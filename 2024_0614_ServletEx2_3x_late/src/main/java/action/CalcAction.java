package action;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, // 요청처리객체(client -> server)
			HttpServletResponse response// 응답처리객체(server -> client)
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// http://localhost:8080/2024_0614_ServletEx2_3x_late/hi.do?su1=10&su2=5
		
		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		
		int plus = su1 + su2;
		int minus = su1 - su2;
		int multiply = su1 * su2;
		int divide = su1 / su2;
		int remain = su1 % su2;
		
		String msg = String.format("<h3>%d 와(과) %d의 계산결과</h3>", su1, su2);
		String plusMsg = String.format("<p>%4d + %4d = %d</p>", su1, su2, plus);
		String minusMsg = String.format("<p>%4d - %4d = %d</p>", su1, su2, minus);
		String multiplyMsg = String.format("<p>%4d * %4d = %d</p>", su1, su2, multiply);
		String divideMsg = String.format("<p>%4d / %4d = %d</p>", su1, su2, su2==0 ? 0 : divide);
		String remainMsg = String.format("<p>%4d %% %4d = %d</p>", su1, su2, su2==0 ? 0 : remain);
		
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>계산기</title></head>");
		out.print("<body>");
		out.println(msg);
		out.println(plusMsg);
		out.println(minusMsg);
		out.println(multiplyMsg);
		out.println(divideMsg);
		out.println(remainMsg);		
		out.print("<a href='calc.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
		
	}

}
