<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->
<%@ include file="jsp022_header.jsp" %>
<!-- header -->

	<div class="container card my-5">
	
		<h3 class="card-header">LOGIN</h3>
		
		<p style="text-align:center;"><img src="images/login.png" alt="login"></p>
		
		<form action="jsp022_login_action.jsp" method="post" onsubmit="return blank()">
			
			<div class="mb-3 mt-3">
				<label for="id" class="form-label">ID : </label> 
				<input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
			</div>
			
			<div class="mb-3">
				<label for="pass" class="form-label">PASSWORD : </label> 
				<input type="password" class="form-control" id="pass" placeholder="Enter password" name="pass">
			</div>
			
			<div class="form-check mb-3">
				<label class="form-check-label"> 
					<input class="form-check-input" type="checkbox" name="remember">
					아이디 기억하기
				</label>
			</div>
			
			<div class="text-end my-3">
				<input type="submit" class="btn btn-success" title="Login 하러가기" name="LOGIN" value="LOGIN"/>
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
<%@ include file="jsp022_footer.jsp" %>
<!-- footer -->