/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdMedium;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdMediumModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMediumController {

    public MdMediumController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMediumController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdMediumId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMedium.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdMedium) results.get(0)).getId();
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

    public MdMedium getDataById(BigDecimal Id) {

        MdMedium mdMedium = new MdMedium();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMedium.class);
            criteria.add(Restrictions.eq("mdDigitalTransferOptionsId", Id));
            mdMedium = (MdMedium) criteria.uniqueResult();

            if (mdMedium == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdMedium;
    }
    
    public String deletedMdMedium(BigDecimal Id) {

        MdMedium mdMedium = new MdMedium();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMedium.class);
            criteria.add(Restrictions.eq("id", Id));
            mdMedium = (MdMedium) criteria.uniqueResult();

            session.delete(mdMedium);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdMedium(MdMediumModel mdModel) {
        MdMedium MdMedium = new MdMedium();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMedium.setId(mdModel.getId());
            MdMedium.setDensityUnits(mdModel.getDensityUnits());
            MdMedium.setMediumNote(mdModel.getMediumNote());
            MdMedium.setVolumes(mdModel.getVolumes());
            MdMedium.setMdDigitalTransferOptionsId(mdModel.getMdDigitalTransferOptionsId());
            MdMedium.setName(mdModel.getName());

            session.save(MdMedium);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdMedium(BigDecimal id,MdMediumModel mdModel) {

        MdMedium mdMedium = new MdMedium();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMedium.class);
            criteria.add(Restrictions.eq("id", id));
            mdMedium = (MdMedium) criteria.uniqueResult();

            // mdMedium.setId(mdModel.getId());
            mdMedium.setDensityUnits(mdModel.getDensityUnits());
            mdMedium.setMediumNote(mdModel.getMediumNote());
            mdMedium.setVolumes(mdModel.getVolumes());
            mdMedium.setMdDigitalTransferOptionsId(mdModel.getMdDigitalTransferOptionsId());
            mdMedium.setName(mdModel.getName());

            session.update(mdMedium);
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