#	Feature: 
#		Scenario: 
#			 Given
#				When 
#				And
#				Then


Feature: CadastroUsuario
  Scenario: Cadastro de Novo Usuario no Site
    Given I access the Americanas site
    When I mouse over in "cadastre"
    And I click in "cliente_novo" 
    And I click in label "e_mail" and type the e-mail
    And I click in label "senha" and type the senha
    And I click in label "CPF" and type the cpf
    And I click in label "nome_sobrenome" and type the nome e sobrenome
    And I click in label "data_nascimento" and type the data de nascimento
    And I click in checkbox "masculino" 
    And I click in label "telefone" and type the telefone
    And I click in button "criar_cadastro" 
    Then I have successfully registered 
    
