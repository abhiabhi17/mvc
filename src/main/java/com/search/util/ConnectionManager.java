package com.search.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;

public class ConnectionManager {

	private static final String db_uname="root";
	private static final String db_pwd="";
	private static final String db_url="jdbc:mysql://localhost:3306/search";
	private static final String db_driver_cls="com.mysql.jdbc.Driver";
	private static Connection con = null;
	
public static Connection getConnection() {
		// TODO Auto-generated method stub
		try {
	      Class.forName(db_driver_cls); 
           Connection con = DriverManager.getConnection(db_url, db_uname, db_pwd);
            }

catch(Exception e)
{
	e.printStackTrace();
}

return con;
}	
}

//no comments removed and adeed some info power gone//
