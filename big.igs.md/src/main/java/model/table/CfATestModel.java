/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.math.BigDecimal;
import java.sql.Clob;

/**
 *
 * @author wallet
 */
public class CfATestModel {
    
    private BigDecimal id;
    private Clob DataClob;


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Clob getDataClob() {
        return DataClob;
    }

    public void setDataClob(Clob DataClob) {
        this.DataClob = DataClob;
    }
    
}
