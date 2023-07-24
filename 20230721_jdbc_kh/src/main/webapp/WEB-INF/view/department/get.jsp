<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 정보</title>
</head>
<body>
	<h1>부서 상세 정보</h1>
	<% 
	DepartmentVo vos = (DepartmentVo)request.getAttribute("department");
	%>
		<table border = "1">
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>부서종류</td>
			<td>개강여부</td>
			<td>수용인원</td>
		</tr>
		<tr>
			<td><%=vos.getDepartmentNo() %></td>
			<td><%=vos.getDepartmentName() %></td>
			<td><%=vos.getCategory() %></td>
			<td><%=vos.getOpenYn() %></td>
			<td><%=vos.getCapacity() %></td>
		</tr>
	</table>
</body>
</html>