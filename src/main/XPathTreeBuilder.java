package main;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class XPathTreeBuilder {

    private SimpleNode nodeTree;
    private Map<String, SimpleNode> nodeMap;

    public XPathTreeBuilder(String xPath) {
        nodeMap = new HashMap<String, SimpleNode>();
        parseXPath(xPath);
    }

    public String parseXPath(String xPath) {
        StringTokenizer st = new StringTokenizer(xPath, "/");
        String pathTracker = setAndReturnRoot(xPath);
        st.nextToken(); // skip root
        while (st.hasMoreTokens()) {
            SimpleNode currentNode = parseSubPath(st.nextToken());
            currentNode.setParent(nodeMap.get(pathTracker.toString()));
            nodeMap.get(pathTracker.toString()).addChild(currentNode);
            nodeMap.put(genXPath(currentNode), currentNode);
            pathTracker= genXPath(currentNode);
        }

        return st.toString();
    }

    private String setAndReturnRoot(String xPathToken) {
        String rootSubPathName = (xPathToken.split("/"))[1]; // splits the full xpath and get the first element WITH namespace
        nodeTree = parseSubPath(rootSubPathName);
        nodeMap.put(genXPath(rootSubPathName), nodeTree);
        return "/" + rootSubPathName;
    }

    private String genXPath(String subPath) {
        return "/" + subPath;
    }

    private String genXPath(SimpleNode node) {
        String toReturn = "/" + node.nodeSubPath();
        while (node.getParent() != null) {
            toReturn = "/" + node.getParent().nodeSubPath() + toReturn;
            node = node.getParent();
        }
        return toReturn;
    }

    private SimpleNode parseSubPath(String subPath) {
        String[] path = subPath.trim().split(":");
        return new SimpleNode.SimpleNodeBuilder(path[1])
                .nameSpace(path[0])
                .build();
    }

    private SimpleNode createNode(String name) {
        SimpleNode result = new SimpleNode.SimpleNodeBuilder(name)
                .nameSpace("scb:")
                .attribute("href")
                .build();

        return result;
    }

    public SimpleNode getNodeTree() {
        return nodeTree;
    }
}