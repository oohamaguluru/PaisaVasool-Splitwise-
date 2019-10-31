/**@dashok
 * 
 * This js file checks if the user has entered correct credentials
 * 
 */

$(document).ready(function(){
	$("#toDashboardButton").click(function(){
		$.ajax({
			url: "loginServlet",
			data : ($("#dashBoardForm").serialize()),
			success:function(data){
				$("#resultField").html(data);
			}
		});
		
	});
	
});