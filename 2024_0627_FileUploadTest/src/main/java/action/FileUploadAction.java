package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload.do")
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// /upload.do?title=제목&photo=a.jpg
		// String saveDir = "F:\\dev\\upload"; // upload 위치
		String webPath  = "/upload/"; // 웹(URL)경로
		
		// 현재 웹어플리케이션의 전역관리객체(상대경로->절대경로)
		ServletContext application = request.getServletContext();
		//				  웹(상대)경로 -> 절대경로 구하기 (과정 꼭 필요!!!)
		String saveDir = application.getRealPath(webPath); 
		System.out.println(saveDir);
		int	   maxSize = 1024 * 1024 * 100; // 최대업로드크기 (100MB)
		// FileUpload객체 => MultipartRequest
		MultipartRequest mr = new MultipartRequest(
										request, 	 // request 위임
										saveDir,     // 저장위치
										maxSize, 	 // 최대업로드크기
										"utf-8", 	 // 수신인코딩
										// 화일이름이 동일할 경우 다른 이름으로 변경시키는 객체
										new DefaultFileRenamePolicy() 
										);	
		// 업로드화일명을 얻어온다
		String filename = "no_file";
		// mr에 의해서 업로드된 화일정보 얻어온다
		File f = mr.getFile("photo");
		
		if(f!=null) { //업로드화일 존재하면
			
			filename = f.getName();
			f.getAbsolutePath();
		}		
			
		// 업로드화일 외에 다른 파라메터는 mr로 수신해야 된다
		String title = mr.getParameter("title");
		//System.out.println(title);
		
		//parameter외의 정보처리시에는 request 사용
		String ip = request.getRemoteAddr();
		// request binding
		request.setAttribute("title", title);
		request.setAttribute("filename", filename);
		
		// Dispatcher형식으로 호출
		String forward_page 	= "result1.jsp";
		RequestDispatcher disp  = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
