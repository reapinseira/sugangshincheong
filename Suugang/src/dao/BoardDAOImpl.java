package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FAQ;
import model.Notice;

public class BoardDAOImpl extends BaseDAO implements BoardDAO {

	private static final String SelectAllNotice
	= "SELECT nno, ntitle, ncontent, TO_CHAR(ndate, 'yy/mm/dd') ndate, nclick, n.ano, a.aname" + 
		" FROM notice n, admin a" + 
		" WHERE n.ano = a.ano" +
		" ORDER BY nno DESC";

	private static final String SelectAllFAQ
	= "SELECT fno, ftitle, fcontent, TO_CHAR(fdate, 'yy/mm/dd') fdate, fclick, f.ano, a.aname" + 
		"FROM faq f, admin a" + 
		"WHERE f.ano = a.ano" +
		" ORDER BY fno DESC";
	
	
	private static final String SelectByNoNotice
	= "SELECT nno, ntitle, ncontent, TO_CHAR(ndate, 'yy/mm/dd') ndate, nclick, n.ano, a.aname" + 
		" FROM notice n, admin a" + 
		" WHERE n.ano = a.ano AND nno = ?";
	
	private static final String SelectByNoFAQ
	= "SELECT fno, ftitle, fcontent, TO_CHAR(fdate, 'yy/mm/dd') fdate, fclick, f.ano, a.aname" + 
		"FROM faq f, admin a" + 
		"WHERE f.ano = a.ano AND fno = ?";
	
	
	private static final String InsertNotice
	= "INSERT INTO notice" +
		" VALUES(seq_notice.nextval, ?, ?, TO_DATE(sysdate, 'yy/mm/dd'), 0, ?)";
	
	private static final String InsertFAQ
	= "INSERT INTO faq" +
		" VALUES(seq_faq.nextval, ?, ?, TO_DATE(sysdate, 'yy/mm/dd'), 0, ?)";
	
	
	private static final String UpdateNotice
	= "UPDATE notice" +
		" SET ntitle = ?, ncontent = ?" +
		" WHERE nno = ?";
	
	private static final String UpdateFAQ
	= "UPDATE faq" +
		" SET ftitle = ?, fcontent = ?" +
		" WHERE fno = ?";
	
	
	private static final String DeleteNotice
	= "DELETE FROM notice" +
		" WHERE nno = ?";
	
	private static final String DeleteFAQ
	= "DELETE FROM faq" +
		" WHERE fno = ?";
	
	
	
	@Override
	public List<Notice> SelectAllNotice() {
		List<Notice> noticeList = new ArrayList<Notice>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SelectAllNotice);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Notice notice = new Notice();
				
				notice.setNno(resultSet.getInt("nno"));
				notice.setNtitle(resultSet.getString("ntitle"));
				notice.setNcontent(resultSet.getString("ncontent"));
				notice.setNdate(resultSet.getString("ndate"));
				notice.setNclick(resultSet.getInt("nclick"));
				notice.setAno(resultSet.getString("ano"));
				notice.setAname(resultSet.getString("aname"));
				
				noticeList.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		
		return noticeList;
	}

	@Override
	public List<FAQ> SelectAllFAQ() {
		List<FAQ> faqList = new ArrayList<FAQ>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SelectAllFAQ);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				FAQ faq = new FAQ();
				
				faq.setFno(resultSet.getInt("fno"));
				faq.setFtitle(resultSet.getString("ftitle"));
				faq.setFcontent(resultSet.getString("fcontent"));
				faq.setFdate(resultSet.getString("fdate"));
				faq.setFclick(resultSet.getInt("fclick"));
				faq.setAno(resultSet.getString("ano"));
				faq.setAname(resultSet.getString("aname"));
				
				faqList.add(faq);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		
		return faqList;
	}

	
	
	@Override
	public Notice SelectByNoNotice(int nno) {
		Notice notice = new Notice();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(SelectByNoNotice);
			preparedStatement.setInt(1, nno);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				
				notice.setNno(resultSet.getInt("nno"));
				notice.setNtitle(resultSet.getString("ntitle"));
				notice.setNcontent(resultSet.getString("ncontent"));
				notice.setNdate(resultSet.getString("ndate"));
				notice.setNclick(resultSet.getInt("nclick"));
				notice.setAno(resultSet.getString("ano"));
				notice.setAname(resultSet.getString("aname"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(resultSet, preparedStatement, connection);
		}
		
		return notice;
	}

	@Override
	public FAQ SelectByNoFAQ(int fno) {
		
		return null;
	}

	
	
	@Override
	public void InsertNotice(Notice notice) {
		

	}

	@Override
	public void InsertFAQ(FAQ faq) {
		

	}

	
	
	
	@Override
	public void UpdateNotice(Notice notice) {
		

	}

	@Override
	public void UpdateFAQ(FAQ faq) {
		

	}

	
	
	@Override
	public void DeleteNotice(int no) {
		

	}

	@Override
	public void DeleteFAQ(int no) {
		

	}

}
