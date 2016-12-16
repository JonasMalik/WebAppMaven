package Servlets;

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

/**
 * Created by jonas on 2016-12-15.
 */
@WebServlet(name = "UpdateServlet", urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // Getting instance
        SessionFactory sessionFactory = MyFactories.getInstance().getSessionFactory();

        // Getting form data
        String StringId =  request.getParameter("id").trim();
        int id =  Integer.parseInt(StringId);
        String newName = request.getParameter("name");
        String newEmail = request.getParameter("email");
        String newPassword = request.getParameter("password");
        String newRole = request.getParameter("role");

        // Creating user
        Users users = new Users();
        users.setId(id);
        users.setName(newName);
        users.setEmail(newEmail);
        users.setPassword(newPassword);
        users.setRole(newRole);

        // Open database connection
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Update user
        session.update(users);
        session.getTransaction().commit();

        // Closing database connection
        session.close();

        // Redirect
        resp.sendRedirect("/Profile");
    }
}
