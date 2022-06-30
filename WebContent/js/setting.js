$(document).ready(function() {
	$("#searchBar10").validate({
		rules : {
			address1 : {
				required : true

			},
			address2 : {
				required : true

			},
			licenseNo : {
				required : true
			},
			mobileNo : {
				required : true,
				number : true,
				minlength : '10',
				maxlength : '10'

			},
			email : {
				required : true,
				email : true
			},

			promoDiscount : {
				number : true
			},

			tax : {
				number : true
			},

		},
		messages : {
			address1 : "Please Enter Address 1",
			address2 : "Please Enter Address 2",
			licenseNo : "Please Enter Lisence No",
			email : "Please Enter Email",

			mobileNo : {
				required : "Please Enter Mobile Number",
				number : "Please Enter 10 digit Number"
			},
			promoDiscount : {
				number : "Please Enter Number",

			},
			tax : {
				number : "Please Enter Number",

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
	$('form#searchBar10').submit();

});