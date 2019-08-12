package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lecture;

public class SugangDAOImpl extends BaseDAO implements SugangDAO {
	private static final String SELECT_BY_SNO_SQL=
			"select *from lecture natural join department\r\n" + 
			"                     natural join professor\r\n" + 
			"where lno in(select lno from sugang where sno=?)";
	private static final String INSERT_SUGANG_SQL=
			"insert into sugang values(?,?)";
	@Override
	public void insert(String lno, String sno) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(INSERT_SUGANG_SQL);
			preparedStatement.setString(1, lno);
			preparedStatement.setString(2, sno);
			preparedStatement.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(null, preparedStatement, connection);
		}
	}

	@Override
	public List<Lecture> selectBySno(String sno) {
		List<Lecture> lectureList=new ArrayList<Lecture>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECT_BY_SNO_SQL);
			preparedStatement.setString(1, sno);
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
			System.out.println("½ÇÇà");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return lectureList;
	}

}
