package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		ActionForward forward = null;
		
		
		System.out.println(session.getAttribute("id"));
		if(session.getAttribute("id") == null) {
			System.out.println("id : null" );
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인하세요');");
			out.println("location.href='./Student_Login.me';");
			out.println("</script>");
		}else {
			System.out.println("id : not null" );
			session.invalidate();
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("Student_Login.me");
		}
		return forward;
	}

}
