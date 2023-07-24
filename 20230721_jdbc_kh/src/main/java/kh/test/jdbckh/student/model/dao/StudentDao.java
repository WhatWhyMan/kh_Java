package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao {
// PPT 내용구현
	
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			
			if(conn != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
//			stmt = conn.createStatement();
			String query = "select * from tb_student";
			pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				System.out.println(rs.getString(("STUDENT_NAME")));
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("student_no"));
				vo.setDepartmentNo(rs.getString("department_no"));
				vo.setStudentName(rs.getString("Student_Name"));
				vo.setStudentSsn(rs.getString("Student_Ssn"));
				vo.setAbsenceYn(rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo(rs.getString("Coach_Professor_No"));
				vo.setStudentAddress(rs.getString("Student_Address"));
				vo.setEntranceDate(rs.getString("entrance_Date"));
				
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
		System.out.println(result);
		return result;
	}
	
	
}
