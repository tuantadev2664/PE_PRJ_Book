<%-- 
    Document   : menu.jsp
    Created on : Jun 27, 2024, 1:00:11 AM
    Author     : FPTSHOP
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        
<!--        <a href="home">
            home
        </a>
    <c:if test="${sessionScope.cloud!=null}">
       
        ||
        <a href="login">
            Logout
        </a>
        &nbsp;&nbsp;&nbsp;
        <span style="color:red">[ ${sessionScope.cloud.username} ]</span>
    </c:if>
    <c:if test="${sessionScope.cloud==null}">
        ||
        <a href="login">
            Login
        </a>
    </c:if>
        -->
        
        <!-- Navigation Bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="home">Library</a>
            
            <c:if test="${sessionScope.cloud!=null}">
                <a class="nav-link" style="color:red">[Hello, ${sessionScope.cloud.username} ]</a>
            </c:if>
                
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            
                
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="form.jsp">Add New Member</a>
                    </li>
                    <c:if test="${sessionScope.cloud!=null}">
                        <li class="nav-item">
                            <a class="nav-link" href="login">Logout</a>
                        </li>

                    </c:if>
                    <c:if test="${sessionScope.cloud==null}">  
                        <li class="nav-item">
                            <a class="nav-link" href="login">Login</a>
                        </li>

                    </c:if>
                </ul>
            </div>
        </nav>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
