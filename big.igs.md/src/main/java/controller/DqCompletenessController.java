/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqCompleteness;
import domain.DqDataQuality;
import domain.ExGeographicBoundingBox;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqCompletenessModel;
import model.table.DqDataQualityModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqCompletenessController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqCompletenessController() {
    }

    public DqCompletenessController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
     
    public BigDecimal getMaxDqCompletenessId() {
       
        BigDecimal maxId = null;
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqCompleteness.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqCompleteness) results.get(0)).getId();
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
    
    public DqCompleteness getDataById(BigDecimal id) {
        DqCompleteness dqCompleteness = new DqCompleteness();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqCompleteness.class);
            criteria.add(Restrictions.eq("dqDataQualityId", id));
            dqCompleteness = (DqCompleteness) criteria.uniqueResult();

            if (dqCompleteness == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dqCompleteness;
    }
    
    public String deletedDqCompleteness(BigDecimal id) {
        DqCompleteness dqCompleteness = new DqCompleteness();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqCompleteness.class);
            criteria.add(Restrictions.eq("id", id));
            dqCompleteness = (DqCompleteness) criteria.uniqueResult();

            session.delete(dqCompleteness);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqDataQuality(DqCompletenessModel mdModel) {
       
        DqCompleteness dqCompleteness = new DqCompleteness();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dqCompleteness.setId(mdModel.getId());
            dqCompleteness.setDqDataQualityId(mdModel.getDqDataQualityId());
            
            //System.out.println(md);
            session.save(dqCompleteness);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqDataQuality(BigDecimal id,DqCompletenessModel mdModel) {
        
        DqCompleteness dqCompleteness = new DqCompleteness();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqCompleteness.class);
            criteria.add(Restrictions.eq("id", id));
            dqCompleteness = (DqCompleteness) criteria.uniqueResult();

            dqCompleteness.setDqDataQualityId(mdModel.getDqDataQualityId());

            session.update(dqCompleteness);
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
