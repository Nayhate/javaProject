package principal.controladores;

import principal.dao.DAO;
import principal.dao.FuncionarioDAO;
import principal.modelos.Funcionario;

public class ControleAcesso {
	
	public static Funcionario usuarioLogado;
	
	public static boolean isUsuarioLogado() {
		return usuarioLogado != null;
	}
	
	public static void autenticar(String login, String senha) {
		DAO<Funcionario> dao = new FuncionarioDAO();
		String query = "from Usuario u where u.login = '" + login + "' and senha='" + senha + "'";
		usuarioLogado = dao.buscarPorQuery(query);
	} 
}

