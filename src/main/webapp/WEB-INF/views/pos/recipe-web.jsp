<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>STARBUCKS My Recipe</title>
	
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<!-- CSS import -->
	<link rel="stylesheet"
		href="/greenTumblerServer/resources/css/bootstrap.css">
	<link rel="stylesheet"
		href="/greenTumblerServer/resources/css/style-web.css">
	<link rel="stylesheet"
		href="/greenTumblerServer/resources/css/recipe-web.css">
	<!-- JS import -->
	<script src="/greenTumblerServer/resources/js/jquery-3.3.1.js"></script>
	<script src="/greenTumblerServer/resources/js/popper-1.14.7.js"></script>
	<script src="/greenTumblerServer/resources/js/bootstrap.js"></script>
	
</head>
<body id="body" class="background">
	<%@include file="./navbar-partner.jsp"%>
	<input class="transparent-input" id="nfcId"></input>
	<div id="container-partner" class="container white-container">
		<div class="row">
			<div class="col-7 mt-3" style="margin-bottom: 50px">
				<div class="row">
					<div class="col-6">
						<p class="white-font font">whip</p>
						<div class="content-box mt-3 text-center">
							<p id="whip" class="font whip color-white"></p>
						</div>
					</div>
					<div class="col-6">
						<p class="white-font font">shots</p>
						<div class="content-box mt-3 text-center">
							<p id="shots" class="font shots color-white"></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<p class="white-font font">syrup</p>
						<div class="content-box wide mt-3 text-center">
							<p id="syrup" class="font shots color-white"></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<p class="white-font font">drizzle</p>
						<div class="content-box wide mt-3 text-center">
							<p id="drizzle" class="font shots color-white"></p>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<p class="white-font font">custom</p>
						<div class="content-box wide mt-3 text-center">
							<p id="custom" class="font shots color-white"></p>
						</div>
					</div>
				</div>
			</div>
			<div class="col-1">
				<div class="horizontal-line"></div>
			</div>
			<div class="col-4 mt-3">
				<div class="row">
					<p class="white-font font right">메뉴</p>
				</div>
				<div class="row">
					<p style="line-height: 1 !important;" id="menu_name" class="font menu_name color-white"><br/><br/></p>
				</div>
				<div class="row mt-3" >
					<p class="white-font font right" style="margin-top: 200px;">주문 시간</p>
				</div>
				<div class="row">
					<p id="order_time" class="font ordertime color-white"><br/></p>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			
			let bodyHeightPercent = 0.9;
			let bodyWidthPercent = 0.3;
			
			let navbarPartner = document.getElementById("navbar-partner");
			let containerPartner = document.getElementById("container-partner");
			let nfcId = document.getElementById("nfcId");
			
			let windowHeight = window.innerHeight;
			let windowWidth = window.innerWidth;
			let body = document.getElementById("body");
			body.style.height = (windowHeight * bodyHeightPercent) + "px";
			let bodyMarginTop = (windowHeight * ((1-bodyHeightPercent)/2));
			let bodyMarginLeft = (windowWidth - body.offsetLeft);
			
			//body.style.marginTop = bodyMarginTop + "px";
			body.style.width = (windowWidth * bodyWidthPercent) + "px";
			body.style.marginLeft = (windowWidth * ((1-bodyWidthPercent)/2)) + "px";
			
			let innerBodyHeight = navbarPartner.offsetHeight + containerPartner.offsetHeight + nfcId.offsetHeight;
			body.style.paddingTop = (windowHeight - innerBodyHeight) * 0.9 /2 + "px";
			
			
			$("#nfcId").focus();
			let typingTimer;
			let doneTypingInterval = 200;

			// 인풋 필드가 끝까지 입력되었을 때에만 ajax 날리기
			$('#nfcId').on("keyup", function(e) {
				clearTimeout(typingTimer);

				typingTimer = setTimeout(function() {
					console.log($("#nfcId").val());
					$.ajax({
						url : "/greenTumblerServer/pos/getRecipe",
						data : {
							nfcId : $("#nfcId").val().replace(/\s/g, '')
						},
						type : "POST",
						dataType : "json",
						success : function(order) {

							console.log(order);
							$('#menu_name').text(order.menu_name);
							if (order.whipped_cream) {
								$('#whip').text('O');
							} else {
								$('#whip').text('X');
							}
							$('#shots').text(order.shot);
							$('#syrup').text(order.syrup);
							if (order.drizzle) {
								$('#drizzle').text('O');
							} else {
								$('#drizzle').text('X');
							}
							$('#order_time').text(order.order_time2);
							$('#nfcId').val('');
							
							$("#nfcId").focus();
						},
						error: function(e) {
							$('#menu_name').text("");
							$('#whip').text("");
							$('#shots').text("");
							$('#syrup').text("");
							$('#drizzle').text("");
							$('#order_time').text("");
							
							$('#nfcId').val('');
							$("#nfcId").focus();
						}
					})

				}, doneTypingInterval);
			})

			$('#nfcId').on("keydown", function(e) {

				clearTimeout(typingTimer);
			});
		});
	</script>
</body>
</html>