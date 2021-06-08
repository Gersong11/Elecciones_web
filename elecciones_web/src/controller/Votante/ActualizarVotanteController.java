package controller.Votante;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Eleccion;
import elecciones_model.model.Tipodocumento;
import elecciones_model.model.Votante;
import elecciones_model.model.dao.EleccionDao;
import elecciones_model.model.dao.TipodocumentoDao;
import elecciones_model.model.dao.VotanteDao;

/**
 * Servlet implementation class ActualizarVotanteController
 */
@WebServlet("/ActualizarVotanteController")
public class ActualizarVotanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotanteDao votanteDao;
	private EleccionDao eleccionDao;
	private TipodocumentoDao tipodocumentoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarVotanteController() {
        super();
        // TODO Auto-generated constructor stub
        votanteDao = new VotanteDao();
        eleccionDao = new EleccionDao();
        tipodocumentoDao = new TipodocumentoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Votante votante = this.votanteDao.find(id);
		request.setAttribute("votante", votante);
		List<Eleccion> elecciones = eleccionDao.list();
		request.setAttribute("elecciones", elecciones);
		List<Tipodocumento> tipodocumentos = tipodocumentoDao.list();
		request.setAttribute("tipodocumentos", tipodocumentos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarvotante.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("documento")) && esValido(request.getParameter("email"))
				&& esValido(request.getParameter("nombre")) && esValido(request.getParameter("eleccion")) && esValido(request.getParameter("tipodocumento"))) {

			Votante v = new Votante();
			
			String documento = request.getParameter("documento");
			String email = request.getParameter("email");
			String nombre = request.getParameter("nombre");
			int eleccion = Integer.parseInt(request.getParameter("eleccion"));
			int tipodocumento = Integer.parseInt(request.getParameter("tipodocumento"));

			
			v.setDocumento(documento);
			Eleccion e = eleccionDao.find(eleccion);
			v.setEleccionBean(e);
			v.setEmail(email);
			v.setNombre(nombre);
			Tipodocumento t = tipodocumentoDao.find(tipodocumento);
			v.setEleccionBean(e);
			v.setTipodocumentoBean(t);
			
			votanteDao.update(v);
			
			request.getRequestDispatcher("actualizarvotante.jsp").forward(request,response);

		}
	}
	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}

}
