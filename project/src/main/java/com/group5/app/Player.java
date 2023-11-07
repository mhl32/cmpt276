package com.group5.app;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
* Inherits GameObject class, assigns with unique
* ID and loads its image from SpriteSheet.
* <p>
* Player's image from SpriteSheet is 32x32pixel
* locates fourth column first row in the SpriteSheet.
*
* @author	Marco Lai	John Sweeney
* @since	1.0
*/

public class Player extends GameObject{
	
	Handler handler;
	Game game;
	private BufferedImage player_image;
	Sound sound = new Sound();

	/**
	 * Constructor.
	 * @param x			position x-coordinate
	 * @param y			position y-coordinate
	 * @param id		ID of the object
	 * @param handler	pass handler to loop through all objects
	 * @param game		pass variables from game class
	 * @param ss		pass SpriteSheet to load image
	 */
	public Player(int x, int y, ID id, Handler handler, Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler = handler;
		this.game = game;

		player_image = ss.grabImage(4, 1, 32, 55);
	}

	/**
	 * Process all the Player movement that is handled by the User
	 * interacting with the keyboard by using WASD keys, this is handled
	 * by the handler object.
	 */
	public void tick() {
		x += velX;
		y += velY;
		
		collision();
		
		if(handler.isUp()) velY = -5;
		else if(!handler.isDown()) velY = 0;
		
		if(handler.isDown()) velY = 5;
		else if(!handler.isUp()) velY = 0;
		
		if(handler.isRight()) velX = 5;
		else if(!handler.isLeft()) velX = 0;
		
		if(handler.isLeft()) velX = -5;
		else if(!handler.isRight()) velX = 0;
	}

	/**
	 * Process all the collision between Player and other game objects.
	 */
	public void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.Barriers) {
				if (getBounds().intersects(tempObject.getBounds())) {
					x += velX * -1;
					y += velY * -1;
				}
			}
			if (tempObject.getId() == ID.Punishment) {
				if (getBounds().intersects(tempObject.getBounds())) {
					game.score -= 50;
					game.HEALTH -= 30;
					handler.removeObject(tempObject);
					//sound.playSE(5);
					if (game.score <= 0 || game.HEALTH <= 0) {
						Game.State = Game.STATE.EXIT;
					}
				}
			}

			if (tempObject.getId() == ID.RegularReward) {
				if (getBounds().intersects(tempObject.getBounds())) {
					game.score += 10;
					game.CoinsCollect += 1;
					//sound.playSE(1);
					handler.removeObject(tempObject);
				}
			}

			if (tempObject.getId() == ID.BonusReward) {
				if (getBounds().intersects(tempObject.getBounds())) {
					game.score += 50;
					//sound.playSE(2);
					handler.removeObject(tempObject);

				}
			}

			if (tempObject.getId() == ID.Exit) {
				if (getBounds().intersects(tempObject.getBounds())) {
					if (game.CoinsCollect == game.MaxCoins) {
						Game.State = Game.STATE.EXIT;
						//sound.playSE(3);
					}
				}
			}

			if (tempObject.getId() == ID.MovingEnemy) {
				if (getBounds().intersects(tempObject.getBounds())) {
					game.HEALTH--;
					//sound.playSE(5);

					Game.State = Game.STATE.EXIT;
				}
			}
		}
	}

	/**
	 * Draw the Image of the Player on the Game Board render on Window
	 * */
	public void render(Graphics g) {
		g.drawImage(player_image, x, y, null);
	}

	/**
	 * Draw the Rectangle and set bounds for the Player Object
	 * */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 55);
	}
}
