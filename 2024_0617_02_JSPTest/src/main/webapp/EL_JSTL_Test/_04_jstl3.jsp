<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL Core -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 배열
	String[] sido_array = {"서울", "경기", "인천", "대전", "강원"};

	// ArrayList
	List<String> fruit_list = new ArrayList<>();
	fruit_list.add("사과");
	fruit_list.add("참외");
	fruit_list.add("수박");
	fruit_list.add("딸기");

	// request binding
	request.setAttribute("sido_array", sido_array);
	request.setAttribute("fruit_list", fruit_list);
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	시도목록
<hr>
	<ul>
		<!--       			  items : 배열/컬렉션/Map               -->
		<!-- for(String sido: sido_array)와 동일한 코드 -->
		<c:forEach var="sido" items="${ requestScope.sido_array }" >
			<li>${ pageScope.sido }</li>
		</c:forEach>
	</ul>

<hr>
	과일목록
<hr>
	<ul>
		<!--  for(int i =0; i<fruit.size(); i++)-->
		<!--  for(String fruit : fruit_list) 동일    
													   varStatus=> index (첨자)
													   			   count (반복회수)
				JSTL내에 기록되는 값(변수) 표현시(EL) 절대 공백띄우지 말것
				*** 중요
		JSTML 내에서 사용되는 변수는 반드시 EL표현식으로 표현하게 되어있다.	
		EL표현값 scope영역중에 있어야 표현가능
		***									   			   
		-->
		<c:forEach var="fruit" items="${ fruit_list }" varStatus="i">
			<li>${ i.count } 번째 : ${ fruit }(${ i.index })</li>
		</c:forEach>
	</ul>

</body>
</html>