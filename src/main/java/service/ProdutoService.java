package service;

import java.util.List;

import dao.DAOException;
import dao.DaoFactory;
import dao.ProdutoDAO;
import entity.Grupo;
import entity.Marca;
import entity.Produto;

public class ProdutoService {
	
	private ProdutoDAO dao;
	private static Produto produto;

	public ProdutoService() {
		dao = DaoFactory.getInstance().getProdutoDAO();
		
		produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		ProdutoService.produto = produto;
	}
	
	public List<Produto> getProdutos() throws ServiceException {
		try {
			return dao.getProdutos();
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}
	
	public List<Marca> getMarcas() throws ServiceException {
		try {
			
			return DaoFactory.getInstance().getMarcaDAO().getMarcas();
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public List<Grupo> getGrupos() throws ServiceException {
		try {
			
			return DaoFactory.getInstance().getGrupoDAO().getGrupos();
		
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void salvar(Produto produto) throws ServiceException {
		try {
			DaoFactory.getInstance().getUnidadeMedidaDAO().salvarLista(produto.getUnMedida());
			DaoFactory.getInstance().getProdutoDAO().salvar(produto);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	public void salvarLista(List<Produto> produtos) throws ServiceException {
		try {
		
			dao.salvarLista(produtos);
		
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
