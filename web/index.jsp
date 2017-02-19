<%-- 
    Document   : index
    Created on : 19-feb-2017, 15:32:41
    Author     : Àlex
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Sports Store </title>
    </head>
    <body>
        <form action="SalesServlet" method="post">
                <p>Product name</p> <input type="text" name="name" placeholder="Ex. Tshirt, trainers..." required>
                <p>Quantity</p> <input type="number" name="quantity" required>
                <input id="add" name="add" type="submit" value="Add to cart">
        </form> <br>
        
       <form action="SalesServlet" method="post">
                <input id="finishOrder" name="finishOrder" type="submit" value="Finish your order!">
            </form>
        
        <div>
            <h3>List of products in the cart:</h3>
            <a href="SalesServlet">Refresh</a>
            <c:forEach items="${productsList}" var="p">
                <p>${p.getName()} ${p.getPrice()}€ x ${p.getQuantity()} = ${p.getQuantity() * p.getPrice()}€</p>
            </c:forEach>
            <form action="SalesServlet" method="post">
                <input id="removeAll" name="removeAll" type="submit" value="Remove all the items">
            </form><br>
        </div>
            <h4> Final price: </h4>
            <p>${price}€</p>
    </body>
</html>
