<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="bean.StudentBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>getMajor Result</title>
</head>
<body>
  <%
    StudentBean student = (StudentBean) request.getAttribute("student");
  %>
  <h2>Attribute retrieved from Servlet to JSP</h2>
  <p>Name: <%= student.getName() %></p>
  <p>Email: <%= student.getAge() %></p>
  <p>Message: <%= student.getMajor() %></p>
</body>
</html>