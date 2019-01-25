/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality.lilineage;

import model.metadata.xml.ParentElement;
import model.metadata.xml.identificationinfo.extent.Extent;
import model.metadata.xml.identificationinfo.spatialresolution.MdRepresentativeFraction;
import model.metadata.xml.referencesystemInfo.CiCitation;
import model.metadata.xml.referencesystemInfo.MdReferenceSystem;

/**
 *
 * @author WIN8
 */
public class LiSource {
    
    private String subparent;
    private String current="gmd:LI_Source";
    private String description="gmd:description.gco:CharacterString";
    private MdRepresentativeFraction mdRepresentativeFraction;
    private MdReferenceSystem mdReferenceSystem;
    private CiCitation ciCitation;
    private Extent extent;
    private LiProcessStep liProcessStep;

    public LiSource(String parent) {
        subparent = parent+"."+current;
    }

    public String Description() {
        return subparent+"."+description;
    }

    public MdRepresentativeFraction MdRepresentativeFraction() {
        mdRepresentativeFraction=new MdRepresentativeFraction(subparent+"."+ParentElement.SCALEDENOMINATOR);
        return mdRepresentativeFraction;
    }

    public MdReferenceSystem MdReferenceSystem() {
        mdReferenceSystem=new MdReferenceSystem(subparent+"."+ParentElement.SOURCEREFERENCESYSTEM);
        return mdReferenceSystem;
    }

    public CiCitation CiCitation() {
        ciCitation=new CiCitation(subparent+"."+ParentElement.SOURCECITATION);
        return ciCitation;
    }

    public Extent Extent() {
        extent=new Extent(subparent+"."+ParentElement.SOURCEEXTENT);
        return extent;
    }

    public LiProcessStep LiProcessStep() {
        liProcessStep=new LiProcessStep(subparent+"."+ParentElement.SOURCESTEP);
        return liProcessStep;
    }
        
    
}
