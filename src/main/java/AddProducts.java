import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.connection.DatabaseConnection;

@WebServlet("/AddProducts")
public class AddProducts extends HttpServlet {

    // Path where all the images are stored
    private final String UPLOAD_DIRECTORY = "C:/Users/Windows 10 Pro/Videos/OnlineShoppingSystemADVANCED PROJECT/src/main/webapp/uploads";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Creating session
        HttpSession session = request.getSession();
        String imageName = null;
        String productName = null;
        String productQuantity = null;
        String productPrice = null;
        String descrip = null;
        String mrpPrice = null;
        String status = null;
        String category = null;

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                // Taking all image requests
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

                // SALTCHARS to generate unique code for product
                String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                StringBuilder salt = new StringBuilder();
                Random rnd = new Random();
                while (salt.length() < 3) { // length of the random string.
                    int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                    salt.append(SALTCHARS.charAt(index));
                }
                String code = salt.toString();

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        // Getting image name
                        imageName = new File(item.getName()).getName();

                        // Check if image name is not null or empty
                        if (imageName != null && !imageName.isEmpty()) {
                            // Storing in the specified directory
                            item.write(new File(UPLOAD_DIRECTORY + File.separator + imageName));
                        }
                    } else {
                        // For form fields
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
                        

                        // Handle form fields
                        if ("productName".equals(fieldName)) {
                            productName = fieldValue;
                        } else if ("productPrice".equals(fieldName)) {
                            productPrice = fieldValue;
                        } else if ("productQuantity".equals(fieldName)) {
                            productQuantity = fieldValue;
                        } else if ("description".equals(fieldName)) {
                            descrip = fieldValue;
                        } else if ("mrpPrice".equals(fieldName)) {
                            mrpPrice = fieldValue;
                        } else if ("status".equals(fieldName)) {
                            status = fieldValue;
                        } else if ("category".equals(fieldName)) {
                            category = fieldValue;
                        }
                            // Add cases for other form fields
                        }
                    }
                
                
                try {
                    int id = 0;
                    String imagePath = UPLOAD_DIRECTORY + imageName;
                    
                    // Parse product quantity as an integer
                    int parsedProductQuantity = Integer.parseInt(productQuantity);
                    
                    // Querying to insert product in the table
                    int i = DatabaseConnection.insertUpdateFromSqlQuery(
                            "insert into tblproduct(id, active, code, description, image, image_name, name, price, mrp_price, product_category, productQuantity) values('"
                                    + id + "','" + status + "','" + code + "','" + descrip + "','" + imagePath + "','"
                                    + imageName + "','" + productName + "','" + productPrice + "','" + mrpPrice + "','"
                                    + category + "', " + parsedProductQuantity + ")");
                    
                    // If product inserted successfully in the database
                    if (i > 0) {
                        String success = "Product added successfully.";
                        // Adding method in session.
                        session.setAttribute("message", success);
                        // Response send to the admin-add-product.jsp
                        response.sendRedirect("admin-add-product.jsp");
                        System.out.println("user "+session.getId()+" has added product"+ productName);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                // If any error occurred
                ex.printStackTrace();
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }
        } else {
            request.setAttribute("message", "Sorry, this Servlet only handles file upload requests");
        }
        
    }
}
