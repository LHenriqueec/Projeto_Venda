package dao;

import java.util.List;

import org.hibernate.HibernateException;

import entity.Produto;

public class ProdutoDAO extends DAO<Produto> {

	
	public ProdutoDAO() {
		super(Produto.class);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Produto> getProdutos() throws DAOException {
		return (List<Produto>) list("FROM Produto");
	}
	
	public void salvarLista(List<Produto> produtos) throws DAOException {
		try {
			
			session.beginTransaction();
			produtos.forEach(session::saveOrUpdate);
			session.getTransaction().commit();
		
		} catch(HibernateException e) {
			throw new DAOException(e);
		}
	}
}






