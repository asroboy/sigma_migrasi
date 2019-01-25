/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.ExGeographicExtent;
import domain.ExTemporalExtent;
import java.math.BigDecimal;
import java.util.List;
import model.table.ExTemporalExtentModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class ExTemporalExtentController {
    
    private HibernateUtilXml hibernateUtilXml;
    private Session session;
    
    public ExTemporalExtentController() {}
   
    public ExTemporalExtentController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxExTemporalExtentId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExTemporalExtent.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((ExTemporalExtent) results.get(0)).getId();
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

    public ExTemporalExtent getDataById(BigDecimal Id) {

       ExTemporalExtent exTemporalExtent = new ExTemporalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExTemporalExtent.class);
            criteria.add(Restrictions.eq("exExtentId", Id));
            exTemporalExtent = (ExTemporalExtent) criteria.uniqueResult();

            if (exTemporalExtent == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return exTemporalExtent;
    }
    
    public String saveExTemporalExtent(ExTemporalExtentModel extentModel) {

        ExTemporalExtent exTemporalExtent = new ExTemporalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            exTemporalExtent.setId(extentModel.getId());
            exTemporalExtent.setExtendsType(extentModel.getExtendsType());
            exTemporalExtent.setExExtentId(extentModel.getExExtendId());

            //System.out.println(md);
            session.save(exTemporalExtent);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateExTemporalExtent(BigDecimal id,ExTemporalExtentModel mdModel) {

        ExTemporalExtent exTemporalExtent = new ExTemporalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExTemporalExtent.class);
            criteria.add(Restrictions.eq("id", id));
            exTemporalExtent = (ExTemporalExtent) criteria.uniqueResult();

            exTemporalExtent.setExtendsType(mdModel.getExtendsType());
            exTemporalExtent.setExExtentId(mdModel.getExExtendId());
          
            session.update(exTemporalExtent);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deletedExTemporalExtent(BigDecimal Id) {

        ExTemporalExtent ete = new ExTemporalExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExTemporalExtent.class);
            criteria.add(Restrictions.eq("id", Id));
            ete = (ExTemporalExtent) criteria.uniqueResult();

            session.delete(ete);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {

        }
    }

}
