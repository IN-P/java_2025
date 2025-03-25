<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<script> //브라우저가 로딩되면 = 처리해주세요{}
	window.onload=function(){ //어디에서든 작동가능 하게 해주는 함수 window.onload
		let result = document.querySelector(".result");
		//console.log(result);
		window.setTimeout(()=>{
			console.log("5초뒤에실행");
			location.href='jsp019_error.jsp';
		},5000);
	}
</script>

</head>
<body>
	<div class="container bg-info card my-5">
		<h3 class="card-header bg-info text-white">ERROR 500</h3>
		<p class="text-center bg-white p-3">
			<img alt="" src="images/error.png">
		</p>
		<p><%=exception.getMessage()%></p>
	</div>	
</body>
</html>