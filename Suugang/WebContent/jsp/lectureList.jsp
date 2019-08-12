<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>강의리스트</title>
	<!-- 부트스트랩 준비완료 -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
	#select{
		font-color:red;
	}
</style>
</head>
<body>
<div class="container">
	<h3>강의리스트</h3>
	<form method="post" action="lecture_search">
	<input type="text" class="form-control" placeholder="강의명을 입력하세요" name ="lname"/>
	<input type="submit" class="btn btn-primary"  value="검색"/><br />
	</form>
	<form method="post" action="lecture_dept">
	<select name="dno">
	<c:if test="${!empty departmentList}">
			
			<c:forEach var="dept" items="${departmentList}">
				<option value="${dept.dno}">${dept.dname}</option>
			</c:forEach>
			
	</c:if>
	</select>
	<input type="submit" class="btn btn-primary"  value="검색"/><br />
	</form>
	<c:if test="${empty lectureList}">
	<hr />
	검색결과가 존재하지 않습니다.
	<hr /></c:if>
	<c:if test="${!empty lectureList}">
		<table class="table table-striped">
    	<thead>
     	 <tr>
				<th>강좌번호</th>
				<th>강좌명</th>
				<th>취득학점</th>
				<th>강의실</th>
				<th>강의교수</th>
				<th>학과</th>
		</tr>
   		</thead>
   		<tbody>
			<c:forEach var="lecture" items="${lectureList}">
			<tr>
				<td>${lecture.lno}</td>
				<td>${lecture.lname}</td>
				<td>${lecture.credit}</td>
				<td>${lecture.lroom}</td>
				<td>${lecture.pname}</td>
				<td>${lecture.dname}</td>
			</tr>
			</c:forEach>
		</tbody>
		</table>
	</c:if>
	
	
	<a href="memo_input"class="btn btn-primary btn-block">메모저장</a>
	<a href="index.jsp" class="btn btn-primary btn-block">처음 화면으로</a>
	</div>
</body>
</html>