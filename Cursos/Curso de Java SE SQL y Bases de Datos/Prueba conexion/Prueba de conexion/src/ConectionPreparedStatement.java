import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ConectionPreparedStatement {

    public static void main(String[] args) {

        Connection myConn = null;
        PreparedStatement myStamt = null;


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


            int rowsAffected = myStamt.executeUpdate();

            if (rowsAffected > 0){
                System.out.println("Se ha creado un cliente");
            }
        }catch (Exception e){
        e.printStackTrace();
            System.out.println("Algo Salio mal");
    }
    }
}