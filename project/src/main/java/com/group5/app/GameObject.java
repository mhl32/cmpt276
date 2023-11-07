package com.group5.app;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
* GameObject is the abstract base class for all game objects contexts
* which allow each game object inherit and override with unique ID
* and SpriteSheet image
* <p>
* velX and velY only used in player class and movingenemy class
* tick method updates every objects position
* render method draws corresponding images
* Rectangle method initials size of objects to process collision
* detection.
*
* @author	Marco Lai
* @since	1.0
*/
public abstract class GameObject {

	protected int x, y;
	protected float velX = 0, velY = 0;
	protected ID id;
	protected SpriteSheet ss;

	/**
	 * Constructor of game object.
	 * @param x		position x-coordinate
	 * @param y		position y-coordinate
	 * @param id	ID of the object
	 * @param ss	pass SpriteSheet to load image
	 * @see			SpriteSheet
	 */
	public GameObject(int x, int y, ID id, SpriteSheet ss) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.ss = ss;
	}

	/**
	 * Tick method is an abstract base method for all game
	 * objects that allow an application to process the
	 * coordinates of each component.
	 */
	public abstract void tick();
	/**
	 * Render method is an abstract base method for all game
	 * objects that allow an application to draw onto components.
	 * @param g		invoke draw system
	 */
	public abstract void render(Graphics g);
	/**
	 * This is an abstract base method for all game objects
	 * to inherit and initial the size of the object
	 * to process collision detection.
	 */
	public abstract Rectangle getBounds();

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

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

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}
}
