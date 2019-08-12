package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lecture;

public class LectureDAOImpl extends BaseDAO implements LectureDAO {
	private static final String SELECT_ALL_LECTURE_SQL=
			"select *from lecture l, professor p where l.pno=p.pno";
	private static final String SELECT_BY_DEPT_LECTURE_SQL=
			"select * from lecture natural join department " + 
			"                      natural join professor " + 
			"where dno=(select dno from department where dname=?)";
	private static final String SELECT_BY_LNAME_LECTURE_SQL=
			"select *from lecture natural join department " + 
			"                     natural join professor " + 
			"where lname like?";
	@Override
	public List<Lecture> selectALL() {
		List<Lecture> lectureList=new ArrayList<Lecture>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECT_ALL_LECTURE_SQL);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Lecture lecture=new Lecture();
				lecture.setLno(resultSet.getString("lno"));
				lecture.setLname(resultSet.getString("lname"));
				lecture.setCredit(resultSet.getInt("credit"));
				lecture.setLroom(resultSet.getString("lroom"));
				lecture.setPno(resultSet.getInt("pno"));
				lecture.setDno(resultSet.getInt("dno"));
				lecture.setPname(resultSet.getString("pname"));
				lecture.setDname(resultSet.getString("dname"));
				lectureList.add(lecture);
			}
			System.out.println("실행");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return lectureList;
	}

	@Override
	public List<Lecture> selectByDname(String dname) {
		List<Lecture> lectureList=new ArrayList<Lecture>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECT_BY_DEPT_LECTURE_SQL);
			preparedStatement.setString(1, dname);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Lecture lecture=new Lecture();
				lecture.setLno(resultSet.getString("lno"));
				lecture.setLname(resultSet.getString("lname"));
				lecture.setCredit(resultSet.getInt("credit"));
				lecture.setLroom(resultSet.getString("lroom"));
				lecture.setPno(resultSet.getInt("pno"));
				lecture.setPname(resultSet.getString("pname"));
				lecture.setDno(resultSet.getInt("dno"));
				lecture.setDname(resultSet.getString("dname"));
				lectureList.add(lecture);
			}
			System.out.println("실행");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return lectureList;
	}

	@Override
	public List<Lecture> selectByLname(String lname) {
		List<Lecture> lectureList=new ArrayList<Lecture>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECT_BY_LNAME_LECTURE_SQL);
			preparedStatement.setString(1, lname);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Lecture lecture=new Lecture();
				lecture.setLno(resultSet.getString("lno"));
				lecture.setLname(resultSet.getString("lname"));
				lecture.setCredit(resultSet.getInt("credit"));
				lecture.setLroom(resultSet.getString("lroom"));
				lecture.setPno(resultSet.getInt("pno"));
				lecture.setPname(resultSet.getString("pname"));
				lecture.setDno(resultSet.getInt("dno"));
				lecture.setDname(resultSet.getString("dname"));
				lectureList.add(lecture);
			}
			System.out.println("실행");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return lectureList;
	}
	


}
