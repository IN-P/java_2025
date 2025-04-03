<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	
	<div class="container card my-3">
		<h3 class="card-header bg-dark text-white"> USERS </h3>
		<c:forEach var="u" items="${list}" varStatus="status">
			<div class="card-body my-3">
				<a href="detail.user?no=${u.no}">${u.no}<a>
				<a href="delete.user?no=${u.no}">삭제<a>
				<p>NO : ${u.no} - NAME : ${u.name} - AGE : ${u.age}</p>
			</div>			
		</c:forEach>
	</div>
	
	<!-- Blank Test -->
	<div class="container card my-3">
		<form method="post" action="insert.user" id="userInsert" onsubmit="return blank()">
			<fieldset>
				<legend>유저입력폼</legend>
				<div class="form-group">
					<label for="name">이름</label> <input type="text" name="name"
						id="name" class="form-control" />
				</div>
				<div class="form-group">
					<label for="age">나이</label> <input type="number" name="age"
						id="age" class="form-control" />
				</div>
				<div class="form-group">
					<input type="submit" value="전송" class="btn  btn-danger" />
				</div>
			</fieldset>
		</form>
	</div>
	<script>
		function blank(){
			
			let name = document.getElementById("name");
			let age = document.getElementById("age");
			
			if (name.value=="") {alert("blank"); name.focus(); return false;};
			if (age.value=="") {alert("blank"); age.focus(); return false;};
		}
	</script>

	<div class="container card my-3">
		<form method="post" action="update.user" id="userUpdate" onsubmit="return blank1()">
			<fieldset>
				<legend>유저수정폼</legend>
				<div class="form-group">
					<label for="no1">번호</label> <input type="number" name="no"
						id="no1" class="form-control" />
				</div>
				<div class="form-group">
					<label for="name1">이름</label> <input type="text" name="name"
						id="name1" class="form-control" />
				</div>
				<div class="form-group">
					<label for="age1">나이</label> <input type="number" name="age"
						id="age1" class="form-control" />
				</div>
				<div class="form-group">
					<input type="submit" value="전송" class="btn  btn-danger" />
				</div>
			</fieldset>
		</form>
	</div>
	<script>
		function blank1(){
			
			let no1 = document.getElementById("no1");
			let name1 = document.getElementById("name1");
			let age1 = document.getElementById("age1");
			
			if (no1.value=="") {alert("blank"); no1.focus(); return false;};
			if (name1.value=="") {alert("blank"); name1.focus(); return false;};
			if (age1.value=="") {alert("blank"); age1.focus(); return false;};
		}
	</script>	
	
</body>
</html>