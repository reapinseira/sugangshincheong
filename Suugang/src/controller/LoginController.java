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
		int lastIndex = uri.lastIndexOf("/");//������ /�� index(��ġ)�� return.
		String action = uri.substring(lastIndex+1);//������ /���� +1�� ������ �������� ���� action String�� �Է�
		
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
				//���̵�� ��й�ȣ�� ��� �����Ƿ�, ���̵� ���ϴ��� �� �� ��ġ�ؾ߸� ����� �Ѿ���� ��.
				//�л� ���̺��� ���� �˻��� �� ���� ���̺� �˻�
				//System.out.println("���̵�, ��й�ȣ ��� ��ġ");
				message = "�α��εǾ����ϴ�.";
				req.setAttribute("message", message);
				
				session.setAttribute("account", studentDB);
				session.setAttribute("student", authority);
				
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
			} else if (studentDB.getSno() == null) {
				//������ ���� �˻�
				System.out.println("�ϴ� ���� Ȯ��");
				studentDB = null;
				
				authority = null;

				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.forward(req, resp);
				
			} else {
				//�л� ����, ������ ���� �� �� �ƴ� ���
				message = "���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
				req.setAttribute("message", message);
				studentDB = null;
				adminDB = null;
				authority = null;
				//�� ��ü�� �ʱ�ȭ
				req.setAttribute("member", studentDB);
				
				RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
				rd.forward(req, resp);
			} 
			
			
			
			/*
			if (studentDB.getSpassword() == null) {
				//���̵� �������� �ʰų�, ���̵�� ��й�ȣ�� ��ġ���� ���� ���
				//System.out.println("���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				
				//�л� ���̵� �ƴ϶�� ������ ���̺��� ���� �˻�.
				//������ ���̺� ��ġ�ϴ� ���̵� �ִٸ� break
				//������ ���̺����� ��ġ�ϴ� ���̵� ���ٸ� ����ġ �޼��� ǥ��.
				
				message = "���̵� Ȥ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
				req.setAttribute("message", message);
				studentDB = null;
				req.setAttribute("member", studentDB);
				
				RequestDispatcher rd = req.getRequestDispatcher("/loginpage.jsp");
				rd.forward(req, resp);
				
			} else if(sno == studentDB.getSno()) {
				//���̵�� ��й�ȣ�� ��� �����Ƿ�, ���̵� ���ϴ��� �� �� ��ġ�ؾ߸� ����� �Ѿ���� ��.
				System.out.println("���̵�, ��й�ȣ ��� ��ġ");
				message = "�α��εǾ����ϴ�.";
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
			
			System.out.println("logout ����");
			session.removeAttribute("account");
			session.removeAttribute("authority");
			
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, resp);
			
		}
		
		
	}

}