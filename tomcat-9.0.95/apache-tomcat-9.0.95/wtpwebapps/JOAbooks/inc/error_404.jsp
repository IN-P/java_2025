<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %> <!-- 에러페이지 -->
<% response.setStatus(200); %> <!-- 응답상태정상 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
	window.onload=function(){ //window.onload 페이지 작동시 즉시
		window.setTimeout(()=>{
			console.log("5초뒤에실행");
			location.href='../test.jsp';
		},5000);
	}
</script>
</head>
<body>
	<div class="container card my-5 bg-danger">
		<h3 class="card-header">ERROR 404</h3>
		<p class="text-center bg-white p-3"><img alt="" src="images/error.png"></p>
		<p class="text-white">요청하신 페이지가 없습니다. 관리자에게 문의바랍니다.</p>
	</div>	
</body>
</html>