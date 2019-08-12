package controller;

import java.io.IOException;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DepartmentDAOImpl;
import dao.LectureDAOImpl;
import model.Department;
import model.Lecture;
@WebServlet(urlPatterns= {"/lectureList_move"})
public class LectureController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		int lastIndex=uri.lastIndexOf("/");
		String action=uri.substring(lastIndex+1);
		req.setCharacterEncoding("utf-8");
		if(action.equals("lectureList_move")) {
			LectureDAOImpl lecturedao=new LectureDAOImpl();
			DepartmentDAOImpl departmentDAO=new DepartmentDAOImpl();
			List<Lecture> lectureList=lecturedao.selectALL();
			List<Department> departmentList=departmentDAO.selectAll();
			req.setAttribute("lectureList", lectureList);
			req.setAttribute("departmentList",departmentList);
			System.out.println("½ÇÇà12");
			RequestDispatcher rd=req.getRequestDispatcher("/jsp/lectureList.jsp");
			rd.forward(req, resp);
		}
	}
}
