package admin.svc;

import java.sql.Connection;

import dao.AdminDAO;

import static db.JdbcUtil.*;
import vo.TeacherBean;
// 수정 폼에 들어갈 정보를 보여주게끔 하는 비지니스 로직 class
public class AdminModifyFormService {

	public TeacherBean getAdmin(String id) {		// 관리자(강사) 아이디로 관리자(강사) 정보를 불러오는 메서드
		TeacherBean teacher = null;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			
			teacher  = adminDAO.selectAdmin(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return teacher;
	}

}
