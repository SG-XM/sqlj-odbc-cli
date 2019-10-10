import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class JDBCUtil{
   public static Connection connection;
    public JDBCUtil(){
        String userid = "root";
        String passwd = "root";
        String url = "jdbc:mysql://localhost:3306/test";
        try {
            connection = DriverManager.getConnection(url,userid,passwd);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

}