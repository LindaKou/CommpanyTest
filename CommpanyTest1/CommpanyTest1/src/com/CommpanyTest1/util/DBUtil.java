package com.CommpanyTest1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	//连接本地数据库，上传时将本函数与下面的getConnection2()函数名交换
	public  static  Connection getConnection() {
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String user = "root";
		String password = "582607";
		String url = "jdbc:mysql://localhost:33060/qiye";
		Connection connection = null;
		try {
			//2.创建连接对象
			 connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
	
	//3.关闭连接
	public static void close(Connection connection ) {
		try {
			if (connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement preparedStatement ) {
		try {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void close(ResultSet resultSet ) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// 连接新浪云数据库，上传时将本函数与上面的函数名交换
	public static Connection getConnection2(){
		String driver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "qunying";
		//System.getenv("MYSQL_HOST_S"); 为从库，只读
		Connection con = null;
		
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", "szfusrvxydcc.mysql.sae.sina.com.cn", "10063", "zz");
		    try {
				Class.forName(driver).newInstance();
				con = DriverManager.getConnection(dbUrl, username, password);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    // ...
		return con;
	}
}
