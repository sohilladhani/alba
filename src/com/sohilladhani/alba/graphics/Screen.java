package com.sohilladhani.alba.graphics;

import java.util.Arrays;
import java.util.Random;

/* Screen class for rendering the pixels with colors we specify */
public class Screen {
    private int width;
    private int height;
    public int[] pixels;
    public int[] tiles = new int[64 << 6];
    private Random random = new Random();
    private int tileIndex = 0;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
        for(int i = 0; i < (64 << 6); i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
        }
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            tileIndex = (y >> 4) << 6;
            for (int x = 0; x < width; x++) {
                /* Some random value assigning to pixels */
                pixels[(x + y * width) % (width * height)] = tiles[(x >> 4) + tileIndex];
            }
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }
}
