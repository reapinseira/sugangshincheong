package dao;

import java.util.List;

import model.Department;

public interface DepartmentDAO {
	List<Department> selectAll();
}
