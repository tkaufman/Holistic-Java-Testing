(function($){
	var findEdge = function($items,comparator) {
		var edge;
		$.each($items,function(i,e){
			var val = parseInt($(e).val());
			if(edge === undefined || comparator(val,edge)) {
				edge = val;
			}
		});
		return edge;
	};
	
	var appendHiddenInput = function(parent,name,value) {
		var $hidden = $('<input type="hidden" name="'+name+'" value="'+value+'"></input>').appendTo(parent);		
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
		
		self.config.max = findEdge($radios, function(val,max){ return val > max; });
		self.config.min = findEdge($radios, function(val,min){ return val < min; });
		self.config.step = Math.ceil((self.config.max - self.config.min) / $radios.length);
		self.config.value = parseInt($radios.filter(':checked').val());
		self.config.change = appendHiddenInput(this,$radios.attr('name'),self.config.value);
		
		$(this).slider(self.config);
		return self;
	};
})(jQuery);