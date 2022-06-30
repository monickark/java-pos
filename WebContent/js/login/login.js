
$(function() {
    $('body').keypress(function(e) {
        if (e.which == 13) {
            e.preventDefault();
            $('#log-in').submit();
       }
    });
});

$(document).ready(function(){
	  $("#login-btn").click(function(){
	     $("#log-in").submit();
	  });
	});