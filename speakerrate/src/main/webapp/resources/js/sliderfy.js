(function($){
	$.fn.sliderfy = function() {
		var self = {
			config: {}
		};
			
		var $radios = $(this).find(':input[type=radio]');
		$(this).children().detach();
		
		self.config.value = parseInt($radios.filter(':checked').val());
		var $hidden = $('<input type="hidden" name="'+$radios.attr('name')+'" value="'+self.config.value+'"></input>').appendTo(this);
		
		self.config.change = function(e,ui) {
			$hidden.val(ui.value);
		};
		
		$.each($radios,function(i,e){
			var val = parseInt($(e).val());
			if(self.config.max === undefined || val > self.config.max) {
				self.config.max = val;
			}
			if(self.config.min === undefined || val < self.config.min) {
				self.config.min = val; 
			}
		});
		self.config.step = Math.ceil((self.config.max - self.config.min) / $radios.length);
		
		
		$(this).slider(self.config);
		
		return self;
	};
})(jQuery);