package dao;

import java.util.List;

import model.Lecture;

public interface SugangDAO {
	void insert(String sno, String lno);
	List<Lecture> selectBySno(String sno);
	
}
