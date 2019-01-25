/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.identificationinfo.descriptivekeywords;

import model.metadata.xml.ParentElement;
import model.metadata.xml.referencesystemInfo.CiCitation;

/**
 *
 * @author WIN8
 */
public class MdKeywords {
    
    private String subParent;
    private String current="gmd:MD_Keywords";
    private String keyword="gmd:keyword.gco:CharacterString";
    private String type="gmd:type.gmd:MD_KeywordTypeCode";
    private CiCitation ciCitation;

    public MdKeywords(String parent) {
        subParent= parent+"."+current;
    }

    public String Keyword() {
        return subParent+"."+keyword;
    }

    public String Type() {
        return subParent+"."+type;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subParent+"."+ParentElement.THESAURUSNAME);
        return ciCitation;
    }
        
    
}
