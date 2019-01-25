/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author wallet
 */
public class MdMaintenanceInfoModel {
    
    public static final String MD_IDENTIFICATIONID="mdIdentificationId";
    public static final String MD_METADATAID="mdMetadataId";
    
    private BigDecimal id;
    private Date dateOfNextUpdate;
    private String userDefinedMaintenanceFreq;
    private BigDecimal mdIdentificationId;
    private String maintenanceAndUpdateFrequency;
    private BigDecimal mdMetadataId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDateOfNextUpdate() {
        return dateOfNextUpdate;
    }

    public void setDateOfNextUpdate(Date dateOfNextUpdate) {
        this.dateOfNextUpdate = dateOfNextUpdate;
    }

    public String getUserDefinedMaintenanceFreq() {
        return userDefinedMaintenanceFreq;
    }

    public void setUserDefinedMaintenanceFreq(String userDefinedMaintenanceFreq) {
        this.userDefinedMaintenanceFreq = userDefinedMaintenanceFreq;
    }

    public BigDecimal getMdIdentificationId() {
        return mdIdentificationId;
    }

    public void setMdIdentificationId(BigDecimal mdIdentificationId) {
        this.mdIdentificationId = mdIdentificationId;
    }

    public String getMaintenanceAndUpdateFrequency() {
        return maintenanceAndUpdateFrequency;
    }

    public void setMaintenanceAndUpdateFrequency(String maintenanceAndUpdateFrequency) {
        this.maintenanceAndUpdateFrequency = maintenanceAndUpdateFrequency;
    }

    public BigDecimal getMdMetadataId() {
        return mdMetadataId;
    }

    public void setMdMetadataId(BigDecimal mdMetadataId) {
        this.mdMetadataId = mdMetadataId;
    }
    
}
