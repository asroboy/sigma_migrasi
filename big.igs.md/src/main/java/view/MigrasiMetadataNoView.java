/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.DataConfiguration;
import config.HibernateUtil;
import config.HibernateUtilXml;
import controller.CiAddressController;
import controller.CiAddressDeliveryPointController;
import controller.CiAddressEmailAddressController;
import controller.CiCitationAlternateTitleController;
import controller.CiCitationController;
import controller.CiCitationPresentationFormController;
import controller.CiContactController;
import controller.CiDateController;
import controller.CiDateTypeCodeController;
import controller.CiOnlineFunctionCodeController;
import controller.CiOnlineResourceController;
import controller.CiPresentationFormCodeController;
import controller.CiResponsiblePartyController;
import controller.CiRoleCodeController;
import controller.CiSeriesController;
import controller.CiTelephoneController;
import controller.CiTelephoneFacsimileController;
import controller.CiTelephoneVoiceController;
import controller.DqAbsextposaccController;
import controller.DqAccTimeMeAsController;
import controller.DqComPomController;
import controller.DqCompCommController;
import controller.DqCompletenessController;
import controller.DqConcconsisController;
import controller.DqConformanceResultController;
import controller.DqDataQualityController;
import controller.DqDomconsisController;
import controller.DqElementController;
import controller.DqElementDateTimeController;
import controller.DqElementNameOfMeasureController;
import controller.DqEvaluationMethodTypeCodeController;
import controller.DqFormConsisController;
import controller.DqGridDataPosAccController;
import controller.DqLogicalConsistencyController;
import controller.DqNonQuanAttaccController;
import controller.DqPositionalAccuracyController;
import controller.DqQuanAttacController;
import controller.DqQuantitativeResultController;
import controller.DqQuantitativeResultValueController;
import controller.DqRellntPosAccController;
import controller.DqResultController;
import controller.DqScopeController;
import controller.DqTempConsisController;
import controller.DqTempValidController;
import controller.DqTemporalAccuracyController;
import controller.DqThemClassCorController;
import controller.DqThematicAccuracyController;
import controller.DqTopConsisController;
import controller.DsAssociationTypeCodeController;
import controller.DsInitiativeTypeCodeController;
import controller.ExBoundingPolygonController;
import controller.ExBoundingPolygonPolygonController;
import controller.ExExtentController;
import controller.ExGeographicBoundingBoxController;
import controller.ExGeographicExtentController;
import controller.ExTemporalExtentController;
import controller.ExVerticalExtentController;
import controller.LiLineageController;
import controller.LiProcessStepController;
import controller.LiSourceController;
import controller.MdAggregateInfoController;
import controller.MdApplicationSchemaInfoController;
import controller.MdBrowseGraphicController;
import controller.MdCharacterSetCodeController;
import controller.MdClassificationCodeController;
import controller.MdConstraintsController;
import controller.MdConstraintsUseLimitationController;
import controller.MdContentInfoController;
import controller.MdCoverageContentTypeCodeController;
import controller.MdCoverageDescriptionController;
import controller.MdDataIdentificationCharsetController;
import controller.MdDataIdentificationController;
import controller.MdDataIdentificationLangController;
import controller.MdDataIdentificationSpatrepController;
import controller.MdDataIdentificationTopcatController;
import controller.MdDataTypeCodeController;
import controller.MdDigitalTransferOptionsController;
import controller.MdDistributionController;
import controller.MdDistributorController;
import controller.MdExtendedElementInfoController;
import controller.MdExtendedElementInfoParentController;
import controller.MdFormatController;
import controller.MdGeometricObjectTypeCodeController;
import controller.MdGeometricObjectsController;
import controller.MdIdentificationController;
import controller.MdIdentificationCreditController;
import controller.MdIdentificationStatusController;
import controller.MdIdentifierController;
import controller.MdKeywordController;
import controller.MdKeywordKeywordController;
import controller.MdKeywordTypeCodeController;
import controller.MdLegalConstraintsController;
import controller.MdLegalConstraintsOtherController;
import controller.MdMaintenanceFrequencyCodeController;
import controller.MdMaintenanceInfoController;
import controller.MdMediumController;
import controller.MdMediumNameCodeController;
import controller.MdMetadataController;
import controller.MdMetadataExtensionInfoController;
import controller.MdMetadataHierarchyLvController;
import controller.MdMetadataHierarchyLvNameController;
import controller.MdObligationCodeController;
import controller.MdPortrayalCatalogueRefController;
import controller.MdProgressCodeController;
import controller.MdReferenceSystemController;
import controller.MdRepresentativeFractionController;
import controller.MdResolutionController;
import controller.MdScopecodeController;
import controller.MdSecurityConstraintsController;
import controller.MdSpatialRepresentTypeCodeController;
import controller.MdSpatialRepresentationController;
import controller.MdTopicCategoryCodeController;
import controller.MdTopologyLevelCodeController;
import controller.MdUploadFileController;
import controller.MdVectorSpatialRepresentationController;
import controller.PtLocaleController;
import controller.RsIdentifierController;
import controller.SvServiceIdentificationController;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialClob;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import libraries.xml.XmlReader;
import model.metadata.xml.applicationschemaInfo.MdApplicationSchemaInformation;
import model.metadata.xml.contentinfo.MdCoverageDescription;
import model.metadata.xml.dataquality.DqConformanceResult;
import model.metadata.xml.dataquality.DqDataQuality;
import model.metadata.xml.dataquality.DqQuantitativeResult;
import model.metadata.xml.dataquality.ValueUnit;
import model.metadata.xml.dataquality.lilineage.CiSeries;
import model.metadata.xml.dataquality.lilineage.ExBoundingPolygon;
import model.metadata.xml.dataquality.lilineage.LiLineage;
import model.metadata.xml.dataquality.lilineage.LiProcessStep;
import model.metadata.xml.dataquality.lilineage.LiSource;
import model.metadata.xml.dataquality.lilineage.Polygon;
import model.metadata.xml.dataquality.subelement.DqAbsoluteExternalPositionalAccuracy;
import model.metadata.xml.dataquality.subelement.DqAccuracyOfATimeMeasurement;
import model.metadata.xml.dataquality.subelement.DqCompletenessCommission;
import model.metadata.xml.dataquality.subelement.DqCompletenessOmission;
import model.metadata.xml.dataquality.subelement.DqConceptualConsistency;
import model.metadata.xml.dataquality.subelement.DqDomainConsistency;
import model.metadata.xml.dataquality.subelement.DqFormatConsistency;
import model.metadata.xml.dataquality.subelement.DqGriddedDataPositionalAccuracy;
import model.metadata.xml.dataquality.subelement.DqNonQuantitativeAttributeAccuracy;
import model.metadata.xml.dataquality.subelement.DqQuantitativeAttributeAccuracy;
import model.metadata.xml.dataquality.subelement.DqRelativeInternalPositionalAccuracy;
import model.metadata.xml.dataquality.subelement.DqScope;
import model.metadata.xml.dataquality.subelement.DqTemporalConsistency;
import model.metadata.xml.dataquality.subelement.DqTemporalValidity;
import model.metadata.xml.dataquality.subelement.DqThematicClassificationCorrectness;
import model.metadata.xml.dataquality.subelement.DqTopologicalConsistency;
import model.metadata.xml.distributioninfo.MdDistribution;
import model.metadata.xml.identificationinfo.MdDataIdentification;
import model.metadata.xml.identificationinfo.aggregationInfo.MdAggregateInformation;
import model.metadata.xml.identificationinfo.aggregationInfo.MdIdentifier;
import model.metadata.xml.identificationinfo.descriptivekeywords.MdKeywords;
import model.metadata.xml.identificationinfo.extent.ExGeographicBoundingBox;
import model.metadata.xml.identificationinfo.extent.Extent;
import model.metadata.xml.identificationinfo.graphicoverview.MdBrowseGraphic;
import model.metadata.xml.identificationinfo.resourceformat.MdDigitalTransferOptions;
import model.metadata.xml.identificationinfo.resourceformat.MdDistributor;
import model.metadata.xml.identificationinfo.resourceformat.MdFormat;
import model.metadata.xml.identificationinfo.resourceformat.MdMedium;
import model.metadata.xml.identificationinfo.spatialresolution.MdRepresentativeFraction;
import model.metadata.xml.identificationinfo.spatialresolution.MdResolution;
import model.metadata.xml.metadataconstraints.MdConstraints;
import model.metadata.xml.metadataconstraints.MdLegalConstraints;
import model.metadata.xml.metadataconstraints.MdSecurityConstraints;
import model.metadata.xml.metadataentitysetinformation.CiAddress;
import model.metadata.xml.metadataentitysetinformation.CiOnlineResourceInfo;
import model.metadata.xml.metadataentitysetinformation.CiResponsibleParty;
import model.metadata.xml.metadataentitysetinformation.CiTelephone;
import model.metadata.xml.metadataentitysetinformation.ContactInfo;
import model.metadata.xml.metadataentitysetinformation.MdMetadata;
import model.metadata.xml.metadataextensioninfo.MdExtendedElementInformation;
import model.metadata.xml.metadataextensioninfo.MdExtensionInfo;
import model.metadata.xml.metadatamaintenance.MdMaintenanceInformation;
import model.metadata.xml.portrayalcatalogueInfo.MdPortrayalCatalogueReference;
import model.metadata.xml.referencesystemInfo.CiCitation;
import model.metadata.xml.referencesystemInfo.CiDate;
import model.metadata.xml.referencesystemInfo.MdReferenceSystem;
import model.metadata.xml.referencesystemInfo.RsIdentifier;
import model.metadata.xml.spatialrepresentationInfo.MdGeometricObjects;
import model.metadata.xml.spatialrepresentationInfo.MdSpatialRepresentation;
import model.table.CiAddressDeliveryPointModel;
import model.table.CiAddressEmailAddressModel;
import model.table.CiAddressModel;
import model.table.CiCitationAlternateTitleModel;
import model.table.CiCitationModel;
import model.table.CiCitationPresentationFormModel;
import model.table.CiContactModel;
import model.table.CiDateModel;
import model.table.CiOnlineResourceModel;
import model.table.CiResponsiblePartyModel;
import model.table.CiSeriesModel;
import model.table.CiTelephoneFacsimileModel;
import model.table.CiTelephoneModel;
import model.table.CiTelephoneVoiceModel;
import model.table.DqAbsextposaccModel;
import model.table.DqAccTimeMeAsModel;
import model.table.DqComPomModel;
import model.table.DqCompCommModel;
import model.table.DqCompletenessModel;
import model.table.DqConcconsisModel;
import model.table.DqConformanceResultModel;
import model.table.DqDataQualityModel;
import model.table.DqDomconsisModel;
import model.table.DqElementDateTimeModel;
import model.table.DqElementModel;
import model.table.DqElementNameOfMeasureModel;
import model.table.DqFormConsisModel;
import model.table.DqGridDataPosAccModel;
import model.table.DqLogicalConsistencyModel;
import model.table.DqNonQuanAttaccModel;
import model.table.DqPositionalAccuracyModel;
import model.table.DqQuanAttacModel;
import model.table.DqQuantitativeResultModel;
import model.table.DqQuantitativeResultValueModel;
import model.table.DqRellntPosAccModel;
import model.table.DqResultModel;
import model.table.DqScopeModel;
import model.table.DqTempConsisModel;
import model.table.DqTempValidModel;
import model.table.DqTemporalAccuracyModel;
import model.table.DqThemClassCorModel;
import model.table.DqThematicAccuracyModel;
import model.table.DqTopConsisModel;
import model.table.ExBoundingPolygonModel;
import model.table.ExBoundingPolygonPolygonModel;
import model.table.ExExtentModel;
import model.table.ExGeographicBoundingBoxModel;
import model.table.ExGeographicExtentModel;
import model.table.ExTemporalExtentModel;
import model.table.ExVerticalExtentModel;
import model.table.LiLineageModel;
import model.table.LiProcessStepModel;
import model.table.LiSourceModel;
import model.table.MdAggregateInfoModel;
import model.table.MdApplicationSchemaInfoModel;
import model.table.MdBrowseGraphicModel;
import model.table.MdConstraintsModel;
import model.table.MdConstraintsUselimitationModel;
import model.table.MdContentInfoModel;
import model.table.MdCoverageDescriptionModel;
import model.table.MdDataIdentificationCharsetModel;
import model.table.MdDataIdentificationLangModel;
import model.table.MdDataIdentificationModel;
import model.table.MdDataIdentificationSpatrepModel;
import model.table.MdDataIdentificationTopcatModel;
import model.table.MdDigitalTransferOptionsModel;
import model.table.MdDistributionModel;
import model.table.MdDistributorModel;
import model.table.MdExtendedElementInfoModel;
import model.table.MdExtendedElementInfoParentModel;
import model.table.MdFormatModel;
import model.table.MdGeometricObjectsModel;
import model.table.MdIdentificationCreditModel;
import model.table.MdIdentificationModel;
import model.table.MdIdentificationStatusModel;
import model.table.MdIdentifierModel;
import model.table.MdKeywordKeywordModel;
import model.table.MdKeywordModel;
import model.table.MdLegalConstraintsModel;
import model.table.MdLegalConstraintsOtherModel;
import model.table.MdMaintenanceInfoModel;
import model.table.MdMediumModel;
import model.table.MdMetadataExtensionInfoModel;
import model.table.MdMetadataHierarchylvModel;
import model.table.MdMetadataHierarchylvNameModel;
import model.table.MdMetadataModel;
import model.table.MdPortrayalCatalogueRefModel;
import model.table.MdReferenceSystemModel;
import model.table.MdRepresentativeFractionModel;
import model.table.MdResolutionModel;
import model.table.MdSecurityConstraintsModel;
import model.table.MdSpatialRepresentationModel;
import model.table.MdUploadFileModel;
import model.table.MdVectorSpatialRepresentationModel;
import model.table.RsIdentifierModel;
import model.table.SvServiceIdentificationModel;
import org.hibernate.Session;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import variable.VarApplicationSchemaInformation;
import variable.VarContentInfo;
import variable.DataQuality.*;
import variable.IdentificationInformation.*;
import variable.VarDistributionInformation;
import variable.VarMaintenanceInformation;
import variable.VarMetadataConstraints;
import variable.VarMetadataEntitySetInformation;
import variable.VarMetadataExtensionInformation;
import variable.VarPotrayalCatalogueInformation;
import variable.VarReferenceSystem;
import variable.VarSpatialRepresentationInformation;

/**
 *
 * @author USER DELL
 */
public class MigrasiMetadataNoView extends javax.swing.JFrame {

    /**
     * Creates new form MigrasiMetadataNoView
     */
    // global variable
    private UIManager.LookAndFeelInfo looks[];
    private JFileChooser dialog = new JFileChooser();
    private FileInputStream inputStream = null;

    //elemen metadata identification info
    private VarIdentificationInformation varIdentificationInformation = new VarIdentificationInformation();
    private VarCitation varCitation = new VarCitation();
    private VarPointOfContact varPointOfContact = new VarPointOfContact();
    private VarMdBrowseGraphic varMdBrowseGraphic = new VarMdBrowseGraphic();
    private VarMdFormat varMdFormat = new VarMdFormat();
    private VarDescriptiveKeywords varDescriptiveKeywords = new VarDescriptiveKeywords();
    private VarResourceConstraints varResourceConstraints = new VarResourceConstraints();
    private VarAggregationInfo varAggregationInfo = new VarAggregationInfo();
    private VarSpatialRepresentationType varSpatialRepresentationType = new VarSpatialRepresentationType();
    private VarSpatialResolution varSpatialResolution = new VarSpatialResolution();
    private VarExtent varExtent = new VarExtent();
    private VarContentInfo varContentInfo = new VarContentInfo();
    private VarResourceMaintenance varResourceMaintenance = new VarResourceMaintenance();
       
    //elemen metadata spatial representation info
    private ArrayList<VarSpatialRepresentationInformation> listMdGeometricObject = new ArrayList<>();
    private ArrayList<VarDescriptiveKeywords> listMdKeywordObject = new ArrayList<>();

    //elemen umum
    private int FIRST_ID = 1;
    private String nullValue = "-";
    private HibernateUtil util;
    private ArrayList<DataConfiguration> data;
    private HibernateUtilXml hibernateUtilXml;
    private Session session;
    private int progressMin = 0;
    private int progressMax = 750;
    private String fileName = "";
    private String message = null;

    //elemen data quality
    private VarDqScope varDqScope = new VarDqScope();
    private VarDqCompletenessComission varDqCompletenessComission = new VarDqCompletenessComission();
    private VarDqCompletenessOmission varDqCompletenessOmission = new VarDqCompletenessOmission();
    private VarDqConceptualConsistency varDqConceptualConsistency = new VarDqConceptualConsistency();
    private VarDqDomainConsistency varDqDomainConsistency = new VarDqDomainConsistency();
    private VarDqFormatConsistency varDqFormatConsistency = new VarDqFormatConsistency();
    private VarDqAbsoluteExternalPositionalAccuracy varDqAbsoluteExternalPositionalAccuracy = new VarDqAbsoluteExternalPositionalAccuracy();
    private VarDqGriddedDataPositionalAccuracy varDqGriddedDataPositionalAccuracy = new VarDqGriddedDataPositionalAccuracy();
    private VarDqRelativeInternalPositionalAccuracy varDqRelativeInternalPositionalAccuracy = new VarDqRelativeInternalPositionalAccuracy();
    private VarDqThematicClassificationCorrectness varDqThematicClassificationCorrectness = new VarDqThematicClassificationCorrectness();
    private VarDqNonQuantitativeAttributeAccuracy varDqNonQuantitativeAttributeAccuracy = new VarDqNonQuantitativeAttributeAccuracy();
    private VarDqQuantitativeAttributeAccuracy varDqQuantitativeAttributeAccuracy = new VarDqQuantitativeAttributeAccuracy();
    private VarDqAccuracyOfATimeMeasurement varDqAccuracyOfATimeMeasurement = new VarDqAccuracyOfATimeMeasurement();
    private VarDqTemporalConsistency varDqTemporalConsistency = new VarDqTemporalConsistency();
    private VarDqTemporalValidity varDqTemporalValidity = new VarDqTemporalValidity();
    private VarDqTopologicalConsistency varDqTopologicalConsistency = new VarDqTopologicalConsistency();
    private VarLiLineage varLiLineage = new VarLiLineage();

    //declare set,get every elemen 
    private VarMetadataEntitySetInformation varMetadataEntitySetInformation = new VarMetadataEntitySetInformation();
    private VarMaintenanceInformation varMaintenanceInformation = new VarMaintenanceInformation();
    private VarSpatialRepresentationInformation varSpatialRepresentationInformation = new VarSpatialRepresentationInformation();
    private VarPotrayalCatalogueInformation varPotrayalCatalogueInformation = new VarPotrayalCatalogueInformation();
    private VarMetadataExtensionInformation varMetadataExtensionInformation = new VarMetadataExtensionInformation();
    private VarApplicationSchemaInformation varApplicationSchemaInformation = new VarApplicationSchemaInformation();
    private VarReferenceSystem varReferenceSystem = new VarReferenceSystem();
    private VarMetadataConstraints varMetadataConstraints = new VarMetadataConstraints();
    private VarDistributionInformation varDistributionInformation = new VarDistributionInformation();
    
    String xmlPath = "";
    JTextArea jTextAreaLogData;
    JProgressBar jprocessbar;

    public MigrasiMetadataNoView(JProgressBar jProgressBar1, String path, JTextArea jTextAreaLog, HibernateUtilXml hibernateUtilXml) {
        this.xmlPath = path;
        this.fileName = path;
        this.hibernateUtilXml = hibernateUtilXml;
        session = hibernateUtilXml.buildSession().openSession();
        jTextAreaLogData = jTextAreaLog;
        jprocessbar = jProgressBar1;
        userInterface();

    }

    private void userInterface() {
        setLocationRelativeTo(this);

        jprocessbar.setMinimum(progressMin);
        jprocessbar.setMaximum(progressMax);
    }

    public void setMaxProgressBar(int max) {
        jprocessbar.setMaximum(max);
    }

    public void clearForm() {
        jTextAreaLogData.setText("");
    }

    public void clearFormWithoutIp() {
        jTextAreaLogData.setText("");
    }

    public void getLog(String log) {
        jTextAreaLogData.setText(log);
    }

    //method xml
    
    public void getMetadataEntitySetInformationXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            MdMetadata mdMetadata = new MdMetadata();
            XmlReader xmlReader = new XmlReader();
            //metadata
            varMetadataEntitySetInformation.setFileIdentifier(xmlReader.getNode(document, mdMetadata.FileIdentifier()));
            varMetadataEntitySetInformation.setLanguage(xmlReader.getNode(document, mdMetadata.Language()));
            varMetadataEntitySetInformation.setCharacterSet(xmlReader.getNode(document, mdMetadata.CharacterSet()));
            varMetadataEntitySetInformation.setParentIdentifier(xmlReader.getNode(document, mdMetadata.ParentIdentifier()));
            varMetadataEntitySetInformation.setHierarchyLevel(xmlReader.getNode(document, mdMetadata.HierarchyLevel()));
            varMetadataEntitySetInformation.setHierarchyLevelName(xmlReader.getNode(document, mdMetadata.HierarchyLevelName()));
            //responsibleparty
            CiResponsibleParty ciResponsibleParty = mdMetadata.CiResponsibleParty();
            varMetadataEntitySetInformation.setIndividualName(xmlReader.getNode(document, ciResponsibleParty.IndividualName()));
            varMetadataEntitySetInformation.setOrganisationName(xmlReader.getNode(document, ciResponsibleParty.OrganisationName()));
            varMetadataEntitySetInformation.setPositionName(xmlReader.getNode(document, ciResponsibleParty.PositionName()));
            //contactinfo phone,voice
            ContactInfo contactInfo = ciResponsibleParty.ContactInfo();
            CiTelephone ciTelephone = contactInfo.CiTelephone();
            CiAddress ciAddress = contactInfo.CiAddress();
            varMetadataEntitySetInformation.setVoice(xmlReader.getNode(document, ciTelephone.Voice()));
            varMetadataEntitySetInformation.setFax(xmlReader.getNode(document, ciTelephone.Facsimile()));
            //address
            varMetadataEntitySetInformation.setDeliveryPoint(xmlReader.getNode(document, ciAddress.DeliveryPoint()));
            varMetadataEntitySetInformation.setCity(xmlReader.getNode(document, ciAddress.City()));
            varMetadataEntitySetInformation.setAdministrativeArea(xmlReader.getNode(document, ciAddress.AdministrativeArea()));
            varMetadataEntitySetInformation.setPostalCode(xmlReader.getNode(document, ciAddress.PostalCode()));
            varMetadataEntitySetInformation.setCountry(xmlReader.getNode(document, ciAddress.Country()));
            varMetadataEntitySetInformation.setElectronicMailAddress(xmlReader.getNode(document, ciAddress.ElectronicMailAddress()));
            varMetadataEntitySetInformation.setHoursOfService(xmlReader.getNode(document, contactInfo.HoursOfService()));
            //contactinfo
            varMetadataEntitySetInformation.setContactInstructions(xmlReader.getNode(document, contactInfo.ContactInstructions()));
            varMetadataEntitySetInformation.setRole(xmlReader.getNode(document, ciResponsibleParty.Role()));
            //metadata
            varMetadataEntitySetInformation.setDateStamp(xmlReader.getNode(document, mdMetadata.DateStamp()));
            varMetadataEntitySetInformation.setMetadataStandardName(xmlReader.getNode(document, mdMetadata.MetadataStandardName()));
            varMetadataEntitySetInformation.setMetadataStandardVersion(xmlReader.getNode(document, mdMetadata.MetadataStandardVersion()));
            varMetadataEntitySetInformation.setDataSetURI(xmlReader.getNode(document, mdMetadata.DataSetUri()));
            //online resource
            CiOnlineResourceInfo ciOnlineResourceInfo = contactInfo.CiOnlineResourceInfo();
            varMetadataEntitySetInformation.setLinkage(xmlReader.getNode(document, ciOnlineResourceInfo.Linkage()));
            varMetadataEntitySetInformation.setProtocol(xmlReader.getNode(document, ciOnlineResourceInfo.Protocol()));
            varMetadataEntitySetInformation.setApplicationProfile(xmlReader.getNode(document, ciOnlineResourceInfo.ApplicationProfile()));
            varMetadataEntitySetInformation.setNameOnlineResource(xmlReader.getNode(document, ciOnlineResourceInfo.Name()));
            varMetadataEntitySetInformation.setDescription(xmlReader.getNode(document, ciOnlineResourceInfo.Description()));
            varMetadataEntitySetInformation.setFunction(xmlReader.getNode(document, ciOnlineResourceInfo.Function()));
            
            
            System.out.println("\n#Metadata Entity Set Information#");
            System.out.println("#==============#");
            System.out.println("#MD_Metadata#");
            System.out.println(varMetadataEntitySetInformation.getFileIdentifier());
            System.out.println(varMetadataEntitySetInformation.getLanguage());
            System.out.println(varMetadataEntitySetInformation.getCharacterSet());
            System.out.println(varMetadataEntitySetInformation.getParentIdentifier());
            System.out.println(varMetadataEntitySetInformation.getDateStamp());
            System.out.println(varMetadataEntitySetInformation.getDataSetURI());
            System.out.println(varMetadataEntitySetInformation.getMetadataStandardName());
            System.out.println(varMetadataEntitySetInformation.getMetadataStandardVersion());
            System.out.println("\n#MD_Metadata HierarchyLevel#");
            System.out.println(varMetadataEntitySetInformation.getHierarchyLevel());
            System.out.println("\n#MD_Metadata HierarchyLevelName#");
            System.out.println(varMetadataEntitySetInformation.getHierarchyLevelName());
            System.out.println("\n#CI_ResponsibleParty#");
            System.out.println(varMetadataEntitySetInformation.getIndividualName());
            System.out.println(varMetadataEntitySetInformation.getOrganisationName());
            System.out.println(varMetadataEntitySetInformation.getPositionName());
            System.out.println(varMetadataEntitySetInformation.getRole());
            System.out.println("\n#CI_Contact#");
            System.out.println(varMetadataEntitySetInformation.getHoursOfService());
            System.out.println(varMetadataEntitySetInformation.getContactInstructions());
            System.out.println("\n#CI_Telephone#");
            System.out.println(varMetadataEntitySetInformation.getVoice());
            System.out.println(varMetadataEntitySetInformation.getFax());
            System.out.println("\n#CI_Address#");
            System.out.println(varMetadataEntitySetInformation.getDeliveryPoint());
            System.out.println(varMetadataEntitySetInformation.getCity());
            System.out.println(varMetadataEntitySetInformation.getAdministrativeArea());
            System.out.println(varMetadataEntitySetInformation.getPostalCode());
            System.out.println(varMetadataEntitySetInformation.getCountry());
            System.out.println(varMetadataEntitySetInformation.getElectronicMailAddress());
            System.out.println("\n#CI_OnlineResource#");
            System.out.println(varMetadataEntitySetInformation.getLinkage());
            System.out.println(varMetadataEntitySetInformation.getProtocol());
            System.out.println(varMetadataEntitySetInformation.getApplicationProfile());
            System.out.println(varMetadataEntitySetInformation.getNameOnlineResource());
            System.out.println(varMetadataEntitySetInformation.getDescription());
            System.out.println(varMetadataEntitySetInformation.getFunction());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Entity Set Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Entity Set Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Entity Set Information "+i.toString());
        }
    }
    
    public void getSpatialRepresentationInfoXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdSpatialRepresentation mdSpatialRepresentation = mdMetadata.MdSpatialRepresentation();
            MdGeometricObjects mdGeometricObjects = mdSpatialRepresentation.MdGeometricObjects();
            //md_vectorspatial
            varSpatialRepresentationInformation.setTopologyLevel(xmlReader.getNode(document, mdSpatialRepresentation.TopologyLevel()));

            String[] arrayGeometricObjectType = xmlReader.getNodeLoop(document, mdGeometricObjects.GeometricObjectType());
            String[] arrayGeometricObjectCount = xmlReader.getNodeLoop(document, mdGeometricObjects.GeometricObjectCount());
 
            varSpatialRepresentationInformation.setLength(arrayGeometricObjectCount.length);

            System.out.println("#Metadata Vector Spatial Representation#");
            System.out.println("#==============#");
            System.out.println("\n#Md_VectorSpatialRepresentation#");
            System.out.println(varSpatialRepresentationInformation.getTopologyLevel());
            //md_geometicobject
            for (int i = 0; i < arrayGeometricObjectCount.length; i++) {

                VarSpatialRepresentationInformation information = new VarSpatialRepresentationInformation();
                information.setGeometricObjectType(arrayGeometricObjectType[i]);
                information.setGeometricObjectCount(arrayGeometricObjectCount[i]);
                
                listMdGeometricObject.add(information);

            }

            for (VarSpatialRepresentationInformation list : listMdGeometricObject) {
                System.out.println("\n#Md_GeometricObject#");
                System.out.println(list.getGeometricObjectType());
                System.out.println(list.getGeometricObjectCount());
            }

            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata SpatialRepresentationInformation "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata SpatialRepresentationInformation "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata SpatialRepresentationInformation "+i.toString());
        }
    }

    public void getReferenceSystemInfoXml() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdReferenceSystem mdReferenceSystem = mdMetadata.MdReferenceSystem();
            RsIdentifier rsIdentifier = mdReferenceSystem.RsIdentifier();
            CiCitation ciCitation = rsIdentifier.CiCitation();
            //title
            varReferenceSystem.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            //date
            CiDate ciDate = ciCitation.Date();
            varReferenceSystem.setDate_(xmlReader.getNode(document, ciDate.Date()));
            varReferenceSystem.setDateType(xmlReader.getNode(document, ciDate.DateType()));
            //Rs_identifier
            varReferenceSystem.setCode1(xmlReader.getNode(document, rsIdentifier.Code()));
            varReferenceSystem.setCode2(xmlReader.getNode(document, rsIdentifier.CodeSpace()));

            System.out.println("#Metadata Reference System Info#");
            System.out.println("#==============#");
            System.out.println("\n#Ci_citation#");
            System.out.println(varReferenceSystem.getTitle());
            System.out.println("\n#Ci_date#");
            System.out.println(varReferenceSystem.getDate_());
            System.out.println(varReferenceSystem.getDateType());
            System.out.println("\n#Rs_identifier#");
            System.out.println(varReferenceSystem.getCode1());
            System.out.println(varReferenceSystem.getCode2());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Reference System Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Reference System Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Reference System Information "+i.toString());
        }
    }

    public void getContentInfoXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdCoverageDescription mcd = mdMetadata.MdCoverageDescription();
            //md_coveragedescription
            varContentInfo.setAttributeDescription(xmlReader.getNode(document, mcd.AttributeDescription()));
            varContentInfo.setContentType(xmlReader.getNode(document, mcd.ContentType()));

            System.out.println("#Metadata Content Info#");
            System.out.println("#==============#");
            System.out.println("\n#Md_coverageDescription#");
            System.out.println(varContentInfo.getAttributeDescription());
            System.out.println(varContentInfo.getContentType());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Content Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Content Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Content Information "+i.toString());
        }
    }

    public void getPortrayalCatalogueInfoXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdPortrayalCatalogueReference mpcr = mdMetadata.MdPortrayalCatalogueReference();
            CiCitation cc = mpcr.CiCitation();
            CiDate cd = cc.Date();
            //Ci_citation
            varPotrayalCatalogueInformation.setTitle(xmlReader.getNode(document, cc.Title()));
            //Ci_citation_alternate_title
            varPotrayalCatalogueInformation.setAlternatetitle(xmlReader.getNode(document, cc.AlternateTitle()));
            //ci_date
            varPotrayalCatalogueInformation.setDate_(xmlReader.getNode(document, cd.Date()));
            varPotrayalCatalogueInformation.setDateType(xmlReader.getNode(document, cd.DateType()));
            varPotrayalCatalogueInformation.setEdition(xmlReader.getNode(document, cc.Edition()));
            varPotrayalCatalogueInformation.setEditionDate(xmlReader.getNode(document, cc.EditionDate()));

            System.out.println("#Metadata Portrayal Catalogue Info#");
            System.out.println("#==============#");
            System.out.println("\n#Ci_citation#");
            System.out.println(varPotrayalCatalogueInformation.getTitle());
            System.out.println(varPotrayalCatalogueInformation.getEdition());
            System.out.println(varPotrayalCatalogueInformation.getEditionDate());
            System.out.println("\n#Ci_citationAlternateTitle#");
            System.out.println(varPotrayalCatalogueInformation.getAlternatetitle());
            System.out.println("\n#Ci_date#");
            System.out.println(varPotrayalCatalogueInformation.getDate_());
            System.out.println(varPotrayalCatalogueInformation.getDateType());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Portrayal Catalogue Information "+ex.toString());
            
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Portrayal Catalogue Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Portrayal Catalogue Information "+i.toString());
        }
    }

    public void getMetadataMaintenanceXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdMaintenanceInformation mmi = mdMetadata.MdMaintenanceInformation();
            varMaintenanceInformation.setMaintenanceAndUpdateFrequency(xmlReader.getNode(document, mmi.MaintenanceAndUpdateFrequency()));

            System.out.println("#Metadata Maintenance#");
            System.out.println("#==============#");
            System.out.println("\n#md_metadataMaintenance#");
            System.out.println(varMaintenanceInformation.getMaintenanceAndUpdateFrequency());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Maintenance Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Maintenance Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Maintenance Information "+i.toString());
        }
    }

    public void getIdentificationInfoXml(){

        try {
           
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdDataIdentification mdi = mdMetadata.MdDataIdentification();
            CiCitation cc = mdi.CiCitation();
            //md_dataidentification
            varIdentificationInformation.setAbstract_(xmlReader.getNode(document, mdi.abstract_()));
            varIdentificationInformation.setStatus(xmlReader.getNode(document, mdi.status()));
            varIdentificationInformation.setSupplementallnformation(xmlReader.getNode(document, mdi.SupplementalInformation()));
            //md_dataidentification_spatrep
            varSpatialRepresentationType.setMD_SpatialRepresentationTypeCode(xmlReader.getNode(document, mdi.SpatialRepresentationType()));
            //md_dataidentification_lang
            varIdentificationInformation.setLanguage(xmlReader.getNode(document, mdi.Language()));
            //md_dataidentification_characterset
            varIdentificationInformation.setCharacterSet(xmlReader.getNode(document, mdi.CharacterSet()));
            //md_dataidentification_topcat
            varIdentificationInformation.setTopicCategory(xmlReader.getNode(document, mdi.TopicCategory()));
            varIdentificationInformation.setEnvironmentDescription(xmlReader.getNode(document, mdi.EnvironmentDescription()));
            varIdentificationInformation.setPurpose(xmlReader.getNode(document, mdi.Purpose()));
            varIdentificationInformation.setCredit(xmlReader.getNode(document, mdi.Credit()));
            //citation_elemen
            //citation  
            varCitation.setTitle(xmlReader.getNode(document, cc.Title()));
            varCitation.setEdition(xmlReader.getNode(document, cc.Edition()));
            varCitation.setOtherCitationDetails(xmlReader.getNode(document, cc.OtherCitationDetails()));
            varCitation.setPresentationForm(xmlReader.getNode(document, cc.PresentationForm()));
            //citation_alternate_title
            varCitation.setAlternateTitle(xmlReader.getNode(document, cc.AlternateTitle()));
            //ci_date
            CiDate cd = cc.Date();
            varCitation.setDate(xmlReader.getNode(document, cd.Date()));
            varCitation.setDateType(xmlReader.getNode(document, cd.DateType()));
            //rs_identifier
            RsIdentifier ri = cc.RsIdentifier();
            varCitation.setCode(xmlReader.getNode(document, ri.Code()));
            //citationIdentifier
            CiCitation citation = ri.CiCitation();
            CiDate ciDate = citation.Date();
            varCitation.setTitleCitationIdentifier(xmlReader.getNode(document,  citation.Title()));
            //citationdate
            varCitation.setDateCiDateIdentifier(xmlReader.getNode(document, ciDate.Date()));
            varCitation.setDateTypeCiDateIdentifier(xmlReader.getNode(document, ciDate.DateType()));
            
            CiResponsibleParty crpCit = cc.CiResponsibleParty();
            varCitation.setIndividualName(xmlReader.getNode(document, crpCit.IndividualName()));
            varCitation.setOrganisationName(xmlReader.getNode(document, crpCit.OrganisationName()));
            varCitation.setPositionName(xmlReader.getNode(document, crpCit.PositionName()));
            varCitation.setRole(xmlReader.getNode(document, crpCit.Role()));

            //end citation_elemen
            //pointofcontact elemen
            //ci_responsibleparty
            CiResponsibleParty party = mdi.CiResponsibleParty();
            varPointOfContact.setIndividualName(xmlReader.getNode(document, party.IndividualName()));
            varPointOfContact.setOrganisationName(xmlReader.getNode(document, party.OrganisationName()));
            varPointOfContact.setPositionName(xmlReader.getNode(document, party.PositionName()));
            varPointOfContact.setRole(xmlReader.getNode(document, party.Role()));
            //ci_contactinfo
            ContactInfo ci = party.ContactInfo();
            CiTelephone ct = ci.CiTelephone();
            CiAddress ca = ci.CiAddress();
            varPointOfContact.setHoursOfService(xmlReader.getNode(document, ci.HoursOfService()));
            varPointOfContact.setContactInstructions(xmlReader.getNode(document, ci.ContactInstructions()));
            //ci_telephonevoice
            varPointOfContact.setVoice(xmlReader.getNode(document, ct.Voice()));
            //ci_telephonefacs
            varPointOfContact.setFax(xmlReader.getNode(document, ct.Facsimile()));
            //ci_address
            varPointOfContact.setDeliveryPoint(xmlReader.getNode(document, ca.DeliveryPoint()));
            varPointOfContact.setCity(xmlReader.getNode(document, ca.City()));
            varPointOfContact.setAdministrativeArea(xmlReader.getNode(document, ca.AdministrativeArea()));
            varPointOfContact.setPostalCode(xmlReader.getNode(document, ca.PostalCode()));
            varPointOfContact.setCountry(xmlReader.getNode(document, ca.Country()));
            varPointOfContact.setElectronicMailAddress(xmlReader.getNode(document, ca.ElectronicMailAddress()));
            //ci_onlineResource
            CiOnlineResourceInfo cori = ci.CiOnlineResourceInfo();
            varPointOfContact.setLinkage(xmlReader.getNode(document, cori.Linkage()));
            //end elemen point of conctact
            //md_maintenanceinformation
            MdMaintenanceInformation mmi = mdi.MdMaintenanceInformation();
            varResourceMaintenance.setMaintenanceAndUpdateFrequency(xmlReader.getNode(document, mmi.MaintenanceAndUpdateFrequency()));
            //end md_maintenanceinformation
            //md_browseGraphic// 
            MdBrowseGraphic mbg = mdi.MdBrowseGraphic();
            varMdBrowseGraphic.setFileName(xmlReader.getNode(document, mbg.FileName()));
            varMdBrowseGraphic.setFileType(xmlReader.getNode(document, mbg.FileType()));
            //end md_browseGraphic
            //resourceFormat
            //md_format 
            MdFormat mf = mdi.MdFormat();
            varMdFormat.setName(xmlReader.getNode(document, mf.Name()));
            varMdFormat.setVersion(xmlReader.getNode(document, mf.Version()));
            varMdFormat.setSpesification(xmlReader.getNode(document, mf.Specification()));
            //md_distributor
            MdDistributor md = mf.MdDistributor();
            CiResponsibleParty crp = md.CiResponsibleParty();
            varMdFormat.setDistributorFormat(xmlReader.getNode(document, md.DistributorFormat()));
            //ci_responsibleparty
            varMdFormat.setIndividualName(xmlReader.getNode(document, crp.IndividualName()));
            varMdFormat.setOrganisationName(xmlReader.getNode(document, crp.OrganisationName()));
            varMdFormat.setPositionName(xmlReader.getNode(document, crp.PositionName()));
            varMdFormat.setRole(xmlReader.getNode(document, crp.Role()));
            //ci_contact
            //ci_onlineResource_distributor_contact_element
            ContactInfo info = crp.ContactInfo();
            CiOnlineResourceInfo resourceInfo = info.CiOnlineResourceInfo();
            varMdFormat.setLinkage(xmlReader.getNode(document, resourceInfo.Linkage()));
            //ci_onlineResource
            MdDigitalTransferOptions mdto = md.MdDigitalTransferOptions();
            CiOnlineResourceInfo onlineResourceInfo = mdto.CiOnlineResourceInfo();
            varMdFormat.setOnlineLinkage(xmlReader.getNode(document, onlineResourceInfo.Linkage()));
            varMdFormat.setFunction(xmlReader.getNode(document, onlineResourceInfo.Function()));
            //md_medium
            MdMedium mm = mdto.MdMedium();
            varMdFormat.setNameDigitalTransferOption(xmlReader.getNode(document, mm.Name()));
            varMdFormat.setDensityUnits(xmlReader.getNode(document, mm.DensityUnits()));
            //end resourceformat
            //md_keywords
            MdKeywords mk = mdi.MdKeywords();
            String arrayKeyword[] = xmlReader.getNodeLoop(document, mk.Keyword());
            String arrayType[] = xmlReader.getNodeLoop(document, mk.Type());
            //ci_citation
            CiCitation ciCitation = mk.CiCitation();
            String title[] =xmlReader.getNodeLoop(document, ciCitation.Title());
            //ci_date
            CiDate cdThesaurusName = ciCitation.Date();
            String date[] = xmlReader.getNodeLoop(document, cdThesaurusName.Date());
            String dateType[] = xmlReader.getNodeLoop(document, cdThesaurusName.DateType());
            //md_identifier 
            RsIdentifier identifier = ciCitation.RsIdentifier();
            varDescriptiveKeywords.setCode(xmlReader.getNode(document,identifier.Code()));
            CiCitation citationRsIdentifier = identifier.CiCitation();
            varDescriptiveKeywords.setTitle(xmlReader.getNode(document,citationRsIdentifier.Title()));
            //ci_citation
            CiDate ciDateRsIdentifier = citationRsIdentifier.Date();
            varDescriptiveKeywords.setDate(xmlReader.getNode(document,ciDateRsIdentifier.Date()));
            varDescriptiveKeywords.setDateType(xmlReader.getNode(document,ciDateRsIdentifier.DateType()));
            //ci_date
            //keyword
            for (int i = 0; i < arrayKeyword.length; i++) {

                VarDescriptiveKeywords keywords = new VarDescriptiveKeywords();
                //md_keyword
                keywords.setKeyword(arrayKeyword[i]);
                keywords.setType(arrayType[i]);
                //citation
                if(title.length > 1){
                    
                    //citation
                    keywords.setTitle(title[i]);
                    //date
                    keywords.setDate(date[i]);
                    keywords.setDateType(dateType[i]);
                    keywords.setLengthTitle(String.valueOf(title.length));

                }else if(title.length ==1 && i==0){
                    
                    //citation
                    keywords.setTitle(title[i]);
                    //date
                    keywords.setDate(date[i]);
                    keywords.setDateType(dateType[i]);
                    keywords.setLengthTitle(String.valueOf(title.length));
                     
                }
                
                listMdKeywordObject.add(keywords);

            }
            
            
            System.out.println("citation title"+title.length);
            //end md_keywords
            //md_constraints
            MdConstraints mc = mdi.MdConstraints();
            varResourceConstraints.setUseLimitation(xmlReader.getNode(document, mc.UseLimitation()));
            
            //security contraints
            MdSecurityConstraints msc = mdi.MdSecurityConstraints();
            varResourceConstraints.setClassification(xmlReader.getNode(document, msc.Classification()));
            varResourceConstraints.setClassificationSystem(xmlReader.getNode(document, msc.ClassificationSystem()));
            varResourceConstraints.setUserNote(xmlReader.getNode(document, msc.UserNote()));
                        
            //legall constraints
            MdLegalConstraints mlc = mdi.MdLegalConstraints();
            varResourceConstraints.setOtherConstraints(xmlReader.getNode(document, mlc.OtherConstraints()));
            
             //end md_constraints
            //md_aggregationInfo 
            MdAggregateInformation mai = mdi.MdAggregateInformation();
            varAggregationInfo.setDS_AssociationTypeCode(xmlReader.getNode(document, mai.AssociationType()));
            varAggregationInfo.setDS_InitiativeTypeCode(xmlReader.getNode(document, mai.InitiativeType()));
            //citation
            CiCitation cit = mai.CiCitation();
            varAggregationInfo.setTitle(xmlReader.getNode(document, cit.Title()));
            //ci_date
            CiDate cdDate = cit.Date();
            varAggregationInfo.setDate(xmlReader.getNode(document, cdDate.Date()));
            varAggregationInfo.setDateType(xmlReader.getNode(document, cdDate.DateType()));
            //md_identifier
            MdIdentifier mi = mai.MdIdentifier();
            varAggregationInfo.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation citationIdentifier = mi.CiCitation();
            varAggregationInfo.setTitleIdentifier(xmlReader.getNode(document, citationIdentifier.Title()));
             //ci_date 
            CiDate ciDateIdentifier = citationIdentifier.Date();
            varAggregationInfo.setDateIdentifier(xmlReader.getNode(document, ciDateIdentifier.Date()));
            varAggregationInfo.setDateTypeIdentifier(xmlReader.getNode(document, ciDateIdentifier.DateType()));
            //end md_aggregationinfo
            //md_resolution
            MdResolution mr = mdi.MdResolution();
            MdRepresentativeFraction mrf = mr.MdRepresentativeFraction();
            varSpatialResolution.setDenominator(xmlReader.getNode(document, mrf.Denominator()));
            //end md_resolution
            //ex_extent 
            Extent extent = mdi.Extent();
            varExtent.setDescription(xmlReader.getNode(document, extent.Description()));
            //ex_geographicextent
            ExGeographicBoundingBox box = extent.ExGeographicBoundingBox();
            varExtent.setExtentTypeCode(xmlReader.getNode(document, box.ExtentTypeCode()));
            varExtent.setWestBoundLongitude(xmlReader.getNode(document, box.WestBoundLongitude()));
            varExtent.setEastBoundLongitude(xmlReader.getNode(document, box.EastBoundLongitude()));
            varExtent.setSouthBoundLatitude(xmlReader.getNode(document, box.SouthBoundLatitude()));
            varExtent.setNorthBoundLatitude(xmlReader.getNode(document, box.NorthBoundLatitude()));
            //ex_temporal_element
            varExtent.setTemporalElement(xmlReader.getNode(document, extent.TemporalElement()));
            //ex_vertical_element
            varExtent.setVerticalElement(xmlReader.getNode(document, extent.VerticalElement()));

            System.out.println("#Metadata identification Info#");
            System.out.println("#==============#");
            System.out.println("#Elemen Citation#");
            System.out.println("\n#Elemen Md_identification#");
            System.out.println(varIdentificationInformation.getAbstract_());
            System.out.println(varIdentificationInformation.getStatus());
            System.out.println(varIdentificationInformation.getPurpose());
            System.out.println(varIdentificationInformation.getCredit());
            System.out.println(varIdentificationInformation.getEnvironmentDescription());
            System.out.println(varIdentificationInformation.getSupplementallnformation());
            System.out.println(varIdentificationInformation.getLanguage());
            System.out.println(varIdentificationInformation.getCharacterSet());
            System.out.println(varIdentificationInformation.getTopicCategory());
            System.out.println(varSpatialRepresentationType.getMD_SpatialRepresentationTypeCode());
            System.out.println("\n#Citation#");
            System.out.println(varCitation.getTitle());
            System.out.println(varCitation.getEdition());
            System.out.println(varCitation.getOtherCitationDetails());
            System.out.println(varCitation.getPresentationForm());
            System.out.println("\n#CitationAlternatetitle#");
            System.out.println(varCitation.getAlternateTitle());
            System.out.println("\n#CitationDate#");
            System.out.println(varCitation.getDate());
            System.out.println(varCitation.getDateType());
            System.out.println("\n#RsIdentifier#");
            System.out.println(varCitation.getCode());
            System.out.println("\n#Citation#");
            System.out.println(varCitation.getTitleCitationIdentifier());
            System.out.println("\n#CitationDate#");
            System.out.println(varCitation.getDateCiDateIdentifier());
            System.out.println(varCitation.getDateTypeCiDateIdentifier());
            System.out.println("\n#responsibleparty citation#");
            System.out.println(varCitation.getIndividualName());
            System.out.println(varCitation.getOrganisationName());
            System.out.println(varCitation.getPositionName());
            System.out.println(varCitation.getRole());
            System.out.println("\n#pointofcontact#");
            System.out.println("\n#responsibleparty#");
            System.out.println(varPointOfContact.getIndividualName());
            System.out.println(varPointOfContact.getOrganisationName());
            System.out.println(varPointOfContact.getPositionName());
            System.out.println(varPointOfContact.getRole());
            System.out.println("\n#contactinfo#");
            System.out.println(varPointOfContact.getHoursOfService());
            System.out.println(varPointOfContact.getContactInstructions());
            System.out.println("\n#voice#");          
            System.out.println(varPointOfContact.getVoice());
            System.out.println("\n#Fax#");
            System.out.println(varPointOfContact.getFax());
            System.out.println("\n#Address#");
            System.out.println(varPointOfContact.getDeliveryPoint());
            System.out.println(varPointOfContact.getCity());
            System.out.println(varPointOfContact.getAdministrativeArea());
            System.out.println(varPointOfContact.getPostalCode());
            System.out.println(varPointOfContact.getCountry());
            System.out.println(varPointOfContact.getElectronicMailAddress());
            System.out.println("\n#OnlineResource#");
            System.out.println(varPointOfContact.getLinkage());
            System.out.println("\n#ResourceMaintenance#");
            System.out.println(varResourceMaintenance.getMaintenanceAndUpdateFrequency());
            System.out.println("\n#MdBrowserGraphic#");
            System.out.println(varMdBrowseGraphic.getFileName());
            System.out.println(varMdBrowseGraphic.getFileType());
            System.out.println("\n#MdFormat#");
            System.out.println(varMdFormat.getName());
            System.out.println(varMdFormat.getVersion());
            System.out.println(varMdFormat.getSpesification());
            System.out.println("\n#MdDistributor#");
            System.out.println(varMdFormat.getDistributorFormat());
            System.out.println("\n#Responsibleparty#");
            System.out.println(varMdFormat.getIndividualName());
            System.out.println(varMdFormat.getOrganisationName());
            System.out.println(varMdFormat.getPositionName());
            System.out.println(varMdFormat.getRole());
            System.out.println("\n#OnlineResource#");
            System.out.println(varMdFormat.getLinkage());
            System.out.println("\n#DistributorTransferOption#");
            System.out.println(varMdFormat.getOnlineLinkage());
            System.out.println(varMdFormat.getFunction());
            System.out.println("\n#Md_Medium#");
            System.out.println(varMdFormat.getNameDigitalTransferOption());
            System.out.println(varMdFormat.getDensityUnits());
            System.out.println("\n#Md_constraints#");
            System.out.println(varResourceConstraints.getUseLimitation());
            System.out.println("\n#Md_Securityconstraints#");
            System.out.println(varResourceConstraints.getClassification());
            System.out.println(varResourceConstraints.getClassificationSystem());
            System.out.println(varResourceConstraints.getUserNote());
            System.out.println("\n#Md_Legalconstraints#");
            System.out.println(varResourceConstraints.getOtherConstraints());
            System.out.println("\n#Md_aggregationInfo#");
            System.out.println(varAggregationInfo.getAggregateDataSetIdentifier());
            System.out.println(varAggregationInfo.getDS_AssociationTypeCode());
            System.out.println(varAggregationInfo.getDS_InitiativeTypeCode());
            System.out.println("\n#Ci_citation#");
            System.out.println(varAggregationInfo.getTitle());
            System.out.println("\n#CI_date#");
            System.out.println(varAggregationInfo.getDate());
            System.out.println(varAggregationInfo.getDateType());
            System.out.println("\n#Md_identifier#");
            System.out.println(varAggregationInfo.getCode());
            System.out.println("\n#Ci_citation#");
            System.out.println(varAggregationInfo.getTitleIdentifier());
            System.out.println("\n#CI_date#");
            System.out.println(varAggregationInfo.getDateIdentifier());
            System.out.println(varAggregationInfo.getDateTypeIdentifier());
            System.out.println("\n#Md_keyword#");
            
            for (VarDescriptiveKeywords list : listMdKeywordObject) {

               
                System.out.println(list.getKeyword());
                System.out.println(list.getType());
                System.out.println(list.getTitle());
                System.out.println(list.getDate());
                System.out.println(list.getDateType());
                System.out.println("----------");
            }
            
            System.out.println("\n#Citation#");
            System.out.println(varDescriptiveKeywords.getTitle());
            System.out.println("\n#CI_date#");
            System.out.println(varDescriptiveKeywords.getDate());
            System.out.println(varDescriptiveKeywords.getDateType());
            System.out.println("\n#Md_identifier#");
            System.out.println(varDescriptiveKeywords.getCode());      
            System.out.println("\n#Md_resolution#");
            System.out.println(varSpatialResolution.getDenominator());
            System.out.println("\n#Ex_extent#");
            System.out.println(varExtent.getDescription());
            System.out.println(varExtent.getExtentTypeCode());
            System.out.println(varExtent.getWestBoundLongitude());
            System.out.println(varExtent.getEastBoundLongitude());
            System.out.println(varExtent.getSouthBoundLatitude());
            System.out.println(varExtent.getNorthBoundLatitude());
            System.out.println("\n#Ex_extent_temporal#");
            System.out.println(varExtent.getTemporalElement());
            System.out.println("\n#Ex_extent_vertical#");
            System.out.println(varExtent.getVerticalElement());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Identification Information "+ex.toString());
        } catch(ArrayIndexOutOfBoundsException ae){
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ae);
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Identification Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Identification Information "+i.toString());
        }
    }
    
    public void getMetadataConstraintsInfoXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            
            MdConstraints mc = mdMetadata.MdConstraints();
            varMetadataConstraints.setUseLimitation(xmlReader.getNode(document, mc.UseLimitation()));
            
            MdSecurityConstraints msc = mdMetadata.MdSecurityConstraints();
            varMetadataConstraints.setClassification(xmlReader.getNode(document, msc.Classification()));
            varMetadataConstraints.setClassificationSystem(xmlReader.getNode(document, msc.ClassificationSystem()));
            varMetadataConstraints.setUserNote(xmlReader.getNode(document, msc.UserNote()));

            System.out.println("#Metadata Constraints#");
            System.out.println("#==============#");
            System.out.println(varMetadataConstraints.getUseLimitation());
            System.out.println(varMetadataConstraints.getClassification());
            System.out.println(varMetadataConstraints.getClassificationSystem());
            System.out.println(varMetadataConstraints.getUserNote());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Constraints Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Constraints Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Constraints Information "+i.toString());
        }
    }
    
    public void getApplicationSchemaInfoXml() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdApplicationSchemaInformation masi = mdMetadata.MdApplicationSchemaInformation();
            
            varApplicationSchemaInformation.setSchemaLanguage(xmlReader.getNode(document,masi.SchemaLanguage()));
            varApplicationSchemaInformation.setConstraintLanguage(xmlReader.getNode(document,masi.ConstraintLanguage()));
            
            CiCitation cc = masi.CiCitation();
            varApplicationSchemaInformation.setTitle(xmlReader.getNode(document,cc.Title()));
            CiDate cd = cc.Date();
            varApplicationSchemaInformation.setDate_(xmlReader.getNode(document,cd.Date()));
            varApplicationSchemaInformation.setDateType(xmlReader.getNode(document,cd.DateType()));
           
            System.out.println("#Metadata ApplicationSchemaInformation#");
            System.out.println("#==============#");
            System.out.println(varApplicationSchemaInformation.getSchemaLanguage());
            System.out.println(varApplicationSchemaInformation.getConstraintLanguage());
            System.out.println(varApplicationSchemaInformation.getTitle());
            System.out.println(varApplicationSchemaInformation.getDate_());
            System.out.println(varApplicationSchemaInformation.getDateType());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Application Schema Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Application Schema Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Application Schema Information "+i.toString());
        }
    }
    
    public void getDistributionInfoXml() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            
            MdDistribution md = mdMetadata.MdDistribution();   
            varDistributionInformation.setDistributorFormat(xmlReader.getNode(document, md.DistributorFormat()));
            
            MdDistributor mdr = md.MdDistributor();
            varDistributionInformation.setDistributorFormatMdr(xmlReader.getNode(document, mdr.DistributorFormat()));
            
            CiResponsibleParty party = mdr.CiResponsibleParty();
            varDistributionInformation.setIndividualName(xmlReader.getNode(document, party.IndividualName()));
            varDistributionInformation.setOrganisationName(xmlReader.getNode(document, party.OrganisationName()));
            varDistributionInformation.setPositionName(xmlReader.getNode(document, party.PositionName()));
            varDistributionInformation.setRole(xmlReader.getNode(document, party.Role()));
           
            //contactinfo phone,voice
            ContactInfo contactInfo = party.ContactInfo();
            CiTelephone ciTelephone = contactInfo.CiTelephone();
            CiAddress ciAddress = contactInfo.CiAddress();
            varDistributionInformation.setVoice(xmlReader.getNode(document, ciTelephone.Voice()));
            varDistributionInformation.setFax(xmlReader.getNode(document, ciTelephone.Facsimile()));
            
            //address
            varDistributionInformation.setDeliveryPoint(xmlReader.getNode(document, ciAddress.DeliveryPoint()));
            varDistributionInformation.setCity(xmlReader.getNode(document, ciAddress.City()));
            varDistributionInformation.setAdministrativeArea(xmlReader.getNode(document, ciAddress.AdministrativeArea()));
            varDistributionInformation.setPostalCode(xmlReader.getNode(document, ciAddress.PostalCode()));
            varDistributionInformation.setCountry(xmlReader.getNode(document, ciAddress.Country()));
            varDistributionInformation.setElectronicMailAddress(xmlReader.getNode(document, ciAddress.ElectronicMailAddress()));
            varDistributionInformation.setHoursOfService(xmlReader.getNode(document, contactInfo.HoursOfService()));
            
            //contactinfo
            varDistributionInformation.setContactInstructions(xmlReader.getNode(document, contactInfo.ContactInstructions()));
            varDistributionInformation.setHoursOfService(xmlReader.getNode(document, contactInfo.HoursOfService()));
            varDistributionInformation.setRole(xmlReader.getNode(document, party.Role()));

            //online resource
            CiOnlineResourceInfo ciOnlineResourceInfo = contactInfo.CiOnlineResourceInfo();
            varDistributionInformation.setLinkage(xmlReader.getNode(document, ciOnlineResourceInfo.Linkage()));
            varDistributionInformation.setProtocol(xmlReader.getNode(document, ciOnlineResourceInfo.Protocol()));
            varDistributionInformation.setApplicationProfile(xmlReader.getNode(document, ciOnlineResourceInfo.ApplicationProfile()));
            varDistributionInformation.setNameOnlineResource(xmlReader.getNode(document, ciOnlineResourceInfo.Name()));
            varDistributionInformation.setDescription(xmlReader.getNode(document, ciOnlineResourceInfo.Description()));
            varDistributionInformation.setFunction(xmlReader.getNode(document, ciOnlineResourceInfo.Function()));
                    
            MdDigitalTransferOptions mdto = md.MdDigitalTransferOptions();
            varDistributionInformation.setTransferSize(xmlReader.getNode(document, mdto.TransferSize()));
           
            System.out.println("#Metadata DistributionInformation#");
            System.out.println("#==============#");
            System.out.println("\n#mddistributor#");
            System.out.println(varDistributionInformation.getDistributorFormat());
            System.out.println(varDistributionInformation.getDistributorFormatMdr());
            System.out.println("\n#responsibleparty#");
            System.out.println(varDistributionInformation.getIndividualName());
            System.out.println(varDistributionInformation.getOrganisationName());
            System.out.println(varDistributionInformation.getPositionName());
            System.out.println(varDistributionInformation.getRole());
            System.out.println("\n#contactinfo#");
            System.out.println(varDistributionInformation.getHoursOfService());
            System.out.println(varDistributionInformation.getContactInstructions());
            System.out.println("\n#voice#");          
            System.out.println(varDistributionInformation.getVoice());
            System.out.println("\n#Fax#");
            System.out.println(varDistributionInformation.getFax());
            System.out.println("\n#Address#");
            System.out.println(varDistributionInformation.getDeliveryPoint());
            System.out.println(varDistributionInformation.getCity());
            System.out.println(varDistributionInformation.getAdministrativeArea());
            System.out.println(varDistributionInformation.getPostalCode());
            System.out.println(varDistributionInformation.getCountry());
            System.out.println(varDistributionInformation.getElectronicMailAddress());
            System.out.println("\n#OnlineResource#");
            System.out.println(varDistributionInformation.getLinkage());
            System.out.println(varDistributionInformation.getProtocol());
            System.out.println(varDistributionInformation.getApplicationProfile());
            System.out.println(varDistributionInformation.getNameOnlineResource());
            System.out.println(varDistributionInformation.getDescription());
            System.out.println(varDistributionInformation.getFunction());
            System.out.println("\n#mdDigitaltransferoption#");
            System.out.println(varDistributionInformation.getTransferSize());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Distribution Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Distribution Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Distribution Information "+i.toString());
        }
    }
    
    public void getMdExtensionInfoXml(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdExtensionInfo mdExtensionInfo = mdMetadata.MdExtensionInfo();
            CiOnlineResourceInfo ciOnlineResourceInfo = mdExtensionInfo.CiOnlineResourceInfo();
            //ExtensionOnLineResource
            varMetadataExtensionInformation.setLinkage(xmlReader.getNode(document, ciOnlineResourceInfo.Linkage()));
            
            //ExtendedElementinfo
            MdExtendedElementInformation meei = mdExtensionInfo.MdExtendedElementInformation();
            varMetadataExtensionInformation.setName(xmlReader.getNode(document, meei.Name()));
            varMetadataExtensionInformation.setShortName(xmlReader.getNode(document, meei.ShortName()));
            varMetadataExtensionInformation.setDomainCode(xmlReader.getNode(document, meei.DomainCode()));
            varMetadataExtensionInformation.setDefinition(xmlReader.getNode(document, meei.Definition()));
            varMetadataExtensionInformation.setObligation(xmlReader.getNode(document, meei.Obligation()));
            varMetadataExtensionInformation.setCondition(xmlReader.getNode(document, meei.Condition()));
            varMetadataExtensionInformation.setDataType(xmlReader.getNode(document, meei.DataType()));
            varMetadataExtensionInformation.setMaximumOccurrence(xmlReader.getNode(document, meei.MaximumOccurance()));
            varMetadataExtensionInformation.setDomainValue(xmlReader.getNode(document, meei.DomainValue()));
            varMetadataExtensionInformation.setParentEntity(xmlReader.getNode(document, meei.ParentEntity()));
            varMetadataExtensionInformation.setRule(xmlReader.getNode(document, meei.Rule()));
           
            CiResponsibleParty party = meei.CiResponsibleParty();
            varMetadataExtensionInformation.setIndividualName(xmlReader.getNode(document, party.IndividualName()));
            varMetadataExtensionInformation.setOrganisationName(xmlReader.getNode(document, party.OrganisationName()));
            varMetadataExtensionInformation.setPositionName(xmlReader.getNode(document, party.PositionName()));
            varMetadataExtensionInformation.setRole(xmlReader.getNode(document, party.Role()));
            
            ContactInfo ci = party.ContactInfo();
            CiOnlineResourceInfo cori = ci.CiOnlineResourceInfo();
            varMetadataExtensionInformation.setLinkageSource(xmlReader.getNode(document, cori.Linkage()));
                       
            System.out.println("#Metadata MetadataExtensionInformation#");
            System.out.println("#==============#");
            System.out.println(varMetadataExtensionInformation.getLinkage());
            System.out.println(varMetadataExtensionInformation.getName());
            System.out.println(varMetadataExtensionInformation.getShortName());
            System.out.println(varMetadataExtensionInformation.getDomainCode());
            System.out.println(varMetadataExtensionInformation.getDefinition());
            System.out.println(varMetadataExtensionInformation.getObligation());
            System.out.println(varMetadataExtensionInformation.getCondition());
            System.out.println(varMetadataExtensionInformation.getDataType());
            System.out.println(varMetadataExtensionInformation.getMaximumOccurrence());
            System.out.println(varMetadataExtensionInformation.getDomainValue());
            System.out.println(varMetadataExtensionInformation.getParentEntity());
            System.out.println(varMetadataExtensionInformation.getRule());
            System.out.println(varMetadataExtensionInformation.getIndividualName());
            System.out.println(varMetadataExtensionInformation.getOrganisationName());
            System.out.println(varMetadataExtensionInformation.getPositionName());
            System.out.println(varMetadataExtensionInformation.getRole());
            System.out.println(varMetadataExtensionInformation.getLinkageSource());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata Extension Information "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata Extension Information "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata Extension Information "+i.toString());
        }
    }
  
    //elemen MetadataDataQuality
    public void getDataQualityInfoXml(){

        try {

            getDataDqScope();
            getDataDqCompletenessCommission();
            getDataDqCompletenessOmission();
            getDataDqConceptualConsistency();
            getDataDqDomainConsistency();
            getDataDqFormatConsistency();
            getDataDqTopologicalConsistency();
            getDataDqAbsoluteExternalPositionalAccuracy();
            getDataDqGriddedDataPositionalAccuracy();
            getDataDqRelativeInternalPositionalAccuracy();
            getDataDqThematicClassificationCorrectness();
            getDataDqNonQuantitativeAttributeAccuracy();
            getDataDqQuantitativeAttributeAccuracy();
            getDataDqAccuracyOfATimeMeasurement();
            getDataDqTemporalConsistency();
            getDataDqTemporalValidity();
            getDataLiLineage();

      
        } catch (NullPointerException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqDataquality "+ex.toString());
        }

    }

    public void getDataDqScope() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();

            DqScope dqScope = dqDataQuality.DqScope();
            varDqScope.setLevel(xmlReader.getNode(document, dqScope.Level()));
            varDqScope.setLevelDescription(xmlReader.getNode(document, dqScope.LevelDescription()));
            
            System.out.println("#Dq Scope#");
            System.out.println("#==============#");
            System.out.println(varDqScope.getLevel());
            System.out.println(varDqScope.getLevelDescription());
            System.out.println(varDqScope.getExtentTypeCode());
            System.out.println(varDqScope.getWestBoundLongitude());
            System.out.println(varDqScope.getEastBoundLongitude());
            System.out.println(varDqScope.getSouthBoundLatitude());
            System.out.println(varDqScope.getNorthBoundLatitude());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqScope "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqScope "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqScope "+i.toString());
        }

    }

    public void getDataDqCompletenessCommission() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqCompletenessCommission dcc = dqDataQuality.DqCompletenessCommission();

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dcc.MdIdentifier();
            varDqCompletenessComission.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqCompletenessComission.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            varDqCompletenessComission.setAlternateTitle(xmlReader.getNode(document, cc.AlternateTitle()));
            varDqCompletenessComission.setEdition(xmlReader.getNode(document, cc.Edition()));
            varDqCompletenessComission.setEditionDate(xmlReader.getNode(document, cc.EditionDate()));
            //cidate
            CiDate cd = cc.Date();
            varDqCompletenessComission.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqCompletenessComission.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            //md_identifier
            MdIdentifier mdIdentifier = cc.MdIdentifier();
            varDqCompletenessComission.setCodeIdentifier(xmlReader.getNode(document, mdIdentifier.Code()));
            CiCitation citation = mdIdentifier.CiCitation();
            varDqCompletenessComission.setTitleIdentifier(xmlReader.getNode(document, citation.Title()));
            CiDate ciDate = citation.Date();
            varDqCompletenessComission.setDateIdentifier(xmlReader.getNode(document, ciDate.Date()));
            varDqCompletenessComission.setDateTypeIdentifier(xmlReader.getNode(document, ciDate.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dcc.CiCitation();
            varDqCompletenessComission.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqCompletenessComission.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqCompletenessComission.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            varDqCompletenessComission.setNameOfMeasure(xmlReader.getNode(document, dcc.NameOfMeasure()));
            varDqCompletenessComission.setMeasureDescription(xmlReader.getNode(document, dcc.MeasureDescription()));
            varDqCompletenessComission.setEvaluationMethodType(xmlReader.getNode(document,dcc.EvaluationMethodType()));
            varDqCompletenessComission.setEvaluationMethodDescription(xmlReader.getNode(document, dcc.EvaluationMethodDescription()));
            varDqCompletenessComission.setDateTime(xmlReader.getNode(document, dcc.DateTime()));

            //conformanceResult
            DqConformanceResult dcr = dcc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdDcr = ciCitation.Date();
            varDqCompletenessComission.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqCompletenessComission.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqCompletenessComission.setDate(xmlReader.getNode(document, cdDcr.Date()));
            varDqCompletenessComission.setDateType(xmlReader.getNode(document, cdDcr.DateType()));
            varDqCompletenessComission.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqCompletenessComission.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dcc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqCompletenessComission.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqCompletenessComission.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqCompletenessComission.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqCompletenessComission.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqCompletenessComission.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqCompletenessComission.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqCompletenessComission.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqCompletenessComission.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqCompletenessComission.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqCompletenessComission.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqCompletenessComission.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqCompletenessComission.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqCompletenessComission.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq CompletenessComission#");
            System.out.println("#==============#");
            System.out.println(varDqCompletenessComission.getNameOfMeasure());
            System.out.println(varDqCompletenessComission.getMeasureDescription());
            System.out.println(varDqCompletenessComission.getEvaluationMethodType());
            System.out.println(varDqCompletenessComission.getEvaluationMethodDescription());
            System.out.println(varDqCompletenessComission.getDateTime());
            System.out.println("#Dq ConformanceResult#");
            System.out.println(varDqCompletenessComission.getTitle());
            System.out.println(varDqCompletenessComission.getDate());
            System.out.println(varDqCompletenessComission.getDateType());
            System.out.println(varDqCompletenessComission.getEditionConformance());
            System.out.println(varDqCompletenessComission.getExplanation());
            System.out.println(varDqCompletenessComission.getPass());
            System.out.println("#Dq QuantitativResult#");
            System.out.println(varDqCompletenessComission.getValueType());
            System.out.println(varDqCompletenessComission.getUnitDefinition());
            System.out.println(varDqCompletenessComission.getErrorStatic());
            System.out.println(varDqCompletenessComission.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqCompletenessComission.getCode());
            System.out.println(varDqCompletenessComission.getTitleMeasure());
            System.out.println(varDqCompletenessComission.getAlternateTitle());
            System.out.println(varDqCompletenessComission.getEdition());
            System.out.println(varDqCompletenessComission.getEditionDate());
            System.out.println(varDqCompletenessComission.getDateMeasure());
            System.out.println(varDqCompletenessComission.getDateTypeMeasure());
            System.out.println(varDqCompletenessComission.getCodeIdentifier());
            System.out.println(varDqCompletenessComission.getTitleIdentifier());
            System.out.println(varDqCompletenessComission.getDateIdentifier());
            System.out.println(varDqCompletenessComission.getDateTypeIdentifier());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqCompletenessComission.getTitleEvaluation());
            System.out.println(varDqCompletenessComission.getDateEvaluation());
            System.out.println(varDqCompletenessComission.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqCompletenessComission.getRemarks());
            System.out.println(varDqCompletenessComission.getQuantityType());
            System.out.println(varDqCompletenessComission.getQuantityTypeReference());
            System.out.println(varDqCompletenessComission.getCatalogSymbol());
            System.out.println(varDqCompletenessComission.getDescription());
            System.out.println(varDqCompletenessComission.getDescriptionReference());
            System.out.println(varDqCompletenessComission.getMetaDataProperty());
            System.out.println(varDqCompletenessComission.getIdentifier());
            System.out.println(varDqCompletenessComission.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqCompleteness Comission "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqCompleteness Comission "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqCompleteness Comission "+i.toString());
        }

    }

    public void getDataDqCompletenessOmission(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqCompletenessOmission dco = dqDataQuality.DqCompletenessOmission();

            varDqCompletenessOmission.setNameOfMeasure(xmlReader.getNode(document, dco.NameOfMeasure()));
            varDqCompletenessOmission.setMeasureDescription(xmlReader.getNode(document, dco.MeasureDescription()));
            varDqCompletenessOmission.setEvaluationMethodType(xmlReader.getNode(document, dco.EvaluationMethodType()));
            varDqCompletenessOmission.setEvaluationMethodDescription(xmlReader.getNode(document, dco.EvaluationMethodDescription()));
            varDqCompletenessOmission.setDateTime(xmlReader.getNode(document, dco.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dco.MdIdentifier();
            varDqCompletenessOmission.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqCompletenessOmission.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqCompletenessOmission.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqCompletenessOmission.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dco.CiCitation();
            varDqCompletenessOmission.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqCompletenessOmission.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqCompletenessOmission.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dco.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdDcr = ciCitation.Date();
            varDqCompletenessOmission.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqCompletenessOmission.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqCompletenessOmission.setDate(xmlReader.getNode(document, cdDcr.Date()));
            varDqCompletenessOmission.setDateType(xmlReader.getNode(document, cdDcr.DateType()));
            varDqCompletenessOmission.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqCompletenessOmission.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dco.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqCompletenessOmission.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqCompletenessOmission.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqCompletenessOmission.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqCompletenessOmission.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqCompletenessOmission.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqCompletenessOmission.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqCompletenessOmission.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqCompletenessOmission.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqCompletenessOmission.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqCompletenessOmission.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqCompletenessOmission.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqCompletenessOmission.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqCompletenessOmission.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));

            System.out.println("#Dq Completenessomission#");
            System.out.println("#==============#");
            System.out.println(varDqCompletenessOmission.getNameOfMeasure());
            System.out.println(varDqCompletenessOmission.getMeasureDescription());
            System.out.println(varDqCompletenessOmission.getEvaluationMethodType());
            System.out.println(varDqCompletenessOmission.getEvaluationMethodDescription());
            System.out.println(varDqCompletenessOmission.getDateTime());
            System.out.println(varDqCompletenessOmission.getTitle());
            System.out.println(varDqCompletenessOmission.getDate());
            System.out.println(varDqCompletenessOmission.getDateType());
            System.out.println(varDqCompletenessOmission.getExplanation());
            System.out.println(varDqCompletenessOmission.getPass());
            System.out.println(varDqCompletenessOmission.getValueType());
            System.out.println(varDqCompletenessOmission.getUnitDefinition());
            System.out.println(varDqCompletenessOmission.getErrorStatic());
            System.out.println(varDqCompletenessOmission.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqCompletenessOmission.getCode());
            System.out.println(varDqCompletenessOmission.getTitleMeasure());
            System.out.println(varDqCompletenessOmission.getDateMeasure());
            System.out.println(varDqCompletenessOmission.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqCompletenessOmission.getTitleEvaluation());
            System.out.println(varDqCompletenessOmission.getDateEvaluation());
            System.out.println(varDqCompletenessOmission.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqCompletenessOmission.getRemarks());
            System.out.println(varDqCompletenessOmission.getQuantityType());
            System.out.println(varDqCompletenessOmission.getQuantityTypeReference());
            System.out.println(varDqCompletenessOmission.getCatalogSymbol());
            System.out.println(varDqCompletenessOmission.getDescription());
            System.out.println(varDqCompletenessOmission.getDescriptionReference());
            System.out.println(varDqCompletenessOmission.getMetaDataProperty());
            System.out.println(varDqCompletenessOmission.getIdentifier());
            System.out.println(varDqCompletenessOmission.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqCompleteness Omission "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqCompleteness Omission "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqCompleteness Omission "+i.toString());
        }

    }

    public void getDataDqConceptualConsistency() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqConceptualConsistency dcc = dqDataQuality.DqConceptualConsistency();

            MdIdentifier mi = dcc.MdIdentifier();
            varDqConceptualConsistency.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqConceptualConsistency.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            varDqConceptualConsistency.setAlternateTitle(xmlReader.getNode(document, cc.AlternateTitle()));
            varDqConceptualConsistency.setEdition(xmlReader.getNode(document, cc.Edition()));
            varDqConceptualConsistency.setEditionDate(xmlReader.getNode(document, cc.EditionDate()));
            //cidate
            CiDate cd = cc.Date();
            varDqConceptualConsistency.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqConceptualConsistency.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            //md_identifier
            MdIdentifier mdIdentifier = cc.MdIdentifier();
            varDqConceptualConsistency.setCodeIdentifier(xmlReader.getNode(document, mdIdentifier.Code()));
            CiCitation citation = mdIdentifier.CiCitation();
            varDqConceptualConsistency.setTitleIdentifier(xmlReader.getNode(document, citation.Title()));
            CiDate ciDate = citation.Date();
            varDqConceptualConsistency.setDateIdentifier(xmlReader.getNode(document, ciDate.Date()));
            varDqConceptualConsistency.setDateTypeIdentifier(xmlReader.getNode(document, ciDate.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dcc.CiCitation();
            varDqConceptualConsistency.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqConceptualConsistency.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqConceptualConsistency.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            varDqConceptualConsistency.setNameOfMeasure(xmlReader.getNode(document, dcc.NameOfMeasure()));
            varDqConceptualConsistency.setMeasureDescription(xmlReader.getNode(document, dcc.MeasureDescription()));
            varDqConceptualConsistency.setEvaluationMethodType(xmlReader.getNode(document,dcc.EvaluationMethodType()));
            varDqConceptualConsistency.setEvaluationMethodDescription(xmlReader.getNode(document, dcc.EvaluationMethodDescription()));
            varDqConceptualConsistency.setDateTime(xmlReader.getNode(document, dcc.DateTime()));

            //conformanceResult
            DqConformanceResult dcr = dcc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdDcr = ciCitation.Date();
            varDqConceptualConsistency.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqConceptualConsistency.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqConceptualConsistency.setDate(xmlReader.getNode(document, cdDcr.Date()));
            varDqConceptualConsistency.setDateType(xmlReader.getNode(document, cdDcr.DateType()));
            varDqConceptualConsistency.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqConceptualConsistency.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dcc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqConceptualConsistency.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqConceptualConsistency.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqConceptualConsistency.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqConceptualConsistency.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqConceptualConsistency.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqConceptualConsistency.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqConceptualConsistency.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqConceptualConsistency.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqConceptualConsistency.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqConceptualConsistency.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqConceptualConsistency.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqConceptualConsistency.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqConceptualConsistency.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));

            System.out.println("#Dq ConceptualConsistency#");
            System.out.println("#==============#");
            System.out.println(varDqConceptualConsistency.getNameOfMeasure());
            System.out.println(varDqConceptualConsistency.getMeasureDescription());
            System.out.println(varDqConceptualConsistency.getEvaluationMethodType());
            System.out.println(varDqConceptualConsistency.getEvaluationMethodDescription());
            System.out.println(varDqConceptualConsistency.getDateTime());
            System.out.println(varDqConceptualConsistency.getTitle());
            System.out.println(varDqConceptualConsistency.getDate());
            System.out.println(varDqConceptualConsistency.getDateType());
            System.out.println(varDqConceptualConsistency.getExplanation());
            System.out.println(varDqConceptualConsistency.getPass());
            System.out.println(varDqConceptualConsistency.getValueType());
            System.out.println(varDqConceptualConsistency.getUnitDefinition());
            System.out.println(varDqConceptualConsistency.getErrorStatic());
            System.out.println(varDqConceptualConsistency.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqConceptualConsistency.getCode());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqConceptualConsistency.getTitleEvaluation());
            System.out.println(varDqConceptualConsistency.getDateEvaluation());
            System.out.println(varDqConceptualConsistency.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqConceptualConsistency.getRemarks());
            System.out.println(varDqConceptualConsistency.getQuantityType());
            System.out.println(varDqConceptualConsistency.getQuantityTypeReference());
            System.out.println(varDqConceptualConsistency.getCatalogSymbol());
            System.out.println(varDqConceptualConsistency.getDescription());
            System.out.println(varDqConceptualConsistency.getDescriptionReference());
            System.out.println(varDqConceptualConsistency.getMetaDataProperty());
            System.out.println(varDqConceptualConsistency.getIdentifier());
            System.out.println(varDqConceptualConsistency.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqConceptual Consistency "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqConceptual Consistency "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqConceptual Consistency "+i.toString());
        }

    }

    public void getDataDqDomainConsistency(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqDomainConsistency ddc = dqDataQuality.DqDomainConsistency();

            varDqDomainConsistency.setNameOfMeasure(xmlReader.getNode(document, ddc.NameOfMeasure()));
            varDqDomainConsistency.setMeasureDescription(xmlReader.getNode(document, ddc.MeasureDescription()));
            varDqDomainConsistency.setEvaluationMethodType(xmlReader.getNode(document,ddc.EvaluationMethodType()));
            varDqDomainConsistency.setEvaluationMethodDescription(xmlReader.getNode(document, ddc.EvaluationMethodDescription()));
            varDqDomainConsistency.setDateTime(xmlReader.getNode(document, ddc.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = ddc.MdIdentifier();
            varDqDomainConsistency.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqDomainConsistency.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            
            //cidate
            CiDate cd = cc.Date();
            varDqDomainConsistency.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqDomainConsistency.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure            
            CiCitation cit = ddc.CiCitation();
            varDqDomainConsistency.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            varDqCompletenessComission.setAlternateTitle(xmlReader.getNode(document, cit.AlternateTitle()));
            varDqCompletenessComission.setEdition(xmlReader.getNode(document,cit.Edition()));
            
            CiDate dateCi = cit.Date();
            varDqDomainConsistency.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqDomainConsistency.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
           
            CiSeries cs = cit.CiSeries(); 
            varDqCompletenessComission.setName(xmlReader.getNode(document, cs.Name()));
            varDqCompletenessComission.setIssueIdentification(xmlReader.getNode(document, cs.IssueIdentification()));
            varDqCompletenessComission.setPage(xmlReader.getNode(document, cs.Page()));
            
            //conformanceResult
            DqConformanceResult dcr = ddc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation(); 
            CiDate cdDcr = ciCitation.Date();
            varDqDomainConsistency.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqDomainConsistency.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqDomainConsistency.setDate(xmlReader.getNode(document, cdDcr.Date()));
            varDqDomainConsistency.setDateType(xmlReader.getNode(document, cdDcr.DateType()));
            varDqDomainConsistency.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqDomainConsistency.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = ddc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqDomainConsistency.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqDomainConsistency.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqDomainConsistency.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqDomainConsistency.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqDomainConsistency.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqDomainConsistency.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqDomainConsistency.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqDomainConsistency.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqDomainConsistency.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqDomainConsistency.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqDomainConsistency.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqDomainConsistency.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqDomainConsistency.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq DomainConsistency#");
            System.out.println("#==============#");
            System.out.println(varDqDomainConsistency.getNameOfMeasure());
            System.out.println(varDqDomainConsistency.getMeasureDescription());
            System.out.println(varDqDomainConsistency.getEvaluationMethodType());
            System.out.println(varDqDomainConsistency.getEvaluationMethodDescription());
            System.out.println(varDqDomainConsistency.getDateTime());
            System.out.println(varDqDomainConsistency.getTitle());
            System.out.println(varDqDomainConsistency.getDate());
            System.out.println(varDqDomainConsistency.getDateType());
            System.out.println(varDqDomainConsistency.getExplanation());
            System.out.println(varDqDomainConsistency.getPass());
            System.out.println(varDqDomainConsistency.getValueType());
            System.out.println(varDqDomainConsistency.getUnitDefinition());
            System.out.println(varDqDomainConsistency.getErrorStatic());
            System.out.println(varDqDomainConsistency.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqDomainConsistency.getCode());
            System.out.println(varDqDomainConsistency.getTitleMeasure());
            System.out.println(varDqDomainConsistency.getDateMeasure());
            System.out.println(varDqDomainConsistency.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqDomainConsistency.getTitleEvaluation());
            System.out.println(varDqDomainConsistency.getAlternateTitle());
            System.out.println(varDqDomainConsistency.getEdition());
            System.out.println(varDqDomainConsistency.getDateEvaluation());
            System.out.println(varDqDomainConsistency.getDateTypeEvaluation());
            System.out.println("\nci_series");
            System.out.println(varDqDomainConsistency.getName());
            System.out.println(varDqDomainConsistency.getIssueIdentification());
            System.out.println(varDqDomainConsistency.getPage());
            System.out.println("\nvalueunit");
            System.out.println(varDqDomainConsistency.getRemarks());
            System.out.println(varDqDomainConsistency.getQuantityType());
            System.out.println(varDqDomainConsistency.getQuantityTypeReference());
            System.out.println(varDqDomainConsistency.getCatalogSymbol());
            System.out.println(varDqDomainConsistency.getDescription());
            System.out.println(varDqDomainConsistency.getDescriptionReference());
            System.out.println(varDqDomainConsistency.getMetaDataProperty());
            System.out.println(varDqDomainConsistency.getIdentifier());
            System.out.println(varDqDomainConsistency.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqDomain Consistency "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqDomain Consistency "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqDomain Consistency "+i.toString());
        }

    }

    public void getDataDqFormatConsistency(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqFormatConsistency dfc = dqDataQuality.DqFormatConsistency();

            varDqFormatConsistency.setNameOfMeasure(xmlReader.getNode(document, dfc.NameOfMeasure()));
            varDqFormatConsistency.setMeasureDescription(xmlReader.getNode(document, dfc.MeasureDescription()));
            varDqFormatConsistency.setEvaluationMethodType(xmlReader.getNode(document,dfc.EvaluationMethodType()));
            varDqFormatConsistency.setEvaluationMethodDescription(xmlReader.getNode(document, dfc.EvaluationMethodDescription()));
            varDqFormatConsistency.setDateTime(xmlReader.getNode(document, dfc.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dfc.MdIdentifier();
            varDqFormatConsistency.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqFormatConsistency.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqFormatConsistency.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqFormatConsistency.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dfc.CiCitation();
            varDqFormatConsistency.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqFormatConsistency.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqFormatConsistency.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dfc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdfcr = ciCitation.Date();
            varDqFormatConsistency.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqFormatConsistency.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqFormatConsistency.setDate(xmlReader.getNode(document, cdfcr.Date()));
            varDqFormatConsistency.setDateType(xmlReader.getNode(document, cdfcr.DateType()));
            varDqFormatConsistency.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqFormatConsistency.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dfc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqFormatConsistency.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqFormatConsistency.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqFormatConsistency.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqFormatConsistency.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqFormatConsistency.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqFormatConsistency.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqFormatConsistency.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqFormatConsistency.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqFormatConsistency.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqFormatConsistency.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqFormatConsistency.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqFormatConsistency.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqFormatConsistency.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));

            
            System.out.println("#Dq FormatConsistency#");
            System.out.println("#==============#");
            System.out.println(varDqFormatConsistency.getNameOfMeasure());
            System.out.println(varDqFormatConsistency.getMeasureDescription());
            System.out.println(varDqFormatConsistency.getEvaluationMethodType());
            System.out.println(varDqFormatConsistency.getEvaluationMethodDescription());
            System.out.println(varDqFormatConsistency.getDateTime());
            System.out.println(varDqFormatConsistency.getTitle());
            System.out.println(varDqFormatConsistency.getDate());
            System.out.println(varDqFormatConsistency.getDateType());
            System.out.println(varDqFormatConsistency.getExplanation());
            System.out.println(varDqFormatConsistency.getPass());
            System.out.println(varDqFormatConsistency.getValueType());
            System.out.println(varDqFormatConsistency.getUnitDefinition());
            System.out.println(varDqFormatConsistency.getErrorStatic());
            System.out.println(varDqFormatConsistency.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqFormatConsistency.getCode());
            System.out.println(varDqFormatConsistency.getTitleMeasure());
            System.out.println(varDqFormatConsistency.getDateMeasure());
            System.out.println(varDqFormatConsistency.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqFormatConsistency.getTitleEvaluation());
            System.out.println(varDqFormatConsistency.getDateEvaluation());
            System.out.println(varDqFormatConsistency.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqFormatConsistency.getRemarks());
            System.out.println(varDqFormatConsistency.getQuantityType());
            System.out.println(varDqFormatConsistency.getQuantityTypeReference());
            System.out.println(varDqFormatConsistency.getCatalogSymbol());
            System.out.println(varDqFormatConsistency.getDescription());
            System.out.println(varDqFormatConsistency.getDescriptionReference());
            System.out.println(varDqFormatConsistency.getMetaDataProperty());
            System.out.println(varDqFormatConsistency.getIdentifier());
            System.out.println(varDqFormatConsistency.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqFormat Consistency "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqFormat Consistency "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqFormat Consistency "+i.toString());
        }

    }

    public void getDataDqTopologicalConsistency(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqTopologicalConsistency dtc = dqDataQuality.DqTopologicalConsistency();

            varDqTopologicalConsistency.setNameOfMeasure(xmlReader.getNode(document, dtc.NameOfMeasure()));
            varDqTopologicalConsistency.setMeasureDescription(xmlReader.getNode(document, dtc.MeasureDescription()));
            varDqTopologicalConsistency.setEvaluationMethodType(xmlReader.getNode(document,dtc.EvaluationMethodType()));
            varDqTopologicalConsistency.setEvaluationMethodDescription(xmlReader.getNode(document, dtc.EvaluationMethodDescription()));
            varDqTopologicalConsistency.setDateTime(xmlReader.getNode(document, dtc.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dtc.MdIdentifier();
            varDqTopologicalConsistency.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqTopologicalConsistency.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            varDqTopologicalConsistency.setEdition(xmlReader.getNode(document, cc.Edition()));
            varDqTopologicalConsistency.setEditionDate(xmlReader.getNode(document, cc.EditionDate()));
            //cidate
            CiDate cd = cc.Date();
            varDqTopologicalConsistency.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqTopologicalConsistency.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //md_identifier
            MdIdentifier mdIdentifier = cc.MdIdentifier();
            varDqTopologicalConsistency.setCodeIdentifier(xmlReader.getNode(document, mdIdentifier.Code()));
            CiCitation citation = mdIdentifier.CiCitation();
            varDqTopologicalConsistency.setTitleIdentifier(xmlReader.getNode(document, citation.Title()));
            
            CiDate ciDate = citation.Date();
            varDqTopologicalConsistency.setDateIdentifier(xmlReader.getNode(document, ciDate.Date()));
            varDqTopologicalConsistency.setDateTypeIdentifier(xmlReader.getNode(document, ciDate.DateType()));
            
            varDqTopologicalConsistency.setEditionIdentifier(xmlReader.getNode(document, citation.Edition()));
            varDqTopologicalConsistency.setEditionDateIdentifier(xmlReader.getNode(document, citation.EditionDate()));
            
            MdIdentifier identifier = citation.MdIdentifier();
            varDqTopologicalConsistency.setCodeMeasureIdentifier(xmlReader.getNode(document, identifier.Code()));
            CiCitation ccIdentifier = identifier.CiCitation();
            varDqTopologicalConsistency.setTitleMeasureIdentifier(xmlReader.getNode(document, ccIdentifier.Title()));
            varDqTopologicalConsistency.setEditionDateMeasureIdentifier(xmlReader.getNode(document, ccIdentifier.EditionDate()));
            
            CiDate cdIdentifier = ccIdentifier.Date();
            varDqTopologicalConsistency.setDateMeasureIdentifier(xmlReader.getNode(document, cdIdentifier.Date()));
            varDqTopologicalConsistency.setDateTypeMeasureIdentifier(xmlReader.getNode(document, cdIdentifier.DateType()));        
                       
            //evaluationProcedure
            CiCitation cit = dtc.CiCitation();
            varDqTopologicalConsistency.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqTopologicalConsistency.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqTopologicalConsistency.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dtc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdtcr = ciCitation.Date();
            varDqTopologicalConsistency.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqTopologicalConsistency.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqTopologicalConsistency.setDate(xmlReader.getNode(document, cdtcr.Date()));
            varDqTopologicalConsistency.setDateType(xmlReader.getNode(document, cdtcr.DateType()));
            varDqTopologicalConsistency.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqTopologicalConsistency.setPass(xmlReader.getNode(document, dcr.Pass()));
           
            //quantitativeresult
            DqQuantitativeResult dqr = dtc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqTopologicalConsistency.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqTopologicalConsistency.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqTopologicalConsistency.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqTopologicalConsistency.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqTopologicalConsistency.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqTopologicalConsistency.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqTopologicalConsistency.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqTopologicalConsistency.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqTopologicalConsistency.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqTopologicalConsistency.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqTopologicalConsistency.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqTopologicalConsistency.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqTopologicalConsistency.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq TopologicalConsistency#");
            System.out.println("#==============#");
            System.out.println(varDqTopologicalConsistency.getNameOfMeasure());
            System.out.println(varDqTopologicalConsistency.getMeasureDescription());
            System.out.println(varDqTopologicalConsistency.getEvaluationMethodType());
            System.out.println(varDqTopologicalConsistency.getEvaluationMethodDescription());
            System.out.println(varDqTopologicalConsistency.getDateTime());
            System.out.println(varDqTopologicalConsistency.getTitle());
            System.out.println(varDqTopologicalConsistency.getDate());
            System.out.println(varDqTopologicalConsistency.getDateType());
            System.out.println(varDqTopologicalConsistency.getExplanation());
            System.out.println(varDqTopologicalConsistency.getPass());
            System.out.println(varDqTopologicalConsistency.getValueType());
            System.out.println(varDqTopologicalConsistency.getUnitDefinition());
            System.out.println(varDqTopologicalConsistency.getErrorStatic());
            System.out.println(varDqTopologicalConsistency.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqTopologicalConsistency.getCode());
            System.out.println(varDqTopologicalConsistency.getTitleMeasure());
            System.out.println(varDqTopologicalConsistency.getDateMeasure());
            System.out.println(varDqTopologicalConsistency.getDateTypeMeasure());
            System.out.println(varDqTopologicalConsistency.getEdition());
            System.out.println(varDqTopologicalConsistency.getEditionDate());
            System.out.println("\nmdidentifier");
            System.out.println(varDqTopologicalConsistency.getCodeIdentifier());
            System.out.println(varDqTopologicalConsistency.getTitleIdentifier());
            System.out.println(varDqTopologicalConsistency.getDateIdentifier());
            System.out.println(varDqTopologicalConsistency.getDateTypeIdentifier());
            System.out.println(varDqTopologicalConsistency.getEditionIdentifier());
            System.out.println(varDqTopologicalConsistency.getEditionDateIdentifier());
            System.out.println("\nmeasuremdidentifier");
            System.out.println(varDqTopologicalConsistency.getCodeMeasureIdentifier());
            System.out.println(varDqTopologicalConsistency.getTitleMeasureIdentifier());
            System.out.println(varDqTopologicalConsistency.getDateMeasureIdentifier());
            System.out.println(varDqTopologicalConsistency.getDateTypeMeasureIdentifier());
            System.out.println(varDqTopologicalConsistency.getEditionDateMeasureIdentifier());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqTopologicalConsistency.getTitleEvaluation());
            System.out.println(varDqTopologicalConsistency.getDateEvaluation());
            System.out.println(varDqTopologicalConsistency.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqTopologicalConsistency.getRemarks());
            System.out.println(varDqTopologicalConsistency.getQuantityType());
            System.out.println(varDqTopologicalConsistency.getQuantityTypeReference());
            System.out.println(varDqTopologicalConsistency.getCatalogSymbol());
            System.out.println(varDqTopologicalConsistency.getDescription());
            System.out.println(varDqTopologicalConsistency.getDescriptionReference());
            System.out.println(varDqTopologicalConsistency.getMetaDataProperty());
            System.out.println(varDqTopologicalConsistency.getIdentifier());
            System.out.println(varDqTopologicalConsistency.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqTopological Consistency "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqTopological Consistency "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqTopological Consistency "+i.toString());
        }

    }

    public void getDataDqAbsoluteExternalPositionalAccuracy(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqAbsoluteExternalPositionalAccuracy daepa = dqDataQuality.DqAbsoluteExternalPositionalAccuracy();

            varDqAbsoluteExternalPositionalAccuracy.setNameOfMeasure(xmlReader.getNode(document, daepa.NameOfMeasure()));
            varDqAbsoluteExternalPositionalAccuracy.setMeasureDescription(xmlReader.getNode(document, daepa.MeasureDescription()));
            varDqAbsoluteExternalPositionalAccuracy.setEvaluationMethodType(xmlReader.getNode(document,daepa.EvaluationMethodType()));
            varDqAbsoluteExternalPositionalAccuracy.setEvaluationMethodDescription(xmlReader.getNode(document, daepa.EvaluationMethodDescription()));
            varDqAbsoluteExternalPositionalAccuracy.setDateTime(xmlReader.getNode(document, daepa.DateTime()));
                
            //measureIdentification
            //md_identifier
            MdIdentifier mi = daepa.MdIdentifier();
            varDqAbsoluteExternalPositionalAccuracy.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqAbsoluteExternalPositionalAccuracy.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqAbsoluteExternalPositionalAccuracy.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqAbsoluteExternalPositionalAccuracy.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = daepa.CiCitation();
            varDqAbsoluteExternalPositionalAccuracy.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqAbsoluteExternalPositionalAccuracy.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqAbsoluteExternalPositionalAccuracy.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = daepa.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdaepar = ciCitation.Date();
            varDqAbsoluteExternalPositionalAccuracy.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqAbsoluteExternalPositionalAccuracy.setDate(xmlReader.getNode(document, cdaepar.Date()));
            varDqAbsoluteExternalPositionalAccuracy.setDateType(xmlReader.getNode(document, cdaepar.DateType()));
            varDqAbsoluteExternalPositionalAccuracy.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqAbsoluteExternalPositionalAccuracy.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = daepa.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqAbsoluteExternalPositionalAccuracy.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqAbsoluteExternalPositionalAccuracy.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqAbsoluteExternalPositionalAccuracy.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqAbsoluteExternalPositionalAccuracy.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqAbsoluteExternalPositionalAccuracy.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqAbsoluteExternalPositionalAccuracy.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqAbsoluteExternalPositionalAccuracy.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqAbsoluteExternalPositionalAccuracy.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqAbsoluteExternalPositionalAccuracy.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqAbsoluteExternalPositionalAccuracy.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqAbsoluteExternalPositionalAccuracy.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqAbsoluteExternalPositionalAccuracy.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqAbsoluteExternalPositionalAccuracy.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            varDqAbsoluteExternalPositionalAccuracy.setValue(xmlReader.getNode(document, dqr.Value()));
              
            
            
            System.out.println("#Dq AbsoluteExternalPositionalAccuracy#");
            System.out.println("#==============#");
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getNameOfMeasure());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getMeasureDescription());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getEvaluationMethodType());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getEvaluationMethodDescription());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDateTime());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getTitle());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDate());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDateType());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getExplanation());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getPass());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getValueType());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getUnitDefinition());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getErrorStatic());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getCode());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getTitleMeasure());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDateMeasure());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getTitleEvaluation());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDateEvaluation());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getRemarks());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getQuantityType());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getQuantityTypeReference());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getCatalogSymbol());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDescription());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getDescriptionReference());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getMetaDataProperty());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getIdentifier());
            System.out.println(varDqAbsoluteExternalPositionalAccuracy.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqAbsoluteExternal Positional Accuracy "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqAbsoluteExternal Positional Accuracy "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqAbsoluteExternal Positional Accuracy "+i.toString());
        }

    }

    public void getDataDqGriddedDataPositionalAccuracy() {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqGriddedDataPositionalAccuracy dgdpa = dqDataQuality.DqGriddedDataPositionalAccuracy();

            varDqGriddedDataPositionalAccuracy.setNameOfMeasure(xmlReader.getNode(document, dgdpa.NameOfMeasure()));
            varDqGriddedDataPositionalAccuracy.setMeasureDescription(xmlReader.getNode(document, dgdpa.MeasureDescription()));
            varDqGriddedDataPositionalAccuracy.setEvaluationMethodType(xmlReader.getNode(document,dgdpa.EvaluationMethodType()));
            varDqGriddedDataPositionalAccuracy.setEvaluationMethodDescription(xmlReader.getNode(document, dgdpa.EvaluationMethodDescription()));
            varDqGriddedDataPositionalAccuracy.setDateTime(xmlReader.getNode(document, dgdpa.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dgdpa.MdIdentifier();
            varDqGriddedDataPositionalAccuracy.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqGriddedDataPositionalAccuracy.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqGriddedDataPositionalAccuracy.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqGriddedDataPositionalAccuracy.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dgdpa.CiCitation();
            varDqGriddedDataPositionalAccuracy.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqGriddedDataPositionalAccuracy.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqGriddedDataPositionalAccuracy.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dgdpa.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdgdpar = ciCitation.Date();
            varDqGriddedDataPositionalAccuracy.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqGriddedDataPositionalAccuracy.setDate(xmlReader.getNode(document, cdgdpar.Date()));
            varDqGriddedDataPositionalAccuracy.setDateType(xmlReader.getNode(document, cdgdpar.DateType()));
            varDqGriddedDataPositionalAccuracy.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqGriddedDataPositionalAccuracy.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dgdpa.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqGriddedDataPositionalAccuracy.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqGriddedDataPositionalAccuracy.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqGriddedDataPositionalAccuracy.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqGriddedDataPositionalAccuracy.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqGriddedDataPositionalAccuracy.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqGriddedDataPositionalAccuracy.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqGriddedDataPositionalAccuracy.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqGriddedDataPositionalAccuracy.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqGriddedDataPositionalAccuracy.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqGriddedDataPositionalAccuracy.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqGriddedDataPositionalAccuracy.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqGriddedDataPositionalAccuracy.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqGriddedDataPositionalAccuracy.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq GriddedDataPositionalAccuracy#");
            System.out.println("#==============#");
            System.out.println(varDqGriddedDataPositionalAccuracy.getNameOfMeasure());
            System.out.println(varDqGriddedDataPositionalAccuracy.getMeasureDescription());
            System.out.println(varDqGriddedDataPositionalAccuracy.getEvaluationMethodType());
            System.out.println(varDqGriddedDataPositionalAccuracy.getEvaluationMethodDescription());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDateTime());
            System.out.println(varDqGriddedDataPositionalAccuracy.getTitle());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDate());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDateType());
            System.out.println(varDqGriddedDataPositionalAccuracy.getExplanation());
            System.out.println(varDqGriddedDataPositionalAccuracy.getPass());
            System.out.println(varDqGriddedDataPositionalAccuracy.getValueType());
            System.out.println(varDqGriddedDataPositionalAccuracy.getUnitDefinition());
            System.out.println(varDqGriddedDataPositionalAccuracy.getErrorStatic());
            System.out.println(varDqGriddedDataPositionalAccuracy.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqGriddedDataPositionalAccuracy.getCode());
            System.out.println(varDqGriddedDataPositionalAccuracy.getTitleMeasure());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDateMeasure());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqGriddedDataPositionalAccuracy.getTitleEvaluation());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDateEvaluation());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqGriddedDataPositionalAccuracy.getRemarks());
            System.out.println(varDqGriddedDataPositionalAccuracy.getQuantityType());
            System.out.println(varDqGriddedDataPositionalAccuracy.getQuantityTypeReference());
            System.out.println(varDqGriddedDataPositionalAccuracy.getCatalogSymbol());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDescription());
            System.out.println(varDqGriddedDataPositionalAccuracy.getDescriptionReference());
            System.out.println(varDqGriddedDataPositionalAccuracy.getMetaDataProperty());
            System.out.println(varDqGriddedDataPositionalAccuracy.getIdentifier());
            System.out.println(varDqGriddedDataPositionalAccuracy.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqGriddedData Positional Accuracy "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqGriddedData Positional Accuracy "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqGriddedData Positional Accuracy "+i.toString());
        }

    }

    public void getDataDqRelativeInternalPositionalAccuracy(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqRelativeInternalPositionalAccuracy dripa = dqDataQuality.DqRelativeInternalPositionalAccuracy();

            varDqRelativeInternalPositionalAccuracy.setNameOfMeasure(xmlReader.getNode(document, dripa.NameOfMeasure()));
            varDqRelativeInternalPositionalAccuracy.setMeasureDescription(xmlReader.getNode(document, dripa.MeasureDescription()));
            varDqRelativeInternalPositionalAccuracy.setEvaluationMethodType(xmlReader.getNode(document,dripa.EvaluationMethodType()));
            varDqRelativeInternalPositionalAccuracy.setEvaluationMethodDescription(xmlReader.getNode(document, dripa.EvaluationMethodDescription()));
            varDqRelativeInternalPositionalAccuracy.setDateTime(xmlReader.getNode(document, dripa.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dripa.MdIdentifier();
            varDqRelativeInternalPositionalAccuracy.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqRelativeInternalPositionalAccuracy.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqRelativeInternalPositionalAccuracy.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqRelativeInternalPositionalAccuracy.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dripa.CiCitation();
            varDqRelativeInternalPositionalAccuracy.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqRelativeInternalPositionalAccuracy.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqRelativeInternalPositionalAccuracy.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dripa.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdripar = ciCitation.Date();
            varDqRelativeInternalPositionalAccuracy.setTitle(xmlReader.getNode(document, ciCitation.Title()));;
            varDqRelativeInternalPositionalAccuracy.setDate(xmlReader.getNode(document, cdripar.Date()));
            varDqRelativeInternalPositionalAccuracy.setDateType(xmlReader.getNode(document, cdripar.DateType()));
            varDqRelativeInternalPositionalAccuracy.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqRelativeInternalPositionalAccuracy.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dripa.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqRelativeInternalPositionalAccuracy.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqRelativeInternalPositionalAccuracy.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqRelativeInternalPositionalAccuracy.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqRelativeInternalPositionalAccuracy.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqRelativeInternalPositionalAccuracy.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqRelativeInternalPositionalAccuracy.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqRelativeInternalPositionalAccuracy.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqRelativeInternalPositionalAccuracy.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqRelativeInternalPositionalAccuracy.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqRelativeInternalPositionalAccuracy.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqRelativeInternalPositionalAccuracy.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqRelativeInternalPositionalAccuracy.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqRelativeInternalPositionalAccuracy.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq RelativeInternalPositionalAccuracy#");
            System.out.println("#==============#");
            System.out.println(varDqRelativeInternalPositionalAccuracy.getNameOfMeasure());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getMeasureDescription());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getEvaluationMethodType());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getEvaluationMethodDescription());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDateTime());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getTitle());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDate());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDateType());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getExplanation());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getPass());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getValueType());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getUnitDefinition());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getErrorStatic());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqRelativeInternalPositionalAccuracy.getCode());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getTitleMeasure());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDateMeasure());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqRelativeInternalPositionalAccuracy.getTitleEvaluation());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDateEvaluation());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqRelativeInternalPositionalAccuracy.getRemarks());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getQuantityType());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getQuantityTypeReference());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getCatalogSymbol());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDescription());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getDescriptionReference());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getMetaDataProperty());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getIdentifier());
            System.out.println(varDqRelativeInternalPositionalAccuracy.getUnitsSystem());
            
            
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqRelativeInternal Positional Accuracy "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqRelativeInternal Positional Accuracy "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqRelativeInternal Positional Accuracy "+i.toString());
        }

    }

    public void getDataDqThematicClassificationCorrectness(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqThematicClassificationCorrectness dtcc = dqDataQuality.DqThematicClassificationCorrectness();

            varDqThematicClassificationCorrectness.setNameOfMeasure(xmlReader.getNode(document, dtcc.NameOfMeasure()));
            varDqThematicClassificationCorrectness.setMeasureDescription(xmlReader.getNode(document, dtcc.MeasureDescription()));
            varDqThematicClassificationCorrectness.setEvaluationMethodType(xmlReader.getNode(document,dtcc.EvaluationMethodType()));
            varDqThematicClassificationCorrectness.setEvaluationMethodDescription(xmlReader.getNode(document, dtcc.EvaluationMethodDescription()));
            varDqThematicClassificationCorrectness.setDateTime(xmlReader.getNode(document, dtcc.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dtcc.MdIdentifier();
            varDqThematicClassificationCorrectness.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqThematicClassificationCorrectness.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            varDqThematicClassificationCorrectness.setAlternateTitle(xmlReader.getNode(document, cc.AlternateTitle()));
            CiDate cd = cc.Date();
            varDqThematicClassificationCorrectness.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqThematicClassificationCorrectness.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            //md_identifier
            MdIdentifier mdIdentifier = cc.MdIdentifier();
            varDqThematicClassificationCorrectness.setCodeIdentifier(xmlReader.getNode(document, mdIdentifier.Code()));
            CiCitation citation = mdIdentifier.CiCitation();
            varDqThematicClassificationCorrectness.setTitleIdentifier(xmlReader.getNode(document, citation.Title()));
            varDqThematicClassificationCorrectness.setAlternateTitleIdentifier(xmlReader.getNode(document, citation.AlternateTitle()));
            CiDate ciDate = citation.Date();
            varDqThematicClassificationCorrectness.setDateIdentifier(xmlReader.getNode(document, ciDate.Date()));
            varDqThematicClassificationCorrectness.setDateTypeIdentifier(xmlReader.getNode(document, ciDate.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dtcc.CiCitation();
            varDqThematicClassificationCorrectness.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqThematicClassificationCorrectness.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqThematicClassificationCorrectness.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dtcc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdtccr = ciCitation.Date();
            varDqThematicClassificationCorrectness.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqThematicClassificationCorrectness.setDate(xmlReader.getNode(document, cdtccr.Date()));
            varDqThematicClassificationCorrectness.setDateType(xmlReader.getNode(document, cdtccr.DateType()));
            varDqThematicClassificationCorrectness.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqThematicClassificationCorrectness.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dtcc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqThematicClassificationCorrectness.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqThematicClassificationCorrectness.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqThematicClassificationCorrectness.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqThematicClassificationCorrectness.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqThematicClassificationCorrectness.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqThematicClassificationCorrectness.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqThematicClassificationCorrectness.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqThematicClassificationCorrectness.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqThematicClassificationCorrectness.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqThematicClassificationCorrectness.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqThematicClassificationCorrectness.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqThematicClassificationCorrectness.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqThematicClassificationCorrectness.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq ThematicClassificationCorrectness#");
            System.out.println("#==============#");
            System.out.println(varDqThematicClassificationCorrectness.getNameOfMeasure());
            System.out.println(varDqThematicClassificationCorrectness.getMeasureDescription());
            System.out.println(varDqThematicClassificationCorrectness.getEvaluationMethodType());
            System.out.println(varDqThematicClassificationCorrectness.getEvaluationMethodDescription());
            System.out.println(varDqThematicClassificationCorrectness.getDateTime());
            System.out.println(varDqThematicClassificationCorrectness.getTitle());
            System.out.println(varDqThematicClassificationCorrectness.getDate());
            System.out.println(varDqThematicClassificationCorrectness.getDateType());
            System.out.println(varDqThematicClassificationCorrectness.getExplanation());
            System.out.println(varDqThematicClassificationCorrectness.getPass());
            System.out.println(varDqThematicClassificationCorrectness.getValueType());
            System.out.println(varDqThematicClassificationCorrectness.getUnitDefinition());
            System.out.println(varDqThematicClassificationCorrectness.getErrorStatic());
            System.out.println(varDqThematicClassificationCorrectness.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqThematicClassificationCorrectness.getCode());
            System.out.println(varDqThematicClassificationCorrectness.getTitleMeasure());
            System.out.println(varDqThematicClassificationCorrectness.getAlternateTitle());
            System.out.println(varDqThematicClassificationCorrectness.getDateMeasure());
            System.out.println(varDqThematicClassificationCorrectness.getDateTypeMeasure());
            System.out.println(varDqThematicClassificationCorrectness.getCodeIdentifier());
            System.out.println(varDqThematicClassificationCorrectness.getTitleIdentifier());
            System.out.println(varDqThematicClassificationCorrectness.getAlternateTitleIdentifier());
            System.out.println(varDqThematicClassificationCorrectness.getDateIdentifier());
            System.out.println(varDqThematicClassificationCorrectness.getDateTypeIdentifier());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqThematicClassificationCorrectness.getTitleEvaluation());
            System.out.println(varDqThematicClassificationCorrectness.getDateEvaluation());
            System.out.println(varDqThematicClassificationCorrectness.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqThematicClassificationCorrectness.getRemarks());
            System.out.println(varDqThematicClassificationCorrectness.getQuantityType());
            System.out.println(varDqThematicClassificationCorrectness.getQuantityTypeReference());
            System.out.println(varDqThematicClassificationCorrectness.getCatalogSymbol());
            System.out.println(varDqThematicClassificationCorrectness.getDescription());
            System.out.println(varDqThematicClassificationCorrectness.getDescriptionReference());
            System.out.println(varDqThematicClassificationCorrectness.getMetaDataProperty());
            System.out.println(varDqThematicClassificationCorrectness.getIdentifier());
            System.out.println(varDqThematicClassificationCorrectness.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqThematic Classification Correctness "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqThematic Classification Correctness "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqThematic Classification Correctness "+i.toString());
        }

    }

    public void getDataDqNonQuantitativeAttributeAccuracy(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqNonQuantitativeAttributeAccuracy dnqaa = dqDataQuality.DqNonQuantitativeAttributeAccuracy();

            varDqNonQuantitativeAttributeAccuracy.setNameOfMeasure(xmlReader.getNode(document, dnqaa.NameOfMeasure()));
            varDqNonQuantitativeAttributeAccuracy.setMeasureDescription(xmlReader.getNode(document, dnqaa.MeasureDescription()));
            varDqNonQuantitativeAttributeAccuracy.setEvaluationMethodType(xmlReader.getNode(document,dnqaa.EvaluationMethodType()));
            varDqNonQuantitativeAttributeAccuracy.setEvaluationMethodDescription(xmlReader.getNode(document, dnqaa.EvaluationMethodDescription()));
            varDqNonQuantitativeAttributeAccuracy.setDateTime(xmlReader.getNode(document, dnqaa.DateTime()));
            
            //measureIdentification
            //md_identifier
            MdIdentifier mi = dnqaa.MdIdentifier();
            varDqNonQuantitativeAttributeAccuracy.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqNonQuantitativeAttributeAccuracy.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqNonQuantitativeAttributeAccuracy.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqNonQuantitativeAttributeAccuracy.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dnqaa.CiCitation();
            varDqNonQuantitativeAttributeAccuracy.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqNonQuantitativeAttributeAccuracy.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqNonQuantitativeAttributeAccuracy.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dnqaa.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdnqaar = ciCitation.Date();
            varDqNonQuantitativeAttributeAccuracy.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqNonQuantitativeAttributeAccuracy.setDate(xmlReader.getNode(document, cdnqaar.Date()));
            varDqNonQuantitativeAttributeAccuracy.setDateType(xmlReader.getNode(document, cdnqaar.DateType()));
            varDqNonQuantitativeAttributeAccuracy.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqNonQuantitativeAttributeAccuracy.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dnqaa.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqNonQuantitativeAttributeAccuracy.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqNonQuantitativeAttributeAccuracy.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqNonQuantitativeAttributeAccuracy.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqNonQuantitativeAttributeAccuracy.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqNonQuantitativeAttributeAccuracy.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqNonQuantitativeAttributeAccuracy.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqNonQuantitativeAttributeAccuracy.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqNonQuantitativeAttributeAccuracy.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqNonQuantitativeAttributeAccuracy.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqNonQuantitativeAttributeAccuracy.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqNonQuantitativeAttributeAccuracy.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqNonQuantitativeAttributeAccuracy.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqNonQuantitativeAttributeAccuracy.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq NonQuantitativeAttributeAccuracy#");
            System.out.println("#==============#");
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getNameOfMeasure());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getMeasureDescription());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getEvaluationMethodType());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getEvaluationMethodDescription());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDateTime());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getTitle());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDate());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDateType());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getExplanation());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getPass());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getValueType());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getUnitDefinition());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getErrorStatic());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getCode());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getTitleMeasure());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDateMeasure());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getTitleEvaluation());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDateEvaluation());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getRemarks());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getQuantityType());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getQuantityTypeReference());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getCatalogSymbol());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDescription());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getDescriptionReference());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getMetaDataProperty());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getIdentifier());
            System.out.println(varDqNonQuantitativeAttributeAccuracy.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqNonQuantitative Attribute Accuracy "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqNonQuantitative Attribute Accuracy "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqNonQuantitative Attribute Accuracy "+i.toString());
        }

    }

    public void getDataDqQuantitativeAttributeAccuracy(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqQuantitativeAttributeAccuracy dqaa = dqDataQuality.DqQuantitativeAttributeAccuracy();

            varDqQuantitativeAttributeAccuracy.setNameOfMeasure(xmlReader.getNode(document, dqaa.NameOfMeasure()));
            varDqQuantitativeAttributeAccuracy.setMeasureDescription(xmlReader.getNode(document, dqaa.MeasureDescription()));
            varDqQuantitativeAttributeAccuracy.setEvaluationMethodType(xmlReader.getNode(document,dqaa.EvaluationMethodType()));
            varDqQuantitativeAttributeAccuracy.setEvaluationMethodDescription(xmlReader.getNode(document, dqaa.EvaluationMethodDescription()));
            varDqQuantitativeAttributeAccuracy.setDateTime(xmlReader.getNode(document, dqaa.DateTime()));
            
            //measureIdentification
            //md_identifier
            MdIdentifier mi = dqaa.MdIdentifier();
            varDqQuantitativeAttributeAccuracy.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqQuantitativeAttributeAccuracy.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            varDqQuantitativeAttributeAccuracy.setAlternateTitle(xmlReader.getNode(document, cc.AlternateTitle()));
            varDqQuantitativeAttributeAccuracy.setEdition(xmlReader.getNode(document, cc.Edition()));
            //cidate
            CiDate cd = cc.Date();
            varDqQuantitativeAttributeAccuracy.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqQuantitativeAttributeAccuracy.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            //md_identifier
            
            //evaluationProcedure
            CiCitation cit = dqaa.CiCitation();
            varDqQuantitativeAttributeAccuracy.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqQuantitativeAttributeAccuracy.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqQuantitativeAttributeAccuracy.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dqaa.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdqaar = ciCitation.Date();
            varDqQuantitativeAttributeAccuracy.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqQuantitativeAttributeAccuracy.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqQuantitativeAttributeAccuracy.setDate(xmlReader.getNode(document, cdqaar.Date()));
            varDqQuantitativeAttributeAccuracy.setDateType(xmlReader.getNode(document, cdqaar.DateType()));
            varDqQuantitativeAttributeAccuracy.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqQuantitativeAttributeAccuracy.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dqaa.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqQuantitativeAttributeAccuracy.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqQuantitativeAttributeAccuracy.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqQuantitativeAttributeAccuracy.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqQuantitativeAttributeAccuracy.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqQuantitativeAttributeAccuracy.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqQuantitativeAttributeAccuracy.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqQuantitativeAttributeAccuracy.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqQuantitativeAttributeAccuracy.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqQuantitativeAttributeAccuracy.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqQuantitativeAttributeAccuracy.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqQuantitativeAttributeAccuracy.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqQuantitativeAttributeAccuracy.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqQuantitativeAttributeAccuracy.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq QuantitativeAttributeAccuracy#");
            System.out.println("#==============#");
            System.out.println(varDqQuantitativeAttributeAccuracy.getNameOfMeasure());
            System.out.println(varDqQuantitativeAttributeAccuracy.getMeasureDescription());
            System.out.println(varDqQuantitativeAttributeAccuracy.getEvaluationMethodType());
            System.out.println(varDqQuantitativeAttributeAccuracy.getEvaluationMethodDescription());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDateTime());
            System.out.println(varDqQuantitativeAttributeAccuracy.getTitle());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDate());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDateType());
            System.out.println(varDqQuantitativeAttributeAccuracy.getExplanation());
            System.out.println(varDqQuantitativeAttributeAccuracy.getPass());
            System.out.println(varDqQuantitativeAttributeAccuracy.getValueType());
            System.out.println(varDqQuantitativeAttributeAccuracy.getUnitDefinition());
            System.out.println(varDqQuantitativeAttributeAccuracy.getErrorStatic());
            System.out.println(varDqQuantitativeAttributeAccuracy.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqQuantitativeAttributeAccuracy.getCode());
            System.out.println(varDqQuantitativeAttributeAccuracy.getTitleMeasure());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDateMeasure());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDateTypeMeasure());
            System.out.println(varDqQuantitativeAttributeAccuracy.getEdition());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqQuantitativeAttributeAccuracy.getTitleEvaluation());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDateEvaluation());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqQuantitativeAttributeAccuracy.getRemarks());
            System.out.println(varDqQuantitativeAttributeAccuracy.getQuantityType());
            System.out.println(varDqQuantitativeAttributeAccuracy.getQuantityTypeReference());
            System.out.println(varDqQuantitativeAttributeAccuracy.getCatalogSymbol());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDescription());
            System.out.println(varDqQuantitativeAttributeAccuracy.getDescriptionReference());
            System.out.println(varDqQuantitativeAttributeAccuracy.getMetaDataProperty());
            System.out.println(varDqQuantitativeAttributeAccuracy.getIdentifier());
            System.out.println(varDqQuantitativeAttributeAccuracy.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqQuantitative Attribute Accuracy "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqQuantitative Attribute Accuracy "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqQuantitative Attribute Accuracy "+i.toString());
        }

    }

    public void getDataDqAccuracyOfATimeMeasurement(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqAccuracyOfATimeMeasurement daoatm = dqDataQuality.DqAccuracyOfATimeMeasurement();

            varDqAccuracyOfATimeMeasurement.setNameOfMeasure(xmlReader.getNode(document, daoatm.NameOfMeasure()));
            varDqAccuracyOfATimeMeasurement.setMeasureDescription(xmlReader.getNode(document, daoatm.MeasureDescription()));
            varDqAccuracyOfATimeMeasurement.setEvaluationMethodType(xmlReader.getNode(document,daoatm.EvaluationMethodType()));
            varDqAccuracyOfATimeMeasurement.setEvaluationMethodDescription(xmlReader.getNode(document, daoatm.EvaluationMethodDescription()));
            varDqAccuracyOfATimeMeasurement.setDateTime(xmlReader.getNode(document, daoatm.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = daoatm.MdIdentifier();
            varDqAccuracyOfATimeMeasurement.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqAccuracyOfATimeMeasurement.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqAccuracyOfATimeMeasurement.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqAccuracyOfATimeMeasurement.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = daoatm.CiCitation();
            varDqAccuracyOfATimeMeasurement.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqAccuracyOfATimeMeasurement.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqAccuracyOfATimeMeasurement.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
           
            //conformanceResult
            DqConformanceResult dcr = daoatm.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdaoatmr = ciCitation.Date();
            varDqAccuracyOfATimeMeasurement.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqAccuracyOfATimeMeasurement.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqAccuracyOfATimeMeasurement.setDate(xmlReader.getNode(document, cdaoatmr.Date()));
            varDqAccuracyOfATimeMeasurement.setDateType(xmlReader.getNode(document, cdaoatmr.DateType()));
            varDqAccuracyOfATimeMeasurement.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqAccuracyOfATimeMeasurement.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
           
            System.out.println("#Dq AccuracyOfATimeMeasurement#");
            System.out.println("#==============#");
            System.out.println(varDqAccuracyOfATimeMeasurement.getNameOfMeasure());
            System.out.println(varDqAccuracyOfATimeMeasurement.getMeasureDescription());
            System.out.println(varDqAccuracyOfATimeMeasurement.getEvaluationMethodType());
            System.out.println(varDqAccuracyOfATimeMeasurement.getEvaluationMethodDescription());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDateTime());
            System.out.println(varDqAccuracyOfATimeMeasurement.getTitle());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDate());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDateType());
            System.out.println(varDqAccuracyOfATimeMeasurement.getExplanation());
            System.out.println(varDqAccuracyOfATimeMeasurement.getPass());
            System.out.println(varDqAccuracyOfATimeMeasurement.getValueType());
            System.out.println(varDqAccuracyOfATimeMeasurement.getUnitDefinition());
            System.out.println(varDqAccuracyOfATimeMeasurement.getErrorStatic());
            System.out.println(varDqAccuracyOfATimeMeasurement.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqAccuracyOfATimeMeasurement.getCode());
            System.out.println(varDqAccuracyOfATimeMeasurement.getTitleMeasure());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDateMeasure());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqAccuracyOfATimeMeasurement.getTitleEvaluation());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDateEvaluation());
            System.out.println(varDqAccuracyOfATimeMeasurement.getDateTypeEvaluation());
//            System.out.println("\nvalueunit");
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqAccuracyOfATime Measurement "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqAccuracyOfATime Measurement "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqAccuracyOfATime Measurement "+i.toString());
        }

    }

    public void getDataDqTemporalConsistency(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqTemporalConsistency dtc = dqDataQuality.DqTemporalConsistency();

            varDqTemporalConsistency.setNameOfMeasure(xmlReader.getNode(document, dtc.NameOfMeasure()));
            varDqTemporalConsistency.setMeasureDescription(xmlReader.getNode(document, dtc.MeasureDescription()));
            varDqTemporalConsistency.setEvaluationMethodType(xmlReader.getNode(document,dtc.EvaluationMethodType()));
            varDqTemporalConsistency.setEvaluationMethodDescription(xmlReader.getNode(document, dtc.EvaluationMethodDescription()));
            varDqTemporalConsistency.setDateTime(xmlReader.getNode(document, dtc.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dtc.MdIdentifier();
            varDqTemporalConsistency.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqTemporalConsistency.setTitleMeasure(xmlReader.getNode(document, cc.Title()));
            //cidate
            CiDate cd = cc.Date();
            varDqTemporalConsistency.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqTemporalConsistency.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dtc.CiCitation();
            varDqTemporalConsistency.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqTemporalConsistency.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqTemporalConsistency.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dtc.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdtcr = ciCitation.Date();
            varDqTemporalConsistency.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqTemporalConsistency.setDate(xmlReader.getNode(document, cdtcr.Date()));
            varDqTemporalConsistency.setDateType(xmlReader.getNode(document, cdtcr.DateType()));
            varDqTemporalConsistency.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqTemporalConsistency.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dtc.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqTemporalConsistency.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqTemporalConsistency.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqTemporalConsistency.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqTemporalConsistency.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqTemporalConsistency.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqTemporalConsistency.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqTemporalConsistency.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqTemporalConsistency.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqTemporalConsistency.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqTemporalConsistency.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqTemporalConsistency.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqTemporalConsistency.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqTemporalConsistency.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq TemporalConsistency#");
            System.out.println("#==============#");
            System.out.println(varDqTemporalConsistency.getNameOfMeasure());
            System.out.println(varDqTemporalConsistency.getMeasureDescription());
            System.out.println(varDqTemporalConsistency.getEvaluationMethodType());
            System.out.println(varDqTemporalConsistency.getEvaluationMethodDescription());
            System.out.println(varDqTemporalConsistency.getDateTime());
            System.out.println(varDqTemporalConsistency.getTitle());
            System.out.println(varDqTemporalConsistency.getDate());
            System.out.println(varDqTemporalConsistency.getDateType());
            System.out.println(varDqTemporalConsistency.getExplanation());
            System.out.println(varDqTemporalConsistency.getPass());
            System.out.println(varDqTemporalConsistency.getValueType());
            System.out.println(varDqTemporalConsistency.getUnitDefinition());
            System.out.println(varDqTemporalConsistency.getErrorStatic());
            System.out.println(varDqTemporalConsistency.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqTemporalConsistency.getCode());
            System.out.println(varDqTemporalConsistency.getTitleMeasure());
            System.out.println(varDqTemporalConsistency.getDateMeasure());
            System.out.println(varDqTemporalConsistency.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqTemporalConsistency.getTitleEvaluation());
            System.out.println(varDqTemporalConsistency.getDateEvaluation());
            System.out.println(varDqTemporalConsistency.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqTemporalConsistency.getRemarks());
            System.out.println(varDqTemporalConsistency.getQuantityType());
            System.out.println(varDqTemporalConsistency.getQuantityTypeReference());
            System.out.println(varDqTemporalConsistency.getCatalogSymbol());
            System.out.println(varDqTemporalConsistency.getDescription());
            System.out.println(varDqTemporalConsistency.getDescriptionReference());
            System.out.println(varDqTemporalConsistency.getMetaDataProperty());
            System.out.println(varDqTemporalConsistency.getIdentifier());
            System.out.println(varDqTemporalConsistency.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqTemporal Consistency "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqTemporal Consistency "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqTemporal Consistency "+i.toString());
        }

    }

    public void getDataDqTemporalValidity(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            DqTemporalValidity dtv = dqDataQuality.DqTemporalValidity();

            varDqTemporalValidity.setNameOfMeasure(xmlReader.getNode(document, dtv.NameOfMeasure()));
            varDqTemporalValidity.setMeasureDescription(xmlReader.getNode(document, dtv.MeasureDescription()));
            varDqTemporalValidity.setEvaluationMethodType(xmlReader.getNode(document,dtv.EvaluationMethodType()));
            varDqTemporalValidity.setEvaluationMethodDescription(xmlReader.getNode(document, dtv.EvaluationMethodDescription()));
            varDqTemporalValidity.setDateTime(xmlReader.getNode(document, dtv.DateTime()));

            //measureIdentification
            //md_identifier
            MdIdentifier mi = dtv.MdIdentifier();
            varDqTemporalValidity.setCode(xmlReader.getNode(document, mi.Code()));
            //citation
            CiCitation cc = mi.CiCitation();
            varDqTemporalValidity.setTitleMeasure(xmlReader.getNode(document, cc.Title()));;
            //cidate
            CiDate cd = cc.Date();
            varDqTemporalValidity.setDateMeasure(xmlReader.getNode(document, cd.Date()));
            varDqTemporalValidity.setDateTypeMeasure(xmlReader.getNode(document, cd.DateType()));
            
            //evaluationProcedure
            CiCitation cit = dtv.CiCitation();
            varDqTemporalValidity.setTitleEvaluation(xmlReader.getNode(document, cit.Title()));
            CiDate dateCi = cit.Date();
            varDqTemporalValidity.setDateEvaluation(xmlReader.getNode(document, dateCi.Date()));
            varDqTemporalValidity.setDateTypeEvaluation(xmlReader.getNode(document, dateCi.DateType()));
            
            //conformanceResult
            DqConformanceResult dcr = dtv.DqConformanceResult();
            CiCitation ciCitation = dcr.CiCitation();
            CiDate cdtvr = ciCitation.Date();
            varDqTemporalValidity.setTitle(xmlReader.getNode(document, ciCitation.Title()));
            varDqTemporalValidity.setEditionConformance(xmlReader.getNode(document, ciCitation.Edition()));
            varDqTemporalValidity.setDate(xmlReader.getNode(document, cdtvr.Date()));
            varDqTemporalValidity.setDateType(xmlReader.getNode(document, cdtvr.DateType()));
            varDqTemporalValidity.setExplanation(xmlReader.getNode(document, dcr.Explanation()));
            varDqTemporalValidity.setPass(xmlReader.getNode(document, dcr.Pass()));

            //quantitativeresult
            DqQuantitativeResult dqr = dtv.DqQuantitativeResult();
            ValueUnit vu = dqr.ValueUnit();
            varDqTemporalValidity.setValueType(xmlReader.getNode(document, dqr.ValueType()));
            varDqTemporalValidity.setUnitDefinition(xmlReader.getNode(document, vu.UnitDefinition()));
            varDqTemporalValidity.setErrorStatic(xmlReader.getNode(document, dqr.ErrorStatistic()));
            varDqTemporalValidity.setValue(xmlReader.getNode(document, dqr.Value()));
            varDqTemporalValidity.setRemarks(vu.getRemarks()+"_:_"+xmlReader.getNode(document, vu.Remarks()));
            varDqTemporalValidity.setQuantityType(vu.getQuantityType()+"_:_"+xmlReader.getNode(document, vu.QuantityType()));
            varDqTemporalValidity.setQuantityTypeReference(vu.getQuantityTypeReference()+"_:_"+xmlReader.getNode(document, vu.QuantityTypeReference()));
            varDqTemporalValidity.setCatalogSymbol(vu.getCatalogSymbol()+"_:_"+xmlReader.getNode(document, vu.CatalogSymbol()));
            varDqTemporalValidity.setDescription(vu.getDescription()+"_:_"+xmlReader.getNode(document, vu.Description()));
            varDqTemporalValidity.setDescriptionReference(vu.getDescriptionReference()+"_:_"+xmlReader.getNode(document, vu.DescriptionReference()));
            varDqTemporalValidity.setMetaDataProperty(vu.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, vu.MetaDataProperty()));
            varDqTemporalValidity.setIdentifier(vu.getIdentifier()+"_:_"+xmlReader.getNode(document, vu.Identifier()));
            varDqTemporalValidity.setUnitsSystem(vu.getUnitsSystem()+"_:_"+xmlReader.getNode(document, vu.UnitsSystem()));
            
            System.out.println("#Dq TemporalValidity#");
            System.out.println("#==============#");
            System.out.println(varDqTemporalValidity.getNameOfMeasure());
            System.out.println(varDqTemporalValidity.getMeasureDescription());
            System.out.println(varDqTemporalValidity.getEvaluationMethodType());
            System.out.println(varDqTemporalValidity.getEvaluationMethodDescription());
            System.out.println(varDqTemporalValidity.getDateTime());
            System.out.println(varDqTemporalValidity.getTitle());
            System.out.println(varDqTemporalValidity.getDate());
            System.out.println(varDqTemporalValidity.getDateType());
            System.out.println(varDqTemporalValidity.getExplanation());
            System.out.println(varDqTemporalValidity.getPass());
            System.out.println(varDqTemporalValidity.getValueType());
            System.out.println(varDqTemporalValidity.getUnitDefinition());
            System.out.println(varDqTemporalValidity.getErrorStatic());
            System.out.println(varDqTemporalValidity.getValue());
            System.out.println("\nmeasureIdentification");
            System.out.println(varDqTemporalValidity.getCode());
            System.out.println(varDqTemporalValidity.getTitleMeasure());
            System.out.println(varDqTemporalValidity.getDateMeasure());
            System.out.println(varDqTemporalValidity.getDateTypeMeasure());
            System.out.println("\nevaluationprocedure");
            System.out.println(varDqTemporalValidity.getTitleEvaluation());
            System.out.println(varDqTemporalValidity.getDateEvaluation());
            System.out.println(varDqTemporalValidity.getDateTypeEvaluation());
            System.out.println("\nvalueunit");
            System.out.println(varDqTemporalValidity.getRemarks());
            System.out.println(varDqTemporalValidity.getQuantityType());
            System.out.println(varDqTemporalValidity.getQuantityTypeReference());
            System.out.println(varDqTemporalValidity.getCatalogSymbol());
            System.out.println(varDqTemporalValidity.getDescription());
            System.out.println(varDqTemporalValidity.getDescriptionReference());
            System.out.println(varDqTemporalValidity.getMetaDataProperty());
            System.out.println(varDqTemporalValidity.getIdentifier());
            System.out.println(varDqTemporalValidity.getUnitsSystem());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata DqTemporal Validity "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata DqTemporal Validity "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata DqTemporal Validity "+i.toString());
        }

    }

    public void getDataLiLineage(){

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
           
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();

            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();
            LiLineage liLineage = dqDataQuality.LiLineage();
            LiProcessStep liProcessStep = liLineage.LiProcessStep();
            LiSource liSource = liLineage.LiSource();
            MdRepresentativeFraction mrf = liSource.MdRepresentativeFraction();
            MdReferenceSystem mrs = liSource.MdReferenceSystem();
            RsIdentifier ri = mrs.RsIdentifier();
            //li_lineage
            varLiLineage.setStatement(xmlReader.getNode(document, liLineage.Statement()));
            //li_proccesstep
            varLiLineage.setDescriptionLiProcessStep(xmlReader.getNode(document, liProcessStep.Description()));
            varLiLineage.setRationale(xmlReader.getNode(document, liProcessStep.Rationale()));
            varLiLineage.setDateTime(xmlReader.getNode(document, liProcessStep.DateTime()));
            //ci_responsibleparty
            CiResponsibleParty party = liProcessStep.CiResponsibleParty();
            varLiLineage.setIndividualName(xmlReader.getNode(document, party.IndividualName()));
            varLiLineage.setOrganisationName(xmlReader.getNode(document, party.OrganisationName()));
            varLiLineage.setPositionName(xmlReader.getNode(document, party.PositionName()));
            varLiLineage.setRole(xmlReader.getNode(document, party.Role()));
            //contactinfo
            ContactInfo ci = party.ContactInfo();
            CiTelephone ct = ci.CiTelephone();
            varLiLineage.setVoice(xmlReader.getNode(document, ct.Voice()));
            varLiLineage.setFax(xmlReader.getNode(document, ct.Facsimile()));
            //address
            CiAddress ca = ci.CiAddress();
            varLiLineage.setDeliveryPoint(xmlReader.getNode(document, ca.DeliveryPoint()));
            varLiLineage.setCity(xmlReader.getNode(document, ca.City()));
            varLiLineage.setAdministrativeArea(xmlReader.getNode(document, ca.AdministrativeArea()));
            varLiLineage.setPostalCode(xmlReader.getNode(document, ca.PostalCode()));
            varLiLineage.setCountry(xmlReader.getNode(document, ca.Country()));
            varLiLineage.setElectronicMailAddress(xmlReader.getNode(document, ca.ElectronicMailAddress()));
            //onlineresource
            CiOnlineResourceInfo cori = ci.CiOnlineResourceInfo();
            varLiLineage.setApplicationProfile(xmlReader.getNode(document, cori.ApplicationProfile()));
            varLiLineage.setLinkage(xmlReader.getNode(document, cori.Linkage()));
            varLiLineage.setProtocol(xmlReader.getNode(document, cori.Protocol()));
            varLiLineage.setNameOnlineResource(xmlReader.getNode(document, cori.Name()));
            varLiLineage.setDescription(xmlReader.getNode(document, cori.Description()));
            varLiLineage.setFunction(xmlReader.getNode(document, cori.Function()));
            //contactinfo
            varLiLineage.setHoursOfService(xmlReader.getNode(document, ci.HoursOfService()));
            varLiLineage.setContactInstructions(xmlReader.getNode(document, ci.ContactInstructions()));
             //li_source
            varLiLineage.setDescriptionLiSource(xmlReader.getNode(document, liSource.Description()));
            //md_reference system
            varLiLineage.setDenominator(xmlReader.getNode(document, mrf.Denominator()));
            //rs_identifier
            varLiLineage.setCodeSpace(xmlReader.getNode(document, ri.CodeSpace()));
            varLiLineage.setCode(xmlReader.getNode(document, ri.Code()));
            varLiLineage.setVersion(xmlReader.getNode(document, ri.Version()));
            //citation
            CiCitation cc = ri.CiCitation();
            varLiLineage.setTitle(xmlReader.getNode(document, cc.Title()));
            varLiLineage.setAlternatetitle(xmlReader.getNode(document, cc.AlternateTitle()));
            varLiLineage.setEdition(xmlReader.getNode(document, cc.Edition()));
            varLiLineage.setEditionDate(xmlReader.getNode(document, cc.EditionDate()));
            varLiLineage.setPresentationForm(xmlReader.getNode(document, cc.PresentationForm()));
            //ci_date
            CiDate cd = cc.Date();
            varLiLineage.setDate_(xmlReader.getNode(document, cd.Date()));
            varLiLineage.setDateType(xmlReader.getNode(document, cd.DateType()));
            //ci_series
            CiSeries cs = cc.CiSeries();
            varLiLineage.setName(xmlReader.getNode(document, cs.Name()));
            varLiLineage.setIssueIdentification(xmlReader.getNode(document, cs.IssueIdentification()));
            varLiLineage.setPage(xmlReader.getNode(document, cs.Page()));
            //citation
            CiCitation citation = liSource.CiCitation();
            varLiLineage.setTitleSource(xmlReader.getNode(document, citation.Title()));
            varLiLineage.setAlternateTitleSource(xmlReader.getNode(document, citation.AlternateTitle()));
            varLiLineage.setEditionSource(xmlReader.getNode(document, citation.Edition()));
            varLiLineage.setEditionDateSource(xmlReader.getNode(document, citation.EditionDate()));
            //cidate
            CiDate ciDate = citation.Date();
            varLiLineage.setDateSource(xmlReader.getNode(document, ciDate.Date()));
            varLiLineage.setDateTypeSource(xmlReader.getNode(document, ciDate.DateType()));
            //ex_extent
            Extent extent = liSource.Extent();
            varLiLineage.setDescription(xmlReader.getNode(document, extent.Description()));
            varLiLineage.setTemporalElement(xmlReader.getNode(document, extent.TemporalElement()));
            varLiLineage.setVerticalElement(xmlReader.getNode(document, extent.VerticalElement()));
            //geographicElement
            ExBoundingPolygon ebp = extent.ExBoundingPolygon();
            varLiLineage.setExtentTypeCode(xmlReader.getNode(document, ebp.ExtentTypeCode()));
            //polygon
            Polygon polygon = ebp.Polygon();
            varLiLineage.setDescriptionPolygon(polygon.getDescription()+"_:_"+xmlReader.getNode(document, polygon.Description()));
            varLiLineage.setDescriptionReference(polygon.getDescriptionReference()+"_:_"+xmlReader.getNode(document, polygon.DescriptionReference()));
            varLiLineage.setIdentifier(polygon.getIdentifier()+"_:_"+xmlReader.getNode(document, polygon.Identifier()));
            varLiLineage.setMetaDataProperty(polygon.getMetaDataProperty()+"_:_"+xmlReader.getNode(document, polygon.MetaDataProperty()));
            varLiLineage.setNamePolygon(polygon.getName()+"_:_"+xmlReader.getNode(document, polygon.Name()));
            //sourcestep
            LiProcessStep lps = liSource.LiProcessStep();
            varLiLineage.setDescriptionSourceStep(xmlReader.getNode(document, lps.Description()));
            varLiLineage.setRationaleSourceStep(xmlReader.getNode(document, lps.Rationale()));
            varLiLineage.setDateTimeSourceStep(xmlReader.getNode(document, lps.DateTime()));
            
            System.out.println("#LiLineage#");
            System.out.println("#==============#");
            System.out.println("\n#LiSource#");
            System.out.println(varLiLineage.getStatement());
            System.out.println(varLiLineage.getDescriptionLiSource());
            System.out.println("\n#LiProcessstep#");
            System.out.println(varLiLineage.getDescriptionLiProcessStep());
            System.out.println(varLiLineage.getRationale());
            System.out.println(varLiLineage.getDateTime());
            System.out.println("\n#MdRepresentativeFraction#");
            System.out.println(varLiLineage.getDenominator());
            System.out.println("\n#RsIdentifier#");
            System.out.println(varLiLineage.getCodeSpace());
            System.out.println(varLiLineage.getCode());
            System.out.println(varLiLineage.getVersion());
            System.out.println("\n#Ci_responsibleparty#");
            System.out.println(varLiLineage.getIndividualName());
            System.out.println(varLiLineage.getOrganisationName());
            System.out.println(varLiLineage.getPositionName());
            System.out.println(varLiLineage.getRole());
            System.out.println("\n#contactInfo#");
            System.out.println(varLiLineage.getHoursOfService());
            System.out.println(varLiLineage.getContactInstructions());
            System.out.println(varLiLineage.getVoice());
            System.out.println(varLiLineage.getFax());
            System.out.println("\n#Address#");
            System.out.println(varLiLineage.getDeliveryPoint());
            System.out.println(varLiLineage.getCity());
            System.out.println(varLiLineage.getAdministrativeArea());
            System.out.println(varLiLineage.getPostalCode());
            System.out.println(varLiLineage.getCountry());
            System.out.println(varLiLineage.getElectronicMailAddress());
            System.out.println("\n#CionlineResource#");
            System.out.println(varLiLineage.getApplicationProfile());
            System.out.println(varLiLineage.getLinkage());
            System.out.println(varLiLineage.getProtocol());
            System.out.println(varLiLineage.getNameOnlineResource());
            System.out.println(varLiLineage.getDescription());
            System.out.println(varLiLineage.getFunction());
            System.out.println("\n#Citation#");
            System.out.println(varLiLineage.getTitle());
            System.out.println(varLiLineage.getAlternatetitle());
            System.out.println(varLiLineage.getEdition());
            System.out.println(varLiLineage.getEditionDate());
            System.out.println(varLiLineage.getPresentationForm());
            System.out.println("\n#CitationDate#");
            System.out.println(varLiLineage.getDate_());
            System.out.println(varLiLineage.getDateType());
            System.out.println("\n#CiSeries#");
            System.out.println(varLiLineage.getName());
            System.out.println(varLiLineage.getIssueIdentification());
            System.out.println(varLiLineage.getPage());
            System.out.println("\n#Citation#");
            System.out.println(varLiLineage.getTitleSource());
            System.out.println(varLiLineage.getAlternateTitleSource());
            System.out.println(varLiLineage.getEditionSource());
            System.out.println(varLiLineage.getEditionDateSource());
            System.out.println("\n#CitationDate#");
            System.out.println(varLiLineage.getDateSource());
            System.out.println(varLiLineage.getDateTypeSource());
            System.out.println("\n#Ex_extent#");
            System.out.println(varLiLineage.getDescription());
            System.out.println(varLiLineage.getTemporalElement());
            System.out.println(varLiLineage.getVerticalElement());
            System.out.println("\n#GeographicElement#");
            System.out.println(varLiLineage.getExtentTypeCode());
            System.out.println("\n#Polygon#");
            System.out.println(varLiLineage.getDescriptionPolygon());
            System.out.println(varLiLineage.getDescriptionReference());
            System.out.println(varLiLineage.getIdentifier());
            System.out.println(varLiLineage.getMetaDataProperty());
            System.out.println(varLiLineage.getNamePolygon());
            System.out.println("\n#SourceStep#");
            System.out.println(varLiLineage.getDescriptionSourceStep());
            System.out.println(varLiLineage.getRationaleSourceStep());
            System.out.println(varLiLineage.getDateTimeSourceStep());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            displayLog(false, "Error Elemen Metadata LiLineage "+ex.toString());
        } catch (SAXException s) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
            displayLog(false, "Error Elemen Metadata LiLineage "+s.toString());
        } catch (IOException i) {
            Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
            displayLog(false, "Error Elemen Metadata LiLineage "+i.toString());
        }

    }
    
    public void displayLog(boolean status,String message){
        
        if(status){
            jTextAreaLogData.setForeground(Color.BLACK);
            jTextAreaLogData.append(message+ "\n");
        }else{
            jTextAreaLogData.setForeground(Color.red);
            jTextAreaLogData.append(message+ "\n");
        }
    }
    
     //Save elemen metadata entity set information
    public void saveUpdateMdMetadata(String column,MdMetadataModel value) {

        String ret = null;
        
        try{

            PtLocaleController ptLocaleController = new PtLocaleController(session, hibernateUtilXml);
            MdMetadataController md = new MdMetadataController(session, hibernateUtilXml);
            MdCharacterSetCodeController mdCharacterSetCodeController = new MdCharacterSetCodeController(session, hibernateUtilXml);
            MdMetadataModel mdModel = new MdMetadataModel();

            BigDecimal mdMetadataId;
            BigDecimal getIdMetadata;
            BigDecimal locale;
            BigDecimal id =null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dt;
            String code=null;
            String newIdentifier = md.checkFileidentifier(value.getFileidentifier());

            getIdMetadata = md.getMaxMetadataId();
            if (getIdMetadata == null) {
                mdMetadataId = new BigDecimal(FIRST_ID);
            } else {
                mdMetadataId = new BigDecimal(getIdMetadata.longValue() + 1);
            }

            if(value.getCharacterset()==null){
                code="000";
            }else{
                code = mdCharacterSetCodeController.getDataByDomain(value.getCharacterset()).getCode();
            }

            if(value.getLanguage()==null || value.getLanguage()=="-"){
                 locale = new BigDecimal(BigInteger.ONE); 
            }else{
                 locale = new BigDecimal(ptLocaleController.getIdByLanguage(value.getLanguage()).getId().toString()); 
            }
            try {
                String date_ = value.getStringDate();
                if (date_.equals("-")) {

                    mdModel.setDatestamp(null);
                } else {
                    dt = dateFormat.parse(date_);
                    mdModel.setDatestamp(dt);
                }

            } catch (ParseException ex) {
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            }

            mdModel.setId(mdMetadataId);
            mdModel.setFileidentifier(newIdentifier);
            mdModel.setHarvestid(null);
            mdModel.setLanguage(value.getLanguage());
            mdModel.setMetadatastandardname(value.getMetadatastandardname());
            mdModel.setMetadatastandardversion(value.getMetadatastandardversion());
            mdModel.setParentidentifier(value.getParentidentifier());
            mdModel.setDataseturi(value.getDataseturi());
            mdModel.setCharacterset(code);
            mdModel.setLocale(locale);

            boolean flag=false;
            if (md.getDataById(column,newIdentifier) == null) {
                flag=true;
                id = mdMetadataId;
            } else {
                flag=false;
                id = md.getDataById(column,newIdentifier).getId();
            }

            if (flag) {
                ret = md.saveMdMetadata(mdModel);
            } else {
                ret = md.updateMdMetadata(mdModel);
            }
            
            displayLog(true, "\nMdMetadata");
            displayLog(true, "id = "+id);
            displayLog(true, "fileidentifier = "+newIdentifier);
            displayLog(true, "Language = "+value.getLanguage());
            displayLog(true, "metadataStandartdName = "+value.getMetadatastandardname());
            displayLog(true, "Metadatastandardversion = "+value.getMetadatastandardversion());
            displayLog(true, "Parentidentifier = "+value.getParentidentifier());
            displayLog(true, "Dataseturi = "+value.getDataseturi());
            displayLog(true, "Datestamp = "+value.getStringDate());
            displayLog(true, "CharacteterSetCode = "+code);
            displayLog(true, "Locale = "+locale);
                       
            if(ret.contains("Error")){
                displayLog(false, "Status table MdMetadata " + ret+"\n");
            }else{
                displayLog(true, "Status table MdMetadata " + ret+"\n");
            }
             
        }catch(Exception e){
            
            displayLog(false, "Error table MdMetadata " + e.toString());
            displayLog(true, "Status table MdMetadata " + ret+"\n");
            
        }
    }

    public void saveUpdateMdMetadataHierarchyLv(MdMetadataHierarchylvModel value) {
        
        String ret=null;
        try{

            MdMetadataHierarchyLvController mdHierarchyLv = new MdMetadataHierarchyLvController(session, hibernateUtilXml);
            MdScopecodeController mdScopecode = new MdScopecodeController(session, hibernateUtilXml);
            MdMetadataHierarchylvModel mdModel = new MdMetadataHierarchylvModel();
            boolean flag=false;

            String code = mdScopecode.getDataByCode(value.getHierarchylevel()).getCode();

            mdModel.setMdMetadataid(value.getMdMetadataid());
            mdModel.setHierarchylevel(code);

            if (mdHierarchyLv.getDataById(value.getMdMetadataid()) == null) {
                flag=true;
            } else {
                flag=false;
            }

            if (flag) {
                ret = mdHierarchyLv.saveMdMetadataHierarchyLv(mdModel);
            } else {
                ret = mdHierarchyLv.updateMdMetadataHierarchyLv(mdModel);
            }
            
            displayLog(true, "MdMetadataHierarchyLevel");
            displayLog(true, "Hierarchylevel = "+code);
            displayLog(true, "foreign key mdMetadataId = "+value.getMdMetadataid());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table MdMetadataHierarchyLv " + ret+"\n");
            }else{
                displayLog(true, "Status table MdMetadataHierarchyLv " + ret+"\n");
            }
            
        }catch(Exception e){
            displayLog(false, "Error MdMetadataHierarchyLv " + e.toString());
            displayLog(true, "Status table MdMetadataHierarchyLv " + ret+"\n");
        }

    }

    public void saveUpdateMdMetadataHierarchyLvName(MdMetadataHierarchylvNameModel value) {
        
        String ret=null;
        
        try{

            MdMetadataHierarchyLvNameController mdHierarchyLvName = new MdMetadataHierarchyLvNameController(session, hibernateUtilXml);
            MdMetadataHierarchylvNameModel mdModel = new MdMetadataHierarchylvNameModel();

            mdModel.setMdMetadataid(value.getMdMetadataid());
            mdModel.setHierarchylevelName(value.getHierarchylevelName());

            boolean flag=false;

            if (mdHierarchyLvName.getDataById(value.getMdMetadataid()) == null) {
                flag=true;
            } else {
                flag=false;
            }

            if (flag) {
                ret = mdHierarchyLvName.saveMdMetadataHierarchyLvName(mdModel);
            } else {
                ret = mdHierarchyLvName.updateMdMetadataHierarchyLvName(mdModel);
            }
            
            displayLog(true, "MdMetadataHierarchyLevelName");
            displayLog(true, "foregin key MdMetadataid = "+value.getMdMetadataid());
            displayLog(true, "HierarchylevelName = "+value.getHierarchylevelName());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table MdMetadataHierarchyLvName " + ret+"\n");
            }else{
                displayLog(true, "Status table MdMetadataHierarchyLvName " + ret+"\n");
            }
                        
        }catch(Exception e){
                        
            displayLog(false, "Error MdMetadataHierarchyLvName " + e.toString());
            displayLog(true, "Status table MdMetadataHierarchyLvName " + ret+"\n");
        }
    }

    public void saveUpdateCiResponsibleParty(String column,BigDecimal foreignId,CiResponsiblePartyModel value) {

        String ret=null;
        
        try{
            CiResponsiblePartyController ciResponsiblePartyController = new CiResponsiblePartyController(session, hibernateUtilXml);
            CiResponsiblePartyModel ciResponsiblePartyModel = new CiResponsiblePartyModel();
            CiRoleCodeController ciRoleCodeController = new CiRoleCodeController(session, hibernateUtilXml);

            BigDecimal ciResponsiblePartyId;
            BigDecimal getCiResponsiblePartyId;

            getCiResponsiblePartyId = ciResponsiblePartyController.getMaxResponsiblePartyId();
            if (getCiResponsiblePartyId == null) {
                ciResponsiblePartyId = new BigDecimal(FIRST_ID);
            } else {
                ciResponsiblePartyId = new BigDecimal(getCiResponsiblePartyId.longValue() + 1);
            }

            String domainName=value.getRole();
            String code = "";
            if(domainName==null){
                code="000";
            }else{
                code = ciRoleCodeController.getDataByDomain(domainName).getCode();
            }

            ciResponsiblePartyModel.setId(ciResponsiblePartyId);
            ciResponsiblePartyModel.setIndividualName(value.getIndividualName());
            ciResponsiblePartyModel.setOrganisationName(value.getOrganisationName());
            ciResponsiblePartyModel.setPositionName(value.getPositionName());
            ciResponsiblePartyModel.setRole(code);
            ciResponsiblePartyModel.setMdMetadataId(value.getMdMetadataId());
            ciResponsiblePartyModel.setCiCitationId(value.getCiCitationId());
            ciResponsiblePartyModel.setMdDistributorId(value.getMdDistributorId());
            ciResponsiblePartyModel.setMdExtendedElementInfoId(value.getMdExtendedElementInfoId());
            ciResponsiblePartyModel.setMdIdentificationId(value.getMdIdentificationId());
            ciResponsiblePartyModel.setMdMaintenanceInfoId(value.getMdMaintenanceInfoId());
            ciResponsiblePartyModel.setLiProcessStepId(value.getLiProcessStepId());
            ciResponsiblePartyModel.setMdUsageId(value.getMdUsageId());

            boolean isFlag=false;
            BigDecimal id=null;

            if (ciResponsiblePartyController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = ciResponsiblePartyId;
            } else {
               isFlag=false;
               id=ciResponsiblePartyController.getDataById(column,foreignId).getId();

            }

            if (isFlag) {
                ret = ciResponsiblePartyController.saveCiResponsibleParty(ciResponsiblePartyModel);

            } else {
                ret = ciResponsiblePartyController.updateCiResponsibleParty(id,ciResponsiblePartyModel);

            }
            
            displayLog(true, "CiResponsibleParty");
            displayLog(true, "id = "+id);
            displayLog(true, "IndividualName = "+value.getIndividualName());
            displayLog(true, "OrganisationName = "+value.getOrganisationName());
            displayLog(true, "PositionName = "+value.getPositionName());
            displayLog(true, "Role = "+value.getRole());
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
                displayLog(false,"Status table CiResponsibleParty " + ret+"\n");
            }else{
                displayLog(true, "Status table CiResponsibleParty " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiResponsibleParty " + e.toString());
            displayLog(true, "Status table CiResponsibleParty " + ret+"\n");
        }

    }

    public void saveUpdateCiContact(CiContactModel value) {
        
        String ret=null;
        try{

            CiContactController ciContactController = new CiContactController(session, hibernateUtilXml);
            CiContactModel ciContactModel = new CiContactModel();
            BigDecimal ciContactId;
            BigDecimal getCicontactId;

           
            boolean isFlag=false;
            BigDecimal id=null;

            getCicontactId = ciContactController.getMaxCiContactId();
            if (getCicontactId == null) {
                ciContactId = new BigDecimal(FIRST_ID);
            } else {
                ciContactId = new BigDecimal(getCicontactId.longValue() + 1);
            }

            ciContactModel.setId(ciContactId);
            ciContactModel.setHouseOfService(value.getHouseOfService());
            ciContactModel.setContactInstruction(value.getContactInstruction());
            ciContactModel.setCiResponsiblePartyId(value.getCiResponsiblePartyId());

            if (ciContactController.getDataById(value.getCiResponsiblePartyId()) == null) {
                isFlag=true;
                id = ciContactId;
            } else {
                isFlag=false;
                id = ciContactController.getDataById(value.getCiResponsiblePartyId()).getId();
            }

            if (isFlag) {
                ret = ciContactController.saveCiContact(ciContactModel);
            } else {
                ret = ciContactController.updateCiContact(id,ciContactModel);

            }
            
            displayLog(true, "CiContact");
            displayLog(true, "id = "+id);
            displayLog(true, "HouseOfService = "+value.getHouseOfService());
            displayLog(true, "ContactInstruction = "+value.getContactInstruction());
            displayLog(true, "foregin key CiResponsiblePartyId = "+value.getCiResponsiblePartyId());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiContactInfo " + ret+"\n");
            }else{
                displayLog(true, "Status table CiContactInfo " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error CiContactInfo " + e.toString());
            displayLog(true, "Status table CiContactInfo " + ret+"\n");
        }

    }

    public void saveUpdateCiTelephone(CiTelephoneModel value) {
        
        String ret=null;
        try{

            CiTelephoneController ciTelephoneController = new CiTelephoneController(session, hibernateUtilXml);
            CiTelephoneModel ciTelephoneModel = new CiTelephoneModel();

            boolean isFlag=false;
            BigDecimal id=null;
            BigDecimal ciTelephoneId;
            BigDecimal getCiTelephoneId;

            getCiTelephoneId = ciTelephoneController.getMaxTelephoneId();
            if(getCiTelephoneId == null) {
                ciTelephoneId = new BigDecimal(FIRST_ID);
            }else {
                ciTelephoneId = new BigDecimal(getCiTelephoneId.longValue() + 1);
            }

            ciTelephoneModel.setId(ciTelephoneId);
            ciTelephoneModel.setCiContactId(value.getCiContactId());

            if (ciTelephoneController.getDataById(value.getCiContactId()) == null) {
                isFlag=true;
                id=ciTelephoneId;
            } else {
                isFlag=false;
                id = ciTelephoneController.getDataById(value.getCiContactId()).getId();
            }

            if (isFlag) {
                ret = ciTelephoneController.saveCiTelephone(ciTelephoneModel);
            } else {
                ret = ciTelephoneController.updateCiTelephone(id,ciTelephoneModel);
            }
            
            displayLog(true, "CiTelephone");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key CiContactId = "+value.getCiContactId());

            if(ret.contains("Error")){
                displayLog(false, "Status table CiTelephone " + ret+"\n");
            }else{
                displayLog(true, "Status table CiTelephone " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiTelephone " + e.toString());
            displayLog(true, "Status table CiTelephone " + ret+"\n");
        }
            

    }

    public void saveUpdateCiTelephoneVoice(CiTelephoneVoiceModel value) {
        
        String ret=null;
        try{
    
            CiTelephoneVoiceController ciTelephoneVoiceController = new CiTelephoneVoiceController(session, hibernateUtilXml);
            CiTelephoneVoiceModel ciTelephoneVoiceModel = new CiTelephoneVoiceModel();

            boolean isFlag=false;

            ciTelephoneVoiceModel.setCiTelephoneId(value.getCiTelephoneId());
            ciTelephoneVoiceModel.setVoice(value.getVoice());

            if (ciTelephoneVoiceController.getDataById(value.getCiTelephoneId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ciTelephoneVoiceController.saveCiTelephoneVoice(ciTelephoneVoiceModel);
            } else {
                ret = ciTelephoneVoiceController.updateCiTelephoneVoice(ciTelephoneVoiceModel);
            }
            
            displayLog(true, "CiTelephoneVoice");
            displayLog(true, "voice = "+value.getVoice());
            displayLog(true, "foreign key CiTelephoneId = "+value.getCiTelephoneId());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiTelephone Voice " + ret+"\n");
            }else{
                displayLog(true, "Status table CiTelephone Voice " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error CiTelephone Voice " + e.toString());
            displayLog(true, "Status table CiTelephone Voice " + ret+"\n");
        }

    }

    public void saveUpdateCiTelephoneFacsimile(CiTelephoneFacsimileModel value) {
        
        String ret=null;
        try{

            CiTelephoneFacsimileController ciTelephoneFacsimileController = new CiTelephoneFacsimileController(session, hibernateUtilXml);
            CiTelephoneFacsimileModel ciTelephoneFacsimileModel = new CiTelephoneFacsimileModel();
            
            boolean isFlag=false;

            ciTelephoneFacsimileModel.setCiTelephoneId(value.getCiTelephoneId());
            ciTelephoneFacsimileModel.setFacsimile(value.getFacsimile());

            if (ciTelephoneFacsimileController.getDataById(value.getCiTelephoneId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ciTelephoneFacsimileController.saveCiTelephoneFacsimile(ciTelephoneFacsimileModel);
            } else {
                ret = ciTelephoneFacsimileController.updateCiTelephoneFacsimile(ciTelephoneFacsimileModel);
            }

            displayLog(true, "CiTelephoneFax");
            displayLog(true, "facsimile = "+value.getFacsimile());
            displayLog(true, "foreign key CiTelephoneId = "+value.getCiTelephoneId());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiTelephone Fax " + ret+"\n");
            }else{
                displayLog(true, "Status table CiTelephone Fax " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiTelephone Fax " + e.toString());
            displayLog(true, "Status table CiTelephone Fax " + ret+"\n");
        }

    }

    public void saveUpdateCiAddress(CiAddressModel value) {
        
        String ret=null;
        try{
            
            CiAddressController ciAddressController = new CiAddressController(session, hibernateUtilXml);
            CiAddressModel ciAddressModel = new CiAddressModel();
            BigDecimal ciAddressId;
            BigDecimal getCiAddressId; 
            boolean isFlag=false;
            BigDecimal id=null;

            getCiAddressId = ciAddressController.getMaxCiAddressId();

            if (getCiAddressId == null) {
                ciAddressId = new BigDecimal(FIRST_ID);
            } else {
                ciAddressId = new BigDecimal(getCiAddressId.longValue() + 1);
            }

            ciAddressModel.setId(ciAddressId);
            ciAddressModel.setAdmnistrativeArea(value.getAdmnistrativeArea());
            ciAddressModel.setCity(value.getCity());
            ciAddressModel.setCountry(value.getCountry());
            ciAddressModel.setPostalCode(value.getPostalCode());
            ciAddressModel.setCiContactId(value.getCiContactId());

            if(ciAddressController.getDataById(value.getCiContactId()) == null) {
               isFlag=true;
               id=ciAddressId;
            }else {
               isFlag=false;
               id=ciAddressController.getDataById(value.getCiContactId()).getId();
            }

            if (isFlag) {
                ret = ciAddressController.saveCiAddress(ciAddressModel);
            } else {
                ret = ciAddressController.updateCiAddress(id,ciAddressModel);
            }
            
            displayLog(true, "CiAddress");
            displayLog(true, "id = "+id);
            displayLog(true, "AdmnistrativeArea = "+value.getAdmnistrativeArea());
            displayLog(true, "City = "+value.getCity());
            displayLog(true, "Country = "+value.getCountry());
            displayLog(true, "PostalCode = "+value.getPostalCode());
            displayLog(true, "foreign key CiContactId = "+value.getCiContactId());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiAddress " + ret+"\n");
            }else{
                displayLog(true, "Status table CiAddress " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiAddress " + e.toString());
            displayLog(true, "Status table CiAddress " + ret+"\n");
        }

    }

    public void saveUpdateCiAddressDeliveryPoint(CiAddressDeliveryPointModel value) {
        
        String ret=null;
        
        try{

            CiAddressDeliveryPointModel ciAddressDeliveryPoint = new CiAddressDeliveryPointModel();
            CiAddressDeliveryPointController ciAddressDeliveryPointController = new CiAddressDeliveryPointController(session, hibernateUtilXml);

            boolean isFlag=false;
            
            ciAddressDeliveryPoint.setCi_addressid(value.getCi_addressid());
            ciAddressDeliveryPoint.setDeliveryPoint(value.getDeliveryPoint());

            if (ciAddressDeliveryPointController.getDataById(value.getCi_addressid()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ciAddressDeliveryPointController.saveCiAddressDeliveryPoint(ciAddressDeliveryPoint);
            } else {
                ret = ciAddressDeliveryPointController.updateCiAddressDeliveryPoint(ciAddressDeliveryPoint);
            }
            
            displayLog(true, "CiAddressDeliveryPoint");
            displayLog(true, "DeliveryPoint = "+value.getDeliveryPoint());
            displayLog(true, "foreign key CiaddressId = "+value.getCi_addressid());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiAddressDeliveryPoint " + ret+"\n");
            }else{
                displayLog(true, "Status table CiAddressDeliveryPoint " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error CiAddressDeliveryPoint " + e.toString());
            displayLog(true, "Status table CiAddressDeliveryPoint " + ret+"\n");
        }

    }

    public void saveUpdateCiAddressEmailAddress(CiAddressEmailAddressModel value) {
        
        String ret=null;
        
        try{

            CiAddressEmailAddressModel ciAddressEmailAddressModel = new CiAddressEmailAddressModel();
            CiAddressEmailAddressController ciAddressEmailAddressController = new CiAddressEmailAddressController(session, hibernateUtilXml);

            boolean isFlag=false;
            
            ciAddressEmailAddressModel.setCi_addressid(value.getCi_addressid());
            ciAddressEmailAddressModel.setEmailAddress(value.getEmailAddress());

            if (ciAddressEmailAddressController.getDataById(value.getCi_addressid()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ciAddressEmailAddressController.saveCiAddressEmailAddress(ciAddressEmailAddressModel);
            } else {
                ret = ciAddressEmailAddressController.updateCiAddressEmailAddress(ciAddressEmailAddressModel);
            }
            
            displayLog(true, "CiAddressEmailAddress");
            displayLog(true, "EmailAddress = "+value.getEmailAddress());
            displayLog(true, "foreign key CiaddressId = "+value.getCi_addressid());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiAddressEmailAddress " + ret+"\n");
            }else{
                displayLog(true, "Status table CiAddressEmailAddress " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiAddressEmailAddress " + e.toString());
            displayLog(true, "Status table CiAddressEmailAddress " + ret+"\n");
        }

    }
    
    public void saveUpdateCiAddressOnlineResource(String column,BigDecimal foreignId,CiOnlineResourceModel value){
        
        String ret=null;
        try{
            
            CiOnlineFunctionCodeController codeController = new CiOnlineFunctionCodeController(session, hibernateUtilXml);
            CiOnlineResourceController ciOnlineResourceController = new CiOnlineResourceController(session, hibernateUtilXml);
            CiOnlineResourceModel ciOnlineResourceModel = new CiOnlineResourceModel();

            BigDecimal getIdCiOnline;
            BigDecimal IdCiOnline;
            BigDecimal id=null;
            boolean isFlag=false;
            
            getIdCiOnline = ciOnlineResourceController.getMaxCiOnlineResourceId();
            if(getIdCiOnline==null){
                IdCiOnline = new BigDecimal(FIRST_ID);
            }else{
                IdCiOnline = new BigDecimal(getIdCiOnline.longValue()+1);
            }

            String domainName = value.getFunction_();
            String code=null;
            if(domainName==null){
                code="000";
            }else{
                code=codeController.getDataByDomain(domainName).getCode();
            }

            ciOnlineResourceModel.setId(IdCiOnline);
            ciOnlineResourceModel.setApplicationProfile(value.getApplicationProfile());
            ciOnlineResourceModel.setDescription(value.getDescription());
            ciOnlineResourceModel.setLinkage(value.getLinkage());
            ciOnlineResourceModel.setName(value.getName());
            ciOnlineResourceModel.setProtocol(value.getProtocol());
            ciOnlineResourceModel.setFunction_(code);
            ciOnlineResourceModel.setCiContactId(value.getCiContactId());
            ciOnlineResourceModel.setMdDigitalTransferOptionsId(value.getMdDigitalTransferOptionsId());
            ciOnlineResourceModel.setMdMetadataExtensionInfoId(value.getMdMetadataExtensionInfoId());
            ciOnlineResourceModel.setSvOperationMetadataId(value.getSvOperationMetadataId());

            if(ciOnlineResourceController.getDataById(column,foreignId)==null){
                isFlag=true;
                id=IdCiOnline;
            }else{
                isFlag=false;
                id=ciOnlineResourceController.getDataById(column,foreignId).getId();
            }

            if(isFlag){
                ret=ciOnlineResourceController.saveCiOnlineResource(ciOnlineResourceModel);
            }else{
                ret=ciOnlineResourceController.updateCiOnlineResource(id,ciOnlineResourceModel);
            }
            
            displayLog(true, "CiOnlineResource");
            displayLog(true, "id = "+id);
            displayLog(true, "ApplicationProfile = "+value.getApplicationProfile());
            displayLog(true, "Description = "+value.getDescription());
            displayLog(true, "Linkage = "+value.getLinkage());
            displayLog(true, "Name = "+value.getName());
            displayLog(true, "Protocol = "+value.getProtocol());
            displayLog(true, "Function_ = "+value.getFunction_());
            displayLog(true, "foreign key "+column +"= "+foreignId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table CiOnlineResource " + ret+"\n");
            }else{
                displayLog(true, "Status table CiOnlineResource " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiOnlineResource " + e.toString());
            displayLog(true, "Status table CiOnlineResource " + ret+"\n");
        }
        
    }
    //end save metatadata entity set information

    //save metadata spatial representation information
    public void saveUpdateMdSpatialRepresentation(MdSpatialRepresentationModel value) {
        
        String ret=null;
        try{
            
            MdSpatialRepresentationController mdSpatialRepresentationController = new MdSpatialRepresentationController(session, hibernateUtilXml);
            MdSpatialRepresentationModel mdSpatialRepresentationModel = new MdSpatialRepresentationModel();

            BigDecimal getIdSpatialRepresentation;
            BigDecimal IdSpatialRepresentation;
            boolean isFlag=false;
            BigDecimal id=null;

            getIdSpatialRepresentation = mdSpatialRepresentationController.getMaxMdSpatialRepresentationId();
            if (getIdSpatialRepresentation == null) {
                IdSpatialRepresentation = new BigDecimal(FIRST_ID);
            } else {
                IdSpatialRepresentation = new BigDecimal(getIdSpatialRepresentation.longValue() + 1);
            }

            mdSpatialRepresentationModel.setId(IdSpatialRepresentation);
            mdSpatialRepresentationModel.setExtendsType(value.getExtendsType());
            mdSpatialRepresentationModel.setMdMetadataId(value.getMdMetadataId());

            if (mdSpatialRepresentationController.getDataById(value.getMdMetadataId()) == null) {
                isFlag=true;
                id=IdSpatialRepresentation;
            } else {
                isFlag=false;
                id=mdSpatialRepresentationController.getDataById(value.getMdMetadataId()).getId();
            }

            if (isFlag) {
                ret = mdSpatialRepresentationController.saveMdSpatialRepresentation(mdSpatialRepresentationModel);
            } else {
                ret = mdSpatialRepresentationController.updateMdSpatialRepresentation(id,mdSpatialRepresentationModel);
            }
            
            displayLog(true, "\nMdSpatialRepresentation");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "foreign key mdMetadataId = "+value.getMdMetadataId());
            
            if(ret.contains("Error")){
                displayLog(false, "Status table MdSpatialRepresentation " + ret+"\n");
            }else{
                displayLog(true, "Status table MdSpatialRepresentation " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdSpatialRepresentation " + e.toString());
            displayLog(true, "Status table MdSpatialRepresentation " + ret+"\n");
        }

    }

    public void saveUpdateMdVectorSpatial(MdVectorSpatialRepresentationModel value) {

        String ret=null;
        try{
            
            MdVectorSpatialRepresentationController mdVectorSpatialRepresentationController = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);
            MdTopologyLevelCodeController mdTopologyLevelCodeController = new MdTopologyLevelCodeController(session, hibernateUtilXml);
            MdVectorSpatialRepresentationModel mdVectorSpatialRepresentationModel = new MdVectorSpatialRepresentationModel();

            boolean isFlag=false;
            String code="";
            BigDecimal id=null;
            String domainName = value.getTopologyLevel();
            if(domainName==null){
                code="000";
            }else{
                code = mdTopologyLevelCodeController.getDataByDomain(domainName).getCode();
            }

            mdVectorSpatialRepresentationModel.setId(value.getId());
            mdVectorSpatialRepresentationModel.setTopologyLevel(code);

            if (mdVectorSpatialRepresentationController.getDataById(value.getId()) == null) {
                isFlag=true;
                id = value.getId();
            } else {
                isFlag=false;
                id=mdVectorSpatialRepresentationController.getDataById(value.getId()).getId();
            }

            if (isFlag) {
                ret = mdVectorSpatialRepresentationController.saveMdVectorSpatialRepresentation(mdVectorSpatialRepresentationModel);
            } else {
                ret = mdVectorSpatialRepresentationController.updateMdVectorSpatialRepresentation(id,mdVectorSpatialRepresentationModel);
            }

            displayLog(true, "MdVectorSpatialRepresentation");
            displayLog(true, "id = "+id); 
            displayLog(true, "TopologyLevel = "+code);           
            
            if(ret.contains("Error")){
                displayLog(false, "Status table MdVectorSpatialRepresentation " + ret+"\n");
            }else{
                displayLog(true, "Status table MdVectorSpatialRepresentation " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdVectorSpatialRepresentationn " + e.toString());
            displayLog(true, "Status table MdVectorSpatialRepresentation " + ret+"\n");
        }

    }

    public void saveUpdateMdGeometricObject(boolean isSave,BigDecimal id,MdGeometricObjectsModel value) {

        MdGeometricObjectsController mdGeometricObjectsController = new MdGeometricObjectsController(session, hibernateUtilXml);
        MdGeometricObjectsModel mdGeometricObjectsModel = new MdGeometricObjectsModel();
        MdGeometricObjectTypeCodeController mdGeometricObjectTypeCodeController = new MdGeometricObjectTypeCodeController(session, hibernateUtilXml);
        BigDecimal getIdMdGeometricObject;
        BigDecimal IdMdGeometricObject;
        String ret = null;
      
        try {

                String domainName = value.getGeometricObjectType();
                String code="";
                if(domainName==null){
                    code="000";
                }else{
                    code= mdGeometricObjectTypeCodeController.getDataByDomain(domainName).getCode();
                }

                    if (isSave){
                        
                            getIdMdGeometricObject = mdGeometricObjectsController.getMaxMdGeometricObjectsId();
                            if (getIdMdGeometricObject == null) {
                                IdMdGeometricObject = new BigDecimal(FIRST_ID);
                            } else {
                                IdMdGeometricObject = new BigDecimal(getIdMdGeometricObject.longValue() + 1);
                            }

                            mdGeometricObjectsModel.setId(IdMdGeometricObject);
                            mdGeometricObjectsModel.setGeometricObjectCount(value.getGeometricObjectCount());
                            mdGeometricObjectsModel.setGeometricObjectType(code);
                            mdGeometricObjectsModel.setMdVectorSpatialRepresentId(value.getMdVectorSpatialRepresentId());

                            ret = mdGeometricObjectsController.saveMdGeometricObjects(mdGeometricObjectsModel);

                            jTextAreaLogData.append("Status table MdGeometricObject " + ret + "\n");


                    } else {      

                            mdGeometricObjectsModel.setId(id);
                            mdGeometricObjectsModel.setGeometricObjectCount(value.getGeometricObjectCount());
                            mdGeometricObjectsModel.setGeometricObjectType(code);
                            mdGeometricObjectsModel.setMdVectorSpatialRepresentId(value.getMdVectorSpatialRepresentId());

                            ret = mdGeometricObjectsController.updateMdGeometricObject(id,mdGeometricObjectsModel);

                            jTextAreaLogData.setForeground(Color.BLACK);
                            jTextAreaLogData.append("Status table MdGeometricObject " + ret + "\n");

                    }
            
        }catch(Exception e){
            
            jTextAreaLogData.setForeground(Color.red);
            jTextAreaLogData.append("Error MdGeometricObject " + e.toString() + "\n");
        }

    }
    
    public void saveUpdateMdGeometricObject(BigDecimal mdVectorSpatialRepresentId) {

        String ret = null;
        
        try{
            MdGeometricObjectsController mdGeometricObjectsController = new MdGeometricObjectsController(session, hibernateUtilXml);
            MdGeometricObjectsModel mdGeometricObjectsModel = new MdGeometricObjectsModel();
            MdGeometricObjectTypeCodeController mdGeometricObjectTypeCodeController = new MdGeometricObjectTypeCodeController(session, hibernateUtilXml);
            BigDecimal getIdMdGeometricObject;
            BigDecimal IdMdGeometricObject;
            boolean flag=false;
            BigDecimal id=null;
            

            for(VarSpatialRepresentationInformation list : listMdGeometricObject){

                String domainName = list.getGeometricObjectType();
                String code="";
                if(domainName==null){
                    code="000";
                }else{
                    code= mdGeometricObjectTypeCodeController.getDataByDomain(domainName).getCode();
                }

                getIdMdGeometricObject = mdGeometricObjectsController.getMaxMdGeometricObjectsId();
                if (getIdMdGeometricObject == null) {
                    IdMdGeometricObject = new BigDecimal(FIRST_ID);
                } else {
                    IdMdGeometricObject = new BigDecimal(getIdMdGeometricObject.longValue() + 1);
                }

                BigDecimal geomObj;
                if(list.getGeometricObjectCount().equalsIgnoreCase("null") || list.getGeometricObjectCount()==null){
                    geomObj = BigDecimal.ZERO;
                }else{
                    geomObj = new BigDecimal(list.getGeometricObjectCount());
                }
                                
                mdGeometricObjectsModel.setId(IdMdGeometricObject);
                mdGeometricObjectsModel.setGeometricObjectCount(geomObj);
                mdGeometricObjectsModel.setGeometricObjectType(code);
                mdGeometricObjectsModel.setMdVectorSpatialRepresentId(mdVectorSpatialRepresentId);

                if(mdGeometricObjectsController.getDataByProperty(mdVectorSpatialRepresentId,code)==null){
                    flag=true;
                    id = IdMdGeometricObject;
                }else{
                    flag=false;
                    id = mdGeometricObjectsController.getDataByProperty(mdVectorSpatialRepresentId,code).getId();
                }

                if(flag){
                      ret = mdGeometricObjectsController.saveMdGeometricObjects(mdGeometricObjectsModel);

                }else{
                      ret = mdGeometricObjectsController.updateMdGeometricObject(id,mdGeometricObjectsModel);
                }
                
                displayLog(true, "MdGeometricObject");
                displayLog(true, "id = "+id);
                displayLog(true, "GeometricObjectCount = "+geomObj);
                displayLog(true, "GeometricObjectType = "+code);
                displayLog(true, "foreign key MdVectorSpatialRepresentId = "+mdVectorSpatialRepresentId);
                

                if(ret.contains("Error")){
                    displayLog(false, "Status table MdGeometricObject " + ret+"\n");
                }else{
                    displayLog(true, "Status table MdGeometricObject " + ret+"\n");
                }
            } 

        }catch(Exception e){
            
                displayLog(false, "Error MdGeometricObject " + e.toString());
                displayLog(true, "Status table MdGeometricObject " + ret+"\n");
        }

    }
    //end save spatial representation information

    //save reference system
    public void saveUpdateReferenceSystem(String column,BigDecimal foreignId,MdReferenceSystemModel value) {
        
        String ret=null;
        try{

            MdReferenceSystemController mdReferenceSystemController = new MdReferenceSystemController(session, hibernateUtilXml);
            MdReferenceSystemModel mdReferenceSystemModel = new MdReferenceSystemModel();
            BigDecimal getIdMdReferenceSystem;
            BigDecimal IdReferenceSystem;

            boolean isFlag=false;
            BigDecimal id=null;    

            getIdMdReferenceSystem = mdReferenceSystemController.getMaxReferenceSystemId();

            if (getIdMdReferenceSystem == null) {
                IdReferenceSystem = new BigDecimal(FIRST_ID);
            } else {
                IdReferenceSystem = new BigDecimal(getIdMdReferenceSystem.longValue() + 1);
            }

            mdReferenceSystemModel.setId(IdReferenceSystem);
            mdReferenceSystemModel.setMdMetadataId(value.getMdMetadataId());
            mdReferenceSystemModel.setLiSourceId(value.getLiSourceId());

            if (mdReferenceSystemController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = IdReferenceSystem;
            } else {
                isFlag=false;
                id = mdReferenceSystemController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdReferenceSystemController.saveMdReferenceSystem(mdReferenceSystemModel);
            } else {
                ret = mdReferenceSystemController.updateMdReferenceSystem(id,mdReferenceSystemModel);
            }
            
            displayLog(true, "MdReferenceSystem");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key "+column+" = "+foreignId);


            if(ret.contains("Error")){
                displayLog(false, "Status table MdReferenceSystem " + ret+"\n");
            }else{
                displayLog(true, "Status table MdReferenceSystem " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false,"Error MdReferenceSystem " + e.toString());
            displayLog(true, "Status table MdReferenceSystem " + ret+"\n");
        }

    }

    public void saveUpdateRsIdentifier(String column,BigDecimal foreignId,RsIdentifierModel value) {
        
        String ret=null;
        try{

            RsIdentifierController rsIdentifierController = new RsIdentifierController(session, hibernateUtilXml);
            RsIdentifierModel rsIdentifierModel = new RsIdentifierModel();

            boolean isFlag=false;
            BigDecimal id=null;
            BigDecimal rsIdentifierId;
            BigDecimal getRsIdentifierId;

            getRsIdentifierId = rsIdentifierController.getMaxRsIdentifierId();
            if(getRsIdentifierId == null) {
                rsIdentifierId = new BigDecimal(FIRST_ID);
            } else {
                rsIdentifierId = new BigDecimal(getRsIdentifierId.longValue() + 1);
            }

            rsIdentifierModel.setId(rsIdentifierId);
            rsIdentifierModel.setCodeSpace(value.getCodeSpace());
            rsIdentifierModel.setCode(value.getCode());
            rsIdentifierModel.setVersion(value.getVersion());
            rsIdentifierModel.setMdReferenceSystemId(value.getMdReferenceSystemId());
            rsIdentifierModel.setMdIdentifierId(value.getMdIdentifierId());

            if (rsIdentifierController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id=rsIdentifierId;
            } else {
                isFlag=false;
                id = rsIdentifierController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = rsIdentifierController.saveRsIdentifier(rsIdentifierModel);
            } else {
                ret = rsIdentifierController.updateRsIdentifier(id,rsIdentifierModel);
            }

            displayLog(true, "RsIdentifier");
            displayLog(true, "id = "+id);
            displayLog(true, "CodeSpace = "+value.getCodeSpace());
            displayLog(true, "Code = "+value.getCode());
            displayLog(true, "Version = "+value.getVersion());
            displayLog(true, "foreign key "+column+" = "+foreignId);


            if(ret.contains("Error")){
                displayLog(false, "Status table RsIdentifier " + ret+"\n");
            }else{
                displayLog(true, "Status table RsIdentifier " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error RsIdentifier " + e.toString() );
            displayLog(true, "Status table RsIdentifier " + ret+"\n");
        }
        

    }

    public void saveUpdateCiCitation(String column,BigDecimal foreignId,CiCitationModel value) {
        
        String ret=null;
        try{

            CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
            CiCitationModel ciCitationModel = new CiCitationModel();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dt;
            BigDecimal ciCitationId;
            BigDecimal id=null;
            boolean isFlag=false;

            BigDecimal getIdCitation = ciCitationController.getMaxCiCitationId();
            if (getIdCitation == null) {
                ciCitationId = new BigDecimal(FIRST_ID);
            } else {
                ciCitationId = new BigDecimal(getIdCitation.longValue() + 1);
            }

            try {
                String date_ = value.getStringEditionDate();
                if (date_.equals("-") || date_==null) {
                    ciCitationModel.setEditionDate(null);
                } else {
                    dt = dateFormat.parse(date_);
                   ciCitationModel.setEditionDate(dt);
                }

            } catch (ParseException ex) {
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            }catch(NullPointerException n){
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }

            ciCitationModel.setId(ciCitationId);
            ciCitationModel.setTitle(value.getTitle());
            ciCitationModel.setIsbn(value.getIsbn());
            ciCitationModel.setIssn(value.getIssn());
            ciCitationModel.setEdition(value.getEdition());
            ciCitationModel.setCollectiveTitle(value.getCollectiveTitle());
            ciCitationModel.setOtherCitationDetails(value.getOtherCitationDetails());
            ciCitationModel.setDqConformanceResultId(value.getDqConformanceResultId());
            ciCitationModel.setDqElementId(value.getDqElementId());
            ciCitationModel.setLiSourceId(value.getLiSourceId());
            ciCitationModel.setMdAggregateInfoId(value.getMdAggregateInfoId());
            ciCitationModel.setMdApplicationschemaInfoId(value.getMdApplicationschemaInfoId());
            ciCitationModel.setMdFeatureCatalogueDescId(value.getMdFeatureCatalogueDescId());
            ciCitationModel.setMdGeoReferenceAbleId(value.getMdGeoReferenceAbleId());
            ciCitationModel.setMdIdentificationId(value.getMdIdentificationId());
            ciCitationModel.setMdIdentifierId(value.getMdIdentifierId());
            ciCitationModel.setMdKeywordId(value.getMdKeywordId());
            ciCitationModel.setMdPortrayalCatalogueRefId(value.getMdPortrayalCatalogueRefId());
            ciCitationModel.setRsIdentifierId(value.getRsIdentifierId());
            ciCitationModel.setSvServiceIdentificationId(value.getSvServiceIdentificationId());

            if (ciCitationController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = ciCitationId;
            } else {
                isFlag=false;
                id = ciCitationController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = ciCitationController.saveCiCitation(ciCitationModel);
            } else {
                ret = ciCitationController.updateCiCitation(id,ciCitationModel);
            }
            
            displayLog(true, "CiCitation");
            displayLog(true, "id = "+id);
            displayLog(true, "Title = "+value.getTitle());
            displayLog(true, "Isbn = "+value.getIsbn());
            displayLog(true, "Issn = "+value.getIssn());
            displayLog(true, "Edition = "+value.getEdition());
            displayLog(true, "CollectiveTitle = "+value.getCollectiveTitle());
            displayLog(true, "EditionDate = "+value.getStringEditionDate());
            displayLog(true, "OtherCitationDetails = "+value.getOtherCitationDetails());
            displayLog(true, "foreign key "+column+" = "+foreignId);


            if(ret.contains("Error")){
                displayLog(false, "Status table CiCitation " + ret+"\n");
            }else{
                displayLog(true, "Status table CiCitation " + ret+"\n");
            }
             
        }catch(Exception e){
            
            displayLog(false, "Error CiCitation " + e.toString());
            displayLog(true, "Status table CiCitation " + ret+"\n");
        }

    }

    public void saveUpdateCiDate(CiDateModel value) {
        
        String ret=null;
        try{

            CiDateController ciDateController = new CiDateController(session, hibernateUtilXml);
            CiDateModel ciDateModel = new CiDateModel();
            CiDateTypeCodeController ciDateTypeCodeController = new CiDateTypeCodeController(session, hibernateUtilXml);
            BigDecimal getCiDateId;
            BigDecimal cidateId;
            boolean isFlag=false;
            BigDecimal id=null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dt;

            String code="";
            if(value.getDateType()==null){
                code="000";
            }else{
                code = ciDateTypeCodeController.getDataByDomain(value.getDateType()).getCode();
            }

            getCiDateId = ciDateController.getMaxCiDateId();
            if (getCiDateId == null) {
                cidateId = new BigDecimal(FIRST_ID);
            } else {
                cidateId = new BigDecimal(getCiDateId.longValue() + 1);
            }

            try {
                String date_ = value.getStringDate_();
                if (date_.equals("-") || date_==null) {
                    ciDateModel.setDate_(null);
                } else {
                    dt = dateFormat.parse(date_);
                    ciDateModel.setDate_(dt);
                }

            } catch (ParseException ex) {
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            }catch(NullPointerException n){
                 Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }

            ciDateModel.setId(cidateId);
            ciDateModel.setDateType(code);
            ciDateModel.setCiCitationId(value.getCiCitationId());

            if (ciDateController.getDataById(value.getCiCitationId()) == null) {
                isFlag=true;
                id = cidateId;
            } else {
                isFlag=false;
                id = ciDateController.getDataById(value.getCiCitationId()).getId();
            }

            if (isFlag) {
                ret = ciDateController.saveCiDate(ciDateModel);
            } else {
                ret = ciDateController.updateCiDate(id,ciDateModel);
            }
            
            displayLog(true, "Cidate");
            displayLog(true, "id = "+id);
            displayLog(true, "date_ = "+value.getStringDate_());
            displayLog(true, "DateType = "+value.getDateType());
            displayLog(true, "foreign key CiCitationId = "+value.getCiCitationId());

            if(ret.contains("Error")){
                displayLog(false, "Status table CiDate " + ret+"\n");
            }else{
                displayLog(true, "Status table CiDate " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiDate " + e.toString());
            displayLog(true, "Status table CiDate " + ret+"\n");
        }

    }

    public void saveUpdateMdIdentifier(String column,BigDecimal foreignId,MdIdentifierModel value) {

        String ret=null;
        try{
            
            MdIdentifierController mdIdentifierController = new MdIdentifierController(session, hibernateUtilXml);
            MdIdentifierModel mdIdentifierModel = new MdIdentifierModel();

            BigDecimal getIdMdIdentifier;
            BigDecimal idMdIdentifier;
            BigDecimal id=null;
            boolean isFlag=false;

            getIdMdIdentifier = mdIdentifierController.getMaxMdIdentifierId();
            if (getIdMdIdentifier == null) {
                idMdIdentifier = new BigDecimal(FIRST_ID);
            } else {
                idMdIdentifier = new BigDecimal(getIdMdIdentifier.longValue() + 1);
            }

            mdIdentifierModel.setId(idMdIdentifier);
            mdIdentifierModel.setExtendsType(value.getExtendsType());
            mdIdentifierModel.setCode(value.getCode());
            mdIdentifierModel.setCiCitationId(value.getCiCitationId());
            mdIdentifierModel.setDqElementId(value.getDqElementId());
            mdIdentifierModel.setExGeographicDescriptionId(value.getExGeographicDescriptionId());
            mdIdentifierModel.setMdAggregationInfoId(value.getMdAggregationInfoId());
            mdIdentifierModel.setMdImageDescriptionIdIqc(value.getMdImageDescriptionIdIqc());
            mdIdentifierModel.setMdImageDescriptionIdPlc(value.getMdImageDescriptionIdPlc());

            if (mdIdentifierController.getDataById(column,foreignId) == null) {
               isFlag=true;
               id = idMdIdentifier;
            } else {
               isFlag=false;
               id = mdIdentifierController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdIdentifierController.saveMdIdentifier(mdIdentifierModel);
            } else {
                ret = mdIdentifierController.updateMdIdentifier(id,mdIdentifierModel);
            }
            
            displayLog(true, "MdIdentifier");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "Code = "+value.getCode());
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
                displayLog(false, "Status table MdIdentifier " + ret+"\n");
            }else{
                displayLog(true, "Status table MdIdentifier " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdIdentifier " + e.toString());
            displayLog(true, "Status table MdIdentifier " + ret+"\n");
        }

    }

    public void SaveUpdateCitationPresentationForm(CiCitationPresentationFormModel value) {

        String ret=null;
        try{
        
            CiCitationPresentationFormController ccpfc = new CiCitationPresentationFormController(session, hibernateUtilXml);
            CiCitationPresentationFormModel CiCitationPresentationFormModel = new CiCitationPresentationFormModel();
            CiPresentationFormCodeController cpfcc = new CiPresentationFormCodeController(session, hibernateUtilXml);
           
            boolean isFlag=false;
            String code="";
            String domain = value.getPresentationForm();
            try{
                if(domain==null){
                    code="000";
                }else{
                    code=cpfcc.getDataByDomain(domain).getCode();
                }
            }catch(NullPointerException n){
                 Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }


            CiCitationPresentationFormModel.setCiCitationId(value.getCiCitationId());
            CiCitationPresentationFormModel.setPresentationForm(code);       

            if (ccpfc.getDataById(value.getCiCitationId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ccpfc.saveCiCitationPresentationForm(CiCitationPresentationFormModel);
            } else {
                ret = ccpfc.updateCiCitationPresentationForm(CiCitationPresentationFormModel);
            }
            
            displayLog(true, "CiCitationPresentationForm");
            displayLog(true, "PresentationForm = "+code);
            displayLog(true, "foreign key CiCitationId = "+value.getCiCitationId());

            if(ret.contains("Error")){
                displayLog(false, "Status table CiCitationPresentationForm " + ret+"\n");
            }else{
                displayLog(true, "Status table CiCitationPresentationForm " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CiCitationPresentationForm " + e.toString());
            displayLog(true, "Status table CiCitationPresentationForm " + ret+"\n");
        }

    }
    
    //end save reference system
    
    //save maintenance information
    public void SaveUpdateMdMaintenanceInfo(String column,BigDecimal foreignId, MdMaintenanceInfoModel value) {

        String ret=null;
        try{
            
            MdMaintenanceFrequencyCodeController mdMaintenanceFrequencyCodeController = new MdMaintenanceFrequencyCodeController(session, hibernateUtilXml);
            MdMaintenanceInfoController mdMaintenanceInfoController = new MdMaintenanceInfoController(session, hibernateUtilXml);
            MdMaintenanceInfoModel mdMaintenanceInfoModel = new MdMaintenanceInfoModel();

            String domainName = value.getMaintenanceAndUpdateFrequency();
            String code="";
            if(domainName==null){
                code="000";
            }else{
                code = mdMaintenanceFrequencyCodeController.getDataByDomain(domainName).getCode();
            }

            BigDecimal getIdMaintenance;
            BigDecimal idMaintenance;
            BigDecimal id=null;
            boolean isFlag=false;
            
            getIdMaintenance = mdMaintenanceInfoController.getMaxMdMaintenanceInfoId();
            if (getIdMaintenance == null) {
                idMaintenance = new BigDecimal(FIRST_ID);
            } else {
                idMaintenance = new BigDecimal(getIdMaintenance.longValue() + 1);
            }

            mdMaintenanceInfoModel.setId(idMaintenance);
            mdMaintenanceInfoModel.setMaintenanceAndUpdateFrequency(code);
            mdMaintenanceInfoModel.setMdIdentificationId(value.getMdIdentificationId());
            mdMaintenanceInfoModel.setMdMetadataId(value.getMdMetadataId());

            if (mdMaintenanceInfoController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id=idMaintenance;
            } else {
                isFlag=false;
                id = mdMaintenanceInfoController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdMaintenanceInfoController.saveMdMaintenanceInfo(mdMaintenanceInfoModel);
            } else {
                ret = mdMaintenanceInfoController.updateMdMaintenanceInfo(id,mdMaintenanceInfoModel);
            }
            
            displayLog(true, "MdMaintenanceInfo");
            displayLog(true, "id = "+id);
            displayLog(true, "MaintenanceAndUpdateFrequency = "+code);
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
                displayLog(false, "Status table MdMaintenanceInfo " + ret+"\n");
            }else{
                displayLog(true, "Status table MdMaintenanceInfo " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdMaintenanceInfo " + e.toString());
            displayLog(true, "Status table MdMaintenanceInfo " + ret+"\n");
        }

    }
    //end save maintenance information

    //save content information
    public void SaveUpdateMdContentInfo(MdContentInfoModel value) {
        
        String ret=null;
        
        try{

            MdContentInfoController mdContentInfoController = new MdContentInfoController(session, hibernateUtilXml);
            MdContentInfoModel mdContentInfoModel = new MdContentInfoModel();

            boolean isFlag=false;
            BigDecimal id=null;
            BigDecimal getIdMdContentInfo;
            BigDecimal IdMdContentInfo;

            getIdMdContentInfo = mdContentInfoController.getMaxMdContentInfoId();
            if (getIdMdContentInfo == null) {
                IdMdContentInfo = new BigDecimal(FIRST_ID);
            } else {
                IdMdContentInfo = new BigDecimal(getIdMdContentInfo.longValue() + 1);
            }

            mdContentInfoModel.setId(IdMdContentInfo);
            mdContentInfoModel.setExtendsType(value.getExtendsType());
            mdContentInfoModel.setMdMetadataId(value.getMdMetadataId());

            if (mdContentInfoController.getDataById(value.getMdMetadataId()) == null) {
                isFlag=true;
                id=IdMdContentInfo;
            } else {
                isFlag=false;
                id = mdContentInfoController.getDataById(value.getMdMetadataId()).getId();
            }

            if (isFlag) {
                ret = mdContentInfoController.saveMdContentInfo(mdContentInfoModel);
            } else {
                ret = mdContentInfoController.updateMdContentInfo(id,mdContentInfoModel);
            }
            
            displayLog(true, "\nMdContentInfo");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "foreign key MdMetadataId =  "+value.getMdMetadataId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdContentInfo " + ret+"\n");
            }else{
                displayLog(true, "Status table MdContentInfo " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error MdContentInfo " + e.toString());
            displayLog(true, "Status table MdContentInfo " + ret+"\n");
        }
    }

    public void SaveUpdateMdCoverageDescription(MdCoverageDescriptionModel value) {
        
        String ret=null;
        try{

            MdCoverageContentTypeCodeController mdCoverageContentTypeCodeController = new MdCoverageContentTypeCodeController(session, hibernateUtilXml);
            MdCoverageDescriptionController mdCoverageDescriptionController = new MdCoverageDescriptionController(session, hibernateUtilXml);
            MdCoverageDescriptionModel mdCoverageDescriptionModel = new MdCoverageDescriptionModel();

            BigDecimal getIdMdCoverageDescription;
            BigDecimal IdMdCoverageDescription;
            BigDecimal id=null;
            boolean isFlag=false;

            String code=null;
            String domainName = value.getContentType();
            if(domainName==null){
                code="000";
            }else{
                code = mdCoverageContentTypeCodeController.getDataByDomain(domainName).getCode();
            }     

            getIdMdCoverageDescription = mdCoverageDescriptionController.getMaxMdCoverageDescriptionId();
            if (getIdMdCoverageDescription == null) {
                IdMdCoverageDescription = new BigDecimal(FIRST_ID);
            } else {
                IdMdCoverageDescription = new BigDecimal(getIdMdCoverageDescription.longValue() + 1);
            }

            mdCoverageDescriptionModel.setId(IdMdCoverageDescription);
            mdCoverageDescriptionModel.setAttributeDescription(value.getAttributeDescription());
            mdCoverageDescriptionModel.setContentType(code);
            mdCoverageDescriptionModel.setMdContentInfoId(value.getMdContentInfoId());

            if (mdCoverageDescriptionController.getDataById(value.getMdContentInfoId()) == null) {
                isFlag=true;
                id = IdMdCoverageDescription;
            } else {
                isFlag=false;
                id = mdCoverageDescriptionController.getDataById(value.getMdContentInfoId()).getId();
            }

            if (isFlag) {
                ret = mdCoverageDescriptionController.saveMdCoverageDescription(mdCoverageDescriptionModel);
            } else {
                ret = mdCoverageDescriptionController.updateMdCoverageDescription(id,mdCoverageDescriptionModel);
            }
            
            displayLog(true, "Mdcoveragedescription");
            displayLog(true, "id = "+id);
            displayLog(true, "AttributeDescription = "+value.getAttributeDescription());
            displayLog(true, "ContentType = "+code);
            displayLog(true, "foreign key MdContentInfoId =  "+value.getMdContentInfoId());

            if(ret.contains("Error")){
                displayLog(false, "Status table Mdcoveragedescription " + ret+"\n");
            }else{
                displayLog(true, "Status table Mdcoveragedescription " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error Mdcoveragedescription " + e.toString());
            displayLog(true, "Status table Mdcoveragedescription " + ret+"\n");
        }

    }
    //end save content information

    //save potrayal catalogue information
    public void SaveUpdateMdPotrayalCatalogueReference(MdPortrayalCatalogueRefModel value) {

        String ret=null;
        try{
            
            MdPortrayalCatalogueRefController mdPortrayalCatalogueRefController = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
            MdPortrayalCatalogueRefModel mdPortrayalCatalogueRefModel = new MdPortrayalCatalogueRefModel();

            BigDecimal getIdMdPortrayalCatalagoue;
            BigDecimal idMdPortrayalCatalogue;
            BigDecimal id=null;
            boolean isFlag;

            getIdMdPortrayalCatalagoue = mdPortrayalCatalogueRefController.getMaxMdPortrayalCatalogueRefId();
            if (getIdMdPortrayalCatalagoue == null) {
                idMdPortrayalCatalogue = new BigDecimal(FIRST_ID);
            } else {
                idMdPortrayalCatalogue = new BigDecimal(getIdMdPortrayalCatalagoue.longValue() + 1);
            }

            mdPortrayalCatalogueRefModel.setId(idMdPortrayalCatalogue);
            mdPortrayalCatalogueRefModel.setMdMetadataId(value.getMdMetadataId());

            if (mdPortrayalCatalogueRefController.getDataById(value.getMdMetadataId()) == null) {
                isFlag=true;
                id = idMdPortrayalCatalogue;
            } else {
                isFlag=false;
                id = mdPortrayalCatalogueRefController.getDataById(value.getMdMetadataId()).getId();
            }

            if (isFlag) {
                ret = mdPortrayalCatalogueRefController.saveMdPortrayalCatalogueRef(mdPortrayalCatalogueRefModel);
            } else {
                ret = mdPortrayalCatalogueRefController.updateMdPortyalCatalagueRef(id,mdPortrayalCatalogueRefModel);

            }
            
            displayLog(true, "\nMdPortrayalCatalogueRef");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key MdMetadataId =  "+value.getMdMetadataId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdPortrayalCatalogueRef " + ret+"\n");
            }else{
                displayLog(true, "Status table MdPortrayalCatalogueRef " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdPortrayalCatalogueRef " + e.toString());
            displayLog(true, "Status table MdPortrayalCatalogueRef " + ret+"\n");
        }

    }

    public void saveUpdateCiCitationAlternateTitle(CiCitationAlternateTitleModel value) {
        
        String ret=null;
        try{

            CiCitationAlternateTitleController ciCitationAlternateTitleController = new CiCitationAlternateTitleController(session, hibernateUtilXml);
            CiCitationAlternateTitleModel citationAlternateTitleModel = new CiCitationAlternateTitleModel();

            boolean isFlag=false;
            BigDecimal id=null;

            citationAlternateTitleModel.setAlternateTitle(value.getAlternateTitle());
            citationAlternateTitleModel.setCi_citationid(value.getCi_citationid());

            if (ciCitationAlternateTitleController.getDataById(value.getCi_citationid()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = ciCitationAlternateTitleController.getDataById(value.getCi_citationid()).getCi_citationid();
            }

            if (isFlag) {
                ret = ciCitationAlternateTitleController.saveCiCitationAlternateTitle(citationAlternateTitleModel);
            } else {
                ret = ciCitationAlternateTitleController.updateCiCitationAlternateTitle(id,citationAlternateTitleModel);
            }
            
            displayLog(true, "CicitationAlteranateTitle");
            displayLog(true, "AlternateTitle = "+value.getAlternateTitle());
            displayLog(true, "foreign key Cicitationid =  "+value.getCi_citationid());

            if(ret.contains("Error")){
                displayLog(false, "Status table CicitationAlteranateTitle " + ret+"\n");
            }else{
                displayLog(true, "Status table CicitationAlteranateTitle " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error CicitationAlteranateTitle " + e.toString());
            displayLog(true, "Status table CicitationAlteranateTitle " + ret+"\n");
        }

    }
    //end save potrayal catalogue information

    //save identification information
    public void saveUpdateMdIdentification(MdIdentificationModel value) {
        
        String ret=null;
        try{ 
            MdIdentificationController mdIdentificationController = new MdIdentificationController(session, hibernateUtilXml);
            MdIdentificationModel mdIdentificationModel = new MdIdentificationModel();

            BigDecimal getMdIdentificationId;
            BigDecimal mdIdentificationId;
            BigDecimal id=null;
            boolean isFlag=false;

            getMdIdentificationId = mdIdentificationController.getMaxMdIdentificationId();
            if (getMdIdentificationId == null) {
                mdIdentificationId = new BigDecimal(FIRST_ID);
            } else {
                mdIdentificationId = new BigDecimal(getMdIdentificationId.longValue() + 1);
            }

            mdIdentificationModel.setId(mdIdentificationId);
            mdIdentificationModel.setAbstract_(value.getAbstract_());
            mdIdentificationModel.setExtendsType(value.getExtendsType());
            mdIdentificationModel.setPurpose(value.getPurpose());
            mdIdentificationModel.setMdMetadataId(value.getMdMetadataId());

            if (mdIdentificationController.getDataById(value.getMdMetadataId()) == null) {
                isFlag=true;
                id = mdIdentificationId;
            } else {
                isFlag=false;
                id = mdIdentificationController.getDataById(value.getMdMetadataId()).getId();
            }

            if (isFlag) {
                ret = mdIdentificationController.saveMdIdentification(mdIdentificationModel);
            } else {
                ret = mdIdentificationController.updateMdIdentification(id,mdIdentificationModel);
            }
            
            displayLog(true, "\nMdIdentification");
            displayLog(true, "id = "+id);
            displayLog(true, "Abstract_ = "+value.getAbstract_());
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "Purpose = "+value.getPurpose());
            displayLog(true, "foreign key MdMetadataId =  "+value.getMdMetadataId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdIdentification " + ret+"\n");
            }else{
                displayLog(true, "Status table MdIdentification " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error MdIdentification " + e.toString());
            displayLog(true, "Status table MdIdentification " + ret+"\n");
        }

    }

    public void saveUpdateMdIdentificationStatus(MdIdentificationStatusModel value) {
        
        String ret=null;
        try{

            MdIdentificationStatusController statusController = new MdIdentificationStatusController(session, hibernateUtilXml);
            MdIdentificationStatusModel statusModel = new MdIdentificationStatusModel();
            MdProgressCodeController codeController = new MdProgressCodeController(session, hibernateUtilXml);

            String code="";
            boolean isFlag=false;
            BigDecimal id=null;

            String domainName = value.getStatus();       
            if(domainName==null){
                code="000";
            }else{
                code= codeController.getDataByDomain(value.getStatus()).getCode();
            }

            statusModel.setStatus(code);
            statusModel.setMdIdentificationId(value.getMdIdentificationId());

            if (statusController.getDataById(value.getMdIdentificationId(),code) == null) {
               isFlag=true;
            } else {
                isFlag=false;
                id = statusController.getDataById(value.getMdIdentificationId(),code).getMdIdentificationId();
            }

            if (isFlag) {
                ret = statusController.saveMdIdentificationStatus(statusModel);
            } else {
                ret = statusController.updateMdIdentificationStatus(id,statusModel);
            }
            
            displayLog(true, "MdIdentificationStatus");
            displayLog(true, "status = "+code);
            displayLog(true, "foreign key MdIdentificationId =  "+value.getMdIdentificationId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdIdentificationStatus " + ret+"\n");
            }else{
                displayLog(true, "Status table MdIdentificationStatus " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error MdIdentificationStatus " + e.toString());
            displayLog(true, "Status table MdIdentificationStatus " + ret+"\n");
        }

    }
    
    public void saveUpdateMdIdentificationCredit(MdIdentificationCreditModel value) {
        
        String ret=null;
        try{

            MdIdentificationCreditController statusController = new MdIdentificationCreditController(session, hibernateUtilXml);
            MdIdentificationCreditModel statusModel = new MdIdentificationCreditModel();
  
            boolean isFlag=false;
            BigDecimal id=null;


            statusModel.setCredit(value.getCredit());
            statusModel.setMdIdentificationId(value.getMdIdentificationId());

            if (statusController.getDataById(value.getMdIdentificationId()) == null) {
               isFlag=true;
            } else {
                isFlag=false;
                id = statusController.getDataById(value.getMdIdentificationId()).getMdIdentificationId();
            }

            if (isFlag) {
                ret = statusController.saveMdIdentificationCredit(statusModel);
            } else {
                ret = statusController.updateMdIdentificationCredit(id,statusModel);
            }
            
            displayLog(true, "MdIdentificationCredit");
            displayLog(true, "credit = "+value.getCredit());
            displayLog(true, "foreign key MdIdentificationId =  "+value.getMdIdentificationId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdIdentificationCredit " + ret+"\n");
            }else{
                displayLog(true, "Status table MdIdentificationCredit " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error MdIdentificationCredit " + e.toString());
            displayLog(true, "Status table MdIdentificationCredit " + ret+"\n");
        }

    }
    
    public void saveUpdateMdBrowseGraphic(MdBrowseGraphicModel value) {

        String ret=null;
        try{
            
            MdBrowseGraphicController mdBrowseGraphicController = new MdBrowseGraphicController(session, hibernateUtilXml);
            MdBrowseGraphicModel mdBrowseGraphicModel = new MdBrowseGraphicModel();

            boolean isFlag=false;
            BigDecimal id=null;
            BigDecimal getIdMdBrowserGraphic;
            BigDecimal idMdBrowserGraphic;

            getIdMdBrowserGraphic = mdBrowseGraphicController.getMaxMdBrowseGraphicId();
            if (getIdMdBrowserGraphic == null) {
                idMdBrowserGraphic = new BigDecimal(FIRST_ID);
            } else {
                idMdBrowserGraphic = new BigDecimal(getIdMdBrowserGraphic.longValue() + 1);
            }

            mdBrowseGraphicModel.setId(idMdBrowserGraphic);
            mdBrowseGraphicModel.setMdIdentificationId(value.getMdIdentificationId());
            mdBrowseGraphicModel.setFileName(value.getFileName());
            mdBrowseGraphicModel.setFileType(value.getFileType());
            mdBrowseGraphicModel.setFileDescription(value.getFileDescription());

            if (mdBrowseGraphicController.getDataById(value.getMdIdentificationId()) == null) {
                isFlag=true;
                id = idMdBrowserGraphic;
            } else {
                isFlag=false;
                id = mdBrowseGraphicController.getDataById(value.getMdIdentificationId()).getId();
            }

            if (isFlag) {
                ret = mdBrowseGraphicController.saveMdBrowseGraphic(mdBrowseGraphicModel);
            } else {
                ret = mdBrowseGraphicController.updateMdBrowseGraphic(id,mdBrowseGraphicModel);
            }
            
            displayLog(true, "MdBrowseGraphic");
            displayLog(true, "id = "+id);
            displayLog(true, "FileName = "+value.getFileName());
            displayLog(true, "FileType = "+value.getFileType());
            displayLog(true, "FileDescription = "+value.getFileDescription());
            displayLog(true, "foreign key MdIdentificationId =  "+value.getMdIdentificationId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdBrowseGraphic " + ret+"\n");
            }else{
                displayLog(true, "Status table MdBrowseGraphic " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error MdBrowseGraphic " + e.toString());
            displayLog(true, "Status table MdBrowseGraphic " + ret+"\n");
        }

    }

    public void saveUpdateMdFormat(String column,BigDecimal foreignId,MdFormatModel value) {

        String ret=null;
        try{    
            
            MdFormatController mdFormatController = new MdFormatController(session, hibernateUtilXml);
            MdFormatModel mdFormatModel = new MdFormatModel();

            boolean isFlag=false;
            BigDecimal getIdMdFormat;
            BigDecimal idMdFormat;
            BigDecimal id=null;

            getIdMdFormat = mdFormatController.getMaxMdFormatId();
            if (getIdMdFormat == null) {
                idMdFormat = new BigDecimal(FIRST_ID);
            } else {
                idMdFormat = new BigDecimal(getIdMdFormat.longValue() + 1);
            }

            mdFormatModel.setId(idMdFormat);
            mdFormatModel.setMdIdentificationId(value.getMdIdentificationId());
            mdFormatModel.setName(value.getName());
            mdFormatModel.setVersion(value.getVersion());
            mdFormatModel.setSpesification(value.getSpesification());
            mdFormatModel.setAmendmentNumber(value.getAmendmentNumber());
            mdFormatModel.setMdDistributionId(value.getMdDistributionId());
            mdFormatModel.setMdDistributorId(value.getMdDistributorId());

            if (mdFormatController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = idMdFormat;
            } else{
                isFlag=false;
                id = mdFormatController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdFormatController.saveMdFormat(mdFormatModel);
            } else {
                ret = mdFormatController.updateMdFormat(id,mdFormatModel);
            }
            
            displayLog(true, "MdFormat");
            displayLog(true, "id = "+id);
            displayLog(true, "Name = "+value.getName());
            displayLog(true, "Version = "+value.getVersion());
            displayLog(true, "Spesification = "+value.getSpesification());
            displayLog(true, "AmendmentNumber = "+value.getAmendmentNumber());
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
                displayLog(false, "Status table MdFormat " + ret+"\n");
            }else{
                displayLog(true, "Status table MdFormat " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error MdFormat " + e.toString());
            displayLog(true, "Status table MdFormat " + ret+"\n");
        }

    }

    public void saveUpdateMdDistributor(String column,BigDecimal foreignId,MdDistributorModel value) {
        
        String ret=null;
        try{

            MdDistributorController mdDistributorController = new MdDistributorController(session, hibernateUtilXml);
            MdDistributorModel mdDistributorModel = new MdDistributorModel();

            BigDecimal getIdMdDistributor;
            BigDecimal idMdDistributor;
            BigDecimal id=null;
            boolean isFlag=false;

            getIdMdDistributor = mdDistributorController.getMaxMdDistributorId();
            if (getIdMdDistributor == null) {
                idMdDistributor = new BigDecimal(FIRST_ID);
            } else {
                idMdDistributor = new BigDecimal(getIdMdDistributor.longValue() + 1);
            }

            mdDistributorModel.setId(idMdDistributor);
            mdDistributorModel.setMdFormatId(value.getMdFormatId());
            mdDistributorModel.setMdDistributionId(value.getMdDistributionId());

            if (mdDistributorController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = idMdDistributor;
            } else {
                isFlag=false;
                id = mdDistributorController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdDistributorController.saveMdDistributor(mdDistributorModel);
            } else {
                ret = mdDistributorController.updateMdDistributor(id,mdDistributorModel);
            }
            
            displayLog(true, "MdDistributor");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
                displayLog(false, "Status table MdDistributor " + ret+"\n");
            }else{
                displayLog(true, "Status table MdDistributor " + ret+"\n");
            }
             
        }catch(Exception e){
            
             displayLog(false, "Error MdDistributor " + e.toString());
             displayLog(true, "Status table MdDistributor " + ret+"\n");
        }

    }
    
    public void saveUpdateMdDistribution(MdDistributionModel value) {
        
        String ret=null;
        try{

            MdDistributionController MdDistributionController = new MdDistributionController(session, hibernateUtilXml);
            MdDistributionModel MdDistributionModel = new MdDistributionModel();

            BigDecimal getIdMdDistribution;
            BigDecimal idMdDistribution;
            BigDecimal id=null;
            boolean isFlag=false;

            getIdMdDistribution = MdDistributionController.getMaxMdDistributionId();
            if (getIdMdDistribution == null) {
                idMdDistribution = new BigDecimal(FIRST_ID);
            } else {
                idMdDistribution = new BigDecimal(getIdMdDistribution.longValue() + 1);
            }

            MdDistributionModel.setId(idMdDistribution);
            MdDistributionModel.setMdMetadataId(value.getMdMetadataId());

            if (MdDistributionController.getDataById(value.getMdMetadataId()) == null) {
                isFlag=true;
                id = idMdDistribution;
            } else {
                isFlag=false;
                id = MdDistributionController.getDataById(value.getMdMetadataId()).getId();
            }

            if (isFlag) {
                ret = MdDistributionController.saveMdDistribution(MdDistributionModel);
            } else {
                ret = MdDistributionController.updateMdDistribution(id,MdDistributionModel);
            }
            
            displayLog(true, "MdDistribution");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key "+value.getMdMetadataId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdDistribution " + ret+"\n");
            }else{
                displayLog(true, "Status table MdDistribution " + ret+"\n");
            }
             
        }catch(Exception e){
            
             displayLog(false, "Error MdDistribution " + e.toString());
             displayLog(true, "Status table MdDistribution " + ret+"\n");
        }

    }
  
    public void saveUpdateMdDigitalTransferOption(String column,BigDecimal foreignId,MdDigitalTransferOptionsModel value) {

        String ret=null;
        displayLog(true, "MdDigitalTransferOptions");
        try{
        
            MdDigitalTransferOptionsController mdDigitalTransferOptionsController = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
            MdDigitalTransferOptionsModel mdDigitalTransferOptionsModel = new MdDigitalTransferOptionsModel();

            boolean isFlag=false;
            BigDecimal getIdMdDigitalTransferOptions;
            BigDecimal idMdDigitalTransferOptions;
            BigDecimal id=null;
            BigDecimal transferSize = null;

            getIdMdDigitalTransferOptions = mdDigitalTransferOptionsController.getMaxMdDigitalTransferOptionsId();
            if (getIdMdDigitalTransferOptions == null) {
                idMdDigitalTransferOptions = new BigDecimal(FIRST_ID);
            } else {
                idMdDigitalTransferOptions = new BigDecimal(getIdMdDigitalTransferOptions.longValue() + 1);
            }
            
            try{
                
                if(value.getStringTransferSize()==null || value.getStringTransferSize()=="-"){
                    transferSize = BigDecimal.ZERO;
                    displayLog(true, "TransferSize = "+transferSize);
                }else{
                    transferSize = new BigDecimal(value.getStringTransferSize());
                    displayLog(true, "TransferSize = "+transferSize);
                }
                
            }catch(NullPointerException n){
                transferSize = BigDecimal.ZERO;
                displayLog(true, "TransferSize = "+transferSize);
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }
            
            mdDigitalTransferOptionsModel.setId(idMdDigitalTransferOptions);
            mdDigitalTransferOptionsModel.setMdDistributorId(value.getMdDistributorId());
            mdDigitalTransferOptionsModel.setMdDistributionId(value.getMdDistributionId());
            mdDigitalTransferOptionsModel.setTransferSize(transferSize);
            mdDigitalTransferOptionsModel.setUnitsOfDistribution(value.getUnitsOfDistribution());

            if (mdDigitalTransferOptionsController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = idMdDigitalTransferOptions;
            } else {
                isFlag=false;
                id = mdDigitalTransferOptionsController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdDigitalTransferOptionsController.saveMdDigitalTransferOptions(mdDigitalTransferOptionsModel);
            } else {
                ret = mdDigitalTransferOptionsController.updateMdDigitalTransferOptions(id,mdDigitalTransferOptionsModel);
            }
                                    
            
            displayLog(true, "id = "+id);
            displayLog(true, "UnitsOfDistribution = "+value.getUnitsOfDistribution());
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
                displayLog(false, "Status table MdDigitalTransferOptions " + ret+"\n");
            }else{
                displayLog(true, "Status table MdDigitalTransferOptions " + ret+"\n");
            }
             
        }catch(Exception e){
            
            displayLog(false, "Error MdDigitalTransferOptions " + e.toString());
            displayLog(true, "Status table MdDigitalTransferOptions " + ret+"\n");
        }

    }

    public void saveUpdateMdMedium(MdMediumModel value) {

        String ret=null;
        try{
            
            MdMediumController mdMediumController = new MdMediumController(session, hibernateUtilXml);
            MdMediumModel mdMediumModel = new MdMediumModel();
            MdMediumNameCodeController mdMediumNameCodeController = new MdMediumNameCodeController(session, hibernateUtilXml);

            boolean isFlag=false;
            BigDecimal getMdMedium;
            BigDecimal idMdMedium;
            BigDecimal id=null;

            getMdMedium = mdMediumController.getMaxMdMediumId();
            if (getMdMedium == null) {
                idMdMedium = new BigDecimal(FIRST_ID);
            } else {
                idMdMedium = new BigDecimal(getMdMedium.longValue() + 1);
            }

            String domainName = value.getName();
            String code = mdMediumNameCodeController.getDataByDomain(domainName).getCode();

            mdMediumModel.setId(idMdMedium);
            mdMediumModel.setName(code);
            mdMediumModel.setDensityUnits(value.getDensityUnits());
            mdMediumModel.setMediumNote(value.getMediumNote());
            mdMediumModel.setVolumes(value.getVolumes());
            mdMediumModel.setMdDigitalTransferOptionsId(value.getMdDigitalTransferOptionsId());

            if (mdMediumController.getDataById(value.getMdDigitalTransferOptionsId()) == null) {
                isFlag=true;
                id = idMdMedium;
            } else {
                isFlag=false;
                id = mdMediumController.getDataById(value.getMdDigitalTransferOptionsId()).getId();
            }

            if (isFlag) {
                ret = mdMediumController.saveMdMedium(mdMediumModel);
            } else {
                ret = mdMediumController.updateMdMedium(id,mdMediumModel);
            }
            
            displayLog(true, "MdMedium");
            displayLog(true, "id = "+id);
            displayLog(true, "Name = "+code);
            displayLog(true, "DensityUnits = "+value.getDensityUnits());
            displayLog(true, "MediumNote = "+value.getMediumNote());
            displayLog(true, "Volumes = "+value.getVolumes());
            displayLog(true, "foreign key MdDigitalTransferOptionsId = "+value.getMdDigitalTransferOptionsId());

            if(ret.contains("Error")){
                displayLog(false, "Status table MdMedium " + ret+"\n");
            }else{
                displayLog(true, "Status table MdMedium " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error MdMedium " + e.toString());
            displayLog(true, "Status table MdMedium " + ret+"\n");
        }
    }

    public void saveUpdateMdKeyword(MdKeywordModel value) {

        MdKeywordController mdKeywordController = new MdKeywordController(session, hibernateUtilXml);
        MdKeywordModel mdKeywordModel = new MdKeywordModel();
        MdKeywordTypeCodeController mdKeywordTypeCodeController = new MdKeywordTypeCodeController(session, hibernateUtilXml);

        BigDecimal getIdMdKeyword;
        BigDecimal idMdKeyword;
        String ret=null;

        try {
            List list = (List) mdKeywordController.getListOfId(value.getMdIdentificationId());

            if (list.get(0).toString().equals("-999")) {

                for (VarDescriptiveKeywords keyword : listMdKeywordObject) {

                    getIdMdKeyword = mdKeywordController.getMaxMdKeywordId();
                    if (getIdMdKeyword == null) {
                        idMdKeyword = new BigDecimal(FIRST_ID);
                    } else {
                        idMdKeyword = new BigDecimal(getIdMdKeyword.longValue() + 1);
                    }

                    String code = mdKeywordTypeCodeController.getDataByDomain(keyword.getType()).getCode();
                    mdKeywordModel.setId(idMdKeyword);
                    mdKeywordModel.setType(code);
                    mdKeywordModel.setMdIdentificationId(value.getMdIdentificationId());

                    ret = mdKeywordController.saveMdKeyword(mdKeywordModel);
                    
                    displayLog(true, "MdKeyword");
                    displayLog(true, "id = "+idMdKeyword);
                    displayLog(true, "Type = "+code);
                    displayLog(true, "foreign key MdIdentificationId = "+value.getMdIdentificationId());

                    if(ret.contains("Error")){
                        displayLog(false, "Status table MdKeyword " + ret+"\n");
                    }else{
                        displayLog(true, "Status table MdKeyword " + ret+"\n");
                    }

                }

            } else {

                int i = 0;
                for (VarDescriptiveKeywords keyword : listMdKeywordObject) {

                    String code = mdKeywordTypeCodeController.getDataByDomain(keyword.getType()).getCode();
               
                    mdKeywordModel.setId(new BigDecimal(list.get(i).toString()));
                    mdKeywordModel.setType(code);
                    mdKeywordModel.setMdIdentificationId(value.getMdIdentificationId());

                    ret = mdKeywordController.updateMdKeywordByCurrentId(mdKeywordModel);

                    displayLog(true, "MdKeyword");
                    displayLog(true, "id = "+list.get(i));
                    displayLog(true, "Type = "+code);
                    displayLog(true, "foreign key MdIdentificationId = "+value.getMdIdentificationId());

                    if(ret.contains("Error")){
                        displayLog(false, "Status table MdKeyword " + ret+"\n");
                    }else{
                        displayLog(true, "Status table MdKeyword " + ret+"\n");
                    }
                    
                    i++;
                }

            }
             
        }catch(Exception e){
            
            displayLog(false,"Error MdKeyword " + e.toString());
            displayLog(true, "Status table MdKeyword " + ret+"\n");

        }

    }

    public void saveUpdateMdKeywordKeyword(BigDecimal mdIdentificationId) {

        MdKeywordKeywordController mdKeywordKeywordController = new MdKeywordKeywordController(session, hibernateUtilXml);
        MdKeywordKeywordModel mdKeywordKeywordModel = new MdKeywordKeywordModel();
        MdKeywordController mdKeywordController = new MdKeywordController(session, hibernateUtilXml);
        MdKeywordTypeCodeController mdKeywordTypeCodeController = new MdKeywordTypeCodeController(session, hibernateUtilXml);

        String ret=null;
        int i = 0;       

        try {
            
            //List list = (List) mdKeywordController.getListOfId(mdIdentificationId);
       
            for (VarDescriptiveKeywords keyword : listMdKeywordObject) {

                String code = mdKeywordTypeCodeController.getDataByDomain(keyword.getType()).getCode();
                BigDecimal idMdKeyword = mdKeywordController.getDataByPropery(mdIdentificationId, code).getId();
                
//                if(getIdMdKeyword==null){
//                    System.out.println("double code in mdkeyword");
//                    idMdKeyword = new BigDecimal(list.get(i).toString());
//
//                }else{
//                    idMdKeyword = new BigDecimal(getIdMdKeyword); 
//                }
                
                mdKeywordKeywordModel.setMdKeywordId(idMdKeyword);
                mdKeywordKeywordModel.setKeyword(keyword.getKeyword());

                if (mdKeywordKeywordController.getDataById(idMdKeyword) == null) {

                    ret = mdKeywordKeywordController.saveMdKeywordKeyword(mdKeywordKeywordModel);

                } else {

                    ret = mdKeywordKeywordController.updateMdKeywordKeyword(mdKeywordKeywordModel);
                }
                
                displayLog(true, "MdKeywordKeyword");
                displayLog(true, "Keyword = "+keyword.getKeyword());
                displayLog(true, "foreign key MdKeywordId = "+idMdKeyword);

                if(ret.contains("Error")){
                    displayLog(false, "Status table MdKeywordKeyword " + ret+"\n");
                }else{
                    displayLog(true, "Status table MdKeywordKeyword " + ret+"\n");
                }
                
                i++;

            }

        }catch(Exception e){
            
            displayLog(false, "Error MdKeywordKeyword " + e.toString());
            displayLog(true, "Status table MdKeywordKeyword " + ret+"\n");
        }

    }

    public void saveUpdateThesaurusNameCitation(List mdkeywordId) { 

        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        String ret=null;
        BigDecimal getIdCiCitation;
        BigDecimal idCiCitation;
        
        try {      
             
            int i=0;
            for (VarDescriptiveKeywords keyword : listMdKeywordObject) {

                 getIdCiCitation = ciCitationController.getMaxCiCitationId();
                 
                 if (getIdCiCitation == null) {
                     idCiCitation = new BigDecimal(FIRST_ID);
                 } else {
                     idCiCitation = new BigDecimal(getIdCiCitation.longValue() + 1);
                 }

                 if (ciCitationController.getDataById(CiCitationModel.MDKEYWORDID, new BigDecimal(mdkeywordId.get(i).toString()))==null) {

                         ciCitationModel.setId(idCiCitation);
                         ciCitationModel.setTitle(keyword.getTitle());
                         ciCitationModel.setMdKeywordId(new BigDecimal(mdkeywordId.get(i).toString()));

                         ret = ciCitationController.saveCiCitation(ciCitationModel);
                         
                         displayLog(true, "CiCitation");
                         displayLog(true, "id = "+idCiCitation);

                 }else{
                         BigDecimal id = ciCitationController.getDataById(CiCitationModel.MDKEYWORDID, new BigDecimal(mdkeywordId.get(i).toString())).getId();
                         
                         ciCitationModel.setId(id);
                         ciCitationModel.setTitle(keyword.getTitle());
                         ciCitationModel.setMdKeywordId(new BigDecimal(mdkeywordId.get(i).toString()));

                         ret = ciCitationController.updateCiCitation(id,ciCitationModel);
                         
                         displayLog(true, "CiCitation");
                         displayLog(true, "id = "+id);
                 }
                 
                 
                 displayLog(true, "Title = "+keyword.getTitle());
                 displayLog(true, "foreign key MdKeywordId = "+mdkeywordId.get(i));

                 if(ret.contains("Error")){
                    displayLog(false, "Status table CiCitation " + ret+"\n");
                 }else{
                    displayLog(true, "Status table CiCitation " + ret+"\n");
                 }
                                  
                  if(keyword.getLengthTitle().equals("1")){
                        
                      break;
                  }
                 i++;
             }
                                 
           
            }catch(Exception e){
            
                e.printStackTrace();
        }
 
    }
        
    public void saveUpdateCitationDateThesaurusName(List mdKeywordId) {

        CiDateController ciDateController = new CiDateController(session, hibernateUtilXml);
        CiDateModel ciDateModel = new CiDateModel();
        CiDateTypeCodeController ciDateTypeCodeController = new CiDateTypeCodeController(session, hibernateUtilXml);
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt;
        BigDecimal getCiDate;
        BigDecimal ciDateId;
        BigDecimal id=null;
        String ret=null;
        boolean flag=false;
        
        try {
             int i=0;
                                  
                for (VarDescriptiveKeywords keyword : listMdKeywordObject) {
                                                            
                    String domainName = keyword.getDateType();
                    String code;
                    
                    code = ciDateTypeCodeController.getDataByDomain(domainName).getCode();

                    getCiDate = ciDateController.getMaxCiDateId();
                    if (getCiDate == null) {
                        ciDateId = new BigDecimal(FIRST_ID);
                    } else {
                        ciDateId = new BigDecimal(getCiDate.longValue() + 1);
                    }
                    
                    ciDateModel.setId(ciDateId);
                    ciDateModel.setDateType(code);
                    try {
                        String date_ = keyword.getDate();
                        if (date_.equals("-")) {
                            ciDateModel.setDate_(null);
                        } else {
                            dt = dateFormat.parse(date_);
                            ciDateModel.setDate_(dt);
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
                    }
                                      
                    BigDecimal citationId = ciCitationController.getDataById(CiCitationModel.MDKEYWORDID,new BigDecimal(mdKeywordId.get(i).toString())).getId();
                    ciDateModel.setCiCitationId(citationId);
                    
                    if(ciDateController.getDataById(citationId, code)==null){
                        flag=true;
                        id = ciDateId;
                    }else{
                        flag=false;
                        id=ciDateController.getDataById(citationId, code).getId();
                    }
                    
                    if(flag){
                        ret=ciDateController.saveCiDate(ciDateModel);
                    }else{
                        ret=ciDateController.updateCiDate(id,ciDateModel);
                    }
                    
                    i++;
                    
                    displayLog(true, "CiDate");
                    displayLog(true, "id = "+id);
                    displayLog(true, "Date_ = "+keyword.getDate());
                    displayLog(true, "DateType = "+code);
                    displayLog(true, "foreign key CiCitationId = "+citationId);

                    if(ret.contains("Error")){
                       displayLog(false, "Status table Cidate " + ret+"\n");
                    }else{
                       displayLog(true, "Status table Cidate " + ret+"\n");
                    }
                      
                }
                                        
        }catch(NullPointerException n){
                n.printStackTrace();
        }
          
    }   
    
    public void saveUpdateMdAggregationInformation(MdAggregateInfoModel value) {

        String ret=null;
        try{
            
            MdAggregateInfoController mdAggregateInfoController = new MdAggregateInfoController(session, hibernateUtilXml);
            MdAggregateInfoModel mdAggregateInfoModel = new MdAggregateInfoModel();
            DsAssociationTypeCodeController dsAssociationTypeCodeController = new DsAssociationTypeCodeController(session, hibernateUtilXml);
            DsInitiativeTypeCodeController dsInitiativeTypeCodeController = new DsInitiativeTypeCodeController(session, hibernateUtilXml);

            boolean isFlag=false;
            BigDecimal getIdMdAggregateInfo;
            BigDecimal idMdAggregateInfo;
            BigDecimal id=null;

            getIdMdAggregateInfo = mdAggregateInfoController.getMaxMdAggregateInfoId();
            if (getIdMdAggregateInfo == null) {
                idMdAggregateInfo = new BigDecimal(FIRST_ID);
            } else {
                idMdAggregateInfo = new BigDecimal(getIdMdAggregateInfo.longValue() + 1);
            }

            String codeAssociation = dsAssociationTypeCodeController.getDataByDomain(value.getAssositionType()).getCode();
            String codeInitiative = dsInitiativeTypeCodeController.getDataByDomain(value.getInitiativeType()).getCode();

            mdAggregateInfoModel.setId(idMdAggregateInfo);
            mdAggregateInfoModel.setMdIdentificationId(value.getMdIdentificationId());
            mdAggregateInfoModel.setAssositionType(codeAssociation);
            mdAggregateInfoModel.setInitiativeType(codeInitiative);

            if (mdAggregateInfoController.getDataById(value.getMdIdentificationId()) == null) {
                isFlag=true;
                id = idMdAggregateInfo;
            } else {
                isFlag=false;
                id = mdAggregateInfoController.getDataById(value.getMdIdentificationId()).getId();
            }

            if (isFlag) {
                ret = mdAggregateInfoController.saveMdAggregateInfo(mdAggregateInfoModel);
            } else {
                ret = mdAggregateInfoController.updateMdAggregateInfo(id,mdAggregateInfoModel);
            }
                                            
            displayLog(true, "MdAggregationInfo");
            displayLog(true, "id = "+id);
            displayLog(true, "AssositionType = "+codeAssociation);
            displayLog(true, "InitiativeType = "+codeInitiative);
            displayLog(true, "foreign key MdIdentificationId = "+value.getMdIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdAggregationInfo " + ret+"\n");
            }else{
               displayLog(true, "Status table MdAggregationInfo " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdAggregationInfo " + e.toString());
            displayLog(true, "Status table MdAggregationInfo " + ret+"\n");
        }

    }    

    public void saveUpdateSvServiceIdentification(SvServiceIdentificationModel value) {

        String ret=null;
        try{
            SvServiceIdentificationController svServiceIdentificationController = new SvServiceIdentificationController(session, hibernateUtilXml);
            SvServiceIdentificationModel svServiceIdentificationModel = new SvServiceIdentificationModel();
            MdProgressCodeController codeController = new MdProgressCodeController(session, hibernateUtilXml);

            String code = "";
            String domainName = value.getStatus();
            boolean isFlag=false;
            BigDecimal id=null;
            BigDecimal getServiceId;
            BigDecimal idServiceIdentification;

            getServiceId = svServiceIdentificationController.getMaxSvServiceIdentificationId();
            if (getServiceId == null) {
                idServiceIdentification = new BigDecimal(FIRST_ID);
            } else {
                idServiceIdentification = new BigDecimal(getServiceId.longValue() + 1);
            }

            if(domainName==null){
                code="000";
            }else{
                code=codeController.getDataByDomain(domainName).getCode();
            }

            svServiceIdentificationModel.setId(idServiceIdentification);
            svServiceIdentificationModel.setServiceType(value.getServiceType());
            svServiceIdentificationModel.setAbstract_(value.getAbstract_());
            svServiceIdentificationModel.setStatus(code);
            svServiceIdentificationModel.setMdIdentificationId(value.getMdIdentificationId());

            if (svServiceIdentificationController.getDataById(value.getMdIdentificationId()) == null) {
                isFlag=true;
                id = idServiceIdentification;
            } else {
                isFlag=false;
                id = svServiceIdentificationController.getDataById(value.getMdIdentificationId()).getId();
            }

            if (isFlag) {
                ret = svServiceIdentificationController.saveSvServiceIdentification(svServiceIdentificationModel);
            } else {
                ret = svServiceIdentificationController.updateSvServiceIdentification(id,svServiceIdentificationModel);
            }
            
            displayLog(true, "SvServiceIdentification");
            displayLog(true, "id = "+id);
            displayLog(true, "ServiceType = "+value.getServiceType());
            displayLog(true, "Abstract_ = "+value.getAbstract_());
            displayLog(true, "Status = "+code);
            displayLog(true, "foreign key MdIdentificationId = "+value.getMdIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table SvServiceIdentification " + ret+"\n");
            }else{
               displayLog(true, "Status table SvServiceIdentification " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error SvServiceIdentification " + e.toString());
            displayLog(true, "Status table SvServiceIdentification " + ret+"\n");
        }

    }

    public void saveUpdateMdDataIdentification(MdDataIdentificationModel value) {
        
        String ret=null;
        try{
            MdDataIdentificationController mdDataIdentificationController = new MdDataIdentificationController(session, hibernateUtilXml);
            MdDataIdentificationModel mdDataIdentificationModel = new MdDataIdentificationModel();
           
            boolean isFlag=false;
            BigDecimal id=null;
            mdDataIdentificationModel.setId(value.getId());
            mdDataIdentificationModel.setSuplementationInformation(value.getSuplementationInformation());
            mdDataIdentificationModel.setSvServiceidentificationId(value.getSvServiceidentificationId());
            mdDataIdentificationModel.setEnvironmentDescription(value.getEnvironmentDescription());    

            if (mdDataIdentificationController.getDataById(value.getId()) == null) {
                isFlag=true;
                
            } else {
                isFlag=false;
                id = mdDataIdentificationController.getDataById(value.getId()).getId();
            }

            if (isFlag) {
                ret = mdDataIdentificationController.saveMdDataIdentification(mdDataIdentificationModel);
            } else {
                ret = mdDataIdentificationController.updateMdDataIdentification(id,mdDataIdentificationModel);
            }
            
            displayLog(true, "MdDataIdentification");
            displayLog(true, "id = "+value.getId());
            displayLog(true, "SuplementationInformation = "+value.getSuplementationInformation());
            displayLog(true, "EnvironmentDescription = "+value.getEnvironmentDescription());
            displayLog(true, "foreign key SvServiceidentificationId = "+value.getSvServiceidentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdDataIdentification " + ret+"\n");
            }else{
               displayLog(true, "Status table MdDataIdentification " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdDataIdentification " + e.toString());
            displayLog(true, "Status table MdDataIdentification " + ret+"\n");
        }

    }

    public void saveUpdateMdResolution(MdResolutionModel value) {

        String ret=null;
        try{
            MdResolutionController mdResolutionController = new MdResolutionController(session, hibernateUtilXml);
            MdResolutionModel mdResolutionModel = new MdResolutionModel();

            boolean isFlag=false;
            BigDecimal getIdMdResolution;
            BigDecimal idMdResolution;
            BigDecimal id=null;

            getIdMdResolution = mdResolutionController.getMaxMdResolutionId();
            if (getIdMdResolution == null) {
                idMdResolution = new BigDecimal(FIRST_ID);
            } else {
                idMdResolution = new BigDecimal(getIdMdResolution.longValue() + 1);
            }

            mdResolutionModel.setId(idMdResolution);
            mdResolutionModel.setMdDataIdentificationId(value.getMdDataIdentificationId());
            mdResolutionModel.setEquivalentScale(value.getEquivalentScale());
            mdResolutionModel.setDistance(value.getDistance());

            if (mdResolutionController.getDataById(value.getMdDataIdentificationId()) == null) {
                isFlag=true;
                id = idMdResolution;
            } else {
                isFlag=false;
                id = mdResolutionController.getDataById(value.getMdDataIdentificationId()).getId();
            }

            if (isFlag) {
                ret = mdResolutionController.saveMdResolution(mdResolutionModel);
            } else {
                ret = mdResolutionController.updateMdResolution(id,mdResolutionModel);
            }
            
            displayLog(true, "MdResolution");
            displayLog(true, "id = "+id);
            displayLog(true, "EquivalentScale = "+value.getEquivalentScale());
            displayLog(true, "Distance = "+value.getDistance());
            displayLog(true, "foreign key MdDataIdentificationId = "+value.getMdDataIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdResolution " + ret+"\n");
            }else{
               displayLog(true, "Status table MdResolution " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdResolution " + e.toString());
            displayLog(true, "Status table MdResolution " + ret+"\n");
        }

    }

    public void saveUpdateMdDataIdentificationSpatrep(MdDataIdentificationSpatrepModel value) {
        
        String ret=null;
        try{

            MdDataIdentificationSpatrepController mdDataIdentificationSpatrepController = new MdDataIdentificationSpatrepController(session, hibernateUtilXml);
            MdDataIdentificationSpatrepModel mdDataIdentificationSpatrepModel = new MdDataIdentificationSpatrepModel();
            MdSpatialRepresentTypeCodeController spatialRepresentTypeCodeController = new MdSpatialRepresentTypeCodeController(session, hibernateUtilXml);

            boolean isFlag=false;
            BigDecimal id=null;

            String code = spatialRepresentTypeCodeController.getDataByDomain(value.getSpatialRepresentationType()).getCode();

            mdDataIdentificationSpatrepModel.setMdDataIdentificationId(value.getMdDataIdentificationId());
            mdDataIdentificationSpatrepModel.setSpatialRepresentationType(code);

            if (mdDataIdentificationSpatrepController.getDataById(value.getMdDataIdentificationId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = mdDataIdentificationSpatrepController.getDataById(value.getMdDataIdentificationId()).getMdDataIdentificationId();
            }

            if (isFlag) {
                ret = mdDataIdentificationSpatrepController.saveMdDataIdentificationSpatrep(mdDataIdentificationSpatrepModel);
            }else{
                ret = mdDataIdentificationSpatrepController.updateMdDataIdentificationSpatrep(id,mdDataIdentificationSpatrepModel);
            }
            
            displayLog(true, "MdDataIdentificationSpatrep");
            displayLog(true, "SpatialRepresentationType = "+code);
            displayLog(true, "foreign key MdDataIdentificationId = "+value.getMdDataIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdDataIdentificationSpatrep " + ret+"\n");
            }else{
               displayLog(true, "Status table MdDataIdentificationSpatrep " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error  MdDataIdentificationSpatrep " + e.toString());
            displayLog(true, "Status table MdDataIdentificationSpatrep " + ret+"\n");
        }

    }

    public void saveUpdateMdDataIdentificationLang(MdDataIdentificationLangModel value) {

        String ret=null;
        try{
            MdDataIdentificationLangController langController = new MdDataIdentificationLangController(session, hibernateUtilXml);
            MdDataIdentificationLangModel langModel = new MdDataIdentificationLangModel();
           
            boolean isFlag=false;
            BigDecimal id=null;

            langModel.setLanguage(value.getLanguage());
            langModel.setMdDataIdentificationId(value.getMdDataIdentificationId());

            if (langController.getDataById(value.getMdDataIdentificationId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = langController.getDataById(value.getMdDataIdentificationId()).getMdDataIdentificationId();
            }

            if (isFlag) {
                ret = langController.saveMdDataIdentificationLang(langModel);
            } else {
                ret = langController.updateMdDataIdentificationLang(id,langModel);
            }

            displayLog(true, "MdDataIdentificationLang");
            displayLog(true, "Language = "+value.getLanguage());
            displayLog(true, "foreign key MdDataIdentificationId = "+value.getMdDataIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdDataIdentificationLang " + ret+"\n");
            }else{
               displayLog(true, "Status table MdDataIdentificationLang " + ret+"\n");
            }
                        
        }catch(Exception e){
            
            displayLog(false, "Error MdDataIdentificationLang " + e.toString());
            displayLog(true, "Status table MdDataIdentificationLang " + ret+"\n");
        }

    }

    public void saveUpdateMdDataIdentificationCharset(MdDataIdentificationCharsetModel value) {

        String ret=null;
        try{
            MdDataIdentificationCharsetController charsetController = new MdDataIdentificationCharsetController(session, hibernateUtilXml);
            MdDataIdentificationCharsetModel charsetModel = new MdDataIdentificationCharsetModel();
            MdCharacterSetCodeController codeController = new MdCharacterSetCodeController(session, hibernateUtilXml);
            
            boolean isFlag=false;
            BigDecimal id=null;
            String code = codeController.getDataByDomain(value.getCharacterSet()).getCode();

            charsetModel.setCharacterSet(code);
            charsetModel.setMdDataIdentificationId(value.getMdDataIdentificationId());

            if (charsetController.getDataById(value.getMdDataIdentificationId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = charsetController.getDataById(value.getMdDataIdentificationId()).getMdDataIdentificationId();
            }

            if (isFlag) {
                ret = charsetController.saveMdDataIdentificationCharset(charsetModel);
            } else {
                ret = charsetController.updateMdDataIdentificationCharset(id,charsetModel);
            }
            
            displayLog(true, "MdDataIdentificationCharset");
            displayLog(true, "CharacterSet = "+code);
            displayLog(true, "foreign key MdDataIdentificationId = "+value.getMdDataIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdDataIdentificationCharset " + ret+"\n");
            }else{
               displayLog(true, "Status table MdDataIdentificationCharset " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdDataIdentificationCharset " + e.toString());
        }
    }

    public void saveUpdateMdDataIdentificationTopCat(MdDataIdentificationTopcatModel value) {

        String ret=null;
        try{
            MdDataIdentificationTopcatController topcatController = new MdDataIdentificationTopcatController(session, hibernateUtilXml);
            MdDataIdentificationTopcatModel topcatModel = new MdDataIdentificationTopcatModel();
            MdTopicCategoryCodeController codeController = new MdTopicCategoryCodeController(session, hibernateUtilXml);

            boolean isFlag=false;
            BigDecimal id=null;

            String code = codeController.getDataByDomain(value.getTopicCategory()).getCode();

            topcatModel.setMdDataIdentificationId(value.getMdDataIdentificationId());
            topcatModel.setTopicCategory(code);

            if (topcatController.getDataById(value.getMdDataIdentificationId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = topcatController.getDataById(value.getMdDataIdentificationId()).getMdDataIdentificationId();
            }

            if (isFlag) {
                ret = topcatController.saveMdDataIdentificationTopcat(topcatModel);
            } else {
                ret = topcatController.updateMdDataIdentificationTopcat(id,topcatModel);
            }

            displayLog(true, "MdDataIdentificationTopCat");
            displayLog(true, "TopicCategory = "+code);
            displayLog(true, "foreign key MdDataIdentificationId = "+value.getMdDataIdentificationId());

            if(ret.contains("Error")){
               displayLog(false, "Status table MdDataIdentificationTopCat " + ret+"\n");
            }else{
               displayLog(true, "Status table MdDataIdentificationTopCat " + ret+"\n");
            }
               
        }catch(Exception e){
            
            displayLog(false, "Error MdDataIdentificationTopCat " + e.toString());
        }

    }

    public void saveUpdateMdRepresentativeFraction(String column,BigDecimal foreignId,MdRepresentativeFractionModel value) {

        String ret=null;
        try{
            MdRepresentativeFractionController mdRepresentativeFractionController = new MdRepresentativeFractionController(session, hibernateUtilXml);
            MdRepresentativeFractionModel mdRepresentativeFractionModel = new MdRepresentativeFractionModel();

            boolean isFlag=false;   
            BigDecimal id=null;
            BigDecimal getIdMdRepresentativeFraction;
            BigDecimal idMdRepresentativeFraction;
            BigDecimal denominator=null;

            getIdMdRepresentativeFraction = mdRepresentativeFractionController.getMaxMdRepresentativeFractionId();
            if (getIdMdRepresentativeFraction == null) {
                idMdRepresentativeFraction = new BigDecimal(FIRST_ID);
            } else {
                idMdRepresentativeFraction = new BigDecimal(getIdMdRepresentativeFraction.longValue() + 1);
            }

            try{
                if(value.getStringDenominator()==null || value.getStringDenominator()=="-"){
                    denominator= BigDecimal.ZERO;
                }else{
                    denominator= new BigDecimal(value.getStringDenominator());
                }

            }catch(NullPointerException n){
                 denominator= BigDecimal.ZERO;
                 Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }

            mdRepresentativeFractionModel.setId(idMdRepresentativeFraction);
            mdRepresentativeFractionModel.setDenominator(denominator);
            mdRepresentativeFractionModel.setMdResolutionId(value.getMdResolutionId());
            mdRepresentativeFractionModel.setLiSourceId(value.getLiSourceId());

            if (mdRepresentativeFractionController.getDataById(column,foreignId) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = mdRepresentativeFractionController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdRepresentativeFractionController.saveMdRepresentativeFraction(mdRepresentativeFractionModel);
            } else {
                ret = mdRepresentativeFractionController.updateMdRepresentativeFraction(id,mdRepresentativeFractionModel);
            }

            displayLog(true, "MdRepresentativeFraction");
            displayLog(true, "id = "+idMdRepresentativeFraction);
            displayLog(true, "Denominator = "+denominator);
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
               displayLog(false, "Status table MdRepresentativeFraction " + ret+"\n");
            }else{
               displayLog(true, "Status table MdRepresentativeFraction " + ret+"\n");
            }
             
        }catch(Exception e){
            
            displayLog(false, "Error MdRepresentativeFraction " + e.toString());
            displayLog(true, "Status table MdRepresentativeFraction " + ret+"\n");
        }

    }

    public void saveUpdateExExtent(String column,BigDecimal foreignId,ExExtentModel value) {

        String ret=null;
        try{
            ExExtentController exExtentController = new ExExtentController(session, hibernateUtilXml);
            ExExtentModel exExtentModel = new ExExtentModel();

            boolean isFlag=false;
            BigDecimal getIdExExtent;
            BigDecimal idExExtent;
            BigDecimal id=null;

            getIdExExtent = exExtentController.getMaxExExtentId();
            if (getIdExExtent == null) {
                idExExtent = new BigDecimal(FIRST_ID);
            } else {
                idExExtent = new BigDecimal(getIdExExtent.longValue() + 1);
            }

            exExtentModel.setId(idExExtent);
            exExtentModel.setMdDataIdentificationId(value.getMdDataIdentificationId());
            exExtentModel.setDescription(value.getDescription());
            exExtentModel.setDqScopeId(value.getDqScopeId());
            exExtentModel.setLiSourceId(value.getLiSourceId());
            exExtentModel.setSvServiceIdentificationId(value.getSvServiceIdentificationId());

            if (exExtentController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = idExExtent;
            } else {
                isFlag=false;
                id = exExtentController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = exExtentController.saveExExtent(exExtentModel);
            }else{
                ret = exExtentController.updateExExtent(id,exExtentModel);
            }
            
            displayLog(true, "ExExtent");
            displayLog(true, "id = "+id);
            displayLog(true, "Description = "+value.getDescription());
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
               displayLog(false, "Status table ExExtent " + ret+"\n");
            }else{
               displayLog(true, "Status table ExExtent " + ret+"\n");
            }
                                
        }catch(Exception e){
            
            displayLog(false, "Error ExExtent " + e.toString());
            displayLog(true, "Status table ExExtent " + ret+"\n");
        }

    }

    public void saveUpdateExExtentGeographicExtent(String column,BigDecimal foreignId,ExGeographicExtentModel value) {

        String ret=null;
        try{
            ExGeographicExtentController exGeographicExtentController = new ExGeographicExtentController(session, hibernateUtilXml);
            ExGeographicExtentModel exGeographicExtentModel = new ExGeographicExtentModel();

            boolean isFlag=false;
            BigDecimal getIdExGeographicExtent;
            BigDecimal idExGeographicExtent;
            BigDecimal id=null;

            getIdExGeographicExtent = exGeographicExtentController.getMaxExGeographicExtentId();
            if (getIdExGeographicExtent == null) {
                idExGeographicExtent = new BigDecimal(FIRST_ID);
            } else {
                idExGeographicExtent = new BigDecimal(getIdExGeographicExtent.longValue() + 1);
            }

            String code=value.getStringExtentTypeCode();
            String condition=null;
            BigDecimal conditional=null;
            try{

                if(code.equalsIgnoreCase("false") || code==null){
                    conditional=BigDecimal.ZERO;
                }else{
                    conditional=BigDecimal.ONE;
                }

            }catch(NullPointerException ex){
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            }


            exGeographicExtentModel.setId(idExGeographicExtent);
            exGeographicExtentModel.setExExtentId(value.getExExtentId());
            exGeographicExtentModel.setExtendsType(value.getExtendsType());
            exGeographicExtentModel.setExtentTypeCode(conditional);
            exGeographicExtentModel.setMeasureDescription(value.getMeasureDescription());
            exGeographicExtentModel.setExSpatialTemporalExtentId(value.getExSpatialTemporalExtentId());

            if (exGeographicExtentController.getDataById(column,foreignId) == null) {
                isFlag=true;
                id = idExGeographicExtent;
            } else {
                isFlag=false;
                id = exGeographicExtentController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = exGeographicExtentController.saveExGeographicExtent(exGeographicExtentModel);
            } else {
                ret = exGeographicExtentController.updateExGeographicExtent(id,exGeographicExtentModel);
            }
            
            displayLog(true, "ExGeographicExtent");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "ExtentTypeCode = "+value.getStringExtentTypeCode());
            displayLog(true, "MeasureDescription = "+value.getMeasureDescription());
            displayLog(true, "foreign key "+column+" = "+foreignId);

            if(ret.contains("Error")){
               displayLog(false, "Status table ExGeographicExtent " + ret+"\n");
            }else{
               displayLog(true, "Status table ExGeographicExtent " + ret+"\n");
            }
                                
        }catch(Exception e){
            
            displayLog(false, "Error ExGeographicExtent " + e.toString());
            displayLog(true, "Status table ExGeographicExtent " + ret+"\n");
        }

    }

    public void saveUpdateExExtentGeographicBoundingBox(ExGeographicBoundingBoxModel value) {

        String ret=null;
        try{
            ExGeographicBoundingBoxController exGeographicBoundingBoxController = new ExGeographicBoundingBoxController(session, hibernateUtilXml);
            ExGeographicBoundingBoxModel exGeographicBoundingBoxModel = new ExGeographicBoundingBoxModel();
   
            boolean isFlag=false;
            BigDecimal getIdExGeographicBoundingBox;
            BigDecimal idExGeographicBoundingBox;
            //BigDecimal id=null;

            getIdExGeographicBoundingBox = exGeographicBoundingBoxController.getMaxExGeographicBoundingBoxId();
            if (getIdExGeographicBoundingBox == null) {
                idExGeographicBoundingBox = new BigDecimal(FIRST_ID);
            } else {
                idExGeographicBoundingBox = new BigDecimal(getIdExGeographicBoundingBox.longValue() + 1);
            }   
            
            String eastBoundLongitude = value.getEastBoundLongitudeString().trim();
            String northBoundLongitud = value.getNorthBoundLongitudString().trim();
            String southtBoundLongitude = value.getSouthBoundLongitudeString().trim();
            String westBoundLongitude = value.getWestBoundLongitudeString().trim();
            
            BigDecimal east = null;
            BigDecimal north = null;
            BigDecimal south = null;
            BigDecimal west = null;
            
            if(eastBoundLongitude.contains(",")){
                eastBoundLongitude = eastBoundLongitude.replaceAll(",", ".");
                east = new BigDecimal(eastBoundLongitude);
                
            }
            if(northBoundLongitud.contains(",")){
                northBoundLongitud = northBoundLongitud.replaceAll(",", ".");
                north = new BigDecimal(northBoundLongitud);
                
            }
            if(southtBoundLongitude.contains(",")){
                southtBoundLongitude = southtBoundLongitude.replaceAll(",", ".");
                south = new BigDecimal(southtBoundLongitude);
                
            }
            if(westBoundLongitude.contains(",")){
                westBoundLongitude = westBoundLongitude.replaceAll(",", ".");
                west = new BigDecimal(westBoundLongitude);
                
            }   
            if(eastBoundLongitude==null || eastBoundLongitude=="0"){
                eastBoundLongitude = "0";
                east = new BigDecimal(eastBoundLongitude);
            }
            if(northBoundLongitud==null || northBoundLongitud=="0"){
                northBoundLongitud = "0";
                north = new BigDecimal(northBoundLongitud);
            }
            if(southtBoundLongitude==null || southtBoundLongitude=="0"){
                southtBoundLongitude = "0";
                south = new BigDecimal(southtBoundLongitude);
            }
            if(westBoundLongitude==null || westBoundLongitude=="0"){
                westBoundLongitude = "0";
                west = new BigDecimal(westBoundLongitude);
            }
               
            exGeographicBoundingBoxModel.setId(idExGeographicBoundingBox);
            exGeographicBoundingBoxModel.setEastBoundLongitude(east);
            exGeographicBoundingBoxModel.setNorthBoundLongitud(north);
            exGeographicBoundingBoxModel.setSouthBoundLongitude(south);
            exGeographicBoundingBoxModel.setWestBoundLongitude(west);
            exGeographicBoundingBoxModel.setExGeographicExtentId(value.getExGeographicExtentId());

            if (exGeographicBoundingBoxController.getDataByIdExExGeographicExtent(value.getExGeographicExtentId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = exGeographicBoundingBoxController.saveExGeographicBoundingBox(exGeographicBoundingBoxModel);
            } else {
                ret = exGeographicBoundingBoxController.updateExGeographicBoundingBox(exGeographicBoundingBoxModel);
            }
            
            displayLog(true, "ExGeographicBoundingBox");
            displayLog(true, "id = "+idExGeographicBoundingBox);
            displayLog(true, "EastBoundLongitude = "+east);
            displayLog(true, "NorthBoundLongitud = "+north);
            displayLog(true, "SouthBoundLongitude = "+south);
            displayLog(true, "WestBoundLongitude = "+west);
            displayLog(true, "foreign key ExGeographicExtentId = "+value.getExGeographicExtentId());

            if(ret.contains("Error")){
               displayLog(false, "Status table ExGeographicBoundingBox " + ret+"\n");
            }else{
               displayLog(true, "Status table ExGeographicBoundingBox " + ret+"\n");
            }
                                
        }catch(Exception e){
            
            displayLog(false, "Error ExGeographicBoundingBox " + e.toString());
            displayLog(true, "Status table ExGeographicBoundingBox " + ret+"\n");
        }

    }
    
    public void saveUpdateExBoundingPolygon(ExBoundingPolygonModel value) {

         String ret=null;
        try{
            ExBoundingPolygonController ExBoundingPolygonController = new ExBoundingPolygonController(session, hibernateUtilXml);
            ExBoundingPolygonModel ExBoundingPolygonModel = new ExBoundingPolygonModel();
 
            boolean isFlag=false;

            ExBoundingPolygonModel.setExGeographicExtentId(value.getExGeographicExtentId());

            if (ExBoundingPolygonController.getDataById(value.getExGeographicExtentId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ExBoundingPolygonController.saveExBoundingPolygon(ExBoundingPolygonModel);
            } else {
                ret = ExBoundingPolygonController.updateExBoundingPolygon(ExBoundingPolygonModel);
            }
            
            displayLog(true, "ExBoundingPolygon");
            displayLog(true, "id = "+value.getExGeographicExtentId());
           
            if(ret.contains("Error")){
               displayLog(false, "Status table ExBoundingPolygon " + ret+"\n");
            }else{
               displayLog(true, "Status table ExBoundingPolygon " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error ExBoundingPolygon " + e.toString());
            displayLog(true, "Status table ExBoundingPolygon " + ret+"\n");
        }

    }
    
    public void saveUpdateExBoundingPolygonPolygon(ExBoundingPolygonPolygonModel value) throws SQLException {

        String ret=null;
        try{
            ExBoundingPolygonPolygonController ebppc  = new ExBoundingPolygonPolygonController(session, hibernateUtilXml);
            ExBoundingPolygonPolygonModel ebppm = new ExBoundingPolygonPolygonModel();
            
            boolean isFlag=false;

            String polygon = ebppc.listToStringTag(value.getPolygonList());

            Clob myClobFile = new SerialClob(polygon.toCharArray());

            ebppm.setExBoundingPolygonId(value.getExBoundingPolygonId());
            ebppm.setPolygon(myClobFile);

            if (ebppc.getDataById(value.getExBoundingPolygonId()) == null) {
                isFlag=true;
            } else {
                isFlag=false;
            }

            if (isFlag) {
                ret = ebppc.saveExBoundingPolygonPolygon(ebppm);
            } else {
                ret = ebppc.updateExBoundingPolygonPolygon(ebppm);
            }
            
            displayLog(true, "ExBoundingPolygonPolygon");          
            displayLog(true, "foreign key ExBoundingPolygonId = "+value.getExBoundingPolygonId());
            displayLog(true, "polygon = "+polygon);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table ExBoundingPolygonPolygon " + ret+"\n");
            }else{
               displayLog(true, "Status table ExBoundingPolygonPolygon " + ret+"\n");
            }
              
        }catch(Exception e){
            
            displayLog(false, "Error ExBoundingPolygonPolygon " + e.toString());
            displayLog(true, "Status table ExBoundingPolygonPolygon " + ret+"\n");
        }

    }
      
    public void saveUpdateExTemporalExtent(ExTemporalExtentModel value){
    
        String ret=null;
        try{
            ExTemporalExtentController extentController = new ExTemporalExtentController(session, hibernateUtilXml);
            ExTemporalExtentModel extentModel = new ExTemporalExtentModel();

            BigDecimal getExTemporalId;
            BigDecimal idExTemporalId;
            BigDecimal id=null;  
            boolean isFlag=false;

            getExTemporalId = extentController.getMaxExTemporalExtentId();
            if(getExTemporalId==null){
                idExTemporalId = new BigDecimal(FIRST_ID);
            }else{
                idExTemporalId = new BigDecimal(getExTemporalId.longValue()+1);   
            }

            extentModel.setId(idExTemporalId);
            extentModel.setExtendsType(value.getExtendsType());
            extentModel.setExExtendId(value.getExExtendId());

            if(extentController.getDataById(value.getExExtendId())==null){
                isFlag=true;
                id =idExTemporalId;
            }else{
                isFlag=false;
                id=extentController.getDataById(value.getExExtendId()).getId();
            }

            if(isFlag){
                ret=extentController.saveExTemporalExtent(extentModel);
            }else{
                ret=extentController.updateExTemporalExtent(id,extentModel);
            }
            
            displayLog(true, "ExTemporalExtent");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "foreign key ExExtendId = "+value.getExExtendId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table ExTemporalExtent " + ret+"\n");
            }else{
               displayLog(true, "Status table ExTemporalExtent" + ret+"\n");
            }
                     
        }catch(Exception e){
            
            displayLog(false, "Error ExTemporalExtent " + e.toString());
            displayLog(true, "Status table ExTemporalExtent" + ret+"\n");
        }
    }
    
    public void saveUpdateExExtentVerticalExtent(ExVerticalExtentModel value){
    
        String ret=null;
        try{
            ExVerticalExtentController exVerticalExtentController = new ExVerticalExtentController(session, hibernateUtilXml);
            ExVerticalExtentModel extentModel = new ExVerticalExtentModel();

            BigDecimal getExVerticalId;
            BigDecimal idExVerticalId;
            BigDecimal id=null; 
            boolean isFlag=false;

            getExVerticalId = exVerticalExtentController.getMaxExVerticalExtentId();
            if(getExVerticalId==null){
                idExVerticalId = new BigDecimal(FIRST_ID);
            }else{
                idExVerticalId = new BigDecimal(getExVerticalId.longValue()+1);   
            }

            extentModel.setId(idExVerticalId);
            extentModel.setExExtentId(value.getExExtentId());
            extentModel.setMaximumValue(value.getMaximumValue());
            extentModel.setMinimumValue(value.getMinimumValue());
            extentModel.setVerticalCrs(value.getVerticalCrs());

            if(exVerticalExtentController.getDataById(value.getExExtentId())==null){
                isFlag=true;
                id = idExVerticalId;
            }else{
                isFlag=false;
                id=exVerticalExtentController.getDataById(value.getExExtentId()).getId();
            }

            if(isFlag){
                ret=exVerticalExtentController.saveExVerticalExtent(extentModel);
            }else{
                ret=exVerticalExtentController.updateExVerticalExtent(id,extentModel);
            }
            
            displayLog(true, "ExVerticalExtent");
            displayLog(true, "id = "+id);
            displayLog(true, "MaximumValue = "+value.getMaximumValue());
            displayLog(true, "MinimumValue = "+value.getMinimumValue());
            displayLog(true, "VerticalCrs = "+value.getVerticalCrs());
            displayLog(true, "foreign key ExExtendId = "+value.getExExtentId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table ExVerticalExtent " + ret+"\n");
            }else{
               displayLog(true, "Status table ExVerticalExtent" + ret+"\n");
            }
              
        }catch(Exception e){
            
            displayLog(false, "Error ExVerticalExtent " + e.toString());
            displayLog(true, "Status table ExVerticalExtent" + ret+"\n");
        }
        
    }
    //end save identification 
    
    //ciseries
    public void saveUpdateCiSeries(CiSeriesModel value) {

        String ret=null;
        try{
            CiSeriesController csc = new CiSeriesController(session, hibernateUtilXml);
            CiSeriesModel csm = new CiSeriesModel();
            
            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getId;
            BigDecimal idCiSeries;

            getId = csc.getMaxCiSeriesId();
            if (getId == null) {
               idCiSeries = new BigDecimal(FIRST_ID);
            } else {
                idCiSeries = new BigDecimal(getId.longValue() + 1);
            }

                csm.setId(idCiSeries);
                csm.setIssueIdentification(value.getIssueIdentification());
                csm.setName(value.getName());
                csm.setPage(value.getPage());
                csm.setCiCitationId(value.getCiCitationId());

            if (csc.getDataById(value.getCiCitationId()) == null) {
                flag=true;
            } else {
               flag=false;
               id = csc.getDataById(value.getCiCitationId()).getId();
            }

            if (flag) {
                ret = csc.saveCiSeries(csm);
            } else {
                ret = csc.updateCiSeries(id, csm);
            }
            
            displayLog(true, "CiSeries");
            displayLog(true, "id = "+idCiSeries);
            displayLog(true, "Name = "+value.getName());
            displayLog(true, "Page = "+value.getPage());
            displayLog(true, "IssueIdentification = "+value.getIssueIdentification());
            displayLog(true, "foreign key CiCitationId = "+value.getCiCitationId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table CiSeries " + ret+"\n");
            }else{
               displayLog(true, "Status table CiSeries " + ret+"\n");
            }
                    
        }catch(Exception e){
            
            displayLog(false, "Error CiSeries " + e.toString());
            displayLog(true, "Status table CiSeries " + ret+"\n");
        }

    }
    //end ciseries
    
    //mdconstraints
    public void saveUpdateMetadataConstraints(String column,BigDecimal foreignId,MdConstraintsModel value) {

        try{
            MdConstraintsController mdConstraintsController = new MdConstraintsController(session, hibernateUtilXml);
            MdConstraintsModel mdConstraintsModel = new MdConstraintsModel();

            boolean isFlag=false;
            String ret=null;
            BigDecimal getIdMdConstraints;
            BigDecimal idMdConstraints;
            BigDecimal id=null;

            getIdMdConstraints = mdConstraintsController.getMaxMdConstraintsId();
            if (getIdMdConstraints == null) {
                idMdConstraints = new BigDecimal(FIRST_ID);
            } else {
                idMdConstraints = new BigDecimal(getIdMdConstraints.longValue() + 1);
            }

            mdConstraintsModel.setId(idMdConstraints);
            mdConstraintsModel.setMdIdentificationId(value.getMdIdentificationId());
            mdConstraintsModel.setMdMetadataId(value.getMdMetadataId());
            mdConstraintsModel.setExtendsType(value.getExtendsType());
            mdConstraintsModel.setSvServiceidentificationId(value.getSvServiceidentificationId());

            if (mdConstraintsController.getDataById(column,foreignId) == null) {
                isFlag=true;
            } else {
                isFlag=false;
                id = mdConstraintsController.getDataById(column,foreignId).getId();
            }

            if (isFlag) {
                ret = mdConstraintsController.saveMdConstraints(mdConstraintsModel);
            } else {
                ret = mdConstraintsController.updateMdConstraints(id,mdConstraintsModel);
            }
            
            displayLog(true, "MdConstraints");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = "+value.getExtendsType());
            displayLog(true, "foreign key "+" = "+foreignId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdConstraints " + ret+"\n");
            }else{
               displayLog(true, "Status table MdConstraints " + ret+"\n");
            }
                    
        }catch(Exception e){
            
            displayLog(false, "Error MdConstraints " + e.toString());
        }

    }

    public void saveUpdateMetadataConstraintsUseLimitation(MdConstraintsUselimitationModel value) {

        try{
            MdConstraintsUseLimitationController limitationController = new MdConstraintsUseLimitationController(session, hibernateUtilXml);
            MdConstraintsUselimitationModel uselimitationModel = new MdConstraintsUselimitationModel();

            String ret=null;
            boolean isFlag=false;
            BigDecimal id=null;

            uselimitationModel.setMdConstraintsId(value.getMdConstraintsId());
            uselimitationModel.setUseLimitation(value.getUseLimitation());

            if (limitationController.getDataById(value.getMdConstraintsId()) == null) {
               isFlag=true;
            } else {
                isFlag=false;
                id = limitationController.getDataById(value.getMdConstraintsId()).getMdConstraintsId();
            }

            if (isFlag) {
                ret = limitationController.saveMdConstraintsUseLimitation(uselimitationModel);
            } else {
                ret = limitationController.updateMdConstraintsUseLimitation(id,uselimitationModel);
            }

            displayLog(true, "MdConstraintsUseLimitation");
            displayLog(true, "UseLimitation = "+value.getUseLimitation());
            displayLog(true, "foreign key MdConstraintsId = "+value.getMdConstraintsId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdConstraintsUseLimitation " + ret+"\n");
            }else{
               displayLog(true, "Status table MdConstraintsUseLimitation " + ret+"\n");
            }
                             
        }catch(Exception e){
            
            displayLog(false, "Error MdConstraintsUseLimitation " + e.toString());
        }    
        

    }
    
    public void saveUpdateMdSecurityConstraints(MdSecurityConstraintsModel value) {

        String ret=null;
        displayLog(true, "MdSecurityConstraints");
           
        try{
            MdSecurityConstraintsController mscc = new MdSecurityConstraintsController(session, hibernateUtilXml);
            MdSecurityConstraintsModel mscm = new MdSecurityConstraintsModel();
            MdClassificationCodeController mccc = new MdClassificationCodeController(session, hibernateUtilXml);

            boolean isFlag=false;
            BigDecimal id=null;
            String code=null;
            
            System.out.println(value.getClassification());
            
            try{
                
                if(value.getClassification()==null || value.getClassification()=="-"){
                   code = "000";
                   displayLog(true, "Classification = "+code);
                }else{
                    code = mccc.getDataByDomain(value.getClassification()).getCode();
                    displayLog(true, "Classification = "+code);
                    
                }  
                
            }catch(NullPointerException n){
                 Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
                 displayLog(true, "Classification = "+code);
                
            }
            
            mscm.setClassification(code);
            mscm.setClassificationSystem(value.getClassificationSystem());
            mscm.setHandlingDescription(value.getHandlingDescription());
            mscm.setUserNote(value.getUserNote());
            mscm.setMdConstraintsId(value.getMdConstraintsId());
            
            if(mscc.getDataById(value.getMdConstraintsId())==null){
                isFlag=true;
                id = value.getMdConstraintsId();
            }else{
                isFlag=false;
                id = mscc.getDataById(value.getMdConstraintsId()).getMdConstraintsId();
            }

            if (isFlag) {
                ret = mscc.saveMdSecurityConstraints(mscm);
            } else {
                ret = mscc.updateMdSecurityConstraints(id, mscm);
            }

           
            displayLog(true, "ClassificationSystem = "+value.getClassificationSystem());
            displayLog(true, "HandlingDescription = "+value.getHandlingDescription());
            displayLog(true, "UserNote = "+value.getUserNote());
            displayLog(true, "foreign key MdConstraintsId = "+value.getMdConstraintsId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdSecurityConstraints " + ret+"\n");
            }else{
               displayLog(true, "Status table MdSecurityConstraints " + ret+"\n");
            }
                             
        }catch(Exception e){
            
            displayLog(false, "Error MdSecurityConstraints " + e.toString());
            displayLog(true, "Status table MdSecurityConstraints " + ret+"\n");
        }    
        

    }
    
    public void saveUpdateMdLegalConstraints(MdLegalConstraintsModel value) {

        String ret=null;
        try{
            MdLegalConstraintsController mscc = new MdLegalConstraintsController(session, hibernateUtilXml);
            MdLegalConstraintsModel mscm = new MdLegalConstraintsModel();

            boolean isFlag=false;
            BigDecimal id=null;

            mscm.setMdConstraintsId(value.getMdConstraintsId());
            
            if(mscc.getDataById(value.getMdConstraintsId())==null){
                isFlag=true;
                id = value.getMdConstraintsId();
            }else{
                isFlag=false;
                id = mscc.getDataById(value.getMdConstraintsId()).getMdConstraintsId();
            }

            if (isFlag) {
                ret = mscc.saveMdLegalConstraints(mscm);
            } else {
                ret = mscc.updateMdLegalConstraints(id, mscm);
            }

            displayLog(true, "MdLegalConstraints");
            displayLog(true, "id = "+value.getMdConstraintsId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdLegalConstraints " + ret+"\n");
            }else{
               displayLog(true, "Status table MdLegalConstraints " + ret+"\n");
            }
                             
        }catch(Exception e){
            
            displayLog(false, "Error MdLegalConstraints " + e.toString());
            displayLog(true, "Status table MdLegalConstraints " + ret+"\n");
        }    
       
    }
    
    public void saveUpdateMdLegalConstraintsOther(MdLegalConstraintsOtherModel value) {

        String ret=null;
        try{
            MdLegalConstraintsOtherController mscc = new MdLegalConstraintsOtherController(session, hibernateUtilXml);
            MdLegalConstraintsOtherModel mscm = new MdLegalConstraintsOtherModel();

            boolean isFlag=false;
            BigDecimal id=null;

            mscm.setMdLegalConstraintsId(value.getMdLegalConstraintsId());
            mscm.setOtherConstraints(value.getOtherConstraints());
            
            if(mscc.getDataById(value.getMdLegalConstraintsId())==null){
                isFlag=true;
                id = value.getMdLegalConstraintsId();
            }else{
                isFlag=false;
                id = mscc.getDataById(value.getMdLegalConstraintsId()).getMdLegalConstraintsId();
            }

            if (isFlag) {
                ret = mscc.saveMdLegalConstraintsOther(mscm);
            } else {
                ret = mscc.updateMdLegalConstraintsOther(id, mscm);
            }

            displayLog(true, "MdLegalConstraintsOther");
            displayLog(true, "otherconstraints = "+value.getOtherConstraints());
            displayLog(true, "foreign key mdlegalconstraints = "+value.getMdLegalConstraintsId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdLegalConstraintsOther " + ret+"\n");
            }else{
               displayLog(true, "Status table MdLegalConstraintsOther " + ret+"\n");
            }
                             
        }catch(Exception e){
            
            displayLog(false, "Error MdLegalConstraintsOther " + e.toString());
            displayLog(true, "Status table MdLegalConstraintsOther " + ret+"\n");
        }    
       
    }
    
    //end mdconstraints
    
    //mdapplicationschemainfo
    public void saveUpdateMdApplicationSchemaInfo(MdApplicationSchemaInfoModel value){
    
        String ret=null;
        try{
            MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
            MdApplicationSchemaInfoModel infoModel = new MdApplicationSchemaInfoModel();

            BigDecimal getMdApplicationId;
            BigDecimal MdApplicationId;
            boolean isFlag=false;
            BigDecimal id=null;

            getMdApplicationId = masic.getMaxMdApplicationSchemaInfoId();
            if(getMdApplicationId==null){
                MdApplicationId= new BigDecimal(FIRST_ID);
            }else{
                MdApplicationId= new BigDecimal(getMdApplicationId.longValue()+1);
            }

            infoModel.setId(MdApplicationId);
            infoModel.setMdMetadataId(value.getMdMetadataId());
            infoModel.setSchemaLanguage(value.getSchemaLanguage());
            infoModel.setConstraintLanguage(value.getConstraintLanguage());
            infoModel.setSoftwareDevelopmentFileFormat(value.getSoftwareDevelopmentFileFormat());
            infoModel.setSchemaAscii(value.getSchemaAscii());

            if(masic.getDataById(value.getMdMetadataId())==null){
               isFlag=true;
               id = MdApplicationId;
            }else{
               isFlag=false;
               id=masic.getDataById(value.getMdMetadataId()).getId();
            }

            if(isFlag){
                ret=masic.saveMdApplicationSchemaInfo(infoModel);
            }else{
                ret=masic.UpdateMdApplicationSchemaInfo(id,infoModel);
            }

            displayLog(true, "\nMdApplicationSchemaInfo");
            displayLog(true, "id = "+MdApplicationId);
            displayLog(true, "SchemaLanguage = "+value.getSchemaLanguage());
            displayLog(true, "ConstraintLanguage = "+value.getConstraintLanguage());
            displayLog(true, "SoftwareDevelopmentFileFormat = "+value.getSoftwareDevelopmentFileFormat());
            displayLog(true, "SchemaAscii = "+value.getSchemaAscii());
            displayLog(true, "foreign key MdMetadataId = "+value.getMdMetadataId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdApplicationSchemaInfo " + ret+"\n");
            }else{
               displayLog(true, "Status table MdApplicationSchemaInfo " + ret+"\n");
            }
                    
        }catch(Exception e){
            
            displayLog(false, "Error MdApplicationSchemaInfo " + e.toString());
            displayLog(true, "Status table MdApplicationSchemaInfo " + ret+"\n");
        }

    }
    //end mdapplicationschemainfo
    
    //metadataextensioninfo
    public void saveUpdateMdMetadataExtensionInfo(MdMetadataExtensionInfoModel value){
    
        String ret=null;
        try{
            MdMetadataExtensionInfoController infoController = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
            MdMetadataExtensionInfoModel infoModel = new MdMetadataExtensionInfoModel();
            
            boolean isFlag=false;
            BigDecimal id=null;
            BigDecimal idMdExtensionInfo;
            BigDecimal getIdMdExtensionInfo;

            getIdMdExtensionInfo = infoController.getMaxMdMetadataExtensionInfoId();
            if(getIdMdExtensionInfo==null){
                idMdExtensionInfo = new BigDecimal(FIRST_ID);
            }else{
                idMdExtensionInfo = new BigDecimal(getIdMdExtensionInfo.longValue()+1);
            }

            infoModel.setId(idMdExtensionInfo);
            infoModel.setMdMetadataId(value.getMdMetadataId());

            if(infoController.getDataById(value.getMdMetadataId())==null){
                isFlag=true;
                id=idMdExtensionInfo;
            }else{
                isFlag=false;
                id=infoController.getDataById(value.getMdMetadataId()).getId();
            }

            if(isFlag){
                ret=infoController.saveMdMetadataExtensionInfo(infoModel);
            }else{
                ret=infoController.UpdateMdMetadataExtensionInfo(id,infoModel);
            }
            
            displayLog(true, "\nMdExtensionInfo");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key MdMetadataId = "+value.getMdMetadataId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdExtensionInfo " + ret+"\n");
            }else{
               displayLog(true, "Status table MdExtensionInfo " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdExtensionInfo " + e.toString());
            displayLog(true, "Status table MdExtensionInfo " + ret+"\n");

        }
    }
    
    public void saveUpdateMdExtendedElementInfo(MdExtendedElementInfoModel value){
    
        String ret=null;
        try{
            
            MdExtendedElementInfoController infoController = new MdExtendedElementInfoController(session, hibernateUtilXml);
            MdExtendedElementInfoModel infoModel = new MdExtendedElementInfoModel();
            MdDataTypeCodeController codeController = new MdDataTypeCodeController(session, hibernateUtilXml);
            MdObligationCodeController mocc = new MdObligationCodeController(session, hibernateUtilXml);

            BigDecimal id=null;
            BigDecimal getId;
            BigDecimal MdExtendedId;
            boolean isFlag=false;
            String code="";
            String obligationCode="";


            getId = infoController.getMaxMdExtendedElementInfoId();
            if(getId==null){
                MdExtendedId = new BigDecimal(FIRST_ID);
            }else{
                MdExtendedId = new BigDecimal(getId.longValue()+1);
            }

            String domainName=value.getDataType();
            if(domainName==null){
                code="000";
            }else{
                code= codeController.getDataByDomain(domainName).getCode();
            }

             String domainObligation=value.getObligation();
            if(domainObligation==null){
                obligationCode ="000";
            }else{
                obligationCode = mocc.getDataByDomain(domainName).getCode();
            }

            BigDecimal domainCode;
            if(value.getStringDomainCode()==null || value.getStringDomainCode()=="-"){
                domainCode=BigDecimal.ZERO;
            }else{
                domainCode=new BigDecimal(value.getStringDomainCode());
            }

            infoModel.setId(MdExtendedId);
            infoModel.setName(value.getName());
            infoModel.setDefinition(value.getDefinition());
            infoModel.setCondition(value.getCondition());
            infoModel.setShortname(value.getShortname());
            infoModel.setDomainCode(domainCode);
            infoModel.setObligation(obligationCode);
            infoModel.setDataType(code);
            infoModel.setMaximumOccurrence(value.getMaximumOccurrence());
            infoModel.setMdMetadataExtensionInfoId(value.getMdMetadataExtensionInfoId());
            infoModel.setDomainValue(value.getDomainValue());
            infoModel.setRule(value.getRule());

            if(infoController.getDataById(value.getMdMetadataExtensionInfoId())==null){
                isFlag=true;
                id = MdExtendedId;
            }else{
                isFlag=false;
                id=infoController.getDataById(value.getMdMetadataExtensionInfoId()).getId();
            }

            if(isFlag){
                ret=infoController.saveMdExtendedElementInfo(infoModel);
            }else{
                ret=infoController.updateMdExtendedElementInfo(id,infoModel);
            }
            
            displayLog(true, "MdExtendedElementInfo");
            displayLog(true, "id = "+id);
            displayLog(true, "Name = "+value.getName());
            displayLog(true, "Definition = "+value.getDefinition());
            displayLog(true, "Condition = "+value.getCondition());
            displayLog(true, "Shortname = "+value.getShortname());
            displayLog(true, "DomainCode = "+domainCode);
            displayLog(true, "Obligation = "+obligationCode);
            displayLog(true, "DataType = "+code);
            displayLog(true, "MaximumOccurrence = "+value.getMaximumOccurrence());
            displayLog(true, "DomainValue = "+value.getDomainValue());
            displayLog(true, "Rule = "+value.getRule());
            displayLog(true, "foreign key MdMetadataExtensionInfoId = "+value.getMdMetadataExtensionInfoId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdExtendedElementInfo " + ret+"\n");
            }else{
               displayLog(true, "Status table MdExtendedElementInfo " + ret+"\n");
            }
   
        }catch(Exception e){
            
            displayLog(false, "Error MdExtendedElementInfo " + e.toString());
            displayLog(true, "Status table MdExtendedElementInfo " + ret+"\n");
        }
        
    }
        
    public void saveUpdateMdExtendedElementInfoParent(MdExtendedElementInfoParentModel value){

        String ret=null;
        try{
            MdExtendedElementInfoParentController infoController = new MdExtendedElementInfoParentController(session, hibernateUtilXml);
            MdExtendedElementInfoParentModel infoModel = new MdExtendedElementInfoParentModel();

            boolean isFlag=false;
            BigDecimal id=null;

            infoModel.setMdExtendedElementInfoId(value.getMdExtendedElementInfoId());
            infoModel.setParentEntity(value.getParentEntity());

            if(infoController.getDataById(value.getMdExtendedElementInfoId())==null){
                isFlag=true;
            }else{
                isFlag=false;
                id=infoController.getDataById(value.getMdExtendedElementInfoId()).getMdExtendedElementInfoId();
            }

            if(isFlag){
                ret=infoController.saveMdExtendedElementInfoParentParent(infoModel);
            }else{
                ret=infoController.updateMdExtendedElementInfoParent(id,infoModel);
            }

            displayLog(true, "MdExtendedElementInfoParent");
            displayLog(true, "ParentEntity = "+value.getParentEntity());
            displayLog(true, "foreign key MdExtendedElementInfoId = "+value.getMdExtendedElementInfoId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdExtendedElementInfoParent " + ret+"\n");
            }else{
               displayLog(true, "Status table MdExtendedElementInfoParent " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error MdExtendedElementInfoParent " + e.toString());
            displayLog(true, "Status table MdExtendedElementInfoParent " + ret+"\n");
        }
        
    }
    //end metadataextensioninfo

    //save dataquality
    //save md_scope
    public void saveUpdateDqDataQuality(DqDataQualityModel value) {

        String ret=null;
        try{
            DqDataQualityController dqDataQualityController = new DqDataQualityController(session, hibernateUtilXml);
            DqDataQualityModel dqDataQualityModel = new DqDataQualityModel();

            
            BigDecimal getIdDqDataQuality;
            BigDecimal idDqDataQuality;
            BigDecimal id=null;
            boolean isFlag=false;

            getIdDqDataQuality = dqDataQualityController.getMaxDqDataQualityId();
            if (getIdDqDataQuality == null) {
                idDqDataQuality = new BigDecimal(FIRST_ID);
            } else {
                idDqDataQuality = new BigDecimal(getIdDqDataQuality.longValue() + 1);
            }

            dqDataQualityModel.setId(idDqDataQuality);
            dqDataQualityModel.setMdMetadataId(value.getMdMetadataId());

            if (dqDataQualityController.getDataById(value.getMdMetadataId()) == null) {
                isFlag=true;
                id = idDqDataQuality;
            } else {
                isFlag=false;
                id = dqDataQualityController.getDataById(value.getMdMetadataId()).getId();
            }

            if (isFlag) {
                ret = dqDataQualityController.saveDqDataQuality(dqDataQualityModel);
            } else {
                ret = dqDataQualityController.updateDqDataQuality(id,dqDataQualityModel);
            }
            
            displayLog(true, "\nDqDataQuality");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key MdMetadataId = "+value.getMdMetadataId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqDataQuality " + ret+"\n");
            }else{
               displayLog(true, "Status table DqDataQuality " + ret+"\n");
            }
   
        }catch(Exception e){
            
            displayLog(false, "Error DqDataQuality " + e.toString());
            displayLog(true, "Status table DqDataQuality " + ret+"\n");
        }

    }

    public void saveUpdateDqScope(DqScopeModel value) {

        String ret=null;
        try{
            DqScopeController dqScopeController = new DqScopeController(session, hibernateUtilXml);
            DqScopeModel dqScopeModel = new DqScopeModel();
            MdScopecodeController msc = new MdScopecodeController(session, hibernateUtilXml);

            boolean flag=false;
            BigDecimal getIdDqScope;
            BigDecimal idDqScope;
            String code;
            BigDecimal id=null;

            getIdDqScope = dqScopeController.getMaxScopeId();
            if (getIdDqScope == null) {
                idDqScope = new BigDecimal(FIRST_ID);
            } else {
                idDqScope = new BigDecimal(getIdDqScope.longValue() + 1);
            }

            code=value.getDqLevel();
            if(code==null){
                code="000";
            }else{
                code=msc.getDataByCode(value.getDqLevel()).getCode();
            }

            dqScopeModel.setId(idDqScope);
            dqScopeModel.setDqLevel(code);
            dqScopeModel.setDqDataQualityId(value.getDqDataQualityId());

            if (dqScopeController.getDataById(value.getDqDataQualityId()) == null) {
                flag=true;
                id = idDqScope;
            } else {
                flag=false;
                id = dqScopeController.getDataById(value.getDqDataQualityId()).getId();
            }

            if (flag) {
                ret = dqScopeController.saveDqScope(dqScopeModel);
            } else {
                ret = dqScopeController.updateDqScope(id,dqScopeModel);
            }

            displayLog(true, "DqScope");
            displayLog(true, "id = "+id);
            displayLog(true, "DqLevel = "+code);
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqScope " + ret+"\n");
            }else{
               displayLog(true, "Status table DqScope " + ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error DqScope " + e.toString());
            displayLog(true, "Status table DqScope " + ret+"\n");
        }

    }

    public void saveUpdateDqScopeGroup(BigDecimal dataQualityId) {
       
        try{
            //local variable
            BigDecimal dqScopeId=null;
            BigDecimal exExtentId=null;
            BigDecimal exGeographicExtentId=null;

            DqScopeModel dsm = new DqScopeModel();

            dsm.setDqDataQualityId(dataQualityId);
            dsm.setDqLevel(varDqScope.getLevel());

            saveUpdateDqScope(dsm);
            jprocessbar.setValue(186);
            jprocessbar.setStringPainted(true);

            //ex_extent
            DqScopeController dsc = new DqScopeController(session, hibernateUtilXml);
            dqScopeId = dsc.getDataById(dataQualityId).getId();
            ExExtentModel eem = new ExExtentModel();

            eem.setDqScopeId(dqScopeId);

            saveUpdateExExtent(ExExtentModel.DQ_SCOPEID,dqScopeId,eem);
            jprocessbar.setValue(188);
            jprocessbar.setStringPainted(true);

             //ex_geographicextent
            ExGeographicExtentModel egem = new ExGeographicExtentModel();
            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            exExtentId = eec.getDataById(ExExtentModel.DQ_SCOPEID,dqScopeId).getId();

            egem.setExExtentId(exExtentId);
            egem.setExtendsType(nullValue);
            egem.setStringExtentTypeCode("false");

            saveUpdateExExtentGeographicExtent(ExGeographicExtentModel.EX_EXTENTID,exExtentId,egem);
            jprocessbar.setValue(190);
            jprocessbar.setStringPainted(true);

             //ex_extent_boundingbox
            ExGeographicBoundingBoxModel boxModel = new ExGeographicBoundingBoxModel();
            ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
            exGeographicExtentId = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();

            boxModel.setExGeographicExtentId(exGeographicExtentId);
            boxModel.setEastBoundLongitudeString("0");
            boxModel.setNorthBoundLongitudString("0");
            boxModel.setSouthBoundLongitudeString("0");
            boxModel.setWestBoundLongitudeString("0");

            saveUpdateExExtentGeographicBoundingBox(boxModel);
            jprocessbar.setValue(192);
            jprocessbar.setStringPainted(true);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end save md_scope

    //save dq_completeness
    public void saveUpdateDqCompleteness(DqCompletenessModel value) {
        
        String ret=null;
        try{
            DqCompletenessController dqCompletenessController = new DqCompletenessController(session, hibernateUtilXml);
            DqCompletenessModel dqCompletenessModel = new DqCompletenessModel();

            BigDecimal dqCompletenessId;
            BigDecimal getdqCompletenessId;
            BigDecimal id=null;       
            boolean flag=false;

            getdqCompletenessId = dqCompletenessController.getMaxDqCompletenessId();
            if (getdqCompletenessId == null) {
                dqCompletenessId = new BigDecimal(FIRST_ID);
            } else {
                dqCompletenessId = new BigDecimal(getdqCompletenessId.longValue() + 1);
            }

            dqCompletenessModel.setId(dqCompletenessId);
            dqCompletenessModel.setDqDataQualityId(value.getDqDataQualityId());

            if (dqCompletenessController.getDataById(value.getDqDataQualityId()) == null) {
               flag=true;
               id = dqCompletenessId;
            } else {
                flag=false;
                id = dqCompletenessController.getDataById(value.getDqDataQualityId()).getId();
            }

            if (flag) {
                ret = dqCompletenessController.saveDqDataQuality(dqCompletenessModel);
            } else {
                ret = dqCompletenessController.updateDqDataQuality(id,dqCompletenessModel);
            }
            
            displayLog(true, "DqCompleteness");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqCompleteness " + ret+"\n");
            }else{
               displayLog(true, "Status table DqCompleteness " + ret+"\n");
            }
   
        }catch(Exception e){
            
            displayLog(false, "Error DqCompleteness " + e.toString());
            displayLog(true, "Status table DqCompleteness " + ret+"\n");
        }

    }

    //save dq_completeness_comission
    public void saveUpdateDqCompcomm(DqCompCommModel value) {

        String ret=null;
        try{
            DqCompCommController dqCompCommController = new DqCompCommController(session, hibernateUtilXml);
            DqCompCommModel dqCompCommModel = new DqCompCommModel();
       
            boolean flag=false;
            BigDecimal getDqCompCommId;
            BigDecimal DqComCommId;
            BigDecimal id=null;

            getDqCompCommId = dqCompCommController.getMaxDqCompCommId();
            if (getDqCompCommId == null) {
                DqComCommId = new BigDecimal(FIRST_ID);
            } else {
                DqComCommId = new BigDecimal(getDqCompCommId.longValue() + 1);
            }

            dqCompCommModel.setId(DqComCommId);
            dqCompCommModel.setDqCompletenessId(value.getDqCompletenessId());
            dqCompCommModel.setDqDataQualityId(value.getDqDataQualityId());

            if (dqCompCommController.getDataById(value.getDqCompletenessId()) == null) {
                flag=true;
                id = DqComCommId;
            } else {
                flag=false;
                id = dqCompCommController.getDataById(value.getDqCompletenessId()).getId();
            }

            if (flag) {
                ret = dqCompCommController.saveDqCompComm(dqCompCommModel);
            } else {
                ret = dqCompCommController.updateDqCompComm(id,dqCompCommModel);
            }
            
            displayLog(true, "DqCompComm");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqCompletenessId = "+value.getDqCompletenessId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqCompComm " + ret+"\n");
            }else{
               displayLog(true, "Status table DqCompComm " + ret+"\n");
            }
   
        }catch(Exception e){
            
            displayLog(false, "Error DqCompComm " + e.toString());
            displayLog(true, "Status table DqCompComm " + ret+"\n");
        }

    }
    //dq for loop

    public void saveUpdateDqCompcommGroup(BigDecimal dqDataQualityId,BigDecimal dqCompletenessId) {

        try{
            //dqcompletenesscomission
            DqCompCommModel dccm = new DqCompCommModel();  

            dccm.setDqDataQualityId(dqDataQualityId);
            dccm.setDqCompletenessId(dqCompletenessId);

            saveUpdateDqCompcomm(dccm);
            jprocessbar.setValue(196);
            jprocessbar.setStringPainted(true);

                //dq_element
                String columnName = DqElementModel.DQ_COMPCOMMID;
                DqElementModel dqElementModel = new DqElementModel();
                DqCompCommController dqCompCommController = new DqCompCommController(session, hibernateUtilXml);
                BigDecimal IdDqCompComm = dqCompCommController.getDataById(dqCompletenessId).getId();

                dqElementModel.setMeasureDescription(varDqCompletenessComission.getMeasureDescription());
                dqElementModel.setEvaluationMethodType(varDqCompletenessComission.getEvaluationMethodType());
                dqElementModel.setEvaluationMethodDescription(varDqCompletenessComission.getEvaluationMethodDescription());
                dqElementModel.setExtendsType(nullValue);
                dqElementModel.setDqDataQualityId(dqDataQualityId);

                saveUpdateDqElement(IdDqCompComm, columnName, dqElementModel);
                jprocessbar.setValue(198);
                jprocessbar.setStringPainted(true);

                    //dq_element_name_of_measure
                    DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                    BigDecimal IdDqElement = dqElementController.getDataById(IdDqCompComm, columnName).getId();
                    DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                    dqElementNameOfMeasureModel.setNameOfMeasure(varDqCompletenessComission.getNameOfMeasure());
                    dqElementNameOfMeasureModel.setDqCompCommId(IdDqCompComm);

                    saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                    jprocessbar.setValue(200);
                    jprocessbar.setStringPainted(true);

                    //dq_element_datetime
                    DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                    dqElementDateTimeModel.setDqCompCommId(IdDqCompComm);
                    dqElementDateTimeModel.setStringDateTime(varDqCompletenessComission.getDateTime());

                    saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                    jprocessbar.setValue(202);
                    jprocessbar.setStringPainted(true);

                    //dq_result
                    saveUpdateDqResult(IdDqElement, columnName);
                    jprocessbar.setValue(204);
                    jprocessbar.setStringPainted(true);

                    //measureidentification
                    //mdidentifier
                    MdIdentifierModel mim = new MdIdentifierModel();
                    mim.setCode(varDqCompletenessComission.getCode());
                    mim.setExtendsType(nullValue);
                    mim.setDqElementId(IdDqElement);

                    saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                    jprocessbar.setValue(206);
                    jprocessbar.setStringPainted(true);

                        //citation
                        CiCitationModel ccm = new CiCitationModel();
                        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                        ccm.setTitle(varDqCompletenessComission.getTitleMeasure());
                        ccm.setEdition(varDqCompletenessComission.getEdition());
                        ccm.setStringEditionDate(varDqCompletenessComission.getEditionDate());
                        ccm.setMdIdentifierId(mdIdentifierIdSup);

                        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                        jprocessbar.setValue(208);
                        jprocessbar.setStringPainted(true);

                            //cidate
                            CiDateModel cdm = new CiDateModel();
                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                            cdm.setStringDate_(varDqCompletenessComission.getDateMeasure());
                            cdm.setDateType(varDqCompletenessComission.getDateTypeMeasure());
                            cdm.setCiCitationId(citationIdSup);

                            saveUpdateCiDate(cdm);
                            jprocessbar.setValue(210);
                            jprocessbar.setStringPainted(true);

                            //citation_alternate_title
                            CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();

                            ccatm.setAlternateTitle(varDqCompletenessComission.getAlternateTitle());
                            ccatm.setCi_citationid(citationIdSup);

                            saveUpdateCiCitationAlternateTitle(ccatm);
                            jprocessbar.setValue(212);
                            jprocessbar.setStringPainted(true);

                            //mdidentifier
                            MdIdentifierModel mimsub = new MdIdentifierModel();
                            mimsub.setCode(varDqCompletenessComission.getCodeIdentifier());
                            mimsub.setCiCitationId(citationIdSup);
                            mimsub.setExtendsType(nullValue);

                            saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationIdSup, mimsub);
                            jprocessbar.setValue(214);
                            jprocessbar.setStringPainted(true);

                                //citation
                                CiCitationModel ccmSub = new CiCitationModel();
                                BigDecimal mdIdentifierSub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationIdSup).getId();

                                ccmSub.setTitle(varDqCompletenessComission.getTitleIdentifier());
                                ccmSub.setMdIdentifierId(mdIdentifierSub);

                                saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub,ccmSub);
                                jprocessbar.setValue(216);
                                jprocessbar.setStringPainted(true);

                                    //cidate
                                    CiDateModel cdmSub = new CiDateModel();
                                    BigDecimal  citationSub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub).getId();

                                    cdmSub.setStringDate_(varDqCompletenessComission.getDateIdentifier());
                                    cdmSub.setDateType(varDqCompletenessComission.getDateTypeIdentifier());
                                    cdmSub.setCiCitationId(citationSub);

                                    saveUpdateCiDate(cdmSub);
                                    jprocessbar.setValue(218);
                                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult
                        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                        dqConformanceResultModel.setDqResultId(IdDqResult);
                        dqConformanceResultModel.setExplanation(varDqCompletenessComission.getExplanation());
                        dqConformanceResultModel.setStringPass(varDqCompletenessComission.getPass());

                        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                        jprocessbar.setValue(220);
                        jprocessbar.setStringPainted(true);

                            //dq_conformanceresult_citation
                            DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                            CiCitationModel ciCitationModel = new CiCitationModel();

                            BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                            ciCitationModel.setTitle(varDqCompletenessComission.getTitle());
                            ciCitationModel.setEdition(varDqCompletenessComission.getEditionConformance());
                            ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                            saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                            jprocessbar.setValue(222);
                            jprocessbar.setStringPainted(true);

                                //dq_conformanceresult_cidate
                                CiDateModel ciDateModel = new CiDateModel();
                                CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

                                BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                                ciDateModel.setStringDate_(varDqCompletenessComission.getDate());
                                ciDateModel.setDateType(varDqCompletenessComission.getDateType());
                                ciDateModel.setCiCitationId(citationConformance);

                                saveUpdateCiDate(ciDateModel);
                                jprocessbar.setValue(224);
                                jprocessbar.setStringPainted(true);

                    //evaluation procedure
                    //citation
                    CiCitationModel cmProcedure = new CiCitationModel();

                    cmProcedure.setTitle(varDqCompletenessComission.getTitleEvaluation());
                    cmProcedure.setDqElementId(IdDqElement);

                    saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
                    jprocessbar.setValue(226);
                    jprocessbar.setStringPainted(true);

                        //cidate
                        CiDateModel cdmProcedure = new CiDateModel();
                        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                        cdmProcedure.setStringDate_(varDqCompletenessComission.getDateEvaluation());
                        cdmProcedure.setDateType(varDqCompletenessComission.getDateTypeEvaluation());
                        cdmProcedure.setCiCitationId(citationProcedure);

                        saveUpdateCiDate(cdmProcedure);
                        jprocessbar.setValue(228);
                        jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult
                        ArrayList<String> list = new ArrayList<>();        
                        list.add(varDqCompletenessComission.getRemarks());
                        list.add(varDqCompletenessComission.getQuantityType());
                        list.add(varDqCompletenessComission.getQuantityTypeReference());
                        list.add(varDqCompletenessComission.getCatalogSymbol());
                        list.add(varDqCompletenessComission.getDescription());
                        list.add(varDqCompletenessComission.getDescriptionReference());
                        list.add(varDqCompletenessComission.getMetaDataProperty());
                        list.add(varDqCompletenessComission.getIdentifier());
                        list.add(varDqCompletenessComission.getUnitsSystem());

                        DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                        dqQuantitativeResultModel.setDqResultId(IdDqResult);
                        dqQuantitativeResultModel.setValueType(varDqCompletenessComission.getValueType());
                        dqQuantitativeResultModel.setValueUnitList(list);
                        dqQuantitativeResultModel.setErrorStatistic(varDqCompletenessComission.getErrorStatic());

                        saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                        jprocessbar.setValue(230);
                        jprocessbar.setStringPainted(true);

                            //dq_quantitativeresult_value
                            DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                            DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                            BigDecimal IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                            dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                            dqQuantitativeResultValueModel.setValue(varDqCompletenessComission.getValue());

                            saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                            jprocessbar.setValue(232);
                            jprocessbar.setStringPainted(true);
                            
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop    
    //end save dq_completeness_comission  

    //save dq_completeness_omission
    public void saveUpdateDqCompom(DqComPomModel value) {
        
        String ret=null;
        try{
            DqComPomController dqComPomController = new DqComPomController(session, hibernateUtilXml);
            DqComPomModel dqComPomModel = new DqComPomModel();

            boolean flag=false;
            BigDecimal dqComPomId;
            BigDecimal getDqComPomId;
            BigDecimal id=null;

            getDqComPomId = dqComPomController.getMaxDqComPomId();
            if (getDqComPomId == null) {
                dqComPomId = new BigDecimal(FIRST_ID);
            } else {
                dqComPomId = new BigDecimal(getDqComPomId.longValue() + 1);
            }

            dqComPomModel.setId(dqComPomId);
            dqComPomModel.setDqCompletenessId(value.getDqCompletenessId());
            dqComPomModel.setDqDataQualityId(value.getDqDataQualityId());

            if (dqComPomController.getDataById(value.getDqCompletenessId()) == null) {
                flag=true;
                id = dqComPomId;
            } else {
                flag=false;
                id = dqComPomController.getDataById(value.getDqCompletenessId()).getId();
            }

            if (flag) {
                ret = dqComPomController.saveDqComPom(dqComPomModel);
            } else {
                ret = dqComPomController.updateDqComPom(id,dqComPomModel);
            }
            
            displayLog(true, "DqCompom");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqCompletenessId = "+value.getDqCompletenessId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqCompom " + ret+"\n");
            }else{
               displayLog(true, "Status table DqCompom " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error DqCompom " + e.toString());
            displayLog(true, "Status table DqCompom " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqCompomGroup(BigDecimal dqDataQualityId,BigDecimal dqCompletenessId) {

        try{
            //dqcompleteness_omission
            DqComPomModel dcpm = new DqComPomModel();
            dcpm.setDqCompletenessId(dqCompletenessId);
            dcpm.setDqDataQualityId(dqDataQualityId);

            saveUpdateDqCompom(dcpm);
            jprocessbar.setValue(234);
            jprocessbar.setStringPainted(true);

                //dq_element
                String columnName = DqElementModel.DQ_COMPOMID;
                BigDecimal IdDqCompom;
                DqElementModel dqElementModel = new DqElementModel();
                DqComPomController DqCompomController = new DqComPomController(session, hibernateUtilXml);
                IdDqCompom = DqCompomController.getDataById(dqCompletenessId).getId();

                dqElementModel.setMeasureDescription(varDqCompletenessOmission.getMeasureDescription());
                dqElementModel.setEvaluationMethodType(varDqCompletenessOmission.getEvaluationMethodType());
                dqElementModel.setEvaluationMethodDescription(varDqCompletenessOmission.getEvaluationMethodDescription());
                dqElementModel.setDqDataQualityId(dqDataQualityId);

                saveUpdateDqElement(IdDqCompom, columnName, dqElementModel);
                jprocessbar.setValue(236);
                jprocessbar.setStringPainted(true);

                    //dq_element_name_of_measure
                    DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                    BigDecimal IdDqElement = dqElementController.getDataById(IdDqCompom, columnName).getId();
                    DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                    dqElementNameOfMeasureModel.setNameOfMeasure(varDqCompletenessOmission.getNameOfMeasure());
                    dqElementNameOfMeasureModel.setDqCompOmId(IdDqCompom);

                    saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                    jprocessbar.setValue(238);
                    jprocessbar.setStringPainted(true);

                    //dq_element_datetime
                    DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                    dqElementDateTimeModel.setStringDateTime(varDqCompletenessOmission.getDateTime());
                    dqElementDateTimeModel.setDqCompOmId(IdDqCompom);

                    saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                    jprocessbar.setValue(240);
                    jprocessbar.setStringPainted(true);

                    //dq_result
                    saveUpdateDqResult(IdDqElement, columnName);
                    jprocessbar.setValue(242);
                    jprocessbar.setStringPainted(true);

                    //measureidentification
                    //mdidentifier
                    MdIdentifierModel mim = new MdIdentifierModel();
                    mim.setCode(varDqCompletenessOmission.getCode());
                    mim.setExtendsType(nullValue);
                    mim.setDqElementId(IdDqElement);

                    saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                    jprocessbar.setValue(244);
                    jprocessbar.setStringPainted(true);

                        //citation
                        CiCitationModel ccm = new CiCitationModel();
                        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                        ccm.setTitle(varDqCompletenessOmission.getTitleMeasure());
                        ccm.setMdIdentifierId(mdIdentifierIdSup);

                        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                        jprocessbar.setValue(246);
                        jprocessbar.setStringPainted(true);

                            //cidate
                            CiDateModel cdm = new CiDateModel();
                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                            cdm.setStringDate_(varDqCompletenessOmission.getDateMeasure());
                            cdm.setDateType(varDqCompletenessOmission.getDateTypeMeasure());
                            cdm.setCiCitationId(citationIdSup);

                            saveUpdateCiDate(cdm);
                            jprocessbar.setValue(248);
                            jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqCompletenessOmission.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqCompletenessOmission.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(250);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqCompletenessOmission.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

                        jprocessbar.setValue(252);
                        jprocessbar.setStringPainted(true);

                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();
                            CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

                            BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            ciDateModel.setStringDate_(varDqCompletenessOmission.getDate());
                            ciDateModel.setDateType(varDqCompletenessOmission.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(254);
                            jprocessbar.setStringPainted(true);

                    //evaluation procedure
                    //citation
                    CiCitationModel cmProcedure = new CiCitationModel();

                    cmProcedure.setTitle(varDqCompletenessOmission.getTitleEvaluation());
                    cmProcedure.setDqElementId(IdDqElement);

                    saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
                    jprocessbar.setValue(256);
                    jprocessbar.setStringPainted(true);

                        //cidate
                        CiDateModel cdmProcedure = new CiDateModel();
                        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                        cdmProcedure.setStringDate_(varDqCompletenessOmission.getDateEvaluation());
                        cdmProcedure.setDateType(varDqCompletenessOmission.getDateTypeEvaluation());
                        cdmProcedure.setCiCitationId(citationProcedure);

                        saveUpdateCiDate(cdmProcedure);
                        jprocessbar.setValue(258);
                        jprocessbar.setStringPainted(true);

                         //dq_quantitativeresult
                        ArrayList<String> list = new ArrayList<>();        
                        list.add(varDqCompletenessOmission.getRemarks());
                        list.add(varDqCompletenessOmission.getQuantityType());
                        list.add(varDqCompletenessOmission.getQuantityTypeReference());
                        list.add(varDqCompletenessOmission.getCatalogSymbol());
                        list.add(varDqCompletenessOmission.getDescription());
                        list.add(varDqCompletenessOmission.getDescriptionReference());
                        list.add(varDqCompletenessOmission.getMetaDataProperty());
                        list.add(varDqCompletenessOmission.getIdentifier());
                        list.add(varDqCompletenessOmission.getUnitsSystem());
                        DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                        dqQuantitativeResultModel.setDqResultId(IdDqResult);
                        dqQuantitativeResultModel.setValueType(varDqCompletenessOmission.getValueType());
                        dqQuantitativeResultModel.setValueUnitList(list);
                        dqQuantitativeResultModel.setErrorStatistic(varDqCompletenessOmission.getErrorStatic());

                        saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                        jprocessbar.setValue(260);
                        jprocessbar.setStringPainted(true);

                            //dq_quantitativeresult_value
                            DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                            DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                            BigDecimal IdDqQuantitativeResult;
                            IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                            dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                            dqQuantitativeResultValueModel.setValue(varDqCompletenessOmission.getValue());

                            saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                            jprocessbar.setValue(262);
                            jprocessbar.setStringPainted(true);
                            
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop   
    //end save dq_completeness_omission
    //end save dq_completeness

    //save dq_conseptual_consistency
    public void saveUpdateDqLogicalconsistency(DqLogicalConsistencyModel value) {
         
        String ret=null;
        try{
            DqLogicalConsistencyController dqLogicalConsistencyController = new DqLogicalConsistencyController(session, hibernateUtilXml);
            DqLogicalConsistencyModel dqLogicalConsistencyModel = new DqLogicalConsistencyModel();

            boolean flag=false;
            BigDecimal getdqLogicalConsitencyId;
            BigDecimal dqLogicalConsistencyId;
            BigDecimal id=null;

            getdqLogicalConsitencyId = dqLogicalConsistencyController.getMaxDqLogicalConsitencyId();
            if (getdqLogicalConsitencyId == null) {
                dqLogicalConsistencyId = new BigDecimal(FIRST_ID);
            } else {
                dqLogicalConsistencyId = new BigDecimal(getdqLogicalConsitencyId.longValue() + 1);
            }

            dqLogicalConsistencyModel.setId(dqLogicalConsistencyId);
            dqLogicalConsistencyModel.setDqDataQualityId(value.getDqDataQualityId());

            if (dqLogicalConsistencyController.getDataById(value.getDqDataQualityId()) == null) {
                flag=true;
                id = dqLogicalConsistencyId;
            } else {
                flag=false;
                id = dqLogicalConsistencyController.getDataById(value.getDqDataQualityId()).getId();
            }

            if (flag) {
                ret = dqLogicalConsistencyController.saveDqLogicalConsitency(dqLogicalConsistencyModel);
            } else {
                ret = dqLogicalConsistencyController.updateDqLogicalConsitency(id,dqLogicalConsistencyModel);
            }

            displayLog(true, "DqLogicalconsistency");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqLogicalconsistency " + ret+"\n");
            }else{
               displayLog(true, "Status table DqLogicalconsistency " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error DqLogicalconsistency " + e.toString());
            displayLog(true, "Status table DqLogicalconsistency " + ret+"\n");
        }

    }

    public void saveUpdateDqConcconsis(DqConcconsisModel value) {
        
        String ret=null;
        try{
            DqConcconsisController dqConcconsisController = new DqConcconsisController(session, hibernateUtilXml);
            DqConcconsisModel dqConcconsisModel = new DqConcconsisModel();
            
            boolean flag=false;
            BigDecimal getIdDqConcconsis;
            BigDecimal IdDqConcconsis;
            BigDecimal id=null;

            getIdDqConcconsis = dqConcconsisController.getMaxDqConcconsisId();
            if (getIdDqConcconsis == null) {
                IdDqConcconsis = new BigDecimal(FIRST_ID);
            } else {
                IdDqConcconsis = new BigDecimal(getIdDqConcconsis.longValue() + 1);
            }

            dqConcconsisModel.setId(IdDqConcconsis);
            dqConcconsisModel.setDqDataQualityId(value.getDqDataQualityId());
            dqConcconsisModel.setDqLogicalConsistencyId(value.getDqLogicalConsistencyId());

            if (dqConcconsisController.getDataById(value.getDqLogicalConsistencyId()) == null) {
                flag=true;
                id = IdDqConcconsis;
            } else {
                flag=false;
                id = dqConcconsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
            }

            if (flag) {
                ret = dqConcconsisController.saveDqConcconsis(dqConcconsisModel);
            } else {
                ret = dqConcconsisController.updateDqConcconsis(id,dqConcconsisModel);
            }
            
            displayLog(true, "DqConcconsis");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqLogicalConsistencyId = "+value.getDqLogicalConsistencyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqConcconsis " + ret+"\n");
            }else{
               displayLog(true, "Status table DqConcconsis " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error DqConcconsis " + e.toString());
            displayLog(true, "Status table DqConcconsis " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqConcconsisGroup(BigDecimal dqLogicalConsitencyId,BigDecimal dataQualityId) {

        try{
        DqConcconsisModel dcm = new DqConcconsisModel();
        
        dcm.setDqDataQualityId(dataQualityId);
        dcm.setDqLogicalConsistencyId(dqLogicalConsitencyId);
        
        saveUpdateDqConcconsis(dcm);
        jprocessbar.setValue(266);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_CONCCONSISID;
            BigDecimal IdDqConcconsis;
            DqElementModel dqElementModel = new DqElementModel();
            DqConcconsisController DqConcconsisController = new DqConcconsisController(session, hibernateUtilXml);
            IdDqConcconsis = DqConcconsisController.getDataById(dqLogicalConsitencyId).getId();

            dqElementModel.setMeasureDescription(varDqConceptualConsistency.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqConceptualConsistency.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqConceptualConsistency.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqConcconsis, columnName, dqElementModel);
            jprocessbar.setValue(268);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqConcconsis, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqConceptualConsistency.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqConcConsisId(IdDqConcconsis);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(270);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqConceptualConsistency.getDateTime());
                dqElementDateTimeModel.setDqConcConsisId(IdDqConcconsis);
                
                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(272);
                jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(274);
                jprocessbar.setStringPainted(true);
        
                //measureidentification
                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varDqConceptualConsistency.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                jprocessbar.setValue(276);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqConceptualConsistency.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqConceptualConsistency.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(278);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqConceptualConsistency.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(280);
                        jprocessbar.setStringPainted(true);

                                //dq_conformanceresult_cidate
                                CiDateModel ciDateModel = new CiDateModel();
                                CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
                                BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                                ciDateModel.setStringDate_(varDqConceptualConsistency.getDate());
                                ciDateModel.setDateType(varDqConceptualConsistency.getDateType());
                                ciDateModel.setCiCitationId(citationConformance);

                                saveUpdateCiDate(ciDateModel);
                                jprocessbar.setValue(282);
                                jprocessbar.setStringPainted(true);

                                //dq_quantitativeresult
                                DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                                ArrayList<String> list = new ArrayList<>();        
                                list.add(varDqConceptualConsistency.getRemarks());
                                list.add(varDqConceptualConsistency.getQuantityType());
                                list.add(varDqConceptualConsistency.getQuantityTypeReference());
                                list.add(varDqConceptualConsistency.getCatalogSymbol());
                                list.add(varDqConceptualConsistency.getDescription());
                                list.add(varDqConceptualConsistency.getDescriptionReference());
                                list.add(varDqConceptualConsistency.getMetaDataProperty());
                                list.add(varDqConceptualConsistency.getIdentifier());
                                list.add(varDqConceptualConsistency.getUnitsSystem());
                                dqQuantitativeResultModel.setDqResultId(IdDqResult);
                                dqQuantitativeResultModel.setValueType(varDqConceptualConsistency.getValueType());
                                dqQuantitativeResultModel.setValueUnitList(list);
                                dqQuantitativeResultModel.setErrorStatistic(varDqConceptualConsistency.getErrorStatic());

                                saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                                jprocessbar.setValue(284);
                                jprocessbar.setStringPainted(true);

                                    //dq_quantitativeresult_value
                                    DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                                    DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                                    BigDecimal IdDqQuantitativeResult;
                                    IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                                    dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                                    dqQuantitativeResultValueModel.setValue(varDqConceptualConsistency.getValue());

                                    saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                                    jprocessbar.setValue(286);
                                    jprocessbar.setStringPainted(true);
                                    
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    //end dq for loop    
    //end save dq_conseptual_consistency

    //save dq_domain_consitency
    public void saveUpdateDqDomconsis(DqDomconsisModel value) {

        String ret=null;
        try{
            DqDomconsisController dqDomconsisController = new DqDomconsisController(session, hibernateUtilXml);
            DqDomconsisModel dqDomconsisModel = new DqDomconsisModel();

            boolean flag=false;
            BigDecimal getIdDqDomconsis;
            BigDecimal IdDqDomconsis;
            BigDecimal id=null;

            getIdDqDomconsis = dqDomconsisController.getMaxDqDomconsisId();
            if (getIdDqDomconsis == null) {
                IdDqDomconsis = new BigDecimal(FIRST_ID);
            } else {
                IdDqDomconsis = new BigDecimal(getIdDqDomconsis.longValue() + 1);
            }

            dqDomconsisModel.setId(IdDqDomconsis);
            dqDomconsisModel.setDqDataQualityId(value.getDqDataQualityId());
            dqDomconsisModel.setDqLogicalConsistencyId(value.getDqLogicalConsistencyId());

            if (dqDomconsisController.getDataById(value.getDqLogicalConsistencyId()) == null) {
                flag=true;
                id = IdDqDomconsis;
            } else {
                flag=false;
                id = dqDomconsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
            }

            if (flag) {
                ret = dqDomconsisController.saveDqDomconsis(dqDomconsisModel);
            } else {
                ret = dqDomconsisController.updateDqDomconsis(id,dqDomconsisModel);
            }
            
            displayLog(true, "DqDomconsis");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqLogicalConsistencyId = "+value.getDqLogicalConsistencyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqDomconsis " + ret+"\n");
            }else{
               displayLog(true, "Status table DqDomconsis " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error DqDomconsis " + e.toString());
            displayLog(true, "Status table DqDomconsis " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqDomconsisGroup(BigDecimal dqLogicalConsitencyId,BigDecimal dataQualityId) {

        try{
        DqDomconsisModel ddm = new DqDomconsisModel();
        ddm.setDqLogicalConsistencyId(dqLogicalConsitencyId);
        ddm.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqDomconsis(ddm);
        jprocessbar.setValue(288);
        jprocessbar.setStringPainted(true);
        
        //dq_element
        String columnName = DqElementModel.DQ_DOMCONSISID;
        BigDecimal IdDqDomconsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqDomconsisController DqDomconsisController = new DqDomconsisController(session, hibernateUtilXml);
        IdDqDomconsis = DqDomconsisController.getDataById(dqLogicalConsitencyId).getId();

        dqElementModel.setMeasureDescription(varDqDomainConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqDomainConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqDomainConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqDomconsis, columnName, dqElementModel);
        jprocessbar.setValue(290);
        jprocessbar.setStringPainted(true);

            //dq_element_name_of_measure
            DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
            BigDecimal IdDqElement = dqElementController.getDataById(IdDqDomconsis, columnName).getId();
            DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
            dqElementNameOfMeasureModel.setNameOfMeasure(varDqDomainConsistency.getNameOfMeasure());
            dqElementNameOfMeasureModel.setDqDomConsisId(IdDqDomconsis);

            saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
            jprocessbar.setValue(292);
            jprocessbar.setStringPainted(true);

            //dq_element_datetime
            DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();

            dqElementDateTimeModel.setStringDateTime(varDqDomainConsistency.getDateTime());
            dqElementDateTimeModel.setDqDomConsisId(IdDqDomconsis);
            saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
            jprocessbar.setValue(294);
            jprocessbar.setStringPainted(true);

            //dq_result
            saveUpdateDqResult(IdDqElement, columnName);
            jprocessbar.setValue(296);
            jprocessbar.setStringPainted(true);
        
            //measureidentification
            //mdidentifier
            MdIdentifierModel mim = new MdIdentifierModel();
            mim.setCode(varDqDomainConsistency.getCode());
            mim.setExtendsType(nullValue);
            mim.setDqElementId(IdDqElement);

            saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
            jprocessbar.setValue(298);
            jprocessbar.setStringPainted(true);
        
                //citation
                CiCitationModel ccm = new CiCitationModel();
                MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                ccm.setTitle(varDqDomainConsistency.getTitleMeasure());
                ccm.setMdIdentifierId(mdIdentifierIdSup);

                saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                jprocessbar.setValue(300);
                jprocessbar.setStringPainted(true);
        
                    //cidate
                    CiDateModel cdm = new CiDateModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                    cdm.setStringDate_(varDqDomainConsistency.getDateMeasure());
                    cdm.setDateType(varDqDomainConsistency.getDateTypeMeasure());
                    cdm.setCiCitationId(citationIdSup);

                    saveUpdateCiDate(cdm);
                    jprocessbar.setValue(302);
                    jprocessbar.setStringPainted(true);

            //dq_conformanceresult
            DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
            DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
            BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();
            dqConformanceResultModel.setDqResultId(IdDqResult);
            dqConformanceResultModel.setExplanation(varDqDomainConsistency.getExplanation());
            dqConformanceResultModel.setStringPass(varDqDomainConsistency.getPass());

            saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
            jprocessbar.setValue(304);
            jprocessbar.setStringPainted(true);
            
                //dq_conformanceresult_citation
                DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                CiCitationModel ciCitationModel = new CiCitationModel();

                BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                ciCitationModel.setTitle(varDqDomainConsistency.getTitle());
                ciCitationModel.setEdition(varDqDomainConsistency.getEditionConformance());
                ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                jprocessbar.setValue(306);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult_cidate
                    CiDateModel ciDateModel = new CiDateModel();
                    CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

                    BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                    ciDateModel.setStringDate_(varDqDomainConsistency.getDate());
                    ciDateModel.setDateType(varDqDomainConsistency.getDateType());
                    ciDateModel.setCiCitationId(citationConformance);

                    saveUpdateCiDate(ciDateModel);
                    jprocessbar.setValue(308);
                    jprocessbar.setStringPainted(true);
        
            //evaluationprocedure
            //citation
            CiCitationModel cmProcedure = new CiCitationModel();

            cmProcedure.setTitle(varDqDomainConsistency.getTitleEvaluation());
            cmProcedure.setEdition(varDqDomainConsistency.getEdition());
            cmProcedure.setDqElementId(IdDqElement);

            saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
            jprocessbar.setValue(310);
            jprocessbar.setStringPainted(true);
       
                //cidate
                CiDateModel cdmProcedure = new CiDateModel();
                BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                cdmProcedure.setStringDate_(varDqDomainConsistency.getDateEvaluation());
                cdmProcedure.setDateType(varDqDomainConsistency.getDateTypeEvaluation());
                cdmProcedure.setCiCitationId(citationProcedure);

                saveUpdateCiDate(cdmProcedure);
                jprocessbar.setValue(312);
                jprocessbar.setStringPainted(true);
        
                    CiSeriesModel csm = new CiSeriesModel();
                    csm.setIssueIdentification(varDqDomainConsistency.getIssueIdentification());
                    csm.setName(varDqDomainConsistency.getName());
                    csm.setPage(varDqDomainConsistency.getPage());
                    csm.setCiCitationId(citationProcedure);

                    saveUpdateCiSeries(csm);
                    jprocessbar.setValue(314);
                    jprocessbar.setStringPainted(true);
        
                //dq_quantitativeresult
                DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();        
                dqQuantitativeResultModel.setDqResultId(IdDqResult);
                ArrayList<String> list = new ArrayList<>();        
                list.add(varDqDomainConsistency.getRemarks());
                list.add(varDqDomainConsistency.getQuantityType());
                list.add(varDqDomainConsistency.getQuantityTypeReference());
                list.add(varDqDomainConsistency.getCatalogSymbol());
                list.add(varDqDomainConsistency.getDescription());
                list.add(varDqDomainConsistency.getDescriptionReference());
                list.add(varDqDomainConsistency.getMetaDataProperty());
                list.add(varDqDomainConsistency.getIdentifier());
                list.add(varDqDomainConsistency.getUnitsSystem());
                dqQuantitativeResultModel.setValueType(varDqDomainConsistency.getValueType());
                dqQuantitativeResultModel.setValueUnitList(list);
                dqQuantitativeResultModel.setErrorStatistic(varDqDomainConsistency.getErrorStatic());

                saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                jprocessbar.setValue(316);
                jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult_value
                    DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                    DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                    BigDecimal IdDqQuantitativeResult;
                    IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                    dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                    dqQuantitativeResultValueModel.setValue(varDqDomainConsistency.getValue());

                    saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                    jprocessbar.setValue(318);
                    jprocessbar.setStringPainted(true);
                    
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dq_domain_consitency

    //save dq_format_consitency
    public void saveUpdateDqFormconsis(DqFormConsisModel value) {
        
        String ret=null;
        try{
            DqFormConsisController dqFormConsisController = new DqFormConsisController(session, hibernateUtilXml);
            DqFormConsisModel dqFormConsisModel = new DqFormConsisModel();

            boolean flag=false;
            BigDecimal getIdDqFormConsis;
            BigDecimal IdDqFormConsis;
            BigDecimal id=null;

            getIdDqFormConsis = dqFormConsisController.getMaxDqFormConsisId();
            if (getIdDqFormConsis == null) {
                IdDqFormConsis = new BigDecimal(FIRST_ID);
            } else {
                IdDqFormConsis = new BigDecimal(getIdDqFormConsis.longValue() + 1);
            }

            dqFormConsisModel.setId(IdDqFormConsis);
            dqFormConsisModel.setDqDataQualityId(value.getDqDataQualityId());
            dqFormConsisModel.setDqLogicalConsistencyId(value.getDqLogicalConsistencyId());

            if (dqFormConsisController.getDataById(value.getDqLogicalConsistencyId()) == null) {
                flag=true;
                id = IdDqFormConsis;
            } else {
                flag=false;
                id = dqFormConsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
            }

            if (flag) {
                ret = dqFormConsisController.saveDqFormConsis(dqFormConsisModel);
            } else {
                ret = dqFormConsisController.updateDqFormConsis(id,dqFormConsisModel);
            }
            
            displayLog(true, "DqFormconsis");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqLogicalConsistencyId = "+value.getDqLogicalConsistencyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqFormconsis " + ret+"\n");
            }else{
               displayLog(true, "Status table DqFormconsis " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error DqFormconsis " + e.toString());
            displayLog(true, "Status table DqFormconsis " + ret+"\n");
        }

        
    }

    //dq for loop    
   
    public void saveUpdateDqFormconsisGroup(BigDecimal dqLogicalConsitencyId,BigDecimal dataQualityId) {
        
        try{
        DqFormConsisModel dfcm = new DqFormConsisModel();
        dfcm.setDqDataQualityId(dataQualityId);
        dfcm.setDqLogicalConsistencyId(dqLogicalConsitencyId);
        
        saveUpdateDqFormconsis(dfcm);
        jprocessbar.setValue(320);
        jprocessbar.setStringPainted(true);
        
        //dq_element
        String columnName = DqElementModel.DQ_FORMCONSISID;
        BigDecimal IdDqFormconsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqFormConsisController dqFormconsisController = new DqFormConsisController(session, hibernateUtilXml);
        IdDqFormconsis = dqFormconsisController.getDataById(dqLogicalConsitencyId).getId();

        dqElementModel.setMeasureDescription(varDqFormatConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqFormatConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqFormatConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqFormconsis, columnName, dqElementModel);
        jprocessbar.setValue(322);
        jprocessbar.setStringPainted(true);

            //dq_element_name_of_measure
            DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
            BigDecimal IdDqElement = dqElementController.getDataById(IdDqFormconsis, columnName).getId();
            DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
            dqElementNameOfMeasureModel.setNameOfMeasure(varDqFormatConsistency.getNameOfMeasure());
            dqElementNameOfMeasureModel.setDqFormConsisId(IdDqFormconsis);

            saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
            jprocessbar.setValue(324);
            jprocessbar.setStringPainted(true);

            //dq_element_datetime
            DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
            dqElementDateTimeModel.setStringDateTime(varDqFormatConsistency.getDateTime());
            dqElementDateTimeModel.setDqFormConsisId(IdDqFormconsis);
            
            saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
            jprocessbar.setValue(326);
            jprocessbar.setStringPainted(true);

            //dq_result
            saveUpdateDqResult(IdDqElement, columnName);
            jprocessbar.setValue(328);
            jprocessbar.setStringPainted(true);
        
            //mdidentifier
            MdIdentifierModel mim = new MdIdentifierModel();
            mim.setCode(varDqFormatConsistency.getCode());
            mim.setExtendsType(nullValue);
            mim.setDqElementId(IdDqElement);

            saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
            jprocessbar.setValue(330);
            jprocessbar.setStringPainted(true);
        
                //citation
                CiCitationModel ccm = new CiCitationModel();
                MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                ccm.setTitle(varDqFormatConsistency.getTitleMeasure());
                ccm.setMdIdentifierId(mdIdentifierIdSup);

                saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                jprocessbar.setValue(332);
                jprocessbar.setStringPainted(true);

                    //cidate
                    CiDateModel cdm = new CiDateModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                    cdm.setStringDate_(varDqFormatConsistency.getDateMeasure());
                    cdm.setDateType(varDqFormatConsistency.getDateTypeMeasure());
                    cdm.setCiCitationId(citationIdSup);

                    saveUpdateCiDate(cdm);
                    jprocessbar.setValue(334);
                    jprocessbar.setStringPainted(true);

                //dq_conformanceresult
                DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();
                dqConformanceResultModel.setDqResultId(IdDqResult);
                dqConformanceResultModel.setExplanation(varDqFormatConsistency.getExplanation());
                dqConformanceResultModel.setStringPass(varDqFormatConsistency.getPass());

                saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                jprocessbar.setValue(336);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult_citation
                    DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                    CiCitationModel ciCitationModel = new CiCitationModel();

                    BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                    ciCitationModel.setTitle(varDqFormatConsistency.getTitle());
                    ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                    saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                    jprocessbar.setValue(338);
                    jprocessbar.setStringPainted(true);
                    
                        //dq_conformanceresult_cidate
                        CiDateModel ciDateModel = new CiDateModel();

                        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                        ciDateModel.setStringDate_(varDqFormatConsistency.getDate());
                        ciDateModel.setDateType(varDqFormatConsistency.getDateType());
                        ciDateModel.setCiCitationId(citationConformance);

                        saveUpdateCiDate(ciDateModel);
                        jprocessbar.setValue(340);
                        jprocessbar.setStringPainted(true);
        
            //evaluation procedure
            //citation
            CiCitationModel cmProcedure = new CiCitationModel();

            cmProcedure.setTitle(varDqFormatConsistency.getTitleEvaluation());
            cmProcedure.setDqElementId(IdDqElement);

            saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
            jprocessbar.setValue(342);
            jprocessbar.setStringPainted(true);
            
                //cidate
                CiDateModel cdmProcedure = new CiDateModel();
                BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                cdmProcedure.setStringDate_(varDqFormatConsistency.getDateEvaluation());
                cdmProcedure.setDateType(varDqFormatConsistency.getDateTypeEvaluation());
                cdmProcedure.setCiCitationId(citationProcedure);

                saveUpdateCiDate(cdmProcedure);
                jprocessbar.setValue(344);
                jprocessbar.setStringPainted(true);

                //dq_quantitativeresult
                ArrayList<String> list = new ArrayList<>();        
                list.add(varDqFormatConsistency.getRemarks());
                list.add(varDqFormatConsistency.getQuantityType());
                list.add(varDqFormatConsistency.getQuantityTypeReference());
                list.add(varDqFormatConsistency.getCatalogSymbol());
                list.add(varDqFormatConsistency.getDescription());
                list.add(varDqFormatConsistency.getDescriptionReference());
                list.add(varDqFormatConsistency.getMetaDataProperty());
                list.add(varDqFormatConsistency.getIdentifier());
                list.add(varDqFormatConsistency.getUnitsSystem());
                DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                dqQuantitativeResultModel.setDqResultId(IdDqResult);
                dqQuantitativeResultModel.setValueType(varDqFormatConsistency.getValueType());
                dqQuantitativeResultModel.setValueUnitList(list);
                dqQuantitativeResultModel.setErrorStatistic(varDqFormatConsistency.getErrorStatic());

                saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                jprocessbar.setValue(346);
                jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult_value
                    DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                    DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                    BigDecimal IdDqQuantitativeResult;
                    IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                    dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                    dqQuantitativeResultValueModel.setValue(varDqFormatConsistency.getValue());

                    saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                    jprocessbar.setValue(348);
                    jprocessbar.setStringPainted(true);
                    
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dq_format_consitency

    //save dq_Topological_consitency
    public void saveUpdateDqTopconsis(DqTopConsisModel value) {
        
        String ret=null;
        try{
            DqTopConsisController DqTopconsisController = new DqTopConsisController(session, hibernateUtilXml);
            DqTopConsisModel DqTopconsisModel = new DqTopConsisModel();
            
            boolean flag=false;
            BigDecimal getIdDqTopconsis;
            BigDecimal IdDqTopconsis;
            BigDecimal id=null;

            getIdDqTopconsis = DqTopconsisController.getMaxDqTopConsisId();
            if (getIdDqTopconsis == null) {
                IdDqTopconsis = new BigDecimal(FIRST_ID);
            } else {
                IdDqTopconsis = new BigDecimal(getIdDqTopconsis.longValue() + 1);
            }

            DqTopconsisModel.setId(IdDqTopconsis);
            DqTopconsisModel.setDqDataQualityId(value.getDqDataQualityId());
            DqTopconsisModel.setDqLogicalConsistencyId(value.getDqLogicalConsistencyId());

            if (DqTopconsisController.getDataById(value.getDqLogicalConsistencyId()) == null) {
                flag=true;
                id = IdDqTopconsis;
            } else {
                flag=false;
                id = DqTopconsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
            }

            if (flag) {
                ret = DqTopconsisController.saveDqTopConsis(DqTopconsisModel);
            } else {
                ret = DqTopconsisController.updateDqTopConsis(id,DqTopconsisModel);
            }
            
            displayLog(true, "DqTopconsis");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqLogicalConsistencyId = "+value.getDqLogicalConsistencyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqTopconsis " + ret+"\n");
            }else{
               displayLog(true, "Status table DqTopconsis " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqTopconsis " + e.toString());
            displayLog(true, "Status table DqTopconsis " + ret+"\n");
            
        }

    }

    //dq for loop
    public void saveUpdateDqTopconsisGroup(BigDecimal dqLogicalConsitencyId,BigDecimal dataQualityId) {

        try{
        DqTopConsisModel dtcm = new DqTopConsisModel();
        dtcm.setDqDataQualityId(dataQualityId);
        dtcm.setDqLogicalConsistencyId(dqLogicalConsitencyId);
        
        saveUpdateDqTopconsis(dtcm);
        jprocessbar.setValue(350);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_TOPCONSISID;
            BigDecimal IdDqTopconsis;
            DqElementModel dqElementModel = new DqElementModel();
            DqTopConsisController dqTopconsisController = new DqTopConsisController(session, hibernateUtilXml);
            IdDqTopconsis = dqTopconsisController.getDataById(dqLogicalConsitencyId).getId();

            dqElementModel.setMeasureDescription(varDqTopologicalConsistency.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqTopologicalConsistency.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqTopologicalConsistency.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqTopconsis, columnName, dqElementModel);
            jprocessbar.setValue(352);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqTopconsis, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqTopologicalConsistency.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqTopConsisId(IdDqTopconsis);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(354);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();

                dqElementDateTimeModel.setStringDateTime(varDqTopologicalConsistency.getDateTime());
                dqElementDateTimeModel.setDqTopConsisId(IdDqTopconsis);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(356);
                jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(358);
                jprocessbar.setStringPainted(true);

                //measureidentification
                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varDqTopologicalConsistency.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                jprocessbar.setValue(360);
                jprocessbar.setStringPainted(true);
        
                    //citation
                    CiCitationModel ccm = new CiCitationModel();
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                    ccm.setTitle(varDqTopologicalConsistency.getTitleMeasure());
                    ccm.setEdition(varDqTopologicalConsistency.getEdition());
                    ccm.setStringEditionDate(varDqTopologicalConsistency.getEditionDate());
                    ccm.setMdIdentifierId(mdIdentifierIdSup);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                    jprocessbar.setValue(362);
                    jprocessbar.setStringPainted(true);
        
                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                        cdm.setStringDate_(varDqTopologicalConsistency.getDateMeasure());
                        cdm.setDateType(varDqTopologicalConsistency.getDateTypeMeasure());
                        cdm.setCiCitationId(citationIdSup);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(364);
                        jprocessbar.setStringPainted(true);
        
                        //mdidentifier
                        MdIdentifierModel mimsub = new MdIdentifierModel();
                        mimsub.setCode(varDqTopologicalConsistency.getCodeIdentifier());
                        mimsub.setExtendsType(nullValue);
                        mimsub.setCiCitationId(citationIdSup);

                        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationIdSup, mimsub);
                        jprocessbar.setValue(366);
                        jprocessbar.setStringPainted(true);
       
                            //citation
                            CiCitationModel ccmSub = new CiCitationModel();
                            BigDecimal mdIdentifierSub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationIdSup).getId();

                            ccmSub.setTitle(varDqTopologicalConsistency.getTitleIdentifier());
                            ccmSub.setMdIdentifierId(mdIdentifierSub);

                            saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub,ccmSub);
                            jprocessbar.setValue(368);
                            jprocessbar.setStringPainted(true);
        
                                //cidate
                                CiDateModel cdmSub = new CiDateModel();
                                BigDecimal  citationSub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub).getId();

                                cdmSub.setStringDate_(varDqTopologicalConsistency.getDateIdentifier());
                                cdmSub.setDateType(varDqTopologicalConsistency.getDateTypeIdentifier());
                                cdmSub.setCiCitationId(citationSub);

                                saveUpdateCiDate(cdmSub);
                                jprocessbar.setValue(370);
                                jprocessbar.setStringPainted(true);
        
                                //mdidentifier
                                MdIdentifierModel mimsubsub = new MdIdentifierModel();
                                mimsubsub.setCode(varDqTopologicalConsistency.getCodeMeasureIdentifier());
                                mimsubsub.setExtendsType(nullValue);
                                mimsubsub.setCiCitationId(citationSub);

                                saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationSub, mimsubsub);
                                jprocessbar.setValue(372);
                                jprocessbar.setStringPainted(true);
       
                                    //citation
                                    CiCitationModel ccmsubsub = new CiCitationModel();
                                    BigDecimal mdIdentifiersubsub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationSub).getId();

                                    ccmsubsub.setTitle(varDqTopologicalConsistency.getTitleMeasureIdentifier());
                                    ccmsubsub.setMdIdentifierId(mdIdentifiersubsub);

                                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifiersubsub,ccmsubsub);
                                    jprocessbar.setValue(374);
                                    jprocessbar.setStringPainted(true);
                                    
                                        //cidate
                                        CiDateModel cdmsubsub = new CiDateModel();
                                        BigDecimal  citationsubsub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifiersubsub).getId();

                                        cdmsubsub.setStringDate_(varDqTopologicalConsistency.getDateMeasureIdentifier());
                                        cdmsubsub.setDateType(varDqTopologicalConsistency.getDateTypeMeasureIdentifier());
                                        cdmsubsub.setCiCitationId(citationsubsub);
        
                                        saveUpdateCiDate(cdmsubsub);
                                        jprocessbar.setValue(376);
                                        jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqTopologicalConsistency.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqTopologicalConsistency.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(378);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqTopologicalConsistency.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(380);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();

                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();
                            ciDateModel.setStringDate_(varDqTopologicalConsistency.getDate());
                            ciDateModel.setDateType(varDqTopologicalConsistency.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(382);
                            jprocessbar.setStringPainted(true);
        
                //evaluation procedure
                //citation
                CiCitationModel cmProcedure = new CiCitationModel();

                cmProcedure.setTitle(varDqTopologicalConsistency.getTitleEvaluation());
                cmProcedure.setDqElementId(IdDqElement);

                saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
                jprocessbar.setValue(384);
                jprocessbar.setStringPainted(true);
                
                    //cidate
                    CiDateModel cdmProcedure = new CiDateModel();
                    BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                    cdmProcedure.setStringDate_(varDqTopologicalConsistency.getDateEvaluation());
                    cdmProcedure.setDateType(varDqTopologicalConsistency.getDateTypeEvaluation());
                    cdmProcedure.setCiCitationId(citationProcedure);

                    saveUpdateCiDate(cdmProcedure);        
                    jprocessbar.setValue(386);
                    jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    ArrayList<String> list = new ArrayList<>(); 
                    list.add(varDqTopologicalConsistency.getRemarks());
                    list.add(varDqTopologicalConsistency.getQuantityType());
                    list.add(varDqTopologicalConsistency.getQuantityTypeReference());
                    list.add(varDqTopologicalConsistency.getCatalogSymbol());
                    list.add(varDqTopologicalConsistency.getDescription());
                    list.add(varDqTopologicalConsistency.getDescriptionReference());
                    list.add(varDqTopologicalConsistency.getMetaDataProperty());
                    list.add(varDqTopologicalConsistency.getIdentifier());
                    list.add(varDqTopologicalConsistency.getUnitsSystem());
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setValueType(varDqTopologicalConsistency.getValueType());
                    dqQuantitativeResultModel.setValueUnit(varDqTopologicalConsistency.getUnitDefinition());
                    dqQuantitativeResultModel.setErrorStatistic(varDqTopologicalConsistency.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(388);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqTopologicalConsistency.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(390);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                       
    }
    //end dq for loop
    //save dq_Topological_consitency

    //save dq_Absolute_External_Positional_Accuracy
    public void saveUpdateDqPositionalAccuracy(DqPositionalAccuracyModel value) {
        
        String ret=null;
        try{
            DqPositionalAccuracyController DqPositionalAccuracyController = new DqPositionalAccuracyController(session, hibernateUtilXml);
            DqPositionalAccuracyModel DqPositionalAccuracyModel = new DqPositionalAccuracyModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqPositionalAccuracy;
            BigDecimal IdDqPositionalAccuracy;

            getIdDqPositionalAccuracy = DqPositionalAccuracyController.getMaxDqPositionalAccuracyId();
            if (getIdDqPositionalAccuracy == null) {
                IdDqPositionalAccuracy = new BigDecimal(FIRST_ID);
            } else {
                IdDqPositionalAccuracy = new BigDecimal(getIdDqPositionalAccuracy.longValue() + 1);
            }

            DqPositionalAccuracyModel.setId(IdDqPositionalAccuracy);
            DqPositionalAccuracyModel.setDqDataQualityId(value.getDqDataQualityId());

            if (DqPositionalAccuracyController.getDataById(value.getDqDataQualityId()) == null) {
                flag=true;
                id = IdDqPositionalAccuracy;
            } else {
                flag=false;
                id = DqPositionalAccuracyController.getDataById(value.getDqDataQualityId()).getId();

            }

            if (flag) {
                ret = DqPositionalAccuracyController.saveDqPositionalAccuracy(DqPositionalAccuracyModel);
            } else {
                ret = DqPositionalAccuracyController.updateDqPositionalAccuracy(id,DqPositionalAccuracyModel);
            }
            
            displayLog(true, "DqPositionalAccuracy");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqPositionalAccuracy " + ret+"\n");
            }else{
               displayLog(true, "Status table DqPositionalAccuracy " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqPositionalAccuracy " + e.toString());
            displayLog(true, "Status table DqPositionalAccuracy " + ret+"\n");
        }

    }

    public void saveUpdateDqAbsextPosAcc(DqAbsextposaccModel value) {
        
        String ret=null;
        try{
            DqAbsextposaccController DqAbsextposaccController = new DqAbsextposaccController(session, hibernateUtilXml);
            DqAbsextposaccModel DqAbsextposaccModel = new DqAbsextposaccModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqAbsextposacc;
            BigDecimal IdDqAbsextposacc;

            getIdDqAbsextposacc = DqAbsextposaccController.getMaxDqAbsextposaccId();
            if (getIdDqAbsextposacc == null) {
                IdDqAbsextposacc = new BigDecimal(FIRST_ID);
            } else {
                IdDqAbsextposacc = new BigDecimal(getIdDqAbsextposacc.longValue() + 1);
            }

            DqAbsextposaccModel.setId(IdDqAbsextposacc);
            DqAbsextposaccModel.setDqDataQualityId(value.getDqDataQualityId());
            DqAbsextposaccModel.setDqPositionalAccuracyId(value.getDqPositionalAccuracyId());

            if (DqAbsextposaccController.getDataById(value.getDqPositionalAccuracyId()) == null) {
                flag=true;
                id = IdDqAbsextposacc;
            } else {
                flag=false;
                id = DqAbsextposaccController.getDataById(value.getDqPositionalAccuracyId()).getId();
            }

            if (flag) {
                ret = DqAbsextposaccController.saveDqAbsextposacc(DqAbsextposaccModel);
            } else {
                ret = DqAbsextposaccController.updateDqAbsextposacc(id,DqAbsextposaccModel);
            }
            
            displayLog(true, "DqAbsextposacc");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqPositionalAccuracyId = "+value.getDqPositionalAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqAbsextposacc " + ret+"\n");
            }else{
               displayLog(true, "Status table DqAbsextposacc " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqAbsextposacc " + e.toString());
        }

    }

    //dq for loop
    public void saveUpdateDqAbsextPosAccGroup(BigDecimal dqPositionalAccuracyId,BigDecimal dataQualityId) {

        try{
        //DqAbsextposacc
        DqAbsextposaccModel dam = new DqAbsextposaccModel();
        
        dam.setDqDataQualityId(dataQualityId);
        dam.setDqPositionalAccuracyId(dqPositionalAccuracyId);
        
        saveUpdateDqAbsextPosAcc(dam);
        jprocessbar.setValue(394);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_ABSEXTPOSACCID;
            BigDecimal IdDqAbsextPosAcc;
            DqElementModel dqElementModel = new DqElementModel();
            DqAbsextposaccController dqAbsextPosAccController = new DqAbsextposaccController(session, hibernateUtilXml);
            IdDqAbsextPosAcc = dqAbsextPosAccController.getDataById(dqPositionalAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqAbsoluteExternalPositionalAccuracy.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqAbsoluteExternalPositionalAccuracy.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqAbsoluteExternalPositionalAccuracy.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqAbsextPosAcc, columnName, dqElementModel);
            jprocessbar.setValue(396);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqAbsextPosAcc, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqAbsoluteExternalPositionalAccuracy.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqAbsExtPosAccId(IdDqAbsextPosAcc);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(398);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();

                dqElementDateTimeModel.setStringDateTime(varDqAbsoluteExternalPositionalAccuracy.getDateTime());
                dqElementDateTimeModel.setDqAbsExtPosAccId(IdDqAbsextPosAcc);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(400);
                jprocessbar.setStringPainted(true);

                //measuredescription
                MdIdentifierModel mim = new MdIdentifierModel();

                mim.setCode(varDqAbsoluteExternalPositionalAccuracy.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID,IdDqElement, mim);
                jprocessbar.setValue(402);
                jprocessbar.setStringPainted(true);

                    //cicitation
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,IdDqElement).getId();

                    CiCitationModel citationModel = new CiCitationModel();

                    citationModel.setTitle(varDqAbsoluteExternalPositionalAccuracy.getTitleMeasure());
                    citationModel.setMdIdentifierId(mdIdentifierId);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierId,citationModel);
                    jprocessbar.setValue(404);
                    jprocessbar.setStringPainted(true);
   
                        //cidate
                        CiDateModel cd = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationMeasure = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierId).getId();

                        cd.setStringDate_(varDqAbsoluteExternalPositionalAccuracy.getDateMeasure());
                        cd.setDateType(varDqAbsoluteExternalPositionalAccuracy.getDateTypeMeasure());
                        cd.setCiCitationId(citationMeasure);

                        saveUpdateCiDate(cd);
                        jprocessbar.setValue(406);
                        jprocessbar.setStringPainted(true);
        
                        //measeuredescription
        
            //dq_result
            saveUpdateDqResult(IdDqElement, columnName);
            jprocessbar.setValue(408);
            jprocessbar.setStringPainted(true);

                //dq_conformanceresult
                DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                dqConformanceResultModel.setDqResultId(IdDqResult);
                dqConformanceResultModel.setExplanation(varDqAbsoluteExternalPositionalAccuracy.getExplanation());
                dqConformanceResultModel.setStringPass(varDqAbsoluteExternalPositionalAccuracy.getPass());

                saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                jprocessbar.setValue(410);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult_citation
                    DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                    CiCitationModel ciCitationModel = new CiCitationModel();

                    BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                    ciCitationModel.setTitle(varDqAbsoluteExternalPositionalAccuracy.getTitle());
                    ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                    saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                    jprocessbar.setValue(412);
                    jprocessbar.setStringPainted(true);
                    
                        //dq_conformanceresult_cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal CiCitationId = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                        cdm.setStringDate_(varDqAbsoluteExternalPositionalAccuracy.getDate());
                        cdm.setDateType(varDqAbsoluteExternalPositionalAccuracy.getDateType());
                        cdm.setCiCitationId(CiCitationId);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(414);
                        jprocessbar.setStringPainted(true);
        
            //evaluation procedure
            CiCitationModel ccm = new CiCitationModel();
        
            ccm.setTitle(varDqAbsoluteExternalPositionalAccuracy.getTitleEvaluation());
            ccm.setDqElementId(IdDqElement);

            saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement, ccm);
            jprocessbar.setValue(416);
            jprocessbar.setStringPainted(true);

                //cidate
                CiDateModel ciDateModel = new CiDateModel();
                BigDecimal CiCitationEvaluation = ciCitationController.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                ciDateModel.setStringDate_(varDqAbsoluteExternalPositionalAccuracy.getDateEvaluation());
                ciDateModel.setDateType(varDqAbsoluteExternalPositionalAccuracy.getDateTypeEvaluation());
                ciDateModel.setCiCitationId(CiCitationEvaluation);

                saveUpdateCiDate(ciDateModel);
                jprocessbar.setValue(418);
                jprocessbar.setStringPainted(true);
            //evaluation procudere
        
                //dq_quantitativeresult     
                ArrayList<String> list = new ArrayList<>();
                list.add(varDqAbsoluteExternalPositionalAccuracy.getRemarks());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getQuantityType());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getQuantityTypeReference());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getCatalogSymbol());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getDescription());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getDescriptionReference());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getMetaDataProperty());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getIdentifier());
                list.add(varDqAbsoluteExternalPositionalAccuracy.getUnitsSystem());

                DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                dqQuantitativeResultModel.setDqResultId(IdDqResult);
                dqQuantitativeResultModel.setValueType(varDqAbsoluteExternalPositionalAccuracy.getValueType());
                dqQuantitativeResultModel.setValueUnitList(list);
                dqQuantitativeResultModel.setErrorStatistic(varDqAbsoluteExternalPositionalAccuracy.getErrorStatic());

                saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                jprocessbar.setValue(420);
                jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult_value
                    DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                    DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                    BigDecimal IdDqQuantitativeResult;
                    IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                    dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                    dqQuantitativeResultValueModel.setValue(varDqAbsoluteExternalPositionalAccuracy.getValue());

                    saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                    jprocessbar.setValue(422);
                    jprocessbar.setStringPainted(true);
                    
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //save dq_Absolute_External_Positional_Accuracy

    //save dq_Gridded_Data_Positional_Accuracy
    public void saveUpdateDqGridDataPosAcc(DqGridDataPosAccModel value) {
        
        String ret=null;
        try{
            DqGridDataPosAccController DqGridDataPosAccController = new DqGridDataPosAccController(session, hibernateUtilXml);
            DqGridDataPosAccModel DqGridDataPosAccModel = new DqGridDataPosAccModel();

            String checkData;
            boolean flag=false;
            BigDecimal getIdDqGridDataPosAcc;
            BigDecimal IdDqGridDataPosAcc;
            BigDecimal id=null;

            getIdDqGridDataPosAcc = DqGridDataPosAccController.getMaxDqGridDataPosAccId();
            if (getIdDqGridDataPosAcc == null) {
                IdDqGridDataPosAcc = new BigDecimal(FIRST_ID);
            } else {
                IdDqGridDataPosAcc = new BigDecimal(getIdDqGridDataPosAcc.longValue() + 1);
            }

            DqGridDataPosAccModel.setId(IdDqGridDataPosAcc);
            DqGridDataPosAccModel.setDqDataQualityId(value.getDqDataQualityId());
            DqGridDataPosAccModel.setDqPositionalAccuracyId(value.getDqPositionalAccuracyId());

            if (DqGridDataPosAccController.getDataById(value.getDqPositionalAccuracyId()) == null) {
                flag=true;
                id = IdDqGridDataPosAcc;
            } else {
                flag=false;
                id = DqGridDataPosAccController.getDataById(value.getDqPositionalAccuracyId()).getId();
            }

            if (flag) {
                ret = DqGridDataPosAccController.saveDqGridDataPosAcc(DqGridDataPosAccModel);
            } else {
                ret = DqGridDataPosAccController.updateDqGridDataPosAcc(id,DqGridDataPosAccModel);
            }

            displayLog(true, "DqGridDataPosAc");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqPositionalAccuracyId = "+value.getDqPositionalAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqGridDataPosAc " + ret+"\n");
            }else{
               displayLog(true, "Status table DqGridDataPosAc " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqGridDataPosAcc " + e.toString());
            displayLog(true, "Status table DqGridDataPosAc " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqGridDataPosAccGroup(BigDecimal dqPositionalAccuracyId,BigDecimal dataQualityId) {
        
        try{
        DqGridDataPosAccModel dgdpam = new DqGridDataPosAccModel();
        dgdpam.setDqDataQualityId(dataQualityId);
        dgdpam.setDqPositionalAccuracyId(dqPositionalAccuracyId);

        saveUpdateDqGridDataPosAcc(dgdpam);
        jprocessbar.setValue(424);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName =  DqElementModel.DQ_GRIDDATAPOSACCID;
            BigDecimal IdDqGridDataPosAcc;
            DqElementModel dqElementModel = new DqElementModel();
            DqGridDataPosAccController dqGridDataPosAccController = new DqGridDataPosAccController(session, hibernateUtilXml);
            IdDqGridDataPosAcc = dqGridDataPosAccController.getDataById(dqPositionalAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqGriddedDataPositionalAccuracy.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqGriddedDataPositionalAccuracy.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqGriddedDataPositionalAccuracy.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqGridDataPosAcc, columnName, dqElementModel);
            jprocessbar.setValue(426);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqGridDataPosAcc, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqGriddedDataPositionalAccuracy.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqGridDataPosAccId(IdDqGridDataPosAcc);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(428);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqGriddedDataPositionalAccuracy.getDateTime());
                dqElementDateTimeModel.setDqGridDataPosAccId(IdDqGridDataPosAcc);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(430);
                jprocessbar.setStringPainted(true);
        
                //measureidentification
                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varDqGriddedDataPositionalAccuracy.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                jprocessbar.setValue(432);
                jprocessbar.setStringPainted(true);
        
                    //citation
                    CiCitationModel ccm = new CiCitationModel();
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                    ccm.setTitle(varDqGriddedDataPositionalAccuracy.getTitleMeasure());
                    ccm.setMdIdentifierId(mdIdentifierIdSup);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                    jprocessbar.setValue(434);
                    jprocessbar.setStringPainted(true);
        
                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                        cdm.setStringDate_(varDqGriddedDataPositionalAccuracy.getDateMeasure());
                        cdm.setDateType(varDqGriddedDataPositionalAccuracy.getDateTypeMeasure());
                        cdm.setCiCitationId(citationIdSup);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(436);
                        jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);  
                jprocessbar.setValue(438);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqGriddedDataPositionalAccuracy.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqGriddedDataPositionalAccuracy.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(440);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqGriddedDataPositionalAccuracy.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(442);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            ciDateModel.setStringDate_(varDqGriddedDataPositionalAccuracy.getDate());
                            ciDateModel.setDateType(varDqGriddedDataPositionalAccuracy.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(444);
                            jprocessbar.setStringPainted(true);
        
                //evaluation procedure
                //citation
                CiCitationModel cmProcedure = new CiCitationModel();
           
                cmProcedure.setTitle(varDqGriddedDataPositionalAccuracy.getTitleEvaluation());
                cmProcedure.setDqElementId(IdDqElement);

                saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
                jprocessbar.setValue(446);
                jprocessbar.setStringPainted(true);
                
                    //cidate
                    CiDateModel cdmProcedure = new CiDateModel();
                    BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                    cdmProcedure.setStringDate_(varDqGriddedDataPositionalAccuracy.getDateEvaluation());
                    cdmProcedure.setDateType(varDqGriddedDataPositionalAccuracy.getDateTypeEvaluation());
                    cdmProcedure.setCiCitationId(citationProcedure);

                    saveUpdateCiDate(cdmProcedure);
                    jprocessbar.setValue(448);
                    jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqGriddedDataPositionalAccuracy.getRemarks());
                    list.add(varDqGriddedDataPositionalAccuracy.getQuantityType());
                    list.add(varDqGriddedDataPositionalAccuracy.getQuantityTypeReference());
                    list.add(varDqGriddedDataPositionalAccuracy.getCatalogSymbol());
                    list.add(varDqGriddedDataPositionalAccuracy.getDescription());
                    list.add(varDqGriddedDataPositionalAccuracy.getDescriptionReference());
                    list.add(varDqGriddedDataPositionalAccuracy.getMetaDataProperty());
                    list.add(varDqGriddedDataPositionalAccuracy.getIdentifier());
                    list.add(varDqGriddedDataPositionalAccuracy.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqGriddedDataPositionalAccuracy.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqGriddedDataPositionalAccuracy.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(450);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqGriddedDataPositionalAccuracy.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(452);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //save dq_Gridded_Data_Positional_Accuracy

    //save dq_relative_internal_Positional_Accuracy
    public void saveUpdateDqRellntPosAcc(DqRellntPosAccModel value) {
         
        String ret=null;
        try{
            DqRellntPosAccController DqRellntPosAccController = new DqRellntPosAccController(session, hibernateUtilXml);
            DqRellntPosAccModel DqRellntPosAccModel = new DqRellntPosAccModel();

            String checkData;
            boolean flag=false;
            BigDecimal getIdDqRellntPosAcc;
            BigDecimal IdDqRellntPosAcc;
            BigDecimal id=null;

            getIdDqRellntPosAcc = DqRellntPosAccController.getMaxDqRellntPosAccId();
            if (getIdDqRellntPosAcc == null) {
                IdDqRellntPosAcc = new BigDecimal(FIRST_ID);
            } else {
                IdDqRellntPosAcc = new BigDecimal(getIdDqRellntPosAcc.longValue() + 1);
            }

            DqRellntPosAccModel.setId(IdDqRellntPosAcc);
            DqRellntPosAccModel.setDqDataQualityId(value.getDqDataQualityId());
            DqRellntPosAccModel.setDqPositionalAccuracyId(value.getDqPositionalAccuracyId());

            if (DqRellntPosAccController.getDataById(value.getDqPositionalAccuracyId()) == null) {
                flag=true;
                id = IdDqRellntPosAcc;
            } else {
                flag=false;
                id = DqRellntPosAccController.getDataById(value.getDqPositionalAccuracyId()).getId();
            }

            if (flag) {
                ret = DqRellntPosAccController.saveDqRellntPosAcc(DqRellntPosAccModel);
            } else {
                ret = DqRellntPosAccController.updateDqRellntPosAcc(id,DqRellntPosAccModel);
            }

            displayLog(true, "DqRellntPosAcc");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqPositionalAccuracyId = "+value.getDqPositionalAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqRellntPosAcc " + ret+"\n");
            }else{
               displayLog(true, "Status table DqRellntPosAcc " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqRellntPosAcc " + e.toString());
            displayLog(true, "Status table DqRellntPosAcc " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqRellntPosAccGroup(BigDecimal dqPositionalAccuracyId,BigDecimal dataQualityId) {

        try{
        DqRellntPosAccModel drpam = new DqRellntPosAccModel();
        drpam.setDqDataQualityId(dataQualityId);
        drpam.setDqPositionalAccuracyId(dqPositionalAccuracyId);
        
        saveUpdateDqRellntPosAcc(drpam);
        jprocessbar.setValue(454);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_RELLNTPOSACCID;
            BigDecimal IdDqRellntPosAcc;
            DqElementModel dqElementModel = new DqElementModel();
            DqRellntPosAccController dqRellntPosAccController = new DqRellntPosAccController(session, hibernateUtilXml);
            IdDqRellntPosAcc = dqRellntPosAccController.getDataById(dqPositionalAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqRelativeInternalPositionalAccuracy.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqRelativeInternalPositionalAccuracy.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqRelativeInternalPositionalAccuracy.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqRellntPosAcc, columnName, dqElementModel);
            jprocessbar.setValue(456);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqRellntPosAcc, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqRelativeInternalPositionalAccuracy.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqRellNtPosAccId(IdDqRellntPosAcc);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(458);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqRelativeInternalPositionalAccuracy.getDateTime());
                dqElementDateTimeModel.setDqRellNtPosAccId(IdDqRellntPosAcc);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(460);
                jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(462);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqRelativeInternalPositionalAccuracy.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqRelativeInternalPositionalAccuracy.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(464);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqRelativeInternalPositionalAccuracy.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(466);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel cdm = new CiDateModel();
                            CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            cdm.setStringDate_(varDqCompletenessOmission.getDateEvaluation());
                            cdm.setDateType(varDqCompletenessOmission.getDateTypeEvaluation());
                            cdm.setCiCitationId(citationConformance);

                            saveUpdateCiDate(cdm);
                            jprocessbar.setValue(468);
                            jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqRelativeInternalPositionalAccuracy.getRemarks());
                    list.add(varDqRelativeInternalPositionalAccuracy.getQuantityType());
                    list.add(varDqRelativeInternalPositionalAccuracy.getQuantityTypeReference());
                    list.add(varDqRelativeInternalPositionalAccuracy.getCatalogSymbol());
                    list.add(varDqRelativeInternalPositionalAccuracy.getDescription());
                    list.add(varDqRelativeInternalPositionalAccuracy.getDescriptionReference());
                    list.add(varDqRelativeInternalPositionalAccuracy.getMetaDataProperty());
                    list.add(varDqRelativeInternalPositionalAccuracy.getIdentifier());
                    list.add(varDqRelativeInternalPositionalAccuracy.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqRelativeInternalPositionalAccuracy.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqRelativeInternalPositionalAccuracy.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(470);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqRelativeInternalPositionalAccuracy.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(472);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //save dq_relative_internal_Positional_Accuracy

    //save dq_accuracyOfATimeMeasurement
    public void saveUpdateDqTemporalAccuracy(DqTemporalAccuracyModel value) {
        
        String ret=null;
        try{
            DqTemporalAccuracyController DqTemporalAccuracyController = new DqTemporalAccuracyController(session, hibernateUtilXml);
            DqTemporalAccuracyModel DqTemporalAccuracyModel = new DqTemporalAccuracyModel();

            BigDecimal getIdDqTemporalAccuracy;
            BigDecimal IdDqTemporalAccuracy;
            BigDecimal id=null;
            boolean flag=false;

            getIdDqTemporalAccuracy = DqTemporalAccuracyController.getMaxDqTemporalAccuracyId();
            if (getIdDqTemporalAccuracy == null) {
                IdDqTemporalAccuracy = new BigDecimal(FIRST_ID);
            } else {
                IdDqTemporalAccuracy = new BigDecimal(getIdDqTemporalAccuracy.longValue() + 1);
            }

            DqTemporalAccuracyModel.setId(IdDqTemporalAccuracy);
            DqTemporalAccuracyModel.setDqDataQualityId(value.getDqDataQualityId());

            if (DqTemporalAccuracyController.getDataById(value.getDqDataQualityId()) == null) {
                flag=true;
                id = IdDqTemporalAccuracy;
            } else {
                flag=false;
                id = DqTemporalAccuracyController.getDataById(value.getDqDataQualityId()).getId();
            }

            if(flag) {
                ret = DqTemporalAccuracyController.saveDqTemporalAccuracy(DqTemporalAccuracyModel);
            }else{
                ret = DqTemporalAccuracyController.updateDqTemporalAccuracy(id,DqTemporalAccuracyModel);
            }
            
            displayLog(true, "DqTemporalAccuracy");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqTemporalAccuracy " + ret+"\n");
            }else{
               displayLog(true, "Status table DqTemporalAccuracy " + ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqTemporalAccuracy " + e.toString());
            displayLog(true, "Status table DqTemporalAccuracy " + ret+"\n");
        }

    }

    public void saveUpdateDqAccTimeMeAs(DqAccTimeMeAsModel value) {
        
        String ret=null;
        try{
            DqAccTimeMeAsController DqAccTimeMeAsController = new DqAccTimeMeAsController(session, hibernateUtilXml);
            DqAccTimeMeAsModel DqAccTimeMeAsModel = new DqAccTimeMeAsModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqAccTimeMeAs;
            BigDecimal IdDqAccTimeMeAs;

            getIdDqAccTimeMeAs = DqAccTimeMeAsController.getMaxDqAccTimeMeAsId();
            if (getIdDqAccTimeMeAs == null) {
                IdDqAccTimeMeAs = new BigDecimal(FIRST_ID);
            } else {
                IdDqAccTimeMeAs = new BigDecimal(getIdDqAccTimeMeAs.longValue() + 1);
            }

            DqAccTimeMeAsModel.setId(IdDqAccTimeMeAs);
            DqAccTimeMeAsModel.setDqDataQualityId(value.getDqDataQualityId());
            DqAccTimeMeAsModel.setDqTemporalAccuracyId(value.getDqTemporalAccuracyId());

            if (DqAccTimeMeAsController.getDataById(value.getDqTemporalAccuracyId()) == null) {
                flag=true;
                id = IdDqAccTimeMeAs;
            } else {
                flag=false;
                id = DqAccTimeMeAsController.getDataById(value.getDqTemporalAccuracyId()).getId();
            }

            if (flag) {
                ret = DqAccTimeMeAsController.saveDqAccTimeMeAs(DqAccTimeMeAsModel);
            } else {
                ret = DqAccTimeMeAsController.updateDqAccTimeMeAs(id,DqAccTimeMeAsModel);
            }

            displayLog(true, "DqAccTimeMeAs");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqTemporalAccuracyId = "+value.getDqTemporalAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqAccTimeMeAs " + ret+"\n");
            }else{
               displayLog(true, "Status table DqAccTimeMeAs " + ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqAccTimeMeAs " + e.toString());
            displayLog(true, "Status table DqAccTimeMeAs " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqAccTimeMeAsGroup(BigDecimal dqTemporalAccuracyId,BigDecimal dataQualityId) {
        
        try{
        //DqAccTimeMeAs
        DqAccTimeMeAsModel asModel = new DqAccTimeMeAsModel();
        
        asModel.setDqDataQualityId(dataQualityId);
        asModel.setDqTemporalAccuracyId(dqTemporalAccuracyId);
        
        saveUpdateDqAccTimeMeAs(asModel);
        jprocessbar.setValue(476);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_ACCTIMEMEASID;
            BigDecimal IdDqAccTimeMeAs;
            DqElementModel dqElementModel = new DqElementModel();
            DqAccTimeMeAsController dqAccTimeMeAsController = new DqAccTimeMeAsController(session, hibernateUtilXml);
            IdDqAccTimeMeAs = dqAccTimeMeAsController.getDataById(dqTemporalAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqAccuracyOfATimeMeasurement.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqAccuracyOfATimeMeasurement.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqAccuracyOfATimeMeasurement.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqAccTimeMeAs, columnName, dqElementModel);
            jprocessbar.setValue(478);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqAccTimeMeAs, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqAccuracyOfATimeMeasurement.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqAccTimeMeAsId(IdDqAccTimeMeAs);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(480);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqAccuracyOfATimeMeasurement.getDateTime());
                dqElementDateTimeModel.setDqAccTimeMeAsId(IdDqAccTimeMeAs);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(482);
                jprocessbar.setStringPainted(true);

                //measuredescription
                MdIdentifierModel mim = new MdIdentifierModel();

                mim.setCode(varDqAccuracyOfATimeMeasurement.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID,IdDqElement, mim);
                jprocessbar.setValue(484);
                jprocessbar.setStringPainted(true);

                    //cicitation
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,IdDqElement).getId();

                    CiCitationModel citationModel = new CiCitationModel();

                    citationModel.setTitle(varDqAccuracyOfATimeMeasurement.getTitleMeasure());
                    citationModel.setMdIdentifierId(mdIdentifierId);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierId,citationModel);
                    jprocessbar.setValue(486);
                    jprocessbar.setStringPainted(true);
   
                        //cidate
                        CiDateModel cd = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationMeasure = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierId).getId();

                        cd.setStringDate_(varDqAccuracyOfATimeMeasurement.getDateMeasure());
                        cd.setDateType(varDqAccuracyOfATimeMeasurement.getDateTypeMeasure());
                        cd.setCiCitationId(citationMeasure);

                        saveUpdateCiDate(cd);
                        jprocessbar.setValue(488);
                        jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(490);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqAccuracyOfATimeMeasurement.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqAccuracyOfATimeMeasurement.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(492);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation       
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqAccuracyOfATimeMeasurement.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult, ciCitationModel);
                        jprocessbar.setValue(494);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel cdm = new CiDateModel();
                            CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal CiCitationId = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            cdm.setStringDate_(varDqAccuracyOfATimeMeasurement.getDate());
                            cdm.setDateType(varDqAccuracyOfATimeMeasurement.getDateType());
                            cdm.setCiCitationId(CiCitationId);

                            saveUpdateCiDate(cdm);
                            jprocessbar.setValue(496);
                            jprocessbar.setStringPainted(true);
        
                //evaluation procedure
                CiCitationModel ccm = new CiCitationModel();
        
                ccm.setTitle(varDqAccuracyOfATimeMeasurement.getTitleEvaluation());
                ccm.setDqElementId(IdDqElement);

                saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement, ccm);
                jprocessbar.setValue(498);
                jprocessbar.setStringPainted(true);

                    //cidate
                    CiDateModel ciDateModel = new CiDateModel();
                    BigDecimal CiCitationEvaluation = ciCitationController.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                    ciDateModel.setStringDate_(varDqAccuracyOfATimeMeasurement.getDateEvaluation());
                    ciDateModel.setDateType(varDqAccuracyOfATimeMeasurement.getDateTypeEvaluation());
                    ciDateModel.setCiCitationId(CiCitationEvaluation);

                    saveUpdateCiDate(ciDateModel);
                    jprocessbar.setValue(500);
                    jprocessbar.setStringPainted(true);
                    //evaluation procudere

                    //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqAccuracyOfATimeMeasurement.getRemarks());
                    list.add(varDqAccuracyOfATimeMeasurement.getQuantityType());
                    list.add(varDqAccuracyOfATimeMeasurement.getQuantityTypeReference());
                    list.add(varDqAccuracyOfATimeMeasurement.getCatalogSymbol());
                    list.add(varDqAccuracyOfATimeMeasurement.getDescription());
                    list.add(varDqAccuracyOfATimeMeasurement.getDescriptionReference());
                    list.add(varDqAccuracyOfATimeMeasurement.getMetaDataProperty());
                    list.add(varDqAccuracyOfATimeMeasurement.getIdentifier());
                    list.add(varDqAccuracyOfATimeMeasurement.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqAccuracyOfATimeMeasurement.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqAccuracyOfATimeMeasurement.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(502);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqAccuracyOfATimeMeasurement.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(504);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dq_accuracyOfATimeMeasurement

    //save dq_TemporalConsistency
    public void saveUpdateDqTempConsis(DqTempConsisModel value) {
         
        String ret=null;
        try{
            DqTempConsisController DqTempConsisController = new DqTempConsisController(session, hibernateUtilXml);
            DqTempConsisModel DqTempConsisModel = new DqTempConsisModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqTempConsis;
            BigDecimal IdDqTempConsis;

            getIdDqTempConsis = DqTempConsisController.getMaxDqTempConsisId();
            if (getIdDqTempConsis == null) {
                IdDqTempConsis = new BigDecimal(FIRST_ID);
            } else {
                IdDqTempConsis = new BigDecimal(getIdDqTempConsis.longValue() + 1);
            }

            DqTempConsisModel.setId(IdDqTempConsis);
            DqTempConsisModel.setDqDataQualityId(value.getDqDataQualityId());
            DqTempConsisModel.setDqTemporalAccuracyId(value.getDqTemporalAccuracyId());

            if (DqTempConsisController.getDataById(value.getDqTemporalAccuracyId()) == null) {
                flag=true;
                id = IdDqTempConsis;
            } else {
                flag=false;
                id = DqTempConsisController.getDataById(value.getDqTemporalAccuracyId()).getId();
            }

            if (flag) {
                ret = DqTempConsisController.saveDqTempConsis(DqTempConsisModel);
            } else {
                ret = DqTempConsisController.updateDqTempConsis(id,DqTempConsisModel);
            }

            displayLog(true, "DqTempConsis");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqTemporalAccuracyId = "+value.getDqTemporalAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqTempConsis " + ret+"\n");
            }else{
               displayLog(true, "Status table DqTempConsis " + ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqTempConsis " + e.toString());
            displayLog(true, "Status table DqTempConsis " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqTempConsisGroup(BigDecimal dqTemporalAccuracyId,BigDecimal dataQualityId) {

        try{
        DqTempConsisModel dtcm = new DqTempConsisModel();
        dtcm.setDqDataQualityId(dataQualityId);
        dtcm.setDqTemporalAccuracyId(dqTemporalAccuracyId);
        
        saveUpdateDqTempConsis(dtcm);
        jprocessbar.setValue(506);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_TEMPCONSISID;
            BigDecimal IdDqTempConsis;
            DqElementModel dqElementModel = new DqElementModel();
            DqTempConsisController dqTempConsisController = new DqTempConsisController(session, hibernateUtilXml);
            IdDqTempConsis = dqTempConsisController.getDataById(dqTemporalAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqTemporalConsistency.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqTemporalConsistency.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqTemporalConsistency.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqTempConsis, columnName, dqElementModel);
            jprocessbar.setValue(508);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqTempConsis, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqTemporalConsistency.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqTempConsisId(IdDqTempConsis);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(510);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqTemporalConsistency.getDateTime());
                dqElementDateTimeModel.setDqTempConsisId(IdDqTempConsis);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(512);
                jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(514);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqTemporalConsistency.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqTemporalConsistency.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(516);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqTemporalConsistency.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(518);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();
                            CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            ciDateModel.setStringDate_(varDqTemporalConsistency.getDate());
                            ciDateModel.setDateType(varDqTemporalConsistency.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(520);
                            jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqTemporalConsistency.getRemarks());
                    list.add(varDqTemporalConsistency.getQuantityType());
                    list.add(varDqTemporalConsistency.getQuantityTypeReference());
                    list.add(varDqTemporalConsistency.getCatalogSymbol());
                    list.add(varDqTemporalConsistency.getDescription());
                    list.add(varDqTemporalConsistency.getDescriptionReference());
                    list.add(varDqTemporalConsistency.getMetaDataProperty());
                    list.add(varDqTemporalConsistency.getIdentifier());
                    list.add(varDqTemporalConsistency.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqTemporalConsistency.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqTemporalConsistency.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(522);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqTemporalConsistency.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(524);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dq_TemporalConsistency

    //save dq_Temporalvalidity
    public void saveUpdateDqTempValid(DqTempValidModel value) {
        
        String ret=null;
        try{
            DqTempValidController DqTempValidController = new DqTempValidController(session, hibernateUtilXml);
            DqTempValidModel DqTempValidModel = new DqTempValidModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqTempValid;
            BigDecimal IdDqTempValid;

            getIdDqTempValid = DqTempValidController.getMaxDqTempValidId();
            if (getIdDqTempValid == null) {
                IdDqTempValid = new BigDecimal(FIRST_ID);
            } else {
                IdDqTempValid = new BigDecimal(getIdDqTempValid.longValue() + 1);
            }

            DqTempValidModel.setId(IdDqTempValid);
            DqTempValidModel.setDqDataQualityId(value.getDqDataQualityId());
            DqTempValidModel.setDqTemporalAccuracyId(value.getDqTemporalAccuracyId());

            if (DqTempValidController.getDataById(value.getDqTemporalAccuracyId()) == null) {
                flag=true;
                id = IdDqTempValid;
            } else {
                flag=false;
                id = DqTempValidController.getDataById(value.getDqTemporalAccuracyId()).getId();
            }

            if (flag) {
                ret = DqTempValidController.saveDqTempValid(DqTempValidModel);
            } else {
                ret = DqTempValidController.updateDqTempValid(id,DqTempValidModel);
            }

            displayLog(true, "DqTempValid");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqTemporalAccuracyId = "+value.getDqTemporalAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqTempValid " + ret+"\n");
            }else{
               displayLog(true, "Status table DqTempValid " + ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqTempValid " + e.toString());
            displayLog(true, "Status table DqTempValid " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqTempValidGroup(BigDecimal dqTemporalAccuracyId,BigDecimal dataQualityId) {

        try{
        DqTempValidModel dtvm = new DqTempValidModel();
        dtvm.setDqDataQualityId(dataQualityId);
        dtvm.setDqTemporalAccuracyId(dqTemporalAccuracyId);
        
        saveUpdateDqTempValid(dtvm);
        jprocessbar.setValue(526);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_TEMPVALIDID;
            BigDecimal IdDqTempValid;
            DqElementModel dqElementModel = new DqElementModel();
            DqTempValidController dqTempValidController = new DqTempValidController(session, hibernateUtilXml);
            IdDqTempValid = dqTempValidController.getDataById(dqTemporalAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqTemporalValidity.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqTemporalValidity.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqTemporalValidity.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqTempValid, columnName, dqElementModel);
            jprocessbar.setValue(528);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqTempValid, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqTemporalValidity.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqTempValidId(IdDqTempValid);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(530);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqTemporalValidity.getDateTime());
                dqElementDateTimeModel.setDqTempValidId(IdDqTempValid);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(532);
                jprocessbar.setStringPainted(true);
        
                //measureidentification
                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varDqTemporalValidity.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                jprocessbar.setValue(534);
                jprocessbar.setStringPainted(true);
                
                    //citation
                    CiCitationModel ccm = new CiCitationModel();
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                    ccm.setTitle(varDqTemporalValidity.getTitleMeasure());
                    ccm.setEdition(varDqTemporalValidity.getEdition());
                    ccm.setStringEditionDate(varDqTemporalValidity.getEditionDate());
                    ccm.setMdIdentifierId(mdIdentifierIdSup);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                    jprocessbar.setValue(536);
                    jprocessbar.setStringPainted(true);
        
                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                        cdm.setStringDate_(varDqTemporalValidity.getDateMeasure());
                        cdm.setDateType(varDqTemporalValidity.getDateTypeMeasure());
                        cdm.setCiCitationId(citationIdSup);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(538);
                        jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(540);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();
                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqTemporalValidity.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqTemporalValidity.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(542);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();
                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();

                        ciCitationModel.setTitle(varDqTemporalValidity.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(544);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            ciDateModel.setStringDate_(varDqTemporalValidity.getDate());
                            ciDateModel.setDateType(varDqTemporalValidity.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(546);
                            jprocessbar.setStringPainted(true);
        
                //evaluation procedure
                //citation
                CiCitationModel cmProcedure = new CiCitationModel();

                cmProcedure.setTitle(varDqTemporalValidity.getTitleEvaluation());
                cmProcedure.setDqElementId(IdDqElement);

                saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
                jprocessbar.setValue(548);
                jprocessbar.setStringPainted(true);
                
                    //cidate
                    CiDateModel cdmProcedure = new CiDateModel();
                    BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                    cdmProcedure.setStringDate_(varDqTemporalValidity.getDateEvaluation());
                    cdmProcedure.setDateType(varDqTemporalValidity.getDateTypeEvaluation());
                    cdmProcedure.setCiCitationId(citationProcedure);

                    saveUpdateCiDate(cdmProcedure);
                    jprocessbar.setValue(550);
                    jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqTemporalValidity.getRemarks());
                    list.add(varDqTemporalValidity.getQuantityType());
                    list.add(varDqTemporalValidity.getQuantityTypeReference());
                    list.add(varDqTemporalValidity.getCatalogSymbol());
                    list.add(varDqTemporalValidity.getDescription());
                    list.add(varDqTemporalValidity.getDescriptionReference());
                    list.add(varDqTemporalValidity.getMetaDataProperty());
                    list.add(varDqTemporalValidity.getIdentifier());
                    list.add(varDqTemporalValidity.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqTemporalValidity.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqTemporalValidity.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(552);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqTemporalValidity.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(554);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //save dq_Temporalvalidity

    //save dqThematicClassificationCorrectness
    public void saveUpdateDqThematicAccuracy(DqThematicAccuracyModel value) {
        
        String ret=null;
        try{
            DqThematicAccuracyController DqThematicAccuracyController = new DqThematicAccuracyController(session, hibernateUtilXml);
            DqThematicAccuracyModel DqThematicAccuracyModel = new DqThematicAccuracyModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqThematicAccuracy;
            BigDecimal IdDqThematicAccuracy;

            getIdDqThematicAccuracy = DqThematicAccuracyController.getMaxDqThematicAccuracyId();
            if (getIdDqThematicAccuracy == null) {
                IdDqThematicAccuracy = new BigDecimal(FIRST_ID);
            } else {
                IdDqThematicAccuracy = new BigDecimal(getIdDqThematicAccuracy.longValue() + 1);
            }

            DqThematicAccuracyModel.setId(IdDqThematicAccuracy);
            DqThematicAccuracyModel.setDqDataQualityId(value.getDqDataQualityId());


            if (DqThematicAccuracyController.getDataById(value.getDqDataQualityId()) == null) {
                flag=true;
                id = IdDqThematicAccuracy;
            } else {
                flag=false;
                id = DqThematicAccuracyController.getDataById(value.getDqDataQualityId()).getId();
            }

            if (flag) {
                ret = DqThematicAccuracyController.saveDqThematicAccuracy(DqThematicAccuracyModel);
            } else {
                ret = DqThematicAccuracyController.updateDqThematicAccuracy(id,DqThematicAccuracyModel);
            }

            displayLog(true, "DqThematicAccuracy");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqThematicAccuracy " + ret+"\n");
            }else{
               displayLog(true, "Status table DqThematicAccuracy " + ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqThematicAccuracy " + e.toString());
            displayLog(true, "Status table DqThematicAccuracy " + ret+"\n");
        }

    }

    public void saveUpdateDqThemClassCor(DqThemClassCorModel value) {
        
        String ret=null;
        try{
            DqThemClassCorController DqThemClassCorController = new DqThemClassCorController(session, hibernateUtilXml);
            DqThemClassCorModel DqThemClassCorModel = new DqThemClassCorModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqThemClassCor;
            BigDecimal IdDqThemClassCor;

            getIdDqThemClassCor = DqThemClassCorController.getMaxDqThemClassCorId();
            if (getIdDqThemClassCor == null) {
                IdDqThemClassCor = new BigDecimal(FIRST_ID);
            } else {
                IdDqThemClassCor = new BigDecimal(getIdDqThemClassCor.longValue() + 1);
            }

            DqThemClassCorModel.setId(IdDqThemClassCor);
            DqThemClassCorModel.setDqDataQualityId(value.getDqDataQualityId());
            DqThemClassCorModel.setDqThematicAccuracyId(value.getDqThematicAccuracyId());

            if (DqThemClassCorController.getDataById(value.getDqThematicAccuracyId()) == null) {
                flag=true;
                id = IdDqThemClassCor;
            } else {
                flag=false;
                id = DqThemClassCorController.getDataById(value.getDqThematicAccuracyId()).getId();
            }

            if (flag) {
                ret = DqThemClassCorController.saveDqThemClassCor(DqThemClassCorModel);
            } else {
                ret = DqThemClassCorController.updateDqThemClassCor(id,DqThemClassCorModel);
            }
            
            displayLog(true, "DqThemClassCor");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqThematicAccuracyId = "+value.getDqThematicAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqThemClassCor " + ret+"\n");
            }else{
               displayLog(true, "Status table DqThemClassCor " + ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqThemClassCor " + e.toString());
            displayLog(true, "Status table DqThemClassCor " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqThemClassCorGroup(BigDecimal dqThematicAccuracyId,BigDecimal dataQualityId) {

        try{
        DqThemClassCorModel dtccm = new DqThemClassCorModel();
       
        dtccm.setDqDataQualityId(dataQualityId);
        dtccm.setDqThematicAccuracyId(dqThematicAccuracyId);
        
        saveUpdateDqThemClassCor(dtccm);
        jprocessbar.setValue(558);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_THEMCLASSCORID;
            BigDecimal IdDqThemClassCor;
            DqElementModel dqElementModel = new DqElementModel();
            DqThemClassCorController dqThemClassCorController = new DqThemClassCorController(session, hibernateUtilXml);
            IdDqThemClassCor = dqThemClassCorController.getDataById(dqThematicAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqThematicClassificationCorrectness.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqThematicClassificationCorrectness.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqThematicClassificationCorrectness.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqThemClassCor, columnName, dqElementModel);
            jprocessbar.setValue(560);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqThemClassCor, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqThematicClassificationCorrectness.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqThemClassCorId(IdDqThemClassCor);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(562);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqThematicClassificationCorrectness.getDateTime());
                dqElementDateTimeModel.setDqThemClassCorId(IdDqThemClassCor);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(564);
                jprocessbar.setStringPainted(true);
        
                //measureidentification
                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varDqThematicClassificationCorrectness.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                jprocessbar.setValue(566);
                jprocessbar.setStringPainted(true);
        
                    //citation
                    CiCitationModel ccm = new CiCitationModel();
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                    ccm.setTitle(varDqThematicClassificationCorrectness.getTitleMeasure());
                    ccm.setMdIdentifierId(mdIdentifierIdSup);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                    jprocessbar.setValue(568);
                    jprocessbar.setStringPainted(true);
        
                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                        cdm.setStringDate_(varDqThematicClassificationCorrectness.getDateMeasure());
                        cdm.setDateType(varDqThematicClassificationCorrectness.getDateTypeMeasure());
                        cdm.setCiCitationId(citationIdSup);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(570);
                        jprocessbar.setStringPainted(true);
        
                        //citation_alternate_title
                        CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();

                        ccatm.setAlternateTitle(varDqThematicClassificationCorrectness.getAlternateTitle());
                        ccatm.setCi_citationid(citationIdSup);

                        saveUpdateCiCitationAlternateTitle(ccatm);
                        jprocessbar.setValue(572);
                        jprocessbar.setStringPainted(true);
        
                        //mdidentifier
                        MdIdentifierModel mimsub = new MdIdentifierModel();
                        mimsub.setCode(varDqThematicClassificationCorrectness.getCodeIdentifier());
                        mimsub.setExtendsType(nullValue);
                        mimsub.setCiCitationId(citationIdSup);

                        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationIdSup, mimsub);
                        jprocessbar.setValue(574);
                        jprocessbar.setStringPainted(true);
       
                            //citation
                            CiCitationModel ccmSub = new CiCitationModel();
                            BigDecimal mdIdentifierSub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationIdSup).getId();

                            ccmSub.setTitle(varDqThematicClassificationCorrectness.getTitleIdentifier());
                            ccmSub.setMdIdentifierId(mdIdentifierSub);

                            saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub,ccmSub);
                            jprocessbar.setValue(576);
                            jprocessbar.setStringPainted(true);
        
                                //cidate
                                CiDateModel cdmSub = new CiDateModel();
                                BigDecimal  citationSub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub).getId();

                                cdmSub.setStringDate_(varDqThematicClassificationCorrectness.getDateIdentifier());
                                cdmSub.setDateType(varDqThematicClassificationCorrectness.getDateTypeIdentifier());
                                cdmSub.setCiCitationId(citationSub);

                                saveUpdateCiDate(cdmSub);
                                jprocessbar.setValue(578);
                                jprocessbar.setStringPainted(true);
                                
                                //citationalternate
                                CiCitationAlternateTitleModel ccatmsub = new CiCitationAlternateTitleModel();

                                ccatmsub.setAlternateTitle(varDqThematicClassificationCorrectness.getAlternateTitleIdentifier());
                                ccatmsub.setCi_citationid(citationSub);

                                saveUpdateCiCitationAlternateTitle(ccatmsub);
                                jprocessbar.setValue(580);
                                jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(582);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqThematicClassificationCorrectness.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqThematicClassificationCorrectness.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(584);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqThematicClassificationCorrectness.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(586);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            ciDateModel.setStringDate_(varDqThematicClassificationCorrectness.getDate());
                            ciDateModel.setDateType(varDqThematicClassificationCorrectness.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(588);
                            jprocessbar.setStringPainted(true);

                     //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqThematicClassificationCorrectness.getRemarks());
                    list.add(varDqThematicClassificationCorrectness.getQuantityType());
                    list.add(varDqThematicClassificationCorrectness.getQuantityTypeReference());
                    list.add(varDqThematicClassificationCorrectness.getCatalogSymbol());
                    list.add(varDqThematicClassificationCorrectness.getDescription());
                    list.add(varDqThematicClassificationCorrectness.getDescriptionReference());
                    list.add(varDqThematicClassificationCorrectness.getMetaDataProperty());
                    list.add(varDqThematicClassificationCorrectness.getIdentifier());
                    list.add(varDqThematicClassificationCorrectness.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqThematicClassificationCorrectness.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqThematicClassificationCorrectness.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(590);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqThematicClassificationCorrectness.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(592);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dqThematicClassificationCorrectness

    //save dqNonQuantitativeAttributeAccuracy
    public void saveUpdateDqNonQuanAttacc(DqNonQuanAttaccModel value) {
           
        String ret=null;
        try{
            DqNonQuanAttaccController DqNonQuanAttaccController = new DqNonQuanAttaccController(session, hibernateUtilXml);
            DqNonQuanAttaccModel DqNonQuanAttaccModel = new DqNonQuanAttaccModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqNonQuanAttacc;
            BigDecimal IdDqNonQuanAttacc;

            getIdDqNonQuanAttacc = DqNonQuanAttaccController.getMaxDqNonQuanAttaccId();
            if (getIdDqNonQuanAttacc == null) {
                IdDqNonQuanAttacc = new BigDecimal(FIRST_ID);
            } else {
                IdDqNonQuanAttacc = new BigDecimal(getIdDqNonQuanAttacc.longValue() + 1);
            }

            DqNonQuanAttaccModel.setId(IdDqNonQuanAttacc);
            DqNonQuanAttaccModel.setDqDataQualityId(value.getDqDataQualityId());
            DqNonQuanAttaccModel.setDqThematicAccuracyId(value.getDqThematicAccuracyId());

            if (DqNonQuanAttaccController.getDataById(value.getDqThematicAccuracyId()) == null) {
                flag=true;
                id = IdDqNonQuanAttacc;
            } else {
                flag=false;
                id = DqNonQuanAttaccController.getDataById(value.getDqThematicAccuracyId()).getId();
            }

            if (flag) {
                ret = DqNonQuanAttaccController.saveDqNonQuanAttacc(DqNonQuanAttaccModel);
            } else {
                ret = DqNonQuanAttaccController.updateDqNonQuanAttacc(id,DqNonQuanAttaccModel);
            }
            
            displayLog(true, "DqNonQuanAttacc");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqThematicAccuracyId = "+value.getDqThematicAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqNonQuanAttacc " + ret+"\n");
            }else{
               displayLog(true, "Status table DqNonQuanAttacc " + ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqNonQuanAttacc " + e.toString());
            displayLog(true, "Status table DqNonQuanAttacc " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqNonQuanAttaccGroup(BigDecimal dqThematicAccuracyId,BigDecimal dataQualityId) {

        try{
        DqNonQuanAttaccModel dnqam = new DqNonQuanAttaccModel();
        dnqam.setDqDataQualityId(dataQualityId);
        dnqam.setDqThematicAccuracyId(dqThematicAccuracyId);
        
        saveUpdateDqNonQuanAttacc(dnqam);
        jprocessbar.setValue(594);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_NONQUANATTACCID;
            BigDecimal IdDqNonQuanAttacc;
            DqElementModel dqElementModel = new DqElementModel();
            DqNonQuanAttaccController dqNonQuanAttaccController = new DqNonQuanAttaccController(session, hibernateUtilXml);
            IdDqNonQuanAttacc = dqNonQuanAttaccController.getDataById(dqThematicAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqNonQuantitativeAttributeAccuracy.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqNonQuantitativeAttributeAccuracy.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqNonQuantitativeAttributeAccuracy.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqNonQuanAttacc, columnName, dqElementModel);
            jprocessbar.setValue(596);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqNonQuanAttacc, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqNonQuantitativeAttributeAccuracy.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqNonQuanAttaccId(IdDqNonQuanAttacc);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(598);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqNonQuantitativeAttributeAccuracy.getDateTime());
                dqElementDateTimeModel.setDqNonQuanAttaccId(IdDqNonQuanAttacc);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(600);
                jprocessbar.setStringPainted(true);

                //dq_result
                saveUpdateDqResult(IdDqElement, columnName);
                jprocessbar.setValue(602);
                jprocessbar.setStringPainted(true);

                    //dq_conformanceresult
                    DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                    DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                    BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                    dqConformanceResultModel.setDqResultId(IdDqResult);
                    dqConformanceResultModel.setExplanation(varDqNonQuantitativeAttributeAccuracy.getExplanation());
                    dqConformanceResultModel.setStringPass(varDqNonQuantitativeAttributeAccuracy.getPass());

                    saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                    jprocessbar.setValue(604);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult_citation
                        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                        CiCitationModel ciCitationModel = new CiCitationModel();

                        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                        ciCitationModel.setTitle(varDqNonQuantitativeAttributeAccuracy.getTitle());
                        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                        jprocessbar.setValue(606);
                        jprocessbar.setStringPainted(true);
                        
                            //dq_conformanceresult_cidate
                            CiDateModel ciDateModel = new CiDateModel();
                            CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

                            BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                            ciDateModel.setStringDate_(varDqNonQuantitativeAttributeAccuracy.getDate());
                            ciDateModel.setDateType(varDqNonQuantitativeAttributeAccuracy.getDateType());
                            ciDateModel.setCiCitationId(citationConformance);

                            saveUpdateCiDate(ciDateModel);
                            jprocessbar.setValue(608);
                            jprocessbar.setStringPainted(true);

                    //dq_quantitativeresult
                    ArrayList<String> list = new ArrayList<>();        
                    list.add(varDqNonQuantitativeAttributeAccuracy.getRemarks());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getQuantityType());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getQuantityTypeReference());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getCatalogSymbol());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getDescription());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getDescriptionReference());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getMetaDataProperty());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getIdentifier());
                    list.add(varDqNonQuantitativeAttributeAccuracy.getUnitsSystem());
                    DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                    dqQuantitativeResultModel.setDqResultId(IdDqResult);
                    dqQuantitativeResultModel.setValueType(varDqNonQuantitativeAttributeAccuracy.getValueType());
                    dqQuantitativeResultModel.setValueUnitList(list);
                    dqQuantitativeResultModel.setErrorStatistic(varDqNonQuantitativeAttributeAccuracy.getErrorStatic());

                    saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                    jprocessbar.setValue(610);
                    jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult_value
                        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                        BigDecimal IdDqQuantitativeResult;
                        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                        dqQuantitativeResultValueModel.setValue(varDqNonQuantitativeAttributeAccuracy.getValue());

                        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                        jprocessbar.setValue(612);
                        jprocessbar.setStringPainted(true);
                        
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dqNonQuantitativeAttributeAccuracy

    //save dqQuantitativeAttributeAccuracy
    public void saveUpdateDqQuanAttacc(DqQuanAttacModel value) {

        String ret=null;
        try{
            DqQuanAttacController DqQuanAttacController = new DqQuanAttacController(session, hibernateUtilXml);
            DqQuanAttacModel DqQuanAttacModel = new DqQuanAttacModel();

            boolean flag=false;
            BigDecimal id=null;
            BigDecimal getIdDqQuanAttac;
            BigDecimal IdDqQuanAttac;

            getIdDqQuanAttac = DqQuanAttacController.getMaxDqQuanAttacId();
            if (getIdDqQuanAttac == null) {
                IdDqQuanAttac = new BigDecimal(FIRST_ID);
            } else {
                IdDqQuanAttac = new BigDecimal(getIdDqQuanAttac.longValue() + 1);
            }

            DqQuanAttacModel.setId(IdDqQuanAttac);
            DqQuanAttacModel.setDqDataQualityId(value.getDqDataQualityId());
            DqQuanAttacModel.setDqThematicAccuracyId(value.getDqThematicAccuracyId());

            if (DqQuanAttacController.getDataById(value.getDqThematicAccuracyId()) == null) {
                flag=true;
                id = IdDqQuanAttac;
            } else {
                flag=false;
                id = DqQuanAttacController.getDataById(value.getDqThematicAccuracyId()).getId();
            }

            if (flag) {
                ret = DqQuanAttacController.saveDqQuanAttac(DqQuanAttacModel);
            } else {
                ret = DqQuanAttacController.updateDqQuanAttac(id,DqQuanAttacModel);
            }
            
            displayLog(true, "DqQuanAttac");
            displayLog(true, "id = "+id);
            displayLog(true, "DqDataQualityId = "+value.getDqDataQualityId());
            displayLog(true, "foreign key DqThematicAccuracyId = "+value.getDqThematicAccuracyId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqQuanAttac " + ret+"\n");
            }else{
               displayLog(true, "Status table DqQuanAttac " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error DqQuanAttac " + e.toString());
            displayLog(true, "Status table DqQuanAttac " + ret+"\n");
        }

    }

    //dq for loop
    public void saveUpdateDqQuanAttaccGroup(BigDecimal dqThematicAccuracyId,BigDecimal dataQualityId) {

        try{
        DqQuanAttacModel dqam = new DqQuanAttacModel();
        dqam.setDqDataQualityId(dataQualityId);
        dqam.setDqThematicAccuracyId(dqThematicAccuracyId);
        
        saveUpdateDqQuanAttacc(dqam);
        jprocessbar.setValue(614);
        jprocessbar.setStringPainted(true);
        
            //dq_element
            String columnName = DqElementModel.DQ_QUANATTACCID;
            BigDecimal IdDqQuanAttacc;
            DqElementModel dqElementModel = new DqElementModel();
            DqQuanAttacController dqQuanAttaccController = new DqQuanAttacController(session, hibernateUtilXml);
            IdDqQuanAttacc = dqQuanAttaccController.getDataById(dqThematicAccuracyId).getId();

            dqElementModel.setMeasureDescription(varDqQuantitativeAttributeAccuracy.getMeasureDescription());
            dqElementModel.setEvaluationMethodType(varDqQuantitativeAttributeAccuracy.getEvaluationMethodType());
            dqElementModel.setEvaluationMethodDescription(varDqQuantitativeAttributeAccuracy.getEvaluationMethodDescription());
            dqElementModel.setDqDataQualityId(dataQualityId);

            saveUpdateDqElement(IdDqQuanAttacc, columnName, dqElementModel);
            jprocessbar.setValue(616);
            jprocessbar.setStringPainted(true);

                //dq_element_name_of_measure
                DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
                BigDecimal IdDqElement = dqElementController.getDataById(IdDqQuanAttacc, columnName).getId();
                DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
                dqElementNameOfMeasureModel.setNameOfMeasure(varDqQuantitativeAttributeAccuracy.getNameOfMeasure());
                dqElementNameOfMeasureModel.setDqQuanAttaccId(IdDqQuanAttacc);

                saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);
                jprocessbar.setValue(618);
                jprocessbar.setStringPainted(true);

                //dq_element_datetime
                DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
                dqElementDateTimeModel.setStringDateTime(varDqQuantitativeAttributeAccuracy.getDateTime());
                dqElementDateTimeModel.setDqQuanAttaccId(IdDqQuanAttacc);

                saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
                jprocessbar.setValue(620);
                jprocessbar.setStringPainted(true);

                //measureidentification
                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varDqQuantitativeAttributeAccuracy.getCode());
                mim.setExtendsType(nullValue);
                mim.setDqElementId(IdDqElement);

                saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
                jprocessbar.setValue(622);
                jprocessbar.setStringPainted(true);
        
                    //citation
                    CiCitationModel ccm = new CiCitationModel();
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();

                    ccm.setTitle(varDqQuantitativeAttributeAccuracy.getTitleMeasure());
                    ccm.setEdition(varDqQuantitativeAttributeAccuracy.getEdition());
                    ccm.setMdIdentifierId(mdIdentifierIdSup);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
                    jprocessbar.setValue(624);
                    jprocessbar.setStringPainted(true);
        
                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();

                        cdm.setStringDate_(varDqQuantitativeAttributeAccuracy.getDateMeasure());
                        cdm.setDateType(varDqQuantitativeAttributeAccuracy.getDateTypeMeasure());
                        cdm.setCiCitationId(citationIdSup);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(626);
                        jprocessbar.setStringPainted(true);

                    //dq_result
                    saveUpdateDqResult(IdDqElement, columnName);
                    jprocessbar.setValue(628);
                    jprocessbar.setStringPainted(true);

                        //dq_conformanceresult
                        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
                        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
                        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

                        dqConformanceResultModel.setDqResultId(IdDqResult);
                        dqConformanceResultModel.setExplanation(varDqQuantitativeAttributeAccuracy.getExplanation());
                        dqConformanceResultModel.setStringPass(varDqQuantitativeAttributeAccuracy.getPass());

                        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);
                        jprocessbar.setValue(630);
                        jprocessbar.setStringPainted(true);

                            //dq_conformanceresult_citation
                            DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
                            CiCitationModel ciCitationModel = new CiCitationModel();

                            BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
                            ciCitationModel.setTitle(varDqQuantitativeAttributeAccuracy.getTitle());
                            ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

                            saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
                            jprocessbar.setValue(632);
                            jprocessbar.setStringPainted(true);
                            
                                //dq_conformanceresult_cidate
                                CiDateModel ciDateModel = new CiDateModel();
                                BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

                                ciDateModel.setStringDate_(varDqQuantitativeAttributeAccuracy.getDate());
                                ciDateModel.setDateType(varDqQuantitativeAttributeAccuracy.getDateType());
                                ciDateModel.setCiCitationId(citationConformance);

                                saveUpdateCiDate(ciDateModel);
                                jprocessbar.setValue(634);
                                jprocessbar.setStringPainted(true);
        
                    //evaluation procedure
                    //citation
                    CiCitationModel cmProcedure = new CiCitationModel();

                    cmProcedure.setTitle(varDqQuantitativeAttributeAccuracy.getTitleEvaluation());
                    cmProcedure.setDqElementId(IdDqElement);

                    saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
                    jprocessbar.setValue(636);
                    jprocessbar.setStringPainted(true);
                    
                        //cidate
                        CiDateModel cdmProcedure = new CiDateModel();
                        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

                        cdmProcedure.setStringDate_(varDqQuantitativeAttributeAccuracy.getDateEvaluation());
                        cdmProcedure.setDateType(varDqQuantitativeAttributeAccuracy.getDateTypeEvaluation());
                        cdmProcedure.setCiCitationId(citationProcedure);

                        saveUpdateCiDate(cdmProcedure);
                        jprocessbar.setValue(638);
                        jprocessbar.setStringPainted(true);

                        //dq_quantitativeresult
                        ArrayList<String> list = new ArrayList<>();        
                        list.add(varDqQuantitativeAttributeAccuracy.getRemarks());
                        list.add(varDqQuantitativeAttributeAccuracy.getQuantityType());
                        list.add(varDqQuantitativeAttributeAccuracy.getQuantityTypeReference());
                        list.add(varDqQuantitativeAttributeAccuracy.getCatalogSymbol());
                        list.add(varDqQuantitativeAttributeAccuracy.getDescription());
                        list.add(varDqQuantitativeAttributeAccuracy.getDescriptionReference());
                        list.add(varDqQuantitativeAttributeAccuracy.getMetaDataProperty());
                        list.add(varDqQuantitativeAttributeAccuracy.getIdentifier());
                        list.add(varDqQuantitativeAttributeAccuracy.getUnitsSystem());
                        DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();
                        dqQuantitativeResultModel.setDqResultId(IdDqResult);
                        dqQuantitativeResultModel.setValueType(varDqQuantitativeAttributeAccuracy.getValueType());
                        dqQuantitativeResultModel.setValueUnitList(list);
                        dqQuantitativeResultModel.setErrorStatistic(varDqQuantitativeAttributeAccuracy.getErrorStatic());

                        saveUpdateDqQuantitativeResult(columnName, dqQuantitativeResultModel);
                        jprocessbar.setValue(640);
                        jprocessbar.setStringPainted(true);

                            //dq_quantitativeresult_value
                            DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
                            DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
                            BigDecimal IdDqQuantitativeResult;
                            IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

                            dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
                            dqQuantitativeResultValueModel.setValue(varDqQuantitativeAttributeAccuracy.getValue());

                            saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);
                            jprocessbar.setValue(642);
                            jprocessbar.setStringPainted(true);
                            
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    //end dq for loop
    //end save dqQuantitativeAttributeAccuracy

    //save li_lineage
    public void saveUpdateLiLineage(LiLineageModel value) {
         
        String ret=null;
        try{
            LiLineageController liLineageController = new LiLineageController(session, hibernateUtilXml);
            LiLineageModel liLineageModel = new LiLineageModel();

            boolean flag=false;
            BigDecimal getIdLiLineage;
            BigDecimal idLiLineage;
            BigDecimal id=null;

            getIdLiLineage = liLineageController.getMaxLiLineageId();

            if (getIdLiLineage == null) {
                idLiLineage = new BigDecimal(FIRST_ID);
            } else {
                idLiLineage = new BigDecimal(getIdLiLineage.longValue() + 1);
            }

            liLineageModel.setId(idLiLineage);
            liLineageModel.setStatement(value.getStatement());
            liLineageModel.setDqDataQualityId(value.getDqDataQualityId());

            if (liLineageController.getDataById(value.getDqDataQualityId()) == null) {
                flag=true;
                id = idLiLineage;
            } else {
                flag=false;
                id = liLineageController.getDataById(value.getDqDataQualityId()).getId();
            }

            if (flag) {
                ret = liLineageController.saveLiLineage(liLineageModel);
            } else {
                ret = liLineageController.updateLiLineage(id,liLineageModel);
            }

            displayLog(true, "LiLineage");
            displayLog(true, "id = "+id);
            displayLog(true, "Statement = "+value.getStatement());
            displayLog(true, "foreign key DqDataQualityId = "+value.getDqDataQualityId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table LiLineage " + ret+"\n");
            }else{
               displayLog(true, "Status table LiLineage " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error LiLineage " + e.toString());
            displayLog(true, "Status table LiLineage " + ret+"\n");
        }

    }

    public void saveUpdateLiProcessStep(String column, BigDecimal foreignId,LiProcessStepModel value) {

        String ret=null;
        displayLog(true, "LiProcessStep");
        
        try{
            LiProcessStepController liProcessStepController = new LiProcessStepController(session, hibernateUtilXml);
            LiProcessStepModel liProcessStepModel = new LiProcessStepModel();

            boolean flag=false;
            BigDecimal getIdLiProcessStep;
            BigDecimal idLiProcessStep;
            BigDecimal id=null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate;

            try {
                String date__ = value.getStringDateTime().replace("T", " ");
                if (date__.equals("-")|| date__==null) {
                    liProcessStepModel.setDateTime(null);
                    displayLog(true, "DateTime = null");
                } else {
                    parsedDate = dateFormat.parse(date__);
                    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                    liProcessStepModel.setDateTime(timestamp);
                    displayLog(true, "DateTime =  "+timestamp);
                }
            } catch (ParseException ex) {
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
                displayLog(true, "DateTime = null");
            }catch(NullPointerException n){
                 Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
                 displayLog(true, "DateTime = null");
            }

            getIdLiProcessStep = liProcessStepController.getMaxLiProcessStepId();
            if (getIdLiProcessStep == null) {
                idLiProcessStep = new BigDecimal(FIRST_ID);
            } else {
                idLiProcessStep = new BigDecimal(getIdLiProcessStep.longValue() + 1);
            }

            liProcessStepModel.setId(idLiProcessStep);
            liProcessStepModel.setDescription(value.getDescription());
            liProcessStepModel.setRationale(value.getRationale());
            liProcessStepModel.setLiLineageId(value.getLiLineageId());
            liProcessStepModel.setLiSourceId(value.getLiSourceId());


            if (liProcessStepController.getDataById(column,foreignId) == null) {
                flag=true;
                id = idLiProcessStep;
            } else {
                flag=false;
                id = liProcessStepController.getDataById(column,foreignId).getId();
            }

            if (flag) {
                ret = liProcessStepController.saveLiProcessStep(liProcessStepModel);
            } else {
                ret = liProcessStepController.updateLiProcessStep(id,liProcessStepModel);
            }
            
            displayLog(true, "LiProcessStep");
            displayLog(true, "id = "+id);
            displayLog(true, "Description = "+value.getDescription());
            displayLog(true, "Rationale = "+value.getRationale());
            displayLog(true, "foreign key "+column+" = "+foreignId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table LiProcessStep " + ret+"\n");
            }else{
               displayLog(true, "Status table LiProcessStep " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error LiProcessStep " + e.toString());
            displayLog(true, "Status table LiProcessStep " + ret+"\n");
        }    
        

    }

    public void saveUpdateLiSource(String column,BigDecimal foreignId,LiSourceModel value) {

        String ret=null;
        try{
            LiSourceController liSourceController = new LiSourceController(session, hibernateUtilXml);
            LiSourceModel liSourceModel = new LiSourceModel();
            
            boolean flag=false;
            BigDecimal getIdLiSource;
            BigDecimal idLiSource;
            BigDecimal id=null;

            getIdLiSource = liSourceController.getMaxLiSourceId();
            if (getIdLiSource == null) {
                idLiSource = new BigDecimal(FIRST_ID);
            } else {
                idLiSource = new BigDecimal(getIdLiSource.longValue() + 1);
            }

            liSourceModel.setId(idLiSource);
            liSourceModel.setDescription(value.getDescription());
            liSourceModel.setLiLineageId(value.getLiLineageId());
            liSourceModel.setLiProcessStepId(value.getLiProcessStepId());

            if (liSourceController.getDataById(column,foreignId) == null) {
                flag=true;
                id = idLiSource;
            } else {
                flag=false;
                id = liSourceController.getDataById(column,foreignId).getId();
            }

            if (flag) {
                ret = liSourceController.saveLiSource(liSourceModel);
            } else {
                ret = liSourceController.updateLiSource(id,liSourceModel);
            }
            
            displayLog(true, "LiSource");
            displayLog(true, "id = "+id);
            displayLog(true, "Description = "+value.getDescription());
            displayLog(true, "foreign key "+column+" = "+foreignId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table LiSource " + ret+"\n");
            }else{
               displayLog(true, "Status table LiSource " + ret+"\n");
            }
            
        }catch(Exception e){
            
            displayLog(false, "Error LiSource " + e.toString());
            displayLog(true, "Status table LiSource " + ret+"\n");
        }  

    }

    public void saveUpdateLiLineageGroup(BigDecimal dataQualityId) {
       
        try{
                   
            //lineage
            LiLineageModel llm = new LiLineageModel();
            llm.setDqDataQualityId(dataQualityId);
            llm.setStatement(varLiLineage.getStatement());

            saveUpdateLiLineage(llm);
            jprocessbar.setValue(644);
            jprocessbar.setStringPainted(true);

                //liprocesstep
                LiProcessStepModel lpsm = new LiProcessStepModel();
                LiLineageController llc = new LiLineageController(session, hibernateUtilXml);
                BigDecimal liLineageId = llc.getDataById(dataQualityId).getId();

                lpsm.setDescription(varLiLineage.getDescriptionLiProcessStep());
                lpsm.setRationale(varLiLineage.getRationale());
                lpsm.setStringDateTime(varLiLineage.getDateTime());
                lpsm.setLiLineageId(liLineageId);

                saveUpdateLiProcessStep(LiProcessStepModel.LI_LINEAGE,liLineageId,lpsm);
                jprocessbar.setValue(646);
                jprocessbar.setStringPainted(true);

                    LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
                    BigDecimal liProcessStepId = lpsc.getDataById(LiProcessStepModel.LI_LINEAGE,liLineageId).getId();

                    //processStep
                    processStep(liProcessStepId);//664

                //lisource
                LiSourceModel lsm = new LiSourceModel();

                lsm.setDescription(varLiLineage.getDescriptionLiSource());
                lsm.setLiLineageId(liLineageId);

                saveUpdateLiSource(LiSourceModel.LI_LINEAGEID,liLineageId,lsm);
                jprocessbar.setValue(666);
                jprocessbar.setStringPainted(true);

                source(liLineageId);//702
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    
    public void processStep(BigDecimal liProcessStepId){
        
        try{
                            
                //ciresponsibleparty
                CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
                partyModel.setIndividualName(varLiLineage.getIndividualName());
                partyModel.setOrganisationName(varLiLineage.getOrganisationName());
                partyModel.setPositionName(varLiLineage.getPositionName());
                partyModel.setRole(varLiLineage.getRole());
                partyModel.setLiProcessStepId(liProcessStepId);

                saveUpdateCiResponsibleParty(CiResponsiblePartyModel.LI_PROCESSSTEPID,liProcessStepId,partyModel);
                jprocessbar.setValue(648);
                jprocessbar.setStringPainted(true);
  
                    //cicontact
                    CiContactModel ccm = new CiContactModel();
                    CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                    BigDecimal ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.LI_PROCESSSTEPID,liProcessStepId).getId();

                    ccm.setContactInstruction(varLiLineage.getContactInstructions());
                    ccm.setHouseOfService(varLiLineage.getHoursOfService());
                    ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                    saveUpdateCiContact(ccm);
                    jprocessbar.setValue(650);
                    jprocessbar.setStringPainted(true);

                        //citelephone
                        CiTelephoneModel ctm = new CiTelephoneModel();
                        CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                        BigDecimal ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();

                        ctm.setCiContactId(ciContactId);

                        saveUpdateCiTelephone(ctm);
                        jprocessbar.setValue(652);
                        jprocessbar.setStringPainted(true);

                            //citelephonevoice
                            CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
                            CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                            BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                            ctvm.setVoice(varLiLineage.getVoice());
                            ctvm.setCiTelephoneId(ciTelephoneId);

                            saveUpdateCiTelephoneVoice(ctvm);
                            jprocessbar.setValue(654);
                            jprocessbar.setStringPainted(true);

                            //citelephonefacs
                            CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
                            ctfm.setFacsimile(varLiLineage.getFax());
                            ctfm.setCiTelephoneId(ciTelephoneId);

                            saveUpdateCiTelephoneFacsimile(ctfm);
                            jprocessbar.setValue(656);
                            jprocessbar.setStringPainted(true);

                        //ciaddress
                        CiAddressModel cam = new CiAddressModel();
                        cam.setAdmnistrativeArea(varLiLineage.getAdministrativeArea());
                        cam.setCity(varLiLineage.getCity());
                        cam.setCountry(varLiLineage.getCountry());
                        cam.setPostalCode(varLiLineage.getPostalCode());
                        cam.setCiContactId(ciContactId);

                        saveUpdateCiAddress(cam);
                        jprocessbar.setValue(658);
                        jprocessbar.setStringPainted(true);

                            //ciaddress_deliverypoint
                            CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
                            CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                            BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                            cadpm.setDeliveryPoint(varLiLineage.getDeliveryPoint());
                            cadpm.setCi_addressid(ciAddressId);

                            saveUpdateCiAddressDeliveryPoint(cadpm);
                            jprocessbar.setValue(660);
                            jprocessbar.setStringPainted(true);

                            //ciaddress_emailaddress
                            CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
                            addressModel.setCi_addressid(ciAddressId);
                            addressModel.setEmailAddress(varLiLineage.getElectronicMailAddress());

                            saveUpdateCiAddressEmailAddress(addressModel);
                            jprocessbar.setValue(662);
                            jprocessbar.setStringPainted(true);
 
                        //ci_onlineresource
                        CiOnlineResourceModel corm = new CiOnlineResourceModel();
                        corm.setLinkage(varLiLineage.getLinkage());
                        corm.setApplicationProfile(varLiLineage.getApplicationProfile());
                        corm.setProtocol(varLiLineage.getProtocol());
                        corm.setName(varLiLineage.getNameOnlineResource());
                        corm.setDescription(varLiLineage.getDescription());
                        corm.setFunction_(varLiLineage.getFunction());
                        corm.setCiContactId(ciContactId);

                        saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,corm);
                        jprocessbar.setValue(664);
                        jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
    }
    
    public void source(BigDecimal liLineageId){
        
        try{           
        
            MdRepresentativeFractionModel mrfm = new MdRepresentativeFractionModel();
            LiSourceController lsc = new LiSourceController(session, hibernateUtilXml);
            BigDecimal liSourceId = lsc.getDataById(LiSourceModel.LI_LINEAGEID, liLineageId).getId();

            mrfm.setStringDenominator(varLiLineage.getDenominator());
            mrfm.setLiSourceId(liSourceId); 

                saveUpdateMdRepresentativeFraction(MdRepresentativeFractionModel.LI_SOURCEID,liSourceId,mrfm);
                jprocessbar.setValue(668);
                jprocessbar.setStringPainted(true);

                sourceReferenceSystem(liSourceId);//682
                sourceCitation(liSourceId);//688
                sourceExtent(liSourceId);//700
                sourceStep(liSourceId);//702
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    public void sourceReferenceSystem(BigDecimal liSourceId){
        
        try{
            
            //mdreferencesytem
            MdReferenceSystemModel mrsm = new MdReferenceSystemModel();
            mrsm.setLiSourceId(liSourceId);

            saveUpdateReferenceSystem(MdReferenceSystemModel.LI_SOURCEID,liSourceId,mrsm);
            jprocessbar.setValue(670);
            jprocessbar.setStringPainted(true);

                //rsidentifier
                RsIdentifierModel rim = new RsIdentifierModel();
                MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
                BigDecimal mdReferenceSystemId=mrsc.getDataById(MdReferenceSystemModel.LI_SOURCEID,liSourceId).getId();

                rim.setCode(varLiLineage.getCode());
                rim.setCodeSpace(varLiLineage.getCodeSpace());
                rim.setVersion(varLiLineage.getVersion());
                rim.setMdReferenceSystemId(mdReferenceSystemId);

                saveUpdateRsIdentifier(RsIdentifierModel.MD_REFERENCESYSTEMID,mdReferenceSystemId,rim);
                jprocessbar.setValue(672);
                jprocessbar.setStringPainted(true);

                    //cicitation
                    CiCitationModel citationModel = new CiCitationModel();
                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                    BigDecimal rsIdentifierId=ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();

                    citationModel.setTitle(varLiLineage.getTitle());
                    citationModel.setEdition(varLiLineage.getEdition());
                    citationModel.setStringEditionDate(varLiLineage.getEditionDate());
                    citationModel.setRsIdentifierId(rsIdentifierId);

                    saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,citationModel);
                    jprocessbar.setValue(674);
                    jprocessbar.setStringPainted(true);

                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        CiCitationController cit = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal ciCitationId=cit.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();

                        cdm.setStringDate_(varLiLineage.getDate_());
                        cdm.setDateType(varLiLineage.getDateType());
                        cdm.setCiCitationId(ciCitationId);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(676);
                        jprocessbar.setStringPainted(true);

                        //citationalternatetitle
                       CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();

                       ccatm.setAlternateTitle(varLiLineage.getAlternatetitle());
                       ccatm.setCi_citationid(ciCitationId);

                       saveUpdateCiCitationAlternateTitle(ccatm);
                       jprocessbar.setValue(678);
                       jprocessbar.setStringPainted(true);

                       CiSeriesModel csm = new CiSeriesModel();
                       csm.setIssueIdentification(varLiLineage.getIssueIdentification());
                       csm.setName(varLiLineage.getName());
                       csm.setPage(varLiLineage.getPage());
                       csm.setCiCitationId(ciCitationId);

                       saveUpdateCiSeries(csm);
                       jprocessbar.setValue(680);
                       jprocessbar.setStringPainted(true);

                       CiCitationPresentationFormModel ccpfm = new CiCitationPresentationFormModel();
                       ccpfm.setCiCitationId(ciCitationId);
                       ccpfm.setPresentationForm(varLiLineage.getPresentationForm());

                       SaveUpdateCitationPresentationForm(ccpfm);
                       jprocessbar.setValue(682);
                       jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    public void sourceCitation(BigDecimal liSourceId){
        
        try{
           
               //cicitation
               CiCitationModel citationModel = new CiCitationModel();

               citationModel.setTitle(varLiLineage.getTitle());
               citationModel.setEdition(varLiLineage.getEditionSource());
               citationModel.setStringEditionDate(varLiLineage.getEditionDateSource());
               citationModel.setLiSourceId(liSourceId);

               saveUpdateCiCitation(CiCitationModel.LISOURCEID,liSourceId,citationModel);
               jprocessbar.setValue(684);
               jprocessbar.setStringPainted(true);

                    //cidate
                    CiDateModel cdm = new CiDateModel();
                    CiCitationController cit = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId=cit.getDataById(CiCitationModel.LISOURCEID,liSourceId).getId();

                    cdm.setStringDate_(varLiLineage.getDate_());
                    cdm.setDateType(varLiLineage.getDateType());
                    cdm.setCiCitationId(ciCitationId);

                    saveUpdateCiDate(cdm);
                    jprocessbar.setValue(686);
                    jprocessbar.setStringPainted(true);

                    //citationalternatetitle
                    CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();

                    ccatm.setAlternateTitle(varLiLineage.getAlternatetitle());
                    ccatm.setCi_citationid(ciCitationId);

                    saveUpdateCiCitationAlternateTitle(ccatm);
                    jprocessbar.setValue(688);
                    jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
        
    }
    
    public void sourceExtent(BigDecimal liSourceId){
        
        try{
            
            //ex_extent
            ExExtentModel eem = new ExExtentModel();            
            eem.setDescription(varLiLineage.getDescription());
            eem.setLiSourceId(liSourceId);
            
            saveUpdateExExtent(ExExtentModel.LI_SOURCEID,liSourceId,eem);
            jprocessbar.setValue(690);
            jprocessbar.setStringPainted(true);
            
                //ex_geographicextent
               ExGeographicExtentModel egem = new ExGeographicExtentModel();
               ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
               BigDecimal exExtentId = eec.getDataById(ExExtentModel.LI_SOURCEID,liSourceId).getId();

               egem.setExExtentId(exExtentId);
               egem.setExtendsType(nullValue);
               egem.setStringExtentTypeCode(varLiLineage.getExtentTypeCode());
                        
               saveUpdateExExtentGeographicExtent(ExGeographicExtentModel.EX_EXTENTID,exExtentId,egem);
               jprocessbar.setValue(692);
               jprocessbar.setStringPainted(true);

                    //ex_boundingpolygon
                    ExBoundingPolygonModel ebpm = new ExBoundingPolygonModel();
                    ExGeographicExtentController egec = new ExGeographicExtentController(session, hibernateUtilXml);
                    BigDecimal exGeographicExtentId = egec.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();
                    ebpm.setExGeographicExtentId(exGeographicExtentId);

                    saveUpdateExBoundingPolygon(ebpm);
                    jprocessbar.setValue(694);
                    jprocessbar.setStringPainted(true);
            
                        //ex_boundingpolygonpolygon
                        ExBoundingPolygonPolygonModel ebppm = new ExBoundingPolygonPolygonModel();
                        ExBoundingPolygonController ebpc = new ExBoundingPolygonController(session, hibernateUtilXml);

                        BigDecimal exBoundingPolygonId = ebpc.getDataById(exGeographicExtentId).getExGeographicExtentId();

                        List polygonList= new ArrayList();
                        polygonList.add(varLiLineage.getDescriptionPolygon());
                        polygonList.add(varLiLineage.getDescriptionReference());
                        polygonList.add(varLiLineage.getIdentifier());
                        polygonList.add(varLiLineage.getMetaDataProperty());
                        polygonList.add(varLiLineage.getNamePolygon());
                        ebppm.setPolygonList(polygonList);
                        ebppm.setExBoundingPolygonId(exBoundingPolygonId);

                        try{
                             saveUpdateExBoundingPolygonPolygon(ebppm); 
                             jprocessbar.setValue(696);
                             jprocessbar.setStringPainted(true);

                        }catch(SQLException ex){
                            ex.printStackTrace();
                        }

                //ex_extenttemporal
               ExTemporalExtentModel etem = new ExTemporalExtentModel();  
               etem.setExExtendId(exExtentId);
               etem.setExtendsType(nullValue);

               saveUpdateExTemporalExtent(etem);
               jprocessbar.setValue(698);
               jprocessbar.setStringPainted(true);

                //ex_extentvertical
               ExVerticalExtentModel evem = new ExVerticalExtentModel();    
               evem.setExExtentId(exExtentId);

               saveUpdateExExtentVerticalExtent(evem);
               jprocessbar.setValue(700);
               jprocessbar.setStringPainted(true);
                        
        }catch(Exception n){
            n.printStackTrace();
        }
    }
    
    public void sourceStep(BigDecimal liSourceId){
        
        try{
            
                //liprocesstep
                LiProcessStepModel lpsm = new LiProcessStepModel();
                lpsm.setDescription(varLiLineage.getDescriptionSourceStep());
                lpsm.setRationale(varLiLineage.getRationaleSourceStep());
                lpsm.setStringDateTime(varLiLineage.getDateTimeSourceStep());
                lpsm.setLiSourceId(liSourceId);

                saveUpdateLiProcessStep(LiProcessStepModel.LI_SOURCEID,liSourceId,lpsm);
                jprocessbar.setValue(702);
                jprocessbar.setStringPainted(true);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }    
        
    }
    //end save li_lineage

    //save dq for loop
    public void saveUpdateDqElement(BigDecimal dqId, String columnName, DqElementModel dqModel) {

        String ret=null;
        try{
            DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
            DqEvaluationMethodTypeCodeController dqEvaluationMethodTypeCodeController = new DqEvaluationMethodTypeCodeController(session, hibernateUtilXml);
            DqElementModel dqElementModel = new DqElementModel();

            BigDecimal getIdDqElement;
            BigDecimal IdDqElement;
            String checkData;
            BigDecimal id=null;
            boolean flag=false;

            String domainName = dqModel.getEvaluationMethodDescription();
            String code;
            if(domainName==null){
                code="000";
            }else{
                code = dqEvaluationMethodTypeCodeController.getDataByDomain(domainName).getCode();
            }

            getIdDqElement = dqElementController.getMaxDqElementId();
            if (getIdDqElement == null) {
                IdDqElement = new BigDecimal(FIRST_ID);
            } else {
                IdDqElement = new BigDecimal(getIdDqElement.longValue() + 1);
            }

            dqElementModel.setId(IdDqElement);
            dqElementModel.setMeasureDescription(dqModel.getMeasureDescription());
            dqElementModel.setEvaluationMethodDescription(dqModel.getEvaluationMethodDescription());
            dqElementModel.setEvaluationMethodType(code);
            dqElementModel.setExtendsType(dqModel.getExtendsType());
            dqElementModel.setDqDataQualityId(dqModel.getDqDataQualityId());

            switch (columnName) {

                case "dqCompCommId":
                    dqElementModel.setDqCompCommId(dqId);
                    break;
                case "dqCompOmId":
                    dqElementModel.setDqCompOmId(dqId);
                    break;
                case "dqConcConsisId":
                    dqElementModel.setDqConcConsisId(dqId);
                    break;
                case "dqDomConsisId":
                    dqElementModel.setDqDomConsisId(dqId);
                    break;
                case "dqFormConsisId":
                    dqElementModel.setDqFormConsisId(dqId);
                    break;
                case "dqTopConsisId":
                    dqElementModel.setDqTopConsisId(dqId);
                    break;
                case "dqAbsExtPosAccId":
                    dqElementModel.setDqAbsExtPosAccId(dqId);
                    break;
                case "dqGridDataPosAccId":
                    dqElementModel.setDqGridDataPosAccId(dqId);
                    break;
                case "dqRellNtPosAccId":
                    dqElementModel.setDqRellNtPosAccId(dqId);
                    break;
                case "dqAccTimeMeAsId":
                    dqElementModel.setDqAccTimeMeAsId(dqId);
                    break;
                case "dqTempConsisId":
                    dqElementModel.setDqTempConsisId(dqId);
                    break;
                case "dqTempValidId":
                    dqElementModel.setDqTempValidId(dqId);
                    break;
                case "dqThemClassCorId":
                    dqElementModel.setDqThemClassCorId(dqId);
                    break;
                case "dqNonQuanAttaccId":
                    dqElementModel.setDqNonQuanAttaccId(dqId);
                    break;
                case "dqQuanAttaccId":
                    dqElementModel.setDqQuanAttaccId(dqId);
                    break;
            }

            if (dqElementController.getDataById(dqId, columnName) == null) {
                flag=true;
                id = IdDqElement;
            } else {
                flag=false;
                id = dqElementController.getDataById(dqId, columnName).getId();
            }

            if (flag) {
                ret = dqElementController.saveDqElement(dqElementModel);
            } else {
                ret = dqElementController.updateDqElement(dqElementModel, id);
            }
                        
            displayLog(true, "DqElement");
            displayLog(true, "id = "+id);
            displayLog(true, "MeasureDescription = "+dqModel.getMeasureDescription());
            displayLog(true, "EvaluationMethodDescription = "+dqModel.getEvaluationMethodDescription());
            displayLog(true, "EvaluationMethodType = "+dqModel.getEvaluationMethodType());
            displayLog(true, "ExtendsType = "+dqModel.getExtendsType());
            displayLog(true, "DqDataQualityId = "+dqModel.getDqDataQualityId());
            displayLog(true, "foreign key "+columnName+" = "+dqId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqElement " + ret+"\n");
            }else{
               displayLog(true, "Status table DqElement " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            }
                 
        }catch(Exception e){
            
            displayLog(false, "Error DqElement "+columnName.toLowerCase().replace("id", "") + " "+ e.toString());
            displayLog(true, "Status table DqElement " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
        }  

    }

    public void saveUpdateDqElementNameOfMeasure(BigDecimal dqElementId, String columnName, DqElementNameOfMeasureModel dqModel) {

        String ret=null;
        try{
            DqElementNameOfMeasureController dqElementNameOfMeasureController = new DqElementNameOfMeasureController(session, hibernateUtilXml);
            DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();

            String checkData;

            dqElementNameOfMeasureModel.setDqElementId(dqElementId);
            dqElementNameOfMeasureModel.setNameOfMeasure(dqModel.getNameOfMeasure());
            dqElementNameOfMeasureModel.setDqAbsExtPosAccId(dqModel.getDqAbsExtPosAccId());
            dqElementNameOfMeasureModel.setDqCompCommId(dqModel.getDqCompCommId());
            dqElementNameOfMeasureModel.setDqCompOmId(dqModel.getDqCompOmId());
            dqElementNameOfMeasureModel.setDqConcConsisId(dqModel.getDqConcConsisId());
            dqElementNameOfMeasureModel.setDqDomConsisId(dqModel.getDqDomConsisId());
            dqElementNameOfMeasureModel.setDqFormConsisId(dqModel.getDqFormConsisId());
            dqElementNameOfMeasureModel.setDqGridDataPosAccId(dqModel.getDqGridDataPosAccId());
            dqElementNameOfMeasureModel.setDqNonQuanAttaccId(dqModel.getDqNonQuanAttaccId());
            dqElementNameOfMeasureModel.setDqQuanAttaccId(dqModel.getDqQuanAttaccId());
            dqElementNameOfMeasureModel.setDqRellNtPosAccId(dqModel.getDqRellNtPosAccId());
            dqElementNameOfMeasureModel.setDqTempConsisId(dqModel.getDqTempConsisId());
            dqElementNameOfMeasureModel.setDqTempValidId(dqModel.getDqTempValidId());
            dqElementNameOfMeasureModel.setDqThemClassCorId(dqModel.getDqThemClassCorId());
            dqElementNameOfMeasureModel.setDqTopConsisId(dqModel.getDqTopConsisId());
            dqElementNameOfMeasureModel.setDqAccTimeMeAsId(dqModel.getDqAccTimeMeAsId());

            if (dqElementNameOfMeasureController.getDataById(dqElementId) == null) {
                checkData = "";
            } else {
                checkData = dqElementNameOfMeasureController.getDataById(dqElementId).getDqElementId().toString();
            }

            if (checkData.equals("")) {
                ret = dqElementNameOfMeasureController.saveDqElementNameOfMeasure(dqElementNameOfMeasureModel);
            } else {
                ret = dqElementNameOfMeasureController.updateDqElementNameOfMeasure(dqElementNameOfMeasureModel);
            }

            displayLog(true, "DqElementNameOfMeasure");
            displayLog(true, "NameOfMeasure = "+dqModel.getNameOfMeasure());
            displayLog(true, "foreign key DqElementId = "+dqElementId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqElementNameOfMeasure " + ret+"\n");
            }else{
               displayLog(true, "Status table DqElementNameOfMeasure " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            }
         
        }catch(Exception e){
            
            displayLog(false, "Error DqElementNameOfMeasure " +columnName.toLowerCase().replace("id", "") + " "+ e.toString());
            displayLog(true, "Status table DqElementNameOfMeasure " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
        }  

    }

    public void saveUpdateDqElementDateTime(BigDecimal dqElementId, String columnName, DqElementDateTimeModel dqModel) {

        String ret=null;
        displayLog(true, "DqElementDateTime");
        
        try{
            DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
            DqElementDateTimeController dqElementDateTimeController = new DqElementDateTimeController(session, hibernateUtilXml);

            String checkData;   
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate;

            try {
                String date__ = dqModel.getStringDateTime().replace("T", " ");
                if (date__.equals("-")||date__==null || date__=="null") {
                    //dt = dateFormat.parse(date__);
                    displayLog(true, "DateTime = null");
                    dqElementDateTimeModel.setDateTime(null);
                    
                    
                } else {
                    parsedDate = dateFormat.parse(date__);
                    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                    dqElementDateTimeModel.setDateTime(timestamp);
                    displayLog(true, "DateTime = "+timestamp);
                    
                }
            } catch (ParseException ex) {
                displayLog(true, "DateTime = null");
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
            }catch(NullPointerException n){
                displayLog(true, "DateTime = null");
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }

            dqElementDateTimeModel.setDqElementId(dqElementId);
            dqElementDateTimeModel.setDqAbsExtPosAccId(dqModel.getDqAbsExtPosAccId());
            dqElementDateTimeModel.setDqCompCommId(dqModel.getDqCompCommId());
            dqElementDateTimeModel.setDqCompOmId(dqModel.getDqCompOmId());
            dqElementDateTimeModel.setDqConcConsisId(dqModel.getDqConcConsisId());
            dqElementDateTimeModel.setDqDomConsisId(dqModel.getDqDomConsisId());
            dqElementDateTimeModel.setDqFormConsisId(dqModel.getDqFormConsisId());
            dqElementDateTimeModel.setDqGridDataPosAccId(dqModel.getDqGridDataPosAccId());
            dqElementDateTimeModel.setDqNonQuanAttaccId(dqModel.getDqNonQuanAttaccId());
            dqElementDateTimeModel.setDqQuanAttaccId(dqModel.getDqQuanAttaccId());
            dqElementDateTimeModel.setDqRellNtPosAccId(dqModel.getDqRellNtPosAccId());
            dqElementDateTimeModel.setDqTempConsisId(dqModel.getDqTempConsisId());
            dqElementDateTimeModel.setDqTempValidId(dqModel.getDqTempValidId());
            dqElementDateTimeModel.setDqThemClassCorId(dqModel.getDqThemClassCorId());
            dqElementDateTimeModel.setDqTopConsisId(dqModel.getDqTopConsisId());
            dqElementDateTimeModel.setDqAccTimeMeAsId(dqModel.getDqAccTimeMeAsId());

            if (dqElementDateTimeController.getDataById(dqElementId) == null) {
                checkData = "";
            } else {
                checkData = dqElementDateTimeController.getDataById(dqElementId).getDqElementId().toString();
            }

            if (checkData.equals("")) {
                ret = dqElementDateTimeController.saveDqElementDateTime(dqElementDateTimeModel);
            } else {
                ret = dqElementDateTimeController.updateDqElementDateTime(dqElementDateTimeModel);
            }
            
            displayLog(true, "foreign key DqElementId = "+dqElementId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqElementDateTime " + ret+"\n");
            }else{
               displayLog(true, "Status table DqElementDateTime " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error DqElementDateTime " +columnName.toLowerCase().replace("id", "") + " "+ e.toString());
            displayLog(true, "Status table DqElementDateTime " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
        }  

    }

    public void saveUpdateDqResult(BigDecimal dqElementId, String columnName) {

        String ret=null;
        try{
            DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
            DqResultModel dqResultModel = new DqResultModel();

            BigDecimal IdDqResult;
            BigDecimal getIdDqResult;
            BigDecimal id=null;
            boolean flag=false;

            getIdDqResult = dqResultController.getMaxDqResultId();
            if (getIdDqResult == null) {
                IdDqResult = new BigDecimal(FIRST_ID);
            } else {
                IdDqResult = new BigDecimal(getIdDqResult.longValue() + 1);
            }

            dqResultModel.setId(IdDqResult);
            dqResultModel.setExtendsType(nullValue);
            dqResultModel.setDqElementId(dqElementId);

            if (dqResultController.getDataById(dqElementId) == null) {
                flag = true;
                id = IdDqResult;
            } else {
                flag=false;
                id = dqResultController.getDataById(dqElementId).getId();
            }

            if (flag) {
                ret = dqResultController.saveDqResult(dqResultModel);
            } else {
                ret = dqResultController.updateDqResult(id,dqResultModel);
            }
            
            displayLog(true, "DqResult");
            displayLog(true, "id = "+id);
            displayLog(true, "ExtendsType = -");
            displayLog(true, "foreign key DqElementId = "+dqElementId);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqResult " + ret+"\n");
            }else{
               displayLog(true, "Status table DqResult " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            }
           
        }catch(Exception e){
            
            displayLog(false, "Error DqResult " +columnName.toLowerCase().replace("id", "") + " "+ e.toString());
            displayLog(true, "Status table DqResult " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
        }      
    }
    //end save dq for loop

    //save dq_conformanceresult
    public void saveUpdateDQConformanceResult(String columnName, DqConformanceResultModel dqModel) {

         String ret=null;
        try{
            DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
            DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();

            String checkData;

            String pass = dqModel.getStringPass();
            BigDecimal passer = null;
            try{

                if (pass.equalsIgnoreCase("true") || pass==null) {
                    passer = new BigDecimal(BigInteger.ONE);
                } else {
                    passer = new BigDecimal(BigInteger.ZERO);
                 }

            }catch(NullPointerException n){
                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }


            dqConformanceResultModel.setDqResultId(dqModel.getDqResultId());
            dqConformanceResultModel.setExplanation(dqModel.getExplanation());
            dqConformanceResultModel.setPass(passer);

            if (dqConformanceResultController.getDataById(dqModel.getDqResultId()) == null) {
                checkData = "";
            } else {
                checkData = dqConformanceResultController.getDataById(dqModel.getDqResultId()).getDqResultId().toString();
            }

            if (checkData.equals("")) {
                ret = dqConformanceResultController.saveDqConformanceResult(dqConformanceResultModel);
            } else {
                ret = dqConformanceResultController.updateDqConformanceResult(dqConformanceResultModel);
            }
            
            displayLog(true, "DqConformanceResult");
            displayLog(true, "Pass = "+passer);
            displayLog(true, "Explanation = "+dqModel.getExplanation());
            displayLog(true, "foreign key DqResultId = "+dqModel.getDqResultId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqConformanceResult " + ret+"\n");
            }else{
               displayLog(true, "Status table DqConformanceResult " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            }   
          
        }catch(Exception e){
            
            displayLog(false, "Error DqConformanceResult " +columnName.toLowerCase().replace("id", "") + " "+ e.toString());
            displayLog(true, "Status table DqConformanceResult " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
        }
        
    }
    //end save dq_conformanceresult

    //save dq_quantitativeresult
    public void saveUpdateDqQuantitativeResult(String columnName, DqQuantitativeResultModel dqModel) {

        String ret=null;
        try{
            DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
            DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();

            String checkData;
            String tagElement="";

            try{

                tagElement = dqQuantitativeResultController.listToStringTag(dqModel.getValueUnitList());
            }catch(NullPointerException n){

                Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, n);
            }


            dqQuantitativeResultModel.setDqResultId(dqModel.getDqResultId());
            dqQuantitativeResultModel.setErrorStatistic(dqModel.getErrorStatistic());
            dqQuantitativeResultModel.setValueType(dqModel.getValueType());
            dqQuantitativeResultModel.setValueUnit(tagElement);

            if (dqQuantitativeResultController.getDataById(dqModel.getDqResultId()) == null) {
                checkData = "";
            } else {
                checkData = dqQuantitativeResultController.getDataById(dqModel.getDqResultId()).getDqResultId().toString();
            }

            if (checkData.equals("")) {
                ret = dqQuantitativeResultController.saveDqQuantitativeResult(dqQuantitativeResultModel);
            } else {
                ret = dqQuantitativeResultController.updateDqQuantitativeResult(dqQuantitativeResultModel);
            }

            displayLog(true, "DqQuantitativeResult");
            displayLog(true, "ErrorStatistic = "+dqModel.getErrorStatistic());
            displayLog(true, "ValueType = "+dqModel.getValueType());
            displayLog(true, "ValueUnit = "+tagElement);
            displayLog(true, "foreign key DqResultId = "+dqModel.getDqResultId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqQuantitativeResult " + ret+"\n");
            }else{
               displayLog(true, "Status table DqQuantitativeResult " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            } 
          
        }catch(Exception e){
            
             displayLog(false, "Error DqQuantitativeResult " +columnName.toLowerCase().replace("id", "") + " "+ e.toString());
             displayLog(true, "Status table DqQuantitativeResult " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");

        }
    }

    public void saveUpdateDqQuantitativeResultValue(String columnName, DqQuantitativeResultValueModel dqModel) {

        String ret=null;
        try{
            DqQuantitativeResultValueController dqQuantitativeResultValueController = new DqQuantitativeResultValueController(session, hibernateUtilXml);
            DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();

            String checkData;
            dqQuantitativeResultValueModel.setDqQuantitativeResultId(dqModel.getDqQuantitativeResultId());
            dqQuantitativeResultValueModel.setValue(dqModel.getValue());

            if (dqQuantitativeResultValueController.getDataById(dqModel.getDqQuantitativeResultId()) == null) {
                checkData = "";
            } else {
                checkData = dqQuantitativeResultValueController.getDataById(dqModel.getDqQuantitativeResultId()).getDqQuantitativeResultId().toString();
            }

            if (checkData.equals("")) {
                ret = dqQuantitativeResultValueController.saveDqQuantitativeResultValue(dqQuantitativeResultValueModel);
            } else {
                ret = dqQuantitativeResultValueController.updateDqQuantitativeResultValue(dqQuantitativeResultValueModel);
            }

            displayLog(true, "DqQuantitativeResultValue");
            displayLog(true, "Value = "+dqModel.getValue());
            displayLog(true, "foreign key DqQuantitativeResultId = "+dqModel.getDqQuantitativeResultId());
         
            if(ret.contains("Error")){
               displayLog(false, "Status table DqQuantitativeResultValue " + ret+"\n");
            }else{
               displayLog(true, "Status table DqQuantitativeResultValue " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Error DqQuantitativeResultValue " +columnName.toLowerCase().replace("id", "") + " "+ e.toString());
            displayLog(true, "Status table DqQuantitativeResultValue " +columnName.toLowerCase().replace("id", "") + " "+ ret+"\n");
        }
    }
    //end save dq_quantitativeresult

    //save mdupload
    public void saveUpdateMdUpload(String newIdentifier) throws FileNotFoundException, IOException, SQLException {

        String ret=null;
        try{
            
            //System.out.println(fileName);
            MdUploadFileController mdUploadFileController = new MdUploadFileController(session, hibernateUtilXml);
            MdUploadFileModel mdUploadFileModel = new MdUploadFileModel();

            BigDecimal getIdMdUpload;
            BigDecimal idMdUpload;
            boolean flag=false;
            BigDecimal id=null;

            try {
                //InputStream input = new FileInputStream(jTextFieldPilihBerkas.getText());
                //String input = jTextFieldPilihBerkas.getText();
                //System.out.println(input);
                //[] bytes = IOUtils.toByteArray(input);
                byte[] bytes = mdUploadFileController.convertFileContentToBlob(fileName);
                Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
                //Blob blob = Hibernate.createBlob(bytes);
                mdUploadFileModel.setFileName(blob);
            } catch (Exception e) {
            }

            getIdMdUpload = mdUploadFileController.getMaxMdUploadId();
            if (getIdMdUpload == null) {
                idMdUpload = new BigDecimal(FIRST_ID);
            } else {
                idMdUpload = new BigDecimal(getIdMdUpload.longValue() + 1);
            }

            mdUploadFileModel.setId(idMdUpload);
            mdUploadFileModel.setFileIdentifier(newIdentifier);

            if (mdUploadFileController.getDataById(newIdentifier) == null) {
                flag = true;
                id  = idMdUpload;
            } else {
                flag=false;
                id = mdUploadFileController.getDataById(newIdentifier).getId();
            }

            if (flag) {
                ret = mdUploadFileController.saveMdUpload(mdUploadFileModel);
            } else {
                ret = mdUploadFileController.updateMdUpload(id,mdUploadFileModel);
            }

            displayLog(true, "\nMdUploadFile");
            displayLog(true, "id = "+id);
            displayLog(true, "foreign key FileIdentifier = "+newIdentifier);
         
            if(ret.contains("Error")){
               displayLog(false, "Status table MdUploadFile " + ret+"\n");
            }else{
               displayLog(true, "Status table MdUploadFile " +ret+"\n");
            }

        }catch(Exception e){
            
            displayLog(false, "Status table MdUploadFile " + e.toString());
            displayLog(true, "Status table MdUploadFile " +ret+"\n");
        }

    }
    //end save mdupload
    
    public void saveAllMetadata(){
        
        try{
            
            jTextAreaLogData.append("menyimpan elemen metadata enitity information.." + "\n");
            
            String fileIdentifer = varMetadataEntitySetInformation.getFileIdentifier();
            
            MdMetadataModel mdModel = new MdMetadataModel();
            mdModel.setFileidentifier(fileIdentifer);
            mdModel.setCharacterset(varMetadataEntitySetInformation.getCharacterSet());
            mdModel.setStringDate(varMetadataEntitySetInformation.getDateStamp());
            mdModel.setLanguage(varMetadataEntitySetInformation.getLanguage());
            mdModel.setMetadatastandardname(varMetadataEntitySetInformation.getMetadataStandardName());
            mdModel.setMetadatastandardversion(varMetadataEntitySetInformation.getMetadataStandardVersion());
            mdModel.setParentidentifier(varMetadataEntitySetInformation.getParentIdentifier());
            mdModel.setDataseturi(varMetadataEntitySetInformation.getDataSetURI());
            mdModel.setMetadatastandardname(varMetadataEntitySetInformation.getMetadataStandardName());
            mdModel.setMetadatastandardversion(varMetadataEntitySetInformation.getMetadataStandardVersion());            
            
            saveUpdateMdMetadata(MdMetadataModel.FILEIDENTIFIER,mdModel);
            jprocessbar.setValue(2);
            jprocessbar.setStringPainted(true);
                      
            MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
            BigDecimal mdMetadataId = mmc.getDataById(MdMetadataModel.FILEIDENTIFIER,mmc.checkFileidentifier(fileIdentifer)).getId();
       
                saveUpdateMetadataEntitySetInformation(mdMetadataId); //24
                saveUpdateSpatialInformation(mdMetadataId);//30
                saveUpdateReferenceSystemInformation(mdMetadataId);//38
                saveUpdateMetadataExtensionInformation(mdMetadataId);//52
                saveUpdateIdentificationInformation(mdMetadataId);//178
                saveUpdateContentInformation(mdMetadataId);//182
                saveUpdateDataQualityInfo(mdMetadataId);//702
                saveUpdatePortrayalCatalagueInformation(mdMetadataId);//710
                saveUpdateMetadataConstraintsInformation(mdMetadataId);//716
                saveUpdateApplicationSchemaInformation(mdMetadataId);//722
                saveUpdateMaintenanceInformation(mdMetadataId);//724
                saveUpdateDistributionInformation(mdMetadataId);//748
                saveUpdateMetadataUploadInformation(mmc.checkFileidentifier(fileIdentifer));//750
                            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }

    //end save dataquality
    private void saveUpdateMetadataEntitySetInformation(BigDecimal mdMetadataId) {

        try {
                                              
            //md_metadata_hieracylevel            
            MdMetadataHierarchylvModel mmhm = new MdMetadataHierarchylvModel();
            mmhm.setHierarchylevel(varMetadataEntitySetInformation.getHierarchyLevel());
            mmhm.setMdMetadataid(mdMetadataId);
            
            saveUpdateMdMetadataHierarchyLv(mmhm);
            jprocessbar.setValue(4);
            jprocessbar.setStringPainted(true);
            
            //md_metadata_hieracylevelname
            MdMetadataHierarchylvNameModel hierarchylvNameModel = new MdMetadataHierarchylvNameModel();
            hierarchylvNameModel.setHierarchylevelName(varMetadataEntitySetInformation.getHierarchyLevelName());
            hierarchylvNameModel.setMdMetadataid(mdMetadataId);
                        
            saveUpdateMdMetadataHierarchyLvName(hierarchylvNameModel);
            jprocessbar.setValue(6);
            jprocessbar.setStringPainted(true);
            
            //ciresponsibleparty
            CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
            partyModel.setIndividualName(varMetadataEntitySetInformation.getIndividualName());
            partyModel.setOrganisationName(varMetadataEntitySetInformation.getOrganisationName());
            partyModel.setPositionName(varMetadataEntitySetInformation.getPositionName());
            partyModel.setRole(varMetadataEntitySetInformation.getRole());
            partyModel.setMdMetadataId(mdMetadataId);
            
            saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_METADATAID,mdMetadataId,partyModel);
            jprocessbar.setValue(8);
            jprocessbar.setStringPainted(true);
            
                //cicontact
                CiContactModel ccm = new CiContactModel();
                CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                BigDecimal ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_METADATAID, mdMetadataId).getId();

                ccm.setContactInstruction(varMetadataEntitySetInformation.getContactInstructions());
                ccm.setHouseOfService(varMetadataEntitySetInformation.getHoursOfService());
                ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                saveUpdateCiContact(ccm);
                jprocessbar.setValue(10);
                jprocessbar.setStringPainted(true);
            
                    //citelephone
                    CiTelephoneModel ctm = new CiTelephoneModel();
                    CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                    BigDecimal ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();

                    ctm.setCiContactId(ciContactId);

                    saveUpdateCiTelephone(ctm);
                    jprocessbar.setValue(12);
                    jprocessbar.setStringPainted(true);
            
                        //citelephonevoice
                        CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
                        CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                        BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                        ctvm.setVoice(varMetadataEntitySetInformation.getVoice());
                        ctvm.setCiTelephoneId(ciTelephoneId);
            
                        saveUpdateCiTelephoneVoice(ctvm);
                        jprocessbar.setValue(14);
                        jprocessbar.setStringPainted(true);
            
                        //citelephonefacs
                        CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
                        ctfm.setFacsimile(varMetadataEntitySetInformation.getFax());
                        ctfm.setCiTelephoneId(ciTelephoneId);

                        saveUpdateCiTelephoneFacsimile(ctfm);
                        jprocessbar.setValue(16);
                        jprocessbar.setStringPainted(true);
            
                    //ciaddress
                    CiAddressModel cam = new CiAddressModel();
                    cam.setAdmnistrativeArea(varMetadataEntitySetInformation.getAdministrativeArea());
                    cam.setCity(varMetadataEntitySetInformation.getCity());
                    cam.setCountry(varMetadataEntitySetInformation.getCountry());
                    cam.setPostalCode(varMetadataEntitySetInformation.getPostalCode());
                    cam.setCiContactId(ciContactId);
          
                    saveUpdateCiAddress(cam);
                    jprocessbar.setValue(18);
                    jprocessbar.setStringPainted(true);
            
                        //ciaddress_deliverypoint
                        CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
                        CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                        BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                        cadpm.setDeliveryPoint(varMetadataEntitySetInformation.getDeliveryPoint());
                        cadpm.setCi_addressid(ciAddressId);

                        saveUpdateCiAddressDeliveryPoint(cadpm);
                        jprocessbar.setValue(20);
                        jprocessbar.setStringPainted(true);
            
                        //ciaddress_emailaddress
                        CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
                        addressModel.setCi_addressid(ciAddressId);
                        addressModel.setEmailAddress(varMetadataEntitySetInformation.getElectronicMailAddress());

                        saveUpdateCiAddressEmailAddress(addressModel);
                        jprocessbar.setValue(22);
                        jprocessbar.setStringPainted(true);
            
                    //ci_onlineresource
                    CiOnlineResourceModel corm = new CiOnlineResourceModel();
                    corm.setLinkage(varMetadataEntitySetInformation.getLinkage());
                    corm.setApplicationProfile(varMetadataEntitySetInformation.getApplicationProfile());
                    corm.setProtocol(varMetadataEntitySetInformation.getProtocol());
                    corm.setName(varMetadataEntitySetInformation.getNameOnlineResource());
                    corm.setDescription(varMetadataEntitySetInformation.getDescription());
                    corm.setFunction_(varMetadataEntitySetInformation.getFunction());
                    corm.setCiContactId(ciContactId);

                    saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,corm);
                    jprocessbar.setValue(24);
                    jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata Entity Set Information Selesai" + "\n\n");
    }

    private void saveUpdateReferenceSystemInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata reference system information.." + "\n\n");
            
            //mdreferencesytem
            MdReferenceSystemModel mrsm = new MdReferenceSystemModel();
            mrsm.setMdMetadataId(mdMetadataId);
            
            saveUpdateReferenceSystem(MdReferenceSystemModel.MD_METADATAID,mdMetadataId,mrsm);
            
            jprocessbar.setValue(32);
            jprocessbar.setStringPainted(true);
            
                //rsidentifier
                RsIdentifierModel rim = new RsIdentifierModel();
                MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
                BigDecimal mdReferenceSystemId=mrsc.getDataById(MdReferenceSystemModel.MD_METADATAID,mdMetadataId).getId();

                rim.setCode(varReferenceSystem.getCode1());
                rim.setCodeSpace(varReferenceSystem.getCode2());
                rim.setMdReferenceSystemId(mdReferenceSystemId);

                saveUpdateRsIdentifier(RsIdentifierModel.MD_REFERENCESYSTEMID,mdReferenceSystemId,rim);
                jprocessbar.setValue(34);
                jprocessbar.setStringPainted(true);

                    //cicitation 
                    CiCitationModel ccm = new CiCitationModel();
                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                    BigDecimal rsIdentifierId=ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();

                    ccm.setTitle(varReferenceSystem.getTitle());
                    ccm.setRsIdentifierId(rsIdentifierId);
                    
                    saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,ccm);
                    jprocessbar.setValue(36);
                    jprocessbar.setStringPainted(true);
            
                    //cidate
                    CiDateModel cdm = new CiDateModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId=ccc.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();

                    cdm.setStringDate_(varReferenceSystem.getDate_());
                    cdm.setDateType(varReferenceSystem.getDateType());
                    cdm.setCiCitationId(ciCitationId);

                    saveUpdateCiDate(cdm);
                    jprocessbar.setValue(38);
                    jprocessbar.setStringPainted(true);

                    //mdidentifier 

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata Reference System Selesai" + "\n\n");
    }

    private void saveUpdateMaintenanceInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata maintenance information.." + "\n\n");

            MdMaintenanceInfoModel mmim = new MdMaintenanceInfoModel();
            
            mmim.setMaintenanceAndUpdateFrequency(varMaintenanceInformation.getMaintenanceAndUpdateFrequency());
            mmim.setMdMetadataId(mdMetadataId);
            
            SaveUpdateMdMaintenanceInfo(MdMaintenanceInfoModel.MD_METADATAID,mdMetadataId,mmim);
            jprocessbar.setValue(724);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata maintenance information Selesai" + "\n\n");
    }
    
    private void saveUpdateDistributionInformation(BigDecimal mdMetadataId){
    
        try{
            
            jTextAreaLogData.append("menyimpan elemen metadata Distribution Information.." + "\n\n");
            
            MdDistributionModel mdm = new MdDistributionModel();
            mdm.setMdMetadataId(mdMetadataId);
            
            saveUpdateMdDistribution(mdm);
            jprocessbar.setValue(726);
            jprocessbar.setStringPainted(true);
            
                MdDistributionController mdc = new MdDistributionController(session, hibernateUtilXml);
                BigDecimal mdDistributionId = mdc.getDataById(mdMetadataId).getId();

                MdDistributorModel mdr = new MdDistributorModel();
                mdr.setMdDistributionId(mdDistributionId);

                saveUpdateMdDistributor(MdDistributorModel.MD_DISTRIBUTIONID, mdDistributionId, mdr);
                jprocessbar.setValue(728);
                jprocessbar.setStringPainted(true);

                MdDistributorController mdrc = new MdDistributorController(session, hibernateUtilXml);
                BigDecimal mdDistributorId = mdrc.getDataById(MdDistributorModel.MD_DISTRIBUTIONID, mdDistributionId).getId();

                //ciresponsibleparty
                CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
                partyModel.setIndividualName(varDistributionInformation.getIndividualName());
                partyModel.setOrganisationName(varDistributionInformation.getOrganisationName());
                partyModel.setPositionName(varDistributionInformation.getPositionName());
                partyModel.setRole(varDistributionInformation.getRole());
                partyModel.setMdDistributorId(mdDistributorId);

                saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_DISTRIBUTORID,mdDistributorId,partyModel);
                jprocessbar.setValue(730);
                jprocessbar.setStringPainted(true);

                    //cicontact
                    CiContactModel ccm = new CiContactModel();
                    CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                    BigDecimal ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_DISTRIBUTORID,mdDistributorId).getId();

                    ccm.setContactInstruction(varDistributionInformation.getContactInstructions());
                    ccm.setHouseOfService(varDistributionInformation.getHoursOfService());
                    ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                    saveUpdateCiContact(ccm);
                    jprocessbar.setValue(732);
                    jprocessbar.setStringPainted(true);

                        //citelephone
                        CiTelephoneModel ctm = new CiTelephoneModel();
                        CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                        BigDecimal ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();

                        ctm.setCiContactId(ciContactId);

                        saveUpdateCiTelephone(ctm);
                        jprocessbar.setValue(734);
                        jprocessbar.setStringPainted(true);

                            //citelephonevoice
                            CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
                            CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                            BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                            ctvm.setVoice(varDistributionInformation.getVoice());
                            ctvm.setCiTelephoneId(ciTelephoneId);

                            saveUpdateCiTelephoneVoice(ctvm);
                            jprocessbar.setValue(736);
                            jprocessbar.setStringPainted(true);

                            //citelephonefacs
                            CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
                            ctfm.setFacsimile(varDistributionInformation.getFax());
                            ctfm.setCiTelephoneId(ciTelephoneId);

                            saveUpdateCiTelephoneFacsimile(ctfm);
                            jprocessbar.setValue(738);
                            jprocessbar.setStringPainted(true);

                        //ciaddress
                        CiAddressModel cam = new CiAddressModel();
                        cam.setAdmnistrativeArea(varDistributionInformation.getAdministrativeArea());
                        cam.setCity(varDistributionInformation.getCity());
                        cam.setCountry(varDistributionInformation.getCountry());
                        cam.setPostalCode(varDistributionInformation.getPostalCode());
                        cam.setCiContactId(ciContactId);

                        saveUpdateCiAddress(cam);
                        jprocessbar.setValue(740);
                        jprocessbar.setStringPainted(true);

                            //ciaddress_deliverypoint
                            CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
                            CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                            BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                            cadpm.setDeliveryPoint(varDistributionInformation.getDeliveryPoint());
                            cadpm.setCi_addressid(ciAddressId);

                            saveUpdateCiAddressDeliveryPoint(cadpm);
                            jprocessbar.setValue(742);
                            jprocessbar.setStringPainted(true);

                            //ciaddress_emailaddress
                            CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
                            addressModel.setCi_addressid(ciAddressId);
                            addressModel.setEmailAddress(varDistributionInformation.getElectronicMailAddress());

                            saveUpdateCiAddressEmailAddress(addressModel);
                            jprocessbar.setValue(744);
                            jprocessbar.setStringPainted(true);

                        //ci_onlineresource
                        CiOnlineResourceModel corm = new CiOnlineResourceModel();
                        corm.setLinkage(varDistributionInformation.getLinkage());
                        corm.setApplicationProfile(varDistributionInformation.getApplicationProfile());
                        corm.setProtocol(varDistributionInformation.getProtocol());
                        corm.setName(varDistributionInformation.getNameOnlineResource());
                        corm.setDescription(varDistributionInformation.getDescription());
                        corm.setFunction_(varDistributionInformation.getFunction());
                        corm.setCiContactId(ciContactId);

                        saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,corm);
                        jprocessbar.setValue(746);
                        jprocessbar.setStringPainted(true);
                
                MdDigitalTransferOptionsModel mdtom = new MdDigitalTransferOptionsModel();
                mdtom.setStringTransferSize(varDistributionInformation.getTransferSize());
                mdtom.setMdDistributionId(mdDistributionId);
                
                saveUpdateMdDigitalTransferOption(MdDigitalTransferOptionsModel.MD_DISTRIBUTIONID, mdDistributionId, mdtom);
                jprocessbar.setValue(748);
                jprocessbar.setStringPainted(true);
                
                jTextAreaLogData.append("Status Metadata Distribution Information Selesai" + "\n\n");
            
        }catch(NullPointerException n){
                n.printStackTrace();
        }
    }

    private void saveUpdateContentInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata content information.." + "\n");
            
            //mdcontentinfo
            MdContentInfoModel mcim = new MdContentInfoModel();
            mcim.setExtendsType(nullValue);
            mcim.setMdMetadataId(mdMetadataId);
            
            SaveUpdateMdContentInfo(mcim);
            jprocessbar.setValue(180);
            jprocessbar.setStringPainted(true);
            
                //mdcoveragedescription
                MdCoverageDescriptionModel mcdm = new MdCoverageDescriptionModel();
                MdContentInfoController mcic = new MdContentInfoController(session, hibernateUtilXml);
                BigDecimal mdContentInfoId = mcic.getDataById(mdMetadataId).getId();

                mcdm.setAttributeDescription(varContentInfo.getAttributeDescription());
                mcdm.setContentType(varContentInfo.getContentType());
                mcdm.setMdContentInfoId(mdContentInfoId);

                SaveUpdateMdCoverageDescription(mcdm);
                jprocessbar.setValue(182);
                jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata ContentInformation Selesai" + "\n\n");
    }

    private void saveUpdatePortrayalCatalagueInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata portrayal catalogue information.." + "\n");
            
            //mdportrayalcatalogue
            MdPortrayalCatalogueRefModel mpcrm = new MdPortrayalCatalogueRefModel();
            
            mpcrm.setMdMetadataId(mdMetadataId);
            
            SaveUpdateMdPotrayalCatalogueReference(mpcrm);
            jprocessbar.setValue(704);
            jprocessbar.setStringPainted(true);

                //cicitation
                CiCitationModel ccm = new CiCitationModel();
                MdPortrayalCatalogueRefController mpcrc = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
                BigDecimal mdPortarayalCatalogueId = mpcrc.getDataById(mdMetadataId).getId();

                ccm.setTitle(varPotrayalCatalogueInformation.getTitle());
                ccm.setEdition(varPotrayalCatalogueInformation.getEdition());
                ccm.setStringEditionDate(varPotrayalCatalogueInformation.getEditionDate());
                ccm.setMdPortrayalCatalogueRefId(mdPortarayalCatalogueId);

                saveUpdateCiCitation(CiCitationModel.MDPORTRAYALCATALOGUEREFID,mdPortarayalCatalogueId,ccm);
                jprocessbar.setValue(706);
                jprocessbar.setStringPainted(true);
            
                    //citationalternatetitle 
                    CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDPORTRAYALCATALOGUEREFID,mdPortarayalCatalogueId).getId();

                    ccatm.setAlternateTitle(varPotrayalCatalogueInformation.getAlternatetitle());
                    ccatm.setCi_citationid(ciCitationId);

                    saveUpdateCiCitationAlternateTitle(ccatm);
                    jprocessbar.setValue(708);
                    jprocessbar.setStringPainted(true);

                        //cidate
                        CiDateModel cdm = new CiDateModel();  
                        cdm.setStringDate_(varPotrayalCatalogueInformation.getDate_());
                        cdm.setDateType(varPotrayalCatalogueInformation.getDateType());
                        cdm.setCiCitationId(ciCitationId);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(710);
                        jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata PortrayalCatalagueInformation Selesai" + "\n\n");
    }

    private void saveUpdateSpatialInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata spatial information.." + "\n");
     
            //mdspatialrepresentation
            MdSpatialRepresentationModel msrm = new MdSpatialRepresentationModel();
            msrm.setExtendsType(nullValue);
            msrm.setMdMetadataId(mdMetadataId);
            
            saveUpdateMdSpatialRepresentation(msrm);
            jprocessbar.setValue(26);
            jprocessbar.setStringPainted(true);
            
                //mdvectorspatial
                MdVectorSpatialRepresentationModel mvsrm = new MdVectorSpatialRepresentationModel();
                MdSpatialRepresentationController msrc = new MdSpatialRepresentationController(session, hibernateUtilXml);
                BigDecimal mdSpatialId= msrc.getDataById(mdMetadataId).getId();

                mvsrm.setId(mdSpatialId);
                mvsrm.setTopologyLevel(varSpatialRepresentationInformation.getTopologyLevel());

                saveUpdateMdVectorSpatial(mvsrm);
                jprocessbar.setValue(28);
                jprocessbar.setStringPainted(true);
           
                    //mdgeometricobject       
                    MdVectorSpatialRepresentationController mvsrc = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);      
                    MdTopologyLevelCodeController codeController = new MdTopologyLevelCodeController(session, hibernateUtilXml);
                    String code = codeController.getDataByDomain(varSpatialRepresentationInformation.getTopologyLevel()).getCode();
                    BigDecimal mdVectorSpatialId=mvsrc.getDataById(mdSpatialId).getId();

                    saveUpdateMdGeometricObject(mdVectorSpatialId);           
                    jprocessbar.setValue(30);
                    jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata SpatialInformation Selesai" + "\n\n");
    }
    
    private void citation(BigDecimal mdIdentificationId){
    
        try{
            
            //cicitation
            CiCitationModel ccm = new CiCitationModel();
           
            ccm.setTitle(varCitation.getTitle());
            ccm.setEdition(varCitation.getEdition());
            ccm.setOtherCitationDetails(varCitation.getOtherCitationDetails());
            ccm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateCiCitation(CiCitationModel.MDIDENTIFICATIONID,mdIdentificationId,ccm);
            jprocessbar.setValue(72);
            jprocessbar.setStringPainted(true);
            
                    //citationalternatetitle
                    CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFICATIONID,mdIdentificationId).getId();

                    ccatm.setAlternateTitle(varCitation.getAlternateTitle());
                    ccatm.setCi_citationid(ciCitationId);

                    saveUpdateCiCitationAlternateTitle(ccatm);
                    jprocessbar.setValue(74);
                    jprocessbar.setStringPainted(true);

                    //cidate
                    CiDateModel cdm = new CiDateModel();     
                    cdm.setStringDate_(varCitation.getDate());
                    cdm.setDateType(varCitation.getDateType());
                    cdm.setCiCitationId(ciCitationId);

                    saveUpdateCiDate(cdm);
                    jprocessbar.setValue(76);
                    jprocessbar.setStringPainted(true);
                    
                    CiCitationPresentationFormModel ccpfm = new CiCitationPresentationFormModel();
                    ccpfm.setPresentationForm(varCitation.getPresentationForm());
                    ccpfm.setCiCitationId(ciCitationId);
                    
                    SaveUpdateCitationPresentationForm(ccpfm);
                    jprocessbar.setValue(78);
                    jprocessbar.setStringPainted(true);
                    
                    CiResponsiblePartyModel crpm = new CiResponsiblePartyModel();
                    crpm.setIndividualName(varCitation.getIndividualName());
                    crpm.setOrganisationName(varCitation.getOrganisationName());
                    crpm.setPositionName(varCitation.getPositionName());
                    crpm.setRole(varCitation.getRole());
                    crpm.setCiCitationId(ciCitationId);
                    
                    saveUpdateCiResponsibleParty(CiResponsiblePartyModel.CI_CITATIONID, ciCitationId, crpm);
                    jprocessbar.setValue(80);
                    jprocessbar.setStringPainted(true);

                    //mdidentifier
                    MdIdentifierModel mim = new MdIdentifierModel();
                    mim.setCode(varCitation.getCode());
                    mim.setCiCitationId(ciCitationId);
                    mim.setExtendsType(nullValue);

                    saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, ciCitationId, mim);
                    jprocessbar.setValue(82);
                    jprocessbar.setStringPainted(true);
            
                        //rsidentifier
                        RsIdentifierModel rim = new RsIdentifierModel();
                        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                        BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();

                        rim.setCode(varCitation.getCode());
                        rim.setMdIdentifierId(mdIdentifierId);
            
                        saveUpdateRsIdentifier(RsIdentifierModel.MD_IDENTIFIERID,mdIdentifierId,rim);
                        jprocessbar.setValue(84);
                        jprocessbar.setStringPainted(true);

                            //cicitation
                            CiCitationModel citationModel = new CiCitationModel();
                            RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                            BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID,mdIdentifierId).getId();

                            citationModel.setTitle(varCitation.getTitleCitationIdentifier());
                            citationModel.setRsIdentifierId(rsIdentifierId);

                            saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,citationModel);
                            jprocessbar.setValue(86);
                            jprocessbar.setStringPainted(true);
            
                                //cidate
                                CiDateModel cd = new CiDateModel();
                                BigDecimal ciCitationIdentifierId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();

                                cd.setStringDate_(varCitation.getDateCiDateIdentifier());
                                cd.setDateType(varCitation.getDateTypeCiDateIdentifier());
                                cd.setCiCitationId(ciCitationIdentifierId);

                                saveUpdateCiDate(cd);
                                jprocessbar.setValue(88);
                                jprocessbar.setStringPainted(true);
                        
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
            
            
    }
     
    private void pointOfContact(BigDecimal mdIdentificationId){
    
        try{
            
            //ciresponsibleparty
            CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
            partyModel.setIndividualName(varPointOfContact.getIndividualName());
            partyModel.setOrganisationName(varPointOfContact.getOrganisationName());
            partyModel.setPositionName(varPointOfContact.getPositionName());
            partyModel.setRole(varPointOfContact.getRole());
            partyModel.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_IDENTIFICATIONID,mdIdentificationId,partyModel);
            jprocessbar.setValue(90);
            jprocessbar.setStringPainted(true);
            
                //cicontact
                CiContactModel ccm = new CiContactModel();
                CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                BigDecimal ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_IDENTIFICATIONID,mdIdentificationId).getId();

                ccm.setContactInstruction(varPointOfContact.getContactInstructions());
                ccm.setHouseOfService(varPointOfContact.getHoursOfService());
                ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                saveUpdateCiContact(ccm);
                jprocessbar.setValue(92);
                jprocessbar.setStringPainted(true);

                    //citelephone
                    CiTelephoneModel ctm = new CiTelephoneModel();
                    CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                    BigDecimal ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();

                    ctm.setCiContactId(ciContactId);

                    saveUpdateCiTelephone(ctm);
                    jprocessbar.setValue(94);
                    jprocessbar.setStringPainted(true);

                        //citelephonevoice
                        CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
                        CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                        BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                        ctvm.setVoice(varPointOfContact.getVoice());
                        ctvm.setCiTelephoneId(ciTelephoneId);

                        saveUpdateCiTelephoneVoice(ctvm);
                        jprocessbar.setValue(96);
                        jprocessbar.setStringPainted(true);
            
                        //citelephonefacs
                        CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
                        ctfm.setFacsimile(varPointOfContact.getFax());
                        ctfm.setCiTelephoneId(ciTelephoneId);

                        saveUpdateCiTelephoneFacsimile(ctfm);
                        jprocessbar.setValue(98);
                        jprocessbar.setStringPainted(true);
            
                    //ciaddress
                    CiAddressModel cam = new CiAddressModel();
                    cam.setAdmnistrativeArea(varPointOfContact.getAdministrativeArea());
                    cam.setCity(varPointOfContact.getCity());
                    cam.setCountry(varPointOfContact.getCountry());
                    cam.setPostalCode(varPointOfContact.getPostalCode());
                    cam.setCiContactId(ciContactId);
          
                    saveUpdateCiAddress(cam);
                    jprocessbar.setValue(100);
                    jprocessbar.setStringPainted(true);
            
                        //ciaddress_deliverypoint
                        CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
                        CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                        BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                        cadpm.setDeliveryPoint(varPointOfContact.getDeliveryPoint());
                        cadpm.setCi_addressid(ciAddressId);

                        saveUpdateCiAddressDeliveryPoint(cadpm);
                        jprocessbar.setValue(102);
                        jprocessbar.setStringPainted(true);

                        //ciaddress_emailaddress
                        CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
                        addressModel.setCi_addressid(ciAddressId);
                        addressModel.setEmailAddress(varPointOfContact.getElectronicMailAddress());

                        saveUpdateCiAddressEmailAddress(addressModel);
                        jprocessbar.setValue(104);
                        jprocessbar.setStringPainted(true);

                    //ci_onlineresource
                    CiOnlineResourceModel corm = new CiOnlineResourceModel();
                    corm.setLinkage(varPointOfContact.getLinkage());
                    corm.setApplicationProfile(varPointOfContact.getApplicationProfile());
                    corm.setProtocol(varPointOfContact.getProtocol());
                    corm.setName(varPointOfContact.getNameOnlineResource());
                    corm.setDescription(varPointOfContact.getDescription());
                    corm.setFunction_(varPointOfContact.getFunction());
                    corm.setCiContactId(ciContactId);

                    saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,corm);
                    jprocessbar.setValue(106);
                    jprocessbar.setStringPainted(true);

            
        }catch(NullPointerException n){
                n.printStackTrace();
        }
    }
    
    private void resourceMaintenance(BigDecimal mdIdentificationId){
    
        try {

            MdMaintenanceInfoModel mmim = new MdMaintenanceInfoModel();
            
            mmim.setMaintenanceAndUpdateFrequency(varResourceMaintenance.getMaintenanceAndUpdateFrequency());
            mmim.setMdIdentificationId(mdIdentificationId);
            
            SaveUpdateMdMaintenanceInfo(MdMaintenanceInfoModel.MD_IDENTIFICATIONID,mdIdentificationId,mmim);
            jprocessbar.setValue(108);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }
    
    }
    
    private void graphicOverview(BigDecimal mdIdentificationId){
    
        try{
            
            MdBrowseGraphicModel mbgm = new MdBrowseGraphicModel();
            
            mbgm.setFileName(varMdBrowseGraphic.getFileName());
            mbgm.setFileType(varMdBrowseGraphic.getFileType());
            mbgm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdBrowseGraphic(mbgm);
            jprocessbar.setValue(110);
            jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
   
    }
    
    private void resourceFormat(BigDecimal mdIdentificationId){
    
        
        try{
            
            MdFormatModel mfm = new MdFormatModel();
            mfm.setName(varMdFormat.getName());
            mfm.setVersion(varMdFormat.getVersion());
            mfm.setSpesification(varMdFormat.getSpesification());
            mfm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdFormat(MdFormatModel.MD_IDENTIFICATIONID,mdIdentificationId,mfm);
            jprocessbar.setValue(112);
            jprocessbar.setStringPainted(true);
            
                MdDistributorModel mdm = new MdDistributorModel();
                MdFormatController mfc = new MdFormatController(session, hibernateUtilXml);
                BigDecimal mdFormatId = mfc.getDataById(MdFormatModel.MD_IDENTIFICATIONID,mdIdentificationId).getId();

                mdm.setMdFormatId(mdFormatId);

                saveUpdateMdDistributor(MdDistributorModel.MD_FORMATID,mdFormatId,mdm);
                jprocessbar.setValue(114);
                jprocessbar.setStringPainted(true);
            
                    //ciresponsibleparty
                   CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
                   MdDistributorController mdc = new MdDistributorController(session, hibernateUtilXml);

                   BigDecimal mdDistributorId = mdc.getDataById(MdDistributorModel.MD_FORMATID,mdFormatId).getId();

                   partyModel.setIndividualName(varMdFormat.getIndividualName());
                   partyModel.setOrganisationName(varMdFormat.getOrganisationName());
                   partyModel.setPositionName(varMdFormat.getPositionName());
                   partyModel.setRole(varMdFormat.getRole());
                   partyModel.setMdDistributorId(mdDistributorId);

                   saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_DISTRIBUTORID,mdDistributorId,partyModel);
                   jprocessbar.setValue(116);
                   jprocessbar.setStringPainted(true);
            
                        //cicontact
                        CiContactModel ccm = new CiContactModel();
                        CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                        BigDecimal ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_DISTRIBUTORID,mdDistributorId).getId();

                        ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                        saveUpdateCiContact(ccm);
                        jprocessbar.setValue(118);
                        jprocessbar.setStringPainted(true);
            
                            //ci_onlineresource
                            CiOnlineResourceModel corm = new CiOnlineResourceModel();
                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);

                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();

                            corm.setLinkage(varMdFormat.getLinkage());
                            corm.setCiContactId(ciContactId);
            
                            saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,corm);
                            jprocessbar.setValue(120);
                            jprocessbar.setStringPainted(true);

                    //md_digitaltransferopt
                    MdDigitalTransferOptionsModel mdtom = new MdDigitalTransferOptionsModel();

                    mdtom.setMdDistributorId(mdDistributorId);

                    saveUpdateMdDigitalTransferOption(MdDigitalTransferOptionsModel.MD_DISTRIBUTORID,mdDistributorId,mdtom);
                    jprocessbar.setValue(122);
                    jprocessbar.setStringPainted(true);
            
                        //ci_onlineresource
                        CiOnlineResourceModel resourceModel = new CiOnlineResourceModel();
                        MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);

                        BigDecimal mdDigitalTransferOptions = mdtoc.getDataById(MdDigitalTransferOptionsModel.MD_DISTRIBUTORID,mdDistributorId).getId();

                        resourceModel.setLinkage(varMdFormat.getOnlineLinkage());
                        resourceModel.setFunction_(varMdFormat.getFunction());
                        resourceModel.setMdDigitalTransferOptionsId(mdDigitalTransferOptions);

                        saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.MD_DIGITALTRANSFEROPTIONID,mdDigitalTransferOptions,resourceModel);
                        jprocessbar.setValue(124);
                        jprocessbar.setStringPainted(true);

                        //md_medium
                        MdMediumModel mmm = new MdMediumModel();
                        mmm.setName(varMdFormat.getNameDigitalTransferOption());
                        mmm.setDensityUnits(varMdFormat.getDensityUnits());
                        mmm.setMdDigitalTransferOptionsId(mdDigitalTransferOptions);

                        saveUpdateMdMedium(mmm);
                        jprocessbar.setValue(126);
                        jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void descriptiveKeywords(BigDecimal mdIdentificationId){
    
        try{
            
            //mdkeyword
            MdKeywordModel mkm = new MdKeywordModel();
            mkm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdKeyword(mkm);
            jprocessbar.setValue(128);
            jprocessbar.setStringPainted(true);
            
                //mdkeyword
                saveUpdateMdKeywordKeyword(mdIdentificationId);
                jprocessbar.setValue(130);
                jprocessbar.setStringPainted(true);
            
                    MdKeywordController mkc = new MdKeywordController(session, hibernateUtilXml);
                    List list = (List) mkc.getListOfId(mdIdentificationId);            

                    //cicitation
                    saveUpdateThesaurusNameCitation(list);
                    jprocessbar.setValue(132);
                    jprocessbar.setStringPainted(true);
            
                        //cidate
                        saveUpdateCitationDateThesaurusName(list);
                        jprocessbar.setValue(134);
                        jprocessbar.setStringPainted(true);
            
                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal citationId = ccc.getDataById(CiCitationModel.MDKEYWORDID, new BigDecimal(list.get(0).toString())).getId();

                         //mdidentifier
                        MdIdentifierModel mim = new MdIdentifierModel();          
                        mim.setCode(varDescriptiveKeywords.getCode());
                        mim.setCiCitationId(citationId);
                        mim.setExtendsType(nullValue);

                        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationId, mim);
                        jprocessbar.setValue(136);
                        jprocessbar.setStringPainted(true);
            
                            //rsidentifier
                            RsIdentifierModel rim = new RsIdentifierModel();
                            MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                            BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, citationId).getId();

                            rim.setCode(varDescriptiveKeywords.getCode());
                            rim.setMdIdentifierId(mdIdentifierId);

                            saveUpdateRsIdentifier(RsIdentifierModel.MD_IDENTIFIERID,mdIdentifierId,rim);
                            jprocessbar.setValue(138);
                            jprocessbar.setStringPainted(true);
            
                                //cicitation
                                CiCitationModel citationModel = new CiCitationModel();
                                RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                                BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID,mdIdentifierId).getId();

                                citationModel.setTitle(varDescriptiveKeywords.getTitle());
                                citationModel.setRsIdentifierId(rsIdentifierId);

                                saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,citationModel);
                                jprocessbar.setValue(140);
                                jprocessbar.setStringPainted(true);

                                    //cidate
                                    CiDateModel cd = new CiDateModel();
                                    BigDecimal ciCitationIdentifierId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();

                                    cd.setStringDate_(varDescriptiveKeywords.getDate());
                                    cd.setDateType(varDescriptiveKeywords.getDateType());
                                    cd.setCiCitationId(ciCitationIdentifierId);

                                    saveUpdateCiDate(cd);
                                    jprocessbar.setValue(142);
                                    jprocessbar.setStringPainted(true);
            
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void resourceConstraints(BigDecimal mdIdentificationId){
    
        try{
           
              //mdconstaints
              MdConstraintsModel mcm = new MdConstraintsModel();
              
              mcm.setMdIdentificationId(mdIdentificationId);
              mcm.setExtendsType(nullValue);
              
              saveUpdateMetadataConstraints(MdConstraintsModel.MD_IDENTIFICATIONID,mdIdentificationId,mcm);
              jprocessbar.setValue(144);
              jprocessbar.setStringPainted(true);
              
                //mdconstraintsuselimitation
                MdConstraintsUselimitationModel mcum = new MdConstraintsUselimitationModel();
                MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
                BigDecimal mdConstraintsId= mcc.getDataById(MdConstraintsModel.MD_IDENTIFICATIONID,mdIdentificationId).getId();

                mcum.setUseLimitation(varResourceConstraints.getUseLimitation());
                mcum.setMdConstraintsId(mdConstraintsId);

                saveUpdateMetadataConstraintsUseLimitation(mcum);
                jprocessbar.setValue(146);
                jprocessbar.setStringPainted(true);
                
                //mdsecurityconstraints
                MdSecurityConstraintsModel mscm = new MdSecurityConstraintsModel();
                mscm.setClassification(varResourceConstraints.getClassification());
                mscm.setClassificationSystem(varResourceConstraints.getClassificationSystem());
                mscm.setUserNote(varResourceConstraints.getUserNote());
                mscm.setMdConstraintsId(mdConstraintsId);
                    
                saveUpdateMdSecurityConstraints(mscm);
                jprocessbar.setValue(148);
                jprocessbar.setStringPainted(true);
                
                MdLegalConstraintsModel mlcm = new MdLegalConstraintsModel();
                mlcm.setMdConstraintsId(mdConstraintsId);
                
                saveUpdateMdLegalConstraints(mlcm);
                jprocessbar.setValue(150);
                jprocessbar.setStringPainted(true);
                
                MdLegalConstraintsController mlcc = new MdLegalConstraintsController(session, hibernateUtilXml);
                BigDecimal mdLegalConstraintsId = mlcc.getDataById(mdConstraintsId).getMdConstraintsId();

                MdLegalConstraintsOtherModel mlcom = new MdLegalConstraintsOtherModel();
                mlcom.setOtherConstraints(varResourceConstraints.getOtherConstraints());
                mlcom.setMdLegalConstraintsId(mdLegalConstraintsId);
                  
                saveUpdateMdLegalConstraintsOther(mlcom);
                jprocessbar.setValue(152);
                jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    private void aggregationInfo(BigDecimal mdIdentificationId){
    
        try{
                      
            //mdaggregationinfo
            MdAggregateInfoModel maim = new MdAggregateInfoModel();
            maim.setAssositionType(varAggregationInfo.getDS_AssociationTypeCode());
            maim.setInitiativeType(varAggregationInfo.getDS_InitiativeTypeCode());
            maim.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdAggregationInformation(maim);
            jprocessbar.setValue(158);
            jprocessbar.setStringPainted(true);
            
                //cicitation
                CiCitationModel ccm = new CiCitationModel();
                MdAggregateInfoController maic = new MdAggregateInfoController(session, hibernateUtilXml);      
                BigDecimal mdAggregateInfoId = maic.getDataById(mdIdentificationId).getId();

                ccm.setTitle(varAggregationInfo.getTitle());
                ccm.setMdAggregateInfoId(mdAggregateInfoId);

                saveUpdateCiCitation(CiCitationModel.MDAGGREGATEINFOID,mdAggregateInfoId,ccm);
                jprocessbar.setValue(160);
                jprocessbar.setStringPainted(true);
            
                    //cidate
                    CiDateModel cd = new CiDateModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationSetName = ccc.getDataById(CiCitationModel.MDAGGREGATEINFOID,mdAggregateInfoId).getId();

                    cd.setStringDate_(varAggregationInfo.getDate());
                    cd.setDateType(varAggregationInfo.getDateType());
                    cd.setCiCitationId(ciCitationSetName);

                    saveUpdateCiDate(cd);
                    jprocessbar.setValue(162);
                    jprocessbar.setStringPainted(true);

                //mdidentifier
                MdIdentifierModel mim = new MdIdentifierModel();
                mim.setCode(varAggregationInfo.getCode());
                mim.setMdAggregationInfoId(mdAggregateInfoId);
                mim.setExtendsType(nullValue);

                saveUpdateMdIdentifier(MdIdentifierModel.MDAGGREGATEINFOID, mdAggregateInfoId, mim);
                jprocessbar.setValue(164);
                jprocessbar.setStringPainted(true);
            
                    //cicitation
                    CiCitationModel citationModel = new CiCitationModel();
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.MDAGGREGATEINFOID, mdAggregateInfoId).getId();

                    citationModel.setTitle(varAggregationInfo.getTitleIdentifier());
                    citationModel.setMdIdentifierId(mdIdentifierId);

                    saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierId,citationModel);
                    jprocessbar.setValue(166);
                    jprocessbar.setStringPainted(true);
                        
                        //cidate
                        CiDateModel cdm = new CiDateModel();
                        BigDecimal ciCitationSetIdentifier = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierId).getId();

                        cdm.setStringDate_(varAggregationInfo.getDateIdentifier());
                        cdm.setDateType(varAggregationInfo.getDateTypeIdentifier());
                        cdm.setCiCitationId(ciCitationSetIdentifier);

                        saveUpdateCiDate(cdm);
                        jprocessbar.setValue(168);
                        jprocessbar.setStringPainted(true);
                        

        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void spatialResolution(BigDecimal mdDataIdentificationId){
    
        try{
            
            //mdresolution
            MdResolutionModel mrm = new MdResolutionModel();
            
            mrm.setMdDataIdentificationId(mdDataIdentificationId);
            
            saveUpdateMdResolution(mrm);
            jprocessbar.setValue(154);
            jprocessbar.setStringPainted(true); 
            
                MdRepresentativeFractionModel mrfm = new MdRepresentativeFractionModel();
                MdResolutionController mrc = new MdResolutionController(session, hibernateUtilXml);
                BigDecimal mdResolutionId = mrc.getDataById(mdDataIdentificationId).getId();

                mrfm.setStringDenominator(varSpatialResolution.getDenominator());
                mrfm.setMdResolutionId(mdResolutionId);

                saveUpdateMdRepresentativeFraction(MdRepresentativeFractionModel.MD_RESOLUTIONID,mdResolutionId,mrfm);
                jprocessbar.setValue(156);
                jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void extent(BigDecimal mdDataIdentificationId){
    
        try{
               
            //ex_extent 
            ExExtentModel eem = new ExExtentModel();
            eem.setDescription(varExtent.getDescription());
            eem.setMdDataIdentificationId(mdDataIdentificationId);
            
            saveUpdateExExtent(ExExtentModel.MD_DATAIDENTIFICATIONID,mdDataIdentificationId,eem);
            jprocessbar.setValue(170);
            jprocessbar.setStringPainted(true);
            
                //ex_geographicextent
               ExGeographicExtentModel egem = new ExGeographicExtentModel();
               ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
               BigDecimal exExtentId = eec.getDataById(ExExtentModel.MD_DATAIDENTIFICATIONID,mdDataIdentificationId).getId();

               egem.setExExtentId(exExtentId);
               egem.setExtendsType(nullValue);
               egem.setStringExtentTypeCode(varExtent.getExtentTypeCode());

               saveUpdateExExtentGeographicExtent(ExGeographicExtentModel.EX_EXTENTID,exExtentId,egem);
               jprocessbar.setValue(172);
               jprocessbar.setStringPainted(true);

                    //ex_extent_boundingbox
                   ExGeographicBoundingBoxModel boxModel = new ExGeographicBoundingBoxModel();
                   ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
                   BigDecimal exGeographicExtentId = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();

                   boxModel.setEastBoundLongitudeString(varExtent.getEastBoundLongitude());
                   boxModel.setNorthBoundLongitudString(varExtent.getNorthBoundLatitude());
                   boxModel.setSouthBoundLongitudeString(varExtent.getSouthBoundLatitude());
                   boxModel.setWestBoundLongitudeString(varExtent.getWestBoundLongitude());
                   boxModel.setExGeographicExtentId(exGeographicExtentId);

                   saveUpdateExExtentGeographicBoundingBox(boxModel);
                   jprocessbar.setValue(174);
                   jprocessbar.setStringPainted(true);

                //ex_extenttemporal
               ExTemporalExtentModel etem = new ExTemporalExtentModel();    
               etem.setExExtendId(exExtentId);
               etem.setExtendsType(nullValue);

               saveUpdateExTemporalExtent(etem);
               jprocessbar.setValue(176);
               jprocessbar.setStringPainted(true);
            
                //ex_extentvertical
               ExVerticalExtentModel evem = new ExVerticalExtentModel();
               evem.setExExtentId(exExtentId);

               saveUpdateExExtentVerticalExtent(evem);
               jprocessbar.setValue(178);
               jprocessbar.setStringPainted(true);
            
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }

    private void saveUpdateIdentificationInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata identification information.." + "\n");
            
            //root
            //mdidentification
            MdIdentificationModel mim = new MdIdentificationModel();
            
            mim.setAbstract_(varIdentificationInformation.getAbstract_());
            mim.setExtendsType(nullValue);
            mim.setPurpose(varIdentificationInformation.getPurpose());
            mim.setMdMetadataId(mdMetadataId);
            
            saveUpdateMdIdentification(mim);
            jprocessbar.setValue(54);
            jprocessbar.setStringPainted(true);
            
                //mdidentificationstatus
                MdIdentificationStatusModel mism = new MdIdentificationStatusModel();
                MdIdentificationController mic = new MdIdentificationController(session, hibernateUtilXml);
                BigDecimal mdIdentificationId = mic.getDataById(mdMetadataId).getId();

                mism.setStatus(varIdentificationInformation.getStatus());
                mism.setMdIdentificationId(mdIdentificationId);

                saveUpdateMdIdentificationStatus(mism);
                jprocessbar.setValue(56);
                jprocessbar.setStringPainted(true);
                
                //mdidentificationcredit
                MdIdentificationCreditModel micm = new MdIdentificationCreditModel();

                micm.setCredit(varIdentificationInformation.getCredit());
                micm.setMdIdentificationId(mdIdentificationId);

                saveUpdateMdIdentificationCredit(micm);
                jprocessbar.setValue(58);
                jprocessbar.setStringPainted(true);
            
                //svserviceidentification
                SvServiceIdentificationModel ssim = new SvServiceIdentificationModel();          
                ssim.setAbstract_(varIdentificationInformation.getAbstract_());
                ssim.setPurpose(varIdentificationInformation.getPurpose());
                ssim.setStatus(varIdentificationInformation.getStatus());
                ssim.setMdIdentificationId(mdIdentificationId);

                saveUpdateSvServiceIdentification(ssim);
                jprocessbar.setValue(60);
                jprocessbar.setStringPainted(true);
            
                //mddataidentification
                MdDataIdentificationModel mdim = new MdDataIdentificationModel();
                SvServiceIdentificationController ssic = new SvServiceIdentificationController(session, hibernateUtilXml);     
                BigDecimal svServiceIdentificationId = ssic.getDataById(mdIdentificationId).getId();

                mdim.setSuplementationInformation(varIdentificationInformation.getSupplementallnformation());
                mdim.setEnvironmentDescription(varIdentificationInformation.getEnvironmentDescription());
                mdim.setSvServiceidentificationId(svServiceIdentificationId);
                mdim.setId(mdIdentificationId);

                saveUpdateMdDataIdentification(mdim);
                jprocessbar.setValue(62);
                jprocessbar.setStringPainted(true);  
            
                    //mdidentificationspatrep
                    MdDataIdentificationSpatrepModel mdism = new MdDataIdentificationSpatrepModel();
                    MdDataIdentificationController mdic = new MdDataIdentificationController(session, hibernateUtilXml);

                    BigDecimal mdDataIdentificationId=mdic.getDataById(mdIdentificationId).getId();

                    mdism.setSpatialRepresentationType(varSpatialRepresentationType.getMD_SpatialRepresentationTypeCode());
                    mdism.setMdDataIdentificationId(mdDataIdentificationId);

                    saveUpdateMdDataIdentificationSpatrep(mdism);
                    jprocessbar.setValue(64);
                    jprocessbar.setStringPainted(true);

                    //mdidentificationlang
                    MdDataIdentificationLangModel langModel = new MdDataIdentificationLangModel();
                    langModel.setLanguage(varIdentificationInformation.getLanguage());
                    langModel.setMdDataIdentificationId(mdDataIdentificationId);

                    saveUpdateMdDataIdentificationLang(langModel);
                    jprocessbar.setValue(66);
                    jprocessbar.setStringPainted(true);

                    //mdidentificationcharset
                    MdDataIdentificationCharsetModel charsetModel = new MdDataIdentificationCharsetModel();
                    charsetModel.setCharacterSet(varIdentificationInformation.getCharacterSet());
                    charsetModel.setMdDataIdentificationId(mdDataIdentificationId);

                    saveUpdateMdDataIdentificationCharset(charsetModel);
                    jprocessbar.setValue(68);
                    jprocessbar.setStringPainted(true);

                    //mdidentificationtopcat
                    MdDataIdentificationTopcatModel mditm = new MdDataIdentificationTopcatModel();
                    mditm.setTopicCategory(varIdentificationInformation.getTopicCategory());
                    mditm.setMdDataIdentificationId(mdDataIdentificationId);

                    saveUpdateMdDataIdentificationTopCat(mditm);
                    jprocessbar.setValue(70);
                    jprocessbar.setStringPainted(true);
            //end root

                //citation
                citation(mdIdentificationId);//88
                //end citation

                //point of contact
                pointOfContact(mdIdentificationId);//106
                //end pointofcontact

                //resource maintenance
                resourceMaintenance(mdIdentificationId);//108
                //resource maintenance

                //graphicOverview
                graphicOverview(mdIdentificationId);//110
                //end graphicOverview

                //resource format
                resourceFormat(mdIdentificationId);//126
                //resource format

                //descriptivekeyword
                descriptiveKeywords(mdIdentificationId);//142
                //end descriptivekeyword

                //md_constraints
                resourceConstraints(mdIdentificationId);//152
                //end md_constraints

                //spatialresolution
                spatialResolution(mdDataIdentificationId);//156
                //end spatialresolution

                //md_aggregationinfo
                aggregationInfo(mdIdentificationId);  //168
                //end md_aggregationinfo

                //ex_extent
                extent(mdDataIdentificationId);//178
                //end ex_extent

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata IdentificationInformation Selesai" + "\n\n");
    }

    private void saveUpdateDataQualityInfo(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata data quality information.." + "\n");
            
            DqDataQualityModel ddqm = new DqDataQualityModel();
            
            ddqm.setMdMetadataId(mdMetadataId);
            
            saveUpdateDqDataQuality(ddqm);
            jprocessbar.setValue(184);
            jprocessbar.setStringPainted(true);
            
            DqDataQualityController ddqc = new DqDataQualityController(session, hibernateUtilXml);
            BigDecimal dqDataQualityId = ddqc.getDataById(mdMetadataId).getId();
            
                saveUpdateDqScopeGroup(dqDataQualityId);//192
                saveUpdateDqCompleteness(dqDataQualityId);//262
                saveUpdateDqLogicalConsistency(dqDataQualityId);//390
                saveUpdateDqPositionalAccuracy(dqDataQualityId);//472
                saveUpdateDqTemporalAccuracy(dqDataQualityId);//554
                saveUpdateDqThematicAccuracy(dqDataQualityId);//642
                saveUpdateLiLineageGroup(dqDataQualityId);//702
                
                
           
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("Status Metadata DataQuality Selesai" + "\n\n");
    }
    
    private void saveUpdateDqLogicalConsistency(BigDecimal dqDataQualityId) {
         
        try{
        
            DqLogicalConsistencyModel dlcm = new DqLogicalConsistencyModel();
            dlcm.setDqDataQualityId(dqDataQualityId);

            saveUpdateDqLogicalconsistency(dlcm);
            jprocessbar.setValue(264);
            jprocessbar.setStringPainted(true);

            DqLogicalConsistencyController dlcc = new DqLogicalConsistencyController(session, hibernateUtilXml);
            BigDecimal dqLogicalConsitencyId = dlcc.getDataById(dqDataQualityId).getId();

                saveUpdateDqConcconsisGroup(dqLogicalConsitencyId,dqDataQualityId);//286
                saveUpdateDqDomconsisGroup(dqLogicalConsitencyId,dqDataQualityId);//318
                saveUpdateDqFormconsisGroup(dqLogicalConsitencyId,dqDataQualityId);//348
                saveUpdateDqTopconsisGroup(dqLogicalConsitencyId,dqDataQualityId);//390
                
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }

    private void saveUpdateDqCompleteness(BigDecimal dqDataQualityId) {
        
        try{
        
            DqCompletenessModel dcm = new DqCompletenessModel();
            dcm.setDqDataQualityId(dqDataQualityId);

            saveUpdateDqCompleteness(dcm);
            jprocessbar.setValue(194);
            jprocessbar.setStringPainted(true);
                
            DqCompletenessController dcc = new DqCompletenessController(session, hibernateUtilXml);
            BigDecimal dqCompletenessId =  dcc.getDataById(dqDataQualityId).getId(); 

                saveUpdateDqCompcommGroup(dqDataQualityId,dqCompletenessId);//232
                saveUpdateDqCompomGroup(dqDataQualityId,dqCompletenessId);//262
       
         }catch(NullPointerException n){
            n.printStackTrace();
        }
    }

    private void saveUpdateDqPositionalAccuracy(BigDecimal dataQualityId) {
        
        
        try{
                //DqPositionalAccuracy
                DqPositionalAccuracyModel dpam = new DqPositionalAccuracyModel();
                dpam.setDqDataQualityId(dataQualityId);

                saveUpdateDqPositionalAccuracy(dpam);
                jprocessbar.setValue(392);
                jprocessbar.setStringPainted(true);

                DqPositionalAccuracyController dpac = new DqPositionalAccuracyController(session, hibernateUtilXml);
                BigDecimal dqPositionalAccuracyId = dpac.getDataById(dataQualityId).getId();

                    saveUpdateDqAbsextPosAccGroup(dqPositionalAccuracyId,dataQualityId);//422
                    saveUpdateDqGridDataPosAccGroup(dqPositionalAccuracyId,dataQualityId);//452
                    saveUpdateDqRellntPosAccGroup(dqPositionalAccuracyId,dataQualityId);//472
                    
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }

    private void saveUpdateDqTemporalAccuracy(BigDecimal dqDataQualityId) {
        
        try{
            //DqTemporalAccuracy
            DqTemporalAccuracyModel dtam = new DqTemporalAccuracyModel();
            dtam.setDqDataQualityId(dqDataQualityId);

            saveUpdateDqTemporalAccuracy(dtam);
            jprocessbar.setValue(474);
            jprocessbar.setStringPainted(true);

            DqTemporalAccuracyController dtac = new DqTemporalAccuracyController(session, hibernateUtilXml); 
            BigDecimal dqTemporalAccuracyId = dtac.getDataById(dqDataQualityId).getId();

                saveUpdateDqAccTimeMeAsGroup(dqTemporalAccuracyId,dqDataQualityId);//504
                saveUpdateDqTempConsisGroup(dqTemporalAccuracyId,dqDataQualityId);//524
                saveUpdateDqTempValidGroup(dqTemporalAccuracyId,dqDataQualityId);//554
                
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }

    private void saveUpdateDqThematicAccuracy(BigDecimal dqDataQualityId) {
        
        try{
            DqThematicAccuracyModel dtam = new DqThematicAccuracyModel();
            dtam.setDqDataQualityId(dqDataQualityId);

            saveUpdateDqThematicAccuracy(dtam);
            jprocessbar.setValue(556);
            jprocessbar.setStringPainted(true);

            DqThematicAccuracyController dtac = new DqThematicAccuracyController(session, hibernateUtilXml);
            BigDecimal dqThematicAccuracyId = dtac.getDataById(dqDataQualityId).getId();

                saveUpdateDqThemClassCorGroup(dqThematicAccuracyId,dqDataQualityId);//592
                saveUpdateDqNonQuanAttaccGroup(dqThematicAccuracyId,dqDataQualityId);//612
                saveUpdateDqQuanAttaccGroup(dqThematicAccuracyId,dqDataQualityId);//642
                
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    private void saveUpdateMetadataExtensionInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata extension information.." + "\n");
            
            //metadataextensionsinfo
            MdMetadataExtensionInfoModel mmeim = new MdMetadataExtensionInfoModel();
            
            mmeim.setMdMetadataId(mdMetadataId);
            
            saveUpdateMdMetadataExtensionInfo(mmeim);
            jprocessbar.setValue(40);
            jprocessbar.setStringPainted(true);

                //cionlineresource
                CiOnlineResourceModel corm = new CiOnlineResourceModel();
                MdMetadataExtensionInfoController mmeic = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
                BigDecimal mdMetadataExtensionId = mmeic.getDataById(mdMetadataId).getId();

                corm.setLinkage(varMetadataExtensionInformation.getLinkage());
                corm.setMdMetadataExtensionInfoId(mdMetadataExtensionId);

                saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.MD_METADATAEXTENSIONINFOID,mdMetadataExtensionId,corm);
                jprocessbar.setValue(42);
                jprocessbar.setStringPainted(true);
            
                //md_extendedelementinfo
                MdExtendedElementInfoModel meeim = new MdExtendedElementInfoModel();
                meeim.setName(varMetadataExtensionInformation.getName());
                meeim.setShortname(varMetadataExtensionInformation.getShortName());
                meeim.setDefinition(varMetadataExtensionInformation.getDefinition());
                meeim.setStringDomainCode(varMetadataExtensionInformation.getDomainCode());
                meeim.setObligation(varMetadataExtensionInformation.getObligation());
                meeim.setCondition(varMetadataExtensionInformation.getCondition());
                meeim.setMaximumOccurrence(varMetadataExtensionInformation.getMaximumOccurrence());
                meeim.setDomainValue(varMetadataExtensionInformation.getDomainValue());
                meeim.setRule(varMetadataExtensionInformation.getRule());
                meeim.setDataType(varMetadataExtensionInformation.getDataType());
                meeim.setMdMetadataExtensionInfoId(mdMetadataExtensionId);

                saveUpdateMdExtendedElementInfo(meeim);
                jprocessbar.setValue(44);
                jprocessbar.setStringPainted(true);
            
                    //md_extendedelementinfoparent
                    MdExtendedElementInfoParentModel meeipm = new MdExtendedElementInfoParentModel();
                    MdExtendedElementInfoController meeic = new MdExtendedElementInfoController(session, hibernateUtilXml);
                    BigDecimal mdExtendedElementInfoId = meeic.getDataById(mdMetadataExtensionId).getId();

                    meeipm.setParentEntity(varMetadataExtensionInformation.getParentEntity());
                    meeipm.setMdExtendedElementInfoId(mdExtendedElementInfoId);

                    saveUpdateMdExtendedElementInfoParent(meeipm);
                    jprocessbar.setValue(46);
                    jprocessbar.setStringPainted(true);

                    //ciresponsibleparty
                   CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
                   partyModel.setIndividualName(varMetadataExtensionInformation.getIndividualName());
                   partyModel.setOrganisationName(varMetadataExtensionInformation.getOrganisationName());
                   partyModel.setPositionName(varMetadataExtensionInformation.getPositionName());
                   partyModel.setRole(varMetadataExtensionInformation.getRole());
                   partyModel.setMdExtendedElementInfoId(mdExtendedElementInfoId);

                   saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_EXTENDEDELEMENTINFOID,mdExtendedElementInfoId,partyModel);
                   jprocessbar.setValue(48);
                   jprocessbar.setStringPainted(true);
            
                        //cicontact
                       CiContactModel ccm = new CiContactModel();
                       CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                       BigDecimal ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_EXTENDEDELEMENTINFOID,mdExtendedElementInfoId).getId();

                       ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                       saveUpdateCiContact(ccm);
                       jprocessbar.setValue(50);
                       jprocessbar.setStringPainted(true);
            
                            //cionlineresource
                            CiOnlineResourceModel resourceModel = new CiOnlineResourceModel();
                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();

                            resourceModel.setLinkage(varMetadataExtensionInformation.getLinkageSource());
                            resourceModel.setCiContactId(ciContactId);

                            saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,resourceModel);
                            jprocessbar.setValue(52);
                            jprocessbar.setStringPainted(true);


        } catch (NullPointerException n) {
            n.printStackTrace();
            jTextAreaLogData.append("Error Elemen Metadata MetadataExtensionInformation " + n.toString()+ "\n\n");
        }

        jTextAreaLogData.append("Status Metadata MetadataExtensionInformation Selesai" + "\n\n");
    }
    
    private void saveUpdateApplicationSchemaInformation(BigDecimal mdMetadataId) {

        try {
            
            jTextAreaLogData.append("menyimpan elemen metadata application schema information.." + "\n");
            
            //mdapplicationschemainfo
            MdApplicationSchemaInfoModel masim = new MdApplicationSchemaInfoModel();           
            masim.setMdMetadataId(mdMetadataId);
            masim.setSchemaLanguage(varApplicationSchemaInformation.getSchemaLanguage());
            masim.setConstraintLanguage(varApplicationSchemaInformation.getConstraintLanguage());
                    
            saveUpdateMdApplicationSchemaInfo(masim);
            jprocessbar.setValue(718);
            jprocessbar.setStringPainted(true);
           
                //cicitation
                CiCitationModel ccm = new CiCitationModel();
                MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
                BigDecimal mdApplicationSchemaId = masic.getDataById(mdMetadataId).getId();

                ccm.setTitle(varApplicationSchemaInformation.getTitle());
                ccm.setEdition(varApplicationSchemaInformation.getEdition());
                ccm.setStringEditionDate(varApplicationSchemaInformation.getEditionDate());
                ccm.setMdApplicationschemaInfoId(mdApplicationSchemaId);

                saveUpdateCiCitation(CiCitationModel.MDAPPLICATIONSCHEMAINFOID,mdApplicationSchemaId,ccm);
                jprocessbar.setValue(720);
                jprocessbar.setStringPainted(true);
            
                    //cidate
                    CiDateModel cdm = new CiDateModel();
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDAPPLICATIONSCHEMAINFOID,mdApplicationSchemaId).getId();

                    cdm.setStringDate_(varApplicationSchemaInformation.getDate_());
                    cdm.setDateType(varApplicationSchemaInformation.getDateType());
                    cdm.setCiCitationId(ciCitationId);

                    saveUpdateCiDate(cdm);
                    jprocessbar.setValue(722);
                    jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
       jTextAreaLogData.append("Status Metadata ApplicationSchemaInformation Selesai" + "\n\n");
       
    }
    
    public void writeToFile(){
        
        BufferedWriter bw = null;
        FileWriter fw = null;
            
        try{
            
//            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//            Document document = docBuilder.parse(new File(xmlPath));
//            document.getDocumentElement().normalize();
//            String[] s = document.getDocumentURI().toString().split("/");
//            System.out.println(document.getDocumentURI()+"ini pathnya");
//            String st="";
//            for(int i=1;i<s.length-1;i++){
//                st+=s[i]+"/";
//            }
//            st+=varMetadataEntitySetInformation.getFileIdentifier().toUpperCase()+"_INSERT_LOG.txt";
//            System.out.println(st+"ini st ");
            String fileIdentifier = varMetadataEntitySetInformation.getFileIdentifier().toUpperCase();
            File file = new File("C:/migrasi/log/");
            file.mkdir();
            fw = new FileWriter("C:/migrasi/log/"+fileIdentifier+"_INSERT_LOG.txt");
            bw = new BufferedWriter(fw);
            
            bw.write(jTextAreaLogData.getText());
                      
//        }catch(ParserConfigurationException pce){
//           Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, pce);
//        }catch(SAXException s){
//           Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, s);
        }catch(IOException i){
           Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
        }finally {

                try {

                    if (bw != null)
                            bw.close();

                    if (fw != null)
                            fw.close();

                } catch (IOException ex) {

                    ex.printStackTrace();

                }

        }
    }
    
    private void info() {
         
        String fileIdentifier = varMetadataEntitySetInformation.getFileIdentifier().trim().toUpperCase();
        String ret="selesai menyimpan, cek C:/migrasi/log/"+fileIdentifier+".txt";

        JOptionPane.showMessageDialog(this, ret);
        return;

        
    }

    private void saveUpdateMetadataConstraintsInformation(BigDecimal mdMetadataId) {

        try {
            
              jTextAreaLogData.append("menyimpan elemen metadata constraints information.." + "\n\n");

              //mdconstaints
              MdConstraintsModel mcm = new MdConstraintsModel(); 
              mcm.setMdMetadataId(mdMetadataId);
              mcm.setExtendsType(nullValue);
              
              saveUpdateMetadataConstraints(MdConstraintsModel.MD_METADATAID,mdMetadataId,mcm);
              jprocessbar.setValue(712);
              jprocessbar.setStringPainted(true);
              
                    //mdconstraintsuselimitation
                    MdConstraintsUselimitationModel mcum = new MdConstraintsUselimitationModel();
                    MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
                    BigDecimal mdConstraintsId= mcc.getDataById(MdConstraintsModel.MD_METADATAID,mdMetadataId).getId();

                    mcum.setUseLimitation(varMetadataConstraints.getUseLimitation());
                    mcum.setMdConstraintsId(mdConstraintsId);

                    saveUpdateMetadataConstraintsUseLimitation(mcum);
                    jprocessbar.setValue(714);
                    jprocessbar.setStringPainted(true);
                   
                    MdSecurityConstraintsModel mscm = new MdSecurityConstraintsModel();
                    mscm.setClassification(varMetadataConstraints.getClassification());
                    mscm.setClassificationSystem(varMetadataConstraints.getClassificationSystem());
                    mscm.setUserNote(varMetadataConstraints.getUserNote());
                    mscm.setMdConstraintsId(mdConstraintsId);
                    
                    saveUpdateMdSecurityConstraints(mscm);
                    jprocessbar.setValue(716);
                    jprocessbar.setStringPainted(true);
              
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Status Metadata Metadata Constraints Selesai" + "\n\n");
    }
      
    private void saveUpdateMetadataUploadInformation(String fileIdentifier){

        try {
            
              jTextAreaLogData.append("menyimpan elemen metadata upload information.." + "\n");
              
              //md_upload
                try {

                        saveUpdateMdUpload(fileIdentifier);
                        jprocessbar.setValue(750);
                        jprocessbar.setStringPainted(true);

                } catch (IOException ex) {
                        Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                        Logger.getLogger(MigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, ex);
                }
              
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Status Metadata Upload Selesai" + "\n\n");
    }   

    public void setColumn() {
    }

    public void SetFile() throws SAXException, IOException {
     
            getMetadataEntitySetInformationXml();
            getSpatialRepresentationInfoXml();
            getReferenceSystemInfoXml();
            getIdentificationInfoXml();
            getContentInfoXml();
            getPortrayalCatalogueInfoXml();
            getMetadataMaintenanceXml();
            getDataQualityInfoXml();
            getMdExtensionInfoXml();
            getMetadataConstraintsInfoXml();
            getApplicationSchemaInfoXml();
                
    }

    public void simpan() {
        // TODO add your handling code here:
         try {

//            String fileIdentifier = varMetadataEntitySetInformation.getFileIdentifier();
//            String title = varCitation.getTitle();
//            String specification = varMdFormat.getSpesification();
//            String denominator = varSpatialResolution.getDenominator();
//            String suplementationInformation = varIdentificationInformation.getSupplementallnformation();
//            String ciDate = varReferenceSystem.getDate_();
//            long x=0;
//            
//            if(fileIdentifier==null){
//                fileIdentifier="-";
//            }
//            if(suplementationInformation==null){
//                suplementationInformation="-";
//            }
//            if(title==null){
//                title="-";
//            }
//            if(denominator==null){
//                denominator="-";
//            }
//            if(ciDate==null){
//                ciDate="-";
//            }
//            if(specification==null){
//                specification="-";
//            }
//            
//            suplementationInformation = suplementationInformation.trim();
//            title = title.trim();
//            denominator = denominator.trim();
//            ciDate = ciDate.trim();
//            specification = specification.trim();
//            
//            //boolean isBlankSpaceInFirst = fileIdentifier.charAt(0) == ' ';
//            boolean isEmptyTitle = title.equals("-") || title.isEmpty();
//            boolean isEmptySpesification = specification.equals("-") || specification.isEmpty();
//            boolean isEmptyDenominator = denominator.equals("-") || denominator.isEmpty();
//            boolean isEmptySuplementationInformation = suplementationInformation.equals("-") || suplementationInformation.isEmpty();
//            boolean isEmptyCiDate = ciDate.equals("-") || ciDate.isEmpty();
//            boolean isEmptyFileIdentifer = fileIdentifier.equals("-") || fileIdentifier.isEmpty();
//            
//            String newIdentifier = fileIdentifier.trim().toUpperCase();
//    
//            boolean isRbi = newIdentifier.substring(0, 3).equalsIgnoreCase("rbi");
//            boolean isLpi = newIdentifier.substring(0, 3).equalsIgnoreCase("lpi");
//            boolean isLln = newIdentifier.substring(0, 3).equalsIgnoreCase("lln");
//
//            if (!((isRbi) || (isLpi) || (isLln))) {
//                JOptionPane.showMessageDialog(this, "Fileidentifier tidak mengandung salah satu value berikut : RBI,LPI,LLN di awal");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }
//            if (isEmptyTitle) {
//                JOptionPane.showMessageDialog(this, "Citation Title di elemen identificationinfo wajib terisi");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }
//            if (isEmptySpesification) {
//                JOptionPane.showMessageDialog(this, "Spesification Md_Format di elemen identificationinfo wajib terisi karena digunakan saat migrasi dari development ke produksi");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }
//            if (isEmptyDenominator) {
//                JOptionPane.showMessageDialog(this, "Denominator MD_Resolution di elemen identificationinfo wajib terisi, dan bertipe numerik");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }
//            if (isEmptySuplementationInformation) {
////                JOptionPane.showMessageDialog(this, "SuplementationInformation di elemen identificationinfo wajib terisi untuk topologi spasial saat migrasi ke publikasi");
////                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
////                return;
//                  System.out.println("suplementation empty");
//            }
//            if (isEmptyCiDate) {
//                JOptionPane.showMessageDialog(this, "Ci_date di elemen reference system wajib terisi, untuk menyimpan temporal data");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }
//            if (isEmptyFileIdentifer) {
//                JOptionPane.showMessageDialog(this, "Fileidentifier wajib terisi");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }
//            
//            try{
//                x = Long.parseLong(denominator);
//                
//            }catch(NumberFormatException n){
//                n.printStackTrace();
//                System.out.println("number format exception denominator");
//                JOptionPane.showMessageDialog(this, "Denominator MD_Resolution di elemen identificationinfo wajib terisi, dan bertipe numerik");
//                jTextAreaLogData.append("\nstatus: batal menyimpan metadata");
//                return;
//            }

            Thread thread = new Thread() {
                public void run() {

                    DefaultCaret caret = (DefaultCaret) jTextAreaLogData.getCaret();
                    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

                    saveAllMetadata();
                    writeToFile();
                    session.close();
                    info();
                    
                }
            };

            thread.start();

        } catch (NullPointerException n) {
            n.printStackTrace();

        }

    }

}
