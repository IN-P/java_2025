<%@page import="org.apache.commons.collections4.bag.SynchronizedSortedBag"%>
<%@page import="com.company.domain.BoardVO"%>
<%@page import="com.company.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- hearder -->
<%@ include file="inc/header.jsp" %>
<!-- hearder -->


	<div class="container card my-5">
		<h3 class="card-header">프로젝트 (1) 설정</h3>
   		<ol>
      		<li>dynamic web project  - JOAbooks</li>
      		<li>inc - header/footer </li>
      		<li>error page 설정 -  404 , 500</li>
      		<li>DBCP</li>
   		</ol>
   		<h4>error</h4>
    


   		<h4>DECP</h4>
	</div>
	
	<%@page import="java.sql.Connection"%>
	<%@page import="javax.sql.*"%>
	<%@page import="javax.naming.*"%>
<%-- 	<%
		// Context 찾겠다 - Resource
		Context initContext = new InitialContext();
		// 환경Context설정 
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		// pool 이름
		DataSource ds = (DataSource)envContext.lookup("jdbc/mbasic");
		// db 연동
		out.println("ok");
		Connection conn = ds.getConnection();
	%> --%>
	
	<div class="container card my-5">
		<h3 class="card-header">PROJECT (2) MODEL</h3>
	  	<pre>
	  	1. DTO          : [com.company.domain]     - BoardVO private
	  	2. DBManager    :  [com.company.dbmanager] - DBManager
	  	3. DAO          : [com.company.dao]        - BoardDao
	   	</pre>
	</div>
	<%
	//BoardDao dao = new BoardDao();
	
	//6. delete
	/*
	BoardVO vo = new BoardVO();
	System.out.println(dao.delete(1));
	*/
	
	//5. update
	/*
	BoardVO vo = new BoardVO();
	vo.setBtitle("제목-new");
	vo.setBcontent("내용-new");
	vo.setBno(1);
	System.out.println(dao.update(vo));
	*/
	
	//4. updateHit
	//System.out.println(dao.updateHit(1));
	
	//3. select
	//System.out.println(dao.select(1));
	
	//2. insert(BoardVo vo) - btitle,bcontent, bname
	/*
	BoardVO vo = new BoardVO();
	vo.setBtitle("제목");
	vo.setBcontent("내용");
	vo.setBname("first");
	System.out.println(dao.insert(vo));
	*/
	
	//1. selectAll
	//out.println(dao.selectAll());
	%>
	
	<div class="container card my-5">
		<h3 class="card-header">PROJECT (3) VIEW</h3>
		<pre>
		[webapp] - [board]
					  ├ list.jsp
					  ├ write.jsp
					  ├ detail.jsp
					  └ update.jsp
		1. markup
		2. validator - 오류검사
		3. 빈캄검사
		</pre>
	</div>		

<!-- footer -->	
<%@ include file="inc/footer.jsp" %>
<!-- footer -->