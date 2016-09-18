/**
A jQuery plugin for search hints

Author: Lorenzo Cioni - https://github.com/lorecioni
*/

(function($) {
	
	$.fn.autocomplete1 = function(ax,params) {
		
		//Selections
		var obj = new Object()
		var currentSelection = -1;
		var currentProposals = [];
		//Default parameters
		params = $.extend({
			hints: [],
			placeholder: '未使用CRM可不填',
			width: "100%",
			height: 16,
			showButton: false,
			buttonText: '添加权限',
			onSubmit: function(text){},
			onBlur: function(){}
		}, params);
		
		
		//Build messagess
		this.each(function() {
			//Container
			var searchContainer = $('<div></div>')
				.addClass('autocomplete-container')
				.css('height', 'auto')
			    .css('width', '100%');	
				
			//Text input
			var input = $('<input type="text" autocomplete="off" name="query">')
				.attr('placeholder', params.placeholder)
				.addClass('form-control autocomplete-input1')
				.css({
					'width' : params.width,
					'height' : params.height
				});
			
			if(params.showButton){
				input.css('border-radius', '3px 0 0 3px');
			}

			//Proposals
			var proposals = $('<div></div>')
				.addClass('proposal-box')
				.css('width', "100%")
				.css('top', 35);
			var proposalList = $('<ul></ul>')
				.addClass('proposal-list');
			proposals.append(proposalList);
//			$(".proposal-list").attr("style","height: 62px;");
			input.keydown(function(e) {
				switch(e.which) {
					case 38: // Up arrow
					e.preventDefault();
					$('ul.proposal-list li').removeClass('selected');
					if((currentSelection - 1) >= 0){
						currentSelection--;
						$( "ul.proposal-list li:eq(" + currentSelection + ")" )
							.addClass('selected');
					} else {
						currentSelection = -1;
					}
					break;
					case 40: // Down arrow
					e.preventDefault();
					if((currentSelection + 1) < currentProposals.length){
						$('ul.proposal-list li').removeClass('selected');
						currentSelection++;
						$( "ul.proposal-list li:eq(" + currentSelection + ")" )
							.addClass('selected');
					}
					break;
					case 13: // Enter
						if(currentSelection > -1){
							var text = $( "ul.proposal-list li:eq(" + currentSelection + ")" ).html();
							input.val(text);
						}
						currentSelection = -1;
						proposalList.empty();
						
						//调用当前选中的用户有什么权限
						console.info("ssssssss"+text);
						searchUserMenu(ax);
//						params.onSubmit(input.val());
						break;
					case 27: // Esc button
						currentSelection = -1;
						proposalList.empty();
						input.val('');
						break;
				}
			});
				
			input.bind("change paste keyup", function(e){
				if(e.which != 13 && e.which != 27 
						&& e.which != 38 && e.which != 40){				
					currentProposals = [];
					currentSelection = -1;
					proposalList.empty();
					if(input.val() != ''){
						var word = "^" + input.val() + ".*";
						proposalList.empty();
						for(var test in params.hints){
							if(params.hints[test].match(word)){
								currentProposals.push(params.hints[test]);	
								var element = $('<li></li>')
									.html(params.hints[test])
									.addClass('proposal')
									.click(function(){
										input.val($(this).html());
										proposalList.empty();
							//调用当前选中的用户有什么权限
										console.info(params.hints[test]+"222222");
										searchUserMenu(ax);
//										params.onSubmit(input.val());
									})
									.mouseenter(function() {
										$(this).addClass('selected');
									})
									.mouseleave(function() {
										$(this).removeClass('selected');
									});
								proposalList.append(element);
							}
						}
					}
				}
			});
			
			input.blur(function(e){
				currentSelection = -1;
				//proposalList.empty();
				params.onBlur();
			});
			
			searchContainer.append(input);
			searchContainer.append(proposals);		
			
			if(params.showButton){
				//Search button
				var button = $('<div></div>')
					.addClass('autocomplete-button')
					.html(params.buttonText)
					.css({
						'height': params.height + 2,
						'line-height': params.height + 2 + 'px'
					})
					.click(function(){
						proposalList.empty();
						params.onSubmit(input.val());
					});
				searchContainer.append(button);	
			}
	
			$(this).append(searchContainer);	
			
			if(params.showButton){
				//Width fix
				searchContainer.css('width', params.width + button.width() + 50);
			}
		});

		return this;
	};
})(jQuery);

	function searchUserMenu(ax){
		var inp = $(".autocomplete-input1").val();
		var inp1 = inp.split("(")[1];
		var inp2= inp1.split(")")[0];
		console.info(inp2+"ggg");
		for (var s = 0; s < ax.length; s++) {
			if (inp2 ==  ax[s].consumerId) {
				$(".autocomplete-input1").val(ax[s].beautifulyard);
				$("#beautifulyard").val(ax[s].beautifulyard);
				$("#shopCount").val(ax[s].shopCount);
//				$("#payDate").val(ax[s].payDate);
//				$("#provinceCode").val(ax[s].provinceCode);
//				$("#cityCode:selected").val("22");
//				$("#cityCode:selected").html("22");
				$(".autocomplete-input").val(ax[s].market);
				$("#zongbuAddress").val(ax[s].zongbuAddress);
				$("#remark").val(ax[s].remark);
				$("#consumerId").val(ax[s].consumerId);
			}
		}
		
	}