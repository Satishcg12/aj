package tomcat.src.lab12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get data from the form or in url parameters (http://localhost:8080/college/CookieServlet?username=rayyanhir000)
        String username = request.getParameter("username");

        // Create a cookie to store the username
        Cookie usernameCookie = new Cookie("username", username);

        
        // Set cookie expiry to 1 hour (3600 seconds)
        usernameCookie.setMaxAge(3600);
        // Set cookie path to the application context
        usernameCookie.setPath(request.getContextPath());
        
        // Add the cookie to the response
        response.addCookie(usernameCookie);

        // Set content type for response (HTML)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Send response with message about stored cookie
        out.println("<html>");
        out.println("<head><title>Cookie Example</title></head>");
        out.println("<body>");
        out.println("<h2>Cookie Stored!</h2>");
        out.println("<p>Username cookie has been stored for 1 hour.</p>");
        out.println("<form action='CookieServlet' method='post'>");
        out.println("<button type='submit'>Check Cookie</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get all cookies from the request
        Cookie[] cookies = request.getCookies();
        String username = null;

        // Find the cookie named "username"
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                }
            }
        }

        // Set content type for response (HTML)
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // If the username cookie exists, display it, else show a message
        out.println("<html>");
        out.println("<head><title>Cookie Value</title></head>");
        out.println("<body>");
        if (username != null) {
            out.println("<h2>Stored Username: " + username + "</h2>");
        } else {
            out.println("<h2>No username cookie found!</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}

