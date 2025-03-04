package org.gestiondestitresimportationbcp.repositories;

import org.gestiondestitresimportationbcp.entities.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PdfFileRepository  extends JpaRepository<PdfFile,Long> {
    @Query("select f.filePath from PdfFile f where f.numeroEnregistrement = :numEnregistrement")
    List<String> findPathByNumeroEnregistrement(@Param("numEnregistrement") Long numEnregistrement);
}
