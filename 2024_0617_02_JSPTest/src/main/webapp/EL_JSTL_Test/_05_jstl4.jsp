<%@page import="java.util.ArrayList"%>
<%@page import="vo.Personvo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

<%
	List<Personvo> p_list = new ArrayList<>();
	p_list.add(new Personvo("일길동",31,"서울 관악 신림1동"));
	p_list.add(new Personvo("이길동",32,"서울 관악 신림2동"));
	p_list.add(new Personvo("삼길동",33,"서울 관악 신림3동"));
	p_list.add(new Personvo("사길동",34,"서울 관악 신림4동"));
	p_list.add(new Personvo("오길동",35,"서울 관악 신림5동"));

	//request.binding
	request.setAttribute("p_list", p_list);
	
	
%> 

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<!-- table title -->
	<tr>
		<th>순번</th>
		<th>이름</th>
		<th>나이</th>
		<th>주소</th>
	</tr>
	
	<!-- table data -->
	<!-- for(PersonVo p: p_list) 동일함 -->
	<c:forEach var="p" items="${ p_list }" varStatus="i">
	<tr>
		<td>${ i.count }</td>
		<td>${ p.name }</td>
		<td>${ p.age }</td>
		<td>${ p.addr }</td>
	</tr>
	</c:forEach>
</table>



</body>
</html>