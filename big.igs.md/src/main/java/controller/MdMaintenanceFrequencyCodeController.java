/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdMaintenanceFrequencyCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdMaintenanceFrequencyCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMaintenanceFrequencyCodeController {

    public MdMaintenanceFrequencyCodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMaintenanceFrequencyCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public long getMaxMdMaintenanceFrequencyCodeId() {
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

            Criteria criteria = session.createCriteria(MdMaintenanceFrequencyCode.class);
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

    public MdMaintenanceFrequencyCode getDataByDomain(String domainName) {

        MdMaintenanceFrequencyCode maintenanceFrequencyCode = new MdMaintenanceFrequencyCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMaintenanceFrequencyCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            maintenanceFrequencyCode = (MdMaintenanceFrequencyCode) criteria.uniqueResult();

            if (maintenanceFrequencyCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return maintenanceFrequencyCode;
    }

    public String saveMdMaintenanceFrequencyCode(MdMaintenanceFrequencyCodeModel mdModel) {
        MdMaintenanceFrequencyCode MdMaintenanceFrequencyCode = new MdMaintenanceFrequencyCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMaintenanceFrequencyCode.setCode(mdModel.getCode());
            MdMaintenanceFrequencyCode.setDefinition(mdModel.getDefinition());
            MdMaintenanceFrequencyCode.setDomainName(mdModel.getDomainName());

            session.save(MdMaintenanceFrequencyCode);
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
