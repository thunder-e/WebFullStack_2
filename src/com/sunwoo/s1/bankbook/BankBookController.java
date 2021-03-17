package com.sunwoo.s1.bankbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunwoo.s1.util.ActionFoward;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
      //멤버변수로 service 객체생성 
	private BankBookService bankBookService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	//Controller 객체 생성 후 자동 호출되는 초기화 메서드
    	bankBookService = new BankBookService();
    	BankBookDAO bankBookDAO = new BankBookDAO();
    	bankBookService.setBankBookDAO(bankBookDAO);
    	
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MemberController 참조
		System.out.println("BankBook Controller!!!!");
		
		//	/WebFullStack_2/bankbook/bankbookList.do
		String uri = request.getRequestURI();
		
		//subString으로 마지막주소 가져오기
		//1. 자르려고 하는 인덱스번호 찾기
		int index = uri.lastIndexOf("/");
		
		//2. 해당 인덱스부터 잘라오기
		uri = uri.substring(index+1); //bankbookList.do
	
		ActionFoward actionFoward = null;
		
		try {
			if(uri.equals("bankbookList.do")) {
				actionFoward = bankBookService.getList(request); //actionFoward - path정보, true false정보
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//forward, redirect
		if(actionFoward.isCheck()) {
			//forward
			RequestDispatcher view = request.getRequestDispatcher(actionFoward.getPath());
			view.forward(request, response);
		} else {
			//redirect
			response.sendRedirect(actionFoward.getPath());
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
