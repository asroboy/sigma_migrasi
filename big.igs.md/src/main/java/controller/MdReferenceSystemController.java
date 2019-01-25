/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdReferenceSystem;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdReferenceSystemModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdReferenceSystemController {

    public MdReferenceSystemController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdReferenceSystemController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxReferenceSystemId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdReferenceSystem.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdReferenceSystem) results.get(0)).getId();
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

    public MdReferenceSystem getDataById(String column,BigDecimal Id) {

        MdReferenceSystem mdReferenceSystem = new MdReferenceSystem();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdReferenceSystem.class);
            criteria.add(Restrictions.eq(column, Id));
            mdReferenceSystem = (MdReferenceSystem) criteria.uniqueResult();

            if (mdReferenceSystem == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdReferenceSystem;
    }
    
    public String deletedMdReferenceSystem(BigDecimal Id) {

        MdReferenceSystem mdReferenceSystem = new MdReferenceSystem();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdReferenceSystem.class);
            criteria.add(Restrictions.eq("id", Id));
            mdReferenceSystem = (MdReferenceSystem) criteria.uniqueResult();

            session.delete(mdReferenceSystem);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deletedMdReferenceSystemByLiSourceId(BigDecimal Id) {

        MdReferenceSystem mdReferenceSystem = new MdReferenceSystem();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdReferenceSystem.class);
            criteria.add(Restrictions.eq("liSourceId", Id));
            mdReferenceSystem = (MdReferenceSystem) criteria.uniqueResult();

            session.delete(mdReferenceSystem);
            trx.commit();
            
            return "deleted successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdReferenceSystem(MdReferenceSystemModel mdModel) {
        MdReferenceSystem MdReferenceSystem = new MdReferenceSystem();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdReferenceSystem.setId(mdModel.getId());
            MdReferenceSystem.setMdMetadataId(mdModel.getMdMetadataId());
            MdReferenceSystem.setLiSourceId(mdModel.getLiSourceId());

            session.save(MdReferenceSystem);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdReferenceSystem(BigDecimal id,MdReferenceSystemModel mdModel) {

        MdReferenceSystem mdReferenceSystem = new MdReferenceSystem();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdReferenceSystem.class);
            criteria.add(Restrictions.eq("id",id));
            mdReferenceSystem = (MdReferenceSystem) criteria.uniqueResult();

            mdReferenceSystem.setLiSourceId(mdModel.getLiSourceId());
            mdReferenceSystem.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdReferenceSystem);
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
