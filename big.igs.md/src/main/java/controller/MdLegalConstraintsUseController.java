/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdLegalConstraintsUse;
import model.table.MdLegalConstraintsUseModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdLegalConstraintsUseController {

    HibernateUtilXml hibernateUtilXml;

    public MdLegalConstraintsUseController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdLegalConstraintsUse(MdLegalConstraintsUseModel mdModel) {
        MdLegalConstraintsUse MdLegalConstraintsUse = new MdLegalConstraintsUse();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdLegalConstraintsUse.setMdLegalConstraintsId(mdModel.getMdLegalConstraintsId());
            MdLegalConstraintsUse.setUseConstraints(mdModel.getUseConstraints());

            session.save(MdLegalConstraintsUse);
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
