/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.graphicoverview;

/**
 *
 * @author wallet
 */
public class MdBrowseGraphic {
    
    private String subParent;
    private String current="gmd:MD_BrowseGraphic";
    private String fileName="gmd:fileName.gco:CharacterString";
    private String fileType="gmd:fileType.gco:CharacterString";

    public MdBrowseGraphic(String parent) {
        subParent = parent+"."+current;
    }

    public String FileName() {
        return subParent+"."+fileName;
    }

    public String FileType() {
        return subParent+"."+fileType;
    }
    
}
