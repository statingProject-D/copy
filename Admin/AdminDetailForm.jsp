<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<html>
<head>
</head>
<body>
    <!-- 1.데이터 베이스에서 한회원의 정보를 가져옴 2. table태그를 이용하며 화면에 회원의 정보를 출력 -->

 <div class="col-md-10 content">
		<div class="panel panel-default">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <h2 class="text-center">직원 정보 보기</h2>
                    <table class="table table-striped">
                       <tr>
                        <td>아이디</td>
                          <td>${teacher.teacher_ID }</td>
                          
                      </tr>
                      
                      <tr>
                        <td>비밀번호</td>
                          <td>${teacher.teacher_PW }</td>
                          
                      </tr>   
                      
                         
                    <tr>
                        <td>담당 교육과정번호</td>
                          <td>
                          <a href="EDC_SelectAction.ad?id=${teacher.teacher_ID }&num=${teacher.edc_Num}">
                          ${teacher.edc_Num}</a>
                         </td>
                      </tr>
                      
                      
                      <tr>
                        <td>이름</td>
                          <td>${teacher.teacher_Name }</td>
                      </tr>
                      
                      <tr>
                        <td>성별</td>
                          <td>${teacher.teacher_Gender }</td>
                      </tr>
                       
                      <tr>
                        <td>휴대전화</td>
                        <td>${teacher.teacher_Phone }</td>
                      </tr>
                       
                       
                      <tr>
                        <td>등급</td>
                    <c:choose>
					<c:when test="${teacher.teacher_Grade == 0 }">
						<td>강사</td>
					</c:when>
					<c:when test="${teacher.teacher_Grade == 1 }">
						<td>상담원</td>
					</c:when>
					<c:when test="${teacher.teacher_Grade == 2 }">
						<td>관리자</td>
					</c:when>
					</c:choose>
                      </tr>
                       
                    <tr>
                         <td class="text-center" colspan="2">

		<button onclick="location.href='AdminModifyFormAction.ad?id=${teacher.teacher_ID }'" class="btn btn-warning">정보수정</button>
		<c:if test="${teacher.teacher_ID != sessionScope.sessionId }">
		<button onclick="location.href='AdminDeleteAction.ad?id=${teacher.teacher_ID}'" class="btn btn-danger">정보삭제</button>
		</c:if>
        <button onclick="location.href='AdminListAction.ad'" class="btn btn-primary">관리리스트로 이동</button>                   
                         </td>    
                    </tr> 
                 
                       
                    </table>
                </div>
        </div> <!-- col-sm-12 -->
    </div><!-- row -->
   </div>
   </div>
</body>
</html>