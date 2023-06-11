package principal.telas;

import java.util.List;

import principal.controladores.ControlePedido;
import principal.modelos.Pedido;
import principal.util.Prompt;

public class TelaDeGerenciamentoDePedido {
	
	public static void mostrar() {
		
	Prompt.imprimir("[1] Listar Pedido(s).");
	Prompt.imprimir("[2] Adicionar funcionário(s).");
	Prompt.imprimir("[3] Alterar funcionário(s).");
	Prompt.imprimir("[4] Excluir funcionário(s).");
	Prompt.imprimir("[5] Voltar para a tela de gerenciamento.");
	
	Integer option = Prompt.lerInteiro();
	
	switch(option) {
	
		case 1:{
			
			TelaDeGerenciamentoDePedido.listarPedidos();
			break;	
		}
		case 2:{
			break;
		}
		case 5:{
			TelaDeGerenciamento.mostrar();
		}
		default:{
			break;
		}
	}
}
	public static void listarPedidos() {
		
		ControlePedido controle = ControlePedido.getInstance();
				
				Prompt.linhaEmBranco();
				Prompt.imprimir("Lista de Pedidos");
				Prompt.imprimir("Escolha o pedido: ");
				List<Pedido> pedidos = controle.listar();
				if (pedidos.isEmpty()) {
					Prompt.imprimir("Nenhum Pedido"); 
				} else {
					for (Pedido pedido : pedidos) {
						Prompt.imprimir("[" + pedido.getId() + "] " + pedido.toString());
					}
				}
				Prompt.linhaEmBranco();
				Long id = (long) Prompt.lerInteiro("Informe o ID: ");
				
				if (id > 0) {
					Pedido pedidoCancelar = controle.buscar(id);
				
					if (pedidoCancelar != null) {
						controle.cancelar(pedidoCancelar);
						Prompt.linhaEmBranco();
						Prompt.imprimir("Pedido Cancelado");
					} else {
						Prompt.linhaEmBranco();
						Prompt.imprimir("Pedido não encontrado");
					}
					Prompt.linhaEmBranco();
					Prompt.pressionarEnter();
				}
			listarPedidos();
		}
	}


