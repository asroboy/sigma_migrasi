/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.distributioninfo;

import model.metadata.xml.ParentElement;
import model.metadata.xml.identificationinfo.resourceformat.MdDigitalTransferOptions;
import model.metadata.xml.identificationinfo.resourceformat.MdDistributor;

/**
 *
 * @author wallet
 */
public class MdDistribution {

    private String subparent;
    private String current="gmd:MD_Distribution";
    private String distributorFormat="gmd:distributionFormat";
    private MdDistributor mdDistributor;
    private MdDigitalTransferOptions mdDigitalTransferOptions;
    
    public MdDistribution(String parent) {
        subparent=parent+"."+current;
    }

    public String DistributorFormat() {
        return subparent+"."+distributorFormat;
    }

    public MdDistributor MdDistributor() {
        mdDistributor = new MdDistributor(subparent+"."+ParentElement.DISTRIBUTOR);
        return mdDistributor;
    }

    public MdDigitalTransferOptions MdDigitalTransferOptions() {
        mdDigitalTransferOptions = new MdDigitalTransferOptions(subparent+"."+ParentElement.TRANSFEROPTION);
        return mdDigitalTransferOptions;
    }   
    
    
}
