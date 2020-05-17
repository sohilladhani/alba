package com.sohilladhani.alba.level;

import com.sohilladhani.alba.graphics.Screen;

public class Level {
    protected int width, height;
    protected int[] tiles;  // like IDs for tile. e.g. 0 = grass, 1 = stone, etc

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

    protected void generateLevel() {

    }

    public void update() {

    }

    /* Like day, night time */
    private void time() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {

    }
}
