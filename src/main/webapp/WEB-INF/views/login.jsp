<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-wdith, initial=scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
<div class = "container" style="margin-top:100px; width: 600px; text-align: center; font-size: 100px;">
ocs</div>
<form class="container" style="margin-top:100px; width:400px;" action="login.do" method="Post">
<div class="col align-self-center">
  <div class="form-group">
    <label for="exampleInputEmail1">아이디</label>
    <input type="text" class="form-control" name="id" id="id" aria-describedby="emailHelp">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">비밀번호</label>
    <input type="password" class="form-control" name="password" id="password">
  </div>
  <button type="submit" class="btn btn-primary">로그인</button>
  </div>
</form>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</html>