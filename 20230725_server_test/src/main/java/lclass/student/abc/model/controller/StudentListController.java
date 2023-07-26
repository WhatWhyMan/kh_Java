package lclass.student.abc.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lclass.student.model.dao.StudentDao;
import lclass.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/student/list")
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String searchWord = request.getParameter("searchWord");
		
		StudentDao dao = new StudentDao();
		List<StudentVo> result = null;
		
			result = dao.selectListStudent();
			
			
			request.setAttribute("studentList", result);
//			if(searchWord != null) {
//				request.setAttribute("searchWord", searchWord);
//			}
		
//		if(searchWord!=null) {
//			result = dao.selectListStudent(searchWord);
//		} else {
//			
//		}
			
		
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}

}
