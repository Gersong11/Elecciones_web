package elecciones_model.model.dao;

import elecciones_model.model.Candidato;
import elecciones_model.model.dao.GenericDao;
import elecciones_model.model.util.Conexion;

public class CandidatoDao extends Conexion<Candidato> 
implements GenericDao<Candidato> {

public CandidatoDao() {
	super(Candidato.class);
}
}
