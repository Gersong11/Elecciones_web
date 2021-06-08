package elecciones_model.model.dao;

import elecciones_model.model.Voto;
import elecciones_model.model.dao.GenericDao;
import elecciones_model.model.util.Conexion;

public class VotoDao extends Conexion<Voto> 
	implements GenericDao<Voto> {
	
	public VotoDao() {
		super(Voto.class);
	}
}