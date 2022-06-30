$(document)
		.ready(
				function()

				{
					
					/*Add Product*/
					var batterytypefirst='No'
					$(".batterytypeadd").val(batterytypefirst);
					var publishtypefirst='No'
						$(".publishtypeadd").val(publishtypefirst);
					
					$('input[name="nonRemovalBatteryadd"]').click(function() {
						console.log("this.val() :" + $(this).val());		
							if ($(this).prop("checked") == true) {	
								batterytype='Yes'
								$(".batterytypeadd").val(batterytype);
							}else if ($(this).prop("checked") == false){
								batterytype='No'
								$(".batterytypeadd").val(batterytype);
							}
					});

					
					$('input[name="publishedadd"]').click(function() {
						console.log("this.val() :" + $(this).val());		
							if ($(this).prop("checked") == true) {	
								publishedtype='Yes'
								$(".publishtypeadd").val(publishedtype);
							}else if ($(this).prop("checked") == false){
								publishedtype='No'
								$(".publishtypeadd").val(publishedtype);
							}
					});	
					
					/*Add Product*/
					
					/*Edit Product*/
					
					var simcard = $(".simCardSize").val().split(',');
					console.log("simcard3 :" + simcard);

					for (i = 0; i < simcard.length; i++) {
						var sim = simcard[i];
						console.log("sim card: " + sim);

						$('input[name="simCard"]').each(function() {
							if ($(this).val() == sim) {
								console.log("this val: " + $(this).val());
								$(this).attr('checked', true);
							}

						});

					}
					$('input[name="simCard"]').click(function() {
						var simcard = [];
						simcard.push($(".simCardSize").val());
						console.log("this.val() :" + $(this).val());

						if ($(this).prop("checked") == true) {
							if(simcard == "") {
								simcard = $(this).val();
							} else {
								simcard.push($(this).val());
							}
							
							$(".simCardSize").val(simcard);
						} else if ($(this).prop("checked") == false) {
							console.log("Checkbox is unchecked.");
							var simArr = $(".simCardSize").val().split(',');
							for (i = 0; i < simArr.length; i++) {
								var sim = simArr[i];

								simArr = jQuery.grep(simArr, function(value) {
									return value != sim;
								});
							}
							$(".simCardSize").val(simArr);

						}

						
					});
					
					var battery = $(".batterytype").val();
					console.log("battery:" + battery);

					if(battery=='Yes'){
					$('input[name="nonRemovalBattery1"]').attr('checked', true);
					}else if(battery=='No'){
						$('input[name="nonRemovalBattery1"]').attr('checked', false);
					}

					
					$('input[name="nonRemovalBattery1"]').click(function() {			
							if ($(this).prop("checked") == true) {	
								batterytype='Yes'
								$(".batterytype").val(batterytype);
							}else if ($(this).prop("checked") == false){
								batterytype='No'
								$(".batterytype").val(batterytype);
							}
					});
					
					
					var publish = $(".publishtype").val();

					if(publish=='Yes'){
					$('input[name="published1"]').attr('checked', true);
					}else if(publish=='No'){
						$('input[name="published1"]').attr('checked', false);
					}

					
					$('input[name="published1"]').click(function() {			
							if ($(this).prop("checked") == true) {	
								publishedtype='Yes'
								$(".publishtype").val(publishedtype);
							}else if ($(this).prop("checked") == false){
								publishedtype='No'
								$(".publishtype").val(publishedtype);
							}
					});
					
					
					/*var colors = $(".multi-colour").val().split(',');
					console.log("colors :" + colors);

					for (i = 0; i < colors.length; i++) {
						var color = colors[i];
						console.log("single color: " + color);
						$('select[name="colour1"] option').each(function() {
							if ($(this).val() == color) {
								console.log("this val color: " + $(this).val());
								$(this).attr('selected',true);
							}

						});
						$('.select-color ul li').each(function() {
							$(this).addClass("active");
							console.log("this val color: " + $('span').text());*/
							
							
							/*console.log("this val color: " + $('span').text());
							if ($('span').text() == color) {
								console.log("this val span: " + $(this).val());
								$(this).attr('checked', true);
							}*/
							
							

						/*});
						

					}*/
					/*$('.select-color').click(function() {
						console.log("this.val() :" + $(this).val());
						var colours = [];
						$.each($("option:selected"), function(){            
            				colours.push($(this).val());
        				});
						$(".multi-colour").val(colours);
						console.log("this.val() :" + $(this).val());
						if ($(this).prop("checked") == true) {
							if(colours == "") {
								colours = $(this).val();
							} else {
								colours.push($(this).val());
							}
							
							$(".multi-colour").val(colours);
						} else if ($(this).prop("checked") == false) {
							console.log("Checkbox is unchecked.");
							var colorArr = $(".simCardSize").val().split(',');
							for (i = 0; i < colorArr.length; i++) {
								var sim = colorArr[i];

								colorArr = jQuery.grep(colorArr, function(value) {
									return value != sim;
								});
							}
							$(".multi-colour").val(colorArr);

						}

					});*/
					
					
					/*Edit Product*/

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

$(".cancel-btn").click(function() {
	$(".sweet-alert").hide();
});

$("#searchBar").validate({
	rules : {
		productName : {
			required : true
		},
		brand : {
			required : true
		},
		model : {
			required : true
		},
		colour : {
			required : true
		}
	},
	messages : {
		productName : "Please Enter Product Name",
		brand : "Please Select Brand",
		model : "Please Select Brand Model",
		colour : "Please Select Colour"
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

/*	onload = function() {
 if (brand != "") {
 var brand = $(".brand").val();
 console.log(" on load: " + brand);
 //	modelName(brand);
 }
 }*/

$('#submitForm').click(function() {
	$('form#searchBar').submit();

});

$.ajaxSetup({
	statusCode : {
		200 : function(data, textStatus, jqxhr) {
			console.log(data);
		},
		406 : function(jqxhr, textStatus, errorThrown) {
			console.log(textStatus + "\n" + errorThrown);
		}
	}
});
