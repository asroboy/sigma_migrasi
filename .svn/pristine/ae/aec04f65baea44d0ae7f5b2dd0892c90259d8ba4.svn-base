/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.spatialrepresentationInfo;

/**
 *
 * @author wallet
 */
public class MdGeometricObjects {
    
    private String subParent;
    private String current="gmd:MD_GeometricObjects";
    private String geometricObjectType="gmd:geometricObjectType.gmd:MD_GeometricObjectTypeCode";
    private String geometricObjectCount="gmd:geometricObjectCount.gco:Integer";

    public MdGeometricObjects(String Parent) {
        subParent = Parent+"."+current;
    }

    public String GeometricObjectType() {
        return subParent+"."+geometricObjectType;
    }

    public String GeometricObjectCount() {
        return subParent+"."+geometricObjectCount;
    }
}
