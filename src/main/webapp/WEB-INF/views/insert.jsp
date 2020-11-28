<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta nam="viewport" content="width=device-wdith, initial=scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/main.css">
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
	<dlv class="row justify-content-center">
	<form style="margin: 25px;" action="insertPatient.do" method="Post">
		<div class="row">
			<span class="badge badge-secondary">환자정보</span>
			<div class="col" id="info">
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">이름</div>
					<input type="text" name="name" class="col-8">
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">주민번호</div>
					<input type="text" name="regNo" class="col-8">
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">성별</div>
					<div class="btn-group btn-group-toggle justify-content-center col-8"
						data-toggle="buttons">
					<label class="btn btn-secondary col-8 active"> 
						<input type="radio" name="gender" value="남자" id="option1" checked> 남자
					</label> 
					<label class="btn btn-secondary col-8"> 
						<input type="radio" name="gender" value="여자" id="option2"> 여자		
					</label>
					</div>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">나이</div>
					<input type="text" name="age" class="col-8">
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">주소</div>
					<input type="text" name="address" class="col-8">
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">전화번호</div>
					<input type="text" name="tel" class="col-8">
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">혈액형</div>
					<div class="col">

					<select class="form-control col" name="blood" id="major">
						<option value="none">혈액형</option>
						<option>RH+A</option>
						<option>RH-A</option>
						<option>RH+B</option>
						<option>RH-B</option>
						<option>RH+O</option>
						<option>RH-O</option>
						<option>RH+AB</option>
						<option>RH-AB</option>
					</select>
					</div>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">보험구분</div>
					<input type="text" name="insurance" class="col-8">
				</div>
			</div>
		</div>
		<div class="row">
			<button class="btn btn-dark col align-self-center"
				style="margin-top: 5px;" type="submit">등록</button>
		</div>
	</form>
	</dlv>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
</html>