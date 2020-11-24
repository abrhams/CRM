/**
 * 
 */
//切换客户表
function customerdata(){
	$("#tab_manager").attr('style','display:none'); //jq加属性
	$("#tab_customer").attr('style','display:');
	//document.getElementById("tab_manager").style.display="none";
	//alert(document.getElementById("tab_manager").style.display)
	total_customer();
}

function managerdata(){
	$("#tab_manager").attr('style','display:');
	$("#tab_customer").attr('style','display:none');
	total_manager();
}