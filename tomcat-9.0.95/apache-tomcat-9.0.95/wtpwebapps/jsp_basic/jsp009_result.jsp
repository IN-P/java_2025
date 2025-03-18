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
		<h3 class="card-header">LOGIN RESULT</h3>
		<%
			int kor = Integer.valueOf(request.getParameter("kor"));
			int eng = Integer.valueOf(request.getParameter("eng"));
			int math = Integer.valueOf(request.getParameter("math"));
			int sum = kor+eng+math;
			//double avg = sum/3.0;
			String avg = String.format("%.2f",sum/3f);
		%>

		<table class="table table-dark">
			<caption>성적처리</caption>
			<thead>
				<tr>
					<th scope="col">국어</th>
					<th scope="col">영어</th>
					<th scope="col">수학</th>
					<th scope="col">총점</th>
					<th scope="col">평균</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=kor%></td>
					<td><%=eng%></td>
					<td><%=math %></td>
					<td><%=sum %></td>
					<td><%=avg %></td>
				</tr>
			</tbody>
		</table>

		<p><a href="javascript:history.go(-1)" class="btn btn-danger">처음으로</a></p>
	</div>	
</body>
</html>