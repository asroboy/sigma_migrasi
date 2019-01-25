/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiRoleCode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class CiRoleCodeController {

    public CiRoleCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiRoleCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public CiRoleCode getDataByDomain(String domain) {

        CiRoleCode ciRoleCode = new CiRoleCode();
        CiRoleCode code = new CiRoleCode();
        code.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiRoleCode.class);
            criteria.add(Restrictions.eq("domainName", domain));
            ciRoleCode = (CiRoleCode) criteria.uniqueResult();

            if (ciRoleCode == null) {
                return code;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciRoleCode;
    }
}
