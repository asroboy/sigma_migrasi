/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdCellGeometryCode;
import domain.MdMetadata;
import java.math.BigDecimal;
import java.util.List;
import model.table.IgFeatureCodeModel;
import model.table.MdCellGeometryCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdCellGeometryCodeController {

    HibernateUtilXml hibernateUtilXml;

    public MdCellGeometryCodeController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public long getMaxMdCellGeometryCodeId() {
        long x = 999;
        long maxId = 1;

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdCellGeometryCode.class);
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

    public MdCellGeometryCode getDataByDomain(String domain) {

        MdCellGeometryCode mdCellGeometryCode = new MdCellGeometryCode();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdCellGeometryCode.class);
            criteria.add(Restrictions.eq("domain", domain));
            mdCellGeometryCode = (MdCellGeometryCode) criteria.uniqueResult();

            if (mdCellGeometryCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdCellGeometryCode;
    }

    public String saveMdCellGeometryCode(MdCellGeometryCodeModel mdCellGeometryCodeModel) {

        MdCellGeometryCode mdCellGeometryCode = new MdCellGeometryCode();

        Session session = hibernateUtilXml.buildSession().openSession();
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdCellGeometryCode.setCode(mdCellGeometryCodeModel.getCode());
            mdCellGeometryCode.setDefinition(mdCellGeometryCodeModel.getDefinition());
            mdCellGeometryCode.setDomainName(mdCellGeometryCodeModel.getDomainName());

            //System.out.println(md);
            session.save(mdCellGeometryCode);
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
