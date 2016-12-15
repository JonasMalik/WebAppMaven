package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jonas on 2016-12-12.
 */

// Filter to check if user is logged in
@WebFilter(filterName = "UserAuthentication", urlPatterns = {"/Profile/*", "/profile.jsp/*"})
public class UserAuthentication implements Filter {
    public void destroy() {
    }


    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // Request session
        HttpSession httpSession = request.getSession();

        // Check if there is a user in session
        if (httpSession.getAttribute("User") == null){
            // Redirects to login page
            response.sendRedirect("/login.jsp");
        }else {
            // Next filter/servlet
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
