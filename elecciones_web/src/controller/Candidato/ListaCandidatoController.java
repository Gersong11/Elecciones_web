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
import elecciones_model.model.dao.CandidatoDao;

/**
 * Servlet implementation class ListaCandidatoController
 */
@WebServlet("/ListaCandidatoController")
public class ListaCandidatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatoDao candidatoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaCandidatoController() {
        super();
        // TODO Auto-generated constructor stub
        candidatoDao = new CandidatoDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Candidato> listaCandidato = candidatoDao.list();
        request.setAttribute("listaCandidato", listaCandidato);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("listacandidatos.jsp");
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
