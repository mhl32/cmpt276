package com.group5.app;

/**
* Camera class bounds the window to follow
* player movement.
*
* @author	Marco Lai
* @since	1.1
*/
public class Camera {
	private float x, y;

	/**
	 * Constructor class
	 * @param x		x coordinate
	 * @param y		y coordinate
	 */
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Set boundary to be locked with coordinates.
	 * @param object	Game object
	 */
	public void tick(GameObject object) {
		
		x += ((object.getX() - x) - 640 * 1f);
		y += ((object.getY() - y) - 320 * 1f);
		
		if(x <= 0) x = 0;
		if(x >= 1295) x = 1295;
		if(y <= 0) y = 0;
		if(y >= 760) y = 760;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
