package lab13Bean;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import bean.StudentBean;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a Student object
        StudentBean student = new StudentBean();
        student.setName("Rayyan Hir000");
        student.setAge(21);
        student.setMajor("Computer Science");

        // Set the Student object as an attribute in the request
        request.setAttribute("student", student);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/studentDetails.jsp").forward(request, response);
    }
}

