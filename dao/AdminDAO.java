package dao;
import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import vo.TeacherBean;
public class AdminDAO {
	public static AdminDAO instance;	//싱글톤패턴
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private AdminDAO() {
		
	}
	
	public static AdminDAO getInstance() {
		if(instance == null) {
			instance = new AdminDAO();
		}
		return instance;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(TeacherBean teacher) {		//관리자인지 아닌지 관리자 아이디 검색
		String loginId = null;
		String sql = "SELECT Teacher_ID FROM Teacher WHERE Teacher_ID = ? AND Teacher_PW = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacher_ID());
			pstmt.setString(2, teacher.getTeacher_PW());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("Teacher_ID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

	public ArrayList<TeacherBean> selectTeacherList() {					// 관리자(강사) 리스트 불러오기
		String sql = "SELECT * FROM Teacher WHERE Teacher_Grade = 0";	//0일때 강사
		ArrayList<TeacherBean> teacherList = new ArrayList<TeacherBean>();
		TeacherBean teacher = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					teacher = new TeacherBean();
					teacher.setTeacher_ID(rs.getString("Teacher_ID"));
					teacher.setTeacher_PW(rs.getString("Teacher_PW"));
					teacher.setTeacher_Name(rs.getString("Teacher_Name"));
					teacher.setTeacher_Gender(rs.getString("Teacher_Gender"));
					teacher.setTeacher_Phone(rs.getString("Teacher_Phone"));
					teacher.setTeacher_Grade(rs.getString("Teacher_Grade"));
					teacherList.add(teacher);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("강사 리스트 불러오기 실패");
		} finally {
			close(rs);
			close(pstmt);
		}
		return teacherList;
	}

	public ArrayList<TeacherBean> selectAllList() {
		String sql = "SELECT * FROM Teacher";	// 전체 조회
		ArrayList<TeacherBean> allList = new ArrayList<TeacherBean>();
		TeacherBean teacher = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					teacher = new TeacherBean();
					teacher.setTeacher_ID(rs.getString("Teacher_ID"));
					teacher.setTeacher_PW(rs.getString("Teacher_PW"));
					teacher.setTeacher_Name(rs.getString("Teacher_Name"));
					teacher.setTeacher_Gender(rs.getString("Teacher_Gender"));
					teacher.setTeacher_Phone(rs.getString("Teacher_Phone"));
					teacher.setTeacher_Grade(rs.getString("Teacher_Grade"));
					allList.add(teacher);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("전체 리스트 불러오기 실패");
		} finally {
			close(rs);
			close(pstmt);
		}
		return allList;
	}

	public TeacherBean selectAdmin(String id) {				//관리자(강사)아이디로 정보조횐
		String sql = "SELECT * FROM Teacher WHERE Teacher_ID = ?";
		TeacherBean teacher = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				teacher = new TeacherBean();
				teacher.setTeacher_ID(rs.getString("Teacher_ID"));
				teacher.setEdc_Num(rs.getInt("EDC_Num"));		//교육과정 번호
				teacher.setTeacher_PW(rs.getString("Teacher_PW"));
				teacher.setTeacher_Name(rs.getString("Teacher_Name"));
				teacher.setTeacher_Gender(rs.getString("Teacher_Gender"));
				teacher.setTeacher_Phone(rs.getString("Teacher_Phone"));
				teacher.setTeacher_Grade(rs.getString("Teacher_Grade"));
			}
			System.out.println("정보 조회 완료");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("정보 상세보기 에러");
		} finally {
			if(rs!=null) {
				close(rs);
			}
			if(pstmt!=null) {
				close(pstmt);
			}
		}
		return teacher;
	}

	public int updateAdmin(TeacherBean teacher) {			//관리자 정보 수정
		int updateCount = 0;
		
		String sql = "   UPDATE Teacher SET Teacher_ID = ?, EDC_Num = ?     "
					+ "                   , Teacher_PW = ?, Teacher_Name = ?"
				    + "					  ,	Teacher_Gender = ?, Teacher_Phone = ?"
				    + "					  ,	Teacher_Grade = ? "
				    + "	 WHERE Teacher_ID = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacher_ID());
			pstmt.setInt(2, teacher.getEdc_Num());
			pstmt.setString(3, teacher.getTeacher_PW());
			pstmt.setString(4, teacher.getTeacher_Name());
			pstmt.setString(5, teacher.getTeacher_Gender());
			pstmt.setString(6, teacher.getTeacher_Phone());
			pstmt.setString(7, teacher.getTeacher_Grade());
			pstmt.setString(8, teacher.getTeacher_ID());
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					close(pstmt);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updateCount;
	}

	public int insertAdmin(TeacherBean teacher) {			//직원 등록
		String sql = "INSERT INTO Teacher VALUES(?,?,?,?,?,?,?)";
		int insertCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacher_ID());
			pstmt.setInt(2, teacher.getEdc_Num());
			pstmt.setString(3, teacher.getTeacher_PW());
			pstmt.setString(4, teacher.getTeacher_Name());
			pstmt.setString(5, teacher.getTeacher_Gender());
			pstmt.setString(6, teacher.getTeacher_Phone());
			pstmt.setString(7, teacher.getTeacher_Grade());
			
			insertCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("insertAdmin 에러");
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					close(pstmt);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount;
	}

	public int deleteAdmin(String id) {				//직원 삭제
		String sql = "DELETE FROM Teacher WHERE Teacher_ID = ?";
		int deleteCount = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
			
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println("직원 삭제 오류");
		} finally {
			try {
				if(pstmt!=null) {
					close(pstmt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return deleteCount;
	}

	public ArrayList<TeacherBean> getAdminList(HashMap<String, Object> listOpt) {
		ArrayList<TeacherBean> list = new ArrayList<TeacherBean>();
		
		String opt = (String)listOpt.get("opt");            //검색옵션(아이디,이름,등급);
		String condition = (String)listOpt.get("condition");//검색내용	
															//페이지 처리
		String grade = null;
		String sql = null;
		
		try {
			 if(opt == null) {							//검색옵션이 없으면	
				 sql = "SELECT * FROM Teacher" ;		//직원목록 전체 보여주기
				 
				 pstmt = con.prepareStatement(sql);
			 } else if(opt.equals("0")) {				//검색옵션이 아이디일경우
				 sql = "SELECT * FROM Teacher WHERE Teacher_ID like ? ";
				 pstmt = con.prepareStatement(sql);
				 pstmt.setString(1, "%"+condition+"%");
				 
			 } else if(opt.equals("1")) {				//검색옵션이 이름일경우
				 sql = "SELECT * FROM Teacher WHERE Teacher_Name like ?";
				 pstmt = con.prepareStatement(sql);
				 pstmt.setString(1, "%"+condition+"%");
				 
			 } else if(opt.equals("2")) {
				 sql = "SELECT * FROM Teacher WHERE Teacher_Grade = ? " ;  //검색옵션이 등급일경우
				 
					 if(condition.equals("관리자")) {
						 grade = "2";
					 } else if(condition.equals("상담원")) {
						 grade = "1";
					 } else if(condition.equals("강사")) {
						 grade = "0";
					 }
				 System.out.println("내용 " + condition);
				 pstmt = con.prepareStatement(sql);
				 pstmt.setString(1, grade);
				 
			 }
			 
			 rs = pstmt.executeQuery();
			 
			 while(rs.next()) {
				 	TeacherBean teacher = new TeacherBean();
				 	teacher.setTeacher_ID(rs.getString("Teacher_ID"));
				 	teacher.setEdc_Num(rs.getInt("EDC_Num"));
				 	teacher.setTeacher_PW(rs.getString("Teacher_PW"));
				 	teacher.setTeacher_Name(rs.getString("Teacher_Name"));
				 	teacher.setTeacher_Phone(rs.getString("Teacher_Gender"));
				 	teacher.setTeacher_Gender(rs.getString("Teacher_Phone"));
				 	teacher.setTeacher_Grade(rs.getString("Teacher_Grade"));
				 	list.add(teacher);
				 	
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					close(rs);
				}
				if(pstmt!=null) {
					close(pstmt);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	

}	
