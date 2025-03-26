<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 데이터값 넘겨받기
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	// out.println(id+"/"+pass); test
	// 드라이버연동 DB연동
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	String sql = "select count(*) as `cnt` from member where id=? and pass=?;";
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String dbid = "root", dbpass="1234";
	int result = -1;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,dbid,dbpass);
		// if (conn!=null) out.println("ok"); test		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pass);
		rset = pstmt.executeQuery();
		if (rset.next()) {result = rset.getInt("cnt");}
			
		if (result==1) {
			//request.getRequestDispatcher("jsp022_my.jsp").forward(request,response);
			out.println("<script>alert('login success'); location.href='jsp022_my.jsp';</script>");
			session.setAttribute("id",id);			
		} else {
			out.println("<script>alert('정보를 확인해주세요'); history.go(-1);</script>");
		}
	} catch (Exception e) {
		e.printStackTrace();	
	} finally {
		if (rset != null) { rset.close();}
		if (pstmt != null) { pstmt.close();}
		if (conn != null) { conn.close();}
	}
	
	

%>