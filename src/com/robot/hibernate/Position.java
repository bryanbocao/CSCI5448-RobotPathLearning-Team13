package com.robot.hibernate;

import java.io.Serializable;

public class Position implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Integer x;
    protected Integer y;

    public Position() {}

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }
}