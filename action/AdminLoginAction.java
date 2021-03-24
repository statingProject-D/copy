package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminLoginService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;
//관리자 로그인 처리 action
public class AdminLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		TeacherBean teacher = new TeacherBean();
		
		teacher.setTeacher_ID(request.getParameter("Admin_ID"));			//teacher 빈에다가 넣어준다
		teacher.setTeacher_PW(request.getParameter("Admin_PW"));
		
		AdminLoginService adminLoginService = new AdminLoginService();
		boolean loginResult = adminLoginService.login(teacher);				//로그인 시 처리 
		ActionForward forward = null;
		
		if(loginResult) {
			forward = new ActionForward();
			session.setAttribute("sessionId", teacher.getTeacher_ID());
			forward.setRedirect(true);
			forward.setPath("AdminMainForm.ad");							//로그인 성공시 관리자 메인으로 이동한다.
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			System.out.println("로그인실패");
			out.println("<script>");
			out.println("alert('로그인 실패');");
			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("Admin_LoginForm.ad");
		}
		
		return forward;
	}

}
