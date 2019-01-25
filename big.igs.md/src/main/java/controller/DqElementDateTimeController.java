/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqElementDateTime;
import java.math.BigDecimal;
import model.table.DqElementDateTimeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqElementDateTimeController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;
    
    private DqElementController dqElementController = new DqElementController();
    private String truthName;        

    public DqElementDateTimeController() {
    }

    public DqElementDateTimeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
    
    public DqElementDateTime getDataById(BigDecimal id) {
        DqElementDateTime dq = new DqElementDateTime();
                
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqElementDateTime.class);
            criteria.add(Restrictions.eq("dqElementId", id));
            dq = (DqElementDateTime) criteria.uniqueResult();

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
    
    public String deletedDqElementDateTime(BigDecimal id) {
        DqElementDateTime dq = new DqElementDateTime();
                
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqElementDateTime.class);
            criteria.add(Restrictions.eq("dqElementId", id));
            dq = (DqElementDateTime) criteria.uniqueResult();

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
    
    public String saveDqElementDateTime(DqElementDateTimeModel mdModel) {
       
        DqElementDateTime dq = new DqElementDateTime();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dq.setDqElementId(mdModel.getDqElementId());
            dq.setDateTime(mdModel.getDateTime());
            dq.setDqAbsExtPosAccId(mdModel.getDqAbsExtPosAccId());
            dq.setDqAccTimeMeAsId(mdModel.getDqAccTimeMeAsId());
            dq.setDqCompCommId(mdModel.getDqCompCommId());
            dq.setDqCompOmId(mdModel.getDqCompOmId());
            dq.setDqConcConsisId(mdModel.getDqConcConsisId());
            dq.setDqDomConsisId(mdModel.getDqDomConsisId());
            dq.setDqFormConsisId(mdModel.getDqFormConsisId());
            dq.setDqGridDataPosAccId(mdModel.getDqGridDataPosAccId());
            dq.setDqNonQuanAttaccId(mdModel.getDqNonQuanAttaccId());
            dq.setDqQuanAttaccId(mdModel.getDqQuanAttaccId());
            dq.setDqRellNtPosAccId(mdModel.getDqRellNtPosAccId());
            dq.setDqTempConsisId(mdModel.getDqTempConsisId());
            dq.setDqTempValidId(mdModel.getDqTempValidId());
            dq.setDqThemClassCorId(dq.getDqThemClassCorId());
            dq.setDqTopConsisId(mdModel.getDqTopConsisId());
            
            
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

    public String updateDqElementDateTime(DqElementDateTimeModel mdModel) {
        
        DqElementDateTime dq = new DqElementDateTime();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqElementDateTime.class);
            criteria.add(Restrictions.eq("dqElementId", mdModel.getDqElementId()));
            dq = (DqElementDateTime) criteria.uniqueResult();

            dq.setDateTime(mdModel.getDateTime());
            dq.setDqAbsExtPosAccId(mdModel.getDqAbsExtPosAccId());
            dq.setDqAccTimeMeAsId(mdModel.getDqAccTimeMeAsId());
            dq.setDqCompCommId(mdModel.getDqCompCommId());
            dq.setDqCompOmId(mdModel.getDqCompOmId());
            dq.setDqConcConsisId(mdModel.getDqConcConsisId());
            dq.setDqDomConsisId(mdModel.getDqDomConsisId());
            dq.setDqFormConsisId(mdModel.getDqFormConsisId());
            dq.setDqGridDataPosAccId(mdModel.getDqGridDataPosAccId());
            dq.setDqNonQuanAttaccId(mdModel.getDqNonQuanAttaccId());
            dq.setDqQuanAttaccId(mdModel.getDqQuanAttaccId());
            dq.setDqRellNtPosAccId(mdModel.getDqRellNtPosAccId());
            dq.setDqTempConsisId(mdModel.getDqTempConsisId());
            dq.setDqTempValidId(mdModel.getDqTempValidId());
            dq.setDqThemClassCorId(dq.getDqThemClassCorId());
            dq.setDqTopConsisId(mdModel.getDqTopConsisId());

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