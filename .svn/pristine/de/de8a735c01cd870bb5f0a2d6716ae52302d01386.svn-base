/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.contentinfo;

/**
 *
 * @author wallet
 */
public class MdCoverageDescription {
    
    private String current="gmd:MD_CoverageDescription";
    private String subParent;
    private String attributeDescription="gmd:attributeDescription.gco:RecordType";
    private String contentType="gmd:contentType.gmd:MD_CoverageContentTypeCode";

    public MdCoverageDescription(String parent) {
        subParent = parent+"."+current;
    }

    public String AttributeDescription() {
        return subParent+"."+attributeDescription;
    }

    public String ContentType() {
        return subParent+"."+contentType;
    }
    
    
}
