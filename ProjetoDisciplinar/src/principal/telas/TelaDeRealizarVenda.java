package principal.telas;

import java.util.ArrayList;
import java.util.List;

import principal.controladores.CadastroProduto;
import principal.controladores.ControleVenda;
import principal.dao.Banco;
import principal.modelos.Adicional;
import principal.modelos.Bebida;
import principal.modelos.Produto;
import principal.modelos.Sorvete;
import principal.modelos.Venda;
import principal.util.Prompt;

public class TelaDeRealizarVenda {
		
	public static void mostrar() {
		
		Prompt.linhaEmBranco();
		
		Prompt.imprimir("[1] Iniciar Venda.");
		Prompt.imprimir("[2] Voltar para a tela de gerenciamento.");
		
		
		Integer opcao = Prompt.lerInteiro();
		
		switch(opcao){
			case 1: {
				TelaDeRealizarVenda.realizarVenda();
				break;
			}
			case 2:{
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
	
public static void realizarVenda() {

	CadastroProduto cadastro = CadastroProduto.getInstance();
	
	Prompt.linhaEmBranco();
	Prompt.imprimir(Mensagem.MSG_LISTA_DE_PRODUTOS);
	
	List<Produto> produtos = cadastro.getProdutos();
	
	if (produtos.isEmpty()) {
		Prompt.imprimir(Mensagem.MSG_NENHUM_PRODUTO); 
	} else {
		for (Produto produto : produtos) {
			Prompt.imprimir(produto.toString());
		}
	}
	
	Prompt.linhaEmBranco();
	Long id = (long) Prompt.lerInteiro(Mensagem.MSG_INFORME_ID);		
	
	if (id < 1) {
		new TelaDeVendas().mostrar();
	} else {
		Produto produto = cadastro.buscar(id);
		
		if (produto != null) {
			Venda.emMemoria.adicionar(produto);
			Prompt.linhaEmBranco();
			Prompt.imprimir(Mensagem.MSG_PRODUTO_SELECIONADO);
			Prompt.linhaEmBranco();
			Prompt.imprimir(Mensagem.MSG_SELECIONAR_MAIS);
			Prompt.imprimir(Mensagem.MSG_SIM);
			Prompt.imprimir(Mensagem.MSG_NAO);
			int opcao = Prompt.lerInteiro();
			if (opcao == 1) {
				TelaDeVendas.mostrarSelecionarProdutos();
			} else {
				new TelaDeVendas().mostrar();
			}
		} else {
			Prompt.linhaEmBranco();
			Prompt.imprimir(Mensagem.MSG_PRODUTO_NAO_ENCONTRADO);
			Prompt.linhaEmBranco();
			Prompt.pressionarEnter();
			TelaDeVendas.mostrarSelecionarProdutos();
		}
	}
  }
}

