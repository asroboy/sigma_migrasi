/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.HibernateUtilXml;
import controller.CiAddressController;
import controller.CiAddressDeliveryPointController;
import controller.CiAddressEmailAddressController;
import controller.CiCitationAlternateTitleController;
import controller.CiCitationController;
import controller.CiCitationPresentationFormController;
import controller.CiContactController;
import controller.CiDateController;
import controller.CiOnlineResourceController;
import controller.CiResponsiblePartyController;
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
import controller.MdConstraintsController;
import controller.MdConstraintsUseLimitationController;
import controller.MdContentInfoController;
import controller.MdCoverageDescriptionController;
import controller.MdDataIdentificationCharsetController;
import controller.MdDataIdentificationController;
import controller.MdDataIdentificationLangController;
import controller.MdDataIdentificationSpatrepController;
import controller.MdDataIdentificationTopcatController;
import controller.MdDigitalTransferOptionsController;
import controller.MdDistributionController;
import controller.MdDistributorController;
import controller.MdExtendedElementInfoController;
import controller.MdExtendedElementInfoParentController;
import controller.MdFormatController;
import controller.MdGeometricObjectsController;
import controller.MdIdentificationController;
import controller.MdIdentificationCreditController;
import controller.MdIdentificationStatusController;
import controller.MdIdentifierController;
import controller.MdKeywordController;
import controller.MdKeywordKeywordController;
import controller.MdLegalConstraintsController;
import controller.MdLegalConstraintsOtherController;
import controller.MdMaintenanceInfoController;
import controller.MdMediumController;
import controller.MdMetadataController;
import controller.MdMetadataExtensionInfoController;
import controller.MdMetadataHierarchyLvController;
import controller.MdMetadataHierarchyLvNameController;
import controller.MdPortrayalCatalogueRefController;
import controller.MdReferenceSystemController;
import controller.MdRepresentativeFractionController;
import controller.MdResolutionController;
import controller.MdSecurityConstraintsController;
import controller.MdSpatialRepresentationController;
import controller.MdUploadFileController;
import controller.MdVectorSpatialRepresentationController;
import controller.RsIdentifierController;
import controller.SvServiceIdentificationController;
import domain.MdGeometricObjects;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;
import model.metadata.xml.ParentElement;
import model.table.CiCitationModel;
import model.table.CiOnlineResourceModel;
import model.table.CiResponsiblePartyModel;
import model.table.DqElementModel;
import model.table.ExExtentModel;
import model.table.ExGeographicExtentModel;
import model.table.LiProcessStepModel;
import model.table.LiSourceModel;
import model.table.MdConstraintsModel;
import model.table.MdDigitalTransferOptionsModel;
import model.table.MdDistributorModel;
import model.table.MdFormatModel;
import model.table.MdGeometricObjectsModel;
import model.table.MdIdentifierModel;
import model.table.MdMaintenanceInfoModel;
import model.table.MdMetadataModel;
import model.table.MdReferenceSystemModel;
import model.table.MdRepresentativeFractionModel;
import model.table.RsIdentifierModel;
import org.hibernate.Session;

/**
 *
 * @author USER DELL
 */
public class DeleteMigrasiMetadataNoView extends javax.swing.JFrame {

    /**
     * Creates new form MigrasiMetadata
     */
    // global variable
    private UIManager.LookAndFeelInfo looks[];
    private JFileChooser dialog = new JFileChooser();
    private FileInputStream inputStream = null;
    private HibernateUtilXml hibernateUtilXml;
    private Session session;
    private int progressMin = 0;
    private int progressMax = 776;
    private String fileName = "";
    
    String xmlPath = "";
    JTextArea jTextAreaLogData;
    JProgressBar jprocessbar;

    public DeleteMigrasiMetadataNoView(JProgressBar jProgressBar1, JTextArea jTextAreaLog, HibernateUtilXml hibernateUtilXml) {
//        this.xmlPath = path;
       // this.fileName = path;
        this.hibernateUtilXml = hibernateUtilXml;
        session = hibernateUtilXml.buildSession().openSession();
        jTextAreaLogData = jTextAreaLog;
        jprocessbar = jProgressBar1;
        jprocessbar.setMinimum(progressMin);
        jprocessbar.setMaximum(progressMax);       

    }
    
    public List getAllFileIdentifier(){
        
        MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
        List list = mmc.getAllFileIdentifier();
        
        return list;
        
    }
    
    private void displayLog(boolean status,String message){
        
        if(status){
            jTextAreaLogData.setForeground(Color.BLACK);
            jTextAreaLogData.append(message+ "\n");
        }else{
            jTextAreaLogData.setForeground(Color.red);
            jTextAreaLogData.append(message+ "\n");
        }
    }
    
    private void info(String newIdentifier) {
        
      //  DeleteMetadataPanel  
        String ret=null;
        BigDecimal id=null;
        
        try{
            MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);    
            id = mmc.getDataById(MdMetadataModel.FILEIDENTIFIER, newIdentifier).getId();
           
            ret="selesai, belum terhapus semua cek C:/migrasi/log/"+newIdentifier+".txt";
         
        }catch(NullPointerException n){
            
            deleteMetadataUploadInformation(newIdentifier);            
            ret="selesai, berhasil menghapus semua cek D:/Log_metadata/DELETE/"+newIdentifier+".txt";
            //n.printStackTrace();
            System.out.println("id => "+n.toString());
            
        }finally{
            
            System.out.println("SELECT MD_METADATA.ID FROM MD_METADATA WHERE FILEIDENTIFIER= "+newIdentifier+" ID => "+id);
            JOptionPane.showMessageDialog(this, ret);
            return;
            
        }
    }
    
    private void writeToFile(String fileIdentifier){
        
        BufferedWriter bw = null;
        FileWriter fw = null;
            
        try{
            
            File file = new File("C:/migrasi/log/");
            file.mkdir();
            fw = new FileWriter("C:/migrasi/log/"+fileIdentifier+"_DELETE_LOG.txt");
            bw = new BufferedWriter(fw);
            
            bw.write(jTextAreaLogData.getText());
                      
        }catch(IOException i){
           Logger.getLogger(DeleteMigrasiMetadataNoView.class.getName()).log(Level.SEVERE, null, i);
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
      
    public void deleteAll(String fileIdentifier){
        
        try{
            
            MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
            
            String newIdentifier = mmc.checkFileidentifier(fileIdentifier);
            BigDecimal mdMetadataId = mmc.getDataById(MdMetadataModel.FILEIDENTIFIER, newIdentifier).getId(); 
             
            if(mdMetadataId==null){
                JOptionPane.showMessageDialog(this, "Fileidentifier tidak ditemukan");
                return;
                
            }else{
                
                Thread thread = new Thread(){
                        
                    public void run(){
                        
                        DefaultCaret caret = (DefaultCaret) jTextAreaLogData.getCaret();
                        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                        
                        displayLog(true, "menghapus metadata dengan fileidentifier "+newIdentifier+"\n");
                        //sas
                        deleteMetadataSpatialInformation(mdMetadataId);//6
                        deleteMetadataReferenceSystemInformation(mdMetadataId);//14
                        deleteMetadataExtensionInformation(mdMetadataId);//28
                        deleteIdentificationInformation(mdMetadataId);//154
                        deleteContentInformation(mdMetadataId);//158
                        deleteDataQualityInformation(mdMetadataId);//704
                        deleteMetadataPortrayalCatalagueInformation(mdMetadataId);//712
                        deleteMetadataConstraintsInformation(mdMetadataId);//718
                        deleteMetadataApplicationSchemaInformation(mdMetadataId);//724
                        deleteMetadataMaintenanceInformation(mdMetadataId);//726
                        deleteMetadataDistributionInformation(mdMetadataId);//750
                        deleteMetadatEntitySetInformation(mdMetadataId);//774
                      
                        info(newIdentifier);
                        writeToFile(newIdentifier);
                        
                    }           
                };
                
                thread.start();                         
            }      
            
        }catch(Exception n){
            n.printStackTrace();
            System.out.println("Error : metadata id is "+n.toString());
        }
          
    }
    
    private void deleteMetadatEntitySetInformation(BigDecimal id){
    
        jTextAreaLogData.append("menghapus elemen metadata entity set information" + "\n\n");
        System.out.println("Elemen => "+ParentElement.ROOT);
        
            try{
                    
                    DELETE_MD_METADATA_HIERARCHYLV(id);
                    jprocessbar.setValue(752);
                    jprocessbar.setStringPainted(true);
                    
                    DELETE_MD_METADATA_HIERARCHYLVNAME(id);
                    jprocessbar.setValue(754);
                    jprocessbar.setStringPainted(true);

                        CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                        BigDecimal ciResponsiblepartyId = crpc.getDataById(CiResponsiblePartyModel.MD_METADATAID, id).getId();

                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();

                                CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                                BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();
                                
                                    DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                                    jprocessbar.setValue(756);
                                    jprocessbar.setStringPainted(true);
                                    
                                    DELETE_CI_TELEPHONE_FACSIMILE(ciTelephoneId);
                                    jprocessbar.setValue(758);
                                    jprocessbar.setStringPainted(true);
                                    
                                DELETE_CI_TELEPHONE(ciTelephoneId);
                                jprocessbar.setValue(760);
                                jprocessbar.setStringPainted(true);

                                CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                                BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();
                                
                                    DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                                    jprocessbar.setValue(762);
                                    jprocessbar.setStringPainted(true);
                                    
                                    DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                                    jprocessbar.setValue(764);
                                    jprocessbar.setStringPainted(true);
                                
                                DELETE_CI_ADDRESS(ciAddressId);
                                jprocessbar.setValue(766);
                                jprocessbar.setStringPainted(true);

                                DELETE_CI_ONLINERESOURCE(ciContactId,CiOnlineResourceModel.CI_CONTACTID);
                                jprocessbar.setValue(768);
                                jprocessbar.setStringPainted(true);
                                
                            DELETE_CI_CONTACT(ciContactId);
                            jprocessbar.setValue(770);
                            jprocessbar.setStringPainted(true);

                        DELETE_CI_RESPONSIBLEPARTY(ciResponsiblepartyId);
                        jprocessbar.setValue(772);
                        jprocessbar.setStringPainted(true);
                        
                DELETE_MD_METADATA(id);
                jprocessbar.setValue(774);
                jprocessbar.setStringPainted(true);
                
            }catch(Exception n){
                n.printStackTrace();
            }
             
        System.out.println("\nBerhasil Menghapus Metadata Entity Information\n");
        jTextAreaLogData.append("Berhasil Menghapus Metadata Entity Information\n\n");
        
    }
    
    private void deleteMetadataSpatialInformation(BigDecimal id){
        
        System.out.println("Elemen => "+ParentElement.SPATIALREPRESENTATIONINFO);
        jTextAreaLogData.append("menghapus elemen metadata spatial information" + "\n\n");
        
        try{
            
                MdSpatialRepresentationController msrc = new MdSpatialRepresentationController(session, hibernateUtilXml);
                BigDecimal mdSpatialRepresentationId = msrc.getDataById(id).getId();

                    MdVectorSpatialRepresentationController mvsrc = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);
                    BigDecimal mdVectorSpatialId = mvsrc.getDataById(mdSpatialRepresentationId).getId();

                            MdGeometricObjectsController mgoc = new MdGeometricObjectsController(session, hibernateUtilXml);
                            List mdGeometricObjectId = mgoc.getListOfId(mdVectorSpatialId);
                            DELETE_MD_GEOMETRICOBJECTS(mdGeometricObjectId);
                            jprocessbar.setValue(2);
                            jprocessbar.setStringPainted(true);

                    DELETE_MD_VECTORSPATIALREPRESENTATION(mdVectorSpatialId);
                    jprocessbar.setValue(4);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_SPATIALREPRESENTATION(mdSpatialRepresentationId);
                jprocessbar.setValue(6);
                jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                      
        jTextAreaLogData.append("Berhasil Menghapus Metadata Spatial Information\n\n");
               
    }
    
    private void deleteMetadataReferenceSystemInformation(BigDecimal id){
    
        jTextAreaLogData.append("menghapus elemen metadata reference system" + "\n\n");
        System.out.println("Elemen => "+ParentElement.REFERENCESYSTEMINFO);
        
        try{
            
                MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
                BigDecimal mdReferenceSystemId = mrsc.getDataById(MdReferenceSystemModel.MD_METADATAID, id).getId();

                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                    BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();

                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID, rsIdentifierId).getId();
                            System.out.println(ciCitationId + " "+ ParentElement.REFERENCESYSTEMINFO);
                            
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(8);
                            jprocessbar.setStringPainted(true);
                            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(10);
                        jprocessbar.setStringPainted(true);

                    DELETE_RS_IDENTIFIER(rsIdentifierId);
                    jprocessbar.setValue(12);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_REFERENCESYSTEM(mdReferenceSystemId); 
                jprocessbar.setValue(14);
                jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }    
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Reference System Information\n\n");
        
    }
    
     private void deleteMetadataDistributionInformation(BigDecimal id){
    
        jTextAreaLogData.append("menghapus elemen Distribution Information" + "\n\n");
        System.out.println("Elemen => "+ParentElement.REFERENCESYSTEMINFO);
        
        try{
            
                MdDistributionController mdc = new MdDistributionController(session, hibernateUtilXml);
                BigDecimal mdDistributionId = mdc.getDataById(id).getId();
                    
                    MdDistributorController mdr = new MdDistributorController(session, hibernateUtilXml);
                    BigDecimal mdDistributorId = mdr.getDataById(MdDistributorModel.MD_DISTRIBUTIONID, mdDistributionId).getId();
                    
                        CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                        BigDecimal ciResponsiblepartyId = crpc.getDataById(CiResponsiblePartyModel.MD_DISTRIBUTORID, mdDistributorId).getId();

                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();

                                CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                                BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();
                                
                                    DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                                    jprocessbar.setValue(728);
                                    jprocessbar.setStringPainted(true);
                                    
                                    DELETE_CI_TELEPHONE_FACSIMILE(ciTelephoneId);
                                    jprocessbar.setValue(730);
                                    jprocessbar.setStringPainted(true);
                                    
                                DELETE_CI_TELEPHONE(ciTelephoneId);
                                jprocessbar.setValue(732);
                                jprocessbar.setStringPainted(true);

                                CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                                BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();
                                
                                    DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                                    jprocessbar.setValue(734);
                                    jprocessbar.setStringPainted(true);
                                    
                                    DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                                    jprocessbar.setValue(736);
                                    jprocessbar.setStringPainted(true);
                                
                                DELETE_CI_ADDRESS(ciAddressId);
                                jprocessbar.setValue(738);
                                jprocessbar.setStringPainted(true);

                                DELETE_CI_ONLINERESOURCE(ciContactId,CiOnlineResourceModel.CI_CONTACTID);
                                jprocessbar.setValue(740);
                                jprocessbar.setStringPainted(true);
                                
                            DELETE_CI_CONTACT(ciContactId);
                            jprocessbar.setValue(742);
                            jprocessbar.setStringPainted(true);

                        DELETE_CI_RESPONSIBLEPARTY(ciResponsiblepartyId);
                        jprocessbar.setValue(744);
                        jprocessbar.setStringPainted(true);
                        
                    DELETE_MD_DISTRIBUTOR(mdDistributorId);
                    jprocessbar.setValue(746);
                    jprocessbar.setStringPainted(true);
                    
                    MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
                    BigDecimal mdDigitalTransferOptId = mdtoc.getDataById(MdDigitalTransferOptionsModel.MD_DISTRIBUTIONID, mdDistributionId).getId();
                    DELETE_MD_DIGITAL_TRANSFER_OPTIONS(mdDigitalTransferOptId);
                    jprocessbar.setValue(748);
                    jprocessbar.setStringPainted(true);
                    
                DELETE_MD_DISTRIBUTION(mdDistributionId);
                jprocessbar.setValue(750);
                jprocessbar.setStringPainted(true);                          
            
        }catch(Exception n){
            n.printStackTrace();
        }    
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Distribution Information\n\n");
        
    }
    
    private void deleteMetadataPortrayalCatalagueInformation(BigDecimal id){
    
        jTextAreaLogData.append("menghapus elemen metadata portrayal catalogue information" + "\n\n");
        System.out.println("Elemen => "+ParentElement.PORTRAYALCATALOGUEINFO);
        
        try{
            
                MdPortrayalCatalogueRefController mpcrc = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
                BigDecimal mdPortrayalId = mpcrc.getDataById(id).getId();

                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDPORTRAYALCATALOGUEREFID, mdPortrayalId).getId();

                        DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                        jprocessbar.setValue(706);
                        jprocessbar.setStringPainted(true);
                        
                        DELETE_CI_DATE(ciCitationId);
                        jprocessbar.setValue(708);
                        jprocessbar.setStringPainted(true);

                    DELETE_CI_CITATION(ciCitationId);
                    jprocessbar.setValue(710);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_PORTRAYALCATALOGUEREF(mdPortrayalId);
                jprocessbar.setValue(712);
                jprocessbar.setStringPainted(true);
                
        }catch(Exception n){
            n.printStackTrace();
        }
                
        System.out.println("Berhasil Menghapus Metadata Portrayal Catalague Information\n\n");
         
    }
    
    private void deleteMetadataExtensionInformation(BigDecimal id) {
    
        jTextAreaLogData.append("menghapus elemen metadata extension information" + "\n\n");
        System.out.println("Elemen => "+ParentElement.METADATAEXTENSIONINFO);
        
        try{
            
                MdMetadataExtensionInfoController mmeic = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
                BigDecimal mdExtensionInfoId = mmeic.getDataById(id).getId();

                    DELETE_CI_ONLINERESOURCE(mdExtensionInfoId,CiOnlineResourceModel.MD_METADATAEXTENSIONINFOID);
                    jprocessbar.setValue(16);
                    jprocessbar.setStringPainted(true);

                    MdExtendedElementInfoController meeic = new MdExtendedElementInfoController(session, hibernateUtilXml);
                    BigDecimal mdExtendedElementId = meeic.getDataById(mdExtensionInfoId).getId();

                        DELETE_MD_EXTENDED_ELEMENTINFO_PARENT(mdExtendedElementId);
                        jprocessbar.setValue(18);
                        jprocessbar.setStringPainted(true);

                        CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                        BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.MD_EXTENDEDELEMENTINFOID, mdExtendedElementId).getId();

                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                                DELETE_CI_ONLINERESOURCE(ciContactId,CiOnlineResourceModel.CI_CONTACTID);
                                jprocessbar.setValue(20);
                                jprocessbar.setStringPainted(true);
                                
                            DELETE_CI_CONTACT(ciContactId);
                            jprocessbar.setValue(22);
                            jprocessbar.setStringPainted(true);

                        DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
                        jprocessbar.setValue(24);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_EXTENDED_ELEMENT(mdExtendedElementId);
                    jprocessbar.setValue(26);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_METADATA_EXTENSIONINFO(mdExtensionInfoId);
                jprocessbar.setValue(28);
                jprocessbar.setStringPainted(true);
                
        }catch(Exception n){
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Extension Information\n\n");
        
    }
    
    private void deleteContentInformation(BigDecimal id){
    
        jTextAreaLogData.append("menghapus elemen metadata content information" + "\n\n");
        System.out.println("Elemen => "+ParentElement.CONTENTINFO);
        
         try{
             
                MdContentInfoController mcic = new  MdContentInfoController(session, hibernateUtilXml);
                BigDecimal mdContentInfoId = mcic.getDataById(id).getId();
                
                       DELETE_MD_COVERAGE_DESCRIPTION(mdContentInfoId);
                       jprocessbar.setValue(156);
                       jprocessbar.setStringPainted(true);

                DELETE_MD_CONTENT_INFO(mdContentInfoId);
                jprocessbar.setValue(158);
                jprocessbar.setStringPainted(true);
                
         }catch(Exception n){
             n.printStackTrace();
         }
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Content Information\n\n");
       
    }
    
    private void deleteIdentificationInformation(BigDecimal id){
    
       jTextAreaLogData.append("menghapus elemen metadata identification information" + "\n\n");
       System.out.println("Elemen => "+ ParentElement.IDENTIFICATIONINFO);
       
        try{
            
            MdIdentificationController mic = new MdIdentificationController(session, hibernateUtilXml);
            BigDecimal mdIdentificationId = mic.getDataById(id).getId();
                
                System.out.println(mdIdentificationId+" mdIdentificationId");
                DELETE_MD_IDENTIFICATION_STATUS(mdIdentificationId);
                jprocessbar.setValue(30);
                jprocessbar.setStringPainted(true);
                
                DELETE_MD_IDENTIFICATION_CREDIT(mdIdentificationId);
                jprocessbar.setValue(32);
                jprocessbar.setStringPainted(true);

                SvServiceIdentificationController ssic = new SvServiceIdentificationController(session, hibernateUtilXml);
                BigDecimal svServiceIdentificationId = ssic.getDataById(mdIdentificationId).getId();

                    MdDataIdentificationController mdic = new MdDataIdentificationController(session, hibernateUtilXml);
                    BigDecimal mdDataIdentificationId = mdic.getDataById(mdIdentificationId).getId();

                        DELETE_MD_DATAIDENTIFICATION_SPATREP(mdDataIdentificationId);
                        jprocessbar.setValue(34);
                        jprocessbar.setStringPainted(true);
                        DELETE_MD_DATAIDENTIFICATION_LANG(mdDataIdentificationId);
                        jprocessbar.setValue(36);
                        jprocessbar.setStringPainted(true);
                        DELETE_MD_DATAIDENTIFICATION_CHARSET(mdDataIdentificationId);
                        jprocessbar.setValue(38);
                        jprocessbar.setStringPainted(true);
                        DELETE_MD_DATAIDENTIFICATION_TOPCAT(mdDataIdentificationId);
                        jprocessbar.setValue(40);
                        jprocessbar.setStringPainted(true);
                       
                        //citation 
                        System.out.println("Elemen "+ ParentElement.CITATION);
                        displayLog(true, "subElemen Citation\n");
                        citation(mdIdentificationId);//58
                        displayLog(true, "akhir subElemen Citation\n");
                        
                        //pointofcontact
                        System.out.println("Elemen "+ ParentElement.POINTOFCONTACT);
                        displayLog(true, "subElemen PointofContact\n");
                        pointOfContact(mdIdentificationId);//76
                        displayLog(true, "akhir subElemen PointofContact\n");
                        
                        //resourcemaintenance
                        System.out.println("Elemen "+ ParentElement.RESOURCEMAINTENANCE);
                        displayLog(true, "subElemen Resource Maintenance\n");
                        resourceMaintenance(mdIdentificationId);//78
                        displayLog(true, "akhir subElemen Resource Maintenance\n");
                                      
                        //graphicoverview
                        System.out.println("Elemen "+ ParentElement.GRAPHICOVERVIEW);
                        displayLog(true, "subElemen Graphic Overview\n");
                        graphicOverview(mdIdentificationId);//80
                        displayLog(true, "akhir subElemen Graphic Overview\n");
                       
                        //resourceformat
                        System.out.println("Elemen "+ ParentElement.RESOURCEFORMAT);
                        displayLog(true, "subElemen Resource Format\n");
                        resourceFormat(mdIdentificationId);//96
                        displayLog(true, "akhir subElemen Resource Format\n");
                        
                        //descriptivekeywords
                        System.out.println("Elemen "+ ParentElement.DESCRIPTIVEKEYWORDS);
                        displayLog(true, "subElemen Descriptive Keywords\n");
                        descriptiveKeywords(mdIdentificationId);//112
                        displayLog(true, "akhir subElemen Descriptive Keywords\n");
                            
                        //resourceconstraints
                        System.out.println("Elemen "+ ParentElement.RESOURCECONSTRAINTS);
                        displayLog(true, "subElemen Resource Constraints\n");
                        resourceConstraints(mdIdentificationId);//122
                        displayLog(true, "akhir subElemen Resource Constraints\n");
                        
                        //spatialresolution
                        System.out.println("Elemen "+ ParentElement.SPATIALRESOLUTION);
                        displayLog(true, "subElemen Spatial Resolution\n");
                        spatialResolution(mdDataIdentificationId);//126
                        displayLog(true, "akhir subElemen Spatial Resolution\n");
                        
                       // aggregationinfo
                        System.out.println("Elemen "+ ParentElement.AGGREGATIONINFO);
                        displayLog(true, "subElemen AggregationInfo\n");
                        aggregationInfo(mdIdentificationId);//138
                        displayLog(true, "akhir subElemen AggregationInfo\n");
                        
                        //extent
                        System.out.println("Elemen "+ ParentElement.EXTENT);
                        displayLog(true, "subElemen ExExtent\n");
                        extent(mdDataIdentificationId);//148
                        displayLog(true, "akhir subElemen ExExtent\n");
                        
                    DELETE_MD_DATAIDENTIFICATION(mdDataIdentificationId);
                    jprocessbar.setValue(150);
                    jprocessbar.setStringPainted(true);

                DELETE_SV_SERVICEIDENTIFICATION(svServiceIdentificationId);
                jprocessbar.setValue(152);
                jprocessbar.setStringPainted(true);
            
            DELETE_MD_IDENTIFICATION(mdIdentificationId);     
            jprocessbar.setValue(154);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                         
       jTextAreaLogData.append("Berhasil Menghapus Metadata Identification Information\n\n");
    }
    
    private void deleteMetadataConstraintsInformation(BigDecimal id){
        
        jTextAreaLogData.append("menghapus elemen metadata constraints information" + "\n\n");
        System.out.println("Elemen => "+ ParentElement.METADATACONSTRAINTS);
        
        try{
        
            MdConstraintsController mci = new MdConstraintsController(session, hibernateUtilXml);
            BigDecimal mdConstraintsId = mci.getDataById(MdConstraintsModel.MD_METADATAID,id).getId();

                DELETE_MD_METADATA_CONSTRAINTS_USE_LIMITATION(mdConstraintsId);
                jprocessbar.setValue(714);
                jprocessbar.setStringPainted(true);
                
                //baru
                DELETE_MD_METADATA_SECURITY_CONSTRAINTS(mdConstraintsId);
                jprocessbar.setValue(716);
                jprocessbar.setStringPainted(true);
                                
            DELETE_MD_CONSTRAINTSINFO(mdConstraintsId);
            jprocessbar.setValue(718);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Constraints Information\n\n");
        
    }
    
    private void deleteMetadataApplicationSchemaInformation(BigDecimal id){
        
        jTextAreaLogData.append("menghapus elemen metadata application information" + "\n\n");
        System.out.println("Elemen => "+ ParentElement.APPLICATIONSCHEMAINFO);
        
        try{
              
            MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
            BigDecimal mdApplicationSchemaInfoId = masic.getDataById(id).getId();

                CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDAPPLICATIONSCHEMAINFOID, mdApplicationSchemaInfoId).getId();

                    DELETE_CI_DATE(ciCitationId);
                    jprocessbar.setValue(720);
                    jprocessbar.setStringPainted(true);
                    
                DELETE_CI_CITATION(ciCitationId);
                jprocessbar.setValue(722);
                jprocessbar.setStringPainted(true);

            DELETE_MD_APPLICATION_SCHEMA_INFO(mdApplicationSchemaInfoId);
            jprocessbar.setValue(724);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Application Schema Information\n\n");  
        
    }
    
    private void citation(BigDecimal mdIdentificationId) {
       
        try{
                        
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFICATIONID, mdIdentificationId).getId();
            System.out.println(ciCitationId);
            
                DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                jprocessbar.setValue(42);
                jprocessbar.setStringPainted(true);
                
                DELETE_CI_DATE(ciCitationId);
                jprocessbar.setValue(44);
                jprocessbar.setStringPainted(true);
                                
                DELETE_CI_CITATION_PRESENTATION_FORM(ciCitationId);
                jprocessbar.setValue(46);
                jprocessbar.setStringPainted(true);
                
                CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.CI_CITATIONID, ciCitationId).getId();
                
                DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
                jprocessbar.setValue(48);
                jprocessbar.setStringPainted(true);

                MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();

                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                    BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID, mdIdentifierId).getId();

                        BigDecimal ciCitationIdentifier = ccc.getDataById(CiCitationModel.RSIDENTIFIERID, rsIdentifierId).getId();

                            DELETE_CI_DATE(ciCitationIdentifier);
                            jprocessbar.setValue(50);
                            jprocessbar.setStringPainted(true);
                            
                        DELETE_CI_CITATION(ciCitationIdentifier);
                        jprocessbar.setValue(52);
                        jprocessbar.setStringPainted(true);

                    DELETE_RS_IDENTIFIER(rsIdentifierId);
                    jprocessbar.setValue(54);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_IDENTIFIER(mdIdentifierId);
                jprocessbar.setValue(56);
                jprocessbar.setStringPainted(true);

            DELETE_CI_CITATION(ciCitationId);
            jprocessbar.setValue(58);
            jprocessbar.setStringPainted(true);

        }catch(Exception n){
            n.printStackTrace();
        }
                
    }
    
    private void pointOfContact(BigDecimal mdIdentificationId){
        
        try{
                
                CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();
                    
                    System.out.println(ciResponsiblePartyId);
                    CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                    BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                        CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                        BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                            DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                            jprocessbar.setValue(60);
                            jprocessbar.setStringPainted(true);
                            
                            DELETE_CI_TELEPHONE_FACSIMILE(ciTelephoneId);
                            jprocessbar.setValue(62);
                            jprocessbar.setStringPainted(true);
                            
                        DELETE_CI_TELEPHONE(ciTelephoneId);
                        jprocessbar.setValue(64);
                        jprocessbar.setStringPainted(true);

                        CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                        BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                            DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                            jprocessbar.setValue(66);
                            jprocessbar.setStringPainted(true);
                            
                            DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                            jprocessbar.setValue(68);
                            jprocessbar.setStringPainted(true);
                            
                        DELETE_CI_ADDRESS(ciAddressId);
                        jprocessbar.setValue(70);
                        jprocessbar.setStringPainted(true);

                        DELETE_CI_ONLINERESOURCE(ciContactId, CiOnlineResourceModel.CI_CONTACTID);
                        jprocessbar.setValue(72);
                        jprocessbar.setStringPainted(true);

                    DELETE_CI_CONTACT(ciContactId);
                    jprocessbar.setValue(74);
                    jprocessbar.setStringPainted(true);

                DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
                jprocessbar.setValue(76);
                jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
               
    }
    
    private void resourceMaintenance(BigDecimal mdIdentificationId){
    
        try{
            
         
            MdMaintenanceInfoController mmic = new MdMaintenanceInfoController(session, hibernateUtilXml);
            BigDecimal id = mmic.getDataById(MdMaintenanceInfoModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();
            System.out.println(id);
            
            DELETE_MD_MAINTENANCE(id);
            jprocessbar.setValue(78);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
    }
    
    private void descriptiveKeywords(BigDecimal mdIdentificationId){
    
        
        MdKeywordController mkc = new MdKeywordController(session, hibernateUtilXml);
        List mdKeywordId = (List) mkc.getListOfId(mdIdentificationId);            
            
        for(int i=0;i<mdKeywordId.size();i++){  
            
            try{
                            
                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDKEYWORDID,new BigDecimal(mdKeywordId.get(i).toString())).getId();

                    if(i==0){                    

                            MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                            BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();

                                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                                    BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID, mdIdentifierId).getId();

                                        BigDecimal ciCitationIdentifier = ccc.getDataById(CiCitationModel.RSIDENTIFIERID, rsIdentifierId).getId();
                                            DELETE_CI_DATE(ciCitationIdentifier);
                                            jprocessbar.setValue(98);
                                            jprocessbar.setStringPainted(true);
                                            
                                        DELETE_CI_CITATION(ciCitationIdentifier);
                                        jprocessbar.setValue(100);
                                        jprocessbar.setStringPainted(true);

                                    DELETE_RS_IDENTIFIER(rsIdentifierId);
                                    jprocessbar.setValue(102);
                                    jprocessbar.setStringPainted(true);

                            DELETE_MD_IDENTIFIER(mdIdentifierId);
                            jprocessbar.setValue(104);
                            jprocessbar.setStringPainted(true);
                    }

                       DELETE_CI_DATE(ciCitationId);
                       jprocessbar.setValue(106);
                       jprocessbar.setStringPainted(true);
                    
                    DELETE_CI_CITATION(ciCitationId);  
                    jprocessbar.setValue(108);
                    jprocessbar.setStringPainted(true);
              
            }catch(Exception n){
                n.printStackTrace();
            }finally{
                   System.out.println(mdKeywordId.get(i));
                   DELETE_MD_KEYWORD_KEYWORD(new BigDecimal(mdKeywordId.get(i).toString()));
                   jprocessbar.setValue(110);
                   jprocessbar.setStringPainted(true);
                   
              DELETE_MD_KEYWORD(new BigDecimal(mdKeywordId.get(i).toString()));
              jprocessbar.setValue(112);
              jprocessbar.setStringPainted(true);
            
            }
        }                     
            
    }
    
    private void graphicOverview(BigDecimal mdIdentificationId){
      
    
        try{
               
            MdBrowseGraphicController mbgc = new MdBrowseGraphicController(session, hibernateUtilXml);
            BigDecimal id = mbgc.getDataById(mdIdentificationId).getId();
            System.out.println(id);

            DELETE_MD_BROWSE_GRAPHIC(id);
            jprocessbar.setValue(80);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
    
    }
    
    private void resourceFormat(BigDecimal mdIdentificationId){
 
    
        try{
            
            MdFormatController mfc = new MdFormatController(session, hibernateUtilXml);
            BigDecimal mdFormatId = mfc.getDataById(MdFormatModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();
                
                System.out.println(mdFormatId+" mdformatId");
                MdDistributorController mdc = new MdDistributorController(session, hibernateUtilXml);
                BigDecimal mdDistributorId = mdc.getDataById(MdDistributorModel.MD_FORMATID, mdFormatId).getId();
                    
                    System.out.println(mdDistributorId+" mdDistributorId");
                    CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                    BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.MD_DISTRIBUTORID, mdDistributorId).getId();
                            
                            System.out.println(ciResponsiblePartyId+" ciresponsiblePartyId");
                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                                DELETE_CI_ONLINERESOURCE(ciContactId, CiOnlineResourceModel.CI_CONTACTID);
                                jprocessbar.setValue(82);
                                jprocessbar.setStringPainted(true);
                                
                            DELETE_CI_CONTACT(ciContactId);
                            jprocessbar.setValue(84);
                            jprocessbar.setStringPainted(true);

                    DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
                    jprocessbar.setValue(86);
                    jprocessbar.setStringPainted(true);

                    MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
                    BigDecimal mdDigitalTransferOptId = mdtoc.getDataById(MdDigitalTransferOptionsModel.MD_DISTRIBUTORID, mdDistributorId).getId();
                       
                        System.out.println(mdDigitalTransferOptId+" mdDigitalTransferOpt");
                        DELETE_CI_ONLINERESOURCE(mdDigitalTransferOptId, CiOnlineResourceModel.MD_DIGITALTRANSFEROPTIONID);
                        jprocessbar.setValue(88);
                        jprocessbar.setStringPainted(true);
            
                        DELETE_MD_MEDIUM(mdDigitalTransferOptId);
                        jprocessbar.setValue(90);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_DIGITAL_TRANSFER_OPTIONS(mdDigitalTransferOptId);
                    jprocessbar.setValue(92);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_DISTRIBUTOR(mdDistributorId);
                jprocessbar.setValue(94);
                jprocessbar.setStringPainted(true);

            DELETE_MD_FORMAT(mdFormatId);
            jprocessbar.setValue(96);
            jprocessbar.setStringPainted(true);
         
        }catch(Exception n){
            n.printStackTrace();
        }

    }
    
    private void resourceConstraints(BigDecimal mdIdentificationId){
   
        
        try{
        
            MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
            BigDecimal mdConstraintsId = mcc.getDataById(MdConstraintsModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();

                DELETE_MD_METADATA_CONSTRAINTS_USE_LIMITATION(mdConstraintsId);
                jprocessbar.setValue(114);
                jprocessbar.setStringPainted(true);
                
                //baru
                DELETE_MD_METADATA_SECURITY_CONSTRAINTS(mdConstraintsId);
                jprocessbar.setValue(116);
                jprocessbar.setStringPainted(true);
                
                MdLegalConstraintsController mlcc = new MdLegalConstraintsController(session, hibernateUtilXml);
                BigDecimal mdLegalConstraintsId = mlcc.getDataById(mdConstraintsId).getMdConstraintsId();
                
                    DELETE_MD_METADATA_LEGAL_CONSTRAINTS_OTHER(mdConstraintsId);
                    jprocessbar.setValue(118);
                    jprocessbar.setStringPainted(true);
                    
                DELETE_MD_METADATA_LEGAL_CONSTRAINTS(mdLegalConstraintsId);
                jprocessbar.setValue(120);
                jprocessbar.setStringPainted(true);
              
            DELETE_MD_CONSTRAINTSINFO(mdConstraintsId);
            jprocessbar.setValue(122);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
    }
    
    private void spatialResolution(BigDecimal mdDataIdentificationId){
      
        try{
            
            MdResolutionController mrc = new MdResolutionController(session, hibernateUtilXml);
            BigDecimal mdResolutionId = mrc.getDataById(mdDataIdentificationId).getId();

                DELETE_MD_REPRESENTATIVE_FRACTION(MdRepresentativeFractionModel.MD_RESOLUTIONID,mdResolutionId);
                jprocessbar.setValue(124);
                jprocessbar.setStringPainted(true);
            
            DELETE_MD_RESOLUTION(mdResolutionId);
            jprocessbar.setValue(126);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                    
    }
    
    private void aggregationInfo(BigDecimal mdIdentificationId){
    
        try{
        
            MdAggregateInfoController maic = new MdAggregateInfoController(session, hibernateUtilXml);
            BigDecimal mdAggregationInfoId = maic.getDataById(mdIdentificationId).getId();

                CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDAGGREGATEINFOID, mdAggregationInfoId).getId();

                    DELETE_CI_DATE(ciCitationId);
                    jprocessbar.setValue(128);
                    jprocessbar.setStringPainted(true);
                    
                DELETE_CI_CITATION(ciCitationId);
                jprocessbar.setValue(130);
                jprocessbar.setStringPainted(true);

                MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.MDAGGREGATEINFOID, mdAggregationInfoId).getId();

                    BigDecimal ciCitationIdentifier = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();

                        DELETE_CI_DATE(ciCitationIdentifier);
                        jprocessbar.setValue(132);
                        jprocessbar.setStringPainted(true);
                        
                    DELETE_CI_CITATION(ciCitationIdentifier);
                    jprocessbar.setValue(134);
                    jprocessbar.setStringPainted(true);

                DELETE_MD_IDENTIFIER(mdIdentifierId);
                jprocessbar.setValue(136);
                jprocessbar.setStringPainted(true);

            DELETE_MD_AGGREGATION_INFO(mdAggregationInfoId);
            jprocessbar.setValue(138);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }
    
    private void extent(BigDecimal mdDataIdentificationId){
        
        try{

            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            BigDecimal exExtentId = eec.getDataById(ExExtentModel.MD_DATAIDENTIFICATIONID, mdDataIdentificationId).getId();

                ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
                BigDecimal exGeoExtentId  = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();

                    DELETE_EX_GEOGRAPHIC_BOUNDING_BOX(exGeoExtentId);
                    jprocessbar.setValue(140);
                    jprocessbar.setStringPainted(true);
            
                DELETE_EX_GEOGRAPHIC_EXTENT(exGeoExtentId);
                jprocessbar.setValue(142);
                jprocessbar.setStringPainted(true);

                DELETE_EX_TEMPORAL_EXTENT(exExtentId);
                jprocessbar.setValue(144);
                jprocessbar.setStringPainted(true);
                
                DELETE_EX_VERTICAL_EXTENT(exExtentId);
                jprocessbar.setValue(146);
                jprocessbar.setStringPainted(true);

            DELETE_EX_EXTENT(exExtentId);
            jprocessbar.setValue(148);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }
    
    private void deleteMetadataMaintenanceInformation(BigDecimal id){
        
        jTextAreaLogData.append("menghapus elemen metadata maintenance information" + "\n\n");
        System.out.println("Elemen => " +ParentElement.METADATAMAINTENANCE);
        
        try{
             
            MdMaintenanceInfoController mmi = new MdMaintenanceInfoController(session, hibernateUtilXml);
            BigDecimal mdMaintananceInfoId = mmi.getDataById(MdMaintenanceInfoModel.MD_METADATAID, id).getId();
        
            DELETE_MD_MAINTANANCEINFO(mdMaintananceInfoId);
            jprocessbar.setValue(726);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Maintanance Information\n\n");

    }
    
    private void deleteMetadataUploadInformation(String fileIdentifier) {
        
        jTextAreaLogData.append("menghapus elemen metadata upload information" + "\n\n");
        System.out.println("Elemen => MetadataUpload");
        
        try{
                   
            MdUploadFileController muf = new MdUploadFileController(session, hibernateUtilXml);
            BigDecimal mdUploadFileId =  muf.getDataById(fileIdentifier).getId();
            
            DELETE_MD_UPLOADINFO(mdUploadFileId);
            jprocessbar.setValue(776);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("Berhasil Menghapus Metadata Upload Information\n\n");

    }
 
    private void deleteDataQualityInformation(BigDecimal id){
    
        jTextAreaLogData.append("menghapus elemen metadata data quality" + "\n\n");
        System.out.println("Elemen => "+ParentElement.DATAQUALITYINFO);
        
        try{
             
            DqDataQualityController ddqc = new DqDataQualityController(session, hibernateUtilXml);
            BigDecimal dqDataQualityId = ddqc.getDataById(id).getId();
                
                System.out.println("Elemen => DqScope");
                displayLog(true, "subElemen DqScope\n");
                dqScope(dqDataQualityId);//166
                displayLog(true, "akhir subElemen DqScope\n");
                  
                System.out.println("Elemen => DqCompleteness");
                displayLog(true, "subElemen DqCompleteness\n");
                dqCompleteness(dqDataQualityId);//246
                displayLog(true, "akhir subElemen DqCompleteness\n");                
                
                System.out.println("Elemen => DqLogicalConsistency");
                displayLog(true, "subElemen DqLogicalConsistency\n");
                dqLogicalConsistency(dqDataQualityId);//372
                displayLog(true, "akhir subElemen DqLogicalConsistency\n"); 
                
                System.out.println("Elemen => DqPositionalAccuraccy");
                displayLog(true, "subElemen DqPositionalAccuraccy\n");
                dqPositionalAccuracy(dqDataQualityId);//452
                displayLog(true, "akhir subElemen DqPositionalAccuraccy\n");
                                
                System.out.println("Elemen => DqTemporalAccuraccy");
                displayLog(true, "subElemen DqTemporalAccuraccy\n");
                dqTemporalAccuracy(dqDataQualityId);//534
                displayLog(true, "akhir subElemen DqTemporalAccuraccy\n");
                                
                System.out.println("Elemen => DqThematicAccuracy");
                displayLog(true, "subElemen DqThematicAccuracy\n");
                dqThematicAccuracy(dqDataQualityId);//622
                displayLog(true, "akhir subElemen DqThematicAccuracy\n");
                                
                System.out.println("Elemen => LiLineage");
                displayLog(true, "subElemen LiLineage\n");
                liLineage(dqDataQualityId);//702
                displayLog(true, "akhir subElemen LiLineage\n");
               
            DELETE_DQ_DATAQUALITY(dqDataQualityId);
            jprocessbar.setValue(704);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
        
        jTextAreaLogData.append("\nFinish Deleting DataQuality Information\n\n");
            
    }
        
    private void DELETE_MD_METADATA_HIERARCHYLV(BigDecimal id) {
       
        try{
                    
            displayLog(true, "menghapus table MdHierarchylevel dengan mdMetadataId = "+id);
            MdMetadataHierarchyLvController mmhlc = new MdMetadataHierarchyLvController(session, hibernateUtilXml);
            String ret = mmhlc.deleteMdMetadataHierarchyLv(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table MdHierarchylevel " + ret+"\n");
            }else{
                displayLog(true, "Status table MdHierarchylevel " + ret+"\n");
            }
                      
        }catch(Exception n){
            displayLog(false, "Error MdHierarchylevel " + n.toString());
  
        }
    }

    private void DELETE_MD_METADATA_HIERARCHYLVNAME(BigDecimal id) {
        
        try{
            
            displayLog(true, "menghapus table MdHierarchylevelName dengan mdMetadataId = " + id);
            MdMetadataHierarchyLvNameController mmhlnc = new MdMetadataHierarchyLvNameController(session, hibernateUtilXml);
            String ret = mmhlnc.deleteMdMetadataHierarchylvName(id);
                
            if(ret.contains("Error")){
                displayLog(false, "Status table MdHierarchylevelName " +ret+"\n");
            }else{
                displayLog(true, "Status table MdHierarchylevelName " + ret+"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdHierarchylevelName " + n.toString());
        }
    }

    private void DELETE_MD_METADATA(BigDecimal id) {
        
        try{
        
            displayLog(true, "menghapus table MdMetadata dengan id = " + id);
            MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
            String ret = mmc.deletedMdMetadata(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table MdMetadata " + ret+"\n");
            }else{
                displayLog(true, "Status table MdMetadata " + ret+"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdMetadata " + n.toString());
        }
        
    }

    private void DELETE_CI_TELEPHONE_VOICE(BigDecimal ciTelephoneId) {
        
        try{
            displayLog(true, "menghapus table CiTelephoneVoice dengan ciTelephoneId = " + ciTelephoneId);
            CiTelephoneVoiceController ctvc = new CiTelephoneVoiceController(session, hibernateUtilXml);
            String ret = ctvc.deleteCiTelephoneVoice(ciTelephoneId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiTelephoneVoice " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiTelephoneVoice " + ret +"\n");
            }
             
         }catch(Exception n){
            displayLog(false, "Error Metadata CiTelephoneVoice " + n.toString());
        }
    }

    private void DELETE_CI_TELEPHONE_FACSIMILE(BigDecimal ciTelephoneId) {
        
        try{
            
            displayLog(true, "menghapus table CiTelephoneFacs dengan ciTelephoneId = " + ciTelephoneId);
            CiTelephoneFacsimileController ctfc = new CiTelephoneFacsimileController(session, hibernateUtilXml);
            String ret = ctfc.deleteCiTelephoneFacsimile(ciTelephoneId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiTelephoneFacs " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiTelephoneFacs " + ret +"\n");
            }
                        
         }catch(Exception n){
             displayLog(false, "Error Metadata CiTelephoneFacs " + n.toString());
        }
    }

    private void DELETE_CI_TELEPHONE(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table ciTelephone dengan id = " + id);
            CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
            String ret = ctc.deleteCiTelephone(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiTelephone " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiTelephone " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata CiTelephone " + n.toString());
        }
        
    }

    private void DELETE_CI_ADDRESS_DELIVERYPOINT(BigDecimal ciAddressId) {
        
        try{
            displayLog(true, "menghapus table CiAddressDeliveryPoint dengan ciAddressId = " + ciAddressId);
            CiAddressDeliveryPointController cadpc = new CiAddressDeliveryPointController(session, hibernateUtilXml);
            String ret=cadpc.deleteCiAddressDeliveryPoint(ciAddressId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiAddressDeliveryPoint " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiAddressDeliveryPoint " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata CiAddressDeliveryPoint " + n.toString());
        }
    }

    private void DELETE_CI_ADDRESS_EMAILADDRESS(BigDecimal ciAddressId) {
        
        try{
            displayLog(true, "menghapus table CiAddressEmailAddress dengan ciAddressId = " + ciAddressId);
            CiAddressEmailAddressController caeac = new CiAddressEmailAddressController(session, hibernateUtilXml);
            String ret = caeac.deletedCiAddressEmailAddress(ciAddressId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiAddressEmailAddress " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiAddressEmailAddress " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata CiAddressEmailAddress " + n.toString());
        }
        
    }

    private void DELETE_CI_ADDRESS(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table CiAddress dengan id = " + id);
            CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
            String ret = cac.deletedCiAddress(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiAddress " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiAddress " + ret +"\n");
            }

         }catch(Exception n){
            displayLog(false,"Error Metadata CiAddress " + n.toString());
        }
        
    }

    private void DELETE_CI_ONLINERESOURCE(BigDecimal id,String column) {
        
        try{
        
            CiOnlineResourceController corc = new CiOnlineResourceController(session, hibernateUtilXml);
            BigDecimal ciOnlineResourceId = corc.getDataById(column, id).getId();
            
            displayLog(true, "menghapus table CiOnlineResource dengan id = " + ciOnlineResourceId);
            String ret = corc.deletedCiOnlineResource(ciOnlineResourceId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiOnlineResource " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiOnlineResource " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata CiOnlineResource " + n.toString());
        }
        
    }

    private void DELETE_CI_CONTACT(BigDecimal ciContactId) {
        
        try{
            displayLog(true, "menghapus table CiContact dengan id = " + ciContactId);
            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
            String ret = ccc.deleteCiContact(ciContactId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiContact " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiContact " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata CiContact " + n.toString());
        }
       
    }

    private void DELETE_CI_RESPONSIBLEPARTY(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table CiResponsibleParty dengan id = " + id);
            CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
            String ret = crpc.deleteCiResponsibleParty(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiResponsibleParty " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiResponsibleParty " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata CiResponsibleParty " + n.toString());
        }
    }

    private void DELETE_MD_GEOMETRICOBJECTS(List listId) {
        
        try{
            MdGeometricObjectsController mgoc = new MdGeometricObjectsController(session, hibernateUtilXml);
                    
            for(int i=0;i<listId.size();i++){

                displayLog(true, "menghapus table MdGeometricObjects dengan id = " + listId.get(i));
                                
                String ret = mgoc.deletedMdGeometricObjects(new BigDecimal(listId.get(i).toString()));
                
                if(ret.contains("Error")){
                    displayLog(false, "Status table Metadata MdGeometricObjects " + ret +"\n");
                }else{
                    displayLog(true, "Status table Metadata MdGeometricObjects " + ret +"\n");
                }
               
            }
         }catch(Exception n){
            displayLog(false, "Error Metadata MdGeometricObjects " + n.toString());
        }
    }

    private void DELETE_MD_VECTORSPATIALREPRESENTATION(BigDecimal id) {
       
        try{
            displayLog(true, "menghapus table MdVectorSpatialRepresentation dengan id = " + id);
            MdVectorSpatialRepresentationController mvsrc = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);
            String ret = mvsrc.deletedMdVectorSpatialRepresentation(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdVectorSpatialRepresentation " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdVectorSpatialRepresentation " + ret +"\n");
            }
        
        }catch(Exception n){
            displayLog(false, "Error Metadata MdVectorSpatialRepresentation " + n.toString());
        }
    }

    private void DELETE_MD_SPATIALREPRESENTATION(BigDecimal id) {
       
        try{
            displayLog(true, "menghapus table MdSpatialRepresentation dengan id = " + id);
            MdSpatialRepresentationController msrc = new MdSpatialRepresentationController(session, hibernateUtilXml);
            String ret = msrc.deletedMdSpatialRepresentation(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdSpatialRepresentation " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdSpatialRepresentation " + ret +"\n");
            }
           
        }catch(Exception n){
            displayLog(false, "Error Metadata MdSpatialRepresentation " + n.toString());
        }
    }

    private void DELETE_CI_DATE(BigDecimal ciCitationId) {
       
        try{
            CiDateController cdc = new CiDateController(session, hibernateUtilXml);
            BigDecimal id = cdc.getDataById(ciCitationId).getId();
            
            displayLog(true, "menghapus table CiDate dengan id = " + id);
            String ret = cdc.deletedCiDate(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiDate " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiDate " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata CiDate " + n.toString());
        }
        
    }

    private void DELETE_CI_CITATION(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table CiCitation dengan id = " + id);
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            String ret = ccc.deletedCiCitation(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiCitation " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiCitation " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata CiCitation " + n.toString());
        }
    }

    private void DELETE_RS_IDENTIFIER(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table RsIdentifier dengan id = " + id);
            RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
            String ret = ric.deletedRsIdentifier(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata RsIdentifier " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata RsIdentifier " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata RsIdentifier " + n.toString());
        }
       
    }

    private void DELETE_MD_REFERENCESYSTEM(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdReferenceSystem dengan id = " + id);
            MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
            String ret = mrsc.deletedMdReferenceSystem(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdReferenceSystem " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdReferenceSystem " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdReferenceSystem " + n.toString());
        }
    }

    private void DELETE_CI_CITATION_ALTERNATETITLE(BigDecimal ciCitationId) {
       
        try{
            displayLog(true, "menghapus table CiCitationAlternateTitle dengan ciCitationId = " + ciCitationId);
            CiCitationAlternateTitleController ccatc = new CiCitationAlternateTitleController(session, hibernateUtilXml);
            String ret = ccatc.deletedCiCitationAlternateTitle(ciCitationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiCitationAlternateTitle " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiCitationAlternateTitle " + ret +"\n");
            }
                      
         }catch(Exception n){
            displayLog(false, "Error Metadata CiCitationAlternateTitle " + n.toString());
        }
    }

    private void DELETE_MD_PORTRAYALCATALOGUEREF(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdPortrayalCatalogueRef dengan id = " + id);
            MdPortrayalCatalogueRefController mpcrc = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
            String ret = mpcrc.deletedMdPortrayalCatalogueRef(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdPortrayalCatalogueRef " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdPortrayalCatalogueRef " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdPortrayalCatalogueRef " + n.toString());
        }
       
    }

    private void DELETE_MD_EXTENDED_ELEMENTINFO_PARENT(BigDecimal mdExtendedElementId) {
        
        try{
            displayLog(true, "menghapus table MdExtendedElementInfoParent dengan mdExtendedElementId = " + mdExtendedElementId);
            MdExtendedElementInfoParentController meeipc = new MdExtendedElementInfoParentController(session, hibernateUtilXml);
            String ret = meeipc.deleteMdExtendedElementInfoParent(mdExtendedElementId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdExtendedElementInfoParent " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdExtendedElementInfoParent " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdExtendedElementInfoParent " + n.toString());
        }
    }

    private void DELETE_MD_EXTENDED_ELEMENT(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdExtendedElementInfo dengan id = " +id);
            MdExtendedElementInfoController meeic = new MdExtendedElementInfoController(session, hibernateUtilXml);
            String ret = meeic.deleteMdExtendedElementInfo(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdExtendedElementInfo " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdExtendedElementInfo " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdExtendedElementInfo " + n.toString());
        }
    }

    private void DELETE_MD_METADATA_EXTENSIONINFO(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdMetadataExtensionInfo dengan id = " +id);
            MdMetadataExtensionInfoController mmeic = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
            String ret = mmeic.deleteMdMetadataExtensionInfo(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdMetadataExtensionInfo " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdMetadataExtensionInfo " + ret +"\n");
            }
             
        }catch(Exception n){
            displayLog(false, "Error Metadata MdMetadataExtensionInfo " + n.toString());
        }
    }

    private void DELETE_MD_COVERAGE_DESCRIPTION(BigDecimal mdContentInfoId) {
        
        try{
           
            MdCoverageDescriptionController mcdc = new MdCoverageDescriptionController(session, hibernateUtilXml);
            BigDecimal id = mcdc.getDataById(mdContentInfoId).getId();
            
            displayLog(true, "menghapus table MdCoverageDescription dengan id = " +id);
            String ret = mcdc.deleteMdCoverageDescription(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdCoverageDescription " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdCoverageDescription " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdCoverageDescription " + n.toString());
        }
        
    }

    private void DELETE_MD_CONTENT_INFO(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdContentInfo dengan id = " +id);
            MdContentInfoController mci = new MdContentInfoController(session, hibernateUtilXml);
            String ret = mci.deletedMdContentInfo(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdContentInfo " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdContentInfo " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdContentInfo " + n.toString());
        }
    }

    private void DELETE_MD_IDENTIFICATION_STATUS(BigDecimal mdIdentificationId) {
      
        try{
            
            displayLog(true, "menghapus table MdIdentificationStatus dengan mdIdentificationId = " +mdIdentificationId);
            MdIdentificationStatusController misc = new MdIdentificationStatusController(session, hibernateUtilXml);
            String ret = misc.deletedMdIdentificationStatus(mdIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdIdentificationStatus " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdIdentificationStatus " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdIdentificationStatus " + n.toString());
        }
        
    }
    
    private void DELETE_MD_IDENTIFICATION_CREDIT(BigDecimal mdIdentificationId) {
      
        try{
            
            displayLog(true, "menghapus table MdIdentificationCredit dengan mdIdentificationId = " +mdIdentificationId);
            MdIdentificationCreditController micc = new MdIdentificationCreditController(session, hibernateUtilXml);
            String ret = micc.deletedMdIdentificationCredit(mdIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdIdentificationCredit " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdIdentificationCredit " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdIdentificationCredit " + n.toString());
        }
        
    }

    private void DELETE_SV_SERVICEIDENTIFICATION(BigDecimal id) {
       
        try{
            displayLog(true, "menghapus table SvServiceIdentification dengan id = " +id);
            SvServiceIdentificationController ssic = new SvServiceIdentificationController(session, hibernateUtilXml);
            String ret = ssic.deletedSvServiceIdentification(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata SvServiceIdentification " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata SvServiceIdentification " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata SvServiceIdentification " + n.toString());
        }
        
    }

    private void DELETE_MD_DATAIDENTIFICATION_SPATREP(BigDecimal mdDataIdentificationId) {
       
        try{
            displayLog(true, "menghapus table MdDataIdentificationSpatrep dengan mdDataIdentificationId = " +mdDataIdentificationId);
            MdDataIdentificationSpatrepController mdisc = new MdDataIdentificationSpatrepController(session, hibernateUtilXml);
            String ret = mdisc.deletedMdDataIdentificationSpatrep(mdDataIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDataIdentificationSpatrep " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDataIdentificationSpatrep " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdDataIdentificationSpatrep " + n.toString());
        }
    }

    private void DELETE_MD_DATAIDENTIFICATION_LANG(BigDecimal mdDataIdentificationId) {
        
        try{
            displayLog(true, "menghapus table MdDataIdentificationLang dengan mdDataIdentificationId = " +mdDataIdentificationId);
            MdDataIdentificationLangController mdisc = new MdDataIdentificationLangController(session, hibernateUtilXml);
            String ret = mdisc.deletedMdDataIdentificationLang(mdDataIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDataIdentificationLang " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDataIdentificationLang " + ret +"\n");
            }
         }catch(Exception n){
           displayLog(false, "Error Metadata MdDataIdentificationLang " + n.toString());
        }
    }

    private void DELETE_MD_DATAIDENTIFICATION_CHARSET(BigDecimal mdDataIdentificationId) {
        
        try{
            
            displayLog(true, "menghapus table MdDataIdentificationCharset dengan mdDataIdentificationId = " +mdDataIdentificationId);
            MdDataIdentificationCharsetController mdisc = new MdDataIdentificationCharsetController(session, hibernateUtilXml);
            String ret = mdisc.deletedMdDataIdentificationCharset(mdDataIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDataIdentificationCharset " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDataIdentificationCharset " + ret +"\n");
            }
            
        }catch(Exception n){
             displayLog(false, "Error Metadata MdDataIdentificationCharset " + n.toString() );
        }
    }

    private void DELETE_MD_DATAIDENTIFICATION_TOPCAT(BigDecimal mdDataIdentificationId) {
        
        try{
            displayLog(true, "menghapus table MdDataIdentificationTopcat dengan mdDataIdentificationId = " +mdDataIdentificationId);
            MdDataIdentificationTopcatController mdisc = new MdDataIdentificationTopcatController(session, hibernateUtilXml);
            String ret = mdisc.deletedMdDataIdentificationTopcat(mdDataIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDataIdentificationTopcat " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDataIdentificationTopcat " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdDataIdentificationTopcat " + n.toString());
           
        }
    }

    private void DELETE_MD_DATAIDENTIFICATION(BigDecimal mdDataIdentificationId) {
        
        try{
            displayLog(true, "menghapus table MdDataIdentification dengan id = " +mdDataIdentificationId);
            MdDataIdentificationController mdic = new MdDataIdentificationController(session, hibernateUtilXml);
            String ret = mdic.deletedMdDataIdentification(mdDataIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDataIdentification " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDataIdentification " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdDataIdentification " + n.toString());
        }
    }

    private void DELETE_MD_IDENTIFICATION(BigDecimal mdIdentificationId) {
        
        try{
            displayLog(true, "menghapus table MdIdentification dengan id = " +mdIdentificationId);
            MdIdentificationController mic = new MdIdentificationController(session, hibernateUtilXml);
            String ret = mic.deleteMdIdentification(mdIdentificationId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdIdentification " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdIdentification " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdIdentification " + n.toString());
        }
    }

    private void DELETE_MD_IDENTIFIER(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdIdentifier dengan id = " +id);
            MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
            String ret = mic.deletedMdIdentifier(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdIdentifier " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdIdentifier " + ret +"\n");
            }
        }catch(Exception n){
            displayLog(false, "Error Metadata MdIdentifier " + n.toString());
        }
        
    }

    private void DELETE_MD_MAINTENANCE(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdMaintenance dengan id = " +id);
            MdMaintenanceInfoController mmic = new MdMaintenanceInfoController(session, hibernateUtilXml);
            String ret = mmic.deletedMdMaintenanceInfo(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdMaintenance " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdMaintenance " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdMaintenance " + n.toString());
        }
    }

    private void DELETE_MD_BROWSE_GRAPHIC(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdBrowseGraphic dengan id = " +id);
            MdBrowseGraphicController mbgc = new MdBrowseGraphicController(session, hibernateUtilXml);
            String ret = mbgc.deletedMdBrowseGraphic(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdBrowseGraphic " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdBrowseGraphic " + ret +"\n");
            }
         }catch(Exception n){
            displayLog(false, "Error Metadata MdBrowseGraphic " + n.toString());
     
        }
    }

    private void DELETE_MD_MEDIUM(BigDecimal mdDigitalTransferOptId) {
        
        try{
            
            MdMediumController mmc = new MdMediumController(session, hibernateUtilXml);
            BigDecimal id = mmc.getDataById(mdDigitalTransferOptId).getId();
            
            displayLog(true, "menghapus table MdMedium dengan id = " +id);
            String ret = mmc.deletedMdMedium(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata  MdMedium " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata  MdMedium " + ret +"\n");
            }
                       
         }catch(Exception n){
           displayLog(false, "Error Metadata MdMedium " + n.toString());
        }
    }

    private void DELETE_MD_DIGITAL_TRANSFER_OPTIONS(BigDecimal mdDigitalTransferOptId) {
        
        try{
            displayLog(true, "menghapus table MdDigitalTransferOptions dengan id = " +mdDigitalTransferOptId);
            MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
            String ret = mdtoc.deletedMdDigitalTransferOptions(mdDigitalTransferOptId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDigitalTransferOptions " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDigitalTransferOptions " + ret +"\n");
            }
            
         }catch(Exception n){
           displayLog(false, "Error Metadata MdDigitalTransferOptions " + n.toString());
          
        }
    }

    private void DELETE_MD_DISTRIBUTOR(BigDecimal mdDistributorId) {
        
        try{
            displayLog(true, "menghapus table MdDistributor dengan id = " +mdDistributorId);
            MdDistributorController mdc = new MdDistributorController(session, hibernateUtilXml);
            String ret = mdc.deletedMdDistributor(mdDistributorId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDistributor " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDistributor " + ret +"\n");
            }
        }catch(Exception n){
            
            displayLog(false, "Error Metadata MdDistibutor " + n.toString());            
        }
    }

    private void DELETE_MD_FORMAT(BigDecimal mdFormatId) {
        
        try{
            displayLog(true, "menghapus table MdFormat dengan id = " +mdFormatId);
            MdFormatController mfc = new MdFormatController(session, hibernateUtilXml);
            String ret = mfc.deletedMdFormat(mdFormatId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdFormat " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdFormat " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdFormat " + n.toString());

        }
    }
    
    private void DELETE_MD_METADATA_CONSTRAINTS_USE_LIMITATION(BigDecimal mdConstraintsId) {
        
        try{
            displayLog(true, "menghapus table MdConstraintsUseLimitation dengan mdConstraintsId = " +mdConstraintsId);
            MdConstraintsUseLimitationController mcc = new MdConstraintsUseLimitationController(session, hibernateUtilXml);
            String ret = mcc.deletedMdConstraintsUseLimitation(mdConstraintsId); 
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdConstraintsUseLimitation " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdConstraintsUseLimitation " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdConstraintsUseLimitation " + n.toString());
        }
    }

    private void DELETE_MD_CONSTRAINTSINFO(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdConstraints dengan id = " +id);
            MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
            String ret = mcc.deletedMdConstraints(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdConstraints " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdConstraints " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdConstraints " + n.toString());
        }
        
    }

    private void DELETE_MD_REPRESENTATIVE_FRACTION(String column,BigDecimal foreignId) {
        
        try{
            
            MdRepresentativeFractionController mrfc = new MdRepresentativeFractionController(session, hibernateUtilXml);
            BigDecimal id = mrfc.getDataById(column, foreignId).getId();
            
            displayLog(true, "menghapus table MdRepresentativeFraction dengan id = " +id);
            String ret = mrfc.deletedMdRepresentativeFraction(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdRepresentativeFraction " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdRepresentativeFraction " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdRepresentativeFraction " + n.toString());
        }
    }

    private void DELETE_MD_RESOLUTION(BigDecimal mdResolutionId) {
       
        try{
            displayLog(true, "menghapus table MdResolution dengan id = " +mdResolutionId);
            MdResolutionController mrc = new MdResolutionController(session, hibernateUtilXml);
            String ret = mrc.deletedMdResolution(mdResolutionId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdResolution " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdResolution " + ret +"\n");
            }
            
         }catch(Exception n){
            displayLog(false, "Error Metadata MdResolution " + n.toString());
        }
        
    }

    private void DELETE_MD_AGGREGATION_INFO(BigDecimal mdAggregationInfoId) {
        
        try{
            displayLog(true, "menghapus table MdAggregationInfo dengan id = " +mdAggregationInfoId);
            MdAggregateInfoController maic = new MdAggregateInfoController(session, hibernateUtilXml);
            String ret = maic.deletedMdAggregateInfo(mdAggregationInfoId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdAggregationInfo " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdAggregationInfo " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdAggregationInfo " + n.toString());
        }
        
    }

    private void DELETE_EX_GEOGRAPHIC_BOUNDING_BOX(BigDecimal exGeoExtentId) {
        
        try{
            ExGeographicBoundingBoxController egbbc = new ExGeographicBoundingBoxController(session, hibernateUtilXml);
            BigDecimal id = egbbc.getDataByIdExExGeographicExtent(exGeoExtentId).getId();
            
            displayLog(true, "menghapus table ExGeographicBoundingBox dengan id = " +id);
            String ret = egbbc.deletedExGeographicBoundingBox(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExGeographicBoundingBox " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExGeographicBoundingBox " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata ExGeographicBoundingBox " + n.toString());
        }
        
    }

    private void DELETE_EX_GEOGRAPHIC_EXTENT(BigDecimal exGeoExtentId) {
        
        try{
            displayLog(true, "menghapus table ExGeographicExtent dengan id = " +exGeoExtentId);
            ExGeographicExtentController egec = new ExGeographicExtentController(session, hibernateUtilXml);
            String ret = egec.deletedExGeographicExtent(exGeoExtentId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExGeographicExtent " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExGeographicExtent " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata ExGeographicExtent " + n.toString());
        }
        
        
    }

    private void DELETE_EX_TEMPORAL_EXTENT(BigDecimal exExtentId) {
        
        try{
            ExTemporalExtentController etec = new ExTemporalExtentController(session, hibernateUtilXml);
            BigDecimal id = etec.getDataById(exExtentId).getId();
            
            displayLog(true, "menghapus table ExTemporalExtent dengan id = " +id);
            String ret = etec.deletedExTemporalExtent(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExTemporalExtent " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExTemporalExtent " + ret +"\n");
            }
        
        }catch(Exception n){
            displayLog(false, "Error Metadata ExTemporalExtent " + n.toString());
        }
        
    }

    private void DELETE_EX_VERTICAL_EXTENT(BigDecimal exExtentId) {
        
        try{
            ExVerticalExtentController evec = new ExVerticalExtentController(session, hibernateUtilXml);
            BigDecimal id = evec.getDataById(exExtentId).getId();
            
            displayLog(true, "menghapus table ExVerticalExtent dengan id = " +id);
            String ret = evec.deletedExVerticalExtent(id);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExVerticalExtent " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExVerticalExtent " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata ExVerticalExtent " + n.toString());
        }
        
    }

    private void DELETE_EX_EXTENT(BigDecimal exExtentId) {
        
        try{
            displayLog(true, "menghapus table ExExtent dengan id = " +exExtentId);
            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            String ret = eec.deletedExExtent(exExtentId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExExtent " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExExtent " + ret +"\n");
            }
        }catch(Exception n){
             displayLog(false, "Error Metadata ExExtent " + n.toString());
        }
        
    }

    private void DELETE_MD_KEYWORD_KEYWORD(BigDecimal mdKeywordId) {
        
        try{
            displayLog(true, "menghapus table MdKeywordKeyword dengan mdKeywordId = " +mdKeywordId);
            MdKeywordKeywordController mkkc = new MdKeywordKeywordController(session, hibernateUtilXml);
            String ret = mkkc.deletedMdKeywordKeyword(mdKeywordId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdKeywordKeyword " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdKeywordKeyword " + ret +"\n");
            }
                        
        }catch(Exception n){
            displayLog(false, "Error Metadata MdKeywordKeyword " + n.toString());
        }
    }

    private void DELETE_MD_KEYWORD(BigDecimal mdKeywordId) {
        
        try{
            displayLog(true, "menghapus table MdKeyword dengan id = " +mdKeywordId);
            MdKeywordController mkc = new MdKeywordController(session, hibernateUtilXml);
            String ret = mkc.deletedMdKeyword(mdKeywordId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdKeyword " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdKeyword " + ret +"\n");
            }
           
        }catch(Exception n){
            displayLog(false, "Error Metadata MdKeyword " + n.toString());
        }
    }

    private void dqScope(BigDecimal dqDataQualityId) {
     
        try{
                System.out.println("dqScope");
                DqScopeController dsc = new DqScopeController(session, hibernateUtilXml);
                BigDecimal dqScopeId = dsc.getDataById(dqDataQualityId).getId();

                   ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
                   BigDecimal exExtentId = eec.getDataById(ExExtentModel.DQ_SCOPEID, dqScopeId).getId();

                          ExGeographicExtentController egec = new ExGeographicExtentController(session, hibernateUtilXml);
                          BigDecimal exGeographicExtent = egec.getDataById(ExGeographicExtentModel.EX_EXTENTID, exExtentId).getId();

                              DELETE_EX_GEOGRAPHIC_BOUNDING_BOX(exGeographicExtent);
                              jprocessbar.setValue(160);
                              jprocessbar.setStringPainted(true);
                              
                          DELETE_EX_GEOGRAPHIC_EXTENT(exGeographicExtent);
                          jprocessbar.setValue(162);
                          jprocessbar.setStringPainted(true);

                    DELETE_EX_EXTENT(exExtentId);
                    jprocessbar.setValue(164);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_SCOPE(dqScopeId);
                jprocessbar.setValue(166);
                jprocessbar.setStringPainted(true);
                
        }catch(Exception n){
            n.printStackTrace();
        }
                  
        
    }
    
    private void dqCompleteness(BigDecimal dqDataQualityId) {
         
        try{
            
         
            DqCompletenessController dcc = new DqCompletenessController(session, hibernateUtilXml);
            BigDecimal dqCompletenessId = dcc.getDataById(dqDataQualityId).getId();
            
                displayLog(true, "subElemen DqCompcomm\n");
                dqCompcomm(dqCompletenessId);//214
                displayLog(true, "akhir subElemen DqCompcomm\n");
                
                displayLog(true, "subElemen DqCompom\n");
                dqCompom(dqCompletenessId);//244
                displayLog(true, "akhir subElemen DqCompom\n");

            DELETE_DQ_COMPLETENESS(dqCompletenessId);
            jprocessbar.setValue(246);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                   
    }

    private void dqLogicalConsistency(BigDecimal dqDataQualityId) {
      
        try{
            
        
            DqLogicalConsistencyController dlcc = new DqLogicalConsistencyController(session, hibernateUtilXml);
            BigDecimal dqLogicalConsitencyId = dlcc.getDataById(dqDataQualityId).getId();
               
                displayLog(true, "subElemen DqConcconsis\n");
                dqConcconsis(dqLogicalConsitencyId);//268
                displayLog(true, "akhir subElemen DqConcconsis\n");
                
                displayLog(true, "subElemen DqDomconsis\n");
                dqDomconsis(dqLogicalConsitencyId);//300
                displayLog(true, "akhir subElemen DqDomconsis\n");
                
                displayLog(true, "subElemen DqFormconsis\n");
                dqFormconsis(dqLogicalConsitencyId);//330
                displayLog(true, "akhir subElemen DqFormconsis\n");
                
                displayLog(true, "subElemen DqTopconsis\n");
                dqTopconsis(dqLogicalConsitencyId);//370
                displayLog(true, "akhir subElemen DqTopconsis\n");
                
            DELETE_DQ_LOGICAL_CONSISTENCY(dqLogicalConsitencyId);
            jprocessbar.setValue(372);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
    }
    
    private void dqPositionalAccuracy(BigDecimal dqDataQualityId) {
       
        try{
            
            DqPositionalAccuracyController dpac = new DqPositionalAccuracyController(session, hibernateUtilXml);
            BigDecimal dqPositionalAccuracyId = dpac.getDataById(dqDataQualityId).getId();
                
                displayLog(true, "subElemen DqAbsextPosAcc\n");
                dqAbsextPosAcc(dqPositionalAccuracyId);//402
                displayLog(true, "akhir subElemen DqAbsextPosAcc\n");
                
                displayLog(true, "subElemen DqGridDataPosAcc\n");
                dqGridDataPosAcc(dqPositionalAccuracyId);//430
                displayLog(true, "akhir subElemen DqGridDataPosAcc\n");
                
                displayLog(true, "subElemen DqRellntPosAcc\n");
                dqRellntPosAcc(dqPositionalAccuracyId);//450
                displayLog(true, "akhir subElemen DqRellntPosAcc\n");
                
            DELETE_DQ_POSITIONAL_ACCURACY(dqPositionalAccuracyId);
            jprocessbar.setValue(452);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
            
    }
    
    private void dqTemporalAccuracy(BigDecimal dqDataQualityId) {
     
        try{
            
        
            DqTemporalAccuracyController dtac = new DqTemporalAccuracyController(session, hibernateUtilXml);
            BigDecimal dqTemporalAccId = dtac.getDataById(dqDataQualityId).getId();
                
                displayLog(true, "subElemen DqAccTimeMeAs\n");
                dqAccTimeMeAs(dqTemporalAccId);//482
                displayLog(true, "akhir subElemen DqAccTimeMeAs\n");
                
                displayLog(true, "subElemen DqTempConsis\n");
                dqTempConsis(dqTemporalAccId);//502
                displayLog(true, "akhir subElemen DqTempConsis\n");
                
                displayLog(true, "subElemen DqTempValid\n");
                dqTempValid(dqTemporalAccId);//532
                displayLog(true, "akhir subElemen DqTempValid\n");
                
            DELETE_DQ_TEMPORALACC(dqTemporalAccId);
            jprocessbar.setValue(534);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }
    
    private void dqThematicAccuracy(BigDecimal dqDataQualityId) {
        
        try{
        
            DqThematicAccuracyController dtac = new DqThematicAccuracyController(session, hibernateUtilXml);
            BigDecimal dqThematicAccuracyId = dtac.getDataById(dqDataQualityId).getId();
                
                displayLog(true, "subElemen dqThemClassCor\n");
                dqThemClassCor(dqThematicAccuracyId);//570
                displayLog(true, "subElemen dqThemClassCor\n");
                
                displayLog(true, "subElemen dqNonQuanAttacc\n");
                dqNonQuanAttacc(dqThematicAccuracyId);//590
                displayLog(true, "subElemen dqNonQuanAttacc\n");
                
                displayLog(true, "subElemen dqQuanAttacc\n");
                dqQuanAttacc(dqThematicAccuracyId);//620
                displayLog(true, "subElemen dqQuanAttacc\n");
                
            DELETE_DQ_THEMATICACCURACY(dqThematicAccuracyId);
            jprocessbar.setValue(622);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
            
    }

    private void dqCompcomm(BigDecimal dqCompletenessId) {
            
        System.out.println("dqCompcomm");

        try{
            
            
            DqCompCommController dccc = new DqCompCommController(session, hibernateUtilXml);
            BigDecimal dqCompCommId = dccc.getDataById(dqCompletenessId).getId();
            System.out.println(dqCompCommId+" => dqCompCommId");

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqCompCommId, DqElementModel.DQ_COMPCOMMID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(168);
                    jprocessbar.setStringPainted(true);
                
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(170);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                            DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                            BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                               CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                                BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();

                                    DELETE_CI_DATE(citationConformance);
                                    jprocessbar.setValue(172);
                                    jprocessbar.setStringPainted(true);
                
                                DELETE_CI_CITATION(citationConformance);
                                jprocessbar.setValue(174);
                                jprocessbar.setStringPainted(true);

                            DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                            jprocessbar.setValue(176);
                            jprocessbar.setStringPainted(true);

                            DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                            BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                                DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                                jprocessbar.setValue(178);
                                jprocessbar.setStringPainted(true);
                
                            DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                            jprocessbar.setValue(180);
                            jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(182);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();

                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(184);
                            jprocessbar.setStringPainted(true);
                
                            DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                            jprocessbar.setValue(186);
                            jprocessbar.setStringPainted(true);

                            BigDecimal mdIdentifierSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
                                BigDecimal citationSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubId).getId();

                                    DELETE_CI_DATE(citationSubId);
                                    jprocessbar.setValue(188);
                                    jprocessbar.setStringPainted(true);
                
                                DELETE_CI_CITATION(citationSubId);
                                jprocessbar.setValue(200);
                                jprocessbar.setStringPainted(true);
                
                            DELETE_MD_IDENTIFIER(mdIdentifierSubId);
                            jprocessbar.setValue(202);
                            jprocessbar.setStringPainted(true);

                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(204);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(206);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();

                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(208);
                        jprocessbar.setStringPainted(true);
                
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(210);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(212);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_COMPCOMM(dqCompCommId);
            jprocessbar.setValue(214);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                        
    }

    private void dqCompom(BigDecimal dqCompletenessId) {
       
        System.out.println("dqCompom");
        try{
       
            DqComPomController dcpc = new DqComPomController(session, hibernateUtilXml);
            BigDecimal dqComPomId = dcpc.getDataById(dqCompletenessId).getId();
            System.out.println(dqComPomId+" => dqCompPomId");
            
                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqComPomId, DqElementModel.DQ_COMPOMID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(216);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(218);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                            DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                            BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                                CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                                BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();

                                    DELETE_CI_DATE(citationConformance);
                                    jprocessbar.setValue(220);
                                    jprocessbar.setStringPainted(true);
            
                                DELETE_CI_CITATION(citationConformance);
                                jprocessbar.setValue(222);
                                jprocessbar.setStringPainted(true);

                            DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                            jprocessbar.setValue(224);
                            jprocessbar.setStringPainted(true);

                            DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                            BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                                DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                                jprocessbar.setValue(226);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                            jprocessbar.setValue(228);
                            jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(230);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();

                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(232);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(234);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(236);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();

                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(238);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(240);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(242);
                jprocessbar.setStringPainted(true);

            DELETE_COMP_OM(dqComPomId);
            jprocessbar.setValue(244);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
            
        
    }

    private void dqConcconsis(BigDecimal dqLogicalConsistencyId) {
            
        System.out.println("dqConcconsis");
        
        try{
            
            DqConcconsisController dcc = new DqConcconsisController(session, hibernateUtilXml);
            BigDecimal dqConConsisId = dcc.getDataById(dqLogicalConsistencyId).getId();
            System.out.println(dqConConsisId+" => dqConConsisId");
            
                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqConConsisId, DqElementModel.DQ_CONCCONSISID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(248);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(250);
                    jprocessbar.setStringPainted(true);
                    
                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                            System.out.println(citationConformance);
                            
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(252);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(254);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(256);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(258);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(260);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(262);
                    jprocessbar.setStringPainted(true);
                    
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();
                    
                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(264);
                    jprocessbar.setStringPainted(true);
                    
                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(266);
                jprocessbar.setStringPainted(true);
             
            DELETE_DQ_CONCCONSIS(dqConConsisId);
            jprocessbar.setValue(268);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                
    }

    private void dqDomconsis(BigDecimal dqLogicalConsistencyId) {
       
        System.out.println("dqdomconsis");
        try{
        
            DqDomconsisController ddc = new DqDomconsisController(session, hibernateUtilXml);
            BigDecimal dqDomconsisId = ddc.getDataById(dqLogicalConsistencyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqDomconsisId, DqElementModel.DQ_DOMCONSISID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(270);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(272);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(274);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(276);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(278);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(280);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(282);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(284);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(286);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(288);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(290);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(292);
                        jprocessbar.setStringPainted(true);
            
                        DELETE_CI_SERIES(citationEvaluation);
                        jprocessbar.setValue(294);
                        jprocessbar.setStringPainted(true);
            
                   DELETE_CI_CITATION(citationEvaluation);
                   jprocessbar.setValue(296);
                   jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(298);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_DOMCONSIS(dqDomconsisId);
            jprocessbar.setValue(300);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                            
    }

    private void dqFormconsis(BigDecimal dqLogicalConsistencyId) {
       
        System.out.println("dqformconsis");
        try{
        
            DqFormConsisController dfcc = new DqFormConsisController(session, hibernateUtilXml);
            BigDecimal dqFormConsisId = dfcc.getDataById(dqLogicalConsistencyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqFormConsisId, DqElementModel.DQ_FORMCONSISID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(302);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(304);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(306);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(308);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(310);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(312);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(314);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(316);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(318);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(320);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(322);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(324);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(326);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(328);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_FORMCONSIS(dqFormConsisId);
            jprocessbar.setValue(330);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }

    }

    private void dqTopconsis(BigDecimal dqLogicalConsistencyId) {
        
        System.out.println("dqtopconsis");
        
        try{
        
            DqTopConsisController dtcc = new DqTopConsisController(session, hibernateUtilXml);
            BigDecimal dqTopConsisId = dtcc.getDataById(dqLogicalConsistencyId).getId();

            System.out.println(dqTopConsisId+" dqTopconsisid");
                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqTopConsisId, DqElementModel.DQ_TOPCONSISID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(332);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(334);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                          CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(336);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(338);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(340);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(342);
                        jprocessbar.setStringPainted(true);

                   DELETE_DQ_RESULT(dqResultId);
                   jprocessbar.setValue(344);
                   jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(346);
                            jprocessbar.setStringPainted(true);

                            BigDecimal mdIdentifierSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
                                BigDecimal citationSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubId).getId();
                                    System.out.println(citationSubId+" cicitation");
                                    DELETE_CI_DATE(citationSubId);
                                    jprocessbar.setValue(348);
                                    jprocessbar.setStringPainted(true);

                                    BigDecimal mdIdentifierSubSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, citationSubId).getId();
                                        BigDecimal citationSubSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubSubId).getId();
                                            System.out.println(citationSubId);
                                            DELETE_CI_DATE(citationSubSubId);
                                            jprocessbar.setValue(350);
                                            jprocessbar.setStringPainted(true);
            
                                        DELETE_CI_CITATION(citationSubSubId);
                                        jprocessbar.setValue(352);
                                        jprocessbar.setStringPainted(true);

                                    DELETE_MD_IDENTIFIER(mdIdentifierSubSubId);
                                    jprocessbar.setValue(354);
                                    jprocessbar.setStringPainted(true);

                                DELETE_CI_CITATION(citationSubId);
                                jprocessbar.setValue(356);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_MD_IDENTIFIER(mdIdentifierSubId);
                            jprocessbar.setValue(358);
                            jprocessbar.setStringPainted(true);

                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(360);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(362);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(364);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(366);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(368);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_TOPCONSIS(dqTopConsisId);
            jprocessbar.setValue(370);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
   
    }

    private void dqAbsextPosAcc(BigDecimal dqPositionalAccuracyId) {
       
        System.out.println("dqabsextposacc");
        
        try{
            
            DqAbsextposaccController dac = new DqAbsextposaccController(session, hibernateUtilXml);
            BigDecimal dqAbsextPostAccId = dac.getDataById(dqPositionalAccuracyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqAbsextPostAccId, DqElementModel.DQ_ABSEXTPOSACCID).getId();
                System.out.println(dqElementId +" dqElementId");
                
                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(374);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(376);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(378);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(380);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(382);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(384);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(386);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(388);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            
                            jprocessbar.setValue(390);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(392);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(394);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(396);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(398);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(400);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_ABSEXTPOSACC(dqAbsextPostAccId);
            jprocessbar.setValue(402);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }

    private void dqGridDataPosAcc(BigDecimal dqPositionalAccuracyId) {
       
        System.out.println("dqgriddataposacc");
        
        try{
               
            DqGridDataPosAccController dgdpac = new DqGridDataPosAccController(session, hibernateUtilXml);
            BigDecimal dqGridDataPosAccId = dgdpac.getDataById(dqPositionalAccuracyId).getId();
                
                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqGridDataPosAccId, DqElementModel.DQ_GRIDDATAPOSACCID).getId();
                    System.out.println(dqElementId +" dqElementId");
                    
                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(404);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(406);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                           CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(408);
                                jprocessbar.setStringPainted(true);
                    
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(410);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(412);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(414);
                            jprocessbar.setStringPainted(true);
                    
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(416);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(418);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(420);
                            jprocessbar.setStringPainted(true);
                    
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(422);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(424);
                        jprocessbar.setStringPainted(true);
                    
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(426);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(428);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_GRID_DATAPOSACC(dqGridDataPosAccId);
            jprocessbar.setValue(430);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
            
    }

    private void dqRellntPosAcc(BigDecimal dqPositionalAccuracyId) {
       
        System.out.println("dqrellntposacc");
        
        try{
            
            DqRellntPosAccController drpac = new DqRellntPosAccController(session, hibernateUtilXml);
            BigDecimal dqRellNtPosAccId = drpac.getDataById(dqPositionalAccuracyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqRellNtPosAccId, DqElementModel.DQ_RELLNTPOSACCID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(432);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(434);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(436);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(438);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(440);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(442);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(444);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(446);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(448);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_RELLNT_POSACC(dqRellNtPosAccId);
            jprocessbar.setValue(450);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
            
    }

    private void dqAccTimeMeAs(BigDecimal dqTemporalAccId) {      

        System.out.println("dqacctimemeas");
        
        try{
            
            DqAccTimeMeAsController datmac = new DqAccTimeMeAsController(session, hibernateUtilXml);
            BigDecimal dqAccTimeMeAsId = datmac.getDataById(dqTemporalAccId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqAccTimeMeAsId, DqElementModel.DQ_ACCTIMEMEASID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(454);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(456);
                    jprocessbar.setStringPainted(true);
                    
                    System.out.println(dqElementId+" ini adalah dqElemetn");

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(458);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(460);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(462);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(464);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(466);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(468);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(470);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(472);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(474);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(476);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(478);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(480);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_ACC_TIMEMEAS(dqAccTimeMeAsId);
            jprocessbar.setValue(482);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }

    }

    private void dqTempConsis(BigDecimal dqTemporalAccId) {
        
        System.out.println("dqtempconsis");
        
        try{
            
            DqTempConsisController dtcc = new DqTempConsisController(session, hibernateUtilXml);
            BigDecimal dqTempConsisId = dtcc.getDataById(dqTemporalAccId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqTempConsisId, DqElementModel.DQ_TEMPCONSISID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(484);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(486);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(488);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(490);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(492);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(494);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(496);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(498);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(500);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_TEMPCONSIS(dqTempConsisId);
            jprocessbar.setValue(502);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
            
    }

    private void dqTempValid(BigDecimal dqTemporalAccId) {
       
        System.out.println("dqtempvalid");
        
        try{
            
            DqTempValidController dtvc = new DqTempValidController(session, hibernateUtilXml);
            BigDecimal dqTempValidId = dtvc.getDataById(dqTemporalAccId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqTempValidId, DqElementModel.DQ_TEMPVALIDID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(504);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(506);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(508);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(510);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(512);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(514);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(516);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(518);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(520);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(522);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(524);
                    jprocessbar.setStringPainted(true);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(526);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(528);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(530);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_TEMPVALID(dqTempValidId);
            jprocessbar.setValue(532);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
             
    }

    private void dqThemClassCor(BigDecimal dqThematicAccuracyId) {
       
        System.out.println("dqthemclasscor");
        
        try{
        
            DqThemClassCorController dtccc = new DqThemClassCorController(session, hibernateUtilXml);
            BigDecimal dqThemClassCorId = dtccc.getDataById(dqThematicAccuracyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqThemClassCorId, DqElementModel.DQ_THEMCLASSCORID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(536);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(538);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(540);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(542);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(544);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(546);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(548);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(550);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(552);
                            jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                            jprocessbar.setValue(554);
                            jprocessbar.setStringPainted(true);

                            BigDecimal mdIdentifierSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
                                BigDecimal citationSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubId).getId();
                                    System.out.println(citationSubId);
                                    DELETE_CI_DATE(citationSubId);
                                    jprocessbar.setValue(556);
                                    jprocessbar.setStringPainted(true);
            
                                    DELETE_CI_CITATION_ALTERNATETITLE(citationSubId);
                                    jprocessbar.setValue(558);
                                    jprocessbar.setStringPainted(true);
            
                                DELETE_CI_CITATION(citationSubId);
                                jprocessbar.setValue(560);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_MD_IDENTIFIER(mdIdentifierSubId);
                            jprocessbar.setValue(562);
                            jprocessbar.setStringPainted(true);

                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(564);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(566);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(568);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_THEM_CLASS_COR(dqThemClassCorId);
            jprocessbar.setValue(570);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
            
    }

    private void dqNonQuanAttacc(BigDecimal dqThematicAccuracyId) {
       
        System.out.println("dqnonquanattac");
        
        try{
        
            DqNonQuanAttaccController dnqac = new DqNonQuanAttaccController(session, hibernateUtilXml);
            BigDecimal dqNonQuanAttacId = dnqac.getDataById(dqThematicAccuracyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqNonQuanAttacId, DqElementModel.DQ_NONQUANATTACCID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(572);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(574);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(576);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(578);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(580);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(582);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(584);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(586);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(588);
                jprocessbar.setStringPainted(true);

            DELETE_DQ_NON_QUANATTACH(dqNonQuanAttacId);
            jprocessbar.setValue(590);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
            
    }

    private void dqQuanAttacc(BigDecimal dqThematicAccuracyId) {
        
        System.out.println("dqquanattach");
        
        try{
            
            DqQuanAttacController dqac = new DqQuanAttacController(session, hibernateUtilXml);
            BigDecimal dqQuanAttaccId = dqac.getDataById(dqThematicAccuracyId).getId();

                DqElementController dec = new DqElementController(session, hibernateUtilXml);
                BigDecimal dqElementId = dec.getDataById(dqQuanAttaccId, DqElementModel.DQ_QUANATTACCID).getId();

                    DELETE_DQ_ELEMENT_NAMEOFMEASURE(dqElementId);
                    jprocessbar.setValue(592);
                    jprocessbar.setStringPainted(true);
            
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    jprocessbar.setValue(594);
                    jprocessbar.setStringPainted(true);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                                jprocessbar.setValue(596);
                                jprocessbar.setStringPainted(true);
            
                            DELETE_CI_CITATION(citationConformance);
                            jprocessbar.setValue(598);
                            jprocessbar.setStringPainted(true);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                        jprocessbar.setValue(600);
                        jprocessbar.setStringPainted(true);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            jprocessbar.setValue(602);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                        jprocessbar.setValue(604);
                        jprocessbar.setStringPainted(true);

                    DELETE_DQ_RESULT(dqResultId);
                    jprocessbar.setValue(606);
                    jprocessbar.setStringPainted(true);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            jprocessbar.setValue(608);
                            jprocessbar.setStringPainted(true);
            
                        DELETE_CI_CITATION(ciCitationId);
                        jprocessbar.setValue(610);
                        jprocessbar.setStringPainted(true);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    jprocessbar.setValue(612);
                    jprocessbar.setStringPainted(true);

                     BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                        jprocessbar.setValue(614);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_CITATION(citationEvaluation);
                    jprocessbar.setValue(616);
                    jprocessbar.setStringPainted(true);

                DELETE_DQ_ELEMENT(dqElementId);
                jprocessbar.setValue(618);
                jprocessbar.setStringPainted(true);

            DQ_QUAN_ATTACH(dqQuanAttaccId);
            jprocessbar.setValue(620);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
                
    }

    private void liLineage(BigDecimal dqDataQualityId) {
        
        System.out.println("LILineage");
        
        try{
            
            LiLineageController llc = new LiLineageController(session, hibernateUtilXml);
            BigDecimal liLineageId = llc.getDataById(dqDataQualityId).getId();
            
                System.out.println(liLineageId+" lilinenage id");
                LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
                BigDecimal liProccessStepId = lpsc.getDataById(LiProcessStepModel.LI_LINEAGE, liLineageId).getId();
                    
                    displayLog(true, "subElemen processStep\n");
                    processStep(liProccessStepId);//640
                    displayLog(true, "akhir subElemen processStep\n");

                DELETE_LI_PROCESS_STEP(liProccessStepId);
                jprocessbar.setValue(642);
                jprocessbar.setStringPainted(true);

                LiSourceController lsc = new LiSourceController(session, hibernateUtilXml);
                BigDecimal liSourceId = lsc.getDataById(LiSourceModel.LI_LINEAGEID, liLineageId).getId();

                    displayLog(true, "subElemen source\n");
                    source(liSourceId);//688
                    displayLog(true, "akhir subElemen source\n");

                DELETE_LI_SOURCE(liSourceId);
                jprocessbar.setValue(700);
                jprocessbar.setStringPainted(true);
                
            DELETE_LI_LINEAGE(liLineageId);
            jprocessbar.setValue(702);
            jprocessbar.setStringPainted(true);
                
        }catch(Exception n){
            n.printStackTrace();
        }

            
    }
    
    private void processStep(BigDecimal liProccessStepId){
        
        System.out.println("processStep");
        
        try{
            
            System.out.println(liProccessStepId+" liprocess id");
            
            CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
            BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.LI_PROCESSSTEPID, liProccessStepId).getId();

                CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                    CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                    BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                        DELETE_CI_TELEPHONE_FACSIMILE(ciTelephoneId);
                        jprocessbar.setValue(624);
                        jprocessbar.setStringPainted(true);
            
                        DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                        jprocessbar.setValue(626);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_TELEPHONE(ciTelephoneId);
                    jprocessbar.setValue(628);
                    jprocessbar.setStringPainted(true);

                    CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                    BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                        DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                        jprocessbar.setValue(630);
                        jprocessbar.setStringPainted(true);
            
                        DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                        jprocessbar.setValue(632);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_CI_ADDRESS(ciAddressId);
                    jprocessbar.setValue(634);
                    jprocessbar.setStringPainted(true);

                    DELETE_CI_ONLINERESOURCE(ciContactId, CiOnlineResourceModel.CI_CONTACTID);
                    jprocessbar.setValue(636);
                    jprocessbar.setStringPainted(true);

                DELETE_CI_CONTACT(ciContactId);
                jprocessbar.setValue(638);
                jprocessbar.setStringPainted(true);

            DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
            jprocessbar.setValue(640);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }
    
    private void source(BigDecimal liSourceId){
        
        System.out.println("source");
        
        try{
            
            displayLog(true, "subElemen sourceReferenceSystem\n");
            sourceReferenceSystem(liSourceId);//656
            displayLog(true, "akhir subElemen sourceReferenceSystem\n");
            
            displayLog(true, "subElemen sourceCitation\n");
            sourceCitation(liSourceId);//672
            displayLog(true, "akhir subElemen sourceCitation\n");
            
            displayLog(true, "subElemen sourceExtent\n");
            sourceExtent(liSourceId);//684
            displayLog(true, "akhir subElemen sourceExtent\n");
            
            displayLog(true, "subElemen sourceStep\n");
            sourceStep(liSourceId);//686
            displayLog(true, "akhir subElemen sourceStep\n");
            
            DELETE_MD_REPRESENTATIVE_FRACTION(MdRepresentativeFractionModel.LI_SOURCEID,liSourceId);
            jprocessbar.setValue(688);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
        
    }
    
    private void sourceReferenceSystem(BigDecimal liSourceId){
     
        System.out.println("sourceReferenceSystem");
        
        try{
            
        
            MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
            BigDecimal mdReferenceSystemId = mrsc.getDataById(MdReferenceSystemModel.LI_SOURCEID, liSourceId).getId();

                RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();

                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID, rsIdentifierId).getId();

                        DELETE_CI_DATE(ciCitationId);
                        jprocessbar.setValue(644);
                        jprocessbar.setStringPainted(true);
                
                        DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                        jprocessbar.setValue(646);
                        jprocessbar.setStringPainted(true);
                    
                        DELETE_CI_SERIES(ciCitationId);
                        jprocessbar.setValue(648);
                        jprocessbar.setStringPainted(true);
                
                        DELETE_CI_CITATION_PRESENTATION_FORM(ciCitationId);
                        jprocessbar.setValue(650);
                        jprocessbar.setStringPainted(true);

                    DELETE_CI_CITATION(ciCitationId);
                    jprocessbar.setValue(652);
                    jprocessbar.setStringPainted(true);

                DELETE_RS_IDENTIFIER(rsIdentifierId);
                jprocessbar.setValue(654);
                jprocessbar.setStringPainted(true);

            DELETE_MD_REFERENCESYSTEM(mdReferenceSystemId);
            jprocessbar.setValue(656);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }
    
    private void sourceCitation(BigDecimal liSourceId){
              
        System.out.println("sourceCitation");
        
        try{
            
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.LISOURCEID, liSourceId).getId();
                System.out.println("source citation "+ciCitationId);
                DELETE_CI_DATE(ciCitationId);
                jprocessbar.setValue(658);
                jprocessbar.setStringPainted(true);
            
                DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                jprocessbar.setValue(670);
                jprocessbar.setStringPainted(true);

            DELETE_CI_CITATION(ciCitationId);
            jprocessbar.setValue(672);
            jprocessbar.setStringPainted(true);
            
        }catch(Exception n){
            n.printStackTrace();
        }
        
    }
    
    private void sourceExtent(BigDecimal liSourceId){
         
        System.out.println("sourceExtent");
        
        try{
            
            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            BigDecimal exExtentId = eec.getDataById(ExExtentModel.LI_SOURCEID, liSourceId).getId();

                ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
                BigDecimal exGeoExtentId = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();

                    ExBoundingPolygonController ebpc = new ExBoundingPolygonController(session, hibernateUtilXml);
                    BigDecimal exBoundingPolygonId = ebpc.getDataById(exGeoExtentId).getExGeographicExtentId();

                        DELETE_EX_BOUNDING_POLYGON_POLYGON(exBoundingPolygonId);
                        jprocessbar.setValue(674);
                        jprocessbar.setStringPainted(true);
            
                    DELETE_EX_BOUNDING_POLYGON(exBoundingPolygonId);
                    jprocessbar.setValue(676);
                    jprocessbar.setStringPainted(true);

                DELETE_EX_GEOGRAPHIC_EXTENT(exGeoExtentId);
                jprocessbar.setValue(678);
                jprocessbar.setStringPainted(true);

                DELETE_EX_TEMPORAL_EXTENT(exExtentId);
                jprocessbar.setValue(680);
                jprocessbar.setStringPainted(true);
            
                DELETE_EX_VERTICAL_EXTENT(exExtentId);
                jprocessbar.setValue(682);
                jprocessbar.setStringPainted(true);

            DELETE_EX_EXTENT(exExtentId);
            jprocessbar.setValue(684);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }        
        
    }
    
    private void sourceStep(BigDecimal liSourceId){
             
        System.out.println("sourceStep");
        
        try{
        
            LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
            BigDecimal liProccessStepId = lpsc.getDataById(LiProcessStepModel.LI_SOURCEID, liSourceId).getId();

            DELETE_LI_PROCESS_STEP(liProccessStepId);
            jprocessbar.setValue(686);
            jprocessbar.setStringPainted(true);
        
        }catch(Exception n){
            n.printStackTrace();
        }
                
    }

    private void DELETE_DQ_DATAQUALITY(BigDecimal dqDataQualityId) {
        
        try{
            
            displayLog(true, "menghapus table DqDataQuality dengan id = " +dqDataQualityId);
            DqDataQualityController ddqc = new DqDataQualityController(session, hibernateUtilXml);
            String ret = ddqc.deletedDqDataQuality(dqDataQualityId);
            
            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqDataQuality " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqDataQuality " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqDataQuality " + n.toString());
        }
    }

    private void DELETE_DQ_SCOPE(BigDecimal dqScopeId) {
        
        try{
            displayLog(true, "menghapus table DqScope dengan id = " +dqScopeId);
            DqScopeController dsc = new DqScopeController(session, hibernateUtilXml);
            String ret = dsc.deletedDqScope(dqScopeId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqScope " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqScope " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqScope " + n.toString());
        }
    }
    
    private void DELETE_MD_MAINTANANCEINFO(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdMaintenanceInfo dengan id = " +id);
            MdMaintenanceInfoController mmi = new MdMaintenanceInfoController(session, hibernateUtilXml);
            String ret = mmi.deletedMdMaintenanceInfo(id);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdMaintenanceInfo " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdMaintenanceInfo " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdMaintenanceInfo " + n.toString());
        }
    }

    private void DELETE_MD_UPLOADINFO(BigDecimal id) {
        
        try{
            displayLog(true, "menghapus table MdUploadFile dengan id = " +id);
            MdUploadFileController muf = new MdUploadFileController(session, hibernateUtilXml);
            String ret = muf.deletedMdUploadFile(id);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdUploadFile " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdUploadFile " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdUploadFile " + n.toString());
        }
    }

    private void DELETE_DQ_ELEMENT_NAMEOFMEASURE(BigDecimal dqElementId) {
        
        try{
            displayLog(true, "menghapus table DqElementNameOfMeasure dengan dqElementId = " +dqElementId);
            DqElementNameOfMeasureController denomc = new DqElementNameOfMeasureController(session, hibernateUtilXml);
            String ret = denomc.deletedDqElementNameOfMeasure(dqElementId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqElementNameOfMeasure " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqElementNameOfMeasure " + ret +"\n");
            }
        }catch(Exception n){
            displayLog(false, "Error Metadata DqElementNameOfMeasure " + n.toString());
        }
    }

    private void DELETE_DQ_ELEMENT_DATETIME(BigDecimal dqElementId) {
        
        try{
            displayLog(true, "menghapus table DqElementDateTime dengan dqElementId = " +dqElementId);
            DqElementDateTimeController dedtc = new DqElementDateTimeController(session, hibernateUtilXml);
            String ret = dedtc.deletedDqElementDateTime(dqElementId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqElementDateTime " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqElementDateTime " + ret +"\n");
            }
        }catch(Exception n){
            displayLog(false, "Error Metadata DqElementDateTime " + n.toString());
        }
    }

    private void DELETE_DQ_CONFORMANCE_RESULT(BigDecimal dqConformanceResultId) {
        
        try{
            displayLog(true, "menghapus table DqConformanceResult dengan id = " +dqConformanceResultId);
            DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
            String ret = dcrc.deletedDqConformanceResult(dqConformanceResultId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqConformanceResult " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqConformanceResult " + ret +"\n");
            }
                        
        }catch(Exception n){
            displayLog(false, "Error Metadata DqConformanceResult " + n.toString());
        }
    }

    private void DELETE_DQ_QUANTITATIVE_RESULT_VALUE(BigDecimal dqQuantitativeResultId) {
        
        try{
            displayLog(true, "menghapus table DqQuantitativeResultValue dengan dqQuantitativeResultId = " +dqQuantitativeResultId);
            DqQuantitativeResultValueController dqrvc = new DqQuantitativeResultValueController(session, hibernateUtilXml);
            String ret = dqrvc.deletedDqQuantitativeResultValue(dqQuantitativeResultId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqQuantitativeResultValue " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqQuantitativeResultValue " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqQuantitativeResultValue " + n.toString());
        }
    }

    private void DELETE_DQ_QUANTITATIVE_RESULT(BigDecimal dqQuantitativeResultId) {
        
        try{
            displayLog(true, "menghapus table DqQuantitativeResult dengan id = " +dqQuantitativeResultId);
            DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
            String ret = dqrc.deletedDqQuantitativeResult(dqQuantitativeResultId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqQuantitativeResult " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqQuantitativeResult " + ret +"\n");
            }
         }catch(Exception n){
            displayLog(false, "Error Metadata DqQuantitativeResult " + n.toString());
        }
    }

    private void DELETE_DQ_RESULT(BigDecimal dqResultId) {
        
        try{
            displayLog(true, "menghapus table DqResult dengan id = " +dqResultId);
            DqResultController drc = new DqResultController(session, hibernateUtilXml);
            String ret = drc.deletedDqResult(dqResultId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqResult " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqResult " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqResult " + n.toString());
        }
    }

    private void DELETE_DQ_ELEMENT(BigDecimal dqElementId) {
        
        try{
            displayLog(true, "menghapus table DqElement dengan id = " +dqElementId);
            DqElementController dec = new DqElementController(session, hibernateUtilXml);
            String ret = dec.deletedDqElement(dqElementId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqElement " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqElement " + ret +"\n");
            }
        }catch(Exception n){
            displayLog(false, "Error Metadata DqElement " + n.toString());
        }
    }

    private void DELETE_DQ_COMPCOMM(BigDecimal dqCompCommId) {
        
        try{
            displayLog(true, "menghapus table DqCompComm dengan id = " +dqCompCommId);
            DqCompCommController dccc = new DqCompCommController(session, hibernateUtilXml);
            String ret = dccc.deletedDqCompComm(dqCompCommId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqCompComm " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqCompComm " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqCompComm " + n.toString());
        }
    }

    private void DELETE_DQ_COMPLETENESS(BigDecimal dqCompletenessId) {
        
        try{
            displayLog(true, "menghapus table DqCompleteness dengan id = " +dqCompletenessId);
            DqCompletenessController dcc = new DqCompletenessController(session, hibernateUtilXml);
            String ret = dcc.deletedDqCompleteness(dqCompletenessId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqCompleteness " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqCompleteness " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqCompleteness " + n.toString());
        }
        
    }

    private void DELETE_COMP_OM(BigDecimal dqComPomId) {
        
        try{
            displayLog(true, "menghapus table DqComPom dengan id = " +dqComPomId);
            DqComPomController dcpc = new DqComPomController(session, hibernateUtilXml);
            String ret = dcpc.deletedDqComPom(dqComPomId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqComPom " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqComPom " + ret +"\n");
            }
        }catch(Exception n){
            displayLog(false, "Error Metadata DqComPom " + n.toString());
        }
    }

    private void DELETE_DQ_CONCCONSIS(BigDecimal dqConConsisId) {
        
        try{
            displayLog(true, "menghapus table DqConConsis dengan id = " +dqConConsisId);
            DqConcconsisController dcc = new DqConcconsisController(session, hibernateUtilXml);
            String ret = dcc.deletedDqConcconsis(dqConConsisId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqConConsis " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqConConsis " + ret +"\n");
            }
        }catch(Exception n){
             displayLog(false, "Error Metadata DqConConsis " + n.toString());
        }
    }

    private void DELETE_CI_SERIES(BigDecimal citationEvaluation) {
        
        try{
            
            CiSeriesController csc = new CiSeriesController(session, hibernateUtilXml);
            BigDecimal id = csc.getDataById(citationEvaluation).getId();
            
            displayLog(true, "menghapus table CiSeries dengan id = " +id);
            String ret = csc.deletedCiSeries(id);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiSeries " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiSeries " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata CiSeries " + n.toString());
        }
    }

    private void DELETE_DQ_DOMCONSIS(BigDecimal dqDomconsisId) {
        
        try{
            displayLog(true, "menghapus table DqDomConsis dengan id = " +dqDomconsisId);
            DqDomconsisController ddc = new DqDomconsisController(session, hibernateUtilXml);
            String ret = ddc.deletedDqDomconsis(dqDomconsisId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqDomConsis " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqDomConsis " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqDomConsis " + n.toString());
        }
    }

    private void DELETE_DQ_FORMCONSIS(BigDecimal dqFormConsisId) {
        
        try{
            displayLog(true, "menghapus table DqFormConsis dengan id = " +dqFormConsisId);
            DqFormConsisController dfcc = new DqFormConsisController(session, hibernateUtilXml);
            String ret = dfcc.deletedDqFormConsis(dqFormConsisId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqFormConsis " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqFormConsis " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqFormConsis " + n.toString());

        }
    }

    private void DELETE_DQ_TOPCONSIS(BigDecimal dqTopConsisId) {
        
        try{
            displayLog(true, "menghapus table DqTopConsis dengan id = " +dqTopConsisId);
            DqTopConsisController dtcc = new DqTopConsisController(session, hibernateUtilXml);
            String ret = dtcc.deletedDqTopConsis(dqTopConsisId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqTopConsis " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqTopConsis " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqTopConsis " + n.toString());
        }
    }

    private void DELETE_DQ_LOGICAL_CONSISTENCY(BigDecimal dqLogicalConsitencyId) {
        
        try{
            displayLog(true, "menghapus table DqLogicalConsistency dengan id = " +dqLogicalConsitencyId);
            DqLogicalConsistencyController dlcc = new DqLogicalConsistencyController(session, hibernateUtilXml);
            String ret= dlcc.deletedDqLogicalConsistency(dqLogicalConsitencyId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqLogicalConsistency " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqLogicalConsistency " + ret +"\n");
            }
            
        }catch(Exception n){
           displayLog(false, "Error Metadata DqLogicalConsistency " + n.toString());

        }
    }

    private void DELETE_DQ_ABSEXTPOSACC(BigDecimal dqAbsextPostAccId) {
        
        try{
            displayLog(true, "menghapus table DqAbsextPosAcc dengan id = " +dqAbsextPostAccId);
            DqAbsextposaccController dac = new DqAbsextposaccController(session, hibernateUtilXml);
            String ret = dac.deletedDqAbsextposacc(dqAbsextPostAccId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqAbsextPosAcc " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqAbsextPosAcc " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqAbsextPosAcc " + n.toString());
        }
    }

    private void DELETE_DQ_GRID_DATAPOSACC(BigDecimal dqGridDataPosAccId) {
        
        try{
            displayLog(true, "menghapus table DqGridDataPosAcc dengan id = " +dqGridDataPosAccId);
            DqGridDataPosAccController dgdpac = new DqGridDataPosAccController(session, hibernateUtilXml);
            String ret = dgdpac.deletedDqGridDataPosAcc(dqGridDataPosAccId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqGridDataPosAcc " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqGridDataPosAcc " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqGridDataPosAcc " + n.toString());
        }
    }

    private void DELETE_DQ_RELLNT_POSACC(BigDecimal dqRellNtPosAccId) {
        
        try{
            displayLog(true, "menghapus table DqRellntPosAcc dengan id = " +dqRellNtPosAccId);
            DqRellntPosAccController drpac = new DqRellntPosAccController(session, hibernateUtilXml);
            String ret = drpac.deletedDqRellntPosAcc(dqRellNtPosAccId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqRellntPosAcc " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqRellntPosAcc " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqRellntPosAcc " + n.toString());
        }
    }

    private void DELETE_DQ_POSITIONAL_ACCURACY(BigDecimal dqPositionalAccuracyId) {
        
        try{
            displayLog(true, "menghapus table DqPositionalAccuracy dengan id = " +dqPositionalAccuracyId);
            DqPositionalAccuracyController dpac = new DqPositionalAccuracyController(session, hibernateUtilXml);
            String ret = dpac.deletedDqPositionalAccuracy(dqPositionalAccuracyId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqPositionalAccuracy " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqPositionalAccuracy " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "rror Metadata DqPositionalAccuracy " + n.toString());
        }
    }

    private void DELETE_DQ_ACC_TIMEMEAS(BigDecimal dqAccTimeMeAsId) {
        
        try{
            displayLog(true, "menghapus table DqAcctimeMeAs dengan id = " +dqAccTimeMeAsId);
            DqAccTimeMeAsController datmac = new DqAccTimeMeAsController(session, hibernateUtilXml);
            String ret = datmac.deletedDqAccTimeMeAs(dqAccTimeMeAsId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqAcctimeMeAs " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqAcctimeMeAs " + ret +"\n");
            }
        }catch(Exception n){
            displayLog(false, "Error Metadata DqAccTimeMeAs " + n.toString());
        }
    }

    private void DELETE_DQ_TEMPCONSIS(BigDecimal dqTempConsisId) {
        
        try{
            displayLog(true, "menghapus table DqTempConsis dengan id = " +dqTempConsisId);
            DqTempConsisController dtcc = new DqTempConsisController(session, hibernateUtilXml);
            String ret = dtcc.deletedDqTempConsis(dqTempConsisId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqTempConsis " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqTempConsis " + ret +"\n");
            }
            
        }catch(Exception n){
           displayLog(false, "Error Metadata DqTempConsis " + n.toString());
        }
    }

    private void DELETE_DQ_TEMPVALID(BigDecimal dqTempValidId) {
        
        try{
            displayLog(true, "menghapus table DqTempValid dengan id = " +dqTempValidId);
            DqTempValidController dtvc = new DqTempValidController(session, hibernateUtilXml);
            String ret = dtvc.deletedDqTempValid(dqTempValidId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqTempValid " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqTempValid " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqTempValid " + n.toString());
        }
    }

    private void DELETE_DQ_TEMPORALACC(BigDecimal dqTemporalAccId) {
        
        try{
            displayLog(true, "menghapus table DqTemporalAcc dengan id = " +dqTemporalAccId);
            DqTemporalAccuracyController dtac = new DqTemporalAccuracyController(session, hibernateUtilXml);
            String ret = dtac.deletedDqTemporalAccuracy(dqTemporalAccId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqTemporalAcc " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqTemporalAcc " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqTemporalAcc " + n.toString());
        }
    }

    private void DELETE_DQ_THEMATICACCURACY(BigDecimal dqThematicAccuracyId) {
        
        try{
            displayLog(true, "menghapus table DqThematicAccuracy dengan id = " +dqThematicAccuracyId);
            DqThematicAccuracyController dtac = new DqThematicAccuracyController(session, hibernateUtilXml);
            String ret = dtac.deletedDqThematicAccuracy(dqThematicAccuracyId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqThematicAccuracy " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqThematicAccuracy " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqThematicAccuracy " + n.toString());
        }
    }

    private void DELETE_DQ_THEM_CLASS_COR(BigDecimal dqThemClassCorId) {
        
        try{
            displayLog(true, "menghapus table DqThemClassCor dengan id = " +dqThemClassCorId);
            DqThemClassCorController dtccc = new DqThemClassCorController(session, hibernateUtilXml);
            String ret = dtccc.deleteDqThemClassCor(dqThemClassCorId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqThemClassCor " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqThemClassCor " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqThemClassCor " + n.toString());
        }
    }

    private void DELETE_DQ_NON_QUANATTACH(BigDecimal dqNonQuanAttacId) {
        
        try{
            displayLog(true, "menghapus table DqNonQuanAttach dengan id = " +dqNonQuanAttacId);
            DqNonQuanAttaccController dnqac = new DqNonQuanAttaccController(session, hibernateUtilXml);
            String ret = dnqac.deletedDqNonQuanAttacc(dqNonQuanAttacId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqNonQuanAttach " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqNonQuanAttach " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqNonQuanAttach " + n.toString());
        }
    }

    private void DQ_QUAN_ATTACH(BigDecimal dqQuanAttaccId) {
        
        try{
            displayLog(true, "menghapus table DqQuanAttach dengan id = " +dqQuanAttaccId);
            DqQuanAttacController dqac = new DqQuanAttacController(session, hibernateUtilXml);
            String ret = dqac.deletedDqQuanAttac(dqQuanAttaccId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata DqQuanAttach " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata DqQuanAttach " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata DqQuanAttach " + n.toString());
        }
    }

    private void DELETE_EX_BOUNDING_POLYGON_POLYGON(BigDecimal exBoundingPolygonId) {
        
        try{
            displayLog(true, "menghapus table ExBoundingPolygonPolgyon dengan exBoundingPolygonId = " +exBoundingPolygonId);
            ExBoundingPolygonPolygonController ebppc = new ExBoundingPolygonPolygonController(session, hibernateUtilXml);
            String ret = ebppc.deletedExBoundingPolygonPolygon(exBoundingPolygonId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExBoundingPolygonPolgyon " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExBoundingPolygonPolgyon " + ret +"\n");
            }
         
        }catch(Exception n){
            displayLog(false, "Error Metadata ExBoundingPolygonPolygon " + n.toString());
        }
    }

    private void DELETE_EX_BOUNDING_POLYGON(BigDecimal exBoundingPolygonId) {
        
        try{
            displayLog(true, "menghapus table ExBoundingPolygon dengan exGeographicExtentId = " +exBoundingPolygonId);
            ExBoundingPolygonController ebpc = new ExBoundingPolygonController(session, hibernateUtilXml);
            String ret = ebpc.deletedExBoundingPolygon(exBoundingPolygonId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata ExBoundingPolygon " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata ExBoundingPolygon " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata ExBoundingPolygon " + n.toString());
        }
    }

    private void DELETE_LI_PROCESS_STEP(BigDecimal liProccessStepId) {
        
        try{
            displayLog(true, "menghapus table LiProcessStep dengan id = " +liProccessStepId);
            LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
            String ret = lpsc.deletedLiProcessStep(liProccessStepId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata LiProcessStep " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata LiProcessStep " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata LiProcessStep " + n.toString());
        }
    }

    private void DELETE_LI_SOURCE(BigDecimal liSourceId) {
        
        try{
            displayLog(true, "menghapus table LiSource dengan id = " +liSourceId);
            LiSourceController lsc = new LiSourceController(session, hibernateUtilXml);
            String ret = lsc.deletedLiSource(liSourceId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata LiSource " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata LiSource " + ret +"\n");
            }
        
        }catch(Exception n){
            displayLog(false, "Error Metadata LiSource " + n.toString());;
        }
    }

    private void DELETE_LI_LINEAGE(BigDecimal liLineageId) {
        
        try{
            displayLog(true, "menghapus table LiLineage dengan id = " +liLineageId);
            LiLineageController llc = new LiLineageController(session, hibernateUtilXml);
            String ret = llc.deletedLiLineage(liLineageId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata LiLineage " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata LiLineage " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata LiLineage " + n.toString());
        }
    }

    private void DELETE_MD_APPLICATION_SCHEMA_INFO(BigDecimal mdApplicationSchemaInfoId) {
        
        try{
            displayLog(true, "menghapus table MdApplicationSchemaInfo dengan id = " +mdApplicationSchemaInfoId);
            MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
            String ret = masic.deletedMdApplicationSchemaInfo(mdApplicationSchemaInfoId);

            if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdApplicationSchemaInfo " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdApplicationSchemaInfo " + ret +"\n");
            }
            
        }catch(Exception n){
             displayLog(false, "Error Metadata MdApplicationSchemaInfo " + n.toString());
         
        }
    }

    private void DELETE_CI_CITATION_PRESENTATION_FORM(BigDecimal ciCitationId) {
        
        try{
            displayLog(true, "menghapus table CiCitationPresentationForm dengan ciCitationId = " +ciCitationId);
            CiCitationPresentationFormController ccpfc = new CiCitationPresentationFormController(session, hibernateUtilXml);
            String ret  = ccpfc.deleteCiCitationPresentationForm(ciCitationId);

           if(ret.contains("Error")){
                displayLog(false, "Status table Metadata CiCitationPresentationForm " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata CiCitationPresentationForm " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata CiCitationPresentationForm " + n.toString());
        }
    }

    private void DELETE_MD_METADATA_SECURITY_CONSTRAINTS(BigDecimal mdConstraintsId) {
        
         try{
            displayLog(true, "menghapus table MdSecurityConstraints dengan mdConstraintsId = " +mdConstraintsId);
             MdSecurityConstraintsController mscc = new MdSecurityConstraintsController(session, hibernateUtilXml);
             String ret = mscc.deletedMdSecurityConstraints(mdConstraintsId);

           if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdSecurityConstraints " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdSecurityConstraints " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdSecurityConstraints " + n.toString());
        }
    }
    
    private void DELETE_MD_METADATA_LEGAL_CONSTRAINTS(BigDecimal mdConstraintsId) {
        
         try{
            displayLog(true, "menghapus table MdLegalConstraints dengan mdConstraintsId = " +mdConstraintsId);
             MdLegalConstraintsController mlcc = new MdLegalConstraintsController(session, hibernateUtilXml);
             String ret = mlcc.deletedMdLegalConstraints(mdConstraintsId);
             
           if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdLegalConstraints " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdLegalConstraints " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdLegalConstraints " + n.toString());
        }
    }
    
    private void DELETE_MD_METADATA_LEGAL_CONSTRAINTS_OTHER(BigDecimal mdLegalConstraintsId) {
        
         try{
            displayLog(true, "menghapus table MdLegalConstraints dengan mdConstraintsId = " +mdLegalConstraintsId);
             MdLegalConstraintsOtherController mlcoc = new MdLegalConstraintsOtherController(session, hibernateUtilXml);
             String ret = mlcoc.deletedMdLegalConstraintsOther(mdLegalConstraintsId);
             
           if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdLegalConstraints " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdLegalConstraints " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdLegalConstraints " + n.toString());
        }
    }

    private void DELETE_MD_DISTRIBUTION(BigDecimal mdDistributionId) {
            
        try{
            
             displayLog(true, "menghapus table MdDistribution dengan id = " +mdDistributionId);
             MdDistributionController mdc = new MdDistributionController(session, hibernateUtilXml);
             String ret = mdc.deletedMdDistribution(mdDistributionId);
             
           if(ret.contains("Error")){
                displayLog(false, "Status table Metadata MdDistribution " + ret +"\n");
            }else{
                displayLog(true, "Status table Metadata MdDistribution " + ret +"\n");
            }
            
        }catch(Exception n){
            displayLog(false, "Error Metadata MdDistribution " + n.toString());
        }
    }
         
}
