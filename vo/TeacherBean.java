package vo;
//강사
public class TeacherBean {
	private String teacher_ID;//'강사_아이디',
	private int edc_Num;//'교육과정_번호',담당교육과정번호
	private String teacher_Name;//'강사_이름',
	private String teacher_Gender;//'강사_성별',
	private String teacher_Phone;//'강사_휴대전화',
	private String teacher_Grade;//'강사_등급',
	private String teacher_PW;//'강사_비밀번호',
	
	private boolean isTeacher; //강사 여부
	
	public int getEdc_Num() {
		return edc_Num;
	}
	public void setEdc_Num(int edc_Num) {
		this.edc_Num = edc_Num;
	}
	public String getTeacher_ID() {
		return teacher_ID;
	}
	public void setTeacher_ID(String teacher_ID) {
		this.teacher_ID = teacher_ID;
	}
	public String getTeacher_Name() {
		return teacher_Name;
	}
	public void setTeacher_Name(String teacher_Name) {
		this.teacher_Name = teacher_Name;
	}
	public String getTeacher_Gender() {
		return teacher_Gender;
	}
	public void setTeacher_Gender(String teacher_Gender) {
		this.teacher_Gender = teacher_Gender;
	}
	public String getTeacher_Phone() {
		return teacher_Phone;
	}
	public void setTeacher_Phone(String teacher_Phone) {
		this.teacher_Phone = teacher_Phone;
	}
	public String getTeacher_Grade() {
		return teacher_Grade;
	}
	public void setTeacher_Grade(String teacher_Grade) {
		this.teacher_Grade = teacher_Grade;
	}
	public String getTeacher_PW() {
		return teacher_PW;
	}
	public void setTeacher_PW(String teacher_PW) {
		this.teacher_PW = teacher_PW;
	}
	public boolean isTeacher() {
		return isTeacher;
	}
	public void setTeacher(boolean isTeacher) {
		this.isTeacher = isTeacher;
	}
	
	
	
}
