package com.biz.oracle.exec;

import com.biz.oracle.dao.IolistDAO;
import com.biz.oracle.dao.tbl_scoreDAO;

public class IolistExec01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//DAO class를 사용하기 위해서 객체로 생성
//		IolistDAO id = new IolistDAO();
//		
//		//DB 연결
//		id.dbConnection();
//		
//		//데이터를 읽어서 console에 표시
//		id.selectIoList();
		
		tbl_scoreDAO tsD = new tbl_scoreDAO();
		tsD.dbConnection();
		tsD.selecttbl_score();
	}

}
