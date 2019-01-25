/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.ExExtent;
import java.math.BigDecimal;
import java.util.List;
import model.table.ExExtentModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class ExExtentController {

    public ExExtentController() {

    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public ExExtentController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxExExtentId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExExtent.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((ExExtent) results.get(0)).getId();
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

    public ExExtent getDataById(String column,BigDecimal Id) {

        ExExtent exExtent = new ExExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExExtent.class);
            criteria.add(Restrictions.eq(column, Id));
            exExtent = (ExExtent) criteria.uniqueResult();

            if (exExtent == null) {
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

        return exExtent;
    }
    
    public String deletedExExtent(BigDecimal Id) {

        ExExtent exExtent = new ExExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExExtent.class);
            criteria.add(Restrictions.eq("id", Id));
            exExtent = (ExExtent) criteria.uniqueResult();

            session.delete(exExtent);
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

    public String saveExExtent(ExExtentModel mdAggregateInfoModel) {

        ExExtent exExtent = new ExExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            exExtent.setId(mdAggregateInfoModel.getId());
            exExtent.setDqScopeId(mdAggregateInfoModel.getDqScopeId());
            exExtent.setLiSourceId(mdAggregateInfoModel.getLiSourceId());
            exExtent.setMdDataIdentificationId(mdAggregateInfoModel.getMdDataIdentificationId());
            exExtent.setSvServiceIdentificationId(mdAggregateInfoModel.getSvServiceIdentificationId());
            exExtent.setDescription(mdAggregateInfoModel.getDescription());

            //System.out.println(md);
            session.save(exExtent);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateExExtent(BigDecimal id,ExExtentModel mdModel) {

        ExExtent exExtent = new ExExtent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExExtent.class);
            criteria.add(Restrictions.eq("id", id));
            exExtent = (ExExtent) criteria.uniqueResult();

            exExtent.setDqScopeId(mdModel.getDqScopeId());
            exExtent.setLiSourceId(mdModel.getLiSourceId());
            exExtent.setMdDataIdentificationId(mdModel.getMdDataIdentificationId());
            exExtent.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());
            exExtent.setDescription(mdModel.getDescription());

            session.update(exExtent);
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
