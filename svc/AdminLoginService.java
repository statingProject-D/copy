package admin.svc;
import static db.JdbcUtil.*;
import java.sql.Connection;
// 관리자 로그인 처리 비즈니스 클래스
import dao.AdminDAO;
import vo.TeacherBean;

public class AdminLoginService {
	
	public boolean login(TeacherBean teacher) {			//관리자 로그인 처리
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		boolean loginResult = false;
		String loginId = adminDAO.selectLoginId(teacher);
		
		if(loginId != null) {
			System.out.println("관리자 아이디 확인");
			loginResult = true;
		}
		close(con);
		return loginResult;
	}
}
