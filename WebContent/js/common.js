//Custom rule for allowing alphanumeric and -
			 $.validator.addMethod("alphaNumerichyphenAndSlahes", function(value, element) {				
			        return this.optional(element) || /^[a-zA-Z0-9\-\s\/\\]+$/i.test(value);
			    }, "This must contain only numbers,characters,slashes and hyphen.");

			 
//Custom rule for Name(allowing text,.,',-)
			 $.validator.addMethod("NameValidation", function(value, element) {				
			        return this.optional(element) || /^[[a-zA-Z\s\'\.\-]+$/i.test(value);
			    }, "Username must contain only characters,dot,Apostrophe,hyphen and space.");		

//Custom rule for city(allowing text,'-',space)
			 $.validator.addMethod("cityName", function(value, element) {						
			        return this.optional(element) || /^[a-zA-Z\-\s]+$/i.test(value);
			    }, "City/Place must contain only characters,hyphen and space.");
			 
			 
//Custom rule for BloodGroup(allowing A,B,AB,O,+,-)
			 $.validator.addMethod("bloodGroup", function(value, element) {						
			        return this.optional(element) || /^(A|B|AB|O)[+-]$/i.test(value);
			    }, "Blood Group must contain only A,B,AB,O,+,-.");
			 
//Custom rule for CharandSpace(allowing char and space)
			 $.validator.addMethod("charAndSpace", function(value, element) {						
			        return this.optional(element) || /^[a-zA-Z\s]+$/i.test(value);
			    }, "This must contain only char and space.");		
			 
//Custom rule for Qualification(allowing char,space,dot,comma,hyphen)
			 $.validator.addMethod("qualificationValidation", function(value, element) {						
			        return this.optional(element) || /^[a-zA-Z\-\s\.\,]+$/i.test(value);
			    }, "Qualification must contain only char,space,comma and dot.");	
			 	
			 
//Custom rule for Address(allowing char and space)
			 $.validator.addMethod("address", function(value, element) {						
			        return this.optional(element) || /^[a-zA-Z0-9\-\s\.\,\/\\]+$/i.test(value);
			    }, "Address must contain only character,numbers,space,dot,comma,'\','/'.");	
			 
			 
//Custom rule for File size validations			 
			 $.validator.addMethod('filesize', function(value, element, param) {	
				    return this.optional(element) || (element.files[0].size <= param) ;
				});			 
			 
//Condition to check entered value is not 0
			 jQuery.validator.addMethod("notEqual", function(value, element,param) {
				  return this.optional(element) || value != param;
				}, "Invalid value");

//Condition to check entered value is less than and Equal			 
			 jQuery.validator.addMethod('lessThanEqual', function(value, element, param) {
				    return this.optional(element) || parseInt(value) <= parseInt($(param).val());
				}, "The value {0} must be less than {1}");
			 
			//Custom rule for numbers(allowing numbers)
			 $.validator.addMethod("numbers", function(value, element) {						
			        return this.optional(element) || /^[0-9]+$/i.test(value);
			    }, "Address must contain only character,numbers,space,dot,comma,'\','/'.");	
			 
//Condition to check entered value of Stock	 greater than 0		 
			 /*jQuery.validator.addMethod('checkStock', function(value, element, param) {
				    return this.optional(element) || parseInt(value) > parseInt($(param).val());
				}, "The value {0} must be less than {1}");*/
			 