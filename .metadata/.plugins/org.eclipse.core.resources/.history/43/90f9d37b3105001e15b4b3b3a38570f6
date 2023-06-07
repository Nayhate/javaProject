package principal.telas;

import principal.controladores.CadastroFuncionario;
import principal.dao.Banco;
import principal.modelos.Funcionario;
import principal.util.Prompt;

public class TelaDeGerenciamentoDeFuncionario {
	
	public static void mostrar() {
		Prompt.linhaEmBranco();
		
		Prompt.imprimir("[1] Listar funcinário(s).");
		Prompt.imprimir("[2] Adicionar funcionário(s).");
		Prompt.imprimir("[3] Alterar funcionário(s).");
		Prompt.imprimir("[4] Excluir funcionário(s).");
		Prompt.imprimir("[5] Voltar para a tela de gerenciamento.");
		
		
		Integer opcao = Prompt.lerInteiro();
		
		switch(opcao){
			case 1: {
				TelaDeGerenciamentoDeFuncionario.listar();
				break;
			}
			case 2:{
				TelaDeGerenciamentoDeFuncionario.adicionar();
				break;
			}
			case 3:{
				TelaDeGerenciamentoDeFuncionario.alterar();
				break;
			}
			case 4:{
				TelaDeGerenciamentoDeFuncionario.excluir();
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
			}
			default:{							
				Prompt.imprimir("ERROR: Comando não reconhecido.");
				Prompt.linhaEmBranco();
				Prompt.imprimir("Retornando ao menu principal.");
				Prompt.linhaEmBranco();
				TelaDeGerenciamentoDeFuncionario.mostrar();
				break;
			}
		}
	}
	
//Listar <-------------------------------------------------------------------->
		
	public static void listar() {	
		
		Prompt.imprimir("Lista de Funcionários");
		Prompt.linhaEmBranco();
		Prompt.imprimir("----------------------");		
		
		for (int i = 0; i < Banco.funcionarios.size(); i++) {
		    Funcionario funcionario = Banco.funcionarios.get(i);
		    Prompt.imprimir("CPF: " + funcionario.getCPF());
		    Prompt.imprimir("Nome: " + funcionario.getNome());
		    Prompt.imprimir("E-mail: " + funcionario.getEmail());
		    Prompt.imprimir("Telefone: " + funcionario.getTelefone());
		    Prompt.imprimir("Admissão: " + funcionario.getDataAdmissao());	
		    Prompt.imprimir("Salário: R$" + funcionario.getSalario());
		    Prompt.imprimir("Entrada: " + funcionario.getHorarioEntrada() + "h");
		    Prompt.imprimir("Saida: " + funcionario.getHorarioSaida() + "h");
		    
		    Prompt.imprimir("----------------------");
		}	
		
		Prompt.imprimir("[1] Sair.");
		Integer option = Prompt.lerInteiro();		
			
		
		if(option == 1) {
			
			TelaDeGerenciamentoDeFuncionario.mostrar();
			
		}
}
	
//Adicionar <-------------------------------------------------------------------->
	
	public static void adicionar() {
		
		Prompt.imprimir("Adicionar Funcionário");
		Prompt.linhaEmBranco();
		
		String adimissao = Prompt.lerLinha("Informe a Data de Admissão: ");
		String entrada = Prompt.lerLinha("Informe o Horário de Entrada: ");
		String saida = Prompt.lerLinha("Informe o Horário de Saída: ");
		double salario = Prompt.lerDecimal("Informe o Salário: ");
		String nome = Prompt.lerLinha("Informe o Nome: ");
		String cpf = Prompt.lerLinha("Informe o CPF: ");
		String telefone = Prompt.lerLinha("Informe o Telefone: ");
		String email = Prompt.lerLinha("Informe o e-mail: ");
		String login = Prompt.lerLinha("Informe o Login: ");
		String senha = Prompt.lerLinha("Informe o Senha: ");
		
		CadastroFuncionario.adicionar(new Funcionario (adimissao, entrada, saida, salario, nome, cpf, telefone, email, login, senha));

		
		Prompt.imprimir("[1] Sair.");
		Integer option = Prompt.lerInteiro();
		
		if(option == 1) {
			
			TelaDeGerenciamentoDeFuncionario.mostrar();
			
		}
		
	}
	
//Alterar <-------------------------------------------------------------------->
	
	
	public static void alterar() {
		
		Prompt.imprimir("Alterar Funcionários");
		
		Prompt.linhaEmBranco();
		String nomeOriginal = Prompt.lerLinha("Informe o Nome Original");	
		
		if (!nomeOriginal.isEmpty()) {
			Funcionario funcionarioAlterar = CadastroFuncionario.buscar(nomeOriginal);
			Prompt.linhaEmBranco();
			if (funcionarioAlterar != null) {
				String adimissao = Prompt.lerLinha("Informe a Data de Admissão: ");
				String entrada = Prompt.lerLinha("Informe o Horário de Entrada: ");
				String saida = Prompt.lerLinha("Informe o Horário de Saída: ");
				double salario = Prompt.lerDecimal("Informe o Salário: ");
				String nome = Prompt.lerLinha("Informe o Nome: ");
				String cpf = Prompt.lerLinha("Informe o CPF: ");
				String telefone = Prompt.lerLinha("Informe o Telefone: ");
				String email = Prompt.lerLinha("Informe o e-mail: ");
				String login = Prompt.lerLinha("Informe o Login: ");
				String senha = Prompt.lerLinha("Informe o Senha: ");
				
				if (!nome.isEmpty() && !cpf.isEmpty() 
						&& !login.isEmpty() && !senha.isEmpty()){
					funcionarioAlterar.setDataAdmissao(adimissao);
					funcionarioAlterar.setHorarioEntrada(entrada);
					funcionarioAlterar.setHorarioSaida(saida);
					funcionarioAlterar.setSalario(salario);
					funcionarioAlterar.setNome(nome);
					funcionarioAlterar.setCPF(cpf);
					funcionarioAlterar.setTelefone(telefone);
					funcionarioAlterar.setEmail(email);
					funcionarioAlterar.setLogin(login);
					funcionarioAlterar.setSenha(senha);
					
					CadastroFuncionario.atualizar(nomeOriginal, funcionarioAlterar);
		
				}
			} 
		
		Prompt.imprimir("[1] Sair.");
		Integer option = Prompt.lerInteiro();
		
		if(option == 1) {
			
			TelaDeGerenciamentoDeFuncionario.mostrar();
			
		}
	}
}
	
//Excluir <-------------------------------------------------------------------->
	
	public static void excluir() {
		
		Prompt.imprimir("Excluir Funcionários");
			
			Prompt.linhaEmBranco();
			String nome = Prompt.lerLinha("Informe o nome original");	
			
			if (!nome.isEmpty()) {
				boolean funcionarioExcluido = CadastroFuncionario.excluir(nome);
				
				Prompt.linhaEmBranco();
				if (funcionarioExcluido) {
					Prompt.imprimir("Usuario Excluido");
				}
			}
		
		Prompt.imprimir("[1] Sair.");
		Integer option = Prompt.lerInteiro();
		
		if(option == 1) {
			
			TelaDeGerenciamentoDeFuncionario.mostrar();
			
		}		
	}
}
