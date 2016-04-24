package com.robot.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;


@Entity
@IdClass(Position.class)
public class Cell {
	
	@Id
	private Integer x;
	
	@Id
	private Integer y;
	
	
	@ManyToMany(mappedBy="cells")
	private Set<Path> paths = new HashSet<Path>();
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
