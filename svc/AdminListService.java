package admin.svc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.AdminDAO;
import vo.TeacherBean;
import static db.JdbcUtil.*;
public class AdminListService {

	public ArrayList<TeacherBean> getTeacherList() {	//강사 리스트 조회 
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		ArrayList<TeacherBean> teacherList = adminDAO.selectTeacherList();
		close(con);
		return teacherList;
	}

	public ArrayList<TeacherBean> getAllList() {		// 관리자, 강사, 상담사 전체 조회
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		ArrayList<TeacherBean> allList = adminDAO.selectAllList();
		close(con);
		return allList;
	}

	public ArrayList<TeacherBean> getAdminList(HashMap<String, Object> listOpt) {		//직원 리스트 옵션 검색 기능
		Connection con = getConnection();
		AdminDAO adminDAO = AdminDAO.getInstance();
		adminDAO.setConnection(con);
		ArrayList<TeacherBean> list = adminDAO.getAdminList(listOpt);
		close(con);
		return list;
	}


}
