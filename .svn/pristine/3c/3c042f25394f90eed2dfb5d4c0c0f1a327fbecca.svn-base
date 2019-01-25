/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqConformanceResult;
import java.math.BigDecimal;
import model.table.DqConformanceResultModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqConformanceResultController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqConformanceResultController() {
    }

    public DqConformanceResultController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
    
    public DqConformanceResult getDataById(BigDecimal id) {
        DqConformanceResult dq = new DqConformanceResult();
                
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqConformanceResult.class);
            criteria.add(Restrictions.eq("dqResultId", id));
            dq = (DqConformanceResult) criteria.uniqueResult();

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
    
    public String deletedDqConformanceResult(BigDecimal id) {
        DqConformanceResult dq = new DqConformanceResult();
                
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqConformanceResult.class);
            criteria.add(Restrictions.eq("dqResultId", id));
            dq = (DqConformanceResult) criteria.uniqueResult();

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
    
    public String saveDqConformanceResult(DqConformanceResultModel mdModel) {
       
        DqConformanceResult dq = new DqConformanceResult();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dq.setDqResultId(mdModel.getDqResultId());
            dq.setExplanation(mdModel.getExplanation());
            dq.setPass(mdModel.getPass());
                        
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

    public String updateDqConformanceResult(DqConformanceResultModel mdModel) {
        
        DqConformanceResult dq = new DqConformanceResult();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqConformanceResult.class);
            criteria.add(Restrictions.eq("dqResultId", mdModel.getDqResultId()));
            dq = (DqConformanceResult) criteria.uniqueResult();

            dq.setExplanation(mdModel.getExplanation());
            dq.setPass(mdModel.getPass());

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
