package com.sohilladhani.alba;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private Thread thread;
    private boolean isRunning = false;
    private JFrame jFrame;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
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
        }
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
