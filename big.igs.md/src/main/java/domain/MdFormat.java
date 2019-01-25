/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdFormat implements java.io.Serializable{
    
    private BigDecimal id;
    private String amenDmentNumber;
    private String fileDecompressionTechnique;
    private String name;
    private String spesification;
    private String version;
    private BigDecimal mdDistributionId;
    private BigDecimal mdDistributorId;
    private BigDecimal mdIdentificationId;

    public MdFormat() {
    }

    public MdFormat(BigDecimal id) {
        this.id = id;
    }

    public MdFormat(BigDecimal id, String amenDmentNumber, String fileDecompressionTechnique, String name, String spesification, String version, BigDecimal mdDistributionId, BigDecimal mdDistributorId, BigDecimal mdIdentificationId) {
        this.id = id;
        this.amenDmentNumber = amenDmentNumber;
        this.fileDecompressionTechnique = fileDecompressionTechnique;
        this.name = name;
        this.spesification = spesification;
        this.version = version;
        this.mdDistributionId = mdDistributionId;
        this.mdDistributorId = mdDistributorId;
        this.mdIdentificationId = mdIdentificationId;
    }
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAmenDmentNumber() {
        return amenDmentNumber;
    }

    public void setAmenDmentNumber(String amenDmentNumber) {
        this.amenDmentNumber = amenDmentNumber;
    }
    
    public String getFileDecompressionTechnique() {
        return fileDecompressionTechnique;
    }

    public void setFileDecompressionTechnique(String fileDecompressionTechnique) {
        this.fileDecompressionTechnique = fileDecompressionTechnique;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpesification() {
        return spesification;
    }

    public void setSpesification(String spesification) {
        this.spesification = spesification;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigDecimal getMdDistributionId() {
        return mdDistributionId;
    }

    public void setMdDistributionId(BigDecimal mdDistributionId) {
        this.mdDistributionId = mdDistributionId;
    }

    public BigDecimal getMdDistributorId() {
        return mdDistributorId;
    }

    public void setMdDistributorId(BigDecimal mdDistributorId) {
        this.mdDistributorId = mdDistributorId;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }
    
    
}
