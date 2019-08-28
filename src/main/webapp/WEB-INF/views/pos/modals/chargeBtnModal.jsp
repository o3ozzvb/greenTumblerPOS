<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Modal -->
<div class="modal fade" id="chargeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">최근주문정보</h5>
      </div>
      <div class="modal-body">
   		<div class="row">
   			<div class="col-3">
   				<button class="btn btn-light charge-amount" data-amount="10000">10000원</button>
   			</div>
   			<div class="col-3">
   				<button class="btn btn-light charge-amount" data-amount="20000">20000원</button>
   			</div>
   			<div class="col-3">
   				<button class="btn btn-light charge-amount" data-amount="30000">30000원</button>
   			</div>
   			<div class="col-3">
   				<button class="btn btn-light charge-amount" data-amount="50000">50000원</button>
   			</div>
   		</div>
   		<div class="row mt-3">
   			<div class="col-6">
   				<div class="white-box charge-box">
  					<p>충전 전 금액 : <span id="before-charge" data-amount="-1"></span> 원</p>
  					<p>충전 후 금액 : <span id="after-charge" data-amount="-1"></span> 원</p>
   				</div>
   			</div>
			<div class="col-3 offset-3">
				<button id="chargeBtn" type="button" class="btn btn-success float-right">충전하기</button>
			</div>
		</div>
      </div>
    </div>
  </div>
</div>
<script>
	$(".charge-amount").on("click", function(){
		let amount = parseInt($(this).data("amount"));
		let beforeCharge = parseInt($("#before-charge").data("amount"));
		$("#after-charge").data("amount", amount+beforeCharge);
		$("#after-charge").text(amount+beforeCharge);
				
	})
	$("#chargeBtn").on("click touchstart", function(e){
		let handled = false;
		
		if(e.type == "touchend") {
			handled = true;
		} else if(e.type=="click" && !handled) {
			let afterCharge = parseInt($("#after-charge").data("amount")); 
			
			if(tumblerMoney < 0 ) {
				alert("텀블러 정보가 로드되지 않았습니다.");
			} else if (afterCharge < 0) {
				alert("충전 금액을 선택해 주세요.");
			} else {
				chargeTumblerInfo["tumbler_Money"] = parseInt($("#after-charge").data("amount"));
				let url = "/greenTumblerServer/pos/chargeTumbler";
				let method = "POST";
				let data = chargeTumblerInfo;
				console.log("clicked");
				sendTumblerRequest(url, method, data, function(tumbler){
					console.log(tumbler);
					let msg = tumblerInfo.nickName + "님의 텀블러 잔액이 " + tumbler.tumbler_Money + " 원 으로 충전되었습니다.";
					$("#tumblerMoney").text(tumbler.tumbler_Money);
					showAlert(msg, "chargeModal", "alertModal");
				});
			}
		}
	})
</script>