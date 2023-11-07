package com.group5.app;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
* Process mouse click input.
* <p>
* There are Play button and Quit button in the menu.
*
* @author   Joshua Kim
* @since    1.3
*/
public class MouseInput implements MouseListener {

    /**
     * Due to Abstract method inherited from MouseListener Class
     * an empty mouseClicked method  is needed to run the class
     * */
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    /**
     * Process Events when Mouse is pressed by the user, then
     * tells the game what to do next
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        //New Game/Play Again Button
        if (mx >= 320 + 190 && mx <= 320 + 480) {
            if (my >= 250 && my <= 310) {
                if (Game.State == Game.STATE.MENU || Game.State == Game.STATE.PAUSE) {
                    Game.State = Game.STATE.GAME;

                } else if (Game.State == Game.STATE.EXIT) {
                    Game.State = Game.STATE.RESET;
                }
            }
        }
        //Quit Button
        if (mx >= 320 + 260 && mx <= 320 + 400) {
            if (my >= 330 && my <= 390) {
                if (Game.State != Game.STATE.GAME) {
                    System.exit(1);
                }
            }
        }
    }
    /**
     * Due to Abstract method inherited from MouseListener Class
     * an empty mouseReleased method  is needed to run the class
     * */
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    /**
     * Due to Abstract method inherited from MouseListener Class
     * an empty mouseEntered method  is needed to run the class
     * */
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    /**
     * Due to Abstract method inherited from MouseListener Class
     * an empty mouseExited method  is needed to run the class
     * */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
