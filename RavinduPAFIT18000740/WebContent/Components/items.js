$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});

//SAVE
$(document).on("click", "#insertPatient", function(event)
{
		
	// Clear alerts---------------------
		
	$("#alertSuccess").text("");
		
	$("#alertSuccess").hide();
		 
	$("#alertError").text("");
		 
	$("#alertError").hide(); 
		 
		
	// Form validation-------------------
		 
	var status = validateItemForm();
		 
	if (status != true)
		  
	{
		  
		$("#alertError").text(status);
		  
		$("#alertError").show();
		  
		return;
		  
	}
		
	// If valid-------------------------

	var type = ($("#hidPatientIDSave").val() == "") ? "POST" : "PUT";
	$.ajax(
			{
			 url : "PatientsAPI",
			 type : type,
			 data : $("#formItem").serialize(),
			 dataType : "text",
			 complete : function(response, status)
			 {
			 onItemSaveComplete(response.responseText, status);
			 }
			});
		 
});

function onItemSaveComplete(response, status)
{

	if (status == "success")
 
	{
 
		var resultSet = JSON.parse(response);
 
		if (resultSet.status.trim() == "success")
 
		{
 
			$("#alertSuccess").text("Successfully saved.");
 
			$("#alertSuccess").show();
 
			$("#divItemsGrid").html(resultSet.data);
 
		} 
		else if (resultSet.status.trim() == "error")
 
		{
 
			$("#alertError").text(resultSet.data);
 
			$("#alertError").show();
 
		}
 
	} 
	else if (status == "error")
 
	{
 
		$("#alertError").text("Error while saving.");
 
		$("#alertError").show();
 
	} else
 
	{
 
		$("#alertError").text("Unknown error while saving..");
 
		$("#alertError").show();
 
	}
 
	$("#hidItemIDSave").val("");
 
	$("#formItem")[0].reset();

}


//UPDATE
$(document).on("click", ".btnUpdate", function(event)
{
		 
	$("#hidPatientIDSave").val($(this).closest("tr").find('#hidPatientIDUpdate').val());
//should be disabled		 
	$("#patientUsername").val($(this).closest("tr").find('td:eq(0)').text());
		
	$("#patientPassword").val($(this).closest("tr").find('td:eq(1)').text());
		 
	$("#patientName").val($(this).closest("tr").find('td:eq(2)').text());
		
	$("#patientAddress").val($(this).closest("tr").find('td:eq(3)').text());
	
	$("#patientContact").val($(this).closest("tr").find('td:eq(4)').text());
	
	$("#patientEmail").val($(this).closest("tr").find('td:eq(5)').text());

});

//CLIENT-MODEL================================================================

function validateItemForm()

{

	// CODE

	if ($("#patientUsername").val().trim() == "")
 
	{
 
		return "Insert Patient User Name.";
 
	}

	// NAME

	if ($("#patientPassword").val().trim() == "")
 
	{

		return "Insert Patient Password.";

	}

	// PRICE-------------------------------

	if ($("#patientName").val().trim() == "")
 
	{

		return "Insert Patient Name.";
 
	}

	if ($("#patientAddress").val().trim() == "")
		 
	{

		return "Insert Patient Address.";
 
	}
	
	if ($("#patientContact").val().trim() == "")
		 
	{

		return "Insert Patient Contact.";
 
	}
	
	if ($("#patientEmail").val().trim() == "")
		 
	{

		return "Insert Patient Email.";
 
	}
	// is numerical value

	var cont = $("#patientContact").val().trim();

	if (!$.isNumeric(cont))
 
	{

		return "Insert a numerical value as your number";

	}



	return true;
}

$(document).on("click", ".btnRemove", function(event)
		{
				 
			$.ajax(
				 
					{
				 
						url : "PatientsAPI",
				 
						type : "DELETE",
				 
						data : "patientID=" + $(this).data("patientid"),
				 
						dataType : "text",
				 
						complete : function(response, status)
				 
						{
				 
							onItemDeleteComplete(response.responseText, status);
				 
						}
				 
					});
				
		});

		function onItemDeleteComplete(response, status)

		{

			if (status == "success")
		 
			{
		 
				var resultSet = JSON.parse(response);

				if (resultSet.status.trim() == "success")
		 
				{
		 
					$("#alertSuccess").text("Successfully deleted.");
		 
					$("#alertSuccess").show();
		 
					$("#divItemsGrid").html(resultSet.data);
		 
				} else if (resultSet.status.trim() == "error")
		 
				{
		 
					$("#alertError").text(resultSet.data);
		 
					$("#alertError").show();
		 
				}
		 
			} else if (status == "error")
		 
			{
		 
				$("#alertError").text("Error while deleting.");
		 
				$("#alertError").show();
		 
			} else
		 
			{
		 
				$("#alertError").text("Unknown error while deleting..");
		 
				$("#alertError").show();
		 
			}
		}