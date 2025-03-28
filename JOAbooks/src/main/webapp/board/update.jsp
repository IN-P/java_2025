<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- hearder -->
<%@ include file="../inc/header.jsp" %>
<!-- hearder -->

	<div class="container card my-5">
		<%-- <%= request.getAttribute("result") %> --%>
		<h2 class="card-header text-center">MULTIBOARD - 수정</h2>
		<h3 class="card-header">UPDATE</h3>
		
		<form action="edit.do?bno=${result.bno}" method="post" onsubmit="return blank()">
			<div class="mb-3 mt-3">
				<label for="bname" class="form-label">이름</label> 
				<input disabled class="form-control" id="bname" placeholder="${result.bname}" name="bname">
			</div>
			<div class="mb-3">
				<label for="btitle" class="form-label">제목</label> 
				<input type="text" class="form-control" id="btitle" placeholder="${result.btitle}" name="btitle">
			</div>
			<div class="mb-3 mt-3">
      			<label for="bcontent">내용</label>
      			<textarea class="form-control" cols="60" rows="10" id="bcontent" name="bcontent" placeholder="${result.bcontent}"></textarea>
    		</div>
    		<div class="d-grid gap-3">
				<button type="submit" class="btn btn-danger btn-outline-dark btn-block ">입력</button>
				<input type="reset" value="취소" class="btn btn-outline-dark btn-block">
				<a href="list.do" class="btn btn-outline-dark btn-block">목록</a>
    		</div>				
						
		</form>
	</div>
	<script type="text/javascript">
	function blank () {
		alert("test");
		let btitle = document.getElementById("btitle");
		let bcontent = document.getElementById("bcontent");
		
		if (btitle.value=="") {alert("blank"); btitle.focus(); return false;};
		if (bcontent.value=="") {alert("blank"); bcontent.focus(); return false;};
	}
	</script>	

<!-- footer -->	
<%@ include file="../inc/footer.jsp" %>
<!-- footer -->