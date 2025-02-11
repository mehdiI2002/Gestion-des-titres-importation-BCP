package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface FileServices {
    DemandeDomiciliationMessage parseFile(String filePath);
    File uploadFile(String uploadDir, MultipartFile file);
}
