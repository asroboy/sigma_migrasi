/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.metadataentitysetinformation;

/**
 *
 * @author wallet
 */

public class CiAddress {
    
    private String subParent;
    private String current="gmd:CI_Address";
    private String deliveryPoint="gmd:deliveryPoint.gco:CharacterString";
    private String city="gmd:city.gco:CharacterString";
    private String administrativeArea="gmd:administrativeArea.gco:CharacterString";
    private String postalCode="gmd:postalCode.gco:CharacterString";
    private String country="gmd:country.gco:CharacterString";
    private String electronicMailAddress="gmd:electronicMailAddress.gco:CharacterString";

    public CiAddress(String parent) {
        
        subParent= parent+"."+current;
    }    

    public String City() {
        return subParent+"."+city;
    }

    public String AdministrativeArea() {
        return subParent+"."+administrativeArea;
    }

    public String PostalCode() {
        return subParent+"."+postalCode;
    }

    public String Country() {
        return subParent+"."+country;
    }

    public String ElectronicMailAddress() {
        return subParent+"."+electronicMailAddress;
    }

    public String DeliveryPoint() {
        return subParent+"."+deliveryPoint;
    }
}
