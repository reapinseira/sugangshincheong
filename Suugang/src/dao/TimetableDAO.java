package dao;

import java.util.List;

import model.Timetable;

public interface TimetableDAO {
	List<Timetable> selectBylno(String lno);
	Timetable selectByTno(int tno);
}
