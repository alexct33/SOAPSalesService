<%-- 
    Document   : index
    Created on : 19-feb-2017, 15:32:41
    Author     : Àlex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store </title>
    </head>
    <body>
        <form action="SalesServlet" method="post">
                <p>Name</p> <input type="text" name="name" placeholder="name" required>
                <p>Quantity</p> <input type="number" name="quantity" required>
                <input id="add" name="add" type="submit" value="Add to cart">
            </form>
        
       <form action="SalesServlet" method="post">
                <input id="finishOrder" name= "finishOrder" type="submit" value="Finish your order">
            </form>
        
        <div>
            <h3>List of products:</h3>
            <a href="SalesServlet">Refresh</a>
            <c:forEach items="${productsList}" var="p">
                <p>${p}</p><br>
            </c:forEach>
            
        </div>
            <h4> Final price: </h4>
            <p>"${price}"</p>
    </body>
</html>
