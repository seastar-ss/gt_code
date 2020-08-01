package com.shawn.ss.lib.tools.img;

public class WaterMarkImage {
    String imageUrl;
    int x;
    int y;

    int width;
    int height;

    public String getImageUrl() {
        return imageUrl;
    }

    public WaterMarkImage setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getX() {
        return x;
    }

    public WaterMarkImage setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public WaterMarkImage setY(int y) {
        this.y = y;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public WaterMarkImage setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public WaterMarkImage setHeight(int height) {
        this.height = height;
        return this;
    }
}
