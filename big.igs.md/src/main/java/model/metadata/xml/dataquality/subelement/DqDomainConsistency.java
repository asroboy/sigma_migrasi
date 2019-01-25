/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.subelement;

import model.metadata.xml.dataquality.DqBaseModel;
/**
 *
 * @author wallet
 */
public class DqDomainConsistency extends DqBaseModel{
    
    private static String current="gmd:DQ_DomainConsistency";
    private String subParent;    

    public DqDomainConsistency(String Parent) {
        super(Parent+"."+current);
    }
    
}
