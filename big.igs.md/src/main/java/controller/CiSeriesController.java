/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiSeries;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiSeriesModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class CiSeriesController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public CiSeriesController() {
    }

    public CiSeriesController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public BigDecimal getMaxCiSeriesId() {
       
        BigDecimal maxId = null;
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(CiSeries.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiSeries) results.get(0)).getId();
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
    
    public CiSeries getDataById(BigDecimal id) {
        CiSeries dq = new CiSeries();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiSeries.class);
            criteria.add(Restrictions.eq("ciCitationId", id));
            dq = (CiSeries) criteria.uniqueResult();

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
    
    public String deletedCiSeries(BigDecimal id) {
        CiSeries cs = new CiSeries();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiSeries.class);
            criteria.add(Restrictions.eq("id", id));
            cs = (CiSeries) criteria.uniqueResult();

            session.delete(cs);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }

    }
   
    public String saveCiSeries(CiSeriesModel mdModel) {
       
        CiSeries cs = new CiSeries();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            cs.setId(mdModel.getId());
            cs.setIssueIdentification(mdModel.getIssueIdentification());
            cs.setName(mdModel.getName());
            cs.setPage(mdModel.getPage());
            cs.setCiCitationId(mdModel.getCiCitationId());
           
            session.save(cs);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateCiSeries(BigDecimal id,CiSeriesModel mdModel) {
        
        CiSeries cs = new CiSeries();
        
        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiSeries.class);
            criteria.add(Restrictions.eq("id",id));
            cs = (CiSeries) criteria.uniqueResult();
            
            cs.setIssueIdentification(mdModel.getIssueIdentification());
            cs.setName(mdModel.getName());
            cs.setPage(mdModel.getPage());
            cs.setCiCitationId(mdModel.getCiCitationId());

            session.update(cs);
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
