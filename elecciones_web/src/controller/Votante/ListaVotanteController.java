package controller.Votante;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import elecciones_model.model.Votante;
import elecciones_model.model.dao.VotanteDao;

/**
 * Servlet implementation class ListaVotanteController
 */
@WebServlet("/ListaVotanteController")
public class ListaVotanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotanteDao votanteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaVotanteController() {
        super();
        // TODO Auto-generated constructor stub
        votanteDao = new VotanteDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Votante> listaVotante = votanteDao.list();
        request.setAttribute("listaVotante", listaVotante);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listavotante.jsp");
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
