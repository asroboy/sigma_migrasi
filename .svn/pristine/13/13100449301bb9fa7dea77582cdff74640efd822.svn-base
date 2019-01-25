/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.SvServiceIdentification;
import java.math.BigDecimal;
import java.util.List;
import model.table.SvServiceIdentificationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class SvServiceIdentificationController {

    public SvServiceIdentificationController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public SvServiceIdentificationController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxSvServiceIdentificationId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(SvServiceIdentification.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((SvServiceIdentification) results.get(0)).getId();
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

    public SvServiceIdentification getDataById(BigDecimal Id,String code) {

        SvServiceIdentification svServiceIdentification = new SvServiceIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(SvServiceIdentification.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id))
                    .add(Restrictions.eqOrIsNull("status", code));
            svServiceIdentification = (SvServiceIdentification) criteria.uniqueResult();

            if (svServiceIdentification == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return svServiceIdentification;
    }
    
    public SvServiceIdentification getDataById(BigDecimal Id) {

        SvServiceIdentification svServiceIdentification = new SvServiceIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(SvServiceIdentification.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id));
            svServiceIdentification = (SvServiceIdentification) criteria.uniqueResult();

            if (svServiceIdentification == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return svServiceIdentification;
    }
    
    public String deletedSvServiceIdentification(BigDecimal Id) {

        SvServiceIdentification svServiceIdentification = new SvServiceIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(SvServiceIdentification.class);
            criteria.add(Restrictions.eq("id", Id));
            svServiceIdentification = (SvServiceIdentification) criteria.uniqueResult();

            session.delete(svServiceIdentification);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveSvServiceIdentification(SvServiceIdentificationModel mdModel) {
        SvServiceIdentification SvServiceIdentification = new SvServiceIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            SvServiceIdentification.setId(mdModel.getId());
            SvServiceIdentification.setServiceType(mdModel.getServiceType());
            SvServiceIdentification.setAbstract_(mdModel.getAbstract_());
            SvServiceIdentification.setCredit(mdModel.getCredit());
            SvServiceIdentification.setPurpose(mdModel.getPurpose());
            SvServiceIdentification.setStatus(mdModel.getStatus());
            SvServiceIdentification.setMdIdentificationId(mdModel.getMdIdentificationId());

            session.save(SvServiceIdentification);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateSvServiceIdentification(BigDecimal id,SvServiceIdentificationModel mdModel) {

        SvServiceIdentification svServiceIdentification = new SvServiceIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(SvServiceIdentification.class);
            criteria.add(Restrictions.eq("id", id));
            svServiceIdentification = (SvServiceIdentification) criteria.uniqueResult();

            svServiceIdentification.setServiceType(mdModel.getServiceType());
            svServiceIdentification.setAbstract_(mdModel.getAbstract_());
            svServiceIdentification.setCredit(mdModel.getCredit());
            svServiceIdentification.setPurpose(mdModel.getPurpose());
            svServiceIdentification.setStatus(mdModel.getStatus());
            svServiceIdentification.setMdIdentificationId(mdModel.getMdIdentificationId());

            session.update(svServiceIdentification);
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
