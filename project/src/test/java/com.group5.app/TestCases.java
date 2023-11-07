package com.group5.app;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.*;

///https://www.vogella.com/tutorials/JUnit/article.html
/**
 * JUnit Test of Barriers Class
 * @author	J Sweeney
 * @since 	1.0
 */
class BarriersTest { //NOT DONE
    Barriers fortest;
    @BeforeEach
    void setUp() {
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage sprite_sheet = loader.loadImage("/sprite_sheet.png");
        SpriteSheet ss = new SpriteSheet(sprite_sheet);

        fortest = new Barriers(32, 32, ID.Barriers, ss);
    }
    @Test
    @DisplayName("Barriers image from SpriteSheet is 32x32pixel")
    void BarriersimageMethod() {
        assertEquals(fortest.getBounds().x,32);
        assertEquals(fortest.getBounds().y,32);
    }

}


/**
 * Test of BonusReward Class
 * @author	J Sweeney
 * @since 	1.0
 */
class BonusRewardTest {
    public BonusReward playButton;
    public BonusReward quitButton;
    int max;
    int min;
    BufferedImageLoader loader;
    BufferedImage sprite_sheet;
    SpriteSheet ss;
    void setUp() {
        int max = 1000;
        int min = 1;
    }
    @RepeatedTest(10)
    void getBoundsTest() {
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage sprite_sheet = loader.loadImage("/sprite_sheet.png");
        ss = new SpriteSheet(sprite_sheet);
        int xx = ThreadLocalRandom.current().nextInt(min, max + 1);
        int yy = ThreadLocalRandom.current().nextInt(min, max + 1);
        playButton = new BonusReward(xx*32, yy*32, ID.BonusReward, ss);
        quitButton=  new BonusReward(xx*32, yy*32, ID.BonusReward, ss);
        assertEquals(playButton.getBounds().x,xx*32);
        assertEquals(playButton.getBounds().y,yy*32);
        assertEquals(quitButton.getBounds().x,xx*32);
        assertEquals(quitButton.getBounds().y,yy*32);
    }
}

/**
 * Test of BufferedImageLoader Class
 * @author	J Sweeney
 * @since 	1.0
 */
class BufferedImageLoaderTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of Camera Class
 * @author	J Sweeney
 * @since 	1.0
 */
class CameraTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of Exit Class
 * @author	J Sweeney
 * @since 	1.0
 */
class ExitTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}
/**
 * Test of Game Class
 * @author	J Sweeney
 * @since 	1.0
 */
class GameTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of GameObject Class
 * @author	J Sweeney
 * @since 	1.0
 */
class GameObjectTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }

    @Test
    void getX() {
    }

    @Test
    void setX() {
    }
}

/**
 * Test of Handler Class
 * @author	J Sweeney
 * @since 	1.0
 */
class HandlerTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}
/**
 * Test of ID Class
 * @author	J Sweeney
 * @since 	1.0
 */
class IDTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}
/**
 * Test of KeyInput Class
 * @author	J Sweeney
 * @since 	1.0
 */
class KeyInputTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of Menu Class
 * @author	J Sweeney Josh Kim
 * @since 	1.0
 */
class MenuTest {
    private Menu menu;

    @Test
    void renderTest() {
        menu = new Menu();
        BufferedImage image = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        menu.render(g, new Game());
        assertNotNull(g);
    }

}
/**
 * Test of MouseInput Class
 * @author	J Sweeney
 * @since 	1.0
 */
class MouseInputTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of MovingEnemy Class
 * @author	J Sweeney
 * @since 	1.0
 */
class MovingEnemyTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of Player Class
 * @author	J Sweeney Jad Alriyabi Marco Lai
 * @since 	1.0
 */
class PlayerTest {
    Player player;
    RegularReward reward;
    BonusReward BonusReward;
    Punishment punishment;
    Game game;
    Handler handler;
    BufferedImage player_image;
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImage sprite_sheet = loader.loadImage("/sprite_sheet.png");
    SpriteSheet ss = new SpriteSheet(sprite_sheet);
    ID id;
    int x = 32;
    int y = 55;
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public PlayerTest()throws IOException {
        player = new Player(x, y, id, handler, game, ss);
        this.handler = handler;
        this.ss = ss;

        player_image = ss.grabImage(4, 1, 32, 55);
    }


    @Test
    void playerMovementTest(){
        assertEquals(32,player.getX());
        assertEquals(55,player.getY());

        player.setX(0);
        player.setY(0);

        assertEquals(0,player.getX());
        assertEquals(0,player.getY());

        player.setX(1);
        player.setY(1);

        assertEquals(1,player.getX());
        assertEquals(1,player.getY());

        player.setX(47);
        player.setY(23);

        assertEquals(47,player.getX());
        assertEquals(23,player.getY());

    }


    @Test
    void collision() {
        reward = new RegularReward(0, 0, ID.RegularReward, ss);
        player.setX(0);
        player.setY(0);
        assertEquals(0,player.getX());
        assertEquals(0,reward.getX());
        assertEquals(0,player.getY());
        assertEquals(0,reward.getY());


        BonusReward = new BonusReward(2, 2, ID.BonusReward, ss);
        player.setX(2);
        player.setY(2);
        assertEquals(2,player.getX());
        assertEquals(2,BonusReward.getX());
        assertEquals(2,player.getY());
        assertEquals(2,BonusReward.getY());


        punishment = new Punishment(4, 4, ID.Punishment, ss);
        player.setX(4);
        player.setY(4);
        assertEquals(4,player.getX());
        assertEquals(4,punishment.getX());
        assertEquals(4,player.getY());
        assertEquals(4,punishment.getY());
    }

    @Test
    void getBounds() {
        assertNotNull(player.getBounds());
        assertEquals(player.getX(), player.getBounds().width);
        assertEquals(player.getY(), player.getBounds().height);
    }
}

/**
 * Test of Punishment Class
 * @author	J Sweeney
 * @since 	1.0
 */
class PunishmentTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of RegularReward Class
 * @author	J Sweeney
 * @since 	1.0
 */
class RegularRewardTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of Sound Class
 * @author	J Sweeney Josh Kim
 * @since 	1.0
 */
class SoundTest {

    @Test
    void setFileTest() {
        Sound sound = new Sound();
        sound.setFile(0);
        assertEquals(sound.clip, sound.clip);
    }
}

/**
 * Test of SpriteSheet Class
 * @author	J Sweeney
 * @since 	1.0
 */
class SpriteSheetTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}

/**
 * Test of Window Class
 * @author	J Sweeney
 * @since 	1.0
 */
class WindowTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}