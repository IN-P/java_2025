<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int ono = Integer.parseInt(request.getParameter("ono_delete"));
	
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	String sql = "delete from milk_order where ono=?;";
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String id = "root", pass="1234";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pass);
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,ono);

		int result  = pstmt.executeUpdate();
		if (result>0) { out.println("<script>alert('Number of weeks Successful removal of order No."+ono+"!'); location.href='milk.jsp';</script>"); }
		else {out.println("<script>alert('Ask the manager!'); location.href='milk.jsp';</script>");}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rset != null) { rset.close();}
		if (pstmt != null) { pstmt.close();}
		if (conn != null) { conn.close();}
	}
%>