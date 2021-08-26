package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ajouterCarte")
public class CarteBancaireServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private CarteBancaireService carteService = new CarteBancaireServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Calendar calendar = Calendar.getInstance();
		List<Integer> months = new ArrayList<>();
		List<Integer> years = new ArrayList<>();
		
		for (int i = 1; i <= 12; i++) {
			months.add(i);
		}
		
		for (int i = 0; i <= 5; i++) {
			years.add(calendar.get(Calendar.YEAR) + i);
		}
		
		req.setAttribute("mois", months);
		req.setAttribute("annees", years);
		
		req.getRequestDispatcher("WEB-INF/ajouterCarteBancaire.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Client client = (Client) req.getSession().getAttribute("client");
		
		String number = req.getParameter("NUMBER");
		int month = Integer.parseInt(req.getParameter("MONTH"));
		int year = Integer.parseInt(req.getParameter("YEAR"));
		String crypto = req.getParameter("CRYPTO");
		
		carteService.ajouterCarteBancaire(number, month, year, crypto, client.getId());
		
		resp.sendRedirect("tableauDeBord");
	}
}
