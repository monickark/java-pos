$(document).ready(function() {
	
	$('.till-amount').focusin(function(){
		var amt = $('.till-amount').val();
		if (amt==0.0 ){
			$('.till-amount').val('');
		}
	});

	$("#tillForm").validate({
		rules : {
			amount : {
				required : true,
				number: true
			},
			description : {
				required : true
			}

		},
		messages : {
			amount : {
				required: "Please Enter Amount",
				number: "Enter only Numbers ",
			},
			
			description : "Please Enter Description"
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
$('#submitForm1').click(function() {

	$('form#tillForm').submit();

});