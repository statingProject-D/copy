package member.Service;
import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.StudentDAO;
import vo.StudentMemberBean;

public class MemberViewService {

	public StudentMemberBean getMember(String viewID) {
		Connection con = null;
		StudentMemberBean member =null;
		
		try {
			con = getConnection();
			StudentDAO studentDAO = StudentDAO.getInstance();
			studentDAO.setConnection(con);
			 member = studentDAO.selectMember(viewID);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return member;
	}

}
