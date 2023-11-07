package com.group5.app;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
* Process all images input
* <p>
* try and catch here to avoid images not found
* @author	Marco lai 
* @since 	1.1
*/

public class BufferedImageLoader {
	
	private BufferedImage image;

	/**
	 * This method read the images from directory
	 * @param path		images path
	 * @return			image to be loaded
	 */
	public BufferedImage loadImage(String path) {
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}
}
