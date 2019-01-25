/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.referencesystemInfo;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class MdReferenceSystem {
    
    
    private String subParent;
    private String current="gmd:MD_ReferenceSystem";
    private RsIdentifier rsIdentifier;

    public MdReferenceSystem(String parent) {
        subParent=parent+"."+current;
    }

    public RsIdentifier RsIdentifier() {
        rsIdentifier=new RsIdentifier(subParent+"."+ParentElement.REFERENCESYSTEMIDENTIFIER);
        return rsIdentifier;
    }
    
    

}
