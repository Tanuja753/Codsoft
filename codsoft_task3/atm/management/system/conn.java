package atm.management.system;
import java.sql.*;
public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","tanuja@1234567argade");
            s = c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
