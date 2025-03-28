package com.company.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.service.BDelete;
import com.company.service.BDetail;
import com.company.service.BEdit;
import com.company.service.BEditView;
import com.company.service.BList;
import com.company.service.BWrite;
import com.company.service.BoardService;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		
		BoardService service = null;
		//NaverBook book = new NaverBook();
		//book.getBooks();
		
		
		if (path.equals("/list.do")) {
			service = new BList(); service.exec(request, response);
			request.getRequestDispatcher("board/list.jsp").forward(request, response);
		} else if (path.equals("/write_view.do")) {
			request.getRequestDispatcher("board/write.jsp").forward(request, response);

		} else if (path.equals("/write.do")) {
			service = new BWrite(); service.exec(request, response);
			//System.out.println("1:"+request.getAttribute("result"));
			String result = (String) request.getAttribute("result");
			String msg = "관리자에게 문의";
			if(result.equals("1")) { msg="success"; }
			out.println("<script>alert('"+msg+"'); location.href='list.do';</script>");
			
		} else if (path.equals("/detail.do")) {
			service = new BDetail(); service.exec(request, response);
			request.getRequestDispatcher("board/detail.jsp").forward(request, response);
			
		} else if (path.equals("/edit_view.do")) {
			service = new BEditView(); service.exec(request, response);
			request.getRequestDispatcher("board/update.jsp").forward(request, response);
			
		} else if (path.equals("/edit.do")) {
			service = new BEdit(); service.exec(request, response);
			String result = (String) request.getAttribute("result");
			String msg = "관리자에게 문의";
			if(result.equals("1")) { msg="success"; }
			out.println("<script>alert('"+msg+"'); location.href='detail.do?bno="+request.getParameter("bno")+"';</script>");
			
		} else if (path.equals("/delete.do")) {
			service = new BDelete(); service.exec(request, response);
			String result = (String) request.getAttribute("result");
			String msg = "관리자에게 문의";
			if(result.equals("1")) { msg="success"; }
			out.println("<script>alert('"+msg+"'); location.href='list.do';</script>");
			
		}
	}

}
