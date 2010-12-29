describe('Slider-fier',function(){
	
	var support;
	
	beforeEach(function(){
		support = $.specHelper();
		support.inject('<div id="radios">'+
				'<span><input id="contentScore1" name="contentScore" type="radio" value="0" checked="checked"><label for="contentScore1">0</label></span>'+
				'<span><input id="contentScore2" name="contentScore" type="radio" value="10"><label for="contentScore2">10</label></span>'+
				'<span><input id="contentScore3" name="contentScore" type="radio" value="20"><label for="contentScore3">20</label></span>'+
				'<span><input id="contentScore4" name="contentScore" type="radio" value="30"><label for="contentScore4">30</label></span>'+
				'<span><input id="contentScore5" name="contentScore" type="radio" value="40"><label for="contentScore5">40</label></span>'+
				'<span><input id="contentScore6" name="contentScore" type="radio" value="50"><label for="contentScore6">50</label></span>'+
				'<span><input id="contentScore7" name="contentScore" type="radio" value="60"><label for="contentScore7">60</label></span>'+
				'<span><input id="contentScore8" name="contentScore" type="radio" value="70"><label for="contentScore8">70</label></span>'+
				'<span><input id="contentScore9" name="contentScore" type="radio" value="80"><label for="contentScore9">80</label></span>'+
				'<span><input id="contentScore10" name="contentScore" type="radio" value="90"><label for="contentScore10">90</label></span>'+
				'<span><input id="contentScore11" name="contentScore" type="radio" value="100"><label for="contentScore11">100</label></span>'+
				'</div>');
	});
	
	it('is named $.fn.sliderfy',function(){
		expect($.fn.sliderfy).toBeDefined();
	});
		
});