package lclass.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lclass.student.model.vo.StudentVo;

public class StudentDao {

	// 전체 보기
	public List<StudentVo> selectListStudent() {
		
		List<StudentVo> result = null;
		String query = "SELECT * FROM TB_STUDENT";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
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
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
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
	
