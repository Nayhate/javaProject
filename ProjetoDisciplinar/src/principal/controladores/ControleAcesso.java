package principal.controladores;

import principal.dao.DAO;
import principal.dao.FuncionarioDAO;
import principal.modelos.Funcionario;

public class ControleAcesso {
	
	public static Funcionario funcionarioLogado;
	
	public static boolean isFuncionarioLogado() {
		return funcionarioLogado != null;
	}
	
	public static void autenticar(String login, String senha) {
		DAO<Funcionario> dao = new FuncionarioDAO();
		String query = "from Funcionario f where f.login = '" + login + "' and senha='" + senha + "'";
		funcionarioLogado = dao.buscarPorQuery(query);
	} 
}
