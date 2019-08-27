<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!-- Modal -->
<div class="modal fade" id="lostTumblerModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">분실 텀블러 알림</h5>
      </div>
      <div class="modal-body">
   		<div class="row">
   			<div class="col-12 no-padding">
   				<div id="lost-message" class ="white-box">
   					<p>분실된 텀블러로 조회되었습니다.</p>
   					<p>고객님에게 푸시 메세지를 송신합니다.</p>
   				</div>
   			</div>
   		</div>
   		<div class="row mt-3">
   			<div class="col-3 offset-6">
				<button id="sendLostMsg" type="button" class="btn btn-light float-right" data-dismiss="modal">보내기</button>	
			</div>
			<div class="col-3">
				<button type="button" class="btn btn-secondary float-left" data-dismiss="modal">취소</button>	
			</div>
		</div>
      </div>
    </div>
  </div>
</div>
<script>
	$("#sendLostMsg").on("click", function(e){
		$.ajax({
            url: "/greenTumblerServer/fcm/sendLostMsg",
            type: "POST",
            data: {
                accountId: tumblerInfo.account_id,
                msg: tumblerInfo.nickName + " 님의 분실 텀블러가 남산스테이트점에서 결제 시도되었습니다."
            },
            success: function(e) {
                console.log(e);
            }
        });
	})
</script>