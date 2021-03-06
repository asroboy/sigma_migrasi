/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdDistributor;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdDistributorModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdDistributorController {

    public MdDistributorController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdDistributorController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdDistributorId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDistributor.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdDistributor) results.get(0)).getId();
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

    public String saveMdDistributor(MdDistributorModel mdModel) {
        MdDistributor MdDistributor = new MdDistributor();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdDistributor.setId(mdModel.getId());
            MdDistributor.setMdDistributionId(mdModel.getMdDistributionId());
            MdDistributor.setMdFormatId(mdModel.getMdFormatId());

            session.save(MdDistributor);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdDistributor getDataById(String column,BigDecimal Id) {

        MdDistributor mdDistributor = new MdDistributor();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDistributor.class);
            criteria.add(Restrictions.eq(column, Id));
            mdDistributor = (MdDistributor) criteria.uniqueResult();

            if (mdDistributor == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdDistributor;
    }
    
    public String deletedMdDistributor(BigDecimal Id) {

        MdDistributor mdDistributor = new MdDistributor();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDistributor.class);
            criteria.add(Restrictions.eq("id", Id));
            mdDistributor = (MdDistributor) criteria.uniqueResult();

            session.delete(mdDistributor);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdDistributor(BigDecimal id,MdDistributorModel mdModel) {

        MdDistributor mdDistributor = new MdDistributor();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDistributor.class);
            criteria.add(Restrictions.eq("id", id));
            mdDistributor = (MdDistributor) criteria.uniqueResult();

            mdDistributor.setMdDistributionId(mdModel.getMdDistributionId());
            mdDistributor.setMdFormatId(mdModel.getMdFormatId());

            session.update(mdDistributor);
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
