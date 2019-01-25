/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiAddressEmailAddress;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiAddressEmailAddressModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class CiAddressEmailAddressController {

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiAddressEmailAddressController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public CiAddressEmailAddressController() {

    }

    public long getMaxId() {
        long x = 999;
        long maxId = 1;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddressEmailAddress.class);
            criteria.add(Restrictions.ne("ci_addressid", new BigDecimal(x)));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = 1;
            } else {
                maxId = results.size() + 1;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return maxId;
    }

    public CiAddressEmailAddress getDataById(BigDecimal Id) {

        CiAddressEmailAddress ciAddressEmailAddress = new CiAddressEmailAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddressEmailAddress.class);
            criteria.add(Restrictions.eq("ci_addressid", Id));
            ciAddressEmailAddress = (CiAddressEmailAddress) criteria.uniqueResult();

            if (ciAddressEmailAddress == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciAddressEmailAddress;
    }

    public String saveCiAddressEmailAddress(CiAddressEmailAddressModel mdModel) {
        CiAddressEmailAddress ci = new CiAddressEmailAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ci.setCi_addressid(mdModel.getCi_addressid());
            ci.setEmailAddress(mdModel.getEmailAddress());

            session.save(ci);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            System.out.println("Session close");
            
            //session.close();
        }
    }

    public String updateCiAddressEmailAddress(CiAddressEmailAddressModel mdModel) {
        CiAddressEmailAddress ci = new CiAddressEmailAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddressEmailAddress.class);
            criteria.add(Restrictions.eq("ci_addressid", mdModel.getCi_addressid()));
            ci = (CiAddressEmailAddress) criteria.uniqueResult();
            
            ci.setEmailAddress(mdModel.getEmailAddress());

            session.update(ci);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            System.out.println("Session close");
            //session.close();
        }
    }
    
    public String deletedCiAddressEmailAddress(BigDecimal Id) {

        CiAddressEmailAddress ciAddressEmailAddress = new CiAddressEmailAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddressEmailAddress.class);
            criteria.add(Restrictions.eq("ci_addressid", Id));
            ciAddressEmailAddress = (CiAddressEmailAddress) criteria.uniqueResult();

            session.delete(ciAddressEmailAddress);
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
