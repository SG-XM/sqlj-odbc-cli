/*@lineinfo:filename=MainSQL*//*@lineinfo:user-code*//*@lineinfo:1^1*/import java.sql.SQLException;

public class MainSQL extends SQLUtil{
    String ssn,fname,dname,fn,lname,ln,bdate,address;
    String sex,minit,mi;
    double salary,sal;
    int dno,dnumber;
    /*@lineinfo:generated-code*//*@lineinfo:8^4*/

//  ************************************************************
//  SQLJ iterator declaration:
//  ************************************************************

class Emp 
extends sqlj.runtime.ref.ResultSetIterImpl
implements sqlj.runtime.NamedIterator
{
  private int salaryNdx;
  private int lnameNdx;
  private int minitNdx;
  private int fnameNdx;
  private int ssnNdx;
  public Emp(sqlj.runtime.profile.RTResultSet resultSet) 
    throws java.sql.SQLException 
  {
    super(resultSet);
    ssnNdx = findColumn("ssn");
    fnameNdx = findColumn("fname");
    minitNdx = findColumn("minit");
    lnameNdx = findColumn("lname");
    salaryNdx = findColumn("salary");
  }
  public Emp(sqlj.runtime.profile.RTResultSet resultSet, int fetchSize, int maxRows) 
    throws java.sql.SQLException 
  {
    super(resultSet, fetchSize, maxRows);
    ssnNdx = findColumn("ssn");
    fnameNdx = findColumn("fname");
    minitNdx = findColumn("minit");
    lnameNdx = findColumn("lname");
    salaryNdx = findColumn("salary");
  }
  public String ssn() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(ssnNdx);
  }
  public String fname() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(fnameNdx);
  }
  public String minit() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(minitNdx);
  }
  public String lname() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(lnameNdx);
  }
  public double salary() 
    throws java.sql.SQLException 
  {
    return resultSet.getDoubleNoNull(salaryNdx);
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:8^85*/
    /*@lineinfo:generated-code*//*@lineinfo:9^4*/

//  ************************************************************
//  SQLJ iterator declaration:
//  ************************************************************

class Emppos 
extends sqlj.runtime.ref.ResultSetIterImpl
implements sqlj.runtime.PositionedIterator
{
  public Emppos(sqlj.runtime.profile.RTResultSet resultSet) 
    throws java.sql.SQLException 
  {
    super(resultSet, 5);
  }
  public Emppos(sqlj.runtime.profile.RTResultSet resultSet, int fetchSize, int maxRows) 
    throws java.sql.SQLException 
  {
    super(resultSet, fetchSize, maxRows, 5);
  }
  public String getCol1() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(1);
  }
  public String getCol2() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(2);
  }
  public String getCol3() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(3);
  }
  public String getCol4() 
    throws java.sql.SQLException 
  {
    return resultSet.getString(4);
  }
  public double getCol5() 
    throws java.sql.SQLException 
  {
    return resultSet.getDoubleNoNull(5);
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:9^64*/

    public void selectInfo(){
        ssn = readEntry("Enter a Social Security Number:");
        try{
            /*@lineinfo:generated-code*//*@lineinfo:14^12*/

//  ************************************************************
//  #sql { SELECT FNAME,MINIT,LNAME,ADDRESS,SALARY
//                   INTO :fname, :minit, :lname, :address, :salary, 
//                  FROM EMPLOYEE WHERE SSN =:ssn };
//  ************************************************************

{
  sqlj.runtime.profile.RTResultSet __sJT_rtRs;
  sqlj.runtime.ConnectionContext __sJT_connCtx = sqlj.runtime.ref.DefaultContext.getDefaultContext();
  if (__sJT_connCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_DEFAULT_CONN_CTX();
  sqlj.runtime.ExecutionContext __sJT_execCtx = __sJT_connCtx.getExecutionContext();
  if (__sJT_execCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_EXEC_CTX();
  synchronized (__sJT_execCtx) {
    sqlj.runtime.profile.RTStatement __sJT_stmt = __sJT_execCtx.registerStatement(__sJT_connCtx, MainSQL_SJProfileKeys.getKey(0), 0);
    try 
    {
      __sJT_stmt.setString(1, ssn);
      __sJT_rtRs = __sJT_execCtx.executeQuery();
    }
    finally 
    {
      __sJT_execCtx.releaseStatement();
    }
  }
  try 
  {
    sqlj.runtime.ref.ResultSetIterImpl.checkColumns(__sJT_rtRs, 5);
    if (!__sJT_rtRs.next())
    {
      sqlj.runtime.error.RuntimeRefErrors.raise_NO_ROW_SELECT_INTO();
    }
    fname = __sJT_rtRs.getString(1);
    minit = __sJT_rtRs.getString(2);
    lname = __sJT_rtRs.getString(3);
    address = __sJT_rtRs.getString(4);
    salary = __sJT_rtRs.getDoubleNoNull(5);
    if (__sJT_rtRs.next())
    {
      sqlj.runtime.error.RuntimeRefErrors.raise_MULTI_ROW_SELECT_INTO();
    }
  }
  finally 
  {
    __sJT_rtRs.close();
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:17^45*/
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println("Social Security Number does not exist:"+ssn);
        }
        System.out.println(fname+ " "+minit+" "+lname+" "+address+" "+salary);
    }
    public void selectDep(){
        dname =readEntry("Enter the Department Name:");
        try{
            /*@lineinfo:generated-code*//*@lineinfo:27^12*/

//  ************************************************************
//  #sql { SELECT DNUMBER
//                   INTO :dnumber, 
//                  FROM DEPARTMENT WHERE DNAME =:dname };
//  ************************************************************

{
  sqlj.runtime.profile.RTResultSet __sJT_rtRs;
  sqlj.runtime.ConnectionContext __sJT_connCtx = sqlj.runtime.ref.DefaultContext.getDefaultContext();
  if (__sJT_connCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_DEFAULT_CONN_CTX();
  sqlj.runtime.ExecutionContext __sJT_execCtx = __sJT_connCtx.getExecutionContext();
  if (__sJT_execCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_EXEC_CTX();
  synchronized (__sJT_execCtx) {
    sqlj.runtime.profile.RTStatement __sJT_stmt = __sJT_execCtx.registerStatement(__sJT_connCtx, MainSQL_SJProfileKeys.getKey(0), 1);
    try 
    {
      __sJT_stmt.setString(1, dname);
      __sJT_rtRs = __sJT_execCtx.executeQuery();
    }
    finally 
    {
      __sJT_execCtx.releaseStatement();
    }
  }
  try 
  {
    sqlj.runtime.ref.ResultSetIterImpl.checkColumns(__sJT_rtRs, 1);
    if (!__sJT_rtRs.next())
    {
      sqlj.runtime.error.RuntimeRefErrors.raise_NO_ROW_SELECT_INTO();
    }
    dnumber = __sJT_rtRs.getIntNoNull(1);
    if (__sJT_rtRs.next())
    {
      sqlj.runtime.error.RuntimeRefErrors.raise_MULTI_ROW_SELECT_INTO();
    }
  }
  finally 
  {
    __sJT_rtRs.close();
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:30^52*/
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println("Department does not exist:"+dname);
            return;
        }
        System.out.println("Employee information for Department:"+dname);
        try{
            Emp e= null;
        /*@lineinfo:generated-code*//*@lineinfo:39^8*/

//  ************************************************************
//  #sql e = { SELECT SSN,FNAME,MINIT,LNAME,SALARY
//                      FROM EMPLOYEE WHERE DNO = :dnumber  };
//  ************************************************************

{
  sqlj.runtime.ConnectionContext __sJT_connCtx = sqlj.runtime.ref.DefaultContext.getDefaultContext();
  if (__sJT_connCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_DEFAULT_CONN_CTX();
  sqlj.runtime.ExecutionContext __sJT_execCtx = __sJT_connCtx.getExecutionContext();
  if (__sJT_execCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_EXEC_CTX();
  synchronized (__sJT_execCtx) {
    sqlj.runtime.profile.RTStatement __sJT_stmt = __sJT_execCtx.registerStatement(__sJT_connCtx, MainSQL_SJProfileKeys.getKey(0), 2);
    try 
    {
      __sJT_stmt.setInt(1, dnumber);
      e = new Emp(__sJT_execCtx.executeQuery(), __sJT_execCtx.getFetchSize(), __sJT_execCtx.getMaxRows());
    }
    finally 
    {
      __sJT_execCtx.releaseStatement();
    }
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:41^55*/
            while(e.next()){

                System.out.println(e.ssn()+" "+e.fname()+" "+e.minit()+" "+e.lname()+" "+e.salary());
            }
            e.close();
        }catch(Exception e){
            e.printStackTrace();
            return;
        }
    }

    public void selectDep2(){
        dname =readEntry("Enter the Department Name:");
        try{
            /*@lineinfo:generated-code*//*@lineinfo:56^12*/

//  ************************************************************
//  #sql { SELECT DNUMBER
//                   INTO :dnumber, 
//                  FROM DEPARTMENT WHERE DNAME =:dname };
//  ************************************************************

{
  sqlj.runtime.profile.RTResultSet __sJT_rtRs;
  sqlj.runtime.ConnectionContext __sJT_connCtx = sqlj.runtime.ref.DefaultContext.getDefaultContext();
  if (__sJT_connCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_DEFAULT_CONN_CTX();
  sqlj.runtime.ExecutionContext __sJT_execCtx = __sJT_connCtx.getExecutionContext();
  if (__sJT_execCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_EXEC_CTX();
  synchronized (__sJT_execCtx) {
    sqlj.runtime.profile.RTStatement __sJT_stmt = __sJT_execCtx.registerStatement(__sJT_connCtx, MainSQL_SJProfileKeys.getKey(0), 3);
    try 
    {
      __sJT_stmt.setString(1, dname);
      __sJT_rtRs = __sJT_execCtx.executeQuery();
    }
    finally 
    {
      __sJT_execCtx.releaseStatement();
    }
  }
  try 
  {
    sqlj.runtime.ref.ResultSetIterImpl.checkColumns(__sJT_rtRs, 1);
    if (!__sJT_rtRs.next())
    {
      sqlj.runtime.error.RuntimeRefErrors.raise_NO_ROW_SELECT_INTO();
    }
    dnumber = __sJT_rtRs.getIntNoNull(1);
    if (__sJT_rtRs.next())
    {
      sqlj.runtime.error.RuntimeRefErrors.raise_MULTI_ROW_SELECT_INTO();
    }
  }
  finally 
  {
    __sJT_rtRs.close();
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:59^52*/
        }catch(SQLException se){
            se.printStackTrace();
            System.out.println("Department does not exist:"+dname);
        }
        System.out.println("Employee information for Department:"+dname);
        try{
            Emppos e= null;
        /*@lineinfo:generated-code*//*@lineinfo:67^8*/

//  ************************************************************
//  #sql e = { SELECT SSN,FNAME,MINIT,LNAME,SALARY
//                      FROM EMPLOYEE WHERE DNO = :dnumber  };
//  ************************************************************

{
  sqlj.runtime.ConnectionContext __sJT_connCtx = sqlj.runtime.ref.DefaultContext.getDefaultContext();
  if (__sJT_connCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_DEFAULT_CONN_CTX();
  sqlj.runtime.ExecutionContext __sJT_execCtx = __sJT_connCtx.getExecutionContext();
  if (__sJT_execCtx == null) sqlj.runtime.error.RuntimeRefErrors.raise_NULL_EXEC_CTX();
  synchronized (__sJT_execCtx) {
    sqlj.runtime.profile.RTStatement __sJT_stmt = __sJT_execCtx.registerStatement(__sJT_connCtx, MainSQL_SJProfileKeys.getKey(0), 4);
    try 
    {
      __sJT_stmt.setInt(1, dnumber);
      e = new Emppos(__sJT_execCtx.executeQuery(), __sJT_execCtx.getFetchSize(), __sJT_execCtx.getMaxRows());
    }
    finally 
    {
      __sJT_execCtx.releaseStatement();
    }
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:69^55*/
        /*@lineinfo:generated-code*//*@lineinfo:70^8*/

//  ************************************************************
//  #sql { FETCH :e  INTO :ssn, :fn, :mi, :ln, :sal,  };
//  ************************************************************

{
  if (e.next())
  {
    ssn = e.getCol1();
    fn = e.getCol2();
    mi = e.getCol3();
    ln = e.getCol4();
    sal = e.getCol5();
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:70^48*/
            while(!e.endFetch()){
                System.out.println(ssn+" "+fn+" "+mi+" "+ln+" "+sal);
                /*@lineinfo:generated-code*//*@lineinfo:73^16*/

//  ************************************************************
//  #sql { FETCH :e  INTO :ssn, :fn, :mi, :ln, :sal,  };
//  ************************************************************

{
  if (e.next())
  {
    ssn = e.getCol1();
    fn = e.getCol2();
    mi = e.getCol3();
    ln = e.getCol4();
    sal = e.getCol5();
  }
}


//  ************************************************************

/*@lineinfo:user-code*//*@lineinfo:73^56*/
            }
            e.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}/*@lineinfo:generated-code*/class MainSQL_SJProfileKeys 
{
  private java.lang.Object[] keys;
  private final sqlj.runtime.profile.Loader loader = sqlj.runtime.RuntimeContext.getRuntime().getLoaderForClass(getClass());
  private static MainSQL_SJProfileKeys inst = null;
  public static java.lang.Object getKey(int keyNum) 
    throws java.sql.SQLException 
  {
    synchronized(MainSQL_SJProfileKeys.class) {
      if (inst == null)
      {
        inst = new MainSQL_SJProfileKeys();
      }
    }
    return inst.keys[keyNum];
  }
  private MainSQL_SJProfileKeys() 
    throws java.sql.SQLException 
  {
    keys = new java.lang.Object[1];
    keys[0] = sqlj.runtime.ref.DefaultContext.getProfileKey(loader, "MainSQL_SJProfile0");
  }
}
