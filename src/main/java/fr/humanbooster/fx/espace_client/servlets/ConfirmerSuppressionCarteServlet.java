package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/confirmerSuppressionCarte")
public class ConfirmerSuppressionCarteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long idCarte = Long.parseLong(req.getParameter("ID"));
		Client client = (Client) req.getSession().getAttribute("client");
		carteBancaireService.supprimerCarteBancaire(idCarte, client.getId());
		resp.sendRedirect("tableauDeBord");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
