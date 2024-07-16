package action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.DeptDao;
import db.vo.DeptVo;

/**
 * Servlet implementation class DeptListAction
 */
@WebServlet("/dept/list.do")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// 부서데이터 가져오기
//		List<DeptVo> list = DeptDao.getInstance().selectList();
		DeptVo list1 = DeptDao.getInstance().selectOne(10);
		
		//request binding
//		request.setAttribute("list", list);
		request.setAttribute("list1", list1);

		// Dispatcher형식으로 호출
		//                    webapp/dept/폴더내에 dept_list.jsp생성
		String forward_page = "dept_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
