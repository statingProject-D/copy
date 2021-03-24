<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale = 1">
<title>강사 관리 리스트</title>
	<!-- <script type="text/javascript" src="../Mentor/assets/vendor/jquery/jquery-3.1.1.js"></script>
	<link rel="stylesheet" href="../Mentor/assets/vendor/bootstrap/css/bootstrap.css"> -->
</head>
<body>

 <div class="col-md-10 content">
		<div class="panel panel-default">
			<form action="AdminListAction.ad" class="navbar-form navbar-left" method="GET" role="search">
				<div class="form-group">
					<select name="opt" class="form-control"> <!-- 구분 -->
						<option value="0" 
							<c:if test="${opt == 0 }">selected</c:if>>아이디</option>
						<option value="1"
							<c:if test="${opt == 1 }">selected</c:if>>이름</option>
						<option value="2"
							<c:if test="${opt == 2 }">selected</c:if>>등급</option>
					</select>
					<input type="text" name="condition" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
			</form>
	<div class="text-right">
	<button class="btn btn-primary" id="advanced-set-submit" onclick="location.href='AdminRegisterFormAction.ad'">강사등록</button>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>직원 아이디</th>
				<th>직원 비밀번호</th>
				<th>직원 이름</th>
				<th>직원 성별</th>
				<th>직원 휴대전화</th>
				<th>직원 등급</th>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
		<tbody>
			<tr>
				<td>
					<a href="AdminDetailAction.ad?id=${list.teacher_ID}">
							${list.teacher_ID}
					</a>
				</td>	
				<td>${list.teacher_PW }</td>	
				<td>${list.teacher_Name }</td>	
				<td>${list.teacher_Gender }</td>	
				<td>${list.teacher_Phone }</td>
				
			<c:choose>
			<c:when test="${list.teacher_Grade == 0 }">
				<td>강사</td>
			</c:when>
			<c:when test="${list.teacher_Grade == 1 }">
				<td>상담원</td>
			</c:when>
			<c:when test="${list.teacher_Grade == 2 }">
				<td>관리자</td>
			</c:when>
			</c:choose>
			
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
	<hr>
	
		
	
	
	<!-- 페이지 설정 -->
	<div class="text-center">
		<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
    
  </ul>
</nav>
	</div>
      
  	</div>
	</div>
	
</body>
	<script type="text/javascript" src="../Mentor/assets/vendor/bootstrap/js/bootstrap.js" />  <!-- 위로 올리면 동작안함  -->
</html>