package com.abc.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
     private static DBConnectionManager dbConnManager;
     private static final String jdbcUrl = "jdbc:sqlite:test.db";
     private static final String jdbcDriverName = "org.sqlite.JDBC";
    
    
     private DBConnectionManager() throws ClassNotFoundException, SQLException {
        //JDBC드라이버 로드
        Class.forName(jdbcDriverName);
     }

     public static Connection getConnection() throws ClassNotFoundException, SQLException {
		  if(dbConnManager==null){
		       dbConnManager = new DBConnectionManager();
		  }
		  //DBMS에 연결하여 Connection 객체 얻기.
		  return DriverManager.getConnection(jdbcUrl);
     }
}