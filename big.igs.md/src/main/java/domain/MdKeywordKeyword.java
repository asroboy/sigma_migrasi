/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdKeywordKeyword implements java.io.Serializable{
    
    private BigDecimal mdKeywordId;
    private String keyword;

    public MdKeywordKeyword() {
    }

    public MdKeywordKeyword(BigDecimal mdKeywordId) {
        this.mdKeywordId = mdKeywordId;
    }

    public MdKeywordKeyword(BigDecimal mdKeywordId, String keyword) {
        this.mdKeywordId = mdKeywordId;
        this.keyword = keyword;
    }

    public BigDecimal getMdKeywordId() {
        return mdKeywordId;
    }

    public void setMdKeywordId(BigDecimal mdKeywordId) {
        this.mdKeywordId = mdKeywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
   
    
}
