package org.senyo.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Before;
import org.junit.Test;

public class MySQLTest {

	@Before
	public void setup() throws Exception {
	}
	
	@Test
	public void test(){
		fail("Not yet implemented");
	}

	@Test
	public void testConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bit88?useSSL=false",
				"makemoney",
				"makemoney");
		
		System.out.println(con);
		
		con.close();
	}

}
