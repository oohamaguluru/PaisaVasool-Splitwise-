/**
 * @dashok
 * 
 * This script file uses ajax to call each of the functionaliteis in the
 * dashboard
 */

$(document).ready(function() {
	
	$("#changepassword").click(function() {
		$.ajax({
			url : "changePassword.jsp",
			success:function(data){
				$("#resultdiv").show();
				$("#resultdiv").html(data);
			}
		});

	});
	$("#profilepic").click(function() {
		$.ajax({
			url : "profilePicServlet",
			data : ($("#profilepic").serialize()),
			success : function(data) {
				$("#resultdiv").show();
				$("#resultdiv").html(data);
			}
		});

	});
	$("#viewfine").click(function() {
		$.ajax({
			url : "viewFine.jsp",
			success : function(data) {
				$("#resultdiv").show();
				$("#resultdiv").html(data);
			}
		});

	});

});
