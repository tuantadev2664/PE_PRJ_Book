<%-- 
    Document   : content
    Created on : May 20, 2024, 2:19:41 PM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>   
    </head>
    <body>
<!--        
        
        <div >
            <table border="1px" width="50%" >
                <tr>
                    <td>ID</td>
                    <td>Title</td>
                    <td>author</td>
                    <th>Publication Date</th>
                    <th>quantity</th>
                    <th>quantity</th>
                </tr>
                <c:forEach items = "${requestScope.listB}" var="c">
                    <c:set var="id" value="${c.id}"/>
                    <tr>
                        <td>${id}</td>
                        <td>${c.title}</td>
                        <td>${c.author}</td>
                        <td>${c.publication_date}</td>
                        <td>${c.quantity}</td>
                        <td>
                            <img src="https://tse3.mm.bing.net/th?id=OIP.h-9M93OmUds-tCiDZVl9eQHaFF&pid=Api&P=0&h=180"/>
                        </td>
                        <td>
                            <a href="borrow?id=${id}">Borrow</a>        
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>    
        
        -->
        <div class="container">
            <div class="row">
                <c:forEach items = "${requestScope.listM}" var="c">
                    <c:set var="id" value="${c.id}"/>
                    <div class="col-md-4 mb-4">
                        <div class="card">
                            <img src="https://tse4.mm.bing.net/th?id=OIP.uH8ATjitch8vqF7QWc57QwEsEs&pid=Api&P=0&h=180" class="card-img-top" alt="Apple" height="auto">
                            <div class="card-body">
                                <h5 class="card-title">Name: ${c.name}</h5>
                                <p class="card-text">ID: ${id}</p>
                                <p class="card-text">Email: ${c.email}</p>
                                <p class="card-text">Join Date: ${c.join_date}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <img src="images/Add.png" href="add.jsp" class="card-img-top" alt="Apple" height="356pt">
                        <div class="card-body">
                            <h5 class="card-title">Add New Member</h5>
                            <p class="card-text"></p>
                            <p class="card-text"></p>
                            <a href="form.jsp" class="btn btn-primary">Add</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         
        
    </body>
</html>
