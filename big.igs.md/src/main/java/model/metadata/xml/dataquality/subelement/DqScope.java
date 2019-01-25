/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.subelement;

import model.metadata.xml.identificationinfo.extent.Extent;

/**
 *
 * @author wallet
 */
public class DqScope {
    
    private String current="gmd:DQ_Scope";
    private String level="gmd:level.gmd:MD_ScopeCode";
    private String levelDescription="gmd:levelDescription";
    private String subparent;

    public DqScope(String parent) {
        this.subparent = parent+"."+current;
    }

    public String Level() {
        return subparent+"."+level;
    }

    public String LevelDescription() {
        return subparent+"."+levelDescription;
    }
        
}
