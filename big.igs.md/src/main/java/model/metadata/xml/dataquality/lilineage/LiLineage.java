/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.lilineage;

import model.metadata.xml.ParentElement;

/**
 *
 * @author WIN8
 */
public class LiLineage {
    
    private String subparent;
    private String current="gmd:LI_Lineage";
    private String statement="gmd:statement.gco:CharacterString";
    private LiProcessStep liProcessStep;
    private LiSource liSource;

    public LiLineage(String parent) {
        subparent = parent+"."+current;
    }

    public String Statement() {
        return subparent+"."+statement;
    }

    public LiProcessStep LiProcessStep() {
        liProcessStep = new LiProcessStep(subparent+"."+ParentElement.PROCESSSTEP);
        return liProcessStep;
    }

    public LiSource LiSource() {
        liSource = new LiSource(subparent+"."+ParentElement.SOURCE);
        return liSource;
    }
    
    
}
