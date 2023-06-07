package principal.controladores;

import principal.modelos.Produto;

import java.util.List;

import principal.dao.DAO;
import principal.dao.ProdutoDAO;

public class CadastroProduto {
	
//Funções Produto

	private static CadastroProduto instance;

	private DAO<Produto> dao = new ProdutoDAO();

	private CadastroProduto() {}
	
	public static synchronized CadastroProduto getInstance() {
		if (instance == null) {
			instance = new CadastroProduto();
		}
		return instance;
	}

	public List<Produto> getProdutos() {
		return dao.listar();
	}

	public void adicionar(Produto produto) {
		dao.salvar(produto);
	}

	public void atualizar(Produto produto) {
		dao.atualizar(produto);
	}

	public Produto buscar(Long id) {
		return dao.buscarPorId(id);
	}

	public void excluir(Long id) {
		dao.apagar(id);
	}
}