package admin.svc;

import java.sql.Connection;

import dao.AdminDAO;

import static db.JdbcUtil.*;
import vo.TeacherBean;
//관리자(정보) 상세보기 비즈니스 로직
public class AdminDetailService {

	public TeacherBean getAdmin(String adminId) {				//관리자(강사) 아이디로 정보조회후 정보불러오기
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		TeacherBean teacher = adminDAO.selectAdmin(adminId);	//관리자(강사) 아이디로 정보조회
		close(con);
		return teacher;											//빈 객체 반환
	}

}
