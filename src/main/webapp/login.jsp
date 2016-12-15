<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <!--================  CSS =================================-->
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/login.css" rel="stylesheet"/>
        <link href="css/validation.css" rel="stylesheet"/>
    </head>
    <body>
        <jsp:include page="menu_bar.jsp"/>
        <div id="mainContainer">
            <div id="loginContainer">
                <h1>Logga in<br></h1>
                <form id="loginForm" name="f" action="LoginServlet" method="post">
                    <input type="email" id="username" name="email" placeholder="E-post" required/>
                    <input type="password" id="password" name="password" placeholder="Lösenord" required/>
                    <button type="submit" id="loginButton">Logga in</button>
                </form>
                <br>
                Är du ny? Registrera här <a href="register.jsp">registrera</a>.
            </div>
        </div>
    </body>
</html>