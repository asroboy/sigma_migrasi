/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variable;

/**
 *
 * @author wallet
 */
public class VarMaintenanceInformation {
    
    private String maintenanceAndUpdateFrequency;
    private String _date;
    private String _dateTime;
    private String tm_PeriodDuration;
    private String tm_Primitive;
    private String dataset;
    private String other;
    private String maintenanceNote;
    private String updateScope;

    public String getMaintenanceAndUpdateFrequency() {
        return maintenanceAndUpdateFrequency;
    }

    public void setMaintenanceAndUpdateFrequency(String maintenanceAndUpdateFrequency) {
        this.maintenanceAndUpdateFrequency = maintenanceAndUpdateFrequency;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String _date) {
        this._date = _date;
    }

    public String getDateTime() {
        return _dateTime;
    }

    public void setDateTime(String _dateTime) {
        this._dateTime = _dateTime;
    }

    public String getTm_PeriodDuration() {
        return tm_PeriodDuration;
    }

    public String getUpdateScope() {
        return updateScope;
    }

    public void setUpdateScope(String updateScope) {
        this.updateScope = updateScope;
    }

    public void setTm_PeriodDuration(String tm_PeriodDuration) {
        this.tm_PeriodDuration = tm_PeriodDuration;
    }

    public String getTm_Primitive() {
        return tm_Primitive;
    }

    public void setTm_Primitive(String tm_Primitive) {
        this.tm_Primitive = tm_Primitive;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getMaintenanceNote() {
        return maintenanceNote;
    }

    public void setMaintenanceNote(String maintenanceNote) {
        this.maintenanceNote = maintenanceNote;
    }
    
}
