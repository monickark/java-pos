$(document).ready(
		function(){
			$("#searchBar21").validate({
				rules : {
					categoryName : {
						required : true,
						charAndSpace : true
					},

				},
				messages : {
					categoryName : {
						required : "Please Enter Category Name",
						charAndSpace : "Please Enter Valid Category"
					},

				},
				errorElement : 'div',
				errorPlacement : function(error, element) {
					var placement = $(element).data('error');
					if (placement) {
						$(placement).append(error)
					} else if(element.attr("name") == "terms"){
							error.insertAfter(element.parent().parent());
					}
					else {
						error.insertAfter(element);
					}
				}
			});
		});

$('#submitForm').click(function() {			
	$('form#searchBar21').submit();

});