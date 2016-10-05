$(function(){
	$(".main-menu ul li").on("click", function() {
		alert($(this).attr("id"));

		if (menuId == "menuJoin") {
			location.href = "/member/join";
		} else if (menuId == "menuLogin") {
			location.href = "아직 제작중입니다.";
		} else if (menuId == "menuScheduler") {
			location.href = "/schedule/list";
		}
	});

	$("#btnJoin").on("click", function(){
		location.href = "/member/join";
	});

	function showLoginDialog() {

	}
});