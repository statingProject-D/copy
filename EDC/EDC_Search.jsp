<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>교육과정 검색</title>
    <!-- 합쳐지고 최소화된 최신 CSS -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script type="text/javascript">
	function setEdcNum(f) {
		//document.write(f);
		//alert(document.getElementById("edcNum").value);
		opener.document.getElementById("search").value = f;
		window.close();
	}

</script>
</head>
<body>
	 <div class="container">
    <div class="row">
    <div class="col-sm-12 text-center" >
     
    <div class="col-sm-10">
    <h2>교육과정명 검색</h2>
    <form action="edcSearchListAction.edc" method="post">
        <table class="table table-boardered">
        <thead>
            <tr>
                <th>교육과정</th>
                <td>
                	<input type="text" class="form-control" name="search" id="search">
                </td>
                <td >
                <input type="submit" class="btn btn-primary" value="검색">
                <input type="reset" class="btn btn-danger" value="취소">
                </td>
            </tr>
            </thead>
        </table>
        </form>
        
        <form >
        <table class="table table-boardered">
            <thead>
            <tr>
            	<td></td>
            	<td>과목명</td>
            	<td>장소</td>
            	<td>시간</td>
            	<td>기간</td>
            	<td>모집인원</td>
            </tr>
            </thead>
            <tbody>
           <c:forEach var="eduList" items="${eduList}">
            <tr>
            	<td>
            	<input type="hidden" value="${eduList.edc_Num }" id="edcNum" name="edcNum">
            	${eduList.edc_Num }
            	</td>
            	<td>${eduList.edc_Subject }</td>
            	<td>${eduList.edc_Place }</td>
            	<td>${eduList.edc_Time }</td>
            	<td>${eduList.edc_PD }</td>
            	<td>${eduList.edc_NMPR }</td>
            	<td><input type="button"  value="선택" class="btn btn-info" onclick="setEdcNum(${eduList.edc_Num })">
            </tr>
             </c:forEach>
             </tbody>
        </table>
    </form>
    </div>
     
    </div>
    </div>
</div>
</body>
</html>