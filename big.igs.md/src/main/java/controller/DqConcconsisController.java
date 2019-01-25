/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqConcconsis;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqConcconsisModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqConcconsisController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqConcconsisController() {
    }

    public DqConcconsisController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public BigDecimal getMaxDqConcconsisId() {
       
        BigDecimal maxId = null;
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqConcconsis.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqConcconsis) results.get(0)).getId();
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
    
    public DqConcconsis getDataById(BigDecimal id) {
        DqConcconsis dqConcconsis = new DqConcconsis();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqConcconsis.class);
            criteria.add(Restrictions.eq("dqLogicalConsistencyId", id));
            dqConcconsis = (DqConcconsis) criteria.uniqueResult();

            if (dqConcconsis == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dqConcconsis;
    }
    
    public String deletedDqConcconsis(BigDecimal id) {
        DqConcconsis dqConcconsis = new DqConcconsis();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqConcconsis.class);
            criteria.add(Restrictions.eq("id", id));
            dqConcconsis = (DqConcconsis) criteria.uniqueResult();

            session.delete(dqConcconsis);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqConcconsis(DqConcconsisModel mdModel) {
       
        DqConcconsis dqConcconsis = new DqConcconsis();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dqConcconsis.setId(mdModel.getId());
            dqConcconsis.setDqDataQualityId(mdModel.getDqDataQualityId());
            dqConcconsis.setDqLogicalConsistencyId(mdModel.getDqLogicalConsistencyId());
            
            session.save(dqConcconsis);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqConcconsis(BigDecimal id,DqConcconsisModel mdModel) {
        
        DqConcconsis dqConcconsis = new DqConcconsis();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqConcconsis.class);
            criteria.add(Restrictions.eq("id", id));
            dqConcconsis = (DqConcconsis) criteria.uniqueResult();
            
            dqConcconsis.setDqDataQualityId(mdModel.getDqDataQualityId());
            dqConcconsis.setDqLogicalConsistencyId(mdModel.getDqLogicalConsistencyId());

            session.update(dqConcconsis);
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
