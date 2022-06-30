$(document).ready(function(){
	
$("#searchBar0").validate({
	rules : {
		'otherBrand.productId' : {
			required : true
		},
		'otherBrand.quantity' : {
			required : true,
			number : true
		},
		'otherBrand.costPrice' : {
			required : true,
			number : true
		},
		'otherBrand.sellPrice' : {
			required : true,
			number : true
		},
	},
	messages : {
		'otherBrand.productId' : "Please Enter Brand Name",
		'otherBrand.quantity'  : "Please Enter Numbers only",
		'otherBrand.costPrice' : "Please Enter Numbers only",
		'otherBrand.sellPrice' : "Please Enter Numbers only"
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

$('#btn-add').click(function() {
	
	$('form#searchBar0').submit();

});