/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqElement;
import domain.DqElementNameOfMeasure;
import java.math.BigDecimal;
import model.table.DqElementModel;
import model.table.DqElementNameOfMeasureModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqElementNameOfMeasureController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;
    private String truthName;
     
    private DqElementController dqElementController = new DqElementController();
    
    public DqElementNameOfMeasureController() {
    }
 
     
    public DqElementNameOfMeasureController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }

    public DqElementNameOfMeasure getDataById(BigDecimal id) {
        DqElementNameOfMeasure dq = new DqElementNameOfMeasure();
                
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqElementNameOfMeasure.class);
            criteria.add(Restrictions.eq("dqElementId", id));
            dq = (DqElementNameOfMeasure) criteria.uniqueResult();

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
    
    public String deletedDqElementNameOfMeasure(BigDecimal id) {
        DqElementNameOfMeasure dq = new DqElementNameOfMeasure();
                
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqElementNameOfMeasure.class);
            criteria.add(Restrictions.eq("dqElementId", id));
            dq = (DqElementNameOfMeasure) criteria.uniqueResult();

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
    
    public String saveDqElementNameOfMeasure(DqElementNameOfMeasureModel mdModel) {
       
        DqElementNameOfMeasure dq = new DqElementNameOfMeasure();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dq.setDqElementId(mdModel.getDqElementId());
            dq.setNameOfMeasure(mdModel.getNameOfMeasure());
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

    public String updateDqElementNameOfMeasure(DqElementNameOfMeasureModel mdModel) {
        
        DqElementNameOfMeasure dq = new DqElementNameOfMeasure();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqElementNameOfMeasure.class);
            criteria.add(Restrictions.eq("dqElementId", mdModel.getDqElementId()));
            dq = (DqElementNameOfMeasure) criteria.uniqueResult();

            dq.setNameOfMeasure(mdModel.getNameOfMeasure());
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
