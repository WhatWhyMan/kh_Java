<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 상세 정보</title>
</head>
<body>
	<h1>학생 상세 정보</h1>
	<% 
	String a = (String)request.getAttribute("aaa");
	String b = (String)request.getAttribute("bbb");
	int c = (int)request.getAttribute("ccc");
	StudentVo vos = (StudentVo)request.getAttribute("student");
	%>
	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>학과이름</td>
			
		</tr>
		<tr>
			<td><%=vos.getStudentNo() %></td>
			<td><%=vos.getStudentName() %></td>
			<td><%=vos.getDepartmentName() %></td>
		</tr>
	</table>
</body>
</html>