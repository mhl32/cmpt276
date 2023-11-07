package com.group5.app;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
* Inherits GameObject class, assigns with unique
* ID and loads its image from SpriteSheet.
* <p>
* MovingEnemy image from SpriteSheet is 32x55pixel
* locates third column first row in the SpriteSheet.
* Initials enemy movement to follow Player and collision
* to barriers in tick method.
*
* @author	Marco Lai	Jad Alriyabi
* @since	1.0
*/

public class MovingEnemy extends GameObject{

	private BufferedImage enemy_image;
	private Handler handler;
	float distance;
	int diffX, diffY;
	int height = 55;
	int width = 32;

	/**
	 * Constructor.
	 * @param x			position x-coordinate
	 * @param y			position y-coordinate
	 * @param id		ID of the object
	 * @param ss		pass SpriteSheet to load image
	 * @param handler  	pass handler to loop through all objects
	 * @see				SpriteSheet
	 */
	public MovingEnemy(int x, int y, ID id, Handler handler, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;

		enemy_image = ss.grabImage(3, 1, 32, 55);
	}

	/**
	 * Process all the Enemy movement and tracks the player at all time
	 * when playing the game
	 */
	public void tick() {
		if(x>=55 && x <= 2495)
			x += velX;
		if(y>= 55 && y <= 1345)
			y += velY;
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getId() == ID.Player) {
				diffX = x - tempObject.getX() - width;
				diffY = y - tempObject.getY() - height;
				distance = (float)Math.sqrt((x - tempObject.getX()) * (x - tempObject.getX()) + (y - tempObject.getY()) * (y - tempObject.getY()));
			}
		}
		velX = ((-2/distance)  * diffX);
		velY = ((-2/distance)  * diffY);
		collision();
	}

	/**
	 * Process all the collision between Moving Enemy and other game objects.
	 */
	public void collision(){
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getId() == ID.Barriers) {
				if(getBoundsTop().intersects(tempObject.getBounds())) {
					y = tempObject.getY() + 32;
				}
				if(getBoundsBottom().intersects(tempObject.getBounds())) {
					y = tempObject.getY() - height;
				}
				if(getBoundsRight().intersects(tempObject.getBounds())) {
					x = tempObject.getX() - width;
				}
				if(getBoundsLeft().intersects(tempObject.getBounds())) {
					x = tempObject.getX() + width;
				}
			}
		}
	}

	/**
	 * Draw the Image of the Enemy on the Game Board render on Window
	 * */
	public void render(Graphics g) {
		g.drawImage(enemy_image, x, y, null);
	}

	/**
	 * Draw the Rectangle and set bounds for the MovingEnemy Object
	 * */
	public Rectangle getBounds() {

		return new Rectangle(x, y, width, height);
	}

	/**
	 * returns the bounds set by the rectangle set for the Moving Enemy object
	 * */
	public Rectangle getBoundsTop(){
		return new Rectangle(x+ width/2 - (width/2)/2, y, width/2,height/2);
	}
	public Rectangle getBoundsBottom(){
		return new Rectangle(x+width/2-(width/2)/2, y+height/2,width/2,height/2);
	}
	public Rectangle getBoundsRight(){
		return new Rectangle(x+width-5, y+4, 5, height -8);
	}
	public Rectangle getBoundsLeft(){
		return new Rectangle(x, y+4, 5, height -8);
	}


}
