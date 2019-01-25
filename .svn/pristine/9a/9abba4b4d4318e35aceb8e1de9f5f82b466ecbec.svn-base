/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqCompComm;
import domain.DqCompleteness;
import domain.ExGeographicBoundingBox;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqCompCommModel;
import model.table.DqCompletenessModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqCompCommController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqCompCommController() {
    }

    public DqCompCommController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public BigDecimal getMaxDqCompCommId() {
       
        BigDecimal maxId = null;
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqCompComm.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqCompComm) results.get(0)).getId();
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
    
    public DqCompComm getDataById(BigDecimal id) {
        DqCompComm dqCompComm = new DqCompComm();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqCompComm.class);
            criteria.add(Restrictions.eq("dqCompletenessId", id));
            dqCompComm = (DqCompComm) criteria.uniqueResult();

            if (dqCompComm == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dqCompComm;
    }
    
    public String deletedDqCompComm(BigDecimal id) {
        DqCompComm dqCompComm = new DqCompComm();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqCompComm.class);
            criteria.add(Restrictions.eq("id", id));
            dqCompComm = (DqCompComm) criteria.uniqueResult();

            session.delete(dqCompComm);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqCompComm(DqCompCommModel mdModel) {
       
        DqCompComm dqCompComm = new DqCompComm();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dqCompComm.setId(mdModel.getId());
            dqCompComm.setDqCompletenessId(mdModel.getDqCompletenessId());
            dqCompComm.setDqDataQualityId(mdModel.getDqDataQualityId());
            
            session.save(dqCompComm);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqCompComm(BigDecimal id,DqCompCommModel mdModel) {
        
        DqCompComm dqCompComm = new DqCompComm();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqCompComm.class);
            criteria.add(Restrictions.eq("id", id));
            dqCompComm = (DqCompComm) criteria.uniqueResult();

            dqCompComm.setDqDataQualityId(mdModel.getDqDataQualityId());
            dqCompComm.setDqCompletenessId(mdModel.getDqCompletenessId());

            session.update(dqCompComm);
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
