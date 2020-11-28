<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta nam="viewport" content="width=device-wdith, initial=scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body>
	<div class="row justify-content-between bg-dark" style="margin:0px;">
		<ul class="nav col-6">
			<li class="nav-item"><a class="nav-link" href="#">OCS</a></li>
			<li class="nav-item"><a class="nav-link" href="boardList">공지사항</a>	</li>
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
	<div class="container row col" style="margin:0px;">
		<div class="col row">
			<span class="badge badge-secondary">환자정보</span>
			<div class="col" style="padding:0px; border: 1px solid #dddddd;">
				<table class="table"style="text-align: center; border: 1px solid #dddddd;">
					<thead>
						<tr>
							<th style="background-color: #fafafa; text-align: center;">환자명</th>
							<th style="background-color: #fafafa; text-align: center;">성별</th>
							<th style="background-color: #fafafa; text-align: center;">주민번호</th>
							<th style="background-color: #fafafa; text-align: center;">나이</th>
							<th style="background-color: #fafafa; text-align: center;">혈액형</th>
						</tr>
					</thead>
					<tbody id="receiveTable">
					</tbody>
				</table>
			</div>
		</div>
		<div class="col row">
			<span class="badge badge-secondary">검사목록</span>
			<form class="col" action="fileupload.do" method="post" enctype="multipart/form-data" style="padding:0px; border: 1px solid #dddddd;">
				<table class="table"style="text-align: center; border: 1px solid #dddddd;">
					<thead>
						<tr>
							<th style="background-color: #fafafa; text-align: center;">검사코드</th>
							<th style="background-color: #fafafa; text-align: center;">검사이름</th>
							<th style="background-color: #fafafa; text-align: center;">업로드</th>
						</tr>
					</thead>
					<tbody id="injecTable">
					</tbody>
				</table>
				<div class="row justify-content-center">
					<input class="receive-id" name="receiveId" type="hidden">					
					<button class="btn btn-dark" type="submit">처방하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">
var request = new XMLHttpRequest();
var injecRequest = new XMLHttpRequest();
function patientFunction() {
	request.open("Get", "./getInjectionPatient",true);
	request.onreadystatechange = patientProcess;
	request.send(null);
}
function patientProcess() {
	var table = document.getElementById("receiveTable");
	var hidden = document.getElementsByClassName("receive-id");
	table.innerHTML = "";
	if (request.readyState == 4 && request.status == 200) {
		const data = JSON.parse(request.responseText);
		for (var i = data.length-1; i >= 0; i--) {
			var row = table.insertRow(0);
			row.addEventListener("click", function(evt) {
				console.log(data[evt.currentTarget.rowIndex - 1][5]);
				hidden[0].value=data[evt.currentTarget.rowIndex - 1][5];
				injectionFunction(data[evt.currentTarget.rowIndex - 1])
			})
			for (var j = 0; j < 5; j++) {
				var cell = row.insertCell(j);
				cell.innerHTML = data[i][j];
			}
		}

	}
}
function injectionFunction(data){
	
	injecRequest.open("Get", "./getInjectionPrescription?receiveId="+encodeURIComponent(data[5]),true);
	injecRequest.onreadystatechange = injectionProcess;
	injecRequest.send(null);
}
function injectionProcess() {
	var table = document.getElementById("injecTable");
	table.innerHTML="";
	if (injecRequest.readyState == 4 && injecRequest.status == 200) {
		const data = JSON.parse(injecRequest.responseText);
		console.log(data);
		for (var i = data.length-1; i >= 0; i--) {
			var row = table.insertRow(0);
			for (var j = 0; j < 2; j++) {
				var cell = row.insertCell(j);
				cell.innerHTML = data[i][j];
			}
			var cell = row.insertCell(2);
			cell.innerHTML ="<input type='file' name='uploadFile'> ";
		}

	}
}
window.onload = function(){
	patientFunction();
}
</script>
</html>