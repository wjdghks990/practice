<%@page import="java.util.Calendar"%>
<!-- JSP 헤더 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	// 선언부
	// Java Code를 작성할 수 있는 영역
	int n = 10;
	Calendar now = Calendar.getInstance();

	//멤버메소드
	void sub() {
		
	}	
	
%>   
 
<%
	//Scriptlet: _jspService()내에 기록 - jaca code
	n = 100;
%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	h3{
		color: red;
	}
</style>
</head>
<body>
<hr>
	<h3>나 Test.jsp야</h3>
	<p>n = <%= n %></p>
<hr>
</body>
</html>