package com.mygdx.game2.tileMapLoader;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class MyTiledWorld implements Screen {
    private TileMap map;
    private SpriteBatch batch;
    private Vector3 worldOrigin;

    @Override
    public void show() {
        map = new TileMap("map.txt", "tilemap.png", 16, 16);
        batch = new SpriteBatch();
        worldOrigin = new Vector3(0, 0, 0);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        sketch(batch);
        batch.end();


    }

    private void sketch(SpriteBatch batch) {

        //grass tile is the (0,8th) tile from top left in the tileset.
        for (int x = 0; x < map.getHeight(); x++) {
            for (int y = 0; y < map.getWidth(); y++) {
                batch.draw(map.getTile(0, 8).getTileImage(), worldOrigin.x + y * Config.SCALED_TILE_SIZE,
                        worldOrigin.y + (map.getHeight() - x - 1) * Config.SCALED_TILE_SIZE,
                        Config.SCALED_TILE_SIZE,
                        Config.SCALED_TILE_SIZE);
            }
        }


        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                batch.draw(map.getTile(i, j).getTileImage(), worldOrigin.x + j * Config.SCALED_TILE_SIZE,
                        worldOrigin.y + (map.getHeight() - i - 1) * Config.SCALED_TILE_SIZE,
                        Config.SCALED_TILE_SIZE,
                        Config.SCALED_TILE_SIZE);
            }
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
