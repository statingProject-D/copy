package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminModifyFormService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;
// 관리자 정보 수정 action 클래스 
// 관리자 정보수정 폼이 따로 존재하므로 생성
public class AdminModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		ActionForward forward = null;
		
		if(sessionId == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Admin_LoginForm.ad");  //관리자 로그인 페이지로 이동
		} else {
			
			String id = request.getParameter("id");
			
			AdminModifyFormService adminModifyFormService = new AdminModifyFormService();
			TeacherBean teacher = adminModifyFormService.getAdmin(id);
			request.setAttribute("teacher", teacher);
//			request.setAttribute("page", page);										//페이지 넣어야함
			request.setAttribute("contentPage", "/Admin/AdminModifyForm.jsp");		//관리자 정보수정 폼 경로를 넣어줌
			forward = new ActionForward("AdminMainForm.ad",false);
		}
		return forward;
	}

}
