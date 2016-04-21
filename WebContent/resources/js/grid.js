var obstacle_mode = true;

$(document).ready(function() {
	// draw the grid
	grid.draw();

	// Command the button that changes from obstacle to moving robot mode.
	$("#toggle-mode").click(function(e) {
		e.preventDefault();
		if (obstacle_mode) {
			// switch to control mode
			$("#toggle-mode").text('Moving Robot')
			obstacle_mode = false;
		} else {
			obstacle_mode = true;
			$("#toggle-mode").text('Inserting Obstacles')
		}
	});

});

// bind the arrow keys to control the robot
$(document).keydown(function(e) {
	if(!obstacle_mode){
		// erase the robot
		robot.clear();
		
		// update it's position
		switch (e.which) {
		case 37: // left
			robot.moveLeft();
			break;
	
		case 38: // up
			robot.moveUp();
			break;
	
		case 39: // right
			robot.moveRight();
			break;
	
		case 40: // down
			robot.moveDown();
			break;
	
		default:
			return; // exit this handler for other keys
		}
		
		// draw in the new position;
		robot.draw();

	}
	e.preventDefault(); // prevent the default action (scroll / move caret)
});

var robot = {
	position_history : [],
	position : {
		x : 0,
		y : 9
	},
	getImagePosition : function() {
		return {
			x : (robot.position.x * grid.gridOptions.majorLines.separation) + 4,
			y : (robot.position.y * grid.gridOptions.majorLines.separation) + 4
		};
	},
	image_size : 50,
	finished : false,
	move_animation_fps : 30,
	animate_move : false,
	draw : function() {
		image = $("#robot").get(0);
		var ctx = document.getElementById('cnv').getContext('2d');
		ctx.drawImage(image, robot.getImagePosition().x, robot
				.getImagePosition().y, robot.image_size, robot.image_size);
	},
	clear : function() {
		var ctx = document.getElementById('cnv').getContext('2d');
		ctx.fillStyle = "#FFFFFF";
		ctx.fillRect(robot.getImagePosition().x, robot.getImagePosition().y,
				robot.image_size, robot.image_size);
	},
	saveCurrentPosition : function() {
		robot.position_history.push({x : robot.position.x, y : robot.position.y});
	},
	moveTo : function(e) {
		current_cell = grid.getSelectedCell(e);

		if (current_cell.x == robot.position.x
				&& current_cell.y == robot.position.y) {
			// user clicked on the robot, do nothing.
			return;
		}

		if (!robot.animate_move) {
			// just draw the robot in the new position
			robot.clear();
			robot.position = current_cell;
			robot.draw();
		}
	},
	moveLeft : function() {
		// check if we can move in that direction
		if(robot.position.x - 1 < 0 ||
			obstacle.checkCellHasObstacle({x: robot.position.x - 1, y: robot.position.y})){
				// end of grid, or there is an obstacle there, cannot move
				return;
			}
		
		robot.saveCurrentPosition();
		robot.position.x--;
	},
	moveRight : function() {
		// check if we can move in that direction
		if(robot.position.x + 1 > grid.gridOptions.size.x - 1 ||
			obstacle.checkCellHasObstacle({x: robot.position.x + 1, y: robot.position.y})){
				// end of grid, or there is an obstacle there, cannot move
				return;
			}
		
		robot.saveCurrentPosition();
		robot.position.x++;


	},
	moveDown : function() {
		// check if we can move in that direction
		if(robot.position.y + 1 > grid.gridOptions.size.y - 1 ||
			obstacle.checkCellHasObstacle({x: robot.position.x, y: robot.position.y+1})){
				// end of grid, or there is an obstacle there, cannot move
				return;
			}
		
		robot.saveCurrentPosition();
		robot.position.y++;

	},
	moveUp : function() {
		// check if we can move in that direction
		if(robot.position.y - 1 < 0 ||
			obstacle.checkCellHasObstacle({x: robot.position.x, y: robot.position.y-1})){
				// end of grid, or there is an obstacle there, cannot move
				return;
			}
		
		robot.saveCurrentPosition();
		robot.position.y--;
	}
};

var grid = {
	gridOptions : {
		majorLines : {
			separation : 60,
			color : '#000000'
		},
		size : {
			x : 10,
			y : 10
		}
	},
	getSelectedCell : function(e) {
		var cnv = $("#cnv");
		var X = e.pageX - cnv.offset().left;
		var Y = e.pageY - cnv.offset().top;
		console.log('X: ' + X + " Y: " + Y);

		current_cell = {
			x : Math.floor(X / grid.gridOptions.majorLines.separation),
			y : Math.floor(Y / grid.gridOptions.majorLines.separation)
		};

		console.log('Selected cell: (' + current_cell.x + "," + current_cell.y
				+ ")");

		return current_cell;
	},
	checkCanDraw : function(cell) {
		// make sure it is not the end cell or where the robot is
		if ((cell.x == 9 && cell.y == 0)
				|| (cell.x == robot.position.x && cell.y == robot.position.y)) {
			return false;
		}
		return true;
	},
	draw : function() {

		var cnv = $("#cnv").get(0);

		// disable the context menu on right click
		$('#cnv').contextmenu(function() {
			return false;
		});

		// capture left and right clicks
		cnv.addEventListener('mousedown', function(e) {
			if (e.button == 0) {
				console.log("left clicked...");
			}
			if (e.button == 2) {
				console.log("right clicked...");
			}
			if (obstacle_mode) {
				obstacle.processObstacle(e);
			} else {
				// if not in obstacle mode, do nothing as we don't want to move
				// the robot around with the mouse anymore
				// robot.moveTo(e);
			}
		}, false);

		grid.drawGridLines(cnv, grid.gridOptions.majorLines);

		robot.draw();
		grid.drawTarget();

	},
	drawTarget : function() {
		var ctx = document.getElementById('cnv').getContext('2d');
		ctx.fillStyle = "#00FF00";
		ctx.fillRect(grid.gridOptions.majorLines.separation * 9 + 1, 1,
				grid.gridOptions.majorLines.separation - 2,
				grid.gridOptions.majorLines.separation - 2);
	},
	drawGridLines : function(cnv, lineOptions) {

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

		for (i = 0; i <= iCount; i++) {
			x = (i * lineOptions.separation);
			ctx.moveTo(x, 0);
			ctx.lineTo(x, iHeight);
			ctx.stroke();
		}

		iCount = Math.floor(iHeight / lineOptions.separation);

		for (i = 0; i <= iCount; i++) {
			y = (i * lineOptions.separation);
			ctx.moveTo(0, y);
			ctx.lineTo(iWidth, y);
			ctx.stroke();
		}

		ctx.closePath();
	}

};

var obstacle = {
	obstacle_list : [],
	checkCellHasObstacle : function(cell) {
		// Check if there is an obstacle in this cell
		ret = false;
		$.each(obstacle.obstacle_list, function(index, value) {
			if (value.x == cell.x && value.y == cell.y) {
				// there is an obstacle here
				ret = true;
				return false;
			}
		});
		return ret;
	},
	processObstacle : function(e) {

		current_cell = grid.getSelectedCell(e);

		is_obstacle = obstacle.checkCellHasObstacle(current_cell);

		var cnv = $("#cnv");
		var ctx = cnv.get(0).getContext('2d');

		if (!grid.checkCanDraw(current_cell)) {
			return;
		}

		if (!is_obstacle) {
			// draw an obstacle if one is not already present, otherwise do
			// nothing
			ctx.fillStyle = "#000000";
			ctx
					.fillRect(current_cell.x
							* grid.gridOptions.majorLines.separation + 1,
							current_cell.y
									* grid.gridOptions.majorLines.separation
									+ 1,
							grid.gridOptions.majorLines.separation - 2,
							grid.gridOptions.majorLines.separation - 2);
			// add this cell to the obstacles list
			obstacle.obstacle_list.push(current_cell);
		} else {
			// remove an obstacle if one is present, otherwise do nothing
			ctx
					.clearRect(current_cell.x
							* grid.gridOptions.majorLines.separation + 1,
							current_cell.y
									* grid.gridOptions.majorLines.separation
									+ 1,
							grid.gridOptions.majorLines.separation - 2,
							grid.gridOptions.majorLines.separation - 2);
			// remove this cell from the obstacles list
			idx = -1;
			$.each(obstacle.obstacle_list, function(index, value) {
				if (value.x == current_cell.x && value.y == current_cell.y) {
					// there is an obstacle here
					idx = index;
					return false;
				}
			});
			if (idx != -1) {
				obstacle.obstacle_list.splice(idx, 1);
			}
		}
	}
};
