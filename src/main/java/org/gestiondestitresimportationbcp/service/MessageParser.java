package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.Message;
import org.gestiondestitresimportationbcp.repositories.MessageRepository;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageParser implements ParserFile {
    private MessageRepository messageRepository;
    private List<String> message;

    public MessageParser(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
        message = new ArrayList<>();
    }

    @Override
    public Message parseMessage(Node nodeElement) {
        NodeList childrens = nodeElement.getChildNodes();
        for (int i = 0; i < childrens.getLength(); i++) {
            Node child = childrens.item(i);
            if ((child.getNodeType() == Node.ELEMENT_NODE && (child.getNodeName().equals("HeaderMessage")))) {

                Element headerMessage = (Element) child;
                getElementValue(headerMessage);
            }
        }
        Long id = Long.parseLong(message.get(0));
        String emetteur = message.get(1);
        int destinataire = Integer.parseInt(message.get(2));
        String dateDeMessage = message.get(3);
        String typeDeMessage = message.get(4);
        String fonction = message.get(5);
        Message message = new Message(id, emetteur, destinataire, dateDeMessage, typeDeMessage, fonction);

      return message;


    }

    private void getElementValue(Element node) {
        NodeList childrens = node.getChildNodes();
        for (int i = 0; i < childrens.getLength(); i++) {
            Node child = childrens.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                message.add(child.getTextContent());
            }
        }
    }

    public List<String> getMessage() {
        return message;
    }
}
