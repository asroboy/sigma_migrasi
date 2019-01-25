/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdIdentification;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdIdentificationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdIdentificationController {

    public MdIdentificationController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdIdentificationController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdIdentificationId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentification.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdIdentification) results.get(0)).getId();
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

    public MdIdentification getDataById(BigDecimal Id) {

        MdIdentification mdIdentification = new MdIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentification.class);
            criteria.add(Restrictions.eq("mdMetadataId", Id));
            mdIdentification = (MdIdentification) criteria.uniqueResult();

            if (mdIdentification == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdIdentification;
    }
    
    public String deleteMdIdentification(BigDecimal Id) {

        MdIdentification mdIdentification = new MdIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentification.class);
            criteria.add(Restrictions.eq("id", Id));
            mdIdentification = (MdIdentification) criteria.uniqueResult();

            session.delete(mdIdentification);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdIdentification(MdIdentificationModel mdModel) {
        MdIdentification MdIdentification = new MdIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdIdentification.setId(mdModel.getId());
            MdIdentification.setMdMetadataId(mdModel.getMdMetadataId());
            MdIdentification.setExtendsType(mdModel.getExtendsType());
            MdIdentification.setAbstract_(mdModel.getAbstract_());
            MdIdentification.setPurpose(mdModel.getPurpose());

            session.save(MdIdentification);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdIdentification(BigDecimal id,MdIdentificationModel mdModel) {

        MdIdentification mdIdentification = new MdIdentification();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentification.class);
            criteria.add(Restrictions.eq("id", id));
            mdIdentification = (MdIdentification) criteria.uniqueResult();

            mdIdentification.setAbstract_(mdModel.getAbstract_());
            mdIdentification.setExtendsType(mdModel.getExtendsType());
            mdIdentification.setPurpose(mdModel.getPurpose());
            mdIdentification.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdIdentification);
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
