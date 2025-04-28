package servlets;

// File: FormServlet.java
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import bean.FormDataBean;

import java.io.*;

public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Create a FormDataBean and populate it with form data
        FormDataBean formData = new FormDataBean();
        formData.setName(name);
        formData.setEmail(email);
        formData.setMessage(message);

        // Write the result directly to the response
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h2>Form Data Submitted</h2>");
        out.println("<p>Name: " + formData.getName() + "</p>");
        out.println("<p>Email: " + formData.getEmail() + "</p>");
        out.println("<p>Message: " + formData.getMessage() + "</p>");
        out.println("</body></html>");
        out.close();
    }
}

