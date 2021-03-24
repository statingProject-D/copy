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
			<form action="NoticeBoardListFormAction.bo" class="navbar-form navbar-left" method="GET" role="search">
				<div class="form-group">
					<select name="opt" class="form-control"> <!-- 구분 -->
						<option value="0" 
							<c:if test="${opt == 0 }">selected</c:if>>제목</option>
						<option value="1"
							<c:if test="${opt == 1 }">selected</c:if>>글쓴이</option>
						<%-- <option value="2"
							<c:if test="${opt == 2 }">selected</c:if>>글쓴이</option> --%>
					</select>
					<input type="text" name="condition" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
			</form>
	<div class="text-right">
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<c:forEach var="list" items="${list}">
		<tbody>
			<tr>
				<td>${list.notice_Board_Num }</td>		<!-- 공지사항 게시판 번호 -->
				<td>${list.notice_Board_Title }</td>	<!-- 제목 -->
				<td>${list.teacher_ID }</td>			<!-- 관리자아이디 -->
				<td>${list.notice_Board_Date }</td>		<!-- 작성일 -->
				<td>${list.notice_Board_Hit }</td>		<!-- 조회수 -->
			</tr>
		</tbody>
		</c:forEach>
	</table>
	
	<hr>
	
		
	
	
	<!-- 페이지 설정 -->
	<div class="text-center">
		<nav aria-label="Page navigation example">
 <div id="pageForm">
        <c:if test="${pageInfo.startPage != 1}">
            <a href='NoticeBoardListFormAction.bo?page=${pageInfo.startPage-1}'>[ 이전 ]</a>
        </c:if>
        
        <c:forEach var="pageNum" begin="${pageInfo.startPage}" end="${pageInfo.endPage}">
            <c:if test="${pageNum == pageInfo.page}">
                ${pageNum}&nbsp;
            </c:if>
            <c:if test="${pageNum != pageInfo.page}">
                <a href='NoticeBoardListFormAction.bo?page=${pageNum}'>${pageNum}&nbsp;</a>
            </c:if>
        </c:forEach>
        
        <c:if test="${pageInfo.endPage != pageInfo.maxPage }">
            <a href='NoticeBoardListFormAction.bo?page=${pageInfo.endPage+1}'>[다음]</a>
        </c:if>
    </div>

</nav>
	</div>
      
  	</div>
	</div>
	
</body>
	<script type="text/javascript" src="../Mentor/assets/vendor/bootstrap/js/bootstrap.js" />  <!-- 위로 올리면 동작안함  -->
</html>