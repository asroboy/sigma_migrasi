/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdCoverageContentTypeCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdCoverageContentTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdCoverageContentTypeCodeController {

    public MdCoverageContentTypeCodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdCoverageContentTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public long getMaxMdCoverageContentTypeCodeId() {
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

            Criteria criteria = session.createCriteria(MdCoverageContentTypeCode.class);
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

    public MdCoverageContentTypeCode getDataByDomain(String domainName) {

        MdCoverageContentTypeCode mdCoverageContentTypeCode = new MdCoverageContentTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdCoverageContentTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            mdCoverageContentTypeCode = (MdCoverageContentTypeCode) criteria.uniqueResult();

            if (mdCoverageContentTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdCoverageContentTypeCode;
    }

    public String saveMdCoverageContentTypeCode(MdCoverageContentTypeCodeModel mdCoverageContentTypeCodeModel) {

        MdCoverageContentTypeCode mdCoverageContentTypeCode = new MdCoverageContentTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdCoverageContentTypeCode.setCode(mdCoverageContentTypeCodeModel.getCode());
            mdCoverageContentTypeCode.setDefinition(mdCoverageContentTypeCodeModel.getDefinition());
            mdCoverageContentTypeCode.setDomainName(mdCoverageContentTypeCodeModel.getDomainName());

            //System.out.println(md);
            session.save(mdCoverageContentTypeCode);
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
