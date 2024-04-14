import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        //Statement myStamt = null;
        PreparedStatement myStamt = null;
        ResultSet myRes = null;

        String url = "jdbc:mysql://localhost:3306/project";
        String user = "root";
        String password = "toor";

        try {
            myConn = DriverManager.getConnection(url, user, password);
            System.out.println("Genial, nos conectamos!!!");

            String sql = ("INSERT INTO employees (first_name, pa_surname) VALUES(?,?)");
            myStamt = myConn.prepareStatement(sql);
            myStamt.setString(1,"Johana");
            myStamt.setString(2,"Dorantes");
            //myStamt = myConn.createStatement();
            //myRes = myStamt.executeQuery( "SELECT * FROM employees" );

            int rowsAffected = myStamt.executeUpdate();

            while (myRes.next()){
                System.out.println(myRes.getString("FIRST_NAME"));
            }
        }catch (Exception e){
        e.printStackTrace();
            System.out.println("Algo Salio mal");
    }
    }
}