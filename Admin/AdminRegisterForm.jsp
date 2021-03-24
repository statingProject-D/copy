<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>관리자 등록 페이지</title>
    <!-- 합쳐지고 최소화된 최신 CSS -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.2/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script type="text/javascript">
	function edc_modal(mypage,myname,w,h,scroll) {
		var winl = (screen.width-w) /2;
		var wint = (screen.height-h) /2;
		winprops = 'height='+h+',width='+w+',top='+wint+',left='+winl+',scrollbars='+scroll+',resizable'
		win = window.open(mypage, myname, winprops)
		if (parseInt(navigator.appVersion) >= 4) { win.window.focus(); }
		}
	
	function checkAll() {   //빈값 체크
		if(!checkId(form.id.value)) {		//아이디 빈값 체크
			return false;
		} else if(!checkPassword(form.password.value,form.passwordConfirm.value)) { //비밀번호 빈값 체크
			return false;
		} else if(!checkSearch(form.search.value)) {		//교육과정 검색 빈값체크
			return false;
		} else if(!checkName(form.name.value)) {			//이름 빈값 체크
			return false;
		} else if(!checkGender(form.gender.value)) {		//성별 빈값 체크
			return false;
		} else if(!checkTel(form.tel.value)) {				//전화번호 빈값 체크
			return false;
		} else if(!checkGrade(form.grade.value)) {
			return false;
		}
		return true;
	}
	
	
	//공백 함수 
	function checkExistData(value, dataName) {
		if(value == "") {
			alert(dataName + " 입력해주세요!");
			return false;
		}
		return true;
	}
	
	
	
	function checkId(id) {
		//id 입력확인
		if(!checkExistData(id,"아이디를")) {
			return false;
		}
		
		 var idRegExp = /^[a-zA-z0-9]{4,10}$/; //아이디 유효성 검사
		 if(!idRegExp.test(id)) {
			 alert("아이디는 영문 대문자와 숫자 4~10자리까지만 입력가능");
			 form.id.value = "";
			 form.id.focus();
			 return false;
		 }
			return true;
	}
	
	
	function checkPassword(password,passwordConfirm) {   //비밀번호 입력여부체크
		if(!checkExistData(password, "비밀번호를")) {
			return false;
		} 
	
		if(!checkExistData(passwordConfirm, "한번 더 비밀번호를 ")) { //비밀번호 확인란 입력여부체크
			return false;
		}
		
		var password1RegExp =  /^[a-zA-z0-9]{4,12}$/;  //비밀번호 유효성검사
		
		if(!password1RegExp.test(password)) {
			alert("비밀번호는 영문 대소문자와 숫자 4~12자리로 입력하세요");
			form.password.value = "";
			form.password.focus();
			return false;
		}
		
		if(password != passwordConfirm) {			//비밀번호, 비밀번호 확인이 같지 않을 때
			alert("두 비밀번호가 맞지 않습니다.");
			form.password.value="";
			form.passwordConfirm = "";
			form.passwordConfirm.focus();
			return false;
		}
		return true;
	}
	
	
		function checkSearch(search) {
			if(!checkExistData(search, "교육과정을")) {
				return false;
			}
			return true;
		}
		
		
		function checkName(name) {						//이름 검사
			if(!checkExistData(name, "이름을")) {
				return false;
			}
		
			
			 var nameRegExp = /^[가-힣]{2,4}$/;
			
			if(!nameRegExp.test(name)) {
				alert("이름이 올바르지 않습니다.");
				return false;
			}
			return true;
		} 
		
		function checkGender(gender) {
			if(!checkExistData(gender,"성별을")) {
				return false;
			}
			return true;
		}
		
		
		function checkTel(tel) {
			
			if(!checkExistData(tel,"전화번호를")) {
				return false;
			}
			var telRegExp = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}$/; //전화번호 정규식
			
			
			  if(!telRegExp.test(tel)) {
				  alert("전화번호 양식이 맞지 않습니다.ex(000-0000-0000 or 00-000-0000 or 00-0000-0000)");
			        form.tel.value="";
			        form.tel.focus();
			        return false;
			    }
			    return true;
			}
		
		function checkGrade(grade) {
			if(!checkExistData(grade,"등급을")) {
				return false;
			} else {
				return true;
			}
		}
		
		function back() {				//뒤로가기
			history.back();
		}

</script>

</head>
<body>
    <div class="row">
    <div class="col-sm-10 text-center" >
    <div class="col-sm-3"></div>
     
    <div class="col-sm-6">
    <h2>직원등록</h2>
    <form action="AdminRegisterAction.ad" method="post" name="form" onsubmit="return checkAll()">
        <table class="table table-boardered">
            <tr>
                <th>직원 아이디</th>
                <td colspan="2"><input type="text" class="form-control" name="id" id="id" placeholder="id를 넣으세요"></td>        
            </tr>
            <tr>
                <th>직원 비밀번호</th>
                <td colspan="2"><input type="password" class="form-control" name="password" id="password" placeholder="영문만 넣어주세요"></td>      
            </tr>
             
            <tr>
                <th>비밀번호 확인</th>
                <td colspan="2"><input type="password" class="form-control" name="passwordConfirm" id="passwordConfirm"></td>        
            </tr>
            <tr>
            	<th>직원 교육과정 </th>
            	<td>
            	<input type="text" name="search" id="search" class="form-control" placeholder="교육과정 검색을 하세요" readonly="readonly">
				<input type="button" value="검색" class="btn btn-primary" onclick="edc_modal('edcModalSearchList.edc','','1000','600','yes')">
				</td>
            </tr> 
             
            <tr>
                <th>직원 이름</th>
                <td colspan="2"><input type="text" class="form-control" name="name" id="name"></td>       
            </tr>
             
            <tr>
                <th>직원 성별</th>
                <td colspan="2">
                <input type="radio"  name="gender" id="gender" value="남">남&nbsp;
                <input type="radio"  name="gender" id="gender" value="여">여
                </td>       
            </tr>
             
            <tr>
                <th>직원 휴대전화</th>
                <td colspan="2"><input type="tel" class="form-control" name="tel" id="tel"></td>       
            </tr> 
             
            <tr>
            	<!--강사 등급  -->
            	<th>직원 등급</th>
            	<td colspan="2">
            	<select name="grade" class="form-control">
            		<option value="">선택</option>
            		<option value="0">강사</option>
            		<option value="1">상담원</option>
            		<option value="2">관리자</option>
            	</select>
            	</td>
            </tr>            
             
             
            <tr>
                <td colspan="2">
                <input type="submit" class="btn btn-primary" value="전송">
                <input type="button" class="btn btn-danger" value="취소" onclick="back()">
                </td>
            </tr>
             
             
        </table>
    </form>
    </div>
     
    </div>
    </div>
</body>
</html>