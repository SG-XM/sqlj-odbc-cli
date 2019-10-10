
set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_80
set SQLJ_HOME=C:\Program Files\IBM\SQLLIB\
set PROJ_HOME=D:\sqlj\sqlj
set CLASSPATH=C:\app\oraroot\product\12.1.0\dbhome_1\oc4j\sqlj\lib\*;C:\app\oraroot\product\12.1.0\dbhome_1\jdbc\lib\ojdbc.jar;
path=%SQLJ_HOME%\bin;%JAVA_HOME%\bin;
cd=%PROJ_HOME%\src\main\java\
@echo off
sqlj MainSQL.sqlj