package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.action.AdminDeleteAction;
import admin.action.AdminDetailAction;
import admin.action.AdminListAction;
import admin.action.AdminLoginAction;
import admin.action.AdminModifyAction;
import admin.action.AdminModifyFormAction;
import admin.action.AdminRegisterAction;
import admin.action.AdminRegisterFormAction;
import board.action.NoticeBoardListFormAction;
import member.action.Action;
import vo.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		 // 넘어온 커맨드를 추출하는 과정
		response.setContentType("text/html;charset=utf-8");
        String requestURI = request.getRequestURI();
        int cmdIdx = requestURI.lastIndexOf("/")+1;
        
        String command = requestURI.substring(cmdIdx);

		ActionForward forward = null;
		Action action = null;
		
		  //URI, command 확인
        System.out.println("requestURI : "+requestURI);
        System.out.println("command : "+command);

        
        
		
		if(command.equals("NoticeBoardListFormAction.bo")) {		//공지사항 폼으로 이동
			action = new NoticeBoardListFormAction();				
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		} else if(command.equals("AdminMainForm.ad")) {				//관리자 메인폼으로 이동
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("Admin/AdminMain.jsp");
		
			
		} else if(command.equals("index.ad")) {						//홈페이지 메인홈페이지로 이동(관리자 아이디 세션을 담아서)
			forward = new ActionForward();
			forward.setRedirect(false);
			HttpSession session = request.getSession();
			System.out.println(session.getAttribute("sessionId"));
			forward.setPath("/index.jsp");	
			
		} else if(command.equals("AdminListForm.ad")) {				// 관리자 리스트 폼으로 이동		//수정예정
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("AdminListForm.jsp");
			
		} else if(command.equals("AdminLogout.ad")) {				//관리자 로그아웃
			forward = new ActionForward();
			HttpSession session = request.getSession();
			session.removeAttribute("sessionId");
			forward.setRedirect(true);
			forward.setPath("Admin_LoginForm.ad");
			
		} else if(command.equals("AdminModifyFormAction.ad")) {			//관리자 정보 수정 폼으로 이동후 정보화면출력
			action = new AdminModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
		} else if(command.equals("AdminRegisterFormAction.ad")) {		//관리자 직원 등록 폼으로 이동
			action = new AdminRegisterFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			
			/* 각종 처리 */
		} else if(command.equals("AdminListAction.ad")) {			//관리자 리스트 화면 처리
			action = new AdminListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("AdminDetailAction.ad")) {			//관리자 상세화면 처리
			action = new AdminDetailAction();
			try {
				forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("AdminModifyAction.ad")) {			//관리자 정보수정 처리
			action = new AdminModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("AdminRegisterAction.ad")) {  		//관리자 직원 등록 처리
			action = new AdminRegisterAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("AdminDeleteAction.ad")) {			//관리자 직원 삭제 처리
			action = new AdminDeleteAction();			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("AdminLoginAction.ad")) {		//관리자 로그인 했을 때의 처리 -> 성공시 관리자 메인페이지로이동
			action = new AdminLoginAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		System.out.println("forward : " + forward.getPath());
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
