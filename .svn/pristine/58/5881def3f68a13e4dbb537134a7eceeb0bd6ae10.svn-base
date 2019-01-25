/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataentitysetinformation;

/**
 *
 * @author wallet
 */
public class CiTelephone {
    
    private String subParent;
    private String current="gmd:CI_Telephone";
    private String voice="gmd:voice.gco:CharacterString";
    private String facsimile="gmd:facsimile.gco:CharacterString";

    public CiTelephone(String parent) {
        subParent = parent+"."+current;
    }

    public String Voice() {
        return subParent+"."+voice;
    } 

    public String Facsimile() {
        return subParent+"."+facsimile;
    }
    
    
}
