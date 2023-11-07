package com.group5.app;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
* Inherits GameObject class, assigns with unique
* ID and loads its image from SpriteSheet.
*
* @author	Marco Lai	John Sweeney
* @since	1.0
*/

public class RegularReward extends GameObject {
	private BufferedImage regular_image;

	/**
	 * RegularReward image from SpriteSheet is 32x32pixel
	 * Locates sixth column first row in the SpriteSheet.
	 * @param x		position x-coordinate
	 * @param y		position y-coordinate
	 * @param id	ID of the object
	 * @param ss	pass SpriteSheet to load image
	 * @see			SpriteSheet
	 */
	public RegularReward(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);

		regular_image = ss.grabImage(6, 1, 32, 32);
	}

	/**
	 * Due to Abstract method inherited from Game Class
	 * an empty tick method due to the reward being static
	 * empty method is needed to run the class
	 * */
	public void tick() {
	}

	/**
	 * Draw the Image on the Game Board render on Window
	 * */
	public void render(Graphics g) {
		g.drawImage(regular_image, x, y ,null);
	}

	/**
	 * Draw the Rectangle and set bounds for the Reward Object
	 * */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
}
