/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.DataConfiguration;
import config.HibernateUtil;
import config.HibernateUtilXml;
import controller.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
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
import model.metadata.xml.dataquality.lilineage.ExBoundingPolygon;
import model.metadata.xml.dataquality.lilineage.LiLineage;
import model.metadata.xml.dataquality.lilineage.LiProcessStep;
import model.metadata.xml.dataquality.lilineage.LiSource;
import model.metadata.xml.dataquality.lilineage.Polygon;
import model.metadata.xml.identificationinfo.aggregationInfo.MdAggregateInformation;
import model.metadata.xml.identificationinfo.descriptivekeywords.MdKeywords;
import model.metadata.xml.identificationinfo.resourceformat.MdDigitalTransferOptions;
import model.metadata.xml.identificationinfo.spatialresolution.MdRepresentativeFraction;
import model.metadata.xml.identificationinfo.extent.Extent;
import model.metadata.xml.identificationinfo.resourceformat.MdDistributor;
import model.metadata.xml.identificationinfo.extent.ExGeographicBoundingBox;
import model.metadata.xml.identificationinfo.graphicoverview.MdBrowseGraphic;
import model.metadata.xml.identificationinfo.MdDataIdentification;
import model.metadata.xml.identificationinfo.aggregationInfo.MdIdentifier;
import model.metadata.xml.identificationinfo.resourceformat.MdFormat;
import model.metadata.xml.identificationinfo.resourceformat.MdMedium;
import model.metadata.xml.identificationinfo.spatialresolution.MdResolution;
import model.metadata.xml.metadataconstraints.MdConstraints;
import model.metadata.xml.metadataentitysetinformation.CiAddress;
import model.metadata.xml.metadataentitysetinformation.ContactInfo;
import model.metadata.xml.metadataentitysetinformation.CiResponsibleParty;
import model.metadata.xml.metadataentitysetinformation.MdMetadata;
import model.metadata.xml.metadataentitysetinformation.CiOnlineResourceInfo;
import model.metadata.xml.metadataentitysetinformation.CiTelephone;
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
import model.table.MdDistributorModel;
import model.table.MdExtendedElementInfoModel;
import model.table.MdExtendedElementInfoParentModel;
import model.table.MdFormatModel;
import model.table.MdGeometricObjectsModel;
import model.table.MdIdentificationModel;
import model.table.MdIdentificationStatusModel;
import model.table.MdIdentifierModel;
import model.table.MdKeywordKeywordModel;
import model.table.MdKeywordModel;
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
import model.table.MdSpatialRepresentationModel;
import model.table.MdUploadFileModel;
import model.table.MdVectorSpatialRepresentationModel;
import model.table.RsIdentifierModel;
import model.table.SvServiceIdentificationModel;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Session;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import variable.VarApplicationSchemaInformation;
import variable.VarContentInfo;
import variable.DataQuality.VarDqAbsoluteExternalPositionalAccuracy;
import variable.DataQuality.VarDqAccuracyOfATimeMeasurement;
import variable.DataQuality.VarDqCompletenessComission;
import variable.DataQuality.VarDqCompletenessOmission;
import variable.DataQuality.VarDqConceptualConsistency;
import variable.DataQuality.VarDqDomainConsistency;
import variable.DataQuality.VarDqFormatConsistency;
import variable.DataQuality.VarDqGriddedDataPositionalAccuracy;
import variable.DataQuality.VarDqNonQuantitativeAttributeAccuracy;
import variable.DataQuality.VarDqQuantitativeAttributeAccuracy;
import variable.DataQuality.VarDqRelativeInternalPositionalAccuracy;
import variable.DataQuality.VarDqScope;
import variable.DataQuality.VarDqTemporalConsistency;
import variable.DataQuality.VarDqTemporalValidity;
import variable.DataQuality.VarDqThematicClassificationCorrectness;
import variable.DataQuality.VarDqTopologicalConsistency;
import variable.DataQuality.VarLiLineage;
import variable.IdentificationInformation.VarAggregationInfo;
import variable.IdentificationInformation.VarCitation;
import variable.IdentificationInformation.VarDescriptiveKeywords;
import variable.IdentificationInformation.VarExtent;
import variable.IdentificationInformation.VarIdentificationInformation;
import variable.IdentificationInformation.VarMdBrowseGraphic;
import variable.IdentificationInformation.VarMdFormat;
import variable.IdentificationInformation.VarPointOfContact;
import variable.IdentificationInformation.VarResourceConstraints;
import variable.IdentificationInformation.VarResourceMaintenance;
import variable.IdentificationInformation.VarSpatialRepresentationType;
import variable.IdentificationInformation.VarSpatialResolution;
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
public class MigrasiMetadata extends javax.swing.JFrame {

    /**
     * Creates new form MigrasiMetadata
     */
    // global variable
    private UIManager.LookAndFeelInfo looks[];
    private JFileChooser dialog = new JFileChooser();
    private FileInputStream inputStream = null;

    //elemen metadata entity set info
    private BigDecimal IdMdMetadata = null;

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
    private int progressMax = 113;
    private String fileName = "";

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
    private BigDecimal IdDataQuality = null;
    private BigDecimal IdDqCompleteness = null;
    private BigDecimal IdDqLogicalConsitency = null;
    private BigDecimal IdDqPositionalAccuracy = null;
    private BigDecimal IdDqTemporalAccuracy = null;
    private BigDecimal IdDqThematicAccuracy = null;

    //declare set,get every elemen 
    private VarMetadataEntitySetInformation varMetadataEntitySetInformation = new VarMetadataEntitySetInformation();
    private VarMaintenanceInformation varMaintenanceInformation = new VarMaintenanceInformation();
    private VarSpatialRepresentationInformation varSpatialRepresentationInformation = new VarSpatialRepresentationInformation();
    private VarPotrayalCatalogueInformation varPotrayalCatalogueInformation = new VarPotrayalCatalogueInformation();
    private VarMetadataExtensionInformation varMetadataExtensionInformation = new VarMetadataExtensionInformation();
    private VarApplicationSchemaInformation varApplicationSchemaInformation = new VarApplicationSchemaInformation();
    private VarReferenceSystem varReferenceSystem = new VarReferenceSystem();
    private VarMetadataConstraints varMetadataConstraints = new VarMetadataConstraints();
    
    public MigrasiMetadata(HibernateUtilXml hibernateUtilXml) {
        initComponents();
        userInterface();
        this.hibernateUtilXml = hibernateUtilXml;
        session = hibernateUtilXml.buildSession().openSession();

    }

    public MigrasiMetadata() {
        
        initComponents();
        userInterface();
    }
    
    private void userInterface() {
        setLocationRelativeTo(this);
        //setColumn();
        downloadFile.setVisible(false);
        reconnect.setVisible(false);
        jButtonSimpan.setEnabled(false);
        jButtonBaru.setEnabled(false);

        looks = UIManager.getInstalledLookAndFeels();
        jprocessbar.setMinimum(progressMin);
        jprocessbar.setMaximum(progressMax);

        try {
            UIManager.setLookAndFeel(looks[3].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setMaxProgressBar(int max) {
        jprocessbar.setMaximum(max);
    }

    public void clearForm() {
        jTextFieldPilihBerkas.setText("");
        jipaddress.setText("");
        jTextFieldFileIdentifer.setText("");
        jTextAreaDeskripsi.setText("");
        jTextAreaLogData.setText("");
    }

    public void clearFormWithoutIp() {
        jTextFieldPilihBerkas.setText("");
        //jipaddress.setText("");
        jTextFieldFileIdentifer.setText("");
        jTextAreaDeskripsi.setText("");
        jTextAreaLogData.setText("");
    }

    public void getLog(String log) {
        jTextAreaLogData.setText(log);
    }

    //method xml
    public void getMetadataEntitySetInformationXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getSpatialRepresentationInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getReferenceSystemInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getContentInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getPortrayalCatalogueInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getMetadataMaintenanceXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getIdentificationInfoXml() throws SAXException, IOException {

        try {
           
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            //citation_elemen
            //citation  
            varCitation.setTitle(xmlReader.getNode(document, cc.Title()));
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
            System.out.println(varIdentificationInformation.getSupplementallnformation());
            System.out.println(varIdentificationInformation.getLanguage());
            System.out.println(varIdentificationInformation.getCharacterSet());
            System.out.println(varIdentificationInformation.getTopicCategory());
            System.out.println(varSpatialRepresentationType.getMD_SpatialRepresentationTypeCode());
            System.out.println("\n#Citation#");
            System.out.println(varCitation.getTitle());
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }catch(ArrayIndexOutOfBoundsException ae){
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ae);
        }
    }
    
    public void getMetadataConstraintsInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            MdConstraints mc = mdMetadata.MdConstraints();
           
            varMetadataConstraints.setUseLimitation(xmlReader.getNode(document, mc.UseLimitation()));

            System.out.println("#Metadata Constraints#");
            System.out.println("#==============#");
            System.out.println(varMetadataConstraints.getUseLimitation());
            System.out.println("#==============#\n");

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getApplicationSchemaInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getMdExtensionInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    //elemen MetadataDataQuality
    public void getDataQualityInfoXml() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
            Document document = docBuilder.parse(new File(xmlPath));
            document.getDocumentElement().normalize();
            XmlReader xmlReader = new XmlReader();
            MdMetadata mdMetadata = new MdMetadata();
            DqDataQuality dqDataQuality = mdMetadata.DqDataQuality();

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

      

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException n) {
        }

    }

    public void getDataDqScope() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqCompletenessCommission() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqCompletenessOmission() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqConceptualConsistency() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqDomainConsistency() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqFormatConsistency() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqTopologicalConsistency() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqAbsoluteExternalPositionalAccuracy() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqGriddedDataPositionalAccuracy() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqRelativeInternalPositionalAccuracy() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqThematicClassificationCorrectness() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqNonQuantitativeAttributeAccuracy() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqQuantitativeAttributeAccuracy() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqAccuracyOfATimeMeasurement() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqTemporalConsistency() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataDqTemporalValidity() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getDataLiLineage() throws SAXException, IOException {

        try {

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            String xmlPath = jTextFieldPilihBerkas.getText();
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setColumn() {

        jTextFieldPilihBerkas.setText(fileName);
        jTextFieldFileIdentifer.setText(varMetadataEntitySetInformation.getFileIdentifier());
        jTextAreaDeskripsi.setText(varIdentificationInformation.getAbstract_());
        jipaddress.setText(hibernateUtilXml.getIp() + ":" + hibernateUtilXml.getPort() + "/" + hibernateUtilXml.getDbName());

    }

    public void SetFile() throws SAXException, IOException {
        
        userInterface();
        if (jComboBoxJenisBerkas.getSelectedItem() == "XML") {
            dialog.setFileFilter(new FileNameExtensionFilter("Metadata File", "xml"));
            dialog.setAcceptAllFileFilterUsed(false);
        } else {
            dialog.setFileFilter(new FileNameExtensionFilter("Worksheet File", "xls", "xlsx"));
            dialog.setAcceptAllFileFilterUsed(false);
        }

        dialog.setDialogTitle("Pilih File Metadata");
        int pFile = dialog.showDialog(this, "Select");

        if (pFile == JFileChooser.APPROVE_OPTION) {
            File file = dialog.getSelectedFile();
            jTextFieldPilihBerkas.setText(file.toString());
            fileName = file.toString();
            String ext = FilenameUtils.getExtension(file.getName()).toLowerCase();

            if (ext.equals("xls") || ext.equals("xlsx")) {} 
            else {
                
                //validasi fileidentifier
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

        }
    }

    //Save elemen metadata entity set information
    public void saveUpdateMdMetadata(String column,MdMetadataModel value) {

        PtLocaleController ptLocaleController = new PtLocaleController(session, hibernateUtilXml);
        MdMetadataController md = new MdMetadataController(session, hibernateUtilXml);
        MdCharacterSetCodeController mdCharacterSetCodeController = new MdCharacterSetCodeController(session, hibernateUtilXml);
        MdMetadataModel mdModel = new MdMetadataModel();
            
        BigDecimal mdMetadataId;
        BigDecimal getIdMetadata;
        BigDecimal locale;
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
        
        if(value.getLanguage()==null){
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException n){
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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

        String ret;
        boolean flag=false;
        if (md.getDataById(column,newIdentifier) == null) {
            flag=true;
        } else {
            flag=false;
        }

        if (flag) {
            ret = md.saveMdMetadata(mdModel);
        } else {
            ret = md.updateMdMetadata(mdModel);
        }

        jTextAreaLogData.append("Status table MdMetadata " + ret + "\n");
    }

    public void saveUpdateMdMetadataHierarchyLv(MdMetadataHierarchylvModel value) {

        MdMetadataHierarchyLvController mdHierarchyLv = new MdMetadataHierarchyLvController(session, hibernateUtilXml);
        MdScopecodeController mdScopecode = new MdScopecodeController(session, hibernateUtilXml);
        MdMetadataHierarchylvModel mdModel = new MdMetadataHierarchylvModel();
        String ret;
        boolean flag=false;

        String code = mdScopecode.getDataByCode(value.getHierarchylevel()).getCode();
        
        mdModel.setMdMetadataid(value.getMdMetadataid());
        mdModel.setHierarchylevel(code);

        if (mdHierarchyLv.getDataById(value.getMdMetadataid(),code) == null) {
            flag=true;
        } else {
            flag=false;
        }

        if (flag) {
            ret = mdHierarchyLv.saveMdMetadataHierarchyLv(mdModel);
        } else {
            ret = mdHierarchyLv.updateMdMetadataHierarchyLv(mdModel);
        }

        jTextAreaLogData.append("Status table MdMetadataHierarchyLv " + ret + "\n");

    }

    public void saveUpdateMdMetadataHierarchyLvName(MdMetadataHierarchylvNameModel value) {

        MdMetadataHierarchyLvNameController mdHierarchyLvName = new MdMetadataHierarchyLvNameController(session, hibernateUtilXml);
        MdMetadataHierarchylvNameModel mdModel = new MdMetadataHierarchylvNameModel();

        mdModel.setMdMetadataid(value.getMdMetadataid());
        mdModel.setHierarchylevelName(value.getHierarchylevelName());

        String ret;
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

        jTextAreaLogData.append("Status table MdMetadataHierarchyLvName " + ret + "\n");
    }

    public void saveUpdateCiResponsibleParty(String column,BigDecimal foreignId,CiResponsiblePartyModel value) {

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
       
        String ret;
        boolean isFlag=false;
        BigDecimal id=null;

        if (ciResponsiblePartyController.getDataById(column,foreignId,code) == null) {
            isFlag=true;
        } else {
           isFlag=false;
           id=ciResponsiblePartyController.getDataById(column,foreignId,code).getId();
           
        }

        if (isFlag) {
            ret = ciResponsiblePartyController.saveCiResponsibleParty(ciResponsiblePartyModel);

        } else {
            ret = ciResponsiblePartyController.updateCiResponsibleParty(id,ciResponsiblePartyModel);

        }

        jTextAreaLogData.append("Status table CiResponsibleParty " + ret + "\n");

    }

    public void saveUpdateCiContact(CiContactModel value) {

        CiContactController ciContactController = new CiContactController(session, hibernateUtilXml);
        CiContactModel ciContactModel = new CiContactModel();
        BigDecimal ciContactId;
        BigDecimal getCicontactId;

        String ret;
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
        } else {
            isFlag=false;
            id = ciContactController.getDataById(value.getCiResponsiblePartyId()).getId();
        }

        if (isFlag) {
            ret = ciContactController.saveCiContact(ciContactModel);
        } else {
            ret = ciContactController.updateCiContact(id,ciContactModel);

        }

        jTextAreaLogData.append("Status table CiContactInfo " + ret + "\n");

    }

    public void saveUpdateCiTelephone(CiTelephoneModel value) {

        CiTelephoneController ciTelephoneController = new CiTelephoneController(session, hibernateUtilXml);
        CiTelephoneModel ciTelephoneModel = new CiTelephoneModel();

        String ret;
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
        } else {
            isFlag=false;
            id = ciTelephoneController.getDataById(value.getCiContactId()).getId();
        }

        if (isFlag) {
            ret = ciTelephoneController.saveCiTelephone(ciTelephoneModel);
        } else {
            ret = ciTelephoneController.updateCiTelephone(id,ciTelephoneModel);
        }

        jTextAreaLogData.append("Status table CiTelephone " + ret + "\n");

    }

    public void saveUpdateCiTelephoneVoice(CiTelephoneVoiceModel value) {
    
        CiTelephoneVoiceController ciTelephoneVoiceController = new CiTelephoneVoiceController(session, hibernateUtilXml);
        CiTelephoneVoiceModel ciTelephoneVoiceModel = new CiTelephoneVoiceModel();

        String ret;
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

        jTextAreaLogData.append("Status table CiTelephone Voice " + ret + "\n");

    }

    public void saveUpdateCiTelephoneFacsimile(CiTelephoneFacsimileModel value) {

        CiTelephoneFacsimileController ciTelephoneFacsimileController = new CiTelephoneFacsimileController(session, hibernateUtilXml);
        CiTelephoneFacsimileModel ciTelephoneFacsimileModel = new CiTelephoneFacsimileModel();

        String ret;
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

        jTextAreaLogData.append("Status table CiTelephone Fax " + ret + "\n");

    }

    public void saveUpdateCiAddress(CiAddressModel value) {
   
        CiAddressController ciAddressController = new CiAddressController(session, hibernateUtilXml);
        CiAddressModel ciAddressModel = new CiAddressModel();
        BigDecimal ciAddressId;
        BigDecimal getCiAddressId;
        String ret;
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
        }else {
           isFlag=false;
           id=ciAddressController.getDataById(value.getCiContactId()).getId();
        }

        if (isFlag) {
            ret = ciAddressController.saveCiAddress(ciAddressModel);
        } else {
            ret = ciAddressController.updateCiAddress(id,ciAddressModel);
        }

        jTextAreaLogData.append("Status table CiAddress " + ret + "\n");

    }

    public void saveUpdateCiAddressDeliveryPoint(CiAddressDeliveryPointModel value) {

        CiAddressDeliveryPointModel ciAddressDeliveryPoint = new CiAddressDeliveryPointModel();
        CiAddressDeliveryPointController ciAddressDeliveryPointController = new CiAddressDeliveryPointController(session, hibernateUtilXml);

        boolean isFlag=false;
        String ret;

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

        jTextAreaLogData.append("Status table CiAddressDeliveryPoint " + ret + "\n");

    }

    public void saveUpdateCiAddressEmailAddress(CiAddressEmailAddressModel value) {

        CiAddressEmailAddressModel ciAddressEmailAddressModel = new CiAddressEmailAddressModel();
        CiAddressEmailAddressController ciAddressEmailAddressController = new CiAddressEmailAddressController(session, hibernateUtilXml);
        
        boolean isFlag=false;
        String ret;

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

        jTextAreaLogData.append("Status table CiAddressEmailAddress " + ret + "\n");

    }
    
    public void saveUpdateCiAddressOnlineResource(String column,BigDecimal foreignId,CiOnlineResourceModel value){
        
        CiOnlineFunctionCodeController codeController = new CiOnlineFunctionCodeController(session, hibernateUtilXml);
        CiOnlineResourceController ciOnlineResourceController = new CiOnlineResourceController(session, hibernateUtilXml);
        CiOnlineResourceModel ciOnlineResourceModel = new CiOnlineResourceModel();
        
        BigDecimal getIdCiOnline;
        BigDecimal IdCiOnline;
        BigDecimal id=null;
        boolean isFlag=false;
        String ret;
        
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
        
        if(ciOnlineResourceController.getDataById(column,foreignId,code)==null){
            isFlag=true;
        }else{
            isFlag=false;
            id=ciOnlineResourceController.getDataById(column,foreignId,code).getId();
        }
        
        if(isFlag){
            ret=ciOnlineResourceController.saveCiOnlineResource(ciOnlineResourceModel);
        }else{
            ret=ciOnlineResourceController.updateCiOnlineResource(id,ciOnlineResourceModel);
        }
        
        jTextAreaLogData.append("Status table CiOnlineResource " + ret + "\n");
        
    }
    //end save metatadata entity set information

    //save metadata spatial representation information
    public void saveUpdateMdSpatialRepresentation(MdSpatialRepresentationModel value) {
         
        MdSpatialRepresentationController mdSpatialRepresentationController = new MdSpatialRepresentationController(session, hibernateUtilXml);
        MdSpatialRepresentationModel mdSpatialRepresentationModel = new MdSpatialRepresentationModel();

        BigDecimal getIdSpatialRepresentation;
        BigDecimal IdSpatialRepresentation;
        String ret;
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
        } else {
            isFlag=false;
            id=mdSpatialRepresentationController.getDataById(value.getMdMetadataId()).getId();
        }

        if (isFlag) {
            ret = mdSpatialRepresentationController.saveMdSpatialRepresentation(mdSpatialRepresentationModel);
        } else {
            ret = mdSpatialRepresentationController.updateMdSpatialRepresentation(id,mdSpatialRepresentationModel);
        }

        jTextAreaLogData.append("Status table MdSpatialRepresentation " + ret + "\n");

    }

    public void saveUpdateMdVectorSpatial(MdVectorSpatialRepresentationModel value) {

        MdVectorSpatialRepresentationController mdVectorSpatialRepresentationController = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);
        MdTopologyLevelCodeController mdTopologyLevelCodeController = new MdTopologyLevelCodeController(session, hibernateUtilXml);
        MdVectorSpatialRepresentationModel mdVectorSpatialRepresentationModel = new MdVectorSpatialRepresentationModel();

        boolean isFlag=false;
        String ret;
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

        if (mdVectorSpatialRepresentationController.getDataById(value.getId(),code) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id=mdVectorSpatialRepresentationController.getDataById(value.getId(),code).getId();
        }

        if (isFlag) {
            ret = mdVectorSpatialRepresentationController.saveMdVectorSpatialRepresentation(mdVectorSpatialRepresentationModel);
        } else {
            ret = mdVectorSpatialRepresentationController.updateMdVectorSpatialRepresentation(id,mdVectorSpatialRepresentationModel);
        }

        jTextAreaLogData.append("Status table MdVectorSpatialRepresentation " + ret + "\n");

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

                            jTextAreaLogData.append("Status table MdGeometricObject " + ret + "\n");

                    }
                    

        } catch (NullPointerException n) {
                n.printStackTrace();
        }

    }
    //end save spatial representation information

    //save reference system
    public void saveUpdateReferenceSystem(String column,BigDecimal foreignId,MdReferenceSystemModel value) {

        MdReferenceSystemController mdReferenceSystemController = new MdReferenceSystemController(session, hibernateUtilXml);
        MdReferenceSystemModel mdReferenceSystemModel = new MdReferenceSystemModel();
        BigDecimal getIdMdReferenceSystem;
        BigDecimal IdReferenceSystem;
        
        boolean isFlag=false;
        BigDecimal id=null;
        String ret;

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
        } else {
            isFlag=false;
            id = mdReferenceSystemController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = mdReferenceSystemController.saveMdReferenceSystem(mdReferenceSystemModel);
        } else {
            ret = mdReferenceSystemController.updateMdReferenceSystem(id,mdReferenceSystemModel);
        }

        jTextAreaLogData.append("Status table ReferenceSystem " + ret + "\n");

    }

    public void saveUpdateRsIdentifier(String column,BigDecimal foreignId,RsIdentifierModel value) {

        RsIdentifierController rsIdentifierController = new RsIdentifierController(session, hibernateUtilXml);
        RsIdentifierModel rsIdentifierModel = new RsIdentifierModel();
        
        boolean isFlag=false;
        BigDecimal id=null;
        String ret;
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
        } else {
            isFlag=false;
            id = rsIdentifierController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = rsIdentifierController.saveRsIdentifier(rsIdentifierModel);
        } else {
            ret = rsIdentifierController.updateRsIdentifier(id,rsIdentifierModel);
        }

        jTextAreaLogData.append("Status table RsIdentifier " + ret + "\n");

    }

    public void saveUpdateCiCitation(String column,BigDecimal foreignId,CiCitationModel value) {

        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dt;
        BigDecimal ciCitationId;
        BigDecimal id=null;
        String ret;
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException n){
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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
        } else {
            isFlag=false;
            id = ciCitationController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = ciCitationController.saveCiCitation(ciCitationModel);
        } else {
            ret = ciCitationController.updateCiCitation(id,ciCitationModel);
        }

        jTextAreaLogData.append("Status table CiCitation " + ret + "\n");

    }

    public void saveUpdateCiDate(CiDateModel value) {

        CiDateController ciDateController = new CiDateController(session, hibernateUtilXml);
        CiDateModel ciDateModel = new CiDateModel();
        CiDateTypeCodeController ciDateTypeCodeController = new CiDateTypeCodeController(session, hibernateUtilXml);
        BigDecimal getCiDateId;
        BigDecimal cidateId;
        boolean isFlag=false;
        BigDecimal id=null;
        String ret;
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException n){
             Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
        }
        
        ciDateModel.setId(cidateId);
        ciDateModel.setDateType(code);
        ciDateModel.setCiCitationId(value.getCiCitationId());

        if (ciDateController.getDataById(value.getCiCitationId(),code) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id = ciDateController.getDataById(value.getCiCitationId(),code).getId();
        }

        if (isFlag) {
            ret = ciDateController.saveCiDate(ciDateModel);
        } else {
            ret = ciDateController.updateCiDate(id,ciDateModel);
        }

        jTextAreaLogData.append("Status table CiDate " + ret + "\n");

    }

    public void saveUpdateMdIdentifier(String column,BigDecimal foreignId,MdIdentifierModel value) {

        MdIdentifierController mdIdentifierController = new MdIdentifierController(session, hibernateUtilXml);
        MdIdentifierModel mdIdentifierModel = new MdIdentifierModel();
       
        String ret;
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
        } else {
           isFlag=false;
           id = mdIdentifierController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = mdIdentifierController.saveMdIdentifier(mdIdentifierModel);
        } else {
            ret = mdIdentifierController.updateMdIdentifier(id,mdIdentifierModel);
        }

        jTextAreaLogData.append("Status table MdIdentifier " + ret + "\n");

    }

    public void SaveUpdateCitationPresentationForm(CiCitationPresentationFormModel value) {

        CiCitationPresentationFormController ccpfc = new CiCitationPresentationFormController(session, hibernateUtilXml);
        CiCitationPresentationFormModel CiCitationPresentationFormModel = new CiCitationPresentationFormModel();
        CiPresentationFormCodeController cpfcc = new CiPresentationFormCodeController(session, hibernateUtilXml);
 
        String ret;
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
             Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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

        jTextAreaLogData.append("Status table CiCitationPresentationForm " + ret + "\n");

    }
    
    //end save reference system
    
    //save maintenance information
    public void SaveUpdateMdMaintenanceInfo(String column,BigDecimal foreignId, MdMaintenanceInfoModel value) {

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
        String ret;

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
        } else {
            isFlag=false;
            id = mdMaintenanceInfoController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = mdMaintenanceInfoController.saveMdMaintenanceInfo(mdMaintenanceInfoModel);
        } else {
            ret = mdMaintenanceInfoController.updateMdMaintenanceInfo(id,mdMaintenanceInfoModel);
        }

        jTextAreaLogData.append("Status table mdMaintenanceInfo " + ret + "\n");

    }
    //end save maintenance information

    //save content information
    public void SaveUpdateMdContentInfo(MdContentInfoModel value) {

        MdContentInfoController mdContentInfoController = new MdContentInfoController(session, hibernateUtilXml);
        MdContentInfoModel mdContentInfoModel = new MdContentInfoModel();

        String ret;
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
        } else {
            isFlag=false;
            id = mdContentInfoController.getDataById(value.getMdMetadataId()).getId();
        }

        if (isFlag) {
            ret = mdContentInfoController.saveMdContentInfo(mdContentInfoModel);
        } else {
            ret = mdContentInfoController.updateMdContentInfo(id,mdContentInfoModel);
        }

        jTextAreaLogData.append("Status table MdContentInfo " + ret + "\n");
    }

    public void SaveUpdateMdCoverageDescription(MdCoverageDescriptionModel value) {

        MdCoverageContentTypeCodeController mdCoverageContentTypeCodeController = new MdCoverageContentTypeCodeController(session, hibernateUtilXml);
        MdCoverageDescriptionController mdCoverageDescriptionController = new MdCoverageDescriptionController(session, hibernateUtilXml);
        MdCoverageDescriptionModel mdCoverageDescriptionModel = new MdCoverageDescriptionModel();

        BigDecimal getIdMdCoverageDescription;
        BigDecimal IdMdCoverageDescription;
        BigDecimal id=null;
        boolean isFlag=false;
        String ret;

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

        if (mdCoverageDescriptionController.getDataById(value.getMdContentInfoId(),code) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id = mdCoverageDescriptionController.getDataById(value.getMdContentInfoId(),code).getId();
        }

        if (isFlag) {
            ret = mdCoverageDescriptionController.saveMdCoverageDescription(mdCoverageDescriptionModel);
        } else {
            ret = mdCoverageDescriptionController.updateMdCoverageDescription(id,mdCoverageDescriptionModel);
        }

        jTextAreaLogData.append("Status table mdcoveragedescription " + ret + "\n");

    }
    //end save content information

    //save potrayal catalogue information
    public void SaveUpdateMdPotrayalCatalogueReference(MdPortrayalCatalogueRefModel value) {

        MdPortrayalCatalogueRefController mdPortrayalCatalogueRefController = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
        MdPortrayalCatalogueRefModel mdPortrayalCatalogueRefModel = new MdPortrayalCatalogueRefModel();

        BigDecimal getIdMdPortrayalCatalagoue;
        BigDecimal idMdPortrayalCatalogue;
        BigDecimal id=null;
        boolean isFlag;
        String ret;

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
        } else {
            isFlag=false;
            id = mdPortrayalCatalogueRefController.getDataById(value.getMdMetadataId()).getId();
        }

        if (isFlag) {
            ret = mdPortrayalCatalogueRefController.saveMdPortrayalCatalogueRef(mdPortrayalCatalogueRefModel);
        } else {
            ret = mdPortrayalCatalogueRefController.updateMdPortyalCatalagueRef(id,mdPortrayalCatalogueRefModel);

        }

        jTextAreaLogData.append("Status table mdPortrayalCatalogueRef " + ret + "\n");

    }

    public void saveUpdateCiCitationAlternateTitle(CiCitationAlternateTitleModel value) {

        CiCitationAlternateTitleController ciCitationAlternateTitleController = new CiCitationAlternateTitleController(session, hibernateUtilXml);
        CiCitationAlternateTitleModel citationAlternateTitleModel = new CiCitationAlternateTitleModel();
            
        boolean isFlag=false;
        BigDecimal id=null;
        String ret;

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

        jTextAreaLogData.append("Status table CicitationAlteranateTitle " + ret + "\n");

    }
    //end save potrayal catalogue information

    //save identification information
    public void saveUpdateMdIdentification(MdIdentificationModel value) {
         
        MdIdentificationController mdIdentificationController = new MdIdentificationController(session, hibernateUtilXml);
        MdIdentificationModel mdIdentificationModel = new MdIdentificationModel();

        BigDecimal getMdIdentificationId;
        BigDecimal mdIdentificationId;
        BigDecimal id=null;
        boolean isFlag=false;
        String ret;
       
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
        } else {
            isFlag=false;
            id = mdIdentificationController.getDataById(value.getMdMetadataId()).getId();
        }

        if (isFlag) {
            ret = mdIdentificationController.saveMdIdentification(mdIdentificationModel);
        } else {
            ret = mdIdentificationController.updateMdIdentification(id,mdIdentificationModel);
        }

        jTextAreaLogData.append("Status table MdIdentification " + ret + "\n");

    }

    public void saveUpdateMdIdentificationStatus(MdIdentificationStatusModel value) {

        MdIdentificationStatusController statusController = new MdIdentificationStatusController(session, hibernateUtilXml);
        MdIdentificationStatusModel statusModel = new MdIdentificationStatusModel();
        MdProgressCodeController codeController = new MdProgressCodeController(session, hibernateUtilXml);

        String ret;
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

        jTextAreaLogData.append("Status table MdIdentificationStatus " + ret + "\n");

    }
    
    public void saveUpdateMdBrowseGraphic(MdBrowseGraphicModel value) {

        MdBrowseGraphicController mdBrowseGraphicController = new MdBrowseGraphicController(session, hibernateUtilXml);
        MdBrowseGraphicModel mdBrowseGraphicModel = new MdBrowseGraphicModel();
        
        boolean isFlag=false;
        String ret;
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
        } else {
            isFlag=false;
            id = mdBrowseGraphicController.getDataById(value.getMdIdentificationId()).getId();
        }

        if (isFlag) {
            ret = mdBrowseGraphicController.saveMdBrowseGraphic(mdBrowseGraphicModel);
        } else {
            ret = mdBrowseGraphicController.updateMdBrowseGraphic(id,mdBrowseGraphicModel);
        }

        jTextAreaLogData.append("Status table MdBrowseGraphic " + ret + "\n");

    }

    public void saveUpdateMdFormat(String column,BigDecimal foreignId,MdFormatModel value) {

        MdFormatController mdFormatController = new MdFormatController(session, hibernateUtilXml);
        MdFormatModel mdFormatModel = new MdFormatModel();
        
        boolean isFlag=false;
        String ret;
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
        } else{
            isFlag=false;
            id = mdFormatController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = mdFormatController.saveMdFormat(mdFormatModel);
        } else {
            ret = mdFormatController.updateMdFormat(id,mdFormatModel);
        }

        jTextAreaLogData.append("Status table MdFormat " + ret + "\n");

    }

    public void saveUpdateMdDistributor(String column,BigDecimal foreignId,MdDistributorModel value) {

        MdDistributorController mdDistributorController = new MdDistributorController(session, hibernateUtilXml);
        MdDistributorModel mdDistributorModel = new MdDistributorModel();
   
        String ret;
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
        } else {
            isFlag=false;
            id = mdDistributorController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = mdDistributorController.saveMdDistributor(mdDistributorModel);
        } else {
            ret = mdDistributorController.updateMdDistributor(id,mdDistributorModel);
        }

        jTextAreaLogData.append("Status table MdDistributor " + ret + "\n");

    }
  
    public void saveUpdateMdDigitalTransferOption(String column,BigDecimal foreignId,MdDigitalTransferOptionsModel value) {

        MdDigitalTransferOptionsController mdDigitalTransferOptionsController = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
        MdDigitalTransferOptionsModel mdDigitalTransferOptionsModel = new MdDigitalTransferOptionsModel();

        boolean isFlag=false;
        String ret;
        BigDecimal getIdMdDigitalTransferOptions;
        BigDecimal idMdDigitalTransferOptions;
        BigDecimal id=null;

        getIdMdDigitalTransferOptions = mdDigitalTransferOptionsController.getMaxMdDigitalTransferOptionsId();
        if (getIdMdDigitalTransferOptions == null) {
            idMdDigitalTransferOptions = new BigDecimal(FIRST_ID);
        } else {
            idMdDigitalTransferOptions = new BigDecimal(getIdMdDigitalTransferOptions.longValue() + 1);
        }

        mdDigitalTransferOptionsModel.setId(idMdDigitalTransferOptions);
        mdDigitalTransferOptionsModel.setMdDistributorId(value.getMdDistributorId());
        mdDigitalTransferOptionsModel.setMdDistributionId(value.getMdDistributionId());
        mdDigitalTransferOptionsModel.setTransferSize(value.getTransferSize());
        mdDigitalTransferOptionsModel.setUnitsOfDistribution(value.getUnitsOfDistribution());

        if (mdDigitalTransferOptionsController.getDataById(column,foreignId) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id = mdDigitalTransferOptionsController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = mdDigitalTransferOptionsController.saveMdDigitalTransferOptions(mdDigitalTransferOptionsModel);
        } else {
            ret = mdDigitalTransferOptionsController.updateMdDigitalTransferOptions(id,mdDigitalTransferOptionsModel);
        }

        jTextAreaLogData.append("Status table MdDigitalTransferOptions " + ret + "\n");

    }

    public void saveUpdateMdMedium(MdMediumModel value) {

        MdMediumController mdMediumController = new MdMediumController(session, hibernateUtilXml);
        MdMediumModel mdMediumModel = new MdMediumModel();
        MdMediumNameCodeController mdMediumNameCodeController = new MdMediumNameCodeController(session, hibernateUtilXml);

        String ret;
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
        } else {
            isFlag=false;
            id = mdMediumController.getDataById(value.getMdDigitalTransferOptionsId()).getId();
        }

        if (isFlag) {
            ret = mdMediumController.saveMdMedium(mdMediumModel);
        } else {
            ret = mdMediumController.updateMdMedium(id,mdMediumModel);
        }

        jTextAreaLogData.append("Status table MdMedium " + ret + "\n");
    }

    public void saveUpdateMdKeyword(MdKeywordModel value) {

        MdKeywordController mdKeywordController = new MdKeywordController(session, hibernateUtilXml);
        MdKeywordModel mdKeywordModel = new MdKeywordModel();
        MdKeywordTypeCodeController mdKeywordTypeCodeController = new MdKeywordTypeCodeController(session, hibernateUtilXml);

        BigDecimal getIdMdKeyword;
        BigDecimal idMdKeyword;
        String ret;

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

                    jTextAreaLogData.append("Status table MdKeyword " + ret + "\n");

                }

            } else {

                int i = 0;
                for (VarDescriptiveKeywords keyword : listMdKeywordObject) {

                    String code = mdKeywordTypeCodeController.getDataByDomain(keyword.getType()).getCode();
               
                    mdKeywordModel.setId(new BigDecimal(list.get(i).toString()));
                    mdKeywordModel.setType(code);
                    mdKeywordModel.setMdIdentificationId(value.getMdIdentificationId());

                    ret = mdKeywordController.updateMdKeywordByCurrentId(mdKeywordModel);

                    jTextAreaLogData.append("Status table MdKeyword " + ret + "\n");
                    i++;
                }

            }

        } catch (NullPointerException n) {
        }

    }

    public void saveUpdateMdKeywordKeyword(BigDecimal mdIdentificationId) {

        MdKeywordKeywordController mdKeywordKeywordController = new MdKeywordKeywordController(session, hibernateUtilXml);
        MdKeywordKeywordModel mdKeywordKeywordModel = new MdKeywordKeywordModel();
        MdKeywordController mdKeywordController = new MdKeywordController(session, hibernateUtilXml);
        MdKeywordTypeCodeController mdKeywordTypeCodeController = new MdKeywordTypeCodeController(session, hibernateUtilXml);

        String ret;
        int i = 0;       

        try {
            
            List list = (List) mdKeywordController.getListOfId(mdIdentificationId);
       
            for (VarDescriptiveKeywords keyword : listMdKeywordObject) {

                String code = mdKeywordTypeCodeController.getDataByDomain(keyword.getType()).getCode();
                String getIdMdKeyword = mdKeywordController.getDataByPropery(mdIdentificationId, code).getId().toString();
                BigDecimal idMdKeyword;
                
                if(getIdMdKeyword==null){
                    System.out.println("double code in mdkeyword");
                    idMdKeyword = new BigDecimal(list.get(i).toString());

                }else{
                    idMdKeyword = new BigDecimal(getIdMdKeyword); 
                }

                   
                mdKeywordKeywordModel.setMdKeywordId(idMdKeyword);
                mdKeywordKeywordModel.setKeyword(keyword.getKeyword());

                if (mdKeywordKeywordController.getDataById(idMdKeyword) == null) {

                    ret = mdKeywordKeywordController.saveMdKeywordKeyword(mdKeywordKeywordModel);
                    jTextAreaLogData.append("Status table MdKeywordKeyword " + ret + "\n");

                } else {

                    ret = mdKeywordKeywordController.updateMdKeywordKeyword(mdKeywordKeywordModel);
                    jTextAreaLogData.append("Status table MdKeywordKeyword " + ret + "\n");
                }

                i++;

            }

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

    }

    public void saveUpdateThesaurusNameCitation(List mdkeywordId) { 

        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        String ret;
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

                 }else{
                         BigDecimal id = ciCitationController.getDataById(CiCitationModel.MDKEYWORDID, new BigDecimal(mdkeywordId.get(i).toString())).getId();
                         
                         ciCitationModel.setId(id);
                         ciCitationModel.setTitle(keyword.getTitle());
                         ciCitationModel.setMdKeywordId(new BigDecimal(mdkeywordId.get(i).toString()));

                         ret = ciCitationController.updateCiCitation(id,ciCitationModel);
                 }
                 
                  jTextAreaLogData.append("Status table CiCitation " + ret + "\n");
                 
                  if(keyword.getLengthTitle().equals("1")){
                        
                      break;
                  }
                 i++;
             }
                                 
           
        }catch(NullPointerException n){
                n.printStackTrace();
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
        String ret;
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
                        Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
                    }catch(NullPointerException n){
			            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
			        }
                                      
                    List citationListId = (List) ciCitationController.getListOfId(new BigDecimal(mdKeywordId.get(i).toString()));
                    BigDecimal citationId = new BigDecimal(citationListId.get(i).toString());
                    ciDateModel.setCiCitationId(citationId);
                    
                    if(ciDateController.getDataById(citationId, code)==null){
                        flag=true;
                    }else{
                        flag=false;
                        id=ciDateController.getDataById(citationId, code).getId();
                    }
                    
                    if(flag){
                        ret=ciDateController.saveCiDate(ciDateModel);
                    }else{
                        ret=ciDateController.updateCiDate(id,ciDateModel);
                    }
                    
                   jTextAreaLogData.append("Status table Cidate " + ret + "\n");
  
                }
                                        
        }catch(NullPointerException n){
                n.printStackTrace();
        }
          
    }   
    
    public void saveUpdateMdAggregationInformation(MdAggregateInfoModel value) {

        MdAggregateInfoController mdAggregateInfoController = new MdAggregateInfoController(session, hibernateUtilXml);
        MdAggregateInfoModel mdAggregateInfoModel = new MdAggregateInfoModel();
        DsAssociationTypeCodeController dsAssociationTypeCodeController = new DsAssociationTypeCodeController(session, hibernateUtilXml);
        DsInitiativeTypeCodeController dsInitiativeTypeCodeController = new DsInitiativeTypeCodeController(session, hibernateUtilXml);
        
        boolean isFlag=false;
        String ret;
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

        if (mdAggregateInfoController.getDataByObjek(mdAggregateInfoModel) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id = mdAggregateInfoController.getDataByObjek(mdAggregateInfoModel).getId();
        }

        if (isFlag) {
            ret = mdAggregateInfoController.saveMdAggregateInfo(mdAggregateInfoModel);
        } else {
            ret = mdAggregateInfoController.updateMdAggregateInfo(id,mdAggregateInfoModel);
        }

        jTextAreaLogData.append("Status table MdAggregationInfo " + ret + "\n");

    }    

    public void saveUpdateSvServiceIdentification(SvServiceIdentificationModel value) {

        SvServiceIdentificationController svServiceIdentificationController = new SvServiceIdentificationController(session, hibernateUtilXml);
        SvServiceIdentificationModel svServiceIdentificationModel = new SvServiceIdentificationModel();
        MdProgressCodeController codeController = new MdProgressCodeController(session, hibernateUtilXml);

        String code = "";
        String domainName = value.getStatus();
        String ret;
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

        if (svServiceIdentificationController.getDataById(value.getMdIdentificationId(),code) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id = svServiceIdentificationController.getDataById(value.getMdIdentificationId(),code).getId();
        }

        if (isFlag) {
            ret = svServiceIdentificationController.saveSvServiceIdentification(svServiceIdentificationModel);
        } else {
            ret = svServiceIdentificationController.updateSvServiceIdentification(id,svServiceIdentificationModel);
        }

        jTextAreaLogData.append("Status table SvServiceIdentification " + ret + "\n");

    }

    public void saveUpdateMdDataIdentification(MdDataIdentificationModel value) {

        MdDataIdentificationController mdDataIdentificationController = new MdDataIdentificationController(session, hibernateUtilXml);
        MdDataIdentificationModel mdDataIdentificationModel = new MdDataIdentificationModel();

        String ret;
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

        jTextAreaLogData.append("Status table MdDataIdentification " + ret + "\n");

    }

    public void saveUpdateMdResolution(MdResolutionModel value) {

        MdResolutionController mdResolutionController = new MdResolutionController(session, hibernateUtilXml);
        MdResolutionModel mdResolutionModel = new MdResolutionModel();

        boolean isFlag=false;
        String ret;
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
        } else {
            isFlag=false;
            id = mdResolutionController.getDataById(value.getMdDataIdentificationId()).getId();
        }

        if (isFlag) {
            ret = mdResolutionController.saveMdResolution(mdResolutionModel);
        } else {
            ret = mdResolutionController.updateMdResolution(id,mdResolutionModel);
        }

        jTextAreaLogData.append("Status table MdResolution " + ret + "\n");

    }

    public void saveUpdateMdDataIdentificationSpatrep(MdDataIdentificationSpatrepModel value) {

        MdDataIdentificationSpatrepController mdDataIdentificationSpatrepController = new MdDataIdentificationSpatrepController(session, hibernateUtilXml);
        MdDataIdentificationSpatrepModel mdDataIdentificationSpatrepModel = new MdDataIdentificationSpatrepModel();
        MdSpatialRepresentTypeCodeController spatialRepresentTypeCodeController = new MdSpatialRepresentTypeCodeController(session, hibernateUtilXml);

        String ret;
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

        jTextAreaLogData.append("Status table MdDataIdentificationSpatrep " + ret + "\n");

    }

    public void saveUpdateMdDataIdentificationLang(MdDataIdentificationLangModel value) {

        MdDataIdentificationLangController langController = new MdDataIdentificationLangController(session, hibernateUtilXml);
        MdDataIdentificationLangModel langModel = new MdDataIdentificationLangModel();

        String ret;
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

        jTextAreaLogData.append("Status table MdDataIdentificationLang " + ret + "\n");

    }

    public void saveUpdateMdDataIdentificationCharset(MdDataIdentificationCharsetModel value) {

        MdDataIdentificationCharsetController charsetController = new MdDataIdentificationCharsetController(session, hibernateUtilXml);
        MdDataIdentificationCharsetModel charsetModel = new MdDataIdentificationCharsetModel();
        MdCharacterSetCodeController codeController = new MdCharacterSetCodeController(session, hibernateUtilXml);

        String ret;
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

        jTextAreaLogData.append("Status table MdDataIdentificationCharset " + ret + "\n");
    }

    public void saveUpdateMdDataIdentificationTopCat(MdDataIdentificationTopcatModel value) {

        MdDataIdentificationTopcatController topcatController = new MdDataIdentificationTopcatController(session, hibernateUtilXml);
        MdDataIdentificationTopcatModel topcatModel = new MdDataIdentificationTopcatModel();
        MdTopicCategoryCodeController codeController = new MdTopicCategoryCodeController(session, hibernateUtilXml);

        String ret;
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

        jTextAreaLogData.append("Status table MdDataIdentificationTopCat " + ret + "\n");

    }

    public void saveUpdateMdRepresentativeFraction(String column,BigDecimal foreignId,MdRepresentativeFractionModel value) {

        MdRepresentativeFractionController mdRepresentativeFractionController = new MdRepresentativeFractionController(session, hibernateUtilXml);
        MdRepresentativeFractionModel mdRepresentativeFractionModel = new MdRepresentativeFractionModel();

        boolean isFlag=false;
        String ret;
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
            if(value.getStringDenominator()==null){
                denominator= BigDecimal.ZERO;
            }else{
                denominator= new BigDecimal(value.getStringDenominator());
            }
            
        }catch(NullPointerException n){
             Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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

        jTextAreaLogData.append("Status table MdRepresentativeFraction " + ret + "\n");

    }

    public void saveUpdateExExtent(String column,BigDecimal foreignId,ExExtentModel value) {

        ExExtentController exExtentController = new ExExtentController(session, hibernateUtilXml);
        ExExtentModel exExtentModel = new ExExtentModel();

        boolean isFlag=false;
        String ret;
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
        } else {
            isFlag=false;
            id = exExtentController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = exExtentController.saveExExtent(exExtentModel);
        }else{
            ret = exExtentController.updateExExtent(id,exExtentModel);
        }

        jTextAreaLogData.append("Status table ExExtent " + ret + "\n");

    }

    public void saveUpdateExExtentGeographicExtent(String column,BigDecimal foreignId,ExGeographicExtentModel value) {

        ExGeographicExtentController exGeographicExtentController = new ExGeographicExtentController(session, hibernateUtilXml);
        ExGeographicExtentModel exGeographicExtentModel = new ExGeographicExtentModel();

        boolean isFlag=false;
        String ret;
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
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        exGeographicExtentModel.setId(idExGeographicExtent);
        exGeographicExtentModel.setExExtentId(value.getExExtentId());
        exGeographicExtentModel.setExtendsType(value.getExtendsType());
        exGeographicExtentModel.setExtentTypeCode(conditional);
        exGeographicExtentModel.setMeasureDescription(value.getMeasureDescription());
        exGeographicExtentModel.setExSpatialTemporalExtentId(value.getExSpatialTemporalExtentId());

        if (exGeographicExtentController.getDataById(column,foreignId) == null) {
            isFlag=true;
        } else {
            isFlag=false;
            id = exGeographicExtentController.getDataById(column,foreignId).getId();
        }

        if (isFlag) {
            ret = exGeographicExtentController.saveExGeographicExtent(exGeographicExtentModel);
        } else {
            ret = exGeographicExtentController.updateExGeographicExtent(id,exGeographicExtentModel);
        }

        jTextAreaLogData.append("Status table ExGeographicExtent " + ret + "\n");

    }

    public void saveUpdateExExtentGeographicBoundingBox(ExGeographicBoundingBoxModel value) {

        ExGeographicBoundingBoxController exGeographicBoundingBoxController = new ExGeographicBoundingBoxController(session, hibernateUtilXml);
        ExGeographicBoundingBoxModel exGeographicBoundingBoxModel = new ExGeographicBoundingBoxModel();
      
        String ret;
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

        exGeographicBoundingBoxModel.setId(idExGeographicBoundingBox);
        exGeographicBoundingBoxModel.setEastBoundLongitude(value.getEastBoundLongitude());
        exGeographicBoundingBoxModel.setNorthBoundLongitud(value.getNorthBoundLongitud());
        exGeographicBoundingBoxModel.setSouthBoundLongitude(value.getSouthBoundLongitude());
        exGeographicBoundingBoxModel.setWestBoundLongitude(value.getWestBoundLongitude());
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

        jTextAreaLogData.append("Status table ExGeographicBoundingBox " + ret + "\n");

    }
    
    public void saveUpdateExBoundingPolygon(ExBoundingPolygonModel value) {

        ExBoundingPolygonController ExBoundingPolygonController = new ExBoundingPolygonController(session, hibernateUtilXml);
        ExBoundingPolygonModel ExBoundingPolygonModel = new ExBoundingPolygonModel();
      
        String ret;
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

        jTextAreaLogData.append("Status table ExBoundingPolygon " + ret + "\n");

    }
    
    public void saveUpdateExBoundingPolygonPolygon(ExBoundingPolygonPolygonModel value) throws SQLException {

        ExBoundingPolygonPolygonController ebppc  = new ExBoundingPolygonPolygonController(session, hibernateUtilXml);
        ExBoundingPolygonPolygonModel ebppm = new ExBoundingPolygonPolygonModel();
      
        String ret;
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

        jTextAreaLogData.append("Status table ExBoundingPolygonPolygon " + ret + "\n");

    }
      
    public void saveUpdateExTemporalExtent(ExTemporalExtentModel value){
    
        ExTemporalExtentController extentController = new ExTemporalExtentController(session, hibernateUtilXml);
        ExTemporalExtentModel extentModel = new ExTemporalExtentModel();
        
        BigDecimal getExTemporalId;
        BigDecimal idExTemporalId;
        BigDecimal id=null;
        String ret;
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
        }else{
            isFlag=false;
            id=extentController.getDataById(value.getExExtendId()).getId();
        }
        
        if(isFlag){
            ret=extentController.saveExTemporalExtent(extentModel);
        }else{
            ret=extentController.updateExTemporalExtent(id,extentModel);
        }
        
        jTextAreaLogData.append("Status table ExTemporalExtent " + ret + "\n");
    }
    
    public void saveUpdateExExtentVerticalExtent(ExVerticalExtentModel value){
    
        ExVerticalExtentController exVerticalExtentController = new ExVerticalExtentController(session, hibernateUtilXml);
        ExVerticalExtentModel extentModel = new ExVerticalExtentModel();
        
        BigDecimal getExVerticalId;
        BigDecimal idExVerticalId;
        BigDecimal id=null;
        String ret;
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
        }else{
            isFlag=false;
            id=exVerticalExtentController.getDataById(value.getExExtentId()).getId();
        }
        
        if(isFlag){
            ret=exVerticalExtentController.saveExVerticalExtent(extentModel);
        }else{
            ret=exVerticalExtentController.updateExVerticalExtent(id,extentModel);
        }
        
        jTextAreaLogData.append("Status table ExVerticalExtent " + ret + "\n");
        
    }
    //end save identification 
    
    //ciseries
    public void saveUpdateCiSeries(CiSeriesModel value) {

        CiSeriesController csc = new CiSeriesController(session, hibernateUtilXml);
        CiSeriesModel csm = new CiSeriesModel();

        String ret;
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

        jTextAreaLogData.append("Status table CiSeries " + ret + "\n");

    }
    //end ciseries
    
    //mdconstraints
    public void saveUpdateMetadataConstraints(String column,BigDecimal foreignId,MdConstraintsModel value) {

        MdConstraintsController mdConstraintsController = new MdConstraintsController(session, hibernateUtilXml);
        MdConstraintsModel mdConstraintsModel = new MdConstraintsModel();

        boolean isFlag=false;
        String ret;
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

        jTextAreaLogData.append("Status table MdConstraints " + ret + "\n");

    }

    public void saveUpdateMetadataConstraintsUseLimitation(MdConstraintsUselimitationModel value) {

        MdConstraintsUseLimitationController limitationController = new MdConstraintsUseLimitationController(session, hibernateUtilXml);
        MdConstraintsUselimitationModel uselimitationModel = new MdConstraintsUselimitationModel();
     
        String ret;
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

        jTextAreaLogData.append("Status table MdConstraintsUseLimitation " + ret + "\n");

    }  
    //end mdconstraints
    
    //mdapplicationschemainfo
    public void saveUpdateMdApplicationSchemaInfo(MdApplicationSchemaInfoModel value){
    
        MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
        MdApplicationSchemaInfoModel infoModel = new MdApplicationSchemaInfoModel();
        
        BigDecimal getMdApplicationId;
        BigDecimal MdApplicationId;
        String ret;
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
        }else{
           isFlag=false;
           id=masic.getDataById(value.getMdMetadataId()).getId();
        }
        
        if(isFlag){
            ret=masic.saveMdApplicationSchemaInfo(infoModel);
        }else{
            ret=masic.UpdateMdApplicationSchemaInfo(id,infoModel);
        }
        
        jTextAreaLogData.append("Status table MdApplicationSchemaInfo " + ret + "\n");
    
    }
    //end mdapplicationschemainfo
    
    //metadataextensioninfo
    public void saveUpdateMdMetadataExtensionInfo(MdMetadataExtensionInfoModel value){
    
        MdMetadataExtensionInfoController infoController = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
        MdMetadataExtensionInfoModel infoModel = new MdMetadataExtensionInfoModel();
        
        String ret;
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
        }else{
            isFlag=false;
            id=infoController.getDataById(value.getMdMetadataId()).getId();
        }
        
        if(isFlag){
            ret=infoController.saveMdMetadataExtensionInfo(infoModel);
        }else{
            ret=infoController.UpdateMdMetadataExtensionInfo(id,infoModel);
        }
        
        jTextAreaLogData.append("Status table MdExtensionInfo " + ret + "\n");
    }
    
    public void saveUpdateMdExtendedElementInfo(MdExtendedElementInfoModel value){
    
        MdExtendedElementInfoController infoController = new MdExtendedElementInfoController(session, hibernateUtilXml);
        MdExtendedElementInfoModel infoModel = new MdExtendedElementInfoModel();
        MdDataTypeCodeController codeController = new MdDataTypeCodeController(session, hibernateUtilXml);
        MdObligationCodeController mocc = new MdObligationCodeController(session, hibernateUtilXml);
        
        String ret;
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
        }else{
            isFlag=false;
            id=infoController.getDataById(value.getMdMetadataExtensionInfoId()).getId();
        }
        
        if(isFlag){
            ret=infoController.saveMdExtendedElementInfo(infoModel);
        }else{
            ret=infoController.updateMdExtendedElementInfo(id,infoModel);
        }
        
        jTextAreaLogData.append("Status table MdExtendedElementInfo " + ret + "\n");
        
    }
    
    public void saveUpdateMdExtendedElementInfoParent(MdExtendedElementInfoParentModel value){
    
        MdExtendedElementInfoParentController infoController = new MdExtendedElementInfoParentController(session, hibernateUtilXml);
        MdExtendedElementInfoParentModel infoModel = new MdExtendedElementInfoParentModel();
        
        String ret;
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
        
        jTextAreaLogData.append("Status table MdExtendedElementInfoParent " + ret + "\n");
        
    }
    //end metadataextensioninfo

    //save dataquality
    //save md_scope
    public void saveUpdateDqDataQuality(DqDataQualityModel value) {

        DqDataQualityController dqDataQualityController = new DqDataQualityController(session, hibernateUtilXml);
        DqDataQualityModel dqDataQualityModel = new DqDataQualityModel();

        String ret;
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
        } else {
            isFlag=false;
            id = dqDataQualityController.getDataById(value.getMdMetadataId()).getId();
        }

        if (isFlag) {
            ret = dqDataQualityController.saveDqDataQuality(dqDataQualityModel);
        } else {
            ret = dqDataQualityController.updateDqDataQuality(id,dqDataQualityModel);
        }

        jTextAreaLogData.append("Status table DqDataQuality " + ret + "\n");

    }

    public void saveUpdateDqScope(DqScopeModel value) {

        DqScopeController dqScopeController = new DqScopeController(session, hibernateUtilXml);
        DqScopeModel dqScopeModel = new DqScopeModel();
        MdScopecodeController msc = new MdScopecodeController(session, hibernateUtilXml);
        
        boolean flag=false;
        String ret;
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
        } else {
            flag=false;
            id = dqScopeController.getDataById(value.getDqDataQualityId()).getId();
        }

        if (flag) {
            ret = dqScopeController.saveDqScope(dqScopeModel);
        } else {
            ret = dqScopeController.updateDqScope(id,dqScopeModel);
        }

        jTextAreaLogData.append("Status table DqScope " + ret + "\n");

    }

    public void saveUpdateDqScopeGroup(BigDecimal dataQualityId) {
       
        //local variable
        BigDecimal dqScopeId=null;
        BigDecimal exExtentId=null;
        BigDecimal exGeographicExtentId=null;
        
        DqScopeModel dsm = new DqScopeModel();
        
        dsm.setDqDataQualityId(dataQualityId);
        dsm.setDqLevel(varDqScope.getLevel());
        
        saveUpdateDqScope(dsm);
        
        //ex_extent
        DqScopeController dsc = new DqScopeController(session, hibernateUtilXml);
        dqScopeId = dsc.getDataById(dataQualityId).getId();
        ExExtentModel eem = new ExExtentModel();

        eem.setDqScopeId(dqScopeId);

        saveUpdateExExtent(ExExtentModel.DQ_SCOPEID,dqScopeId,eem);

         //ex_geographicextent
        ExGeographicExtentModel egem = new ExGeographicExtentModel();
        ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
        exExtentId = eec.getDataById(ExExtentModel.DQ_SCOPEID,dqScopeId).getId();

        egem.setExExtentId(exExtentId);
        egem.setExtendsType(nullValue);
        egem.setStringExtentTypeCode("false");

        saveUpdateExExtentGeographicExtent(ExGeographicExtentModel.EX_EXTENTID,exExtentId,egem);

         //ex_extent_boundingbox
        ExGeographicBoundingBoxModel boxModel = new ExGeographicBoundingBoxModel();
        ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
        exGeographicExtentId = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();
 
        boxModel.setExGeographicExtentId(exGeographicExtentId);

        saveUpdateExExtentGeographicBoundingBox(boxModel);

    }
    //end save md_scope

    //save dq_completeness
    public void saveUpdateDqCompleteness(DqCompletenessModel value) {
        
        DqCompletenessController dqCompletenessController = new DqCompletenessController(session, hibernateUtilXml);
        DqCompletenessModel dqCompletenessModel = new DqCompletenessModel();

        BigDecimal dqCompletenessId;
        BigDecimal getdqCompletenessId;
        BigDecimal id=null;
        String ret;
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
        } else {
            flag=false;
            id = dqCompletenessController.getDataById(value.getDqDataQualityId()).getId();
        }

        if (flag) {
            ret = dqCompletenessController.saveDqDataQuality(dqCompletenessModel);
        } else {
            ret = dqCompletenessController.updateDqDataQuality(id,dqCompletenessModel);
        }

        jTextAreaLogData.append("Status table DqCompleteness " + ret + "\n");

    }

    //save dq_completeness_comission
    public void saveUpdateDqCompcomm(DqCompCommModel value) {

        DqCompCommController dqCompCommController = new DqCompCommController(session, hibernateUtilXml);
        DqCompCommModel dqCompCommModel = new DqCompCommModel();
  
        String ret;
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
        } else {
            flag=false;
            id = dqCompCommController.getDataById(value.getDqCompletenessId()).getId();
        }

        if (flag) {
            ret = dqCompCommController.saveDqCompComm(dqCompCommModel);
        } else {
            ret = dqCompCommController.updateDqCompComm(id,dqCompCommModel);
        }

        jTextAreaLogData.append("Status table DqCompComm " + ret + "\n");

    }
    //dq for loop

    public void saveUpdateDqCompcommGroup(BigDecimal dataQualityId) {

        //dqcompleteness
        DqCompletenessModel dcm = new DqCompletenessModel();
        dcm.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqCompleteness(dcm);

        //dqcompletenesscomission
        DqCompCommModel dccm = new DqCompCommModel();
        DqCompletenessController dcc = new DqCompletenessController(session, hibernateUtilXml);
        IdDqCompleteness =  dcc.getDataById(dataQualityId).getId();   
        
        dccm.setDqDataQualityId(dataQualityId);
        dccm.setDqCompletenessId(IdDqCompleteness);
        
        saveUpdateDqCompcomm(dccm);
        
        //dq_element
        String columnName = DqElementModel.DQ_COMPCOMMID;
        BigDecimal IdDqCompComm;
        DqElementModel dqElementModel = new DqElementModel();
        DqCompCommController dqCompCommController = new DqCompCommController(session, hibernateUtilXml);
        IdDqCompComm = dqCompCommController.getDataById(IdDqCompleteness).getId();
 
        dqElementModel.setMeasureDescription(varDqCompletenessComission.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqCompletenessComission.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqCompletenessComission.getEvaluationMethodDescription());
        dqElementModel.setExtendsType(nullValue);
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqCompComm, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqCompComm, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqCompletenessComission.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqCompCommId(IdDqCompComm);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setDqCompCommId(IdDqCompComm);
        dqElementDateTimeModel.setStringDateTime(varDqCompletenessComission.getDateTime());
        
        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqCompletenessComission.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqCompletenessComission.getTitleMeasure());
        ccm.setEdition(varDqCompletenessComission.getEdition());
        ccm.setStringEditionDate(varDqCompletenessComission.getEditionDate());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqCompletenessComission.getDateMeasure());
        cdm.setDateType(varDqCompletenessComission.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);
        
        //citation_alternate_title
        CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();
      
        ccatm.setAlternateTitle(varDqCompletenessComission.getAlternateTitle());
        ccatm.setCi_citationid(citationIdSup);

        saveUpdateCiCitationAlternateTitle(ccatm);
        
        //mdidentifier
        MdIdentifierModel mimsub = new MdIdentifierModel();
        mimsub.setCode(varDqCompletenessComission.getCodeIdentifier());
        mimsub.setCiCitationId(citationIdSup);
        mimsub.setExtendsType(nullValue);
        
        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationIdSup, mimsub);
       
        //citation
        CiCitationModel ccmSub = new CiCitationModel();
        BigDecimal mdIdentifierSub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationIdSup).getId();
        
        ccmSub.setTitle(varDqCompletenessComission.getTitleIdentifier());
        ccmSub.setMdIdentifierId(mdIdentifierSub);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub,ccmSub);
        
        //cidate
        CiDateModel cdmSub = new CiDateModel();
        BigDecimal  citationSub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub).getId();
        
        cdmSub.setStringDate_(varDqCompletenessComission.getDateIdentifier());
        cdmSub.setDateType(varDqCompletenessComission.getDateTypeIdentifier());
        cdmSub.setCiCitationId(citationSub);
        
        saveUpdateCiDate(cdmSub);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqCompletenessComission.getExplanation());
        dqConformanceResultModel.setStringPass(varDqCompletenessComission.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqCompletenessComission.getTitle());
        ciCitationModel.setEdition(varDqCompletenessComission.getEditionConformance());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);
         
        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
        
        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqCompletenessComission.getDate());
        ciDateModel.setDateType(varDqCompletenessComission.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqCompletenessComission.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
        
        cdmProcedure.setStringDate_(varDqCompletenessComission.getDateEvaluation());
        cdmProcedure.setDateType(varDqCompletenessComission.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqCompletenessComission.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop    
    //end save dq_completeness_comission  

    //save dq_completeness_omission
    public void saveUpdateDqCompom(DqComPomModel value) {
        
        DqComPomController dqComPomController = new DqComPomController(session, hibernateUtilXml);
        DqComPomModel dqComPomModel = new DqComPomModel();

        String ret;
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
        } else {
            flag=false;
            id = dqComPomController.getDataById(value.getDqCompletenessId()).getId();
        }

        if (flag) {
            ret = dqComPomController.saveDqComPom(dqComPomModel);
        } else {
            ret = dqComPomController.updateDqComPom(id,dqComPomModel);
        }

        jTextAreaLogData.append("Status table DqCompom " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqCompomGroup(BigDecimal dataQualityId) {

        //dqcompleteness_omission
        DqComPomModel dcpm = new DqComPomModel();
        dcpm.setDqCompletenessId(IdDqCompleteness);
        dcpm.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqCompom(dcpm);
        //dq_element
        String columnName = DqElementModel.DQ_COMPOMID;
        BigDecimal IdDqCompom;
        DqElementModel dqElementModel = new DqElementModel();
        DqComPomController DqCompomController = new DqComPomController(session, hibernateUtilXml);
        IdDqCompom = DqCompomController.getDataById(IdDqCompleteness).getId();

        dqElementModel.setMeasureDescription(varDqCompletenessOmission.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqCompletenessOmission.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqCompletenessOmission.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqCompom, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqCompom, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqCompletenessOmission.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqCompOmId(IdDqCompom);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqCompletenessOmission.getDateTime());
        dqElementDateTimeModel.setDqCompOmId(IdDqCompom);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqCompletenessOmission.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqCompletenessOmission.getTitleMeasure());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqCompletenessOmission.getDateMeasure());
        cdm.setDateType(varDqCompletenessOmission.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);
       
        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqCompletenessOmission.getExplanation());
        dqConformanceResultModel.setStringPass(varDqCompletenessOmission.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqCompletenessOmission.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqCompletenessOmission.getDate());
        ciDateModel.setDateType(varDqCompletenessOmission.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqCompletenessOmission.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

        cdmProcedure.setStringDate_(varDqCompletenessOmission.getDateEvaluation());
        cdmProcedure.setDateType(varDqCompletenessOmission.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);
        
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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqCompletenessOmission.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop   
    //end save dq_completeness_omission
    //end save dq_completeness

    //save dq_conseptual_consistency
    public void saveUpdateDqLogicalconsistency(DqLogicalConsistencyModel value) {
         
        DqLogicalConsistencyController dqLogicalConsistencyController = new DqLogicalConsistencyController(session, hibernateUtilXml);
        DqLogicalConsistencyModel dqLogicalConsistencyModel = new DqLogicalConsistencyModel();

        String ret;
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
        } else {
            flag=false;
            id = dqLogicalConsistencyController.getDataById(value.getDqDataQualityId()).getId();
        }

        if (flag) {
            ret = dqLogicalConsistencyController.saveDqLogicalConsitency(dqLogicalConsistencyModel);
        } else {
            ret = dqLogicalConsistencyController.updateDqLogicalConsitency(id,dqLogicalConsistencyModel);
        }

        jTextAreaLogData.append("Status table DqLogicalconsistency " + ret + "\n");

    }

    public void saveUpdateDqConcconsis(DqConcconsisModel value) {
        
        DqConcconsisController dqConcconsisController = new DqConcconsisController(session, hibernateUtilXml);
        DqConcconsisModel dqConcconsisModel = new DqConcconsisModel();

        String ret;
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
        } else {
            flag=false;
            id = dqConcconsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
        }

        if (flag) {
            ret = dqConcconsisController.saveDqConcconsis(dqConcconsisModel);
        } else {
            ret = dqConcconsisController.updateDqConcconsis(id,dqConcconsisModel);
        }

        jTextAreaLogData.append("Status table DqConcconsis " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqConcconsisGroup(BigDecimal dataQualityId) {

        DqLogicalConsistencyModel dlcm = new DqLogicalConsistencyModel();
        dlcm.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqLogicalconsistency(dlcm);
        
        DqConcconsisModel dcm = new  DqConcconsisModel();
        DqLogicalConsistencyController dlcc = new DqLogicalConsistencyController(session, hibernateUtilXml);
        IdDqLogicalConsitency = dlcc.getDataById(dataQualityId).getId();
        
        dcm.setDqDataQualityId(dataQualityId);
        dcm.setDqLogicalConsistencyId(IdDqLogicalConsitency);
        
        saveUpdateDqConcconsis(dcm);
        
        //dq_element
        String columnName = DqElementModel.DQ_CONCCONSISID;
        BigDecimal IdDqConcconsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqConcconsisController DqConcconsisController = new DqConcconsisController(session, hibernateUtilXml);
        IdDqConcconsis = DqConcconsisController.getDataById(IdDqLogicalConsitency).getId();

        dqElementModel.setMeasureDescription(varDqConceptualConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqConceptualConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqConceptualConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqConcconsis, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqConcconsis, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqConceptualConsistency.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqConcConsisId(IdDqConcconsis);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqConceptualConsistency.getDateTime());
        dqElementDateTimeModel.setDqConcConsisId(IdDqConcconsis);
        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqConceptualConsistency.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqConceptualConsistency.getExplanation());
        dqConformanceResultModel.setStringPass(varDqConceptualConsistency.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqConceptualConsistency.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();
        
        ciDateModel.setStringDate_(varDqConceptualConsistency.getDate());
        ciDateModel.setDateType(varDqConceptualConsistency.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqConceptualConsistency.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop    
    //end save dq_conseptual_consistency

    //save dq_domain_consitency
    public void saveUpdateDqDomconsis(DqDomconsisModel value) {

        DqDomconsisController dqDomconsisController = new DqDomconsisController(session, hibernateUtilXml);
        DqDomconsisModel dqDomconsisModel = new DqDomconsisModel();

        String ret;
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
        } else {
            flag=false;
            id = dqDomconsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
        }

        if (flag) {
            ret = dqDomconsisController.saveDqDomconsis(dqDomconsisModel);
        } else {
            ret = dqDomconsisController.updateDqDomconsis(id,dqDomconsisModel);
        }

        jTextAreaLogData.append("Status table DqDomconsis " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqDomconsisGroup(BigDecimal dataQualityId) {

        DqDomconsisModel ddm = new DqDomconsisModel();
        ddm.setDqLogicalConsistencyId(IdDqLogicalConsitency);
        ddm.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqDomconsis(ddm);
        //dq_element
        String columnName = DqElementModel.DQ_DOMCONSISID;
        BigDecimal IdDqDomconsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqDomconsisController DqDomconsisController = new DqDomconsisController(session, hibernateUtilXml);
        IdDqDomconsis = DqDomconsisController.getDataById(IdDqLogicalConsitency).getId();

        dqElementModel.setMeasureDescription(varDqDomainConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqDomainConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqDomainConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqDomconsis, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqDomconsis, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqDomainConsistency.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqDomConsisId(IdDqDomconsis);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();

        dqElementDateTimeModel.setStringDateTime(varDqDomainConsistency.getDateTime());
        dqElementDateTimeModel.setDqDomConsisId(IdDqDomconsis);
        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqDomainConsistency.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqDomainConsistency.getTitleMeasure());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqDomainConsistency.getDateMeasure());
        cdm.setDateType(varDqDomainConsistency.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);
        
        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();
        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqDomainConsistency.getExplanation());
        dqConformanceResultModel.setStringPass(varDqDomainConsistency.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqDomainConsistency.getTitle());
        ciCitationModel.setEdition(varDqDomainConsistency.getEditionConformance());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);

        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqDomainConsistency.getDate());
        ciDateModel.setDateType(varDqDomainConsistency.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluationprocedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqDomainConsistency.getTitleEvaluation());
        cmProcedure.setEdition(varDqDomainConsistency.getEdition());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
       
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
		
        cdmProcedure.setStringDate_(varDqDomainConsistency.getDateEvaluation());
        cdmProcedure.setDateType(varDqDomainConsistency.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);
        
        CiSeriesModel csm = new CiSeriesModel();
        csm.setIssueIdentification(varDqDomainConsistency.getIssueIdentification());
        csm.setName(varDqDomainConsistency.getName());
        csm.setPage(varDqDomainConsistency.getPage());
        csm.setCiCitationId(citationProcedure);
        
        saveUpdateCiSeries(csm);
        
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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqDomainConsistency.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dq_domain_consitency

    //save dq_format_consitency
    public void saveUpdateDqFormconsis(DqFormConsisModel value) {
        
        DqFormConsisController dqFormConsisController = new DqFormConsisController(session, hibernateUtilXml);
        DqFormConsisModel dqFormConsisModel = new DqFormConsisModel();

        String ret;
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
        } else {
            flag=false;
            id = dqFormConsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
        }
        
        if (flag) {
            ret = dqFormConsisController.saveDqFormConsis(dqFormConsisModel);
        } else {
            ret = dqFormConsisController.updateDqFormConsis(id,dqFormConsisModel);
        }

        jTextAreaLogData.append("Status table DqFormconsis " + ret + "\n");

        
    }

    //dq for loop    
   
    public void saveUpdateDqFormconsisGroup(BigDecimal dataQualityId) {
        
        DqFormConsisModel dfcm = new DqFormConsisModel();
        dfcm.setDqDataQualityId(dataQualityId);
        dfcm.setDqLogicalConsistencyId(IdDqLogicalConsitency);
        
        saveUpdateDqFormconsis(dfcm);
        
        //dq_element
        String columnName = DqElementModel.DQ_FORMCONSISID;
        BigDecimal IdDqFormconsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqFormConsisController dqFormconsisController = new DqFormConsisController(session, hibernateUtilXml);
        IdDqFormconsis = dqFormconsisController.getDataById(IdDqLogicalConsitency).getId();

        dqElementModel.setMeasureDescription(varDqFormatConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqFormatConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqFormatConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqFormconsis, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqFormconsis, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqFormatConsistency.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqFormConsisId(IdDqFormconsis);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqFormatConsistency.getDateTime());
        dqElementDateTimeModel.setDqFormConsisId(IdDqFormconsis);
        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);
        
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqFormatConsistency.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqFormatConsistency.getTitleMeasure());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqFormatConsistency.getDateMeasure());
        cdm.setDateType(varDqFormatConsistency.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();
        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqFormatConsistency.getExplanation());
        dqConformanceResultModel.setStringPass(varDqFormatConsistency.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqFormatConsistency.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
         
        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqFormatConsistency.getDate());
        ciDateModel.setDateType(varDqFormatConsistency.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqFormatConsistency.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
		
        cdmProcedure.setStringDate_(varDqFormatConsistency.getDateEvaluation());
        cdmProcedure.setDateType(varDqFormatConsistency.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqFormatConsistency.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dq_format_consitency

    //save dq_Topological_consitency
    public void saveUpdateDqTopconsis(DqTopConsisModel value) {
        
        DqTopConsisController DqTopconsisController = new DqTopConsisController(session, hibernateUtilXml);
        DqTopConsisModel DqTopconsisModel = new DqTopConsisModel();

        String ret;
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
        } else {
            flag=false;
            id = DqTopconsisController.getDataById(value.getDqLogicalConsistencyId()).getId();
        }

        if (flag) {
            ret = DqTopconsisController.saveDqTopConsis(DqTopconsisModel);
        } else {
            ret = DqTopconsisController.updateDqTopConsis(id,DqTopconsisModel);
        }

        jTextAreaLogData.append("Status table DqTopconsis " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqTopconsisGroup(BigDecimal dataQualityId) {

        DqTopConsisModel dtcm = new DqTopConsisModel();
        dtcm.setDqDataQualityId(dataQualityId);
        dtcm.setDqLogicalConsistencyId(IdDqLogicalConsitency);
        
        saveUpdateDqTopconsis(dtcm);
        //dq_element
        String columnName = DqElementModel.DQ_TOPCONSISID;
        BigDecimal IdDqTopconsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqTopConsisController dqTopconsisController = new DqTopConsisController(session, hibernateUtilXml);
        IdDqTopconsis = dqTopconsisController.getDataById(IdDqLogicalConsitency).getId();

        dqElementModel.setMeasureDescription(varDqTopologicalConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqTopologicalConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqTopologicalConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqTopconsis, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqTopconsis, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqTopologicalConsistency.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqTopConsisId(IdDqTopconsis);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();

        dqElementDateTimeModel.setStringDateTime(varDqTopologicalConsistency.getDateTime());
        dqElementDateTimeModel.setDqTopConsisId(IdDqTopconsis);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqTopologicalConsistency.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqTopologicalConsistency.getTitleMeasure());
        ccm.setEdition(varDqTopologicalConsistency.getEdition());
        ccm.setStringEditionDate(varDqTopologicalConsistency.getEditionDate());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqTopologicalConsistency.getDateMeasure());
        cdm.setDateType(varDqTopologicalConsistency.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);
        
        //mdidentifier
        MdIdentifierModel mimsub = new MdIdentifierModel();
        mimsub.setCode(varDqTopologicalConsistency.getCodeIdentifier());
        mimsub.setExtendsType(nullValue);
        mimsub.setCiCitationId(citationIdSup);
        
        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationIdSup, mimsub);
       
        //citation
        CiCitationModel ccmSub = new CiCitationModel();
        BigDecimal mdIdentifierSub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationIdSup).getId();
        
        ccmSub.setTitle(varDqTopologicalConsistency.getTitleIdentifier());
        ccmSub.setMdIdentifierId(mdIdentifierSub);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub,ccmSub);
        
        //cidate
        CiDateModel cdmSub = new CiDateModel();
        BigDecimal  citationSub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub).getId();
        
        cdmSub.setStringDate_(varDqTopologicalConsistency.getDateIdentifier());
        cdmSub.setDateType(varDqTopologicalConsistency.getDateTypeIdentifier());
        cdmSub.setCiCitationId(citationSub);
        
        saveUpdateCiDate(cdmSub);
        
        //mdidentifier
        MdIdentifierModel mimsubsub = new MdIdentifierModel();
        mimsubsub.setCode(varDqTopologicalConsistency.getCodeMeasureIdentifier());
        mimsubsub.setExtendsType(nullValue);
        mimsubsub.setCiCitationId(citationSub);
        
        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationSub, mimsubsub);
       
        //citation
        CiCitationModel ccmsubsub = new CiCitationModel();
        BigDecimal mdIdentifiersubsub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationSub).getId();
        
        ccmsubsub.setTitle(varDqTopologicalConsistency.getTitleMeasureIdentifier());
        ccmsubsub.setMdIdentifierId(mdIdentifiersubsub);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifiersubsub,ccmsubsub);
        
        //cidate
        CiDateModel cdmsubsub = new CiDateModel();
        BigDecimal  citationsubsub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifiersubsub).getId();
     
        cdmsubsub.setStringDate_(varDqTopologicalConsistency.getDateMeasureIdentifier());
        cdmsubsub.setDateType(varDqTopologicalConsistency.getDateTypeMeasureIdentifier());
        cdmsubsub.setCiCitationId(citationsubsub);
        
        saveUpdateCiDate(cdmsubsub);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqTopologicalConsistency.getExplanation());
        dqConformanceResultModel.setStringPass(varDqTopologicalConsistency.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqTopologicalConsistency.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);
        
        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
       
        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();
        ciDateModel.setStringDate_(varDqTopologicalConsistency.getDate());
        ciDateModel.setDateType(varDqTopologicalConsistency.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqTopologicalConsistency.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
		
        cdmProcedure.setStringDate_(varDqTopologicalConsistency.getDateEvaluation());
        cdmProcedure.setDateType(varDqTopologicalConsistency.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqTopologicalConsistency.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //save dq_Topological_consitency

    //save dq_Absolute_External_Positional_Accuracy
    public void saveUpdateDqPositionalAccuracy(DqPositionalAccuracyModel value) {
        
        DqPositionalAccuracyController DqPositionalAccuracyController = new DqPositionalAccuracyController(session, hibernateUtilXml);
        DqPositionalAccuracyModel DqPositionalAccuracyModel = new DqPositionalAccuracyModel();

        String ret;
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
        } else {
            flag=false;
            id = DqPositionalAccuracyController.getDataById(value.getDqDataQualityId()).getId();
                  
        }

        if (flag) {
            ret = DqPositionalAccuracyController.saveDqPositionalAccuracy(DqPositionalAccuracyModel);
        } else {
            ret = DqPositionalAccuracyController.updateDqPositionalAccuracy(id,DqPositionalAccuracyModel);
        }

        jTextAreaLogData.append("Status table DqPositionalAccuracy " + ret + "\n");

    }

    public void saveUpdateDqAbsextPosAcc(DqAbsextposaccModel value) {
        
        DqAbsextposaccController DqAbsextposaccController = new DqAbsextposaccController(session, hibernateUtilXml);
        DqAbsextposaccModel DqAbsextposaccModel = new DqAbsextposaccModel();
        
        String ret;
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
        } else {
            flag=false;
            id = DqAbsextposaccController.getDataById(value.getDqPositionalAccuracyId()).getId();
        }

        if (flag) {
            ret = DqAbsextposaccController.saveDqAbsextposacc(DqAbsextposaccModel);
        } else {
            ret = DqAbsextposaccController.updateDqAbsextposacc(id,DqAbsextposaccModel);
        }

        jTextAreaLogData.append("Status table DqAbsextposacc " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqAbsextPosAccGroup(BigDecimal dataQualityId) {

        
        //DqPositionalAccuracy
        DqPositionalAccuracyModel dpam = new DqPositionalAccuracyModel();
        dpam.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqPositionalAccuracy(dpam);
        
        //DqAbsextposacc
        DqAbsextposaccModel dam = new DqAbsextposaccModel();
        DqPositionalAccuracyController dpac = new DqPositionalAccuracyController(session, hibernateUtilXml);
        IdDqPositionalAccuracy = dpac.getDataById(dataQualityId).getId();
        
        dam.setDqDataQualityId(dataQualityId);
        dam.setDqPositionalAccuracyId(IdDqPositionalAccuracy);
        
        saveUpdateDqAbsextPosAcc(dam);
        
        //dq_element
        String columnName = DqElementModel.DQ_ABSEXTPOSACCID;
        BigDecimal IdDqAbsextPosAcc;
        DqElementModel dqElementModel = new DqElementModel();
        DqAbsextposaccController dqAbsextPosAccController = new DqAbsextposaccController(session, hibernateUtilXml);
        IdDqAbsextPosAcc = dqAbsextPosAccController.getDataById(IdDqPositionalAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqAbsoluteExternalPositionalAccuracy.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqAbsoluteExternalPositionalAccuracy.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqAbsoluteExternalPositionalAccuracy.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);
   
        saveUpdateDqElement(IdDqAbsextPosAcc, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqAbsextPosAcc, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqAbsoluteExternalPositionalAccuracy.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqAbsExtPosAccId(IdDqAbsextPosAcc);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();

        dqElementDateTimeModel.setStringDateTime(varDqAbsoluteExternalPositionalAccuracy.getDateTime());
        dqElementDateTimeModel.setDqAbsExtPosAccId(IdDqAbsextPosAcc);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
        
        //measuredescription
        MdIdentifierModel mim = new MdIdentifierModel();

        mim.setCode(varDqAbsoluteExternalPositionalAccuracy.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID,IdDqElement, mim);

        //cicitation
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,IdDqElement).getId();
       
        CiCitationModel citationModel = new CiCitationModel();
      
        citationModel.setTitle(varDqAbsoluteExternalPositionalAccuracy.getTitleMeasure());
        citationModel.setMdIdentifierId(mdIdentifierId);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierId,citationModel);
   
        //cidate
        CiDateModel cd = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationMeasure = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierId).getId();

        cd.setStringDate_(varDqAbsoluteExternalPositionalAccuracy.getDateMeasure());
        cd.setDateType(varDqAbsoluteExternalPositionalAccuracy.getDateTypeMeasure());
        cd.setCiCitationId(citationMeasure);
        
        saveUpdateCiDate(cd);
        
        //measeuredescription
        
        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqAbsoluteExternalPositionalAccuracy.getExplanation());
        dqConformanceResultModel.setStringPass(varDqAbsoluteExternalPositionalAccuracy.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqAbsoluteExternalPositionalAccuracy.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        BigDecimal CiCitationId = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        cdm.setStringDate_(varDqAbsoluteExternalPositionalAccuracy.getDate());
        cdm.setDateType(varDqAbsoluteExternalPositionalAccuracy.getDateType());
        cdm.setCiCitationId(CiCitationId);

        saveUpdateCiDate(cdm);
        
        //evaluation procedure
        CiCitationModel ccm = new CiCitationModel();
        
        ccm.setTitle(varDqAbsoluteExternalPositionalAccuracy.getTitleEvaluation());
        ccm.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement, ccm);

        //cidate
        CiDateModel ciDateModel = new CiDateModel();
        BigDecimal CiCitationEvaluation = ciCitationController.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

        ciDateModel.setStringDate_(varDqAbsoluteExternalPositionalAccuracy.getDateEvaluation());
        ciDateModel.setDateType(varDqAbsoluteExternalPositionalAccuracy.getDateTypeEvaluation());
        ciDateModel.setCiCitationId(CiCitationEvaluation);

        saveUpdateCiDate(cdm);
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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqAbsoluteExternalPositionalAccuracy.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //save dq_Absolute_External_Positional_Accuracy

    //save dq_Gridded_Data_Positional_Accuracy
    public void saveUpdateDqGridDataPosAcc(DqGridDataPosAccModel value) {
        
        DqGridDataPosAccController DqGridDataPosAccController = new DqGridDataPosAccController(session, hibernateUtilXml);
        DqGridDataPosAccModel DqGridDataPosAccModel = new DqGridDataPosAccModel();

        String ret;
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
        } else {
            flag=false;
            id = DqGridDataPosAccController.getDataById(value.getDqPositionalAccuracyId()).getId();
        }

        if (flag) {
            ret = DqGridDataPosAccController.saveDqGridDataPosAcc(DqGridDataPosAccModel);
        } else {
            ret = DqGridDataPosAccController.updateDqGridDataPosAcc(id,DqGridDataPosAccModel);
        }

        jTextAreaLogData.append("Status table DqGridDataPosAcc " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqGridDataPosAccGroup(BigDecimal dataQualityId) {
        
        DqGridDataPosAccModel dgdpam = new DqGridDataPosAccModel();
        dgdpam.setDqDataQualityId(dataQualityId);
        dgdpam.setDqPositionalAccuracyId(IdDqPositionalAccuracy);

        saveUpdateDqGridDataPosAcc(dgdpam);
        
        //dq_element
        String columnName =  DqElementModel.DQ_GRIDDATAPOSACCID;
        BigDecimal IdDqGridDataPosAcc;
        DqElementModel dqElementModel = new DqElementModel();
        DqGridDataPosAccController dqGridDataPosAccController = new DqGridDataPosAccController(session, hibernateUtilXml);
        IdDqGridDataPosAcc = dqGridDataPosAccController.getDataById(IdDqPositionalAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqGriddedDataPositionalAccuracy.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqGriddedDataPositionalAccuracy.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqGriddedDataPositionalAccuracy.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqGridDataPosAcc, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqGridDataPosAcc, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqGriddedDataPositionalAccuracy.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqGridDataPosAccId(IdDqGridDataPosAcc);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqGriddedDataPositionalAccuracy.getDateTime());
        dqElementDateTimeModel.setDqGridDataPosAccId(IdDqGridDataPosAcc);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqGriddedDataPositionalAccuracy.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqGriddedDataPositionalAccuracy.getTitleMeasure());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqGriddedDataPositionalAccuracy.getDateMeasure());
        cdm.setDateType(varDqGriddedDataPositionalAccuracy.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);        

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqGriddedDataPositionalAccuracy.getExplanation());
        dqConformanceResultModel.setStringPass(varDqGriddedDataPositionalAccuracy.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqGriddedDataPositionalAccuracy.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqGriddedDataPositionalAccuracy.getDate());
        ciDateModel.setDateType(varDqGriddedDataPositionalAccuracy.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqGriddedDataPositionalAccuracy.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
		
        cdmProcedure.setStringDate_(varDqGriddedDataPositionalAccuracy.getDateEvaluation());
        cdmProcedure.setDateType(varDqGriddedDataPositionalAccuracy.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqGriddedDataPositionalAccuracy.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //save dq_Gridded_Data_Positional_Accuracy

    //save dq_relative_internal_Positional_Accuracy
    public void saveUpdateDqRellntPosAcc(DqRellntPosAccModel value) {
         
        DqRellntPosAccController DqRellntPosAccController = new DqRellntPosAccController(session, hibernateUtilXml);
        DqRellntPosAccModel DqRellntPosAccModel = new DqRellntPosAccModel();

        String ret;
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
        } else {
            flag=false;
            id = DqRellntPosAccController.getDataById(value.getDqPositionalAccuracyId()).getId();
        }

        if (flag) {
            ret = DqRellntPosAccController.saveDqRellntPosAcc(DqRellntPosAccModel);
        } else {
            ret = DqRellntPosAccController.updateDqRellntPosAcc(id,DqRellntPosAccModel);
        }

        jTextAreaLogData.append("Status table DqRellntPosAcc " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqRellntPosAccGroup(BigDecimal dataQualityId) {

        DqRellntPosAccModel drpam = new DqRellntPosAccModel();
        drpam.setDqDataQualityId(dataQualityId);
        drpam.setDqPositionalAccuracyId(IdDqPositionalAccuracy);
        
        saveUpdateDqRellntPosAcc(drpam);
        //dq_element
        String columnName = DqElementModel.DQ_RELLNTPOSACCID;
        BigDecimal IdDqRellntPosAcc;
        DqElementModel dqElementModel = new DqElementModel();
        DqRellntPosAccController dqRellntPosAccController = new DqRellntPosAccController(session, hibernateUtilXml);
        IdDqRellntPosAcc = dqRellntPosAccController.getDataById(IdDqPositionalAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqRelativeInternalPositionalAccuracy.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqRelativeInternalPositionalAccuracy.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqRelativeInternalPositionalAccuracy.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqRellntPosAcc, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqRellntPosAcc, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqRelativeInternalPositionalAccuracy.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqRellNtPosAccId(IdDqRellntPosAcc);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqRelativeInternalPositionalAccuracy.getDateTime());
        dqElementDateTimeModel.setDqRellNtPosAccId(IdDqRellntPosAcc);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqRelativeInternalPositionalAccuracy.getExplanation());
        dqConformanceResultModel.setStringPass(varDqRelativeInternalPositionalAccuracy.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqRelativeInternalPositionalAccuracy.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();
        
        cdm.setStringDate_(varDqCompletenessOmission.getDateEvaluation());
        cdm.setDateType(varDqCompletenessOmission.getDateTypeEvaluation());
        cdm.setCiCitationId(citationConformance);

        saveUpdateCiDate(cdm);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqRelativeInternalPositionalAccuracy.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //save dq_relative_internal_Positional_Accuracy

    //save dq_accuracyOfATimeMeasurement
    public void saveUpdateDqTemporalAccuracy(DqTemporalAccuracyModel value) {
        
        DqTemporalAccuracyController DqTemporalAccuracyController = new DqTemporalAccuracyController(session, hibernateUtilXml);
        DqTemporalAccuracyModel DqTemporalAccuracyModel = new DqTemporalAccuracyModel();

        String ret;
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
        } else {
            flag=false;
            id = DqTemporalAccuracyController.getDataById(value.getDqDataQualityId()).getId();
        }

        if(flag) {
            ret = DqTemporalAccuracyController.saveDqTemporalAccuracy(DqTemporalAccuracyModel);
        }else{
            ret = DqTemporalAccuracyController.updateDqTemporalAccuracy(id,DqTemporalAccuracyModel);
        }

        jTextAreaLogData.append("Status table DqTemporalAccuracy " + ret + "\n");

    }

    public void saveUpdateDqAccTimeMeAs(DqAccTimeMeAsModel value) {
        
        DqAccTimeMeAsController DqAccTimeMeAsController = new DqAccTimeMeAsController(session, hibernateUtilXml);
        DqAccTimeMeAsModel DqAccTimeMeAsModel = new DqAccTimeMeAsModel();

        String ret;
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
        } else {
            flag=false;
            id = DqAccTimeMeAsController.getDataById(value.getDqTemporalAccuracyId()).getId();
        }

        if (flag) {
            ret = DqAccTimeMeAsController.saveDqAccTimeMeAs(DqAccTimeMeAsModel);
        } else {
            ret = DqAccTimeMeAsController.updateDqAccTimeMeAs(id,DqAccTimeMeAsModel);
        }

        jTextAreaLogData.append("Status table DqAccTimeMeAs " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqAccTimeMeAsGroup(BigDecimal dataQualityId) {

        //DqTemporalAccuracy
        DqTemporalAccuracyModel dtam = new DqTemporalAccuracyModel();
        dtam.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqTemporalAccuracy(dtam);
        
        //DqAccTimeMeAs
        DqAccTimeMeAsModel asModel = new DqAccTimeMeAsModel();
        DqTemporalAccuracyController dtac = new DqTemporalAccuracyController(session, hibernateUtilXml);
        
        IdDqTemporalAccuracy = dtac.getDataById(dataQualityId).getId();
        
        asModel.setDqDataQualityId(dataQualityId);
        asModel.setDqTemporalAccuracyId(IdDqTemporalAccuracy);
        
        saveUpdateDqAccTimeMeAs(asModel);
        
        //dq_element
        String columnName = DqElementModel.DQ_ACCTIMEMEASID;
        BigDecimal IdDqAccTimeMeAs;
        DqElementModel dqElementModel = new DqElementModel();
        DqAccTimeMeAsController dqAccTimeMeAsController = new DqAccTimeMeAsController(session, hibernateUtilXml);
        IdDqAccTimeMeAs = dqAccTimeMeAsController.getDataById(IdDqTemporalAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqAccuracyOfATimeMeasurement.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqAccuracyOfATimeMeasurement.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqAccuracyOfATimeMeasurement.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqAccTimeMeAs, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqAccTimeMeAs, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqAccuracyOfATimeMeasurement.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqAccTimeMeAsId(IdDqAccTimeMeAs);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqAccuracyOfATimeMeasurement.getDateTime());
        dqElementDateTimeModel.setDqAccTimeMeAsId(IdDqAccTimeMeAs);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
        
        //measuredescription
        MdIdentifierModel mim = new MdIdentifierModel();

        mim.setCode(varDqAccuracyOfATimeMeasurement.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID,IdDqElement, mim);

        //cicitation
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,IdDqElement).getId();
       
        CiCitationModel citationModel = new CiCitationModel();
      
        citationModel.setTitle(varDqAccuracyOfATimeMeasurement.getTitleMeasure());
        citationModel.setMdIdentifierId(mdIdentifierId);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierId,citationModel);
   
        //cidate
        CiDateModel cd = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationMeasure = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierId).getId();

        cd.setStringDate_(varDqAccuracyOfATimeMeasurement.getDateMeasure());
        cd.setDateType(varDqAccuracyOfATimeMeasurement.getDateTypeMeasure());
        cd.setCiCitationId(citationMeasure);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqAccuracyOfATimeMeasurement.getExplanation());
        dqConformanceResultModel.setStringPass(varDqAccuracyOfATimeMeasurement.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation       
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqAccuracyOfATimeMeasurement.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult, ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        BigDecimal CiCitationId = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        cdm.setStringDate_(varDqAccuracyOfATimeMeasurement.getDate());
        cdm.setDateType(varDqAccuracyOfATimeMeasurement.getDateType());
        cdm.setCiCitationId(CiCitationId);
        
        saveUpdateCiDate(cdm);
        
        //evaluation procedure
        CiCitationModel ccm = new CiCitationModel();
        
        ccm.setTitle(varDqAccuracyOfATimeMeasurement.getTitleEvaluation());
        ccm.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement, ccm);

        //cidate
        CiDateModel ciDateModel = new CiDateModel();
        BigDecimal CiCitationEvaluation = ciCitationController.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();

        ciDateModel.setStringDate_(varDqAccuracyOfATimeMeasurement.getDateEvaluation());
        ciDateModel.setDateType(varDqAccuracyOfATimeMeasurement.getDateTypeEvaluation());
        ciDateModel.setCiCitationId(CiCitationEvaluation);
        
        saveUpdateCiDate(ciDateModel);
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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqAccuracyOfATimeMeasurement.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dq_accuracyOfATimeMeasurement

    //save dq_TemporalConsistency
    public void saveUpdateDqTempConsis(DqTempConsisModel value) {
         
        DqTempConsisController DqTempConsisController = new DqTempConsisController(session, hibernateUtilXml);
        DqTempConsisModel DqTempConsisModel = new DqTempConsisModel();

        String ret;
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
        } else {
            flag=false;
            id = DqTempConsisController.getDataById(value.getDqTemporalAccuracyId()).getId();
        }

        if (flag) {
            ret = DqTempConsisController.saveDqTempConsis(DqTempConsisModel);
        } else {
            ret = DqTempConsisController.updateDqTempConsis(id,DqTempConsisModel);
        }

        jTextAreaLogData.append("Status table DqTempConsis " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqTempConsisGroup(BigDecimal dataQualityId) {

        DqTempConsisModel dtcm = new DqTempConsisModel();
        dtcm.setDqDataQualityId(dataQualityId);
        dtcm.setDqTemporalAccuracyId(IdDqTemporalAccuracy);
        
        saveUpdateDqTempConsis(dtcm);
        
        //dq_element
        String columnName = DqElementModel.DQ_TEMPCONSISID;
        BigDecimal IdDqTempConsis;
        DqElementModel dqElementModel = new DqElementModel();
        DqTempConsisController dqTempConsisController = new DqTempConsisController(session, hibernateUtilXml);
        IdDqTempConsis = dqTempConsisController.getDataById(IdDqTemporalAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqTemporalConsistency.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqTemporalConsistency.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqTemporalConsistency.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqTempConsis, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqTempConsis, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqTemporalConsistency.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqTempConsisId(IdDqTempConsis);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqTemporalConsistency.getDateTime());
        dqElementDateTimeModel.setDqTempConsisId(IdDqTempConsis);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqTemporalConsistency.getExplanation());
        dqConformanceResultModel.setStringPass(varDqTemporalConsistency.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqTemporalConsistency.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqTemporalConsistency.getDate());
        ciDateModel.setDateType(varDqTemporalConsistency.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqTemporalConsistency.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dq_TemporalConsistency

    //save dq_Temporalvalidity
    public void saveUpdateDqTempValid(DqTempValidModel value) {
        
        DqTempValidController DqTempValidController = new DqTempValidController(session, hibernateUtilXml);
        DqTempValidModel DqTempValidModel = new DqTempValidModel();

        String ret;
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
        } else {
            flag=false;
            id = DqTempValidController.getDataById(value.getDqTemporalAccuracyId()).getId();
        }

        if (flag) {
            ret = DqTempValidController.saveDqTempValid(DqTempValidModel);
        } else {
            ret = DqTempValidController.updateDqTempValid(id,DqTempValidModel);
        }

        jTextAreaLogData.append("Status table DqTempValid " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqTempValidGroup(BigDecimal dataQualityId) {

        DqTempValidModel dtvm = new DqTempValidModel();
        dtvm.setDqDataQualityId(dataQualityId);
        dtvm.setDqTemporalAccuracyId(IdDqTemporalAccuracy);
        
        saveUpdateDqTempValid(dtvm);
        //dq_element
        String columnName = DqElementModel.DQ_TEMPVALIDID;
        BigDecimal IdDqTempValid;
        DqElementModel dqElementModel = new DqElementModel();
        DqTempValidController dqTempValidController = new DqTempValidController(session, hibernateUtilXml);
        IdDqTempValid = dqTempValidController.getDataById(IdDqTemporalAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqTemporalValidity.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqTemporalValidity.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqTemporalValidity.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqTempValid, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqTempValid, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqTemporalValidity.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqTempValidId(IdDqTempValid);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqTemporalValidity.getDateTime());
        dqElementDateTimeModel.setDqTempValidId(IdDqTempValid);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqTemporalValidity.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqTemporalValidity.getTitleMeasure());
        ccm.setEdition(varDqTemporalValidity.getEdition());
        ccm.setStringEditionDate(varDqTemporalValidity.getEditionDate());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqTemporalValidity.getDateMeasure());
        cdm.setDateType(varDqTemporalValidity.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();
        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqTemporalValidity.getExplanation());
        dqConformanceResultModel.setStringPass(varDqTemporalValidity.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();
        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
       
        ciCitationModel.setTitle(varDqTemporalValidity.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();
       
        ciDateModel.setStringDate_(varDqTemporalValidity.getDate());
        ciDateModel.setDateType(varDqTemporalValidity.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqTemporalValidity.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
		
        cdmProcedure.setStringDate_(varDqTemporalValidity.getDateEvaluation());
        cdmProcedure.setDateType(varDqTemporalValidity.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqTemporalValidity.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //save dq_Temporalvalidity

    //save dqThematicClassificationCorrectness
    public void saveUpdateDqThematicAccuracy(DqThematicAccuracyModel value) {
        
        DqThematicAccuracyController DqThematicAccuracyController = new DqThematicAccuracyController(session, hibernateUtilXml);
        DqThematicAccuracyModel DqThematicAccuracyModel = new DqThematicAccuracyModel();

        String ret;
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
        } else {
            flag=false;
            id = DqThematicAccuracyController.getDataById(value.getDqDataQualityId()).getId();
        }

        if (flag) {
            ret = DqThematicAccuracyController.saveDqThematicAccuracy(DqThematicAccuracyModel);
        } else {
            ret = DqThematicAccuracyController.updateDqThematicAccuracy(id,DqThematicAccuracyModel);
        }

        jTextAreaLogData.append("Status table DqThematicAccuracy " + ret + "\n");

    }

    public void saveUpdateDqThemClassCor(DqThemClassCorModel value) {
         
        DqThemClassCorController DqThemClassCorController = new DqThemClassCorController(session, hibernateUtilXml);
        DqThemClassCorModel DqThemClassCorModel = new DqThemClassCorModel();

        String ret;
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
        } else {
            flag=false;
            id = DqThemClassCorController.getDataById(value.getDqThematicAccuracyId()).getId();
        }

        if (flag) {
            ret = DqThemClassCorController.saveDqThemClassCor(DqThemClassCorModel);
        } else {
            ret = DqThemClassCorController.updateDqThemClassCor(id,DqThemClassCorModel);
        }

        jTextAreaLogData.append("Status table DqThemClassCor " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqThemClassCorGroup(BigDecimal dataQualityId) {

        DqThematicAccuracyModel dtam = new DqThematicAccuracyModel();
        dtam.setDqDataQualityId(dataQualityId);
        
        saveUpdateDqThematicAccuracy(dtam);
        
        DqThemClassCorModel dtccm = new DqThemClassCorModel();
        DqThematicAccuracyController dtac = new DqThematicAccuracyController(session, hibernateUtilXml);
        IdDqThematicAccuracy = dtac.getDataById(dataQualityId).getId();
        
        dtccm.setDqDataQualityId(dataQualityId);
        dtccm.setDqThematicAccuracyId(IdDqThematicAccuracy);
        
        saveUpdateDqThemClassCor(dtccm);
        //dq_element
        String columnName = DqElementModel.DQ_THEMCLASSCORID;
        BigDecimal IdDqThemClassCor;
        DqElementModel dqElementModel = new DqElementModel();
        DqThemClassCorController dqThemClassCorController = new DqThemClassCorController(session, hibernateUtilXml);
        IdDqThemClassCor = dqThemClassCorController.getDataById(IdDqThematicAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqThematicClassificationCorrectness.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqThematicClassificationCorrectness.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqThematicClassificationCorrectness.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqThemClassCor, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqThemClassCor, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqThematicClassificationCorrectness.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqThemClassCorId(IdDqThemClassCor);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqThematicClassificationCorrectness.getDateTime());
        dqElementDateTimeModel.setDqThemClassCorId(IdDqThemClassCor);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqThematicClassificationCorrectness.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqThematicClassificationCorrectness.getTitleMeasure());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqThematicClassificationCorrectness.getDateMeasure());
        cdm.setDateType(varDqThematicClassificationCorrectness.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);
        
        //citation_alternate_title
        CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();
      
        ccatm.setAlternateTitle(varDqThematicClassificationCorrectness.getAlternateTitle());
        ccatm.setCi_citationid(citationIdSup);

        saveUpdateCiCitationAlternateTitle(ccatm);
        
        //mdidentifier
        MdIdentifierModel mimsub = new MdIdentifierModel();
        mimsub.setCode(varDqThematicClassificationCorrectness.getCodeIdentifier());
        mimsub.setExtendsType(nullValue);
        mimsub.setCiCitationId(citationIdSup);
        
        saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationIdSup, mimsub);
       
        //citation
        CiCitationModel ccmSub = new CiCitationModel();
        BigDecimal mdIdentifierSub = mic.getDataById(MdIdentifierModel.CICITATIONID, citationIdSup).getId();
        
        ccmSub.setTitle(varDqThematicClassificationCorrectness.getTitleIdentifier());
        ccmSub.setMdIdentifierId(mdIdentifierSub);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub,ccmSub);
        
        //cidate
        CiDateModel cdmSub = new CiDateModel();
        BigDecimal  citationSub = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierSub).getId();
        
        cdmSub.setStringDate_(varDqThematicClassificationCorrectness.getDateIdentifier());
        cdmSub.setDateType(varDqThematicClassificationCorrectness.getDateTypeIdentifier());
        cdmSub.setCiCitationId(citationSub);
        
        saveUpdateCiDate(cdmSub);
        
        CiCitationAlternateTitleModel ccatmsub = new CiCitationAlternateTitleModel();
      
        ccatmsub.setAlternateTitle(varDqThematicClassificationCorrectness.getAlternateTitleIdentifier());
        ccatmsub.setCi_citationid(citationSub);

        saveUpdateCiCitationAlternateTitle(ccatmsub);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqThematicClassificationCorrectness.getExplanation());
        dqConformanceResultModel.setStringPass(varDqThematicClassificationCorrectness.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqThematicClassificationCorrectness.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqThematicClassificationCorrectness.getDate());
        ciDateModel.setDateType(varDqThematicClassificationCorrectness.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqThematicClassificationCorrectness.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dqThematicClassificationCorrectness

    //save dqNonQuantitativeAttributeAccuracy
    public void saveUpdateDqNonQuanAttacc(DqNonQuanAttaccModel value) {
                
        DqNonQuanAttaccController DqNonQuanAttaccController = new DqNonQuanAttaccController(session, hibernateUtilXml);
        DqNonQuanAttaccModel DqNonQuanAttaccModel = new DqNonQuanAttaccModel();

        String ret;
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
        } else {
            flag=false;
            id = DqNonQuanAttaccController.getDataById(value.getDqThematicAccuracyId()).getId();
        }

        if (flag) {
            ret = DqNonQuanAttaccController.saveDqNonQuanAttacc(DqNonQuanAttaccModel);
        } else {
            ret = DqNonQuanAttaccController.updateDqNonQuanAttacc(id,DqNonQuanAttaccModel);
        }

        jTextAreaLogData.append("Status table DqNonQuanAttacc " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqNonQuanAttaccGroup(BigDecimal dataQualityId) {

        DqNonQuanAttaccModel dnqam = new DqNonQuanAttaccModel();
        dnqam.setDqDataQualityId(dataQualityId);
        dnqam.setDqThematicAccuracyId(IdDqThematicAccuracy);
        
        saveUpdateDqNonQuanAttacc(dnqam);
        //dq_element
        String columnName = DqElementModel.DQ_NONQUANATTACCID;
        BigDecimal IdDqNonQuanAttacc;
        DqElementModel dqElementModel = new DqElementModel();
        DqNonQuanAttaccController dqNonQuanAttaccController = new DqNonQuanAttaccController(session, hibernateUtilXml);
        IdDqNonQuanAttacc = dqNonQuanAttaccController.getDataById(IdDqThematicAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqNonQuantitativeAttributeAccuracy.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqNonQuantitativeAttributeAccuracy.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqNonQuantitativeAttributeAccuracy.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqNonQuanAttacc, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqNonQuanAttacc, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqNonQuantitativeAttributeAccuracy.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqNonQuanAttaccId(IdDqNonQuanAttacc);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqNonQuantitativeAttributeAccuracy.getDateTime());
        dqElementDateTimeModel.setDqNonQuanAttaccId(IdDqNonQuanAttacc);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqNonQuantitativeAttributeAccuracy.getExplanation());
        dqConformanceResultModel.setStringPass(varDqNonQuantitativeAttributeAccuracy.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqNonQuantitativeAttributeAccuracy.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        CiCitationController ciCitationController = new CiCitationController(session, hibernateUtilXml);
        
        BigDecimal citationConformance = ciCitationController.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();

        ciDateModel.setStringDate_(varDqNonQuantitativeAttributeAccuracy.getDate());
        ciDateModel.setDateType(varDqNonQuantitativeAttributeAccuracy.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqNonQuantitativeAttributeAccuracy.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dqNonQuantitativeAttributeAccuracy

    //save dqQuantitativeAttributeAccuracy
    public void saveUpdateDqQuanAttacc(DqQuanAttacModel value) {

        DqQuanAttacController DqQuanAttacController = new DqQuanAttacController(session, hibernateUtilXml);
        DqQuanAttacModel DqQuanAttacModel = new DqQuanAttacModel();

        String ret;
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
        } else {
            flag=false;
            id = DqQuanAttacController.getDataById(value.getDqThematicAccuracyId()).getId();
        }

        if (flag) {
            ret = DqQuanAttacController.saveDqQuanAttac(DqQuanAttacModel);
        } else {
            ret = DqQuanAttacController.updateDqQuanAttac(id,DqQuanAttacModel);
        }

        jTextAreaLogData.append("Status table DqQuanAttac " + ret + "\n");

    }

    //dq for loop
    public void saveUpdateDqQuanAttaccGroup(BigDecimal dataQualityId) {

        DqQuanAttacModel dqam = new DqQuanAttacModel();
        dqam.setDqDataQualityId(dataQualityId);
        dqam.setDqThematicAccuracyId(IdDqThematicAccuracy);
        
        saveUpdateDqQuanAttacc(dqam);
        //dq_element
        String columnName = DqElementModel.DQ_QUANATTACCID;
        BigDecimal IdDqQuanAttacc;
        DqElementModel dqElementModel = new DqElementModel();
        DqQuanAttacController dqQuanAttaccController = new DqQuanAttacController(session, hibernateUtilXml);
        IdDqQuanAttacc = dqQuanAttaccController.getDataById(IdDqThematicAccuracy).getId();

        dqElementModel.setMeasureDescription(varDqQuantitativeAttributeAccuracy.getMeasureDescription());
        dqElementModel.setEvaluationMethodType(varDqQuantitativeAttributeAccuracy.getEvaluationMethodType());
        dqElementModel.setEvaluationMethodDescription(varDqQuantitativeAttributeAccuracy.getEvaluationMethodDescription());
        dqElementModel.setDqDataQualityId(dataQualityId);

        saveUpdateDqElement(IdDqQuanAttacc, columnName, dqElementModel);

        //dq_element_name_of_measure
        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        BigDecimal IdDqElement = dqElementController.getDataById(IdDqQuanAttacc, columnName).getId();
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();
        dqElementNameOfMeasureModel.setNameOfMeasure(varDqQuantitativeAttributeAccuracy.getNameOfMeasure());
        dqElementNameOfMeasureModel.setDqQuanAttaccId(IdDqQuanAttacc);

        saveUpdateDqElementNameOfMeasure(IdDqElement, columnName, dqElementNameOfMeasureModel);

        //dq_element_datetime
        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        dqElementDateTimeModel.setStringDateTime(varDqQuantitativeAttributeAccuracy.getDateTime());
        dqElementDateTimeModel.setDqQuanAttaccId(IdDqQuanAttacc);

        saveUpdateDqElementDateTime(IdDqElement, columnName, dqElementDateTimeModel);
        
        //measureidentification
        //mdidentifier
        MdIdentifierModel mim = new MdIdentifierModel();
        mim.setCode(varDqQuantitativeAttributeAccuracy.getCode());
        mim.setExtendsType(nullValue);
        mim.setDqElementId(IdDqElement);

        saveUpdateMdIdentifier(MdIdentifierModel.DQELEMENTID, IdDqElement, mim);
        
        //citation
        CiCitationModel ccm = new CiCitationModel();
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        BigDecimal mdIdentifierIdSup = mic.getDataById(MdIdentifierModel.DQELEMENTID, IdDqElement).getId();
        
        ccm.setTitle(varDqQuantitativeAttributeAccuracy.getTitleMeasure());
        ccm.setEdition(varDqQuantitativeAttributeAccuracy.getEdition());
        ccm.setMdIdentifierId(mdIdentifierIdSup);

        saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup,ccm);
        
        //cidate
        CiDateModel cdm = new CiDateModel();
        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
        BigDecimal citationIdSup = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierIdSup).getId();
        
        cdm.setStringDate_(varDqQuantitativeAttributeAccuracy.getDateMeasure());
        cdm.setDateType(varDqQuantitativeAttributeAccuracy.getDateTypeMeasure());
        cdm.setCiCitationId(citationIdSup);
        
        saveUpdateCiDate(cdm);

        //dq_result
        saveUpdateDqResult(IdDqElement, columnName);

        //dq_conformanceresult
        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();
        BigDecimal IdDqResult = dqResultController.getDataById(IdDqElement).getId();

        dqConformanceResultModel.setDqResultId(IdDqResult);
        dqConformanceResultModel.setExplanation(varDqQuantitativeAttributeAccuracy.getExplanation());
        dqConformanceResultModel.setStringPass(varDqQuantitativeAttributeAccuracy.getPass());

        saveUpdateDQConformanceResult(columnName, dqConformanceResultModel);

        //dq_conformanceresult_citation
        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        CiCitationModel ciCitationModel = new CiCitationModel();

        BigDecimal IdDqConformanceResult = dqConformanceResultController.getDataById(IdDqResult).getDqResultId();
        ciCitationModel.setTitle(varDqQuantitativeAttributeAccuracy.getTitle());
        ciCitationModel.setDqConformanceResultId(IdDqConformanceResult);

        saveUpdateCiCitation(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult,ciCitationModel);

        //dq_conformanceresult_cidate
        CiDateModel ciDateModel = new CiDateModel();
        BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID,IdDqConformanceResult).getId();
        
        ciDateModel.setStringDate_(varDqQuantitativeAttributeAccuracy.getDate());
        ciDateModel.setDateType(varDqQuantitativeAttributeAccuracy.getDateType());
        ciDateModel.setCiCitationId(citationConformance);

        saveUpdateCiDate(ciDateModel);
        
        //evaluation procedure
        //citation
        CiCitationModel cmProcedure = new CiCitationModel();
           
        cmProcedure.setTitle(varDqQuantitativeAttributeAccuracy.getTitleEvaluation());
        cmProcedure.setDqElementId(IdDqElement);

        saveUpdateCiCitation(CiCitationModel.DQELEMENTID,IdDqElement,cmProcedure);
        //cidate
        CiDateModel cdmProcedure = new CiDateModel();
        BigDecimal citationProcedure = ccc.getDataById(CiCitationModel.DQELEMENTID,IdDqElement).getId();
		
	cdmProcedure.setStringDate_(varDqQuantitativeAttributeAccuracy.getDateEvaluation());
        cdmProcedure.setDateType(varDqQuantitativeAttributeAccuracy.getDateTypeEvaluation());
        cdmProcedure.setCiCitationId(citationProcedure);

        saveUpdateCiDate(cdmProcedure);

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

        //dq_quantitativeresult_value
        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();
        BigDecimal IdDqQuantitativeResult;
        IdDqQuantitativeResult = dqQuantitativeResultController.getDataById(IdDqResult).getDqResultId();

        dqQuantitativeResultValueModel.setDqQuantitativeResultId(IdDqQuantitativeResult);
        dqQuantitativeResultValueModel.setValue(varDqQuantitativeAttributeAccuracy.getValue());

        saveUpdateDqQuantitativeResultValue(columnName, dqQuantitativeResultValueModel);

    }
    //end dq for loop
    //end save dqQuantitativeAttributeAccuracy

    //save li_lineage
    public void saveUpdateLiLineage(LiLineageModel value) {
         
        LiLineageController liLineageController = new LiLineageController(session, hibernateUtilXml);
        LiLineageModel liLineageModel = new LiLineageModel();

        boolean flag=false;
        String ret;
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
        } else {
            flag=false;
            id = liLineageController.getDataById(value.getDqDataQualityId()).getId();
        }

        if (flag) {
            ret = liLineageController.saveLiLineage(liLineageModel);
        } else {
            ret = liLineageController.updateLiLineage(id,liLineageModel);
        }

        jTextAreaLogData.append("Status table LiLineage " + ret + "\n");

    }

    public void saveUpdateLiProcessStep(String column, BigDecimal foreignId,LiProcessStepModel value) {

        LiProcessStepController liProcessStepController = new LiProcessStepController(session, hibernateUtilXml);
        LiProcessStepModel liProcessStepModel = new LiProcessStepModel();
      
        boolean flag=false;
        String ret;
        BigDecimal getIdLiProcessStep;
        BigDecimal idLiProcessStep;
        BigDecimal id=null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate;

        try {
            String date__ = value.getStringDateTime().replace("T", " ");
            if (date__.equals("-")|| date__==null) {
                liProcessStepModel.setDateTime(null);
            } else {
                parsedDate = dateFormat.parse(date__);
                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                liProcessStepModel.setDateTime(timestamp);
            }
        } catch (ParseException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException n){
             Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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
        } else {
            flag=false;
            id = liProcessStepController.getDataById(column,foreignId).getId();
        }

        if (flag) {
            ret = liProcessStepController.saveLiProcessStep(liProcessStepModel);
        } else {
            ret = liProcessStepController.updateLiProcessStep(id,liProcessStepModel);
        }

        jTextAreaLogData.append("Status table LiProcessStep " + ret + "\n");

    }

    public void saveUpdateLiSource(String column,BigDecimal foreignId,LiSourceModel value) {

        LiSourceController liSourceController = new LiSourceController(session, hibernateUtilXml);
        LiSourceModel liSourceModel = new LiSourceModel();
    
        String ret;
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
        } else {
            flag=false;
            id = liSourceController.getDataById(column,foreignId).getId();
        }

        if (flag) {
            ret = liSourceController.saveLiSource(liSourceModel);
        } else {
            ret = liSourceController.updateLiSource(id,liSourceModel);
        }

        jTextAreaLogData.append("Status table LiSource " + ret + "\n");

    }

    public void saveUpdateLiLineageGroup(BigDecimal dataQualityId) {
       
        try{
                    
            BigDecimal liLineageId=null;
            BigDecimal liProcessStepId=null;

            //lineage
            LiLineageModel llm = new LiLineageModel();
            llm.setDqDataQualityId(dataQualityId);
            llm.setStatement(varLiLineage.getStatement());

            saveUpdateLiLineage(llm);

            //liprocesstep
            LiProcessStepModel lpsm = new LiProcessStepModel();
            LiLineageController llc = new LiLineageController(session, hibernateUtilXml);
            liLineageId = llc.getDataById(dataQualityId).getId();

            lpsm.setDescription(varLiLineage.getDescriptionLiProcessStep());
            lpsm.setRationale(varLiLineage.getRationale());
            lpsm.setStringDateTime(varLiLineage.getDateTime());
            lpsm.setLiLineageId(liLineageId);

            saveUpdateLiProcessStep(LiProcessStepModel.LI_LINEAGE,liLineageId,lpsm);

            LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
            liProcessStepId = lpsc.getDataById(LiProcessStepModel.LI_LINEAGE,liLineageId).getId();

            //processStep
            processStep(liProcessStepId);

            //lisource
            LiSourceModel lsm = new LiSourceModel();

            lsm.setDescription(varLiLineage.getDescriptionLiSource());
            lsm.setLiLineageId(liLineageId);

            saveUpdateLiSource(LiSourceModel.LI_LINEAGEID,liLineageId,lsm);       

            source(liLineageId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    
    public void processStep(BigDecimal liProcessStepId){
        
        try{
                
                BigDecimal ciResponsiblepartyId=null;
                BigDecimal ciContactId=null;
                BigDecimal ciTelephoneId=null;
                BigDecimal ciAddressId=null;
            
                //ciresponsibleparty
                CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
                partyModel.setIndividualName(varLiLineage.getIndividualName());
                partyModel.setOrganisationName(varLiLineage.getOrganisationName());
                partyModel.setPositionName(varLiLineage.getPositionName());
                partyModel.setRole(varLiLineage.getRole());
                partyModel.setLiProcessStepId(liProcessStepId);

                saveUpdateCiResponsibleParty(CiResponsiblePartyModel.LI_PROCESSSTEPID,liProcessStepId,partyModel);
  
                //cicontact
                CiContactModel ccm = new CiContactModel();
                CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
                CiRoleCodeController codeController = new CiRoleCodeController(session, hibernateUtilXml);
                String code = codeController.getDataByDomain(varLiLineage.getRole()).getCode();
                ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.LI_PROCESSSTEPID,liProcessStepId,code).getId();

                ccm.setContactInstruction(varLiLineage.getContactInstructions());
                ccm.setHouseOfService(varLiLineage.getHoursOfService());
                ccm.setCiResponsiblePartyId(ciResponsiblepartyId);

                saveUpdateCiContact(ccm);

                //citelephone
                CiTelephoneModel ctm = new CiTelephoneModel();
                CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();

                ctm.setCiContactId(ciContactId);

                saveUpdateCiTelephone(ctm);

                //citelephonevoice
                CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
                CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                ciTelephoneId = ctc.getDataById(ciContactId).getId();

                ctvm.setVoice(varLiLineage.getVoice());
                ctvm.setCiTelephoneId(ciTelephoneId);

                saveUpdateCiTelephoneVoice(ctvm);

                //citelephonefacs
                CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
                ctfm.setFacsimile(varLiLineage.getFax());
                ctfm.setCiTelephoneId(ciTelephoneId);

                saveUpdateCiTelephoneFacsimile(ctfm);

                //ciaddress
                CiAddressModel cam = new CiAddressModel();
                cam.setAdmnistrativeArea(varLiLineage.getAdministrativeArea());
                cam.setCity(varLiLineage.getCity());
                cam.setCountry(varLiLineage.getCountry());
                cam.setPostalCode(varLiLineage.getPostalCode());
                cam.setCiContactId(ciContactId);

                saveUpdateCiAddress(cam);

                //ciaddress_deliverypoint
                CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
                CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                ciAddressId = cac.getDataById(ciContactId).getId();

                cadpm.setDeliveryPoint(varLiLineage.getDeliveryPoint());
                cadpm.setCi_addressid(ciAddressId);

                saveUpdateCiAddressDeliveryPoint(cadpm);

                //ciaddress_emailaddress
                CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
                addressModel.setCi_addressid(ciAddressId);
                addressModel.setEmailAddress(varLiLineage.getElectronicMailAddress());

                saveUpdateCiAddressEmailAddress(addressModel);
 
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
        
        }catch(Exception n){
            n.printStackTrace();
        }
    }
    
    public void source(BigDecimal liLineageId){
        
        try{           
        
            BigDecimal liSourceId=null;

            MdRepresentativeFractionModel mrfm = new MdRepresentativeFractionModel();
            LiSourceController lsc = new LiSourceController(session, hibernateUtilXml);
            liSourceId = lsc.getDataById(LiSourceModel.LI_LINEAGEID, liLineageId).getId();

            mrfm.setStringDenominator(varLiLineage.getDenominator());
            mrfm.setLiSourceId(liSourceId); 

            saveUpdateMdRepresentativeFraction(MdRepresentativeFractionModel.LI_SOURCEID,liSourceId,mrfm);
 
            sourceReferenceSystem(liSourceId);
            sourceCitation(liSourceId);
            sourceExtent(liSourceId);
            sourceStep(liSourceId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    public void sourceReferenceSystem(BigDecimal liSourceId){
        
        try{
            
        
            BigDecimal mdReferenceSystemId=null;
            BigDecimal rsIdentifierId=null;
            BigDecimal ciCitationId=null;

            //mdreferencesytem
            MdReferenceSystemModel mrsm = new MdReferenceSystemModel();
            mrsm.setLiSourceId(liSourceId);

            saveUpdateReferenceSystem(MdReferenceSystemModel.LI_SOURCEID,liSourceId,mrsm);

            //rsidentifier
            RsIdentifierModel rim = new RsIdentifierModel();
            MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
            mdReferenceSystemId=mrsc.getDataById(MdReferenceSystemModel.LI_SOURCEID,liSourceId).getId();

            rim.setCode(varLiLineage.getCode());
            rim.setCodeSpace(varLiLineage.getCodeSpace());
            rim.setVersion(varLiLineage.getVersion());
            rim.setMdReferenceSystemId(mdReferenceSystemId);

            saveUpdateRsIdentifier(RsIdentifierModel.MD_REFERENCESYSTEMID,mdReferenceSystemId,rim);

            //cicitation
            CiCitationModel citationModel = new CiCitationModel();
            RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
            rsIdentifierId=ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();

            citationModel.setTitle(varLiLineage.getTitle());
            citationModel.setEdition(varLiLineage.getEdition());
            citationModel.setStringEditionDate(varLiLineage.getEditionDate());
            citationModel.setRsIdentifierId(rsIdentifierId);

            saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,citationModel);

            //cidate
            CiDateModel cdm = new CiDateModel();
            CiCitationController cit = new CiCitationController(session, hibernateUtilXml);
            ciCitationId=cit.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();

            cdm.setStringDate_(varLiLineage.getDate_());
            cdm.setDateType(varLiLineage.getDateType());
            cdm.setCiCitationId(ciCitationId);

            saveUpdateCiDate(cdm);

             //citationalternatetitle
            CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();

            ccatm.setAlternateTitle(varLiLineage.getAlternatetitle());
            ccatm.setCi_citationid(ciCitationId);

            saveUpdateCiCitationAlternateTitle(ccatm);

            CiSeriesModel csm = new CiSeriesModel();
            csm.setIssueIdentification(varLiLineage.getIssueIdentification());
            csm.setName(varLiLineage.getName());
            csm.setPage(varLiLineage.getPage());
            csm.setCiCitationId(ciCitationId);

            saveUpdateCiSeries(csm);

            CiCitationPresentationFormModel ccpfm = new CiCitationPresentationFormModel();
            ccpfm.setCiCitationId(ciCitationId);
            ccpfm.setPresentationForm(varLiLineage.getPresentationForm());

            SaveUpdateCitationPresentationForm(ccpfm);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    public void sourceCitation(BigDecimal liSourceId){
        
        try{
            
               BigDecimal ciCitationId=null;

                //cicitation
               CiCitationModel citationModel = new CiCitationModel();

               citationModel.setTitle(varLiLineage.getTitle());
               citationModel.setEdition(varLiLineage.getEditionSource());
               citationModel.setStringEditionDate(varLiLineage.getEditionDateSource());
               citationModel.setLiSourceId(liSourceId);

               saveUpdateCiCitation(CiCitationModel.LISOURCEID,liSourceId,citationModel);

               //cidate
               CiDateModel cdm = new CiDateModel();
               CiCitationController cit = new CiCitationController(session, hibernateUtilXml);
               ciCitationId=cit.getDataById(CiCitationModel.LISOURCEID,liSourceId).getId();

               cdm.setStringDate_(varLiLineage.getDate_());
               cdm.setDateType(varLiLineage.getDateType());
               cdm.setCiCitationId(ciCitationId);

               saveUpdateCiDate(cdm);

                //citationalternatetitle
               CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();

               ccatm.setAlternateTitle(varLiLineage.getAlternatetitle());
               ccatm.setCi_citationid(ciCitationId);

               saveUpdateCiCitationAlternateTitle(ccatm);
        
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
        
    }
    
    public void sourceExtent(BigDecimal liSourceId){
        
        try{
            
            //local variable
            BigDecimal exExtentId=null;
            BigDecimal exGeographicExtentId=null;
            BigDecimal exBoundingPolygonId=null;
            
            //ex_extent
            ExExtentModel eem = new ExExtentModel();            
            eem.setDescription(varLiLineage.getDescription());
            eem.setLiSourceId(liSourceId);
            
            saveUpdateExExtent(ExExtentModel.LI_SOURCEID,liSourceId,eem);
            
             //ex_geographicextent
            ExGeographicExtentModel egem = new ExGeographicExtentModel();
            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            exExtentId = eec.getDataById(ExExtentModel.LI_SOURCEID,liSourceId).getId();
            
            egem.setExExtentId(exExtentId);
            egem.setExtendsType(nullValue);
            egem.setStringExtentTypeCode(varLiLineage.getExtentTypeCode());
                        
            saveUpdateExExtentGeographicExtent(ExGeographicExtentModel.EX_EXTENTID,exExtentId,egem);

            //ex_boundingpolygon
            ExBoundingPolygonModel ebpm = new ExBoundingPolygonModel();
            ExGeographicExtentController egec = new ExGeographicExtentController(session, hibernateUtilXml);
            exGeographicExtentId = egec.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();
            ebpm.setExGeographicExtentId(exGeographicExtentId);
            
            saveUpdateExBoundingPolygon(ebpm);
            
            //ex_boundingpolygonpolygon
            ExBoundingPolygonPolygonModel ebppm = new ExBoundingPolygonPolygonModel();
            ExBoundingPolygonController ebpc = new ExBoundingPolygonController(session, hibernateUtilXml);
            
            exBoundingPolygonId = ebpc.getDataById(exGeographicExtentId).getExGeographicExtentId();
            
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
                 
            }catch(SQLException ex){
                ex.printStackTrace();
            }
                           
             //ex_extenttemporal
            ExTemporalExtentModel etem = new ExTemporalExtentModel();  
            etem.setExExtendId(exExtentId);
            etem.setExtendsType(nullValue);
            
            saveUpdateExTemporalExtent(etem);
            
             //ex_extentvertical
            ExVerticalExtentModel evem = new ExVerticalExtentModel();    
            evem.setExExtentId(exExtentId);
            
            saveUpdateExExtentVerticalExtent(evem);
                        
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
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }    
        
    }
    //end save li_lineage

    //save dq for loop
    public void saveUpdateDqElement(BigDecimal dqId, String columnName, DqElementModel dqModel) {

        DqElementController dqElementController = new DqElementController(session, hibernateUtilXml);
        DqEvaluationMethodTypeCodeController dqEvaluationMethodTypeCodeController = new DqEvaluationMethodTypeCodeController(session, hibernateUtilXml);
        DqElementModel dqElementModel = new DqElementModel();
        
        BigDecimal getIdDqElement;
        BigDecimal IdDqElement;
        String ret;
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
        } else {
            flag=false;
            id = dqElementController.getDataById(dqId, columnName).getId();
        }

        if (flag) {
            ret = dqElementController.saveDqElement(dqElementModel);
        } else {
            ret = dqElementController.updateDqElement(dqElementModel, id);
        }

        jTextAreaLogData.append("Status table DqElement " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n");

    }

    public void saveUpdateDqElementNameOfMeasure(BigDecimal dqElementId, String columnName, DqElementNameOfMeasureModel dqModel) {

        DqElementNameOfMeasureController dqElementNameOfMeasureController = new DqElementNameOfMeasureController(session, hibernateUtilXml);
        DqElementNameOfMeasureModel dqElementNameOfMeasureModel = new DqElementNameOfMeasureModel();

        String ret;
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

        jTextAreaLogData.append("Status table DqElementNameOfMeasure " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n");

    }

    public void saveUpdateDqElementDateTime(BigDecimal dqElementId, String columnName, DqElementDateTimeModel dqModel) {

        DqElementDateTimeModel dqElementDateTimeModel = new DqElementDateTimeModel();
        DqElementDateTimeController dqElementDateTimeController = new DqElementDateTimeController(session, hibernateUtilXml);

        String ret;
        String checkData;   
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate;

        try {
            String date__ = dqModel.getStringDateTime().replace("T", " ");
            if (date__.equals("-")||date__==null) {
                //dt = dateFormat.parse(date__);
                dqElementDateTimeModel.setDateTime(null);
            } else {
                parsedDate = dateFormat.parse(date__);
                Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
                dqElementDateTimeModel.setDateTime(timestamp);
            }
        } catch (ParseException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NullPointerException n){
             Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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

        jTextAreaLogData.append("Status table DqElementDateTime " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n");

    }

    public void saveUpdateDqResult(BigDecimal dqElementId, String columnName) {

        DqResultController dqResultController = new DqResultController(session, hibernateUtilXml);
        DqResultModel dqResultModel = new DqResultModel();

        String ret;
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
        } else {
            flag=false;
            id = dqResultController.getDataById(dqElementId).getId();
        }

        if (flag) {
            ret = dqResultController.saveDqResult(dqResultModel);
        } else {
            ret = dqResultController.updateDqResult(id,dqResultModel);
        }

        jTextAreaLogData.append("Status table DqResult " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n");

    }
    //end save dq for loop

    //save dq_conformanceresult
    public void saveUpdateDQConformanceResult(String columnName, DqConformanceResultModel dqModel) {

        DqConformanceResultController dqConformanceResultController = new DqConformanceResultController(session, hibernateUtilXml);
        DqConformanceResultModel dqConformanceResultModel = new DqConformanceResultModel();

        String checkData;
        String ret;
        
        String pass = dqModel.getStringPass();
        BigDecimal passer = null;
        try{
           
            if (pass.equalsIgnoreCase("true") || pass==null) {
                passer = new BigDecimal(BigInteger.ONE);
            } else {
                passer = new BigDecimal(BigInteger.ZERO);
             }

        }catch(NullPointerException n){
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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

        jTextAreaLogData.append("Status table DqConformanceResult " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n");

    }
    //end save dq_conformanceresult

    //save dq_quantitativeresult
    public void saveUpdateDqQuantitativeResult(String columnName, DqQuantitativeResultModel dqModel) {

        DqQuantitativeResultController dqQuantitativeResultController = new DqQuantitativeResultController(session, hibernateUtilXml);
        DqQuantitativeResultModel dqQuantitativeResultModel = new DqQuantitativeResultModel();

        String checkData;
        String ret;
        String tagElement="";
        
        try{
            
            tagElement = dqQuantitativeResultController.listToStringTag(dqModel.getValueUnitList());
        }catch(NullPointerException n){
            
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, n);
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

        jTextAreaLogData.append("Status table DqQuantitativeResult " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n");

    }

    public void saveUpdateDqQuantitativeResultValue(String columnName, DqQuantitativeResultValueModel dqModel) {

        DqQuantitativeResultValueController dqQuantitativeResultValueController = new DqQuantitativeResultValueController(session, hibernateUtilXml);
        DqQuantitativeResultValueModel dqQuantitativeResultValueModel = new DqQuantitativeResultValueModel();

        String checkData;
        String ret;
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

        jTextAreaLogData.append("Status table DqQuantitativeResultValue " + columnName.toLowerCase().replace("id", "") + " " + ret + "\n\n");

    }
    //end save dq_quantitativeresult

    //save mdupload
    public void saveUpdateMdUpload() throws FileNotFoundException, IOException, SQLException {

        String fileIdentifier = varMetadataEntitySetInformation.getFileIdentifier().toUpperCase();
        //System.out.println(fileName);
        MdUploadFileController mdUploadFileController = new MdUploadFileController(session, hibernateUtilXml);
        MdUploadFileModel mdUploadFileModel = new MdUploadFileModel();
        MdMetadataController md = new MdMetadataController(session, hibernateUtilXml);
        String newIdentifier = md.checkFileidentifier(fileIdentifier);

        BigDecimal getIdMdUpload;
        BigDecimal idMdUpload;
        String ret=null;
        String checkData;

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
            checkData = "";
        } else {
            checkData = mdUploadFileController.getDataById(newIdentifier).getId().toString();
        }

        if (checkData.equals("")) {
            ret = mdUploadFileController.saveMdUpload(mdUploadFileModel);
        } else {
            //ret = mdUploadFileController.updateMdUpload(mdUploadFileModel);
            ret="kosong";
        }

        jTextAreaLogData.append("Status table MdUploadFile " + ret + "\n");

    }
    //end save mdupload

    //end save dataquality
    private void saveUpdateMetadataEntitySetInformation() {
        
        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            String fileIdentifer = varMetadataEntitySetInformation.getFileIdentifier();
            BigDecimal ciResponsiblepartyId=null;
            BigDecimal ciContactId=null;
            BigDecimal ciTelephoneId=null;
            BigDecimal ciAddressId=null;
            
            //md_metadata
            MdMetadataModel mdModel = new MdMetadataModel();
            mdModel.setFileidentifier(fileIdentifer);
            mdModel.setCharacterset(varMetadataEntitySetInformation.getCharacterSet());
            mdModel.setStringDate(varMetadataEntitySetInformation.getDateStamp());
            mdModel.setLanguage(varMetadataEntitySetInformation.getLanguage());
            mdModel.setMetadatastandardname(varMetadataEntitySetInformation.getMetadataStandardName());
            mdModel.setMetadatastandardversion(varMetadataEntitySetInformation.getMetadataStandardVersion());
            mdModel.setParentidentifier(varMetadataEntitySetInformation.getParentIdentifier());
            mdModel.setDataseturi(varMetadataEntitySetInformation.getDataSetURI());           
            
            saveUpdateMdMetadata(MdMetadataModel.FILEIDENTIFIER,mdModel);
            jprocessbar.setValue(0);
            jprocessbar.setStringPainted(true);
                      
            //md_metadata_hieracylevel
            MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
            IdMdMetadata = mmc.getDataById(MdMetadataModel.FILEIDENTIFIER,mmc.checkFileidentifier(fileIdentifer)).getId();
                
            MdMetadataHierarchylvModel mmhm = new MdMetadataHierarchylvModel();
            mmhm.setHierarchylevel(varMetadataEntitySetInformation.getHierarchyLevel());
            mmhm.setMdMetadataid(IdMdMetadata);
            
            saveUpdateMdMetadataHierarchyLv(mmhm);
            jprocessbar.setValue(1);
            jprocessbar.setStringPainted(true);
            
            //md_metadata_hieracylevelname
            MdMetadataHierarchylvNameModel hierarchylvNameModel = new MdMetadataHierarchylvNameModel();
            hierarchylvNameModel.setHierarchylevelName(varMetadataEntitySetInformation.getHierarchyLevelName());
            hierarchylvNameModel.setMdMetadataid(IdMdMetadata);
                        
            saveUpdateMdMetadataHierarchyLvName(hierarchylvNameModel);
            jprocessbar.setValue(2);
            jprocessbar.setStringPainted(true);
            
            //ciresponsibleparty
            CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
            partyModel.setIndividualName(varMetadataEntitySetInformation.getIndividualName());
            partyModel.setOrganisationName(varMetadataEntitySetInformation.getOrganisationName());
            partyModel.setPositionName(varMetadataEntitySetInformation.getPositionName());
            partyModel.setRole(varMetadataEntitySetInformation.getRole());
            partyModel.setMdMetadataId(IdMdMetadata);
            
            saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_METADATAID,IdMdMetadata,partyModel);
            jprocessbar.setValue(3);
            jprocessbar.setStringPainted(true);
            
            //cicontact
            CiContactModel ccm = new CiContactModel();
            CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
            CiRoleCodeController codeController = new CiRoleCodeController(session, hibernateUtilXml);         
            String code = codeController.getDataByDomain(varMetadataEntitySetInformation.getRole()).getCode();
            ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_METADATAID, IdMdMetadata,code).getId();
            
            ccm.setContactInstruction(varMetadataEntitySetInformation.getContactInstructions());
            ccm.setHouseOfService(varMetadataEntitySetInformation.getHoursOfService());
            ccm.setCiResponsiblePartyId(ciResponsiblepartyId);
            
            saveUpdateCiContact(ccm);
            jprocessbar.setValue(4);
            jprocessbar.setStringPainted(true);
            
            //citelephone
            CiTelephoneModel ctm = new CiTelephoneModel();
            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
            ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();
            
            ctm.setCiContactId(ciContactId);
            
            saveUpdateCiTelephone(ctm);
            jprocessbar.setValue(5);
            jprocessbar.setStringPainted(true);
            
            //citelephonevoice
            CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
            CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
            ciTelephoneId = ctc.getDataById(ciContactId).getId();
            
            ctvm.setVoice(varMetadataEntitySetInformation.getVoice());
            ctvm.setCiTelephoneId(ciTelephoneId);
            
            saveUpdateCiTelephoneVoice(ctvm);
            jprocessbar.setValue(6);
            jprocessbar.setStringPainted(true);
            
            //citelephonefacs
            CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
            ctfm.setFacsimile(varMetadataEntitySetInformation.getFax());
            ctfm.setCiTelephoneId(ciTelephoneId);
            
            saveUpdateCiTelephoneFacsimile(ctfm);
            jprocessbar.setValue(7);
            jprocessbar.setStringPainted(true);
            
            //ciaddress
            CiAddressModel cam = new CiAddressModel();
            cam.setAdmnistrativeArea(varMetadataEntitySetInformation.getAdministrativeArea());
            cam.setCity(varMetadataEntitySetInformation.getCity());
            cam.setCountry(varMetadataEntitySetInformation.getCountry());
            cam.setPostalCode(varMetadataEntitySetInformation.getPostalCode());
            cam.setCiContactId(ciContactId);
          
            saveUpdateCiAddress(cam);
            jprocessbar.setValue(8);
            jprocessbar.setStringPainted(true);
            
            //ciaddress_deliverypoint
            CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
            CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
            ciAddressId = cac.getDataById(ciContactId).getId();
            
            cadpm.setDeliveryPoint(varMetadataEntitySetInformation.getDeliveryPoint());
            cadpm.setCi_addressid(ciAddressId);
            
            saveUpdateCiAddressDeliveryPoint(cadpm);
            jprocessbar.setValue(9);
            jprocessbar.setStringPainted(true);
            
            //ciaddress_emailaddress
            CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
            addressModel.setCi_addressid(ciAddressId);
            addressModel.setEmailAddress(varMetadataEntitySetInformation.getElectronicMailAddress());
          
            saveUpdateCiAddressEmailAddress(addressModel);
            jprocessbar.setValue(10);
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
            jprocessbar.setValue(11);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata Entity Set Information Finished" + "\n\n");
    }

    private void saveUpdateReferenceSystemInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            BigDecimal mdReferenceSystemId=null;
            BigDecimal rsIdentifierId=null;
            BigDecimal ciCitationId=null;
            
            //mdreferencesytem
            MdReferenceSystemModel mrsm = new MdReferenceSystemModel();
            mrsm.setMdMetadataId(IdMdMetadata);
            
            saveUpdateReferenceSystem(MdReferenceSystemModel.MD_METADATAID,IdMdMetadata,mrsm);
            
            jprocessbar.setValue(15);
            jprocessbar.setStringPainted(true);
            
            //rsidentifier
            RsIdentifierModel rim = new RsIdentifierModel();
            MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
            mdReferenceSystemId=mrsc.getDataById(MdReferenceSystemModel.MD_METADATAID,IdMdMetadata).getId();
            
            rim.setCode(varReferenceSystem.getCode1());
            rim.setCodeSpace(varReferenceSystem.getCode2());
            rim.setMdReferenceSystemId(mdReferenceSystemId);
            
            saveUpdateRsIdentifier(RsIdentifierModel.MD_REFERENCESYSTEMID,mdReferenceSystemId,rim);
            jprocessbar.setValue(16);
            jprocessbar.setStringPainted(true);
            
            //cicitation
            CiCitationModel ccm = new CiCitationModel();
            RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
            rsIdentifierId=ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();
            
            ccm.setTitle(varReferenceSystem.getTitle());
            ccm.setRsIdentifierId(rsIdentifierId);
            saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,ccm);
            jprocessbar.setValue(17);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cdm = new CiDateModel();
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            ciCitationId=ccc.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();
            
            cdm.setStringDate_(varReferenceSystem.getDate_());
            cdm.setDateType(varReferenceSystem.getDateType());
            cdm.setCiCitationId(ciCitationId);
            
            saveUpdateCiDate(cdm);
            jprocessbar.setValue(18);
            jprocessbar.setStringPainted(true);
            
            //mdidentifier 

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata Reference System Finished" + "\n\n");
    }

    private void saveUpdateMaintenanceInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");

            MdMaintenanceInfoModel mmim = new MdMaintenanceInfoModel();
            
            mmim.setMaintenanceAndUpdateFrequency(varMaintenanceInformation.getMaintenanceAndUpdateFrequency());
            mmim.setMdMetadataId(IdMdMetadata);
            
            SaveUpdateMdMaintenanceInfo(MdMaintenanceInfoModel.MD_METADATAID,IdMdMetadata,mmim);
            jprocessbar.setValue(112);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata maintenance information Finished" + "\n\n");
    }

    private void saveUpdateContentInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            BigDecimal mdContentInfoId=null;
            
            //mdcontentinfo
            MdContentInfoModel mcim = new MdContentInfoModel();
            mcim.setExtendsType(nullValue);
            mcim.setMdMetadataId(IdMdMetadata);
            
            SaveUpdateMdContentInfo(mcim);
            jprocessbar.setValue(83);
            jprocessbar.setStringPainted(true);
            
            //mdcoveragedescription
            MdCoverageDescriptionModel mcdm = new MdCoverageDescriptionModel();
            MdContentInfoController mcic = new MdContentInfoController(session, hibernateUtilXml);
            mdContentInfoId = mcic.getDataById(IdMdMetadata).getId();
            
            mcdm.setAttributeDescription(varContentInfo.getAttributeDescription());
            mcdm.setContentType(varContentInfo.getContentType());
            mcdm.setMdContentInfoId(mdContentInfoId);
            
            SaveUpdateMdCoverageDescription(mcdm);
            jprocessbar.setValue(84);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata ContentInformation Finished" + "\n\n");
    }

    private void saveUpdatePortrayalCatalagueInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            BigDecimal mdPortarayalCatalogueId=null;
            BigDecimal ciCitationId=null;
            
            //mdportrayalcatalogue
            MdPortrayalCatalogueRefModel mpcrm = new MdPortrayalCatalogueRefModel();
            
            mpcrm.setMdMetadataId(IdMdMetadata);
            
            SaveUpdateMdPotrayalCatalogueReference(mpcrm);
            jprocessbar.setValue(103);
            jprocessbar.setStringPainted(true);
            
            //cicitation
            CiCitationModel ccm = new CiCitationModel();
            MdPortrayalCatalogueRefController mpcrc = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
            mdPortarayalCatalogueId = mpcrc.getDataById(IdMdMetadata).getId();
            
            ccm.setTitle(varPotrayalCatalogueInformation.getTitle());
            ccm.setEdition(varPotrayalCatalogueInformation.getEdition());
            ccm.setStringEditionDate(varPotrayalCatalogueInformation.getEditionDate());
            ccm.setMdPortrayalCatalogueRefId(mdPortarayalCatalogueId);
            
            saveUpdateCiCitation(CiCitationModel.MDPORTRAYALCATALOGUEREFID,mdPortarayalCatalogueId,ccm);
            jprocessbar.setValue(104);
            jprocessbar.setStringPainted(true);
            
            //citationalternatetitle 
            CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            ciCitationId = ccc.getDataById(CiCitationModel.MDPORTRAYALCATALOGUEREFID,mdPortarayalCatalogueId).getId();
            
            ccatm.setAlternateTitle(varPotrayalCatalogueInformation.getAlternatetitle());
            ccatm.setCi_citationid(ciCitationId);
            
            saveUpdateCiCitationAlternateTitle(ccatm);
            jprocessbar.setValue(105);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cdm = new CiDateModel();  
            cdm.setStringDate_(varPotrayalCatalogueInformation.getDate_());
            cdm.setDateType(varPotrayalCatalogueInformation.getDateType());
            cdm.setCiCitationId(ciCitationId);
            
            saveUpdateCiDate(cdm);
            jprocessbar.setValue(106);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata PortrayalCatalagueInformation Finished" + "\n\n");
    }

    private void saveUpdateSpatialInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            BigDecimal mdSpatialId=null;
            BigDecimal mdVectorSpatialId=null;
            
            //mdspatialrepresentation
            MdSpatialRepresentationModel msrm = new MdSpatialRepresentationModel();
            msrm.setExtendsType(nullValue);
            msrm.setMdMetadataId(IdMdMetadata);
            
            saveUpdateMdSpatialRepresentation(msrm);
            jprocessbar.setValue(12);
            jprocessbar.setStringPainted(true);
            
            //mdvectorspatial
            MdVectorSpatialRepresentationModel mvsrm = new MdVectorSpatialRepresentationModel();
            MdSpatialRepresentationController msrc = new MdSpatialRepresentationController(session, hibernateUtilXml);
            mdSpatialId= msrc.getDataById(IdMdMetadata).getId();
            
            mvsrm.setId(mdSpatialId);
            mvsrm.setTopologyLevel(varSpatialRepresentationInformation.getTopologyLevel());
            
            saveUpdateMdVectorSpatial(mvsrm);
            jprocessbar.setValue(13);
            jprocessbar.setStringPainted(true);
           
            //mdgeometricobject       
            MdGeometricObjectsController mgoc = new MdGeometricObjectsController(session, hibernateUtilXml);
            MdVectorSpatialRepresentationController mvsrc = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);      
            MdTopologyLevelCodeController codeController = new MdTopologyLevelCodeController(session, hibernateUtilXml);
            String code = codeController.getDataByDomain(varSpatialRepresentationInformation.getTopologyLevel()).getCode();
            mdVectorSpatialId=mvsrc.getDataById(mdSpatialId, code).getId();
            
            int i=0;
            List listObjek = (List) mgoc.getListOfId(mdVectorSpatialId);           
            
            if(listObjek.get(0).toString().equals("-999")){
                
                for (VarSpatialRepresentationInformation list : listMdGeometricObject) {

                    MdGeometricObjectsModel objectsModel = new MdGeometricObjectsModel();
                    
                    objectsModel.setGeometricObjectCount(new BigDecimal(list.getGeometricObjectCount()));
                    objectsModel.setGeometricObjectType(list.getGeometricObjectType());
                    objectsModel.setMdVectorSpatialRepresentId(mdVectorSpatialId);
                    
                    saveUpdateMdGeometricObject(true,null,objectsModel);
                    
                }
                   
            }else{

                for (VarSpatialRepresentationInformation list : listMdGeometricObject) {

                    MdGeometricObjectsModel objectsModel = new MdGeometricObjectsModel();

                    objectsModel.setGeometricObjectCount(new BigDecimal(list.getGeometricObjectCount()));
                    objectsModel.setGeometricObjectType(list.getGeometricObjectType());
                    objectsModel.setMdVectorSpatialRepresentId(mdVectorSpatialId);

                    saveUpdateMdGeometricObject(false,new BigDecimal(listObjek.get(i).toString()),objectsModel);
                    i++;
                }
                   
            }
            
            jprocessbar.setValue(14);
            jprocessbar.setStringPainted(true);

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata SpatialInformation Finished" + "\n\n");
    }
    
    private void citation(BigDecimal mdIdentificationId){
    
        try{
            
            //local variable
            BigDecimal ciCitationId=null;
            BigDecimal ciCitationIdentifierId=null;
            BigDecimal MdIdentifierId=null;
            BigDecimal rsIdentifierId=null;
            
            //cicitation
            CiCitationModel ccm = new CiCitationModel();
           
            ccm.setTitle(varCitation.getTitle());
            ccm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateCiCitation(CiCitationModel.MDIDENTIFICATIONID,mdIdentificationId,ccm);
            jprocessbar.setValue(34);
            jprocessbar.setStringPainted(true);
            
            //citationalternatetitle
            CiCitationAlternateTitleModel ccatm = new CiCitationAlternateTitleModel();
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFICATIONID,mdIdentificationId).getId();
            
            ccatm.setAlternateTitle(varCitation.getAlternateTitle());
            ccatm.setCi_citationid(ciCitationId);
            
            saveUpdateCiCitationAlternateTitle(ccatm);
            jprocessbar.setValue(35);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cdm = new CiDateModel();     
            cdm.setStringDate_(varCitation.getDate());
            cdm.setDateType(varCitation.getDateType());
            cdm.setCiCitationId(ciCitationId);
            
            saveUpdateCiDate(cdm);
            jprocessbar.setValue(36);
            jprocessbar.setStringPainted(true);

            //mdidentifier
            MdIdentifierModel mim = new MdIdentifierModel();
            mim.setCode(varCitation.getCode());
            mim.setCiCitationId(ciCitationId);
            mim.setExtendsType(nullValue);
            
            saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, ciCitationId, mim);
            jprocessbar.setValue(37);
            jprocessbar.setStringPainted(true);
            
            //rsidentifier
            RsIdentifierModel rim = new RsIdentifierModel();
            MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
            MdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
            
            rim.setCode(varCitation.getCode());
            rim.setMdIdentifierId(MdIdentifierId);
            
            saveUpdateRsIdentifier(RsIdentifierModel.MD_IDENTIFIERID,MdIdentifierId,rim);
            jprocessbar.setValue(38);
            jprocessbar.setStringPainted(true);
            
            //cicitation
            CiCitationModel citationModel = new CiCitationModel();
            RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
            rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID,MdIdentifierId).getId();
            
            citationModel.setTitle(varCitation.getTitleCitationIdentifier());
            citationModel.setRsIdentifierId(rsIdentifierId);
            
            saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,citationModel);
            jprocessbar.setValue(39);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cd = new CiDateModel();
            ciCitationIdentifierId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();
           
            cd.setStringDate_(varCitation.getDateCiDateIdentifier());
            cd.setDateType(varCitation.getDateTypeCiDateIdentifier());
            cd.setCiCitationId(ciCitationIdentifierId);
            
            saveUpdateCiDate(cd);
            jprocessbar.setValue(40);
            jprocessbar.setStringPainted(true);
                        
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
            
            
    }
     
    private void pointOfContact(BigDecimal mdIdentificationId){
    
        try{
               
            //local variable
            BigDecimal ciResponsiblepartyId=null;
            BigDecimal ciContactId=null;
            BigDecimal ciTelephoneId=null;
            BigDecimal ciAddressId=null;
            
            //ciresponsibleparty
            CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
            partyModel.setIndividualName(varPointOfContact.getIndividualName());
            partyModel.setOrganisationName(varPointOfContact.getOrganisationName());
            partyModel.setPositionName(varPointOfContact.getPositionName());
            partyModel.setRole(varPointOfContact.getRole());
            partyModel.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_IDENTIFICATIONID,mdIdentificationId,partyModel);
            jprocessbar.setValue(41);
            jprocessbar.setStringPainted(true);
            
            //cicontact
            CiContactModel ccm = new CiContactModel();
            CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
            CiRoleCodeController codeController = new CiRoleCodeController(session, hibernateUtilXml);
            String code = codeController.getDataByDomain(varPointOfContact.getRole()).getCode();
            ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_IDENTIFICATIONID,mdIdentificationId,code).getId();
            
            ccm.setContactInstruction(varPointOfContact.getContactInstructions());
            ccm.setHouseOfService(varPointOfContact.getHoursOfService());
            ccm.setCiResponsiblePartyId(ciResponsiblepartyId);
            
            saveUpdateCiContact(ccm);
            jprocessbar.setValue(42);
            jprocessbar.setStringPainted(true);
            
            //citelephone
            CiTelephoneModel ctm = new CiTelephoneModel();
            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
            ciContactId=ccc.getDataById(ciResponsiblepartyId).getId();
            
            ctm.setCiContactId(ciContactId);
            
            saveUpdateCiTelephone(ctm);
            jprocessbar.setValue(43);
            jprocessbar.setStringPainted(true);
            
            //citelephonevoice
            CiTelephoneVoiceModel ctvm = new CiTelephoneVoiceModel();
            CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
            ciTelephoneId = ctc.getDataById(ciContactId).getId();
            
            ctvm.setVoice(varPointOfContact.getVoice());
            ctvm.setCiTelephoneId(ciTelephoneId);
            
            saveUpdateCiTelephoneVoice(ctvm);
            jprocessbar.setValue(44);
            jprocessbar.setStringPainted(true);
            
            //citelephonefacs
            CiTelephoneFacsimileModel ctfm = new CiTelephoneFacsimileModel();
            ctfm.setFacsimile(varPointOfContact.getFax());
            ctfm.setCiTelephoneId(ciTelephoneId);
            
            saveUpdateCiTelephoneFacsimile(ctfm);
            jprocessbar.setValue(45);
            jprocessbar.setStringPainted(true);
            
            //ciaddress
            CiAddressModel cam = new CiAddressModel();
            cam.setAdmnistrativeArea(varPointOfContact.getAdministrativeArea());
            cam.setCity(varPointOfContact.getCity());
            cam.setCountry(varPointOfContact.getCountry());
            cam.setPostalCode(varPointOfContact.getPostalCode());
            cam.setCiContactId(ciContactId);
          
            saveUpdateCiAddress(cam);
            jprocessbar.setValue(46);
            jprocessbar.setStringPainted(true);
            
            //ciaddress_deliverypoint
            CiAddressDeliveryPointModel cadpm = new CiAddressDeliveryPointModel();
            CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
            ciAddressId = cac.getDataById(ciContactId).getId();
            
            cadpm.setDeliveryPoint(varPointOfContact.getDeliveryPoint());
            cadpm.setCi_addressid(ciAddressId);
            
            saveUpdateCiAddressDeliveryPoint(cadpm);
            jprocessbar.setValue(47);
            jprocessbar.setStringPainted(true);
            
            //ciaddress_emailaddress
            CiAddressEmailAddressModel addressModel = new CiAddressEmailAddressModel();
            addressModel.setCi_addressid(ciAddressId);
            addressModel.setEmailAddress(varPointOfContact.getElectronicMailAddress());
          
            saveUpdateCiAddressEmailAddress(addressModel);
            jprocessbar.setValue(48);
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
            jprocessbar.setValue(49);
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
            jprocessbar.setValue(50);
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
            jprocessbar.setValue(51);
            jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
   
    }
    
    private void resourceFormat(BigDecimal mdIdentificationId){
    
        
        try{
            //local variable
            BigDecimal mdFormatId=null;
            BigDecimal mdDistributorId=null;
            BigDecimal ciResponsiblepartyId=null;
            BigDecimal ciContactId=null;
            BigDecimal mdDigitalTransferOptions=null;
            
            MdFormatModel mfm = new MdFormatModel();
            mfm.setName(varMdFormat.getName());
            mfm.setVersion(varMdFormat.getVersion());
            mfm.setSpesification(varMdFormat.getSpesification());
            mfm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdFormat(MdFormatModel.MD_IDENTIFICATIONID,mdIdentificationId,mfm);
            jprocessbar.setValue(52);
            jprocessbar.setStringPainted(true);
            
            MdDistributorModel mdm = new MdDistributorModel();
            MdFormatController mfc = new MdFormatController(session, hibernateUtilXml);
            mdFormatId = mfc.getDataById(MdFormatModel.MD_IDENTIFICATIONID,mdIdentificationId).getId();
            
            mdm.setMdFormatId(mdFormatId);
                        
            saveUpdateMdDistributor(MdDistributorModel.MD_FORMATID,mdFormatId,mdm);
            jprocessbar.setValue(53);
            jprocessbar.setStringPainted(true);
            
             //ciresponsibleparty
            CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
            MdDistributorController mdc = new MdDistributorController(session, hibernateUtilXml);
            
            mdDistributorId = mdc.getDataById(MdDistributorModel.MD_FORMATID,mdFormatId).getId();
            
            partyModel.setIndividualName(varMdFormat.getIndividualName());
            partyModel.setOrganisationName(varMdFormat.getOrganisationName());
            partyModel.setPositionName(varMdFormat.getPositionName());
            partyModel.setRole(varMdFormat.getRole());
            partyModel.setMdDistributorId(mdDistributorId);
            
            saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_DISTRIBUTORID,mdDistributorId,partyModel);
            jprocessbar.setValue(54);
            jprocessbar.setStringPainted(true);
            
            //cicontact
            CiContactModel ccm = new CiContactModel();
            CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
            CiRoleCodeController codeController = new CiRoleCodeController(session, hibernateUtilXml);     
            String code = codeController.getDataByDomain(varMdFormat.getRole()).getCode();
            ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_DISTRIBUTORID,mdDistributorId,code).getId();
            
            ccm.setCiResponsiblePartyId(ciResponsiblepartyId);
            
            saveUpdateCiContact(ccm);
            jprocessbar.setValue(55);
            jprocessbar.setStringPainted(true);
            
            //ci_onlineresource
            CiOnlineResourceModel corm = new CiOnlineResourceModel();
            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
            
            ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();
            
            corm.setLinkage(varMdFormat.getLinkage());
            corm.setCiContactId(ciContactId);
            
            saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,corm);
            jprocessbar.setValue(56);
            jprocessbar.setStringPainted(true);

            MdDigitalTransferOptionsModel mdtom = new MdDigitalTransferOptionsModel();
            
            mdtom.setMdDistributorId(mdDistributorId);
            
            saveUpdateMdDigitalTransferOption(MdDigitalTransferOptionsModel.MD_DISTRIBUTORID,mdDistributorId,mdtom);
            jprocessbar.setValue(57);
            jprocessbar.setStringPainted(true);
            
            CiOnlineResourceModel resourceModel = new CiOnlineResourceModel();
            MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
            
            mdDigitalTransferOptions = mdtoc.getDataById(MdDigitalTransferOptionsModel.MD_DISTRIBUTORID,mdDistributorId).getId();
                        
            resourceModel.setLinkage(varMdFormat.getOnlineLinkage());
            resourceModel.setFunction_(varMdFormat.getFunction());
            resourceModel.setMdDigitalTransferOptionsId(mdDigitalTransferOptions);
            
            saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.MD_DIGITALTRANSFEROPTIONID,mdDigitalTransferOptions,resourceModel);
            jprocessbar.setValue(58);
            jprocessbar.setStringPainted(true);
            
            MdMediumModel mmm = new MdMediumModel();
            mmm.setName(varMdFormat.getNameDigitalTransferOption());
            mmm.setDensityUnits(varMdFormat.getDensityUnits());
            mmm.setMdDigitalTransferOptionsId(mdDigitalTransferOptions);
            
            saveUpdateMdMedium(mmm);
            jprocessbar.setValue(59);
            jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void descriptiveKeywords(BigDecimal mdIdentificationId){
    
        try{
            
            //loca variable
            BigDecimal citationId=null;
            BigDecimal MdIdentifierId=null;
            BigDecimal rsIdentifierId=null;
            BigDecimal ciCitationIdentifierId=null;
            
            //mdkeyword
            MdKeywordModel mkm = new MdKeywordModel();
            mkm.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdKeyword(mkm);
            jprocessbar.setValue(60);
            jprocessbar.setStringPainted(true);
            
            //mdkeyword
            saveUpdateMdKeywordKeyword(mdIdentificationId);
            jprocessbar.setValue(61);
            jprocessbar.setStringPainted(true);
            
            MdKeywordController mkc = new MdKeywordController(session, hibernateUtilXml);
            List list = (List) mkc.getListOfId(mdIdentificationId);            
            
            //cicitation
            saveUpdateThesaurusNameCitation(list);
            jprocessbar.setValue(62);
            jprocessbar.setStringPainted(true);
            
            //cidate
            saveUpdateCitationDateThesaurusName(list);
            jprocessbar.setValue(63);
            jprocessbar.setStringPainted(true);
            
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            citationId = ccc.getDataById(CiCitationModel.MDKEYWORDID, new BigDecimal(list.get(0).toString())).getId();
            
             //mdidentifier
            MdIdentifierModel mim = new MdIdentifierModel();          
            mim.setCode(varDescriptiveKeywords.getCode());
            mim.setCiCitationId(citationId);
            mim.setExtendsType(nullValue);
            
            saveUpdateMdIdentifier(MdIdentifierModel.CICITATIONID, citationId, mim);
            jprocessbar.setValue(64);
            jprocessbar.setStringPainted(true);
            
            //rsidentifier
            RsIdentifierModel rim = new RsIdentifierModel();
            MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
            MdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, citationId).getId();
            
            rim.setCode(varDescriptiveKeywords.getCode());
            rim.setMdIdentifierId(MdIdentifierId);
            
            saveUpdateRsIdentifier(RsIdentifierModel.MD_IDENTIFIERID,MdIdentifierId,rim);
            jprocessbar.setValue(65);
            jprocessbar.setStringPainted(true);
            
            //cicitation
            CiCitationModel citationModel = new CiCitationModel();
            RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
            rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID,MdIdentifierId).getId();
            
            citationModel.setTitle(varDescriptiveKeywords.getTitle());
            citationModel.setRsIdentifierId(rsIdentifierId);
            
            saveUpdateCiCitation(CiCitationModel.RSIDENTIFIERID,rsIdentifierId,citationModel);
            jprocessbar.setValue(66);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cd = new CiDateModel();
            ciCitationIdentifierId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID,rsIdentifierId).getId();
            
            cd.setStringDate_(varDescriptiveKeywords.getDate());
            cd.setDateType(varDescriptiveKeywords.getDateType());
            cd.setCiCitationId(ciCitationIdentifierId);
            
            saveUpdateCiDate(cd);
            jprocessbar.setValue(67);
            jprocessbar.setStringPainted(true);
            
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void resourceConstraints(BigDecimal mdIdentificationId){
    
        try{
           
              //local variable
              BigDecimal mdConstraintsId=null;
              //mdconstaints
              MdConstraintsModel mcm = new MdConstraintsModel();
              
              mcm.setMdIdentificationId(mdIdentificationId);
              mcm.setExtendsType(nullValue);
              
              saveUpdateMetadataConstraints(MdConstraintsModel.MD_IDENTIFICATIONID,mdIdentificationId,mcm);
              jprocessbar.setValue(68);
              jprocessbar.setStringPainted(true);
              
              //mdconstraintsuselimitation
              MdConstraintsUselimitationModel mcum = new MdConstraintsUselimitationModel();
              MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
              mdConstraintsId= mcc.getDataById(MdConstraintsModel.MD_IDENTIFICATIONID,mdIdentificationId).getId();
              
              mcum.setUseLimitation(varResourceConstraints.getUseLimitation());
              mcum.setMdConstraintsId(mdConstraintsId);
              
              saveUpdateMetadataConstraintsUseLimitation(mcum);
              jprocessbar.setValue(69);
              jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    private void aggregationInfo(BigDecimal mdIdentificationId){
    
        try{
           
            //localvariable
            BigDecimal mdAggregateInfoId=null;
            BigDecimal ciCitationSetName=null;
            BigDecimal mdIdentifierId=null;
            BigDecimal ciCitationSetIdentifier=null;
            
            //mdaggregationinfo
            MdAggregateInfoModel maim = new MdAggregateInfoModel();
            maim.setAssositionType(varAggregationInfo.getDS_AssociationTypeCode());
            maim.setInitiativeType(varAggregationInfo.getDS_InitiativeTypeCode());
            maim.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdAggregationInformation(maim);
            jprocessbar.setValue(72);
            jprocessbar.setStringPainted(true);
            
            //cicitation
            CiCitationModel ccm = new CiCitationModel();
            MdAggregateInfoController maic = new MdAggregateInfoController(session, hibernateUtilXml);
            MdAggregateInfoModel aggregateInfoModel = new MdAggregateInfoModel();
            DsAssociationTypeCodeController dsA = new DsAssociationTypeCodeController(session, hibernateUtilXml);
            DsInitiativeTypeCodeController dsI = new DsInitiativeTypeCodeController(session, hibernateUtilXml);
            String dsACode = dsA.getDataByDomain(varAggregationInfo.getDS_AssociationTypeCode()).getCode();
            String dsICode = dsI.getDataByDomain(varAggregationInfo.getDS_InitiativeTypeCode()).getCode();
            aggregateInfoModel.setAssositionType(dsACode);
            aggregateInfoModel.setInitiativeType(dsICode);
            aggregateInfoModel.setMdIdentificationId(mdIdentificationId);
      
            mdAggregateInfoId = maic.getDataByObjek(aggregateInfoModel).getId();
            
            ccm.setTitle(varAggregationInfo.getTitle());
            ccm.setMdAggregateInfoId(mdAggregateInfoId);
            
            saveUpdateCiCitation(CiCitationModel.MDAGGREGATEINFOID,mdAggregateInfoId,ccm);
            jprocessbar.setValue(73);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cd = new CiDateModel();
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            ciCitationSetName = ccc.getDataById(CiCitationModel.MDAGGREGATEINFOID,mdAggregateInfoId).getId();
            
            cd.setStringDate_(varAggregationInfo.getDate());
            cd.setDateType(varAggregationInfo.getDateType());
            cd.setCiCitationId(ciCitationSetName);
            
            saveUpdateCiDate(cd);
            jprocessbar.setValue(74);
            jprocessbar.setStringPainted(true);
 
            //mdidentifier
            MdIdentifierModel mim = new MdIdentifierModel();
            mim.setCode(varAggregationInfo.getCode());
            mim.setMdAggregationInfoId(mdAggregateInfoId);
            mim.setExtendsType(nullValue);
            
            saveUpdateMdIdentifier(MdIdentifierModel.MDAGGREGATEINFOID, mdAggregateInfoId, mim);
            jprocessbar.setValue(75);
            jprocessbar.setStringPainted(true);
            
            //cicitation
            CiCitationModel citationModel = new CiCitationModel();
            MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
            mdIdentifierId = mic.getDataById(MdIdentifierModel.MDAGGREGATEINFOID, mdAggregateInfoId).getId();
            
            citationModel.setTitle(varAggregationInfo.getTitleIdentifier());
            citationModel.setMdIdentifierId(mdIdentifierId);
            
            saveUpdateCiCitation(CiCitationModel.MDIDENTIFIERID,mdIdentifierId,citationModel);
            jprocessbar.setValue(76);
            jprocessbar.setStringPainted(true);
                        
            //cidate
            CiDateModel cdm = new CiDateModel();
            ciCitationSetIdentifier = ccc.getDataById(CiCitationModel.MDIDENTIFIERID,mdIdentifierId).getId();
            
            cdm.setStringDate_(varAggregationInfo.getDateIdentifier());
            cdm.setDateType(varAggregationInfo.getDateTypeIdentifier());
            cdm.setCiCitationId(ciCitationSetIdentifier);
            
            saveUpdateCiDate(cdm);
            jprocessbar.setValue(77);
            jprocessbar.setStringPainted(true);
                        

        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void spatialResolution(BigDecimal mdDataIdentificationId){
    
        try{
            
            //local variable
            BigDecimal mdResolutionId=null;
            //mdresolution
            MdResolutionModel mrm = new MdResolutionModel();
            
            mrm.setMdDataIdentificationId(mdDataIdentificationId);
            
            saveUpdateMdResolution(mrm);
            jprocessbar.setValue(70);
            jprocessbar.setStringPainted(true); 
            
            MdRepresentativeFractionModel mrfm = new MdRepresentativeFractionModel();
            MdResolutionController mrc = new MdResolutionController(session, hibernateUtilXml);
            mdResolutionId = mrc.getDataById(mdDataIdentificationId).getId();
            
            mrfm.setStringDenominator(varSpatialResolution.getDenominator());
            mrfm.setMdResolutionId(mdResolutionId);
            
            saveUpdateMdRepresentativeFraction(MdRepresentativeFractionModel.MD_RESOLUTIONID,mdResolutionId,mrfm);
            jprocessbar.setValue(71);
            jprocessbar.setStringPainted(true);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void extent(BigDecimal mdDataIdentificationId){
    
        try{
            
            //local variable
            BigDecimal exExtentId=null;
            BigDecimal exGeographicExtentId=null;
            
            //ex_extent 
            ExExtentModel eem = new ExExtentModel();
            eem.setDescription(varExtent.getDescription());
            eem.setMdDataIdentificationId(mdDataIdentificationId);
            
            saveUpdateExExtent(ExExtentModel.MD_DATAIDENTIFICATIONID,mdDataIdentificationId,eem);
            jprocessbar.setValue(78);
            jprocessbar.setStringPainted(true);
            
             //ex_geographicextent
            ExGeographicExtentModel egem = new ExGeographicExtentModel();
            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            exExtentId = eec.getDataById(ExExtentModel.MD_DATAIDENTIFICATIONID,mdDataIdentificationId).getId();
            
            egem.setExExtentId(exExtentId);
            egem.setExtendsType(nullValue);
            egem.setStringExtentTypeCode(varExtent.getExtentTypeCode());
            
            saveUpdateExExtentGeographicExtent(ExGeographicExtentModel.EX_EXTENTID,exExtentId,egem);
            jprocessbar.setValue(79);
            jprocessbar.setStringPainted(true);
            
             //ex_extent_boundingbox
            ExGeographicBoundingBoxModel boxModel = new ExGeographicBoundingBoxModel();
            ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
            exGeographicExtentId = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();
            
            boxModel.setEastBoundLongitude(new BigDecimal(varExtent.getEastBoundLongitude()));
            boxModel.setNorthBoundLongitud(new BigDecimal(varExtent.getNorthBoundLatitude()));
            boxModel.setSouthBoundLongitude(new BigDecimal(varExtent.getSouthBoundLatitude()));
            boxModel.setWestBoundLongitude(new BigDecimal(varExtent.getWestBoundLongitude()));
            boxModel.setExGeographicExtentId(exGeographicExtentId);
            
            saveUpdateExExtentGeographicBoundingBox(boxModel);
            jprocessbar.setValue(80);
            jprocessbar.setStringPainted(true);
            
             //ex_extenttemporal
            ExTemporalExtentModel etem = new ExTemporalExtentModel();    
            etem.setExExtendId(exExtentId);
            etem.setExtendsType(nullValue);
            
            saveUpdateExTemporalExtent(etem);
            jprocessbar.setValue(81);
            jprocessbar.setStringPainted(true);
            
             //ex_extentvertical
            ExVerticalExtentModel evem = new ExVerticalExtentModel();
            evem.setExExtentId(exExtentId);

            saveUpdateExExtentVerticalExtent(evem);
            jprocessbar.setValue(82);
            jprocessbar.setStringPainted(true);
            
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }

    private void saveUpdateIdentificationInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //root
            //local variable
            BigDecimal mdIdentificationId=null;
            BigDecimal SvServiceIdentificationId=null;
            BigDecimal MdDataIdentificationId=null;

            //mdidentification
            MdIdentificationModel mim = new MdIdentificationModel();
            
            mim.setAbstract_(varIdentificationInformation.getAbstract_());
            mim.setExtendsType(nullValue);
            mim.setPurpose(varIdentificationInformation.getPurpose());
            mim.setMdMetadataId(IdMdMetadata);
            
            saveUpdateMdIdentification(mim);
            jprocessbar.setValue(26);
            jprocessbar.setStringPainted(true);
            
            //mdidentificationstatus
            MdIdentificationStatusModel mism = new MdIdentificationStatusModel();
            MdIdentificationController mic = new MdIdentificationController(session, hibernateUtilXml);
            mdIdentificationId = mic.getDataById(IdMdMetadata).getId();
            
            mism.setStatus(varIdentificationInformation.getStatus());
            mism.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateMdIdentificationStatus(mism);
            jprocessbar.setValue(27);
            jprocessbar.setStringPainted(true);
            
            //svserviceidentification
            SvServiceIdentificationModel ssim = new SvServiceIdentificationModel();          
            ssim.setAbstract_(varIdentificationInformation.getAbstract_());
            ssim.setPurpose(varIdentificationInformation.getPurpose());
            ssim.setStatus(varIdentificationInformation.getStatus());
            ssim.setMdIdentificationId(mdIdentificationId);
            
            saveUpdateSvServiceIdentification(ssim);
            jprocessbar.setValue(28);
            jprocessbar.setStringPainted(true);
            
            //mddataidentification
            MdDataIdentificationModel mdim = new MdDataIdentificationModel();
            SvServiceIdentificationController ssic = new SvServiceIdentificationController(session, hibernateUtilXml);
            MdProgressCodeController codeController = new MdProgressCodeController(session, hibernateUtilXml);      
            String code=codeController.getDataByDomain(varIdentificationInformation.getStatus()).getCode();           
            
            SvServiceIdentificationId = ssic.getDataById(mdIdentificationId, code).getId();
            
            mdim.setSuplementationInformation(varIdentificationInformation.getSupplementallnformation());
            mdim.setSvServiceidentificationId(SvServiceIdentificationId);
            mdim.setId(mdIdentificationId);
            
            saveUpdateMdDataIdentification(mdim);
            jprocessbar.setValue(29);
            jprocessbar.setStringPainted(true);  
            
            //mdidentificationspatrep
            MdDataIdentificationSpatrepModel mdism = new MdDataIdentificationSpatrepModel();
            MdDataIdentificationController mdic = new MdDataIdentificationController(session, hibernateUtilXml);
            
            MdDataIdentificationId=mdic.getDataById(mdIdentificationId).getId();
            
            mdism.setSpatialRepresentationType(varSpatialRepresentationType.getMD_SpatialRepresentationTypeCode());
            mdism.setMdDataIdentificationId(MdDataIdentificationId);
            
            saveUpdateMdDataIdentificationSpatrep(mdism);
            jprocessbar.setValue(30);
            jprocessbar.setStringPainted(true);
            
            //mdidentificationlang
            MdDataIdentificationLangModel langModel = new MdDataIdentificationLangModel();
            langModel.setLanguage(varIdentificationInformation.getLanguage());
            langModel.setMdDataIdentificationId(MdDataIdentificationId);
            
            saveUpdateMdDataIdentificationLang(langModel);
            jprocessbar.setValue(31);
            jprocessbar.setStringPainted(true);
            
            //mdidentificationcharset
            MdDataIdentificationCharsetModel charsetModel = new MdDataIdentificationCharsetModel();
            charsetModel.setCharacterSet(varIdentificationInformation.getCharacterSet());
            charsetModel.setMdDataIdentificationId(MdDataIdentificationId);
            
            saveUpdateMdDataIdentificationCharset(charsetModel);
            jprocessbar.setValue(32);
            jprocessbar.setStringPainted(true);
            
            //mdidentificationtopcat
            MdDataIdentificationTopcatModel mditm = new MdDataIdentificationTopcatModel();
            mditm.setTopicCategory(varIdentificationInformation.getTopicCategory());
            mditm.setMdDataIdentificationId(MdDataIdentificationId);
            
            saveUpdateMdDataIdentificationTopCat(mditm);
            jprocessbar.setValue(33);
            jprocessbar.setStringPainted(true);    
            //end root
            
            //citation
            citation(mdIdentificationId);
            //end citation
            
            //point of contact
            pointOfContact(mdIdentificationId);
            //end pointofcontact
            
            //resource maintenance
            resourceMaintenance(mdIdentificationId);
            //resource maintenance
            
            //graphicOverview
            graphicOverview(mdIdentificationId);
            //end graphicOverview
           
            //resource format
            resourceFormat(mdIdentificationId);
            //resource format
            
            //descriptivekeyword
            descriptiveKeywords(mdIdentificationId);
            //end descriptivekeyword
            
            //md_constraints
            resourceConstraints(mdIdentificationId);
            //end md_constraints
            
            //spatialresolution
            spatialResolution(MdDataIdentificationId);
            //end spatialresolution
                      
            //md_aggregationinfo
            aggregationInfo(mdIdentificationId);  
            //end md_aggregationinfo
            
            //ex_extent
            extent(MdDataIdentificationId);
            //end ex_extent

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata IdentificationInformation Finished" + "\n\n");
    }

    private void saveUpdateDataQualityInfo() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            BigDecimal dqDataQualityId=null;
            DqDataQualityModel ddqm = new DqDataQualityModel();
            
            ddqm.setMdMetadataId(IdMdMetadata);
            
            saveUpdateDqDataQuality(ddqm);
            jprocessbar.setValue(85);
            jprocessbar.setStringPainted(true);
            
            DqDataQualityController ddqc = new DqDataQualityController(session, hibernateUtilXml);
            dqDataQualityId = ddqc.getDataById(IdMdMetadata).getId();
            
            saveUpdateDqScopeGroup(dqDataQualityId);
            jprocessbar.setValue(86);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqCompcommGroup(dqDataQualityId);
            jprocessbar.setValue(87);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqCompomGroup(dqDataQualityId);
            jprocessbar.setValue(88);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqConcconsisGroup(dqDataQualityId);
            jprocessbar.setValue(89);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqDomconsisGroup(dqDataQualityId);
            jprocessbar.setValue(90);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqFormconsisGroup(dqDataQualityId);
            jprocessbar.setValue(91);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqTopconsisGroup(dqDataQualityId);
            jprocessbar.setValue(92);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqAbsextPosAccGroup(dqDataQualityId);
            jprocessbar.setValue(93);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqGridDataPosAccGroup(dqDataQualityId);
            jprocessbar.setValue(94);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqRellntPosAccGroup(dqDataQualityId);
            jprocessbar.setValue(95);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqAccTimeMeAsGroup(dqDataQualityId);
            jprocessbar.setValue(96);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqTempConsisGroup(dqDataQualityId);
            jprocessbar.setValue(97);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqTempValidGroup(dqDataQualityId);
            jprocessbar.setValue(98);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqThemClassCorGroup(dqDataQualityId);
            jprocessbar.setValue(99);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqNonQuanAttaccGroup(dqDataQualityId);
            jprocessbar.setValue(100);
            jprocessbar.setStringPainted(true);
            
            saveUpdateDqQuanAttaccGroup(dqDataQualityId);
            jprocessbar.setValue(101);
            jprocessbar.setStringPainted(true);
            
            saveUpdateLiLineageGroup(dqDataQualityId);
            jprocessbar.setValue(102);
            jprocessbar.setStringPainted(true);
           
        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata DataQuality Finished" + "\n\n");
    }
    
    private void saveUpdateMetadataExtensionInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
            
            //local variable
            BigDecimal mdMetadataExtensionId=null;
            BigDecimal mdExtendedElementInfoId=null;
            BigDecimal ciResponsiblepartyId=null;
            BigDecimal ciContactId=null;
            
            //metadataextensionsinfo
            MdMetadataExtensionInfoModel mmeim = new MdMetadataExtensionInfoModel();
            
            mmeim.setMdMetadataId(IdMdMetadata);
            
            saveUpdateMdMetadataExtensionInfo(mmeim);
            jprocessbar.setValue(19);
            jprocessbar.setStringPainted(true);
            
            //cionlineresource
            CiOnlineResourceModel corm = new CiOnlineResourceModel();
            MdMetadataExtensionInfoController mmeic = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
            mdMetadataExtensionId = mmeic.getDataById(IdMdMetadata).getId();
            
            corm.setLinkage(varMetadataExtensionInformation.getLinkage());
            corm.setMdMetadataExtensionInfoId(mdMetadataExtensionId);
            
            saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.MD_METADATAEXTENSIONINFOID,mdMetadataExtensionId,corm);
            jprocessbar.setValue(20);
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
            jprocessbar.setValue(21);
            jprocessbar.setStringPainted(true);
            
            //md_extendedelementinfoparent
            MdExtendedElementInfoParentModel meeipm = new MdExtendedElementInfoParentModel();
            MdExtendedElementInfoController meeic = new MdExtendedElementInfoController(session, hibernateUtilXml);
            mdExtendedElementInfoId = meeic.getDataById(mdMetadataExtensionId).getId();
            
            meeipm.setParentEntity(varMetadataExtensionInformation.getParentEntity());
            meeipm.setMdExtendedElementInfoId(mdExtendedElementInfoId);
            
            saveUpdateMdExtendedElementInfoParent(meeipm);
            jprocessbar.setValue(22);
            jprocessbar.setStringPainted(true);
            
             //ciresponsibleparty
            CiResponsiblePartyModel partyModel = new CiResponsiblePartyModel();
            partyModel.setIndividualName(varMetadataExtensionInformation.getIndividualName());
            partyModel.setOrganisationName(varMetadataExtensionInformation.getOrganisationName());
            partyModel.setPositionName(varMetadataExtensionInformation.getPositionName());
            partyModel.setRole(varMetadataExtensionInformation.getRole());
            partyModel.setMdExtendedElementInfoId(mdExtendedElementInfoId);
            
            saveUpdateCiResponsibleParty(CiResponsiblePartyModel.MD_EXTENDEDELEMENTINFOID,mdExtendedElementInfoId,partyModel);
            jprocessbar.setValue(23);
            jprocessbar.setStringPainted(true);
            
            //cicontact
            CiContactModel ccm = new CiContactModel();
            CiResponsiblePartyController partyController = new CiResponsiblePartyController(session, hibernateUtilXml);
            CiRoleCodeController codeController = new CiRoleCodeController(session, hibernateUtilXml);
            
            String code = codeController.getDataByDomain(varMetadataExtensionInformation.getRole()).getCode();
            ciResponsiblepartyId = partyController.getDataById(CiResponsiblePartyModel.MD_EXTENDEDELEMENTINFOID,mdExtendedElementInfoId,code).getId();

            ccm.setCiResponsiblePartyId(ciResponsiblepartyId);
            
            saveUpdateCiContact(ccm);
            jprocessbar.setValue(24);
            jprocessbar.setStringPainted(true);
            
            //cionlineresource
            CiOnlineResourceModel resourceModel = new CiOnlineResourceModel();
            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
            ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();
            
            resourceModel.setLinkage(varMetadataExtensionInformation.getLinkageSource());
            resourceModel.setCiContactId(ciContactId);
            
            saveUpdateCiAddressOnlineResource(CiOnlineResourceModel.CI_CONTACTID,ciContactId,resourceModel);
            jprocessbar.setValue(25);
            jprocessbar.setStringPainted(true);
                        

        } catch (NullPointerException n) {
            n.printStackTrace();
        }

        jTextAreaLogData.append("\n" + "Status Metadata MetadataExtensionInformation Finished" + "\n\n");
    }
    
    private void saveUpdateApplicationSchemaInformation() {

        try {
            
            jTextAreaLogData.append("Waiting next process.." + "\n");
             
            //local variable
            BigDecimal mdApplicationSchemaId=null;
            BigDecimal ciCitationId=null;
           
            //mdapplicationschemainfo
            MdApplicationSchemaInfoModel masim = new MdApplicationSchemaInfoModel();           
            masim.setMdMetadataId(IdMdMetadata);
            masim.setSchemaLanguage(varApplicationSchemaInformation.getSchemaLanguage());
            masim.setConstraintLanguage(varApplicationSchemaInformation.getConstraintLanguage());
                    
            saveUpdateMdApplicationSchemaInfo(masim);
            jprocessbar.setValue(109);
            jprocessbar.setStringPainted(true);
           
            //cicitation
            CiCitationModel ccm = new CiCitationModel();
            MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
            mdApplicationSchemaId = masic.getDataById(IdMdMetadata).getId();
            
            ccm.setTitle(varApplicationSchemaInformation.getTitle());
            ccm.setEdition(varApplicationSchemaInformation.getEdition());
            ccm.setStringEditionDate(varApplicationSchemaInformation.getEditionDate());
            ccm.setMdApplicationschemaInfoId(mdApplicationSchemaId);
            
            saveUpdateCiCitation(CiCitationModel.MDAPPLICATIONSCHEMAINFOID,mdApplicationSchemaId,ccm);
            jprocessbar.setValue(110);
            jprocessbar.setStringPainted(true);
            
            //cidate
            CiDateModel cdm = new CiDateModel();
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            ciCitationId = ccc.getDataById(CiCitationModel.MDAPPLICATIONSCHEMAINFOID,mdApplicationSchemaId).getId();
                       
            cdm.setStringDate_(varApplicationSchemaInformation.getDate_());
            cdm.setDateType(varApplicationSchemaInformation.getDateType());
            cdm.setCiCitationId(ciCitationId);
            
            saveUpdateCiDate(cdm);
     
            jprocessbar.setValue(111);
            jprocessbar.setStringPainted(true);
       
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
       jTextAreaLogData.append("\n" + "Status Metadata ApplicationSchemaInformation Finished" + "\n\n");
       
    }

    private void saveUpdateMetadataConstraintsInformation() {

        try {
            
              jTextAreaLogData.append("Waiting next process.." + "\n");
              
              //local variable
              BigDecimal mdConstraintsId=null;
              //mdconstaints
              MdConstraintsModel mcm = new MdConstraintsModel(); 
              mcm.setMdMetadataId(IdMdMetadata);
              mcm.setExtendsType(nullValue);
              
              saveUpdateMetadataConstraints(MdConstraintsModel.MD_METADATAID,IdMdMetadata,mcm);
              jprocessbar.setValue(107);
              jprocessbar.setStringPainted(true);
              
              //mdconstraintsuselimitation
              MdConstraintsUselimitationModel mcum = new MdConstraintsUselimitationModel();
              MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
              mdConstraintsId= mcc.getDataById(MdConstraintsModel.MD_METADATAID,IdMdMetadata).getId();
              
              mcum.setUseLimitation(varMetadataConstraints.getUseLimitation());
              mcum.setMdConstraintsId(mdConstraintsId);
              
              saveUpdateMetadataConstraintsUseLimitation(mcum);
              jprocessbar.setValue(108);
              jprocessbar.setStringPainted(true);
              
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("\n" + "Status Metadata Metadata Constraints Finished" + "\n\n");
    }
    
    
    private void saveUpdateMetadataUploadInformation(){

        try {
            
              jTextAreaLogData.append("Waiting next process.." + "\n");
              
              //md_upload
                try {

                        saveUpdateMdUpload();
                        jprocessbar.setValue(113);
                        jprocessbar.setStringPainted(true);

                } catch (IOException ex) {
                        Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                        Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
                }
              
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("\n" + "Status Metadata Upload Finished" + "\n\n");
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KoneksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KoneksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KoneksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KoneksiView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new MigrasiMetadata().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxJenisBerkas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPilihBerkas = new javax.swing.JTextField();
        jButtonBerkas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFileIdentifer = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jipaddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDeskripsi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaLogData = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButtonBaru = new javax.swing.JButton();
        jButtonSimpan = new javax.swing.JButton();
        jButtonTutup = new javax.swing.JButton();
        jprocessbar = new javax.swing.JProgressBar();
        downloadFile = new javax.swing.JButton();
        reconnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI METADATA");
        setResizable(false);

        jLabel1.setText("JENIS BERKAS");

        jComboBoxJenisBerkas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXCEL", "XML" }));

        jLabel2.setText("PILIH BERKAS");

        jButtonBerkas.setIcon(new javax.swing.ImageIcon("D:\\KODE\\big.igs.md\\src\\main\\resources\\assets\\Folder-Open-icon.png")); // NOI18N
        jButtonBerkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBerkasActionPerformed(evt);
            }
        });

        jLabel3.setText("FILE IDENTIFIER");

        jLabel4.setText("IP ADDRESS");

        jipaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jipaddressActionPerformed(evt);
            }
        });

        jLabel5.setText("DESKRIPSI");

        jTextAreaDeskripsi.setColumns(20);
        jTextAreaDeskripsi.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDeskripsi);

        jTextAreaLogData.setColumns(20);
        jTextAreaLogData.setRows(5);
        jScrollPane2.setViewportView(jTextAreaLogData);

        jLabel6.setText("LOG DATA");

        jButtonBaru.setText("BARU");
        jButtonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBaruActionPerformed(evt);
            }
        });

        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });

        jButtonTutup.setText("TUTUP");
        jButtonTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTutupActionPerformed(evt);
            }
        });

        downloadFile.setIcon(new javax.swing.ImageIcon("D:\\KODE\\big.igs.md\\src\\main\\resources\\assets\\downloads-icon (1).png")); // NOI18N
        downloadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadFileActionPerformed(evt);
            }
        });

        reconnect.setIcon(new javax.swing.ImageIcon("D:\\KODE\\big.igs.md\\src\\main\\resources\\assets\\connection.png")); // NOI18N
        reconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(downloadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                            .addComponent(jipaddress)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxJenisBerkas, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(271, 271, 271))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldPilihBerkas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jButtonBerkas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldFileIdentifer)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jprocessbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBaru, jButtonSimpan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxJenisBerkas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPilihBerkas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButtonBerkas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFileIdentifer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jipaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(downloadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jprocessbar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSimpan)))
                    .addComponent(jButtonTutup, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBaru, jButtonSimpan, jButtonTutup});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBerkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBerkasActionPerformed
        try {
            // TODO add your handling code here:
            SetFile();
            jButtonSimpan.setEnabled(true);
            jButtonBaru.setEnabled(true);
            if (jTextAreaLogData.equals("")) {
                setColumn();
            } else {
                clearFormWithoutIp();
                setColumn();
            }

        } catch (SAXException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBerkasActionPerformed

    private void jButtonTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTutupActionPerformed
        // TODO add your handling code here:
        this.setVisible(false); //you can't see me!
        this.dispose(); //Destroy the JFrame object
        System.exit(0);
    }//GEN-LAST:event_jButtonTutupActionPerformed

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        try {


            String fileIdentifier = varMetadataEntitySetInformation.getFileIdentifier();
            String title = varCitation.getTitle();
            String specification = varMdFormat.getSpesification();
            String denominator = varSpatialResolution.getDenominator();
            String suplementationInformation = varIdentificationInformation.getSupplementallnformation();
            String ciDate = varReferenceSystem.getDate_();
            long x=0;
            
            boolean isBlankSpaceInFirst = fileIdentifier.charAt(0) == ' ';
            boolean isEmptyTitle = title.equals("-") || title.isEmpty();
            boolean isEmptySpesification = specification.equals("-") || specification.isEmpty();
            boolean isEmptyDenominator = denominator.equals("-") || denominator.isEmpty();
            boolean isEmptySuplementationInformation = suplementationInformation.equals("-") || suplementationInformation.isEmpty();
            boolean isEmptyCiDate = ciDate.equals("-") || ciDate.isEmpty();
            boolean isEmptyFileIdentifer = fileIdentifier.equals("-") || fileIdentifier.isEmpty();
            String newIdentifier = "";

            if (isBlankSpaceInFirst) {
                newIdentifier = fileIdentifier.replace(" ", "");
            } else {
                newIdentifier = fileIdentifier;
            }

            boolean isRbi = newIdentifier.substring(0, 3).equalsIgnoreCase("rbi");
            boolean isLpi = newIdentifier.substring(0, 3).equalsIgnoreCase("lpi");
            boolean isLln = newIdentifier.substring(0, 3).equalsIgnoreCase("lln");

            if (!((isRbi) || (isLpi) || (isLln))) {
                JOptionPane.showMessageDialog(this, "Fileidentifier tidak mengandung salah satu value berikut : RBI,LPI,LLN di awal");
                return;
            }
            if (isEmptyTitle) {
                JOptionPane.showMessageDialog(this, "Citation Title di elemen identificationinfo wajib terisi");
                return;
            }
            if (isEmptySpesification) {
                JOptionPane.showMessageDialog(this, "Spesification Md_Format di elemen identificationinfo wajib terisi karena digunakan saat migrasi dari development ke produksi");
                return;
            }
            if (isEmptyDenominator) {
                JOptionPane.showMessageDialog(this, "Denominator MD_Resolution di elemen identificationinfo wajib terisi, dan bertipe numerik");
                return;
            }
            if (isEmptySuplementationInformation) {
                JOptionPane.showMessageDialog(this, "SuplementationInformation di elemen identificationinfo wajib terisi untuk topologi spasial saat migrasi ke publikasi");
                return;
            }
            if (isEmptyCiDate) {
                JOptionPane.showMessageDialog(this, "Ci_date di elemen reference system wajib terisi, untuk menyimpan temporal data");
                return;
            }
            if (isEmptyFileIdentifer) {
                JOptionPane.showMessageDialog(this, "Fileidentifier wajib terisi");
                return;
            }
            
            try{
                x = Long.parseLong(denominator);
                
            }catch(NumberFormatException n){
                n.printStackTrace();
                
                JOptionPane.showMessageDialog(this, "Denominator MD_Resolution di elemen identificationinfo wajib terisi, dan bertipe numerik");
                return;
            }

            Thread thread = new Thread() {
                public void run() {

                    DefaultCaret caret = (DefaultCaret) jTextAreaLogData.getCaret();
                    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

                    saveUpdateMetadataEntitySetInformation();
                    saveUpdateSpatialInformation();
                    saveUpdateReferenceSystemInformation();
                    saveUpdateMetadataExtensionInformation();
                    saveUpdateIdentificationInformation();
                    saveUpdateContentInformation();
                    saveUpdateDataQualityInfo();
                    saveUpdatePortrayalCatalagueInformation();
                    saveUpdateMetadataConstraintsInformation();
                    saveUpdateApplicationSchemaInformation();
                    saveUpdateMaintenanceInformation();
                    saveUpdateMetadataUploadInformation();

                    session.close();
                    jButtonSimpan.setEnabled(false);
                }
            };

            thread.start();

        } catch (NullPointerException n) {
            n.printStackTrace();

        }


    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jButtonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBaruActionPerformed
        // TODO add your handling code here:
        //clearForm();
        clearFormWithoutIp();

        listMdGeometricObject.clear();
        listMdKeywordObject.clear();

        session = hibernateUtilXml.buildSession().openSession();

        jprocessbar.setValue(0);
        jprocessbar.setMinimum(progressMin);
        //jprocessbar.setMaximum(progressMax);
        jButtonSimpan.setEnabled(false);

        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        
    }//GEN-LAST:event_jButtonBaruActionPerformed

    private void jipaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jipaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jipaddressActionPerformed

    private void downloadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadFileActionPerformed
        // TODO add your handling code here:  
    
//        jTextFieldPilihBerkas.setText(file.toString());
        String fileIdentifier = varMetadataEntitySetInformation.getFileIdentifier();
        MdUploadFileController mdUploadFileController = new MdUploadFileController();

        Blob dataBlob = mdUploadFileController.getDataById(fileIdentifier).getFileName();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("D:\\" + fileIdentifier + ".xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fos.write(dataBlob.getBytes(1, (int) dataBlob.length()));
            fos.close();
        } catch (SQLException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MigrasiMetadata.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_downloadFileActionPerformed

    private void reconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reconnectActionPerformed
        // TODO add your handling code here:

        clearForm();

        listMdGeometricObject.clear();
        listMdKeywordObject.clear();

        if (session.isOpen()) {
            session.close();
        }

        jprocessbar.setValue(0);
        jprocessbar.setMinimum(progressMin);
        //jprocessbar.setMaximum(progressMax);

        System.out.print("\033[H\033[2J");
        System.out.flush();

//        KoneksiView koneksiView = new KoneksiView();
//        koneksiView.setVisible(true);
        KoneksiUlang ulang = new KoneksiUlang();
        ulang.setVisible(true);

    }//GEN-LAST:event_reconnectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton downloadFile;
    private javax.swing.JButton jButtonBaru;
    private javax.swing.JButton jButtonBerkas;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JButton jButtonTutup;
    private javax.swing.JComboBox<String> jComboBoxJenisBerkas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaDeskripsi;
    private javax.swing.JTextArea jTextAreaLogData;
    private javax.swing.JTextField jTextFieldFileIdentifer;
    private javax.swing.JTextField jTextFieldPilihBerkas;
    private javax.swing.JTextField jipaddress;
    private javax.swing.JProgressBar jprocessbar;
    private javax.swing.JButton reconnect;
    // End of variables declaration//GEN-END:variables

}
