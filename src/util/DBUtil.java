package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	public static Connection connect(){
		Connection conn = null;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/util/dbInfo.properties"));
			Class.forName(properties.getProperty("driver"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("success");
		} catch (ClassNotFoundException e) {
			System.out.println("not found class :" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB connect fail :" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("파일경로 확인 :" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Connection connect(boolean auto){
		Connection conn = null;
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/util/dbInfo.properties"));
			Class.forName(properties.getProperty("driver"));
			String url = properties.getProperty("url");
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			conn = DriverManager.getConnection(url, user, password);
			//commit setting
			conn.setAutoCommit(auto);
		} catch (ClassNotFoundException e) {
			System.out.println("not found class :" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("DB connect fail :" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("파일경로 확인 :" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void disconnect(ResultSet resultSet, Statement statement, Connection conn){
		try{
			if(resultSet!=null) resultSet.close();
			if(statement!=null) statement.close();
			if(conn!=null) conn.close();
		} catch (SQLException e	){
			e.printStackTrace();
		}
	}
	
	public static void disconnect(Statement statement, Connection conn){
		try{
			if(statement!=null) statement.close();
			if(conn!=null) conn.close();
		} catch (SQLException e	){
			e.printStackTrace();
		}
	}
}
