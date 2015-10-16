/*
'image' : 'Jellyfish.jpg',
'brand' : '¶¯Îï',
'style' : 'Ë®Ä¸',
'price' : 'RMB 100'
*/
(function ($) {

	Cell = Backbone.Model.extend({
		image : null,
		brand : null,
		style : null,
		price : null
	});
		
	Cells = Backbone.Collection.extend({
		initialize: function (models, options) {
			this.bind("add", options.view.addOneCell);
		}
	});

	AppView = Backbone.View.extend({
		el: $("#main-div"),
		initialize: function() {
			this.render();
		},
		render: function() {
			this.cells = new Cells(null, {view : this});
			this.$el.html(_.template($('#stack-div-template').html()));
		},
		events: {
			"click #goto-top" : "gotoTop"
		},
		gotoTop: function() {
			 $('html, body').animate({scrollTop: 0}, 120);
		},
		addOneCell: function(model) {
			var htmlCell = _.template($('#stack-div-cell-template').html(), model.toJSON());
			getMinStackDiv().append(htmlCell);
		}
	});

	function getMinHeightStackDiv(stackDivs) {
		var arrays = new Array();
		var map = new Object();
		$(stackDivs).each(function(i, item) {
			var height = item.height();
			arrays.push(height);
			map[height] = item;
		});
		arrays.sort(function(a, b){
			var ac = parseInt(a), bc = parseInt(b);
			if(ac == bc) return 0;
			return ac > bc ? 1 : -1;
		});
		return map[arrays[0]];
	}
	
	function getMinStackDiv(){
		var height1 = $('#stack-div-1').height();
		var height2 = $('#stack-div-2').height();
		var height3 = $('#stack-div-3').height();
		var height4 = $('#stack-div-4').height();
		var arrays = new Array(
			height1, 
			height2, 
			height3, 
			height4);
		arrays.sort(function(a, b){
			var a1 = parseInt(a), b1 = parseInt(b);
			if(a1 == b1) return 0;
			return a1 > b1 ? 1 : -1;
		});
		if(arrays[0] == height1) return $('#stack-div-1');
		else if(arrays[0] == height2) return $('#stack-div-2');
		else if(arrays[0] == height3) return $('#stack-div-3');
		else if(arrays[0] == height4) return $('#stack-div-4');
	}

	var appview = new AppView;

	console.log(appview);
	
	$(window).bind("scroll", function(){ 
		var height = window.pageYOffset ? window.pageYOffset: document.documentElement.scrollTop;
		if(document.documentElement.clientHeight + height == document.body.scrollHeight) {
			buildHtmlCells(data.cells);
		}
	});
	
	buildHtmlCells(data.cells);

	function buildHtmlCells(data) {
		$.each(data, function(i, item){
			appview.cells.add(new Cell({
				image : item.image,
				brand : item.brand,
				style : item.style,
				price : item.price
			}));
		});
	}
})(jQuery);