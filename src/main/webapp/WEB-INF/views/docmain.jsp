<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta nam="viewport" content="width=device-width, initial=scale=1">
<link rel="stylesheet" href="resources/css/bootstrap.css">
<title>Insert title here</title>
</head>
<body style="margin:0px 20px 0px 20px;overflow-x:hidden;">
	<div class="row justify-content-between bg-dark">
		<ul class="nav col-6">
			<li class="nav-item"><a class="nav-link" href="docmain">OCS</a></li>
			<li class="nav-item"><a class="nav-link" href="boardList">공지사항</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="insert">처방</a></li>
			<li class="nav-item"><a class="nav-link" href="#">진료내역</a></li>
			<li class="nav-item"><a class="nav-link" href="#">영상판독</a></li>
		</ul>

		<form class="col-6" action="logout" method="post">
			<div class="row justify-content-end" style="margin-right: 10px;">
				<a
					style='background-color: white; width: 160px; height: 30px; text-align: center; border-radius: 10px; margin-top: 4px;'>${userName}님
					환영합니다</a>
				<button class='btn btn-primary' type='sumbit'
					style='border-radius: 10px; margin-left: 5px; margin-right: 5px;'>로그아웃</button>
			</div>
		</form>
	</div>
	<br>
		
		<div class="row">
			<div class="col row" style="padding:10px 0px 0px 0px; border:1px solid #dddddd; margin:0px;">
				<span class="badge badge-secondary ">환자정보</span>
					<div class="col" style="padding:0px;" id="info">
						<div class="row col" >
							<div class="row col">
								<label class="bg-dark text-white" style="width: 100px; margin:0px; text-align: center;">이름</label> 
								<label class="col" style="margin:0px;"></label>
							</div> 
							<div class="row col">
								<label class="bg-dark text-white" style="width: 100px; margin:0px; text-align: center;">주민번호</label>
								<label class="col" style="margin:0px;"></label>
							</div>
							<div class="row col"> 
								<label class="bg-dark text-white"style="width: 100px; margin:0px; text-align: center;">성별</label> 
								<label class="col" style="margin:0px;"></label>
							</div>
						</div>
						<div class="row col">
							<div class="row col">
								<label class="bg-dark text-white" style="width: 100px; margin:0px; text-align: center;">혈액형</label> 
								<label class="col" style="margin:0px;"></label>
							</div> 
							<div class="row col">
								<label class="bg-dark text-white" style="width: 100px; margin:0px; text-align: center;">주소</label>
								<label class="col" style="margin:0px;"></label>
							</div>
							<div class="row col"> 
								<label class="bg-dark text-white"style="width: 100px; margin:0px; text-align: center;">특이사항</label> 
								<label class="col" style="margin:0px;"></label>
							</div>
						</div> 
					<div class="row"></div>
				</div>
			</div>
			<div class="row col" style="padding:10px 0px 0px 0px; border:1px solid #dddddd; margin:0px;">
				<div class="row col">
					<span class="badge badge-secondary ">진료<br>대기인원</span>
					<div class="col" style="padding:0px; ">
						<table class="table"style="text-align: center; border: 1px solid #dddddd;">
							<thead>
								<tr>
									<th style="background-color: #fafafa; text-align: center;">NO</th>
									<th style="background-color: #fafafa; text-align: center;">환자명</th>
									<th style="background-color: #fafafa; text-align: center;">초진/재진</th>
								</tr>
							</thead>
							<tbody id="receiveTable">
							</tbody>
						</table>
					</div>
				</div>
				<div class="row col">
					<span class="badge badge-secondary ">검사<br>대기인원</span>
					<div class="col" style="padding:0px; ">
						<table class="table"style="text-align: center; border: 1px solid #dddddd;">
							<thead>
								<tr>
									<th style="background-color: #fafafa; text-align: center;">NO</th>
									<th style="background-color: #fafafa; text-align: center;">환자명</th>
									<th style="background-color: #fafafa; text-align: center;">초진/재진</th>
								</tr>
							</thead>
							<tbody id="receiveInjTable">
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="row col" style="padding:10px 0px 0px 0px; border:1px solid #dddddd; margin:0px;">
				<span class="badge badge-secondary ">의료내역</span>
				<input type="hidden" id="pastReceiveId">
				<div class="col" style="padding:0px;">
					<table id="table" class="table"style="text-align: center; border: 1px solid #dddddd;">
						<thead>
							<tr>
								<th style="background-color: #fafafa; text-align: center;">NO</th>
								<th style="background-color: #fafafa; text-align: center;">상병명</th>
								<th style="background-color: #fafafa; text-align: center;">약품명</th>
								<th style="background-color: #fafafa; text-align: center;">검사명</th>
								<th style="background-color: #fafafa; text-align: center;">접수날짜</th>
							</tr>
						</thead>
						<tbody id="tbody">
							
						</tbody>
					</table>
				
				</div>
			</div>
			<div class="row col" style="padding:10px 0px 0px 0px; border:1px solid #dddddd; margin:0px;">
					<span class="badge badge-secondary ">처방목록</span>
					<div>
					<form action="insertPrescription.do" method="post">
						<div class="col" style="padding:0px; ">
							<div class="row col">
								<button class="btn-dark" type="button" onclick="window.open('disease','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">상병 처방</button>
								<button class="btn-dark" type="button" onclick="window.open('drug','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">약 처방</button>
								<button class="btn-dark" type="button" onclick="window.open('injection','window_name','width=430,height=500,location=no,status=no,scrollbars=yes');">검사 처방</button>
					
							</div>
							<div class="bg-dark text-white">상병 처방 정보</div>
							<table class="table"style="text-align: center; border: 1px solid #dddddd;">
								<thead>
									<tr>
										<th style="background-color: #fafafa; text-align: center;">주</th>
										<th style="background-color: #fafafa; text-align: center;">R/O</th>
										<th style="background-color: #fafafa; text-align: center;">코드</th>
										<th style="background-color: #fafafa; text-align: center;">이름</th>
										<th style="background-color: #fafafa; text-align: center;">취소</th>
									</tr>
								</thead>
								<tbody id="disease-table">
								</tbody>
							</table>
							<div class="bg-dark text-white">약처방 정보</div>
							<table class="table" style="text-align: center; border: 1px solid #dddddd;">
								<thead>
									<tr> 
										<th style="background-color: #fafafa; text-align: center;">약품코드</th>
										<th style="background-color: #fafafa; text-align: center;">약품명</th>
										<th style="background-color: #fafafa; text-align: center;">총 투약일수</th>
										<th style="background-color: #fafafa; text-align: center;">1회 투여량</th>
										<th style="background-color: #fafafa; text-align: center;">1일 투여량</th>
										<th style="background-color: #fafafa; text-align: center;">취소</th>
									</tr>
								</thead>
								<tbody id="drug-table">
								</tbody>
							</table>
							<div class="row justify-content-center">	
								<input class="patient-id" name="patientId" type="hidden">
								<input class="receive-id" name="receiveId" type="hidden">
								<button class="btn btn-dark" type="submit">처방하기</button>
							</div>
						</div>
					</form>
				<br>
				
					<form action="updateInjection.do" method="post">
						<div class="bg-dark text-white">검사 처방 정보</div>
						<table class="table"style="text-align: center; border: 1px solid #dddddd;">
							<thead>
								<tr>
									<th style="background-color: #fafafa; text-align: center;">검사코드</th>
									<th style="background-color: #fafafa; text-align: center;">이름</th>
									<th style="background-color: #fafafa; text-align: center;">취소</th>
									
								</tr>
							</thead>
							<tbody id="injection-Table">
							</tbody>
						</table>
						<div class="row justify-content-center">
							<input class="patient-id" name="patientId" type="hidden">
							<input class="receive-id" name="receiveId" type="hidden">					
							<button class="btn btn-dark" type="submit">검사 처방</button>
						</div>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>
	
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">

	var request = new XMLHttpRequest();
	var injecRequest = new XMLHttpRequest();
	var pastRequest = new XMLHttpRequest();
	var patientRequest = new XMLHttpRequest();
	var receiveId="";
	function receiveFunction() {
		
		request.open("Get", "./getReceivePatient",true);
		request.onreadystatechange = receiveProcess;
		request.send(null);
	}
	function receiveProcess() {
		var table = document.getElementById('receiveTable');
		table.innerHTML = "";
		if (request.readyState == 4 && request.status == 200) {
			
			const data = JSON.parse(request.responseText);
			
			for (var i = data.length-1; i >= 0; i--) {
				var row = table.insertRow(0);
				row.addEventListener("click", function(evt) {
					showPatientInfo(data[evt.currentTarget.rowIndex - 1],
							evt.currentTarget.firstChild.innerText);
					var hidden = document.getElementsByClassName("patient-id");
					hidden[0].value = data[evt.currentTarget.rowIndex - 1][7];
					hidden[1].value = data[evt.currentTarget.rowIndex - 1][7];
					hidden = document.getElementsByClassName("receive-id");
					hidden[0].value = data[evt.currentTarget.rowIndex - 1][8];
					hidden[1].value = data[evt.currentTarget.rowIndex - 1][8];
					receiveId = data[evt.currentTarget.rowIndex - 1][8];
					pastFunction(data[evt.currentTarget.rowIndex - 1][7]);
					
				})
				var cell = row.insertCell(0);
				cell.innerHTML = i+1;
				cell = row.insertCell(1);
				cell.innerHTML = data[i][0];
				cell = row.insertCell(2);
				cell.innerHTML = data[i][6];
			}

		}
	}
	function receiveInjecFunction(){
		
		injecRequest.open("Get", "./getReceiveInjectionPatient",true);
		injecRequest.onreadystatechange = receiveInjecProcess;
		injecRequest.send(null);
	}
	function receiveInjecProcess(){
		var table = document.getElementById('receiveInjTable');
		table.innerHTML = "";
		if (injecRequest.readyState == 4 && injecRequest.status == 200) {
			
			const data = JSON.parse(injecRequest.responseText);
			for (var i = data.length-1; i >=0 ; i--) {
				var row = table.insertRow(0);
				row.addEventListener("click", function(evt) {
					showPatientInfo(data[evt.currentTarget.rowIndex - 1],
							evt.currentTarget.firstChild.innerText);
					var hidden = document.getElementsByClassName("patient-id");
					hidden[0].value = data[evt.currentTarget.rowIndex - 1][7];
					hidden = document.getElementsByClassName("receive-id");
					hidden[0].value = data[evt.currentTarget.rowIndex - 1][8];
					
					pastFunction(data[evt.currentTarget.rowIndex - 1][7]);
					openInejction(data[evt.currentTarget.rowIndex - 1][8]);
				})
				var cell = row.insertCell(0);
				cell.innerHTML = i+1;
				cell = row.insertCell(1);
				cell.innerHTML = data[i][0];
				cell = row.insertCell(2);
				cell.innerHTML = data[i][6];
			}

		}
	}
	function openInejction(data){
		window.open('img?receive_id='+data,'window_name','width=800,height=1000,location=no,status=no,scrollbars=yes');
	}
	function showPatientInfo(data, num) {
		var div = document.getElementById('info');
		for (var i = 0; i < 3; i++) {
			div.children[0].children[i].children[1].innerText = data[i];
			div.children[1].children[i].children[1].innerText = data[i+3];
		}
	}
	

	function pastFunction(id){
		pastRequest.open("Get", "./getPastReceive?id="+ encodeURIComponent(id),true);
		pastRequest.onreadystatechange = pastProcess;
		pastRequest.send(null);
	}
	
	function pastProcess(){
		var tbody = document.getElementById('tbody');
		tbody.innerHTML="";
		if (pastRequest.readyState == 4 && pastRequest.status == 200) {
			const data = JSON.parse(pastRequest.responseText);
			
			for (var i = data.length-1; i>=0; i--) {
				var row = tbody.insertRow(0);
				row.addEventListener("click", function(evt) {
					var r = document.getElementById('pastReceiveId');
					console.log(data[evt.currentTarget.rowIndex - 1]);
					r.value = data[evt.currentTarget.rowIndex - 1][3];
					
					openPast();
				})
				var cell = row.insertCell(0);
				cell.innerHTML = i+1;
				for(var j=1;j<4;j++){
					cell = row.insertCell(j);
					cell.innerHTML = data[i][j-1];
				}
				
			}
		}
	}
	function openPast(){
		window.open('pastReceive','window_name','width=1800,height=900,location=no,status=no,scrollbars=yes');
	}
	function remove(){
		var btn = window.event.srcElement;
		var table = btn.parentNode.parentNode.parentNode;
		var rowIndex = btn.parentNode.rowIndex;
		table.deleteRow(rowIndex);
		
	}
	window.onload = function(){
			receiveFunction();
			receiveInjecFunction();
	}
</script>
</html>