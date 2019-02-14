$(document).ready(function(){
	$(document).on('click', '.grayTrack > .centerHelper > a', function(){
		$('.grayTrack > .centerHelper > a').removeClass('active');
		$(this).addClass('active');
		
		$('main').css('display','none');
		$('.' + $(this).data('main-target')).css('display','inline-block');
	});
});