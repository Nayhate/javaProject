package principal.telas;

import principal.controladores.ControleDePedido;
import principal.modelos.Pedido;
import principal.util.Prompt;

public class TelaDeRealizarVenda {

	public static void mostrar() {


		Prompt.imprimir("Menu");
		Prompt.imprimir("[1] Selecionar Produto");
		Prompt.imprimir("[2] Retornar");

		Integer opcao = Prompt.lerInteiro();

		switch (opcao) {
			case 1: {
				TelaDeRealizarVenda.selecionarProdutos();
				break;
			}
			case 2: {
				TelaDeGerenciamento.mostrar();
				break;
			}
		}
	}
	
	private static void selecionarProdutos() {


		Prompt.linhaEmBranco();
		Prompt.imprimir("Tela de Vendas: ");

		ControleDePedido cadastro = ControleDePedido.getInstance();
		
		String funcionario = Prompt.lerLinha("Informe Nome: ");
		Prompt.imprimir("---------------------");
		String produto = Prompt.lerLinha("Informe o Produto: ");
		Prompt.imprimir("---------------------");
		String data  = Prompt.lerLinha("Informe a Data: ");
		Prompt.imprimir("---------------------");
		
		
			
		if (!funcionario.isEmpty()) {
			cadastro.adicionar(new Pedido(funcionario, produto, data));
			
			Prompt.linhaEmBranco();
			Prompt.pressionarEnter();
			
			TelaDeRealizarVenda.mostrar();
		}
	}
}


