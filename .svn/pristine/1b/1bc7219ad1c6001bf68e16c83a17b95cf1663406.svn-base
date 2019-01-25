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
public class CiResponsibleParty {
 
    private String subParent;
    private String current="gmd:CI_ResponsibleParty";
    private String individualName="gmd:individualName.gco:CharacterString";
    private String organisationName="gmd:organisationName.gco:CharacterString";
    private String positionName="gmd:positionName.gco:CharacterString";
    private ContactInfo contactInfo;
    private String role="gmd:role.gmd:CI_RoleCode";
   
    public CiResponsibleParty(String parent) {
        
        subParent=parent+"."+current;
    }

    public String Role() {
        return subParent+"."+role;
    }
    
    public String IndividualName() {
        return subParent+"."+individualName;
    }

    public String OrganisationName() {
        return subParent+"."+organisationName;
    }

    public String PositionName() {
        return subParent+"."+positionName;
    }

    public ContactInfo ContactInfo() {
        contactInfo=new ContactInfo(subParent+"."+ParentElement.CONTACTINFO);
        return contactInfo;
    }
    

  
}
