/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.spatialrepresentationInfo;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class MdSpatialRepresentation {
 
    private String subParent;
    private String current="gmd:MD_VectorSpatialRepresentation";
    private String topologyLevel="gmd:topologyLevel.gmd:MD_TopologyLevelCode";
    private MdGeometricObjects mdGeometricObjects;
    
    public MdSpatialRepresentation(String parent) {
        subParent=parent+"."+current;
    }

    public String TopologyLevel() {
        return subParent+"."+topologyLevel;
    }
    
    public MdGeometricObjects MdGeometricObjects(){
        mdGeometricObjects = new MdGeometricObjects(subParent+"."+ParentElement.GEOMETRICOBJECTS);
        return mdGeometricObjects;
    }
}
