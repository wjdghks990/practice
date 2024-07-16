<%@page import="service.DBService"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Connection conn = DBService.getInstance().getConnection();

	System.out.println("--success--");
	
	conn.close(); /* 사용하면 커넥션을 닫아줘야 함 */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>