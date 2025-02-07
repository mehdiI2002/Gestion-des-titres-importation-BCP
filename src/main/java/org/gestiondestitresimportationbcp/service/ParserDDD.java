package org.gestiondestitresimportationbcp.service;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

@Service
public class ParserDDD {
    private Document document;
    private Element rootElement;

    public ParserDDD() {
    }

    public Node parseDDDFile(String source) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File xmlFile = new File(source);
            this.document = builder.parse(xmlFile);
            this.rootElement = document.getDocumentElement();
            System.out.println("l element racine " + rootElement.getNodeName());

            NodeList childNodes = rootElement.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node child = childNodes.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.println("First child of root element: " + child.getNodeName());
                    return child;
                }
            }

        } catch (Exception e) {
            System.out.println("erreur dans parseur " + e.getMessage());
        }

        return null;
    }

    public Document getDocument() {
        return document;
    }

    public Element getRootElement() {
        return rootElement;
    }
}