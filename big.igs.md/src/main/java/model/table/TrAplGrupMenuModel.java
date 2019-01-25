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
public class TrAplGrupMenuModel {
    
    private BigDecimal idMenu;
    private BigDecimal idGrup;
    private BigDecimal idApl;

    public BigDecimal getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(BigDecimal idMenu) {
        this.idMenu = idMenu;
    }

    public BigDecimal getIdGrup() {
        return idGrup;
    }

    public void setIdGrup(BigDecimal idGrup) {
        this.idGrup = idGrup;
    }

    public BigDecimal getIdApl() {
        return idApl;
    }

    public void setIdApl(BigDecimal idApl) {
        this.idApl = idApl;
    }
}
