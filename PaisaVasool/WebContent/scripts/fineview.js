/**
 * 
 */

$(document).ready(function(){
	
	$("#viewfine").click(function() {
		console.log("reached viewfine");
		$.ajax({
			
			url : "viewFineServlet",
			success : function(data) {
				$("#resultdiv").show();
				$("#resultdiv").html(data);
			}
		});

	});
});
