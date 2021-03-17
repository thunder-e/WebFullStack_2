package com.sunwoo.s1.test;

import java.util.List;

import com.sunwoo.s1.bankbook.BankBookDAO;
import com.sunwoo.s1.bankbook.BankBookDTO;

public class BankBookDAOTest {

	public static void main(String[] args) {
		BankBookDAO bankBookDAO = new BankBookDAO();
 
		
		try {
			List<BankBookDTO> ar = bankBookDAO.getList();
			System.out.println(ar.size() != 0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
