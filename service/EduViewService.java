package edc.service;

import java.sql.Connection;

import dao.EdcDAO;

import static db.JdbcUtil.*;
import vo.EDCBean;

public class EduViewService {

	public static EDCBean getEduView(int edc_Num) {
		EDCBean edcBean = null;
		
		Connection con = null;
		try {
			con = getConnection();
			EdcDAO edcDao = EdcDAO.getinstance();
			edcDao.setConnection(con);
			
			edcBean = edcDao.selectEdc(edc_Num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
			
		}
		
		return edcBean;
	}

}
