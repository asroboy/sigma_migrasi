/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.utils;

import java.sql.Date;

/**
 *
 * @author Ridho
 */
public class DataValidator {

    public boolean isBeforeDate(Date date1, Date date2) {
        return date1.before(date2);
    }

    public boolean isOverValueLength(String data, int maxLength) {
        return data.length() <= maxLength;
    }

    public boolean isNull(Object data) {
        return data == null;
    }

    public boolean isEmpty(String data) {
        return data.length() == 0 ;
    }

    public boolean isZero(int data) {
        return data == 0;
    }
    
    public boolean isSameType(String typeName1, String typeName2){
        return typeName1.equals(typeName2);
    }
    
    public boolean isSameSize(int sizeA, int sizeB){
        return sizeA == sizeB;
    }
}
