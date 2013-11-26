/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.xmlhelper.xpath;

import java.util.HashMap;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dmitriy Merkushov
 */
public class XPathHelper {

	static XPath xPath = XPathFactory.newInstance ().newXPath ();
	static HashMap<String, XPathExpression> xPathExpressions = new HashMap<String, XPathExpression> ();

	public static XPathExpression getXPathExpression (String xPathStr) throws XPathExpressionException {
		XPathExpression xpe = null;
		if (xPathExpressions.containsKey (xPathStr)) {
			xpe = xPathExpressions.get (xPathStr);
		} else {
			xpe = xPath.compile (xPathStr);
			xPathExpressions.put (xPathStr, xpe);
		}
		return xpe;
	}

	/**
	 * 
	 * @param input
	 * @param xPathStr
	 * @return the node, or null if not found
	 * @throws XPathExpressionException 
	 */
	public static Node getNode (Node input, String xPathStr) throws XPathExpressionException {
		XPathExpression xpe = getXPathExpression (xPathStr);
		Node result = (Node) xpe.evaluate (input, XPathConstants.NODE);
		return result;
	}

	public static NodeList getNodeList (Node input, String xPathStr) throws XPathExpressionException {
		XPathExpression xpe = getXPathExpression (xPathStr);
		NodeList result = (NodeList) xpe.evaluate (input, XPathConstants.NODESET);
		return result;
	}
}
