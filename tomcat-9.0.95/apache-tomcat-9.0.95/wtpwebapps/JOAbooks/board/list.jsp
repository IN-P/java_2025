<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- hearder -->
<%@ include file="../inc/header.jsp" %>
<!-- hearder -->

	<div class="container my-5">
		<h3>MULTIBOARD</h3>
		<p>MULTIBOARD</p>
		<table class="table table-dark table-hover text-center">
			<caption>MULTIBOARD-LIST</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>no</td>
					<td>title</td>
					<td>writer</td>
					<td>date</td>
					<td>hit</td>
				</tr>
			</tbody>
		</table>
		<div class="text-end">
			<br><a href="write.jsp" alt="" class="btn btn-danger text-white">글쓰기</a>
		</div>
	</div>
	

<!-- footer -->	
<%@ include file="../inc/footer.jsp" %>
<!-- footer -->