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
	<span class="badge badge-secondary col">검사</span>
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
	function search(){
		request.open("Get","./getInjection?name=" + encodeURIComponent(document.getElementById("name").value),true);
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
				li.innerText=data[i][2];
				li.id=i;
				li.addEventListener("click", function(evt) {
					name.value=evt.currentTarget.innerText;

					var input = document.createElement('input');
					input.type='hidden';
					input.name='injecId';
					input.value=data[evt.currentTarget.id][0];
					var input2 = document.createElement('input');
					input2.type='hidden';
					input2.name='sugaId';
					input2.value=data[evt.currentTarget.id][0];
					
					var table =  window.opener.document.getElementById('injection-Table');
					var row = table.insertRow(0);
					
					var cell = row.insertCell(0);
					cell.innerHTML = data[evt.currentTarget.id][0];
					cell = row.insertCell(1);
					if(data[evt.currentTarget.id][2].length>7)
						cell.innerHTML = (data[evt.currentTarget.id][2]+"").substring(0,7)+"...";
					else
						cell.innerHTML = data[evt.currentTarget.id][2];
					
					cell = row.insertCell(2);
					cell.innerHTML = "<button class='btn btn-dark' type='button' onclick='remove()' style='width:100px;'>삭제</button>";
					cell.append(input);
					cell.append(input2);
				})
				result.append(li);
			}
		}
	}
</script>
</html>