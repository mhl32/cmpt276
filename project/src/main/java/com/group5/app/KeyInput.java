package com.group5.app;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
* KeyInput class process all the keyPressed
* and keyReleased input.
* <p>
* Since the player class is the only object
* has key input, we create handler instance
* and match the object ID to player. 
*
* @author	Marco Lai
* @since	1.0
*/
public class KeyInput extends KeyAdapter{
	
	Handler handler;

	/**
	 * Constructor
	 * @param handler	handler class instance
	 */
	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	/**
	 * Deals with events that when User pressed certain keys in the game aka(WASD)
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i =0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) handler.setUp(true);
				if(key == KeyEvent.VK_S) handler.setDown(true);
				if(key == KeyEvent.VK_A) handler.setLeft(true);
				if(key == KeyEvent.VK_D) handler.setRight(true);
				if(key == KeyEvent.VK_ESCAPE) {
					Game.State = Game.STATE.PAUSE;
				}
			}
		}
	}

	/**
	 * Deals with events that when User released certain keys in the game aka(WASD)
	 */
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for(int i =0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player) {
				if(key == KeyEvent.VK_W) handler.setUp(false);
				if(key == KeyEvent.VK_S) handler.setDown(false);
				if(key == KeyEvent.VK_A) handler.setLeft(false);
				if(key == KeyEvent.VK_D) handler.setRight(false);
			}
		}
	}
	
}
