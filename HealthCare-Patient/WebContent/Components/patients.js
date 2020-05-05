$(document).ready(function() {
	$("#alertSuccess").hide();
	$("#alertError").hide();
});

// SAVE ============================================
$(document).on("click", "#btnSave", function(event) {

	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validatePatientForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	var type = ($("#hidPatientIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "PatientsAPI",
		type : type,
		data : $("#formPatient").serialize(),
		dataType : "text",
		complete : function(response, status) {
			console.log(response)
			onPatientSaveComplete(response.responseText, status);
		}
	});
});

function onPatientSaveComplete(response, status) {
	if (status == "success") {
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divPatientssGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else {
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidPatientIDSave").val("");
	$("#patientId")[0].reset();
}



// CLIENT-MODEL================================================================
function validatePatientForm() {
	// First name
	if ($("#pFname").val().trim() == "") {
		return "Insert First Name";
	}

	// Last name
	if ($("#pLname").val().trim() == "") {
		return "Insert Last Name.";
	}
	

	//  NIC
	if ($("#pNIC").val().trim() == "") {
		return "Insert NIC.";
	}
	

	//  NIC
	if ($("#pAddress").val().trim() == "") {
		return "Insert Address.";
	}
	
	
	
	// Gender
	if ($("#pGender").val().trim() == "") {
		return "Insert Gender.";
	}
	// Email
	if ($("#pEmail").val().trim() == "") {
		return "Insert Email.";
	}

	// Age
	if ($("#pAge").val().trim() == "") {
		return "Insert Age.";
	}
	// phone
	if ($("#pPhone").val().trim() == "") {
		return "Insert Phone.";
	}
	// Adimitted
	if ($("#pAdmitted").val().trim() == "") {
		return "Insert AdmittedDate.";
	}
	
	
	return true;
}

//// UPDATE==========================================
//	$(document).on("click", ".btnUpdate", function(event)
//			{
//				$("#hidDoctorIDSave").val($(this).closest("tr").find('#hidDoctorIDSave').val());
//				$("#fName").val($(this).closest("tr").find('td:eq(0)').text());
//				$("#lNmae").val($(this).closest("tr").find('td:eq(1)').text());
//				$("#rdoGenderMale").val($(this).closest("tr").find('td:eq(2)').text());
//				$("#age").val($(this).closest("tr").find('td:eq(3)').text());
//				$("#docNIC").val($(this).closest("tr").find('td:eq(4)').text());
//				$("#docEmail").val($(this).closest("tr").find('td:eq(5)').text());
//				$("#passwod").val($(this).closest("tr").find('td:eq(6)').text());
//				$("#phoneNumber").val($(this).closest("tr").find('td:eq(7)').text());
//			});
//	
//	//Remove
//	$(document).on("click", ".btnRemove", function(event)
//			{
//		
//		$.ajax({
//			url : "DoctorAPI",
//			type : type,
//			data : $("#doctorFome").serialize(),
//			dataType : "text",
//			complete : function(response, status) {
//				console.log(response)
//				onDoctorDeleteComplete(response.responseText, status);
//			}
//		
//		});
//	});
//
//	
//		function onDoctorDeleteComplete(response, status)
//		{
//			if (status == "success")
//		{
//				var resultSet = JSON.parse(response);
//				if (resultSet.status.trim() == "success")
//		{
//				$("#alertSuccess").text("Successfully deleted.");
//				$("#alertSuccess").show();
//				$("#hidDoctorIDSave").html(resultSet.data);
//		} 
//		else if (resultSet.status.trim() == "error")
//		{
//				$("#alertError").text(resultSet.data);
//				$("#alertError").show();
//		}
//		}
//		else if (status == "error")
//		{
//			$("#alertError").text("Error while deleting.");
//			$("#alertError").show();
//		} 
//		else
//		{
//			$("#alertError").text("Unknown error while deleting..");
//			$("#alertError").show();
//		}
//}