package elecciones_model.model.dao;

import elecciones_model.model.Votante;
import elecciones_model.model.dao.GenericDao;
import elecciones_model.model.util.Conexion;

public class VotanteDao extends Conexion<Votante> 
	implements GenericDao<Votante> {
	
	public VotanteDao() {
		super(Votante.class);
	}
}