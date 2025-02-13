package org.gestiondestitresimportationbcp.service;

import java.io.File;

public interface KafkaServices {
    void sendMessage(String message);
}
