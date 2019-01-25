/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.extent;

import model.metadata.xml.ParentElement;
import model.metadata.xml.dataquality.lilineage.ExBoundingPolygon;

/**
 *
 * @author WIN8
 */
public class Extent {
    
    private String subParent;
    private String current="gmd:EX_Extent";
    private String description="gmd:description.gco:CharacterString";
    private String temporalElement="gmd:temporalElement";
    private String verticalElement="gmd:verticalElement";
    private ExGeographicBoundingBox exGeographicBoundingBox;
    private ExBoundingPolygon exBoundingPolygon;

    public Extent(String parent) {
        subParent= parent+"."+current;
    }

    public String Description() {
        return subParent+"."+description;
    }

    public ExGeographicBoundingBox ExGeographicBoundingBox() {
        exGeographicBoundingBox=new ExGeographicBoundingBox(subParent+"."+ParentElement.GEOGRAPHICELEMENT);
        return exGeographicBoundingBox;
    }

    public String TemporalElement() {
        return subParent+"."+temporalElement;
    }

    public String VerticalElement() {
        return subParent+"."+verticalElement;
    }

    public ExBoundingPolygon ExBoundingPolygon() {
        exBoundingPolygon=new ExBoundingPolygon(subParent+"."+ParentElement.GEOGRAPHICELEMENT);
        return exBoundingPolygon;
    }
    
}
