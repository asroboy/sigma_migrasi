/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiTelephone;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiTelephoneModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class CiTelephoneController {

    public CiTelephoneController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiTelephoneController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxTelephoneId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephone.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiTelephone) results.get(0)).getId();
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

    public CiTelephone getDataById(BigDecimal Id) {

        CiTelephone ciTelephone = new CiTelephone();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephone.class);
            criteria.add(Restrictions.eq(CiTelephoneModel.CI_CONTACTID, Id));
            ciTelephone = (CiTelephone) criteria.uniqueResult();

            if (ciTelephone == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciTelephone;
    }

    public String saveCiTelephone(CiTelephoneModel mdModel) {

        CiTelephone ciTelephone = new CiTelephone();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ciTelephone.setId(mdModel.getId());
            ciTelephone.setCiContactId(mdModel.getCiContactId());

            session.save(ciTelephone);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateCiTelephone(BigDecimal id,CiTelephoneModel mdModel) {

        CiTelephone ciTelephone = new CiTelephone();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephone.class);
            criteria.add(Restrictions.eq("id", id));
            ciTelephone = (CiTelephone) criteria.uniqueResult();
            
            ciTelephone.setCiContactId(mdModel.getCiContactId());

            session.update(ciTelephone);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deleteCiTelephone(BigDecimal Id) {

        CiTelephone ciTelephone = new CiTelephone();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiTelephone.class);
            criteria.add(Restrictions.eq("id", Id));
            ciTelephone = (CiTelephone) criteria.uniqueResult();

            session.delete(ciTelephone);
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
