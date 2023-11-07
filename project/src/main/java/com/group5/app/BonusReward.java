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

public class BonusReward extends GameObject {
	private BufferedImage bonus_image;

	/**
	 * BonusReward image from SpriteSheet is 32x32pixel
	 * locates first column first row in the SpriteSheet.
	 * @param x		position x-coordinate
	 * @param y		position y-coordinate
	 * @param id	ID of the object
	 * @param ss	pass SpriteSheet to load image
	 * @see			SpriteSheet
	 */
	public BonusReward(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);

		bonus_image = ss.grabImage(1, 1, 32, 32);
	}

	/**
	 * BonusReward remains static to player movement
	 */
	public void tick() {
	}

	/**
	 * Draw the Image of the BonusReward object(cool coin) on the Game Board render on Window
	 * */
	public void render(Graphics g) {
		g.drawImage(bonus_image, x, y ,null);
	}

	/**
	 * Draw the Rectangle and set bounds for the BonusReward Object
	 * */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

}
