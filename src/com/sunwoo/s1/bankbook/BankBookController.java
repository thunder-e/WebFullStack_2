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
       
	private BankBookService bankBookService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankBookController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MemberController 참조
		System.out.println("BankBook Controller!!!!");
		
		String path = request.getServletPath();
		String uri = request.getRequestURI();
		System.out.println(path);
		System.out.println(uri);
		String result="";
		
		//subString으로 마지막주소 가져오기
		//1. 자르려고 하는 인덱스번호 찾기
		int index = uri.lastIndexOf("/");
		
		//2. 해당 인덱스부터 잘라오기
		result = uri.substring(index);
		System.out.println(result);
		String pathInfo="";
		
		ActionFoward actionFoward = null;
		
		if(result.equals("bankbookList.do")) {
			System.out.println("리스트 출력");
			try {
				actionFoward = bankBookService.getList(request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("에러 발생");
				e.printStackTrace();
			} 
		} else {
			System.out.println("그 외 다른 처리");
		}
		
		
		if(actionFoward.isCheck()) {
			//foward
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
