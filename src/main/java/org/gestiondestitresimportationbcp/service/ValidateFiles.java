package org.gestiondestitresimportationbcp.service;

import java.io.File;

public interface ValidateFiles {
   boolean  validateFile(File xmlFile,String shemaFilePath);

}
