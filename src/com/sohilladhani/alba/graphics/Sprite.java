package com.sohilladhani.alba.graphics;

public class Sprite {
    public final int SIZE;
    public final int SIZE_MASK;
    private int x, y;
    public int[] pixels;
    private SpriteSheet spriteSheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet spriteSheet) {
        SIZE = size;
        SIZE_MASK = SIZE - 1;
        this.pixels = new int[SIZE * SIZE];
        this.x = x * size;
        this.y = y * size;
        this.spriteSheet = spriteSheet;
        load();
    }

    private void load() {
        for(int y = 0; y < SIZE; y++) {
            for(int x = 0; x < SIZE; x++) {
                pixels[x + y * SIZE] = spriteSheet.pixels[(x + this.x) + (y + this.y) * spriteSheet.SIZE];
            }
        }
    }
}
