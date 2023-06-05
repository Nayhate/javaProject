package principal.telas;

import java.util.ArrayList;
import java.util.List;

import principal.controladores.CadastroSorvete;
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
		
		List<Bebida> bebidas = Banco.bebidas;
		List<Sorvete> sorvetes = Banco.sorvetes;
		List<Adicional> adicionais = Banco.adicionais;
		
		double total = 0;
		
		while (true) {
            System.out.println("Lista de produtos:");
            for (Bebida bebida : bebidas) {
               Prompt.imprimir(bebida.getId() + " - " + bebida.getNome() + " - " +  bebida.getSabor() + " - R$ " + bebida.getPreco());
            }
            for (Sorvete sorvete : sorvetes) {
                Prompt.imprimir(sorvete.getId() + " - " + sorvete.getNome() + " - " +  sorvete.getSabor() + " - R$ " + sorvete.getPreco());
             }
            for (Adicional adicional : adicionais) {
                Prompt.imprimir(adicional.getId() + " - " + adicional.getNome() + " - " +  adicional.getSabor() + " - R$ " + adicional.getPreco());
             }

            
            int idProduto = Prompt.lerInteiro("Digite o ID do produto desejado (0 para finalizar): ");
            if (idProduto == 0) {
                break;
            }

            Produto produtoSelecionado = null;
            
            for (Bebida bebida : bebidas) {
                if (bebida.getId() == idProduto) {
                    produtoSelecionado = bebida;
                    break;
                }
            }
            for (Sorvete sorvete : sorvetes) {
                if (sorvete.getId() == idProduto) {
                    produtoSelecionado = sorvete;
                    break;
                }
            }
            for (Adicional adicional : adicionais) {
                if (adicional.getId() == idProduto) {
                    produtoSelecionado = adicional;
                    break;
                }
            }


            if (produtoSelecionado == null) {
                Prompt.imprimir("Produto não encontrado.");
                continue;
            }
            

            total += produtoSelecionado.getPreco();
            Prompt.imprimir("------------------------------------");
            Prompt.imprimir("Produto " + produtoSelecionado.getNome() + " adicionado ao carrinho. Total: R$ " + total);
            Prompt.imprimir("------------------------------------");
        }
		
		Prompt.imprimir("------------------------------------");
		Prompt.linhaEmBranco();
        Prompt.imprimir("Compra finalizada. Total: R$ " + total);
        Prompt.linhaEmBranco();
		Prompt.imprimir("------------------------------------");
		Prompt.linhaEmBranco();
       
        TelaDeRealizarVenda.mostrar();
        
    }
}
