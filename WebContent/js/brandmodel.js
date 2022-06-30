$(document)
		.ready(
				function() {

					$("#brand_list").change(function() {
						var brand = $("#brand_list").val();
						console.log(" on change: " + brand);
						modelName(brand);

					});

					function modelName(brand) {
						if (brand != "") {
							$
									.ajax({

										url : 'addProduct.htm?modelList',

										type : "POST",

										data : {
											"brand" : brand,
										},

										success : function(msg) {
											var model = "";
											model += ('<option value="" selected="selected">Select Model</option>');
											var count = 0;
											$
													.each(
															msg,
															function(key, value) {
																model += ("<option value="
																		+ key
																		+ ">"
																		+ value + "");
																$('#model_list')
																		.html(
																				"");
																$('#model_list')
																		.html(
																				model);
															});
											if ($("#modelName").val() != "") {
												$(
														"#model_list option[value='"
																+ $(
																		"#modelName")
																		.val()
																+ "']").attr(
														'selected', true);
											}

										},
										error : function(jqxhr, textStatus,
												errorThrown) {
											console.log(textStatus, jqxhr
													.getAllResponseHeaders(),
													errorThrown)
										}
									});
						}

					}

				});

$("#searchBar8").validate({
	rules : {
		'brandVO.brandName' : {
			required : true
		}
	},
	messages : {
		'brandVO.brandName' : "Please Enter Brand Name",
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

$("#searchBar9").validate({
	rules : {
		'modelVO.brandId' : {
			required : true
		},
		'modelVO.modelValue' : {
			required : true
		},
	},
	messages : {
		'modelVO.brandId' : "Please Select Brand Name",
		'modelVO.modelValue' : "Please Enter Brand Model",
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

$('#submitForm').click(function() {
	$('form#searchBar8').submit();
});
$('#submitForm1').click(function() {
	$('form#searchBar9').submit();
});