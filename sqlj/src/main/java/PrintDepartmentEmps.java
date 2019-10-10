import java.sql.*;
import java.util.Scanner;

public class PrintDepartmentEmps {
    static Scanner scanner = new Scanner(System.in);
    static Connection connection;

    public static void main(String[] args) throws SQLException {
        //检查jdbc驱动
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {

            String dbacct, passwrd,  lname;
            Double salary;
            int dno;
            dbacct = readEntry("Enter database account:");
            passwrd = readEntry("Enter password:");
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:com";
            connection = DriverManager.getConnection(url, dbacct, passwrd);
            String stml = "select Lname,Salary from EMPLOYEE where Dno = ?";
            //拒绝像 ppt JDBC2 那样拼接，还要把 dno 转换为 String 拼接实，非常不优雅
            PreparedStatement p = connection.prepareStatement(stml);
            //返回值不同不能构成重载，所以我也很好奇 ppt 上的 readentry 函数
            dno = Integer.valueOf(readEntry("Entera Social Security Number:"));
            p.clearParameters();
            p.setInt(1,dno);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                lname = r.getString(1);
                salary = r.getDouble(2);
                System.out.println(lname + " " + salary);
            }
            //释放资源
            p.close();
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static String readEntry(String hint) {
        System.out.println(hint);
        return scanner.next();
    }
}
