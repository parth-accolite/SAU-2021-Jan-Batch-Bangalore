package com.java.assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Assignment {
	public static void main(String Args[])  throws ClassNotFoundException, SQLException, IOException {
		FileOutputStream out;
		
		out = new FileOutputStream("randomNumbers.txt");
		int num;
		
		while(true){
			num = (int) (Math.random()*100);
			
			out.write(num);
			if(num % 5 == 0) {
				break;
			}
		}
		
		FileInputStream in = new FileInputStream("randomNumbers.txt");
		int c;
		ArrayList<Integer> myNums = new ArrayList<Integer>();
		while((c=in.read()) != -1) {
			myNums.add(c);
		}
		in.close();
		out.close();
		
		System.out.println(myNums);
		Integer modifiedInteger = myNums.stream().filter(e-> e%5 == 0).map(e-> e*2).reduce(1,(a,b)->{return a*b;});
		System.out.println(modifiedInteger);
Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		String url = "jdbc:mysql://remotemysql.com:3306/sMkXvyYxZM";		
		String username = "sMkXvyYxZM";
		String	passowrd = "8h9tWhCKws";
		
		Connection connection = DriverManager.getConnection(url, username, passowrd);
		
		
		String sql = "insert into test values (?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
//		Integer ids = modifiedInteger;
		String name="Parth"	;
		
		preparedStatement.setInt(1, modifiedInteger);
		preparedStatement.setString(2,name);
		preparedStatement.execute();

		ResultSet result = preparedStatement.executeQuery("select * from test");
		while(result.next()) {
		    String id = result.getString("id");
		    String name2 = result.getString("name");
		    System.out.println("Name,id - " + name2 + "," + id); 
		}
		
		
		
	}
}
