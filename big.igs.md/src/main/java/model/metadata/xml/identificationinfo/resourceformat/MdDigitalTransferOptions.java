/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.resourceformat;

import model.metadata.xml.ParentElement;
import model.metadata.xml.metadataentitysetinformation.CiOnlineResourceInfo;

/**
 *
 * @author WIN8
 */
public class MdDigitalTransferOptions {
    
    private String subParent;
    private String current="gmd:MD_DigitalTransferOptions";
    private CiOnlineResourceInfo ciOnlineResourceInfo;
    private MdMedium mdMedium;
    private String transferSize="gmd:transferSize.gco:Real";
   
    public MdDigitalTransferOptions(String parent) {
        subParent = parent+"."+current;
    }

    public CiOnlineResourceInfo CiOnlineResourceInfo() {
        ciOnlineResourceInfo=new CiOnlineResourceInfo(subParent+"."+ParentElement.ONLINE);
        return ciOnlineResourceInfo;
    }

    public MdMedium MdMedium() {
        mdMedium=new MdMedium(subParent+"."+ParentElement.OFFLINE);
        return mdMedium;
    }

    public String TransferSize() {
        return subParent+"."+transferSize;
    }
    
    
}
