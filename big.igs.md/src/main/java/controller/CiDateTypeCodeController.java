/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiDateTypeCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiDateTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class CiDateTypeCodeController {

    public CiDateTypeCodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiDateTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public long getMaxCiDateTypeCodeId() {
        long x = 999;
        long maxId = 1;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDateTypeCode.class);
            criteria.add(Restrictions.ne("code", new BigDecimal(x)));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = 1;
            } else {
                maxId = results.size() + 1;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return maxId;
    }

    public CiDateTypeCode getDataByDomain(String domainName) {

        CiDateTypeCode ciDateTypeCode = new CiDateTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDateTypeCode.class);
            criteria.add(Restrictions.eq("domainname", domainName).ignoreCase());
            ciDateTypeCode = (CiDateTypeCode) criteria.uniqueResult();

            if (ciDateTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciDateTypeCode;
    }

    public String saveCiDateTypeCode(CiDateTypeCodeModel mdModel) {
        CiDateTypeCode CiDateTypeCode = new CiDateTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            CiDateTypeCode.setCode(mdModel.getCode());
            CiDateTypeCode.setDefinition(mdModel.getDefinition());
            CiDateTypeCode.setDomainname(mdModel.getDomainname());

            session.save(CiDateTypeCode);
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
