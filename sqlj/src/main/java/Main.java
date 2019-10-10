

public class Main {
    public static void main(String[] args) {
//        SQLUtil sqlUtil = new MainSQL();
//        sqlUtil.connectOracle();
        //new JDBCUtil();

        MainSQL.connectOracle();
        new MainSQL().selectInfo();
        new MainSQL().selectDep();
        new MainSQL().selectDep2();
        MainSQL.closeConnection();

    }
}
