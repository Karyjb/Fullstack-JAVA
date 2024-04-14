import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConecctionStatement {


    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

        public static void main(String[] args) {

            Connection myConn = null;
            Statement myStamt = null;
            ResultSet myRes = null;


            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "toor";

            try {
                myConn = DriverManager.getConnection(url, user, password);
                System.out.println("Genial, nos conectamos!!!");


                myStamt = myConn.createStatement();


                //Actualizar datos

                //int rowsAffected = myStamt.executeUpdate("UPDATE employees set email = 'johanador@example.com' WHERE first_name = 'Johana' ");
                //myRes = myStamt.executeQuery("SELECT * fROM employees order by pa_surname");

                //Eliminar datos

                int rowsAffected = myStamt.executeUpdate("DELETE from employees WHERE id = 7 ");
                myRes = myStamt.executeQuery("SELECT * fROM employees order by pa_surname");
              while (myRes.next()){
                    System.out.println(myRes.getString("first_name" ) + "," + myRes.getString("id"));
                }

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Algo salio mal :( ");
            }
        }
    }

