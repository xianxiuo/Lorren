$(document).ready(function() {

	Cell = Backbone.Model.extend({
		image : null,
		brand : null,
		style : null,
		price : null
	});
		
	Cells = Backbone.Collection.extend({
		initialize: function (models, options) {
			this.bind('add', options.view.addOne);
		}
	});

    ItemView = Backbone.View.extend({
        tagName: 'div',
		className: 'stack_cell_div',
        itemTemplate: _.template($("#stack-div-cell-template").html()),
        render: function() {
            this.$el.html(this.itemTemplate(this.model.toJSON()));
            return this;
        }
    });
    
    ListView = Backbone.View.extend({
        el: $("#main-div"),
		listTemplate: _.template($("#stack-div-template").html()),
        initialize : function() {
            this.itemList = new Cells(null, {view: this});
			this.render();
		},
        render: function() {
            this.$el.html(this.listTemplate());
        },
		events: {
			"click #goto-top" : "gotoTop"
		},
        addOne: function(model) {
            var view = new ItemView({model : model});
			getMinStackDiv().append(view.render().el);
        },
        addAll: function() { 
            this.itemList.each(this.addOne);
        },
		gotoTop: function() {
			 $('html, body').animate({scrollTop: 0}, 120);
		}
    });
    
    var listView = new ListView();
	buildHtmlCells(data.cells);
	
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
	
	function buildHtmlCells(data) {
		$.each(data, function(i, item){
			listView.itemList.add(new Cell({
				image : item.image,
				brand : item.brand,
				style : item.style,
				price : item.price
			}));
		});
	}
	
	$(window).bind("scroll", function(){ 
		var height = window.pageYOffset ? window.pageYOffset: document.documentElement.scrollTop;
		if(document.documentElement.clientHeight + height == document.body.scrollHeight) {
			buildHtmlCells(data.cells);
		}
	});
});