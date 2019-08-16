package dao;

import model.Admin;
import model.Student;

public interface LoginDAO {
	Student StudentLogin(String sno, String spassword);
	Admin AdminLogin(String ano, String apassword);
}