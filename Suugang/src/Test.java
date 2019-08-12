import java.util.List;

import dao.TimetableDAOImpl;
import model.Timetable;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimetableDAOImpl timetableDAOImpl=new TimetableDAOImpl();
		List<Timetable> timetableList=timetableDAOImpl.selectBylno("1");
		String day=timetableList.get(0).getDay();
		System.out.println(day);
	}

}
