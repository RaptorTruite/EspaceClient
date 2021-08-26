package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.business.Facture;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.PaiementService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.PaiementServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/reglerFacture")
public class ReglerFactureServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private FactureService factureService = new FactureServiceImpl();
	private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
	private PaiementService paiementService = new PaiementServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Facture facture = factureService.recupererFacture(Long.parseLong(req.getParameter("ID")));
		Client client = (Client) req.getSession().getAttribute("client");
		
		req.setAttribute("cartes", carteBancaireService.recupererCartesBancaires(client.getId()));
		req.setAttribute("facture", facture);

		req.getRequestDispatcher("WEB-INF/reglerFacture.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Long idFacture = Long.parseLong(req.getParameter("ID_FACTURE"));
		Long idCarte = Long.parseLong(req.getParameter("ID_CARTE"));
		Float montant = Float.parseFloat(req.getParameter("MONTANT"));
		Date date = null;
		try {
			date = simpleDateFormat.parse(req.getParameter("ECHEANCE"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		paiementService.ajouterPaiement(idFacture, idCarte, montant, date);
		resp.sendRedirect("tableauDeBord");
	}
}
