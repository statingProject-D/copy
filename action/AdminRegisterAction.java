package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminRegisterService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;
//직원 등록하는 action 클래스
public class AdminRegisterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("sessionId");
		ActionForward forward = null;
		TeacherBean teacher = new TeacherBean();
		boolean registResult = false;
		
		if(sessionId == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Admin_LoginForm.ad");  //관리자 로그인 페이지로 이동
		}
		teacher.setTeacher_ID(request.getParameter("id"));
		teacher.setEdc_Num((Integer.parseInt(request.getParameter("search"))));
		teacher.setTeacher_PW(request.getParameter("password"));
		teacher.setTeacher_Name(request.getParameter("name"));
		teacher.setTeacher_Gender(request.getParameter("gender"));
		teacher.setTeacher_Phone(request.getParameter("tel"));
		teacher.setTeacher_Grade(request.getParameter("grade"));
		
		
		AdminRegisterService adminRegisterService = new AdminRegisterService();
		registResult = adminRegisterService.registAdmin(teacher);
		
		
		if(registResult == false) {
			response.setContentType("text/html;charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('직원등록실패')");
   			out.println("history.back()");
   			out.println("</script>");
		} else {
			response.setContentType("text/html;charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('직원이 성공적으로 등록되었습니다.')");
   			out.println("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./AdminListAction.ad");
		}
		
		return forward;
	}

}
