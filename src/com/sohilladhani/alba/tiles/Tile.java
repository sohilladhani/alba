package com.sohilladhani.alba.tiles;

import com.sohilladhani.alba.graphics.Screen;
import com.sohilladhani.alba.graphics.Sprite;

public abstract class Tile {
    public int x, y;
    public Sprite sprite;

    public static Tile grass = new GrassTile(Sprite.grass);

    public Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {

    }

    /* solid = true --> can't walk through it
    *  solid - false --> can walk through it e.g. grass*/
    public boolean solid() {
        return false;
    }
}
