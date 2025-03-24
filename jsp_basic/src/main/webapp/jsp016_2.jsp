<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	int age = Integer.parseInt(request.getParameter("userage"));
	
	if (age<19) {
		//out.println("<script>alert('미성년자입니다.'); location.href='jsp016_child.jsp';</script>"); //경로 노출
		response.sendRedirect("jsp016_child.jsp?userage="+age); //경로노출됨. 권장사항
	} else {
		//out.println("<script>alert('성인입니다.'); location.href='jsp016_adult.jsp';</script>"); //경로 노출
		// 요청					jsp016_adult.jsp 이페이지에		요청한정보, 응답하는 정보 둘다 넘김
		request.getRequestDispatcher("jsp016_adult.jsp").forward(request, response);
	}
%>