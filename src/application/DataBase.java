package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBase
{
	static final String JDBC_Driver = "com.mysql.jdbc.Driver" ; 
	static final String DB_URL_1 = "jdbc:mysql://localhost:3306/?useSSL=false" ;
	static final String DB_URL_2 = "jdbc:mysql://localhost:3306/DOUBLECOLOUR?useSSL=false" ;
	
	static final String USER = "root";
	static final String PASS = "Liuqingxun" ;
	
	public static void createDataBase()
	{
		try
		{
			Class.forName(JDBC_Driver) ;
			
			Connection conn1 = DriverManager.getConnection(DB_URL_1, USER, PASS) ;
			Statement stmt1 = conn1.createStatement() ;
			stmt1.execute("CREATE DATABASE IF NOT EXISTS DOUBLECOLOUR") ;
			conn1.close();
			
			Connection conn2 = DriverManager.getConnection(DB_URL_2, USER, PASS) ;
			Statement stmt2 = conn2.createStatement() ;
			stmt2.execute("CREATE TABLE IF NOT EXISTS DATALIST(No INT DEFAULT '1' PRIMARY KEY,RED char(32),BLUE char(4),TIME CHAR(10))") ;
			stmt2.execute("ALTER TABLE DATALIST MODIFY No INT AUTO_INCREMENT");
			conn2.close();
			
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void insertNum(String red, String blue)
	{
		try
		{
			Class.forName(JDBC_Driver) ;
			Connection conn = DriverManager.getConnection(DB_URL_2, USER, PASS) ;
			Statement stmt = conn.createStatement() ;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
			Date now = new Date();
			String today = sdf.format(now) ;

			String sqlNum = "INSERT INTO DATALIST(RED,BLUE,TIME) VALUES('" + red + "','" + blue + "','" + today + "')";
			stmt.execute(sqlNum) ;
			
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} 
	}
	
	public static void getResult()
	{
		try
		{
			Class.forName(JDBC_Driver) ;
			Connection conn = DriverManager.getConnection(DB_URL_2, USER, PASS) ;
			Statement stmt = conn.createStatement() ;
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM DATALIST") ;
			
			while(rs.next())
			{
				int No = rs.getInt(1) ;
				String red = rs.getString("RED") ;
				String blue = rs.getString("BLUE") ;
				String time = rs.getString("TIME") ;
				
				System.out.printf("%d ;%s ;%s ;%s\n",No,red,blue,time);
			}
			
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
