/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variable;

import variable.ContactInfo;

/**
 *
 * @author wallet
 */
public class VarApplicationSchemaInformation extends ContactInfo{
    
    private String schemaLanguage;
    private String constraintLanguage;
    private String schemaAscii;
    private String graphicsFile;
    private String softwareDevelopmentFile;
    private String identifier;
    private String nameSeries;
    private String issueIdentification;
    private String page;

    
    public String getSchemaLanguage() {
        return schemaLanguage;
    }

    public void setSchemaLanguage(String schemaLanguage) {
        this.schemaLanguage = schemaLanguage;
    }

    public String getConstraintLanguage() {
        return constraintLanguage;
    }

    public void setConstraintLanguage(String constraintLanguage) {
        this.constraintLanguage = constraintLanguage;
    }

    public String getSchemaAscii() {
        return schemaAscii;
    }

    public void setSchemaAscii(String schemaAscii) {
        this.schemaAscii = schemaAscii;
    }

    public String getGraphicsFile() {
        return graphicsFile;
    }

    public void setGraphicsFile(String graphicsFile) {
        this.graphicsFile = graphicsFile;
    }

    public String getSoftwareDevelopmentFile() {
        return softwareDevelopmentFile;
    }

    public void setSoftwareDevelopmentFile(String softwareDevelopmentFile) {
        this.softwareDevelopmentFile = softwareDevelopmentFile;
    }

    public String getNameSeries() {
        return nameSeries;
    }

    public void setNameSeries(String nameSeries) {
        this.nameSeries = nameSeries;
    }

    public String getIssueIdentification() {
        return issueIdentification;
    }

    public void setIssueIdentification(String issueIdentification) {
        this.issueIdentification = issueIdentification;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
    
}
