package org.gestiondestitresimportationbcp.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class ConvertToPdf {
    public ResponseEntity<FileSystemResource> transformFileToPDF(String filePath) {
        String decodedFilePath = URLDecoder.decode(filePath, StandardCharsets.UTF_8);

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            decodedFilePath = decodedFilePath.replace("/", "\\");
        }
        System.out.println("path : "+ decodedFilePath);
        decodedFilePath = decodedFilePath.trim().replaceFirst("^,", "");

        File pdfFile = new File(decodedFilePath);
        FileSystemResource resource = new FileSystemResource(pdfFile);
       return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + pdfFile.getName())
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdfFile.length())
                .body(resource);
        }

}