<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 로그인 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<style>
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>

<script type="text/javascript">
	function checkValue() {
		inputForm = eval("document.loginInfo");
		if(!inputForm.Admin_ID.value) {
			alert("아이디를 입력하세요");
			inputForm.Admin_ID.focus();
			return false;
		}
		
		if(!inputForm.Admin_PW.value) {
			alert("비밀번호를 입력하세요");
			inputForm.Admin_PW.focus();
			return false;
		}
	}

</script>
</head>

<body>
<jsp:include page="/Header.jsp"></jsp:include>
<main id="main">
    <!-- ======= Popular Courses Section ======= -->
    <section id="popular-courses" class="courses">
      <div class="container" data-aos="fade-up">
      
	<div class="login-form">
    <form name="loginInfo" action="AdminLoginAction.ad" method="post" onsubmit="return checkValue()">
        <h2 class="text-center">Log in</h2>       
        <div class="form-group">
            <input type="text" class="form-control" placeholder="관리자 아이디" required="required" name="Admin_ID">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" placeholder="관리자 비밀번호" required="required" name="Admin_PW">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">로그인</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Remember me</label>
            <a href="#" class="pull-right">Forgot Password?</a>
        </div>        
    </form>
    <p class="text-center"><a href="#">Create an Account</a></p>
</div>

 </div>
    </section><!-- End Popular Courses Section -->
    </main>
    <jsp:include page="/Footer.jsp"></jsp:include>
</body>
</html>