/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdScopecode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class MdScopecodeController {

    public MdScopecodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdScopecodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdScopecode getDataByCode(String DomainName) {

        MdScopecode mdScopecode = new MdScopecode();
        MdScopecode ms = new MdScopecode();
        ms.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            if (DomainName.toLowerCase().equals("feature class")) {
                DomainName = "feature";
            }

            Criteria criteria = session.createCriteria(MdScopecode.class);
            criteria.add(Restrictions.eq("domainname", DomainName).ignoreCase());
            mdScopecode = (MdScopecode) criteria.uniqueResult();

            if (mdScopecode == null) {
                return ms;
            }

            trx.commit();

            //return mdScopecode;
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdScopecode;
    }

}
