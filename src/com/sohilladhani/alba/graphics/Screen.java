package com.sohilladhani.alba.graphics;

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
}
