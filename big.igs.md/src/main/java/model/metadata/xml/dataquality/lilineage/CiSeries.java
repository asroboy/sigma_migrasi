/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.lilineage;

/**
 *
 * @author wallet
 */
public class CiSeries {
    
    private String current="gmd:CI_Series";
    private String subParent;
    private String name="gmd:name.gco:CharacterString";
    private String issueIdentification="gmd:issueIdentification.gco:CharacterString";
    private String page="gmd:page.gco:CharacterString";

    public CiSeries(String parent) {
        this.subParent = parent+"."+current;
    }

    public String Name() {
        return subParent+"."+name;
    }

    public String IssueIdentification() {
        return subParent+"."+issueIdentification;
    }

    public String Page() {
        return subParent+"."+page;
    } 
    
}
