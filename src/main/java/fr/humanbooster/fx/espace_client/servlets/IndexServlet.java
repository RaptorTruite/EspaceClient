package fr.humanbooster.fx.espace_client.servlets;

import java.io.IOException;

import fr.humanbooster.fx.espace_client.business.Client;
import fr.humanbooster.fx.espace_client.service.CarteBancaireService;
import fr.humanbooster.fx.espace_client.service.ClientService;
import fr.humanbooster.fx.espace_client.service.FactureService;
import fr.humanbooster.fx.espace_client.service.impl.CarteBancaireServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.ClientServiceImpl;
import fr.humanbooster.fx.espace_client.service.impl.FactureServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/index", loadOnStartup = 1)
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ClientService clientService = null;

	@Override
	public void init() throws ServletException {
		clientService = new ClientServiceImpl();
		new CarteBancaireServiceImpl();
		new FactureServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object o = req.getSession().getAttribute("ID_client");
		if (o != null) {
			System.out.println("Deconnexion");
			req.getSession().invalidate();
		}

		req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("EMAIL");
		String password = req.getParameter("PASSWORD");

		Client client = clientService.recupererClient(email, password);
		System.out.println("Connexion :" + client);

		if (client != null) {
			req.getSession().setAttribute("client", client);
			resp.sendRedirect("tableauDeBord");
		} 
		else {
			req.setAttribute("erreur", "Utilisateur non trouvé. Le mail ou le mot de passe est incorrect");
			doGet(req, resp);
		}
	}
}
