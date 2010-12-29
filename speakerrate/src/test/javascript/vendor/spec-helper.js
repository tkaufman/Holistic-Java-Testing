(function($){
	$.specHelper = function(){
		var rootId = 'specContainer';		
		var isReady = false;
		var self = {};
		
		self.init = function() {
			$('body').append('<div id="'+rootId+'"></div>');
			isReady = true;
		};
		
		self.inject = function(html,overwriteAll) {
			if(isReady === false) self.init();
			var $root = $('#'+rootId);
			overwriteAll === true ? $root.html(html) : $root.append(html);
		};
		
		self.tidyUp = function() {
			$('#'+rootId).remove();
			isReady = false;
		};
		
		return self;
	};
	
})(jQuery);