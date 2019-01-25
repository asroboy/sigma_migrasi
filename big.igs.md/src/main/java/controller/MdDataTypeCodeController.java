/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.CiDateTypeCode;
import domain.MdDataTypeCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiDateTypeCodeModel;
import model.table.MdDataTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdDataTypeCodeController {
    
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdDataTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdDataTypeCode getDataByDomain(String domainName) {

        MdDataTypeCode code = new MdDataTypeCode();
        MdDataTypeCode mdtc = new MdDataTypeCode();
        mdtc.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            code = (MdDataTypeCode) criteria.uniqueResult();

            if (code == null) {
                return mdtc;
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
