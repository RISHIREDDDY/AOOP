import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/VoterEligibilityServlet")
public class VoterEligibilityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get the user's name and age from the form submission
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        // Validate input and handle errors
        try {
            int age = Integer.parseInt(ageStr);

            // Check voter eligibility based on age
            if (age >= 18) {
                out.println("<h2>Hello " + name + ", you are eligible to vote!</h2>");
            } else {
                out.println("<h2>Hello " + name + ", you are not eligible to vote yet.</h2>");
            }
        } catch (NumberFormatException e) {
            out.println("<h2>Invalid input. Please enter a valid number for age.</h2>");
        }

        out.close();
    }
}
