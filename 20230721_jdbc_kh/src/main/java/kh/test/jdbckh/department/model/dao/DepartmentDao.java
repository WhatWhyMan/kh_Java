package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import kh.test.jdbckh.department.model.vo.DepartmentVo;

public class DepartmentDao {
	
	public DepartmentVo selectOneDepartment(String departmentNo) {
		System.out.println("DAO selectOneDepartment() arg:"+ departmentNo);
		
		DepartmentVo result = null;
		String query = "select * from tb_department where department_no = "+"'"+departmentNo+"'";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new DepartmentVo();
				result.setDepartmentNo(rset.getString("department_No"));
				result.setDepartmentName(rset.getString("department_Name"));
				result.setCategory(rset.getString("category"));
				result.setOpenYn(rset.getString("open_Yn"));
				result.setCapacity(rset.getString("capacity"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null)	rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	
	public List<DepartmentVo> selectListDepartment() {
		List<DepartmentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
//			if(conn != null) {
//				System.out.println("DB 연결 성공");
//			} else {
//				System.out.println("DB 연결 실패");
//			}
//			stmt = conn.createStatement();
			String query = "select * from tb_department";
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = new ArrayList<DepartmentVo>();
			while(rs.next() == true) {
				System.out.println(rs.getString(("DEPARTMENT_NAME")));
				DepartmentVo vo = new DepartmentVo();
				vo.setDepartmentNo(rs.getString("department_no"));
				vo.setDepartmentName(rs.getString("department_name"));
				vo.setCategory(rs.getString("category"));
				vo.setOpenYn(rs.getString("open_yn"));
				vo.setCapacity(rs.getString("capacity"));
				
				result.add(vo);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}