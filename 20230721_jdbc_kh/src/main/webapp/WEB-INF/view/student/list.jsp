<%@page import="kh.test.jdbckh.student.model.vo.StudentVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 리스트</title>
</head>
<body>
	<h2>학생 리스트</h2>
	<div>
	<form action="<%=request.getContextPath() %>/student/list">
		<input type="search" name="searchWord">
		<input type="submit" name="">
	</form>
	</div>
	<% 

	List<StudentVo> volist = (List<StudentVo>)request.getAttribute("studentList");
	String searchWord = (String)request.getAttribute("searchWord");
	if(searchWord != null){
		%>
		<h3><%=searchWord %>검색결과</h3>
		<h3><a href="<%=request.getContextPath() %>/student/list">전체보기</a></h3>
		<%
	}
	
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
			<td><a href="<%=request.getContextPath()%>/student/get?sno=<%=vo.getStudentNo()%>"><%=vo.getStudentNo()%></a></td>
			<td><%=vo.getStudentName() %></td>
			<td><%=vo.getEntranceDate() %></td>
			<td><%=vo.getStudentAddress() %></td>
		</tr>
		
		<%
		}
		%>
	</table>
	<div>
	<%
		for(int i=1; i<=10; i++)	{
	%>
		<a href="<%=request.getContextPath()%>/student/list?pageNo=<%=i%>"><span><%=i%></span></a>
		,
	<%
	}
	%>
	</div>
	<%
	}
	%>
</body>
</html>