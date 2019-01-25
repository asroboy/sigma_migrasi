package domain;
// Generated Sep 20, 2017 9:23:56 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * MdMetadata generated by hbm2java
 */
public class MdMetadata implements java.io.Serializable {


     private BigDecimal id;
     private String dataseturi;
     private Date datestamp;
     private String fileidentifier;
     private BigDecimal harvestid;
     private String language;
     private String metadatastandardname;
     private String metadatastandardversion;
     private String parentidentifier;
     private String characterset;
     private BigDecimal locale;

    public MdMetadata() {
    }

	
    public MdMetadata(BigDecimal id, Date datestamp, String fileidentifier) {
        this.id = id;
        this.datestamp = datestamp;
        this.fileidentifier = fileidentifier;
    }
    public MdMetadata(BigDecimal id, String dataseturi, Date datestamp, String fileidentifier, BigDecimal harvestid, String language, String metadatastandardname, String metadatastandardversion, String parentidentifier, String characterset, BigDecimal locale) {
       this.id = id;
       this.dataseturi = dataseturi;
       this.datestamp = datestamp;
       this.fileidentifier = fileidentifier;
       this.harvestid = harvestid;
       this.language = language;
       this.metadatastandardname = metadatastandardname;
       this.metadatastandardversion = metadatastandardversion;
       this.parentidentifier = parentidentifier;
       this.characterset = characterset;
       this.locale = locale;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public String getDataseturi() {
        return this.dataseturi;
    }
    
    public void setDataseturi(String dataseturi) {
        this.dataseturi = dataseturi;
    }
    public Date getDatestamp() {
        return this.datestamp;
    }
    
    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }
    public String getFileidentifier() {
        return this.fileidentifier;
    }
    
    public void setFileidentifier(String fileidentifier) {
        this.fileidentifier = fileidentifier;
    }
    public BigDecimal getHarvestid() {
        return this.harvestid;
    }
    
    public void setHarvestid(BigDecimal harvestid) {
        this.harvestid = harvestid;
    }
    public String getLanguage() {
        return this.language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getMetadatastandardname() {
        return this.metadatastandardname;
    }
    
    public void setMetadatastandardname(String metadatastandardname) {
        this.metadatastandardname = metadatastandardname;
    }
    public String getMetadatastandardversion() {
        return this.metadatastandardversion;
    }
    
    public void setMetadatastandardversion(String metadatastandardversion) {
        this.metadatastandardversion = metadatastandardversion;
    }
    public String getParentidentifier() {
        return this.parentidentifier;
    }
    
    public void setParentidentifier(String parentidentifier) {
        this.parentidentifier = parentidentifier;
    }
    public String getCharacterset() {
        return this.characterset;
    }
    
    public void setCharacterset(String characterset) {
        this.characterset = characterset;
    }
    public BigDecimal getLocale() {
        return this.locale;
    }
    
    public void setLocale(BigDecimal locale) {
        this.locale = locale;
    }




}

