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
//url �ּҸ� �޾�����, html�� �ƴϸ� �����̳ʴ� url ������ �´� �������� �����Ѵ�. 


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
		int lastIndex = uri.lastIndexOf("/");//������ /�� index(��ġ)�� return.
		String action = uri.substring(lastIndex+1);//������ /���� +1�� ������ �������� ���� action String�� �Է�
		
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
