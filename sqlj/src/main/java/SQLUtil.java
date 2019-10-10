
import oracle.sqlj.runtime.Oracle;
import sqlj.runtime.ref.DefaultContext;

import java.sql.SQLException;
import java.util.Scanner;

public class SQLUtil {
    static DefaultContext cntxt;
    static Scanner scanner = new Scanner(System.in);

    public static void connectOracle() {

        String userid = "C##zq";
        String passwd = "root";
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:orclzq";

        try {
            cntxt = Oracle.getConnection(url, userid, passwd);//= DriverManager.getConnection(url, userid, passwd);
            DefaultContext.setDefaultContext(cntxt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            cntxt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static String readEntry(String hint) {
        System.out.println(hint);
        return scanner.next();
    }
}
