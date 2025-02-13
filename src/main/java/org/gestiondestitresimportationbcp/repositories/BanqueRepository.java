package org.gestiondestitresimportationbcp.repositories;

import org.gestiondestitresimportationbcp.entities.Banque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BanqueRepository extends JpaRepository<Banque,Long> {
}
