/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdGeometricObjectTypeCode;
import model.table.MdGeometricObjectTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdGeometricObjectTypeCodeController {

   public MdGeometricObjectTypeCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdGeometricObjectTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdGeometricObjectTypeCode getDataByDomain(String domainName) {

        MdGeometricObjectTypeCode mdGeometricObjectTypeCode = new MdGeometricObjectTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjectTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName));
            mdGeometricObjectTypeCode = (MdGeometricObjectTypeCode) criteria.uniqueResult();
            
            if (mdGeometricObjectTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdGeometricObjectTypeCode;
    }

    public String saveMdGeometricObjectTypeCode(MdGeometricObjectTypeCodeModel mdModel) {
        MdGeometricObjectTypeCode MdGeometricObjectTypeCode = new MdGeometricObjectTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdGeometricObjectTypeCode.setCode(mdModel.getCode());
            MdGeometricObjectTypeCode.setDefinition(mdModel.getDefinition());
            MdGeometricObjectTypeCode.setDomainName(mdModel.getDomainName());

            session.save(MdGeometricObjectTypeCode);
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
