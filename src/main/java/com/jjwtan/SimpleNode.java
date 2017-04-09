package com.jjwtan;

import java.util.ArrayList;
import java.util.List;

public class SimpleNode {
    private String nodeName;
    private String nameSpace;
    private String attribute;
    private String attributeName;
    private SimpleNode parent;
    private List<SimpleNode> children;

    public Boolean down, up;

    private SimpleNode(SimpleNodeBuilder builder) {
        this.nodeName = builder.nodeName;
        this.nameSpace = builder.nameSpace;
        this.attribute = builder.attribute;
        this.parent = builder.parent;
        this.children = builder.children;
        down = up = false;
    }

    public static class SimpleNodeBuilder {
        private final String nodeName;
        private String nameSpace;
        private String attribute;
        private String attributeName;
        private SimpleNode parent;
        private ArrayList<SimpleNode> children;

        public SimpleNodeBuilder(String nodeName) {
            this.nodeName = nodeName;
        }

        public SimpleNodeBuilder nameSpace(String nameSpace) {
            this.nameSpace = nameSpace;
            return this;
        }

        public SimpleNodeBuilder attribute(String attribute) {
            this.attribute = attribute;
            return this;
        }

        public SimpleNodeBuilder attributeName(String attributeName) {
            this.attributeName = attributeName;
            return this;
        }

        public SimpleNodeBuilder parent(SimpleNode parent) {
            this.parent = parent;
            return this;
        }

        public SimpleNodeBuilder children(ArrayList<SimpleNode> children) {
            this.children = children;
            return this;
        }

        public SimpleNode build() {
            return new SimpleNode(this);
        }
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public SimpleNode getParent() {
        return parent;
    }

    public void setParent(SimpleNode parent) {
        this.parent = parent;
    }

    public List<SimpleNode> getChildren() {
        return children;
    }

    public void setChildren(List<SimpleNode> children) {
        this.children = children;
    }

    public String nodeSubPath() {
        return nameSpace + ":" + nodeName;
    }

    public void addChild(SimpleNode child) {
        if (children == null) {
            children = new ArrayList<SimpleNode>();
            children.add(child);
        } else {
            children.add(child);
        }
    }
}