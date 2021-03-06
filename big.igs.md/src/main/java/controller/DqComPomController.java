/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqComPom;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqComPomModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqComPomController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqComPomController() {
    }

    public DqComPomController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
    
    public BigDecimal getMaxDqComPomId() {
       
        BigDecimal maxId = null;
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(DqComPom.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqComPom) results.get(0)).getId();
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
    
    public DqComPom getDataById(BigDecimal id) {
        DqComPom dqCompComm = new DqComPom();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqComPom.class);
            criteria.add(Restrictions.eq("dqCompletenessId", id));
            dqCompComm = (DqComPom) criteria.uniqueResult();

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
    
    public String deletedDqComPom(BigDecimal id) {
        DqComPom dqCompComm = new DqComPom();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqComPom.class);
            criteria.add(Restrictions.eq("id", id));
            dqCompComm = (DqComPom) criteria.uniqueResult();

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
    
    public String saveDqComPom(DqComPomModel mdModel) {
       
        DqComPom dqCompComm = new DqComPom();
        
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

    public String updateDqComPom(BigDecimal id,DqComPomModel mdModel) {
        
        DqComPom dqCompComm = new DqComPom();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqComPom.class);
            criteria.add(Restrictions.eq("id", id));
            dqCompComm = (DqComPom) criteria.uniqueResult();

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
