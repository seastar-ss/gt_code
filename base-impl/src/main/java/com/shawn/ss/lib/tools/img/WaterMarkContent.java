package com.shawn.ss.lib.tools.img;

import java.awt.*;

public class WaterMarkContent {
    String content;
    int x;
    int y;

    Color color;
    Font font;

    public String getContent() {
        return content;
    }

    public WaterMarkContent setContent(String content) {
        this.content = content;
        return this;
    }

    public int getX() {
        return x;
    }

    public WaterMarkContent setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public WaterMarkContent setY(int y) {
        this.y = y;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public WaterMarkContent setColor(Color color) {
        this.color = color;
        return this;
    }

    public Font getFont() {
        return font;
    }

    public WaterMarkContent setFont(Font font) {
        this.font = font;
        return this;
    }
}
