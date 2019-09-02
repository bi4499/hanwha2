<%@ page contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
					<!--uri = name space 기술 ==> 이걸 만들어서 tag끼리 서로 충돌하는 것을 방지   -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript" src="../common/js/jquery-3.4.1.min.js">
		</script>
		<script>
		function call(){
			//주소창의 주소를 ~를 넣어라
			location.href = "deptinsert";
			alert("부서추가");
			
		}
		
		
		</script>
		
	</head>
	
	<body>
	<h1>부서목록.........${name}</h1>
	<button onclick="call();">부서추가</button>
	<hr>
	
	<table border="1">
	<tr> 
	<td>부서번호</td> <td>부서이름</td>
	</tr>
	<!--향상된 for -->
	<c:forEach var="dept" items = "${deptlist}">
		<tr>
		<!--getter 호출  -->
		<td><a href ="deptdetail?deptid=${dept.department_id}">${dept.department_id}</a></td>
		<td>${dept.department_name}</td>
		<td><a href="deptdelete?deptid=${dept.department_id}">삭제하기</a></td>
		</tr>
	</c:forEach>
	
	
	
	
	
	
	</table>
	
	
	
	
	
	<%--  <%                                             //이 함수 자체가 Object를 리턴하기 때문에 강제로 타입변환 해주어야함 
	List<DeptDTO> deptlist = (List<DeptDTO>)request.getAttribute("deptlist");
		for(DeptDTO dept : deptlist){%>
		<p><%=dept%></p>
	<%}%>--%>
	
	
	
	</body>
	
</html>