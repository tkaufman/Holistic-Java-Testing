describe('Slider-fier',function(){
	var initiallyCheckedValue;
	beforeEach(function(){
		$.jasmine.inject(
				'<div id="contentScoreScale">'+
					'<span><input id="contentScore1" name="contentScore" type="radio" value="0"><label for="contentScore1">0</label></span>'+
					'<span><input id="contentScore2" name="contentScore" type="radio" value="10"><label for="contentScore2">10</label></span>'+
					'<span><input id="contentScore3" name="contentScore" type="radio" value="20"><label for="contentScore3">20</label></span>'+
					'<span><input id="contentScore4" name="contentScore" type="radio" value="30"><label for="contentScore4">30</label></span>'+
					'<span><input id="contentScore5" name="contentScore" type="radio" value="40"><label for="contentScore5">40</label></span>'+
					'<span><input id="contentScore6" name="contentScore" type="radio" value="50" checked="checked"><label for="contentScore6">50</label></span>'+
					'<span><input id="contentScore7" name="contentScore" type="radio" value="60"><label for="contentScore7">60</label></span>'+
					'<span><input id="contentScore8" name="contentScore" type="radio" value="70"><label for="contentScore8">70</label></span>'+
					'<span><input id="contentScore9" name="contentScore" type="radio" value="80"><label for="contentScore9">80</label></span>'+
					'<span><input id="contentScore10" name="contentScore" type="radio" value="90"><label for="contentScore10">90</label></span>'+
					'<span><input id="contentScore11" name="contentScore" type="radio" value="100"><label for="contentScore11">100</label></span>'+
				'</div>');
		initiallyCheckedValue = 50;
	});
	
	it('is named $.fn.sliderfy',function(){
		expect($.fn.sliderfy).toBeDefined();
	});
		
	describe('sliderfying a group of radio buttons',function(){
		var sliderfy, $container;
		beforeEach(function(){
			spyOn($.fn,'slider');
			$container = $('#contentScoreScale');
			sliderfy = $container.sliderfy();
		});
		
		describe('configuration',function(){
			it('detects a min of 0',function(){
				expect(sliderfy.config.min).toBe(0);
			});
			
			it('detects a max of 100',function(){
				expect(sliderfy.config.max).toBe(100);
			});
			
			it('detects a step interval of 10',function(){
				expect(sliderfy.config.step).toBe(10);
			});
			
			it('defines a change event handler',function(){
				expect(sliderfy.config.change).toBeDefined();
			});
		});
		
		describe('DOM manipulation',function(){
			it('detaches the radio buttons',function(){
				expect($container.find('input[type=radio]')).not.toExist();
			});
			
			it('detaches the spans and labels too',function() {
				expect($container.find('span,label')).not.toExist();
			});
			
			describe('replacing the radio inputs with a hidden input',function(){
				var $hidden;
				beforeEach(function(){
					$hidden = $container.find('input[type=hidden]');
				});
				it('has the same name the radio buttons had',function(){
					expect($hidden).toHaveAttr('name','contentScore');
				});
				describe('Changing the slider value',function() {
					var expected = 80;
					beforeEach(function(){
						sliderfy.config.change(null, { value: expected });
					});
					it('updates the hidden field',function() {
						expect($hidden).toHaveValue(expected);
					});
				});
			});
		});
		
		describe('interaction with jQuery Slider',function(){
			it('invokes jQuery UI slider with the configuration',function(){
				expect($.fn.slider).toHaveBeenCalledWith(sliderfy.config);
			});
		});
		
	});
	
});