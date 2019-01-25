/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.big.tools;


import java.sql.Types;
import org.hibernate.dialect.Oracle9Dialect;


public class OracleSpatialDialect extends Oracle9Dialect {

    public OracleSpatialDialect() {
        super();
        registerColumnType(Types.OTHER, "sdo_geometry");
    }
}
