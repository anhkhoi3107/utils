/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
/**
 *
 * @author ADMIN
 */
public class JDBC {
    public static java.sql.Connection getConnection() {
		java.sql.Connection c = null;
		try {
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String url = "jdbc:sqlserver://localhost:1433;databaseName=BaoVe;"
					+ "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
			String user = "sa";
			String passWord = "123";
			c = DriverManager.getConnection(url, user, passWord);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}

	public static void closeConnection(java.sql.Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		java.sql.Connection cc = getConnection();
		System.out.println(cc);
	}
	
}
