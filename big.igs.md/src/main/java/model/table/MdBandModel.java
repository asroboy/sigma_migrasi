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
public class MdBandModel {
    
    private BigDecimal bitsPerValue;
    private BigDecimal maxValue;
    private BigDecimal minValue;
    private BigDecimal offsets;
    private BigDecimal peakResponse;
    private BigDecimal scaleFactor;
    private BigDecimal toneGradation;
    private String units;
    private BigDecimal id;

    public BigDecimal getBitsPerValue() {
        return bitsPerValue;
    }

    public void setBitsPerValue(BigDecimal bitsPerValue) {
        this.bitsPerValue = bitsPerValue;
    }

    public BigDecimal getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    public BigDecimal getMinValue() {
        return minValue;
    }

    public void setMinValue(BigDecimal minValue) {
        this.minValue = minValue;
    }

    public BigDecimal getOffsets() {
        return offsets;
    }

    public void setOffsets(BigDecimal offsets) {
        this.offsets = offsets;
    }

    public BigDecimal getPeakResponse() {
        return peakResponse;
    }

    public void setPeakResponse(BigDecimal peakResponse) {
        this.peakResponse = peakResponse;
    }

    public BigDecimal getScaleFactor() {
        return scaleFactor;
    }

    public void setScaleFactor(BigDecimal scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public BigDecimal getToneGradation() {
        return toneGradation;
    }

    public void setToneGradation(BigDecimal toneGradation) {
        this.toneGradation = toneGradation;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
    
    
}
