package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;

import fr.humanbooster.fx.espace_client.business.CarteBancaire;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/supprimerCarte")
public class SupprimerCarteServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CarteBancaireService carteBancaireService = new CarteBancaireServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarteBancaire carte = carteBancaireService.recupererCarteBancaire(Long.parseLong(req.getParameter("ID")));
		req.setAttribute("carte", carte);
		req.getRequestDispatcher("WEB-INF/supprimerCarteBancaire.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
