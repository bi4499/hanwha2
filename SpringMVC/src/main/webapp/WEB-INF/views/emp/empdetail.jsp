<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
	
	<head>
	
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../common/js/jquery-3.4.1.min.js">
		</script>
	</head>
	
	<body>
	<h1>직원정보 상세보기</h1>
	<form action="empdetail" method="post">
												   <!--값은 보여주는데 수정불가능  -->
		<labeL>사번</labeL> : <input type="number" disabled = "disabled"	name="aa" value="${emp.employee_id}"><br/>
							 <input type="hidden" name="employee_id" value="${emp.employee_id}"><br/>
		<labeL>성 :</labeL> <input type="text" name="first_name" value="${emp.first_name}"><br/>
		<labeL>이름 :</labeL> <input type="text" name="last_name" value="${emp.last_name}"><br/>
		<labeL>이메일 :</labeL> <input type="text" name="email" value="${emp.email}"><br/>
		<labeL>전번 :</labeL> <input type="text" name="phone_number" value="${emp.phone_number}"><br/>
		<!-- 이렇게하면 3자리 숫자 - 4자리 숫자 - 3자리 숫자 형식의 전화번호 패턴으로만 저장됨  -->
		<!--<input type = "tel" name ="phone_number" pattern "\d{3} - \d{4} - \d{3}"  -->
		<labeL>입사일 :</labeL> <input type="Date" name="hire_date" value="${emp.hire_date}"><br/>
		<labeL>직책:</labeL> 
		<select name="job_id">
			<c:forEach items="${joblist}" var="job">
			<option ${emp.job_id==job?"selected":""}>${job}</option>
			</c:forEach>
		</select><br/>
		<labeL>월급:</labeL> <input type="number" name="salary" value="${emp.salary}"><br/>
		<labeL>커미션:</labeL> <input type="text" name="commission_pct" value="${emp.commission_pct}"><br/>
		<labeL>담당자:</labeL> 
		<select name="manager_id">
			<c:forEach items="${mlist}" var="manager">
			<option ${emp.manager_id==manager?"selected":""}>${manager}</option>
			<%-- <option>${manager}</option> --%>
			</c:forEach>
		</select><br/>
		<labeL>부서</labeL> 
		<select name="department_id">
			<c:forEach items="${deptlist}" var="dept">
			<c:if test="${emp.department_id == dept.department_id}">
			<option selected value = "${dept.department_id}">${dept.department_name} </option>
			</c:if>
			<c:if test="${emp.department_id != dept.department_id}">
			<option value = "${dept.department_id}">${dept.department_name} </option>
			</c:if>
			
			</c:forEach>
		</select>
	<input type ="submit" value="입력하기">
	</form>
	
	</body>
	
</html>