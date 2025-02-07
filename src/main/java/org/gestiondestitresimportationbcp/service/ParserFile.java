package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;
import org.w3c.dom.Node;

public interface ParserFile {
    Message parseMessage(Node nodeElement);

}
