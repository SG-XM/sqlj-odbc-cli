import java.sql.SQLException;

public class MainSQL extends SQLUtil{
    String ssn,fname,dname,fn,lname,ln,bdate,address;
    String sex,minit,mi;
    double salary,sal;
    int dno,dnumber;
    #sql iterator Emp(String ssn,String fname,String minit,String lname,double salary);
    #sql iterator Emppos(String ,String ,String ,String ,double );

    public void selectInfo(){
        ssn = readEntry("Enter a Social Security Number:");
        try{
            #sql{
                SELECT FNAME,MINIT,LNAME,ADDRESS,SALARY
                INTO :fname,:minit,:lname,:address,:salary
                FROM EMPLOYEE WHERE SSN =:ssn};
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println("Social Security Number does not exist:"+ssn);
        }
        System.out.println(fname+ " "+minit+" "+lname+" "+address+" "+salary);
    }
    public void selectDep(){
        dname =readEntry("Enter the Department Name:");
        try{
            #sql{
                SELECT DNUMBER
                INTO :dnumber
                FROM DEPARTMENT WHERE DNAME =: dname};
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println("Department does not exist:"+dname);
            return;
        }
        System.out.println("Employee information for Department:"+dname);
        try{
            Emp e= null;
        #sql e = {
                    SELECT SSN,FNAME,MINIT,LNAME,SALARY
                    FROM EMPLOYEE WHERE DNO = :dnumber };
            while(e.next()){

                System.out.println(e.ssn()+" "+e.fname()+" "+e.minit()+" "+e.lname()+" "+e.salary());
            }
            e.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
    }

    public selectDept2(){
        dname =readEntry("Enter the Department Name:");
        try{
            #sql{
                SELECT DNUMBER
                INTO :dnumber
                FROM DEPARTMENT WHERE DNAME =: dname};
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println("Department does not exist:"+dname);
        }
        System.out.println("Employee information for Department:"+dname);
        try{
            Emppos e= null;
        #sql e = {
                    SELECT SSN,FNAME,MINIT,LNAME,SALARY
                    FROM EMPLOYEE WHERE DNO = :dnumber };
        #sql{FETCH :e INTO :ssn,:fn,:mi,:ln,:sal};
            while(!e.endFetch()){
                System.out.println(ssn+" "+fn+" "+mi+" "+ln+" "+sal);
                #sql{FETCH :e INTO :ssn,:fn,:mi,:ln,:sal};
            }
            e.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}