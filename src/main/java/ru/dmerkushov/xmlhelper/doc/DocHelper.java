/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dmerkushov.xmlhelper.doc;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Dmitriy Merkushov
 */
public class DocHelper {

	static DocumentBuilder docBuilder;

	private static void checkDocBuilder () throws ParserConfigurationException {
		if (docBuilder == null) {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance ();
			docBuilder = dbf.newDocumentBuilder ();
		}
	}

	public static Document getDomDocumentFromFile (String filename) throws ParserConfigurationException, SAXException, IOException {
		Document doc = DocHelper.getDomDocumentFromFile (new File (filename));
		return doc;
	}

	public static Document getDomDocumentFromFile (File file) throws ParserConfigurationException, SAXException, IOException {
		checkDocBuilder ();
		Document doc = docBuilder.parse (file);
		return doc;
	}

	public static Document getDomDocumentFromString (String xml) throws ParserConfigurationException, SAXException, IOException {
		checkDocBuilder ();

		InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xml));

        Document doc = docBuilder.parse(is);

		return doc;
	}
}
