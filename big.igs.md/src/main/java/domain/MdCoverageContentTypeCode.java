/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author wallet
 */
public class MdCoverageContentTypeCode implements java.io.Serializable{
    
    private String code;
    private String definition;
    private String domainName;

    public MdCoverageContentTypeCode() {
    }

    public MdCoverageContentTypeCode(String code) {
        this.code = code;
    }

    public MdCoverageContentTypeCode(String code, String definition, String domainName) {
        this.code = code;
        this.definition = definition;
        this.domainName = domainName;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
}
