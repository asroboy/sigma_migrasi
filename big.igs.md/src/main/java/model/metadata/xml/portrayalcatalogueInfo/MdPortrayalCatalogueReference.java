/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.portrayalcatalogueInfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author wallet
 */
public class MdPortrayalCatalogueReference {
    
    private String subParent;
    private String current="gmd:MD_PortrayalCatalogueReference";
    private CiCitation ciCitation;

    public MdPortrayalCatalogueReference(String parent) {
          
        subParent=parent+"."+current;
    }  

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subParent+"."+ParentElement.PORTRAYALCATALOGUECITATION);
        return ciCitation;
    }
     
    
            
}
