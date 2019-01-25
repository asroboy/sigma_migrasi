/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataentitysetinformation;

import model.metadata.xml.ParentElement;
import model.metadata.xml.applicationschemaInfo.MdApplicationSchemaInformation;
import model.metadata.xml.contentinfo.MdCoverageDescription;
import model.metadata.xml.dataquality.DqDataQuality;
import model.metadata.xml.distributioninfo.MdDistribution;
import model.metadata.xml.identificationinfo.MdDataIdentification;
import model.metadata.xml.metadataconstraints.MdConstraints;
import model.metadata.xml.metadataconstraints.MdSecurityConstraints;
import model.metadata.xml.metadataextensioninfo.MdExtensionInfo;
import model.metadata.xml.metadatamaintenance.MdMaintenanceInformation;
import model.metadata.xml.portrayalcatalogueInfo.MdPortrayalCatalogueReference;
import model.metadata.xml.referencesystemInfo.MdReferenceSystem;
import model.metadata.xml.spatialrepresentationInfo.MdSpatialRepresentation;

/**
 *W
 * @author wallet
 */
public class MdMetadata {
    
    private String parent=ParentElement.ROOT;
    private String fileIdentifier="gmd:fileIdentifier.gco:CharacterString";
    private String language="gmd:language.gco:CharacterString";
    private String characterSet="gmd:characterSet.gmd:MD_CharacterSetCode";
    private String parentIdentifier="gmd:parentIdentifier.gco:CharacterString";
    private String hierarchyLevel="gmd:hierarchyLevel.gmd:MD_ScopeCode";
    private String hierarchyLevelName="gmd:hierarchyLevelName.gco:CharacterString";
    private CiResponsibleParty ciResponsibleParty;
    private String dateStamp="gmd:dateStamp.gco:Date";
    private String metadataStandardName="gmd:metadataStandardName.gco:CharacterString";
    private String metadataStandardVersion="gmd:metadataStandardVersion.gco:CharacterString";
    private String dataSetUri="gmd:dataSetURI.gco:CharacterString";
    private MdSpatialRepresentation mdSpatialRepresentation;
    private MdReferenceSystem mdReferenceSystem;
    private MdCoverageDescription mdCoverageDescription;
    private MdPortrayalCatalogueReference mdPortrayalCatalogueReference;
    private MdMaintenanceInformation mdMaintenanceInformation;
    private MdDataIdentification mdDataIdentification;
    private DqDataQuality dqDataQuality;
    private MdConstraints mdConstraints;
    private MdApplicationSchemaInformation mdApplicationSchemaInformation;
    private MdExtensionInfo mdExtensionInfo;
    private MdDistribution mdDistribution;
    private MdSecurityConstraints mdSecurityConstraints;

    public String FileIdentifier() {
        return parent+"."+fileIdentifier;
    }
    
    public String Language() {
        return parent+"."+language;
    }
    
    public String CharacterSet() {
        return parent+"."+characterSet;
    }
    
    public String ParentIdentifier() {
        return parent+"."+parentIdentifier;
    }
    
    public String HierarchyLevel() {
        return parent+"."+hierarchyLevel;
    }

    public String HierarchyLevelName() {
        return parent+"."+hierarchyLevelName;
    }

    public CiResponsibleParty CiResponsibleParty() {
        ciResponsibleParty = new CiResponsibleParty(parent+"."+ParentElement.CONTACT);
        return ciResponsibleParty;
    }
    
    public String DateStamp() {
        return parent+"."+dateStamp;
    }
    
    public String MetadataStandardName() {
        return parent+"."+metadataStandardName;
    }

    public String MetadataStandardVersion() {
        return parent+"."+metadataStandardVersion;
    }

    public String DataSetUri() {
        return parent+"."+dataSetUri;
    }

    public MdSpatialRepresentation MdSpatialRepresentation() {
        mdSpatialRepresentation = new MdSpatialRepresentation(parent+"."+ParentElement.SPATIALREPRESENTATIONINFO);
        return mdSpatialRepresentation;
    }

    public MdReferenceSystem MdReferenceSystem() {
        mdReferenceSystem = new MdReferenceSystem(parent+"."+ParentElement.REFERENCESYSTEMINFO);
        return mdReferenceSystem;
    }

    public MdCoverageDescription MdCoverageDescription() {
        mdCoverageDescription=new MdCoverageDescription(parent+"."+ParentElement.CONTENTINFO);
        return mdCoverageDescription;
    }

    public MdPortrayalCatalogueReference MdPortrayalCatalogueReference() {
        mdPortrayalCatalogueReference=new MdPortrayalCatalogueReference(parent+"."+ParentElement.PORTRAYALCATALOGUEINFO);
        return mdPortrayalCatalogueReference;
    }

    public MdMaintenanceInformation MdMaintenanceInformation() {
        mdMaintenanceInformation=new MdMaintenanceInformation(parent+"."+ParentElement.METADATAMAINTENANCE);
        return mdMaintenanceInformation;
    }

    public MdDataIdentification MdDataIdentification() {
        mdDataIdentification=new MdDataIdentification(parent+"."+ParentElement.IDENTIFICATIONINFO);
        return mdDataIdentification;
    }

    public DqDataQuality DqDataQuality() {
        dqDataQuality = new DqDataQuality(parent+"."+ParentElement.DATAQUALITYINFO);
        return dqDataQuality;
    }

    public MdConstraints MdConstraints() {
        mdConstraints=new MdConstraints(parent+"."+ParentElement.METADATACONSTRAINTS);
        return mdConstraints;
    }    

    public MdApplicationSchemaInformation MdApplicationSchemaInformation() {
        mdApplicationSchemaInformation=new MdApplicationSchemaInformation(parent+"."+ParentElement.APPLICATIONSCHEMAINFO);
        return mdApplicationSchemaInformation;
    }

    public MdExtensionInfo MdExtensionInfo() {
        mdExtensionInfo=new MdExtensionInfo(parent+"."+ParentElement.METADATAEXTENSIONINFO);
        return mdExtensionInfo;
    }

    public MdDistribution MdDistribution() {
        mdDistribution = new MdDistribution(parent+"."+ParentElement.DISTRIBUTIONINFO);
        return mdDistribution;
    }

    public MdSecurityConstraints MdSecurityConstraints() {
        mdSecurityConstraints = new MdSecurityConstraints(parent+"."+ParentElement.METADATACONSTRAINTS);
        return mdSecurityConstraints;
    }
    
    
   
    
    
    
}