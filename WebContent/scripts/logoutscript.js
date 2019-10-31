/**@author dashok
 * 
 * This script is executed when the logout button is clicked
 */

$(document).ready(function(){
	$("#signOutButton").click(function() {
			$(logoutForm).submit();
		});

	});
