/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdScopeDescFeatureInst;
import model.table.MdScopeDescFeatureInstModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdScopeDescFeatureInstController {

    HibernateUtilXml hibernateUtilXml;

    public MdScopeDescFeatureInstController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdScopeDescFeatureInst(MdScopeDescFeatureInstModel mdModel) {
        MdScopeDescFeatureInst MdScopeDescFeatureInst = new MdScopeDescFeatureInst();

        Session session = hibernateUtilXml.buildSession().openSession();
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdScopeDescFeatureInst.setMdScopeDescriptionId(mdModel.getMdScopeDescriptionId());
            MdScopeDescFeatureInst.setFeatureInstances(mdModel.getFeatureInstances());

            session.save(MdScopeDescFeatureInst);
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
