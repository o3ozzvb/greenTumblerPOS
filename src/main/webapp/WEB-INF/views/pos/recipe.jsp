<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<!-- JS import -->
<script src="/greenTumblerServer/resources/js/jquery-3.3.1.js"></script>
<script src="/greenTumblerServer/resources/js/popper-1.14.7.js"></script>
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
	width: 90%;
	height: 90%;
	
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

.menu_name {
	position: absolute;
	top: 340px;
	left: 520px;
	width: 170px;
	font-size: 3em;
	font-weight: bold;
}

.whip {
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
	top: 415px;
	left: 290px;
	font-size: 5.4em;
	font-weight: bold;
}

.drizzle {
	position: absolute;
	top: 555px;
	left: 290px;
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

input:focus {
	outline: none !important;
	border-color: white;
}
</style>
<meta charset="UTF-8">
<title>STARBUCKS My Recipe</title>
</head>
<body>
	<div style="position: relative;">
		<img
			src="${pageContext.request.contextPath}/resources/images/recipe-img.png">
		<span id="menu_name" class="font menu_name"></span>
		<p id="whip" class="font whip"></p>
		<p id="shots" class="font shots"></p>
		<p id="syrup" class="font syrup"></p>
		<p id="drizzle" class="font drizzle"></p>
		<p id="custom" class="font custom"></p>
		<p id="order_time" class="font ordertime"></p>
	</div>
	<input style="border: white; color: white" id="nfcId"></input>
	<script>
		$("#nfcId").focus();
		let typingTimer;
		let doneTypingInterval=200;
		
		// 인풋 필드가 끝까지 입력되었을 때에만 ajax 날리기
		$('#nfcId').on("keyup", function (e) {
			clearTimeout(typingTimer);
			
			typingTimer = setTimeout(function(){
				console.log($("#nfcId").val());
				$.ajax({
					url: "/greenTumblerServer/pos/getRecipe",
					data:{
						nfcId: $("#nfcId").val()
					},
					type:"POST",
					dataType:"json",
					success: function(order){
						
						console.log(order);
						$('#menu_name').text(order.menu_name);
						if(order.whipped_cream){
							$('#whip').text('O');
						}else{
							$('#whip').text('X');
						}
						$('#shots').text(order.shot);
						$('#syrup').text(order.syrup);
						if(order.drizzle){
							$('#drizzle').text('O');
						}
						else{
							$('#drizzle').text('X');
						}
						$('#order_time').text(order.order_date);
					}
				})
				
			}, doneTypingInterval);
		})
		
		$('#nfcId').on("keydown", function (e) {
			
			clearTimeout(typingTimer);
		});
		
		/* $('#recentOrderModal').on(
				'shown.bs.modal',
				function(e) {
					// let tumbler = JSON.parse('${ sessionScope.tumblerJson }');
					let url = "/greenTumblerServer/pos/getRecentOrder/"
							+ tumblerInfo.account_id;
					let method = "POST";

					sendTumblerRequest(url, method, {}, function(order) {
						console.log(order);
						$('#decaf').text(order.menu_name);
						$('#shots').text(order.size);
						$('#syrup').text(order.order_date);
						$('#milk').text(order.store_name);
						$('#custom').text(order.detail_price);
						$('#order_time').text(order.detail_price);
					})

				}) */
	</script>
</body>
</html>