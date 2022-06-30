$(document).ready(
		function()

		{  
			
			$("#searchBar11").validate({
				rules : {
					category : {

						required : true,
						
					},
					brand : {
						required : true
					},
					name : {
						required : true
					},
					quantity : {
						required : true,
						digits : true
					},
					costPrice : {
						required : true,
						digits : true
					},
					sellingPrice : {
						required : true,
						digits : true
					},
					
				},
				messages : {

					category : {
						required : "Please Select Category",
						
					},
					brand : "Please Enter Brand",
					name : "Please Enter Model No",
					quantity : {
						required : "Please Enter Quantity",
						digits : "Please Enter Numbers only"
					},
					costPrice : {
						required : "Please Enter Cost Price",
						digits : "Please Enter Numbers only"
					},
					sellingPrice : {
						required : "Please Enter Selling Price",
						digits : "Please Enter Numbers only"
					},

				},
				errorElement : 'div',
				errorPlacement : function(error, element) {
					var placement = $(element).data('error');
					if (placement) {
						$(placement).append(error)
					} else {
						error.insertAfter(element);
					}
				}
			});
		});

$('#submitForm').click(function() {
	$('form#searchBar11').submit();

});