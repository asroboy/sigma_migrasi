package model.table;
// Generated Sep 10, 2017 4:17:16 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

public class MdMetadataModel {
    
    public static final String FILEIDENTIFIER="fileidentifier";
    
    private BigDecimal id;
    private String dataseturi;
    private String stringDate;
    private Date datestamp;
    private String fileidentifier;
    private BigDecimal harvestid;
    private String language;
    private String metadatastandardname;
    private String metadatastandardversion;
    private String parentidentifier;
    private String characterset;
    private BigDecimal locale;
    

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDataseturi() {
        return dataseturi;
    }

    public void setDataseturi(String dataseturi) {
        this.dataseturi = dataseturi;
    }

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }

    public String getFileidentifier() {
        return fileidentifier;
    }

    public void setFileidentifier(String fileidentifier) {
        this.fileidentifier = fileidentifier;
    }

    public BigDecimal getHarvestid() {
        return harvestid;
    }

    public void setHarvestid(BigDecimal harvestid) {
        this.harvestid = harvestid;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMetadatastandardname() {
        return metadatastandardname;
    }

    public void setMetadatastandardname(String metadatastandardname) {
        this.metadatastandardname = metadatastandardname;
    }

    public String getMetadatastandardversion() {
        return metadatastandardversion;
    }

    public void setMetadatastandardversion(String metadatastandardversion) {
        this.metadatastandardversion = metadatastandardversion;
    }

    public String getParentidentifier() {
        return parentidentifier;
    }

    public void setParentidentifier(String parentidentifier) {
        this.parentidentifier = parentidentifier;
    }

    public String getCharacterset() {
        return characterset;
    }

    public void setCharacterset(String characterset) {
        this.characterset = characterset;
    }

    public BigDecimal getLocale() {
        return locale;
    }

    public void setLocale(BigDecimal locale) {
        this.locale = locale;
    }

    public String getStringDate() {
        return stringDate;
    }

    public void setStringDate(String stringDate) {
        this.stringDate = stringDate;
    }
    
}


