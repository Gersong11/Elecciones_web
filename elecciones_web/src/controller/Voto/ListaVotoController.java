package controller.Voto;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Voto;
import elecciones_model.model.dao.VotoDao;

/**
 * Servlet implementation class ListaVotoController
 */
@WebServlet("/ListaVotoController")
public class ListaVotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotoDao votoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaVotoController() {
        super();
        // TODO Auto-generated constructor stub
        votoDao = new VotoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Voto> listaVoto = votoDao.list();
        request.setAttribute("listaVoto", listaVoto);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("listavotos.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
