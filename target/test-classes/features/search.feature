#encoding: utf-8
#Author: Jesus Salatiel
@Escenario
Feature: Search Product
  As  a user i want to buy a new cell phone and see in my shopping car

  @Valid
  Scenario Outline: Search Product
    Given the user is the main page
    Then the user click the button hamburguer
    When the user choose the "<section>" section
    And the user select the "<category>" product
    Then the cellphone page apppears
    When the user is in the cellphone page
    Then the user should be able to select a "<product>"
    And the user will be able to see the product in the shooping car

    Examples: 
      | section   | category          | product                                            |
      | Telefonía | Celulares básicos | Celular Adulto Mayor BLU Joy Boton SOS 3G Dual SIM |
