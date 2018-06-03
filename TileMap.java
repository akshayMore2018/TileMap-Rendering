package com.mygdx.game2.tileMapLoader;

public class TileMap {

    private Tile[][] tiles;
    private int height, width;
    private MapFileParser mapFile;
    private TileSetManager tileSet;

    public TileMap(String mapFile, String tileSet, int tileWidth, int tileHeight) {
        this.tileSet = new TileSetManager(tileSet, tileWidth, tileHeight);
        this.width = this.tileSet.getxTiles();
        this.height = this.tileSet.getyTiles();

        this.mapFile = new MapFileParser(mapFile, width, height);

        tiles = new Tile[height][width];

//        for (int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                tiles[y][x] = new Tile(TERRAIN.TILE_1);
//            }
//        }

        for (int yTiles = 0; yTiles < height; yTiles++) {
            for (int xTiles = 0; xTiles < width; xTiles++) {
                tiles[yTiles][xTiles] = new Tile(this.tileSet.getTile(this.mapFile.getMapID(yTiles, xTiles)));
            }
        }


    }


    public Tile getTile(int y, int x) {
        return tiles[y][x];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
