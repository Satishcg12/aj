package tomcat.src.lab13;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a Student object
        StudentBean student = new StudentBean();
        student.setName("Satish Chandra");
        student.setAge(21);
        student.setMajor("BCA");

        // Set the Student object as an attribute in the request
        request.setAttribute("student", student);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/studentDetails.jsp").forward(request, response);
    }
}

