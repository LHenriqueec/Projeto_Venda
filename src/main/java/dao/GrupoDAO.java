package dao;

import java.util.List;

import entity.Grupo;

public class GrupoDAO extends DAO<Grupo> {

	public GrupoDAO() {
		super(Grupo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo> getGrupos() throws DAOException {
		return (List<Grupo>) list("FROM Grupo");
	}
}
