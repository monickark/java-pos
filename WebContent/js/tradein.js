$(document).ready(
		function()

		{

			$('#redrawSignature').signature({
				disabled : true
			});
			$('#sig').signature({syncField: '#signatureJSON'}); 

			$('#sig').signature('option', 'syncFormat', 'JPEG'); 
			$.ajax({
				type : "GET",
				url : "tradein.htm?getSign",

				success : function(msg) {
					console.log("success data :" + msg);
					$('#redrawSignature').signature('enable').signature('draw',
							msg).signature('disable');

				},
				error : function(jqXHR, textStatus, errorThrown, exception) {
					$('#redrawSignature').signature('draw').signature('disable');
				},

			});

			$(".term-check").click(function() {
				if ($(this).prop("checked") == true){
					$("#modal1").show();
				}else{
					$(".sign-mod").val(null);
					var sig = $('#sig').signature();
					sig.signature('clear');
				}

			
			});
			
			$(".confirm-btn").click(function() {
				var sign = $(".sign-mod").val()
				console.log("sign "+sign);
				$(".sign-hid").val(sign);
			});

			$(function() {
				var sig = $('#sig').signature();
				$('#disable').click(function() {
					var disable = $(this).text() === 'Disable';
					$(this).text(disable ? 'Enable' : 'Disable');
					sig.signature(disable ? 'disable' : 'enable');
				});
				$('#clear').click(function() {
					sig.signature('clear');
				});
				$('#json').click(function() {
					console.log(sig.signature('toJSON'));
				});
				$('#svg').click(function() {
					console.log(sig.signature('toSVG'));
				});
			});

			$("#searchBar15").validate({
				rules : {
					customerName : {

						required : true,
						charAndSpace : true
					},
					brand : {
						required : true
					},
					modelNo : {
						required : true
					},
					contactNo : {
						digits : true
					},
					color : {
						charAndSpace : true
					},
					resaleValue : {
						required : true,
						digits : true
					},
					imei : {
						required : true,
						number : true
					},
					terms: {
				         required : true
				    },

				},
				messages : {

					customerName : {
						required : "Please Enter Customer Name",
						charAndSpace : "Please Enter Valid name"
					},
					brand : "Please Enter Brand",
					modelNo : "Please Enter Model No",
					contactNo : {
						digits : "Please Enter Digits alone"
					},
					color : {
						charAndSpace : "Please Enter Letters alone",
					},
					resaleValue : {
						required : "Please Enter Resale value",
						digits : "Please Enter Digits alone"
					},
					imei : {
						required : "Please Enter IMEI",
						number : "Please Enter Number"
					},
					terms: {
				        required : "Please Accept the terms and conditions"
				    }

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
		/*if ($('input[name="terms"]').prop("checked") == true) {
			$(".terms-error").val("");
			$('form#searchBar15').submit();
		}else if ($('input[name="terms"]').prop("checked") == false){
			var termserror='Please Accept the terms and conditions';
			$(".terms-error").val(termserror);
		}	*/
	$('form#searchBar15').submit();

});

$.ajaxSetup({
	   statusCode : {
	            200 : function (data, textStatus, jqxhr) {
	            },
	            406 : function (jqxhr, textStatus, errorThrown) {
	            }
	        }
	 });