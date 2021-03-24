package admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.svc.AdminModifyService;
import member.action.Action;
import vo.ActionForward;
import vo.TeacherBean;

public class AdminModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward  = null;
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("sessionId");
//		String page = request.getParameter("page");
		response.setContentType("text;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(sessionId == null) {		//관리자 아이디 세션이 존재하지 않을 경우
			
			out.println("<script>");
			out.println("alert('관리자 재로그인이 필요합니다.!!')");
    		out.println("location.href='/Admin/AdminLoginForm.jsp'");
    		out.println("</script>");
    		out.flush();
    		out.close();
		} else {
			request.setCharacterEncoding("utf-8");
			TeacherBean teacher = new TeacherBean();
			teacher.setTeacher_ID(request.getParameter("id"));  					//아이디
			teacher.setTeacher_PW(request.getParameter("password"));
			teacher.setEdc_Num(Integer.parseInt(request.getParameter("num")));		//교육과정 번호
			teacher.setTeacher_Name(request.getParameter("name"));					//이름
			teacher.setTeacher_Gender(request.getParameter("gender")); 				//성별
			teacher.setTeacher_Phone(request.getParameter("phone"));   				//전화번호
			String[] grade = request.getParameterValues("grade");		//등급의 각 파라미터로 온 것을 구분
			
			System.out.println(request.getParameter("name"));
			System.out.println(request.getParameter("gender"));
			System.out.println(request.getParameter("phone"));
			
			for(String gr : grade) {
				teacher.setTeacher_Grade(gr);
				System.out.println(gr + "으로 변경");
			}
			
			AdminModifyService adminModifyService = new AdminModifyService();
			boolean isModifySuccess = adminModifyService.modifyAdmin(teacher);
			
			if(isModifySuccess) {		//수정성공시
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("AdminDetailAction.ad?id="+ teacher.getTeacher_ID());// + "&page="+ page추가예정
			} else {
				out.println("<script>");
				out.println("alert('수정실패')");
				out.println("history.back();");
	    		out.println("</script>");
			}
			
		}
		
		
		return forward;
	}

}
