/**
 * @author dashok
 * 
 * This js checks if both passwords are same and only then gives the submit
 * button
 * 
 */

$(document).ready(function() {
	$("#confirmButton").click(function() {
		var pass1 = $("#newpass").val();
		var pass2 = $("#dummypass").val();

		if (pass1 != pass2) {
			$("#mismatch").show();
		} else if(pass1 == ""){
			$("#mismatch").show();
		} else {
			
			$(myForm).submit();
		}

	});

});
