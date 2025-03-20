<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	//2. request.getParamether() 이용해서 데이터받기 
	String oname = request.getParameter("oname");
	int onum = Integer.parseInt(request.getParameter("onum"));
	//out.println(oname+"/"+onum); 데이터 잘 넘겨 받는지 확인용
	
	Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
	String sql = "insert into milk_order (oname,onum,oip) values(?,?,?);";
	String url = "jdbc:mysql://localhost:3306/mbasic";
	String id = "root", pass="1234";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url,id,pass);
		
		// out.println("ok"+conn); 데이터베이스 연동 확인용
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,oname);
		pstmt.setInt(2,onum);
		pstmt.setString(3,InetAddress.getLocalHost().getHostAddress());
		// pstmt.executeQuery(); select 구문에서 사용
		int result  = pstmt.executeUpdate(); // insert, update, delete 실행줄수에서 사용
		
		
		
		if (result>0) {
			pstmt = conn.prepareStatement("select ono from milk_order where oname=? and onum=?");
			pstmt.setString(1,oname);
			pstmt.setInt(2,onum);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				int ono = rset.getInt("ono");
				out.println("<script>alert('주문성공! 주문하신 번호는 "+ono+"입니다.'); location.href='milk.jsp';</script>");
			}
		}
		else {out.println("<script>alert('관리자에게 문의바람!'); location.href='milk.jsp';</script>");}
		//location.href=''; 주소표시찰줄경로바꾸기
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rset != null) { rset.close();}
		if (pstmt != null) { pstmt.close();}
		if (conn != null) { conn.close();}
	}
%>
    
    