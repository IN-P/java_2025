package jsp026_frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.front")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FrontController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = request.getServletPath();
		System.out.println("........"+path);
		
		if (path.equals("/a.front")) {System.out.println("A. a처리컨트롤러 호출 B. View");}
		else if (path.equals("/b.front")) {System.out.println("A. b처리컨트롤러 호출 B. View");}
	}
}
// http://localhost:8080/jsp_basic/*.front 콘솔창확인 	/*.front
// http://localhost:8080/jsp_basic/a.front			/a.front
// http://localhost:8080/jsp_basic/b.front			/b.front