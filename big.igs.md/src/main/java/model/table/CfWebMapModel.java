/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.sql.Clob;
import java.util.Date;

/**
 *
 * @author wallet
 */
public class CfWebMapModel {
    
    private String id;
    private String webMapName;
    private BigDecimal spatialRef;
    private String baseMap;
    private String GroupShared;
    private String summary;
    private String username;
    private Date createDate;
    private Date lastUpdated;
    private BigDecimal xMin;
    private BigDecimal xMax;
    private BigDecimal yMin;
    private BigDecimal yMax;
    private Clob featureCollection;
    private Clob bookmarks;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebMapName() {
        return webMapName;
    }

    public void setWebMapName(String webMapName) {
        this.webMapName = webMapName;
    }

    public BigDecimal getSpatialRef() {
        return spatialRef;
    }

    public void setSpatialRef(BigDecimal spatialRef) {
        this.spatialRef = spatialRef;
    }

    public String getBaseMap() {
        return baseMap;
    }

    public void setBaseMap(String baseMap) {
        this.baseMap = baseMap;
    }

    public String getGroupShared() {
        return GroupShared;
    }

    public void setGroupShared(String GroupShared) {
        this.GroupShared = GroupShared;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public BigDecimal getxMin() {
        return xMin;
    }

    public void setxMin(BigDecimal xMin) {
        this.xMin = xMin;
    }

    public BigDecimal getxMax() {
        return xMax;
    }

    public void setxMax(BigDecimal xMax) {
        this.xMax = xMax;
    }

    public BigDecimal getyMin() {
        return yMin;
    }

    public void setyMin(BigDecimal yMin) {
        this.yMin = yMin;
    }

    public BigDecimal getyMax() {
        return yMax;
    }

    public void setyMax(BigDecimal yMax) {
        this.yMax = yMax;
    }

    public Clob getFeatureCollection() {
        return featureCollection;
    }

    public void setFeatureCollection(Clob featureCollection) {
        this.featureCollection = featureCollection;
    }

    public Clob getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Clob bookmarks) {
        this.bookmarks = bookmarks;
    }
      
}
