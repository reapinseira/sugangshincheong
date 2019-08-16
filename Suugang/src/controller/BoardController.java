package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import model.Notice;

@WebServlet(name = "BoardController", urlPatterns = {"/notice", "/notice_detail", "/faq", "/lecture_info"} )
public class BoardController extends HttpServlet {

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
		
		if (action.equals("notice")) {
			
			BoardDAO dao = new BoardDAOImpl();
			List<Notice> noticeList = dao.SelectAllNotice();
			/*
			for (Notice n : noticeList) {
				System.out.println(n);
			}
			*/
			req.setAttribute("noticeList", noticeList);
			
			RequestDispatcher rd = req.getRequestDispatcher("/notice.jsp");
			rd.forward(req, resp);
		
		} else if (action.equals("notice_detail")) {
			int nno = Integer.parseInt(req.getParameter("nno"));
			
			BoardDAO dao = new BoardDAOImpl();
			Notice noticeDetail = new Notice();
			noticeDetail = dao.SelectByNoNotice(nno);
			//System.out.println(noticeDetail);
			
			req.setAttribute("notice", noticeDetail);
			
			RequestDispatcher rd = req.getRequestDispatcher("/noticedetail.jsp");
			rd.forward(req, resp);
		
		} else if (action.equals("faq")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/faq.jsp");
			rd.forward(req, resp);
		} else if (action.equals("lecture_info")) {
			
			RequestDispatcher rd = req.getRequestDispatcher("/lectureinfo.jsp");
			rd.forward(req, resp);
		}
	
	}

}
