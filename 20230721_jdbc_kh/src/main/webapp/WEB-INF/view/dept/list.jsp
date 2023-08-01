<%@page import="kh.test.jdbckh.department.model.dto.DepartmentDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 리스트</title>
</head>
<body>
	<h1>학과 리스트</h1>
	<form action="<%=request.getContextPath() %>/dept/get" method="get">
		학과 번호 : <input type="text" name="departmentNo"> <input type="submit" value="찾기">
	</form>

	<%
		List<DepartmentDto> volist = (List<DepartmentDto>)request.getAttribute("deptList");
	%>

	<table border="1">
		<tr>
			<td>학과번호</td>
			<td>학과이름</td>
			<td>계열</td>
			<td>개설여부</td>
			<td>정원</td>
		</tr>
		
	<%
		for(int i = 0; i<volist.size(); i++) {
			DepartmentDto dto = volist.get(i);
	%>
		<tr>
			<td><%=dto.getDepartmentNo() %></a></td>
			<td><%=dto.getDepartmentName() %></td>
			<td><%=dto.getCategory() %></td>
			<td><%=dto.getOpenYn() %></td>
			<td><%=dto.getCapacity() %></td>
		</tr>
	<%
		}
	%>
	
	</table>






























<%-- 	<h2>학과 리스트</h2>
	<div>
		<form action="<%=request.getContextPath() %>/dept/get" method="get">
			학과 번호 : <input type="text" name="departmentNo"><br>
			<input type="submit" value="찾기">
		</form>
	</div>
[[ ${deptList }]]
	<table border="1">
		<tr>
			<td>학과번호</td>
			<td>학과이름</td>
			<td>계열</td>
			<td>개설여부</td>
			<td>정원</td>
		</tr>
	</table> --%>
</body>
</html>