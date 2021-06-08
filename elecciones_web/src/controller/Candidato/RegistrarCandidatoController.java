package controller.Candidato;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Candidato;
import elecciones_model.model.Eleccion;
import elecciones_model.model.dao.CandidatoDao;
import elecciones_model.model.dao.EleccionDao;

/**
 * Servlet implementation class RegistrarCandidatoController
 */
@WebServlet("/RegistrarCandidatoController")
public class RegistrarCandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatoDao candidatoDao;
	private EleccionDao eleccionDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarCandidatoController() {
        super();
        // TODO Auto-generated constructor stub
        candidatoDao = new CandidatoDao();
        eleccionDao = new EleccionDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Eleccion> elecciones = eleccionDao.list();
		request.setAttribute("elecciones", elecciones);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrarcandidato.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("documento")) && esValido(request.getParameter("nombre"))
				&& esValido(request.getParameter("apellido")) && esValido(request.getParameter("eleccion")) && esValido(request.getParameter("numero"))) {

			Candidato c = new Candidato();

			String documento = request.getParameter("documento");
			String apellido = request.getParameter("apellido");
			String nombre = request.getParameter("nombre");
			int eleccion = Integer.parseInt(request.getParameter("eleccion"));
			int numero = Integer.parseInt(request.getParameter("numero"));

			c.setDocumento(documento);
			Eleccion e = eleccionDao.find(eleccion);
			c.setEleccionBean(e);
			c.setApellido(apellido);
			c.setNombre(nombre);
			c.setNumero(numero);

			candidatoDao.insert(c);
			
			doGet(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("listacandidatos.jsp");
		} else {
			response.sendRedirect("index.jsp?estado=Fail");
		}
	}
	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}
	
}
