<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="p-5 bg-dark text-white">
		<h1>MILK ORDER Project</h1>
		<p>PreparedStatement Ex</p>
	</div>

	<div class="container card my-5">
		<h3 class="card-header alert-warning">Milk Order</h3>

		<table class="table table-dark my-5">
			<caption>우유주문현황</caption>
			<thead>
				<tr>
					<th scope='col'>NO</th>
					<th scope='col'>NAME</th>
					<th scope='col'>PRICE</th>
				</tr>
			</thead>
			<tbody>
		<%@ page import="java.sql.*"%>
		<%
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select*from milk";
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String id = "root";
		String pass = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			conn = DriverManager.getConnection(url,id,pass);
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
			//	out.println( rset.getInt("mno")+"/"+rset.getString("mname") +"/"+rset.getInt("mprice")+"<br/>" );
			int mno = rset.getInt("mno");
			String mname = rset.getString("mname");
			int mprice = rset.getInt("mprice");
		%>
				<tr>
					<td><%=mno %></td>
					<td><%=mname %></td>
					<td><%=mprice %></td>
				</tr>
		<%
			}
		} catch (Exception e) {e.printStackTrace();
		} finally {
			if (rset !=null) { rset.close();}
			if (pstmt !=null) { pstmt.close();}
			if (conn !=null) { conn.close();}
		}
		%>
			</tbody>
		</table>
	</div>	
</body>
</html>