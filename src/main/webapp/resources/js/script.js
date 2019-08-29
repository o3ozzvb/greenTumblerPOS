
$(function(){
	
    // 좌측 카테고리 메뉴가 클릭되었을 때
    $(".pos-category-btn").on("click touchstart", function(e){
    	let handled = false;
		
		if(e.type == "touchend") {
			handled = true;
		} else if(e.type=="click" && !handled) {
			
			category2 = e.target.innerText;
	    	let idx = 0;
	        let posMenuBtns = document.getElementsByClassName("pos-menu-btn");
	        
	        $(".pos-menu-btn").removeClass("selected");
	        $(".pos-category-btn").removeClass("selected");
	        $(this).addClass("selected");
	        $(".pos-btn.pos-menu-btn").each(function(){
	        	$(this).text("");
	        })
	        
	        for(var i = 0 ; i < menus.length ; i++) {
	        	if(category2 == '나만의메뉴'){
	        		
	        		if(validateTumbler(tumblerInfo) <= 0) {
	        			let msg = "텀블러 정보가 유효한지 확인해 주세요.";
	        			showAlert(msg, "myMenuModal", "alertModal");	
	        			
	        		} else {
	        			let url = "/greenTumblerServer/pos/getPrivateMenu" ;
	        		 	let method = "GET";
	        		 	
	        		 	let data = {
	        		 			accountId: tumblerInfo.account_id
	        		 	}
	        		 	
	        		 	sendTumblerRequest(url, method, data, function(myMenu){
	        		 		
	        		 		console.log(myMenu);
	        		 		let posMenuBtns = document.getElementsByClassName("pos-menu-btn");
	        		 		
	        		 		for(var i = 0 ; i < myMenu.length ; i++) {
	        		        		
	    		        		posMenuBtns[idx].innerHTML += `
	    		        			<div class="menu-name" style="height: 55px;">
	    		        				`+ myMenu[i].menu_name +`
	    		        			</div>
	    		        		`;
	    		        		posMenuBtns[idx].innerHTML += `
	    		        			<div style="text-center">
	    		        				<img src="`+ myMenu[i].image +`" style="width: 80%; border-radius: 40%" />
	    		        			</div>
	    		        		`;
	    		        		posMenuBtns[idx].dataset.price = myMenu[i].price;
	    		        		posMenuBtns[idx].dataset.menu_id = myMenu[i].menu_id;
	    		        		posMenuBtns[idx].dataset.menu_name = myMenu[i].menu_name;
	    		        		posMenuBtns[idx].dataset.category2 = myMenu[i].category2;
	    		        		posMenuBtns[idx].dataset.shot = myMenu[i].shot;
	    		        		posMenuBtns[idx].dataset.syrup = myMenu[i].syrup;
	    		        		posMenuBtns[idx].dataset.whipped_cream = myMenu[i].whipped_cream;
	    		        		posMenuBtns[idx++].dataset.drizzle = myMenu[i].drizzle;
	    		        		
	        		        }
	        		 		
	        		 	})
	        		}
	        		
	        		break;
	        	}
	        	else if(menus[i].category2 == category2) {
	        		
	        		posMenuBtns[idx].innerHTML += `
	        			<div class="menu-name" style="height: 55px;">
	        				`+ menus[i].menu_name +`
	        			</div>
	        		`;
	        		posMenuBtns[idx].innerHTML += `
	        			<div style="text-center">
	        				<img src="`+ menus[i].image +`" style="width: 80%; border-radius: 40%" />
	        			</div>
	        		`;
	        		posMenuBtns[idx].dataset.price = menus[i].price;
	        		posMenuBtns[idx].dataset.menu_id = menus[i].menu_id;
	        		posMenuBtns[idx++].dataset.category2 = menus[i].category2;
	        	}
	        }
			
		}
    	
    });	
    
    // 우측 메뉴가 클릭되었을 때
    $(".pos-menu-btn").on("click touchend", function(e){
    	let handled = false;
		
		if(e.type == "touchend") {
			handled = true;
		} else if(e.type=="click" && !handled) {
			
			$(".pos-menu-btn").removeClass("selected");
	        $(this).addClass("selected");
	        
	        let element = e.target.parentNode.dataset;
	        selectedMenu["menu_id"] = parseInt(element.menu_id);
	        selectedMenu["menu_name"] = element.menu_name;
	        selectedMenu["price"] = element.price;
	        selectedMenu["category2"] = element.category2;
	        selectedMenu["shot"] = parseInt(element.shot);
	        selectedMenu["syrup"] = parseInt(element.syrup);
	        selectedMenu["whipped_cream"] = (element.whipped_cream=="true");
	        selectedMenu["drizzle"] = (element.drizzle=="true");
	        
	        
	        if(category2 == "나만의메뉴") {
	        	selectedMenu["line_id"] = orderIdx++;
	        	updateOrderList(orderList, selectedMenu);
	        }
			
		}
    });	
})

function activateSpinner() {
	$("#spinner").css("visibility", "visible");
}

function deactiveSpinner() {
	$("#spinner").css("visibility", "hidden");
}