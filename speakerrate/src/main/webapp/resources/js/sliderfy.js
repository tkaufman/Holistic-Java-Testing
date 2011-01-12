(function($){
	var appendHiddenInput = function(parent,name) {
		var $hidden = $('<input type="hidden" name="'+name+'"></input>').appendTo(parent);		
		return function(e,ui) {
			$hidden.val(ui.value);
		};
	};
	
	$.fn.sliderfy = function() {
		var self = {
			config: {}
		};
		var $radios = $(this).find(':input[type=radio]');
		$(this).children().detach();
		
		
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
		self.config.change = appendHiddenInput(this,$radios.attr('name'));
		
		$(this).slider(self.config);
		return self;
	};
})(jQuery);