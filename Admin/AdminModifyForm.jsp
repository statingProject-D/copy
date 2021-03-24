<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
 
 <div class="col-md-10 content">
		<div class="panel panel-default">
    <div class="row">
        <div class="col-sm-12">
            <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <h2 class="text-center">직원 정보 수정하기</h2>
                     
                    <form action="AdminModifyAction.ad" method="post">
                     
                    <table class="table table-striped">
                    
                    <tr>
                        <td>아이디</td>
                        <td>
                        <input type="text" value='${teacher.teacher_ID}' name="id" id="id" class="form-control" />
                        <%-- ${teacher.teacher_ID } --%>
                        </td>
                      </tr>
                     <tr>
                     	<td>비밀번호</td>
                     	<td>
                     		<input type="password" value="${teacher.teacher_PW }" name="password" id="password" class="form-control">
                     	</td>
                     </tr>
                    
                    <tr>
                    	<td>담당 교육과정번호</td>
                    	<td>
                    		<input type="text" value="${teacher.edc_Num }" name="num" id="num" class="form-control">
                    	</td>
                    </tr>
                    
                    <tr>
                        <td>이름</td>
                        <td>
                        <input type="text" value='${teacher.teacher_Name }' name="name" id="name" class="form-control">
                        </td>
                      </tr>
                      
                      <tr>
                        <td>성별</td>
                        <td>
                        <input type="text" value='${teacher.teacher_Gender }' name="gender" id="gender" class="form-control">
                        </td>
                      </tr>
                    
                    <tr>
                        <td>휴대전화</td>
                        <td>
                        <input type="text" value='${teacher.teacher_Phone }' name="phone" id="phone" class="form-control">
                        </td>
                      </tr>
                    
                       <tr>
                        <td>등급</td>
                    <c:choose>
					<c:when test="${teacher.teacher_Grade == 0 }">
						<td>
							<input type="text" value="강사" readonly="readonly" name="teacher" id="teacher" class="form-control">
							<select name="grade" class="form-control">
								<option value="">선택</option>
								<option value="2">관리자</option>
								<option value="1">상담원</option>
							</select>
						</td>
					</c:when>
					<c:when test="${teacher.teacher_Grade == 1 }">
						<td>
							<input type="text" value='상담원' readonly="readonly" name="cs" id="cs" class="form-control">
							<select name="grade" class="form-control">
								<option value="">선택</option>
								<option value="2">관리자</option>
								<option value="0">강사</option>
							</select>
						</td>
					</c:when>
					<c:when test="${teacher.teacher_Grade == 2 }">
						<td>
							<input type="text" value='관리자' readonly="readonly" name="admin" id="admin" class="form-control">
							<select name="grade" class="form-control">
								<option value="">선택</option>
								<option value="0">강사</option>
								<option value="1">상담원</option>
							</select>
						</td>
					</c:when>
					</c:choose>
                      </tr>
                      
                    <tr>
                         <td colspan="2" class="text-center">
                         <input type="submit" value="회원 수정하기" class="btn btn-success">
                         
                         </td>    
                    </tr>
                           
                    </table>
                 
                </form>   
                    
                </div>
        </div> <!-- col-sm-12 -->
    </div><!-- row -->
</div> <!-- container end-->
   </div>  
    
</body>
</html>