package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;

import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.PaiementService;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.PaiementServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/voirFactureReglee")
public class DetailFactureServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FactureService factureService = new FactureServiceImpl();
	private PaiementService paiementService = new PaiementServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Facture facture = factureService.recupererFacture(Long.parseLong(req.getParameter("ID")));
		req.setAttribute("facture", facture);
		req.setAttribute("paiements", paiementService.recupererPaiements(facture.getId()));
		req.getRequestDispatcher("WEB-INF/voirFactureReglee.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
