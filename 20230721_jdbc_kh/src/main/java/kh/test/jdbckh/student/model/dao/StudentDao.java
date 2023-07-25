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
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

public class StudentDao {
// PPT 내용구현
	// DB에서 tb_student 테이블의 전달받은 학번을 통해 학생 1명의 상세정보를 읽어옴.
	public StudentVo selectOneStudent(String studentNo) {
		System.out.println("DAO selectOneStudent() arg:"+ studentNo);
		
		StudentVo result = null;
		String query = "select * from tb_student join tb_department using(department_no) where student_no = "+"'"+studentNo+"'";
	
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
//			if(conn==null) {
//				System.out.println("연결실패");
//			}
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = new StudentVo();
				// While 동작 시킬 필요 없음. Query 결과가 단일행이므로
				result.setAbsenceYn(rset.getString("Absence_Yn"));
				result.setCoachProfessorNo(rset.getString("Coach_Professor_No"));
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setEntranceDate(rset.getString("Entrance_Date"));
				result.setStudentAddress(rset.getString("Student_Address"));
				result.setStudentName(rset.getString("Student_Name"));
				result.setStudentNo(rset.getString("Student_No"));
				result.setStudentSsn(rset.getString("Student_Ssn"));
				result.setDepartmentName(rset.getString("Department_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
//		System.out.println(result);
		
		return result;
	}
	
//	전체 찾기
	public List<StudentVo> selectListStudent() {
		List<StudentVo> result = null;
		String query = "SELECT * FROM TB_STUDENT";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			
			if(conn != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
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
				if(rs!=null) {
					rs.close();
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
		
		System.out.println(result); // 확인용
		return result;
	}
	


//한 명 검색하기
	public List<StudentVo> selectListStudent(String searchWord) {
		List<StudentVo> result = null;
		String query = "SELECT * FROM TB_STUDENT WHERE STUDENT_NAME LIKE ? OR STUDENT_ADDRESS LIKE ?";
	//String query = "SELECT * FROM TB_STUDENT WHERE STUDENT_NAME LIKE '%?%' OR STUDENT_ADDRESS LIKE '%?%'";
		// 1. like 연산자인 경우 위치홀더? 보다 연결자 사용.
	//String query = "SELECT * FROM TB_STUDENT WHERE STUDENT_NAME LIKE '%"+searchWord+"%' OR STUDENT_ADDRESS LIKE '%?%'";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			
			if(conn != null) {
				System.out.println("DB 연결 성공");
			} else {
				System.out.println("DB 연결 실패");
			}
	//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(query);
			searchWord = "%"+searchWord+"%"; // like 연산자인 경우 % 또는 _를 합쳐서 만듬
			pstmt.setString(1, searchWord);
			pstmt.setString(2, searchWord);
			
			rs = pstmt.executeQuery();
			
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
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		System.out.println(result); // 확인용
		return result;
	}
	
	public List<StudentVo> selectListStudent(int currentPage, int pageSize) { // 페이징처리
		List<StudentVo> result = new ArrayList<StudentVo>();
		
		String quertTotalCnt = "select count(*) cnt from tb_student";
		String query = "select tb2.*\r\n "
				+ " from (\r\n "
				+ " select tb1.*, rownum rn\r\n "
				+ " from (\r\n "
				+ " select * from tb_student\r\n "
				+ " ) tb1\r\n "
				+ " ) tb2\r\n "
				+ " where rn between ? and ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int totalCnt = 0; // 총글 갯수
		int startRownum = 0;
		int endRownum = 0;
		
		try {
			conn = getConnection();
			// 총글 갯수 알아오기 위한 query 실행 부분
			pstmt = conn.prepareStatement(quertTotalCnt);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCnt = rs.getInt("cnt");
			}
			System.out.println("총 글갯수 :"+totalCnt);
			startRownum = (currentPage-1)*pageSize +1 ;
			endRownum = currentPage * pageSize > totalCnt ?totalCnt : currentPage * pageSize;
			
			System.out.println("첫 페이지 :"+startRownum);
			System.out.println("마지막 페이지 :"+endRownum);
			
			// conn 생성으로 2개의 query(select)문을 실행할 때
			close(rs);
			close(pstmt);
			
			// 페이지당 글 읽어오기 위한 query 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();
			
//			result = new ArrayList<StudentVo>();
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
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		
		System.out.println(result); // 확인용
		return result;
	}
}


