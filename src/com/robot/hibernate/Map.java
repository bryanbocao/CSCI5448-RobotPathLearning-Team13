package com.robot.hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Map {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	private Set<Cell> obstacles;
	
	@OneToOne(mappedBy="map")
	private Path path;

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public Set<Cell> getObstacles() {
		return obstacles;
	}

	public void setObstacles(Set<Cell> obstacles) {
		this.obstacles = obstacles;
	}

	public int getId() {
		return id;
	}

}
