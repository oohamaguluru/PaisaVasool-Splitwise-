/**@author dashok
 * 
 */

$(document).ready(function(){
	$("#profilepic").click(function() {
		$.ajax({
			url : "profilePicServlet",
			success : function(data) {
				$("#resultdiv").show();
				$("#resultdiv").html(data);
			}
		});

	});
	
});
