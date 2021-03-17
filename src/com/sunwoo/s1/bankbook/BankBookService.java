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
		
		
		public ActionFoward getWrite(HttpServletRequest request) throws Exception {
			ActionFoward actionFoward = new ActionFoward();
			
			System.out.println("setWrite");
			//GET
			actionFoward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
			actionFoward.setCheck(true); 
			if(request.getMethod().toUpperCase().equals("POST")) {		//get으로 해서 500 오류났었음
				//받아서 insert
				BankBookDTO bankBookDTO = new BankBookDTO();
				//입력은 3개하는데 bookNumber은 없으니까 파라미터의 값은 String의 기본값인 null -> 오류
				bankBookDTO.setBookName(request.getParameter("bookName"));
				bankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")));
				bankBookDTO.setBookSale(request.getParameter("bookSale"));
				//DAO 작업
				int result = bankBookDAO.setWrite(bankBookDTO);
				actionFoward.setPath("./bankbookList.do"); //이미 같은 기능을 하는 메서드가 있다면 redirect
				actionFoward.setCheck(false); //redirect 
			}
			
			return actionFoward;
		}
		


		public ActionFoward getSelect(HttpServletRequest request)throws Exception{
			ActionFoward actionFoward = new ActionFoward();
			
			long bookNumber = Long.parseLong(request.getParameter("bookNumber"));
			
			BankBookDTO bankBookDTO = bankBookDAO.getSelect(bookNumber);
			
			actionFoward.setCheck(true);
			actionFoward.setPath("../WEB-INF/bankbook/bankbookSelect.jsp");
			request.setAttribute("dto", bankBookDTO);
			
			return actionFoward;
		}
		

		//getList dao의 getList 호출 
		public ActionFoward getList(HttpServletRequest request)throws Exception{
			ActionFoward actionFoward = new ActionFoward();
			List<BankBookDTO> ar = bankBookDAO.getList();
			
			request.setAttribute("list", ar);
			actionFoward.setPath("../WEB-INF/bankbook/bankbookList.jsp");
			actionFoward.setCheck(true);
			
			
			return actionFoward;
		}
		

		
}