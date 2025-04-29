package servlets;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set individual attributes in the request
        request.setAttribute("name", "Rayyan Hir000");
        request.setAttribute("age", 21);
        request.setAttribute("major", "Computer Science");

        // Forward the request to the JSP page
        request.getRequestDispatcher("/studentDetails.jsp").forward(request, response);
    }
}