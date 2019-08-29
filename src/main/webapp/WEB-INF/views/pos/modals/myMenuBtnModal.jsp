<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Modal -->
<div class="modal fade" id="myMenuModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">나만의 메뉴</h5>
      </div>
      <div class="modal-body">
   		<div id="my-menu-area" class="row">
   			
   			
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

	$('#myMenuModal').on('shown.bs.modal', function (e) {
		
		// let tumbler = JSON.parse('${ sessionScope.tumblerJson }');
		if(validateTumbler(tumblerInfo) <= 0) {
			let msg = "텀블러 정보가 유효한지 확인해 주세요.";
			showAlert(msg, "myMenuModal", "alertModal");	
			
		} else {
			let url = "/greenTumblerServer/pos/getPrivateMenu" ;
		 	let method = "GET";
		 	
		 	let data = {
		 			accountId: tumblerInfo.account_id
		 	}
		 	
		 	sendTumblerRequest(url, method, data, function(tumbler){
		 		
		 		console.log(tumbler);
		 		$("#my-menu-area").html("");
		 		for(var i = 0 ; i < tumbler.length ; i++) {
		 			
		 			$("#my-menu-area").append(`
		 				<div class="col-4 mt-2">
		 					<img style="border-radius: 25px;" src="`+tumbler[i].image+`" width="100%" />
		 					<div style="border-radius: 15px; background-color: #F1F3F5; margin-top: 3px; width: 100%;">
		 					<div style="vertical-align:middle; text-align:center; height:52px;">
		 						<span style="color:black; font-size:1.1rem; font-weight:bold; "> ` + tumbler[i].menu_name + `</span>
		 					</div>
		 						<p style="color:black; text-align:center"> ` + (tumbler[i].size=="T" ? `Tall` : tumbler[i].size=="G" ? `Grande` : `Venti` ) + `</p>
		 						<p style="color:black; text-align:center"> ` + `샷     : ` + tumbler[i].shot + `</p>
		 						<p style="color:black; text-align:center"> ` + `시럽   : ` + tumbler[i].syrup + `</p>
		 						<p style="color:black; text-align:center"> ` + `휘핑   : ` + (tumbler[i].whipped_cream? `Y` : `N`) + `</p>
		 						<p style="color:black; text-align:center"> ` + `드리즐 : ` + (tumbler[i].drizzle ? `Y` : `N`) + `</p>
		 					</div>
		 					<button type="button" 
		 							class="btn btn-light" style="margin-top: 5px; width:100% background-color: "
		 							data-menu_name="`+ tumbler[i].menu_name +`"
		 							data-size="`+ tumbler[i].size +`"
		 							data-cup="`+ tumbler[i].cup +`"
		 							data-drizzle="`+ tumbler[i].drizzle +`"
		 							data-shot="`+ tumbler[i].shot +`"
		 							data-syrup="`+ tumbler[i].syrup +`"
		 							data-whipped_cream="`+ tumbler[i].whipped_cream +`"
		 							data-price="`+ tumbler[i].price +`"
		 							data-menu_id="`+ tumbler[i].menu_id +`"
		 							onclick="addMyMenuToOrderList(event)">
		 						가져오기
		 					</button>	
		 				</div>	
		 			`);
		 			
		 		}
		 	})
		}
	})
	
	function addMyMenuToOrderList(e) {
		let dataset = e.target.dataset;
		console.log(dataset);
		let menu_name = dataset.menu_name;
		let size = dataset.size;
		let cup = dataset.cup;
		let drizzle = (dataset.drizzle == "true");
		let shot = parseInt(dataset.shot);
		let syrup = parseInt(dataset.syrup);
		let whipped_cream = (dataset.whipped_cream == "true");
		let price = parseInt(dataset.price);
		let menu_id = parseInt(dataset.menu_id);
		let option_sum = 0;
		let private_menu_yn = true;
		let is_tumbler = true;
		
		option_sum += (drizzle ? optionPrice : 0);
		option_sum += (whipped_cream ? optionPrice : 0);
		option_sum += (shot * optionPrice);
		option_sum += (syrup * optionPrice);
		
		
		selectedMenu = {
			menu_name: menu_name,
			size: size,
			cup: cup,
			drizzle: drizzle,
			syrup: syrup,
			shot: shot,
			whipped_cream: whipped_cream,
			line_id: orderIdx++,
			price: price,
			menu_id: menu_id,
			menu_cnt: 1,
			option_sum: option_sum,
			private_menu_yn: private_menu_yn,
			is_tumbler: is_tumbler
		};
		
		updateOrderList(orderList, selectedMenu);
		
		$("#myMenuModal").modal("hide");
		
	}
</script>

