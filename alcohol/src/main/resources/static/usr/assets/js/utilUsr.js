/*페이징 관련 js*/
goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlUsrList;
    form.submit();
}


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
