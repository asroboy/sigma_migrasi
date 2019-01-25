/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.sql.Clob;

/**
 *
 * @author wallet
 */
public class CfOperationLayerModel {
    
    private String id;
    private String url;
    private String name;
    private String type;
    private BigDecimal number;
    private BigDecimal idCategories;
    private BigDecimal opacity;
    private Clob infoTemplates;
    private String layerDefinitions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getIdCategories() {
        return idCategories;
    }

    public void setIdCategories(BigDecimal idCategories) {
        this.idCategories = idCategories;
    }

    public BigDecimal getOpacity() {
        return opacity;
    }

    public void setOpacity(BigDecimal opacity) {
        this.opacity = opacity;
    }

    public Clob getInfoTemplates() {
        return infoTemplates;
    }

    public void setInfoTemplates(Clob infoTemplates) {
        this.infoTemplates = infoTemplates;
    }

    public String getLayerDefinitions() {
        return layerDefinitions;
    }

    public void setLayerDefinitions(String layerDefinitions) {
        this.layerDefinitions = layerDefinitions;
    }
    
    
}
