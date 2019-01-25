/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;

/**
 *
 * @author wallet
 */
public class MdDataIdentificationTopcatModel {
    
    private BigDecimal mdDataIdentificationId;
    private String topicCategory;

    public BigDecimal getMdDataIdentificationId() {
        return mdDataIdentificationId;
    }

    public void setMdDataIdentificationId(BigDecimal mdDataIdentificationId) {
        this.mdDataIdentificationId = mdDataIdentificationId;
    }

    public String getTopicCategory() {
        return topicCategory;
    }

    public void setTopicCategory(String topicCategory) {
        this.topicCategory = topicCategory;
    }
   
}
