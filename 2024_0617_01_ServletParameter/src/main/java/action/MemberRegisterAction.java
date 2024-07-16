package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MemberRegisterAction
 */

/* url-pattern 문제발생 : LifeException발생 
   1. 서블릿 매핑에서 유효하지 않은 <url-pattern> ; /xxx.do
   2. <url-pattern> 중복되는 경우
*/

@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// /member_resgister.do?name=홍길동&id=asdf1&pwd=1234&gender=남자&firend=&firend=&firend=&blood=A형&profile=3
		
		// 0. 수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 1. parameter 받기
		String name 	= request.getParameter("name");
		String id 		= request.getParameter("id");
		String pwd 		= request.getParameter("pwd");
		String gender 	= request.getParameter("gender");
		String blood 	= request.getParameter("blood");
		String profile 	= request.getParameter("profile");
		
		// parameter이름이 동일한 이름으로 들어온 경우에는 배열로 받는다
		// checkbox : 체크된 목록만 넘어온다(체크항목이 없으면 null)
		String[] hobbyArr  = request.getParameterValues("hobby");	
		//						hobby=독서&hobby=영화
		//							0		1
		// String[] hobbyArr  = {"독서","영화"};
		
		//취미목록
		String hobbyList = "취미없음";
		if(hobbyArr != null) {
			
			StringBuffer sb = new StringBuffer();
			for(String hobby : hobbyArr) {
				// 메모리 낭비 줄임
				sb.append(hobby);
				sb.append(" ");
			}
			
			hobbyList = sb.toString().trim();
		}
//		-------------------------------------------------------------------------------		
		
		// input : 모든값이 넘어옴
		String[] friendArr = request.getParameterValues("friend");
		//					 friend=&friend=&friend=
		// String[] friendArr = {"", "", ""}; 	
		String friendList = "";
		
		StringBuffer sb1 = new StringBuffer(); // StringBuffer(느리다) vs StringBulider(빠르다)
		for(String friend : friendArr) {
			sb1.append(friend);
			sb1.append(" ");
		}
		
		friendList = sb1.toString().trim();
		
		if(friendList.isEmpty()) friendList = "친구없음";
		
		// 응답처리
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<table border='1'>");
		
		out.printf("<tr><th>이름</th><td> %s </td></tr>", name);
		out.printf("<tr><th>아이디</th><td> %s </td></tr>", id);
		out.printf("<tr><th>비밀번호</th><td> %s </td></tr>", pwd);
		out.printf("<tr><th>성별</th><td> %s </td></tr>", gender);
		out.printf("<tr><th>취미</th><td> %s </td></tr>", hobbyList);
		out.printf("<tr><th>친구</th><td> %s </td></tr>", friendList);
		out.printf("<tr><th>혈액형</th><td> %s </td></tr>", blood);
		out.printf("<tr><th>자기소개</th><td> %s </td></tr>", profile);
		out.printf("<tr><td colspan='2'><a href ='input.html'>다시하기</a></td></tr>");
		
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
