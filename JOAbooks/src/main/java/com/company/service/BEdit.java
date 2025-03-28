package com.company.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.dao.BoardDao;
import com.company.domain.BoardVO;

public class BEdit implements BoardService {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BoardDao dao = new BoardDao();
		BoardVO vo = new BoardVO();
		int bno = Integer.valueOf(request.getParameter("bno"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		vo.setBtitle(btitle);
		vo.setBcontent(bcontent);
		vo.setBno(bno);
		
		request.setAttribute("result",String.valueOf(dao.update(vo)));
	}
}
