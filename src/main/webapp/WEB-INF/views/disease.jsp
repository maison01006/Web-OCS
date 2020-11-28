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
	<div class="col">
	<span class="badge badge-secondary col">상병</span>
		<div class="row col-12" style="padding:0px; margin:0px;">
			<input type="text" class="col-10" id="name" onKeyup="search();">
			<button class="btn btn-dark col-2">검색</button>
		</div>
		<div class="result col">
			<ul class="list-group list-group-flush" id="result">
			
			</ul>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script type="text/javascript">
	var request = new XMLHttpRequest();
	var a="";
	var data=""
	var table =  window.opener.document.getElementById('disease-table');
	var cell="";
	function search(){
		request.open("Get","./getDisease?name=" + encodeURIComponent(document.getElementById("name").value),true);
		request.onreadystatechange = searchProcess;
		request.send(null);
	}
	function searchProcess(){
		var result = document.getElementById('result');
		var name = document.getElementById('name');

		if(request.readyState == 4 && request.status == 200){
			data = JSON.parse(request.responseText);
			result.innerHTML="";
			
			for (var i = data.length-1; i >= 0; i--) {
				var li = document.createElement("li");
				li.className='list-group-item';
				li.innerText=data[i][3];
				li.id=i;
				li.addEventListener("click", function(evt) {
					
					var input = document.createElement('input');
					input.type='hidden';
					input.name='diseaseId';
					input.value=data[evt.currentTarget.id][0];
					
					
					name.value=evt.currentTarget.innerText;

					
					var row = table.insertRow(0);
					
					for (var j = 0; j < 2; j++) {
						cell = row.insertCell(j);
					
						if(j==0) {
							cell.innerHTML = "<input type='checkbox' name='disesYn' value='m'>";
						}
						else if(j==1) {
							cell.innerHTML = "<input type='checkbox' name='disesYn' value='r'>";
						}
						
					}	
					for (var j = 2; j < 4; j++) {
						var cell = row.insertCell(j);
						if(data[evt.currentTarget.id][j].length>10)
							cell.innerHTML = (data[evt.currentTarget.id][j]+"").substring(0,10)+"...";
						else
							cell.innerHTML = data[evt.currentTarget.id][j];
						
					}
					var cell = row.insertCell(4);
					cell.innerHTML = "<button class='btn btn-dark' type='button' onclick='remove()' style='width:100px;'>삭제</button>"
					cell.append(input);
				
				})
				
				result.append(li);

			}
		}
	}
</script>
</html>