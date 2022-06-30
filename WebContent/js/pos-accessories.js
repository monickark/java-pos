$(document)
		.ready(
				function() {
					$("#stock").attr('readonly', true);
					$("#costprice").attr('readonly', true);
					$("#sellingprice").attr('readonly', true);
/*					$("button[name='addaccessory']").click(function(e) {
						  alert("ready!");
						  e.preventdefault();
					});*/
					
					/*$("#qty")
					.keyup(
							function() {
								var quantity = $(this).val();
								var stock = $(this).parent().parent()
										.find("#stock").val();
								if (stock<quantity) {
									$('.qtyerror').text("Only "+stock+" Available");
								}else{
									$('.qtyerror').text("");
								}
							});*/

					$("#categoryClass"). change(function(){
						
						var category= $("#categoryClass").val();
						getbrand(category);
						
        				$('#nameList').html('<option value="" selected="selected">Select Accessory</option>');
        				$("#stock").val('');
						$("#costprice").val('');
						$("#sellingprice").val('');
						$('.accessorySpan').text("");
						$('.inventorySpan').text("");
        				

					});
					
					function getbrand(category) {
						if(category != "" && category!= null){
						$.ajax({

									url : 'possale.htm?brandList',

									type : "POST",

									data : {
										"category" : category
									},
									
									success : function(msg) {
										var brand= "";
										brand += ('<option value="" selected="selected">Select Brand</option>');
										var count = 0;
							        		 $.each(msg, function(key, value) {
							        			 
							        				brand +=("<option value="+ key + ">" + value + "");
							        				$('#brandList').html("");  					        				        				        			        
								        			$('#brandList').html(brand);	
									        	});
							        	$('.brandSpan').text("");

									},
									error : function(jqxhr, textStatus, errorThrown) {
										$('.brandSpan').text("Brand not found");
										$('#brandList').html('<option value="" selected="selected">Select Brand</option>');
										}
								});
						}
						
					}
					
					
					$("#brandList"). change(function(){
						
						var category= $("#categoryClass").val();
						var brand= $("#brandList").val();
						getaccessory(category,brand);
						$("#stock").val('');
						$("#costprice").val('');
						$("#sellingprice").val('');
						$('.inventorySpan').text("");
						$('#nameList').html('<option value="" selected="selected">Select Accessory</option>');

					});
					
					function getaccessory(category,brand) {
						if(category != "" && category!= null && brand!="" && brand!= null){
						$.ajax({

									url : 'possale.htm?nameList',

									type : "POST",

									data : {
										"category" : category,
										"brand" : brand
									},
									
									success : function(msg) {
										var accessory= "";
							        		 var count = 0;
							        		 accessory += ('<option value="" selected="selected">Select Accessory</option>');
							        		 $.each(msg, function(key, value) {			        				
							        			 accessory +=("<option value="+ key + ">" + value + "");
							        				$('#nameList').html("");  					        				        				        			        
								        			$('#nameList').html(accessory);	
									        	});
							        		 $('.accessorySpan').text("");

									},
									error : function(jqxhr, textStatus, errorThrown) {
										$('.accessorySpan').text("Accessory not found");
										}
								});
						}
						
					}
					
					$("#nameList").change(function(){
						var accessory= $('#nameList').val();
						inventory(accessory);
						

					});
					
					function inventory(accessory) {
						if(accessory != ""){
						$.ajax({

									url : 'possale.htm?getInventory',

									type : "POST",

									data : {
										"accessory" : accessory
									},
									
									success : function(msg) {
										$("#stock").val(msg.quantity);
										$("#costprice").val(msg.costPrice);
										$("#sellingprice").val(msg.sellingPrice);
										$('.inventorySpan').text("");
										var name=$("#nameList option[value='"+$("#nameList").val()+"']").attr('selected',true).text();
										$("#accessoryName").val(name);
										if($("#stock").val()==0){
											$("#qty").attr('readonly',true);
										}else{
											$("#qty").attr('readonly',false);
										}
									},
									error : function(jqxhr, textStatus, errorThrown) {
										$("#stock").val('');
										$("#costprice").val('');
										$("#sellingprice").val('');
										$('.inventorySpan').text("Accessory not in Inventory");
										}
								});
						}
						
					}
					
					
				});

$.ajaxSetup({
	   statusCode : {
	            200 : function (data, textStatus, jqxhr) {
	            },
	            406 : function (jqxhr, textStatus, errorThrown) {
	            }
	        }
	 });