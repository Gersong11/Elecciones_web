package elecciones_model.model.dao;

import elecciones_model.model.Estamento;
import elecciones_model.model.dao.GenericDao;
import elecciones_model.model.util.Conexion;

public class EstamentoDao extends Conexion<Estamento> 
	implements GenericDao<Estamento> {
	
	public EstamentoDao() {
		super(Estamento.class);
	}
}