
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
        	
        	if(menus[i].category2 == category2) {
        		console.log(menus[i].menu_name)
        		posMenuBtns[idx].innerText = menus[i].menu_name;
        		posMenuBtns[idx].dataset.price = menus[i].price;
        		posMenuBtns[idx].dataset.menu_name = menus[i].menu_name;
        		posMenuBtns[idx++].dataset.category2 = menus[i].category2;
        	}
        }
    });	
    
    // 우측 메뉴가 클릭되었을 때
    $(".pos-menu-btn").on("click touchend", function(e){
        $(".pos-menu-btn").removeClass("selected");
        $(this).addClass("selected");
        
        selectedMenu["menu_id"] = parseInt(e.target.dataset.menu_id);
        selectedMenu["menu_name"] = e.target.dataset.menu_name;
        selectedMenu["price"] = e.target.dataset.price;
        selectedMenu["category2"] = e.target.dataset.category2;
    });	
})

function activateSpinner() {
	$("#spinner").css("visibility", "visible");
}

function deactiveSpinner() {
	$("#spinner").css("visibility", "hidden");
}