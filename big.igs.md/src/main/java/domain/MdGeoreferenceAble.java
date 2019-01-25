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
public class MdGeoreferenceAble implements java.io.Serializable{
    
    private BigDecimal controlPointAvailability;
    private String georeferencedParameters;
    private BigDecimal orientationParamAvailability;
    private String orientationParamDesc;
    private BigDecimal id;

    public MdGeoreferenceAble() {
    }

    public MdGeoreferenceAble(BigDecimal id) {
        this.id = id;
    }

    public MdGeoreferenceAble(BigDecimal controlPointAvailability, String georeferencedParameters, BigDecimal orientationParamAvailability, String orientationParamDesc, BigDecimal id) {
        this.controlPointAvailability = controlPointAvailability;
        this.georeferencedParameters = georeferencedParameters;
        this.orientationParamAvailability = orientationParamAvailability;
        this.orientationParamDesc = orientationParamDesc;
        this.id = id;
    }

    public BigDecimal getControlPointAvailability() {
        return controlPointAvailability;
    }

    public void setControlPointAvailability(BigDecimal controlPointAvailability) {
        this.controlPointAvailability = controlPointAvailability;
    }

    public String getGeoreferencedParameters() {
        return georeferencedParameters;
    }

    public void setGeoreferencedParameters(String georeferencedParameters) {
        this.georeferencedParameters = georeferencedParameters;
    }

    public BigDecimal getOrientationParamAvailability() {
        return orientationParamAvailability;
    }

    public void setOrientationParamAvailability(BigDecimal orientationParamAvailability) {
        this.orientationParamAvailability = orientationParamAvailability;
    }

    public String getOrientationParamDesc() {
        return orientationParamDesc;
    }

    public void setOrientationParamDesc(String orientationParamDesc) {
        this.orientationParamDesc = orientationParamDesc;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    
}
