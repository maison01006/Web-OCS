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
	<div class="row justify-content-between bg-dark">
		<ul class="nav col-6">
			<li class="nav-item"><a class="nav-link" href="#">OCS</a></li>
			<li class="nav-item"><a class="nav-link" href="boardList">공지사항</a>	</li>
			<li class="nav-item"><a class="nav-link" href="insert">환자등록</a></li>
			<li class="nav-item"><a class="nav-link" href="#">접수</a></li>
			<li class="nav-item"><a class="nav-link" href="receipt">수납</a></li>
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
			<tbody id="receiveTable">
			</tbody>
		</table>
	</div>
	<div class="col row">
		<div class="col row">
			<span class="badge badge-secondary">수납 리스트</span>
			<div class="col" style="padding:0px;">
				<table class="table"style="text-align: center; border: 1px solid #dddddd;">
					<thead>
						<tr>
							<th style="background-color: #fafafa; text-align: center;">수가분류</th>
							<th style="background-color: #fafafa; text-align: center;">수가코드</th>
							<th style="background-color: #fafafa; text-align: center;">수가명</th>
							<th style="background-color: #fafafa; text-align: center;">급여</th>
							<th style="background-color: #fafafa; text-align: center;">단가</th>
						</tr>
					</thead>
					<tbody id="receiptTable">
					</tbody>
				</table>
			</div>
		</div>
		<div class="col row">
			<span class="badge badge-secondary">수납 금액</span>
			<form class="col" action="updateReceive.do" method="post">
				<div class="col row" >
					<ul class="list-group list-group-flush col" style="border-bottom: 1px solid #dddddd;" >
  						<li class="list-group-item" >항목</li>
  						<li class="list-group-item">진찰료</li>
  						<li class="list-group-item">입원료</li>
  						<li class="list-group-item">식이</li>
  						<li class="list-group-item">주사료</li>
  						<li class="list-group-item">검사료</li>
  						<li class="list-group-item">계</li>
  						<li class="list-group-item">본인부담금</li>
					</ul>
					<ul class="list-group list-group-flush col" style="border-bottom: 1px solid #dddddd;">
  						<li class="list-group-item" >급여</li>
  						<li class="list-group-item" id="1">&nbsp;</li>
  						<li class="list-group-item" id="2">&nbsp;</li>
  						<li class="list-group-item" id="3">&nbsp;</li>
  						<li class="list-group-item" id="4">&nbsp;</li>
	  					<li class="list-group-item" id="5">&nbsp;</li>
  						<li class="list-group-item" id="6">&nbsp;</li>
  						<li class="list-group-item" id="7">&nbsp;</li>
					</ul>
				</div>
				<br>
				<div class="row justify-content-center">	
					<input type="hidden" id="receiveId" name="receiveId">				
					<button class="btn btn-dark" type="submit">수납하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">

	var request = new XMLHttpRequest();
	var sugaRequest = new XMLHttpRequest();
	function searchFunction() {
		if (document.getElementById("name").value == "" || "${userName}" == "")
			return;
		request.open("Get", "./getReceipt?patientName="
				+ encodeURIComponent(document.getElementById("name").value),
				true);
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	function searchProcess() {
		var table = document.getElementById("receiveTable");
		table.innerHTML = "";
		if (request.readyState == 4 && request.status == 200) {
			const data = JSON.parse(request.responseText);
			
			console.log(data);
			for (var i = data.length-1; i >= 0; i--) {
				var row = table.insertRow(0);
				row.addEventListener("click", function(evt) {
					sugaFunction(data[evt.currentTarget.rowIndex - 1]);
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
	function sugaFunction(data){
		var receive = document.getElementById("receiveId");
		receive.value = data[8];
		sugaRequest.open("Get", "./getSuga?receiveId="
				+ encodeURIComponent(data[8])+"&fmyn="+encodeURIComponent(data[7]),true);
		sugaRequest.onreadystatechange = sugaProcess;
		sugaRequest.send(null);
	}
	function sugaProcess(){
		var table = document.getElementById("receiptTable");
		table.innerHTML="";
		var li ="";
		var row = table.insertRow(0);
		if (sugaRequest.readyState == 4 && sugaRequest.status == 200) {
			for(var i=0;i<7;i++){
				li= document.getElementById(i+1);
				li.innerHTML = 0;
			}
			const data = JSON.parse(sugaRequest.responseText);
			console.log(data);
			var row = table.insertRow(0);
			var cell = row.insertCell(0);
			cell.innerHTML = "진찰료";
			for(var i=0;i<4;i++){
				cell = row.insertCell(i+1);
				cell.innerHTML = data["suga"][i];	
			}
			
			if(data["sugaInjec"].length!=0){
				row = table.insertRow(1);
				cell = row.insertCell(0);
				cell.innerHTML = "검사료";
				for(var i=0;i<4;i++){
					cell = row.insertCell(i+1);
					cell.innerHTML = data["sugaInjec"][0][i];	
				}
				li = document.getElementById("1");
				li.innerHTML = data["suga"][3];
				li = document.getElementById("2");
				li.innerHTML = 0;
				li = document.getElementById("3");
				li.innerHTML = 0;
				li = document.getElementById("4");
				li.innerHTML = 0;
				li = document.getElementById("5");
				li.innerHTML = data["sugaInjec"][0][3];
				li = document.getElementById("6");
				li.innerHTML = (data["suga"][3]+data["sugaInjec"][0][3])*1.3;
				li = document.getElementById("7");
				li.innerHTML = Math.round((data["suga"][3]*0.6+data["sugaInjec"][0][3])*1.3);
			}else{
				li = document.getElementById("1");
				li.innerHTML = data["suga"][3];
				li = document.getElementById("2");
				li.innerHTML = 0;
				li = document.getElementById("3");
				li.innerHTML = 0;
				li = document.getElementById("4");
				li.innerHTML = 0;
				li = document.getElementById("5");
				li.innerHTML = 0;
				li = document.getElementById("6");
				li.innerHTML = data["suga"][3]*1.3;
				li = document.getElementById("7");
				li.innerHTML = Math.round(data["suga"][3]*0.6*1.3);
			}
		}
	}

</script>
</html>