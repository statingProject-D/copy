package member.Service;

import java.sql.Connection;

import dao.StudentDAO;

import static db.JdbcUtil.*;
import vo.StudentMemberBean;

public class MemberUpdateService {

	public boolean modifyMember(StudentMemberBean member) {
		boolean isModifySucess = false;
		Connection con = null;
		
		try {
			con = getConnection();
			StudentDAO memberDAO = StudentDAO.getInstance();
			memberDAO.setConnection(con);
			
			int updateCount = memberDAO.updateMember(member);
			
			if(updateCount > 0) {
				isModifySucess = true;
				commit(con);
			}else {
				isModifySucess = false;
				rollback(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isModifySucess;
	}

}
