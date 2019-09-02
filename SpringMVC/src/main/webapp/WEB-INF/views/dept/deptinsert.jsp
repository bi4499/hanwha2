<%@ page contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
	
<html>
	
	<head>
	
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../common/js/jquery-3.4.1.min.js">
		</script>
	</head>
	
	<body>
	<h1>부서 입력</h1>									<!--binary file 가져갈때  -->
	<form action="deptinsert" method="post" enctype="multipart/form-data" >
	부서번호 : <input type="number" name="department_id"><br/>
	부서이름 :  <input type="text" name="department_name"><br/>
	
	<input type="file" name="uploadfile"><br/>
	
	

	
	
	
	<input type ="submit" value="입력하기">
	</form>
	
	
	</body>
	
</html>