package controller.Tipodocumento;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Tipodocumento;
import elecciones_model.model.dao.TipodocumentoDao;

/**
 * Servlet implementation class RegistrarTipodocumentoController
 */
@WebServlet("/RegistrarTipodocumentoController")
public class RegistrarTipodocumentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TipodocumentoDao tipodocumentoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarTipodocumentoController() {
        super();
        // TODO Auto-generated constructor stub
        tipodocumentoDao = new TipodocumentoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrartipodocumento.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("descripcion"))) {

			Tipodocumento t = new Tipodocumento();
			
			String descripcion = request.getParameter("descripcion");

			t.setDescripcion(descripcion);

			tipodocumentoDao.insert(t);
			
			doGet(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("registrartipodocumento.jsp");
			// request.getRequestDispatcher("registrartipodocumento.jsp").forward(request,response);
		}
	}

	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}
}
