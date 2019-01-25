/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdIdentificationCredit;
import domain.MdIdentificationCredit;
import java.math.BigDecimal;
import model.table.MdIdentificationCreditModel;
import model.table.MdIdentificationCreditModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdIdentificationCreditController {

    HibernateUtilXml hibernateUtilXml;
    Session session;
    
    public MdIdentificationCreditController() {
    }
    
    public MdIdentificationCreditController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public String saveMdIdentificationCredit(MdIdentificationCreditModel mdModel) {
        MdIdentificationCredit md = new MdIdentificationCredit();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            md.setMdIdentificationId(mdModel.getMdIdentificationId());
            md.setCredit(mdModel.getCredit());

            session.save(md);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdIdentificationCredit getDataById(BigDecimal Id) {

        MdIdentificationCredit md = new MdIdentificationCredit();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentificationCredit.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id));
            
            md = (MdIdentificationCredit) criteria.uniqueResult();

            if (md == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return md;
    }
    
    public String deletedMdIdentificationCredit(BigDecimal Id) {

        MdIdentificationCredit md = new MdIdentificationCredit();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentificationCredit.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id));
            md = (MdIdentificationCredit) criteria.uniqueResult();

            session.delete(md);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdIdentificationCredit(BigDecimal id,MdIdentificationCreditModel mdModel) {

        MdIdentificationCredit md = new MdIdentificationCredit();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentificationCredit.class);
            criteria.add(Restrictions.eq("mdIdentificationId", id));
            md = (MdIdentificationCredit) criteria.uniqueResult();

            md.setCredit(mdModel.getCredit());

            session.update(md);
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
