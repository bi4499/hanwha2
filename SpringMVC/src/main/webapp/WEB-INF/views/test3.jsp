<%@ page contentType="text/html; charset=UTF-8" pageEncoding ="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"%>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
</head>
<body>

<h1>회사명: ${company}</h1>
<h1>부서명: ${dept}</h1>
<h1>이름:${myname}</h1>
<hr>
<form action="paramtest">
ID : <input name="userid" type="number"><br/>
UserName :  <input name="username" type="text"><br/>
<input type="submit" value="서버전송">
</form>

<form action="paramtest2">
ID : <input name="userid" type="number"><br/>
UserName :  <input name="username" type="text"><br/>
<input type="submit" value="서버전송2">
</form>


</body>
</html>
