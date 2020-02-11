Feature: Compra no site
	Scenario: Busca por Produto
		Given que acesso o site do Extra
		When preencho o termo "smartphone" e clico na Lupa
		Then exibe a lista de produtos
		
		
	Scenario: Busca por Produto Não Encontrado
		Given que acesso o site do Extra
		When preencho o termo "QWEQWEQWEQWEDFDFEFKDJD" e clico na Lupa
		Then exibe a mensagem de produto nao encontrado