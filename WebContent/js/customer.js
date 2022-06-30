$(document).ready(function()
		
		{
	
	$("#search1" ).validate(
			{
				rules:{	
			email:{
				
				email : true
			},
			phone:{
				number:true
					},
			mobile:{
				number:true
					},
			postCode:{
				number:true
							},
			
				},
			messages:{
				
				email: "Please Enter Email",
				phone:{
					number :"Please Enter Number"
				},
				mobile:{
					number :"Please Enter Number"
				},
				postCode:{
					number :"Please Enter Number"
				},
				},
				errorElement : 'div',
			    errorPlacement: function(error, element) {
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
	
	// $("#success").fadeTo("slow",0.7);
	$('form#search1').submit();
	
});