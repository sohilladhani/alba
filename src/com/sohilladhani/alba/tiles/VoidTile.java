package com.sohilladhani.alba.tiles;

import com.sohilladhani.alba.graphics.Screen;
import com.sohilladhani.alba.graphics.Sprite;

public class VoidTile extends Tile {
    public VoidTile(Sprite voidSprite) {
        super(voidSprite);
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x, y, this);
    }
}
