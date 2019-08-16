package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.Student;

public class LoginDAOImpl extends BaseDAO implements LoginDAO {
	
	private static final String STUDENT_LOGIN
	= "SELECT sno, sname, sphoto, dno, spassword" +
		" FROM student" +
		" WHERE sno = ? AND spassword = ?";
	
	private static final String ADMIN_LOGIN
	= "SELECT ano, aname, apassword, aemail" +
		" FROM admin" +
		" WHERE ano = ? AND apassword = ?";

	@Override
	public Student StudentLogin(String sno, String spassword) {
		Student student = new Student();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			preparedStatement = connection.prepareStatement(STUDENT_LOGIN);
			preparedStatement.setString(1, sno);
			preparedStatement.setString(2, spassword);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				student.setSno(resultSet.getString("sno"));
				student.setSname(resultSet.getString("sname"));
				student.setSpassword(resultSet.getString("spassword"));
				student.setSphoto(resultSet.getString("sphoto"));
				student.setDno(resultSet.getInt("dno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return student;
	}

	@Override
	public Admin AdminLogin(String ano, String apassword) {
		Admin admin = new Admin();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			preparedStatement = connection.prepareStatement(ADMIN_LOGIN);
			preparedStatement.setString(1, ano);
			preparedStatement.setString(2, apassword);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				admin.setAno(resultSet.getString("sno"));
				admin.setAname(resultSet.getString("sname"));
				admin.setApassword(resultSet.getString("spassword"));
				admin.setAemail(resultSet.getString("aemail"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return admin;
	}
	
	
	

}