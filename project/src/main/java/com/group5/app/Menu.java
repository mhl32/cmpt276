package com.group5.app;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

/**
* Menu class is the UI class shows up 
* when Game state equals MENU or EXIT
*
* @author   Joshua Kim
* @since    1.3
*/
public class Menu {

    //initializing rectangles for the buttons on the menu
    public Rectangle playButton = new java.awt.Rectangle(320 + 190, 250, 310, 60);
    public Rectangle quitButton = new java.awt.Rectangle(320 + 260, 330, 140, 60);

    DecimalFormat dFormat = new DecimalFormat("#0.00");

    /**
     * Draws the MENU images.
     * @param g     invoke draw system
     */
    public void render(Graphics g, Game game) {
        Graphics2D g2d = (Graphics2D) g;
        Font fnt0 = new Font("arial", Font.BOLD, 75);
        g.setFont(fnt0);
        g.setColor(Color.orange);


        Font fnt1 = new Font("arial", Font.BOLD, 50);

        if (Game.State == Game.STATE.MENU){
            g.drawString("Escape The Bank", 320, 150);
            g.setFont(fnt1);
            g.drawString("New Game", playButton.x + 20, playButton.y + 50);
        }
        if (Game.State == Game.STATE.EXIT){
            g.setColor(Color.orange);
            g.setFont(fnt0);
            if (game.CoinsCollect == game.MaxCoins) {
                g.drawString("You Escaped!", 410, 150);
                g.setFont(fnt1);
                g.drawString("Score: "  + game.score ,900,350);
                g.drawString("Time: "  + dFormat.format(game.playTime) + "'s" ,900,400);
            } else {
                g.setFont(fnt0);
                g.drawString("Got Caught!", 440, 150);
            }
            g.setFont(fnt1);
            g.drawString("Play Again!", playButton.x + 20, playButton.y + 50);
        }
        if (Game.State == Game.STATE.PAUSE) {
            g.drawString("Paused", 510, 150);
            g.setFont(fnt1);
            g.drawString("Resume", playButton.x + 50, playButton.y + 50);
        }


        g2d.draw(playButton);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 50);
        g2d.draw(quitButton);
    }
}
