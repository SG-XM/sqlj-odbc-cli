#include "sqlcli.h"
#include "sqlcli1.h"
#include <stdio.h>


char lname[20];
int salary;
int ssn;
void printSal() {
	SQLHSTMT stmt1;
	SQLHDBC con1;
	SQLHENV env1;
	SQLRETURN ret1, ret2, ret3, ret4;
	ret1 = SQLAllocHandle(SQL_HANDLE_ENV, SQL_NULL_HANDLE, &env1);
	if (!ret1) {
		ret2 = SQLAllocHandle(SQL_HANDLE_DBC, env1, &con1);
	}
	else {
		exit;
	}
	if (!ret2) {
		ret3 = SQLConnect(con1, "orclzq", SQL_NTS, "C##ZQ", SQL_NTS, "root", SQL_NTS);
	}
	else {
		exit;
	}
	if (!ret3) {
		ret4 = SQLAllocHandle(SQL_HANDLE_STMT, con1, &stmt1);
	}
	else {
		exit;
	}
	SQLPrepare(stmt1, "SELECT LANEM,SALARY FROM emp WHERE SSN = ?", SQL_NTS);
	printf("Enter a Social Security Number:");
	scanf_s("%d", &ssn);
	int len1 = 7;
	int len2 = 15;
	SQLBindParameter(stmt1, 1, SQL_PARAM_INPUT, SQL_INTEGER, SQL_INTEGER, 7, 0, &ssn, 7499, &ssn);
	ret1 = SQLExecute(stmt1);
	if (!ret1) {
		SQLBindCol(stmt1, 1, SQL_CHAR, &lname, 15, &len2);
		SQLBindCol(stmt1, 2, SQL_INTEGER, &salary, 7, &len1);
		ret2 = SQLFetch(stmt1);
		if (!ret2) {
			printf("%d\t%s\t%d", ssn, lname, salary);
		}
		else {
			printf("Social Security Number Does Not Exist");
		}
	}
}
void main()
{
	printSal(); 
}
