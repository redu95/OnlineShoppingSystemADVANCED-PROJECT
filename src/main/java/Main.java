import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;



public class Main {

    public static void rsd(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/club");
            rowSet.setUsername("root");
            rowSet.setPassword("root00");
            rowSet.setCommand("select * from loginuser");
            rowSet.execute();
            while(rowSet.next()){
                for(int i = 1; i <= 6; i++){
                    System.out.print(rowSet.getString(i)+"\t");
                }
                System.out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void logMetaData(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/club", "root", "root00");
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM loginuser");
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Total columns: "+rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));
            System.out.println("Column Name of 2nd column: "+rsmd.getColumnName(2));
            System.out.println("Column Type Name of 2nd column: "+rsmd.getColumnTypeName(2));

            con.close();


        }
        catch(Exception e){
            System.out.println(" Fenan is Always Correct!");

        }

    }
    public static void display() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/club", "root", "root00");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from loginuser");

            System.out.println("Role\tID\tName");
            System.out.println("------------------------------------\n");

            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            }

            System.out.println("---------------------------------------");
            con.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error: MySQL JDBC driver not found. Make sure to include it in your classpath.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void addMember(String user_role, String user_name, String user_pass, String user_sex, String user_status){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/club", "root", "root00");
            Statement stmt = con.createStatement();

            String query = "INSERT into loginuser(user_role, user_name, user_pass, user_sex, user_status)values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user_role);
            ps.setString(2, user_name);
            ps.setString(3, user_pass);
            ps.setString(4, user_sex);
            ps.setString(5, user_status);

            int result = ps.executeUpdate();
            ps.close();

        }
        catch(Exception e){
            System.out.println("Oops there was an error!");
        }
    }

    public static void main(String[] args) {
        //addMember("Admin", "Demeke Mekonnen", "olala@453", "Male", "Active");
        //display();
        //logMetaData();
        rsd();
    }
}