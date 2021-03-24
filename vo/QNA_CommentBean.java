package vo;

import java.sql.Date;

//질의응답 게시판댓글
public class QNA_CommentBean {
	private int qna_Com_Num ;// '댓글번호',
//	private String Teacher_ID;// '강사_아이디',
	private Date qna_Com_Date;// '등록일',
	private String qna_Com_Content;// '내용',
	private int qna_Com_Re_Ref;//'부모글넘버',
	private int qna_Com_lvl;//'댓글레벨',
	private int qna_Board_Num;//'질의응답 게시판 번호',
	
	public int getQna_Com_Num() {
		return qna_Com_Num;
	}
	public void setQna_Com_Num(int qna_Com_Num) {
		this.qna_Com_Num = qna_Com_Num;
	}
	public Date getQna_Com_Date() {
		return qna_Com_Date;
	}
	public void setQna_Com_Date(Date qna_Com_Date) {
		this.qna_Com_Date = qna_Com_Date;
	}
	public String getQna_Com_Content() {
		return qna_Com_Content;
	}
	public void setQna_Com_Content(String qna_Com_Content) {
		this.qna_Com_Content = qna_Com_Content;
	}
	public int getQna_Com_Re_Ref() {
		return qna_Com_Re_Ref;
	}
	public void setQna_Com_Re_Ref(int qna_Com_Re_Ref) {
		this.qna_Com_Re_Ref = qna_Com_Re_Ref;
	}
	public int getQna_Com_lvl() {
		return qna_Com_lvl;
	}
	public void setQna_Com_lvl(int qna_Com_lvl) {
		this.qna_Com_lvl = qna_Com_lvl;
	}
	public int getQna_Board_Num() {
		return qna_Board_Num;
	}
	public void setQna_Board_Num(int qna_Board_Num) {
		this.qna_Board_Num = qna_Board_Num;
	}
	
	
}
