package principal.telas;

import principal.util.Prompt;

public class TelaDeGerenciamento {
	public static void mostrar() {
		Prompt.linhaEmBranco();
		
		Prompt.imprimir("[1]: Ir para a tela de gerenciamento de produto.");
		Prompt.imprimir("[2]: Ir para a tela de gerenciamento de funcionário.");
		Prompt.imprimir("[3]: Ir para a tela de gerenciamento de pedido.");
		Prompt.imprimir("[4]: Ir para a tela de realizar vendas.");
		Prompt.imprimir("[5]: Sair do programa.");
		
		
		Integer opcao = Prompt.lerInteiro();
		
		switch (opcao) {
			case 1: {
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
			}
			case 2: {
				TelaDeGerenciamentoDeFuncionario.mostrar();
				break;
			}
			case 3: {
				TelaDeGerenciamentoPedido.mostrar();
				break;
			}
			case 4:{
				TelaDeRealizarVenda.mostrar();
				break;
			}
			case 5: {
				Prompt.imprimir("---------------------");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Encerrando o Programa.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("---------------------");
				break;
			}
			default:{							
				Prompt.imprimir("ERROR: Comando não reconhecido.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao menu principal.");
				Prompt.linhaEmBranco();
				TelaDeGerenciamento.mostrar();
				break;
			}
		}
	}
}