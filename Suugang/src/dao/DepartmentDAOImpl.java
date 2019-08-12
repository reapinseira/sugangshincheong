package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Department;


public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO {
	private static final String SELECTALL_DEPT_SQL="select * from department";
	@Override
	public List<Department> selectAll() {
		List<Department> departmentList=new ArrayList<Department>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet =null;
		
		try {
			connection=getConnection();
			preparedStatement=connection.prepareStatement(SELECTALL_DEPT_SQL);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next()) {
				Department dept=new Department();
				dept.setDno(resultSet.getInt("dno"));
				dept.setDname(resultSet.getString("dname"));
				departmentList.add(dept);
			}
			System.out.println("dept½ÇÇà");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		return departmentList;
	}

}
