package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.json.simple.JSONObject;
import static org.hamcrest.Matchers.is;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import org.testng.IReporter;
import org.testng.Reporter;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AssuredRunner implements IReporter {

	private Response response;
	private List ListEmployees;

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		RestAssured.basePath = "/api/v1";
	}

	@Test(priority = 1, description = "Get all employee data")
	public void getListEmployee() {
		// @formatter:off
		ListEmployees = given()
        .relaxedHTTPSValidation()
		.log().all()
		.contentType(ContentType.JSON)
		.when()
		.get("/employees")
		.then()
		.log().all()
		.extract().response()
		.path("data");

	}

	@Test(priority = 2, description = "	Get a single employee data")
	public void getEmployeeByID() {
		String employee = "2";
		
		given()
        .relaxedHTTPSValidation()
		.log().all()
		.contentType(ContentType.JSON)
		.when()
		.get("/employee/{employee}", employee)
		.then()
		.statusCode(is(200))
		.log().all()
		.extract().response();
		
	}
	
	@Test(priority = 3, description = "Create new record in database")
	public void createEmployeePost() {
		sleep();
		JSONObject request = new JSONObject();
		request.put("name", "Jesus Salatiel");
		request.put("salary", "1300");
		request.put("age", "26");
		
		System.out.println(request.toString());
		given()
        .relaxedHTTPSValidation()
		.log().all()
		.body(request.toJSONString())
		.when()
		.post("/create")
		.then()
		.statusCode(is(200))
		.log().all()
		.and()
		.body("status", containsString("success"));

	}
	
	@Test(priority = 4, description = "Update an employee record")
	public void updateEmployeePut() {
		sleep();
		String employee = "8";
		
		JSONObject request = new JSONObject();
		request.put("name", "Jesus Salatiel");
		request.put("salary", "1300");
		request.put("age", "26");
		
		given()
        .relaxedHTTPSValidation()
		.log().all()
		.body(request.toJSONString())
		.when()
		.put("/update/{employee}", employee)
		.then()
		.log().all()
		.and()
		.body("message", containsString("Successfully! Record has been updated."));
	}
	
	@Test(priority = 5, description = "Delete an employee record")
	public void deleteEmployee() {
		sleep();
		String employee =  String.valueOf(this.ListEmployees.size()).equals(null)?"1":String.valueOf(this.ListEmployees.size());
		
		given()
        .relaxedHTTPSValidation()
		.log().all()
		.contentType(ContentType.JSON)
		.when()
		.delete("/delete/{employee}", employee)
		.then()
		.log().all()
		.and()
		.body("message", containsString("Successfully! Record has been deleted"));
	}

	public void sleep() {
		try {
			Thread.sleep(12000);	
		}catch (Exception e) {
	}
		
		
	}
}
