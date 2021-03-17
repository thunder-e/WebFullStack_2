package com.sunwoo.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sunwoo.s1.util.ActionFoward;

public class BankBookService {
	//멤버변수로 선언 -> 다른 메서드에서도 쓸 수 있게. 객체는 하나만 있으면 되니까
	private BankBookDAO bankBookDAO;

	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}
	
	//getList dao의 getList 호출  action
	public ActionFoward getList(HttpServletRequest request) throws Exception {
		ActionFoward actionFoward = new ActionFoward();
		List<BankBookDTO> ar = bankBookDAO.getList();
		
		request.setAttribute("list", ar);
		actionFoward.setPath("../WEB-INF/bankbook/bankbookList.jsp"); //상대경로를 적을 때 현재위치
		actionFoward.setCheck(true); //true-forward false-redirect 
		//
		
		return actionFoward;
	}
	
	
}
