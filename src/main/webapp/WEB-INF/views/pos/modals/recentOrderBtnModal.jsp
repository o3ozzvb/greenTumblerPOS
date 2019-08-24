<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Modal -->
<div class="modal fade" id="recentOrderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">최근주문정보</h5>
      </div>
      <div class="modal-body">
   		<div class="row">
   			<div class="col-6 offset-3 no-padding">
   				<div class ="white-box">
   					<p>아이스아메리카노 / Venti / 개인컵</p>
   					<p>드리즐, 샷, 시럽, 휘핑</p>
   					<p>2019 / 08 / 19 12:51:56</p>
   					<p>남산스테이트점</p>
   					<p>합계 : 9100</p>
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
		
	 	
	})

</script>