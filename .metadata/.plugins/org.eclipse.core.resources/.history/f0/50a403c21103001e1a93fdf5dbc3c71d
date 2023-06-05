package principal.controladores;

import principal.db.Banco;
import principal.modelos.Funcionario;

public class ControleAcesso {
	

	public static Funcionario funcionarioLogado;
	
	public static boolean isFuncionarioLogado() {
		return funcionarioLogado != null;
	}
	
	public static void autenticar(String login, String senha) {
		for (Funcionario funcionario : Banco.funcionarios) {
			if (funcionario.getLogin().equalsIgnoreCase(login) &&
					funcionario.getSenha().equalsIgnoreCase(senha)) {
				ControleAcesso.funcionarioLogado = funcionario;
				break;
			}
		}
	} 


}
