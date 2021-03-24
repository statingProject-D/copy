package admin.svc;

import java.sql.Connection;

import dao.AdminDAO;

import static db.JdbcUtil.*;
import vo.TeacherBean;
//관리자 정보를 수정하는 비즈니스 로직 class
public class AdminModifyService {

	public boolean modifyAdmin(TeacherBean teacher) {
		boolean isModifySuccess  = false;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			int updateCount = adminDAO.updateAdmin(teacher);
			
			if(updateCount > 0) {
				commit(con);
				isModifySuccess = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return isModifySuccess;
	}

}
