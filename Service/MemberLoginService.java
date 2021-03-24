package member.Service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.StudentDAO;
import vo.StudentMemberBean;

public class MemberLoginService {

	public boolean login(StudentMemberBean member) {
		Connection con = null;
		boolean loginResult = false;
		try {
			con = getConnection();
			StudentDAO studentDAO = StudentDAO.getInstance();
			studentDAO.setConnection(con);
			
			
			String loginId = studentDAO.studentLoginID(member);
			
			if(loginId != null) {
				loginResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		
		return loginResult;
	}

}
