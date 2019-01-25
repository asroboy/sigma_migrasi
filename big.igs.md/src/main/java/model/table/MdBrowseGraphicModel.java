/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdBrowseGraphicModel {
    
    private BigDecimal id;
    private String fileDescription;
    private String fileName;
    private String fileType;
    private BigDecimal mdIdentificationId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }
}
