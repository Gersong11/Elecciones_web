package controller.Eleccion;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Eleccion;
import elecciones_model.model.dao.EleccionDao;

/**
 * Servlet implementation class RegistrarEleccionController
 */
@WebServlet("/RegistrarEleccionController")
public class RegistrarEleccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EleccionDao eleccionDao;
	private SimpleDateFormat sdfTime;
    private SimpleDateFormat sdf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarEleccionController() {
        super();
        // TODO Auto-generated constructor stub
        eleccionDao = new EleccionDao();
        sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrareleccion.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (esValido(request.getParameter("nombre")) && esValido(request.getParameter("cargo"))
				&& esValido(request.getParameter("fechainicio")) && esValido(request.getParameter("fechafin"))) {

			Eleccion e = new Eleccion();
			
			String nombre = request.getParameter("nombre");
			String cargo = request.getParameter("cargo");

			Date dateI;
			Date dateF;
			try {
				dateI = sdf.parse(request.getParameter("fechainicio"));
				dateF = sdf.parse(request.getParameter("fechafin"));
				String strI = sdfTime.format(dateI);
		        String strF = sdfTime.format(dateF);
		        Timestamp fechainicio = Timestamp.valueOf(strI);
		        Timestamp fechafin = Timestamp.valueOf(strF);
		        
		        e.setNombre(nombre);
				e.setFechainicio(fechainicio);
				e.setFechafin(fechafin);
				e.setCargo(cargo);
				
				eleccionDao.update(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			request.getRequestDispatcher("registrareleccion.jsp").forward(request,response);
		}
	}
	public <T> boolean esValido(T valor) {
		if (valor == null) {
			return false;
		}
		return valor != "";
	}

}
