package elecciones_model.model.dao;

import elecciones_model.model.Tipodocumento;
import elecciones_model.model.dao.GenericDao;
import elecciones_model.model.util.Conexion;

public class TipodocumentoDao extends Conexion<Tipodocumento> 
	implements GenericDao<Tipodocumento> {
	
	public TipodocumentoDao() {
		super(Tipodocumento.class);
	}
}