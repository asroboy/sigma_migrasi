/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variable.IdentificationInformation;

import variable.ContactInfo;
import variable.VarContentInfo;

/**
 *
 * @author wallet
 */
public class VarCitation extends ContactInfo{
    
    private String title;
    private String alternateTitle;
    private String date;
    private String dateType;
    private String titleCitationIdentifier;
    private String dateCiDateIdentifier;
    private String dateTypeCiDateIdentifier;
    private String code;
    private String lengthTitle;
    private String edition;
    private String otherCitationDetails;
    private String presentationForm;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlternateTitle() {
        return alternateTitle;
    }

    public void setAlternateTitle(String alternateTitle) {
        this.alternateTitle = alternateTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getTitleCitationIdentifier() {
        return titleCitationIdentifier;
    }

    public void setTitleCitationIdentifier(String titleCitationIdentifier) {
        this.titleCitationIdentifier = titleCitationIdentifier;
    }

    public String getDateCiDateIdentifier() {
        return dateCiDateIdentifier;
    }

    public void setDateCiDateIdentifier(String dateCiDateIdentifier) {
        this.dateCiDateIdentifier = dateCiDateIdentifier;
    }

    public String getDateTypeCiDateIdentifier() {
        return dateTypeCiDateIdentifier;
    }

    public void setDateTypeCiDateIdentifier(String dateTypeCiDateIdentifier) {
        this.dateTypeCiDateIdentifier = dateTypeCiDateIdentifier;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLengthTitle() {
        return lengthTitle;
    }

    public void setLengthTitle(String lengthTitle) {
        this.lengthTitle = lengthTitle;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getOtherCitationDetails() {
        return otherCitationDetails;
    }

    public void setOtherCitationDetails(String otherCitationDetails) {
        this.otherCitationDetails = otherCitationDetails;
    }

    public String getPresentationForm() {
        return presentationForm;
    }

    public void setPresentationForm(String presentationForm) {
        this.presentationForm = presentationForm;
    }
    
}
