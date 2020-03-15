#	Feature: 
#		Scenario: 
#			 Given
#				When 
#				And
#				Then


Feature: Login
  Scenario: Login de usuario ja cadastrado
    Given I access americanas web site
    When I mouse over in the "faca_login" 
    And I click in the button "Entrar" 
    And I click in label "e_mail" and type e-mail
    And I click in label "senha" and type senha
    And click in "continuar"
    Then I have successfully login 

