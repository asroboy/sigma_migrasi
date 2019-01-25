/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.sql.Blob;

/**
 *
 * @author wallet
 */
public class MdUploadFileModel {
    
    private BigDecimal id;
    private String fileIdentifier;
    private Blob fileName;

    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFileIdentifier() {
        return fileIdentifier;
    }

    public void setFileIdentifier(String fileIdentifier) {
        this.fileIdentifier = fileIdentifier;
    }

    public Blob getFileName() {
        return fileName;
    }

    public void setFileName(Blob fileName) {
        this.fileName = fileName;
    }
    
    
    
}
