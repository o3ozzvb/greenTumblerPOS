<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/nanumpenscript.css);

.font {
	font-family: 'Nanum Pen Script', cursive;
}

body {
	width: 100%;
	height: 100%;
}

img {
	width: 80%;
	height: 80%;
}

.decaf {
	position: absolute;
	top: 240px;
	left: 215px;
	font-size: 5.4em;
	font-weight: bold;
}

.shots {
	position: absolute;
	top: 240px;
	left: 380px;
	font-size: 5.4em;
	font-weight: bold;
}

.syrup {
	position: absolute;
	top: 390px;
	left: 280px;
	font-size: 5.4em;
	font-weight: bold;
}

.milk {
	position: absolute;
	top: 540px;
	left: 250px;
	font-size: 5.4em;
	font-weight: bold;
}

.custom {
	position: absolute;
	top: 690px;
	left: 230px;
	font-size: 5.4em;
	font-weight: bold;
}

.ordertime {
	position: absolute;
	top: 800px;
	left: 520px;
	font-size: 3em;
}

</style>
<meta charset="UTF-8">
<title>STARBUCKS My Recipe</title>
</head>
<body>
	<div style="position: relative;">
		<img
			src="${pageContext.request.contextPath}/resources/images/recipe-img.png">
		<p class="font decaf">X</p>
		<p class="font shots">2</p>
		<p class="font syrup">2</p>
		<p class="font milk">soy</p>
		<p class="font custom">HJS 2</p>
		<p class="font ordertime">11:34:45</p>
	</div>
</body>
</html>