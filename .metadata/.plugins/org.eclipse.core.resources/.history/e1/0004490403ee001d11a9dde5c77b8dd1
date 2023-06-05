package principal.telas;

import principal.controladores.ControleVenda;
import principal.db.Banco;
import principal.modelos.Produto;
import principal.modelos.Venda;
import principal.modelos.Venda.Status;
import principal.util.Prompt;

public class TelaDeGerenciamentoDeVenda {
	public static void mostrar() {
		Prompt.linhaEmBranco();
		
		Prompt.imprimir("[1] Listar  venda(s).");
		Prompt.imprimir("[2] Cancelar venda(s).");
		Prompt.imprimir("[3] Voltar para a tela de gerenciamento.");
		
		
		Integer opcao = Prompt.lerInteiro();
		
		switch(opcao){
			case 1: {
				TelaDeGerenciamentoDeVenda.listar();
				break;
			}
			case 2:{
				TelaDeGerenciamentoDeVenda.cancelar();
				break;
			}
			case 3:{
				TelaDeGerenciamento.mostrar();
				break;
			}
		}
	}
		
	public static void listar() {

			Prompt.linhaEmBranco();
			Prompt.imprimir("Lista de Vendas");
			
			if (Banco.vendas.isEmpty()) {
				Prompt.imprimir("Nenhuma Venda Encontrada"); 
			} else {
				for (Produto produto : Venda.getProdutos()) {
			        System.out.println(produto.getNome());
			    }
			}
			
			Prompt.linhaEmBranco();
			Prompt.pressionarEnter();
			TelaDeGerenciamentoDeVenda.mostrar();
		}

		private static void cancelar() {

			Prompt.linhaEmBranco();
			Prompt.imprimir("Lista de Vendas");
			Prompt.imprimir("Informe o Código");
			if (Banco.vendas.isEmpty()) {
				Prompt.imprimir("Nenhum Pedido Encontrado"); 
			} else {
				for (Venda venda : Banco.vendas) {
					Prompt.imprimir("[" + venda.codigo + "] " + venda.toString());
				}
			}
			Prompt.linhaEmBranco();
			Integer codigo = Prompt.lerInteiro("Informe o código de venda");
			
			if (codigo > 0) {
				Venda vendaCancelar = ControleVenda.buscar(codigo);
				
				Prompt.linhaEmBranco();
				if (vendaCancelar != null) {
					vendaCancelar.Status = Status.CANCELADO;
					ControleVenda.cancelar(codigo, vendaCancelar);
					Prompt.imprimir("Venda Cancelada");
				} else {
					Prompt.imprimir("Venda não Encontrada");
				}
				Prompt.linhaEmBranco();
				Prompt.pressionarEnter();
			}
			TelaDeGerenciamentoDeVenda.listar();
		}

	}

