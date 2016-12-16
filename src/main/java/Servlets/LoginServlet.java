package Servlets;

import Database.HqlQueries;
import Database.MyFactories;
import Database.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting instances
		SessionFactory sessionFactory = MyFactories.getInstance().getSessionFactory();
		HqlQueries hql = HqlQueries.getInstance();

		// Requests form data
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Open database conection
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// Creating query
		Query query = session.createQuery(hql.getLoginQuery())
								.setParameter("password",password)
									.setParameter("email", email);

		// Query result
		List<Users> results = query.getResultList();

		// Check if account exists
		if(results.size() != 0){
			Users users = results.get(0);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("User", users.getName());
			httpSession.setAttribute("Role", users.getRole());
			response.sendRedirect("/Profile");
		}else{

			// Redirect if user not found
			response.sendRedirect("/login.jsp");
		}

		// Closing database connection
		session.close();
	}
}

