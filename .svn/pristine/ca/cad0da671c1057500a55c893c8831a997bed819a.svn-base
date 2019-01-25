/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.resourceformat;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class MdFormat {
    
    private String subParent;
    private String current="gmd:MD_Format";
    private String name="gmd:name.gco:CharacterString";
    private String version="gmd:version.gco:CharacterString";
    private String specification="gmd:specification.gco:CharacterString";
    private MdDistributor mdDistributor;

    public MdFormat(String parent) {
        subParent = parent+"."+current;
    }

    public String Name() {
        return subParent+"."+name;
    }

    public String Version() {
        return subParent+"."+version;
    }

    public String Specification() {
        return subParent+"."+specification;
    }

    public MdDistributor MdDistributor() {
        mdDistributor=new MdDistributor(subParent+"."+ParentElement.FORMATDISTRIBUTOR);
        return mdDistributor;
    }
      
    
}
