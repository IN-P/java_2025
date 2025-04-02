<%@page import="com.company.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include  file="../inc/header.jsp" %>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->

<div class="container"   style="margin-top:5%; min-height:500px">
	<h3>MULTIBOARD</h3>
	<table  class="table table-striped">
		<caption>MULTIBOARD - MVC1</caption>
		<thead>
			<tr><th scope="col">NO</th><th scope="col">TITLE</th>
			     <th scope="col">WRITER</th><th scope="col">DATE</th><th scope="col">HIT</th></tr>
		</thead>
		<tbody>
		 
 
<%--  			<tr><td>1</td><td><a href="<%=request.getContextPath()%>/BDetail?bno=1">
 								첫번재 글쓰기입니다.
 								</a></td>
				<td>ADMIN</td><td>2020-01-02 13:14:30</td><td>1</td></tr>  --%>
	
		</tbody>
	</table>
	<p  class="text-right"><a href="<%=request.getContextPath()%>/BWrite"   class="btn btn-danger">글쓰기</a></p>
</div>

<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<%@ include  file="../inc/footer.jsp" %>