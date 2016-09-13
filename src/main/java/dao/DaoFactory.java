package dao;

public class DaoFactory {
	
	private static DaoFactory instance;
	
	
	public static DaoFactory getInstance() {
		
		if (instance == null) {
			instance = new DaoFactory();
		}
		
		return instance;
	}
	
	
	public ProdutoDAO getProdutoDAO() {
		return new ProdutoDAO();
	}
	
	public ClienteDAO getClienteDAO() {
		return new ClienteDAO();
	}
	
	public PedidoDAO getPedidoDAO() {
		return new PedidoDAO();
	}
	
	public VendaDAO getVendaDAO() {
		return new VendaDAO();
	}
	
	public VendedorDAO getVendedorDAO() {
		return new VendedorDAO();
	}
	
	public MarcaDAO getMarcaDAO() {
		return new MarcaDAO();
	}
	
	public GrupoDAO getGrupoDAO() {
		return new GrupoDAO();
	}
}
