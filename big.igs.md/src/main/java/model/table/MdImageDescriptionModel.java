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
public class MdImageDescriptionModel {
    
    private BigDecimal cameraCalibrationInfoAvailable;
    private BigDecimal cloudCoverPercentage;
    private BigDecimal compressionGenerationQuantity;
    private BigDecimal filmDistortionInfoAvailability;
    private BigDecimal illuminationAzimuthAngle;
    private BigDecimal illmuniationElevationAngle;
    private BigDecimal lenDistortionInfoAvailability;
    private BigDecimal radioMetricCalibDataAvailable;
    private BigDecimal triangulationIndicator;
    private BigDecimal id;
    private String imagingCondition;

    public BigDecimal getCameraCalibrationInfoAvailable() {
        return cameraCalibrationInfoAvailable;
    }

    public void setCameraCalibrationInfoAvailable(BigDecimal cameraCalibrationInfoAvailable) {
        this.cameraCalibrationInfoAvailable = cameraCalibrationInfoAvailable;
    }

    public BigDecimal getCloudCoverPercentage() {
        return cloudCoverPercentage;
    }

    public void setCloudCoverPercentage(BigDecimal cloudCoverPercentage) {
        this.cloudCoverPercentage = cloudCoverPercentage;
    }

    public BigDecimal getCompressionGenerationQuantity() {
        return compressionGenerationQuantity;
    }

    public void setCompressionGenerationQuantity(BigDecimal compressionGenerationQuantity) {
        this.compressionGenerationQuantity = compressionGenerationQuantity;
    }

    public BigDecimal getFilmDistortionInfoAvailability() {
        return filmDistortionInfoAvailability;
    }

    public void setFilmDistortionInfoAvailability(BigDecimal filmDistortionInfoAvailability) {
        this.filmDistortionInfoAvailability = filmDistortionInfoAvailability;
    }

    public BigDecimal getIlluminationAzimuthAngle() {
        return illuminationAzimuthAngle;
    }

    public void setIlluminationAzimuthAngle(BigDecimal illuminationAzimuthAngle) {
        this.illuminationAzimuthAngle = illuminationAzimuthAngle;
    }

    public BigDecimal getIllmuniationElevationAngle() {
        return illmuniationElevationAngle;
    }

    public void setIllmuniationElevationAngle(BigDecimal illmuniationElevationAngle) {
        this.illmuniationElevationAngle = illmuniationElevationAngle;
    }

    public BigDecimal getLenDistortionInfoAvailability() {
        return lenDistortionInfoAvailability;
    }

    public void setLenDistortionInfoAvailability(BigDecimal lenDistortionInfoAvailability) {
        this.lenDistortionInfoAvailability = lenDistortionInfoAvailability;
    }

    public BigDecimal getRadioMetricCalibDataAvailable() {
        return radioMetricCalibDataAvailable;
    }

    public void setRadioMetricCalibDataAvailable(BigDecimal radioMetricCalibDataAvailable) {
        this.radioMetricCalibDataAvailable = radioMetricCalibDataAvailable;
    }

    public BigDecimal getTriangulationIndicator() {
        return triangulationIndicator;
    }

    public void setTriangulationIndicator(BigDecimal triangulationIndicator) {
        this.triangulationIndicator = triangulationIndicator;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getImagingCondition() {
        return imagingCondition;
    }

    public void setImagingCondition(String imagingCondition) {
        this.imagingCondition = imagingCondition;
    }
    
    
}
