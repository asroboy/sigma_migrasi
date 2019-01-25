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
public class CiOnlineResourceInfo {
    
    private String current="gmd:CI_OnlineResource";
    private String subparent;
    private String linkage="gmd:linkage.gmd:URL";
    private String protocol="gmd:protocol.gco:CharacterString";
    private String applicationProfile="gmd:applicationProfile.gco:CharacterString";
    private String name="gmd:name.gco:CharacterString";
    private String description="gmd:description.gco:CharacterString";
    private String function="gmd:function.gmd:CI_OnLineFunctionCode";
    
    public CiOnlineResourceInfo(String parent) {
        this.subparent = parent+"."+current;
    }

    public String Current() {
        return subparent+"."+current;
    }

    public String Linkage() {
        return subparent+"."+linkage;
    }

    public String Protocol() {
        return subparent+"."+protocol;
    }

    public String ApplicationProfile() {
        return subparent+"."+applicationProfile;
    }

    public String Name() {
        return subparent+"."+name;
    }

    public String Description() {
        return subparent+"."+description;
    }

    public String Function() {
        return subparent+"."+function;
    }
    
          
}
