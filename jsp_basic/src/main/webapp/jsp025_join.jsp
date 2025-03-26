<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->
<%@ include file="jsp025_header.jsp" %>
<!-- header -->

	<div class="container card my-5">
	
		<h3 class="card-header">JOIN</h3>
		
		<p style="text-align:center;"><img src="images/login.png" alt="login"></p>
		
		<form action="<%=request.getContextPath()%>/user_join" method="post" onsubmit="return blank()">
			
			<div class="mb-3">
				<label for="id" class="form-label">ID : </label> 
				<input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
			</div>
			
			<div class="mb-3">
				<label for="pass" class="form-label">PASSWORD : </label> 
				<input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
			</div>
			
			<div class="text-end my-3">
				<input type="submit" class="btn btn-success" title="Join 하러가기" name="JOIN" value="JOIN"/>
			</div>
		
		</form>
		
		<script>
			function blank () {
				let id = document.querySelector("#id");
				let pass = document.querySelector("#pass");
				if (id.value=="") { alert("blank"); id.focus(); return false; }
				if (pass.value=="") { alert("blank"); pass.focus(); return false; }
			}
		</script>
		
	</div>	
	
<!-- footer -->	
<%@ include file="jsp025_footer.jsp" %>
<!-- footer -->