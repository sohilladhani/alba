package com.sohilladhani.alba.graphics;

import java.util.Arrays;
import java.util.Random;

/* Screen class for rendering the pixels with colors we specify */
public class Screen {
    private int width;
    private int height;
    public int[] pixels;
    private final int MAP_SIZE = 64;
    private final int MAP_MASK = 63;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
        }
    }

    public void render(int xOffset, int yOffset) {
        int yp = 0;
        int xp = 0;
        for (int y = 0; y < height; y++) {
            yp = y - yOffset;
            if (yp < 0 || yp >= height) continue;
            for (int x = 0; x < width; x++) {
                xp = x - xOffset;
                if (xp < 0 || xp >= width) continue;
                pixels[xp + yp * width] =
                        Sprite.grass.pixels[(x & Sprite.grass.SIZE_MASK) +
                                (y & Sprite.grass.SIZE_MASK) * Sprite.grass.SIZE];
            }
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }
}
