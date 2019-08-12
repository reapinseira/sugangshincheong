package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Lecture;
import model.Timetable;

public class TimetableDAOImpl extends BaseDAO implements TimetableDAO {
	private static final String SELECT_BY_TNO_SQL=
			"select * from timetable where tno=?";
	private static final String SELECT_BY_LNO_SQL=
			"select*from schedule where lno=?";
	@Override
	public Timetable selectByTno(int tno) {
		Timetable timetable=new Timetable();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECT_BY_TNO_SQL);
			preparedStatement.setInt(1, tno);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				timetable.setDay(resultSet.getString("day"));
				timetable.setTime(resultSet.getInt("time"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return timetable;
	}
	@Override
	public List<Timetable> selectBylno(String lno) {
		List<Timetable> timetableList=new ArrayList<Timetable>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECT_BY_LNO_SQL);
			preparedStatement.setString(1, lno);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				int tno=resultSet.getInt("tno");
				Timetable timetable=selectByTno(tno);
				timetableList.add(timetable);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return null;
	}

}
