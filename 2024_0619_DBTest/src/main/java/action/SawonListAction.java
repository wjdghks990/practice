package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.SawonDao;
import db.vo.SawonVo;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		
		// 사원데이터 가져오기
		List<SawonVo> list = SawonDao.getInstance().selectList();
		
		// request Binding
		request.setAttribute("list", list);

		// Dispatcher형식으로 호출
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
