/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.DsAssociationTypeCode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DsAssociationTypeCodeController {

    public DsAssociationTypeCodeController() {

    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public DsAssociationTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public DsAssociationTypeCode getDataByDomain(String domainName) {

        DsAssociationTypeCode dsAssociationTypeCode = new DsAssociationTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DsAssociationTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            dsAssociationTypeCode = (DsAssociationTypeCode) criteria.uniqueResult();

            if (dsAssociationTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return dsAssociationTypeCode;
    }

}
