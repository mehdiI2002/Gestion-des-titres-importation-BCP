package org.gestiondestitresimportationbcp.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Service
public class KafkaProducerService  implements  KafkaServices{
    private KafkaTemplate kafkaTemplate;
    public KafkaProducerService(KafkaTemplate<Integer,String>kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    private static final String TOPIC = "DDDTopic";
        @Override
        public void sendMessage(String message) {
            kafkaTemplate.send(TOPIC, message);
        }

    }

