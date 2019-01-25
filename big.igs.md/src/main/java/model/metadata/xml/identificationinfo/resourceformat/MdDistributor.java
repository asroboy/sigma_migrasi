/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.resourceformat;

import model.metadata.xml.ParentElement;
import model.metadata.xml.identificationinfo.resourceformat.MdDigitalTransferOptions;
import model.metadata.xml.metadataentitysetinformation.CiResponsibleParty;

/**
 *
 * @author wallet
 */
public class MdDistributor {
    
    private String subParent;
    private String current="gmd:MD_Distributor";
    private String distributorFormat="gmd:distributorFormat";
    private CiResponsibleParty ciResponsibleParty;
    private MdDigitalTransferOptions mdDigitalTransferOptions;

    public MdDistributor(String parent) {
    
        subParent = parent+"."+current;
    }

    public String DistributorFormat() {
        return subParent+"."+distributorFormat;
    }

    public CiResponsibleParty CiResponsibleParty() {
        ciResponsibleParty=new CiResponsibleParty(subParent+"."+ParentElement.DISTRIBUTORCONTACT);
        return ciResponsibleParty;
    }

    public MdDigitalTransferOptions MdDigitalTransferOptions() {
        mdDigitalTransferOptions=new MdDigitalTransferOptions(subParent+"."+ParentElement.DISTRIBUTORTRANSFEROPTIONS);
        return mdDigitalTransferOptions;
    }

}
