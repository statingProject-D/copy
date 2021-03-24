package board.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.BoardDAO;
import vo.Notice_BoardBean;
public class BoardListService {

	public int getNoticeBoardListCount(HashMap<String, Object> listOpt) {		//공지사항 게시판 글목록 갯수구하기
		int listCount = 0;
		Connection con = null;
		
		try {
			con = getConnection();
			BoardDAO boardDAO = BoardDAO.getinstance();
			boardDAO.setConnection(con);
			listCount = boardDAO.getNoticeListCount(listOpt);		//공지사항 글 목록 개수 구하기
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		
		return listCount;
	}

	public ArrayList<Notice_BoardBean> getNoticeBoardList(HashMap<String, Object> listOpt) {
		ArrayList<Notice_BoardBean> list = null;
		Connection con = null;
		
		try {
			con = getConnection();
			BoardDAO boardDAO = BoardDAO.getinstance();
			boardDAO.setConnection(con); 
			list = boardDAO.getNoticeBoardList(listOpt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return list;
	}

}
