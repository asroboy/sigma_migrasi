/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.spatialresolution;

import model.metadata.xml.ParentElement;

/**
 *
 * @author WIN8
 */
public class MdResolution {
    
    private String subParent;
    private String current="gmd:MD_Resolution";
    private MdRepresentativeFraction mdRepresentativeFraction;

    public MdResolution(String parent) {
        subParent= parent+"."+current;
    }

    public MdRepresentativeFraction MdRepresentativeFraction() {
        mdRepresentativeFraction=new MdRepresentativeFraction(subParent+"."+ParentElement.EQUIVALENTSCALE);
        return mdRepresentativeFraction;
    }
    
}
