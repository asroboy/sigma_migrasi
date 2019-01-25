package model.table;
// Generated Sep 10, 2017 4:17:16 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;

public class CiAddressModel {
    private BigDecimal id;
    private String admnistrativeArea;
    private String city;
    private String country;
    private String postalCode;
    private BigDecimal ciContactId;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAdmnistrativeArea() {
        return admnistrativeArea;
    }

    public void setAdmnistrativeArea(String admnistrativeArea) {
        this.admnistrativeArea = admnistrativeArea;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public BigDecimal getCiContactId() {
        return ciContactId;
    }

    public void setCiContactId(BigDecimal ciContactId) {
        this.ciContactId = ciContactId;
    }

    
}


