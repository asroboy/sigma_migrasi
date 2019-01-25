/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.subelement;

import model.metadata.xml.dataquality.DqBaseModel;

/**
 *
 * @author WIN8
 */
public class DqAccuracyOfATimeMeasurement extends DqBaseModel{
    
    private static String current="gmd:DQ_AccuracyOfATimeMeasurement";
    private String subParent;

    public DqAccuracyOfATimeMeasurement(String Parent) {
        super(Parent+"."+current);
    }
}
