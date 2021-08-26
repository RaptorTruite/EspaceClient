package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/tableauDeBord")
public class DashboardServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FactureService factureService = new FactureServiceImpl();
	private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client client = (Client) req.getSession().getAttribute("client");
		
		req.setAttribute("facturesReglees", factureService.recupererFacturesReglees(client.getId()));
		req.setAttribute("facturesARegler", factureService.recupererFacturesARegler(client.getId()));
		req.setAttribute("cartesBancaires", carteBancaireService.recupererCartesBancaires(client.getId()));

		req.getRequestDispatcher("WEB-INF/tableauDeBord.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
