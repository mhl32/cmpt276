package com.group5.app;
import javax.swing.JFrame;
import java.awt.Dimension;

/**
* Creates constructor for our window called from Game Class
* adds the game class into Jframe.
* <p>
* This class is called whenever the game
* class make new instance of the window.
* Set up the dimension and size for the Jframe import.
*
* @author	Marco Lai 
* @since	1.0
*/
public class Window {
	/**
	 * Constructor of window
	 * @param width		Width of this game window
	 * @param height	Height of this game window
	 * @param title		Header shows on this game window
	 * @param game		instance pass from Game class
	 */
	public Window(int width, int height, String title, Game game) {
		//Use of the JFrame class to build the UI
		JFrame frame = new JFrame(title);

		//Set the Preferred Dimensions of the Game window
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));

		//Adding the game Functionality to the Window
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
		
}
