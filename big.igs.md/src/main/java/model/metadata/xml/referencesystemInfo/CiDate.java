/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.referencesystemInfo;

/**
 *
 * @author wallet
 */
public class CiDate {
    
    private String subParent;
    private String current="gmd:CI_Date";
    private String date="gmd:date.gco:Date";
    private String dateType="gmd:dateType.gmd:CI_DateTypeCode";
    
    public CiDate(String parent) {
        subParent = parent+"."+current;
    }
    
    public String Date() {
        return subParent+"."+date;
    }

    public String DateType() {
        return subParent+"."+dateType;
    }
    
}
