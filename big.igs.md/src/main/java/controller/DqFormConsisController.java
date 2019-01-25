/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqFormConsis;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqFormConsisModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqFormConsisController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqFormConsisController() {
    }

    public DqFormConsisController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public BigDecimal getMaxDqFormConsisId() {
       
        BigDecimal maxId = null;
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqFormConsis.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqFormConsis) results.get(0)).getId();
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
    
    public DqFormConsis getDataById(BigDecimal id) {
        DqFormConsis dq = new DqFormConsis();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqFormConsis.class);
            criteria.add(Restrictions.eq("dqLogicalConsistencyId", id));
            dq = (DqFormConsis) criteria.uniqueResult();

            if (dq == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dq;
    }
    
    public String deletedDqFormConsis(BigDecimal id) {
        DqFormConsis dq = new DqFormConsis();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqFormConsis.class);
            criteria.add(Restrictions.eq("id", id));
            dq = (DqFormConsis) criteria.uniqueResult();

            session.delete(dq);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqFormConsis(DqFormConsisModel mdModel) {
       
        DqFormConsis dq = new DqFormConsis();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dq.setId(mdModel.getId());
            dq.setDqDataQualityId(mdModel.getDqDataQualityId());
            dq.setDqLogicalConsistencyId(mdModel.getDqLogicalConsistencyId());
            
            session.save(dq);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqFormConsis(BigDecimal id,DqFormConsisModel mdModel) {
        
        DqFormConsis dq = new DqFormConsis();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqFormConsis.class);
            criteria.add(Restrictions.eq("id", id));
            dq = (DqFormConsis) criteria.uniqueResult();

            dq.setDqDataQualityId(mdModel.getDqDataQualityId());
            dq.setDqLogicalConsistencyId(mdModel.getDqLogicalConsistencyId());

            session.update(dq);
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
