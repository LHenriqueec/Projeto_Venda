package service;

import java.util.List;

import dao.DAOException;
import dao.DaoFactory;
import entity.Grupo;
import entity.Marca;
import entity.Produto;

public class ProdutoService {
	

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
			
			DaoFactory.getInstance().getProdutoDAO().salvar(produto);
			
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
}
