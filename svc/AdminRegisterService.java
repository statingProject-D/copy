package admin.svc;

import dao.AdminDAO;
import vo.TeacherBean;
import static db.JdbcUtil.*;

import java.sql.Connection;

public class AdminRegisterService {

	public boolean registAdmin(TeacherBean teacher) {  //직원등록
		boolean registSuccess = false;
		Connection con = null;
		
		try {
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			int insertCount = adminDAO.insertAdmin(teacher);
			
			if(insertCount > 0) {
				commit(con);
				registSuccess = true;
				System.out.println("직원 등록 완료");
			} else {
				rollback(con);
				System.out.println("직원 등록 실패");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con);
		}
		return registSuccess;
	}

}
