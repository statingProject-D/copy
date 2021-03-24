package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminDeleteService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;

public class AdminDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");	//관리자 세션
		System.out.println("세션 아이디 " + sessionId);
		ActionForward forward = null;
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		AdminDeleteService adminDeleteService = new AdminDeleteService();
		TeacherBean teacher = adminDeleteService.isAdmin(sessionId);
		
		System.out.println(sessionId + "의 등급의 값은 " + teacher.getTeacher_Grade());
		if(sessionId == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("Admin_LoginForm.ad");
			
		} else {
			System.out.println("지금 이 아이디의 등급은 " + teacher.getTeacher_Grade());
			
			if(!teacher.getTeacher_Grade().equals("2")) {		//관리자 등급이 아닐때
			out.println("<script>");
			out.println("alert('관리자 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
			} else {			//관리자일때
				String id = request.getParameter("id");							//직원 아이디 를 파라미터로 받아옴
				boolean deleteResult = adminDeleteService.deleteAdmin(id);
				
					if(deleteResult) {
						out.println("<script> ");
						out.println("alert('직원정보를 삭제하였습니다.');");
						out.println("history.back();");
						out.println("</script>");
						out.flush();
						out.close();
						forward = new ActionForward();
						forward.setRedirect(true);
						forward.setPath("AdminListAction.ad"); 				//직원 리스트로 이동
						
					} else  {
						out.println("<script>");
						out.println("alert('직원정보삭제 실패.');");
						out.println("location.href='AdminListAction.ad';");
						out.println("</script>");
					}
				
				}
			}
			return forward;
		}

}
