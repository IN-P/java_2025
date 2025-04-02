<%@page import="com.company.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>%>
<%@ include file="../inc/header.jsp" %>
<%@page import="java.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
BoardDto dto = (BoardDto)request.getAttribute("dto");
%>
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>MULTIBOARD 상세보기</h3> 					
	<div class="panel" >
	  <div  class="panel-body"> 
  		<span class="glyphicon glyphicon-plus">  조회수</span>    <p><%=dto.getBhit()%></p>
	</div>	
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">  이름</span> <p><%=dto.getBname()%></p>
		</div>
	</div>				
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  제목</span> <p><%=dto.getBtitle()%></p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  내용</span> <textarea  class="form-control"><%=dto.getBcontent()%></textarea>
	  </div> 
	</div>	
	<div class="text-right"    >
		 <a href="<%=request.getContextPath()%>/BEdit?bno=<%=dto.getBno()%>"  class="btn btn-danger" >수정</a> 
		 <a href="<%=request.getContextPath()%>/BDelete?bno=<%=dto.getBno()%>"  class="btn btn-danger" >삭제</a>    
		 <a href="<%=request.getContextPath()%>/BList"  class="btn btn-info" >목록보기</a> 
	</div>						 
</div>	
<%@ include file="../inc/footer.jsp" %>
