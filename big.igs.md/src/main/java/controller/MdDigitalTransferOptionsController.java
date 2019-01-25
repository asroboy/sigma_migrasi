/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdDigitalTransferOptions;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdDigitalTransferOptionsModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdDigitalTransferOptionsController {

    public MdDigitalTransferOptionsController() {

    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdDigitalTransferOptionsController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdDigitalTransferOptionsId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDigitalTransferOptions.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdDigitalTransferOptions) results.get(0)).getId();
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

    public MdDigitalTransferOptions getDataById(String column,BigDecimal Id) {

        MdDigitalTransferOptions mdDigitalTransferOptions = new MdDigitalTransferOptions();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDigitalTransferOptions.class);
            criteria.add(Restrictions.eq(column, Id));
            mdDigitalTransferOptions = (MdDigitalTransferOptions) criteria.uniqueResult();

            if (mdDigitalTransferOptions == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdDigitalTransferOptions;
    }
    
    public String deletedMdDigitalTransferOptions(BigDecimal Id) {

        MdDigitalTransferOptions mdDigitalTransferOptions = new MdDigitalTransferOptions();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDigitalTransferOptions.class);
            criteria.add(Restrictions.eq("id", Id));
            mdDigitalTransferOptions = (MdDigitalTransferOptions) criteria.uniqueResult();

            session.delete(mdDigitalTransferOptions);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdDigitalTransferOptions(MdDigitalTransferOptionsModel mdModel) {

        MdDigitalTransferOptions mdDigitalTransferOptions = new MdDigitalTransferOptions();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdDigitalTransferOptions.setId(mdModel.getId());
            mdDigitalTransferOptions.setMdDistributionId(mdModel.getMdDistributionId());
            mdDigitalTransferOptions.setMdDistributorId(mdModel.getMdDistributorId());
            mdDigitalTransferOptions.setTransferSize(mdModel.getTransferSize());
            mdDigitalTransferOptions.setUnitsOfDistribution(mdModel.getUnitsOfDistribution());

            session.save(mdDigitalTransferOptions);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdDigitalTransferOptions(BigDecimal id,MdDigitalTransferOptionsModel mdModel) {
        MdDigitalTransferOptions mdDigitalTransferOptions = new MdDigitalTransferOptions();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDigitalTransferOptions.class);
            criteria.add(Restrictions.eq("id",id));
            mdDigitalTransferOptions = (MdDigitalTransferOptions) criteria.uniqueResult();

            mdDigitalTransferOptions.setUnitsOfDistribution(mdModel.getUnitsOfDistribution());
            mdDigitalTransferOptions.setTransferSize(mdModel.getTransferSize());
            mdDigitalTransferOptions.setMdDistributionId(mdModel.getMdDistributionId());
            mdDigitalTransferOptions.setMdDistributorId(mdModel.getMdDistributorId());

            session.update(mdDigitalTransferOptions);
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
