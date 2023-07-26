<%@page import="lclass.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 목록</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<div>
	<form action="<%=request.getContextPath() %>/student/list">
		<input type="search" name="searchWord">
		<input type="submit">
	</form>
	</div>
	
	<%
	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	
	
	if (volist.size() < 1){
	%>
	<h2>결과물이 없습니다.</h2>
	<%
	} else {
	%>
	<table border="1">
		<tr>
			<td>학번</td>
			<td>이름</td>
			<td>입학일</td>
			<td>주소</td>
		</tr>
		<% 
		for(int i=0; i<volist.size(); i++){
			StudentVo vo = volist.get(i);
		
		%>
		<tr>
			<td><%=vo.getStudentNo()%></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getEntranceDate() %></td>
			<td><%=vo.getStudentAddress() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	%>
</body>
</html>