$(document).ready(function() {
	console.log('document ready!');
	// draw the grid
	drawGrid();

	// disable the context menu on right click
	$('#cnv').contextmenu(function() {
		return false;
	});

	// capture left and right clicks
	$('#cnv').get(0).addEventListener('mousedown', function(e) {
		if (e.button == 0) {
			console.log("left clicked...");
		}
		if (e.button == 2) {
			console.log("right clicked...");
		}
		processObstacle(e);
	}, false);

});

var obstacles = [];

function processObstacle(e){
	var cnv = $("#cnv");
	var X = e.pageX - cnv.offset().left; 
	var Y = e.pageY - cnv.offset().top;
	console.log('X: ' + X + " Y: " + Y);

	current_cell = {x:Math.floor(X / 60), y:Math.floor(Y / 60)};
	
	console.log('Selected cell: (' + current_cell.x + "," + current_cell.y + ")");	
	is_obstacle = false;
	
	// Check if there is an obstacle in this cell
	$.each(obstacles, function( index, value){
		if(value.x == current_cell.x && value.y == current_cell.y){
			// there is an obstacle here
			is_obstacle = true;
		}
	});

	var ctx = cnv.get(0).getContext('2d');

	if(e.button == 0 && !is_obstacle){
		//left, draw an obstacle if one is not already present, otherwise do nothing
		ctx.fillStyle="#000000";
		ctx.fillRect(current_cell.x*60+1, current_cell.y*60+1, 58, 58);
		// add this cell to the obstacles list
		obstacles.push(current_cell);
	}
	else if(e.button == 2 && is_obstacle){
		//right, remove an obstacle if one is present, otherwise do nothing
		ctx.clearRect(current_cell.x*60+1, current_cell.y*60+1, 58, 58);
		// remove this cell from the obstacles list
		idx = -1;
		$.each(obstacles, function( index, value){
			if(value.x == current_cell.x && value.y == current_cell.y){
				// there is an obstacle here
				idx =index;
			}
		});
		if(idx != -1){
			obstacles.splice(idx, 1);
		}
	}
}

function drawGrid() {

	var cnv = $("#cnv").get(0);

	var gridOptions = {
		majorLines : {
			separation : 60,
			color : '#000000'
		}
	};

	drawGridLines(cnv, gridOptions.majorLines);

	return;
}

function drawGridLines(cnv, lineOptions) {

	var iWidth = cnv.width;
	var iHeight = cnv.height;

	var ctx = cnv.getContext('2d');

	ctx.strokeStyle = lineOptions.color;
	ctx.strokeWidth = 1;

	ctx.beginPath();

	var iCount = null;
	var i = null;
	var x = null;
	var y = null;

	iCount = Math.floor(iWidth / lineOptions.separation);

	for (i = 1; i <= iCount; i++) {
		x = (i * lineOptions.separation);
		ctx.moveTo(x, 0);
		ctx.lineTo(x, iHeight);
		ctx.stroke();
	}

	iCount = Math.floor(iHeight / lineOptions.separation);

	for (i = 1; i <= iCount; i++) {
		y = (i * lineOptions.separation);
		ctx.moveTo(0, y);
		ctx.lineTo(iWidth, y);
		ctx.stroke();
	}

	ctx.closePath();

	return;
}
