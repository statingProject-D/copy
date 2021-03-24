package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import static db.JdbcUtil.*;
import vo.StudentMemberBean;

public class StudentDAO {
	public static StudentDAO stuDAO;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	private StudentDAO() {
		
	}
	public static StudentDAO getInstance(){
		if(stuDAO == null){
			stuDAO = new StudentDAO();
		}
		return stuDAO;
	}
	public void setConnection(Connection con){
		this.con = con;
	}
	public String studentLoginID(StudentMemberBean member) {
		String loginId = null;
		String sql = "select Stu_ID from StudentMember where Stu_ID =? and Stu_PW=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getStu_ID());
			pstmt.setString(2, member.getStu_PW());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginId = rs.getString("Stu_ID");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}
	public StudentMemberBean selectMember(String viewID) {
		String sql = "select * from StudentMember where Stu_ID =?";
		StudentMemberBean member = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, viewID);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			member = new StudentMemberBean();
			member.setStu_Num(rs.getInt("Stu_Num"));
			member.setStu_Name(rs.getString("Stu_Name"));
			member.setStu_Gender(rs.getString("Stu_Gender"));
			member.setStu_Birth(rs.getString("Stu_Birth"));
			member.setStu_ID(rs.getString("Stu_ID"));
			member.setStu_PW(rs.getString("Stu_PW"));
			member.setStu_Email(rs.getString("Stu_Email"));
			member.setStu_Phone(rs.getString("Stu_Phone"));
			member.setStu_Address(rs.getString("Stu_Address"));
			member.setLecture_Time(rs.getString("Lecture_Time"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}
	public int updateMember(StudentMemberBean member) {
		
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update StudentMember set stu_Name =?, stu_Gender =?, stu_Birth =?, stu_Email=?, stu_Phone=?, stu_Address =?, "
				+" lecture_Time=?, stu_ID=?, stu_PW=? where Stu_Num=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			System.out.println("id2 : " + member.getStu_Name());
			pstmt.setString(1, member.getStu_Name());
			pstmt.setString(2, member.getStu_Gender());
			pstmt.setString(3, member.getStu_Birth());
			pstmt.setString(4, member.getStu_Email());
			pstmt.setString(5, member.getStu_Phone());
			pstmt.setString(6, member.getStu_Address());
			pstmt.setString(7, member.getLecture_Time());
			pstmt.setString(8, member.getStu_ID());
			pstmt.setString(9, member.getStu_PW());
			pstmt.setInt(10, member.getStu_Num());
			
			
			updateCount = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return updateCount;
	}
	
}
