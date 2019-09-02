<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../common/js/jquery-3.4.1.min.js">
	
</script>
<style>
label {
	width: 150px;
	background-color: orange;
	display: inline-block;
}

input {
	
}
</style>
</head>

<body>
	<h1>사번 입력</h1>
	<form action="empinsert" method="post">
		<labeL>사번 :</labeL> <input type="number" name="employee_id"><br />
		<labeL>성 :</labeL> <input type="text" name="first_name"><br />
		<labeL>이름 :</labeL> <input type="text" name="last_name"><br />
		<!--예시 넣는 부분  -->
		<labeL>이메일 :</labeL> <input type="text" name="email"
			placeholder="aa@bb.cc"><br /> <labeL>전번 :</labeL> <input
			type="text" name="phone_number" placeholder="010-1234-5678"><br />
		<!-- 이렇게하면 3자리 숫자 - 4자리 숫자 - 3자리 숫자 형식의 전화번호 패턴으로만 저장됨  -->
		<!--<input type = "tel" name ="phone_number" pattern "\d{3} - \d{4} - \d{3}"  -->
		<labeL>입사일 :</labeL> <input type="Date" name="hire_date"><br />

		<labeL>직책:</labeL> <select name="job_id">
			<c:forEach items="${joblist}" var="job">
				<option>${job}</option>
			</c:forEach>
		</select> <br /> <labeL>월급:</labeL> <input type="number" name="salary"><br />
		<labeL>커미션:</labeL> <input type="text" name="commission_pct"><br />
		<label>담당자</label> <select name="manager_id">
			<c:forEach items="${mlist}" var="manager">
				<option value="${manager}">${manager}</option>
			</c:forEach>
		</select> <br/>
		<labeL>부서</labeL> <select name="department_id">
			<c:forEach items="${deptlist}" var="dept">
				<!--실제 들어가는 값  -->
				<!-- >유저에게 보여주는 값<  -->
				<option value="${dept.department_id}">${dept.department_name}</option>
			</c:forEach>
		</select><br/>
		<input type="submit" value="입력하기">


	</form>

</body>

</html>