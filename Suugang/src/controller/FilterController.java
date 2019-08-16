package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FilterController", 
			urlPatterns = {"/lecture_regist.do", "/timetable.do"} )
//url 주소를 받았을때, html이 아니면 컨테이너는 url 패턴이 맞는 서블릿으로 연결한다. 


public class FilterController extends HttpServlet{

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
		
		if (action.equals("lecture_regist.do")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/lecture_regist.jsp");
			rd.forward(req, resp);
			
		} else if (action.equals("timetable.do")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/timetable_dummy.jsp");
			rd.forward(req, resp);
	
		}
		
	}

}
