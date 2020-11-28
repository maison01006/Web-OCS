<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-between bg-dark">
		<ul class="nav col-6">
			<li class="nav-item"><a class="nav-link" href="main">OCS</a></li>
			<li class="nav-item"><a class="nav-link" href="boardList">공지사항</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="insert">환자등록</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="#">접수</a></li>
		</ul>

		<form class="col-6" action="logout" method="post">
			<div class="row justify-content-end" style="margin-right:10px;">
				<a
					style='background-color: white; width: 160px; height: 30px; text-align: center; border-radius: 10px; margin-top: 4px;'>${userName}님
					환영합니다</a>
				<button class='btn btn-primary' type='sumbit'
					style='border-radius: 10px; margin-left: 5px; margin-right: 5px;'>로그아웃</button>
			</div>
		</form>
	</div>
	<br>
<div class="container">
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성자</th>
      <th scope="col">작성시간</th>
    </tr>
  </thead>
  <tbody>
  
    <tr>
      <th scope="row">1</th>
      <td><a href="/ocs">asd</a></td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
</div>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>