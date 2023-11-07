package com.group5.app;
import java.awt.image.BufferedImage;

/**
* Encapsulates the properties and methods associated with a Sprite Sheet
* <p>
* initials column and row *32-32 
* set 1 equals to 32pixel
*
* @author	Marco Lai
* @since	1.1
*/

public class SpriteSheet {
	private BufferedImage image;

	/**
	 * Constructor.
	 * @param image		the image to be loaded
	 */
	public SpriteSheet(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Reads column and row 32 pixels as 1 unit
	 * @param col		32 pixels as one column
	 * @param row		32 pixels as one row
	 * @param width		pixel width of the image
	 * @param height	pixel height of the image
	 * @return			image to be loaded
	 */
	public BufferedImage grabImage(int col, int row, int width, int height) {
		return image.getSubimage(col*32-32, row*32 - 32, width, height);
	}
}
