/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.ExGeographicExtent;
import java.math.BigDecimal;
import java.util.List;
import model.table.ExGeographicExtentModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class ExGeographicExtentController {

    public ExGeographicExtentController() {

    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public ExGeographicExtentController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxExGeographicExtentId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExGeographicExtent.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((ExGeographicExtent) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();

        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        }
        //session.close();
        System.out.println("session close");

        return maxId;
    }

    public ExGeographicExtent getDataById(String column,BigDecimal Id) {

        ExGeographicExtent exGeographicExtent = new ExGeographicExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExGeographicExtent.class);
            criteria.add(Restrictions.eq(column, Id));
            exGeographicExtent = (ExGeographicExtent) criteria.uniqueResult();

            if (exGeographicExtent == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
            System.out.println("session close");
        }

        return exGeographicExtent;
    }

    public String deletedExGeographicExtent(BigDecimal Id) {

        ExGeographicExtent exGeographicExtent = new ExGeographicExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExGeographicExtent.class);
            criteria.add(Restrictions.eq("id", Id));
            exGeographicExtent = (ExGeographicExtent) criteria.uniqueResult();

            session.delete(exGeographicExtent);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
            System.out.println("session close");
        }
    }

    public String saveExGeographicExtent(ExGeographicExtentModel mdModel) {

        ExGeographicExtent exGeographicExtent = new ExGeographicExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            exGeographicExtent.setId(mdModel.getId());
            exGeographicExtent.setExExtentId(mdModel.getExExtentId());
            exGeographicExtent.setExSpatialTemporalExtentId(mdModel.getExSpatialTemporalExtentId());
            exGeographicExtent.setExtendsType(mdModel.getExtendsType());
            exGeographicExtent.setExtentTypeCode(mdModel.getExtentTypeCode());
            exGeographicExtent.setMeasureDescription(mdModel.getMeasureDescription());

            //System.out.println(md);
            session.save(exGeographicExtent);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
            System.out.println("session close");
            
        }
    }

    public String updateExGeographicExtent(BigDecimal id,ExGeographicExtentModel mdModel) {

        ExGeographicExtent exGeographicExtent = new ExGeographicExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExGeographicExtent.class);
            criteria.add(Restrictions.eq("id", id));
            exGeographicExtent = (ExGeographicExtent) criteria.uniqueResult();

            exGeographicExtent.setExExtentId(mdModel.getExExtentId());
            exGeographicExtent.setExSpatialTemporalExtentId(mdModel.getExSpatialTemporalExtentId());
            exGeographicExtent.setExtendsType(mdModel.getExtendsType());
            exGeographicExtent.setExtentTypeCode(mdModel.getExtentTypeCode());
            exGeographicExtent.setMeasureDescription(mdModel.getMeasureDescription());

            session.update(exGeographicExtent);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
            //System.out.println("session close");
        }
    }

}
