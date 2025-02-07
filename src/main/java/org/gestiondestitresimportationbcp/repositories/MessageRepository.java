package org.gestiondestitresimportationbcp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.gestiondestitresimportationbcp.entities.Message;

public interface MessageRepository  extends JpaRepository<Message,Long> {

}
