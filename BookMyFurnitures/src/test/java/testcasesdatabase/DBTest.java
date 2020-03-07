package testcasesdatabase;

import java.sql.DriverManager;
import java.sql.SQLException;
import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.Statement;

import base.CommonConstant;

public class DBTest {

	public Connection con = null;
	public Statement stmt;

	
	@Test
	public void validateDBTest() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(CommonConstant.DB_URL, CommonConstant.DB_USER,CommonConstant.DB_PASSWORD);
		con.close();
		

		}

	}


