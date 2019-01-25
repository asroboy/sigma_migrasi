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
public class SvOperationMetadataModel {
    
    private BigDecimal id;
    private String invocationName;
    private String operationDescription;
    private String operationName;
    private BigDecimal svOperationMetadataId;
    private BigDecimal svServiceIdentificationId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getInvocationName() {
        return invocationName;
    }

    public void setInvocationName(String invocationName) {
        this.invocationName = invocationName;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public BigDecimal getSvOperationMetadataId() {
        return svOperationMetadataId;
    }

    public void setSvOperationMetadataId(BigDecimal svOperationMetadataId) {
        this.svOperationMetadataId = svOperationMetadataId;
    }

    public BigDecimal getSvServiceIdentificationId() {
        return svServiceIdentificationId;
    }

    public void setSvServiceIdentificationId(BigDecimal svServiceIdentificationId) {
        this.svServiceIdentificationId = svServiceIdentificationId;
    }
}