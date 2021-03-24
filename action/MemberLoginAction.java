package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Service.MemberLoginService;
import vo.ActionForward;
import vo.StudentMemberBean;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		StudentMemberBean member = new StudentMemberBean();
		
		
		
		//getParmater로 넘어온 id pw 저장
		member.setStu_ID(request.getParameter("MEMBER_ID"));
		member.setStu_PW(request.getParameter("MEMBER_PW"));
		
		MemberLoginService memberLoginService = new MemberLoginService();
		//member넘겨 로그인 여부 확인
		boolean logoinResult = memberLoginService.login(member);
		ActionForward forward = null;
		
		//로그인시 세션ID저장후 이동
		if(logoinResult) {
			forward = new ActionForward();
			session.setAttribute("id", member.getStu_ID());
			System.out.println("학생" + session.getAttribute("id"));
			forward.setRedirect(true);
			forward.setPath("StudentView.me");
			
		}else {//로그인 실패시 경고창 실행
			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('로그인 실패');");
	   		out.println("location.href='./Student_Login.me';");
	   		out.println("</script>");
		}
		
		return forward;
	}

}
