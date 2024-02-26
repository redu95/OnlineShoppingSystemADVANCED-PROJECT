

import com.connection.DatabaseConnection;
import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerProductsOrderStatus")
public class CustomerProductsOrderStatus extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int statusMode = 0;
            //Taking input from admin order-id to get the order status from the database
            ResultSet rs = DatabaseConnection.getResultFromSqlQuery("select order_status from tblorders where order_no='" + request.getParameter("orderId") + "'");
            while (rs.next()) {
                if (rs.getString(1).equals("Deliver")) {
                    statusMode = DatabaseConnection.insertUpdateFromSqlQuery("update tblorders set order_status='Pending' where order_no='" + request.getParameter("orderId") + "'");
                } else {
                    statusMode = DatabaseConnection.insertUpdateFromSqlQuery("update tblorders set order_status='Deliver' where order_no='" + request.getParameter("orderId") + "'");
                }
            }
            if (statusMode > 0) {
                //Sending response back to admin-all-orders.jsp page when sql query executed sucesfully
                response.sendRedirect("admin-all-orders.jsp");
            } else {
                //Sending response back to admin-all-orders.jsp page
                response.sendRedirect("admin-all-orders.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
