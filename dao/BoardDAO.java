package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Notice_BoardBean;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private static BoardDAO edcDAO;
	


	public static BoardDAO getinstance() {
		if(edcDAO == null) {
			edcDAO = new BoardDAO();
		}
		return edcDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
		
	}
	

	public int getNoticeListCount(HashMap<String, Object> listOpt) {			//공지사항 글 목록 갯수 구하기
		int listCount = 0;
		String opt = (String) listOpt.get("opt");		//검색옵션
		String condition = (String)listOpt.get("condition"); //검색내용
		String sql = null;
		try {
			if(opt == null) {	//전체글의 개수
				sql = "SELECT count(*) FROM Notice_Board";
				pstmt = con.prepareStatement(sql);
				
			} else if(opt.equals("0")) { 		//제목으로 검색
				sql = "SELECT count(*) FROM Notice_Board WHERE Notice_Board_Title like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + condition + '%');
				
			} else if(opt.equals("1")) {		//내용으로 검색
				sql = "SELECT count(*) FROM Notice_Board WHERE Notice_Board_Content like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + condition + '%');
			}
				
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);	
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("공지사항ListCount 에러");
		} finally {
			try {
				if(rs!=null) {
					close(rs);
				}
				if(pstmt != null) {
					close(pstmt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listCount;
	}

	//공지사항 리스트 목록 가져오기
	public ArrayList<Notice_BoardBean> getNoticeBoardList(HashMap<String, Object> listOpt) {
		ArrayList<Notice_BoardBean> list = new ArrayList<Notice_BoardBean>();
		
		String opt = (String)listOpt.get("opt"); //검색옵션 
		String condition = (String)listOpt.get("condition"); //검색내용
		int start = (Integer)listOpt.get("start"); //현재 페이지 번호
		System.out.println("현재 페이지 번호 " + start);
		String sql = null;
		try {
			if(opt == null) {
				sql = "SELECT * FROM Notice_Board ORDER BY Notice_Board_Num DESC LIMIT ?,?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, start-1);
				pstmt.setInt(2, start+9);
				System.out.println(pstmt);
				
			} else if(opt.equals("0")) {		//제목으로 검색
				sql = "SELECT * FROM Notice_Board WHERE Notice_Board_Title like ?  "
					+ " ORDER BY Notice_Board_Num DESC LIMIT ?,?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + condition + '%');
				pstmt.setInt(2, start-1);
				pstmt.setInt(3, start+9);
				System.out.println(pstmt);
				
			} else if(opt.equals("1")) {	 //관리자(아이디) 로 검색
				sql = "SELECT * FROM Notice_Board WHERE Teacher_ID like ? "
					+ " ORDER BY Notice_Board_Num DESC LIMIT ?,?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, '%' + condition + '%');
				pstmt.setInt(2, start-1);
				pstmt.setInt(3, start+9);
				System.out.println(pstmt);
				
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice_BoardBean board = new Notice_BoardBean();
				board.setNotice_Board_Num(rs.getInt("Notice_Board_Num"));
				board.setTeacher_ID(rs.getString("Teacher_ID"));
				board.setNotice_Board_Title(rs.getString("Notice_Board_Title"));
				board.setNotice_Board_Date(rs.getDate("Notice_Board_Date"));
				board.setNotice_Board_Hit(rs.getString("Notice_Board_Hit"));
				board.setNotice_Board_Content(rs.getString("Notice_Board_Content"));
				list.add(board);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					close(rs);
				}
				if(pstmt != null) {
					close(pstmt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}


}
	
