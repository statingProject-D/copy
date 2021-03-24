package edc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edc.service.EduViewService;
import member.action.Action;
import vo.ActionForward;
import vo.EDCBean;

public class EduViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		EDCBean edcBean = new EDCBean();
		int edc_Num = Integer.parseInt(request.getParameter("edc_Num"));
		edcBean = EduViewService.getEduView(edc_Num);
		
		request.setAttribute("edcBean", edcBean);
		
		ActionForward forward = new ActionForward();
		forward.setPath("education_view.jsp");
		
		return forward;
	}

}
