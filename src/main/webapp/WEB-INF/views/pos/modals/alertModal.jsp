<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Modal -->
<div class="modal fade" id="alertModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">알림</h5>
      </div>
      <div class="modal-body">
   		<p id="errorMsg"></p>
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
	$("#chargeBtn").on("click", function(e){
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
			
			sendTumblerRequest(url, method, data, function(tumbler){
				console.log(tumbler);
			});
		}
	})
</script>