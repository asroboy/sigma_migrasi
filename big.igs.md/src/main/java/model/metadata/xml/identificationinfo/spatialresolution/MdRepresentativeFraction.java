/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.spatialresolution;

/**
 *
 * @author WIN8
 */
public class MdRepresentativeFraction {
    
    private String subParent;
    private String current="gmd:MD_RepresentativeFraction";
    private String denominator="gmd:denominator.gco:Integer";

    public MdRepresentativeFraction(String parent) {
        subParent= parent+"."+current;
    }

    public String Denominator() {
        return subParent+"."+denominator;
    }
    
    
    
}
