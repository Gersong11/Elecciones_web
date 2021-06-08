package controller.Eleccion;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Eleccion;
import elecciones_model.model.dao.EleccionDao;

/**
 * Servlet implementation class EliminarEleccionController
 */
@WebServlet("/EliminarEleccionController")
public class EliminarEleccionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EleccionDao eleccionDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEleccionController() {
        super();
        // TODO Auto-generated constructor stub
        eleccionDao = new EleccionDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Eleccion eleccion = this.eleccionDao.find(id);
			this.eleccionDao.delete(eleccion);
			List<Eleccion> listaEleccion = eleccionDao.list();
	        request.setAttribute("listaEleccion", listaEleccion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listaeleccion.jsp");
	        dispatcher.forward(request, response);
			}
			catch(Exception e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("listaeleccion.jsp");
				List<Eleccion> listaEleccion = eleccionDao.list();
		        request.setAttribute("listaEleccion", listaEleccion);
		        dispatcher.forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
