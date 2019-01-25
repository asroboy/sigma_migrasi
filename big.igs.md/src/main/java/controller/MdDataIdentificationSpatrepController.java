/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdDataIdentificationSpatrep;
import java.math.BigDecimal;
import model.table.MdDataIdentificationSpatrepModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdDataIdentificationSpatrepController {

    public MdDataIdentificationSpatrepController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdDataIdentificationSpatrepController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public String saveMdDataIdentificationSpatrep(MdDataIdentificationSpatrepModel mdModel) {
        MdDataIdentificationSpatrep MdDataIdentificationSpatrep = new MdDataIdentificationSpatrep();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdDataIdentificationSpatrep.setMdDataIdentificationId(mdModel.getMdDataIdentificationId());
            MdDataIdentificationSpatrep.setSpatialRepresentationType(mdModel.getSpatialRepresentationType());

            session.save(MdDataIdentificationSpatrep);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdDataIdentificationSpatrep getDataById(BigDecimal Id) {

        MdDataIdentificationSpatrep spatrep = new MdDataIdentificationSpatrep();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationSpatrep.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            spatrep = (MdDataIdentificationSpatrep) criteria.uniqueResult();

            if (spatrep == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return spatrep;
    }
    
    public String deletedMdDataIdentificationSpatrep(BigDecimal Id) {

        MdDataIdentificationSpatrep spatrep = new MdDataIdentificationSpatrep();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationSpatrep.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            spatrep = (MdDataIdentificationSpatrep) criteria.uniqueResult();

            session.delete(spatrep);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdDataIdentificationSpatrep(BigDecimal id,MdDataIdentificationSpatrepModel mdModel) {

        MdDataIdentificationSpatrep mdDataIdentificationSpatrep = new MdDataIdentificationSpatrep();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationSpatrep.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", id));
            mdDataIdentificationSpatrep = (MdDataIdentificationSpatrep) criteria.uniqueResult();

            mdDataIdentificationSpatrep.setSpatialRepresentationType(mdModel.getSpatialRepresentationType());

            session.update(mdDataIdentificationSpatrep);
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
