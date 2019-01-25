/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdDataIdentificationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdDataIdentificationController {

    HibernateUtilXml hibernateUtilXml;
    Session session;
    
    public MdDataIdentificationController() {
    }

    public MdDataIdentificationController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdDataIdentificationId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdDataIdentification.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((domain.MdDataIdentification) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();

        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        }
        //session.close();

        return maxId;
    }

    public domain.MdDataIdentification getDataById(BigDecimal Id) {

        domain.MdDataIdentification mdDataIdentification = new domain.MdDataIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdDataIdentification.class);
            criteria.add(Restrictions.eq("id", Id));
            mdDataIdentification = (domain.MdDataIdentification) criteria.uniqueResult();

            if (mdDataIdentification == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdDataIdentification;
    }
    
    public String deletedMdDataIdentification(BigDecimal Id) {

        domain.MdDataIdentification mdDataIdentification = new domain.MdDataIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdDataIdentification.class);
            criteria.add(Restrictions.eq("id", Id));
            mdDataIdentification = (domain.MdDataIdentification) criteria.uniqueResult();

            session.delete(mdDataIdentification);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String saveMdDataIdentification(MdDataIdentificationModel mdDataIdentificationModel) {

        domain.MdDataIdentification mdDataIdentification = new domain.MdDataIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdDataIdentification.setId(mdDataIdentificationModel.getId());
            mdDataIdentification.setEnvironmentDescription(mdDataIdentificationModel.getEnvironmentDescription());
            mdDataIdentification.setSuplementationInformation(mdDataIdentificationModel.getSuplementationInformation());
            mdDataIdentification.setSvServiceIdentificationId(mdDataIdentificationModel.getSvServiceidentificationId());

            //System.out.println(md);
            session.save(mdDataIdentification);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdDataIdentification(BigDecimal id,MdDataIdentificationModel mdModel) {

        domain.MdDataIdentification mdDataIdentification = new domain.MdDataIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdDataIdentification.class);
            criteria.add(Restrictions.eq("id", id));
            mdDataIdentification = (domain.MdDataIdentification) criteria.uniqueResult();

            mdDataIdentification.setEnvironmentDescription(mdModel.getEnvironmentDescription());
            mdDataIdentification.setSuplementationInformation(mdModel.getSuplementationInformation());
            mdDataIdentification.setSvServiceIdentificationId(mdModel.getSvServiceidentificationId());

            session.update(mdDataIdentification);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

}
