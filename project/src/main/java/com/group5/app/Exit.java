package com.group5.app;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
* Inherits GameObject class, assigns with unique
* ID and loads its image from SpriteSheet.
*
* @author	Marco Lai
* @since	1.0
*/

public class Exit extends GameObject {
    private BufferedImage exit_image;

    /**
     * Exit image from SpriteSheet is 32x32pixel.
     * Locates second column first row in the SpriteSheet.
     *
     * @param x		position x-coordinate
     * @param y		position y-coordinate
     * @param id	ID of the object
     * @param ss	pass SpriteSheet to load image
     * @see			SpriteSheet
     */
    public Exit(int x, int y, ID id, SpriteSheet ss) {
        super(x, y, id, ss);
        
        exit_image = ss.grabImage(2, 1, 32, 32);
    }
    /**
     * Exit object remains static to player movement
     */
    public void tick() {
    }

    /**
     * Draw the Image of the Exit object(doors) on the Game Board render on Window
     * */
    public void render(Graphics g) { 
        g.drawImage(exit_image, x, y ,null);
    }

    /**
     * Draw the Rectangle and set bounds for the Exit Object
     * */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    
}
