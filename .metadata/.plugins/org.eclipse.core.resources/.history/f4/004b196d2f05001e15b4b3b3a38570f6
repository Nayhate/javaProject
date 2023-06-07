package principal.controladores;

import java.util.List;

import principal.dao.DAO;
import principal.dao.FuncionarioDAO;
import principal.modelos.Funcionario;


public class CadastroFuncionario {

	private static CadastroFuncionario instance;

	private DAO<Funcionario> dao = new FuncionarioDAO();

	private CadastroFuncionario() {}
	
	public static synchronized CadastroFuncionario getInstance() {
		if (instance == null) {
			instance = new CadastroFuncionario();
		}
		return instance;
	}

	public List<Funcionario> getFuncionarios() {
		return dao.listar();
	}

	public void adicionar(Funcionario funcionario) {
		dao.salvar(funcionario);
	}

	public void atualizar(Funcionario funcionario) {
		dao.atualizar(funcionario);
	}

	public Funcionario buscar(Integer id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Integer id) {
		dao.apagar(id);
	}
}



