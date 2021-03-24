package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminDetailService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;
// 관리자 리스트 상세보기 action 클래스
public class AdminDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");		//강사 아이디 세션
		
		ActionForward forward = null;
		if(sessionId == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Admin_LoginForm.ad");
		} else {
			String id = request.getParameter("id");	//AdminListForm 에서 강사아이디 값을 파라미터로 받아옴
			AdminDetailService adminDetailService = new AdminDetailService();
			TeacherBean teacher = adminDetailService.getAdmin(id);		//강사아이디의 이름으로 db에서 값 불러오기
			request.setAttribute("teacher", teacher);
			request.setAttribute("contentPage", "/Admin/AdminDetailForm.jsp");		//관리자 상세보기 폼 경로를 넣어줌
			forward = new ActionForward("AdminMainForm.ad",false);
		}
		return forward;
	}

}
