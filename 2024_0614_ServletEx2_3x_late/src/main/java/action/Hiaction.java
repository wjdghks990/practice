package action;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hiaction
 */
@WebServlet("/hi.do")
public class Hiaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,  // Client -> Server 요청정보			
			HttpServletResponse response // server -> Client 전송
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// http://localhost:8080/2024_0614_ServletEx2_3x_late/hi.do?nation=kor - 쿼리를 통해 요구사항을 요청함
		//                                                         ?query
		//                                                          parameter(전달인자)
		//                                                          parameter name : nation
		
		// Client측에서 들어온 정보 처리(request) : query를 통해서 전달된 정보는 무조건 String
		String nation = request.getParameter("nation"); // 안들어오던지 철자틀리면 null
		
		if(nation==null)nation="kor";
		
		// nation=kor eng jpn chn ger fra
		
		String nation_name = "";
		String greeting = "";
		
		switch (nation) {
		case "kor": nation_name = "한국"; greeting="안뇽"; break;
		case "eng": nation_name = "미국/영국"; greeting="hi~"; break;
		case "jpn": nation_name = "일본"; greeting="おはよう"; break;
		case "chn": nation_name = "중국"; greeting="你好"; break;
		case "ger": nation_name = "독일"; greeting="Guten Tag"; break;
		case "fra": nation_name = "불란서"; greeting="bonjour"; break;
		default : nation_name = "어디임?"; greeting="몰루~";
		}
		
		String msg = String.format("<h3>[%s]어 인사말은 [%s]입니다</h3>", nation_name, greeting);
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8;");
		
		// 응답처리 객체 얻어온다
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		out.print(msg);
		out.print("<a href='hi.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
	}	
}
