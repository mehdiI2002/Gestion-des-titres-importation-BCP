package org.gestiondestitresimportationbcp.entities;

import jakarta.persistence.*;

@Entity
public class PdfFile{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id ;
    @Column
    private String filePath;
@Column
private Long numeroEnregistrement ;
public PdfFile() {
    }

    public Long getId() {
        return id;
    }
    public String getFilePath() {
        return filePath;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getNumeroEnregistrement() {
        return numeroEnregistrement;
    }

    public void setNumeroEnregistrement(Long numeroEnregistrement) {
        this.numeroEnregistrement = numeroEnregistrement;
    }

    public PdfFile(Long id, String filePath, Long numeroEnregistrement) {
        this.id = id;
        this.filePath = filePath;
        this.numeroEnregistrement = numeroEnregistrement;
    }


}
