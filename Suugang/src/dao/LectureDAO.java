package dao;

import java.util.List;

import model.Lecture;

public interface LectureDAO {
	List<Lecture> selectALL();
	List<Lecture> selectByDname(String dname);
	List<Lecture> selectByLname(String lname);
}
