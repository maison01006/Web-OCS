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
<body>
	<div class="row col" style="text-align: center;">
		<div class="col-2">
			<ul class="list-group" id="disease">
  				<li class="list-group-item list-group-item-dark font-weight-bold">상병명</li>

			</ul>
		</div>
		<div class="col-2">
			<ul class="list-group" id="drug">
  				<li class="list-group-item list-group-item-dark font-weight-bold">약품명</li>

			</ul>
		</div>
		<div class="col-8">
			<ul class="list-group" id="injection">
  				<li class="list-group-item list-group-item-dark font-weight-bold">검사</li>
			</ul>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">
	var receiveId = opener.document.getElementById('pastReceiveId').value;
	var drugRequest = new XMLHttpRequest();
	var diseaseRequest = new XMLHttpRequest();
	var injectionRequest = new XMLHttpRequest();
	
	function drugFunction() {
		
		drugRequest.open("Get", "./getDrugPrescription?receiveId="+encodeURIComponent(receiveId),true);
		drugRequest.onreadystatechange = drugProcess;
		drugRequest.send(null);
	}
	
	function drugProcess(){
		var ul = document.getElementById('drug');
		
		if (drugRequest.readyState == 4 && drugRequest.status == 200) {
			var data = JSON.parse(drugRequest.responseText);
			for(var i=0; i<data.length;i++){
				var li = document.createElement('li');
				li.innerText=data[i]['name'];
				li.className = "list-group-item";
				ul.append(li);
			}
		}
		
		
	}
	
	function diseaseFunction() {
		
		diseaseRequest.open("Get", "./getDiseasePrescription?receiveId="+encodeURIComponent(receiveId),true);
		diseaseRequest.onreadystatechange = diseaseProcess;
		diseaseRequest.send(null);
	}
	
	function diseaseProcess(){
		var ul = document.getElementById('disease');
		
		
		if (diseaseRequest.readyState == 4 && diseaseRequest.status == 200) {
			var data = JSON.parse(diseaseRequest.responseText);
			for(var i=0; i<data.length;i++){
				var li = document.createElement('li');
				li.innerText=data[i]['name'];
				li.className = "list-group-item";
				ul.append(li);
			}
		}
	}
	
	function injectionFunction() {
		
		injectionRequest.open("Get", "./getInjectionPrescription?receiveId="+encodeURIComponent(receiveId),true);
		injectionRequest.onreadystatechange = injectionProcess;
		injectionRequest.send(null);
	}
	
	function injectionProcess(){
		var ul = document.getElementById('injection');
		if (injectionRequest.readyState == 4 && injectionRequest.status == 200) {
			var data = JSON.parse(injectionRequest.responseText);
			console.log(data);
			for(var i=0; i<data.length;i++){
				var li = document.createElement('li');
				li.innerText=data[i][1];
				li.className = "list-group-item";
				ul.append(li);
				li = document.createElement('li');
				li.className = "list-group-item";
				console.log(data[i][2]);
				li.innerHTML='<img src= "resources/img/'+data[i][2]+'"/>';
				ul.append(li);
			}
		}
	}
	window.onload = function(){
		drugFunction();
		diseaseFunction();
		injectionFunction();
}
	
</script>
</html>