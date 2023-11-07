package com.group5.app;

import  java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Creates constructor for our Sounds called from Game and Player Class
 * <p>
 * This Class is  for whenever a sound is need to implemented in the game
 * class make new instance of the window.
 *
 * @author	Jad Alriyabi
 * @since	1.3
 */

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    /**
     * Constructor.
     * Sounds to be played in game
     */
    public Sound() {
        soundURL[0] = getClass().getResource("/sound/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getResource("/sound/coin.wav");
        soundURL[2] = getClass().getResource("/sound/bonus.wav");
        soundURL[3] = getClass().getResource("/sound/unlock.wav");
        soundURL[4] = getClass().getResource("/sound/fanfare.wav");
        soundURL[5] = getClass().getResource("/sound/ouch.wav");
    }

    /**
     * Set the audio that is intended to be played
     */
    public void setFile(int i) {
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e){
            System.out.print("Unavailable Audio to be played");
        }
    }

    /**
     * play the audio
     */
    public void play(){
        clip.start();
    }

    /**
     * loop the audio
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * loop the audio without stopping
     */
    public void playMusic(int i){
        setFile(i);
        play();
        loop();
    }

    /**
     * play the audio once
     */
    public void playSE(int i){
        setFile(i);
        play();
    }
}
