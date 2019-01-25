/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdScopeDescAttributesInst;
import model.table.MdScopeDescAttributesInstModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdScopeDescAttributesInstController {

    HibernateUtilXml hibernateUtilXml;

    public MdScopeDescAttributesInstController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdScopeDescAttributesInst(MdScopeDescAttributesInstModel mdModel) {
        MdScopeDescAttributesInst MdScopeDescAttributesInst = new MdScopeDescAttributesInst();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdScopeDescAttributesInst.setMdScopeDescriptionId(mdModel.getMdScopeDescriptionId());
            MdScopeDescAttributesInst.setAttributesInstances(mdModel.getAttributesInstances());

            session.save(MdScopeDescAttributesInst);
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
