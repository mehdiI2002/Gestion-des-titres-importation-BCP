package org.gestiondestitresimportationbcp.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import org.gestiondestitresimportationbcp.entities.Message;
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseGeneriqueMessage {
    public ResponseGeneriqueMessage(Message headerMessage, MessageRecu messageRecu, Accuse accuse) {
        this.headerMessage = headerMessage;
        this.messageRecu = messageRecu;
        this.accuse = accuse;
    }

    public ResponseGeneriqueMessage(Message headerMessage,MessageRecu messageRecu) {
        this.headerMessage = headerMessage;
        this.messageRecu = messageRecu;
    }

    @XmlElement(name = "HeaderMessage")
    Message headerMessage;
    @XmlElement(name = "MessageRecu")
    MessageRecu messageRecu;
    @XmlElement(name = "Accuse")
    Accuse accuse;

    public ResponseGeneriqueMessage() {
    }

    public Message getHeaderMessage() {
        return headerMessage;
    }

    public MessageRecu getMessageRecu() {
        return messageRecu;
    }

    public Accuse getAccuse() {
        return accuse;
    }
}
