/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.DsInitiativeTypeCode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DsInitiativeTypeCodeController {

    public DsInitiativeTypeCodeController() {

    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public DsInitiativeTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public DsInitiativeTypeCode getDataByDomain(String domainName) {

        DsInitiativeTypeCode dsInitiativeTypeCode = new DsInitiativeTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DsInitiativeTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            dsInitiativeTypeCode = (DsInitiativeTypeCode) criteria.uniqueResult();

            if (dsInitiativeTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return dsInitiativeTypeCode;
    }
}
