$(document)
		.ready(
				function() {
					$("#poslist").on(
							"click",
							".clear-icon",
							function() {
								 
						var amount = $(this).parent().parent().find(
						".amount").text();
						var removeObj = $(this).parent().parent();
						removeObj.remove();
						var totalAmount = $(".totalAmount").text();
						var delAmount = totalAmount - amount;
						fixDiscount(delAmount, 0);
						var prodName= $(this).parent().parent().find(".productName").text();
						deleteProdName(prodName);
						

					});
					
					function deleteProdName(prodName) {
						if(prodName != "" && prodName!= null){
						$.ajax({

									url : 'possale.htm?delete',

									type : "POST",

									data : {
										"productName" : prodName
									},
									
									success : function(msg) {

									},
									error : function(jqxhr, textStatus, errorThrown) {
										
									}
								});
						}
						
					}
					
					
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
							promoDiscount:{
								number : true
							}
						},
						messages : {
							'otherBrand.productId' : "Please Enter Brand Name",
							'otherBrand.quantity' : {
								required : "Please Enter Quantity",
								number : "Please Enter Numbers"
							},
							'otherBrand.costPrice' : {
								required : "Please Enter Price",
								number : "Please Enter Numbers"
							},
							promoDiscount:{
								number : "Please Enter Numbers"
							}
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
					
					$("#searchBarAcc").validate({
						rules : {
							'accessories.category' : {
								required : true
							},
							'accessories.brand' : {
								required : true
							},
							'accessories.accessoriesId' : {
								required : true
							},
							'accessories.inStock' : {
								notEqual: 0																
							},
							'accessories.quantity' : {
								required : {
				                    depends: function (element) {	
				                    	if($('#stock').val()!=0){
				                    	return true;
				                    }
				                    }
								},
								numbers : true,
								lessThanEqual: "#stock",
								notEqual: 0																
							},
						},
						messages : {
							'accessories.category' : "Please Select Category Name",
							'accessories.brand' : {
								required : "Please Select Brand Name"
							},
							'accessories.accessoriesId' : {
								required : "Please Select Accessory Name"
							},
							'accessories.inStock' : {
								notEqual : "No stock for this product"																
							},
							'accessories.quantity' : {
								required : "Please Enter Quantity",
								numbers : "Please Enter Numbers",
								lessThanEqual : "Quantity must be less than In Stock",
								notEqual : "Quantity must be at least 1"
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
					
					$("#discount-form").hide();
					$('#modal1').click(function() {
						$("#discount-form").show();
					});
					$("#discount-form").validate({
						rules : {
							'percentage' : {
								number : true
							},
							'promo' : {
								number : true
							},
						},
						messages : {
							'percentage' :{
								number : "Please Enter Numbers"
							},
							'promo' : {
								number : "Please Enter Numbers"
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
					
					
					/*$('#btn-add').click(function() {

						$('form#searchBar0').submit();

					});*/

					$('#disc-btn').click(function() {

						$('form#discount-form').submit();

					});

					var validator = $("#search").validate({
						rules : {
							imei : {
								required : true,
								number : true
							},
							costPrice : {
								required : true,
								number : true
							},
							sellPrice : {
								required : true,
								number : true
							},

						},
						messages : {
							imei : {
								required : "Please Enter IMEI Number",
								number : "Please Enter Number"
							},
							costPrice : {
								required : "Please Enter Cost Price",
								number : "Please Enter Number"
							},
							sellPrice : {
								required : "Please Enter Selling Price",
								number : "Please Enter Number"
							}
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
					
					$(".close-btn").click(function() {
					    validator.resetForm();
					});

					$(".tab-colours").on(
							"click",
							".tab-link",
							function() {
								$(".imei-add").val("");
								var colour = $(this).text();
								function toTitleCase(colour) {
								    return colour.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
								}
								$(".colour").val(toTitleCase(colour));
								$('.tab-link').css('border-bottom', '');
								$(this).css('border-bottom', '3px solid #00bcd4');
							});

					$("#imeiNumber").val("");
					$(".modal-discount").hide();
					$(".btn-discount").click(function() {
						$(".modal-discount").show();
					});

					$(".cancel-btn").click(function() {
						$(".modal-discount").hide();
					});
					$(".confirm-btn").click(function() {
						$(".modal-discount").hide();
					});

				/*$(".clear-icon").click(
							function() {
								var amount = $(this).parent().parent().find(
										".amount").text();
								var removeObj = $(this).parent().parent();
								removeObj.remove();
								var totalAmount = $(".totalAmount").text();
								var delAmount = totalAmount - amount;
								fixDiscount(delAmount, 0);
							});*/

					$(".discount")
							.keyup(
									function() {
										var discount = $(this).val();
										var amount = $(this).parent().parent()
												.find(".amount").text();
										console.log("discount :" + discount);
										var qty = $(this).parent().parent()
												.find(".quantity").html();
										var price = $(this).parent().parent()
												.find(".price").text();
										console.log("qty :" + qty);
										console.log("price :" + price);
										var discAmount = ((qty * price) - discount)
												.toFixed(2);
										$(this).parent().parent().find(
												".amount").text(discAmount);
										console
												.log("discAmount :"
														+ discAmount);
										var totalAmount = ($(".totalAmount")
												.text());
										console.log("totalAmount :"
												+ totalAmount);
										var netAmount = (parseInt(totalAmount) - parseInt(amount
												- discAmount)).toFixed(2);
										console.log("netAmount :" + netAmount);
										var promoAmount = $(".disc-amount")
												.val();
										if (promoAmount == '') {
											promoAmount = 0;
										}
										fixDiscount(netAmount, promoAmount);
									});
					$(".oamt").attr('readonly', true);
					$(".ocp").keyup(function() {
						getAmountFill()
					});
					$(".oqty").keyup(function() {
						getAmountFill()
					});
					function getAmountFill() {
						var price = $(".ocp").val();
						var qty = $(".oqty").val();
						var amount = price * qty;
						console.log("amount :" + amount);
						$(".oamt").val(amount);
					}

					$(".quantity")
							.keyup(
									function() {
										var quantity = $(this).val();
										var amount = $(this).parent().parent()
												.find(".amount").text();
										var price = $(this).parent().parent()
												.find(".price").text();
										var discount = $(this).parent()
												.parent().find(".discount")
												.val();
										var quanAmount = ((quantity * price) - discount)
												.toFixed(2);
										$(this).parent().parent().find(
												".amount").text(quanAmount);
										var totalAmount = $(".totalAmount")
												.text();
										var netAmount = parseInt(totalAmount)
												+ parseInt((quanAmount - amount));
										fixDiscount(netAmount, 0);
									});

					$(".disc").keyup(
							function() {
								var amount = $(".totalAmount").text();
								var percentage = $(".disc").val();
								var promoAmount = (amount * percentage / 100)
										.toFixed(2);
								$(".disc-amount").val(promoAmount);
								if (promoAmount == '') {
									promoAmount = 0;
								}
								fixDiscount(amount, promoAmount);
							});

					$(".disc-amount").keyup(function() {
						var amount = $(".totalAmount").text();
						$(".disc").val("");
						var promoAmount = $(".disc-amount").val();
						if (promoAmount == '') {
							promoAmount = 0;
						}
						fixDiscount(amount, promoAmount);
					});

					function fixDiscount(amount, promoAmount) {
						$(".totalAmount").text((amount));
						$(".promoAmount").text((promoAmount));

						var payable = (amount - promoAmount).toFixed(2);
						console.log("payable :" + payable);
						$(".payableAmount").text(payable);

						var netAmount = (payable * 0.909).toFixed(2);
						console.log("netAmount :" + netAmount);
						$(".netAmount").text(netAmount);

						var taxamount = (payable - netAmount).toFixed(2);
						$(".taxAmount").text(taxamount);
					}

					$(".disc").focusout(function() {
						/* $(".modal-discount").hide(); */

					});

					$(".disc-amount").focusout(function() {
						/* $(".modal-discount").hide(); */

					});

					$(".display").on(
							"click",
							".inventory",
							function() {
								validator.resetForm();
								$(".cp-add").val("");
								$(".sp-add").val("");
								$(".imei-add").val("");
								$(".footer-success").text("");
								$(".footer-fail").text("");
								console.log("click2");
								var id = $(this).parent().parent().parent()
										.find(".id").text();
								console.log("$(this).parent() : "
										+ $(this).parent().parent());
								console.log("id:"
										+ $(this).parent().find(".id"));
								console.log("id val:" + id);
								getProduct(id);

							});

					function getProduct(productId) {
						console.log("inside view product");
						console.log('productId :' + productId);
						$
								.ajax({
									type : "GET",
									url : "productMasterList.htm",
									data : {
										"productIdView" : productId
									},
									success : function(msg) {
										console.log("success data :" + msg);
										console.log("product name :"
												+ msg.productName);
										console.log("Colours : " + msg.colour);
										var myArr = msg.colour;
										var result = myArr.split(',');
										console.log("Result :" + result);
										$.each(result, function(index, value) {
											console.log(index + ": " + value);
										});										
										var text_tab = '<ul class="tabs tab-profile z-depth-1 deep-orange accent-2">';

										$
												.each(
														result,
														function(index, value) {
															text_tab += '<li class="tab col s3 "><a class="white-text tab-link waves-effect waves-light">'
																	+ value
																			.toUpperCase()
																	+ '</a></li>'
														});

										text_tab += '</ul>'
										$(".tab-colours").text(text_tab);
										$(".tab-colours").html(text_tab);
										$(".colour").val(result[0]);
										$('.tab-colours li:first .tab-link').css('border-bottom', '3px solid #00bcd4');
										$(".idInvAdd").val(msg.productId);
										$(".productNameModel").text(
												msg.productName);
										$(".ramCapacityModel").text(
												msg.ramCapacity + " GB RAM");
										$(".batteryModel").text(msg.battery+ " Battery");
										$(".simTypeModel").text(msg.simType);
										$(".brandModel").text(msg.model);
										$(".descriptionModel").text(
												msg.description);
									},
									error : function(jqXHR, textStatus,
											errorThrown, exception) {
										console.log("no record found");
									},

								});

					}
					
					
					$(".display").on(
							"click",
							".viewProd",
							function() {
								console.log("click2");
								var id = $(this).parent().parent().find(".id")
										.text();
								console.log("$(this).parent() : "
										+ $(this).parent().parent());
								console.log("id:"
										+ $(this).parent().find(".id"));
								console.log("id val:" + id);
								getProductView(id);

							});

					function getProductView(productId) {
						console.log("inside view product");
						console.log('productId :' + productId);
						$
								.ajax({
									type : "GET",
									url : "productMasterList.htm",
									data : {
										"productIdView" : productId
									},
									success : function(msg) {
										$(".idModel").val(msg.productId);
										$(".productNameModel").text(
												msg.productName);
										$(".ramCapacityModel").text(
												msg.ramCapacity + " GB RAM");
										$(".batteryModel").text(
												msg.battery + " Battery");
										$(".simTypeModel").text(msg.simType);
										$(".brandModel").text(msg.brand);
										$(".descriptionModel").text(
												msg.description);
										$(".modelmodel").text(msg.model);
										$(".colourModel").text(msg.colour);
										$(".osModel").text(msg.os);
										$(".dimensionsModel").text(
												msg.dimensions);
										$(".displayModel").text(msg.display);
										$(".categoryModel").text(msg.category);
										$(".nonRemovalBatteryModel").text(
												msg.nonRemovalBattery);

									},
									error : function(jqXHR, textStatus,
											errorThrown, exception) {
										console.log("no record found");
									},

								});

					}

					/*$(".tab").change(function() {
						$(".imei-add").val("");
					});*/

					$(document).on('change','.imei-add , .cp-add , .sp-add',function() {
						if ($('#search').validate().form()) {
							var imei = $(".imei-add").val();
							var id = $(".idInvAdd").val();
							var cp = $(".cp-add").val();
							var sp = $(".sp-add").val();
							var colour = $(".colour").val();
							console.log("cp: " + cp);
							console.log("sp: " + sp);
							console.log("imei: " + imei);
							console.log("colour: " + colour);
							console.log("id: " + id);
							insertInventory(id, imei, cp, sp, colour);
					    } else {					    	
					    }
					});

					function insertInventory(id, imei, cp, sp, colour) {
						console.log("inside insert inventoryt");
						$
								.ajax({
									type : "GET",
									url : "productMasterInventory.htm",
									data : {
										"inInvAdd" : id,
										"imei" : imei,
										"cp" : cp,
										"sp" : sp,
										"colour" : colour
									},
									success : function(msg) {
										console.log("success data :" + msg);
										if (msg == "success") {
											$(".footer-success")
													.text(
															imei
																	+ ": Item added to inventory !");
											$(".footer-fail").text("");
											$(".imei-add").val("");
										} else {
											$(".footer-fail")
													.text(
															imei
																	+ ": Item already exist !");
											$(".footer-success").text("");

										}

									},
									error : function(jqXHR, textStatus,
											errorThrown, exception) {
										console.log("Duplicate entry");
									},

								});

					}
					$(".display").on(
							"click",
							".btn-warning-confirm-delete",function() {
						var productId = $(this).parent().parent().find(".id")
						.text();
						deleteproduct(productId);
					});
					
					function deleteproduct(productId){
						swal({
								title: "Are you sure?",
								text: "You will not be able to recover this data!",
								type: "warning",
								showCancelButton: true,
								confirmButtonColor: '#DD6B55',
								confirmButtonText: 'Yes, delete it!',
								closeOnConfirm: false
							},
							function () {
				                    $.ajax({
				                        type: "GET",
				                        url: "productMasterList.htm",
				                        data: {
				                        	"id" : productId
				                        },
				                        success: function(){ 
				                            swal("Deleted!", "Your product has been deleted!", "success");
				                            window.location.reload();
				                        },
				                        error: function(){
				                            swal("Error", "Product Could not be deleted!", "error");   
				                        }

				                    });  

							});
					};
					
						$("#newcustomerName").hide();
						$("#newcustomerId").show();
						var name = $(".getcustomername").val();
						if(name!=null && name!=''){
							$("#newcustomerId").hide();
							$("#newcustomerName").show();
							$("#newcustomerNamevalue").val(name);
						}
						$("#newcustomerbtn").click(function() {
							var name = $(".getcustomername").val();
							if(name!=null && name!=''){
								$("#newcustomerId").hide();
								$("#newcustomerName").show();
								$("#newcustomerNamevalue").val(name);
							}
						});
						
				});