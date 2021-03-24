<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인페이지</title>
</head>
<body>
	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<jsp:include page="AdminLeftMenu.jsp"></jsp:include>
	
	<!-- 메인 -->
	<!-- <div class="col-md-10 content">
		<div class="panel panel-default">

		</div>
	</div> -->
			<div id="main">
			<div class="container">
            <jsp:include page="${contentPage }" />
        	</div>
        	</div>
	
	<jsp:include page="AdminFooter.jsp"></jsp:include>
	</div>
</body>
</html>