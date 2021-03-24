package vo;

import java.sql.Date;

//질의응답 게시판
public class QNA_BoardBean {
	private int qna_Board_Num ;// '질의응답 게시판 번호',
	private String qna_Board_Name ;//'등록자이름',
	private String qna_Board_Password ;// '등록자비밀번호',
	private String qna_Board_Title;// '제목',
	private Date qna_Board_Date ;// '등록일',
	private String qna_Board_Hit;// '조회수',
	private String qna_Board_Content;//'내용'
	
	public int getQna_Board_Num() {
		return qna_Board_Num;
	}
	public void setQna_Board_Num(int qna_Board_Num) {
		this.qna_Board_Num = qna_Board_Num;
	}
	public String getQna_Board_Name() {
		return qna_Board_Name;
	}
	public void setQna_Board_Name(String qna_Board_Name) {
		this.qna_Board_Name = qna_Board_Name;
	}
	public String getQna_Board_Password() {
		return qna_Board_Password;
	}
	public void setQna_Board_Password(String qna_Board_Password) {
		this.qna_Board_Password = qna_Board_Password;
	}
	public String getQna_Board_Title() {
		return qna_Board_Title;
	}
	public void setQna_Board_Title(String qna_Board_Title) {
		this.qna_Board_Title = qna_Board_Title;
	}
	public Date getQna_Board_Date() {
		return qna_Board_Date;
	}
	public void setQna_Board_Date(Date qna_Board_Date) {
		this.qna_Board_Date = qna_Board_Date;
	}
	public String getQna_Board_Hit() {
		return qna_Board_Hit;
	}
	public void setQna_Board_Hit(String qna_Board_Hit) {
		this.qna_Board_Hit = qna_Board_Hit;
	}
	public String getQna_Board_Content() {
		return qna_Board_Content;
	}
	public void setQna_Board_Content(String qna_Board_Content) {
		this.qna_Board_Content = qna_Board_Content;
	}
	
	
}
