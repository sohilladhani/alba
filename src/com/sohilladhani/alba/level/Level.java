package com.sohilladhani.alba.level;

import com.sohilladhani.alba.graphics.Screen;

public class Level {
    private int width, height;
    private int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    /* Level from a resource path*/
    public Level(String path) {
        loadLevel(path);
    }

    private void loadLevel(String path) {

    }

    private void generateLevel() {

    }

    public void update() {

    }

    /* Like day, night time */
    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {

    }
}
