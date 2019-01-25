/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.extent;

/**
 *
 * @author WIN8
 */
public class ExGeographicBoundingBox {
    
    private String subParent;
    private String current="gmd:EX_GeographicBoundingBox";
    private String extentTypeCode="gmd:extentTypeCode.gco:Boolean";
    private String westBoundLongitude="gmd:westBoundLongitude.gco:Decimal";
    private String eastBoundLongitude="gmd:eastBoundLongitude.gco:Decimal";
    private String southBoundLatitude="gmd:southBoundLatitude.gco:Decimal";
    private String northBoundLatitude="gmd:northBoundLatitude.gco:Decimal";

    public ExGeographicBoundingBox(String parent) {
        subParent = parent+"."+current;
    }

    public String ExtentTypeCode() {
        return subParent+"."+extentTypeCode;
    }

    public String WestBoundLongitude() {
        return subParent+"."+westBoundLongitude;
    }

    public String EastBoundLongitude() {
        return subParent+"."+eastBoundLongitude;
    }

    public String SouthBoundLatitude() {
        return subParent+"."+southBoundLatitude;
    }

    public String NorthBoundLatitude() {
        return subParent+"."+northBoundLatitude;
    }
    
}
