package principal.controladores;

import java.util.List;

import principal.dao.DAO;
import principal.dao.VendaDAO;
import principal.modelos.Venda;
import principal.modelos.Venda.Status;

public class ControleVenda {

	private static ControleVenda instance;
	
	private DAO<Venda> dao = new VendaDAO();
	
	private ControleVenda() {}
	
	public static synchronized ControleVenda getInstance() {
		if (instance == null) {
			instance = new ControleVenda();
		}
		return instance;
	}

	public List<Venda> listar() {
		return dao.listar();
	}
	
	public Venda buscar(Integer id) {
		return dao.buscarPorId(id);
	}
	
	public void adicionar(Venda pedido) {
		dao.salvar(pedido);
	}

	public void cancelar(Venda pedido) {
		pedido.setStatus(Status.CANCELADO);
		dao.atualizar(pedido);
	}
}
