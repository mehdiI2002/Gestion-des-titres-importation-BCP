package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.PdfFile;
import org.gestiondestitresimportationbcp.repositories.PdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdfFileServicesDefault implements PdfFileServices{
    @Autowired
    private PdfFileRepository pdfFileRepository;

    @Override
    public void insertPdfFile(PdfFile pdfFile) {

        pdfFileRepository.save(pdfFile);

       }

    @Override
    public List<String> selectPdfsFortitle(Long numEnregistrement) {
        return  pdfFileRepository.findPathByNumeroEnregistrement(numEnregistrement);
    }

}



