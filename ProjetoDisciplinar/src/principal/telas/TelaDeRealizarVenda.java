package principal.telas;

import java.util.ArrayList;
import java.util.List;

import principal.controladores.CadastroProduto;
import principal.controladores.ControlePedido;
import principal.modelos.Produto;
import principal.modelos.Pedido;
import principal.modelos.Pedido.Status;
import principal.util.Prompt;

public class TelaDeRealizarVenda {
	
	public static void mostrar(){
		Prompt.imprimir("[1] Listar produto(s).");
		Prompt.imprimir("[2] Adicionar produto(s).");
		Prompt.imprimir("[3] Alterar produto(s).");
		Prompt.imprimir("[4] Excluir produto(s).");
		Prompt.imprimir("[5] Voltar para a tela de gerenciamento.");
		
		
		Integer opcao = Prompt.lerInteiro();
		
		switch(opcao){
			case 1: {
				TelaDeRealizarVenda.mostrarSelecionarProdutos();
				break;
			}
			case 2:{
				TelaDeGerenciamentoDeProduto.adicionar();
				break;
			}
			case 3:{
				TelaDeGerenciamentoDeProduto.alterar();
				break;
			}
			case 4:{
				TelaDeGerenciamentoDeProduto.excluir();
				break;
			}
			case 5:{
				Prompt.imprimir("------------------------------------");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao Menu de Gerenciamento.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("------------------------------------");
				Prompt.linhaEmBranco();
				TelaDeGerenciamento.mostrar();
				break;
			}default:{
				Prompt.imprimir("ERROR: Comando não reconhecido.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao menu principal.");
				Prompt.linhaEmBranco();
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
			}
	}
}
	public static void mostrarSelecionarProdutos() {
	
		CadastroProduto cadastro = CadastroProduto.getInstance();
		
		Prompt.linhaEmBranco();
		Prompt.imprimir("Lista de Produtos");
		
		List<Produto> produtos = cadastro.getProdutos();
		
		if (produtos.isEmpty()) {
			Prompt.imprimir("Lista Vazia"); 
		} else {
			for (Produto produto : produtos) {
				Prompt.imprimir(produto.toString());
			}
		}
		
		Prompt.linhaEmBranco();
		Long id = (long) Prompt.lerInteiro("Informe o ID: ");		
		
		if (id < 1) {
			TelaDeRealizarVenda.mostrar();
		} else {
			Produto produto = cadastro.buscar(id);
			
			if (produto != null) {
				Pedido.emMemoria.adicionar(produto);
				Prompt.linhaEmBranco();
				Prompt.imprimir("Produto Selecionado");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Deseja Selecionar outro Produto?");
				Prompt.imprimir("Sim [1]");
				Prompt.imprimir("Não [2]");
				int opcao = Prompt.lerInteiro();
				if (opcao == 1) {
					TelaDeRealizarVenda.mostrarSelecionarProdutos();
				} else {
					TelaDeRealizarVenda.mostrar();
				}
			} else {
				Prompt.linhaEmBranco();
				Prompt.imprimir("Produto não Encontrado");
				Prompt.linhaEmBranco();
				Prompt.pressionarEnter();
				TelaDeRealizarVenda.mostrarSelecionarProdutos();
			}
		}
	}
}



