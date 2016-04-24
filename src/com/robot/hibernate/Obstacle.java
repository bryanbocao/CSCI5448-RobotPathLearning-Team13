package com.robot.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Obstacle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}

	@ManyToOne
	private Cell cell;

}
