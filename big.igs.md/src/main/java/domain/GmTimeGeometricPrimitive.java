
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
public class GmTimeGeometricPrimitive implements java.io.Serializable{
    
    private String extendsType;
    private BigDecimal id;
    private String timePosition;
    private String beginPosition;
    private String duration;
    private String endPosition;
    private String timeInterval;
    private BigDecimal exTemporalExtentId;

    public GmTimeGeometricPrimitive() {
    }

    public GmTimeGeometricPrimitive(BigDecimal id) {
        this.id = id;
    }

    public GmTimeGeometricPrimitive(String extendsType, BigDecimal id, String timePosition, String beginPosition, String duration, String endPosition, String timeInterval, BigDecimal exTemporalExtentId) {
        this.extendsType = extendsType;
        this.id = id;
        this.timePosition = timePosition;
        this.beginPosition = beginPosition;
        this.duration = duration;
        this.endPosition = endPosition;
        this.timeInterval = timeInterval;
        this.exTemporalExtentId = exTemporalExtentId;
    }

    public String getExtendsType() {
        return extendsType;
    }

    public void setExtendsType(String extendsType) {
        this.extendsType = extendsType;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTimePosition() {
        return timePosition;
    }

    public void setTimePosition(String timePosition) {
        this.timePosition = timePosition;
    }

    public String getBeginPosition() {
        return beginPosition;
    }

    public void setBeginPosition(String beginPosition) {
        this.beginPosition = beginPosition;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(String endPosition) {
        this.endPosition = endPosition;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public BigDecimal getExTemporalExtentId() {
        return exTemporalExtentId;
    }

    public void setExTemporalExtentId(BigDecimal exTemporalExtentId) {
        this.exTemporalExtentId = exTemporalExtentId;
    }
    
    
    
}   
