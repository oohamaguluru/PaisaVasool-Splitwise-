/**
 * @dashok New User validation script
 */
$(document).ready(function() {

	$("#newUserButton").click(function() {
		
		var flag1=0;
		var flag2=0;
		var flag3=0;
		
		/*Checking for OID*/
		var newOID = $('#oid').val(); 
		var regex = /^\d+$/;
		if(newOID=='') {
			$('#dangerOID').show();
			flag1=1;
		} else if (!regex.test(newOID)) {
			$('#dangerOID').show();
			flag1=1;
			
		} else {
			$('#dangerOID').hide();
			flag1=0;
		}
		
		/*Checking for password*/
		
		
		if( $('#defaultPassword').val()=='') {
			$('#dangerPassword').show();
			flag2=1;
		} else if ( $('#defaultPassword').val()!='admin') {
			$('#wrongPassword').show();
			flag2=1;
		} else {
			$('#dangerPassword').hide();
			$('#wrongPassword').hide();
			flag2=0;
		}
		
		
		/*Checking for name*/
		
		if($('#newUserName').val()=='') {
			$('#dangerName').show();
			flag3=1;
		} else {
			$('#dangerName').hide();
			flag3=0;
		}
		
		if(flag1==0&&flag2==0&&flag3==0) {
			
			document.newUserForm.submit();
		}
	});
});