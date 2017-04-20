/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsystem;

/**
 *
 * @author xumc
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	static String URL = "jdbc:mysql://localhost:3306/PETSYSTEM?zeroDateTimeBehavior=convertToNull";//Change URL to yours
	static String USER = "root";
	static String PASS = "Cai19870120";//Add your password here
	
	static public Connection conn;
	
	static public Connection GetConnection() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
		
		Connection conn1 = DriverManager.getConnection(URL, USER, PASS);
		return conn1;
	}
}
    

