package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Helloaction
 */
@WebServlet("/hello.do")
public class Helloaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,		// 요청처리객체
			HttpServletResponse response	// 응답처리객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("---service()---");
		
		// request : client요청정보 포함
		String ip = request.getRemoteAddr(); // 요청자 IP
		System.out.printf("[%s]님이 요청하셨습니다.\n", ip);
		
		// 응답처리 : [192.168.219.164]님 환영합니다.
		// 동적으로 HTML생성 전달
		
		// 응답할 컨텐츠에 대한 정보 응답헤더를 통해서 클라이언트에 전달
		// mime-type : text/html text/xml application/json image/jpg 
		response.setContentType("text/html; charset=utf-8;"); // utf-8로 설정해야 한글이 깨지지 않는다.
		// 출력스트림(OutputStream) -> 전송객체 얻어옴
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><title>처음실행해본서블릿</title></head>");
		
		out.print("<body>");
		// out.print("Hi~~");
		
		out.printf("<h3>[%s]님 환영합니다</h3>", ip);
		
		out.print("</body>");
		out.print("</html>");
		
	}

}
