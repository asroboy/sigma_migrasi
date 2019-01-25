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
public class MdSecurityConstraintsModel {
    
    private String classificationSystem;
    private String handlingDescription;
    private String userNote;
    private BigDecimal mdConstraintsId;
    private String classification;

    public String getClassificationSystem() {
        return classificationSystem;
    }

    public void setClassificationSystem(String classificationSystem) {
        this.classificationSystem = classificationSystem;
    }

    public String getHandlingDescription() {
        return handlingDescription;
    }

    public void setHandlingDescription(String handlingDescription) {
        this.handlingDescription = handlingDescription;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public BigDecimal getMdConstraintsId() {
        return mdConstraintsId;
    }

    public void setMdConstraintsId(BigDecimal mdConstraintsId) {
        this.mdConstraintsId = mdConstraintsId;
    }
    
    
}
