package vo;

import java.sql.Date;
// 신청
public class RegistBean {
	private int regist_Num ;// '신청_번호',
//	private int edc_Num;// '교육과정_번호',
	private String regsit_Name;// '신청_이름',
	private String regist_Birth;//'신청_생년월일',
	private String regist_Phone ;//'신청_휴대전화',
	private String regist_Email;//'신청_이메일',
	private Date regist_Date;//'신청_날짜',
	private String regist_Pro_Check;//'신청_처리여부',
	private String regist_Check;// '신청_여부',
	private String regist_Content;//'신청_내용',
	
	public int getRegist_Num() {
		return regist_Num;
	}
	public void setRegist_Num(int regist_Num) {
		this.regist_Num = regist_Num;
	}
//	public int getEdc_Num() {
//		return edc_Num;
//	}
//	public void setEdc_Num(int edc_Num) {
//		this.edc_Num = edc_Num;
//	}
	public String getRegsit_Name() {
		return regsit_Name;
	}
	public void setRegsit_Name(String regsit_Name) {
		this.regsit_Name = regsit_Name;
	}
	public String getRegist_Birth() {
		return regist_Birth;
	}
	public void setRegist_Birth(String regist_Birth) {
		this.regist_Birth = regist_Birth;
	}
	public String getRegist_Phone() {
		return regist_Phone;
	}
	public void setRegist_Phone(String regist_Phone) {
		this.regist_Phone = regist_Phone;
	}
	public String getRegist_Email() {
		return regist_Email;
	}
	public void setRegist_Email(String regist_Email) {
		this.regist_Email = regist_Email;
	}
	public Date getRegist_Date() {
		return regist_Date;
	}
	public void setRegist_Date(Date regist_Date) {
		this.regist_Date = regist_Date;
	}
	public String getRegist_Pro_Check() {
		return regist_Pro_Check;
	}
	public void setRegist_Pro_Check(String regist_Pro_Check) {
		this.regist_Pro_Check = regist_Pro_Check;
	}
	public String getRegist_Check() {
		return regist_Check;
	}
	public void setRegist_Check(String regist_Check) {
		this.regist_Check = regist_Check;
	}
	public String getRegist_Content() {
		return regist_Content;
	}
	public void setRegist_Content(String regist_Content) {
		this.regist_Content = regist_Content;
	}
	
	
}
