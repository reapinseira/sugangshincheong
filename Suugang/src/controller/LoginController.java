package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import dao.LoginDAOImpl;
import model.Admin;
import model.Student;

@WebServlet(name = "LoginController", urlPatterns = {"/login_page", "/login", "/logout"} )
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);		
	}
	
	
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		//System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");//마지막 /의 index(위치)를 return.
		String action = uri.substring(lastIndex+1);//마지막 /에서 +1한 값부터 끝까지의 값을 action String에 입력
		
		HttpSession session=null;
		session = req.getSession();
		
		req.setCharacterEncoding("utf-8");
		
		if (action.equals("login_page")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
			rd.forward(req, resp);
		
		} else if (action.equals("login")) {
			
			LoginDAO dao = new LoginDAOImpl();
			Student studentInput = new Student();
			
			String message = null;
			String authority = null;
			
			String no = req.getParameter("no");
			//int no = Integer.parseInt(req.getParameter("no"));
			String password = req.getParameter("password");
			
			studentInput.setSno(no);
			studentInput.setSpassword(password);
			
			System.out.println("input id : " + no);
			System.out.println("input pass : " + password);
			
			Student studentDB = dao.StudentLogin(no, password);
			Admin adminDB = dao.AdminLogin(no, password);
			
			System.out.println("DB id : " + studentDB.getSno());
			System.out.println("DB pass : " + studentDB.getSpassword());
			
			
			//if(studentInput.getSno().equals(studentDB.getSno())) {
			if(no.equals(studentDB.getSno())) {
				//아이디와 비밀번호를 모두 보내므로, 아이디만 비교하더라도 둘 다 일치해야만 여기로 넘어오게 됨.
				//학생 테이블에서 먼저 검색한 후 어드민 테이블 검색
				//System.out.println("아이디, 비밀번호 모두 일치");
				message = "로그인되었습니다.";
				req.setAttribute("message", message);
				
				session.setAttribute("account", studentDB);
				session.setAttribute("student", authority);
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			} else if (studentDB.getSno() == null) {
				//관리자 계정 검색
				System.out.println("일단 진입 확인");
				studentDB = null;
				
				authority = null;

				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
				
			} else {
				//학생 계정, 관리자 계정 둘 다 아닐 경우
				message = "아이디 혹은 비밀번호가 일치하지 않습니다.";
				req.setAttribute("message", message);
				studentDB = null;
				adminDB = null;
				authority = null;
				//각 개체값 초기화
				req.setAttribute("member", studentDB);
				
				RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
				rd.forward(req, resp);
			} 
			
			
			
			/*
			if (studentDB.getSpassword() == null) {
				//아이디가 존재하지 않거나, 아이디와 비밀번호가 일치하지 않을 경우
				//System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");
				
				//학생 아이디가 아니라면 관리자 테이블에서 계정 검색.
				//관리자 테이블에 일치하는 아이디가 있다면 break
				//관리자 테이블에서도 일치하는 아이디가 없다면 불일치 메세지 표시.
				
				message = "아이디 혹은 비밀번호가 일치하지 않습니다.";
				req.setAttribute("message", message);
				studentDB = null;
				req.setAttribute("member", studentDB);
				
				RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
				rd.forward(req, resp);
				
			} else if(sno == studentDB.getSno()) {
				//아이디와 비밀번호를 모두 보내므로, 아이디만 비교하더라도 둘 다 일치해야만 여기로 넘어오게 됨.
				System.out.println("아이디, 비밀번호 모두 일치");
				message = "로그인되었습니다.";
				req.setAttribute("message", message);
				
				session.setAttribute("student", studentDB);
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			}
			*/
			/*
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			*/
		} else if (action.equals("logout")) {
			
			System.out.println("logout 실행");
			session.removeAttribute("account");
			session.removeAttribute("authority");
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			
		}
		
		
	}

}