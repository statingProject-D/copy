package edc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edc.service.EduListService;
import member.action.Action;
import vo.ActionForward;
import vo.EDCBean;
// 모달창(검색)교육과정 리스트 action 클래스
public class EduSearchListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EduListService eduListService = new EduListService();
		
		ArrayList<EDCBean> eduList = eduListService.getEduList();//교육과정 edc 리스트 생성 서비스에 요청
		
		request.setAttribute("eduList", eduList);//받아온 교육과정 리스트 추가
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/EDC/EDC_Search.jsp");
		return forward;
	}

}
