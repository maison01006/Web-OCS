<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/main.css">
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;">
<div class="container col" style="margin: 0px; padding:0px;">
	<div class="row justify-content-between bg-dark">
		<ul class="nav col">
			<li class="nav-item"><a class="nav-link" href="#">OCS</a></li>
			<li class="nav-item"><a class="nav-link" href="boardList">공지사항</a>	</li>
			<li class="nav-item"><a class="nav-link" href="insert">환자등록</a></li>
			<li class="nav-item"><a class="nav-link" href="#">접수</a></li>
			<li class="nav-item"><a class="nav-link" href="receipt">수납</a></li>
		</ul>

		<form class="col" action="logout" method="post">
			<div class="row justify-content-end" style="margin-right:10px;">
				<a
					style='background-color: white; width: 160px; height: 30px; text-align: center; border-radius: 10px; margin-top: 4px;'>${userName}님
					환영합니다</a>
				<button class='btn btn-primary' type='sumbit'
					style='border-radius: 10px; margin-left: 5px; margin-right: 5px;'>로그아웃</button>
			</div>
		</form>
	</div>
</div>
	<br>
	<div class="container">
		<div class="form-group row float-right">
			<div class="col-xs-8">
				<input class="form-control" id="name" name="name" type="text"
					size="20">
			</div>
			<div class="col-xs-2">
				<button class="btn btn-primary" onclick="searchFunction();"
					type="button">검색</button>
			</div>
		</div>
		<table class="table"
			style="text-align: center; border: 1px solid #dddddd;">
			<thead>
				<tr>
					<th style="background-color: #fafafa; text-align: center;">ID</th>
					<th style="background-color: #fafafa; text-align: center;">성별</th>
					<th style="background-color: #fafafa; text-align: center;">주민번호</th>
					<th style="background-color: #fafafa; text-align: center;">주소</th>
					<th style="background-color: #fafafa; text-align: center;">환자명</th>
					<th style="background-color: #fafafa; text-align: center;">나이</th>
					<th style="background-color: #fafafa; text-align: center;">휴대폰번호</th>
				</tr>
			</thead>
			<tbody id="ajaxTable">
			</tbody>
		</table>
	</div>
	<form action="insertReceive.do" class="col" method="post">
		<div class="row" >
			<span class="badge badge-secondary">환자정보</span>
			<div class="col" id="info">
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">ID</div>
					<input type="text" class="col" name="patientId" readonly >
					<div class="d-inline p-2 bg-dark text-white">환자명</div>
					<label class="col"></label>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">성별</div>
					<label class="col"></label>
					<div class="d-inline p-2 bg-dark text-white">나이</div>
					<label class="col"></label>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">주민번호</div>
					<label class="col"></label>
					<div class="d-inline p-2 bg-dark text-white">휴대폰번호</div>
					<label class="col"></label>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">주소</div>
					<label class="col"></label>
				</div>
				<div class="row" style="height: 133px;">
					<div class="d-inline p-2 bg-dark text-white">특이사항</div>
					<label class="col"></label>
				</div>
			</div>
			<span class="badge badge-secondary">의사정보</span>
			<div class="col" id="info">
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">진료부서</div>
					<select class="form-control col" id="major"
						onchange="changeOption()">
						<option value="none">진료부서</option>
					</select>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">진료의사</div>
					<input type="hidden" name="userId" class="doc">
					<select class="form-control col" id="doc-name" onchange="changeDocId()">
						<option value="none">진료의사</option>

					</select>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">접수분류</div>
					<div
						class="btn-group btn-group-toggle justify-content-center col-10"
						data-toggle="buttons">
						<label class="btn btn-secondary col-3 active"> <input
							type="radio" name="fmyn" id="option1" value="초진" checked> 초진
						</label> <label class="btn btn-secondary col-3"> <input
							type="radio" name="fmyn" id="option2" value="재진"> 재진
						</label>
					</div>
				</div>
				<div class="row">
					<div class="d-inline p-2 bg-dark text-white">참고사항</div>
					<div class="justify-content-center col-10">
						<textarea rows="5" cols="50" style="margin-top: 3px;" name="treatStatus"></textarea>
						<div>
							<button class="btn btn-dark" type="submit">접수</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">
	var a = "";
	var request = new XMLHttpRequest();
var data="";
	function searchFunction() {
		if (document.getElementById("name").value == "" || "${userName}" == "")
			return;
		request.open("Get", "./getPatient?patientName="
				+ encodeURIComponent(document.getElementById("name").value),
				true);
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	function searchProcess() {
		var table = document.getElementById("ajaxTable");
		table.innerHTML = "";
		if (request.readyState == 4 && request.status == 200) {
			data = JSON.parse(request.responseText);
			for (var i = data.length-1; i >= 0; i--) {
				var row = table.insertRow(0);
				row.addEventListener("click", function(evt) {
					showPatientInfo(data[evt.currentTarget.rowIndex - 1],
							evt.currentTarget.firstChild.innerText)
				})
				for (var j = 0; j < 6; j++) {
					var cell = row.insertCell(j);
					cell.innerHTML = data[i][j];
				}
				var cell = row.insertCell(6);
				cell.innerHTML = "010" + data[i][6];
			}

		}
	}

	function showPatientInfo(data, num) {
		var div = document.getElementById('info');
		console.log(data);
		for (var i = 0; i < 3; i++) {
			div.children[i].children[1].innerText = data[i];
			div.children[i].children[3].innerText = data[i + 4];
		}
		div.children[0].children[1].value = data[0];
		div.children[3].children[1].innerText = data[3];
		div.children[4].children[1].innerText = data[7];
	}
</script>
<script type="text/javascript">
var docData="";
var select = document.getElementById("major");
var docSelect = document.getElementById("doc-name");
var doc = document.getElementsByClassName("doc");
	var majorRequest = new XMLHttpRequest();
	var docRequest = new XMLHttpRequest();
	function majorFunction() {
		majorRequest.open("Get", "./getMajor", true);
		majorRequest.onreadystatechange = majorProcess;
		majorRequest.send(null);
	}
	function majorProcess() {
		var div = document.getElementById('major');
		if (majorRequest.readyState == 4 && majorRequest.status == 200) {
			var data = JSON.parse(majorRequest.responseText);
			for(var i=1; i<data.length;i++){
				var option=document.createElement('option');
				option.innerText=data[i][1];
				div.append(option);
			}
		}
	}
	function changeOption() {
		
		while(docSelect.childElementCount!=1){
			docSelect.removeChild( docSelect.lastChild );

			
		}
		
		
		docRequest.open("Get", "./getDoc?id="+encodeURIComponent(select.selectedIndex+1), true);
		docRequest.onreadystatechange = docProcess;
		docRequest.send(null);
		console.log(select.selectedIndex);
	}
	function changeDocId(){
		doc[0].value = docData[docSelect.selectedIndex-1]['id'];
	}
	function docProcess() {
		if (docRequest.readyState == 4 && docRequest.status == 200) {
			docData = JSON.parse(docRequest.responseText);
			
			for(var i=0; i<docData.length;i++){
				var option=document.createElement('option');
				option.innerText=docData[i]['name'];
				docSelect.append(option);
			}
		}
	}
	window.onload = function(){
		majorFunction();
	}
</script>