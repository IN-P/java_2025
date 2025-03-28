<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- hearder -->
<%@ include file="../inc/header.jsp" %>
<!-- hearder -->

	<div class="container card  my-5  p-3">
		<%-- <%= request.getAttribute("result") %> --%>
		
		<h3>MULTIBOARD 상세보기</h3>
		<div class="my-3 ">
			<div class="">
				<span><i class="bi bi-book"></i> 조회수</span>
				<p>${result.bhit}</p>
			</div>
		</div>
		<div class="my-3">
			<div class="">
				<span><i class="bi bi-book"></i> 이름</span>
				<p>${result.bname}</p>
			</div>
		</div>
		<div class="my-3">
			<div class="">
				<span><i class="bi bi-book"></i> 제목</span>
				<p>${result.btitle}</p>
			</div>
		</div>
		<div class="my-3">
			<div class="">
				<span><i class="bi bi-book"></i> 내용</span>
				<textarea class="form-control" readonly>${result.bcontent}</textarea>
			</div>
		</div>
		<div class="text-end">
			<a href="edit_view.do?bno=${result.bno}" class="btn btn-danger">수정</a> 
			<a href="delete.do?bno=${result.bno}" class="btn btn-danger">삭제</a>
			<a href="list.do" class="btn btn-info">목록보기</a>
		</div>
	</div>	

<!-- footer -->	
<%@ include file="../inc/footer.jsp" %>
<!-- footer -->