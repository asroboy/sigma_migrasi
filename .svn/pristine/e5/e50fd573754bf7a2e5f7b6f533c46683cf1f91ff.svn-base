/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataentitysetinformation;

import model.metadata.xml.ParentElement;

/**
 *
 * @author wallet
 */
public class ContactInfo {
    
    private String subParent;
    private String current="gmd:CI_Contact";
    private CiTelephone ciTelephone;
    private CiAddress ciAddress;
    private CiOnlineResourceInfo ciOnlineResourceInfo;
    private String hoursOfService="gmd:hoursOfService.gco:CharacterString";
    private String contactInstructions="gmd:contactInstructions.gco:CharacterString";

    public ContactInfo(String parent) {
        
        subParent = parent+"."+current;
    }

    public String HoursOfService() {
        return subParent+"."+hoursOfService;
    }

    public String ContactInstructions() {
        return subParent+"."+contactInstructions;
    }

    public CiTelephone CiTelephone() {
        ciTelephone=new CiTelephone(subParent+"."+ParentElement.PHONE);
        return ciTelephone;
    }

    public CiAddress CiAddress() {
        ciAddress=new CiAddress(subParent+"."+ParentElement.ADDRESS);
        return ciAddress;
    }

    public CiOnlineResourceInfo CiOnlineResourceInfo() {
        ciOnlineResourceInfo=new CiOnlineResourceInfo(subParent+"."+ParentElement.ONLINERESOURCE);
        return ciOnlineResourceInfo;
    }
    
}
