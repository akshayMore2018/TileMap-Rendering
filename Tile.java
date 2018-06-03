package com.mygdx.game2.tileMapLoader;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
    private TERRAIN terrain;

    private TextureRegion region;
    private String ID;

    public Tile(TERRAIN terrain) {
        this.terrain = terrain;
    }

    public Tile(TextureRegion region) {
        this.region = region;
    }


    public Tile(String ID) {
        this.ID = ID;
    }

    public TERRAIN getTerrain() {
        return terrain;
    }


    public TextureRegion getTileImage() {

        return region;
    }
}

