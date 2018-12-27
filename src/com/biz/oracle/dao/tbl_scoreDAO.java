package com.biz.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class tbl_scoreDAO {

	Connection dbConn ;
	
	public void dbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String strurl = "jdbc:oracle:thin:@localhost:1521:xe";
			String struser = "myMEM";
			String password = "1234";
			
			dbConn = DriverManager.getConnection(strurl, struser, password);
			
			System.out.println("DB 연결 성공");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selecttbl_score() {
		
		PreparedStatement ps ;
		
		String sql = "SELECT * FROM 통합성적일람표";
		
		try {
			ps = dbConn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(true) {
				
				if(rs.next() == false) break;
				
				String strName = rs.getString("st_name");
				int intKor = rs.getInt("국어");
				int intEng = rs.getInt("영어");
				int intMth = rs.getInt("수학");
				int intSci = rs.getInt("과학");
				int intHis = rs.getInt("국사");
				int intPic = rs.getInt("미술");
				int intSum = intKor + intEng + intMth + intSci + intHis + intPic;
				float floatAvg = intSum / 6.0f;
				
				
				System.out.print(strName + "\t");
				System.out.print(intKor + "\t");
				System.out.print(intEng + "\t");
				System.out.print(intMth + "\t");
				System.out.print(intSci + "\t");
				System.out.print(intHis + "\t");
				System.out.print(intPic + "\t");
				System.out.print(intSum + "\t");
				System.out.print(floatAvg + "\n");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
