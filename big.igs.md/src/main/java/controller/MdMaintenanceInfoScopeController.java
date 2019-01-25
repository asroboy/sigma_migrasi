/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdMaintenanceInfoScope;
import model.table.MdMaintenanceInfoScopeModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMaintenanceInfoScopeController {

    HibernateUtilXml hibernateUtilXml;

    public MdMaintenanceInfoScopeController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdMaintenanceInfoScope(MdMaintenanceInfoScopeModel mdModel) {
        MdMaintenanceInfoScope MdMaintenanceInfoScope = new MdMaintenanceInfoScope();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMaintenanceInfoScope.setMdMaintenanceInfoId(mdModel.getMdMaintenanceInfoId());
            MdMaintenanceInfoScope.setUpdateScope(mdModel.getUpdateScope());

            session.save(MdMaintenanceInfoScope);
            trx.commit();

            return "saved successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return e.getMessage();
        } finally {
            //session.close();
        }
    }
}
