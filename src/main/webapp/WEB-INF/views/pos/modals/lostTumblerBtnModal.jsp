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
   					<p>김한배 고객님,</p>
   					<p>2019/08/10 에 분실 신고 한</p>
   					<p>고객님의 분실된 텀블러를 </p>
   					<p>'남산 스테이트' 점에서 보관 중입니다.</p>
   				</div>
   			</div>
   		</div>
   		<div class="row mt-3">
   			<div class="col-3 offset-6">
				<button type="button" class="btn btn-light float-right" data-dismiss="modal">보내기</button>	
			</div>
			<div class="col-3">
				<button type="button" class="btn btn-secondary float-left" data-dismiss="modal">취소</button>	
			</div>
		</div>
      </div>
    </div>
  </div>
</div>