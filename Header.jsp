<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Mentor Bootstrap Template - Index</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="/Mentor/assets/img/favicon.png" rel="icon">
  <link href="/Mentor/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="Mentor/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="Mentor/assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="Mentor/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="Mentor/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="Mentor/assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="Mentor/assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="${pagecontext.request.contextpath}/Mentor/assets/vendor/aos/aos.css" rel="stylesheet">
  

  <!-- Template Main CSS File -->
  <link href="Mentor/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Mentor - v2.2.1
  * Template URL: https://bootstrapmade.com/mentor-free-education-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto"><a href="index.html">Mentor</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li class="active"><a href="index.jsp">Home</a></li>
          <li><a href="educationListAction.edc">교육과정</a></li>
          <li><a href="Notice.jsp">공지사항</a></li>
          <li><a href="Review.jsp">수강후기게시판</a></li>
          <li><a href="QNA.jsp">Q&A</a></li>
          <li><a href="pricing.html">서비스준비중</a></li>
          <li class="drop-down"><a href="">서비스준비중</a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="drop-down"><a href="#">Deep Drop Down</a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li>
          <li><a href="contact.html">서비스준비중</a></li>

        </ul>
      </nav><!-- .nav-menu -->

<c:if test="${sessionScope.sessionId == sessionId }">
<c:choose>
	<c:when test="${sessionScope.sessionId eq null }">
 		<a href="Admin_LoginForm.ad" class="get-started-btn">관리자 로그인</a>
	</c:when>
	<c:otherwise>
	 	<a href="AdminLogout.ad" class="get-started-btn">관리자 로그아웃</a>
	</c:otherwise>
</c:choose>
</c:if>

<c:if test="${sessionScope.id == id }">
<c:choose>
	<c:when test="${sessionScope.id eq null}">
		<a href="Student_Login.me" class="get-started-btn"  >학생 로그인</a>
	</c:when>
	<c:otherwise>
		<a href="StudentLogout.me" class="get-started-btn" >로그아웃</a>
	</c:otherwise>
	
</c:choose>
</c:if>
     
		 

    </div>
  </header><!-- End Header -->
</body>
</html>