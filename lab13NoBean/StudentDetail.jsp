<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Student Details</title>
</head>
<body>
  <h2>Attribute retrieved from Servlet to JSP</h2>
  <p>Name: <%= request.getAttribute("name") %></p>
  <p>Age: <%= request.getAttribute("age") %></p>
  <p>Major: <%= request.getAttribute("major") %></p>
</body>
</html>