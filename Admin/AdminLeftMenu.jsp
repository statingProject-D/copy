<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeView(value) {
		if(value == "1") {
			location.href="AdminListAction.ad";		// 리스트 만든 후 수정
		}
		
		if(value == "4") {
			location.href='NoticeBoardListFormAction.bo'   //공지사항 리스트로 이동
		}
	}
</script>
</head>
<body>
	<!--네비게이션  -->
	<div class="container-fluid main-container">
  		<div class="col-md-2 sidebar">
  			<div class="row">
	<!-- uncomment code for absolute positioning tweek see top comment in css -->
	<div class="absolute-wrapper"> </div>
	<!-- Menu -->
	<div class="side-menu">
		<nav class="navbar navbar-default" role="navigation">
			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">
					<li class="panel panel-default" id="dropdown">
					<a href="#dropdown-lv2" data-target="#dropdown-lvl2" data-toggle="collapse"  style="border-right-width: 0px;">
						<span class="glyphicon glyphicon-dashboard"></span> 게시판 관리 <span class="caret"></span>
					</a>
					
					<div id="dropdown-lvl2" class="panel-collapse collapse">
						<div class="panel-body">
							<ul class="nav navbar-nav">
								<li><a href="javascript:changeView(4);">공지사항</a></li>
								<li><a href="#">질의응답 게시판</a></li>
								<li><a href="#">수강후기 게시판 </a></li>
							</ul>
						</div> 
					</div>
					
					
					
					</li>
					<li><a href="#"><span class="glyphicon glyphicon-plane"></span> Active Link</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-cloud"></span> 수강생 관리</a></li>

					<!-- Dropdown-->
					<li class="panel panel-default" id="dropdown">
						<a data-toggle="collapse" href="#dropdown-lvl1">
							<span class="glyphicon glyphicon-user"></span> 교직원 관리 <span class="caret"></span>
						</a>

						<!-- Dropdown level 1 -->
						<div id="dropdown-lvl1" class="panel-collapse collapse">
							<div class="panel-body">
								<ul class="nav navbar-nav">
									<li><a href="javascript:changeView(1);">관리 리스트</a></li><!-- 수정예정 -->
									<li><a href="javascript:changeView(2);">link</a></li>
									<li><a href="javascript:changeView(3);">link</a></li>

									<!-- Dropdown level 2 -->
								<!-- 	<li class="panel panel-default" id="dropdown">
										<a data-toggle="collapse" href="#dropdown-lvl2">
											<span class="glyphicon glyphicon-off"></span> Sub Level <span class="caret"></span>
										</a>
										<div id="dropdown-lvl2" class="panel-collapse collapse">
											<div class="panel-body">
												<ul class="nav navbar-nav">
													<li><a href="#">Link</a></li>
													<li><a href="#">Link</a></li>
													<li><a href="#">Link</a></li>
												</ul>
											</div>
										</div>
									</li> -->
								</ul>
							</div>
						</div>
					</li>

					<li><a href="#"><span class="glyphicon glyphicon-signal"></span> Link</a></li>

				</ul>
			</div><!-- /.navbar-collapse -->
		</nav>

	</div>
</div>  		
</div>
</body>
</html>