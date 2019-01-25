/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiAddress;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiAddressModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class CiAddressController {

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiAddressController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public CiAddressController() {

    }

    public BigDecimal getMaxCiAddressId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddress.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiAddress) results.get(0)).getId();
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

    public CiAddress getDataById(BigDecimal id) {
        CiAddress ciAddress = new CiAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddress.class);
            criteria.add(Restrictions.eq("ci_contactid", id));
            ciAddress = (CiAddress) criteria.uniqueResult();

            if (ciAddress == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciAddress;
    }

    public CiAddress getDataByProperty(BigDecimal id, String administrativeArea, String city, String country, String PostalCode) {
        CiAddress ciAddress = new CiAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddress.class);
            criteria.add(Restrictions.eq("ci_contactid", id))
                    .add(Restrictions.eqOrIsNull("administrativearea", administrativeArea))
                    .add(Restrictions.eqOrIsNull("city", city))
                    .add(Restrictions.eqOrIsNull("country", country))
                    .add(Restrictions.eqOrIsNull("postalcode", PostalCode));
            ciAddress = (CiAddress) criteria.uniqueResult();

            if (ciAddress == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciAddress;
    }

    public String saveCiAddress(CiAddressModel mdModel) {
        CiAddress ci = new CiAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ci.setId(mdModel.getId());
            ci.setAdministrativearea(mdModel.getAdmnistrativeArea());
            ci.setCity(mdModel.getCity());
            ci.setCountry(mdModel.getCountry());
            ci.setPostalcode(mdModel.getPostalCode());
            ci.setCi_contactid(mdModel.getCiContactId());

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

    public String updateCiAddress(BigDecimal id,CiAddressModel mdModel) {
        CiAddress ci = new CiAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddress.class);
            criteria.add(Restrictions.eq("id",id));
            ci = (CiAddress) criteria.uniqueResult();

            //ci.setId(ci.getId());
            ci.setAdministrativearea(mdModel.getAdmnistrativeArea());
            ci.setCity(mdModel.getCity());
            ci.setCountry(mdModel.getCountry());
            ci.setPostalcode(mdModel.getPostalCode());
            ci.setCi_contactid(mdModel.getCiContactId());

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
    
    public String deletedCiAddress(BigDecimal id) {
        CiAddress ciAddress = new CiAddress();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiAddress.class);
            criteria.add(Restrictions.eq("id", id));
            ciAddress = (CiAddress) criteria.uniqueResult();

            session.delete(ciAddress);
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
