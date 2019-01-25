/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.aggregationInfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author WIN8
 */
public class MdAggregateInformation {
    
    private String subParent;
    private String current="gmd:MD_AggregateInformation";
    private String associationType="gmd:associationType.gmd:DS_AssociationTypeCode";
    private String initiativeType="gmd:initiativeType.gmd:DS_InitiativeTypeCode";
    private CiCitation ciCitation;
    private MdIdentifier mdIdentifier;

    public MdAggregateInformation(String parent) {
        subParent= parent+"."+current;
    }

    public String AssociationType() {
        return subParent+"."+associationType;
    }

    public String InitiativeType() {
        return subParent+"."+initiativeType;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subParent+"."+ParentElement.AGGREGATEDATASETNAME);
        return ciCitation;
    }

    public MdIdentifier MdIdentifier() {
        mdIdentifier=new MdIdentifier(subParent+"."+ParentElement.AGGREGATEDATASETIDENTIFIER);
        return mdIdentifier;
    }
    
    

}
