/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.xmlhelper;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dmitriy Merkushov
 */
public class DynamicArrayNodeList extends ArrayList<Node> implements NodeList {

	private static final long serialVersionUID = 1L;

	public DynamicArrayNodeList () {
		super ();
	}

	public DynamicArrayNodeList (NodeList nodeList) {
		this ();
		if (nodeList != null) {
			for (int i = 0; i < nodeList.getLength (); i++) {
				Node node = nodeList.item (i);
				add (node);
			}
		}
	}

	@Override
	public Node item (int index) {
		return get (index);
	}

	@Override
	public int getLength () {
		return size ();
	}
}
