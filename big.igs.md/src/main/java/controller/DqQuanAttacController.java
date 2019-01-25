/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqQuanAttac;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqQuanAttacModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqQuanAttacController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqQuanAttacController() {
    }

    public DqQuanAttacController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public BigDecimal getMaxDqQuanAttacId() {
       
        BigDecimal maxId = null;
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqQuanAttac.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqQuanAttac) results.get(0)).getId();
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
    
    public DqQuanAttac getDataById(BigDecimal id) {
        DqQuanAttac dq = new DqQuanAttac();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqQuanAttac.class);
            criteria.add(Restrictions.eq("dqThematicAccuracyId", id));
            dq = (DqQuanAttac) criteria.uniqueResult();

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
    
    public String deletedDqQuanAttac(BigDecimal id) {
        DqQuanAttac dq = new DqQuanAttac();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqQuanAttac.class);
            criteria.add(Restrictions.eq("id", id));
            dq = (DqQuanAttac) criteria.uniqueResult();

            session.delete(dq);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqQuanAttac(DqQuanAttacModel mdModel) {
       
        DqQuanAttac dq = new DqQuanAttac();
        
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
            dq.setDqThematicAccuracyId(mdModel.getDqThematicAccuracyId());
            
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

    public String updateDqQuanAttac(BigDecimal id,DqQuanAttacModel mdModel) {
        
        DqQuanAttac dq = new DqQuanAttac();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqQuanAttac.class);
            criteria.add(Restrictions.eq("id", id));
            dq = (DqQuanAttac) criteria.uniqueResult();

            dq.setDqDataQualityId(mdModel.getDqDataQualityId());
            dq.setDqThematicAccuracyId(mdModel.getDqThematicAccuracyId());

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
