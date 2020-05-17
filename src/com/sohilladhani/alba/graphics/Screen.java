package com.sohilladhani.alba.graphics;

import java.util.Random;

/* Screen class for rendering the pixels with colors we specify */
public class Screen {
    private int width;
    private int height;
    public int[] pixels;
    int count = 0;
    int xtime = 0;
    int ytime = 0;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }

    public void render() {
        count++;
        if (count % 10==0) xtime = xtime + new Random().nextInt(10);
        if (count % 80==0) ytime = ytime + new Random().nextInt(80);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                /* Some random value assigning to pixels */
                pixels[(xtime + ytime * width) % (width * height)] = 0x4285F4;
                pixels[(ytime + xtime * width) % (width * height)] = 0xF4B400;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }
}
