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
 * Servlet implementation class EliminarVotanteController
 */
@WebServlet("/EliminarVotanteController")
public class EliminarVotanteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private VotanteDao votanteDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVotanteController() {
        super();
        // TODO Auto-generated constructor stub
        votanteDao = new VotanteDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Votante votante = this.votanteDao.find(id);
			this.votanteDao.delete(votante);
			List<Votante> listaVotante = votanteDao.list();
	        request.setAttribute("listaVotante", listaVotante);
			RequestDispatcher dispatcher = request.getRequestDispatcher("listavotante.jsp");
	        dispatcher.forward(request, response);
			}
			catch(Exception e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("listavotante.jsp");
				List<Votante> listavotante = votanteDao.list();
		        request.setAttribute("listavotante", listavotante);
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
