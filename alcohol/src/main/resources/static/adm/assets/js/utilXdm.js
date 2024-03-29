
/*페이징 관련 js*/
goList = function (thisPage) {
    document.querySelector("input[name=thisPage]").value = thisPage;
    form.action = goUrlXdmList;
    form.submit();
}

document.getElementById("buttonSignOut").onclick = function () {
alert("확인");
	$.ajax({
		
		async: true 
		,cache: false
		,type: "post"
		/* ,dataType:"json" */
		,url: "/signOutXdmCheck"
		
		,success: function(response) {
			alert("확인");
			if(response.rt == "success") {
				alert("logOut success")
				location.href = "/membersXdmLogin";
				
			} else {
				alert("logOut Fail");
				// document.getElementById("modalAlertTitle").innerText = "확 인";
				// document.getElementById("modalAlertBody").innerText = "일치하는 회원이 존재 하지 않습니다!";
				// $("#modalAlert").modal("show");
			}
		}
		,error : function(jqXHR, textStatus, errorThrown){
			alert("ajaxUpdate " + jqXHR.textStatus + " : " + jqXHR.errorThrown);
		}
	});
}
