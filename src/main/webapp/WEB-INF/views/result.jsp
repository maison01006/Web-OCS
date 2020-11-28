<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img class="img" src='<c:url value="${img }" />' />
</body>
</html>
<script type="text/javascript">
window.onload = function(){
    self.moveTo(0,0); //창위치
    self.resizeTo(screen.availWidth, screen.availHeight); //창크기
}
</script>