/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.DataConfiguration;
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
import controller.MdDistributorController;
import controller.MdExtendedElementInfoController;
import controller.MdExtendedElementInfoParentController;
import controller.MdFormatController;
import controller.MdGeometricObjectsController;
import controller.MdIdentificationController;
import controller.MdIdentificationStatusController;
import controller.MdIdentifierController;
import controller.MdKeywordController;
import controller.MdKeywordKeywordController;
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
import controller.MdSpatialRepresentationController;
import controller.MdUploadFileController;
import controller.MdVectorSpatialRepresentationController;
import controller.RsIdentifierController;
import controller.SvServiceIdentificationController;
import domain.CiDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
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
import model.table.MdIdentifierModel;
import model.table.MdMaintenanceInfoModel;
import model.table.MdMetadataModel;
import model.table.MdReferenceSystemModel;
import model.table.MdRepresentativeFractionModel;
import model.table.RsIdentifierModel;
import org.hibernate.Session;

/**
 *
 * @author wallet
 */
public class DeleteMigrasiMetadata {

    /**
     * @param args the command line arguments
     */
    
    private Session session;
    private HibernateUtilXml hibernateUtilXml;

    public DeleteMigrasiMetadata(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        
        this.session = hibernateUtilXml.buildSession().openSession();
    }
    
//    public DeleteMigrasiMetadata(HibernateUtilXml hibernateUtilXml, String fileIdentifier) {
//       
//        this.hibernateUtilXml = hibernateUtilXml;
//        this.fileIdentifier = fileIdentifier;
//        
//        this.session = hibernateUtilXml.buildSession().openSession();
//        
//        //get metadata id
//        try{
//            
//             MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
//             this.mdMetadataId = mmc.getDataById(MdMetadataModel.FILEIDENTIFIER, fileIdentifier).getId(); 
//             
//        }catch(NullPointerException n){
//            n.printStackTrace();
//        }
//               
//    }
              
//    public static void main(String[] args) {
//        // TODO code application logic here       
//
//        //fileIdentifier
//        String fileIdentifier="LLN500020131209BANDUNGUTARA_11_TESTING";
//        
//        HibernateUtilXml hux = hibernateConfig();
//        DeleteMigrasiMetadata dmm = new DeleteMigrasiMetadata(hux);       
//                
//        //call fileidentifier
//        listFileIdentifier();
//        
//        //
//        
//            
//    }
    
//    public static HibernateUtilXml hibernateConfig(){
//        
//        String dbName="igsver2";
//        String ip="virtua.co.id";
//        String port="1522";
//        String userName="system";
//        String password="Virtua2017";
//        
//        DataConfiguration configuration = new DataConfiguration();
//        configuration.setDatabaseName(dbName);
//        configuration.setIp(ip);
//        configuration.setPort(port);
//        configuration.setUsername(userName);
//        configuration.setPassword(password);
//        
//        HibernateUtilXml hux = new HibernateUtilXml(configuration);
//        
//        return hux;
//     
//    }
//    
//    public static void listFileIdentifier(){
//        
//        HibernateUtilXml hux = hibernateConfig();
//        Session s = hux.buildSession().openSession();
//        
//        MdMetadataController mmc = new MdMetadataController(s, hux);
//        List list = mmc.getAllFileIdentifier();
//        
//        System.out.println("List FileIdentifier");
//        
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i));
//        }
//        
//    }
    
    public List getAllFileIdentifier(){
        
        MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
        List list = mmc.getAllFileIdentifier();
        
        return list;
        
    }
    
    public void getAllCiDate(){
         
        CiDateController cdc = new CiDateController(session, hibernateUtilXml);
        ArrayList<CiDate> cd = cdc.getAllData();
        String query = "";
        
        for(CiDate cds : cd){
             query="INSERT INTO METADATA.CI_DATE(ID,DATETYPE,DATE_,CI_CITATIONID) VALUES("
                    +cds.getId()+","
                    + "'"+cds.getDateType()+"',";
             
                    if(cds.getDate_()!=null){
                        query+="TO_DATE("+"'"+cds.getDate_()+"'"+",'YYYY-MM-DD'),";
                    }else{
                        query+="NULL"+",";
                    }
                   
                    query+=cds.getCiCitationId()+")";
            System.out.println(query);
        }            
            
    }
    
    public void insertData(){
        
       MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
       MdMetadataModel mmm = new MdMetadataModel();
       mmm.setId(new BigDecimal("82"));
       mmm.setCharacterset("000");
       mmm.setLocale(BigDecimal.ONE);
       mmm.setFileidentifier("RBI5000020070110SUMATERAKALIMANTANSULAWESI_TESTINGTESTING");
       
       System.out.println(mmc.saveMdMetadata(mmm));
    }
      
    public void deleteAll(String fileIdentifier){
        
        try{
                        
            MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
            
            String newIdentifier = mmc.checkFileidentifier(fileIdentifier);
            BigDecimal mdMetadataId = mmc.getDataById(MdMetadataModel.FILEIDENTIFIER, newIdentifier).getId(); 
            
            System.out.println(mdMetadataId+" => id Metadata");
             
            if(mdMetadataId==null){
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }else{
                
                    deleteMetadataSpatialInformation(mdMetadataId);
                    deleteMetadataReferenceSystemInformation(mdMetadataId);
                    deleteMetadataExtensionInformation(mdMetadataId);
                    deleteIdentificationInformation(mdMetadataId);
                    deleteContentInformation(mdMetadataId);
                    deleteDataQualityInformation(mdMetadataId);
                    deleteMetadataPortrayalCatalagueInformation(mdMetadataId);
                    deleteMetadataConstraintsInformation(mdMetadataId);
                    deleteMetadataApplicationSchemaInformation(mdMetadataId);
                    deleteMetadataMaintenanceInformation(mdMetadataId);
                    deleteMetadataUploadInformation(newIdentifier);
                    deleteMetadatEntitySetInformation(mdMetadataId);
            }      
            
        }catch(NullPointerException n){
            n.printStackTrace();
            System.out.println("Error : metadata id is "+n.getMessage());
        }
          
    }
    
    private void deleteMetadatEntitySetInformation(BigDecimal id){
    
        System.out.println("Deleting Metadata Entity Information\n");
        
            try{
                
                    DELETE_MD_METADATA_HIERARCHYLV(id);
                    DELETE_MD_METADATA_HIERARCHYLVNAME(id);

                        CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                        BigDecimal ciResponsiblepartyId = crpc.getDataById(CiResponsiblePartyModel.MD_METADATAID, id).getId();

                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblepartyId).getId();

                                CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                                BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();
                                    DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                                    DELETE_CI_TELEPHONE_FACSIMILE(ciTelephoneId);
                                DELETE_CI_TELEPHONE(ciTelephoneId);

                                CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                                BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();
                                    DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                                    DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                                DELETE_CI_ADDRESS(ciAddressId);

                                DELETE_CI_ONLINERESOURCE(ciContactId,CiOnlineResourceModel.CI_CONTACTID);

                            DELETE_CI_CONTACT(ciContactId);

                        DELETE_CI_RESPONSIBLEPARTY(ciResponsiblepartyId);
                
              //  DELETE_MD_METADATA(id);
                
            }catch(NullPointerException n){
                n.printStackTrace();
            }
             
        System.out.println("\nFinish Deleting Metadata Entity Information\n");
        
    }
    
    private void deleteMetadataSpatialInformation(BigDecimal id){
        
        System.out.println("Deleting Metadata Spatial Information\n");
        
        try{
                MdSpatialRepresentationController msrc = new MdSpatialRepresentationController(session, hibernateUtilXml);
                BigDecimal mdSpatialRepresentationId = msrc.getDataById(id).getId();

                    MdVectorSpatialRepresentationController mvsrc = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);
                    BigDecimal mdVectorSpatialId = mvsrc.getDataById(mdSpatialRepresentationId).getId();

                            MdGeometricObjectsController mgoc = new MdGeometricObjectsController(session, hibernateUtilXml);
                            List mdGeometricObjectId = mgoc.getListOfId(mdVectorSpatialId);
                            DELETE_MD_GEOMETRICOBJECTS(mdGeometricObjectId);

                    DELETE_MD_VECTORSPATIALREPRESENTATION(mdVectorSpatialId);

                DELETE_MD_SPATIALREPRESENTATION(mdSpatialRepresentationId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
   
        System.out.println("\nFinish Deleting Metadata Spatial Information\n");
               
    }
    
    private void deleteMetadataReferenceSystemInformation(BigDecimal id){
    
        System.out.println("Deleting Metadata Reference System Information\n");
        
        try{
            
                MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
                BigDecimal mdReferenceSystemId = mrsc.getDataById(MdReferenceSystemModel.MD_METADATAID, id).getId();

                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                    BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_REFERENCESYSTEMID, mdReferenceSystemId).getId();

                        CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.RSIDENTIFIERID, rsIdentifierId).getId();
                            System.out.println(ciCitationId + "mdReferenceSystem");
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_RS_IDENTIFIER(rsIdentifierId);

                DELETE_MD_REFERENCESYSTEM(mdReferenceSystemId); 
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }    
        
        System.out.println("\nFinish Deleting Metadata Reference System Information\n");
        
    }
    
    private void deleteMetadataPortrayalCatalagueInformation(BigDecimal id){
    
        System.out.println("Deleting Metadata Portrayal Catalague Information\n");
        
        try{
            
                MdPortrayalCatalogueRefController mpcrc = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
                BigDecimal mdPortrayalId = mpcrc.getDataById(id).getId();

                    CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                    BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDPORTRAYALCATALOGUEREFID, mdPortrayalId).getId();

                        DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                        DELETE_CI_DATE(ciCitationId);

                    DELETE_CI_CITATION(ciCitationId);

                DELETE_MD_PORTRAYALCATALOGUEREF(mdPortrayalId);
                
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                
        System.out.println("\nFinish Deleting Metadata Portrayal Catalague Information\n");
         
    }
    
    private void deleteMetadataExtensionInformation(BigDecimal id) {
    
        System.out.println("Deleting Metadata Extension Information\n");
        
        try{
            
                MdMetadataExtensionInfoController mmeic = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
                BigDecimal mdExtensionInfoId = mmeic.getDataById(id).getId();

                    DELETE_CI_ONLINERESOURCE(mdExtensionInfoId,CiOnlineResourceModel.MD_METADATAEXTENSIONINFOID);

                    MdExtendedElementInfoController meeic = new MdExtendedElementInfoController(session, hibernateUtilXml);
                    BigDecimal mdExtendedElementId = meeic.getDataById(mdExtensionInfoId).getId();

                        DELETE_MD_EXTENDED_ELEMENTINFO_PARENT(mdExtendedElementId);

                        CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                        BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.MD_EXTENDEDELEMENTINFOID, mdExtendedElementId).getId();

                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                                DELETE_CI_ONLINERESOURCE(ciContactId,CiOnlineResourceModel.CI_CONTACTID);
                            DELETE_CI_CONTACT(ciContactId);

                        DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
//
                    DELETE_MD_EXTENDED_ELEMENT(mdExtendedElementId);

                DELETE_MD_METADATA_EXTENSIONINFO(mdExtensionInfoId);
                
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
 
        
        System.out.println("\nFinish Deleting Metadata Extension Information\n");
        
    }
    
    private void deleteContentInformation(BigDecimal id){
    
         System.out.println("Deleting Metadata Content Information\n");
       
         try{
             
                MdContentInfoController mcic = new  MdContentInfoController(session, hibernateUtilXml);
                BigDecimal mdContentInfoId = mcic.getDataById(id).getId();
                       DELETE_MD_COVERAGE_DESCRIPTION(mdContentInfoId);

                DELETE_MD_CONTENT_INFO(id);
                
         }catch(NullPointerException n){
             n.printStackTrace();
         }
        
        System.out.println("\nFinish Deleting Content Information\n");
       
    }
    
    private void deleteIdentificationInformation(BigDecimal id){
    
       System.out.println("Deleting Metadata Identification Information\n");
       
        try{
            
            MdIdentificationController mic = new MdIdentificationController(session, hibernateUtilXml);
            BigDecimal mdIdentificationId = mic.getDataById(id).getId();
                
                System.out.println(mdIdentificationId+" mdIdentificationId");
                DELETE_MD_IDENTIFICATION_STATUS(mdIdentificationId);

                SvServiceIdentificationController ssic = new SvServiceIdentificationController(session, hibernateUtilXml);
                BigDecimal svServiceIdentificationId = ssic.getDataById(mdIdentificationId).getId();

                    MdDataIdentificationController mdic = new MdDataIdentificationController(session, hibernateUtilXml);
                    BigDecimal mdDataIdentificationId = mdic.getDataById(mdIdentificationId).getId();

                        DELETE_MD_DATAIDENTIFICATION_SPATREP(mdDataIdentificationId);
                        DELETE_MD_DATAIDENTIFICATION_LANG(mdDataIdentificationId);
                        DELETE_MD_DATAIDENTIFICATION_CHARSET(mdDataIdentificationId);
                        DELETE_MD_DATAIDENTIFICATION_TOPCAT(mdDataIdentificationId);
                       
                        //citation
                        citation(mdIdentificationId);
                        
                        //pointofcontact
                        pointOfContact(mdIdentificationId);
                        
                        //resourcemaintenance
                        resourceMaintenance(mdIdentificationId);
                        
                        //graphicoverview
                        graphicOverview(mdIdentificationId);
                       
                        //resourceformat
                        resourceFormat(mdIdentificationId);
                        
                        //descriptivekeywords
                        descriptiveKeywords(mdIdentificationId);
                        
                        //resourceconstraints
                        resourceConstraints(mdIdentificationId);
                        
                        //spatialresolution
                        spatialResolution(mdDataIdentificationId);
                        
                       // aggregationinfo
                        aggregationInfo(mdIdentificationId);
                        
                        //extent
                        extent(mdDataIdentificationId);
                        
                    DELETE_MD_DATAIDENTIFICATION(mdDataIdentificationId);

                DELETE_SV_SERVICEIDENTIFICATION(svServiceIdentificationId);
            
            DELETE_MD_IDENTIFICATION(mdIdentificationId);     
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                         
        
       System.out.println("\nFinish Deleting Metadata Identification Information\n");
    }
    
    private void deleteMetadataConstraintsInformation(BigDecimal id){
        
        System.out.println("Deleting Metadata Constraints Information\n");
        
        try{
        
            MdConstraintsController mci = new MdConstraintsController(session, hibernateUtilXml);
            BigDecimal mdConstraintsId = mci.getDataById(MdConstraintsModel.MD_METADATAID,id).getId();

                DELETE_MD_METADATA_CONSTRAINTS_USE_LIMITATION(mdConstraintsId);
            DELETE_MD_CONSTRAINTSINFO(mdConstraintsId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
        System.out.println("\nFinish Deleting Metadata Constraints Information\n");
        
    }
    
    private void deleteMetadataApplicationSchemaInformation(BigDecimal id){
        
        System.out.println("Deleting Metadata Application Schema Information\n");
        
        try{
                
            MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
            BigDecimal mdApplicationSchemaInfoId = masic.getDataById(id).getId();

                CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDAPPLICATIONSCHEMAINFOID, mdApplicationSchemaInfoId).getId();

                    DELETE_CI_DATE(ciCitationId);
                DELETE_CI_CITATION(ciCitationId);

            DELETE_MD_APPLICATION_SCHEMA_INFO(mdApplicationSchemaInfoId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
        System.out.println("\nFinish Deleting Metadata Application Schema Information\n");    
        
    }
    
    private void citation(BigDecimal mdIdentificationId) {
       
        try{
            
            System.out.println("citation");
            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
            BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFICATIONID, mdIdentificationId).getId();
            System.out.println(ciCitationId);
                DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                DELETE_CI_DATE(ciCitationId);

                MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();

                    RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
                    BigDecimal rsIdentifierId = ric.getDataById(RsIdentifierModel.MD_IDENTIFIERID, mdIdentifierId).getId();

                        BigDecimal ciCitationIdentifier = ccc.getDataById(CiCitationModel.RSIDENTIFIERID, rsIdentifierId).getId();

                            DELETE_CI_DATE(ciCitationIdentifier);
                        DELETE_CI_CITATION(ciCitationIdentifier);

                    DELETE_RS_IDENTIFIER(rsIdentifierId);

                DELETE_MD_IDENTIFIER(mdIdentifierId);

            DELETE_CI_CITATION(ciCitationId);

        }catch(NullPointerException n){
            n.printStackTrace();
        }
                
    }
    
    private void pointOfContact(BigDecimal mdIdentificationId){
        
        try{
                System.out.println("pointofcontact");
                CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();
                    System.out.println(ciResponsiblePartyId);
                    CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                    BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                        CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
                        BigDecimal ciTelephoneId = ctc.getDataById(ciContactId).getId();

                            DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                            DELETE_CI_TELEPHONE_FACSIMILE(ciTelephoneId);
                        DELETE_CI_TELEPHONE(ciTelephoneId);

                        CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                        BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                            DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                            DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                        DELETE_CI_ADDRESS(ciAddressId);

                        DELETE_CI_ONLINERESOURCE(ciContactId, CiOnlineResourceModel.CI_CONTACTID);

                    DELETE_CI_CONTACT(ciContactId);

                DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);  
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
               
        
    }
    
    private void resourceMaintenance(BigDecimal mdIdentificationId){
    
        try{
            
            System.out.println("resourceMaintenance");
            MdMaintenanceInfoController mmic = new MdMaintenanceInfoController(session, hibernateUtilXml);
            BigDecimal id = mmic.getDataById(MdMaintenanceInfoModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();
            System.out.println(id);
            DELETE_MD_MAINTENANCE(id);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    private void descriptiveKeywords(BigDecimal mdIdentificationId){
    
        System.out.println("descriptiveKeywords");
        
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
                                        System.out.println(ciCitationIdentifier);
                                            DELETE_CI_DATE(ciCitationIdentifier);
                                        DELETE_CI_CITATION(ciCitationIdentifier);

                                    DELETE_RS_IDENTIFIER(rsIdentifierId);

                            DELETE_MD_IDENTIFIER(mdIdentifierId);
                    }


                      DELETE_CI_DATE(ciCitationId);
                    DELETE_CI_CITATION(ciCitationId);             
              
            }catch(NullPointerException n){
                n.printStackTrace();
            }finally{
                   System.out.println(mdKeywordId.get(i));
                   DELETE_MD_KEYWORD_KEYWORD(new BigDecimal(mdKeywordId.get(i).toString()));
              DELETE_MD_KEYWORD(new BigDecimal(mdKeywordId.get(i).toString()));
            }
        }                     
            
    }
    
    private void graphicOverview(BigDecimal mdIdentificationId){
        
        System.out.println("graphicOverfiew");
    
        try{
               
            MdBrowseGraphicController mbgc = new MdBrowseGraphicController(session, hibernateUtilXml);
            BigDecimal id = mbgc.getDataById(mdIdentificationId).getId();
            System.out.println(id);

            DELETE_MD_BROWSE_GRAPHIC(id);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    
    }
    
    private void resourceFormat(BigDecimal mdIdentificationId){
        
        System.out.println("resource format");
    
        try{
            
            MdFormatController mfc = new MdFormatController(session, hibernateUtilXml);
            BigDecimal mdFormatId = mfc.getDataById(MdFormatModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();
                System.out.println(mdFormatId);
                MdDistributorController mdc = new MdDistributorController(session, hibernateUtilXml);
                BigDecimal mdDistributorId = mdc.getDataById(MdDistributorModel.MD_FORMATID, mdFormatId).getId();

                    CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
                    BigDecimal ciResponsiblePartyId = crpc.getDataById(CiResponsiblePartyModel.MD_DISTRIBUTORID, mdDistributorId).getId();

                            CiContactController ccc = new CiContactController(session, hibernateUtilXml);
                            BigDecimal ciContactId = ccc.getDataById(ciResponsiblePartyId).getId();

                                DELETE_CI_ONLINERESOURCE(ciContactId, CiOnlineResourceModel.CI_CONTACTID);
                            DELETE_CI_CONTACT(ciContactId);

                    DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);

                    MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
                    BigDecimal mdDigitalTransferOptId = mdtoc.getDataById(MdDigitalTransferOptionsModel.MD_DISTRIBUTORID, mdDistributorId).getId();

                        DELETE_CI_ONLINERESOURCE(mdDigitalTransferOptId, CiOnlineResourceModel.MD_DIGITALTRANSFEROPTIONID);
                        DELETE_MD_MEDIUM(mdDigitalTransferOptId);

                    DELETE_MD_DIGITAL_TRANSFER_OPTIONS(mdDigitalTransferOptId);

                DELETE_MD_DISTRIBUTOR(mdDistributorId);

            DELETE_MD_FORMAT(mdFormatId);
         
        }catch(NullPointerException n){
            n.printStackTrace();
        }

    }
    
    private void resourceConstraints(BigDecimal mdIdentificationId){
    
        System.out.println("resource constraints");
        
        try{
        
            MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
            BigDecimal mdConstraintsId = mcc.getDataById(MdConstraintsModel.MD_IDENTIFICATIONID, mdIdentificationId).getId();

                DELETE_MD_METADATA_CONSTRAINTS_USE_LIMITATION(mdConstraintsId);
            DELETE_MD_CONSTRAINTSINFO(mdConstraintsId);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    private void spatialResolution(BigDecimal mdDataIdentificationId){
    
       System.out.println("spatial resolution");
        
        try{
            
            MdResolutionController mrc = new MdResolutionController(session, hibernateUtilXml);
            BigDecimal mdResolutionId = mrc.getDataById(mdDataIdentificationId).getId();

                DELETE_MD_REPRESENTATIVE_FRACTION(MdRepresentativeFractionModel.MD_RESOLUTIONID,mdResolutionId);
            DELETE_MD_RESOLUTION(mdResolutionId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                    
    }
    
    private void aggregationInfo(BigDecimal mdIdentificationId){
    
        System.out.println("aggregationinfo");
        
        try{
        
            MdAggregateInfoController maic = new MdAggregateInfoController(session, hibernateUtilXml);
            BigDecimal mdAggregationInfoId = maic.getDataById(mdIdentificationId).getId();

                CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDAGGREGATEINFOID, mdAggregationInfoId).getId();
                    System.out.println(ciCitationId);
                    DELETE_CI_DATE(ciCitationId);
                DELETE_CI_CITATION(ciCitationId);

                MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.MDAGGREGATEINFOID, mdAggregationInfoId).getId();

                    BigDecimal ciCitationIdentifier = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                        System.out.println(ciCitationIdentifier);
                        DELETE_CI_DATE(ciCitationIdentifier);
                    DELETE_CI_CITATION(ciCitationIdentifier);

                DELETE_MD_IDENTIFIER(mdIdentifierId);

            DELETE_MD_AGGREGATION_INFO(mdAggregationInfoId);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    private void extent(BigDecimal mdDataIdentificationId){
    
        System.out.println("extent");
        
        try{

            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            BigDecimal exExtentId = eec.getDataById(ExExtentModel.MD_DATAIDENTIFICATIONID, mdDataIdentificationId).getId();

                ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
                BigDecimal exGeoExtentId  = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();

                    DELETE_EX_GEOGRAPHIC_BOUNDING_BOX(exGeoExtentId);
                DELETE_EX_GEOGRAPHIC_EXTENT(exGeoExtentId);


                DELETE_EX_TEMPORAL_EXTENT(exExtentId);
                DELETE_EX_VERTICAL_EXTENT(exExtentId);

            DELETE_EX_EXTENT(exExtentId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    private void deleteMetadataMaintenanceInformation(BigDecimal id){
        
        System.out.println("Deleting Metadata Maintanance Information\n");
        
        try{
        
            MdMaintenanceInfoController mmi = new MdMaintenanceInfoController(session, hibernateUtilXml);
            BigDecimal mdMaintananceInfoId = mmi.getDataById(MdMaintenanceInfoModel.MD_METADATAID, id).getId();
        
            DELETE_MD_MAINTANANCEINFO(mdMaintananceInfoId);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
        System.out.println("\nFinish Deleting Metadata Maintanance Information\n"); 
    }
    
    private void deleteMetadataUploadInformation(String fileIdentifier) {
        
        System.out.println("Deleting Metadata Upload Information\n");
        
        try{
                   
            MdUploadFileController muf = new MdUploadFileController(session, hibernateUtilXml);
            BigDecimal mdUploadFileId =  muf.getDataById(fileIdentifier).getId();
            
            DELETE_MD_UPLOADINFO(mdUploadFileId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
        System.out.println("\nFinish Deleting Metadata Upload Information\n"); 
    }
 
    private void deleteDataQualityInformation(BigDecimal id){
    
        System.out.println("Deleting DataQuality Information\n");
        
        try{
            
        
            DqDataQualityController ddqc = new DqDataQualityController(session, hibernateUtilXml);
            BigDecimal dqDataQualityId = ddqc.getDataById(id).getId();

                dqScope(dqDataQualityId);
                dqCompleteness(dqDataQualityId);
                dqLogicalConsistency(dqDataQualityId);
                dqPositionalAccuracy(dqDataQualityId);
                dqTemporalAccuracy(dqDataQualityId);
                dqThematicAccuracy(dqDataQualityId);
                liLineage(dqDataQualityId);

            DELETE_DQ_DATAQUALITY(dqDataQualityId);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
            
        System.out.println("\nFinish Deleting DataQuality Information\n");
            
    }
        
    private void DELETE_MD_METADATA_HIERARCHYLV(BigDecimal id) {
       
        MdMetadataHierarchyLvController mmhlc = new MdMetadataHierarchyLvController(session, hibernateUtilXml);
        mmhlc.deleteMdMetadataHierarchyLv(id);
        
    }

    private void DELETE_MD_METADATA_HIERARCHYLVNAME(BigDecimal id) {
        MdMetadataHierarchyLvNameController mmhlnc = new MdMetadataHierarchyLvNameController(session, hibernateUtilXml);
        mmhlnc.deleteMdMetadataHierarchylvName(id);
    }

    private void DELETE_MD_METADATA(BigDecimal id) {
        
        MdMetadataController mmc = new MdMetadataController(session, hibernateUtilXml);
        mmc.deletedMdMetadata(id);
    }

    private void DELETE_CI_TELEPHONE_VOICE(BigDecimal ciTelephoneId) {
        CiTelephoneVoiceController ctvc = new CiTelephoneVoiceController(session, hibernateUtilXml);
        ctvc.deleteCiTelephoneVoice(ciTelephoneId);
    }

    private void DELETE_CI_TELEPHONE_FACSIMILE(BigDecimal ciTelephoneId) {
        CiTelephoneFacsimileController ctfc = new CiTelephoneFacsimileController(session, hibernateUtilXml);
        ctfc.deleteCiTelephoneFacsimile(ciTelephoneId);
    }

    private void DELETE_CI_TELEPHONE(BigDecimal id) {
        CiTelephoneController ctc = new CiTelephoneController(session, hibernateUtilXml);
        ctc.deleteCiTelephone(id);
    }

    private void DELETE_CI_ADDRESS_DELIVERYPOINT(BigDecimal ciAddressId) {
        CiAddressDeliveryPointController cadpc = new CiAddressDeliveryPointController(session, hibernateUtilXml);
        cadpc.deleteCiAddressDeliveryPoint(ciAddressId);
    }

    private void DELETE_CI_ADDRESS_EMAILADDRESS(BigDecimal ciAddressId) {
        CiAddressEmailAddressController caeac = new CiAddressEmailAddressController(session, hibernateUtilXml);
        caeac.deletedCiAddressEmailAddress(ciAddressId);
    }

    private void DELETE_CI_ADDRESS(BigDecimal id) {
        CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
        cac.deletedCiAddress(id);
    }

    private void DELETE_CI_ONLINERESOURCE(BigDecimal id,String column) {
        CiOnlineResourceController corc = new CiOnlineResourceController(session, hibernateUtilXml);
        BigDecimal ciOnlineResourceId = corc.getDataById(column, id).getId();
        corc.deletedCiOnlineResource(ciOnlineResourceId);
        
    }

    private void DELETE_CI_CONTACT(BigDecimal ciContactId) {
       CiContactController ccc = new CiContactController(session, hibernateUtilXml);
       ccc.deleteCiContact(ciContactId);
    }

    private void DELETE_CI_RESPONSIBLEPARTY(BigDecimal id) {
       
        CiResponsiblePartyController crpc = new CiResponsiblePartyController(session, hibernateUtilXml);
        crpc.deleteCiResponsibleParty(id);
    }

    private void DELETE_MD_GEOMETRICOBJECTS(List listId) {
        
        MdGeometricObjectsController mgoc = new MdGeometricObjectsController(session, hibernateUtilXml);
      
        for(int i=0;i<listId.size();i++){
            
            mgoc.deletedMdGeometricObjects(new BigDecimal(listId.get(i).toString()));
           
        }
    }

    private void DELETE_MD_VECTORSPATIALREPRESENTATION(BigDecimal id) {
       
        MdVectorSpatialRepresentationController mvsrc = new MdVectorSpatialRepresentationController(session, hibernateUtilXml);
        mvsrc.deletedMdVectorSpatialRepresentation(id);
    }

    private void DELETE_MD_SPATIALREPRESENTATION(BigDecimal id) {
       
        MdSpatialRepresentationController msrc = new MdSpatialRepresentationController(session, hibernateUtilXml);
        msrc.deletedMdSpatialRepresentation(id);
    }

    private void DELETE_CI_DATE(BigDecimal ciCitationId) {
       
        CiDateController cdc = new CiDateController(session, hibernateUtilXml);
        BigDecimal id = cdc.getDataById(ciCitationId).getId();
        cdc.deletedCiDate(id);
        
    }

    private void DELETE_CI_CITATION(BigDecimal id) {
       CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
       ccc.deletedCiCitation(id);
    }

    private void DELETE_RS_IDENTIFIER(BigDecimal id) {
       RsIdentifierController ric = new RsIdentifierController(session, hibernateUtilXml);
       ric.deletedRsIdentifier(id);
    }

    private void DELETE_MD_REFERENCESYSTEM(BigDecimal id) {
       MdReferenceSystemController mrsc = new MdReferenceSystemController(session, hibernateUtilXml);
       mrsc.deletedMdReferenceSystem(id);
    }

    private void DELETE_CI_CITATION_ALTERNATETITLE(BigDecimal ciCitationId) {
       
        CiCitationAlternateTitleController ccatc = new CiCitationAlternateTitleController(session, hibernateUtilXml);
        ccatc.deletedCiCitationAlternateTitle(ciCitationId);
    }

    private void DELETE_MD_PORTRAYALCATALOGUEREF(BigDecimal id) {
       MdPortrayalCatalogueRefController mpcrc = new MdPortrayalCatalogueRefController(session, hibernateUtilXml);
       mpcrc.deletedMdPortrayalCatalogueRef(id);
    }

    private void DELETE_MD_EXTENDED_ELEMENTINFO_PARENT(BigDecimal mdExtendedElementId) {
     
        MdExtendedElementInfoParentController meeipc = new MdExtendedElementInfoParentController(session, hibernateUtilXml);
        meeipc.deleteMdExtendedElementInfoParent(mdExtendedElementId);
    }

    private void DELETE_MD_EXTENDED_ELEMENT(BigDecimal id) {
        
       MdExtendedElementInfoController meeic = new MdExtendedElementInfoController(session, hibernateUtilXml);
       meeic.deleteMdExtendedElementInfo(id);
    }

    private void DELETE_MD_METADATA_EXTENSIONINFO(BigDecimal id) {
        MdMetadataExtensionInfoController mmeic = new MdMetadataExtensionInfoController(session, hibernateUtilXml);
        mmeic.deleteMdMetadataExtensionInfo(id);
    }

    private void DELETE_MD_COVERAGE_DESCRIPTION(BigDecimal mdContentInfoId) {
        MdCoverageDescriptionController mcdc = new MdCoverageDescriptionController(session, hibernateUtilXml);
        mcdc.deleteMdCoverageDescription(mdContentInfoId);
    }

    private void DELETE_MD_CONTENT_INFO(BigDecimal id) {
        MdContentInfoController mci = new MdContentInfoController(session, hibernateUtilXml);
        mci.deletedMdContentInfo(id);
    }

    private void DELETE_MD_IDENTIFICATION_STATUS(BigDecimal mdIdentificationId) {
      
        MdIdentificationStatusController misc = new MdIdentificationStatusController(session, hibernateUtilXml);
        misc.deletedMdIdentificationStatus(mdIdentificationId);
    }

    private void DELETE_SV_SERVICEIDENTIFICATION(BigDecimal id) {
       
        SvServiceIdentificationController ssic = new SvServiceIdentificationController(session, hibernateUtilXml);
        ssic.deletedSvServiceIdentification(id);
    }

    private void DELETE_MD_DATAIDENTIFICATION_SPATREP(BigDecimal mdDataIdentificationId) {
       
        MdDataIdentificationSpatrepController mdisc = new MdDataIdentificationSpatrepController(session, hibernateUtilXml);
        mdisc.deletedMdDataIdentificationSpatrep(mdDataIdentificationId);
    }

    private void DELETE_MD_DATAIDENTIFICATION_LANG(BigDecimal mdDataIdentificationId) {
        MdDataIdentificationLangController mdisc = new MdDataIdentificationLangController(session, hibernateUtilXml);
        mdisc.deletedMdDataIdentificationLang(mdDataIdentificationId);
    }

    private void DELETE_MD_DATAIDENTIFICATION_CHARSET(BigDecimal mdDataIdentificationId) {
        MdDataIdentificationCharsetController mdisc = new MdDataIdentificationCharsetController(session, hibernateUtilXml);
        mdisc.deletedMdDataIdentificationCharset(mdDataIdentificationId);
    }

    private void DELETE_MD_DATAIDENTIFICATION_TOPCAT(BigDecimal mdDataIdentificationId) {
        MdDataIdentificationTopcatController mdisc = new MdDataIdentificationTopcatController(session, hibernateUtilXml);
        mdisc.deletedMdDataIdentificationTopcat(mdDataIdentificationId);
    }

    private void DELETE_MD_DATAIDENTIFICATION(BigDecimal mdDataIdentificationId) {
        MdDataIdentificationController mdic = new MdDataIdentificationController(session, hibernateUtilXml);
        mdic.deletedMdDataIdentification(mdDataIdentificationId);
    }

    private void DELETE_MD_IDENTIFICATION(BigDecimal mdIdentificationId) {
       MdIdentificationController mic = new MdIdentificationController(session, hibernateUtilXml);
       mic.deleteMdIdentification(mdIdentificationId);
    }

    private void DELETE_MD_IDENTIFIER(BigDecimal id) {
        
        MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
        mic.deletedMdIdentifier(id);
        
    }

    private void DELETE_MD_MAINTENANCE(BigDecimal id) {
        MdMaintenanceInfoController mmic = new MdMaintenanceInfoController(session, hibernateUtilXml);
        mmic.deletedMdMaintenanceInfo(id);
    }

    private void DELETE_MD_BROWSE_GRAPHIC(BigDecimal id) {
      
        MdBrowseGraphicController mbgc = new MdBrowseGraphicController(session, hibernateUtilXml);
        mbgc.deletedMdBrowseGraphic(id);
    }

    private void DELETE_MD_MEDIUM(BigDecimal mdDigitalTransferOptId) {
        
        MdMediumController mmc = new MdMediumController(session, hibernateUtilXml);
        BigDecimal id = mmc.getDataById(mdDigitalTransferOptId).getId();
        mmc.deletedMdMedium(id);
    }

    private void DELETE_MD_DIGITAL_TRANSFER_OPTIONS(BigDecimal mdDigitalTransferOptId) {
        MdDigitalTransferOptionsController mdtoc = new MdDigitalTransferOptionsController(session, hibernateUtilXml);
        mdtoc.deletedMdDigitalTransferOptions(mdDigitalTransferOptId);
    }

    private void DELETE_MD_DISTRIBUTOR(BigDecimal mdDistributorId) {
        MdDistributorController mdc = new MdDistributorController(session, hibernateUtilXml);
        mdc.deletedMdDistributor(mdDistributorId);
    }

    private void DELETE_MD_FORMAT(BigDecimal mdFormatId) {
       MdFormatController mfc = new MdFormatController(session, hibernateUtilXml);
       mfc.deletedMdFormat(mdFormatId);
    }
    
    private void DELETE_MD_METADATA_CONSTRAINTS_USE_LIMITATION(BigDecimal mdConstraintsId) {
        MdConstraintsUseLimitationController mcc = new MdConstraintsUseLimitationController(session, hibernateUtilXml);
        mcc.deletedMdConstraintsUseLimitation(mdConstraintsId);      
    }

    private void DELETE_MD_CONSTRAINTSINFO(BigDecimal id) {
        MdConstraintsController mcc = new MdConstraintsController(session, hibernateUtilXml);
        mcc.deletedMdConstraints(id);
    }

    private void DELETE_MD_REPRESENTATIVE_FRACTION(String column,BigDecimal foreignId) {
       
        MdRepresentativeFractionController mrfc = new MdRepresentativeFractionController(session, hibernateUtilXml);
        BigDecimal id = mrfc.getDataById(column, foreignId).getId();
        mrfc.deletedMdRepresentativeFraction(id);
    }

    private void DELETE_MD_RESOLUTION(BigDecimal mdResolutionId) {
       
        MdResolutionController mrc = new MdResolutionController(session, hibernateUtilXml);
        mrc.deletedMdResolution(mdResolutionId);
    }

    private void DELETE_MD_AGGREGATION_INFO(BigDecimal mdAggregationInfoId) {
       
        MdAggregateInfoController maic = new MdAggregateInfoController(session, hibernateUtilXml);
        maic.deletedMdAggregateInfo(mdAggregationInfoId);
    }

    private void DELETE_EX_GEOGRAPHIC_BOUNDING_BOX(BigDecimal exGeoExtentId) {
       
        ExGeographicBoundingBoxController egbbc = new ExGeographicBoundingBoxController(session, hibernateUtilXml);
        BigDecimal id = egbbc.getDataByIdExExGeographicExtent(exGeoExtentId).getId();
        egbbc.deletedExGeographicBoundingBox(id);
    }

    private void DELETE_EX_GEOGRAPHIC_EXTENT(BigDecimal exGeoExtentId) {
      
        ExGeographicExtentController egec = new ExGeographicExtentController(session, hibernateUtilXml);
        egec.deletedExGeographicExtent(exGeoExtentId);
        
    }

    private void DELETE_EX_TEMPORAL_EXTENT(BigDecimal exExtentId) {
        
        ExTemporalExtentController etec = new ExTemporalExtentController(session, hibernateUtilXml);
        BigDecimal id = etec.getDataById(exExtentId).getId();
        etec.deletedExTemporalExtent(id);
        
    }

    private void DELETE_EX_VERTICAL_EXTENT(BigDecimal exExtentId) {
       
        ExVerticalExtentController evec = new ExVerticalExtentController(session, hibernateUtilXml);
        BigDecimal id = evec.getDataById(exExtentId).getId();
        evec.deletedExVerticalExtent(id);
    }

    private void DELETE_EX_EXTENT(BigDecimal exExtentId) {
        
        ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
        eec.deletedExExtent(exExtentId);
    }

    private void DELETE_MD_KEYWORD_KEYWORD(BigDecimal mdKeywordId) {
        MdKeywordKeywordController mkkc = new MdKeywordKeywordController(session, hibernateUtilXml);
        mkkc.deletedMdKeywordKeyword(mdKeywordId);
    }

    private void DELETE_MD_KEYWORD(BigDecimal mdKeywordId) {
       MdKeywordController mkc = new MdKeywordController(session, hibernateUtilXml);
       mkc.deletedMdKeyword(mdKeywordId);
    }

    private void dqScope(BigDecimal dqDataQualityId) {
     
        try{
                DqScopeController dsc = new DqScopeController(session, hibernateUtilXml);
                BigDecimal dqScopeId = dsc.getDataById(dqDataQualityId).getId();

                   ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
                   BigDecimal exExtentId = eec.getDataById(ExExtentModel.DQ_SCOPEID, dqScopeId).getId();

                          ExGeographicExtentController egec = new ExGeographicExtentController(session, hibernateUtilXml);
                          BigDecimal exGeographicExtent = egec.getDataById(ExGeographicExtentModel.EX_EXTENTID, exExtentId).getId();

                              DELETE_EX_GEOGRAPHIC_BOUNDING_BOX(exGeographicExtent);
                          DELETE_EX_GEOGRAPHIC_EXTENT(exGeographicExtent);

                    DELETE_EX_EXTENT(exExtentId);

                DELETE_DQ_SCOPE(dqScopeId);
                
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                  
        
    }
    
    private void dqCompleteness(BigDecimal dqDataQualityId) {
         
        try{
            
         
            DqCompletenessController dcc = new DqCompletenessController(session, hibernateUtilXml);
            BigDecimal dqCompletenessId = dcc.getDataById(dqDataQualityId).getId();

                dqCompcomm(dqCompletenessId);
                dqCompom(dqCompletenessId);

            DELETE_DQ_COMPLETENESS(dqCompletenessId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                   
    }

    private void dqLogicalConsistency(BigDecimal dqDataQualityId) {
      
        try{
            
        
            DqLogicalConsistencyController dlcc = new DqLogicalConsistencyController(session, hibernateUtilXml);
            BigDecimal dqLogicalConsitencyId = dlcc.getDataById(dqDataQualityId).getId();

                dqConcconsis(dqLogicalConsitencyId);
                dqDomconsis(dqLogicalConsitencyId);
                dqFormconsis(dqLogicalConsitencyId);
                dqTopconsis(dqLogicalConsitencyId);

            DELETE_DQ_LOGICAL_CONSISTENCY(dqLogicalConsitencyId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
    }
    
    private void dqPositionalAccuracy(BigDecimal dqDataQualityId) {
       
        try{
            
        
            DqPositionalAccuracyController dpac = new DqPositionalAccuracyController(session, hibernateUtilXml);
            BigDecimal dqPositionalAccuracyId = dpac.getDataById(dqDataQualityId).getId();

                dqAbsextPosAcc(dqPositionalAccuracyId);
                dqGridDataPosAcc(dqPositionalAccuracyId);
                dqRellntPosAcc(dqPositionalAccuracyId);

            DELETE_DQ_POSITIONAL_ACCURACY(dqPositionalAccuracyId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
            
    }
    
    private void dqTemporalAccuracy(BigDecimal dqDataQualityId) {
     
        try{
            
        
            DqTemporalAccuracyController dtac = new DqTemporalAccuracyController(session, hibernateUtilXml);
            BigDecimal dqTemporalAccId = dtac.getDataById(dqDataQualityId).getId();

                dqAccTimeMeAs(dqTemporalAccId);
                dqTempConsis(dqTemporalAccId);
                dqTempValid(dqTemporalAccId);

            DELETE_DQ_TEMPORALACC(dqTemporalAccId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    private void dqThematicAccuracy(BigDecimal dqDataQualityId) {
        
        try{
        
            DqThematicAccuracyController dtac = new DqThematicAccuracyController(session, hibernateUtilXml);
            BigDecimal dqThematicAccuracyId = dtac.getDataById(dqDataQualityId).getId();

                dqThemClassCor(dqThematicAccuracyId);
                dqNonQuanAttacc(dqThematicAccuracyId);
                dqQuanAttacc(dqThematicAccuracyId);

            DELETE_DQ_THEMATICACCURACY(dqThematicAccuracyId);   
        
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                            DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                            BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                               CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                                BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                    System.out.println(citationConformance);
                                    DELETE_CI_DATE(citationConformance);
                                DELETE_CI_CITATION(citationConformance);

                            DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                            DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                            BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                                DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);

                            BigDecimal mdIdentifierSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
                                BigDecimal citationSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubId).getId();
                                     System.out.println(citationSubId);
                                    DELETE_CI_DATE(citationSubId);
                                DELETE_CI_CITATION(citationSubId);
                            DELETE_MD_IDENTIFIER(mdIdentifierSubId);

                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_COMPCOMM(dqCompCommId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                            DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                            BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                                CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                                BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                     System.out.println(citationConformance);
                                    DELETE_CI_DATE(citationConformance);
                                DELETE_CI_CITATION(citationConformance);

                            DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                            DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                            BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                                DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_COMP_OM(dqComPomId); 
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    
                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                            System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);
                    
                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();
                    DELETE_MD_IDENTIFIER(mdIdentifierId);
                    
                DELETE_DQ_ELEMENT(dqElementId);
             
            DELETE_DQ_CONCCONSIS(dqConConsisId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                        DELETE_CI_SERIES(citationEvaluation);
                   DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_DOMCONSIS(dqDomconsisId);    
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_FORMCONSIS(dqFormConsisId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                          CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                   DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);

                            BigDecimal mdIdentifierSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
                                BigDecimal citationSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubId).getId();
                                    System.out.println(citationSubId+" cicitation");
                                    DELETE_CI_DATE(citationSubId);

                                    BigDecimal mdIdentifierSubSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, citationSubId).getId();
                                        BigDecimal citationSubSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubSubId).getId();
                                            System.out.println(citationSubId);
                                            DELETE_CI_DATE(citationSubSubId);
                                        DELETE_CI_CITATION(citationSubSubId);

                                    DELETE_MD_IDENTIFIER(mdIdentifierSubSubId);

                                DELETE_CI_CITATION(citationSubId);
                            DELETE_MD_IDENTIFIER(mdIdentifierSubId);

                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_TOPCONSIS(dqTopConsisId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                              CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_ABSEXTPOSACC(dqAbsextPostAccId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                           CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);
                            
                            DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                            BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();
                                  DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                            DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);
                            
                       DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);
                       

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId);      

            DELETE_DQ_GRID_DATAPOSACC(dqGridDataPosAccId);  
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                           CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_RELLNT_POSACC(dqRellNtPosAccId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);
                    
                    System.out.println(dqElementId+" ini adalah dqElemetn");

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId); 

            DELETE_DQ_ACC_TIMEMEAS(dqAccTimeMeAsId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_TEMPCONSIS(dqTempConsisId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                    BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId); 

            DELETE_DQ_TEMPVALID(dqTempValidId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                            DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);

                            BigDecimal mdIdentifierSubId = mic.getDataById(MdIdentifierModel.CICITATIONID, ciCitationId).getId();
                                BigDecimal citationSubId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierSubId).getId();
                                    System.out.println(citationSubId);
                                    DELETE_CI_DATE(citationSubId);
                                    DELETE_CI_CITATION_ALTERNATETITLE(citationSubId);
                                DELETE_CI_CITATION(citationSubId);
                            DELETE_MD_IDENTIFIER(mdIdentifierSubId);

                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_THEM_CLASS_COR(dqThemClassCorId);
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                DELETE_DQ_ELEMENT(dqElementId);

            DELETE_DQ_NON_QUANATTACH(dqNonQuanAttacId);   
            
        }catch(NullPointerException n){
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
                    DELETE_DQ_ELEMENT_DATETIME(dqElementId);

                    DqResultController drc = new DqResultController(session, hibernateUtilXml);
                    BigDecimal dqResultId = drc.getDataById(dqElementId).getId();

                        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
                        BigDecimal dqConformanceResultId = dcrc.getDataById(dqResultId).getDqResultId();

                            CiCitationController ccc = new CiCitationController(session, hibernateUtilXml);
                            BigDecimal citationConformance = ccc.getDataById(CiCitationModel.DQCONFORMANCERESULTID, dqConformanceResultId).getId();
                                System.out.println(citationConformance);
                                DELETE_CI_DATE(citationConformance);
                            DELETE_CI_CITATION(citationConformance);

                        DELETE_DQ_CONFORMANCE_RESULT(dqConformanceResultId);

                        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
                        BigDecimal dqQuantitativeResultId = dqrc.getDataById(dqResultId).getDqResultId();

                            DELETE_DQ_QUANTITATIVE_RESULT_VALUE(dqQuantitativeResultId);
                        DELETE_DQ_QUANTITATIVE_RESULT(dqQuantitativeResultId);

                    DELETE_DQ_RESULT(dqResultId);

                    MdIdentifierController mic = new MdIdentifierController(session, hibernateUtilXml);
                    BigDecimal mdIdentifierId = mic.getDataById(MdIdentifierModel.DQELEMENTID,dqElementId).getId();

                        BigDecimal ciCitationId = ccc.getDataById(CiCitationModel.MDIDENTIFIERID, mdIdentifierId).getId();
                            System.out.println(ciCitationId);
                            DELETE_CI_DATE(ciCitationId);
                        DELETE_CI_CITATION(ciCitationId);

                    DELETE_MD_IDENTIFIER(mdIdentifierId);

                     BigDecimal citationEvaluation = ccc.getDataById(CiCitationModel.DQELEMENTID, dqElementId).getId();
                        System.out.println(citationEvaluation);
                        DELETE_CI_DATE(citationEvaluation);
                    DELETE_CI_CITATION(citationEvaluation);

                DELETE_DQ_ELEMENT(dqElementId); 

            DQ_QUAN_ATTACH(dqQuanAttaccId);   
            
        }catch(NullPointerException n){
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

                    processStep(liProccessStepId);

                DELETE_LI_PROCESS_STEP(liProccessStepId);

                LiSourceController lsc = new LiSourceController(session, hibernateUtilXml);
                BigDecimal liSourceId = lsc.getDataById(LiSourceModel.LI_LINEAGEID, liLineageId).getId();

                    source(liSourceId);

                DELETE_LI_SOURCE(liSourceId);
                
            DELETE_LI_LINEAGE(liLineageId);
                
        }catch(NullPointerException n){
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
                        DELETE_CI_TELEPHONE_VOICE(ciTelephoneId);
                    DELETE_CI_TELEPHONE(ciTelephoneId);

                    CiAddressController cac = new CiAddressController(session, hibernateUtilXml);
                    BigDecimal ciAddressId = cac.getDataById(ciContactId).getId();

                        DELETE_CI_ADDRESS_DELIVERYPOINT(ciAddressId);
                        DELETE_CI_ADDRESS_EMAILADDRESS(ciAddressId);
                    DELETE_CI_ADDRESS(ciAddressId);

                    DELETE_CI_ONLINERESOURCE(ciContactId, CiOnlineResourceModel.CI_CONTACTID);

                DELETE_CI_CONTACT(ciContactId);

            DELETE_CI_RESPONSIBLEPARTY(ciResponsiblePartyId);
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    private void source(BigDecimal liSourceId){
        
        System.out.println("source");
        
        try{


            DELETE_MD_REPRESENTATIVE_FRACTION(MdRepresentativeFractionModel.LI_SOURCEID,liSourceId);

            sourceReferenceSystem(liSourceId);
            sourceCitation(liSourceId);
            sourceExtent(liSourceId);
            sourceStep(liSourceId);
            
        }catch(NullPointerException n){
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
                        DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);
                        DELETE_CI_SERIES(ciCitationId);
                        DELETE_CI_CITATION_PRESENTATION_FORM(ciCitationId);

                    DELETE_CI_CITATION(ciCitationId);

                DELETE_RS_IDENTIFIER(rsIdentifierId);

            DELETE_MD_REFERENCESYSTEM(mdReferenceSystemId);
            
        }catch(NullPointerException n){
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
                DELETE_CI_CITATION_ALTERNATETITLE(ciCitationId);

            DELETE_CI_CITATION(ciCitationId);  
            
        }catch(NullPointerException n){
            n.printStackTrace();
        }
        
    }
    
    private void sourceExtent(BigDecimal liSourceId){
         
        System.out.println("sourceExtent");
        
        try{
            
            ExExtentController eec = new ExExtentController(session, hibernateUtilXml);
            BigDecimal exExtentId = eec.getDataById(ExExtentModel.LI_SOURCEID, liSourceId).getId();

                ExGeographicExtentController ege = new ExGeographicExtentController(session, hibernateUtilXml);
                BigDecimal exGeoExtentId  = ege.getDataById(ExGeographicExtentModel.EX_EXTENTID,exExtentId).getId();

                    ExBoundingPolygonController ebpc = new ExBoundingPolygonController(session, hibernateUtilXml);
                    BigDecimal exBoundingPolygonId = ebpc.getDataById(exGeoExtentId).getExGeographicExtentId();

                        DELETE_EX_BOUNDING_POLYGON_POLYGON(exBoundingPolygonId);
                    DELETE_EX_BOUNDING_POLYGON(exBoundingPolygonId);    

                DELETE_EX_GEOGRAPHIC_EXTENT(exGeoExtentId);

                DELETE_EX_TEMPORAL_EXTENT(exExtentId);
                DELETE_EX_VERTICAL_EXTENT(exExtentId);

            DELETE_EX_EXTENT(exExtentId);   
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }        
        
    }
    
    private void sourceStep(BigDecimal liSourceId){
             
        System.out.println("sourceStep");
        
        try{
        
            LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
            BigDecimal liProccessStepId = lpsc.getDataById(LiProcessStepModel.LI_SOURCEID, liSourceId).getId();

            DELETE_LI_PROCESS_STEP(liProccessStepId);
        
        }catch(NullPointerException n){
            n.printStackTrace();
        }
                
    }

    private void DELETE_DQ_DATAQUALITY(BigDecimal dqDataQualityId) {
        DqDataQualityController ddqc = new DqDataQualityController(session, hibernateUtilXml);
        ddqc.deletedDqDataQuality(dqDataQualityId);
    }

    private void DELETE_DQ_SCOPE(BigDecimal dqScopeId) {
       DqScopeController dsc = new DqScopeController(session, hibernateUtilXml);
       dsc.deletedDqScope(dqScopeId);
    }
    
    private void DELETE_MD_MAINTANANCEINFO(BigDecimal id) {
        MdMaintenanceInfoController mmi = new MdMaintenanceInfoController(session, hibernateUtilXml);
        mmi.deletedMdMaintenanceInfo(id);
    }

    private void DELETE_MD_UPLOADINFO(BigDecimal id) {
        MdUploadFileController muf = new MdUploadFileController(session, hibernateUtilXml);
        muf.deletedMdUploadFile(id);
    }

    private void DELETE_DQ_ELEMENT_NAMEOFMEASURE(BigDecimal dqElementId) {
        DqElementNameOfMeasureController denomc = new DqElementNameOfMeasureController(session, hibernateUtilXml);
        denomc.deletedDqElementNameOfMeasure(dqElementId);
    }

    private void DELETE_DQ_ELEMENT_DATETIME(BigDecimal dqElementId) {
        DqElementDateTimeController dedtc = new DqElementDateTimeController(session, hibernateUtilXml);
        dedtc.deletedDqElementDateTime(dqElementId);
    }

    private void DELETE_DQ_CONFORMANCE_RESULT(BigDecimal dqConformanceResultId) {
        DqConformanceResultController dcrc = new DqConformanceResultController(session, hibernateUtilXml);
        dcrc.deletedDqConformanceResult(dqConformanceResultId);
    }

    private void DELETE_DQ_QUANTITATIVE_RESULT_VALUE(BigDecimal dqQuantitativeResultId) {
        DqQuantitativeResultValueController dqrvc = new DqQuantitativeResultValueController(session, hibernateUtilXml);
        dqrvc.deletedDqQuantitativeResultValue(dqQuantitativeResultId);
    }

    private void DELETE_DQ_QUANTITATIVE_RESULT(BigDecimal dqQuantitativeResultId) {
        DqQuantitativeResultController dqrc = new DqQuantitativeResultController(session, hibernateUtilXml);
        dqrc.deletedDqQuantitativeResult(dqQuantitativeResultId);
    }

    private void DELETE_DQ_RESULT(BigDecimal dqResultId) {
       DqResultController drc = new DqResultController(session, hibernateUtilXml);
       drc.deletedDqResult(dqResultId);
    }

    private void DELETE_DQ_ELEMENT(BigDecimal dqElementId) {
        DqElementController dec = new DqElementController(session, hibernateUtilXml);
        dec.deletedDqElement(dqElementId);
    }

    private void DELETE_DQ_COMPCOMM(BigDecimal dqCompCommId) {
        DqCompCommController dccc = new DqCompCommController(session, hibernateUtilXml);
        dccc.deletedDqCompComm(dqCompCommId);
    }

    private void DELETE_DQ_COMPLETENESS(BigDecimal dqCompletenessId) {
        DqCompletenessController dcc = new DqCompletenessController(session, hibernateUtilXml);
        dcc.deletedDqCompleteness(dqCompletenessId);
    }

    private void DELETE_COMP_OM(BigDecimal dqComPomId) {
       DqComPomController dcpc = new DqComPomController(session, hibernateUtilXml);
       dcpc.deletedDqComPom(dqComPomId);
    }

    private void DELETE_DQ_CONCCONSIS(BigDecimal dqConConsisId) {
        DqConcconsisController dcc = new DqConcconsisController(session, hibernateUtilXml);
        dcc.deletedDqConcconsis(dqConConsisId);
    }

    private void DELETE_CI_SERIES(BigDecimal citationEvaluation) {
        CiSeriesController csc = new CiSeriesController(session, hibernateUtilXml);
        BigDecimal id = csc.getDataById(citationEvaluation).getId();
        csc.deletedCiSeries(id);
    }

    private void DELETE_DQ_DOMCONSIS(BigDecimal dqDomconsisId) {
        DqDomconsisController ddc = new DqDomconsisController(session, hibernateUtilXml);
        ddc.deletedDqDomconsis(dqDomconsisId);
    }

    private void DELETE_DQ_FORMCONSIS(BigDecimal dqFormConsisId) {
       DqFormConsisController dfcc = new DqFormConsisController(session, hibernateUtilXml);
       dfcc.deletedDqFormConsis(dqFormConsisId);
    }

    private void DELETE_DQ_TOPCONSIS(BigDecimal dqTopConsisId) {
        DqTopConsisController dtcc = new DqTopConsisController(session, hibernateUtilXml);
        dtcc.deletedDqTopConsis(dqTopConsisId);
    }

    private void DELETE_DQ_LOGICAL_CONSISTENCY(BigDecimal dqLogicalConsitencyId) {
        DqLogicalConsistencyController dlcc = new DqLogicalConsistencyController(session, hibernateUtilXml);
        dlcc.deletedDqLogicalConsistency(dqLogicalConsitencyId);
    }

    private void DELETE_DQ_ABSEXTPOSACC(BigDecimal dqAbsextPostAccId) {
        DqAbsextposaccController dac = new DqAbsextposaccController(session, hibernateUtilXml);
        dac.deletedDqAbsextposacc(dqAbsextPostAccId);
    }

    private void DELETE_DQ_GRID_DATAPOSACC(BigDecimal dqGridDataPosAccId) {
        DqGridDataPosAccController dgdpac = new DqGridDataPosAccController(session, hibernateUtilXml);
        dgdpac.deletedDqGridDataPosAcc(dqGridDataPosAccId);
    }

    private void DELETE_DQ_RELLNT_POSACC(BigDecimal dqRellNtPosAccId) {
       DqRellntPosAccController drpac = new DqRellntPosAccController(session, hibernateUtilXml);
       drpac.deletedDqRellntPosAcc(dqRellNtPosAccId);
    }

    private void DELETE_DQ_POSITIONAL_ACCURACY(BigDecimal dqPositionalAccuracyId) {
        DqPositionalAccuracyController dpac = new DqPositionalAccuracyController(session, hibernateUtilXml);
        dpac.deletedDqPositionalAccuracy(dqPositionalAccuracyId);
    }

    private void DELETE_DQ_ACC_TIMEMEAS(BigDecimal dqAccTimeMeAsId) {
       DqAccTimeMeAsController datmac = new DqAccTimeMeAsController(session, hibernateUtilXml);
       datmac.deletedDqAccTimeMeAs(dqAccTimeMeAsId);
    }

    private void DELETE_DQ_TEMPCONSIS(BigDecimal dqTempConsisId) {
        DqTempConsisController dtcc = new DqTempConsisController(session, hibernateUtilXml);
        dtcc.deletedDqTempConsis(dqTempConsisId);
    }

    private void DELETE_DQ_TEMPVALID(BigDecimal dqTempValidId) {
       DqTempValidController dtvc = new DqTempValidController(session, hibernateUtilXml);
       dtvc.deletedDqTempValid(dqTempValidId);
    }

    private void DELETE_DQ_TEMPORALACC(BigDecimal dqTemporalAccId) {
        DqTemporalAccuracyController dtac = new DqTemporalAccuracyController(session, hibernateUtilXml);
        dtac.deletedDqTemporalAccuracy(dqTemporalAccId);
    }

    private void DELETE_DQ_THEMATICACCURACY(BigDecimal dqThematicAccuracyId) {
       DqThematicAccuracyController dtac = new DqThematicAccuracyController(session, hibernateUtilXml);
       dtac.deletedDqThematicAccuracy(dqThematicAccuracyId);
    }

    private void DELETE_DQ_THEM_CLASS_COR(BigDecimal dqThemClassCorId) {
        DqThemClassCorController dtccc = new DqThemClassCorController(session, hibernateUtilXml);
        dtccc.deleteDqThemClassCor(dqThemClassCorId);
    }

    private void DELETE_DQ_NON_QUANATTACH(BigDecimal dqNonQuanAttacId) {
        DqNonQuanAttaccController dnqac = new DqNonQuanAttaccController(session, hibernateUtilXml);
        dnqac.deletedDqNonQuanAttacc(dqNonQuanAttacId);
    }

    private void DQ_QUAN_ATTACH(BigDecimal dqQuanAttaccId) {
        DqQuanAttacController dqac = new DqQuanAttacController(session, hibernateUtilXml);
        dqac.deletedDqQuanAttac(dqQuanAttaccId);
    }

    private void DELETE_EX_BOUNDING_POLYGON_POLYGON(BigDecimal exBoundingPolygonId) {
        ExBoundingPolygonPolygonController ebppc = new ExBoundingPolygonPolygonController(session, hibernateUtilXml);
        ebppc.deletedExBoundingPolygonPolygon(exBoundingPolygonId);
    }

    private void DELETE_EX_BOUNDING_POLYGON(BigDecimal exBoundingPolygonId) {
        ExBoundingPolygonController ebpc = new ExBoundingPolygonController(session, hibernateUtilXml);
        ebpc.deletedExBoundingPolygon(exBoundingPolygonId);
    }

    private void DELETE_LI_PROCESS_STEP(BigDecimal liProccessStepId) {
        LiProcessStepController lpsc = new LiProcessStepController(session, hibernateUtilXml);
        lpsc.deletedLiProcessStep(liProccessStepId);
    }

    private void DELETE_LI_SOURCE(BigDecimal liSourceId) {
        LiSourceController lsc = new LiSourceController(session, hibernateUtilXml);
        lsc.deletedLiSource(liSourceId);
    }

    private void DELETE_LI_LINEAGE(BigDecimal liLineageId) {
        LiLineageController llc = new LiLineageController(session, hibernateUtilXml);
        llc.deletedLiLineage(liLineageId);
    }

    private void DELETE_MD_APPLICATION_SCHEMA_INFO(BigDecimal mdApplicationSchemaInfoId) {
        MdApplicationSchemaInfoController masic = new MdApplicationSchemaInfoController(session, hibernateUtilXml);
        masic.deletedMdApplicationSchemaInfo(mdApplicationSchemaInfoId);
    }

    private void DELETE_CI_CITATION_PRESENTATION_FORM(BigDecimal ciCitationId) {
        CiCitationPresentationFormController ccpfc = new CiCitationPresentationFormController(session, hibernateUtilXml);
        ccpfc.deleteCiCitationPresentationForm(ciCitationId);
    }
    
}
