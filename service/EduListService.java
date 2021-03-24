package edc.service;
import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.EdcDAO;
import vo.EDCBean;

public class EduListService {

	public ArrayList<EDCBean> getEduList() {
		ArrayList<EDCBean> edcList = null;
		EdcDAO edcDAO = EdcDAO.getinstance();
		Connection con = null;
		
		try {
			con = getConnection();
			edcDAO.setConnection(con);
			edcList = edcDAO.selectEdcList();//edc db에서 모든 교육과정 정보 받아옴
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			close(con);
		}
		return edcList;
	}

}
