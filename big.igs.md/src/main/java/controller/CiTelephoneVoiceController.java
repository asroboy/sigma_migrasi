/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiTelephoneVoice;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiTelephoneVoiceModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class CiTelephoneVoiceController {

    public CiTelephoneVoiceController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiTelephoneVoiceController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxCiTelephoneVoiceId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneVoice.class);
            criteria.addOrder(Order.desc("ciTelephoneId"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiTelephoneVoice) results.get(0)).getCiTelephoneId();
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

    public String saveCiTelephoneVoice(CiTelephoneVoiceModel mdModel) {
        CiTelephoneVoice CiTelephoneVoice = new CiTelephoneVoice();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            CiTelephoneVoice.setCiTelephoneId(mdModel.getCiTelephoneId());
            CiTelephoneVoice.setVoice(mdModel.getVoice());

            session.save(CiTelephoneVoice);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public CiTelephoneVoice getDataById(BigDecimal Id) {

        CiTelephoneVoice ciTelephoneVoice = new CiTelephoneVoice();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneVoice.class);
            criteria.add(Restrictions.eq("ciTelephoneId", Id));
            ciTelephoneVoice = (CiTelephoneVoice) criteria.uniqueResult();

            if (ciTelephoneVoice == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciTelephoneVoice;
    }

    public String updateCiTelephoneVoice(CiTelephoneVoiceModel mdModel) {

        CiTelephoneVoice ciTelephoneVoice = new CiTelephoneVoice();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneVoice.class);
            criteria.add(Restrictions.eq("ciTelephoneId", mdModel.getCiTelephoneId()));
            ciTelephoneVoice = (CiTelephoneVoice) criteria.uniqueResult();

            ciTelephoneVoice.setVoice(mdModel.getVoice());

            session.update(ciTelephoneVoice);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
     public String deleteCiTelephoneVoice(BigDecimal Id) {

        CiTelephoneVoice ciTelephoneVoice = new CiTelephoneVoice();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephoneVoice.class);
            criteria.add(Restrictions.eq("ciTelephoneId", Id));
            ciTelephoneVoice = (CiTelephoneVoice) criteria.uniqueResult();

            session.delete(ciTelephoneVoice);
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
