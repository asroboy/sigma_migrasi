/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdScopeDescAttributes;
import model.table.MdScopeDescAttributesModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdScopeDescAttributesController {

    HibernateUtilXml hibernateUtilXml;

    public MdScopeDescAttributesController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdScopeDescAttributes(MdScopeDescAttributesModel mdModel) {
        MdScopeDescAttributes MdScopeDescAttributes = new MdScopeDescAttributes();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdScopeDescAttributes.setMdScopeDescriptionId(mdModel.getMdScopeDescriptionId());
            MdScopeDescAttributes.setAttributes(mdModel.getAttributes());

            session.save(MdScopeDescAttributes);
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
