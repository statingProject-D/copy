<%@page import="com.sun.org.apache.xerces.internal.util.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta charset="utf-8" />
<title>Static Headline Template | PrepBootstrap</title>

<%-- <jsp:include page="/Header.jsp"></jsp:include> --%>


<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css"
	href="education/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="education/font-awesome/css/font-awesome.min.css" />

<script type="text/javascript" src="education/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript"
	src="education/bootstrap/js/bootstrap.min.js"></script>


<style>
.main-text {
	position: absolute;
	top: 50px;
	width: 96.66666666666666%;
	color: #FFF;
}

.btn-min-block {
	min-width: 170px;
	line-height: 26px;
}

.btn-clear {
	color: #FFF;
	border-color: #FFF;
	border-width: 2px;
	margin-right: 15px;
}

.btn-clear:hover {
	color: #000;
	background-color: #6699CC;
}

.arrowalign {
	top: 50%;
}

.arrowalign:hover {
	vertical-align: middle;
}

.carousel-control {
	color: #fff;
	top: 50%;
	bottom: auto;
	padding-top: 0px;
	width: 30px;
	height: 30px;
	text-shadow: none;
	opacity: 0.9;
}
</style>

</head>
<body>


	<div class="container">

		<!-- <div class="page-header">
    <h1>Static Headline <small>A template, demonstrating a carousel with a static headline.</small></h1>
</div>
 -->
		<!-- Static Headline - START -->



		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<c:if test="${eduList != null}">
						<div id="carousel-example" class="carousel slide"
							data-ride="carousel">
							<!-- 맨아래 커서 버튼 -->

							<ol class="carousel-indicators">
								<c:forEach var="list" items="${eduList }" varStatus="status">

									<c:choose>
										<c:when test="${status.index == 0}">

											<li data-target="#carousel-example"
												data-slide-to="${status.count }" class="active"></li>

										</c:when>
										<c:otherwise>
											<li data-target="#carousel-example"
												data-slide-to="${status.count }"></li>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</ol>

							<!-- 	 
                 <ol class="carousel-indicators">
                    <li data-target="#carousel-example" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example" data-slide-to="1"></li>
                    <li data-target="#carousel-example" data-slide-to="2"></li>
                    <li data-target="#carousel-example" data-slide-to="3"></li>
                </ol> 
                 -->
               
							<div class="carousel-inner">
								<!-- 커서 아이템 -->
								<c:forEach var="list" items="${eduList }" varStatus="count">

									<c:choose>
										<c:when test="${count.index == 0}">
		
											<div class="item active">
												<img
													src="http://www.prepbootstrap.com/Content/images/template/carouselstaticheader/slide_03.jpg"
													alt="First slide" />
												<div class="carousel-caption">
													<h3>${list.edc_Subject }</h3>
													<p>${list.edc_Content }</p>
													<p>${list.edc_PD }</p>
													<p>
														<a class="btn btn-clear btn-sm btn-min-block"
															href="educationView.edc?edc_Num=${list.edc_Num }">More Details</a>
													</p>
													
												</div>
											</div>
											
											<%-- <div class="main-text hidden-xs">
												<div class="col-md-12 text-center">
													 <h1><c:out value="${list.edc_Subject }"></c:out></h1> 
													
												</div>
											</div> 탑타이틀
											--%>
										</c:when>
										<c:otherwise>
											
											
											
											<div class="item">
												<img
													src="http://www.prepbootstrap.com/Content/images/template/carouselstaticheader/slide_02.jpg"
													alt="Second slide" />
												<div class="carousel-caption">
													<h3>${list.edc_Subject }</h3>
													<p>${list.edc_Content }</p>
													<p>${list.edc_PD }</p>
													<p>
														<a class="btn btn-clear btn-sm btn-min-block"
															href="education_view.jsp">More Details</a>
													</p>
												</div>
											</div>
												
										</c:otherwise>
										
									</c:choose>
									
								</c:forEach>
	
												
								<!-- 
                    <div class="item">
                        <img src="http://www.prepbootstrap.com/Content/images/template/carouselstaticheader/slide_02.jpg" alt="Second slide" />
                        <div class="carousel-caption">
                            <h3>Product B</h3>
                            <p>
                                Best Suitable for small businesses 
                            </p>
                            <p><a class="btn btn-clear btn-sm btn-min-block" href="#">More Details</a></p>
                        </div>
                    </div>
                  
                    <div class="item">
                        <img src="http://www.prepbootstrap.com/Content/images/template/carouselstaticheader/slide_01.jpg" alt="Third slide" />
                        <div class="carousel-caption">
                            <h3>Product B</h3>
                            <p>
                                Best Suitable for small businesses 
                            </p>
                            <p><a class="btn btn-clear btn-sm btn-min-block" href="#">More Details</a></p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="http://www.prepbootstrap.com/Content/images/template/carouselstaticheader/slide_01.jpg" alt="Third slide" />
                        <div class="carousel-caption">
                            <h3>Product B</h3>
                            <p>
                                Best Suitable for small businesses 
                            </p>
                            <p><a class="btn btn-clear btn-sm btn-min-block" href="#">More Details</a></p>
                        </div>
                    </div>
                     -->
							</div>
						</div>
					</c:if>
					<!-- Left and right controls -->
					<a class="left carousel-control" href="#carousel-example"
						role="button" data-slide="prev"> <span
						class="fa fa-arrow-left" aria-hidden="true"></span>
					</a> <a class="right carousel-control" href="#carousel-example"
						role="button" data-slide="next"> <span
						class="fa fa-arrow-right" aria-hidden="true"></span>
					</a>
				</div>
				<!-- 
            <div class="main-text hidden-xs">
                <div class="col-md-12 text-center">
                    <h1>Affordable products</h1>
                    <h3>Pick up the one that suits you best
                    </h3>
                </div>
            </div>
             -->
			</div>
		</div>
	</div>

	</div>

	<%-- <jsp:include page="Footer.jsp"></jsp:include> --%>
</body>
</html>