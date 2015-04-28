/**
 * 
 */


$('#validation').validate();

$("input[name='Network']").change(function(){
	   
	   if($(this).attr("id")=="Network_etc"){
		   
		   $("#Network_text").show();
		   
	   }
	   else{
		   
		   $("#Network_text").hide();
	   }

});

$('#Network_text').on('keyup', function(){
    $("#Network_etc").val($(this).val());     
});
