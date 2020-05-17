package com.sohilladhani.alba.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private String path;
    private final int SIZE; // size of sprite sheet (width * height)
    public int[] pixels;

    public SpriteSheet(String path, int size) {
        this.path = path;
        SIZE = size;
        this.pixels = new int[SIZE * SIZE];
    }

    private void load() {
        try {
            BufferedImage bufferedImage = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();
            bufferedImage.getRGB(0,0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
