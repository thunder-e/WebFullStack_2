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
			String method = request.getMethod();
			actionFoward.setPath("../WEB-INF/bankbook/bankbookWrite.jsp");
			actionFoward.setCheck(true); 
			if(method.toUpperCase().equals("GET")) {
				BankBookDTO bankBookDTO = new BankBookDTO();
				bankBookDTO.setBookNumber(Long.parseLong(request.getParameter("bookNumber")));
				bankBookDTO.setBookName(request.getParameter("bookName"));
				bankBookDTO.setBookRate(Double.parseDouble(request.getParameter("bookRate")));
				bankBookDTO.setBookSale(request.getParameter("bookSale"));
				int result = bankBookDAO.setWrite(bankBookDTO);
				actionFoward.setPath("../bankbook/bankbookList.do");
				actionFoward.setCheck(false);
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