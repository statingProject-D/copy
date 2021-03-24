package admin.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;
import vo.TeacherBean;

public class AdminDeleteService {
	
	public TeacherBean isAdmin(String id) {			//직원 중 관리자인 직원을 검색
		
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		TeacherBean teacher = adminDAO.selectAdmin(id);	//관리자(강사) 아이디로 관리자인지 구분
		close(con);
		return teacher;	
	}

	public boolean deleteAdmin(String id) {			//직원 삭제
		boolean deleteResult = false;
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		
		int deleteCount = adminDAO.deleteAdmin(id);
		if(deleteCount > 0) {
			commit(con);
			deleteResult = true;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return deleteResult;
	}
}