package com.arthlimchiu.expandablerecyclerview;

/**
 * Created by shang on 9/8/2015.
 */
public class Child extends Item {

    private String headerParent;

    public Child(int type, String text, String headerParent) {
        this.headerParent = headerParent;
        this.text = text;
        this.type = type;
    }

    public String getHeaderParent() {
        return headerParent;
    }

    public void setHeaderParent(String headerParent) {
        this.headerParent = headerParent;
    }
}
