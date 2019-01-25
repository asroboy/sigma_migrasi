/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdSpatialRepresentTypeCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdSpatialRepresentTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdSpatialRepresentTypeCodeController {

    public MdSpatialRepresentTypeCodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdSpatialRepresentTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public long getMaxMdSpatialRepresentTypeCodeId() {
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

            Criteria criteria = session.createCriteria(MdSpatialRepresentTypeCode.class);
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

    public MdSpatialRepresentTypeCode getDataByDomain(String domainName) {

        MdSpatialRepresentTypeCode spatialRepresentTypeCode = new MdSpatialRepresentTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSpatialRepresentTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            spatialRepresentTypeCode = (MdSpatialRepresentTypeCode) criteria.uniqueResult();

            if (spatialRepresentTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return spatialRepresentTypeCode;
    }

    public String saveMdSpatialRepresentTypeCode(MdSpatialRepresentTypeCodeModel mdModel) {
        MdSpatialRepresentTypeCode MdSpatialRepresentTypeCode = new MdSpatialRepresentTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdSpatialRepresentTypeCode.setCode(mdModel.getCode());
            MdSpatialRepresentTypeCode.setDefinition(mdModel.getDefinition());
            MdSpatialRepresentTypeCode.setDomainName(mdModel.getDomainName());

            session.save(MdSpatialRepresentTypeCode);
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
