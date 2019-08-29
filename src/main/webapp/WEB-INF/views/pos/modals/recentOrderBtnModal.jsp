<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Modal -->
<div class="modal fade" id="recentOrderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="recent-modal modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">최근주문정보</h5>
      </div>
      <div class="modal-body">
   		<div class="row">
   			<div class="col-8 offset-2 no-padding">
   				<div class ="white-box text-center">
   					<p><span id="menu_name"></span> / <span id="size"></span> </p>
   					<p>드리즐, 샷, 시럽, 휘핑</p>
   					<p><span id="order_date"></span></p>
   					<p><span id="store_name"></span></p>
   					<p>합계 : <span id="price"></span></p>
   				</div>
   			</div>
   		</div>
   		<div class="row mt-3">
			<div class="col-3 offset-9">
				<button type="button" class="btn btn-secondary float-right" data-dismiss="modal">취소</button>	
			</div>
		</div>
      </div>
    </div>
  </div>
</div>


<script>
	
	$('#recentOrderModal').on('shown.bs.modal', function (e) {
		// let tumbler = JSON.parse('${ sessionScope.tumblerJson }');
		if(validateTumbler(tumblerInfo) <= 0) {
			let msg = "텀블러 정보가 유효한지 확인해 주세요.";
			showAlert(msg, "recentOrderModal", "alertModal");	
			
		} else {
			let url = "/greenTumblerServer/pos/getRecentOrder/" + tumblerInfo.account_id;
		 	let method = "POST";
		 	
		 	sendTumblerRequest(url, method, {}, function(order){
		 		console.log(order);
		 		$('#menu_name').text(order.menu_name);
		 		$('#size').text(order.size);
		 		$('#order_date').text(order.order_date);
		 		$('#store_name').text(order.store_name);
		 		$('#price').text(order.detail_price);
		 	})
		}
	})

</script>