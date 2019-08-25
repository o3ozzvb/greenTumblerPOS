<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <!-- CSS import -->
        <link rel="stylesheet" href="/greenTumblerServer/resources/css/bootstrap.css">
        <link rel="stylesheet" href="/greenTumblerServer/resources/css/style.css">
        <link rel="stylesheet" href="/greenTumblerServer/resources/css/modal.css">
        <!-- JS import -->
        <script src="/greenTumblerServer/resources/js/jquery-3.3.1.js"></script>
        <script src="/greenTumblerServer/resources/js/popper-1.14.7.js"></script>
        <script src="/greenTumblerServer/resources/js/bootstrap.js"></script>  
        <!-- IONICONS -->
        <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>
    </head>

    <body class="background">
    	<%@include file="./navbar.jsp"%>
        <div class="container mt-3">
            <div class="row">
                <div class="col-6 grid-upper grid-gray white">
                    <div class="row">
                    	<div class="col-3">
                    		<div class="row">
                    			<div class="col-12">
                    				<c:forEach 	items="${ category2 }" 
                    							var="item"
                    							varStatus="status">
                    					<c:if test="${ status.first == true }">
                    						<div id="defaultCategory" class="pos-btn pos-category-btn selected">${ item }</div>
                    					</c:if>
                    					<c:if test="${ status.first == false }">
                    						<div class="pos-btn pos-category-btn">${ item }</div>
                    					</c:if>
                    				</c:forEach>
                    			</div>
                    		</div>
                    	</div>
                    	<div class="col-9">
                    		<div class="row">
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    			<div class="col-4 pos-menu-grid">
                    				<div class="pos-btn pos-menu-btn"></div>
                    			</div>
                    		</div>
                    	</div>
                    </div>
                </div>
                
                <div class="col-5 offset-1 grid-upper grid-black white">
                    <div class="row text-center">
                    	<div class="col-5">
                    		<p>상품</p>
                    	</div>
                    	<div class="col-3">
                    		<p>#</p>
                    	</div>
                    	<div class="col-1">
                    		<p>Size</p>
                    	</div>
                    	<div class="col-3">
                    		<p>가격</p>
                    	</div>
                    </div>
                    <div class="col-12">
                    	<hr/>
                    </div>
                    <div id="order-list-area" class="row text-center">
                    
                    </div>
                    <div style="position: absolute; top: 90%; width: 100%;">
	                    <div id="total-area" class="row">
	                    	<div class="col-6">
	                    		<h5>개수 : <span id="totalCount">0</span>건</h5>
	                    	</div>
	                    	<div class="col-6" style="text-align: left;">
	                    		<h5>합계 : <span id="totalPrice">0</span>원</h5>
	                    	</div>
	                    </div>
	                </div>
                </div>
            </div>
            <!-- 하단 메뉴 영역 -->
            <p class="menu-font mt-1">사이즈</p>
            <div class="row mt-3">
                <div class="button-area col-4">
                    <button class="btn btn-danger btn-lg size-btn" data-size="tall">Tall</button>
                    <button class="btn btn-danger btn-lg size-btn" data-size="grande">Grande</button>
                    <button class="btn btn-danger btn-lg size-btn" data-size="venti">Venti</button>
                </div>
                <div class="col-6 offset-2 tumbler-info-area">
                	<p>충전 금액 : <span id="tumblerMoney"></span>원</p>
                	<p>고객명 : <span id="nickName"></span></p>
                	<p>분실 여부 : <span id="lostYn"></span> / 결제 가능 여부 : <span id="payYn"></span></p>
                </div>
            </div>
            <div class="row">
            	<div class="col-6 offset-6" style="background-color: #C8D0D8;">
            		<div class="row">
            			<div class="col-3 offset-1">
            				<button class="btn border-green no-padding-vertical transparent"
            					data-toggle="modal" data-target="#myMenuModal">나만의 메뉴</button>
            			</div>
            			<div class="col-3 offset-1">
            				<button class="btn border-green no-padding-vertical transparent"
            					data-toggle="modal" data-target="#recentOrderModal">최근주문정보</button>
            			</div>
            			<div class="col-3 offset-1">
            				<button class="btn border-red no-padding-vertical transparent"
            					data-toggle="modal" data-target="#lostTumblerModal">텀블러 분실신고</button>
            			</div>
            		</div>
            	</div>
            </div>
            <p class="menu-font mt-2">퍼스널 옵션</p>
            <div class="row mt-3">
                <div class="button-area col-6">
                    <button data-personal="shot" class="btn btn-secondary btn-lg personal-btn">샷</button>
                    <button data-personal="syrup" class="btn btn-secondary btn-lg personal-btn">시럽</button>
                    <button data-personal="whipped_cream" class="btn btn-secondary btn-lg personal-btn">휘핑</button>
                    <button data-personal="drizzle" class="btn btn-secondary btn-lg personal-btn">드리즐</button>
                </div>
               	<div class="col-2">
            		<button class="btn btn-success pay-btn float-right" data-toggle="modal" data-target="#chargeModal">충전</button>
                </div>
                <div class="col-2">
            		<button class="btn btn-success pay-btn float-right" data-toggle="modal" data-target="#tumblerModal">텀블러</button>
                </div>
            	<div class="col-2">
            		<button id="payBtn" class="btn btn-danger pay-btn float-right">결제</button>
                </div>
            </div>
        </div>
        
        <%@include file="./modals/myMenuBtnModal.jsp"%>
        <%@include file="./modals/recentOrderBtnModal.jsp"%>
        <%@include file="./modals/lostTumblerBtnModal.jsp"%>
        <%@include file="./modals/chargeBtnModal.jsp"%>
        <%@include file="./modals/tumblerBtnModal.jsp"%>
        <%@include file="./modals/payingModal.jsp"%>
        <%@include file="./spinner.jsp"%>

		<script>
			let menus = JSON.parse('${ menus }');
			let orderList = []; // OrderList 의 묶음. Order Model 에 들어가게 된다.
			let selectedMenu = {}; // 가장 최근에 선택된 메뉴를 나타낸다.
			let orderIdx = 1; // OrderItem 의 번호이다.
			let optionPrice = 600; // 샷, 시럽, 휘핑, 드리즐 등의 가격을 나타낸다.
			let tumblerMoney = -1; // 텀블러 잔액
			let tumblerInfo = null; // 로드된 텀블러가 담기게 되는 변수
			let chargeTumblerInfo = null; // 충전 시에 텀블러 정보가 담기게 되는 변수
			
			function sendTumblerRequest(url, method, data, success) {
				$.ajaxSettings.traditional = true;
				$.ajax({
					url: url,
					type: method,
					dataType: "json",
					data: data,
					success: success,
					error : function(request,status,error) {
						console.log(JSON.stringify(request,status,error));
					}
				});
			}
			function sendTumblerRequestWithJSON(url, method, data, success) {
				$.ajaxSettings.traditional = true;
				$.ajax({
					url: url,
					dataType: "json",
					contentType: "application/json",
					type: method,
					data: data,
					success: success,
					error : function(request,status,error) {
						console.log(JSON.stringify(request,status,error));
					}
				});
			}
			
			$(function(){
				// 스타벅스 메뉴 불러오기
				let posMenuBtns = document.getElementsByClassName("pos-menu-btn");	
				let defaultCategory = $("#defaultCategory").text();
				let idx = 0;
				
				for(var i = 0 ; i < menus.length ; i++) {
		        	
		        	if(menus[i].category2 == defaultCategory) {
		        		
		        		posMenuBtns[idx].innerText = menus[i].menu_name;
		        		posMenuBtns[idx].dataset.price = menus[i].price;
		        		posMenuBtns[idx].dataset.menu_id = menus[i].menu_id;
		        		posMenuBtns[idx].dataset.menu_name = menus[i].menu_name;
		        		posMenuBtns[idx++].dataset.category2 = menus[i].category2;
		        	}
		        }	
				// Tall Grande, Venti 버튼이 클릭되었을 때
				$(".size-btn").on("click touchstart", function(e){
					
					if(selectedMenu.menu_name != null){
						let handled = false;
						let size = e.target.dataset.size;
						
						selectedMenu["size"] = size=="tall" ? "T" : size=="grande" ? "G" : "V";
						selectedMenu["menu_cnt"] = 1;
						selectedMenu["line_id"] = orderIdx++;
						selectedMenu["shot"] = 0;
						selectedMenu["syrup"] = 0;
						selectedMenu["option_sum"] = 0;
						
						selectedMenu["whipped_cream"] = false;
						selectedMenu["drizzle"] = false;
						selectedMenu["private_menu_yn"] = false;
						selectedMenu["is_tumbler"] = false;
						
						if(e.type == "touchend") {
							updateOrderList(orderList, selectedMenu);
							handled = true;
						} else if(e.type=="click" && !handled) {
							updateOrderList(orderList, selectedMenu);
						}						
					}
				})
				
				// 샷, 시럽, 휘핑, 드리즐 버튼이 클릭되었을 때
				$(".personal-btn").on("click touchstart", function(e){
					let handled = false;
					let personal = e.target.dataset.personal;
					let id = selectedMenu.line_id;
					
					if(e.type == "touchend") {
						handled = true;
					} else if(e.type=="click" && !handled) {
						for(var i = 0 ; i < orderList.length ; i++) {
						    if(orderList[i].line_id == id) {
								let newOrderItem = orderList[i];
								if(personal == "shot" || personal == "syrup") {
									newOrderItem[personal] += 1;
									newOrderItem["option_sum"] += optionPrice;
								} else if(personal == "whipped_cream" || personal == "drizzle") {
									if(newOrderItem[personal]) {
										newOrderItem["option_sum"] -= optionPrice;	
									} else {
										newOrderItem["option_sum"] += optionPrice;
									}
									newOrderItem[personal] = !newOrderItem[personal];
								}
								
								// 포인터로 저장되는 것을 막기 위해, deep copy 한다.
								Object.assign(orderList[i], newOrderItem);
								
							} 
						}
					}
					updateOrderList(orderList, null);
				})
				
				// 결제 버튼이 클릭되었을 때
				$("#payBtn").on("click", function(e){
					
					let url = "/greenTumblerServer/pos/pay/" + tumblerInfo.nfc_id;
					let method = "POST";
					orderList = validateOrderList(orderList);
					
					console.log(orderList);
					$("#payingModal").modal("show");
					
					sendTumblerRequestWithJSON(url, method, JSON.stringify(orderList), function(tumbler){
						console.log(tumbler);
						let msg = "";
						if(tumbler.account_id == null && tumbler.nickName == null) {
							msg = "잔액이 부족합니다";
						} else {
							msg += tumbler.account_id + " / 잔액 : " + tumbler.tumbler_Money; 
						}
						$("#paymentMsg").text(msg);
					}); 
				})
			})
			
			function validateOrderList(orderList) {
				for(var i = 0 ; i < orderList.length ; i++) {
					if(orderList[i]["drizzle"] == "true" || orderList[i]["drizzle"] == "false") {
						orderList[i]["drizzle"] = (orderList[i]["drizzle"] == "true");	
					}
					if(orderList[i]["whipped_cream"] == "true" || orderList[i]["whipped_cream"] == "false") {
						orderList[i]["whipped_cream"] = (orderList[i]["whipped_cream"] == "true");	
					}
					
					orderList[i]["menu_cnt"] = parseInt(orderList[i]["menu_cnt"]);
					orderList[i]["option_sum"] = parseInt(orderList[i]["option_sum"]);
					orderList[i]["line_id"] = parseInt(orderList[i]["line_id"]);
					orderList[i]["price"] = parseInt(orderList[i]["price"]);
					orderList[i]["shot"] = parseInt(orderList[i]["shot"]);
					orderList[i]["syrup"] = parseInt(orderList[i]["syrup"]);
					
					orderList[i]["private_menu_yn"] = (orderList[i]["private_menu_yn"] ? true : false);
					
				}
				return orderList;
			}
			
			// 주문 목록에서 개별의 아이템들이 클릭 되었을 때
			function orderItemSelected(e) {
				
				let orderListElement = e.target.parentElement.parentElement.parentElement;
				let id = parseInt(orderListElement.dataset.id);
				$(".orderlist").removeClass("selected");
				orderListElement.classList.add("selected");
				
				for(var i = 0 ; i < orderList.length ; i++) {
					if(orderList[i].line_id == id) {
						let newOrderItem = orderList[i];
						selectedMenu = newOrderItem;
						
					}
				}
			}
			// 주문 목록을 UI 로 뿌려주는 함수
			function updateOrderList(orderList, selectedMenu) {
				let totalAmount = 0;
				let totalCnt = 0;
				
				
				if(selectedMenu != null) {
					let _selectedMenu = $.extend({}, selectedMenu);
					orderList.push(_selectedMenu);	
				}
				
				$("#order-list-area").html("");
				
				for(var i = 0 ; i < orderList.length ; i++) {
					let optionSum = 0;
					if(orderList[i].option_sum == null) {
						orderList[i]["option_sum"] = 0;
					}
					optionSum += parseInt(orderList[i].option_sum);
					
					var orderItem = `
						<div class="col-12 orderlist" 
							data-id="`+ orderList[i].line_id +`"
							onclick="orderItemSelected(event)">
							<div class="row">
						        <div class="col-4">
						            <p class="order-list-txt">`+ orderList[i].menu_name +`</p>
						        </div>
						        <div class="col-4">
						            <p class="order-list-txt">
						            	<ion-icon onclick="reduceCount(event)" data-id="`+ orderList[i].line_id +`" name="arrow-back"></ion-icon>`
						            		+ orderList[i].menu_cnt +`
						            	<ion-icon onclick="increaseCount(event)" data-id="`+ orderList[i].line_id +`" name="arrow-forward"></ion-icon>
						            </p>
						        </div>
						        <div class="col-1">
						            <p class="order-list-txt">`+ orderList[i].size +`</p>
						        </div>
						        <div class="col-3">
						            <p class="order-list-txt">`+ orderList[i].price +`</p>
						        </div>
						        <div class="col-3">
									<p class="order-list-option"> 샷 : ` +  orderList[i].shot  + `</p>						        
						        </div>
						        <div class="col-3">
									<p class="order-list-option"> 시럽 : ` +  orderList[i].syrup  + `</p>						        
						        </div>
						        <div class="col-3">
									<p class="order-list-option"> 휘핑 : ` +  (orderList[i].whipped_cream ? `Y` : `N`)  + `</p>						        
						        </div>
						        <div class="col-3">
									<p class="order-list-option"> 드리즐 : ` +  (orderList[i].drizzle ? `Y` : `N`)  + `</p>						        
						        </div>
						        <div class="col-12">
						        	<hr/>
						        </div>
						     </div>
						 </div>
					`;
					
					totalAmount += parseInt(orderList[i].price * orderList[i].menu_cnt);
					totalAmount += parseInt(optionSum);
					totalCnt += parseInt(orderList[i].menu_cnt);
					$("#order-list-area").append(orderItem);
					$("#totalCount").text(totalCnt);
					$("#totalPrice").text(totalAmount);
					
				}
			}
			// 음료의 수량을 줄이는 함수
			function reduceCount(e) {
				let id = parseInt(e.target.dataset.id);
				for(var i = 0 ; i < orderList.length ; i++) {
					if(orderList[i].line_id == id) {
						let newOrderItem = orderList[i];
						if(newOrderItem.menu_cnt > 1) {
							newOrderItem.menu_cnt -= 1;
							Object.assign(orderList[i], newOrderItem);	
						}
					}
				}
				updateOrderList(orderList, null);
				e.stopPropagation();
			}
			// 음료의 수량을 증가시키는 함수
			function increaseCount(e) {
				let id = parseInt(e.target.dataset.id);
				for(var i = 0 ; i < orderList.length ; i++) {
					if(orderList[i].line_id == id) {
						let newOrderItem = orderList[i];
						newOrderItem.menu_cnt += 1;
						Object.assign(orderList[i], newOrderItem);
					}
				}
				updateOrderList(orderList, null);
				e.stopPropagation();
			}
		</script>
          
		<script src="/greenTumblerServer/resources/js/script.js"></script>       
    </body>
</html>