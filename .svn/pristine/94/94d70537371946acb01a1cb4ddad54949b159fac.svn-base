/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.lilineage;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class ExBoundingPolygon {
    
    private String subParent;
    private String current="gmd:EX_BoundingPolygon";
    private String extentTypeCode="gmd:extentTypeCode.gco:Boolean";
    private Polygon polygon;

    public ExBoundingPolygon(String parent) {
        subParent = parent+"."+current;
    }

    public String ExtentTypeCode() {
        return subParent+"."+extentTypeCode;
    }

    public Polygon Polygon() {
        polygon=new Polygon(subParent+"."+ParentElement.POLYGON);
        return polygon;
    }
    
    
}
