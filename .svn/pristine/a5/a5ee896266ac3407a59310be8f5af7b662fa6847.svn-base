/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqLogicalConsistency;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqLogicalConsistencyModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqLogicalConsistencyController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqLogicalConsistencyController() {
    }

    public DqLogicalConsistencyController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public BigDecimal getMaxDqLogicalConsitencyId() {
       
        BigDecimal maxId = null;
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqLogicalConsistency.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqLogicalConsistency) results.get(0)).getId();
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
    
    public DqLogicalConsistency getDataById(BigDecimal id) {
        DqLogicalConsistency dqLogicalConsistency = new DqLogicalConsistency();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqLogicalConsistency.class);
            criteria.add(Restrictions.eq("dqDataQualityId", id));
            dqLogicalConsistency = (DqLogicalConsistency) criteria.uniqueResult();

            if (dqLogicalConsistency == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dqLogicalConsistency;
    }
    
    public String deletedDqLogicalConsistency(BigDecimal id) {
        DqLogicalConsistency dqLogicalConsistency = new DqLogicalConsistency();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqLogicalConsistency.class);
            criteria.add(Restrictions.eq("id", id));
            dqLogicalConsistency = (DqLogicalConsistency) criteria.uniqueResult();

            session.delete(dqLogicalConsistency);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqLogicalConsitency(DqLogicalConsistencyModel mdModel) {
       
        DqLogicalConsistency dqLogicalConsistency = new DqLogicalConsistency();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dqLogicalConsistency.setId(mdModel.getId());
            dqLogicalConsistency.setDqDataQualityId(mdModel.getDqDataQualityId());
            
            session.save(dqLogicalConsistency);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqLogicalConsitency(BigDecimal id,DqLogicalConsistencyModel mdModel) {
        
        DqLogicalConsistency dqLogicalConsistency = new DqLogicalConsistency();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqLogicalConsistency.class);
            criteria.add(Restrictions.eq("id",id));
            dqLogicalConsistency = (DqLogicalConsistency) criteria.uniqueResult();

            dqLogicalConsistency.setDqDataQualityId(mdModel.getDqDataQualityId());

            session.update(dqLogicalConsistency);
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
