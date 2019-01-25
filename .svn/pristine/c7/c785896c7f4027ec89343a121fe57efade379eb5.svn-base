/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdCoverageDescription;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdCoverageDescriptionModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdCoverageDescriptionController {

    public MdCoverageDescriptionController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdCoverageDescriptionController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdCoverageDescriptionId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdCoverageDescription.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((domain.MdCoverageDescription) results.get(0)).getId();
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

    public domain.MdCoverageDescription getDataById(BigDecimal mdMaintenanceInfo,String code) {

        domain.MdCoverageDescription mdCoverageDescription = new domain.MdCoverageDescription();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdCoverageDescription.class);
            criteria.add(Restrictions.eq("mdContentInfoId", mdMaintenanceInfo))
                    .add(Restrictions.eqOrIsNull("contentType", code));

            mdCoverageDescription = (domain.MdCoverageDescription) criteria.uniqueResult();

            if (mdCoverageDescription == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdCoverageDescription;
    }
    
    public domain.MdCoverageDescription getDataById(BigDecimal mdMaintenanceInfo) {

        domain.MdCoverageDescription mdCoverageDescription = new domain.MdCoverageDescription();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdCoverageDescription.class);
            criteria.add(Restrictions.eq("mdContentInfoId", mdMaintenanceInfo));

            mdCoverageDescription = (domain.MdCoverageDescription) criteria.uniqueResult();

            if (mdCoverageDescription == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdCoverageDescription;
    }
    
     public String deleteMdCoverageDescription(BigDecimal id) {

        MdCoverageDescription mdCoverageDescription = new MdCoverageDescription();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdCoverageDescription.class);
            criteria.add(Restrictions.eq("id",id));

            mdCoverageDescription = (MdCoverageDescription) criteria.uniqueResult();

            session.delete(mdCoverageDescription);
            trx.commit();
            
            return "berhasil dihapus.....!!";
            
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdCoverageDescription(MdCoverageDescriptionModel mdCoverageDescriptionModel) {

        domain.MdCoverageDescription mdCoverageDescription = new domain.MdCoverageDescription();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdCoverageDescription.setId(mdCoverageDescriptionModel.getId());
            mdCoverageDescription.setContentType(mdCoverageDescriptionModel.getContentType());
            mdCoverageDescription.setAttributeDescription(mdCoverageDescriptionModel.getAttributeDescription());
            mdCoverageDescription.setMdContentInfoId(mdCoverageDescriptionModel.getMdContentInfoId());

            session.save(mdCoverageDescription);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdCoverageDescription(BigDecimal id,MdCoverageDescriptionModel mdModel) {

        MdCoverageDescription mdCoverageDescription = new MdCoverageDescription();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdCoverageDescription.class);
            criteria.add(Restrictions.eq("id", id));

            mdCoverageDescription = (MdCoverageDescription) criteria.uniqueResult();
            
            mdCoverageDescription.setContentType(mdModel.getContentType());
            mdCoverageDescription.setAttributeDescription(mdModel.getAttributeDescription());
            mdCoverageDescription.setMdContentInfoId(mdModel.getMdContentInfoId());

            session.update(mdCoverageDescription);
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
