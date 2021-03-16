package com.sunwoo.s1.bankbook;

import javax.servlet.http.HttpServletRequest;

import com.sunwoo.s1.util.ActionFoward;

public class BankBookService {

	//getList dao의 getList 호출  action
	private BankBookDAO bankBookDAO;

	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}
	
	public ActionFoward getList(HttpServletRequest request) throws Exception {
		ActionFoward actionFoward = new ActionFoward();
		String method = request.getMethod();
		actionFoward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
		actionFoward.setCheck(true);
		if(method.toUpperCase().equals("POST")) {
			
			
			
			actionFoward.setPath("../index.do");
			actionFoward.setCheck(false);
		}
		
		
		
		return actionFoward;
	}
	
	
}
