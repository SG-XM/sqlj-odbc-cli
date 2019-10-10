#include "sqlcli.h"
#include <stdio.h>
#include <stdlib.h>
char lname[50];
char fname[15];
long salary;
long ssn;
long lenOut1, lenOut5;
#define NAME_LEN 50
void printSal() {
	SQLHSTMT stmt1;
	SQLHDBC con1;
	SQLHENV env1;
	SQLRETURN ret1, ret2, ret3, ret4;
	ret1 = SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &env1);
	ret1 = SQLSetEnvAttr(env1, SQL_ATTR_ODBC_VERSION, (SQLPOINTER)SQL_OV_ODBC3, SQL_IS_INTEGER);
	ret2 = SQLAllocHandle(SQL_HANDLE_DBC, env1, &con1);
	ret3 = SQLConnect(con1, (SQLCHAR*)"test", SQL_NTS, (SQLCHAR*)"root", SQL_NTS, (SQLCHAR*)"root", SQL_NTS);//连接数据库 
	if (ret3 == SQL_SUCCESS || ret3 == SQL_SUCCESS_WITH_INFO) {
		printf("connected!!\n");
	}
	char err[800];
	SQLError(env1, con1, SQL_NULL_HANDLE, NULL, NULL,
		err, sizeof(err), NULL);
	//printf("error:%s  <<-\n", err);
	ret4 = SQLAllocHandle(SQL_HANDLE_STMT, con1, &stmt1);
	
	char sql[200] = "SELECT LNAME,FNAME FROM EMPLOYEE WHERE SSN = ";
	printf("Enter a SSN :");
	char ssn[10];
	scanf_s("%s", ssn,9);
	char de[10] = ";";
	strcat_s(sql, sizeof(sql), ssn);
	strcat_s(sql, sizeof(sql), de);
	printf("%s",sql);
	
	SQLPrepare(stmt1, sql, SQL_NTS);
	 
	ret1 = SQLExecute(stmt1);//直接执行SQL语句 
	int P = 100;
	if (!ret1) {
		SQLBindCol(stmt1, 1, SQL_CHAR, lname, 15,&P);
		SQLBindCol(stmt1, 2, SQL_CHAR, fname, 15, &P);
		ret2 = SQLFetch(stmt1);
		if (!ret2) printf("\n res = %s,%s\n",lname,fname);
	}
	
	SQLDisconnect(con1);//断开与数据库的连接 
}

	int main()
	{
		printSal(); 
		system("pause");
		return 0;
	}