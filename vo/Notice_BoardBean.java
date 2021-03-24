package vo;

import java.sql.Date;

//공지사항 게시판
public class Notice_BoardBean {
	private int notice_Board_Num;  //'공지사항 게시판번호',
	private String teacher_ID ;// '강사_아이디',
	private String notice_Board_Title ;// '제목',
	private Date notice_Board_Date ;// '등록일',
	private String notice_Board_Hit ;// '조회수',
	private String notice_Board_Content ;// '내용'
	
	
	
	public String getTeacher_ID() {
		return teacher_ID;
	}
	public void setTeacher_ID(String teacher_ID) {
		this.teacher_ID = teacher_ID;
	}
	public int getNotice_Board_Num() {
		return notice_Board_Num;
	}
	public void setNotice_Board_Num(int notice_Board_Num) {
		this.notice_Board_Num = notice_Board_Num;
	}
	public String getNotice_Board_Title() {
		return notice_Board_Title;
	}
	public void setNotice_Board_Title(String notice_Board_Title) {
		this.notice_Board_Title = notice_Board_Title;
	}
	public Date getNotice_Board_Date() {
		return notice_Board_Date;
	}
	public void setNotice_Board_Date(Date notice_Board_Date) {
		this.notice_Board_Date = notice_Board_Date;
	}
	public String getNotice_Board_Hit() {
		return notice_Board_Hit;
	}
	public void setNotice_Board_Hit(String notice_Board_Hit) {
		this.notice_Board_Hit = notice_Board_Hit;
	}
	public String getNotice_Board_Content() {
		return notice_Board_Content;
	}
	public void setNotice_Board_Content(String notice_Board_Content) {
		this.notice_Board_Content = notice_Board_Content;
	}
	
	
}
