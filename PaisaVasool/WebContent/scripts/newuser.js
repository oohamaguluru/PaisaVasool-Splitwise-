/**
 * @dashok
 * 
 * This file checks for the addition of a new user to the DBs
 * 
 */

$(document).ready(function() {
	$("#newUserButton").click(function() {

		/* Checking for OID */
		var newOID = $('#oid').val();
		var regex = /^\d+$/;
		if (newOID == '') {
			$('#dangerOID').show();
			flag1 = 1;
		} else if (!regex.test(newOID)) {
			$('#dangerOID').show();
			flag1 = 1;

		} else {
			$('#dangerOID').hide();
			flag1 = 0;
		}

		/* Checking for password */

		if ($('#defaultPassword').val() == '') {
			$('#dangerPassword').show();
			flag2 = 1;
		} else {
			$('#dangerPassword').hide();
			flag2 = 0;
		}

		/* Checking for name */

		if ($('#newUserName').val() == '') {
			$('#dangerName').show();
			flag3 = 1;
		} else {
			$('#dangerName').hide();
			flag3 = 0;
		}
		
		
		$.ajax({
			url : "newUserServlet",
			data : ($("#newForm").serialize()),
			success : function(data) {
				$("#resultField").html(data);
			}
		});

	});

});