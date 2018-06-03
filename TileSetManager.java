package com.mygdx.game2.tileMapLoader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.HashMap;

public class TileSetManager {

    private final int xTiles, yTiles;
    private TextureRegion regions[][];
    private HashMap<String, TextureRegion> tileBuffer;

    public TileSetManager(String path, int tileWidth, int tileHeight) {
        tileBuffer = new HashMap<String, TextureRegion>();

        Texture tileSheet = new Texture(Gdx.files.internal(path));

        int height = tileSheet.getHeight();
        int width = tileSheet.getWidth();

        xTiles = width / tileWidth;
        yTiles = height / tileHeight;

        regions = new TextureRegion[xTiles][yTiles];

        regions = TextureRegion.split(tileSheet, tileWidth, tileHeight);
        int counter = 0;


        for (int y = 0; y < yTiles; y++) {
            for (int x = 0; x < xTiles; x++) {
                tileBuffer.put("" + counter++, regions[y][x]);
            }
        }
    }

    public int getxTiles() {
        return xTiles;
    }

    public int getyTiles() {
        return yTiles;
    }

    public TextureRegion getTile(String ID) {
        return tileBuffer.get(ID);
    }
}
