package com.group5.app;

import java.util.LinkedList;
import java.awt.Graphics;

/**
* Creates a LinkedList and stores all GameObject and
* runs through a loop to update all game objects.
* <p>
* render and tick method called only once to avoid duplicate
* input.
*
* @author	Marco Lai
* @since	1.0
*/
public class Handler {
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	private boolean up = false, down = false, right = false, left = false;

	/**
	 * this tick method will loop through all game objects and updates.
	 * storing each object into temporary object.
	 */
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.tick();
		}
	}

	/**
	 * this render method will loop through all game objects and updates.
	 * storing each object into temporary object.
	 * @param g		invoke draw system
	 */
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			tempObject.render(g);
		}
	}

	/**
	 * performs object addition
	 * @param tempObject	temp game object
	 */
	public void addObject(GameObject tempObject) {
		object.add(tempObject);
	}

	/**
	 * performs object removal
	 * @param tempObject	temp game object
	 */
	public void removeObject(GameObject tempObject) {
		object.remove(tempObject);
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	
	
}
