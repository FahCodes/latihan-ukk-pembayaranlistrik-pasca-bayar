package fahmi_connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
//Function
public class fahmidb_connection implements fahmi_kunciKoneksi{
    static class con{
        static Statement createStatement(){
            throw new UnsupportedOperationException("Not Yet Implemented");
        }
        public con(){
        }
    }
    public Connection connection;
    public fahmidb_connection(){
        try{
            Object newInstance = Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(Exception e){
            Logger.getLogger(fahmidb_connection.class.getName()).log(Level.SEVERE,null,e);
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static void main(String[] args){
        fahmidb_connection k = new fahmidb_connection();
    }
}
