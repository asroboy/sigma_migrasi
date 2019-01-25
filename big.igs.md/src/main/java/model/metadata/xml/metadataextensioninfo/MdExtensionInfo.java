/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataextensioninfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.metadataentitysetinformation.CiOnlineResourceInfo;

/**
 *
 * @author wallet
 */
public class MdExtensionInfo {
    
    private String current="gmd:MD_MetadataExtensionInformation";
    private String subparent;
    private CiOnlineResourceInfo ciOnlineResourceInfo;
    private MdExtendedElementInformation mdExtendedElementInformation;

    public MdExtensionInfo(String parent) {
        this.subparent = parent+"."+current;
    }

    public CiOnlineResourceInfo CiOnlineResourceInfo() {
        ciOnlineResourceInfo=new CiOnlineResourceInfo(subparent+"."+ParentElement.EXTENSIONONLINERESOURCE);
        return ciOnlineResourceInfo;
    }

    public MdExtendedElementInformation MdExtendedElementInformation() {
        mdExtendedElementInformation=new MdExtendedElementInformation(subparent+"."+ParentElement.EXTENDEDELEMENTINFORMATION);
        return mdExtendedElementInformation;
    }    
    
    
}
