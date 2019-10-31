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
});
