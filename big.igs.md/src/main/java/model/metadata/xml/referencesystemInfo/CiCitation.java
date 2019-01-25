/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.referencesystemInfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.dataquality.lilineage.CiSeries;
import model.metadata.xml.identificationinfo.aggregationInfo.MdIdentifier;
import model.metadata.xml.metadataentitysetinformation.CiResponsibleParty;

/**
 *
 * @author wallet
 */
public class CiCitation {
 
    private String subParent;
    private String current="gmd:CI_Citation";
    private String title="gmd:title.gco:CharacterString";
    private String alternateTitle="gmd:alternateTitle.gco:CharacterString";
    private String edition="gmd:edition.gco:CharacterString";
    private String editionDate="gmd:editionDate.gco:Date";
    private String presentationForm="gmd:presentationForm.gmd:CI_PresentationFormCode";
    private String otherCitationDetails="gmd:otherCitationDetails.gco:CharacterString";
    private CiDate ciDate;
    private RsIdentifier rsIdentifier;
    private CiSeries ciSeries;
    private MdIdentifier mdIdentifier;
    private CiResponsibleParty ciResponsibleParty;

    public CiCitation(String parent) {
        subParent = parent+"."+current;
    }

    public String Title() {
        return subParent+"."+title;
    }

    public CiDate Date() {
        ciDate = new CiDate(subParent+"."+ParentElement.DATE_);
        return ciDate;
    }

    public String AlternateTitle() {
        return subParent+"."+alternateTitle;
    }

    public String Edition() {
        return subParent+"."+edition;
    }

    public String EditionDate() {
        return subParent+"."+editionDate;
    }

    public RsIdentifier RsIdentifier() {
        rsIdentifier=new RsIdentifier(subParent+"."+ParentElement.IDENTIFIER);
        return rsIdentifier;
    }

    public CiSeries CiSeries() {
        ciSeries=new CiSeries(subParent+"."+ParentElement.SERIES);
        return ciSeries;
    }

    public String PresentationForm() {
        return subParent+"."+presentationForm;
    }

    public MdIdentifier MdIdentifier() {
        mdIdentifier=new MdIdentifier(subParent+"."+ParentElement.IDENTIFIER);
        return mdIdentifier;
    }

    public CiResponsibleParty CiResponsibleParty() {
        ciResponsibleParty = new CiResponsibleParty(subParent+"."+ParentElement.CITEDRESPONSIBLEPARTY);
        return ciResponsibleParty;
    }

    public String OtherCitationDetails() {
        return subParent+"."+otherCitationDetails;
    }
    
    
}
