SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Attend;
DROP TABLE IF EXISTS Record;
DROP TABLE IF EXISTS Regist;
DROP TABLE IF EXISTS Review_Board;
DROP TABLE IF EXISTS StudentMember;
DROP TABLE IF EXISTS Notice_Board;
DROP TABLE IF EXISTS QNA_Comment;
DROP TABLE IF EXISTS Teacher;
DROP TABLE IF EXISTS EDC;
DROP TABLE IF EXISTS QNA_Board;




/* Create Tables */

-- 출석
CREATE TABLE Attend
(
	Stu_Num int NOT NULL COMMENT '학생_번호',
	Attend_Check int DEFAULT 0 NOT NULL COMMENT '출석체크',
	Attend_Late int DEFAULT 0 NOT NULL COMMENT '지각체크',
	Attend_Leave int DEFAULT 0 NOT NULL COMMENT '결석체크',
	Attend_Day int NOT NULL COMMENT '출석일수',
	Attend_StartTime datetime NOT NULL COMMENT '입실시간',
	Attend_endTime datetime NOT NULL COMMENT '퇴실시간',
	PRIMARY KEY (Stu_Num)
) COMMENT = '출석';


-- 교육과정
CREATE TABLE EDC
(
	EDC_Num int NOT NULL COMMENT '교육과정_번호',
	EDC_Subject varchar(50) NOT NULL COMMENT '교육과정_과목명',
	EDC_Place varchar(20) NOT NULL COMMENT '교육과정_장소',
	EDC_Time varchar(30) NOT NULL COMMENT '교육과정_시간',
	EDC_PD varchar(30) NOT NULL COMMENT '교육과정_기간',
	EDC_NMPR varchar(20) NOT NULL COMMENT '교육과정_모집인원',
	EDC_Photo varchar(50) NOT NULL COMMENT '교육과정_사진',
	EDC_Content varchar(4000) NOT NULL COMMENT '교육과정_내용',
	PRIMARY KEY (EDC_Num)
) COMMENT = '교육과정';


-- 공지사항 게시판
CREATE TABLE Notice_Board
(
	Notice_Board_Num int NOT NULL AUTO_INCREMENT COMMENT '공지사항 게시판번호',
	Teacher_ID varchar(20) NOT NULL COMMENT '강사_아이디',
	Notice_Board_Title varchar(50) NOT NULL COMMENT '제목',
	Notice_Board_Date date NOT NULL COMMENT '등록일',
	Notice_Board_Hit varchar(100) NOT NULL COMMENT '조회수',
	Notice_Board_Content varchar(4000) NOT NULL COMMENT '내용',
	PRIMARY KEY (Notice_Board_Num)
) COMMENT = '공지사항 게시판';


-- 질의응답 게시판
CREATE TABLE QNA_Board
(
	QNA_Board_Num int NOT NULL COMMENT '질의응답 게시판 번호',
	QNA_Board_Name varchar(20) NOT NULL COMMENT '등록자이름',
	QNA_Board_Password varchar(20) NOT NULL COMMENT '등록자비밀번호',
	QNA_Board_Title varchar(50) NOT NULL COMMENT '제목',
	QNA_Board_Date date NOT NULL COMMENT '등록일',
	QNA_Board_Hit varchar(100) NOT NULL COMMENT '조회수',
	QNA_Board_Content varchar(4000) NOT NULL COMMENT '내용',
	PRIMARY KEY (QNA_Board_Num)
) COMMENT = '질의응답 게시판';


-- 질의응답 게시판댓글
CREATE TABLE QNA_Comment
(
	QNA_Com_Num int NOT NULL AUTO_INCREMENT COMMENT '댓글번호',
	Teacher_ID varchar(20) NOT NULL COMMENT '강사_아이디',
	QNA_Com_Date date COMMENT '등록일',
	QNA_Com_Content  varchar(2000) NOT NULL COMMENT '내용',
	QNA_Com_Re_Ref   int NOT NULL COMMENT '부모글넘버',
	QNA_Com_lvl  int NOT NULL COMMENT '댓글레벨',
	QNA_Board_Num int COMMENT '질의응답 게시판 번호',
	PRIMARY KEY (QNA_Com_Num)
) COMMENT = '질의응답 게시판댓글';


-- 강사/과정이력
CREATE TABLE Record
(
	Record_Num int NOT NULL COMMENT '이력번호',
	Teacher_ID varchar(20) NOT NULL COMMENT '강사_아이디',
	EDC_Num int NOT NULL COMMENT '교육과정_번호',
	PRIMARY KEY (Record_Num)
) COMMENT = '강사/과정이력';


-- 신청
CREATE TABLE Regist
(
	Regist_Num int NOT NULL AUTO_INCREMENT COMMENT '신청_번호',
	EDC_Num int NOT NULL COMMENT '교육과정_번호',
	Regsit_Name varchar(20) NOT NULL COMMENT '신청_이름',
	Regist_Birth varchar(30) NOT NULL COMMENT '신청_생년월일',
	Regist_Phone varchar(30) NOT NULL COMMENT '신청_휴대전화',
	Regist_Email varchar(20) NOT NULL COMMENT '신청_이메일',
	Regist_Date date NOT NULL COMMENT '신청_날짜',
	Regist_Pro_Check varchar(3) NOT NULL COMMENT '신청_처리여부',
	Regist_Check varchar(3) NOT NULL COMMENT '신청_여부',
	Regist_Content varchar(100) NOT NULL COMMENT '신청_내용',
	PRIMARY KEY (Regist_Num)
) COMMENT = '신청';


-- 수강후기 게시판
CREATE TABLE Review_Board
(
	Review_Board_Num int NOT NULL COMMENT '수강후기 게시판번호',
	Stu_Num int NOT NULL COMMENT '학생_번호',
	Review_Board_Title varchar(50) NOT NULL COMMENT '제목',
	Review_Board_Date date NOT NULL COMMENT '등록일',
	Review_Board_Hit varchar(100) NOT NULL COMMENT '조회수',
	Review_Board_Content varchar(4000) NOT NULL COMMENT '내용',
	PRIMARY KEY (Review_Board_Num)
) COMMENT = '수강후기 게시판';


-- 학생정보
CREATE TABLE StudentMember
(
	Stu_Num int NOT NULL AUTO_INCREMENT COMMENT '학생_번호',
	EDC_Num int NOT NULL COMMENT '교육과정_번호',
	Stu_Name varchar(20) NOT NULL COMMENT '학생_이름',
	Stu_Gender varchar(2) DEFAULT '0' COMMENT '학생_성별',
	Stu_Birth varchar(10) NOT NULL COMMENT '학생_생년월일',
	Stu_Email varchar(20) NOT NULL COMMENT '학생_이메일',
	Stu_Phone varchar(25) DEFAULT '01000000000' COMMENT '학생_휴대전화',
	Stu_Address varchar(150) DEFAULT '0' COMMENT '학생_주소',
	Lecture_Time varchar(10) NOT NULL COMMENT '수강회차',
	Stu_Photo varchar(50) COMMENT '사진파일',
	Stu_ID varchar(20) NOT NULL COMMENT '학생_아이디',
	Stu_PW varchar(20) NOT NULL COMMENT '학생_비밀번호',
	PRIMARY KEY (Stu_Num),
	UNIQUE (Stu_ID)
) COMMENT = '학생정보';


-- 강사
CREATE TABLE Teacher
(
	Teacher_ID varchar(20) NOT NULL COMMENT '강사_아이디',
	EDC_Num int NOT NULL COMMENT '교육과정_번호',
	Teacher_PW varchar(20) NOT NULL COMMENT '강사_비밀번호',
	Teacher_Name varchar(20) NOT NULL COMMENT '강사_이름',
	Teacher_Gender varchar(2) NOT NULL COMMENT '강사_성별',
	Teacher_Phone varchar(25) NOT NULL COMMENT '강사_휴대전화',
	Teacher_Grade varchar(3) NOT NULL COMMENT '강사_등급',
	PRIMARY KEY (Teacher_ID)
) COMMENT = '강사';



/* Create Foreign Keys */

ALTER TABLE Record
	ADD FOREIGN KEY (EDC_Num)
	REFERENCES EDC (EDC_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Regist
	ADD FOREIGN KEY (EDC_Num)
	REFERENCES EDC (EDC_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE StudentMember
	ADD FOREIGN KEY (EDC_Num)
	REFERENCES EDC (EDC_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Teacher
	ADD FOREIGN KEY (EDC_Num)
	REFERENCES EDC (EDC_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE QNA_Comment
	ADD FOREIGN KEY (QNA_Board_Num)
	REFERENCES QNA_Board (QNA_Board_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Attend
	ADD FOREIGN KEY (Stu_Num)
	REFERENCES StudentMember (Stu_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Review_Board
	ADD FOREIGN KEY (Stu_Num)
	REFERENCES StudentMember (Stu_Num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Notice_Board
	ADD FOREIGN KEY (Teacher_ID)
	REFERENCES Teacher (Teacher_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE QNA_Comment
	ADD FOREIGN KEY (Teacher_ID)
	REFERENCES Teacher (Teacher_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Record
	ADD FOREIGN KEY (Teacher_ID)
	REFERENCES Teacher (Teacher_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



