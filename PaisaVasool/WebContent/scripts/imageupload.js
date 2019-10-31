/**
 * 
 */

$(document).ready(function(){
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
	
});
