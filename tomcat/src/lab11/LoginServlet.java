
package tomcat.src.lab11;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type
        response.setContentType("text/html");

        // Get the username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Write the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Login Details</h2>");
        out.println("<p><b>Username:</b> " + username + "</p>");
        out.println("<p><b>Password:</b> " + password + "</p>");
        out.println("</body></html>");
    }
}

