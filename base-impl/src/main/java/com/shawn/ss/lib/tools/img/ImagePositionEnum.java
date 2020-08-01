package com.shawn.ss.lib.tools.img;

public enum ImagePositionEnum {

    MIDDLE("middle"),
    TOP("top"),
    BOTTOM("bottom"),
    LEFT("left"),
    RIGHT("right"),
    LEFT_TOP("leftTop"),
    LEFT_BOTTOM("leftBottom"),
    RIGHT_TOP("rightTop"),
    RIGHT_BOTTOM("rightBottom"),
    ;
    protected String key;
    protected Integer count;

    ImagePositionEnum(String key) {
        this.key = key;
    }

    ImagePositionEnum(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
