/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.CiDateTypeCode;
import domain.CiPresentationFormCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiPresentationFormCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class CiPresentationFormCodeController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public CiPresentationFormCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
    
    public CiPresentationFormCode getDataByDomain(String domainName) {

       CiPresentationFormCode code = new CiPresentationFormCode();
       CiPresentationFormCode cpfc = new CiPresentationFormCode();
       cpfc.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiPresentationFormCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            code = (CiPresentationFormCode) criteria.uniqueResult();

            if (code == null) {
                return cpfc;
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
