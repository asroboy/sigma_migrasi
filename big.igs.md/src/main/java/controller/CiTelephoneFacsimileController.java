/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiTelephoneFacsimile;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiTelephoneFacsimileModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class CiTelephoneFacsimileController {

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiTelephoneFacsimileController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public CiTelephoneFacsimileController() {

    }

    public BigDecimal getMaxCiTelephoneFaxId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneFacsimile.class);
            criteria.addOrder(Order.desc("ciTelephoneId"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiTelephoneFacsimile) results.get(0)).getCiTelephoneId();
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

    public String saveCiTelephoneFacsimile(CiTelephoneFacsimileModel mdModel) {

        CiTelephoneFacsimile ciTelephoneFacsimile = new CiTelephoneFacsimile();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ciTelephoneFacsimile.setCiTelephoneId(mdModel.getCiTelephoneId());
            ciTelephoneFacsimile.setFacsimile(mdModel.getFacsimile());

            session.save(ciTelephoneFacsimile);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public CiTelephoneFacsimile getDataById(BigDecimal Id) {

        CiTelephoneFacsimile ciTelephoneFacsimile = new CiTelephoneFacsimile();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneFacsimile.class);
            criteria.add(Restrictions.eq("ciTelephoneId", Id));
            ciTelephoneFacsimile = (CiTelephoneFacsimile) criteria.uniqueResult();

            if (ciTelephoneFacsimile == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciTelephoneFacsimile;
    }

    public String updateCiTelephoneFacsimile(CiTelephoneFacsimileModel mdModel) {

        CiTelephoneFacsimile ciTelephoneFacsimile = new CiTelephoneFacsimile();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneFacsimile.class);
            criteria.add(Restrictions.eq("ciTelephoneId", mdModel.getCiTelephoneId()));
            ciTelephoneFacsimile = (CiTelephoneFacsimile) criteria.uniqueResult();

            ciTelephoneFacsimile.setFacsimile(mdModel.getFacsimile());

            session.update(ciTelephoneFacsimile);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deleteCiTelephoneFacsimile(BigDecimal Id) {

        CiTelephoneFacsimile ciTelephoneFacsimile = new CiTelephoneFacsimile();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneFacsimile.class);
            criteria.add(Restrictions.eq("ciTelephoneId", Id));
            ciTelephoneFacsimile = (CiTelephoneFacsimile) criteria.uniqueResult();

            session.delete(ciTelephoneFacsimile);
            trx.commit();
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
}