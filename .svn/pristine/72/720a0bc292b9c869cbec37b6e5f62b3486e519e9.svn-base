/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqEvaluationMethodTypeCode;
import domain.MdCharacterSetCode;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqEvaluationMethodTypeCodeController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqEvaluationMethodTypeCodeController() {
    }

    public DqEvaluationMethodTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public DqEvaluationMethodTypeCode getDataByDomain(String domain) {
        DqEvaluationMethodTypeCode code = new DqEvaluationMethodTypeCode();

         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqEvaluationMethodTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domain).ignoreCase());
            code = (DqEvaluationMethodTypeCode) criteria.uniqueResult();

            if (code == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return code;
    }
}
