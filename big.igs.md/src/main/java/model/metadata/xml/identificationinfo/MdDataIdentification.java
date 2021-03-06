/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.identificationinfo.extent.Extent;
import model.metadata.xml.identificationinfo.spatialresolution.MdResolution;
import model.metadata.xml.identificationinfo.aggregationInfo.MdAggregateInformation;
import model.metadata.xml.identificationinfo.descriptivekeywords.MdKeywords;
import model.metadata.xml.identificationinfo.resourceformat.MdFormat;
import model.metadata.xml.identificationinfo.graphicoverview.MdBrowseGraphic;
import model.metadata.xml.metadataconstraints.MdConstraints;
import model.metadata.xml.metadataconstraints.MdLegalConstraints;
import model.metadata.xml.metadataconstraints.MdSecurityConstraints;
import model.metadata.xml.metadataentitysetinformation.CiResponsibleParty;
import model.metadata.xml.metadatamaintenance.MdMaintenanceInformation;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author wallet
 */
public class MdDataIdentification {

    private String subParent;
    private String current = "gmd:MD_DataIdentification";
    private String supplementalInformation = "gmd:supplementalInformation.gco:CharacterString";
    private String abstract_ = "gmd:abstract.gco:CharacterString";
    private String status = "gmd:status.gmd:MD_ProgressCode";
    private CiResponsibleParty ciResponsibleParty;
    private CiCitation ciCitation;
    private MdMaintenanceInformation mdMaintenanceInformation;
    private MdBrowseGraphic mdBrowseGraphic;
    private String spatialRepresentationType = "gmd:spatialRepresentationType.gmd:MD_SpatialRepresentationTypeCode";
    private MdFormat mdFormat;
    private MdKeywords mdKeywords;
    private MdConstraints mdConstraints;
    private MdAggregateInformation mdAggregateInformation;
    private MdResolution mdResolution;
    private String language = "gmd:language.gco:CharacterString";
    private String characterSet = "gmd:characterSet.gmd:MD_CharacterSetCode";
    private String topicCategory = "gmd:topicCategory.gmd:MD_TopicCategoryCode";
    private String environmentDescription = "gmd:environmentDescription.gco:CharacterString";
    private String purpose = "gmd:purpose.gco:CharacterString";
    private String credit = "gmd:credit.gco:CharacterString";
    private Extent extent;
    private MdSecurityConstraints mdSecurityConstraints;
    private MdLegalConstraints mdLegalConstraints;

    public MdDataIdentification(String parent) {
        subParent = parent + "." + current;
    }

    public String abstract_() {
        return subParent + "." + abstract_;
    }

    public String status() {
        return subParent + "." + status;
    }

    public String SupplementalInformation() {
        return subParent + "." + supplementalInformation;
    }

    public String SpatialRepresentationType() {
        return subParent + "." + spatialRepresentationType;
    }

    public CiCitation CiCitation() {
        ciCitation = new CiCitation(subParent + "." + ParentElement.CITATION);
        return ciCitation;
    }

    public CiResponsibleParty CiResponsibleParty() {
        ciResponsibleParty = new CiResponsibleParty(subParent + "." + ParentElement.POINTOFCONTACT);
        return ciResponsibleParty;
    }

    public MdMaintenanceInformation MdMaintenanceInformation() {
        mdMaintenanceInformation = new MdMaintenanceInformation(subParent + "." + ParentElement.RESOURCEMAINTENANCE);
        return mdMaintenanceInformation;
    }

    public MdBrowseGraphic MdBrowseGraphic() {
        mdBrowseGraphic = new MdBrowseGraphic(subParent + "." + ParentElement.GRAPHICOVERVIEW);
        return mdBrowseGraphic;
    }

    public MdFormat MdFormat() {
        mdFormat = new MdFormat(subParent + "." + ParentElement.RESOURCEFORMAT);
        return mdFormat;
    }

    public MdKeywords MdKeywords() {
        mdKeywords = new MdKeywords(subParent + "." + ParentElement.DESCRIPTIVEKEYWORDS);
        return mdKeywords;
    }

    public MdConstraints MdConstraints() {
        mdConstraints = new MdConstraints(subParent + "." + ParentElement.RESOURCECONSTRAINTS);
        return mdConstraints;
    }

    public MdAggregateInformation MdAggregateInformation() {
        mdAggregateInformation = new MdAggregateInformation(subParent + "." + ParentElement.AGGREGATIONINFO);
        return mdAggregateInformation;
    }

    public MdResolution MdResolution() {
        mdResolution = new MdResolution(subParent + "." + ParentElement.SPATIALRESOLUTION);
        return mdResolution;
    }

    public String Language() {
        return subParent + "." + language;
    }

    public String CharacterSet() {
        return subParent + "." + characterSet;
    }

    public String TopicCategory() {
        return subParent + "." + topicCategory;
    }

    public Extent Extent() {
        extent = new Extent(subParent + "." + ParentElement.EXTENT);
        return extent;
    }

    public MdSecurityConstraints MdSecurityConstraints() {
        mdSecurityConstraints = new MdSecurityConstraints(subParent + "." + ParentElement.RESOURCECONSTRAINTS);
        return mdSecurityConstraints;
    }

    public MdLegalConstraints MdLegalConstraints() {
        mdLegalConstraints = new MdLegalConstraints(subParent + "." + ParentElement.RESOURCECONSTRAINTS);
        return mdLegalConstraints;
    }

    public String EnvironmentDescription() {
        return subParent + "." + environmentDescription;
    }

    public String Purpose() {
        return subParent + "." + purpose;
    }

    public String Credit() {
        return subParent + "." + credit;
    }

}
