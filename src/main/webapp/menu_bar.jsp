<%@ page contentType="text/html; charset=UTF-8" %>
<%!
    String login;
    String name;
    String role;
%>
<%
    // Checking if user is logged in
    if (request.getSession().getAttribute("User")== null){
        login = "Logga in";
    }else{
        login = "Logga ut";
    }
%>
<div id="header">
    <ul id="topMenu">
        <%
            // Checking if user is logged in
            if (request.getSession().getAttribute("User")!= null){

                // Getting session variables
                name = request.getSession().getAttribute("User").toString();
                role = request.getSession().getAttribute("Role").toString();

                // Printing user information
                out.print("<h3 class='title'>Inloggad som:</h3>");
                out.print("<h3 class='left'>");
                out.print(name);
                out.print("</h3>");
                out.print("<h3 class='title'>Behörighet:</h3>");
                out.print("<h3 class='left'>");
                out.print(role);
                out.print("</h3>");
            }
        %>
        <li class="right"><a class="active" href="/Logout"><%=login%></a></li>
    </ul>
</div>
