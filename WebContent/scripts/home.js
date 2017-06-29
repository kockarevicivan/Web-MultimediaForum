$(document).ready(function(){
	$('.grayTrack > .centerHelper > a').on('click', function(){
		$('.grayTrack > .centerHelper > a').removeClass('active');
		$(this).addClass('active');
		
		$('main').css('display','none');
		$('.' + $(this).data('main-target')).css('display','inline-block');
	});
});