package jsp_basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/user_login")
public class Jsp025_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Jsp025_Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		//1. 데이터 넘겨받기
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		//2. DBManager 연동
		DBManager db = new DBManager();
		Connection conn = db.getConnection();
		//3. connection Sql 구문처리
		PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select count(*) as `cnt` from member where id=? and pass=?;";
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rset = pstmt.executeQuery();
			if (rset.next()) {result = rset.getInt("cnt");}
			
			if (result==1) {
				HttpSession session = request.getSession();
				out.println("<script>alert('login success'); location.href='jsp025_my.jsp';</script>");
				session.setAttribute("id",id);			
			} else {
				out.println("<script>alert('정보를 확인해주세요'); history.go(-1);</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) { try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if (pstmt != null) { try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }} 
			}
	}
}
