<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%-- Directive Tag: Setting page properties --%>
<%@ page import="java.util.Date" %> <%-- Directive Tag: Importing Date class --%>

<html>
<head>
    <title>Full JSP Example</title>
</head>

<body>

    <%-- Directive Tag: Including external file --%>
    <%@ include file="header.html" %>

    <h1>Welcome to Full JSP Example!</h1>

    <%-- Declaration Tag: Declaring a method --%>
    <%! 
        public int addNumbers(int a, int b) {
            return a + b;
        }
    %>

    <%-- Scriptlet Tag: Writing Java logic --%>
    <%
        int x = 10, y = 20;
        int sum = addNumbers(x, y);
    %>

    <%-- Expression Tag: Direct output of sum --%>
    <p>Sum of 10 and 20 is: <b><%= sum %></b></p>

    <%-- Expression Tag: Display current Date and Time --%>
    <p>Today's date is: <b><%= new Date() %></b></p>

</body>
</html>
