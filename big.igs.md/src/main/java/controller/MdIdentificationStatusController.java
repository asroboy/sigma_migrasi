/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdIdentificationStatus;
import java.math.BigDecimal;
import model.table.MdIdentificationStatusModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdIdentificationStatusController {

    public MdIdentificationStatusController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdIdentificationStatusController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public String saveMdIdentificationStatus(MdIdentificationStatusModel mdModel) {
        MdIdentificationStatus mdIdentificationStatus = new MdIdentificationStatus();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdIdentificationStatus.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdIdentificationStatus.setStatus(mdModel.getStatus());

            session.save(mdIdentificationStatus);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdIdentificationStatus getDataById(BigDecimal Id,String code) {

        MdIdentificationStatus mdIdentificationStatus = new MdIdentificationStatus();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentificationStatus.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id))
                    .add(Restrictions.eqOrIsNull("status", code));
            
            mdIdentificationStatus = (MdIdentificationStatus) criteria.uniqueResult();

            if (mdIdentificationStatus == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdIdentificationStatus;
    }
    
    public String deletedMdIdentificationStatus(BigDecimal Id) {

        MdIdentificationStatus mdIdentificationStatus = new MdIdentificationStatus();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentificationStatus.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id));
            mdIdentificationStatus = (MdIdentificationStatus) criteria.uniqueResult();

            session.delete(mdIdentificationStatus);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdIdentificationStatus(BigDecimal id,MdIdentificationStatusModel mdModel) {

        MdIdentificationStatus mdIdentificationStatus = new MdIdentificationStatus();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentificationStatus.class);
            criteria.add(Restrictions.eq("mdIdentificationId", id));
            mdIdentificationStatus = (MdIdentificationStatus) criteria.uniqueResult();

            mdIdentificationStatus.setStatus(mdModel.getStatus());

            session.update(mdIdentificationStatus);
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