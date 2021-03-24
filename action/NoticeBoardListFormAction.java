package board.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.svc.BoardListService;
import member.action.Action;
import vo.ActionForward;
import vo.Notice_BoardBean;
import vo.PageInfo;
//공지사항 리스트 보여주기 action 클래스
public class NoticeBoardListFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int spage = 1;
		String page = request.getParameter("page");
		
		if(page != null) {
			spage = Integer.parseInt(page);
		}
		
		//검색옵션 
		String opt = request.getParameter("opt");		//옵션
		String condition = request.getParameter("condition"); //내용
		
		//검색조건과 내용을 MAP에 담음
		
		HashMap<String, Object> listOpt = new HashMap<String, Object>();
		listOpt.put("opt", opt);
		listOpt.put("condition", condition);
		listOpt.put("start", spage*10-9);
		
		BoardListService boardListService = new BoardListService();
		
		//공지사항 글 갯수 구하기
		int listCount = boardListService.getNoticeBoardListCount(listOpt); 
		ArrayList<Notice_BoardBean> list = boardListService.getNoticeBoardList(listOpt);
		//전체 페이지수 
		int maxPage = (int)(listCount/10.0 + 0.9);
		//시작 페이지수
		int startPage = (int)(spage/5.0 + 0.8) * 5 -4;
		// 마지막 페이지수 
		int endPage = startPage + 4;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(spage);
		pageInfo.setStartPage(startPage);
		

		
		request.setAttribute("pageInfo", pageInfo);
		//글 총 수와 글목록 저장
		request.setAttribute("list", list);
		request.setAttribute("opt", opt); 
		request.setAttribute("contentPage", "/Board/NoticeBoard.jsp");		//공지사항 게시판을 관리자메인에넣어줌
		forward = new ActionForward("AdminMainForm.ad",false);
		return forward;
	}

}
