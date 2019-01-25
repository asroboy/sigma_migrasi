/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiCitationAlternateTitle;
import java.math.BigDecimal;
import model.table.CiCitationAlternateTitleModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class CiCitationAlternateTitleController {

    public CiCitationAlternateTitleController() {

    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiCitationAlternateTitleController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public CiCitationAlternateTitle getDataById(BigDecimal Id) {

        CiCitationAlternateTitle ciCitationAlternateTitle = new CiCitationAlternateTitle();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiCitationAlternateTitle.class);
            criteria.add(Restrictions.eq("ci_citationid", Id));
            ciCitationAlternateTitle = (CiCitationAlternateTitle) criteria.uniqueResult();

            if (ciCitationAlternateTitle == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciCitationAlternateTitle;
    }
    
    public String deletedCiCitationAlternateTitle(BigDecimal Id) {

        CiCitationAlternateTitle ciCitationAlternateTitle = new CiCitationAlternateTitle();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiCitationAlternateTitle.class);
            criteria.add(Restrictions.eq("ci_citationid", Id));
            ciCitationAlternateTitle = (CiCitationAlternateTitle) criteria.uniqueResult();

            session.delete(ciCitationAlternateTitle);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveCiCitationAlternateTitle(CiCitationAlternateTitleModel mdModel) {
        CiCitationAlternateTitle ci = new CiCitationAlternateTitle();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ci.setCi_citationid(mdModel.getCi_citationid());
            ci.setAlternateTitle(mdModel.getAlternateTitle());

            session.save(ci);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateCiCitationAlternateTitle(BigDecimal id,CiCitationAlternateTitleModel mdModel) {
        CiCitationAlternateTitle ci = new CiCitationAlternateTitle();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiCitationAlternateTitle.class);
            criteria.add(Restrictions.eq("ci_citationid", id));
            ci = (CiCitationAlternateTitle) criteria.uniqueResult();

            ci.setAlternateTitle(mdModel.getAlternateTitle());

            session.update(ci);
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
