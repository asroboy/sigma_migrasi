/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.resourceformat;

/**
 *
 * @author wallet
 */
public class MdMedium {
 
    private String current="gmd:MD_Medium";
    private String subparent;
    private String name="gmd:name.gco:CharacterString";
    private String densityUnits="gmd:densityUnits.gco:CharacterString";

    public MdMedium(String parent) {
        this.subparent = parent+"."+current;
    }

    public String Name() {
        return subparent+"."+name;
    }

    public String DensityUnits() {
        return subparent+"."+densityUnits;
    }
    
    
}
