package main;

public class Init {
    public static void main(String[] args) {
        XPathTreeBuilder xPath  = new XPathTreeBuilder("/scb:SCBML/scb:header/scb:captureSystem");
        System.out.println("test " + xPath.getNodeTree().nodeSubPath());
    }
}
