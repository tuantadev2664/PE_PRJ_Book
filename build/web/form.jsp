<%-- 
    Document   : Edit.jsp
    Created on : Jun 13, 2024, 6:43:12 AM
    Author     : FPTSHOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="menu.jsp"/>
        <jsp:include page="banner.jsp"/>
        <% 
        if (request.getAttribute("newMember") != null ) {  
        %>
        <div class="alert alert-success" role="alert">
            <p>Id: ${newMember.id}</p>
            <p>Name: ${newMember.name}</p>
            <p>Email: ${newMember.email}</p>
            <p>Join Date: ${newMember.join_date}</p>
        </div>
        <% 
        } else if (request.getAttribute("mess") != null) {  
        %>
        
        <h1 class="modal-title" style="text-align: center">Form Add New Member</h1>

        <div style="margin: 30px" >
            <div style="display: flex; justify-content: center; align-items: center">
                <form action="check" method="get" style="width: 50%">
                    <div class=" alert alert-danger" role="alert"><p style="text-align: center">${mess}</p></div>
                    <div class="row mb-3">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <input value="" name="name" type="text" class="form-control" required >
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input value="" name="email" type="text" class="form-control" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check" style="text-align: center">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <button type="submit" class="btn btn-primary">save</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <%
//            session.setAttribute("mess1", null);
        } else{ 
        %>

        <h1 class="modal-title" style="text-align: center">Form Add New Member here</h1>

        <div style="margin: 30px" >
            <div style="display: flex; justify-content: center; align-items: center">
                <form action="check" method="get" style="width: 50%">
                    <div class="row mb-3">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Name</label>
                        <div class="col-sm-10">
                            <input value="" name="name" type="text" class="form-control" required >
                        </div>
                    </div>

                    <div class="row mb-3">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input value="" name="email" type="text" class="form-control" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-sm-10 offset-sm-2">
                            <div class="form-check" style="text-align: center">
                                <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                                <button type="submit" class="btn btn-primary">save</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <%
            }
        %>               
        <jsp:include page="footer.jsp"/>

    </body>
</html>
