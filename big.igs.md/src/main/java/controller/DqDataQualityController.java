/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqDataQuality;
import java.math.BigDecimal;
import java.util.List;
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
public class DqDataQualityController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public DqDataQualityController() {
    }

    public DqDataQualityController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
            
    public BigDecimal getMaxDqDataQualityId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
       
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqDataQuality.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((DqDataQuality) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();

        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        }
//        session.close();
        return maxId;
    }
    

    public DqDataQuality getDataById(BigDecimal idmetadata) {
        DqDataQuality md = new DqDataQuality();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqDataQuality.class);
            criteria.add(Restrictions.eq("mdMetadataId", idmetadata));
            md = (DqDataQuality) criteria.uniqueResult();

            if (md == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
//            session.close();
        }

        return md;
    }
    
    public String deletedDqDataQuality(BigDecimal id) {
        DqDataQuality md = new DqDataQuality();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqDataQuality.class);
            criteria.add(Restrictions.eq("id", id));
            md = (DqDataQuality) criteria.uniqueResult();

            session.delete(md);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
//            session.close();
        }
    }

    public String saveDqDataQuality(DqDataQualityModel mdModel) {
       
        DqDataQuality dqDataQuality = new DqDataQuality();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dqDataQuality.setId(mdModel.getId());
            dqDataQuality.setMdMetadataId(mdModel.getMdMetadataId());
            
            //System.out.println(md);
            session.save(dqDataQuality);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqDataQuality(BigDecimal id,DqDataQualityModel mdModel) {
        
        DqDataQuality dqDataQuality = new DqDataQuality();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqDataQuality.class);
            criteria.add(Restrictions.eq("id", id));
            dqDataQuality = (DqDataQuality) criteria.uniqueResult();

            dqDataQuality.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(dqDataQuality);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
//            session.close();
        }
    }
    
}
