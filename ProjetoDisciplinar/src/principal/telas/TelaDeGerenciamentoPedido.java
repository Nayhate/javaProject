package principal.telas;

import java.util.List;

import principal.controladores.ControleDePedido;
import principal.modelos.Pedido;
import principal.util.Prompt;

public class TelaDeGerenciamentoPedido {
	
	public static void mostrar() {
		
		Prompt.linhaEmBranco();
		Prompt.imprimir("Tela de Gerenciamento de Pedidos");

		Prompt.imprimir("[1] Listar");
		Prompt.imprimir("[2] Cancelar");
		Prompt.imprimir("[3] Voltar");
		
		Integer opcao = Prompt.lerInteiro();

		switch (opcao) {
			case 1: {
				TelaDeGerenciamentoPedido.listar();
				break;
			}
			case 2: {
				TelaDeGerenciamentoPedido.cancelar();
				break;
			}
			case 3: {
				TelaDeGerenciamento.mostrar();
				break;
			}
		}
	}

	public static void listar() {

		Prompt.linhaEmBranco();
		Prompt.imprimir("Lista de Pedidos");
		
		ControleDePedido cadastro = ControleDePedido.getInstance();
		
		List<Pedido> pedidos = cadastro.getPedidos();
		if (pedidos.isEmpty()) {
			Prompt.imprimir("Lista Vazia"); 
		} else {
			for (Pedido pedido : pedidos) {
				Prompt.imprimir(pedido.toString());
			}
		}
		
		Prompt.linhaEmBranco();
		Prompt.pressionarEnter();
		TelaDeGerenciamentoPedido.mostrar();
	}

	private static void cancelar() {

		Prompt.linhaEmBranco();
		Prompt.imprimir("Lista de Pedidos");
		Prompt.imprimir("Escolha: ");
		
		ControleDePedido cadastro = ControleDePedido.getInstance();
		
		List<Pedido> pedidos = cadastro.getPedidos();
		if (pedidos.isEmpty()) {
			Prompt.imprimir("Lista Vazia"); 
		} else {
			for (Pedido pedido : pedidos) {
				Prompt.imprimir(pedido.toString());
			}
		}
		
		Prompt.linhaEmBranco();
		
		Long id = (long) Prompt.lerInteiro("Informe o ID: ");
		
		if (id > 0) {
				cadastro.excluir(id);
			
				Prompt.linhaEmBranco();
				Prompt.imprimir("Pedido Cancelado");
				Prompt.linhaEmBranco();
				Prompt.pressionarEnter();
				}
		
			TelaDeGerenciamentoPedido.listar();			
			TelaDeGerenciamentoPedido.mostrar();
	}
}
