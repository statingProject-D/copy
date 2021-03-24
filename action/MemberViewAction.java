package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Service.MemberViewService;
import vo.ActionForward;
import vo.StudentMemberBean;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = null;
		
		if(id==null) {
			forward.setRedirect(true);
			forward.setPath("./Student_Login.me");
		}else {
			
			  forward = new ActionForward(); 
			  
			  
			  MemberViewService memberViewService = new MemberViewService();
			  StudentMemberBean member = memberViewService.getMember(id);
			  request.setAttribute("member", member);
			 
			  request.setAttribute("pagefile", "./Student/Student_Info.jsp");
				forward.setPath("./index2.jsp");
//			forward.setRedirect(false);
//			forward.setPath("./Student/Student_Info.jsp");
		}
		
		return forward;
	}

}
