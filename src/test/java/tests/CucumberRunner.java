package tests;

import org.junit.runner.RunWith;
import static cucumber.api.SnippetType.CAMELCASE;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features"}, 
		glue = { "gluecode" },
	    plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:resources/cucumber-reports/report.html"},
	    snippets= CAMELCASE
		)

public class CucumberRunner {
	
}
