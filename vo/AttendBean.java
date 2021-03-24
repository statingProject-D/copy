package vo;

import java.sql.Date;

//출석
public class AttendBean {
//	private int stu_Num ;// '학생_번호',
	private int attend_Check ; // '출석체크',
	private int attend_Late;  // '지각체크',
	private int attend_Leave;  // '결석체크',
	private int attend_Day ; //'출석일수',
	private Date attend_StartTime ; // '입실시간',
	private Date attend_endTime; // '퇴실시간',
	public int getAttend_Check() {
		return attend_Check;
	}
	public void setAttend_Check(int attend_Check) {
		this.attend_Check = attend_Check;
	}
	public int getAttend_Late() {
		return attend_Late;
	}
	public void setAttend_Late(int attend_Late) {
		this.attend_Late = attend_Late;
	}
	public int getAttend_Leave() {
		return attend_Leave;
	}
	public void setAttend_Leave(int attend_Leave) {
		this.attend_Leave = attend_Leave;
	}
	public int getAttend_Day() {
		return attend_Day;
	}
	public void setAttend_Day(int attend_Day) {
		this.attend_Day = attend_Day;
	}
	public Date getAttend_StartTime() {
		return attend_StartTime;
	}
	public void setAttend_StartTime(Date attend_StartTime) {
		this.attend_StartTime = attend_StartTime;
	}
	public Date getAttend_endTime() {
		return attend_endTime;
	}
	public void setAttend_endTime(Date attend_endTime) {
		this.attend_endTime = attend_endTime;
	}
	
	
}
