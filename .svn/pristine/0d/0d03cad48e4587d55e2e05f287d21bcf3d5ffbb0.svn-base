/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdScopeDescFeature;
import model.table.MdScopeDescFeatureModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdScopeDescFeatureController {

    HibernateUtilXml hibernateUtilXml;

    public MdScopeDescFeatureController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdScopeDescFeature(MdScopeDescFeatureModel mdModel) {
        MdScopeDescFeature MdScopeDescFeature = new MdScopeDescFeature();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdScopeDescFeature.setMdScopeDescriptionId(mdModel.getMdScopeDescriptionId());
            MdScopeDescFeature.setFeatures(mdModel.getFeatures());

            session.save(MdScopeDescFeature);
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
