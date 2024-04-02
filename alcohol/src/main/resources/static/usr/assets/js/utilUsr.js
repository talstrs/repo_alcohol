/*페이징 관련 js*/
goList = function (thisPage) {
	alert=("확인");
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlUsrList;
    form.submit();
}


/*사용자 페이지 세션 로그아웃*/
if(document.getElementById("buttonUsrSignOut")){
	document.getElementById("buttonUsrSignOut").onclick = function () {
	alert("확인");
		$.ajax({
			
			async: true 
			,cache: false
			,type: "post"
			/* ,dataType:"json" */
			,url: "/signOutUsrCheck"
			
			,success: function(response) {
				alert("확인");
				if(response.rt == "success") {
					alert("logOut success")
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
