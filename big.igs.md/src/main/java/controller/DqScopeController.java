/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqScope;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqScopeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqScopeController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqScopeController() {
    }

    public DqScopeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
       
    public BigDecimal getMaxScopeId() {
       
        BigDecimal maxId = null;
       
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
       
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqScope.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqScope) results.get(0)).getId();
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
    

    public DqScope getDataById(BigDecimal iddataquality) {
        DqScope dqScope = new DqScope();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqScope.class);
            criteria.add(Restrictions.eq("dqDataQualityId", iddataquality));
            dqScope = (DqScope) criteria.uniqueResult();

            if (dqScope == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dqScope;
    }
    
    public String deletedDqScope(BigDecimal id) {
        DqScope dqScope = new DqScope();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqScope.class);
            criteria.add(Restrictions.eq("id", id));
            dqScope = (DqScope) criteria.uniqueResult();

            session.delete(dqScope);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String saveDqScope(DqScopeModel mdModel) {
        DqScope dqScope = new DqScope();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dqScope.setId(mdModel.getId());
            dqScope.setDqLevel(mdModel.getDqLevel());
            dqScope.setDqDataQualityId(mdModel.getDqDataQualityId());
            
            //System.out.println(md);
            session.save(dqScope);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqScope(BigDecimal id,DqScopeModel mdModel) {
        DqScope dqScope = new DqScope();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqScope.class);
            criteria.add(Restrictions.eq("id", id));
            dqScope = (DqScope) criteria.uniqueResult();

            dqScope.setDqLevel(mdModel.getDqLevel());

            session.update(dqScope);
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
