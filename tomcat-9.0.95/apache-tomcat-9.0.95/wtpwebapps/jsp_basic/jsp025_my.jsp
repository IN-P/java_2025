<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->
<%@ include file="jsp025_header.jsp" %> 
<!-- header -->


	<div class="container card my-5">
	
		<div class="my-5"><%=session.getAttribute("id")%></div>
		
		<h3 class="card-header"></h3>
	
		<table class="table table-striped table-bordered">
			<caption>MYINFO</caption>
			<tbody>
				<tr>
					<th scope="row">NO</th>
					<td></td>
				</tr>
				<tr>
					<th scope="row">NAME</th>
					<td></td>
				</tr>
				<tr>
					<th scope="row">PASS</th>
					<td></td>
				</tr>
			</tbody>
		</table>
			
	</div>	

	
<!-- footer -->	
<%@ include file="jsp025_footer.jsp" %>
<!-- footer -->