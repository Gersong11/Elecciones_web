package elecciones_model.model.dao;

import elecciones_model.model.Eleccion;
import elecciones_model.model.dao.GenericDao;
import elecciones_model.model.util.Conexion;

public class EleccionDao extends Conexion<Eleccion> 
	implements GenericDao<Eleccion> {
	
	public EleccionDao() {
		super(Eleccion.class);
	}
}
