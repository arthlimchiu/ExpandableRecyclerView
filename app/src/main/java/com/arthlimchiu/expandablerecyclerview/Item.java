package com.arthlimchiu.expandablerecyclerview;

/**
 * Created by shang on 9/8/2015.
 */
public class Item {

    protected int type;
    protected String text;

    public Item() {

    }

    public Item(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
