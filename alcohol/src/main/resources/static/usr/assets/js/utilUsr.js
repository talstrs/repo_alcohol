

/*사용자 페이지 세션 로그아웃*/
if(document.getElementById("buttonUsrSignOut")){
	document.getElementById("buttonUsrSignOut").onclick = function () {
		$.ajax({
			
			async: true 
			,cache: false
			,type: "post"
			/* ,dataType:"json" */
			,url: "/signOutUsrCheck"
			
			,success: function(response) {
				if(response.rt == "success") {
					location.href = "/membersUsrLogin";
					
				} else {
					alert("logOut Fail");
				}
			}
			,error : function(jqXHR, textStatus, errorThrown){
				alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
			}
		});
	}
}
