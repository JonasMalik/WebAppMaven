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
@WebServlet(name = "DeleteServlet", urlPatterns = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Getting an instance of a SessionFactory
        SessionFactory sessionFactory = MyFactories.getInstance().getSessionFactory();
        //HqlQueries hql = HqlQueries.getInstance();

        String StringId =  req.getParameter("id").trim();
        int id =  Integer.parseInt(StringId);
        //String newName = request.getParameter("name");
        //String newEmail = request.getParameter("email");
        //String newPassword = request.getParameter("password");
        //String newRole = request.getParameter("role");

        // Creating user
        Users users = new Users();
        users.setId(id);

        // Open database connection
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Delete from database
        session.delete(users);
        session.getTransaction().commit();

        // Closing database connection
        session.close();


        resp.sendRedirect("/Profile");
    }
}
