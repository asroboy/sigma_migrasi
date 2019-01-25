/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.ExGeographicBoundingBox;
import domain.ExTemporalExtent;
import domain.ExVerticalExtent;
import java.math.BigDecimal;
import java.util.List;
import model.table.ExGeographicBoundingBoxModel;
import model.table.ExTemporalExtentModel;
import model.table.ExVerticalExtentModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class ExVerticalExtentController {
    
    private HibernateUtilXml hibernateUtilXml;
    private Session session;
    
    public ExVerticalExtentController() { }
   

    public ExVerticalExtentController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxExVerticalExtentId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExVerticalExtent.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((ExVerticalExtent) results.get(0)).getId();
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

    public ExVerticalExtent getDataById(BigDecimal Id) {

       ExVerticalExtent ExVerticalExtent = new ExVerticalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExVerticalExtent.class);
            criteria.add(Restrictions.eq("exExtentId", Id));
            ExVerticalExtent = (ExVerticalExtent) criteria.uniqueResult();

            if (ExVerticalExtent == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ExVerticalExtent;
    }
    
    public String saveExVerticalExtent(ExVerticalExtentModel extentModel) {

        ExVerticalExtent ExVerticalExtent = new ExVerticalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ExVerticalExtent.setId(extentModel.getId());
            ExVerticalExtent.setMaximumValue(extentModel.getMaximumValue());
            ExVerticalExtent.setMinimumValue(extentModel.getMinimumValue());
            ExVerticalExtent.setVerticalCrs(extentModel.getVerticalCrs());
            ExVerticalExtent.setExExtentId(extentModel.getExExtentId());

            //System.out.println(md);
            session.save(ExVerticalExtent);
            trx.commit();

            return "berhasil disimpan....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateExVerticalExtent(BigDecimal id,ExVerticalExtentModel extentModel) {

        ExVerticalExtent ExVerticalExtent = new ExVerticalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExVerticalExtent.class);
            criteria.add(Restrictions.eq("id", id));
            ExVerticalExtent = (ExVerticalExtent) criteria.uniqueResult();

            ExVerticalExtent.setMaximumValue(extentModel.getMaximumValue());
            ExVerticalExtent.setMinimumValue(extentModel.getMinimumValue());
            ExVerticalExtent.setVerticalCrs(extentModel.getVerticalCrs());
            ExVerticalExtent.setExExtentId(extentModel.getExExtentId());
          
            session.update(ExVerticalExtent);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deletedExVerticalExtent(BigDecimal Id) {

        ExVerticalExtent ete = new ExVerticalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExVerticalExtent.class);
            criteria.add(Restrictions.eq("id", Id));
            ete = (ExVerticalExtent) criteria.uniqueResult();

            session.delete(ete);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {

        }
    }
    
}
