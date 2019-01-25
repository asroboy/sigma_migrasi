/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadatamaintenance;

/**
 *
 * @author wallet
 */
public class MdMaintenanceInformation {
    
    private String current="gmd:MD_MaintenanceInformation";
    private String subParent;
    private String maintenanceAndUpdateFrequency="gmd:maintenanceAndUpdateFrequency.gmd:MD_MaintenanceFrequencyCode";

    public MdMaintenanceInformation(String parent) {       
        subParent=parent+"."+current;
    }

    public String MaintenanceAndUpdateFrequency() {
        return subParent+"."+maintenanceAndUpdateFrequency;
    }
   
    
    
    
    
}
