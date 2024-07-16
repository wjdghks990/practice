package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.DeptVo;
import service.DBService;

// DAO(Data Access Object)
// Create : insert 추가
// Read	  : select 조회
// Update : update 수정
// Delete : delete 삭제

public class DeptDao {
	
	// single-ton pattern : 객체 1개만 생성해서 이용하자
	static DeptDao single = null;

	public static DeptDao getInstance() {

		//없으면 생성해라
		if (single == null)
			single = new DeptDao();

		return single;
	}

	// 외부에서 객체생성하지 말아라...
	private DeptDao() {

	}
	
	// import정리 : ctrl + shitf + o
	
	// 부서조회
	public List<DeptVo> selectList() {

		List<DeptVo> list = new ArrayList<DeptVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from dept";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어온다
			rs = pstmt.executeQuery();

			while (rs.next()) {

				//저장객체 생성->레코드에서 읽은 값을 넣는다
				DeptVo vo = new DeptVo();

				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
				
				//ArrayList에 추가
				list.add(vo);

			} //end:while

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			//마무리 작업(열린역순으로 닫기)
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}
	
	// 부서 일부만 조회
	// 일부만 조회
	public DeptVo selectOne(int deptno) {

		DeptVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from dept where deptno=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index채우기
			pstmt.setInt(1, deptno);

			//4.ResultSet 얻어온다
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//저장객체 생성->레코드에서 읽은 값을 넣는다
				vo = new DeptVo();

				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));

			} //end:if

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			//마무리 작업(열린역순으로 닫기)
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return vo;
	}
	
}
