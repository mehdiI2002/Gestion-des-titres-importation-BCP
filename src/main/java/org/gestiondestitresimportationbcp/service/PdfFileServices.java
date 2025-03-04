package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.entities.PdfFile;

import java.util.List;


public interface PdfFileServices {
   void insertPdfFile( PdfFile pdfFile) ;
   public List<String> selectPdfsFortitle(Long numEnregistrement );
}
