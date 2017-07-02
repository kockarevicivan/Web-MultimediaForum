var rules = [];

$(document).ready(function(){
	$(document).on('click', '#newRuleButton',function(){
		var newRule = $('#newRuleTextarea').val();
		if(newRule.trim() != '') {
			rules.push(newRule);
			$('#newRuleTextarea').val('');
			appendNewRule(newRule);
		}
	});
	
	$(document).on('click',".rule > i",function(e){
		 var text = $(this).parent().text();

		 rules.pop(text);
		 
		 $(this).parent().remove();
	});
	
	$(document).on('click', '#newSubforumSubmit', function() {
		sendDataAjax();
	});
});

function appendNewRule(newRule) {
	$('#rulesWrapper').append('<div class="rule">' + newRule + '<i class="fa fa-times" aria-hidden="true"></i></div>');
}

function sendDataAjax() {
	var data = new FormData();
	
	data.append('rules', rules);
	data.append('subforumName', $('#newSubforumName').val());
	data.append('subforumDescription', $('#newSubforumDescription').val());
	data.append('icon', $('#newSubforumImageInput')[0].files[0]);
	
	$.ajax({
        url: '/WebProjekat/NewSubforumAPIServlet',
        type: 'POST',
        data: data,
        contentType: false,
        processData: false,
        success: function (result) {
            displayToast(result);
        },
        error: function (xhr, ajaxOptions, thrownError) {
            
        }
    });
}