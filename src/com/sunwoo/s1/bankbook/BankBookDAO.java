package com.sunwoo.s1.bankbook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BankBookDAO {
	
	//getList
	//bankbook table의 모든 데이터 조회 후 리턴
	public List<BankBookDTO> getList() throws Exception {
		
		
		//1. 로그인 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		//2. 클래스 로딩 - 드라이버명 명시
		Class.forName(driver);
		
		//3. 로그인 Connection
		Connection con = DriverManager.getConnection(url, user, password);
		
		//4. SQL문 작성
		String sql = "select * from bankbook";
		
		//5. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);
		
		//6. ? 세팅
		
		//7. 최종전송 후 처리
		ResultSet rs = st.executeQuery();
		
		List<BankBookDTO> dtos = new ArrayList<>();
		
		if(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBooknumber(rs.getInt("bookname"));
			bankBookDTO.setBookname(rs.getString("bookname"));
			bankBookDTO.setBookrate(rs.getDouble("bookrate"));
			bankBookDTO.setBooksale(rs.getString("booksale"));
			dtos.add(bankBookDTO);
		}
		
	
		//8. 연결 해제
		rs.close();
		st.close();
		con.close();
		
		
		return dtos;
		
		
		
		
		
	}
	
	
	
	

}
