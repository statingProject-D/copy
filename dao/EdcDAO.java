package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.EDCBean;

public class EdcDAO {
	Connection con;
	private static EdcDAO edcDAO;
	


	public static EdcDAO getinstance() {
		if(edcDAO == null) {
			edcDAO = new EdcDAO();
		}
		return edcDAO;
	}

	public void setConnection(Connection con2) {
		this.con = con2;
		
	}
	
	//db에서 교육과정 정보 얻어오기
	public ArrayList<EDCBean> selectEdcList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EDCBean> edcList = null;
		
		try {
			pstmt = con.prepareStatement("select * from EDC");
			rs = pstmt.executeQuery();
			
			
			
			
			if(rs.next()) {
				
				edcList = new ArrayList<EDCBean>();
				do {
					EDCBean edcBean =new EDCBean();
					edcBean.setEdc_Num(rs.getInt("edc_Num"));// '교육과정_번호',
					edcBean.setEdc_Subject(rs.getString("edc_Subject"));// '교육과정_과목명',
					edcBean.setEdc_Place(rs.getString("edc_Place"));//'교육과정_장소',
					edcBean.setEdc_Time(rs.getString("edc_Time"));// '교육과정_시간',
					edcBean.setEdc_PD(rs.getString("edc_PD"));//'교육과정_기간',
					edcBean.setEdc_NMPR(rs.getString("edc_NMPR"));// '교육과정_모집인원',
					edcBean.setEdc_Photo(rs.getString("edc_Photo"));//'교육과정_사진',
					edcBean.setEdc_Content(rs.getString("edc_Content"));// '교육과정_내용',
					
					
					
					
					edcList.add(edcBean); //bean객체 리스트에 추가
				}while (rs.next()); 
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			close(rs);
			close(pstmt);
		}
		return edcList;
	}

	public EDCBean selectEdc(int edc_Num) {
		EDCBean edcBean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from EDC where edc_Num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, edc_Num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				edcBean =new EDCBean();
				edcBean.setEdc_Num(rs.getInt("edc_Num"));// '교육과정_번호',
				edcBean.setEdc_Subject(rs.getString("edc_Subject"));// '교육과정_과목명',
				edcBean.setEdc_Place(rs.getString("edc_Place"));//'교육과정_장소',
				edcBean.setEdc_Time(rs.getString("edc_Time"));// '교육과정_시간',
				edcBean.setEdc_PD(rs.getString("edc_PD"));//'교육과정_기간',
				edcBean.setEdc_NMPR(rs.getString("edc_NMPR"));// '교육과정_모집인원',
				edcBean.setEdc_Photo(rs.getString("edc_Photo"));//'교육과정_사진',
				edcBean.setEdc_Content(rs.getString("edc_Content"));// '교육과정_내용',
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return edcBean;
	}

	

}
