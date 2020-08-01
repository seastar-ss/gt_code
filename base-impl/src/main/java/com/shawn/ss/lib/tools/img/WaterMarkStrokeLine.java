package com.shawn.ss.lib.tools.img;

import java.awt.*;

public class WaterMarkStrokeLine {
    int x1;
    int y1;
    int x2;
    int y2;
    Color color;
    Stroke stroke;
    //Stroke bs2 = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {4, 4}, 0);

    public int getX1() {
        return x1;
    }

    public WaterMarkStrokeLine setX1(int x1) {
        this.x1 = x1;
        return this;
    }

    public int getY1() {
        return y1;
    }

    public WaterMarkStrokeLine setY1(int y1) {
        this.y1 = y1;
        return this;
    }

    public int getX2() {
        return x2;
    }

    public WaterMarkStrokeLine setX2(int x2) {
        this.x2 = x2;
        return this;
    }

    public int getY2() {
        return y2;
    }

    public WaterMarkStrokeLine setY2(int y2) {
        this.y2 = y2;
        return this;
    }

    public Color getColor() {
        return color;
    }

    public WaterMarkStrokeLine setColor(Color color) {
        this.color = color;
        return this;
    }

    public Stroke getStroke() {
        return stroke;
    }

    public WaterMarkStrokeLine setStroke(Stroke stroke) {
        this.stroke = stroke;
        return this;
    }
}
