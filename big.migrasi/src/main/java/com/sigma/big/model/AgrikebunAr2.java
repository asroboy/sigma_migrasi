/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ridho
 */
@Entity
@Table(name = "AGRIKEBUN_AR2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgrikebunAr2.findAll", query = "SELECT a FROM AgrikebunAr2 a")
    , @NamedQuery(name = "AgrikebunAr2.findByObjectid", query = "SELECT a FROM AgrikebunAr2 a WHERE a.objectid = :objectid")
    , @NamedQuery(name = "AgrikebunAr2.findByAqdate", query = "SELECT a FROM AgrikebunAr2 a WHERE a.aqdate = :aqdate")
    , @NamedQuery(name = "AgrikebunAr2.findByFcode", query = "SELECT a FROM AgrikebunAr2 a WHERE a.fcode = :fcode")
    , @NamedQuery(name = "AgrikebunAr2.findByKodlco", query = "SELECT a FROM AgrikebunAr2 a WHERE a.kodlco = :kodlco")
    , @NamedQuery(name = "AgrikebunAr2.findByNamobj", query = "SELECT a FROM AgrikebunAr2 a WHERE a.namobj = :namobj")
    , @NamedQuery(name = "AgrikebunAr2.findByPudate", query = "SELECT a FROM AgrikebunAr2 a WHERE a.pudate = :pudate")
    , @NamedQuery(name = "AgrikebunAr2.findByRemark", query = "SELECT a FROM AgrikebunAr2 a WHERE a.remark = :remark")
    , @NamedQuery(name = "AgrikebunAr2.findByShapeArea", query = "SELECT a FROM AgrikebunAr2 a WHERE a.shapeArea = :shapeArea")
    , @NamedQuery(name = "AgrikebunAr2.findByShapeLength", query = "SELECT a FROM AgrikebunAr2 a WHERE a.shapeLength = :shapeLength")
    , @NamedQuery(name = "AgrikebunAr2.findBySrsId", query = "SELECT a FROM AgrikebunAr2 a WHERE a.srsId = :srsId")
    , @NamedQuery(name = "AgrikebunAr2.findByMetadata", query = "SELECT a FROM AgrikebunAr2 a WHERE a.metadata = :metadata")
    , @NamedQuery(name = "AgrikebunAr2.findByDatetime", query = "SELECT a FROM AgrikebunAr2 a WHERE a.datetime = :datetime")
    , @NamedQuery(name = "AgrikebunAr2.findByObjectidOld", query = "SELECT a FROM AgrikebunAr2 a WHERE a.objectidOld = :objectidOld")
    , @NamedQuery(name = "AgrikebunAr2.findByUnsurOld", query = "SELECT a FROM AgrikebunAr2 a WHERE a.unsurOld = :unsurOld")})
public class AgrikebunAr2 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OBJECTID")
    private BigDecimal objectid;
    @Lob
    @Column(name = "SHAPE")
    private Object shape;
    @Column(name = "AQDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aqdate;
    @Size(max = 50)
    @Column(name = "FCODE")
    private String fcode;
    @Size(max = 50)
    @Column(name = "KODLCO")
    private String kodlco;
    @Size(max = 250)
    @Column(name = "NAMOBJ")
    private String namobj;
    @Column(name = "PUDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pudate;
    @Size(max = 250)
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "SHAPE_AREA")
    private Double shapeArea;
    @Column(name = "SHAPE_LENGTH")
    private Double shapeLength;
    @Size(max = 50)
    @Column(name = "SRS_ID")
    private String srsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "METADATA")
    private String metadata;
    @Column(name = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "OBJECTID_OLD")
    private BigInteger objectidOld;
    @Size(max = 30)
    @Column(name = "UNSUR_OLD")
    private String unsurOld;

    public AgrikebunAr2() {
    }

    public AgrikebunAr2(BigDecimal objectid) {
        this.objectid = objectid;
    }

    public AgrikebunAr2(BigDecimal objectid, String metadata) {
        this.objectid = objectid;
        this.metadata = metadata;
    }

    public BigDecimal getObjectid() {
        return objectid;
    }

    public void setObjectid(BigDecimal objectid) {
        this.objectid = objectid;
    }

    public Object getShape() {
        return shape;
    }

    public void setShape(Object shape) {
        this.shape = shape;
    }

    public Date getAqdate() {
        return aqdate;
    }

    public void setAqdate(Date aqdate) {
        this.aqdate = aqdate;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getKodlco() {
        return kodlco;
    }

    public void setKodlco(String kodlco) {
        this.kodlco = kodlco;
    }

    public String getNamobj() {
        return namobj;
    }

    public void setNamobj(String namobj) {
        this.namobj = namobj;
    }

    public Date getPudate() {
        return pudate;
    }

    public void setPudate(Date pudate) {
        this.pudate = pudate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Double getShapeArea() {
        return shapeArea;
    }

    public void setShapeArea(Double shapeArea) {
        this.shapeArea = shapeArea;
    }

    public Double getShapeLength() {
        return shapeLength;
    }

    public void setShapeLength(Double shapeLength) {
        this.shapeLength = shapeLength;
    }

    public String getSrsId() {
        return srsId;
    }

    public void setSrsId(String srsId) {
        this.srsId = srsId;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public BigInteger getObjectidOld() {
        return objectidOld;
    }

    public void setObjectidOld(BigInteger objectidOld) {
        this.objectidOld = objectidOld;
    }

    public String getUnsurOld() {
        return unsurOld;
    }

    public void setUnsurOld(String unsurOld) {
        this.unsurOld = unsurOld;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objectid != null ? objectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgrikebunAr2)) {
            return false;
        }
        AgrikebunAr2 other = (AgrikebunAr2) object;
        if ((this.objectid == null && other.objectid != null) || (this.objectid != null && !this.objectid.equals(other.objectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sigma.big.model.AgrikebunAr2[ objectid=" + objectid + " ]";
    }
    
}
