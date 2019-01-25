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
public class Polygon {
    
    private String current="gml:Polygon";
    private String subparent;
    private String description="gml:description";
    private String descriptionReference="gml:descriptionReference";
    private String identifier="gml:identifier";
    private String metaDataProperty="gml:metaDataProperty.gml:GenericMetaData";
    private String name="gml:name";

    public Polygon(String parent) {
        this.subparent = parent+"."+current;
    }

    public String Description() {
        return subparent+"."+description;
    }

    public String DescriptionReference() {
        return subparent+"."+descriptionReference;
    }

    public String Identifier() {
        return subparent+"."+identifier;
    }

    public String MetaDataProperty() {
        return subparent+"."+metaDataProperty;
    }

    public String Name() {
        return subparent+"."+name;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionReference() {
        return descriptionReference;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getMetaDataProperty() {
        return metaDataProperty;
    }

    public String getName() {
        return name;
    }
    
    
    
}
