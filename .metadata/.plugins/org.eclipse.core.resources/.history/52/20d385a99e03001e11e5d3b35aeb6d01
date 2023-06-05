package principal.controladores;

import principal.modelos.Produto;
import principal.modelos.Sorvete;

import java.util.List;

import principal.dao.DAO;
import principal.dao.SorveteDAO;

public class CadastroSorvete {
	
//Funções Produto

	private static CadastroSorvete instance;

	private DAO<Sorvete> dao = new SorveteDAO();

	private CadastroSorvete() {}
	
	public static synchronized CadastroSorvete getInstance() {
		if (instance == null) {
			instance = new CadastroSorvete();
		}
		return instance;
	}

	public List<Sorvete> getSorvetes() {
		return dao.listar();
	}

	public void adicionar(Sorvete sorvete) {
		dao.salvar(sorvete);
	}

	public void atualizar(Sorvete sorvete) {
		dao.atualizar(sorvete);
	}

	public Produto buscar(Integer id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Integer id) {
		dao.apagar(id);
	}
}