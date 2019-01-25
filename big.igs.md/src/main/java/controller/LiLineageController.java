/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.LiLineage;
import java.math.BigDecimal;
import java.util.List;
import model.table.LiLineageModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class LiLineageController {

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public  LiLineageController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public LiLineageController() {
    }
    
    
   public BigDecimal getMaxLiLineageId() {
        BigDecimal maxId = null;
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
       
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiLineage.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((LiLineage) results.get(0)).getId();
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

    public LiLineage getDataById(BigDecimal id) {
        LiLineage liLineage = new LiLineage();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiLineage.class);
            criteria.add(Restrictions.eq("dqDataQualityId", id));
            liLineage = (LiLineage) criteria.uniqueResult();

            if (liLineage == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return liLineage;
    }
    
    public String deletedLiLineage(BigDecimal id) {
        LiLineage liLineage = new LiLineage();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiLineage.class);
            criteria.add(Restrictions.eq("id", id));
            liLineage = (LiLineage) criteria.uniqueResult();

            session.delete(liLineage);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveLiLineage(LiLineageModel liLineageModel) {
        
        LiLineage liLineage = new LiLineage();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }
            
            liLineage.setId(liLineageModel.getId());
            liLineage.setStatement(liLineage.getStatement());
            liLineage.setDqDataQualityId(liLineageModel.getDqDataQualityId());
            
            //System.out.println(md);
            session.save(liLineage);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String updateLiLineage(BigDecimal id,LiLineageModel mdModel) {
        LiLineage liLineage = new LiLineage();

         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(LiLineage.class);
            criteria.add(Restrictions.eq("id", id));
            liLineage = (LiLineage) criteria.uniqueResult();

            liLineage.setStatement(mdModel.getStatement());
            liLineage.setDqDataQualityId(mdModel.getDqDataQualityId());

            session.update(liLineage);
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