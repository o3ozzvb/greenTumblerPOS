<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Modal -->
<div class="modal fade" id="tumblerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">텀블러 가져오기</h5>
      </div>
      <div class="modal-body">
   		<div class="row">
   			<div class="col-7">
   				<input id="nfcId" type="text" class="form-control" autofocus placeholder="텀블러 번호" />	
   			</div>
   			<div class="col-5">
      			<button id="getTumblerBtn" type="button" class="btn btn-light">불러오기</button>
      			<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>	
   			</div>
   		</div>
      </div>
    </div>
  </div>
</div>

<script>

	$(function(){
		
		$('#tumblerModal').on("shown.bs.modal", function (e) {
		  $("#nfcId").focus();
		})
		
		$('#nfcId').on("input", function (e) {
			$("#getTumblerBtn").click();
			
		})
		
		function tumblerConfirmed(tumbler) {
			deactiveSpinner();
			
			tumblerInfo = tumbler;
			chargeTumblerInfo = tumbler;
			
			if(tumbler.lost_yn) {
				$("#lostTumblerModal").modal("show");				
			}
			
			if(tumbler == null || tumbler == "") {
				console.log("텀블러 정보 조회 불가");
			} else {
				$("#tumblerMoney").text(tumbler.tumbler_Money);
				$("#nickName").text(tumbler.nickName);
				$("#lostYn").text(tumbler.lost_yn ? "Y" : "N");
				$("#payYn").text(tumbler.pay_yn ? "Y" : "N");
				$("#tumblerModal").modal("hide");	
				$("#nfcId").val("");
				tumblerMoney = tumbler.tumbler_Money;
				$("#before-charge").text(tumblerMoney);
				$("#before-charge").data("amount", tumblerMoney);
			}
		}
		
		$("#getTumblerBtn").on("click", function() {
			activateSpinner();
			let nfcId = $("#nfcId").val().replace(/ /g, "");
			
			$.ajax({
				url: "/greenTumblerServer/pos/test",
				data: {
					"nfcId" : nfcId
				},
				method: "POST",
				success: function(result){
					if(result == "" || result == null) {
						console.log("텀블러 조회 정보 실패");
							
					} else {
						tumblerConfirmed(result);	
					}
				}
			});
		})
	}) 
</script>