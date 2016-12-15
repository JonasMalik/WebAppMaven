<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <!--================  CSS =================================-->
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/login.css" rel="stylesheet"/>
        <link href="css/register.css" rel="stylesheet"/>
        <link href="css/validation.css" rel="stylesheet"/>
    </head>
    <body>
        <jsp:include page="menu_bar.jsp"/>
        <div id="mainContainer">
            <div id="registerContainer">
                <h1>Registrera dig <br></h1>
                <select id="role" class="inputPos" name="role" form="registerForm">
                    <option value="ROLE_USER">Användare</option>
                    <option value="ROLE_ADMIN">Administratör</option>
                </select>
                <form id="registerForm" action="RegisterServlet" method="post">
                    <input class="inputPos" type="text" name="name" placeholder="Namn" required><br>
                    <input class="inputPos" type="email" name="email" placeholder="E-post" required><br>
                    <input class="inputPos" type="password" name="password" placeholder="Lösenord" required><br>
                    <input id="registerButton" class="inputPos" type="submit" value="Registrera">
                </form>
                <br>
            </div>
        </div>
    </body>
</html>