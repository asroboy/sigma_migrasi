/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.LiLineage;
import domain.LiProcessStep;
import java.math.BigDecimal;
import java.util.List;
import model.table.LiLineageModel;
import model.table.LiProcessStepModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class LiProcessStepController {

    Session session;
    HibernateUtilXml hibernateUtilXml;
    
    public LiProcessStepController() {
    }

    public LiProcessStepController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
 
    public BigDecimal getMaxLiProcessStepId() {
        BigDecimal maxId = null;
       
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
       
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiProcessStep.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((LiProcessStep) results.get(0)).getId();
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
    
    public LiProcessStep getDataById(String column,BigDecimal id) {
        LiProcessStep liProcessStep = new LiProcessStep();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiProcessStep.class);
            criteria.add(Restrictions.eq(column, id));
            liProcessStep = (LiProcessStep) criteria.uniqueResult();

            if (liProcessStep == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return liProcessStep;
    }
    
    public String deletedLiProcessStep(BigDecimal id) {
        LiProcessStep liProcessStep = new LiProcessStep();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiProcessStep.class);
            criteria.add(Restrictions.eq("id", id));
            liProcessStep = (LiProcessStep) criteria.uniqueResult();

            session.delete(liProcessStep);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    
    public String saveLiProcessStep(LiProcessStepModel liProcessStepModel) {
        
        LiProcessStep liProcessStep = new LiProcessStep();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }
            
            liProcessStep.setId(liProcessStepModel.getId());
            liProcessStep.setDateTime(liProcessStepModel.getDateTime());
            liProcessStep.setDescription(liProcessStepModel.getDescription());
            liProcessStep.setRationale(liProcessStepModel.getRationale());
            liProcessStep.setLiLineageId(liProcessStepModel.getLiLineageId());
            liProcessStep.setLiSourceId(liProcessStepModel.getLiSourceId());

            session.save(liProcessStep);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    
    public String updateLiProcessStep(BigDecimal id,LiProcessStepModel mdModel) {
        
        LiProcessStep liProcessStep = new LiProcessStep();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiProcessStep.class);
            criteria.add(Restrictions.eq("id",id));
            liProcessStep = (LiProcessStep) criteria.uniqueResult();

            liProcessStep.setDateTime(mdModel.getDateTime());
            liProcessStep.setDescription(mdModel.getDescription());
            liProcessStep.setRationale(mdModel.getRationale());
            liProcessStep.setLiLineageId(mdModel.getLiLineageId());
            liProcessStep.setLiSourceId(mdModel.getLiSourceId());

            session.update(liProcessStep);
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
