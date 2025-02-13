package org.gestiondestitresimportationbcp.service;

import org.gestiondestitresimportationbcp.models.DemandeDomiciliationMessage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileServices {
    DemandeDomiciliationMessage parseFile(String filePath);
    List<String> uploadFile(MultipartFile[] files);
}
