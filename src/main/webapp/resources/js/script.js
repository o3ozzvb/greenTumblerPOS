
$(function(){
	
    // 좌측 카테고리 메뉴가 클릭되었을 때
    $(".pos-category-btn").on("click touchstart", function(e){
    	let category2 = e.target.innerText;
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
        		console.log("나만의메뉴");
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
    });	
    
    // 우측 메뉴가 클릭되었을 때
    $(".pos-menu-btn").on("click touchend", function(e){
        $(".pos-menu-btn").removeClass("selected");
        $(this).addClass("selected");
        console.log(e.target.parentNode)
        selectedMenu["menu_id"] = parseInt(e.target.parentNode.dataset.menu_id);
        selectedMenu["menu_name"] = e.target.parentNode.dataset.menu_name;
        selectedMenu["price"] = e.target.parentNode.dataset.price;
        selectedMenu["category2"] = e.target.parentNode.dataset.category2;
    });	
})

function activateSpinner() {
	$("#spinner").css("visibility", "visible");
}

function deactiveSpinner() {
	$("#spinner").css("visibility", "hidden");
}