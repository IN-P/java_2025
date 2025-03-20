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
<!-- 메뉴판 -->
	<div class="container card my-5 bg-dark text-white">
		<h3 class="card-header alert-warning">MILK MENU</h3>
		<table class="table table-dark my-5">
			<caption>우유메뉴판</caption>
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
<!-- 주문현황 -->	
	<div class="container card my-5 bg-dark text-white">
		<h3 class="card-header alert-warning">MILK ORDER STATE</h3>
		<table class="table table-dark my-5">
			<caption>milk order state</caption>
			<thead>
				<tr>
					<th scope='col'>NO</th>
					<th scope='col'>NAME</th>
					<th scope='col'>NUM</th>
					<th scope='col'>DATE</th>
				</tr>
			</thead>
			<tbody>					
				<%
				sql = "select*from milk_order order by ono desc";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");			
					conn = DriverManager.getConnection(url,id,pass);
					
					pstmt = conn.prepareStatement(sql);
					rset = pstmt.executeQuery();
					while (rset.next()) {
						out.println(
							"<tr><td>"+rset.getInt("ono")
							+"</td><td>"+rset.getString("oname")		
							+"</td><td>"+rset.getString("onum")		
							+"</td><td>"+rset.getString("odate")+"</td></tr>"		
						);
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



	<div class="container card my-5 bg-dark">
		<h3 class="card-header alert-warning text-white"> GO TO ORDER MILK </h3>
		<div id="accordion">
			<div class="card">
				<div class="card-header bg-dark">
					<a class="collapsed btn text-white" data-bs-toggle="collapse" href="#collapseOne" style="font-weight:bold;"> PLACE ORDER </a>
				</div>
				<div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
					<div class="card-body">
<!-- 주문하기 -->
						<form action="milk_insert.jsp" method="post">
							<div class="mb-3 mt-3">
								<label for="oname" class="form-label">MILK NAME :</label> 
								<input type="text" class="form-control" id="oname" placeholder="Write down the name of the milk you want to order!!" name="oname">
							</div>
							<div class="mb-3">
								<label for="onum" class="form-label">MILK NUMBER :</label> 
								<input type="number" class="form-control" id="onum" placeholder="Write down the number of milk to order!!" name="onum">
							</div>
							<button type="submit" class="btn btn-danger"> PLACE ORDER </button>
						</form>
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header bg-dark">
					<a class="collapsed btn text-white" data-bs-toggle="collapse" href="#collapseTwo" style="font-weight:bold;" > MODIFY ORDER </a>
				</div>
				<div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
<!-- 주문수정 -->
						<form action="milk_update.jsp" method="post">
							<div class="mb-3 mt-3">
								<label for="ono_update" class="form-label">MILK NO :</label> 
								<input type="number" class="form-control" id="ono_update" placeholder="Please enter the order number to be modified!!" name="ono_update">
							</div>
							<div class="mb-3">
								<label for="oname_update" class="form-label">MILK NAME :</label> 
								<input type="text" class="form-control" id="oname_update" placeholder="Write down the name of the milk you want to order!!" name="oname_update">
							</div>
							<div class="mb-3">
								<label for="onum_update" class="form-label">MILK NUMBER :</label> 
								<input type="number" class="form-control" id="onum_update" placeholder="Write down the number of milk to order!!" name="onum_update">
							</div>
							<button type="submit" class="btn btn-danger"> MODIFY ORDER </button>
						</form>					
					</div>
				</div>
			</div>

			<div class="card">
				<div class="card-header bg-dark">
					<a class="collapsed btn text-white" data-bs-toggle="collapse" href="#collapseThree" style="font-weight:bold;"> DELETE ORDER </a>
				</div>
				<div id="collapseThree" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
<!-- 주문삭제 -->	
						<form action="milk_delete.jsp" method="post">
							<div class="mb-3 mt-3">
								<label for="ono_delete" class="form-label">MILK NO :</label> 
								<input type="number" class="form-control" id="ono_delete" placeholder="Please enter the order number to be deleted!!" name="ono_delete">
							</div>
							<button type="submit" class="btn btn-danger"> DELETE ORDER </button>
						</form>
					</div>
				</div>
			</div>
		</div>


	</div>

		
</body>
</html>