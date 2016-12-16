package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Servlets.ProfileServlet
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/Profile/*", "/profile"})
public class ProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//opens profile.jsp
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}



}
