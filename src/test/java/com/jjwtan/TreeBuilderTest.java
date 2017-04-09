package com.jjwtan;

import org.junit.Test;

/**
 * Created by Ran on 9/4/2017.
 */
public class TreeBuilderTest {

    /**
     *  tree of one xPath: /XML/header/format
     *              XML
     *              /
     *          header
     *          /
     *       format
     */
    @Test
    public void testBuildSimpleTree() {
        XPathTreeBuilder xPath  = new XPathTreeBuilder("/XML/header/format");
        xPath.getTreeOutput();
    }
}
