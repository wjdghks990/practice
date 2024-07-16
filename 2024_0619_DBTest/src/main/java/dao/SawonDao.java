package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.SawonVo;
import service.DBService;

public class SawonDao {

	// single-ton pattern : 객체 1개만 생성해서 이용하자
	static SawonDao single = null;

	public static SawonDao getInstance() {

		//없으면 생성해라
		if (single == null)
			single = new SawonDao();

		return single;
	}

	// 외부에서 객체생성하지 말아라...
	private SawonDao() {

	}
	
	// 사원 조회
	public List<SawonVo> selectList() {

		List<SawonVo> list = new ArrayList<SawonVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet 얻어온다
			rs = pstmt.executeQuery();

			while (rs.next()) {

				//저장객체 생성->레코드에서 읽은 값을 넣는다
				SawonVo vo = new SawonVo();

				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire").substring(0, 10));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				

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
	
	// 일부만 조회
	public SawonVo selectOne(int sabun) {

		SawonVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon where sabun=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter index채우기
			pstmt.setInt(1, sabun);

			//4.ResultSet 얻어온다
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//저장객체 생성->레코드에서 읽은 값을 넣는다
				vo = new SawonVo();

				//rs가 가리키는 레코드값을 vo에 넣는다
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire").substring(0, 10));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));

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
