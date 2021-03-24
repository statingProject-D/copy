package member.Service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.StudentDAO;
import vo.StudentMemberBean;

public class MemberUPdateViewService {

	public StudentMemberBean getMember(String id) {
		Connection con = null;
		StudentMemberBean member =null;
		
		try {
			con = getConnection();
			StudentDAO studentDAO = StudentDAO.getInstance();
			studentDAO.setConnection(con);
			 member = studentDAO.selectMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return member;
	}

}
