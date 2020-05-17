package com.sohilladhani.alba.graphics;

import java.util.Arrays;
import java.util.Random;

/* Screen class for rendering the pixels with colors we specify */
public class Screen {
    private int width;
    private int height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void render() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                /* Some random value assigning to pixels */
                pixels[(x + y * width) % (width * height)] = 0x0F9D58;
            }
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }
}
