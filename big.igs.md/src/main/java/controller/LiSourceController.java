/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.LiProcessStep;
import domain.LiSource;
import java.math.BigDecimal;
import java.util.List;
import model.table.LiProcessStepModel;
import model.table.LiSourceModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class LiSourceController {

    Session session;
    HibernateUtilXml hibernateUtilXml;
    
    public LiSourceController() {
    }

    public LiSourceController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
    
    public BigDecimal getMaxLiSourceId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
       
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiSource.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((LiSource) results.get(0)).getId();
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
    
    
    public LiSource getDataById(String column,BigDecimal id) {
        LiSource liSource = new LiSource();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiSource.class);
            criteria.add(Restrictions.eq(column, id));
            liSource = (LiSource) criteria.uniqueResult();

            if (liSource == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return liSource;
    }
    
    public String deletedLiSource(BigDecimal id) {
        LiSource liSource = new LiSource();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiSource.class);
            criteria.add(Restrictions.eq("id", id));
            liSource = (LiSource) criteria.uniqueResult();

            session.delete(liSource);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    
    public String saveLiSource(LiSourceModel liSourceModel) {
        
        LiSource liSource = new LiSource();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }
            
            liSource.setId(liSourceModel.getId());
            liSource.setDescription(liSourceModel.getDescription());
            liSource.setLiLineageId(liSourceModel.getLiLineageId());
            liSource.setLiProcessStepId(liSourceModel.getLiProcessStepId());
            
            //System.out.println(md);
            session.save(liSource);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    
    public String updateLiSource(BigDecimal id,LiSourceModel mdModel) {
        LiSource liSource = new LiSource();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiSource.class);
            criteria.add(Restrictions.eq("id", id));
            liSource = (LiSource) criteria.uniqueResult();
            
            liSource.setDescription(mdModel.getDescription());
            liSource.setLiLineageId(mdModel.getLiLineageId());
            liSource.setLiProcessStepId(mdModel.getLiProcessStepId());

            session.update(liSource);
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
