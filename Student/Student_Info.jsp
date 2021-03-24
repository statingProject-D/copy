<%@page import="vo.StudentMemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<html>
<head>
<jsp:include page="Header.jsp" />
</head>
<body>
    <!-- 1.데이터 베이스에서 한회원의 정보를 가져옴 2. table태그를 이용하며 화면에 회원의 정보를 출력 -->


 
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <h2 class="text-center">회원 정보 보기</h2>
                    <table class="table table-striped">
                    	<tr>
                        <td>학생번호</td>
                      	 <td>${member.stu_Num }</td>
                      	 
                      </tr>	
                    <tr>
                        <td>이름</td>
                      	 <td>${member.stu_Name }</td>
                      </tr>
                      
                      
                      <tr>
                        <td>성별</td>
                      	 <td>${member.stu_Gender }</td>
                      </tr>
                      
                      <tr>
                        <td>생년월일</td>
                      	 <td>${member.stu_Birth }</td>
                      </tr>
                       
                      <tr>
                        <td>이메일</td>
                        <td>${member.stu_Email }</td>
                      </tr>
                       
                      <tr>
                        <td>휴대전화</td>
                        <td>${member.stu_Phone }</td>
                      </tr>
                       
                      <tr>
                        <td>주소</td>
                        <td>${member.stu_Address }</td>
                      </tr>
                       
                      <tr>
                        <td>수강회차</td>
                        <td>${member.lecture_Time }</td>
                      </tr>
                       
                      <tr>
                        <td>아이디</td>
                        <td>${member.stu_ID }</td>
                      </tr>
                      
                      <tr>
                        <td>비밀번호</td>
                      	 <td>${member.stu_PW }</td>
                      </tr>
                       
                    <tr>
                         <td class="text-center" colspan="2">
<!-- <button onclick="location.href='MemberUpdateForm.jsp?id='" class="btn btn-primary">회원수정</button>
<button onclick="location.href='MemberDeleteForm.jsp?id=" class="btn btn-danger">회원삭제</button> -->
<button onclick="location.href='StudentUpdateForm.me'" class="btn btn-warning">회원수정</button>
<button onclick="location.href='MemberJoin.jsp'" class="btn btn-success">출석체크</button>
                           
                         </td>    
                    </tr> 
                 
                       
                    </table>
                </div>
        </div> <!-- col-sm-12 -->
    </div><!-- row -->
</div> <!-- container end-->
     
     
</body>
</html>