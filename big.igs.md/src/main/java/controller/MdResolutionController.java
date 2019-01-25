/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdResolution;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdResolutionModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdResolutionController {

    public MdResolutionController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdResolutionController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdResolutionId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdResolution.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdResolution) results.get(0)).getId();
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

    public MdResolution getDataById(BigDecimal Id) {

        MdResolution mdResolution = new MdResolution();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdResolution.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            mdResolution = (MdResolution) criteria.uniqueResult();

            if (mdResolution == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdResolution;
    }
    
    public String deletedMdResolution(BigDecimal Id) {

        MdResolution mdResolution = new MdResolution();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdResolution.class);
            criteria.add(Restrictions.eq("id", Id));
            mdResolution = (MdResolution) criteria.uniqueResult();

            session.delete(mdResolution);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdResolution(MdResolutionModel mdModel) {
        MdResolution MdResolution = new MdResolution();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdResolution.setId(mdModel.getId());
            MdResolution.setDistance(mdModel.getDistance());
            MdResolution.setMdDataIdentificationId(mdModel.getMdDataIdentificationId());
            MdResolution.setEquivalentScale(mdModel.getEquivalentScale());

            session.save(MdResolution);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdResolution(BigDecimal id,MdResolutionModel mdModel) {

        MdResolution mdResolution = new MdResolution();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdResolution.class);
            criteria.add(Restrictions.eq("id",id));
            mdResolution = (MdResolution) criteria.uniqueResult();

            mdResolution.setDistance(mdModel.getDistance());
            mdResolution.setEquivalentScale(mdModel.getEquivalentScale());
            mdResolution.setMdDataIdentificationId(mdModel.getMdDataIdentificationId());

            session.update(mdResolution);
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
