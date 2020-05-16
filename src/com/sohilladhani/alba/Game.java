package com.sohilladhani.alba;

import com.sohilladhani.alba.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private Thread thread;
    private boolean isRunning = false;
    private Screen screen;
    private JFrame jFrame;
    /* BufferedImage - Image with a buffer */
    private BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) bufferedImage.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        screen = new Screen(width, height);
        jFrame = new JFrame();
    }

    public synchronized void start() {
        isRunning = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    public synchronized void stop() {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            update();
            render();
        }
    }

    /* Handles logic of the game, like keyboard input, etc.
     *  Also called 'tick', it is fixed throughout the game and does not
     *  depend on the PC configurations. For e.g. updating at 60 ticks per second */
    public void update() {

    }

    /* Handles rendering of the images on the screen.
     *  It depends on the PC configurations. Remember FPS of games? It is handled by this
     *  method. */
    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy==null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render();
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        /* Do Graphics stuff i.e. what to display on screen,
           till graphics.dispose() */
        graphics.drawImage(bufferedImage, 0, 0, getWidth(), getHeight(), null);
        graphics.dispose(); // release system resources. remove graphics at the end of the frame
        bufferStrategy.show();  // make next buffer visible
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.jFrame.setResizable(false);
        game.jFrame.setTitle("Alba");
        game.jFrame.add(game);
        game.jFrame.pack();
        game.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.jFrame.setLocationRelativeTo(null);
        game.jFrame.setVisible(true);
        game.start();
    }
}
