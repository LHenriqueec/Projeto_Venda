package dao;

import java.util.List;

import entity.Pedido;

public class PedidoDAO extends DAO<Pedido> {

	public PedidoDAO() {
		super(Pedido.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos() throws DAOException {
		return (List<Pedido>) list("FROM Pedido");
	}
}
