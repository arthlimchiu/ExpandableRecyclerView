package com.arthlimchiu.expandablerecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shang on 9/8/2015.
 */
public class Header extends Item {

    private boolean isExpanded;
    private int position;
    private List<Child> children = new ArrayList<Child>();

    public Header() {

    }

    public Header(int type, String text) {
        this.type = type;
        this.text = text;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setIsExpanded(boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
