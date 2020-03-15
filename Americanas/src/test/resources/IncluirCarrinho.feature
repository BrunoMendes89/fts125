#	Feature: 
#		Scenario: 
#			 Given
#				When 
#				And
#				Then


Feature: IncluirCarrinho
  Scenario: Buscar Produto e Incluir no Carrinho
    Given I access Americanas site
    When I type the term "Agile Testing" and press Enter
    And I view the list of products and click in Agile Testing Foundations book
    Then I click in "comprar" button 
