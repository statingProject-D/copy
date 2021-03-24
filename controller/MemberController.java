package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.action.*;
import vo.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.me")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		System.out.println("requestURI : " + RequestURI);
		System.out.println("contextPath : " + contextPath);
		System.out.println("command : " + command);
		
		if(command.equals("/Student_Login.me")) {//학생 로그인창페이지로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("pagefile", "/Student/StudentLoginForm.jsp");
			forward.setPath("index2.jsp");
		}else if (command.equals("/memberLoginAction.me")){//학생 로그인엑션이동
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/AcademyMain.me")) {//메인으로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			request.setAttribute("pagefile", "Main.jsp");
			forward.setPath("index2.jsp");
			
		}else if(command.equals("/StudentView.me")) {//학생정보수정폼으로 이동
			action = new MemberViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		//	forward.setPath("/Student/Student_Info.jsp");
		}else if(command.equals("/StudentUpdateForm.me")) {//학생정보수정폼으로 이동
			
			action = new MemberUpdateFormAction();
			try {
				forward = action.execute(request, response);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(command.equals("/StudentUpdate.me")) {//학생정보 업데이트
			action = new MemberUpdateAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/StudentLogout.me")) {//로그아웃
			action = new MemberLogoutAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		
		System.out.println("forward : " + forward.getPath());
		//페이지 이동
		if(forward != null) {
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}

}
