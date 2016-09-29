package dao;

import java.util.List;

import entity.Marca;

public class MarcaDAO extends DAO<Marca> {

	public MarcaDAO() {
		super(Marca.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Marca> getMarcas() throws DAOException {
		return (List<Marca>) list("FROM Marca");
	}
}
