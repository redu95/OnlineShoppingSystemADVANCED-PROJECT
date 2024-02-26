import com.connection.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("Great");
            //Getting all the parameters from the frontend (admin)
            String email = request.getParameter("email");
            String pass = request.getParameter("upass");

            //Retriving our session
            HttpSession hs = request.getSession();
            System.out.println("user "+hs.getId()+" has logged in as "+ email);

            //Calling Connection method
            Connection con = DatabaseConnection.getConnection();

            //Creating Statement
            Statement st = con.createStatement();

            //Querying inside the database
            ResultSet resultset = st.executeQuery("select * from tbladmin where email='" + email + "' AND password='" + pass + "'");
            //If all the details are correct
            if (resultset.next()) {
                hs.setAttribute("uname", resultset.getString("name"));
                //Redirecting admin to dashboard page
                response.sendRedirect("dashboard.jsp");

            } else {
                //If details are wrong
                String message = "You have enter wrong credentials";
                hs.setAttribute("credential", message);
                //Redirecting admin to admin login page
                response.sendRedirect("admin-login.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
