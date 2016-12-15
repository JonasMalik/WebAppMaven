<%@ page import="com.sun.xml.internal.ws.developer.MemberSubmissionAddressing" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <!--================  CSS =================================-->
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/login.css" rel="stylesheet"/>
        <link href="css/validation.css" rel="stylesheet"/>
        <link href="css/table.css" rel="stylesheet"/>
        <link href="css/popup.css" rel="stylesheet"/>
        <!--================ JavaScript/JQuery ====================-->
        <script src="js/jquery-1.12.2.min.js"></script>
        <script src="js/user_manager.js"></script>
    </head>
    <body>
        <jsp:include page="menu_bar.jsp"/>
        <div id="mainContainer">
            <h1>Registrerade konton</h1>
            <%
                String includes = null;
                if(request.getSession().getAttribute("Role").equals("ROLE_ADMIN")){
                    includes = "admins_table.jsp";
                }else {
                    includes = "users_table.jsp";
                }
            %>
            <jsp:include page="<%=includes%>"/>
        </div>
        <jsp:include page="popup.jsp"/>
    </body>
</html>