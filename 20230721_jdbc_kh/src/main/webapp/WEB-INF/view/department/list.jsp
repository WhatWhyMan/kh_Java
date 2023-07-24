<%@page import="kh.test.jdbckh.department.model.vo.DepartmentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 목록</title>
</head>
<body>

	<h1>부서 목록</h1>
	<%
	List<DepartmentVo> volist = (List<DepartmentVo>)request.getAttribute("departmentList");
	%>
	<table border = "1">
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>부서종류</td>
			<td>개강여부</td>
			<td>수용인원</td>
		</tr>
		<%
		for (int i=0; i < volist.size(); i++){
			DepartmentVo vo = volist.get(i);
		
		%>
		<tr>
			<td><a href="<%=request.getContextPath() %>/department/get?sno=<%=vo.getDepartmentNo() %>"><%=vo.getDepartmentNo()%></a></td>
			<td><%=vo.getDepartmentName() %></td>
			<td><%=vo.getCategory() %></td>
			<td><%=vo.getOpenYn() %></td>
			<td><%=vo.getCapacity() %></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>