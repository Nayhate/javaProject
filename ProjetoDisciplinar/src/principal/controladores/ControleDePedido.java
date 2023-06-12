package principal.controladores;

import java.util.List;

import principal.dao.DAO;
import principal.dao.PedidoDAO;
import principal.modelos.Pedido;

public class ControleDePedido {

	private static ControleDePedido instance;
	
	private DAO<Pedido> dao = new PedidoDAO();
	
	private ControleDePedido() {}
	
	public static synchronized ControleDePedido getInstance() {
		if (instance == null) {
			instance = new ControleDePedido();
		}
		return instance;
	}

	public List<Pedido> getPedidos() {
		return dao.listar();
	}
	
	public Pedido buscar(Long id) {
		return dao.buscarPorId(id);
	}
	
	public void adicionar(Pedido pedido) {
		dao.salvar(pedido);
	}

	public void excluir(Long id) {
		dao.apagar(id);
	}
}
