package controller.Voto;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Candidato;
import elecciones_model.model.Estamento;
import elecciones_model.model.Votante;
import elecciones_model.model.Voto;
import elecciones_model.model.dao.CandidatoDao;
import elecciones_model.model.dao.EstamentoDao;
import elecciones_model.model.dao.VotanteDao;
import elecciones_model.model.dao.VotoDao;


/**
 * Servlet implementation class RegistrarVotoController
 */
@WebServlet("/RegistrarVotoController")
public class RegistrarVotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatoDao candidatoDao;
	private EstamentoDao estamentoDao;
	private VotoDao votoDao;
	private VotanteDao votanteDao;
	private SimpleDateFormat sdfTime;
    private SimpleDateFormat sdf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarVotoController() {
        super();
        // TODO Auto-generated constructor stub
        candidatoDao = new CandidatoDao();
        estamentoDao = new EstamentoDao();
        votanteDao = new VotanteDao();
        votoDao = new VotoDao();
        sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Estamento> estamentos = estamentoDao.list();
		request.setAttribute("estamentos", estamentos);
		List<Candidato> candidatos = candidatoDao.list();
		request.setAttribute("candidatos", candidatos);
		List<Votante> votantes = votanteDao.list();
		request.setAttribute("votantes", votantes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarvoto.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("uuid")) && esValido(request.getParameter("enlace"))
				&& esValido(request.getParameter("fechacreacion")) && esValido(request.getParameter("fechavoto"))) {

			String uuid = request.getParameter("uuid");
			String enlace = request.getParameter("enlace");
			int estamento = Integer.parseInt(request.getParameter("estamento"));
			int votante = Integer.parseInt(request.getParameter("votante"));
			int candidato = Integer.parseInt(request.getParameter("candidato"));
			
			Voto vo = new Voto();
			
			Votante v = votanteDao.find(votante);
			Estamento e = estamentoDao.find(estamento);
			Candidato c = candidatoDao.find(candidato);
			
			candidatoDao.insert(c);
			estamentoDao.insert(e);
			votanteDao.insert(v);
			Date dateC;
			Date dateV;
			try {
				
				vo.setVotanteBean(v);
				vo.setEstamentoBean(e);
				vo.setCandidatoBean(c);
				
				dateC = sdf.parse(request.getParameter("fechacreacion"));
				dateV = sdf.parse(request.getParameter("fechavoto"));
				String strC = sdfTime.format(dateC);
		        String strV = sdfTime.format(dateV);
		        Timestamp fechacreacion = Timestamp.valueOf(strC);
		        Timestamp fechavoto = Timestamp.valueOf(strV);
		        vo.setVotanteBean(v);
				vo.setEstamentoBean(e);
				vo.setCandidatoBean(c);
				vo.setFechacreacion(fechacreacion);
				vo.setFechavoto(fechavoto);
				vo.setUuid(uuid);
				vo.setEnlace(enlace);
		        
				votoDao.insert(vo);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("registrarvoto.jsp").forward(request,response);
		}
	}
	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}

}
