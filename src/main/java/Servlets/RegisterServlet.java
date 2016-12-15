package Servlets;

import Database.HqlQueries;
import Database.MyFactories;
import Database.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting an instance of a SessionFactory
		SessionFactory sessionFactory = MyFactories.getInstance().getSessionFactory();
		HqlQueries hql = HqlQueries.getInstance();

		// Requests form data
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		// Creating user
		Users users = new Users();
		users.setName(name);
		users.setEmail(email);
		users.setPassword(password);
		users.setRole(role);

		// Open database connection
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Saving to database
		session.save(users);
		session.getTransaction().commit();

		// Closing database connection
		session.close();

			
		// Redirect to login page
		response.sendRedirect("/login.jsp");
		}
}


