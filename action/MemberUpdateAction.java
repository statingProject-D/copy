package member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.Service.MemberUpdateService;
import vo.ActionForward;
import vo.StudentMemberBean;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		ActionForward forward = null;
		
		if(id==null) {
			forward.setRedirect(true);
			forward.setPath("./Student_Login.me");
		}else {
			
			 
			  StudentMemberBean member = new StudentMemberBean();
			  member.setStu_Name(request.getParameter("name"));
			  member.setStu_Gender(request.getParameter("gender"));
			  member.setStu_Birth(request.getParameter("birth"));
			  member.setStu_Email(request.getParameter("email"));
			  member.setStu_Phone(request.getParameter("phone"));
			  member.setStu_Address(request.getParameter("address"));
			  member.setLecture_Time(request.getParameter("time"));
			  member.setStu_ID(request.getParameter("id"));
			  member.setStu_PW(request.getParameter("pw"));
			  member.setStu_Num(Integer.parseInt(request.getParameter("number")));
			  
			  
			  MemberUpdateService memberUpdateService = new MemberUpdateService();
			  boolean isModifySuccess = memberUpdateService.modifyMember(member);
			  
			  if(isModifySuccess) {
				  forward = new ActionForward(); 
				  forward.setRedirect(true);
				  
				  
				  forward.setPath("StudentView.me");
			  }else {
					response.setContentType("text/html;charset=utf-8");
					PrintWriter out = response.getWriter();
					out.println("<script>");
					out.println("alert('수정실패');");
					out.println("history.back();");
					out.println("</script>");
				}
		}
		return forward;
	}

}
