<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>메뉴</h3>
	<c:forEach items="${ menus }" var="item">
		<div class="row">
			<img src="${ item.image }" style="width: 100px; height: 100px;" />
			<a target="_blank" href="${ item.image }">${ item.image }</a>
		</div>
	</c:forEach>
	<h3>텀블러</h3>
	<c:forEach items="${ tumblers }" var="item">
		<div class="row">
			<img src="${ item.image }" style="width: 100px; height: 100px;" />
			<a target="_blank" href="${ item.image }">${ item.image }</a>
		</div>
	</c:forEach>
	<script>
		let menus = JSON.parse('${ menuJson }');
		console.log(menus);
		let tumblers = JSON.parse('${ tumblerJson }');
		console.log(tumblers);
	</script>
</body>
</html>