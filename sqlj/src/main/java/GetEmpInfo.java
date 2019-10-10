import java.sql.*;
import java.util.Scanner;

public class GetEmpInfo {
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

            String dbacct, passwrd, ssn, lname;
            Double salary;
            dbacct = readEntry("Enter database account:");
            passwrd = readEntry("Enter password:");
            String url = "jdbc:oracle:thin:@127.0.0.1:1521:com";
            connection = DriverManager.getConnection(url, dbacct, passwrd);
            String stml = "select Lname,Salary from EMPLOYEE where Ssn = ?";
            //不要直接拼接，预处理可很大程度上防注入且效率更高，最重要的是可读性！！
            PreparedStatement p = connection.prepareStatement(stml);
            ssn = readEntry("Entera Social Security Number:");
            p.clearParameters();
            p.setString(1, ssn);
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
