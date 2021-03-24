package vo;

import java.sql.Date;

//수강후기 게시판
public class Review_BoardBean {
	private int review_Board_Num;//'수강후기 게시판번호',
//	private int stu_Num;//'학생_번호',
	private String review_Board_Title;//'제목',
	private Date review_Board_Date;//'등록일',
	private String review_Board_Hit;//'조회수',
	private String review_Board_Content;//'내용',
	
	public int getReview_Board_Num() {
		return review_Board_Num;
	}
	public void setReview_Board_Num(int review_Board_Num) {
		this.review_Board_Num = review_Board_Num;
	}
//	public int getStu_Num() {
//		return stu_Num;
//	}
//	public void setStu_Num(int stu_Num) {
//		this.stu_Num = stu_Num;
//	}
	public String getReview_Board_Title() {
		return review_Board_Title;
	}
	public void setReview_Board_Title(String review_Board_Title) {
		this.review_Board_Title = review_Board_Title;
	}
	public Date getReview_Board_Date() {
		return review_Board_Date;
	}
	public void setReview_Board_Date(Date review_Board_Date) {
		this.review_Board_Date = review_Board_Date;
	}
	public String getReview_Board_Hit() {
		return review_Board_Hit;
	}
	public void setReview_Board_Hit(String review_Board_Hit) {
		this.review_Board_Hit = review_Board_Hit;
	}
	public String getReview_Board_Content() {
		return review_Board_Content;
	}
	public void setReview_Board_Content(String review_Board_Content) {
		this.review_Board_Content = review_Board_Content;
	}
	
	
	
	
}
