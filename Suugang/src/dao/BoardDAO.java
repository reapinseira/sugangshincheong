package dao;

import java.util.List;

import model.FAQ;
import model.Notice;

public interface BoardDAO {
	List<Notice> SelectAllNotice();
	List<FAQ> SelectAllFAQ();
	
	Notice SelectByNoNotice(int nno);
	FAQ SelectByNoFAQ(int fno);
	
	void InsertNotice(Notice notice);
	void InsertFAQ(FAQ faq);
	
	void UpdateNotice(Notice notice);
	void UpdateFAQ(FAQ faq);
	
	void DeleteNotice(int no);
	void DeleteFAQ(int no);
}
