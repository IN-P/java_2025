<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card my-5">
		<h3 class="card-header bg-info">select box</h3>
		<p>좋아하는 과일선택</p>
		<form action="jsp017_EX_reponse.jsp" method="get" onsubmit="return blank()">
		
			<div class="mb-3 mt-3">
				<label for="name" class="form-label">사용자이름</label> 
				<input type="text" class="form-control" id="name" placeholder="이름을 적어주세요" name="name">
			</div>
			
			<label for="fruit" class="form-label">좋아하는 과일선택</label>
			<select class="form-select" id="fruit" name="fruit">
				<option value="">-- 선택 --</option>
				<option value="apple.jpg">APPLE</option>
				<option value="banana.jpg">BANANA</option>
				<option value="coconut.png">COCONUT</option>
			</select>
			
			<div class="d-grid gap-2">
				<button type="submit" class="btn btn-danger">수신체크하러가기</button>
			</div>
		</form>
		
		<script>
			function blank(){
				let name = document.querySelector("#name");
				let fruit = document.querySelector("#fruit > option:checked");
				if (name.value == "") {
					alert("blank"); name.focus(); return false;
				}
				if (fruit.value == "") {
					alert("blank"); return false;
				}
			}
		
		</script>
		
	</div>	
</body>
</html>