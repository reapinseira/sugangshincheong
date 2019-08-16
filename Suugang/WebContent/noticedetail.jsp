<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
	<meta charset="utf-8">
	<title>공지사항</title>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	
</head>
<body>
	<br/><br/>
	<div class="container">
		<table class="table table-bordered text-center">
			<thead>
				<tr style="height:20px">
					<td style="width:100px">제목</td>
					<td style="width:300px">${notice.ntitle}</td>
				</tr>
				<tr style="height:20px">
					<td>작성자</td>
					<td>${notice.aname}</td>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td colspan="2">${notice.ncontent}</td>
					</tr>
			</tbody>
		</table>
	</div>
</body>
</html>