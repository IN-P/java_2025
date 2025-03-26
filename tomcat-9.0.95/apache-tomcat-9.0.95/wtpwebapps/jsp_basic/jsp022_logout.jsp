<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.invalidate(); //session 초기화
	
	//response.sendRedirect("jsp022_login.jsp");
	//out.println("<script>alert('logout'); location.href='jsp022_login.jsp';</script>");
	//새로고침 http-equiv='refresh' content='초;url=경로'
	out.println("<meta http-equiv='refresh' content='2; url=jsp022_login.jsp'/>");
	
	//request.getRequestDispatcher("jsp022_login.jsp").forward(request,response);
%>