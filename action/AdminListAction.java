package admin.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminListService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;

public class AdminListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		ActionForward forward = null;
		
		if(sessionId == null) {					// 아이디가 없을 때
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Admin_LoginForm.ad");
		} else {							//아이디가 존재할때
			
			String opt = request.getParameter("opt");
			String condition = request.getParameter("condition");
			AdminListService adminListService = new AdminListService();
			
			//검색 조건과 내용을 Map 에 넣는다.
			
			HashMap<String, Object> listOpt = new HashMap<String, Object>();
			listOpt.put("opt", opt);
			listOpt.put("condition", condition);
			//페이지도 같이 넣음 (수정예정)
			
			ArrayList<TeacherBean> list = adminListService.getAdminList(listOpt);
			55555
			request.setAttribute("list", list);
			request.setAttribute("opt", opt); 									// select태그의 옵션 값이 고정되게 request에 담아줌
			request.setAttribute("contentPage", "/Admin/AdminListForm.jsp");		//관리자 리스트 폼 경로를 넣어줌
			forward = new ActionForward("AdminMainForm.ad",false);
			
		}
		return forward;
	}

}
