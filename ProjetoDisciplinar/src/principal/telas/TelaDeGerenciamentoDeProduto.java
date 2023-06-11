package principal.telas;

import java.util.List;

import principal.controladores.CadastroProduto;
import principal.modelos.Produto;
import principal.util.Prompt;

public class TelaDeGerenciamentoDeProduto {
	public static void mostrar() {
		Prompt.linhaEmBranco();
		
		Prompt.imprimir("[1] Listar produto(s).");
		Prompt.imprimir("[2] Adicionar produto(s).");
		Prompt.imprimir("[3] Alterar produto(s).");
		Prompt.imprimir("[4] Excluir produto(s).");
		Prompt.imprimir("[5] Voltar para a tela de gerenciamento.");
		
		
		Integer opcao = Prompt.lerInteiro();
		
		switch(opcao){
			case 1: {
				TelaDeGerenciamentoDeProduto.listar();
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
		
//Listar <-------------------------------------------------------------------->
	
		
public static void listar() {	
			
			Prompt.imprimir("Lista de Produtos");
			Prompt.linhaEmBranco();
			Prompt.imprimir("----------------------");
			
			CadastroProduto cadastro = CadastroProduto.getInstance();

			List<Produto> produtos = cadastro.getProdutos();
			if (produtos.isEmpty()) {
				Prompt.imprimir("Lista Vazia"); 
			} else {
				for (Produto produto : produtos) {
					Prompt.imprimir(produto.toString());
				}
			}			
			Prompt.linhaEmBranco();
			Prompt.pressionarEnter();
			TelaDeGerenciamentoDeProduto.mostrar();
		}
		
//Adicionar <-------------------------------------------------------------------->
		
		public static void adicionar() {
			
			Prompt.imprimir("Adicionar Produto");
			Prompt.linhaEmBranco();
			
			Prompt.imprimir("[1] Cadastrar Sorvete.");
			Prompt.imprimir("[2] Sair.");
			Integer selection = Prompt.lerInteiro();
			
			switch(selection) {
			
			case 1:{
				
				String nome = Prompt.lerLinha("Informe o Nome: ");
				Prompt.imprimir("---------------------");
				String sabor = Prompt.lerLinha("Informe o Sabor: ");
				Prompt.imprimir("---------------------");
				double preco = Prompt.lerDecimal("Informe o Preço: ");
				Prompt.imprimir("---------------------");
				
				CadastroProduto cadastro = CadastroProduto.getInstance();
					
				if (!nome.isEmpty()) {
					cadastro.adicionar(new Produto(nome, sabor, preco));
					
					Prompt.linhaEmBranco();
					Prompt.pressionarEnter();
				}
				
				TelaDeGerenciamentoDeProduto.mostrar();
				
			break;
			}
			case 2: {				
				Prompt.imprimir("------------------------------------");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao Menu.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("------------------------------------");
				Prompt.linhaEmBranco();
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
			}
			default: {				
				Prompt.imprimir("ERROR: Comando não reconhecido.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao menu.");
				Prompt.linhaEmBranco();
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
			}
			}
}
		
//Alterar <-------------------------------------------------------------------->
		
		
public static void alterar() {
	
		Prompt.linhaEmBranco();
	
		Prompt.imprimir("[1] Alterar Sorvete.");
		Prompt.imprimir("[2] Sair.");
		Integer selection = Prompt.lerInteiro();
		
		switch(selection) {
		
		case 1: {
			
			Prompt.imprimir("Alterar Produtos");
			
			Prompt.linhaEmBranco();
			Long id = (long) Prompt.lerInteiro("Informe o ID: ");
			
			CadastroProduto cadastro = CadastroProduto.getInstance();
			
			if (id > 0) {
				Produto produtoAlterar = cadastro.buscar(id);
			
				if (produtoAlterar != null) {
					String nome = Prompt.lerLinha("Informe o Nome: ");
					String sabor = Prompt.lerLinha("Informe o Sabor: ");
					Double preco = Prompt.lerDecimal("Informe o Preço: ");

					if (!nome.isEmpty()) {		
						produtoAlterar.setId(id); 
						produtoAlterar.setNome(nome);
						produtoAlterar.setSabor(sabor);
						produtoAlterar.setPreco(preco);
												
						cadastro.atualizar(produtoAlterar);
	
						Prompt.linhaEmBranco();
						Prompt.imprimir("Produto Alterado");
					}
				} else {
					Prompt.linhaEmBranco();
					Prompt.imprimir("Produto não encontrado");
				}
				Prompt.linhaEmBranco();
				Prompt.pressionarEnter();
			}
			
			TelaDeGerenciamentoDeProduto.mostrar();
			break;
			
		}
		case 4:{
			
			Prompt.imprimir("------------------------------------");
			Prompt.linhaEmBranco();
			Prompt.imprimir("Retornando ao Menu.");
			Prompt.linhaEmBranco();
			Prompt.imprimir("------------------------------------");
			Prompt.linhaEmBranco();
			TelaDeGerenciamentoDeProduto.mostrar();
			break;
			
		}
		default:{
			
			Prompt.imprimir("ERROR: Comando não reconhecido.");
			Prompt.linhaEmBranco();
			Prompt.imprimir("Retornando ao menu.");
			Prompt.linhaEmBranco();
			TelaDeGerenciamentoDeProduto.mostrar();
			break;
		}
	}
}

//Excluir <-------------------------------------------------------------------->
		
		public static void excluir() {
			
			Prompt.imprimir("[1] Excluir Sorvete.");
			Prompt.imprimir("[2] Sair.");
			
			Integer selection = Prompt.lerInteiro();
			
			switch(selection) {
			
			case 1: {					
			
			Prompt.imprimir("Excluir - - - Sorvete");
			Prompt.linhaEmBranco();
			Prompt.imprimir("---------------------");
			Long id = (long) Prompt.lerInteiro("Informe o ID:");	
			Prompt.imprimir("---------------------");
			Prompt.linhaEmBranco();
			
			CadastroProduto cadastro = CadastroProduto.getInstance();
				
			if (id > 0) {
					cadastro.excluir(id);
				
					Prompt.linhaEmBranco();
					Prompt.imprimir("Produto Excluido");
					Prompt.linhaEmBranco();
					Prompt.pressionarEnter();
					}
			
				TelaDeGerenciamentoDeProduto.listar();
				
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
			}
				
			case 2: {
				
				Prompt.imprimir("------------------------------------");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao Menu.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("------------------------------------");
				Prompt.linhaEmBranco();
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
				
			}
			default:{
				
				Prompt.imprimir("ERROR: Comando não reconhecido.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao menu.");
				Prompt.linhaEmBranco();
				TelaDeGerenciamentoDeProduto.mostrar();
				break;
			}
		}
	}
}
