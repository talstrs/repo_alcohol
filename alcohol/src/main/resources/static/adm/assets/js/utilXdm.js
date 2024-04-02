
/*페이징 관련 js*/
goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlXdmList;
    form.submit();
}

/*관리자 페이지 세션 로그아웃*/
if(document.getElementById("buttonXdmSignOut")){
	document.getElementById("buttonXdmSignOut").onclick = function () {
		$.ajax({
			
			async: true 
			,cache: false
			,type: "post"
			/* ,dataType:"json" */
			,url: "/signOutXdmCheck"
			
			,success: function(response) {
				if(response.rt == "success") {
					location.href = "/membersXdmLogin";
					
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
